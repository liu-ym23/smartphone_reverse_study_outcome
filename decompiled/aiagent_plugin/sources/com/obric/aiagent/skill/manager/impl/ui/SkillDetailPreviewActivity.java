package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.impl.SkillManager;
import com.obric.aiagent.skill.manager.impl.db;
import com.obric.aiagent.skill.manager.impl.di;
import com.obric.aiagent.skill.manager.impl.dr;
import com.obric.aiagent.skill.manager.impl.du;
import com.obric.aiagent.skill.manager.impl.dw;
import com.obric.aiagent.skill.manager.impl.dy;
import com.obric.aiagent.skill.manager.impl.dz;
import com.obric.aiagent.skill.manager.impl.ea;
import com.obric.aiagent.skill.manager.impl.eb;
import com.obric.aiagent.skill.manager.impl.en;
import com.obric.aiagent.skill.manager.impl.ft;
import com.obric.aiagent.skill.manager.impl.gn;
import com.obric.aiagent.skill.manager.impl.hd;
import com.obric.aiagent.skill.manager.impl.hi;
import com.obric.oui.actionbar.v2.OBottomActionBarNormalHorizontal;
import com.obric.oui.button.OProgressButton;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.header.HeaderInfoView;
import com.obric.oui.oswitch.OSwitch;
import com.obric.oui.popover.menu.OPopoverEntranceMenuView;
import com.obric.oui.popover.menu.PopoverMenuLinearLayout;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.cx;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillDetailPreviewActivity extends SkillGatedActivity {
    public static final a Companion = null;
    private static final float DETAIL_COVER_RADIUS_DP = 20.0f;
    private static final int DETAIL_SIGNING_MAX_CONSECUTIVE_NETWORK_FAILURES = 3;
    private static final long DETAIL_SIGNING_MAX_SESSION_MS = 300000;
    private static final long DETAIL_SIGNING_REFRESH_INTERVAL_MS = 10000;
    private static final long DETAIL_SIGNING_RETRY_INTERVAL_MS = 5000;
    private static final float DISABLED_CTA_ALPHA = 0.3f;
    private static final float DISABLED_MENU_ITEM_ALPHA = 0.3f;
    private static final int EDIT_MENU_ITEM_POSITION = 1;
    private static final String EXTRA_SHORT_DESCRIPTION = "short_description";
    private static final String EXTRA_SLUG = "slug";
    private static final int INSTALL_COMPLETE_PROGRESS = 100;
    private static final List<d.o.k> MARKDOWN_DESCRIPTION_PATTERNS = null;
    private static final long SECURITY_COMPLETED_FOOTER_DURATION_MS = 2000;
    private static final String SKILL_MD_FRONTMATTER_MARKER = "---";
    private static final int SKILL_MENU_SWITCH_CONTAINER_WIDTH_DP = 52;
    private static final int USE_SKILL_MENU_ITEM_POSITION = 0;
    private boolean bottomDividerRefreshPending;
    private boolean contentOverflowDividerEnabled;
    private final d.f coverStore$delegate;
    private String currentShopShortDescription;
    private com.obric.aiagent.skill.manager.api.e currentSkill;
    private boolean currentSkillInstalled;
    private String currentSlug;
    private String currentStoreDetailDescription;
    private List<String> currentUsageExamples;
    private OBottomActionBarNormalHorizontal detailBottomBar;
    private OProgressButton detailCta;
    private long detailLoadRequestId;
    private OPageStatus detailLoadingStatus;
    private OPopover detailMenuPopover;
    private View detailMore;
    private View detailPage;
    private boolean detailPageVisible;
    private ViewGroup detailScroll;
    private int detailSigningProgress;
    private ab detailSigningProgressSnapshot;
    private final ac detailSigningProgressStore;
    private boolean detailSigningRefreshAttempted;
    private final ad detailSigningRefreshGate;
    private kotlinx.coroutines.ca detailSigningRefreshJob;
    private b detailSigningRefreshSession;
    private OFloatingTitleBar detailTitleBar;
    private final d.f editCoverPickerCoordinator$delegate;
    private final d.f editFilePickerCoordinator$delegate;
    private az editFormSheetController;
    private final d.f enterPageTracker$delegate;
    private ViewGroup exampleList;
    private View exampleSectionTitle;
    private kotlinx.coroutines.ca installProgressJob;
    private final y installProgressRunner;
    private final kotlinx.coroutines.am ioScope;
    private final kotlinx.coroutines.am mainScope;
    private ViewTreeObserver.OnPreDrawListener pendingDescriptionAlignmentListener;
    private kotlinx.coroutines.ca refreshDetailJob;
    private kotlinx.coroutines.ca securityCompletedFooterDismissJob;
    private TextView securityFooterText;
    private boolean securityScanObservedWhileVisible;
    private final ft shopRepository;
    private TextView skillDescription;
    private SkillDescriptionMarkdownView skillDescriptionMarkdown;
    private HeaderInfoView skillHeader;
    private SimpleDraweeView skillIcon;
    private ISkillManagerService skillManager;
    private TextView skillRelatedInfo;
    private TextView skillSecurityInfo;
    private kotlinx.coroutines.ca stateObserveJob;
    private final hd trackingReporter;

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final Intent a(Context r3, String r4, String r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "context");
            d.h.b.o.e(r4, SkillDetailPreviewActivity.EXTRA_SLUG);
            d.h.b.o.e(r5, "shortDescription");
            return b(r6, r4, r5, null);
        }

        public static /* synthetic */ Intent a(a r1, Context r2, String r3, String r4, du r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if ((r6 & 4) == 0) goto L6;
            r4 = "";
        L6:
            return r1.a(r8, r3, r4, r5);
        }

        public final Intent a(Context r3, String r4, String r5, du r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r7, "context");
            d.h.b.o.e(r4, SkillDetailPreviewActivity.EXTRA_SLUG);
            d.h.b.o.e(r5, "shortDescription");
            d.h.b.o.e(r6, "trackingSource");
            return b(r7, r4, r5, r6);
        }

        private final Intent b(Context r3, String r4, String r5, du r6) {
            Intent r7 = new Intent((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), SkillDetailPreviewActivity.class);
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L9;
            r7.putExtra(SkillDetailPreviewActivity.EXTRA_SLUG, r4);
            r7.putExtra(SkillDetailPreviewActivity.EXTRA_SHORT_DESCRIPTION, r5);
            if (r6 == null) goto L7;
            bo.a(r7, r6);
        L7:
            return r7;
        L9:
            throw new IllegalArgumentException("Skill slug must not be blank.".toString());
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f20233b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ea f20234c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f20235d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f20236e;
        private int f;
        private boolean g;
        private com.obric.aiagent.skill.manager.api.am h;
        private c i;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20232a, r10.f20232a) == true) goto L12;
            return false;
        L12:
            if (this.f20233b == r10.f20233b) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f20234c, r10.f20234c) == true) goto L18;
            return false;
        L18:
            if (this.f20235d == r10.f20235d) goto L21;
            return false;
        L21:
            if (this.f20236e == r10.f20236e) goto L24;
            return false;
        L24:
            if (this.f == r10.f) goto L27;
            return false;
        L27:
            if (this.g == r10.g) goto L30;
            return false;
        L30:
            if (this.h == r10.h) goto L33;
            return false;
        L33:
            if (this.i == r10.i) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((((this.f20232a.hashCode() * 31) + Long.hashCode(this.f20233b)) * 31) + this.f20234c.hashCode()) * 31) + Integer.hashCode(this.f20235d)) * 31) + Integer.hashCode(this.f20236e)) * 31) + Integer.hashCode(this.f)) * 31) + Boolean.hashCode(this.g)) * 31;
            com.obric.aiagent.skill.manager.api.am r1 = this.h;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            c r5 = this.i;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "DetailSigningRefreshSession(key=" + this.f20232a + ", startedAtMs=" + this.f20233b + ", performanceScope=" + this.f20234c + ", consecutiveNetworkFailures=" + this.f20235d + ", networkFailureCount=" + this.f20236e + ", pollCount=" + this.f + ", submittedScan=" + this.g + ", lastAction=" + this.h + ", stoppedReason=" + this.i + ')';
        }

        public b(String r2, long r3, ea r5, int r6, int r7, int r8, boolean r9, com.obric.aiagent.skill.manager.api.am r10, c r11) {
            d.h.b.o.e(r2, "key");
            d.h.b.o.e(r5, "performanceScope");
            this.f20232a = r2;
            this.f20233b = r3;
            this.f20234c = r5;
            this.f20235d = r6;
            this.f20236e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r11;
        }

        public /* synthetic */ b(String r15, long r16, ea r18, int r19, int r20, int r21, boolean r22, com.obric.aiagent.skill.manager.api.am r23, c r24, int r25, d.h.b.h r26) {
            if ((r25 & 8) == 0) goto L5;
            int r8 = 0;
        L7:
            if ((r25 & 16) == 0) goto L9;
            int r9 = 0;
        L11:
            if ((r25 & 32) == 0) goto L13;
            int r10 = 0;
        L15:
            if ((r25 & 64) == 0) goto L17;
            boolean r11 = false;
        L19:
            if ((r25 & 128) == 0) goto L21;
            com.obric.aiagent.skill.manager.api.am r12 = null;
        L23:
            if ((r25 & 256) == 0) goto L25;
            c r13 = null;
        L26:
            this(r15, r16, r18, r8, r9, r10, r11, r12, r13);
            return;
        L25:
            r13 = r24;
            goto L26
        L21:
            r12 = r23;
            goto L23
        L17:
            r11 = r22;
            goto L19
        L13:
            r10 = r21;
            goto L15
        L9:
            r9 = r20;
            goto L11
        L5:
            r8 = r19;
            goto L7
        }

        public final String a() {
            return this.f20232a;
        }

        public final ea b() {
            return this.f20234c;
        }

        public final void a(int r1) {
            this.f20235d = r1;
        }

        public final int c() {
            return this.f20235d;
        }

        public final void b(int r1) {
            this.f20236e = r1;
        }

        public final int d() {
            return this.f20236e;
        }

        public final void c(int r1) {
            this.f = r1;
        }

        public final int e() {
            return this.f;
        }

        public final void a(boolean r1) {
            this.g = r1;
        }

        public final boolean f() {
            return this.g;
        }

        public final void a(com.obric.aiagent.skill.manager.api.am r1) {
            this.h = r1;
        }

        public final com.obric.aiagent.skill.manager.api.am g() {
            return this.h;
        }

        public final void a(c r1) {
            this.i = r1;
        }

        public final c h() {
            return this.i;
        }

        public final long i() {
            return d.l.n.a(SystemClock.elapsedRealtime() - this.f20233b, 0);
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f20237a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f20238b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f20239c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f20240d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f20241e = null;
        public static final c f = null;
        public static final c g = null;
        public static final c h = null;
        public static final c i = null;
        public static final c j = null;
        private static final /* synthetic */ c[] l = null;
        private static final /* synthetic */ d.d.a m = null;
        private final String k;

        private static final /* synthetic */ c[] b() {
            return new c[]{f20237a, f20238b, f20239c, f20240d, f20241e, f, g, h, i, j};
        }

        private c(String r1, int r2, String r3) {
            super(r1, r2);
            this.k = r3;
        }

        public final String a() {
            return this.k;
        }

        static {
            f20237a = new c("COMPLETED", 0, "completed");
            f20238b = new c("ERROR_TERMINAL", 1, "error_terminal");
            f20239c = new c("MANIFEST_UNRESOLVED", 2, "manifest_unresolved");
            f20240d = new c("NETWORK_RETRY_EXHAUSTED", 3, "network_retry_exhausted");
            f20241e = new c("POLL_TIMEOUT", 4, "poll_timeout");
            f = new c("PAGE_HIDDEN", 5, "page_hidden");
            g = new c("SKILL_REMOVED", 6, "skill_removed");
            h = new c("REPEAT_SUBMIT_BLOCKED", 7, "repeat_submit_blocked");
            i = new c("STOPPED_BY_CONFIG", 8, "stopped_by_config");
            j = new c("SUPERSEDED", 9, "superseded");
            c[] r0 = b();
            l = r0;
            m = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(l.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f20242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f20243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f20244c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f20242a, r6.f20242a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f20243b, r6.f20243b) == true) goto L15;
            return false;
        L15:
            if (d.h.b.o.a(this.f20244c, r6.f20244c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f20242a.hashCode() * 31) + this.f20243b.hashCode()) * 31) + this.f20244c.hashCode();
        }

        public String toString() {
            return "SkillEditDraft(displayName=" + this.f20242a + ", description=" + this.f20243b + ", body=" + this.f20244c + ')';
        }

        public d(String r2, String r3, String r4) {
            d.h.b.o.e(r2, "displayName");
            d.h.b.o.e(r3, "description");
            d.h.b.o.e(r4, "body");
            this.f20242a = r2;
            this.f20243b = r3;
            this.f20244c = r4;
        }

        public final String a() {
            return this.f20242a;
        }

        public final String b() {
            return this.f20243b;
        }

        public final String c() {
            return this.f20244c;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20245a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f20246b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f20247c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f20248d = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.manager.impl.ba.values().length];
            r0[com.obric.aiagent.skill.manager.impl.ba.f19541a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L73:
            r0[com.obric.aiagent.skill.manager.impl.ba.f19542b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L81:
            r0[com.obric.aiagent.skill.manager.impl.ba.f19543c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L51:
            r0[com.obric.aiagent.skill.manager.impl.ba.f19544d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L10:
            f20245a = r0;
            int[] r1 = new int[aa.values().length];
            r1[aa.f20483a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L75:
            r1[aa.f20484b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L13:
            f20246b = r1;
            int[] r2 = new int[c.values().length];
            r2[c.f20237a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L67:
            r2[c.i.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L77:
            r2[c.f20241e.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L47:
            r2[c.h.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L55:
            r2[c.f.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L71:
            r2[c.g.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L49:
            r2[c.j.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L61:
            r2[c.f20238b.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L63:
            r2[c.f20239c.ordinal()] = 9;     // Catch: NoSuchFieldError -> L43
        L79:
            r2[c.f20240d.ordinal()] = 10;     // Catch: NoSuchFieldError -> L44
        L24:
            f20247c = r2;
            int[] r3 = new int[com.obric.aiagent.skill.manager.impl.bb.values().length];
            r3[com.obric.aiagent.skill.manager.impl.bb.f19546a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L45
        L69:
            r3[com.obric.aiagent.skill.manager.impl.bb.f19547b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L46
        L27:
            f20248d = r3;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    /* synthetic */ class f extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.impl.ui.e, d.x> {
        f(Object r8) {
            super(1, r8, SkillDetailPreviewActivity.class, "openUsageExample", "openUsageExample(Lcom/obric/aiagent/skill/manager/impl/ui/FormattedUsageExample;)V", 0);
        }

        public final void a(com.obric.aiagent.skill.manager.impl.ui.e r3) {
            d.h.b.o.e(r3, "p0");
            SkillDetailPreviewActivity.access$openUsageExample((SkillDetailPreviewActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin"), r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.impl.ui.e r3) {
            a((com.obric.aiagent.skill.manager.impl.ui.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.impl.ui.e.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {1902}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$bindPassedSecurityFooter$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillDetailPreviewActivity f20250b;

        g(SkillDetailPreviewActivity r3, d.c.d<? super g> r4) {
            SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20250b = r5;
            super(2, r6);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f20250b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20249a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (en.b(SkillDetailPreviewActivity.currentSecurityState$default(this.f20250b, null, 1, null)) == false) goto L17;
            OBottomActionBarNormalHorizontal r7 = SkillDetailPreviewActivity.access$getDetailBottomBar$p(this.f20250b);
            if (r7 != null) goto L16;
            d.h.b.o.c("detailBottomBar");
            r7 = null;
        L16:
            r7.removeHeaderView();
        L17:
            SkillDetailPreviewActivity.access$setSecurityCompletedFooterDismissJob$p(this.f20250b, null);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r8 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20249a = 1;
            if (kotlinx.coroutines.ax.a(SkillDetailPreviewActivity.SECURITY_COMPLETED_FOOTER_DURATION_MS, r8) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    /* synthetic */ class h extends d.h.b.l implements d.h.a.a<d.x> {
        h(Object r8) {
            super(0, r8, SkillDetailPreviewActivity.class, "scheduleBottomDividerRefresh", "scheduleBottomDividerRefresh()V", 0);
        }

        public final void a() {
            SkillDetailPreviewActivity.access$scheduleBottomDividerRefresh((SkillDetailPreviewActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$deleteCurrentSkill$1")
    static final class i extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20251a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20252b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20253c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillDetailPreviewActivity f20254d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$i$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$deleteCurrentSkill$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20255a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20256b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f20257c;

            AnonymousClass1(SkillDetailPreviewActivity r3, String r4, d.c.d<? super AnonymousClass1> r5) {
                SkillDetailPreviewActivity r6 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20256b = r6;
                this.f20257c = r4;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20256b, this.f20257c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f20255a != 0) goto L7;
                d.o.a(r3);
                SkillDetailPreviewActivity.access$clearDetailSigningProgress(this.f20256b, this.f20257c);
                SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20256b, c.g, SkillDetailPreviewActivity.access$getCurrentSkill$p(this.f20256b));
                SkillDetailPreviewActivity.access$stopDetailSigningRefresh(this.f20256b);
                SkillDetailPreviewActivity.access$logDetailInfo(this.f20256b, "Detail delete skill completed", "Detail delete skill completed: slug=" + this.f20257c);
                this.f20256b.finish();
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        i(ISkillManagerService r3, String r4, SkillDetailPreviewActivity r5, d.c.d<? super i> r6) {
            ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            SkillDetailPreviewActivity r8 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r5, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20252b = r7;
            this.f20253c = r4;
            this.f20254d = r8;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((i) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), i.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new i(this.f20252b, this.f20253c, this.f20254d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f20251a != 0) goto L20;
            d.o.a(r9);
            com.obric.aiagent.skill.manager.api.u<d.x> r10 = this.f20252b.deleteSkill(this.f20253c);     // Catch: Exception -> L13 CancellationException -> L17
            if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L9;
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(this.f20254d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20254d, this.f20253c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L13 CancellationException -> L17
        L16:
            return d.x.f38692a;
        L9:
            if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L12;
            SkillDetailPreviewActivity.access$logDetailWarning(this.f20254d, "Detail delete skill failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Detail delete skill failed: slug=" + this.f20253c + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L13 CancellationException -> L17
            goto L16
        L12:
            throw new d.k();     // Catch: Exception -> L13 CancellationException -> L17
        L17:
            e = move-exception;
            throw e;
        L13:
            e = move-exception;
            SkillDetailPreviewActivity.access$logDetailFailure(this.f20254d, "Detail delete skill failed", "Detail delete skill failed: slug=" + this.f20253c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L16
        L20:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    /* synthetic */ class j extends d.h.b.l implements d.h.a.m<aj, at, d.x> {
        j(Object r8) {
            super(2, r8, SkillDetailPreviewActivity.class, "handleEditFileStateChanged", "handleEditFileStateChanged(Lcom/obric/aiagent/skill/manager/impl/ui/SkillFileTarget;Lcom/obric/aiagent/skill/manager/impl/ui/SkillFormFileState;)V", 0);
        }

        public final void a(aj r3, at r4) {
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            SkillDetailPreviewActivity.access$handleEditFileStateChanged((SkillDetailPreviewActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin"), r3, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(aj r3, at r4) {
            a((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.aiagent.plugin"), (at) ZeusTransformUtils.preCheckCast(r4, at.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    /* synthetic */ class k extends d.h.b.l implements d.h.a.m<aj, com.obric.aiagent.skill.manager.impl.cb, d.x> {
        k(Object r8) {
            super(2, r8, SkillDetailPreviewActivity.class, "handleEditFormFileReady", "handleEditFormFileReady(Lcom/obric/aiagent/skill/manager/impl/ui/SkillFileTarget;Lcom/obric/aiagent/skill/manager/impl/SkillFormDraft;)V", 0);
        }

        public final void a(aj r3, com.obric.aiagent.skill.manager.impl.cb r4) {
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            SkillDetailPreviewActivity.access$handleEditFormFileReady((SkillDetailPreviewActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin"), r3, r4);
        }

        @Override // d.h.a.m
        public /* synthetic */ d.x invoke(aj r3, com.obric.aiagent.skill.manager.impl.cb r4) {
            a((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.aiagent.plugin"), (com.obric.aiagent.skill.manager.impl.cb) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.impl.cb.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    /* synthetic */ class l extends d.h.b.l implements d.h.a.q<aj, String, Throwable, d.x> {
        l(Object r8) {
            super(3, r8, SkillDetailPreviewActivity.class, "handleEditFileFailure", "handleEditFileFailure(Lcom/obric/aiagent/skill/manager/impl/ui/SkillFileTarget;Ljava/lang/String;Ljava/lang/Throwable;)V", 0);
        }

        public final void a(aj r3, String r4, Throwable r5) {
            d.h.b.o.e(r3, "p0");
            d.h.b.o.e(r4, "p1");
            d.h.b.o.e(r5, "p2");
            SkillDetailPreviewActivity.access$handleEditFileFailure((SkillDetailPreviewActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin"), r3, r4, r5);
        }

        @Override // d.h.a.q
        public /* synthetic */ d.x invoke(aj r3, String r4, Throwable r5) {
            a((aj) ZeusTransformUtils.preCheckCast(r3, aj.class, "com.obric.aiagent.plugin"), (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$ensureSkillObserverStarted$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f20259b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillDetailPreviewActivity f20260c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f20261d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$m$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {1337}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$ensureSkillObserverStarted$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20262a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f20263b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20264c;

            AnonymousClass1(kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r3, SkillDetailPreviewActivity r4, d.c.d<? super AnonymousClass1> r5) {
                kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r6 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
                SkillDetailPreviewActivity r7 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20263b = r6;
                this.f20264c = r7;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20263b, this.f20264c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20262a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                d.o.a(r6);
            L12:
                throw new d.d();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r7 = this.f20263b;
                final SkillDetailPreviewActivity r3 = this.f20264c;
                kotlinx.coroutines.b.i<? super List<com.obric.aiagent.skill.manager.api.e>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new C04251(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20262a = 1;
                if (r7.collect(r2, r4) != r0) goto L12;
                return r0;
            }
        }

        m(kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r3, SkillDetailPreviewActivity r4, d.c.d<? super m> r5) {
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r6 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
            SkillDetailPreviewActivity r7 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20259b = r6;
            this.f20260c = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            m r0 = new m(this.f20259b, this.f20260c, r6);
            r0.f20261d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f20258a != 0) goto L7;
            d.o.a(r9);
            kotlinx.coroutines.i.a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f20261d, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20259b, this.f20260c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {1143}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$installCurrentSkill$1")
    static final class n extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillDetailPreviewActivity f20270b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20271c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20272d;

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {1145}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$installCurrentSkill$1$installResult$1")
        static final class a extends d.c.b.a.l implements d.h.a.b<d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.e>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20273a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ISkillManagerService f20274b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f20275c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20276d;

            /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$n$a$1, reason: invalid class name */
            /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
            @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$installCurrentSkill$1$installResult$1$1")
            static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.e>>, Object> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                int f20277a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ ISkillManagerService f20278b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                final /* synthetic */ String f20279c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                final /* synthetic */ SkillDetailPreviewActivity f20280d;

                AnonymousClass1(ISkillManagerService r3, String r4, SkillDetailPreviewActivity r5, d.c.d<? super AnonymousClass1> r6) {
                    ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
                    SkillDetailPreviewActivity r8 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r5, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                    d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                    this.f20278b = r7;
                    this.f20279c = r4;
                    this.f20280d = r8;
                    super(2, r9);
                }

                public final Object a(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r4) {
                    return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
                }

                @Override // d.c.b.a.a
                public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                    d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                    return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20278b, this.f20279c, this.f20280d, r6), d.c.d.class, "com.obric.aiagent.plugin");
                }

                @Override // d.h.a.m
                public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.e>> r4) {
                    return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
                }

                @Override // d.c.b.a.a
                public final Object invokeSuspend(Object r3) {
                    d.c.a.b.a();
                    if (this.f20277a != 0) goto L7;
                    d.o.a(r3);
                    return this.f20278b.installSkill(this.f20279c, SkillDetailPreviewActivity.access$getCurrentShopShortDescription$p(this.f20280d), com.obric.aiagent.skill.manager.api.au.f);
                L7:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            a(ISkillManagerService r3, String r4, SkillDetailPreviewActivity r5, d.c.d<? super a> r6) {
                ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
                SkillDetailPreviewActivity r8 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r5, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20274b = r7;
                this.f20275c = r4;
                this.f20276d = r8;
                super(1, r9);
            }

            public final Object a(d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e>> r3) {
                return ((a) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20274b, this.f20275c, this.f20276d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.b
            public /* synthetic */ Object invoke(d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.e>> r3) {
                return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20273a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r9);
            L11:
                return r9;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r9);
                d.c.g r10 = (d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
                d.h.a.m r2 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20274b, this.f20275c, this.f20276d, null), d.h.a.m.class, "com.obric.aiagent.plugin");
                d.c.d r3 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20273a = 1;
                r9 = kotlinx.coroutines.i.a(r10, r2, r3);
                if (r9 != r0) goto L11;
                return r0;
            }
        }

        n(SkillDetailPreviewActivity r3, String r4, ISkillManagerService r5, d.c.d<? super n> r6) {
            SkillDetailPreviewActivity r7 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            ISkillManagerService r8 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r5, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20270b = r7;
            this.f20271c = r4;
            this.f20272d = r8;
            super(2, r9);
        }

        public static /* synthetic */ d.x lambda$CxE5TOkWvcc5ZxOgTa4f3MbeNxw(SkillDetailPreviewActivity r0, int r1) {
            return a(r0, r1);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((n) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), n.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new n(this.f20270b, this.f20271c, this.f20272d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20269a;
            if (r1 == 0) goto L15;
            if (r1 != 1) goto L14;
            d.o.a(r9);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L19:
            com.obric.aiagent.skill.manager.api.u r10 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L27;
            com.obric.aiagent.skill.manager.api.e r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            cm r2 = cm.f20758a;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            Activity r3 = (Activity) ZeusTransformUtils.preCheckCast(this.f20270b, Activity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r11.l() == false) goto L24;
            cm.a r5 = cm.a.f20760a;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L25:
            r2.a(r3, r5);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            SkillDetailPreviewActivity.access$setCurrentSkill$p(this.f20270b, r11);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            SkillDetailPreviewActivity.access$setCurrentSkillInstalled$p(this.f20270b, true);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            SkillDetailPreviewActivity.access$renderDetail(this.f20270b, r11);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            SkillDetailPreviewActivity.access$ensureSkillObserverStarted(this.f20270b);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L47:
            SkillDetailPreviewActivity.access$setInstallProgressJob$p(this.f20270b, null);
            return d.x.f38692a;
        L24:
            r5 = cm.a.g;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            goto L25
        L27:
            if (ZeusTransformUtils.instanceOf(r10, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L39;
            SkillDetailPreviewActivity.access$logDetailWarning(this.f20270b, "install skill failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "install skill failed: slug=" + this.f20271c + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            com.obric.aiagent.skill.manager.api.e r4 = SkillDetailPreviewActivity.access$getCurrentSkill$p(this.f20270b);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r4 == null) goto L31;
            SkillDetailPreviewActivity.access$configureCta(this.f20270b, r4);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L32:
            cm.a r12 = cl.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r12 == null) goto L35;
            cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20270b, Activity.class, "com.obric.aiagent.plugin"), r12);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L35:
            d.x r13 = d.x.f38692a;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            SkillDetailPreviewActivity.access$setInstallProgressJob$p(this.f20270b, null);
            return r13;
        L31:
            SkillDetailPreviewActivity.access$configureAddCta(this.f20270b);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            goto L32
        L39:
            throw new d.k();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            d.o.a(r9);
            y r14 = SkillDetailPreviewActivity.access$getInstallProgressRunner$p(this.f20270b);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(this.f20272d, this.f20271c, this.f20270b, null), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            final SkillDetailPreviewActivity r7 = this.f20270b;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.h.a.b<? super Integer, d.x> r8 = new $$Lambda$SkillDetailPreviewActivity$n$CxE5TOkWvcc5ZxOgTa4f3MbeNxw(r7);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            this.f20269a = 1;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            r9 = r14.a(r6, r8, r15);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
            if (r9 != r0) goto L19;
            return r0;
        L7:
            th = move-exception;
            SkillDetailPreviewActivity.access$setInstallProgressJob$p(this.f20270b, null);
            throw th;
        L11:
            e = move-exception;
            throw e;     // Catch: Throwable -> L7
        L9:
            e = move-exception;
            cl.a("SkillManager", "install skill", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
            com.obric.aiagent.skill.manager.api.e r16 = SkillDetailPreviewActivity.access$getCurrentSkill$p(this.f20270b);     // Catch: Throwable -> L7
            if (r16 == null) goto L43;
            SkillDetailPreviewActivity.access$configureCta(this.f20270b, r16);     // Catch: Throwable -> L7
        L44:
            cm.a r17 = cl.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L7
            if (r17 == null) goto L47;
            cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20270b, Activity.class, "com.obric.aiagent.plugin"), r17);     // Catch: Throwable -> L7
            goto L47
        L43:
            SkillDetailPreviewActivity.access$configureAddCta(this.f20270b);     // Catch: Throwable -> L7
            goto L44
        }

        private static final d.x a(SkillDetailPreviewActivity r3, int r4) {
            SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            OProgressButton r0 = null;
            if (r4 != 100) goto L9;
            OProgressButton r6 = SkillDetailPreviewActivity.access$getDetailCta$p(r5);
            if (r6 != null) goto L7;
            d.h.b.o.c("detailCta");
        L8:
            r0.setProgress(r4);
        L15:
            return d.x.f38692a;
        L7:
            r0 = r6;
            goto L8
        L9:
            OProgressButton r7 = SkillDetailPreviewActivity.access$getDetailCta$p(r5);
            if (r7 != null) goto L12;
            d.h.b.o.c("detailCta");
        L13:
            r0.updateProgress(r4, true);
            goto L15
        L12:
            r0 = r7;
            goto L13
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    /* synthetic */ class o extends d.h.b.l implements d.h.a.b<ISkillManagerService, d.x> {
        o(Object r8) {
            super(1, r8, SkillDetailPreviewActivity.class, "initializeSkillPage", "initializeSkillPage(Lcom/obric/aiagent/skill/manager/api/ISkillManagerService;)V", 0);
        }

        public final void a(ISkillManagerService r3) {
            ISkillManagerService r4 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "p0");
            SkillDetailPreviewActivity.access$initializeSkillPage((SkillDetailPreviewActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(ISkillManagerService r3) {
            a((ISkillManagerService) ZeusTransformUtils.preCheckCast(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    /* synthetic */ class p extends d.h.b.l implements d.h.a.a<d.x> {
        p(Object r8) {
            super(0, r8, SkillDetailPreviewActivity.class, "finish", "finish()V", 0);
        }

        public final void a() {
            ((SkillDetailPreviewActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).finish();
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {825}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$refreshSkillDetail$1")
    static final class q extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f20281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f20282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillDetailPreviewActivity f20283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20284d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f20285e;
        final /* synthetic */ long f;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$q$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$refreshSkillDetail$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20286a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20287b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f20288c;

            AnonymousClass1(SkillDetailPreviewActivity r3, long r4, d.c.d<? super AnonymousClass1> r6) {
                SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20287b = r5;
                this.f20288c = r4;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r5, d.c.d<?> r6) {
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20287b, this.f20288c, r7), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                d.c.a.b.a();
                if (this.f20286a != 0) goto L10;
                d.o.a(r6);
                if (SkillDetailPreviewActivity.access$finishDetailLoadRequest(this.f20287b, this.f20288c) == false) goto L8;
                SkillDetailPreviewActivity r7 = this.f20287b;
                String r0 = r7.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_not_found, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_not_found"));
                d.h.b.o.c(r0, "getString(...)");
                String r5 = this.f20287b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_retry_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_retry_message"));
                d.h.b.o.c(r5, "getString(...)");
                SkillDetailPreviewActivity.access$renderError(r7, r0, r5);
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$q$2, reason: invalid class name */
        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$refreshSkillDetail$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20289a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20290b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f20291c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ae f20292d;

            AnonymousClass2(SkillDetailPreviewActivity r3, long r4, ae r6, d.c.d<? super AnonymousClass2> r7) {
                SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20290b = r5;
                this.f20291c = r4;
                this.f20292d = r6;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20290b, this.f20291c, this.f20292d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f20289a != 0) goto L12;
                d.o.a(r3);
                if (SkillDetailPreviewActivity.access$finishDetailLoadRequest(this.f20290b, this.f20291c) == false) goto L10;
                SkillDetailPreviewActivity.access$setCurrentSkill$p(this.f20290b, this.f20292d.a());
                SkillDetailPreviewActivity.access$setCurrentSkillInstalled$p(this.f20290b, this.f20292d.d());
                SkillDetailPreviewActivity.access$setCurrentUsageExamples$p(this.f20290b, this.f20292d.c());
                SkillDetailPreviewActivity.access$setCurrentStoreDetailDescription$p(this.f20290b, this.f20292d.b());
                SkillDetailPreviewActivity.access$renderDetail(this.f20290b, this.f20292d.a());
                if (this.f20292d.d() == false) goto L10;
                SkillDetailPreviewActivity.access$ensureSkillObserverStarted(this.f20290b);
            L10:
                return d.x.f38692a;
            L12:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$q$3, reason: invalid class name */
        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$refreshSkillDetail$1$3")
        static final class AnonymousClass3 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20293a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20294b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ long f20295c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Exception f20296d;

            AnonymousClass3(SkillDetailPreviewActivity r3, long r4, Exception r6, d.c.d<? super AnonymousClass3> r7) {
                SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20294b = r5;
                this.f20295c = r4;
                this.f20296d = r6;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass3.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f20294b, this.f20295c, this.f20296d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                d.c.a.b.a();
                if (this.f20293a != 0) goto L10;
                d.o.a(r6);
                if (SkillDetailPreviewActivity.access$finishDetailLoadRequest(this.f20294b, this.f20295c) == false) goto L8;
                cl.a("SkillManager", "load skill detail", (Throwable) ZeusTransformUtils.preCheckCast(this.f20296d, Throwable.class, "com.obric.aiagent.plugin"));
                SkillDetailPreviewActivity r7 = this.f20294b;
                String r0 = r7.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_load_failed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_load_failed"));
                d.h.b.o.c(r0, "getString(...)");
                String r5 = this.f20294b.getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_retry_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_retry_message"));
                d.h.b.o.c(r5, "getString(...)");
                SkillDetailPreviewActivity.access$renderError(r7, r0, r5);
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        /* synthetic */ class a extends d.h.b.l implements d.h.a.b<String, com.obric.aiagent.skill.manager.impl.ao> {
            a(Object r8) {
                super(1, r8, ft.class, "getSkill", "getSkill(Ljava/lang/String;)Lcom/obric/aiagent/skill/manager/impl/ShopSkillDetail;", 0);
            }

            public final com.obric.aiagent.skill.manager.impl.ao a(String r3) {
                d.h.b.o.e(r3, "p0");
                return ((ft) ZeusTransformUtils.preCheckCast(this.receiver, ft.class, "com.obric.aiagent.plugin")).a(r3);
            }

            @Override // d.h.a.b
            public /* synthetic */ com.obric.aiagent.skill.manager.impl.ao invoke(String r3) {
                return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {793}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$refreshSkillDetail$1$loadedState$2")
        static final class b extends d.c.b.a.l implements d.h.a.r<com.obric.aiagent.skill.manager.api.e, com.obric.aiagent.skill.manager.impl.ao, d.h.a.a<? extends d.x>, d.c.d<? super hi>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20297a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            /* synthetic */ Object f20298b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            /* synthetic */ Object f20299c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f20300d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ ISkillManagerService f20301e;

            b(ISkillManagerService r3, d.c.d<? super b> r4) {
                ISkillManagerService r5 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20301e = r5;
                super(4, r6);
            }

            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
            public final Object a2(com.obric.aiagent.skill.manager.api.e r3, com.obric.aiagent.skill.manager.impl.ao r4, d.h.a.a<d.x> r5, d.c.d<? super hi> r6) {
                d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                b r0 = new b(this.f20301e, r8);
                r0.f20298b = r3;
                r0.f20299c = r4;
                r0.f20300d = r7;
                return r0.invokeSuspend(d.x.f38692a);
            }

            @Override // d.h.a.r
            public /* synthetic */ Object a(com.obric.aiagent.skill.manager.api.e r3, com.obric.aiagent.skill.manager.impl.ao r4, d.h.a.a<? extends d.x> r5, d.c.d<? super hi> r6) {
                return a2((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), (com.obric.aiagent.skill.manager.impl.ao) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.impl.ao.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.preCheckCast(r5, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r6, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r9) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20297a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                d.o.a(r9);
            L16:
                hi r8 = (hi) ZeusTransformUtils.preCheckCast(r9, hi.class, "com.obric.aiagent.plugin");
                if (r8 == null) goto L20;
                return r8;
            L20:
                throw new IllegalStateException("Skill Manager implementation does not support detail refresh.".toString());
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r9);
                com.obric.aiagent.skill.manager.api.e r10 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f20298b, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.impl.ao r2 = (com.obric.aiagent.skill.manager.impl.ao) ZeusTransformUtils.preCheckCast(this.f20299c, com.obric.aiagent.skill.manager.impl.ao.class, "com.obric.aiagent.plugin");
                d.h.a.a<d.x> r4 = (d.h.a.a) ZeusTransformUtils.preCheckCast(this.f20300d, d.h.a.a.class, "com.obric.aiagent.plugin");
                ISkillManagerService r5 = this.f20301e;
                if (ZeusTransformUtils.instanceOf(r5, SkillManager.class) == false) goto L11;
                SkillManager r6 = (SkillManager) ZeusTransformUtils.preCheckCast(r5, SkillManager.class, "com.obric.aiagent.plugin");
            L12:
                if (r6 == null) goto L20;
                d.c.d<? super hi> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20298b = null;
                this.f20299c = null;
                this.f20297a = 1;
                r9 = r6.refreshSkillForDetail$impl_release(r10, r2, r4, r7);
                if (r9 != r0) goto L16;
                return r0;
            L11:
                r6 = null;
                goto L12
            }
        }

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$refreshSkillDetail$1$loadedState$3$1$1")
        static final class c extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20302a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f20303b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20304c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ cm.a f20305d;

            c(long r3, SkillDetailPreviewActivity r5, cm.a r6, d.c.d<? super c> r7) {
                SkillDetailPreviewActivity r8 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r5, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20303b = r3;
                this.f20304c = r8;
                this.f20305d = r6;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((c) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f20303b, this.f20304c, this.f20305d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                d.c.a.b.a();
                if (this.f20302a != 0) goto L10;
                d.o.a(r5);
                if (this.f20303b != SkillDetailPreviewActivity.access$getDetailLoadRequestId$p(this.f20304c)) goto L8;
                cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20304c, Activity.class, "com.obric.aiagent.plugin"), this.f20305d);
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$refreshSkillDetail$1$loadedState$4$1")
        static final class d extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20306a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ long f20307b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20308c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ aa f20309d;

            d(long r3, SkillDetailPreviewActivity r5, aa r6, d.c.d<? super d> r7) {
                SkillDetailPreviewActivity r8 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r5, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20307b = r3;
                this.f20308c = r8;
                this.f20309d = r6;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((d) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f20307b, this.f20308c, this.f20309d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r5) {
                d.c.a.b.a();
                if (this.f20306a != 0) goto L10;
                d.o.a(r5);
                if (this.f20307b != SkillDetailPreviewActivity.access$getDetailLoadRequestId$p(this.f20308c)) goto L8;
                SkillDetailPreviewActivity.access$renderLoading(this.f20308c, this.f20309d);
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        q(SkillDetailPreviewActivity r3, ISkillManagerService r4, String r5, long r6, d.c.d<? super q> r8) {
            SkillDetailPreviewActivity r7 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            ISkillManagerService r9 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20283c = r7;
            this.f20284d = r9;
            this.f20285e = r5;
            this.f = r6;
            super(2, r10);
        }

        public static /* synthetic */ d.x lambda$S0eqmuyeQ4MCgb_eqLyVjIHWKeg(SkillDetailPreviewActivity r0, long r1, com.obric.aiagent.skill.manager.api.e r3, com.obric.aiagent.skill.manager.api.u.a r4) {
            return a(r0, r1, r3, r4);
        }

        /* JADX INFO: renamed from: lambda$ZL0D7BQW7-RA9F_iyM1wJwvjEc4, reason: not valid java name */
        public static /* synthetic */ d.x m306lambda$ZL0D7BQW7RA9F_iyM1wJwvjEc4(SkillDetailPreviewActivity r0, long r1, aa r3) {
            return a(r0, r1, r3);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r9, d.c.d<?> r10) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f20283c, this.f20284d, this.f20285e, this.f, r7), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.obric.aiagent.skill.manager.impl.ea, int] */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r32) {
            Object r0 = d.c.a.b.a();
            ?? r2 = this.f20282b;
            if (r2 == 0) goto L10;
            if (r2 != 1) goto L9;
            ea r3 = (ea) ZeusTransformUtils.preCheckCast(this.f20281a, ea.class, "com.obric.aiagent.plugin");
            d.o.a(r32);     // Catch: Exception -> L30 CancellationException -> L34
            Object r4 = r32;
        L24:
            ae r12 = (ae) ZeusTransformUtils.preCheckCast(r4, ae.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30 CancellationException -> L34
            if (r12 != null) goto L28;
            ea.a(r3, dz.f19792b, null, this.f20285e, null, null, null, dw.f19777b, "detail_request", d.c.b.a.b.a(true), null, d.a.ao.a(d.s.a("page_type", "detail")), 570, null);     // Catch: Exception -> L30 CancellationException -> L34
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(this.f20283c), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20283c, this.f, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L30 CancellationException -> L34
            return d.x.f38692a;
        L28:
            ea.a(r3, dz.f19791a, r12.a(), null, null, null, null, null, null, null, null, d.a.ao.a(new d.m[]{d.s.a("page_type", "detail"), d.s.a("installed", d.c.b.a.b.a(r12.d())), d.s.a("usage_example_count", d.c.b.a.b.a(r12.c().size()))}), DownloadErrorCode.ERROR_THREAD_INTERRUPT, null);     // Catch: Exception -> L30 CancellationException -> L34
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(this.f20283c), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20283c, this.f, r12, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L30 CancellationException -> L34
        L33:
            return d.x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            d.o.a(r32);
            r3 = new ea(dy.q, SkillDetailPreviewActivity.access$getTrackingReporter$p(this.f20283c), null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
            List r8 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(this.f20284d.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30 CancellationException -> L34
            if (r8 != null) goto L14;
            r8 = d.a.p.b();     // Catch: Exception -> L30 CancellationException -> L34
        L14:
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30 CancellationException -> L34
            String r10 = this.f20285e;     // Catch: Exception -> L30 CancellationException -> L34
            Iterator r11 = r9.iterator();     // Catch: Exception -> L30 CancellationException -> L34
        L16:
            if (r11.hasNext() == false) goto L20;
            Object r13 = r11.next();     // Catch: Exception -> L30 CancellationException -> L34
            if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r10) == false) goto L16;
        L21:
            com.obric.aiagent.skill.manager.api.e r14 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30 CancellationException -> L34
            d.h.a.b r15 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new a(SkillDetailPreviewActivity.access$getShopRepository$p(this.f20283c)), d.h.a.b.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30 CancellationException -> L34
            d.h.a.r r16 = (d.h.a.r) ZeusTransformUtils.preCheckCast(new b(this.f20284d, null), d.h.a.r.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30 CancellationException -> L34
            final SkillDetailPreviewActivity r17 = this.f20283c;     // Catch: Exception -> L30 CancellationException -> L34
            final long r18 = this.f;     // Catch: Exception -> L30 CancellationException -> L34
            d.h.a.m r19 = new $$Lambda$SkillDetailPreviewActivity$q$S0eqmuyeQ4MCgb_eqLyVjIHWKeg(r17, r18);     // Catch: Exception -> L30 CancellationException -> L34
            final SkillDetailPreviewActivity r110 = this.f20283c;     // Catch: Exception -> L30 CancellationException -> L34
            final long r111 = this.f;     // Catch: Exception -> L30 CancellationException -> L34
            z r20 = new z(r15, r16, r19, new $$Lambda$SkillDetailPreviewActivity$q$ZL0D7BQW7RA9F_iyM1wJwvjEc4(r110, r111));     // Catch: Exception -> L30 CancellationException -> L34
            String r5 = this.f20285e;     // Catch: Exception -> L30 CancellationException -> L34
            d.c.d<? super ae> r112 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L30 CancellationException -> L34
            this.f20281a = r3;     // Catch: Exception -> L30 CancellationException -> L34
            this.f20282b = 1;     // Catch: Exception -> L30 CancellationException -> L34
            r4 = r20.a(r5, r14, r112);     // Catch: Exception -> L30 CancellationException -> L34
            if (r4 != r0) goto L24;
            return r0;
        L20:
            r13 = null;
        L34:
            e = move-exception;
            ea.a(r2, dz.f19793c, null, this.f20285e, null, null, null, dw.n, "superseded", null, null, d.a.ao.a(d.s.a("page_type", "detail")), 826, null);
            throw e;
        L30:
            e = move-exception;
            ea.a(r2, dz.f19792b, null, this.f20285e, null, null, null, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "detail_request", d.c.b.a.b.a(true), null, d.a.ao.a(d.s.a("page_type", "detail")), 570, null);
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(this.f20283c), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.f20283c, this.f, e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            goto L33
        }

        private static final d.x a(SkillDetailPreviewActivity r13, long r14, com.obric.aiagent.skill.manager.api.e r16, com.obric.aiagent.skill.manager.api.u.a r17) {
            SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r13, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            SkillDetailPreviewActivity.access$logDetailWarning(r5, "refresh installed shop skill failed code=" + r17.a(), "refresh installed shop skill failed: slug=" + r16.a() + ", code=" + r17.a());
            cm.a r6 = cl.a(r17);
            if (r6 == null) goto L6;
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(r5), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r14, r5, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        L6:
            return d.x.f38692a;
        }

        private static final d.x a(SkillDetailPreviewActivity r12, long r13, aa r15) {
            SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r12, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(r5), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r13, r5, r15, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {1420, 1563}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$scheduleDetailSigningRefresh$1")
    static final class r extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f20310a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f20311b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillDetailPreviewActivity f20312c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20313d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f20314e;
        final /* synthetic */ com.obric.aiagent.skill.manager.api.e f;
        final /* synthetic */ b g;
        private /* synthetic */ Object h;

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f20315a = null;

            static {
                int[] r0 = new int[com.obric.aiagent.skill.manager.api.am.values().length];
                r0[com.obric.aiagent.skill.manager.api.am.f19205e.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[com.obric.aiagent.skill.manager.api.am.f19203c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f20315a = r0;
            }
        }

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {1423, 1428}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$scheduleDetailSigningRefresh$1$refreshResult$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.ao>>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20316a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f20317b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ ISkillManagerService f20318c;

            b(String r3, ISkillManagerService r4, d.c.d<? super b> r5) {
                ISkillManagerService r6 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20317b = r3;
                this.f20318c = r6;
                super(2, r7);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f20317b, this.f20318c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super com.obric.aiagent.skill.manager.api.u<? extends com.obric.aiagent.skill.manager.api.ao>> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r7) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20316a;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                d.o.a(r7);
            L20:
                return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                d.o.a(r7);
            L21:
                return (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
            L10:
                d.o.a(r7);
                com.obric.aiagent.skill.manager.api.ap.b r8 = new com.obric.aiagent.skill.manager.api.ap.b(d.a.ax.a(this.f20317b));
                if (ZeusTransformUtils.instanceOf(this.f20318c, SkillManager.class) == false) goto L16;
                SkillManager r2 = (SkillManager) ZeusTransformUtils.preCheckCast(this.f20318c, SkillManager.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.api.ap r9 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.impl.aw r3 = com.obric.aiagent.skill.manager.impl.aw.f19533d;
                d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20316a = 1;
                r7 = r2.refreshSkillSignatures$impl_release(r9, r3, r5);
                if (r7 != r0) goto L21;
                return r0;
            L16:
                ISkillManagerService r4 = this.f20318c;
                com.obric.aiagent.skill.manager.api.ap r10 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
                d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20316a = 2;
                r7 = r4.refreshSkillSignatures(r10, r6);
                if (r7 != r0) goto L20;
                return r0;
            }
        }

        r(SkillDetailPreviewActivity r3, ISkillManagerService r4, String r5, com.obric.aiagent.skill.manager.api.e r6, b r7, d.c.d<? super r> r8) {
            SkillDetailPreviewActivity r9 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            ISkillManagerService r10 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20312c = r9;
            this.f20313d = r10;
            this.f20314e = r5;
            this.f = r6;
            this.g = r7;
            super(2, r11);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((r) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), r.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r10, d.c.d<?> r11) {
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            r r12 = new r(this.f20312c, this.f20313d, this.f20314e, this.f, this.g, r8);
            r12.h = r10;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r12, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:204:0x05a3 -> B:23:0x006f). Please report as a decompilation issue!!! */
        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r18) {
            Object r2 = d.c.a.b.a();
            int r0 = this.f20311b;
            if (r0 == 0) goto L22;
            if (r0 == 1) goto L13;
            if (r0 != 2) goto L12;
            kotlinx.coroutines.am r8 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.h, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L9
        L24:
            if (kotlinx.coroutines.an.a(r8) == false) goto L226;
            if (SkillDetailPreviewActivity.access$getDetailPageVisible$p(this.f20312c) == false) goto L226;
            List r1 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(this.f20313d.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r1 != null) goto L30;
            r1 = d.a.p.b();     // Catch: Throwable -> L9
        L30:
            Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            String r9 = this.f20314e;     // Catch: Throwable -> L9
            Iterator r4 = r3.iterator();     // Catch: Throwable -> L9
        L32:
            if (r4.hasNext() == false) goto L36;
            Object r10 = r4.next();     // Catch: Throwable -> L9
            if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r9) == false) goto L32;
        L37:
            com.obric.aiagent.skill.manager.api.e r11 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r10, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r11 != null) goto L45;
            SkillDetailPreviewActivity.access$clearDetailSigningProgress(this.f20312c, this.f20314e);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.g, this.f);     // Catch: Throwable -> L9
            d.x r5 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L43;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L43:
            return r5;
        L45:
            if (this.g.f() == false) goto L56;
            if (r11.i() != com.obric.aiagent.skill.manager.api.aj.d.f19189a) goto L49;
        L50:
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.h, r11);     // Catch: Throwable -> L9
            d.x r6 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L54;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L54:
            return r6;
        L49:
            if (ZeusTransformUtils.instanceOf(r11.i(), com.obric.aiagent.skill.manager.api.aj.b.class) == true) goto L50;
        L56:
            if (ZeusTransformUtils.instanceOf(r11.i(), com.obric.aiagent.skill.manager.api.aj.e.class) == true) goto L58;
        L235:
            d.c.g r7 = (d.c.g) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9 Exception -> L69 CancellationException -> L71
            d.h.a.m r12 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.f20314e, this.f20313d, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9 Exception -> L69 CancellationException -> L71
            d.c.d r13 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9 Exception -> L69 CancellationException -> L71
            this.h = r8;     // Catch: Throwable -> L9 Exception -> L69 CancellationException -> L71
            this.f20310a = r11;     // Catch: Throwable -> L9 Exception -> L69 CancellationException -> L71
            this.f20311b = 1;     // Catch: Throwable -> L9 Exception -> L69 CancellationException -> L71
            Object r14 = kotlinx.coroutines.i.a(r7, r12, r13);     // Catch: Throwable -> L9 Exception -> L69 CancellationException -> L71
            if (r14 != r2) goto L67;
            return r2;
        L67:
            com.obric.aiagent.skill.manager.api.u r15 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r14, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9 Exception -> L69 CancellationException -> L71
        L75:
            if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L77;
            com.obric.aiagent.skill.manager.api.u.b r16 = (com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L78:
            if (r16 == null) goto L80;
            com.obric.aiagent.skill.manager.api.ao r17 = (com.obric.aiagent.skill.manager.api.ao) ZeusTransformUtils.preCheckCast(r16.a(), com.obric.aiagent.skill.manager.api.ao.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L82:
            if (ZeusTransformUtils.instanceOf(r15, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L84;
            SkillDetailPreviewActivity.access$logDetailWarning(this.f20312c, "Detail signing refresh failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Detail signing refresh failed: slug=" + this.f20314e + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r15, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L9
        L84:
            if (r17 == null) goto L95;
            List<com.obric.aiagent.skill.manager.api.an> r19 = r17.a();     // Catch: Throwable -> L9
            if (r19 == null) goto L95;
            Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(r19, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            String r110 = this.f20314e;     // Catch: Throwable -> L9
            Iterator r21 = r20.iterator();     // Catch: Throwable -> L9
        L89:
            if (r21.hasNext() == false) goto L93;
            Object r111 = r21.next();     // Catch: Throwable -> L9
            if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r111, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin")).a(), r110) == false) goto L89;
        L94:
            com.obric.aiagent.skill.manager.api.an r22 = (com.obric.aiagent.skill.manager.api.an) ZeusTransformUtils.preCheckCast(r111, com.obric.aiagent.skill.manager.api.an.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        L96:
            b r112 = this.g;     // Catch: Throwable -> L9
            if (r22 == null) goto L99;
            com.obric.aiagent.skill.manager.api.am r113 = r22.b();     // Catch: Throwable -> L9
        L100:
            r112.a(r113);     // Catch: Throwable -> L9
            if (r22 == null) goto L103;
            com.obric.aiagent.skill.manager.api.am r114 = r22.b();     // Catch: Throwable -> L9
        L104:
            if (r114 != null) goto L106;
            int r115 = -1;
        L107:
            if (r115 == 1) goto L112;
            if (r115 != 2) goto L120;
            b r116 = this.g;     // Catch: Throwable -> L9
            r116.c(r116.e() + 1);     // Catch: Throwable -> L9
        L120:
            if (r22 != null) goto L122;
        L125:
            boolean r117 = true;
        L126:
            if (r117 == false) goto L136;
            if (r22 == null) goto L133;
            String r118 = r22.c();     // Catch: Throwable -> L9
            if (r118 == null) goto L133;
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r118, CharSequence.class, "com.obric.aiagent.plugin"))) != true) goto L133;
            boolean r119 = true;
        L134:
            if (r119 == false) goto L136;
            SkillDetailPreviewActivity.access$logDetailWarning(this.f20312c, "Detail signing refresh returned failure", "Detail signing refresh returned failure: slug=" + this.f20314e + ", error=" + r22.c());     // Catch: Throwable -> L9
        L133:
            r119 = false;
        L136:
            List r120 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(this.f20313d.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r120 != null) goto L139;
            r120 = d.a.p.b();     // Catch: Throwable -> L9
        L139:
            Iterable r121 = (Iterable) ZeusTransformUtils.preCheckCast(r120, Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            String r122 = this.f20314e;     // Catch: Throwable -> L9
            Iterator r123 = r121.iterator();     // Catch: Throwable -> L9
        L141:
            if (r123.hasNext() == false) goto L145;
            Object r124 = r123.next();     // Catch: Throwable -> L9
            if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r124, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r122) == false) goto L141;
        L146:
            com.obric.aiagent.skill.manager.api.e r125 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r124, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            if (r125 != null) goto L153;
            SkillDetailPreviewActivity.access$clearDetailSigningProgress(this.f20312c, this.f20314e);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.g, r11);     // Catch: Throwable -> L9
            d.x r23 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L152;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L152:
            return r23;
        L153:
            if (r22 != null) goto L155;
        L157:
            boolean r24 = false;
        L158:
            if (r24 == false) goto L168;
            if (en.c(r125.i()) == false) goto L162;
            SkillDetailPreviewActivity.access$pauseDetailSigningProgress(this.f20312c, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$bindSecurityFooter(this.f20312c, r125);     // Catch: Throwable -> L9
        L162:
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.f20238b, r125);     // Catch: Throwable -> L9
            d.x r25 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L166;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L166:
            return r25;
        L168:
            if (en.c(r125.i()) == false) goto L219;
            SkillDetailPreviewActivity.access$setCurrentSkill$p(this.f20312c, r125);     // Catch: Throwable -> L9
            if (ZeusTransformUtils.instanceOf(r125.i(), com.obric.aiagent.skill.manager.api.aj.b.class) == false) goto L172;
        L206:
            SkillDetailPreviewActivity.access$pauseDetailSigningProgress(this.f20312c, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$bindSecurityFooter(this.f20312c, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity r26 = this.f20312c;     // Catch: Throwable -> L9
            if (r22 == null) goto L209;
            com.obric.aiagent.skill.manager.api.am r27 = r22.b();     // Catch: Throwable -> L9
        L211:
            if (r27 != com.obric.aiagent.skill.manager.api.am.f19204d) goto L213;
            c r28 = c.f20239c;     // Catch: Throwable -> L9
        L214:
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(r26, r28, r125);     // Catch: Throwable -> L9
            d.x r29 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L218;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L218:
            return r29;
        L213:
            r28 = c.f20238b;     // Catch: Throwable -> L9
            goto L214
        L209:
            r27 = null;
            goto L211
        L172:
            if (r125.i() == com.obric.aiagent.skill.manager.api.aj.d.f19189a) goto L206;
            if (r22 == null) goto L176;
            com.obric.aiagent.skill.manager.api.am r30 = r22.b();     // Catch: Throwable -> L9
        L178:
            if (r30 != com.obric.aiagent.skill.manager.api.am.f19204d) goto L184;
            SkillDetailPreviewActivity.access$pauseDetailSigningProgress(this.f20312c, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$bindSecurityFooter(this.f20312c, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.f20239c, r125);     // Catch: Throwable -> L9
            d.x r31 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L183;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L183:
            return r31;
        L184:
            if (r117 == false) goto L192;
            b r32 = this.g;     // Catch: Throwable -> L9
            r32.a(r32.c() + 1);     // Catch: Throwable -> L9
            b r33 = this.g;     // Catch: Throwable -> L9
            r33.b(r33.d() + 1);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$pauseDetailSigningProgress(this.f20312c, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$bindSecurityFooter(this.f20312c, r125);     // Catch: Throwable -> L9
            if (this.g.c() < 3) goto L194;
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.f20240d, r125);     // Catch: Throwable -> L9
            d.x r34 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L191;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L191:
            return r34;
        L194:
            if (com.obric.aiagent.skill.manager.api.al.f19195a.a().E() == true) goto L200;
            SkillDetailPreviewActivity.access$logDetailInfo(this.f20312c, "Detail signing polling stopped by config", "Detail signing polling stopped by config after one refresh: slug=" + this.f20314e);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.i, r125);     // Catch: Throwable -> L9
            d.x r35 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L199;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L199:
            return r35;
        L200:
            if (r117 == false) goto L202;
            long r36 = 5000;
        L203:
            d.c.d r37 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
            this.h = r8;     // Catch: Throwable -> L9
            this.f20310a = null;     // Catch: Throwable -> L9
            this.f20311b = 2;     // Catch: Throwable -> L9
            if (kotlinx.coroutines.ax.a(r36, r37) != r2) goto L24;
            return r2;
        L202:
            r36 = SkillDetailPreviewActivity.DETAIL_SIGNING_REFRESH_INTERVAL_MS;
            goto L203
        L192:
            this.g.a(0);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$advanceDetailSigningProgress(this.f20312c, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$bindSecurityFooter(this.f20312c, r125);     // Catch: Throwable -> L9
            goto L194
        L176:
            r30 = null;
            goto L178
        L219:
            SkillDetailPreviewActivity.access$setCurrentSkill$p(this.f20312c, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.f20237a, r125);     // Catch: Throwable -> L9
            SkillDetailPreviewActivity.access$renderDetail(this.f20312c, r125);     // Catch: Throwable -> L9
            d.x r38 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L223;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L223:
            return r38;
        L155:
            if (gn.a(r22) != true) goto L157;
            r24 = true;
            goto L158
        L145:
            r124 = null;
            goto L146
        L122:
            if (r22.b() == com.obric.aiagent.skill.manager.api.am.g) goto L125;
            r117 = false;
            goto L126
        L112:
            if (this.g.f() == false) goto L118;
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.h, r11);     // Catch: Throwable -> L9
            d.x r39 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L117;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L117:
            return r39;
        L118:
            this.g.a(true);     // Catch: Throwable -> L9
            goto L120
        L106:
            r115 = a.f20315a[r114.ordinal()];     // Catch: Throwable -> L9
            goto L107
        L103:
            r114 = null;
            goto L104
        L99:
            r113 = null;
            goto L100
        L93:
            r111 = null;
        L95:
            r22 = null;
            goto L96
        L80:
            r17 = null;
            goto L82
        L77:
            r16 = null;
            goto L78
        L71:
            e = move-exception;
            throw e;     // Catch: Throwable -> L9
        L69:
            Exception e2 = e;
        L73:
            SkillDetailPreviewActivity.access$logDetailFailure(this.f20312c, "Detail signing refresh failed", "Detail signing refresh failed: slug=" + this.f20314e, (Throwable) ZeusTransformUtils.preCheckCast(e2, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L9
            r15 = null;
            goto L75
        L58:
            if (this.g.i() < SkillDetailPreviewActivity.DETAIL_SIGNING_MAX_SESSION_MS) goto L235;
            SkillDetailPreviewActivity.access$finishDetailSigningRefreshSession(this.f20312c, c.f20241e, r11);     // Catch: Throwable -> L9
            d.x r40 = d.x.f38692a;     // Catch: Throwable -> L9
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L63;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L63:
            return r40;
        L36:
            r10 = null;
        L226:
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r8.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L229;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L229:
            return d.x.f38692a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            com.obric.aiagent.skill.manager.api.e r41 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(this.f20310a, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.am r42 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.h, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            d.o.a(r18);     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L20
            r14 = r18;
            r11 = r41;
            r8 = r42;
            goto L67
        L20:
            e = move-exception;
            throw e;     // Catch: Throwable -> L9
        L18:
            e2 = e;
            r11 = r41;
            r8 = r42;
        L16:
            th = th;
        L231:
            if (SkillDetailPreviewActivity.access$getDetailSigningRefreshJob$p(this.f20312c) != r42.a().get((d.c.g.c) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin"))) goto L233;
            SkillDetailPreviewActivity.access$getDetailSigningRefreshGate$p(this.f20312c).b();
            SkillDetailPreviewActivity.access$setDetailSigningRefreshJob$p(this.f20312c, null);
        L233:
            throw th;
        L22:
            d.o.a(r18);
            r8 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.h, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
        L9:
            th = th;
            goto L231
        }
    }

    /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
    @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$submitEditSkillSheet$1")
    static final class s extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillDetailPreviewActivity f20320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ bb f20323e;
        final /* synthetic */ bb f;
        final /* synthetic */ ISkillManagerService g;
        final /* synthetic */ bc h;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$s$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$submitEditSkillSheet$1$2")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20324a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20325b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20326c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ bc f20327d;

            AnonymousClass1(SkillDetailPreviewActivity r3, com.obric.aiagent.skill.manager.api.e r4, bc r5, d.c.d<? super AnonymousClass1> r6) {
                SkillDetailPreviewActivity r7 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                bc r8 = (bc) ZeusTransformUtils.wrapperContextForParams(r5, bc.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20325b = r7;
                this.f20326c = r4;
                this.f20327d = r8;
                super(2, r9);
            }

            public static /* synthetic */ d.x lambda$o0BN8hKC0ZqzYotNjPNh2sc8eAM(SkillDetailPreviewActivity r0) {
                return a(r0);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20325b, this.f20326c, this.f20327d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f20324a != 0) goto L7;
                d.o.a(r3);
                SkillDetailPreviewActivity.access$setCurrentSkill$p(this.f20325b, this.f20326c);
                SkillDetailPreviewActivity.access$setCurrentSlug$p(this.f20325b, this.f20326c.a());
                SkillDetailPreviewActivity.access$renderDetail(this.f20325b, this.f20326c);
                SkillDetailPreviewActivity.access$ensureSkillObserverStarted(this.f20325b);
                bc r4 = this.f20327d;
                final SkillDetailPreviewActivity r0 = this.f20325b;
                r4.a(new $$Lambda$SkillDetailPreviewActivity$s$1$o0BN8hKC0ZqzYotNjPNh2sc8eAM(r0));
                this.f20327d.d();
                return d.x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            private static final d.x a(SkillDetailPreviewActivity r3) {
                SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r4, Activity.class, "com.obric.aiagent.plugin"), cm.a.f20761b);
                return d.x.f38692a;
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$s$2, reason: invalid class name */
        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$submitEditSkillSheet$1$3")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20328a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ bc f20329b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20330c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Exception f20331d;

            AnonymousClass2(bc r3, SkillDetailPreviewActivity r4, Exception r5, d.c.d<? super AnonymousClass2> r6) {
                bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.aiagent.plugin");
                SkillDetailPreviewActivity r8 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20329b = r7;
                this.f20330c = r8;
                this.f20331d = r5;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20329b, this.f20330c, this.f20331d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20328a != 0) goto L10;
                d.o.a(r4);
                this.f20329b.f();
                cm r5 = cm.f20758a;
                Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.f20330c, Activity.class, "com.obric.aiagent.plugin");
                cm.a r3 = cl.a((Throwable) ZeusTransformUtils.preCheckCast(this.f20331d, Throwable.class, "com.obric.aiagent.plugin"));
                if (r3 != null) goto L7;
                r3 = cm.a.f20762c;
            L7:
                r5.a(r0, r3);
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        /* synthetic */ class a extends d.h.b.l implements d.h.a.m<com.obric.aiagent.skill.manager.api.e, Collection<? extends com.obric.aiagent.skill.manager.impl.bf>, d.x> {
            a(Object r8) {
                super(2, r8, hd.class, "reportSkillEdit", "reportSkillEdit(Lcom/obric/aiagent/skill/manager/api/Skill;Ljava/util/Collection;)V", 0);
            }

            public final void a(com.obric.aiagent.skill.manager.api.e r3, Collection<? extends com.obric.aiagent.skill.manager.impl.bf> r4) {
                Collection<? extends com.obric.aiagent.skill.manager.impl.bf> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
                d.h.b.o.e(r3, "p0");
                d.h.b.o.e(r5, "p1");
                ((hd) ZeusTransformUtils.preCheckCast(this.receiver, hd.class, "com.obric.aiagent.plugin")).a(r3, r5);
            }

            @Override // d.h.a.m
            public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.api.e r3, Collection<? extends com.obric.aiagent.skill.manager.impl.bf> r4) {
                a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), (Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin"));
                return d.x.f38692a;
            }
        }

        /* JADX INFO: compiled from: SkillDetailPreviewActivity.kt */
        @d.c.b.a.f(b = "SkillDetailPreviewActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillDetailPreviewActivity$submitEditSkillSheet$1$saved$1")
        static final class b extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20332a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ bc f20333b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SkillDetailPreviewActivity f20334c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> f20335d;

            b(bc r3, SkillDetailPreviewActivity r4, com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r5, d.c.d<? super b> r6) {
                bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r3, bc.class, "com.obric.aiagent.plugin");
                SkillDetailPreviewActivity r8 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r9 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
                d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20333b = r7;
                this.f20334c = r8;
                this.f20335d = r9;
                super(2, r10);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f20333b, this.f20334c, this.f20335d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20332a != 0) goto L10;
                d.o.a(r4);
                this.f20333b.f();
                cm r5 = cm.f20758a;
                Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.f20334c, Activity.class, "com.obric.aiagent.plugin");
                cm.a r3 = cl.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(this.f20335d, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"));
                if (r3 != null) goto L7;
                r3 = cm.a.f20762c;
            L7:
                r5.a(r0, r3);
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        s(SkillDetailPreviewActivity r3, String r4, com.obric.aiagent.skill.manager.api.e r5, bb r6, bb r7, ISkillManagerService r8, bc r9, d.c.d<? super s> r10) {
            SkillDetailPreviewActivity r11 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
            ISkillManagerService r12 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r8, ISkillManagerService.class, "com.obric.aiagent.plugin");
            bc r13 = (bc) ZeusTransformUtils.wrapperContextForParams(r9, bc.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20320b = r11;
            this.f20321c = r4;
            this.f20322d = r5;
            this.f20323e = r6;
            this.f = r7;
            this.g = r12;
            this.h = r13;
            super(2, r14);
        }

        public static /* synthetic */ com.obric.aiagent.skill.manager.api.u lambda$STLz9NZLMYKmi5caAgOYXOT4NTI(boolean r0, ISkillManagerService r1, bb r2, com.obric.aiagent.skill.manager.api.e r3, String r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((s) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), s.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r11, d.c.d<?> r12) {
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new s(this.f20320b, this.f20321c, this.f20322d, this.f20323e, this.f, this.g, this.h, r9), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r15) {
            d.c.a.b.a();
            if (this.f20319a != 0) goto L52;
            d.o.a(r15);
            com.obric.aiagent.skill.manager.impl.y r16 = SkillDetailPreviewActivity.access$getEditCoverPickerCoordinator(this.f20320b).a(this.f20321c);
            boolean r2 = com.obric.aiagent.skill.manager.impl.az.a(this.f20322d, SkillDetailPreviewActivity.access$getCurrentSkillInstalled$p(this.f20320b));
            if (r2 == false) goto L7;
            List<com.obric.aiagent.skill.manager.impl.bf> r3 = af.a(this.f20323e, this.f);
        L8:
            boolean r4 = false;
            int r7 = this.f20322d.j();     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            if (r2 == false) goto L12;
            final boolean r9 = true;
        L13:
            final ISkillManagerService r10 = this.g;     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            final bb r11 = this.f;     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            final com.obric.aiagent.skill.manager.api.e r12 = this.f20322d;     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            final String r13 = this.f20321c;     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r5 = af.a(r7, r3, new $$Lambda$SkillDetailPreviewActivity$s$STLz9NZLMYKmi5caAgOYXOT4NTI(r9, r10, r11, r12, r13), (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(SkillDetailPreviewActivity.access$getTrackingReporter$p(this.f20320b)), d.h.a.m.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            if (ZeusTransformUtils.instanceOf(r5, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L29;
            com.obric.aiagent.skill.manager.api.e r6 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.av.a(this.f20322d.f(), this.f20321c, true), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L22 Exception -> L24 CancellationException -> L26
            com.obric.aiagent.skill.manager.impl.au r14 = SkillDetailPreviewActivity.access$getCoverStore(this.f20320b);     // Catch: Throwable -> L22 Exception -> L24 CancellationException -> L26
            Iterator r17 = r8.iterator();     // Catch: Throwable -> L22 Exception -> L24 CancellationException -> L26
        L18:
            if (r17.hasNext() == false) goto L20;
            r14.a((String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L22 Exception -> L24 CancellationException -> L26
            goto L18
        L20:
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(this.f20320b), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20320b, r6, this.h, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L22 Exception -> L24 CancellationException -> L26
        L44:
            return d.x.f38692a;
        L26:
            e = move-exception;
            throw e;     // Catch: Throwable -> L36
        L24:
            e = e;
            r4 = true;
        L39:
            SkillDetailPreviewActivity.access$logDetailFailure(this.f20320b, "Edit skill save failed", "Edit skill save failed: slug=" + this.f20322d.a(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L36
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(this.f20320b), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.h, this.f20320b, e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L36
            if (r4 == true) goto L44;
            if (r16 == null) goto L44;
            d.c.b.a.b.a(SkillDetailPreviewActivity.access$getCoverStore(this.f20320b).a(r16.a()));
        L22:
            th = th;
            r4 = true;
        L47:
            if (r4 == true) goto L50;
            if (r16 == null) goto L50;
            d.c.b.a.b.a(SkillDetailPreviewActivity.access$getCoverStore(this.f20320b).a(r16.a()));
        L50:
            throw th;
        L29:
            if (ZeusTransformUtils.instanceOf(r5, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L35;
            SkillDetailPreviewActivity.access$logDetailWarning(this.f20320b, "Edit skill save failed code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Edit skill save failed: slug=" + this.f20322d.a() + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            kotlinx.coroutines.i.a(SkillDetailPreviewActivity.access$getMainScope$p(this.f20320b), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this.h, this.f20320b, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            d.x r0 = d.x.f38692a;     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
            if (r16 == null) goto L33;
            d.c.b.a.b.a(SkillDetailPreviewActivity.access$getCoverStore(this.f20320b).a(r16.a()));
        L33:
            return r0;
        L35:
            throw new d.k();     // Catch: Throwable -> L36 Exception -> L38 CancellationException -> L45
        L12:
            r9 = false;
        L36:
            th = th;
        L45:
            e = move-exception;
            throw e;     // Catch: Throwable -> L36
        L38:
            e = e;
            goto L39
        L7:
            r3 = d.a.p.b();
            goto L8
        L52:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        private static final com.obric.aiagent.skill.manager.api.u a(boolean r21, ISkillManagerService r22, bb r23, com.obric.aiagent.skill.manager.api.e r24, String r25) {
            ISkillManagerService r0 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r22, ISkillManagerService.class, "com.obric.aiagent.plugin");
            if (r21 == false) goto L6;
            return r0.saveSkill(com.obric.aiagent.skill.manager.api.e.a(r24, null, r23.a(), r23.b(), null, null, r25, null, null, null, 0, r23.c(), false, false, null, null, null, null, 130009, null));
        L6:
            return r0.saveSkillCover(r24.a(), r25);
        }
    }

    public static /* synthetic */ int access$000(String r0, String r1) {
        return Log.i(r0, r1);
    }

    public static /* synthetic */ int access$001(String r0, String r1) {
        return Log.w(r0, r1);
    }

    public static /* synthetic */ int access$002(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }

    public static final Intent createIntent(Context r2, String r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return Companion.a(r5, r3, r4);
    }

    public static /* synthetic */ void lambda$26rGXtCe_BbczZdcF6Yo4i3YJ4E(SkillDetailPreviewActivity r0) {
        scheduleBottomDividerRefresh$lambda$70(r0);
    }

    public static /* synthetic */ d.x lambda$5IQV4jYUhdz_DJGojZoCmT_Vp6k(d.h.a.b r0, SkillDetailPreviewActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3, int r4) {
        return showDetailMenu$lambda$21$lambda$18(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ void lambda$6r7iTj7YVEtWHe0QubjGLYMV7Mw(SkillDetailPreviewActivity r0, com.obric.aiagent.skill.manager.api.e r1, DialogInterface r2, int r3) {
        showDeleteConfirmAlertDialog$lambda$40(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$9dU6Ww_PllAEElulAJ-d2USBAmI, reason: not valid java name */
    public static /* synthetic */ d.x m290lambda$9dU6Ww_PllAEElulAJd2USBAmI(SkillDetailPreviewActivity r0) {
        return configureCta$lambda$43$lambda$42(r0);
    }

    public static /* synthetic */ d.x lambda$A43JfoXhD_9yAc0szSxWY4tcTwk(com.obric.aiagent.skill.manager.impl.cf r0) {
        return editFilePickerCoordinator_delegate$lambda$3$lambda$1(r0);
    }

    public static /* synthetic */ ai lambda$BI30RRMRgMIwLpCUTrhE5K27Y6Y(SkillDetailPreviewActivity r0) {
        return editFilePickerCoordinator_delegate$lambda$3(r0);
    }

    public static /* synthetic */ d.x lambda$B_tdSPNPlTI0f_ltLliYx5mJfAU(SkillDetailPreviewActivity r0, aj r1, com.obric.aiagent.skill.manager.impl.cb r2, Throwable r3) {
        return handleEditFormFileReady$lambda$32(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$CHZcLo9KaLKLnbkWD-sV2gmERpk, reason: not valid java name */
    public static /* synthetic */ d.x m291lambda$CHZcLo9KaLKLnbkWDsV2gmERpk(SkillDetailPreviewActivity r0) {
        return showEditSkillSheet$lambda$27(r0);
    }

    public static /* synthetic */ OProgressButton lambda$DmDla65WTl8kBNvhKgJrEYsruF8(Context r0, int r1, int r2) {
        return configureBottomActionBar$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$FdFkqeYd2p5iDqu9mEK_uqSUdw0(SkillDetailPreviewActivity r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        configureStaticViews$lambda$14(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public static /* synthetic */ void lambda$Ik8NErNspt5IghpiGLukSpY3GaI(SkillDetailPreviewActivity r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
        configureCta$lambda$43(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$Ir3azEng9lrpgvmT22RDgEP-khI, reason: not valid java name */
    public static /* synthetic */ d.x m292lambda$Ir3azEng9lrpgvmT22RDgEPkhI(SkillDetailPreviewActivity r0, Throwable r1) {
        return editCoverPickerCoordinator_delegate$lambda$7$lambda$5(r0, r1);
    }

    public static /* synthetic */ void lambda$JMrlSBskePwzIM0B4VyUWvvyZ78(DialogInterface r0, int r1) {
        showDeleteConfirmAlertDialog$lambda$39(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$NKXM6KNAsVJ6-d055x1BSWp1m3g, reason: not valid java name */
    public static /* synthetic */ void m293lambda$NKXM6KNAsVJ6d055x1BSWp1m3g(SkillDetailPreviewActivity r0, View r1) {
        configureCta$lambda$41(r0, r1);
    }

    public static /* synthetic */ void lambda$O0WU888KNYhbK39xq5TLrT9VCwE(SkillDetailPreviewActivity r0, View r1) {
        bindViews$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$O6KA6gBN6dadK7eNegjRdi-NF-0, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e m294lambda$O6KA6gBN6dadK7eNegjRdiNF0(SkillDetailPreviewActivity r0, aj r1) {
        return editFilePickerCoordinator_delegate$lambda$3$lambda$2(r0, r1);
    }

    public static /* synthetic */ ag lambda$PCqDwcdLS46jDQSb4khjPZxd9lc(SkillDetailPreviewActivity r0) {
        return enterPageTracker_delegate$lambda$9(r0);
    }

    /* JADX INFO: renamed from: lambda$U1-PznggUoAB36_rfDKZoXNLYTQ, reason: not valid java name */
    public static /* synthetic */ void m295lambda$U1PznggUoAB36_rfDKZoXNLYTQ(SkillDetailPreviewActivity r0, View r1) {
        setDetailMenuVisible$lambda$45(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$UXW_v--JZvrUoB61BoUP_ekRQ04, reason: not valid java name */
    public static /* synthetic */ bp m296lambda$UXW_vJZvrUoB61BoUP_ekRQ04(SkillDetailPreviewActivity r0) {
        return enterPageTracker_delegate$lambda$9$lambda$8(r0);
    }

    public static /* synthetic */ d.x lambda$WYVW6L58W3DIfQP9XHWbibjhcCM(SkillDetailPreviewActivity r0, String r1) {
        return editCoverPickerCoordinator_delegate$lambda$7$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$WqTPTzS1Ab-oQaa-M4foU85uIO8, reason: not valid java name */
    public static /* synthetic */ d.x m297lambda$WqTPTzS1AboQaaM4foU85uIO8(SkillDetailPreviewActivity r0, d.h.b.z.f r1, com.obric.aiagent.skill.manager.api.e r2, boolean r3) {
        return showDetailMenu$lambda$17(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$ZK-oLebxyz98PKuRHWw8iUFjep8, reason: not valid java name */
    public static /* synthetic */ d.x m298lambda$ZKoLebxyz98PKuRHWw8iUFjep8(SkillDetailPreviewActivity r0, String r1) {
        return openUsageExample$lambda$48(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$aQzlpDGId0vZpI-ds1ASRywhNXU, reason: not valid java name */
    public static /* synthetic */ void m299lambda$aQzlpDGId0vZpIds1ASRywhNXU(SkillDetailPreviewActivity r0, View r1) {
        configureAddCta$lambda$49(r0, r1);
    }

    public static /* synthetic */ d.x lambda$aRecUrgjz3urunMTy1jakWKO1fE(SkillDetailPreviewActivity r0) {
        return showEditSkillSheet$lambda$28(r0);
    }

    /* JADX INFO: renamed from: lambda$bbMcIixSENndCw9NOg-6SlmhECg, reason: not valid java name */
    public static /* synthetic */ v m300lambda$bbMcIixSENndCw9NOg6SlmhECg(SkillDetailPreviewActivity r0) {
        return editCoverPickerCoordinator_delegate$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$ci4RbTgzT-ogAckAoqrgK_mMzZY, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.skill.manager.api.e m301lambda$ci4RbTgzTogAckAoqrgK_mMzZY(SkillDetailPreviewActivity r0) {
        return editCoverPickerCoordinator_delegate$lambda$7$lambda$6(r0);
    }

    /* JADX INFO: renamed from: lambda$crNKfcD3Lvsemsbjn8MLk7G-69w, reason: not valid java name */
    public static /* synthetic */ d.x m302lambda$crNKfcD3Lvsemsbjn8MLk7G69w(SkillDetailPreviewActivity r0, String r1) {
        return openCurrentSkillInChat$lambda$47(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$eRbvMywY4sRTVf-tZ7eTXup-fMU, reason: not valid java name */
    public static /* synthetic */ d.x m303lambda$eRbvMywY4sRTVftZ7eTXupfMU(com.obric.aiagent.skill.manager.impl.bc r0, SkillDetailPreviewActivity r1, d.h.b.z.f r2, com.obric.aiagent.skill.manager.api.e r3, View r4, int r5) {
        return showDetailMenu$lambda$21$lambda$19(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$fq-_03UTaqwsD6I6Ikynq6wKmE8, reason: not valid java name */
    public static /* synthetic */ com.obric.aiagent.skill.manager.impl.au m304lambda$fq_03UTaqwsD6I6Ikynq6wKmE8(SkillDetailPreviewActivity r0) {
        return coverStore_delegate$lambda$0(r0);
    }

    public static /* synthetic */ d.x lambda$ipNHdgQoHUcrcEyWYQllruUWbEM(SkillDetailPreviewActivity r0, com.obric.aiagent.skill.manager.api.e r1, bb r2, bb r3, String r4, bc r5) {
        return showEditSkillSheet$lambda$31(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ d.x lambda$j4GSXWlyaCW90DC_KacjqnRyx2Q(SkillDetailPreviewActivity r0) {
        return showEditSkillSheet$lambda$29(r0);
    }

    public static /* synthetic */ d.x lambda$oSgNm0EOvFWuCk3svdg4MPbpadI(SkillDetailPreviewActivity r0) {
        return showEditSkillSheet$lambda$30(r0);
    }

    public static /* synthetic */ void lambda$rpq0Eyb2KPUVyZBWAm2gn7ug0OI(d.h.a.b r0, OSwitch r1, View r2) {
        attachSkillEnabledSwitch$lambda$23$lambda$22(r0, r1, r2);
    }

    public static /* synthetic */ void lambda$uZH2NteJYbXfqxnGkU6rHIjPR_8(SkillDetailPreviewActivity r0, View r1) {
        renderError$lambda$57(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$xDrJUnrBpWRISr-UvQOk_OU5hlI, reason: not valid java name */
    public static /* synthetic */ d.x m305lambda$xDrJUnrBpWRISrUvQOk_OU5hlI(d.h.b.z.f r0, SkillDetailPreviewActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3, int r4) {
        return showDetailMenu$lambda$21$lambda$20(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ d.x lambda$xiSFlFHwSmhtnkKLeX2nKpiXJhg(SkillDetailPreviewActivity r0) {
        return showEditSkillSheet$lambda$26(r0);
    }

    private static final void showDeleteConfirmAlertDialog$lambda$39(DialogInterface r1, int r2) {
        DialogInterface r3 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r1, DialogInterface.class, "com.obric.aiagent.plugin");
    }

    public SkillDetailPreviewActivity() {
        this.ioScope = kotlinx.coroutines.an.a(kotlinx.coroutines.bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        this.mainScope = kotlinx.coroutines.an.a();
        this.detailSigningRefreshGate = new ad();
        this.detailSigningProgressStore = new ac();
        this.installProgressRunner = new y(null, 1, null);
        this.currentUsageExamples = d.a.p.b();
        this.currentShopShortDescription = "";
        this.currentStoreDetailDescription = "";
        this.coverStore$delegate = d.g.a(new $$Lambda$SkillDetailPreviewActivity$fq_03UTaqwsD6I6Ikynq6wKmE8(this));
        this.editFilePickerCoordinator$delegate = d.g.a(new $$Lambda$SkillDetailPreviewActivity$BI30RRMRgMIwLpCUTrhE5K27Y6Y(this));
        this.editCoverPickerCoordinator$delegate = d.g.a(new $$Lambda$SkillDetailPreviewActivity$bbMcIixSENndCw9NOg6SlmhECg(this));
        this.shopRepository = new ft();
        this.trackingReporter = new hd(null, null, null, 7, null);
        this.enterPageTracker$delegate = d.g.a(new $$Lambda$SkillDetailPreviewActivity$PCqDwcdLS46jDQSb4khjPZxd9lc(this));
    }

    public static final /* synthetic */ void access$advanceDetailSigningProgress(SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).advanceDetailSigningProgress(r3);
    }

    public static final /* synthetic */ void access$bindSecurityFooter(SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).bindSecurityFooter(r3);
    }

    public static final /* synthetic */ void access$clearDetailSigningProgress(SkillDetailPreviewActivity r2, String r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).clearDetailSigningProgress(r3);
    }

    public static final /* synthetic */ void access$clearPendingDescriptionAlignment(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).clearPendingDescriptionAlignment();
    }

    public static final /* synthetic */ int access$color(SkillDetailPreviewActivity r2, int r3) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).color(r3);
    }

    public static final /* synthetic */ void access$configureAddCta(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).configureAddCta();
    }

    public static final /* synthetic */ void access$configureCta(SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).configureCta(r3);
    }

    public static final /* synthetic */ void access$ensureSkillObserverStarted(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).ensureSkillObserverStarted();
    }

    public static final /* synthetic */ boolean access$finishDetailLoadRequest(SkillDetailPreviewActivity r2, long r3) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).finishDetailLoadRequest(r3);
    }

    public static final /* synthetic */ void access$finishDetailSigningRefreshSession(SkillDetailPreviewActivity r2, c r3, com.obric.aiagent.skill.manager.api.e r4) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).finishDetailSigningRefreshSession(r3, r4);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.impl.au access$getCoverStore(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).getCoverStore();
    }

    public static final /* synthetic */ String access$getCurrentShopShortDescription$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentShopShortDescription;
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.e access$getCurrentSkill$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentSkill;
    }

    public static final /* synthetic */ boolean access$getCurrentSkillInstalled$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentSkillInstalled;
    }

    public static final /* synthetic */ String access$getCurrentSlug$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentSlug;
    }

    public static final /* synthetic */ OBottomActionBarNormalHorizontal access$getDetailBottomBar$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).detailBottomBar;
    }

    public static final /* synthetic */ OProgressButton access$getDetailCta$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).detailCta;
    }

    public static final /* synthetic */ long access$getDetailLoadRequestId$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).detailLoadRequestId;
    }

    public static final /* synthetic */ OPopover access$getDetailMenuPopover$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).detailMenuPopover;
    }

    public static final /* synthetic */ boolean access$getDetailPageVisible$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).detailPageVisible;
    }

    public static final /* synthetic */ ViewGroup access$getDetailScroll$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).detailScroll;
    }

    public static final /* synthetic */ ad access$getDetailSigningRefreshGate$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).detailSigningRefreshGate;
    }

    public static final /* synthetic */ kotlinx.coroutines.ca access$getDetailSigningRefreshJob$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).detailSigningRefreshJob;
    }

    public static final /* synthetic */ v access$getEditCoverPickerCoordinator(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).getEditCoverPickerCoordinator();
    }

    public static final /* synthetic */ y access$getInstallProgressRunner$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).installProgressRunner;
    }

    public static final /* synthetic */ kotlinx.coroutines.am access$getMainScope$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).mainScope;
    }

    public static final /* synthetic */ ft access$getShopRepository$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).shopRepository;
    }

    public static final /* synthetic */ TextView access$getSkillDescription$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).skillDescription;
    }

    public static final /* synthetic */ hd access$getTrackingReporter$p(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).trackingReporter;
    }

    public static final /* synthetic */ void access$handleEditFileFailure(SkillDetailPreviewActivity r2, aj r3, String r4, Throwable r5) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).handleEditFileFailure(r3, r4, r5);
    }

    public static final /* synthetic */ void access$handleEditFileStateChanged(SkillDetailPreviewActivity r2, aj r3, at r4) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).handleEditFileStateChanged(r3, r4);
    }

    public static final /* synthetic */ void access$handleEditFormFileReady(SkillDetailPreviewActivity r2, aj r3, com.obric.aiagent.skill.manager.impl.cb r4) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).handleEditFormFileReady(r3, r4);
    }

    public static final /* synthetic */ void access$initializeSkillPage(SkillDetailPreviewActivity r2, ISkillManagerService r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).initializeSkillPage((ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$logDetailFailure(SkillDetailPreviewActivity r2, String r3, String r4, Throwable r5) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).logDetailFailure(r3, r4, r5);
    }

    public static final /* synthetic */ void access$logDetailInfo(SkillDetailPreviewActivity r2, String r3, String r4) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).logDetailInfo(r3, r4);
    }

    public static final /* synthetic */ void access$logDetailWarning(SkillDetailPreviewActivity r2, String r3, String r4) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).logDetailWarning(r3, r4);
    }

    public static final /* synthetic */ void access$openUsageExample(SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.impl.ui.e r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).openUsageExample(r3);
    }

    public static final /* synthetic */ void access$pauseDetailSigningProgress(SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).pauseDetailSigningProgress(r3);
    }

    public static final /* synthetic */ void access$refreshBottomDividerByContentOverflow(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).refreshBottomDividerByContentOverflow();
    }

    public static final /* synthetic */ void access$renderDetail(SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).renderDetail(r3);
    }

    public static final /* synthetic */ void access$renderError(SkillDetailPreviewActivity r2, String r3, String r4) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).renderError(r3, r4);
    }

    public static final /* synthetic */ void access$renderLoading(SkillDetailPreviewActivity r2, aa r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).renderLoading(r3);
    }

    public static final /* synthetic */ void access$scheduleBottomDividerRefresh(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).scheduleBottomDividerRefresh();
    }

    public static final /* synthetic */ void access$setBottomDividerRefreshPending$p(SkillDetailPreviewActivity r2, boolean r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).bottomDividerRefreshPending = r3;
    }

    public static final /* synthetic */ void access$setCurrentSkill$p(SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentSkill = r3;
    }

    public static final /* synthetic */ void access$setCurrentSkillInstalled$p(SkillDetailPreviewActivity r2, boolean r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentSkillInstalled = r3;
    }

    public static final /* synthetic */ void access$setCurrentSlug$p(SkillDetailPreviewActivity r2, String r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentSlug = r3;
    }

    public static final /* synthetic */ void access$setCurrentStoreDetailDescription$p(SkillDetailPreviewActivity r2, String r3) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentStoreDetailDescription = r3;
    }

    public static final /* synthetic */ void access$setCurrentUsageExamples$p(SkillDetailPreviewActivity r2, List r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        r4.currentUsageExamples = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setDetailSigningRefreshJob$p(SkillDetailPreviewActivity r2, kotlinx.coroutines.ca r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        r4.detailSigningRefreshJob = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setInstallProgressJob$p(SkillDetailPreviewActivity r2, kotlinx.coroutines.ca r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        r4.installProgressJob = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setSecurityCompletedFooterDismissJob$p(SkillDetailPreviewActivity r2, kotlinx.coroutines.ca r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        r4.securityCompletedFooterDismissJob = (kotlinx.coroutines.ca) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$stopDetailSigningRefresh(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).stopDetailSigningRefresh();
    }

    private static final com.obric.aiagent.skill.manager.impl.au coverStore_delegate$lambda$0(SkillDetailPreviewActivity r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        return com.obric.aiagent.skill.manager.impl.au.f19522a.a((Context) ZeusTransformUtils.preCheckCast(r4, Context.class, "com.obric.aiagent.plugin"));
    }

    private final com.obric.aiagent.skill.manager.impl.au getCoverStore() {
        return (com.obric.aiagent.skill.manager.impl.au) ZeusTransformUtils.preCheckCast(this.coverStore$delegate.b(), com.obric.aiagent.skill.manager.impl.au.class, "com.obric.aiagent.plugin");
    }

    private final ai getEditFilePickerCoordinator() {
        return (ai) ZeusTransformUtils.preCheckCast(this.editFilePickerCoordinator$delegate.b(), ai.class, "com.obric.aiagent.plugin");
    }

    private static final ai editFilePickerCoordinator_delegate$lambda$3(SkillDetailPreviewActivity r14) {
        final SkillDetailPreviewActivity r15 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r14, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        return new ai((FragmentActivity) ZeusTransformUtils.preCheckCast(r15, FragmentActivity.class, "com.obric.aiagent.plugin"), r15.ioScope, r15.mainScope, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r15), d.h.a.m.class, "com.obric.aiagent.plugin"), $$Lambda$SkillDetailPreviewActivity$A43JfoXhD_9yAc0szSxWY4tcTwk.INSTANCE, (d.h.a.m) ZeusTransformUtils.preCheckCast(new k(r15), d.h.a.m.class, "com.obric.aiagent.plugin"), (d.h.a.q) ZeusTransformUtils.preCheckCast(new l(r15), d.h.a.q.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillDetailPreviewActivity$O6KA6gBN6dadK7eNegjRdiNF0(r15), null, 256, null);
    }

    private static final d.x editFilePickerCoordinator_delegate$lambda$3$lambda$1(com.obric.aiagent.skill.manager.impl.cf r1) {
        d.h.b.o.e(r1, "draft");
        r1.e();
        return d.x.f38692a;
    }

    private static final com.obric.aiagent.skill.manager.api.e editFilePickerCoordinator_delegate$lambda$3$lambda$2(SkillDetailPreviewActivity r2, aj r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "it");
        return r4.currentSkill;
    }

    private final v getEditCoverPickerCoordinator() {
        return (v) ZeusTransformUtils.preCheckCast(this.editCoverPickerCoordinator$delegate.b(), v.class, "com.obric.aiagent.plugin");
    }

    private static final v editCoverPickerCoordinator_delegate$lambda$7(SkillDetailPreviewActivity r13) {
        final SkillDetailPreviewActivity r14 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r13, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        return new v((FragmentActivity) ZeusTransformUtils.preCheckCast(r14, FragmentActivity.class, "com.obric.aiagent.plugin"), r14.getCoverStore(), r14.ioScope, r14.mainScope, new $$Lambda$SkillDetailPreviewActivity$WYVW6L58W3DIfQP9XHWbibjhcCM(r14), new $$Lambda$SkillDetailPreviewActivity$Ir3azEng9lrpgvmT22RDgEPkhI(r14), new $$Lambda$SkillDetailPreviewActivity$ci4RbTgzTogAckAoqrgK_mMzZY(r14), null, 128, null);
    }

    private static final d.x editCoverPickerCoordinator_delegate$lambda$7$lambda$4(SkillDetailPreviewActivity r2, String r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "coverUrl");
        az r5 = r4.editFormSheetController;
        if (r5 != null) goto L5;
        d.h.b.o.c("editFormSheetController");
        r5 = null;
    L5:
        r5.a(r3);
        return d.x.f38692a;
    }

    private static final d.x editCoverPickerCoordinator_delegate$lambda$7$lambda$5(SkillDetailPreviewActivity r2, Throwable r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "throwable");
        r4.logDetailFailure("Edit skill cover import failed", "Edit skill cover import failed", r3);
        return d.x.f38692a;
    }

    private static final com.obric.aiagent.skill.manager.api.e editCoverPickerCoordinator_delegate$lambda$7$lambda$6(SkillDetailPreviewActivity r2) {
        return ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).currentSkill;
    }

    private final ag getEnterPageTracker() {
        return (ag) ZeusTransformUtils.preCheckCast(this.enterPageTracker$delegate.b(), ag.class, "com.obric.aiagent.plugin");
    }

    private static final ag enterPageTracker_delegate$lambda$9(SkillDetailPreviewActivity r7) {
        final SkillDetailPreviewActivity r8 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r7, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        return new ag(new $$Lambda$SkillDetailPreviewActivity$UXW_vJZvrUoB61BoUP_ekRQ04(r8), null, null, 6, null);
    }

    private static final bp enterPageTracker_delegate$lambda$9$lambda$8(SkillDetailPreviewActivity r2) {
        Intent r3 = ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).getIntent();
        d.h.b.o.c(r3, "getIntent(...)");
        return bo.a(r3, dr.f19762c);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        configureSystemBars();
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_skill_detail_preview, "layout", "activity_skill_detail_preview"));
        installSkillPageGuard(ZeusTransformUtils.mapRes(R.id.skill_detail_preview_root, DbHelper.COL_ID, "skill_detail_preview_root"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new o(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity
    public OFloatingTitleBar getFloatingTitleBar() {
        OFloatingTitleBar r1 = this.detailTitleBar;
        if (r1 == null) goto L7;
        if (r1 != null) goto L8;
        d.h.b.o.c("detailTitleBar");
        goto L7
    L8:
        return r1;
    L7:
        return null;
    }

    private final void initializeSkillPage(ISkillManagerService r6) {
        ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r6, ISkillManagerService.class, "com.obric.aiagent.plugin");
        this.skillManager = r7;
        this.editFormSheetController = new az((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), this.trackingReporter);
        this.currentSlug = getIntent().getStringExtra(EXTRA_SLUG);
        String r0 = getIntent().getStringExtra(EXTRA_SHORT_DESCRIPTION);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        this.currentShopShortDescription = r0;
        String r1 = this.currentSlug;
        com.obric.aiagent.skill.manager.api.e r2 = null;
        Object r3 = null;
        if (r1 == null) goto L17;
        List r8 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r7.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L10;
        r8 = d.a.p.b();
    L10:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L12:
        if (r9.hasNext() == false) goto L16;
        Object r4 = r9.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r4, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r1) == false) goto L12;
        r3 = r4;
    L16:
        r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
    L17:
        boolean r10 = true;
        if (r2 == null) goto L20;
        boolean r5 = true;
    L21:
        this.currentSkillInstalled = r5;
        if (r2 != null) goto L25;
        r10 = false;
    L25:
        bindViews(r10);
        configureStaticViews();
        refreshSkillDetail(r2);
        return;
    L20:
        r5 = false;
        goto L21
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        this.detailPageVisible = true;
        com.obric.aiagent.skill.manager.api.e r0 = this.currentSkill;
        if (r0 == null) goto L9;
        reconcileDetailSigningProgress(r0);
        bindSecurityFooter(r0);
        scheduleDetailSigningRefresh(r0);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStop() {
        if (isSkillPageContentInitialized() == false) goto L5;
        this.detailPageVisible = false;
        clearTransientSecurityFooter();
        finishDetailSigningRefreshSession(c.f, this.currentSkill);
        stopDetailSigningRefresh();
        this.detailSigningRefreshSession = null;
        this.detailSigningRefreshAttempted = false;
    L5:
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        if (isSkillPageContentInitialized() == false) goto L8;
        clearPendingDescriptionAlignment();
        getEditCoverPickerCoordinator().c();
        getEditFilePickerCoordinator().a();
        az r0 = this.editFormSheetController;
        if (r0 != null) goto L7;
        d.h.b.o.c("editFormSheetController");
        r0 = null;
    L7:
        r0.a();
    L8:
        kotlinx.coroutines.ca r1 = this.stateObserveJob;
        if (r1 == null) goto L11;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L11:
        kotlinx.coroutines.ca r2 = this.refreshDetailJob;
        if (r2 == null) goto L15;
        kotlinx.coroutines.ca.a.a(r2, null, 1, null);
    L15:
        if (isSkillPageContentInitialized() == false) goto L17;
        finishDetailSigningRefreshSession(c.f, this.currentSkill);
        clearTransientSecurityFooter();
        stopDetailSigningRefresh();
        this.detailSigningRefreshSession = null;
    L17:
        kotlinx.coroutines.ca r3 = this.installProgressJob;
        if (r3 == null) goto L20;
        kotlinx.coroutines.ca.a.a(r3, null, 1, null);
    L20:
        OPopover r4 = this.detailMenuPopover;
        if (r4 == null) goto L23;
        r4.dismiss();
    L23:
        kotlinx.coroutines.an.a(this.ioScope, null, 1, null);
        kotlinx.coroutines.an.a(this.mainScope, null, 1, null);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        getEnterPageTracker().a();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        if (isSkillPageContentInitialized() == true) goto L8;
        return;
    L8:
        if (getEditCoverPickerCoordinator().a(r2, r3, r4) == false) goto L10;
        return;
    L10:
        getEditFilePickerCoordinator().a(r2, r3, r4);
    }

    private final void bindViews(boolean r9) {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.detail_page, DbHelper.COL_ID, "detail_page"));
        d.h.b.o.c(r0, "findViewById(...)");
        this.detailPage = r0;
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.detail_scroll, DbHelper.COL_ID, "detail_scroll"));
        d.h.b.o.c(r1, "findViewById(...)");
        this.detailScroll = (ViewGroup) ZeusTransformUtils.preCheckCast(r1, ViewGroup.class, "com.obric.aiagent.plugin");
        View r2 = findViewById(ZeusTransformUtils.mapRes(R.id.detail_title_bar, DbHelper.COL_ID, "detail_title_bar"));
        d.h.b.o.c(r2, "findViewById(...)");
        this.detailTitleBar = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r2, OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.detail_loading_status, DbHelper.COL_ID, "detail_loading_status"));
        d.h.b.o.c(r3, "findViewById(...)");
        this.detailLoadingStatus = (OPageStatus) ZeusTransformUtils.preCheckCast(r3, OPageStatus.class, "com.obric.aiagent.plugin");
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_header, DbHelper.COL_ID, "skill_header"));
        d.h.b.o.c(r4, "findViewById(...)");
        this.skillHeader = (HeaderInfoView) ZeusTransformUtils.preCheckCast(r4, HeaderInfoView.class, "com.obric.aiagent.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_icon, DbHelper.COL_ID, "skill_icon"));
        d.h.b.o.c(r5, "findViewById(...)");
        this.skillIcon = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r5, SimpleDraweeView.class, "com.obric.aiagent.plugin");
        View r6 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_description, DbHelper.COL_ID, "skill_description"));
        d.h.b.o.c(r6, "findViewById(...)");
        this.skillDescription = (TextView) ZeusTransformUtils.preCheckCast(r6, TextView.class, "com.obric.aiagent.plugin");
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_description_markdown, DbHelper.COL_ID, "skill_description_markdown"));
        d.h.b.o.c(r7, "findViewById(...)");
        this.skillDescriptionMarkdown = (SkillDescriptionMarkdownView) ZeusTransformUtils.preCheckCast(r7, SkillDescriptionMarkdownView.class, "com.obric.aiagent.plugin");
        View r8 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_related_info, DbHelper.COL_ID, "skill_related_info"));
        d.h.b.o.c(r8, "findViewById(...)");
        this.skillRelatedInfo = (TextView) ZeusTransformUtils.preCheckCast(r8, TextView.class, "com.obric.aiagent.plugin");
        View r10 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_security_info, DbHelper.COL_ID, "skill_security_info"));
        d.h.b.o.c(r10, "findViewById(...)");
        this.skillSecurityInfo = (TextView) ZeusTransformUtils.preCheckCast(r10, TextView.class, "com.obric.aiagent.plugin");
        View r11 = findViewById(ZeusTransformUtils.mapRes(R.id.example_section_title, DbHelper.COL_ID, "example_section_title"));
        d.h.b.o.c(r11, "findViewById(...)");
        this.exampleSectionTitle = r11;
        View r12 = findViewById(ZeusTransformUtils.mapRes(R.id.example_list, DbHelper.COL_ID, "example_list"));
        d.h.b.o.c(r12, "findViewById(...)");
        this.exampleList = (ViewGroup) ZeusTransformUtils.preCheckCast(r12, ViewGroup.class, "com.obric.aiagent.plugin");
        View r13 = findViewById(ZeusTransformUtils.mapRes(R.id.detail_bottom_bar, DbHelper.COL_ID, "detail_bottom_bar"));
        d.h.b.o.c(r13, "findViewById(...)");
        this.detailBottomBar = (OBottomActionBarNormalHorizontal) ZeusTransformUtils.preCheckCast(r13, OBottomActionBarNormalHorizontal.class, "com.obric.aiagent.plugin");
        this.detailMore = findViewById(ZeusTransformUtils.mapRes(R.id.detail_more, DbHelper.COL_ID, "detail_more"));
        OFloatingTitleBar r14 = this.detailTitleBar;
        OFloatingTitleBar r15 = null;
        if (r14 != null) goto L5;
        d.h.b.o.c("detailTitleBar");
        r14 = null;
    L5:
        r14.addStartAction(ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$SkillDetailPreviewActivity$O0WU888KNYhbK39xq5TLrT9VCwE(this)).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_back, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_back")), CharSequence.class, "com.obric.aiagent.plugin"));
        if (r9 == false) goto L8;
        setDetailMenuVisible(true, false);
    L8:
        OFloatingTitleBar r16 = this.detailTitleBar;
        if (r16 != null) goto L11;
        d.h.b.o.c("detailTitleBar");
    L12:
        r15.setFloatingTransitionEnabled(true);
        return;
    L11:
        r15 = r16;
        goto L12
    }

    private static final void bindViews$lambda$13(SkillDetailPreviewActivity r1, View r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void configureStaticViews() {
        OPageStatus r0 = this.detailLoadingStatus;
        ViewGroup r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("detailLoadingStatus");
        r0 = null;
    L5:
        r0.setType(1);
        OPageStatus r1 = this.detailLoadingStatus;
        if (r1 != null) goto L8;
        d.h.b.o.c("detailLoadingStatus");
        r1 = null;
    L8:
        ODownloadProgressView r3 = r1.getLoadingView();
        if (r3 == null) goto L11;
        r3.setProcessingColor(color(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")));
    L11:
        OPageStatus r4 = this.detailLoadingStatus;
        if (r4 != null) goto L14;
        d.h.b.o.c("detailLoadingStatus");
        r4 = null;
    L14:
        r4.showLoading(true);
        com.obric.aiagent.skill.manager.impl.ui.s r5 = com.obric.aiagent.skill.manager.impl.ui.s.f20812a;
        SimpleDraweeView r6 = this.skillIcon;
        if (r6 != null) goto L17;
        d.h.b.o.c("skillIcon");
        SimpleDraweeView r7 = null;
    L18:
        com.obric.aiagent.skill.manager.impl.ui.s.a(r5, r7, null, 20.0f, true, null, 16, null);
        SkillDescriptionMarkdownView r8 = this.skillDescriptionMarkdown;
        if (r8 != null) goto L21;
        d.h.b.o.c("skillDescriptionMarkdown");
        r8 = null;
    L21:
        r8.setOnContentHeightChanged$impl_release((d.h.a.a) ZeusTransformUtils.preCheckCast(new h(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
        configureBottomActionBar();
        OBottomActionBarNormalHorizontal r9 = this.detailBottomBar;
        if (r9 != null) goto L24;
        d.h.b.o.c("detailBottomBar");
        r9 = null;
    L24:
        r9.showDivider(false);
        ViewGroup r10 = this.detailScroll;
        if (r10 != null) goto L27;
        d.h.b.o.c("detailScroll");
    L28:
        r2.addOnLayoutChangeListener(new $$Lambda$SkillDetailPreviewActivity$FdFkqeYd2p5iDqu9mEK_uqSUdw0(this));
        return;
    L27:
        r2 = r10;
        goto L28
    L17:
        r7 = r6;
        goto L18
    }

    private static final void configureStaticViews$lambda$14(SkillDetailPreviewActivity r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r0, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).scheduleBottomDividerRefresh();
    }

    private final void configureBottomActionBar() {
        this.detailCta = (OProgressButton) ZeusTransformUtils.preCheckCast(com.obric.oui.d.e.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), ZeusTransformUtils.mapRes(R.style.SkillDetailProgressButton, "style", "SkillDetailProgressButton"), $$Lambda$SkillDetailPreviewActivity$DmDla65WTl8kBNvhKgJrEYsruF8.INSTANCE), OProgressButton.class, "com.obric.aiagent.plugin");
        OBottomActionBarNormalHorizontal r0 = this.detailBottomBar;
        OProgressButton r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("detailBottomBar");
        r0 = null;
    L5:
        OProgressButton r5 = this.detailCta;
        if (r5 != null) goto L8;
        d.h.b.o.c("detailCta");
    L9:
        r0.setButtons(d.a.p.a(r1));
        return;
    L8:
        r1 = r5;
        goto L9
    }

    private static final OProgressButton configureBottomActionBar$lambda$16(Context r6, int r7, int r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "styledContext");
        OProgressButton r9 = new OProgressButton(r1, null, 0, 4, null);
        r9.setId(ZeusTransformUtils.mapRes(R.id.detail_cta, DbHelper.COL_ID, "detail_cta"));
        r9.setLayoutParams(new ViewGroup.LayoutParams(-1, r8));
        r9.setAllCaps(false);
        return r9;
    }

    /* JADX WARN: Type inference failed for: r1v10, types: [T, com.obric.oui.popover.v2.OPopover] */
    /* JADX WARN: Type inference failed for: r1v2, types: [T, com.obric.oui.oswitch.OSwitch] */
    private final void showDetailMenu() {
        final com.obric.aiagent.skill.manager.api.e r1 = this.currentSkill;
        if (r1 != null) goto L6;
        return;
    L6:
        if (shouldShowDetailMenu(r1) == true) goto L8;
        return;
    L8:
        View r5 = this.detailMore;
        if (r5 != null) goto L11;
        return;
    L11:
        OPopover r2 = this.detailMenuPopover;
        if (r2 == null) goto L14;
        r2.dismiss();
    L14:
        final d.h.b.z.f r3 = new d.h.b.z.f();
        final d.h.b.z.f r4 = new d.h.b.z.f();
        final d.h.a.b<? super Boolean, d.x> r6 = new $$Lambda$SkillDetailPreviewActivity$WqTPTzS1AboQaaM4foU85uIO8(this, r4, r1);
        final com.obric.aiagent.skill.manager.impl.bc r7 = com.obric.aiagent.skill.manager.impl.az.c(r1, this.currentSkillInstalled);
        if (r7.a() == true) goto L17;
    L19:
        boolean r8 = false;
    L20:
        OPopoverEntranceMenuView.a r15 = new OPopoverEntranceMenuView.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        r15.a(OPopoverEntranceMenuView.e.f36017a);
        r15.a(true);
        OPopoverEntranceMenuView.a.a(r15, null, null, null, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_use_skill, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_use_skill")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$SkillDetailPreviewActivity$5IQV4jYUhdz_DJGojZoCmT_Vp6k(r6, this, r1), 247, null);
        if (r8 == false) goto L23;
    L24:
        r15.c();
    L25:
        if (r8 == false) goto L27;
        String r24 = "com.obric.aiagent.plugin";
        OPopoverEntranceMenuView.a.a(r15, null, null, null, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_edit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_edit")), CharSequence.class, "com.obric.aiagent.plugin"), null, null, false, null, new $$Lambda$SkillDetailPreviewActivity$eRbvMywY4sRTVftZ7eTXupfMU(r7, this, r3, r1), 247, null);
    L29:
        if (r7.c() == false) goto L31;
        String r16 = r24;
        String r25 = r16;
        OPopoverEntranceMenuView.a.a(r15, null, null, null, (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_remove_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_remove_action")), CharSequence.class, r16), null, null, true, null, new $$Lambda$SkillDetailPreviewActivity$xDrJUnrBpWRISrUvQOk_OU5hlI(r3, this, r1), 183, null);
    L32:
        OPopoverEntranceMenuView r9 = r15.d();
        r4.f38504a = attachSkillEnabledSwitch(r9, r1.l(), r6);
        if (r8 == true) goto L35;
    L39:
        String r10 = r25;
        r3.f38504a = ((OPopover.a) ZeusTransformUtils.preCheckCast(((OPopover.a) ZeusTransformUtils.preCheckCast(new OPopover.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, r10)).a((View) ZeusTransformUtils.preCheckCast(r9, View.class, r10)), OPopover.a.class, r10)).b(false), OPopover.a.class, r10)).G();
        this.detailMenuPopover = (OPopover) ZeusTransformUtils.preCheckCast(r3.f38504a, OPopover.class, r10);
        com.obric.oui.popover.v2.d.a(com.obric.oui.popover.v2.d.f36067a, (OPopover) ZeusTransformUtils.preCheckCast(r3.f38504a, OPopover.class, r10), r5, 85, true, 0, false, 0, 0, 240, null);
        return;
    L35:
        if (r7.b() == true) goto L39;
        PopoverMenuLinearLayout r11 = r9.getItemView(1);
        if (r11 == null) goto L39;
        r11.setAlpha(0.3f);
        goto L39
    L31:
        r25 = r24;
        goto L32
    L27:
        r24 = "com.obric.aiagent.plugin";
        goto L29
    L23:
        if (r7.c() == false) goto L25;
    L17:
        if (com.obric.aiagent.skill.manager.impl.bs.a(com.obric.aiagent.skill.manager.impl.bs.f19588a, null, 1, null) == false) goto L19;
        r8 = true;
        goto L20
    }

    private static final d.x showDetailMenu$lambda$17(SkillDetailPreviewActivity r2, d.h.b.z.f r3, com.obric.aiagent.skill.manager.api.e r4, boolean r5) {
        SkillDetailPreviewActivity r6 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        r6.updateSkillEnabledFromMenu(r5);
        OSwitch r7 = (OSwitch) ZeusTransformUtils.preCheckCast(r3.f38504a, OSwitch.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L10;
        com.obric.aiagent.skill.manager.api.e r8 = r6.currentSkill;
        if (r8 == null) goto L7;
        boolean r9 = r8.l();
    L8:
        r7.setChecked(r9);
        goto L10
    L7:
        r9 = r4.l();
    L10:
        return d.x.f38692a;
    }

    private static final d.x showDetailMenu$lambda$21$lambda$18(d.h.a.b r1, SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.api.e r3, View r4, int r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin");
        SkillDetailPreviewActivity r7 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<unused var>");
        com.obric.aiagent.skill.manager.api.e r8 = r7.currentSkill;
        if (r8 == null) goto L5;
        boolean r9 = r8.l();
    L6:
        r6.invoke(Boolean.valueOf(!r9));
        return d.x.f38692a;
    L5:
        r9 = r3.l();
        goto L6
    }

    private static final d.x showDetailMenu$lambda$21$lambda$19(com.obric.aiagent.skill.manager.impl.bc r1, SkillDetailPreviewActivity r2, d.h.b.z.f r3, com.obric.aiagent.skill.manager.api.e r4, View r5, int r6) {
        SkillDetailPreviewActivity r7 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<unused var>");
        if (r1.b() == true) goto L6;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r7, Activity.class, "com.obric.aiagent.plugin"), cm.a.l);
        return d.x.f38692a;
    L6:
        OPopover r8 = (OPopover) ZeusTransformUtils.preCheckCast(r3.f38504a, OPopover.class, "com.obric.aiagent.plugin");
        if (r8 == null) goto L9;
        r8.dismiss();
    L9:
        r7.showEditSkillSheet(r4);
        return d.x.f38692a;
    }

    private static final d.x showDetailMenu$lambda$21$lambda$20(d.h.b.z.f r1, SkillDetailPreviewActivity r2, com.obric.aiagent.skill.manager.api.e r3, View r4, int r5) {
        SkillDetailPreviewActivity r6 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<unused var>");
        OPopover r7 = (OPopover) ZeusTransformUtils.preCheckCast(r1.f38504a, OPopover.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L5;
        r7.dismiss();
    L5:
        r6.showDeleteConfirmDialog(r3);
        return d.x.f38692a;
    }

    private final OSwitch attachSkillEnabledSwitch(OPopoverEntranceMenuView r9, boolean r10, d.h.a.b<? super Boolean, d.x> r11) {
        final d.h.a.b r12 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r11, d.h.a.b.class, "com.obric.aiagent.plugin");
        PopoverMenuLinearLayout r13 = r9.getItemView(0);
        if (r13 != null) goto L5;
        return null;
    L5:
        LinearLayout r14 = (LinearLayout) ZeusTransformUtils.preCheckCast(r13.findViewById(ZeusTransformUtils.mapRes(R.id.item_container, DbHelper.COL_ID, "item_container")), LinearLayout.class, "com.obric.aiagent.plugin");
        if (r14 != null) goto L8;
        return null;
    L8:
        final OSwitch r0 = new OSwitch((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), null, 0, 6, null);
        r0.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_use_skill, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_use_skill")), CharSequence.class, "com.obric.aiagent.plugin"));
        r0.setCheckedNoAnim(r10);
        r0.setOnClickListener(new $$Lambda$SkillDetailPreviewActivity$rpq0Eyb2KPUVyZBWAm2gn7ug0OI(r12, r0));
        FrameLayout r15 = new FrameLayout((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        r15.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(dp(52), -2), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r15.addView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new FrameLayout.LayoutParams(-2, -2, 17), ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r14.addView((View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.aiagent.plugin"));
        return r0;
    }

    private static final void attachSkillEnabledSwitch$lambda$23$lambda$22(d.h.a.b r1, OSwitch r2, View r3) {
        ((d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r1, d.h.a.b.class, "com.obric.aiagent.plugin")).invoke(Boolean.valueOf(r2.isChecked()));
    }

    private final void showEditSkillSheet(final com.obric.aiagent.skill.manager.api.e r23) {
        di r2 = com.obric.aiagent.skill.manager.impl.bg.a(currentSecurityState(r23));
        if (r2 == null) goto L11;
        cm r1 = cm.f20758a;
        Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin");
        if (r2 != di.f19744b) goto L7;
        cm.a r3 = cm.a.l;
    L8:
        r1.a(r0, r3);
        return;
    L7:
        r3 = cm.a.m;
        goto L8
    L11:
        if (com.obric.aiagent.skill.manager.impl.az.b(r23, this.currentSkillInstalled) == true) goto L13;
        return;
    L13:
        boolean r14 = com.obric.aiagent.skill.manager.impl.az.a(r23, this.currentSkillInstalled);
        d r4 = buildEditDraft(r23);
        final bb r7 = new bb(r4.a(), r4.b(), r4.c());
        az r5 = this.editFormSheetController;
        if (r5 != null) goto L16;
        d.h.b.o.c("editFormSheetController");
        r5 = null;
    L16:
        ax r6 = ax.f20584c;
        String r8 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_edit_skill, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_edit_skill"));
        d.h.b.o.c(r8, "getString(...)");
        ao r9 = ao.f20546a.a();
        am r10 = new am(r23.f(), true, new $$Lambda$SkillDetailPreviewActivity$xiSFlFHwSmhtnkKLeX2nKpiXJhg(this));
        bd r11 = bd.f20630a.c();
        if (r14 == false) goto L19;
        as r12 = (as) ZeusTransformUtils.preCheckCast(new as.b(aq.f20554b, av.f20577b, (at) ZeusTransformUtils.preCheckCast(at.b.f20570a, at.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillDetailPreviewActivity$CHZcLo9KaLKLnbkWDsV2gmERpk(this), new $$Lambda$SkillDetailPreviewActivity$aRecUrgjz3urunMTy1jakWKO1fE(this)), as.class, "com.obric.aiagent.plugin");
    L20:
        as r13 = r12;
        if (r14 == false) goto L23;
        ap r15 = ap.f20549a;
    L24:
        r5.a(new ay(r6, r8, r7, r9, null, r10, r11, r13, r15, r14, new $$Lambda$SkillDetailPreviewActivity$j4GSXWlyaCW90DC_KacjqnRyx2Q(this), new $$Lambda$SkillDetailPreviewActivity$oSgNm0EOvFWuCk3svdg4MPbpadI(this), new $$Lambda$SkillDetailPreviewActivity$ipNHdgQoHUcrcEyWYQllruUWbEM(this, r23, r7), 16, null));
        return;
    L23:
        r15 = ap.f20550b;
        goto L24
    L19:
        r12 = (as) ZeusTransformUtils.preCheckCast(as.a.f20562a, as.class, "com.obric.aiagent.plugin");
        goto L20
    }

    private static final d.x showEditSkillSheet$lambda$26(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).getEditCoverPickerCoordinator().a();
        return d.x.f38692a;
    }

    private static final d.x showEditSkillSheet$lambda$27(SkillDetailPreviewActivity r3) {
        ai.a(((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).getEditFilePickerCoordinator(), aj.f20531d, null, 2, null);
        return d.x.f38692a;
    }

    private static final d.x showEditSkillSheet$lambda$28(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).getEditFilePickerCoordinator().a(aj.f20531d);
        return d.x.f38692a;
    }

    private static final d.x showEditSkillSheet$lambda$29(SkillDetailPreviewActivity r2) {
        SkillDetailPreviewActivity r3 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        r3.getEditCoverPickerCoordinator().b();
        r3.getEditFilePickerCoordinator().a(aj.f20531d);
        return d.x.f38692a;
    }

    private static final d.x showEditSkillSheet$lambda$30(SkillDetailPreviewActivity r2) {
        SkillDetailPreviewActivity r3 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        r3.getEditCoverPickerCoordinator().c();
        r3.getEditFilePickerCoordinator().a(aj.f20531d);
        return d.x.f38692a;
    }

    private static final d.x showEditSkillSheet$lambda$31(SkillDetailPreviewActivity r8, com.obric.aiagent.skill.manager.api.e r9, bb r10, bb r11, String r12, bc r13) {
        SkillDetailPreviewActivity r2 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r8, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r13, bc.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r11, "values");
        d.h.b.o.e(r12, "coverUrl");
        d.h.b.o.e(r7, "submission");
        r2.submitEditSkillSheet(r9, r10, r11, r12, r7);
        return d.x.f38692a;
    }

    private final void handleEditFileStateChanged(aj r2, at r3) {
        if (r2 != aj.f20531d) goto L9;
        az r1 = this.editFormSheetController;
        if (r1 != null) goto L7;
        d.h.b.o.c("editFormSheetController");
        r1 = null;
    L7:
        r1.a(r3);
        return;
    }

    private final void handleEditFormFileReady(final aj r3, final com.obric.aiagent.skill.manager.impl.cb r4) {
        if (r3 == aj.f20531d) goto L5;
        return;
    L5:
        az r0 = this.editFormSheetController;
        if (r0 != null) goto L8;
        d.h.b.o.c("editFormSheetController");
        r0 = null;
    L8:
        r0.a(r4, new $$Lambda$SkillDetailPreviewActivity$B_tdSPNPlTI0f_ltLliYx5mJfAU(this, r3, r4));
    }

    private static final d.x handleEditFormFileReady$lambda$32(SkillDetailPreviewActivity r2, aj r3, com.obric.aiagent.skill.manager.impl.cb r4, Throwable r5) {
        SkillDetailPreviewActivity r6 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "throwable");
        r6.handleEditFileFailure(r3, r4.a(), r5);
        return d.x.f38692a;
    }

    private final void handleEditFileFailure(aj r2, String r3, Throwable r4) {
        if (r2 == aj.f20531d) goto L5;
        return;
    L5:
        logDetailFailure("Edit skill file parse failed", "Edit skill file parse failed: fileName=" + r3, r4);
    }

    private final void submitEditSkillSheet(com.obric.aiagent.skill.manager.api.e r15, bb r16, bb r17, String r18, bc r19) {
        bc r7 = (bc) ZeusTransformUtils.wrapperContextForParams(r19, bc.class, "com.obric.aiagent.plugin");
        ISkillManagerService r6 = this.skillManager;
        if (r6 != null) goto L6;
        SkillDetailPreviewActivity r0 = (SkillDetailPreviewActivity) ZeusTransformUtils.preCheckCast(this, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        r7.f();
        r0.logDetailWarning("Edit skill save failed: manager unavailable", "Edit skill save failed: skill manager unavailable, slug=" + r15.a());
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r0, Activity.class, "com.obric.aiagent.plugin"), cm.a.f20762c);
        return;
    L6:
        kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new s(this, r18, r15, r16, r17, r6, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final d buildEditDraft(com.obric.aiagent.skill.manager.api.e r6) {
        String r0 = com.obric.aiagent.skill.manager.impl.az.d(r6);
        String r1 = r6.c();
        String r2 = toEditableSkillBody(r6.k());
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L9;
        r2 = fallbackSkillBody(r6);
    L9:
        return new d(r0, r1, r2);
    }

    private final String toEditableSkillBody(String r4) {
        if (d.o.o.b(r4, SKILL_MD_FRONTMATTER_MARKER, false, 2, null) == true) goto L8;
        return r4;
    L8:
        return db.a(db.f19721a, r4, 0, 2, null).c();
    L10:
        return r4;
    }

    private final String fallbackSkillBody(com.obric.aiagent.skill.manager.api.e r8) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.d(r8), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r0) == false) goto L8;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r1) == false) goto L7;
        r1 = "Untitled";
    L7:
        r0 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin");
    L8:
        Object r2 = (String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.aiagent.plugin");
        String r3 = toEditableSkillBody(r8.k());
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L12;
        r3 = null;
    L12:
        if (r3 != null) goto L18;
        int r4 = ZeusTransformUtils.mapRes(R.string.obric_skill_detail_default_markdown, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_default_markdown");
        Object[] r5 = new Object[2];
        r5[0] = r2;
        CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r8.c(), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r9) == false) goto L16;
        r9 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_default_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_default_description"));
        d.h.b.o.c(r9, "getString(...)");
    L16:
        r5[1] = r9;
        String r6 = getString(r4, r5);
        d.h.b.o.c(r6, "getString(...)");
        return r6;
    L18:
        return r3;
    }

    private final void updateSkillEnabledFromMenu(boolean r4) {
        com.obric.aiagent.skill.manager.api.e r0 = this.currentSkill;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.currentSkillInstalled == true) goto L9;
        return;
    L9:
        if (d.h.b.o.a(r0.a(), this.currentSlug) == true) goto L12;
        return;
    L12:
        if (r0.l() != r4) goto L14;
        return;
    L14:
        setCurrentSkillEnabled(r4);
    }

    private final void showDeleteConfirmDialog(com.obric.aiagent.skill.manager.api.e r2) {
        if (this.currentSkillInstalled == true) goto L6;
        return;
    L6:
        if (r2.m() == true) goto L8;
        return;
    L8:
        showDeleteConfirmAlertDialog(r2);
    }

    private final void showDeleteConfirmAlertDialog(final com.obric.aiagent.skill.manager.api.e r19) {
        if (ZeusTransformUtils.instanceOf(r19.g(), com.obric.aiagent.skill.manager.api.aq.b.class) == false) goto L5;
        int r1 = ZeusTransformUtils.mapRes(R.string.obric_skill_detail_remove_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_remove_message");
    L6:
        com.obric.oui.dialog.v2.alert.a r6 = com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_remove_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_remove_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).b((CharSequence) ZeusTransformUtils.preCheckCast(getString(r1), CharSequence.class, "com.obric.aiagent.plugin")).a(true);
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_cancel"));
        d.h.b.o.c(r2, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r12 = com.obric.oui.dialog.v2.alert.a.b(r6, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), $$Lambda$SkillDetailPreviewActivity$JMrlSBskePwzIM0B4VyUWvvyZ78.INSTANCE, null, 4, null);
        String r3 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_remove_action, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_remove_action"));
        d.h.b.o.c(r3, "getString(...)");
        ((OAlertDialog) ZeusTransformUtils.preCheckCast(com.obric.oui.dialog.v2.alert.a.a(r12, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillDetailPreviewActivity$6r7iTj7YVEtWHe0QubjGLYMV7Mw(this, r19), null, 4, null).b(true).g(), OAlertDialog.class, "com.obric.aiagent.plugin")).show();
        return;
    L5:
        r1 = ZeusTransformUtils.mapRes(R.string.obric_skill_detail_remove_non_created_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_remove_non_created_message");
        goto L6
    }

    private static final void showDeleteConfirmAlertDialog$lambda$40(SkillDetailPreviewActivity r1, com.obric.aiagent.skill.manager.api.e r2, DialogInterface r3, int r4) {
        SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        DialogInterface r6 = (DialogInterface) ZeusTransformUtils.wrapperContextForParams(r3, DialogInterface.class, "com.obric.aiagent.plugin");
        r5.deleteCurrentSkill(r2);
    }

    private final void refreshSkillDetail(com.obric.aiagent.skill.manager.api.e r16) {
        View r0 = this.detailPage;
        if (r0 != null) goto L5;
        d.h.b.o.c("detailPage");
        r0 = null;
    L5:
        boolean r2 = false;
        r0.setVisibility(0);
        String r3 = this.currentSlug;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L8;
    L9:
        r2 = true;
    L11:
        if (r2 == false) goto L14;
        String r4 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_temporarily_unavailable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_temporarily_unavailable"));
        d.h.b.o.c(r4, "getString(...)");
        String r5 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_retry_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_retry_message"));
        d.h.b.o.c(r5, "getString(...)");
        renderError(r4, r5);
        return;
    L14:
        ISkillManagerService r6 = this.skillManager;
        if (r6 != null) goto L18;
        String r7 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_temporarily_unavailable, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_temporarily_unavailable"));
        d.h.b.o.c(r7, "getString(...)");
        String r8 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_retry_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_retry_message"));
        d.h.b.o.c(r8, "getString(...)");
        renderError(r7, r8);
        return;
    L18:
        kotlinx.coroutines.ca r9 = this.refreshDetailJob;
        if (r9 == null) goto L21;
        kotlinx.coroutines.ca.a.a(r9, null, 1, null);
    L21:
        long r10 = 1 + this.detailLoadRequestId;
        this.detailLoadRequestId = r10;
        renderLoading(aa.f20483a);
        this.refreshDetailJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(this, r6, r3, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L8:
        if (r1.length() != 0) goto L11;
        goto L9
    }

    private final boolean finishDetailLoadRequest(long r3) {
        long r0 = this.detailLoadRequestId;
        if (r3 == r0) goto L6;
        return false;
    L6:
        this.detailLoadRequestId = r0 + 1;
        return true;
    }

    private final void renderDetail(com.obric.aiagent.skill.manager.api.e r14) {
        setDetailBodyVisible(true);
        this.contentOverflowDividerEnabled = true;
        TextView r3 = null;
        setDetailMenuVisible$default(this, shouldShowDetailMenu(r14), false, 2, null);
        if (d.h.b.o.a(r14.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L12;
        com.obric.aiagent.skill.manager.impl.ui.a r0 = com.obric.aiagent.skill.manager.impl.ui.a.f20482a;
        SimpleDraweeView r2 = this.skillIcon;
        if (r2 != null) goto L7;
        d.h.b.o.c("skillIcon");
        r2 = null;
    L7:
        com.obric.aiagent.skill.manager.api.a r1 = r14.h();
        if (r1 == null) goto L10;
        String r4 = r1.a();
    L11:
        r0.a(r2, r4, 20.0f);
    L17:
        HeaderInfoView r5 = this.skillHeader;
        if (r5 != null) goto L20;
        d.h.b.o.c("skillHeader");
        r5 = null;
    L20:
        r5.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(valueOrDash(com.obric.aiagent.skill.manager.impl.az.d(r14)), CharSequence.class, "com.obric.aiagent.plugin"));
        bindMetadata(r14);
        if (ZeusTransformUtils.instanceOf(r14.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == false) goto L23;
        String r6 = this.currentStoreDetailDescription;
    L24:
        renderDescription(r14, r6);
        TextView r7 = this.skillRelatedInfo;
        if (r7 != null) goto L27;
        d.h.b.o.c("skillRelatedInfo");
        r7 = null;
    L27:
        r7.setVisibility(8);
        TextView r8 = this.skillSecurityInfo;
        if (r8 != null) goto L30;
        d.h.b.o.c("skillSecurityInfo");
    L31:
        r3.setVisibility(8);
        bindExamples(this.currentUsageExamples);
        reconcileDetailSigningProgress(r14);
        bindSecurityFooter(r14);
        configureCta(r14);
        scheduleDetailSigningRefresh(r14);
        scheduleBottomDividerRefresh();
        return;
    L30:
        r3 = r8;
        goto L31
    L23:
        r6 = r14.c();
        goto L24
    L10:
        r4 = null;
        goto L11
    L12:
        com.obric.aiagent.skill.manager.impl.ui.s r9 = com.obric.aiagent.skill.manager.impl.ui.s.f20812a;
        SimpleDraweeView r10 = this.skillIcon;
        if (r10 != null) goto L15;
        d.h.b.o.c("skillIcon");
        SimpleDraweeView r11 = null;
    L16:
        com.obric.aiagent.skill.manager.impl.ui.s.a(r9, r11, r14.f(), 20.0f, true, null, 16, null);
        goto L17
    L15:
        r11 = r10;
        goto L16
    }

    private final void alignDescriptionByLineCount() {
        clearPendingDescriptionAlignment();
        TextView r0 = this.skillDescription;
        if (r0 != null) goto L5;
        d.h.b.o.c("skillDescription");
        r0 = null;
    L5:
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == true) goto L8;
        return;
    L8:
        ViewTreeObserver.OnPreDrawListener r2 = new SkillDetailPreviewActivity$alignDescriptionByLineCount$listener$1(this);
        this.pendingDescriptionAlignmentListener = (ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(r2, ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin");
        r1.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(r2, ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
    }

    private final void clearPendingDescriptionAlignment() {
        ViewTreeObserver.OnPreDrawListener r0 = this.pendingDescriptionAlignmentListener;
        if (r0 != null) goto L5;
        return;
    L5:
        TextView r1 = this.skillDescription;
        if (r1 != null) goto L8;
        d.h.b.o.c("skillDescription");
        r1 = null;
    L8:
        ViewTreeObserver r2 = r1.getViewTreeObserver();
        if (r2.isAlive() == false) goto L11;
        r2.removeOnPreDrawListener(r0);
    L11:
        this.pendingDescriptionAlignmentListener = null;
    }

    private final void renderDescription(com.obric.aiagent.skill.manager.api.e r4, String r5) {
        if (ZeusTransformUtils.instanceOf(r4.g(), com.obric.aiagent.skill.manager.api.aq.e.class) == true) goto L5;
    L23:
        showPlainDescription((CharSequence) ZeusTransformUtils.preCheckCast(valueOrDash(r5), CharSequence.class, "com.obric.aiagent.plugin"), true);
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L23;
        if (shouldRenderAsMarkdown(r5) == false) goto L23;
        clearPendingDescriptionAlignment();
        TextView r7 = this.skillDescription;
        SkillDescriptionMarkdownView r0 = null;
        if (r7 != null) goto L14;
        d.h.b.o.c("skillDescription");
        r7 = null;
    L14:
        r7.setVisibility(8);
        SkillDescriptionMarkdownView r8 = this.skillDescriptionMarkdown;
        if (r8 != null) goto L17;
        d.h.b.o.c("skillDescriptionMarkdown");
        r8 = null;
    L17:
        r8.setVisibility(0);
        SkillDescriptionMarkdownView r3 = this.skillDescriptionMarkdown;
        if (r3 != null) goto L20;
        d.h.b.o.c("skillDescriptionMarkdown");
    L21:
        r0.setMarkdownContent$impl_release(r5);
        return;
    L20:
        r0 = r3;
        goto L21
    L7:
        r6 = false;
        goto L8
    }

    private final void showPlainDescription(CharSequence r5, boolean r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
        SkillDescriptionMarkdownView r0 = this.skillDescriptionMarkdown;
        TextView r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("skillDescriptionMarkdown");
        r0 = null;
    L5:
        r0.setVisibility(8);
        SkillDescriptionMarkdownView r1 = this.skillDescriptionMarkdown;
        if (r1 != null) goto L8;
        d.h.b.o.c("skillDescriptionMarkdown");
        r1 = null;
    L8:
        r1.clearMarkdownContent$impl_release();
        TextView r3 = this.skillDescription;
        if (r3 != null) goto L11;
        d.h.b.o.c("skillDescription");
        r3 = null;
    L11:
        r3.setVisibility(0);
        TextView r4 = this.skillDescription;
        if (r4 != null) goto L14;
        d.h.b.o.c("skillDescription");
        r4 = null;
    L14:
        r4.setText(r7);
        if (r6 == false) goto L17;
        alignDescriptionByLineCount();
        return;
    L17:
        clearPendingDescriptionAlignment();
        TextView r8 = this.skillDescription;
        if (r8 != null) goto L20;
        d.h.b.o.c("skillDescription");
    L21:
        r2.setGravity(8388611);
        return;
    L20:
        r2 = r8;
        goto L21
    }

    private final void configureCta(final com.obric.aiagent.skill.manager.api.e r9) {
        int r0 = e.f20245a[com.obric.aiagent.skill.manager.impl.az.d(r9, this.currentSkillInstalled).ordinal()];
        if (r0 == 1) goto L47;
        OProgressButton r6 = null;
        if (r0 != 2) goto L7;
        applyCtaStyle(false);
        OProgressButton r10 = this.detailCta;
        if (r10 != null) goto L39;
        d.h.b.o.c("detailCta");
        r10 = null;
    L39:
        r10.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_enable_skill, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_enable_skill"));
        OProgressButton r11 = this.detailCta;
        if (r11 != null) goto L42;
        d.h.b.o.c("detailCta");
        r11 = null;
    L42:
        r11.setEnabled(true);
        OProgressButton r12 = this.detailCta;
        if (r12 != null) goto L45;
        d.h.b.o.c("detailCta");
    L46:
        r6.setOnClickListener(new $$Lambda$SkillDetailPreviewActivity$NKXM6KNAsVJ6d055x1BSWp1m3g(this));
        return;
    L45:
        r6 = r12;
        goto L46
    L7:
        if (r0 != 3) goto L9;
        applyCtaStyle(true);
        OProgressButton r1 = this.detailCta;
        if (r1 != null) goto L28;
        d.h.b.o.c("detailCta");
        r1 = null;
    L28:
        r1.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_go_use, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_go_use"));
        OProgressButton r2 = this.detailCta;
        if (r2 != null) goto L31;
        d.h.b.o.c("detailCta");
        r2 = null;
    L31:
        r2.setEnabled(true);
        OProgressButton r3 = this.detailCta;
        if (r3 != null) goto L34;
        d.h.b.o.c("detailCta");
    L35:
        r6.setOnClickListener(new $$Lambda$SkillDetailPreviewActivity$Ik8NErNspt5IghpiGLukSpY3GaI(this, r9));
        return;
    L34:
        r6 = r3;
        goto L35
    L9:
        if (r0 != 4) goto L24;
        applyCtaStyle(true);
        OProgressButton r13 = this.detailCta;
        if (r13 != null) goto L13;
        d.h.b.o.c("detailCta");
        r13 = null;
    L13:
        r13.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_go_use, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_go_use"));
        OProgressButton r14 = this.detailCta;
        if (r14 != null) goto L16;
        d.h.b.o.c("detailCta");
        r14 = null;
    L16:
        r14.setEnabled(false);
        OProgressButton r15 = this.detailCta;
        if (r15 != null) goto L19;
        d.h.b.o.c("detailCta");
        r15 = null;
    L19:
        r15.setAlpha(0.3f);
        OProgressButton r8 = this.detailCta;
        if (r8 != null) goto L22;
        d.h.b.o.c("detailCta");
        r8 = null;
    L22:
        r8.setOnClickListener(null);
        return;
    L24:
        throw new d.k();
    L47:
        configureAddCta();
    }

    private static final void configureCta$lambda$41(SkillDetailPreviewActivity r1, View r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).setCurrentSkillEnabled(true);
    }

    private static final void configureCta$lambda$43(SkillDetailPreviewActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3) {
        final SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        co.a((FragmentActivity) ZeusTransformUtils.preCheckCast(r4, FragmentActivity.class, "com.obric.aiagent.plugin"), r2, new $$Lambda$SkillDetailPreviewActivity$9dU6Ww_PllAEElulAJd2USBAmI(r4));
    }

    private static final d.x configureCta$lambda$43$lambda$42(SkillDetailPreviewActivity r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).openCurrentSkillInChat();
        return d.x.f38692a;
    }

    private final void renderLoading(aa r8) {
        stopDetailSigningRefresh();
        OPageStatus r0 = null;
        this.currentSkill = null;
        this.currentUsageExamples = d.a.p.b();
        hideBottomDivider();
        setDetailBodyVisible(false);
        OPageStatus r2 = this.detailLoadingStatus;
        if (r2 != null) goto L5;
        d.h.b.o.c("detailLoadingStatus");
        r2 = null;
    L5:
        int r9 = e.f20246b[r8.ordinal()];
        if (r9 != 1) goto L8;
        int r10 = ZeusTransformUtils.mapRes(R.string.obric_skill_detail_loading_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_loading_description");
    L13:
        r2.setLoadingResult((CharSequence) ZeusTransformUtils.preCheckCast(getString(r10), CharSequence.class, "com.obric.aiagent.plugin"));
        OPageStatus r11 = this.detailLoadingStatus;
        if (r11 != null) goto L16;
        d.h.b.o.c("detailLoadingStatus");
        r11 = null;
    L16:
        r11.showLoading(true);
        OPageStatus r7 = this.detailLoadingStatus;
        if (r7 != null) goto L19;
        d.h.b.o.c("detailLoadingStatus");
    L20:
        r0.setVisibility(0);
        return;
    L19:
        r0 = r7;
        goto L20
    L8:
        if (r9 != 2) goto L11;
        r10 = ZeusTransformUtils.mapRes(R.string.obric_skill_detail_updating_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_updating_description");
        goto L13
    L11:
        throw new d.k();
    }

    static /* synthetic */ void setDetailMenuVisible$default(SkillDetailPreviewActivity r1, boolean r2, boolean r3, int r4, Object r5) {
        SkillDetailPreviewActivity r6 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r6.setDetailMenuVisible(r2, r3);
    }

    private final void setDetailMenuVisible(boolean r5, boolean r6) {
        OFloatingTitleBar r2 = null;
        if (r5 == false) goto L14;
        View r7 = this.detailMore;
        if (r7 == null) goto L8;
        r7.setEnabled(true);
        return;
    L8:
        OFloatingTitleBar r8 = this.detailTitleBar;
        if (r8 != null) goto L11;
        d.h.b.o.c("detailTitleBar");
    L12:
        View r9 = r2.addEndAction(ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_more, "drawable", "o_floating_title_bar_icon_more"), 0, r6, new $$Lambda$SkillDetailPreviewActivity$U1PznggUoAB36_rfDKZoXNLYTQ(this));
        r9.setId(ZeusTransformUtils.mapRes(R.id.detail_more, DbHelper.COL_ID, "detail_more"));
        r9.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_more, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_more")), CharSequence.class, "com.obric.aiagent.plugin"));
        this.detailMore = r9;
        return;
    L11:
        r2 = r8;
        goto L12
    L14:
        View r10 = this.detailMore;
        if (r10 != null) goto L17;
        return;
    L17:
        OPopover r3 = this.detailMenuPopover;
        if (r3 == null) goto L20;
        r3.dismiss();
    L20:
        this.detailMenuPopover = null;
        r10.setEnabled(false);
        OFloatingTitleBar r11 = this.detailTitleBar;
        if (r11 != null) goto L23;
        d.h.b.o.c("detailTitleBar");
        r11 = null;
    L23:
        r11.removeEndActionAt(0, r6);
        this.detailMore = null;
    }

    private static final void setDetailMenuVisible$lambda$45(SkillDetailPreviewActivity r1, View r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).showDetailMenu();
    }

    private final void setDetailBodyVisible(boolean r5) {
        if (r5 == false) goto L5;
        int r1 = 0;
    L6:
        ViewGroup r2 = this.detailScroll;
        OPageStatus r3 = null;
        if (r2 != null) goto L9;
        d.h.b.o.c("detailScroll");
        r2 = null;
    L9:
        r2.setVisibility(r1);
        OBottomActionBarNormalHorizontal r4 = this.detailBottomBar;
        if (r4 != null) goto L12;
        d.h.b.o.c("detailBottomBar");
        r4 = null;
    L12:
        r4.setVisibility(r1);
        if (r5 == false) goto L20;
        OPageStatus r6 = this.detailLoadingStatus;
        if (r6 != null) goto L17;
        d.h.b.o.c("detailLoadingStatus");
    L18:
        r3.setVisibility(8);
        return;
    L17:
        r3 = r6;
        goto L18
    L20:
        return;
    L5:
        r1 = 8;
        goto L6
    }

    private final void openCurrentSkillInChat() {
        if (com.obric.aiagent.skill.manager.impl.ui.r.a(com.obric.aiagent.skill.manager.impl.ui.r.f20808a, (Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), this.skillManager, this.currentSlug, null, new $$Lambda$SkillDetailPreviewActivity$crNKfcD3Lvsemsbjn8MLk7G69w(this), 8, null) == false) goto L6;
        finish();
        return;
    }

    private static final d.x openCurrentSkillInChat$lambda$47(SkillDetailPreviewActivity r2, String r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "message");
        r4.showUseError(r3);
        return d.x.f38692a;
    }

    private final void openUsageExample(com.obric.aiagent.skill.manager.impl.ui.e r9) {
        com.obric.aiagent.skill.manager.impl.ui.r r0 = com.obric.aiagent.skill.manager.impl.ui.r.f20808a;
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin");
        ISkillManagerService r3 = this.skillManager;
        com.obric.aiagent.skill.manager.api.e r4 = this.currentSkill;
        r0.a(r1, r3, r9, r4, d.a.p.b(r4), new $$Lambda$SkillDetailPreviewActivity$ZKoLebxyz98PKuRHWw8iUFjep8(this), (d.h.a.a) ZeusTransformUtils.preCheckCast(new p(this), d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    private static final d.x openUsageExample$lambda$48(SkillDetailPreviewActivity r2, String r3) {
        SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "message");
        r4.showUseError(r3);
        return d.x.f38692a;
    }

    private final void installCurrentSkill() {
        ISkillManagerService r0 = this.skillManager;
        String r1 = this.currentSlug;
        if (r0 == null) goto L21;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin");
        boolean r4 = false;
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L22;
        kotlinx.coroutines.ca r5 = this.installProgressJob;
        if (r5 != null) goto L15;
    L17:
        if (r4 == true) goto L23;
        showInstallProgress();
        this.installProgressJob = kotlinx.coroutines.i.a(this.mainScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new n(this, r1, r0, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L23:
        return;
    L15:
        if (r5.b() != true) goto L17;
        r4 = true;
        goto L17
    L22:
        return;
    L7:
        if (r2.length() == 0) goto L10;
        r3 = false;
        goto L11
    }

    private final void configureAddCta() {
        applyCtaStyle(false);
        OProgressButton r0 = this.detailCta;
        OProgressButton r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("detailCta");
        r0 = null;
    L5:
        r0.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_add, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_add"));
        OProgressButton r2 = this.detailCta;
        if (r2 != null) goto L8;
        d.h.b.o.c("detailCta");
        r2 = null;
    L8:
        r2.setEnabled(true);
        OProgressButton r3 = this.detailCta;
        if (r3 != null) goto L11;
        d.h.b.o.c("detailCta");
    L12:
        r1.setOnClickListener(new $$Lambda$SkillDetailPreviewActivity$aQzlpDGId0vZpIds1ASRywhNXU(this));
        return;
    L11:
        r1 = r3;
        goto L12
    }

    private static final void configureAddCta$lambda$49(SkillDetailPreviewActivity r1, View r2) {
        SkillDetailPreviewActivity r3 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        OFloatingTitleBar r4 = r3.detailTitleBar;
        if (r4 != null) goto L5;
        d.h.b.o.c("detailTitleBar");
        r4 = null;
    L5:
        r4.finishFloatingTransitionForUserInteraction();
        r3.installCurrentSkill();
    }

    private final void showInstallProgress() {
        OProgressButton r0 = this.detailCta;
        OProgressButton r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("detailCta");
        r0 = null;
    L5:
        r0.setProgressMode(true);
        OProgressButton r1 = this.detailCta;
        if (r1 != null) goto L8;
        d.h.b.o.c("detailCta");
        r1 = null;
    L8:
        r1.updateBackgroundProgress(0.0f);
        OProgressButton r3 = this.detailCta;
        if (r3 != null) goto L11;
        d.h.b.o.c("detailCta");
        r3 = null;
    L11:
        r3.setProgress(0);
        OProgressButton r4 = this.detailCta;
        if (r4 != null) goto L14;
        d.h.b.o.c("detailCta");
        r4 = null;
    L14:
        r4.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_processing, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_processing"));
        OProgressButton r5 = this.detailCta;
        if (r5 != null) goto L17;
        d.h.b.o.c("detailCta");
        r5 = null;
    L17:
        r5.setEnabled(true);
        OProgressButton r6 = this.detailCta;
        if (r6 != null) goto L20;
        d.h.b.o.c("detailCta");
        r6 = null;
    L20:
        r6.setOnClickListener(null);
        OProgressButton r8 = this.detailCta;
        if (r8 != null) goto L23;
        d.h.b.o.c("detailCta");
    L24:
        r2.setClickable(false);
        return;
    L23:
        r2 = r8;
        goto L24
    }

    private final void setCurrentSkillEnabled(boolean r10) {
        ISkillManagerService r3 = this.skillManager;
        String r4 = this.currentSlug;
        if (r3 == null) goto L45;
        CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == true) goto L47;
        OProgressButton r7 = null;
        if (r10 == true) goto L16;
    L21:
        OProgressButton r8 = this.detailCta;
        if (r8 != null) goto L24;
        d.h.b.o.c("detailCta");
    L25:
        r7.setEnabled(false);
        com.obric.aiagent.skill.manager.api.u<d.x> r9 = r3.setSkillEnabled(r4, r10);     // Catch: Exception -> L37
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L30;
        logDetailInfo("Detail set skill enabled completed enabled=" + r10, "Detail set skill enabled completed: slug=" + r4 + ", enabled=" + r10);     // Catch: Exception -> L37
    L34:
        renderLatestInstalledSkill();     // Catch: Exception -> L37
        return;
    L30:
        if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L36;
        logDetailWarning("Detail set skill enabled failed enabled=" + r10 + " code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a(), "Detail set skill enabled failed: slug=" + r4 + ", enabled=" + r10 + ", code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());     // Catch: Exception -> L37
        com.obric.aiagent.skill.manager.impl.bh r11 = com.obric.aiagent.skill.manager.impl.az.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"));     // Catch: Exception -> L37
        if (r11 == null) goto L34;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), r11);     // Catch: Exception -> L37
        goto L34
    L36:
        throw new d.k();     // Catch: Exception -> L37
    L37:
        e = move-exception;
        logDetailFailure("Detail set skill enabled failed enabled=" + r10, "Detail set skill enabled failed: slug=" + r4 + ", enabled=" + r10, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        com.obric.aiagent.skill.manager.impl.bh r12 = com.obric.aiagent.skill.manager.impl.az.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        if (r12 == null) goto L41;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), r12);
    L41:
        renderLatestInstalledSkill();
        return;
    L24:
        r7 = r8;
        goto L25
    L16:
        if (en.d(currentSecurityState$default(this, null, 1, null)) == false) goto L21;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this, Activity.class, "com.obric.aiagent.plugin"), cm.a.m);
        com.obric.aiagent.skill.manager.api.e r13 = this.currentSkill;
        if (r13 == null) goto L44;
        renderDetail(r13);
        return;
    L44:
        return;
    L47:
        return;
    L7:
        if (r5.length() == 0) goto L10;
        r6 = false;
        goto L11
    }

    private final void renderLatestInstalledSkill() {
        String r0 = this.currentSlug;
        if (r0 != null) goto L5;
        return;
    L5:
        ISkillManagerService r1 = this.skillManager;
        com.obric.aiagent.skill.manager.api.e r2 = null;
        Object r3 = null;
        r2 = null;
        r2 = null;
        if (r1 == null) goto L18;
        com.obric.aiagent.skill.manager.api.u<List<com.obric.aiagent.skill.manager.api.e>> r4 = r1.getInstalledSkills();
        if (r4 == null) goto L18;
        List r5 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r4), List.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L18;
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Object r7 = r6.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r0) == false) goto L13;
        r3 = r7;
    L17:
        r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
    L18:
        if (r2 == null) goto L20;
        this.currentSkill = r2;
        renderDetail(r2);
        ensureSkillObserverStarted();
        return;
    L20:
        com.obric.aiagent.skill.manager.api.e r8 = this.currentSkill;
        if (r8 == null) goto L28;
        renderDetail(r8);
        return;
    }

    private final void deleteCurrentSkill(com.obric.aiagent.skill.manager.api.e r10) {
        ISkillManagerService r0 = this.skillManager;
        String r11 = r10.a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L13;
        kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new i(r0, r11, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L13:
        return;
    L7:
        r1 = false;
        goto L8
    }

    private final void ensureSkillObserverStarted() {
        ISkillManagerService r0 = this.skillManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.stateObserveJob == null) goto L8;
        return;
    L8:
        kotlinx.coroutines.b.ak r1 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r0.observeInstalledSkills()), kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        return;
    L11:
        this.stateObserveJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r1, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void scheduleDetailSigningRefresh(com.obric.aiagent.skill.manager.api.e r13) {
        if (com.obric.aiagent.skill.manager.impl.az.b(r13) == true) goto L7;
        finishDetailSigningRefreshSession(c.f20237a, r13);
        clearDetailSigningProgress(r13.a());
        stopDetailSigningRefresh();
        return;
    L7:
        if (this.detailPageVisible == true) goto L9;
        return;
    L9:
        ISkillManagerService r3 = this.skillManager;
        if (r3 != null) goto L12;
        return;
    L12:
        String r0 = r13.a();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L16;
        r0 = null;
    L16:
        String r4 = r0;
        if (r4 != null) goto L20;
        return;
    L20:
        if (com.obric.aiagent.skill.manager.api.al.f19195a.a().E() == true) goto L25;
        if (this.detailSigningRefreshAttempted == false) goto L25;
        return;
    L25:
        if (this.detailSigningRefreshGate.a() == true) goto L27;
        return;
    L27:
        b r6 = detailSigningRefreshSession(r13);
        if (r6.h() == null) goto L31;
        this.detailSigningRefreshGate.b();
        return;
    L31:
        this.detailSigningRefreshAttempted = true;
        this.detailSigningRefreshJob = kotlinx.coroutines.i.a(this.mainScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new r(this, r3, r4, r13, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void advanceDetailSigningProgress(com.obric.aiagent.skill.manager.api.e r6) {
        ab r0 = signingProgressSnapshot(r6);
        boolean r1 = r0.h();
        ab r2 = this.detailSigningProgressStore.a(r0, System.currentTimeMillis());
        this.detailSigningProgressSnapshot = r2;
        this.detailSigningProgress = r2.f();
        if (r1 == false) goto L8;
        if (r2.h() == true) goto L8;
        logDetailInfo("Detail signing progress resumed", "Detail signing progress resumed: slug=" + r6.a() + ", version=" + r6.j() + ", progress=" + r2.f());
        return;
    L8:
        if (r2.f() == r0.f()) goto L12;
        logDetailInfo("Detail signing progress advanced", "Detail signing progress advanced: slug=" + r6.a() + ", version=" + r6.j() + ", progress=" + r2.f() + ", tick=" + r2.e());
        return;
    }

    private final void pauseDetailSigningProgress(com.obric.aiagent.skill.manager.api.e r4) {
        ab r0 = signingProgressSnapshot(r4);
        ab r1 = this.detailSigningProgressStore.a(r0);
        this.detailSigningProgressSnapshot = r1;
        this.detailSigningProgress = r1.f();
        if (r0.h() == true) goto L6;
        logDetailWarning("Detail signing progress paused", "Detail signing progress paused: slug=" + r4.a() + ", version=" + r4.j() + ", progress=" + r1.f());
        return;
    }

    private final ab signingProgressSnapshot(com.obric.aiagent.skill.manager.api.e r5) {
        ab r0 = this.detailSigningProgressSnapshot;
        if (r0 == null) goto L5;
        String r1 = r0.b();
    L7:
        if (d.h.b.o.a(r1, r5.a()) == true) goto L9;
    L11:
        ab r6 = this.detailSigningProgressStore.a(r5.a(), r5.j(), System.currentTimeMillis());
        this.detailSigningProgressSnapshot = r6;
        this.detailSigningProgress = r6.f();
        return r6;
    L9:
        if (r0.c() != r5.j()) goto L11;
        return r0;
    L5:
        r1 = null;
        goto L7
    }

    private final void reconcileDetailSigningProgress(com.obric.aiagent.skill.manager.api.e r2) {
        if (en.c(currentSecurityState(r2)) == false) goto L6;
        signingProgressSnapshot(r2);
        return;
    L6:
        clearDetailSigningProgress(r2.a());
    }

    private final void clearDetailSigningProgress(String r2) {
        this.detailSigningProgress = 0;
        this.detailSigningProgressSnapshot = null;
        this.detailSigningProgressStore.a(r2);
    }

    private final void stopDetailSigningRefresh() {
        kotlinx.coroutines.ca r0 = this.detailSigningRefreshJob;
        if (r0 == null) goto L5;
        kotlinx.coroutines.ca.a.a(r0, null, 1, null);
    L5:
        this.detailSigningRefreshJob = null;
        this.detailSigningRefreshGate.b();
    }

    private final b detailSigningRefreshSession(com.obric.aiagent.skill.manager.api.e r19) {
        String r3 = r19.a() + ':' + r19.j();
        b r1 = this.detailSigningRefreshSession;
        if (r1 == null) goto L5;
        String r2 = r1.a();
    L7:
        if (d.h.b.o.a(r2, r3) == false) goto L9;
        return r1;
    L9:
        if (r1 == null) goto L11;
        finishDetailSigningRefreshSession(c.j, this.currentSkill);
    L11:
        b r4 = new b(r3, SystemClock.elapsedRealtime(), new ea(dy.k, this.trackingReporter, null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null), 0, 0, 0, false, null, null, 504, null);
        this.detailSigningRefreshSession = r4;
        return r4;
    L5:
        r2 = null;
        goto L7
    }

    private final void finishDetailSigningRefreshSession(c r20, com.obric.aiagent.skill.manager.api.e r21) {
        b r15 = this.detailSigningRefreshSession;
        if (r15 != null) goto L6;
        return;
    L6:
        if (r15.h() == null) goto L8;
        return;
    L8:
        r15.a(r20);
        switch(e.f20247c[r20.ordinal()]) {
            case 1: goto L16;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L13;
            case 7: goto L13;
            case 8: goto L12;
            case 9: goto L12;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        dz r1 = dz.f19792b;
    L17:
        dz r2 = r1;
        String r16 = null;
        switch(e.f20247c[r20.ordinal()]) {
            case 1: goto L28;
            case 2: goto L28;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L24;
            case 6: goto L23;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L22;
            case 10: goto L21;
            default: goto L20;
        };
    L21:
        dw r3 = dw.g;
    L27:
        dw r8 = r3;
    L29:
        ea r4 = r15.b();
        if (r21 == null) goto L34;
        com.obric.aiagent.skill.manager.api.aj r5 = r21.i();
        if (r5 == null) goto L34;
        String r7 = r5.a();
    L36:
        if (r2 != dz.f19791a) goto L38;
        String r9 = null;
    L39:
        d.m[] r12 = new d.m[7];
        r12[0] = d.s.a("refresh_origin", "detail");
        r12[1] = d.s.a("stop_reason", r20.a());
        r12[2] = d.s.a("poll_count", Integer.valueOf(r15.e()));
        r12[3] = d.s.a("network_failure_count", Integer.valueOf(r15.d()));
        r12[4] = d.s.a("elapsed_ms", Long.valueOf(r15.i()));
        com.obric.aiagent.skill.manager.api.am r6 = r15.g();
        if (r6 == null) goto L45;
        String r10 = r6.name();
        if (r10 == null) goto L45;
        Locale r13 = Locale.ROOT;
        d.h.b.o.c(r13, "ROOT");
        String r11 = r10.toLowerCase(r13);
        d.h.b.o.c(r11, "toLowerCase(...)");
        if (r11 == null) goto L45;
    L46:
        r12[5] = d.s.a("last_refresh_action", r11);
        r12[6] = d.s.a("submitted_scan", Boolean.valueOf(r15.f()));
        ea.a(r4, r2, r21, null, null, null, r7, r8, r9, false, false, d.a.ao.a(r12), 28, null);
        String r14 = "Detail signing refresh stopped reason=" + r20.a();
        StringBuilder r17 = new StringBuilder().append("Detail signing refresh stopped: slug=");
        if (r21 == null) goto L49;
        r16 = r21.a();
    L49:
        if (r16 != null) goto L51;
        r16 = "";
    L51:
        logDetailInfo(r14, r17.append(r16).append(", reason=").append(r20.a()).append(", pollCount=").append(r15.e()).append(", networkFailureCount=").append(r15.d()).append(", submittedScan=").append(r15.f()).toString());
        return;
    L45:
        r11 = OProtocolTextEffectTextView.EffectNameNone;
        goto L46
    L38:
        r9 = "detail_refresh";
    L34:
        r7 = null;
        goto L36
    L22:
        r3 = dw.o;
        goto L27
    L23:
        r3 = dw.f19777b;
        goto L27
    L24:
        r3 = dw.n;
        goto L27
    L25:
        r3 = dw.f19778c;
        goto L27
    L26:
        r3 = dw.m;
        goto L27
    L28:
        r8 = null;
        goto L29
    L20:
        throw new d.k();
    L13:
        r1 = dz.f19793c;
        goto L17
    L14:
        r1 = dz.f19795e;
        goto L17
    L15:
        r1 = dz.f;
        goto L17
    L16:
        r1 = dz.f19791a;
        goto L17
    L11:
        throw new d.k();
    }

    private final void logDetailInfo(String r1, String r2) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r1 = r2;
    L5:
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_ui_SkillDetailPreviewActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i("SkillManager", r1);
    }

    private final void logDetailWarning(String r1, String r2) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        r1 = r2;
    L5:
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_ui_SkillDetailPreviewActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("SkillManager", r1);
    }

    private final void logDetailFailure(String r2, String r3, Throwable r4) {
        if (IAppContext.Companion.isDebug() == false) goto L5;
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_ui_SkillDetailPreviewActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e("SkillManager", r3, r4);
        return;
    L5:
        INVOKESTATIC_com_obric_aiagent_skill_manager_impl_ui_SkillDetailPreviewActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w("SkillManager", r2);
    }

    private final void renderError(String r12, String r13) {
        stopDetailSigningRefresh();
        OProgressButton r0 = null;
        this.currentSkill = null;
        this.currentSkillInstalled = false;
        this.currentUsageExamples = d.a.p.b();
        hideBottomDivider();
        setDetailBodyVisible(true);
        setDetailMenuVisible(false, false);
        com.obric.aiagent.skill.manager.impl.ui.s r3 = com.obric.aiagent.skill.manager.impl.ui.s.f20812a;
        SimpleDraweeView r4 = this.skillIcon;
        if (r4 != null) goto L5;
        d.h.b.o.c("skillIcon");
        r4 = null;
    L5:
        com.obric.aiagent.skill.manager.impl.ui.s.a(r3, r4, null, 20.0f, true, null, 16, null);
        HeaderInfoView r5 = this.skillHeader;
        if (r5 != null) goto L8;
        d.h.b.o.c("skillHeader");
        r5 = null;
    L8:
        r5.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"));
        bindMetadata(null);
        showPlainDescription((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), false);
        TextView r14 = this.skillRelatedInfo;
        if (r14 != null) goto L11;
        d.h.b.o.c("skillRelatedInfo");
        r14 = null;
    L11:
        r14.setVisibility(8);
        TextView r15 = this.skillSecurityInfo;
        if (r15 != null) goto L14;
        d.h.b.o.c("skillSecurityInfo");
        r15 = null;
    L14:
        r15.setVisibility(8);
        bindExamples(d.a.p.b());
        bindSecurityFooter(null);
        applyCtaStyle(false);
        OProgressButton r16 = this.detailCta;
        if (r16 != null) goto L17;
        d.h.b.o.c("detailCta");
        r16 = null;
    L17:
        r16.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_back, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_back"));
        OProgressButton r17 = this.detailCta;
        if (r17 != null) goto L20;
        d.h.b.o.c("detailCta");
        r17 = null;
    L20:
        r17.setEnabled(true);
        OProgressButton r18 = this.detailCta;
        if (r18 != null) goto L23;
        d.h.b.o.c("detailCta");
    L24:
        r0.setOnClickListener(new $$Lambda$SkillDetailPreviewActivity$uZH2NteJYbXfqxnGkU6rHIjPR_8(this));
        return;
    L23:
        r0 = r18;
        goto L24
    }

    private static final void renderError$lambda$57(SkillDetailPreviewActivity r1, View r2) {
        ((SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private final void bindMetadata(com.obric.aiagent.skill.manager.api.e r10) {
        CharSequence r0 = null;
        if (r10 != null) goto L5;
    L10:
        com.obric.aiagent.skill.manager.impl.bd r11 = null;
    L12:
        if (r11 != null) goto L14;
    L62:
        HeaderInfoView r9 = this.skillHeader;
        if (r9 != null) goto L65;
        d.h.b.o.c("skillHeader");
        r9 = null;
    L65:
        r9.setSubtitle(null);
        return;
    L14:
        if (r11.d() == false) goto L62;
        String r2 = r11.b();
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L20;
        r2 = null;
    L20:
        String r3 = "";
        if (r2 == null) goto L49;
        com.obric.aiagent.skill.manager.impl.bb r6 = r11.c();
        if (r6 != null) goto L25;
        int r7 = -1;
    L26:
        if (r7 != (-1)) goto L28;
        Integer r8 = null;
    L44:
        if (r8 == null) goto L46;
        String r4 = getString(((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.aiagent.plugin")).intValue(), new Object[]{r2});
    L47:
        if (r4 != null) goto L50;
        r4 = "";
    L50:
        if (r4 == null) goto L53;
        r3 = r4;
    L53:
        HeaderInfoView r12 = this.skillHeader;
        if (r12 != null) goto L56;
        d.h.b.o.c("skillHeader");
        r12 = null;
    L56:
        CharSequence r13 = (CharSequence) ZeusTransformUtils.preCheckCast(r11.a() + r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r13) == true) goto L60;
        r0 = r13;
    L60:
        r12.setSubtitle(r0);
        return;
    L46:
        r4 = null;
        goto L47
    L28:
        if (r7 == 1) goto L39;
        if (r7 != 2) goto L37;
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L34;
        int r14 = ZeusTransformUtils.mapRes(R.string.obric_skill_source_imported_suffix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_source_imported_suffix");
    L35:
        r8 = Integer.valueOf(r14);
        goto L44
    L34:
        r14 = ZeusTransformUtils.mapRes(R.string.obric_skill_source_and_imported_suffix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_source_and_imported_suffix");
        goto L35
    L37:
        throw new d.k();
    L39:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L41;
        int r15 = ZeusTransformUtils.mapRes(R.string.obric_skill_source_created_suffix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_source_created_suffix");
    L42:
        r8 = Integer.valueOf(r15);
        goto L44
    L41:
        r15 = ZeusTransformUtils.mapRes(R.string.obric_skill_source_and_created_suffix, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_source_and_created_suffix");
        goto L42
    L25:
        r7 = e.f20248d[r6.ordinal()];
        goto L26
    L49:
        r4 = null;
        goto L50
    L5:
        if (d.h.b.o.a(r10.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L7;
        com.obric.aiagent.skill.manager.api.e r5 = r10;
    L8:
        if (r5 == null) goto L10;
        r11 = com.obric.aiagent.skill.manager.impl.az.a(r5, 0, null, 3, null);
        goto L12
    L7:
        r5 = null;
        goto L8
    }

    private final void bindExamples(List<String> r8) {
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r10 = r9.iterator();
    L3:
        ViewGroup r3 = null;
        CharSequence r4 = null;
        if (r10.hasNext() == false) goto L12;
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast((String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin"), CharSequence.class, "com.obric.aiagent.plugin");
        if (d.o.o.d(r2) == true) goto L9;
        r4 = r2;
    L9:
        String r5 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L3;
        r0.add(r5);
        goto L3
    L12:
        List r11 = (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
        View r1 = this.exampleSectionTitle;
        if (r1 != null) goto L15;
        d.h.b.o.c("exampleSectionTitle");
        r1 = null;
    L15:
        int r6 = 8;
        if (r11.isEmpty() == false) goto L18;
        int r7 = 8;
    L19:
        r1.setVisibility(r7);
        ViewGroup r12 = this.exampleList;
        if (r12 != null) goto L23;
        d.h.b.o.c("exampleList");
        r12 = null;
    L23:
        if (r11.isEmpty() == true) goto L26;
        r6 = 0;
    L26:
        r12.setVisibility(r6);
        ViewGroup r13 = this.exampleList;
        if (r13 != null) goto L29;
        d.h.b.o.c("exampleList");
    L30:
        cn.a(r3, r11, (d.h.a.b) ZeusTransformUtils.preCheckCast(new f(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
        scheduleBottomDividerRefresh();
        return;
    L29:
        r3 = r13;
        goto L30
    L18:
        r7 = 0;
        goto L19
    }

    private final void bindSecurityFooter(com.obric.aiagent.skill.manager.api.e r12) {
        OBottomActionBarNormalHorizontal r0 = null;
        if (r12 == null) goto L5;
        com.obric.aiagent.skill.manager.api.aj r13 = currentSecurityState(r12);
    L6:
        boolean r1 = true;
        if (r13 != null) goto L9;
    L11:
        boolean r3 = false;
    L13:
        if (r3 == false) goto L15;
        this.securityScanObservedWhileVisible = this.detailPageVisible;
        cancelSecurityCompletedFooterDismiss();
        String r14 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_security_progress, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_security_progress"), new Object[]{Integer.valueOf(this.detailSigningProgress)});
        d.h.b.o.c(r14, "getString(...)");
        showSecurityFooter$default(this, (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), color(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")), false, 4, null);
        return;
    L15:
        if (r13 != null) goto L17;
    L19:
        r1 = false;
    L20:
        if (r1 == false) goto L23;
        bindPassedSecurityFooter();
        return;
    L23:
        if (ZeusTransformUtils.instanceOf(r13, com.obric.aiagent.skill.manager.api.aj.a.class) == false) goto L25;
        this.securityScanObservedWhileVisible = false;
        cancelSecurityCompletedFooterDismiss();
        boolean r15 = com.obric.aiagent.skill.manager.api.al.f19195a.a().A();
        showSecurityFooter(failedSecurityFooterText(r15), color(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6")), r15);
        return;
    L25:
        this.securityScanObservedWhileVisible = false;
        cancelSecurityCompletedFooterDismiss();
        OBottomActionBarNormalHorizontal r11 = this.detailBottomBar;
        if (r11 != null) goto L28;
        d.h.b.o.c("detailBottomBar");
    L29:
        r0.removeHeaderView();
        return;
    L28:
        r0 = r11;
        goto L29
    L17:
        if (en.b(r13) != true) goto L19;
    L9:
        if (en.c(r13) != true) goto L11;
        r3 = true;
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    private final void bindPassedSecurityFooter() {
        kotlinx.coroutines.ca r0 = this.securityCompletedFooterDismissJob;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L11;
        return;
    L11:
        if (this.detailPageVisible == true) goto L13;
    L15:
        r1 = false;
    L16:
        this.securityScanObservedWhileVisible = false;
        OBottomActionBarNormalHorizontal r6 = null;
        if (r1 == true) goto L24;
        OBottomActionBarNormalHorizontal r3 = this.detailBottomBar;
        if (r3 != null) goto L21;
        d.h.b.o.c("detailBottomBar");
    L22:
        r6.removeHeaderView();
        return;
    L21:
        r6 = r3;
        goto L22
    L24:
        String r4 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_security_completed, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_security_completed"));
        d.h.b.o.c(r4, "getString(...)");
        showSecurityFooter$default(this, (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin"), color(ZeusTransformUtils.mapRes(R.color.oui_basic_text_3, "color", "oui_basic_text_3")), false, 4, null);
        this.securityCompletedFooterDismissJob = kotlinx.coroutines.i.a(this.mainScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L13:
        if (this.securityScanObservedWhileVisible == false) goto L15;
    L5:
        if (r0.b() != true) goto L7;
        r2 = true;
        goto L8
    }

    private final void clearTransientSecurityFooter() {
        this.securityScanObservedWhileVisible = false;
        cancelSecurityCompletedFooterDismiss();
        OBottomActionBarNormalHorizontal r0 = null;
        if (en.b(currentSecurityState$default(this, null, 1, null)) == false) goto L10;
        OBottomActionBarNormalHorizontal r2 = this.detailBottomBar;
        if (r2 != null) goto L7;
        d.h.b.o.c("detailBottomBar");
    L8:
        r0.removeHeaderView();
        return;
    L7:
        r0 = r2;
        goto L8
    }

    private final void cancelSecurityCompletedFooterDismiss() {
        kotlinx.coroutines.ca r0 = this.securityCompletedFooterDismissJob;
        if (r0 == null) goto L5;
        kotlinx.coroutines.ca.a.a(r0, null, 1, null);
    L5:
        this.securityCompletedFooterDismissJob = null;
    }

    static /* synthetic */ void showSecurityFooter$default(SkillDetailPreviewActivity r1, CharSequence r2, int r3, boolean r4, int r5, Object r6) {
        SkillDetailPreviewActivity r7 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r4 = false;
    L5:
        r7.showSecurityFooter(r8, r3, r4);
    }

    private final void showSecurityFooter(CharSequence r10, int r11, boolean r12) {
        CharSequence r13 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r10, CharSequence.class, "com.obric.aiagent.plugin");
        TextView r0 = this.securityFooterText;
        if (r0 != null) goto L5;
        OTextView r1 = new OTextView((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), null, 0, null, 14, null);
        ViewGroup.MarginLayoutParams r2 = new ViewGroup.MarginLayoutParams(-1, -2);
        r2.bottomMargin = dp(8);
        r1.setLayoutParams((ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r2, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        r1.setTextAppearance(ZeusTransformUtils.mapRes(R.style.Body_S, "style", "Body_S"));
        r1.setTextSize(2, 12.0f);
        r1.setGravity(17);
        this.securityFooterText = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
        r0 = (TextView) ZeusTransformUtils.preCheckCast(r1, TextView.class, "com.obric.aiagent.plugin");
    L5:
        r0.setText(r13);
        r0.setTextColor(r11);
        r0.setLinksClickable(r12);
        OBottomActionBarNormalHorizontal r14 = null;
        if (r12 == false) goto L8;
        MovementMethod r15 = LinkMovementMethod.getInstance();
    L9:
        r0.setMovementMethod(r15);
        r0.setHighlightColor(0);
        OBottomActionBarNormalHorizontal r9 = this.detailBottomBar;
        if (r9 != null) goto L12;
        d.h.b.o.c("detailBottomBar");
    L13:
        r14.setHeaderView((View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.aiagent.plugin"));
        return;
    L12:
        r14 = r9;
        goto L13
    L8:
        r15 = null;
        goto L9
    }

    private final CharSequence failedSecurityFooterText(boolean r9) {
        String r0 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_security_failed_toast, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_security_failed_toast"));
        d.h.b.o.c(r0, "getString(...)");
        if (r9 == false) goto L5;
        String r10 = r0 + ' ';
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_detail_security_appeal, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_detail_security_appeal"));
        d.h.b.o.c(r1, "getString(...)");
        SpannableStringBuilder r2 = new SpannableStringBuilder((CharSequence) ZeusTransformUtils.preCheckCast(r10 + r1, CharSequence.class, "com.obric.aiagent.plugin"));
        r2.setSpan(new ForegroundColorSpan(color(ZeusTransformUtils.mapRes(R.color.oui_functional_red_6, "color", "oui_functional_red_6"))), 0, r10.length(), 33);
        r2.setSpan(new ForegroundColorSpan(color(ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg"))), r10.length(), r10.length() + r1.length(), 33);
        r2.setSpan(new SkillDetailPreviewActivity$failedSecurityFooterText$1$1(this), r10.length(), r10.length() + r1.length(), 33);
        return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
    L5:
        return (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
    }

    private final void showUseError(String r3) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L6;
        logDetailWarning("Open skill chat failed", "Open skill chat failed: " + r3);
        return;
    }

    private final boolean shouldShowDetailMenu(com.obric.aiagent.skill.manager.api.e r2) {
        if (this.currentSkillInstalled == true) goto L5;
    L7:
        return false;
    L5:
        if (d.h.b.o.a(r2.a(), this.currentSlug) == false) goto L7;
        return true;
    }

    static /* synthetic */ com.obric.aiagent.skill.manager.api.aj currentSecurityState$default(SkillDetailPreviewActivity r1, com.obric.aiagent.skill.manager.api.e r2, int r3, Object r4) {
        SkillDetailPreviewActivity r5 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L6;
        r2 = r5.currentSkill;
    L6:
        return r5.currentSecurityState(r2);
    }

    private final com.obric.aiagent.skill.manager.api.aj currentSecurityState(com.obric.aiagent.skill.manager.api.e r2) {
        if (r2 == null) goto L6;
        com.obric.aiagent.skill.manager.api.aj r1 = r2.i();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return (com.obric.aiagent.skill.manager.api.aj) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.aj.c.f19187a, com.obric.aiagent.skill.manager.api.aj.class, "com.obric.aiagent.plugin");
    }

    private final void applyCtaStyle(boolean r6) {
        resetDetailCtaProgress();
        if (r6 == false) goto L5;
        int r2 = ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg");
    L6:
        if (r6 == false) goto L8;
        int r7 = ZeusTransformUtils.mapRes(R.color.oui_on_accent_default, "color", "oui_on_accent_default");
    L9:
        OProgressButton r0 = this.detailCta;
        OProgressButton r1 = null;
        if (r0 != null) goto L12;
        d.h.b.o.c("detailCta");
        r0 = null;
    L12:
        r0.setAlpha(1.0f);
        OProgressButton r3 = this.detailCta;
        if (r3 != null) goto L15;
        d.h.b.o.c("detailCta");
        r3 = null;
    L15:
        r3.setBackgroundColor(color(r2));
        OProgressButton r4 = this.detailCta;
        if (r4 != null) goto L18;
        d.h.b.o.c("detailCta");
        r4 = null;
    L18:
        r4.setRadius(dp(24));
        int r8 = color(r7);
        OProgressButton r5 = this.detailCta;
        if (r5 != null) goto L21;
        d.h.b.o.c("detailCta");
    L22:
        r1.setTextColor(r8);
        return;
    L21:
        r1 = r5;
        goto L22
    L8:
        r7 = ZeusTransformUtils.mapRes(R.color.oui_accent_6_bg, "color", "oui_accent_6_bg");
        goto L9
    L5:
        r2 = ZeusTransformUtils.mapRes(R.color.oui_basic_fill_element_2, "color", "oui_basic_fill_element_2");
        goto L6
    }

    private final void resetDetailCtaProgress() {
        OProgressButton r0 = this.detailCta;
        OProgressButton r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("detailCta");
        r0 = null;
    L5:
        r0.setProgressMode(false);
        OProgressButton r2 = this.detailCta;
        if (r2 != null) goto L8;
        d.h.b.o.c("detailCta");
        r2 = null;
    L8:
        r2.setProgress(0);
        OProgressButton r4 = this.detailCta;
        if (r4 != null) goto L11;
        d.h.b.o.c("detailCta");
    L12:
        r1.setClickable(true);
        return;
    L11:
        r1 = r4;
        goto L12
    }

    private final void hideBottomDivider() {
        this.contentOverflowDividerEnabled = false;
        OBottomActionBarNormalHorizontal r1 = this.detailBottomBar;
        if (r1 != null) goto L5;
        d.h.b.o.c("detailBottomBar");
        r1 = null;
    L5:
        r1.showDivider(false);
    }

    private final void scheduleBottomDividerRefresh() {
        if (this.bottomDividerRefreshPending == false) goto L5;
        return;
    L5:
        this.bottomDividerRefreshPending = true;
        ViewGroup r0 = this.detailScroll;
        if (r0 != null) goto L8;
        d.h.b.o.c("detailScroll");
        r0 = null;
    L8:
        r0.post(new $$Lambda$SkillDetailPreviewActivity$26rGXtCe_BbczZdcF6Yo4i3YJ4E(this));
    }

    private static final void scheduleBottomDividerRefresh$lambda$70(SkillDetailPreviewActivity r3) {
        final SkillDetailPreviewActivity r4 = (SkillDetailPreviewActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillDetailPreviewActivity.class, "com.obric.aiagent.plugin");
        ViewGroup r0 = r4.detailScroll;
        if (r0 != null) goto L5;
        d.h.b.o.c("detailScroll");
        r0 = null;
    L5:
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1.isAlive() == true) goto L9;
        r4.bottomDividerRefreshPending = false;
        r4.refreshBottomDividerByContentOverflow();
        return;
    L9:
        r1.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) ZeusTransformUtils.preCheckCast(new SkillDetailPreviewActivity$scheduleBottomDividerRefresh$1$1(r4), ViewTreeObserver.OnPreDrawListener.class, "com.obric.aiagent.plugin"));
    }

    private final void refreshBottomDividerByContentOverflow() {
        boolean r2 = false;
        OBottomActionBarNormalHorizontal r3 = null;
        if (this.contentOverflowDividerEnabled == true) goto L10;
        OBottomActionBarNormalHorizontal r7 = this.detailBottomBar;
        if (r7 != null) goto L7;
        d.h.b.o.c("detailBottomBar");
    L8:
        r3.showDivider(false);
        return;
    L7:
        r3 = r7;
        goto L8
    L10:
        ViewGroup r0 = this.detailScroll;
        if (r0 != null) goto L13;
        d.h.b.o.c("detailScroll");
        r0 = null;
    L13:
        View r1 = r0.getChildAt(0);
        if (r1 == null) goto L16;
        int r4 = r1.getHeight();
    L17:
        ViewGroup r5 = this.detailScroll;
        if (r5 != null) goto L20;
        d.h.b.o.c("detailScroll");
        r5 = null;
    L20:
        int r6 = r5.getHeight();
        ViewGroup r8 = this.detailScroll;
        if (r8 != null) goto L23;
        d.h.b.o.c("detailScroll");
        r8 = null;
    L23:
        int r9 = r6 - r8.getPaddingTop();
        ViewGroup r10 = this.detailScroll;
        if (r10 != null) goto L26;
        d.h.b.o.c("detailScroll");
        r10 = null;
    L26:
        int r11 = r9 - r10.getPaddingBottom();
        OBottomActionBarNormalHorizontal r12 = this.detailBottomBar;
        if (r12 != null) goto L29;
        d.h.b.o.c("detailBottomBar");
    L30:
        if (r4 <= r11) goto L32;
        r2 = true;
    L32:
        r3.showDivider(r2);
        return;
    L29:
        r3 = r12;
        goto L30
    L16:
        r4 = 0;
        goto L17
    }

    private final int color(int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(r4, getTheme());
    L6:
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(r4);
    }

    private final String valueOrDash(String r2) {
        if (r2 != null) goto L4;
    L11:
        return "-";
    L4:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L6;
        boolean r1 = true;
    L7:
        if (r1 == true) goto L10;
        r2 = null;
    L10:
        if (r2 == null) goto L11;
        return r2;
    L6:
        r1 = false;
        goto L7
    }

    private final boolean shouldRenderAsMarkdown(String r7) {
        CharSequence r6 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
        int r2 = 0;
    L4:
        if (r2 >= r6.length()) goto L15;
        char r3 = r6.charAt(r2);
        if (r3 != '\n') goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L13;
        r2 = r2 + 1;
        goto L4
    L13:
        boolean r8 = true;
    L16:
        if (r8 == true) goto L30;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(MARKDOWN_DESCRIPTION_PATTERNS, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L20;
    L22:
        Iterator r10 = r9.iterator();
    L24:
        if (r10.hasNext() == false) goto L21;
        if (((d.o.k) ZeusTransformUtils.preCheckCast(r10.next(), d.o.k.class, "com.obric.aiagent.plugin")).b((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L24;
        boolean r11 = true;
    L28:
        if (r11 == true) goto L30;
        return false;
    L21:
        r11 = false;
        goto L28
    L20:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L22;
    L30:
        return true;
    L8:
        if (r3 == '\r') goto L11;
        r4 = false;
        goto L12
    L15:
        r8 = false;
        goto L16
    }

    private final int dp(int r2) {
        return (int) ((r2 * ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density) + 0.5f);
    }

    private final void configureSystemBars() {
        bh.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 0, false, 6, null);
    }

    static {
        Companion = new a(null);
        MARKDOWN_DESCRIPTION_PATTERNS = d.a.p.b(new d.o.k[]{new d.o.k("^\\s{0,3}#{1,6}\\s+", d.o.m.f38653b), new d.o.k("^\\s{0,3}(?:[-+*]|\\d+[.)])\\s+", d.o.m.f38653b), new d.o.k("^\\s{0,3}>\\s+", d.o.m.f38653b), new d.o.k("^\\s*(?:```|~~~)", d.o.m.f38653b), new d.o.k("`[^`]+`"), new d.o.k("\\*\\*[^*]+\\*\\*|__[^_]+__|\\*[^*]+\\*|_[^_]+_|~~[^~]+~~"), new d.o.k("!?\\[[^\\]]+]\\([^)]+\\)"), new d.o.k("^\\s*\\|.+\\|\\s*$", d.o.m.f38653b), new d.o.k("^\\s{0,3}(?:-{3,}|\\*{3,}|_{3,})\\s*$", d.o.m.f38653b)});
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_skill_manager_impl_ui_SkillDetailPreviewActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_i(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_skill_manager_impl_ui_SkillDetailPreviewActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_w(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int INVOKESTATIC_com_obric_aiagent_skill_manager_impl_ui_SkillDetailPreviewActivity_com_obric_aiagent_apm_impl_AiAgentReleaseLogLancet_e(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
