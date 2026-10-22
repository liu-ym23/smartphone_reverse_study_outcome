package com.obric.aiagent.skill.manager.impl.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.manager.api.ISkillManagerService;
import com.obric.aiagent.skill.manager.impl.SkillManager;
import com.obric.aiagent.skill.manager.impl.du;
import com.obric.aiagent.skill.manager.impl.dw;
import com.obric.aiagent.skill.manager.impl.dy;
import com.obric.aiagent.skill.manager.impl.dz;
import com.obric.aiagent.skill.manager.impl.ea;
import com.obric.aiagent.skill.manager.impl.eb;
import com.obric.aiagent.skill.manager.impl.ee;
import com.obric.aiagent.skill.manager.impl.ft;
import com.obric.aiagent.skill.manager.impl.gx;
import com.obric.aiagent.skill.manager.impl.gy;
import com.obric.aiagent.skill.manager.impl.gz;
import com.obric.aiagent.skill.manager.impl.hd;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.oui.button.OButton;
import com.obric.oui.forms.OEditText;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.obric.oui.progress.ODownloadProgressView;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.ss.bduploader.BDImageUploader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.cx;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SkillSearchActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SkillSearchActivity extends SkillGatedActivity {
    private static final long ACTION_SUCCEED_DURATION_MS = 1000;
    public static final a Companion = null;
    private static final String EXTRA_MODE = "mode";
    private static final String MODE_APP_FUNCTION = "app_function";
    private static final String MODE_MANAGEMENT = "management";
    private static final String MODE_SHOP = "shop";
    private static final float SEARCH_COVER_RADIUS_DP = 14.0f;
    private static final long SEARCH_DEBOUNCE_MS = 300;
    private static final float SOURCE_ICON_RADIUS_DP = 7.0f;
    private final HashSet<String> completedSkillSlugs;
    private String currentKeyword;
    private kotlinx.coroutines.ca decisionRefreshJob;
    private boolean decisionRefreshRequested;
    private OPageStatus emptyStatus;
    private Float emptyStatusImeStartY;
    private float emptyStatusImeTranslationY;
    private int emptyStatusInitialBottomPadding;
    private int emptyStatusInitialTopPadding;
    private final kotlinx.coroutines.am ioScope;
    private final ArrayList<com.obric.aiagent.skill.manager.api.e> latestInstalledSkills;
    private final kotlinx.coroutines.am mainScope;
    private com.obric.aiagent.skill.manager.impl.ui.h managementAdapter;
    private com.obric.aiagent.skill.manager.impl.ui.g managementInteractionController;
    private c mode;
    private final HashSet<String> processingSkillSlugs;
    private OSearchBar searchBar;
    private kotlinx.coroutines.ca searchJob;
    private RecyclerView searchList;
    private boolean searchPageVisible;
    private View searchRoot;
    private OFloatingTitleBar searchTitleBar;
    private d shopAdapter;
    private final d.f shopLoadMoreAdapter$delegate;
    private final d.f shopPager$delegate;
    private final ft shopRepository;
    private boolean shouldShowInitialIme;
    private ISkillManagerService skillManager;
    private kotlinx.coroutines.ca skillStateJob;
    private kotlinx.coroutines.ca storeMetadataRefreshJob;
    private final hd trackingReporter;

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final Intent a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "context");
            Intent r3 = new Intent(r1, SkillSearchActivity.class).putExtra(SkillSearchActivity.EXTRA_MODE, SkillSearchActivity.MODE_SHOP);
            d.h.b.o.c(r3, "putExtra(...)");
            return r3;
        }

        public final Intent b(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "context");
            Intent r3 = new Intent(r1, SkillSearchActivity.class).putExtra(SkillSearchActivity.EXTRA_MODE, SkillSearchActivity.MODE_MANAGEMENT);
            d.h.b.o.c(r3, "putExtra(...)");
            return r3;
        }

        public final Intent c(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "context");
            Intent r3 = new Intent(r1, SkillSearchActivity.class).putExtra(SkillSearchActivity.EXTRA_MODE, SkillSearchActivity.MODE_APP_FUNCTION);
            d.h.b.o.c(r3, "putExtra(...)");
            return r3;
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    private static final enum b extends Enum<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f20363a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f20364b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f20365c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f20366d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ b[] f20367e = null;
        private static final /* synthetic */ d.d.a f = null;

        private static final /* synthetic */ b[] a() {
            return new b[]{f20363a, f20364b, f20365c, f20366d};
        }

        private b(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f20363a = new b("BUTTON_ADD", 0);
            f20364b = new b("PROGRESSING", 1);
            f20365c = new b("SUCCEED_CHECK", 2);
            f20366d = new b("BUTTON_USE", 3);
            b[] r0 = a();
            f20367e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static b valueOf(String r2) {
            return (b) ZeusTransformUtils.preCheckCast(Enum.valueOf(b.class, r2), b.class, "com.obric.aiagent.plugin");
        }

        public static b[] values() {
            return (b[]) ZeusTransformUtils.preCheckCast(f20367e.clone(), b[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20368a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f20369b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f20370c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f20371d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ c[] f20372e = null;
        private static final /* synthetic */ d.d.a f = null;

        /* JADX INFO: compiled from: SkillSearchActivity.kt */
        public static final class a {
            public /* synthetic */ a(d.h.b.h r1) {
                this();
            }

            private a() {
            }

            public final c a(String r1) {
                if (d.h.b.o.a(r1, SkillSearchActivity.MODE_MANAGEMENT) == false) goto L6;
                return c.f20370c;
            L6:
                if (d.h.b.o.a(r1, SkillSearchActivity.MODE_APP_FUNCTION) == false) goto L9;
                return c.f20371d;
            L9:
                return c.f20369b;
            }
        }

        private static final /* synthetic */ c[] a() {
            return new c[]{f20369b, f20370c, f20371d};
        }

        private c(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f20369b = new c("SHOP", 0);
            f20370c = new c("MANAGEMENT", 1);
            f20371d = new c("APP_FUNCTION", 2);
            c[] r0 = a();
            f20372e = r0;
            f = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
            f20368a = new a(null);
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f20372e.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    private final class d extends RecyclerView.a<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillSearchActivity f20373a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<com.obric.aiagent.skill.manager.api.e> f20374b;

        /* JADX INFO: compiled from: SkillSearchActivity.kt */
        public final class a extends RecyclerView.v {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ d f20375a;
            private final OCardListItem s;
            private final SimpleDraweeView t;
            private final TextView u;
            private final TextView v;
            private final SimpleDraweeView w;
            private final TextView x;
            private final OButton y;
            private final ODownloadProgressView z;

            /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$d$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SkillSearchActivity.kt */
            public /* synthetic */ class C0429a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f20376a = null;

                static {
                    int[] r0 = new int[b.values().length];
                    r0[b.f20363a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
                L13:
                    r0[b.f20366d.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
                L19:
                    r0[b.f20364b.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
                L15:
                    r0[b.f20365c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
                L7:
                    f20376a = r0;
                }
            }

            public static /* synthetic */ void lambda$L8FTmEg423xWDXBPbWdzGmCOd9I(SkillSearchActivity r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
                a(r0, r1, r2);
            }

            public static /* synthetic */ void lambda$ipEAqzchxS_BysM0ektVNXGhYS8(SkillSearchActivity r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
                c(r0, r1, r2);
            }

            public static /* synthetic */ void lambda$qAZj63iIPh9y1ng2WQOd5hwWNDc(SkillSearchActivity r0, com.obric.aiagent.skill.manager.api.e r1, View r2) {
                b(r0, r1, r2);
            }

            public a(d r6, View r7) {
                d.h.b.o.e(r7, "itemView");
                this.f20375a = r6;
                super(r7);
                OCardListItem r8 = (OCardListItem) ZeusTransformUtils.preCheckCast(r7, OCardListItem.class, "com.obric.aiagent.plugin");
                this.s = r8;
                View r1 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_icon, DbHelper.COL_ID, "skill_icon"));
                d.h.b.o.c(r1, "findViewById(...)");
                this.t = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r1, SimpleDraweeView.class, "com.obric.aiagent.plugin");
                View r2 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_name, DbHelper.COL_ID, "skill_name"));
                d.h.b.o.c(r2, "findViewById(...)");
                this.u = (TextView) ZeusTransformUtils.preCheckCast(r2, TextView.class, "com.obric.aiagent.plugin");
                View r3 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_description, DbHelper.COL_ID, "skill_description"));
                d.h.b.o.c(r3, "findViewById(...)");
                this.v = (TextView) ZeusTransformUtils.preCheckCast(r3, TextView.class, "com.obric.aiagent.plugin");
                View r4 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source_avatar, DbHelper.COL_ID, "skill_source_avatar"));
                d.h.b.o.c(r4, "findViewById(...)");
                this.w = (SimpleDraweeView) ZeusTransformUtils.preCheckCast(r4, SimpleDraweeView.class, "com.obric.aiagent.plugin");
                View r5 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_source, DbHelper.COL_ID, "skill_source"));
                d.h.b.o.c(r5, "findViewById(...)");
                this.x = (TextView) ZeusTransformUtils.preCheckCast(r5, TextView.class, "com.obric.aiagent.plugin");
                View r9 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_action, DbHelper.COL_ID, "skill_action"));
                d.h.b.o.c(r9, "findViewById(...)");
                this.y = (OButton) ZeusTransformUtils.preCheckCast(r9, OButton.class, "com.obric.aiagent.plugin");
                View r10 = r7.findViewById(ZeusTransformUtils.mapRes(R.id.skill_action_progress, DbHelper.COL_ID, "skill_action_progress"));
                d.h.b.o.c(r10, "findViewById(...)");
                this.z = (ODownloadProgressView) ZeusTransformUtils.preCheckCast(r10, ODownloadProgressView.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.impl.ui.q.a(r8);
            }

            public final void a(final com.obric.aiagent.skill.manager.api.e r9, int r10, int r11) {
                d.h.b.o.e(r9, "skill");
                com.obric.aiagent.skill.manager.impl.ui.q.a(this.s, r10, r11);
                boolean r12 = SkillSearchActivity.access$getProcessingSkillSlugs$p(this.f20375a.f20373a).contains(r9.a());
                boolean r13 = SkillSearchActivity.access$getCompletedSkillSlugs$p(this.f20375a.f20373a).contains(r9.a());
                com.obric.aiagent.skill.manager.impl.ui.s.a(com.obric.aiagent.skill.manager.impl.ui.s.f20812a, this.t, r9.f(), 14.0f, true, null, 16, null);
                this.u.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.d(r9), CharSequence.class, "com.obric.aiagent.plugin"));
                this.v.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.e(r9), CharSequence.class, "com.obric.aiagent.plugin"));
                this.x.setText((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.az.g(r9), CharSequence.class, "com.obric.aiagent.plugin"));
                ch.f20743a.a(this.w, this.x, com.obric.aiagent.skill.manager.impl.az.f(r9), SkillSearchActivity.SOURCE_ICON_RADIUS_DP);
                if (r12 == false) goto L5;
                b r14 = b.f20364b;
            L21:
                OCardListItem r15 = this.s;
                final SkillSearchActivity r0 = this.f20375a.f20373a;
                r15.setOnContentClickListener(new $$Lambda$SkillSearchActivity$d$a$L8FTmEg423xWDXBPbWdzGmCOd9I(r0, r9));
                a(r9, r14);
                return;
            L5:
                if (r13 == false) goto L7;
                r14 = b.f20365c;
                goto L21
            L7:
                Iterable r16 = (Iterable) ZeusTransformUtils.preCheckCast(SkillSearchActivity.access$getLatestInstalledSkills$p(this.f20375a.f20373a), Iterable.class, "com.obric.aiagent.plugin");
                boolean r1 = false;
                if (ZeusTransformUtils.instanceOf(r16, Collection.class) == true) goto L10;
            L12:
                Iterator r17 = r16.iterator();
            L14:
                if (r17.hasNext() == false) goto L18;
                if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r17.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r9.a()) == false) goto L14;
                r1 = true;
            L18:
                if (r1 == false) goto L20;
                r14 = b.f20366d;
                goto L21
            L20:
                r14 = b.f20363a;
                goto L21
            L10:
                if (((Collection) ZeusTransformUtils.preCheckCast(r16, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L12;
                goto L12
            }

            private static final void a(SkillSearchActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3) {
                SkillSearchActivity.access$openSkillDetail((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillSearchActivity.class, "com.obric.aiagent.plugin"), r2);
            }

            private final void a(final com.obric.aiagent.skill.manager.api.e r4, b r5) {
                this.z.setVisibility(8);
                this.y.setVisibility(8);
                this.y.setEnabled(true);
                this.y.setOnClickListener(null);
                int r6 = C0429a.f20376a[r5.ordinal()];
                if (r6 != 1) goto L5;
                this.y.setVisibility(0);
                bj.a(this.y);
                this.y.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_add, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_add"));
                OButton r7 = this.y;
                final SkillSearchActivity r3 = this.f20375a.f20373a;
                r7.setOnClickListener(new $$Lambda$SkillSearchActivity$d$a$qAZj63iIPh9y1ng2WQOd5hwWNDc(r3, r4));
                return;
            L5:
                if (r6 != 2) goto L7;
                this.y.setVisibility(0);
                bj.b(this.y);
                this.y.setText(ZeusTransformUtils.mapRes(R.string.obric_skill_common_use, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_use"));
                OButton r8 = this.y;
                final SkillSearchActivity r9 = this.f20375a.f20373a;
                r8.setOnClickListener(new $$Lambda$SkillSearchActivity$d$a$ipEAqzchxS_BysM0ektVNXGhYS8(r9, r4));
                return;
            L7:
                if (r6 != 3) goto L9;
                this.z.setVisibility(0);
                this.z.setCurrentState(0);
                return;
            L9:
                if (r6 != 4) goto L12;
                this.z.setVisibility(0);
                this.z.setCurrentState(4);
                return;
            L12:
                throw new d.k();
            }

            private static final void b(SkillSearchActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3) {
                SkillSearchActivity.access$installShopSkill((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillSearchActivity.class, "com.obric.aiagent.plugin"), r2);
            }

            private static final void c(SkillSearchActivity r1, com.obric.aiagent.skill.manager.api.e r2, View r3) {
                SkillSearchActivity.access$useSearchSkill((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillSearchActivity.class, "com.obric.aiagent.plugin"), r2);
            }
        }

        public d(SkillSearchActivity r3) {
            this.f20373a = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
            this.f20374b = new ArrayList();
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public /* synthetic */ void a(RecyclerView.v r3, int r4) {
            a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public /* synthetic */ RecyclerView.v b(ViewGroup r1, int r2) {
            return (RecyclerView.v) ZeusTransformUtils.preCheckCast(a(r1, r2), RecyclerView.v.class, "com.obric.aiagent.plugin");
        }

        public final void a(List<com.obric.aiagent.skill.manager.api.e> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r5, "nextItems");
            this.f20374b.clear();
            this.f20374b.addAll((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin"));
            g();
        }

        public a a(ViewGroup r6, int r7) {
            d.h.b.o.e(r6, "parent");
            View r8 = ZeusTransformUtils.inflate(LayoutInflater.from((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")), ZeusTransformUtils.mapRes(R.layout.item_skill_search, "layout", "item_skill_search"), r6, false, "com.obric.aiagent.plugin");
            d.h.b.o.c(r8, "inflate(...)");
            return new a(this, r8);
        }

        public void a(a r5, int r6) {
            d.h.b.o.e(r5, "holder");
            SkillSearchActivity r0 = this.f20373a;
            com.obric.aiagent.skill.manager.api.e r1 = this.f20374b.get(r6);
            d.h.b.o.c(r1, "get(...)");
            r5.a(SkillSearchActivity.access$withLatestInstalledState(r0, (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")), r6, this.f20374b.size());
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.a
        public int a() {
            return this.f20374b.size();
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    public /* synthetic */ class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20377a = null;

        static {
            int[] r0 = new int[c.values().length];
            r0[c.f20369b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[c.f20370c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[c.f20371d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f20377a = r0;
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$ensureSkillObserverStarted$1")
    static final class f extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillSearchActivity f20379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f20380c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private /* synthetic */ Object f20381d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$f$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillSearchActivity.kt */
        @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {400}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$ensureSkillObserverStarted$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20382a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> f20383b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SkillSearchActivity f20384c;

            AnonymousClass1(kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r3, SkillSearchActivity r4, d.c.d<? super AnonymousClass1> r5) {
                kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r6 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
                SkillSearchActivity r7 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillSearchActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20383b = r6;
                this.f20384c = r7;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20383b, this.f20384c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r6) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f20382a;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L6;
                d.o.a(r6);
            L12:
                throw new d.d();
            L6:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                d.o.a(r6);
                kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r7 = this.f20383b;
                final SkillSearchActivity r3 = this.f20384c;
                kotlinx.coroutines.b.i<? super List<com.obric.aiagent.skill.manager.api.e>> r2 = (kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new C04301(r3), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin");
                d.c.d<?> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20382a = 1;
                if (r7.collect(r2, r4) != r0) goto L12;
                return r0;
            }
        }

        f(SkillSearchActivity r3, kotlinx.coroutines.b.ak<? extends List<com.obric.aiagent.skill.manager.api.e>> r4, d.c.d<? super f> r5) {
            SkillSearchActivity r6 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
            kotlinx.coroutines.b.ak<List<com.obric.aiagent.skill.manager.api.e>> r7 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20379b = r6;
            this.f20380c = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            f r0 = new f(this.f20379b, this.f20380c, r6);
            r0.f20381d = r4;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r0, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r9) {
            d.c.a.b.a();
            if (this.f20378a != 0) goto L18;
            d.o.a(r9);
            kotlinx.coroutines.am r2 = (kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(this.f20381d, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin");
            c r10 = null;
            kotlinx.coroutines.i.a(r2, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20380c, this.f20379b, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L7 CancellationException -> L15
        L14:
            return d.x.f38692a;
        L15:
            e = move-exception;
            throw e;
        L7:
            e = move-exception;
            ee r3 = ee.f19808a;
            StringBuilder r4 = new StringBuilder().append("Observe installed skills failed on search page: mode=");
            c r8 = SkillSearchActivity.access$getMode$p(this.f20379b);
            if (r8 != null) goto L11;
            d.h.b.o.c(SkillSearchActivity.EXTRA_MODE);
        L12:
            r3.a("SkillManager", "Observe installed skills failed on search page", r4.append(r10).toString(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            goto L14
        L11:
            r10 = r8;
            goto L12
        L18:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$installShopSkill$1")
    static final class g extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20390b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20391c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SkillSearchActivity f20392d;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$g$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillSearchActivity.kt */
        @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$installShopSkill$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20393a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillSearchActivity f20394b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20395c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20396d;

            AnonymousClass1(SkillSearchActivity r3, com.obric.aiagent.skill.manager.api.e r4, com.obric.aiagent.skill.manager.api.e r5, d.c.d<? super AnonymousClass1> r6) {
                SkillSearchActivity r7 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20394b = r7;
                this.f20395c = r4;
                this.f20396d = r5;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20394b, this.f20395c, this.f20396d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20393a != 0) goto L11;
                d.o.a(r4);
                SkillSearchActivity.access$upsertLatestInstalledSkill(this.f20394b, this.f20395c);
                SkillSearchActivity.access$getCompletedSkillSlugs$p(this.f20394b).add(this.f20396d.a());
                cm r5 = cm.f20758a;
                Activity r0 = (Activity) ZeusTransformUtils.preCheckCast(this.f20394b, Activity.class, "com.obric.aiagent.plugin");
                if (this.f20395c.l() == false) goto L7;
                cm.a r1 = cm.a.f20760a;
            L8:
                r5.a(r0, r1);
                SkillSearchActivity.access$getProcessingSkillSlugs$p(this.f20394b).remove(this.f20396d.a());
                SkillSearchActivity.access$notifyVisibleAdapterChanged(this.f20394b);
                SkillSearchActivity.access$scheduleSearchCompletionClear(this.f20394b, this.f20396d.a());
                return d.x.f38692a;
            L7:
                r1 = cm.a.g;
                goto L8
            L11:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$g$2, reason: invalid class name */
        /* JADX INFO: compiled from: SkillSearchActivity.kt */
        @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$installShopSkill$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20397a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillSearchActivity f20398b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20399c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ Exception f20400d;

            AnonymousClass2(SkillSearchActivity r3, com.obric.aiagent.skill.manager.api.e r4, Exception r5, d.c.d<? super AnonymousClass2> r6) {
                SkillSearchActivity r7 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
                d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20398b = r7;
                this.f20399c = r4;
                this.f20400d = r5;
                super(2, r8);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20398b, this.f20399c, this.f20400d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20397a != 0) goto L10;
                d.o.a(r4);
                SkillSearchActivity.access$getProcessingSkillSlugs$p(this.f20398b).remove(this.f20399c.a());
                SkillSearchActivity.access$getCompletedSkillSlugs$p(this.f20398b).remove(this.f20399c.a());
                SkillSearchActivity.access$notifyVisibleAdapterChanged(this.f20398b);
                cl.a("SkillManager", "install skill", (Throwable) ZeusTransformUtils.preCheckCast(this.f20400d, Throwable.class, "com.obric.aiagent.plugin"));
                cm.a r5 = cl.a((Throwable) ZeusTransformUtils.preCheckCast(this.f20400d, Throwable.class, "com.obric.aiagent.plugin"));
                if (r5 == null) goto L8;
                SkillSearchActivity r3 = this.f20398b;
                cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r3, Activity.class, "com.obric.aiagent.plugin"), r5);
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SkillSearchActivity.kt */
        @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$installShopSkill$1$installed$1")
        static final class a extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20401a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillSearchActivity f20402b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.e f20403c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> f20404d;

            a(SkillSearchActivity r3, com.obric.aiagent.skill.manager.api.e r4, com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r5, d.c.d<? super a> r6) {
                SkillSearchActivity r7 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
                com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r8 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20402b = r7;
                this.f20403c = r4;
                this.f20404d = r8;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f20402b, this.f20403c, this.f20404d, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r4) {
                d.c.a.b.a();
                if (this.f20401a != 0) goto L10;
                d.o.a(r4);
                SkillSearchActivity.access$getProcessingSkillSlugs$p(this.f20402b).remove(this.f20403c.a());
                SkillSearchActivity.access$getCompletedSkillSlugs$p(this.f20402b).remove(this.f20403c.a());
                SkillSearchActivity.access$notifyVisibleAdapterChanged(this.f20402b);
                a("SkillManager", "install skill failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(this.f20404d, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());
                cm.a r5 = cl.a((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(this.f20404d, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin"));
                if (r5 == null) goto L8;
                cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(this.f20402b, Activity.class, "com.obric.aiagent.plugin"), r5);
            L8:
                return d.x.f38692a;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
            public static int a(String r1, String r2) {
                if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
                return 0;
            L5:
                return Log.w(r1, r2);
            }
        }

        g(ISkillManagerService r3, com.obric.aiagent.skill.manager.api.e r4, SkillSearchActivity r5, d.c.d<? super g> r6) {
            ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            SkillSearchActivity r8 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r5, SkillSearchActivity.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20390b = r7;
            this.f20391c = r4;
            this.f20392d = r8;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new g(this.f20390b, this.f20391c, this.f20392d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f20389a != 0) goto L21;
            d.o.a(r10);
            com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.e> r1 = this.f20390b.installSkill(this.f20391c.a(), this.f20391c.d(), com.obric.aiagent.skill.manager.api.au.f19237d);     // Catch: Exception -> L14 CancellationException -> L18
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.b.class) == false) goto L9;
            com.obric.aiagent.skill.manager.api.e r2 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(((com.obric.aiagent.skill.manager.api.u.b) ZeusTransformUtils.preCheckCast(r1, com.obric.aiagent.skill.manager.api.u.b.class, "com.obric.aiagent.plugin")).a(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L14 CancellationException -> L18
            kotlinx.coroutines.i.a(SkillSearchActivity.access$getMainScope$p(this.f20392d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20392d, r2, this.f20391c, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L14 CancellationException -> L18
        L17:
            return d.x.f38692a;
        L9:
            if (ZeusTransformUtils.instanceOf(r1, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L13;
            kotlinx.coroutines.i.a(SkillSearchActivity.access$getMainScope$p(this.f20392d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(this.f20392d, this.f20391c, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: Exception -> L14 CancellationException -> L18
            return d.x.f38692a;
        L13:
            throw new d.k();     // Catch: Exception -> L14 CancellationException -> L18
        L18:
            e = move-exception;
            throw e;
        L14:
            e = move-exception;
            kotlinx.coroutines.i.a(SkillSearchActivity.access$getMainScope$p(this.f20392d), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20392d, this.f20391c, e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
            goto L17
        L21:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {545}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$loadNextShopSearchPage$1")
    static final class h extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20405a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f20406b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SkillSearchActivity f20407c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f20408d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ gy f20409e;

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$h$1, reason: invalid class name */
        /* JADX INFO: compiled from: SkillSearchActivity.kt */
        @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$loadNextShopSearchPage$1$1")
        static final class AnonymousClass1 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20410a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillSearchActivity f20411b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f20412c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ gy f20413d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.obric.aiagent.skill.manager.impl.an<com.obric.aiagent.skill.manager.api.e> f20414e;

            AnonymousClass1(SkillSearchActivity r3, String r4, gy r5, com.obric.aiagent.skill.manager.impl.an<com.obric.aiagent.skill.manager.api.e> r6, d.c.d<? super AnonymousClass1> r7) {
                SkillSearchActivity r8 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20411b = r8;
                this.f20412c = r4;
                this.f20413d = r5;
                this.f20414e = r6;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass1.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20411b, this.f20412c, this.f20413d, this.f20414e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f20410a != 0) goto L17;
                d.o.a(r3);
                if (d.h.b.o.a(SkillSearchActivity.access$getCurrentKeyword$p(this.f20411b), this.f20412c) == false) goto L15;
                c r4 = SkillSearchActivity.access$getMode$p(this.f20411b);
                if (r4 != null) goto L10;
                d.h.b.o.c(SkillSearchActivity.EXTRA_MODE);
                r4 = null;
            L10:
                if (r4 != c.f20369b) goto L15;
                if (SkillSearchActivity.access$getShopPager(this.f20411b).a(this.f20413d, this.f20414e) == false) goto L15;
                SkillSearchActivity.access$getShopLoadMoreAdapter(this.f20411b).b_(false);
                SkillSearchActivity r2 = this.f20411b;
                SkillSearchActivity.access$renderResult(r2, SkillSearchActivity.access$getShopPager(r2).a());
            L15:
                return d.x.f38692a;
            L17:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$h$2, reason: invalid class name */
        /* JADX INFO: compiled from: SkillSearchActivity.kt */
        @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$loadNextShopSearchPage$1$2")
        static final class AnonymousClass2 extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f20415a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ SkillSearchActivity f20416b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f20417c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ gy f20418d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Exception f20419e;

            AnonymousClass2(SkillSearchActivity r3, String r4, gy r5, Exception r6, d.c.d<? super AnonymousClass2> r7) {
                SkillSearchActivity r8 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
                this.f20416b = r8;
                this.f20417c = r4;
                this.f20418d = r5;
                this.f20419e = r6;
                super(2, r9);
            }

            public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return ((AnonymousClass2) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), AnonymousClass2.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
                d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20416b, this.f20417c, this.f20418d, this.f20419e, r6), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
                return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r2) {
                d.c.a.b.a();
                if (this.f20415a != 0) goto L20;
                d.o.a(r2);
                if (d.h.b.o.a(SkillSearchActivity.access$getCurrentKeyword$p(this.f20416b), this.f20417c) == false) goto L18;
                c r3 = SkillSearchActivity.access$getMode$p(this.f20416b);
                if (r3 != null) goto L10;
                d.h.b.o.c(SkillSearchActivity.EXTRA_MODE);
                r3 = null;
            L10:
                if (r3 != c.f20369b) goto L18;
                if (SkillSearchActivity.access$getShopPager(this.f20416b).a(this.f20418d) == false) goto L18;
                SkillSearchActivity.access$getShopLoadMoreAdapter(this.f20416b).b_(false);
                if (this.f20418d.b() != 1) goto L16;
                SkillSearchActivity.access$renderResult(this.f20416b, d.a.p.b());
            L16:
                cl.a("SkillManager", "search shop skills", (Throwable) ZeusTransformUtils.preCheckCast(this.f20419e, Throwable.class, "com.obric.aiagent.plugin"));
            L18:
                return d.x.f38692a;
            L20:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        h(boolean r3, SkillSearchActivity r4, String r5, gy r6, d.c.d<? super h> r7) {
            SkillSearchActivity r8 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillSearchActivity.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20406b = r3;
            this.f20407c = r8;
            this.f20408d = r5;
            this.f20409e = r6;
            super(2, r9);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), h.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r8, d.c.d<?> r9) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new h(this.f20406b, this.f20407c, this.f20408d, this.f20409e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r26) {
            Object r0 = d.c.a.b.a();
            int r5 = this.f20405a;
            if (r5 == 0) goto L8;
            if (r5 != 1) goto L7;
            d.o.a(r26);
        L13:
            ea r6 = new ea(dy.q, SkillSearchActivity.access$getTrackingReporter$p(this.f20407c), null, 0, null, 0, false, BDImageUploader.MessageIsPreHeatResultUsed, null);
            com.obric.aiagent.skill.manager.impl.an<com.obric.aiagent.skill.manager.api.e> r1 = SkillSearchActivity.access$getShopRepository$p(this.f20407c).a(null, this.f20408d, this.f20409e.b(), this.f20409e.c());     // Catch: Exception -> L20 CancellationException -> L24
            ea.a(r6, dz.f19791a, null, null, null, null, null, null, null, null, null, d.a.ao.a(new d.m[]{d.s.a("page_type", "search"), d.s.a("item_count", d.c.b.a.b.a(r1.a().size())), d.s.a("page_number", d.c.b.a.b.a(this.f20409e.b()))}), DownloadErrorCode.ERROR_NO_CONNECTION, null);     // Catch: CancellationException -> L18 Exception -> L20
            kotlinx.coroutines.i.a(SkillSearchActivity.access$getMainScope$p(this.f20407c), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.f20407c, this.f20408d, this.f20409e, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);     // Catch: CancellationException -> L18 Exception -> L20
        L23:
            return d.x.f38692a;
        L18:
            e = e;
            int r8 = 2;
        L26:
            dz r9 = dz.f19793c;
            dw r15 = dw.n;
            d.m[] r7 = new d.m[r8];
            r7[0] = d.s.a("page_type", "search");
            r7[1] = d.s.a("page_number", d.c.b.a.b.a(this.f20409e.b()));
            ea.a(r6, r9, null, null, null, null, null, r15, "superseded", null, null, d.a.ao.a(r7), 830, null);
            throw e;
        L20:
            e = move-exception;
            ea.a(r6, dz.f19792b, null, null, null, null, null, eb.a((Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin")), "search_request", d.c.b.a.b.a(true), null, d.a.ao.a(new d.m[]{d.s.a("page_type", "search"), d.s.a("page_number", d.c.b.a.b.a(this.f20409e.b()))}), 574, null);
            kotlinx.coroutines.i.a(SkillSearchActivity.access$getMainScope$p(this.f20407c), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.f20407c, this.f20408d, this.f20409e, e, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        L24:
            e = e;
            r8 = 2;
            goto L26
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r26);
            if (this.f20406b == false) goto L13;
            d.c.d r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20405a = 1;
            if (kotlinx.coroutines.ax.a(SkillSearchActivity.SEARCH_DEBOUNCE_MS, r10) != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    /* synthetic */ class i extends d.h.b.l implements d.h.a.b<ISkillManagerService, d.x> {
        i(Object r8) {
            super(1, r8, SkillSearchActivity.class, "initializeSkillPage", "initializeSkillPage(Lcom/obric/aiagent/skill/manager/api/ISkillManagerService;)V", 0);
        }

        public final void a(ISkillManagerService r3) {
            ISkillManagerService r4 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r4, "p0");
            SkillSearchActivity.access$initializeSkillPage((SkillSearchActivity) ZeusTransformUtils.preCheckCast(this.receiver, SkillSearchActivity.class, "com.obric.aiagent.plugin"), r4);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(ISkillManagerService r3) {
            a((ISkillManagerService) ZeusTransformUtils.preCheckCast(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {379}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$refreshInstalledStoreMetadata$1")
    static final class j extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillManager f20421b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Set<String> f20422c;

        j(SkillManager r3, Set<String> r4, d.c.d<? super j> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20421b = r3;
            this.f20422c = r6;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f20421b, this.f20422c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20420a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            gx r5 = (gx) ZeusTransformUtils.preCheckCast(r6, gx.class, "com.obric.aiagent.plugin");
            if (r5.b() <= 0) goto L15;
            ee.f19808a.c("SkillManager", "Management search Store Skill presentation refresh partially failed", "Management search Store Skill presentation refresh partially failed: failures=" + r5.b() + ", total=" + r5.a().size());
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            SkillManager r7 = this.f20421b;
            Set<String> r2 = this.f20422c;
            d.c.d<? super gx> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20420a = 1;
            r6 = r7.refreshInstalledStoreMetadata$impl_release(r2, r4);
            if (r6 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    /* synthetic */ class l extends d.h.b.l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f20424a = null;

        static {
            f20424a = new l();
        }

        l() {
            super(1, d.o.o.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            d.h.b.o.e(r2, "p0");
            return Boolean.valueOf(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {455, 460}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$requestManagementDecisionRefreshOnce$1")
    static final class m extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20425a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Set<String> f20426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISkillManagerService f20427c;

        m(Set<String> r3, ISkillManagerService r4, d.c.d<? super m> r5) {
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
            ISkillManagerService r7 = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillManagerService.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20426b = r6;
            this.f20427c = r7;
            super(2, r8);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((m) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), m.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new m(this.f20426b, this.f20427c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20425a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r7);
        L19:
            com.obric.aiagent.skill.manager.api.u r6 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
        L21:
            if (ZeusTransformUtils.instanceOf(r6, com.obric.aiagent.skill.manager.api.u.a.class) == false) goto L24;
            ee.f19808a.c("SkillManager", "Management search Skill security refresh failed", "Management search Skill security refresh failed: code=" + ((com.obric.aiagent.skill.manager.api.u.a) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.manager.api.u.a.class, "com.obric.aiagent.plugin")).a());
        L24:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r7);
        L15:
            r6 = (com.obric.aiagent.skill.manager.api.u) ZeusTransformUtils.preCheckCast(r7, com.obric.aiagent.skill.manager.api.u.class, "com.obric.aiagent.plugin");
            goto L21
        L10:
            d.o.a(r7);
            com.obric.aiagent.skill.manager.api.ap.b r8 = new com.obric.aiagent.skill.manager.api.ap.b(this.f20426b);
            if (ZeusTransformUtils.instanceOf(this.f20427c, SkillManager.class) == false) goto L16;
            SkillManager r2 = (SkillManager) ZeusTransformUtils.preCheckCast(this.f20427c, SkillManager.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.manager.api.ap r9 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
            com.obric.aiagent.skill.manager.impl.aw r3 = com.obric.aiagent.skill.manager.impl.aw.g;
            d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20425a = 1;
            r7 = r2.refreshSkillSignatures$impl_release(r9, r3, r5);
            if (r7 != r0) goto L15;
            return r0;
        L16:
            ISkillManagerService r4 = this.f20427c;
            com.obric.aiagent.skill.manager.api.ap r10 = (com.obric.aiagent.skill.manager.api.ap) ZeusTransformUtils.preCheckCast(r8, com.obric.aiagent.skill.manager.api.ap.class, "com.obric.aiagent.plugin");
            d.c.d<? super com.obric.aiagent.skill.manager.api.u<com.obric.aiagent.skill.manager.api.ao>> r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20425a = 2;
            r7 = r4.refreshSkillSignatures(r10, r11);
            if (r7 != r0) goto L19;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    /* synthetic */ class n extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.api.e, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final n f20428a = null;

        static {
            f20428a = new n();
        }

        n() {
            super(1, com.obric.aiagent.skill.manager.impl.az.class, "requiresLocalSigning", "requiresLocalSigning(Lcom/obric/aiagent/skill/manager/api/Skill;)Z", 1);
        }

        public final Boolean a(com.obric.aiagent.skill.manager.api.e r1) {
            d.h.b.o.e(r1, "p0");
            return Boolean.valueOf(com.obric.aiagent.skill.manager.impl.az.b(r1));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(com.obric.aiagent.skill.manager.api.e r3) {
            return a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    /* synthetic */ class p extends d.h.b.l implements d.h.a.b<String, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f20430a = null;

        static {
            f20430a = new p();
        }

        p() {
            super(1, d.o.o.class, "isNotBlank", "isNotBlank(Ljava/lang/CharSequence;)Z", 1);
        }

        public final Boolean a(String r2) {
            d.h.b.o.e(r2, "p0");
            return Boolean.valueOf(!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin")));
        }

        @Override // d.h.a.b
        public /* synthetic */ Boolean invoke(String r3) {
            return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    @d.c.b.a.f(b = "SkillSearchActivity.kt", c = {EntityType.COUNTDOWN}, d = "invokeSuspend", e = "com.obric.aiagent.skill.manager.impl.ui.SkillSearchActivity$scheduleSearchCompletionClear$1")
    static final class q extends d.c.b.a.l implements d.h.a.m<kotlinx.coroutines.am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f20431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillSearchActivity f20432b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f20433c;

        q(SkillSearchActivity r3, String r4, d.c.d<? super q> r5) {
            SkillSearchActivity r6 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20432b = r6;
            this.f20433c = r4;
            super(2, r7);
        }

        public final Object a(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return ((q) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.am) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), q.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new q(this.f20432b, this.f20433c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(kotlinx.coroutines.am r3, d.c.d<? super d.x> r4) {
            return a((kotlinx.coroutines.am) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f20431a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            if (SkillSearchActivity.access$getCompletedSkillSlugs$p(this.f20432b).remove(this.f20433c) == false) goto L15;
            SkillSearchActivity.access$notifyVisibleAdapterChanged(this.f20432b);
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f20431a = 1;
            if (kotlinx.coroutines.ax.a(1000, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    public static final class r extends WindowInsetsAnimationCompat.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SkillSearchActivity f20434b;

        r(SkillSearchActivity r3) {
            this.f20434b = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
            super(1);
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public void a(WindowInsetsAnimationCompat r2) {
            d.h.b.o.e(r2, "animation");
            if (SkillSearchActivity.access$isImeAnimation(this.f20434b, r2) == true) goto L5;
            return;
        L5:
            SkillSearchActivity r1 = this.f20434b;
            OPageStatus r3 = SkillSearchActivity.access$getEmptyStatus$p(r1);
            if (r3 != null) goto L8;
            d.h.b.o.c("emptyStatus");
            r3 = null;
        L8:
            SkillSearchActivity.access$setEmptyStatusImeStartY$p(r1, Float.valueOf(r3.getY()));
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public WindowInsetsAnimationCompat.a a(WindowInsetsAnimationCompat r5, WindowInsetsAnimationCompat.a r6) {
            d.h.b.o.e(r5, "animation");
            d.h.b.o.e(r6, "bounds");
            if (SkillSearchActivity.access$isImeAnimation(this.f20434b, r5) == true) goto L5;
            return r6;
        L5:
            Float r7 = SkillSearchActivity.access$getEmptyStatusImeStartY$p(this.f20434b);
            OPageStatus r0 = null;
            if (r7 == null) goto L8;
            float r8 = r7.floatValue();
        L12:
            OPageStatus r2 = SkillSearchActivity.access$getEmptyStatus$p(this.f20434b);
            if (r2 != null) goto L15;
            d.h.b.o.c("emptyStatus");
            r2 = null;
        L15:
            r2.setTranslationY(0.0f);
            SkillSearchActivity r3 = this.f20434b;
            OPageStatus r4 = SkillSearchActivity.access$getEmptyStatus$p(r3);
            if (r4 != null) goto L18;
            d.h.b.o.c("emptyStatus");
            r4 = null;
        L18:
            SkillSearchActivity.access$setEmptyStatusImeTranslationY$p(r3, r8 - r4.getTop());
            OPageStatus r9 = SkillSearchActivity.access$getEmptyStatus$p(this.f20434b);
            if (r9 != null) goto L21;
            d.h.b.o.c("emptyStatus");
        L22:
            r0.setTranslationY(SkillSearchActivity.access$getEmptyStatusImeTranslationY$p(this.f20434b));
            return r6;
        L21:
            r0 = r9;
            goto L22
        L8:
            OPageStatus r10 = SkillSearchActivity.access$getEmptyStatus$p(this.f20434b);
            if (r10 != null) goto L11;
            d.h.b.o.c("emptyStatus");
            r10 = null;
        L11:
            r8 = r10.getY();
            goto L12
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public androidx.core.view.al a(androidx.core.view.al r6, List<WindowInsetsAnimationCompat> r7) {
            List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r6, "insets");
            d.h.b.o.e(r8, "runningAnimations");
            Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
            SkillSearchActivity r0 = this.f20434b;
            Iterator r10 = r9.iterator();
        L3:
            OPageStatus r3 = null;
            if (r10.hasNext() == false) goto L8;
            Object r2 = r10.next();
            if (SkillSearchActivity.access$isImeAnimation(r0, (WindowInsetsAnimationCompat) ZeusTransformUtils.preCheckCast(r2, WindowInsetsAnimationCompat.class, "com.obric.aiagent.plugin")) == false) goto L3;
        L9:
            WindowInsetsAnimationCompat r11 = (WindowInsetsAnimationCompat) ZeusTransformUtils.preCheckCast(r2, WindowInsetsAnimationCompat.class, "com.obric.aiagent.plugin");
            if (r11 != null) goto L12;
            return r6;
        L12:
            OPageStatus r1 = SkillSearchActivity.access$getEmptyStatus$p(this.f20434b);
            if (r1 != null) goto L15;
            d.h.b.o.c("emptyStatus");
        L16:
            r3.setTranslationY(SkillSearchActivity.access$getEmptyStatusImeTranslationY$p(this.f20434b) * (1.0f - r11.b()));
            return r6;
        L15:
            r3 = r1;
            goto L16
        L8:
            r2 = null;
            goto L9
        }

        @Override // androidx.core.view.WindowInsetsAnimationCompat.b
        public void b(WindowInsetsAnimationCompat r3) {
            d.h.b.o.e(r3, "animation");
            if (SkillSearchActivity.access$isImeAnimation(this.f20434b, r3) == true) goto L5;
            return;
        L5:
            OPageStatus r4 = SkillSearchActivity.access$getEmptyStatus$p(this.f20434b);
            if (r4 != null) goto L8;
            d.h.b.o.c("emptyStatus");
            r4 = null;
        L8:
            r4.setTranslationY(0.0f);
            SkillSearchActivity.access$setEmptyStatusImeStartY$p(this.f20434b, null);
            SkillSearchActivity.access$setEmptyStatusImeTranslationY$p(this.f20434b, 0.0f);
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    public static final class s extends RecyclerView.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkillSearchActivity f20435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f20436b;

        public static /* synthetic */ void lambda$IlWOjdu36YzKarvQEl6Q7mZaH7U(SkillSearchActivity r0) {
            a(r0);
        }

        s(SkillSearchActivity r3, LinearLayoutManager r4) {
            this.f20435a = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
            this.f20436b = r4;
        }

        @Override // com.obric.oui.orecyclerview.widget.RecyclerView.m
        public void a(RecyclerView r3, int r4, int r5) {
            d.h.b.o.e(r3, "recyclerView");
            if (r5 <= 0) goto L18;
            d r6 = SkillSearchActivity.access$getShopAdapter$p(this.f20435a);
            d r7 = null;
            if (r6 != null) goto L8;
            d.h.b.o.c("shopAdapter");
            r6 = null;
        L8:
            if (r6.a() == 0) goto L20;
            int r8 = this.f20436b.q();
            d r1 = SkillSearchActivity.access$getShopAdapter$p(this.f20435a);
            if (r1 != null) goto L13;
            d.h.b.o.c("shopAdapter");
        L15:
            if (r8 < (r7.a() - 1)) goto L19;
            final SkillSearchActivity r2 = this.f20435a;
            r3.post(new $$Lambda$SkillSearchActivity$s$IlWOjdu36YzKarvQEl6Q7mZaH7U(r2));
            return;
        L19:
            return;
        L13:
            r7 = r1;
            goto L15
        L20:
            return;
        }

        private static final void a(SkillSearchActivity r4) {
            SkillSearchActivity r5 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r4, SkillSearchActivity.class, "com.obric.aiagent.plugin");
            SkillSearchActivity.loadNextShopSearchPage$default(r5, SkillSearchActivity.access$getCurrentKeyword$p(r5), false, 2, null);
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    /* synthetic */ class t extends d.h.b.l implements d.h.a.b<com.obric.aiagent.skill.manager.api.e, d.x> {
        t(Object r8) {
            super(1, r8, com.obric.aiagent.skill.manager.impl.ui.g.class, "onToggleRequested", "onToggleRequested(Lcom/obric/aiagent/skill/manager/api/Skill;)V", 0);
        }

        public final void a(com.obric.aiagent.skill.manager.api.e r3) {
            d.h.b.o.e(r3, "p0");
            ((com.obric.aiagent.skill.manager.impl.ui.g) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.ui.g.class, "com.obric.aiagent.plugin")).a(r3);
        }

        @Override // d.h.a.b
        public /* synthetic */ d.x invoke(com.obric.aiagent.skill.manager.api.e r3) {
            a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"));
            return d.x.f38692a;
        }
    }

    /* JADX INFO: compiled from: SkillSearchActivity.kt */
    /* synthetic */ class u extends d.h.b.l implements d.h.a.a<d.x> {
        u(Object r8) {
            super(0, r8, com.obric.aiagent.skill.manager.impl.ui.g.class, "onSecurityBlocked", "onSecurityBlocked()V", 0);
        }

        public final void a() {
            ((com.obric.aiagent.skill.manager.impl.ui.g) ZeusTransformUtils.preCheckCast(this.receiver, com.obric.aiagent.skill.manager.impl.ui.g.class, "com.obric.aiagent.plugin")).a();
        }

        @Override // d.h.a.a
        public /* synthetic */ d.x invoke() {
            a();
            return d.x.f38692a;
        }
    }

    static {
        Companion = new a(null);
    }

    public static /* synthetic */ d.x lambda$AucDsMaCfOo3VUucoNoZ5UpZ4PI(SkillSearchActivity r0, com.obric.aiagent.skill.manager.api.e r1) {
        return setupSearchPage$lambda$8(r0, r1);
    }

    public static /* synthetic */ void lambda$H_x8_sMa2IrGtyzHb0e8_pALjSs(SkillSearchActivity r0, View r1) {
        setupSearchPage$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$IW_4DITkdoR8vI8dE-3hJ6SBdpw, reason: not valid java name */
    public static /* synthetic */ String m314lambda$IW_4DITkdoR8vI8dE3hJ6SBdpw(com.obric.aiagent.skill.manager.api.e r0) {
        return shopPager_delegate$lambda$1$lambda$0(r0);
    }

    public static /* synthetic */ d.x lambda$J0XiE6oBOPpKlxOfT_5TdYBx4UY(SkillSearchActivity r0) {
        return setupSearchPage$lambda$7(r0);
    }

    /* JADX INFO: renamed from: lambda$OKHt9S-x8jr1wgtJE6APnPxh7G4, reason: not valid java name */
    public static /* synthetic */ androidx.core.view.al m315lambda$OKHt9Sx8jr1wgtJE6APnPxh7G4(SkillSearchActivity r0, View r1, androidx.core.view.al r2) {
        return setupEmptyStatusImeMotion$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ ISkillManagerService lambda$WdEv7oVmJoEXE8I5PbjpUM4wrlk(SkillSearchActivity r0) {
        return setupSearchPage$lambda$6(r0);
    }

    public static /* synthetic */ d.x lambda$d2OF2w2LGKDTh8jINwInSXQWBdQ(SkillSearchActivity r0, com.obric.aiagent.skill.manager.api.e r1, d.h.a.a r2) {
        return setupSearchPage$lambda$5(r0, r1, r2);
    }

    /* JADX INFO: renamed from: lambda$dfaP13-OXQqX5HvBPNlJ2tkLPLU, reason: not valid java name */
    public static /* synthetic */ d.x m316lambda$dfaP13OXQqX5HvBPNlJ2tkLPLU(SkillSearchActivity r0, String r1) {
        return useSearchSkill$lambda$18$lambda$17(r0, r1);
    }

    public static /* synthetic */ boolean lambda$hdKh7t_HzKdKNbsmkXkCnvrLei0(com.obric.aiagent.skill.manager.api.e r0) {
        return refreshInstalledStoreMetadata$lambda$11(r0);
    }

    /* JADX INFO: renamed from: lambda$n9spfW8WHNUpVszuA-IY9YInbaM, reason: not valid java name */
    public static /* synthetic */ gz m317lambda$n9spfW8WHNUpVszuAIY9YInbaM() {
        return shopPager_delegate$lambda$1();
    }

    public static /* synthetic */ boolean lambda$nOLlBjuN1OjX7feD5IHOJYvohbQ(SkillSearchActivity r0, com.obric.aiagent.skill.manager.api.e r1) {
        return requestManagementDecisionRefreshOnce$lambda$12(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$nruAqVxIc2pl_k-QuYbz9CD1ZfU, reason: not valid java name */
    public static /* synthetic */ ck m318lambda$nruAqVxIc2pl_kQuYbz9CD1ZfU() {
        return shopLoadMoreAdapter_delegate$lambda$2();
    }

    public static /* synthetic */ void lambda$vAHyVcyhlYKlnKppvjBnPxRm7Ik(SkillSearchActivity r0, OEditText r1) {
        requestInitialSearchFocusAndIme$lambda$10(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$wkGaMi2xe9TXfrd1fu-PdBbOV38, reason: not valid java name */
    public static /* synthetic */ d.x m319lambda$wkGaMi2xe9TXfrd1fuPdBbOV38(com.obric.aiagent.skill.manager.api.e r0, SkillSearchActivity r1) {
        return useSearchSkill$lambda$18(r0, r1);
    }

    public SkillSearchActivity() {
        this.latestInstalledSkills = new ArrayList();
        this.processingSkillSlugs = new HashSet();
        this.completedSkillSlugs = new HashSet();
        this.ioScope = kotlinx.coroutines.an.a(kotlinx.coroutines.bd.c().plus((d.c.g) ZeusTransformUtils.preCheckCast(cx.a(null, 1, null), d.c.g.class, "com.obric.aiagent.plugin")));
        this.mainScope = kotlinx.coroutines.an.a();
        this.shopRepository = new ft();
        this.trackingReporter = new hd(null, null, null, 7, null);
        this.shopPager$delegate = d.g.a($$Lambda$SkillSearchActivity$n9spfW8WHNUpVszuAIY9YInbaM.INSTANCE);
        this.shopLoadMoreAdapter$delegate = d.g.a($$Lambda$SkillSearchActivity$nruAqVxIc2pl_kQuYbz9CD1ZfU.INSTANCE);
        this.currentKeyword = "";
        this.shouldShowInitialIme = true;
    }

    public static final /* synthetic */ HashSet access$getCompletedSkillSlugs$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).completedSkillSlugs;
    }

    public static final /* synthetic */ String access$getCurrentKeyword$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).currentKeyword;
    }

    public static final /* synthetic */ OPageStatus access$getEmptyStatus$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).emptyStatus;
    }

    public static final /* synthetic */ Float access$getEmptyStatusImeStartY$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).emptyStatusImeStartY;
    }

    public static final /* synthetic */ float access$getEmptyStatusImeTranslationY$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).emptyStatusImeTranslationY;
    }

    public static final /* synthetic */ ArrayList access$getLatestInstalledSkills$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).latestInstalledSkills;
    }

    public static final /* synthetic */ kotlinx.coroutines.am access$getMainScope$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).mainScope;
    }

    public static final /* synthetic */ c access$getMode$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).mode;
    }

    public static final /* synthetic */ HashSet access$getProcessingSkillSlugs$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).processingSkillSlugs;
    }

    public static final /* synthetic */ d access$getShopAdapter$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).shopAdapter;
    }

    public static final /* synthetic */ ck access$getShopLoadMoreAdapter(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).getShopLoadMoreAdapter();
    }

    public static final /* synthetic */ gz access$getShopPager(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).getShopPager();
    }

    public static final /* synthetic */ ft access$getShopRepository$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).shopRepository;
    }

    public static final /* synthetic */ hd access$getTrackingReporter$p(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).trackingReporter;
    }

    public static final /* synthetic */ void access$initializeSkillPage(SkillSearchActivity r2, ISkillManagerService r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).initializeSkillPage((ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$installShopSkill(SkillSearchActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).installShopSkill(r3);
    }

    public static final /* synthetic */ boolean access$isImeAnimation(SkillSearchActivity r2, WindowInsetsAnimationCompat r3) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).isImeAnimation(r3);
    }

    public static final /* synthetic */ void access$notifyVisibleAdapterChanged(SkillSearchActivity r2) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).notifyVisibleAdapterChanged();
    }

    public static final /* synthetic */ void access$onKeywordChanged(SkillSearchActivity r2, String r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).onKeywordChanged(r3);
    }

    public static final /* synthetic */ void access$openSkillDetail(SkillSearchActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).openSkillDetail(r3);
    }

    public static final /* synthetic */ void access$renderInstalledSearch(SkillSearchActivity r2, String r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).renderInstalledSearch(r3);
    }

    public static final /* synthetic */ void access$renderResult(SkillSearchActivity r2, List r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).renderResult((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$requestManagementDecisionRefreshOnce(SkillSearchActivity r2) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).requestManagementDecisionRefreshOnce();
    }

    public static final /* synthetic */ void access$scheduleSearchCompletionClear(SkillSearchActivity r2, String r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).scheduleSearchCompletionClear(r3);
    }

    public static final /* synthetic */ void access$setEmptyStatusImeStartY$p(SkillSearchActivity r2, Float r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).emptyStatusImeStartY = r3;
    }

    public static final /* synthetic */ void access$setEmptyStatusImeTranslationY$p(SkillSearchActivity r2, float r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).emptyStatusImeTranslationY = r3;
    }

    public static final /* synthetic */ void access$upsertLatestInstalledSkill(SkillSearchActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).upsertLatestInstalledSkill(r3);
    }

    public static final /* synthetic */ void access$useSearchSkill(SkillSearchActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).useSearchSkill(r3);
    }

    public static final /* synthetic */ com.obric.aiagent.skill.manager.api.e access$withLatestInstalledState(SkillSearchActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).withLatestInstalledState(r3);
    }

    private final gz<com.obric.aiagent.skill.manager.api.e> getShopPager() {
        return (gz) ZeusTransformUtils.preCheckCast(this.shopPager$delegate.b(), gz.class, "com.obric.aiagent.plugin");
    }

    private static final gz shopPager_delegate$lambda$1() {
        return new gz(0, $$Lambda$SkillSearchActivity$IW_4DITkdoR8vI8dE3hJ6SBdpw.INSTANCE, 1, null);
    }

    private static final String shopPager_delegate$lambda$1$lambda$0(com.obric.aiagent.skill.manager.api.e r1) {
        d.h.b.o.e(r1, "it");
        return r1.a();
    }

    private final ck getShopLoadMoreAdapter() {
        return (ck) ZeusTransformUtils.preCheckCast(this.shopLoadMoreAdapter$delegate.b(), ck.class, "com.obric.aiagent.plugin");
    }

    private static final ck shopLoadMoreAdapter_delegate$lambda$2() {
        return new ck();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r4) {
        super.onCreate(r4);
        this.mode = c.f20368a.a(getIntent().getStringExtra(EXTRA_MODE));
        configureSystemBars();
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_skill_search, "layout", "activity_skill_search"));
        installSkillPageGuard(ZeusTransformUtils.mapRes(R.id.skill_search_root, DbHelper.COL_ID, "skill_search_root"), (d.h.a.b) ZeusTransformUtils.preCheckCast(new i(this), d.h.a.b.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity
    public OFloatingTitleBar getFloatingTitleBar() {
        OFloatingTitleBar r1 = this.searchTitleBar;
        if (r1 == null) goto L7;
        if (r1 != null) goto L8;
        d.h.b.o.c("searchTitleBar");
        goto L7
    L8:
        return r1;
    L7:
        return null;
    }

    public void onWindowFocusChanged(boolean r1) {
        super.onWindowFocusChanged(r1);
        if (r1 == false) goto L6;
        requestInitialSearchFocusAndIme();
        return;
    }

    private final void initializeSkillPage(ISkillManagerService r3) {
        this.skillManager = (ISkillManagerService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillManagerService.class, "com.obric.aiagent.plugin");
        bindViews();
        setupEmptyStatusImeMotion();
        setupSearchPage();
        ensureSkillObserverStarted();
        renderInitialState();
        requestManagementDecisionRefreshOnce();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        View r0 = this.searchRoot;
        if (r0 != null) goto L5;
    L11:
        kotlinx.coroutines.ca r1 = this.searchJob;
        if (r1 == null) goto L14;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L14:
        kotlinx.coroutines.ca r2 = this.skillStateJob;
        if (r2 == null) goto L17;
        kotlinx.coroutines.ca.a.a(r2, null, 1, null);
    L17:
        kotlinx.coroutines.ca r3 = this.storeMetadataRefreshJob;
        if (r3 == null) goto L20;
        kotlinx.coroutines.ca.a.a(r3, null, 1, null);
    L20:
        kotlinx.coroutines.ca r4 = this.decisionRefreshJob;
        if (r4 == null) goto L23;
        kotlinx.coroutines.ca.a.a(r4, null, 1, null);
    L23:
        kotlinx.coroutines.an.a(this.ioScope, null, 1, null);
        kotlinx.coroutines.an.a(this.mainScope, null, 1, null);
        super.onDestroy();
        return;
    L5:
        if (r0 != null) goto L7;
        d.h.b.o.c("searchRoot");
        r0 = null;
    L7:
        ViewCompat.a(r0, null);
        View r5 = this.searchRoot;
        if (r5 != null) goto L10;
        d.h.b.o.c("searchRoot");
        r5 = null;
    L10:
        ViewCompat.a(r5, null);
        goto L11
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity, androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        this.searchPageVisible = true;
        requestManagementDecisionRefreshOnce();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStop() {
        this.searchPageVisible = false;
        kotlinx.coroutines.ca r1 = this.decisionRefreshJob;
        if (r1 == null) goto L5;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L5:
        this.decisionRefreshJob = null;
        this.decisionRefreshRequested = false;
        super.onStop();
    }

    private final void configureSystemBars() {
        bh.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), false, 0, false, 7, null);
    }

    private final void bindViews() {
        View r0 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_search_root, DbHelper.COL_ID, "skill_search_root"));
        d.h.b.o.c(r0, "findViewById(...)");
        this.searchRoot = r0;
        View r1 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_search_title_bar, DbHelper.COL_ID, "skill_search_title_bar"));
        d.h.b.o.c(r1, "findViewById(...)");
        OFloatingTitleBar r2 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r1, OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        this.searchTitleBar = r2;
        OPageStatus r3 = null;
        if (r2 != null) goto L5;
        d.h.b.o.c("searchTitleBar");
        r2 = null;
    L5:
        r2.setFloatingTransitionEnabled(true);
        View r4 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_search_bar, DbHelper.COL_ID, "skill_search_bar"));
        d.h.b.o.c(r4, "findViewById(...)");
        this.searchBar = (OSearchBar) ZeusTransformUtils.preCheckCast(r4, OSearchBar.class, "com.obric.aiagent.plugin");
        View r5 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_search_list, DbHelper.COL_ID, "skill_search_list"));
        d.h.b.o.c(r5, "findViewById(...)");
        RecyclerView r6 = (RecyclerView) ZeusTransformUtils.preCheckCast(r5, RecyclerView.class, "com.obric.aiagent.plugin");
        this.searchList = r6;
        if (r6 != null) goto L8;
        d.h.b.o.c("searchList");
        r6 = null;
    L8:
        bh.a(r6, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.skill_navigation_list_extra_bottom, "dimen", "skill_navigation_list_extra_bottom")));
        View r7 = findViewById(ZeusTransformUtils.mapRes(R.id.skill_search_empty, DbHelper.COL_ID, "skill_search_empty"));
        d.h.b.o.c(r7, "findViewById(...)");
        OPageStatus r8 = (OPageStatus) ZeusTransformUtils.preCheckCast(r7, OPageStatus.class, "com.obric.aiagent.plugin");
        this.emptyStatus = r8;
        if (r8 != null) goto L11;
        d.h.b.o.c("emptyStatus");
        r8 = null;
    L11:
        this.emptyStatusInitialTopPadding = r8.getPaddingTop();
        OPageStatus r9 = this.emptyStatus;
        if (r9 != null) goto L14;
        d.h.b.o.c("emptyStatus");
    L15:
        this.emptyStatusInitialBottomPadding = r3.getPaddingBottom();
        return;
    L14:
        r3 = r9;
        goto L15
    }

    private final void setupEmptyStatusImeMotion() {
        View r0 = this.searchRoot;
        View r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("searchRoot");
        r0 = null;
    L5:
        ViewCompat.a(r0, new $$Lambda$SkillSearchActivity$OKHt9Sx8jr1wgtJE6APnPxh7G4(this));
        View r2 = this.searchRoot;
        if (r2 != null) goto L8;
        d.h.b.o.c("searchRoot");
        r2 = null;
    L8:
        ViewCompat.a(r2, (WindowInsetsAnimationCompat.b) ZeusTransformUtils.preCheckCast(new r(this), WindowInsetsAnimationCompat.b.class, "com.obric.aiagent.plugin"));
        View r6 = this.searchRoot;
        if (r6 != null) goto L11;
        d.h.b.o.c("searchRoot");
    L12:
        ViewCompat.u(r1);
        return;
    L11:
        r1 = r6;
        goto L12
    }

    private static final androidx.core.view.al setupEmptyStatusImeMotion$lambda$3(SkillSearchActivity r2, View r3, androidx.core.view.al r4) {
        SkillSearchActivity r5 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<unused var>");
        d.h.b.o.e(r4, "insets");
        r5.updateEmptyStatusImePadding(r4);
        return r4;
    }

    private final boolean isImeAnimation(WindowInsetsAnimationCompat r1) {
        if ((r1.a() & androidx.core.view.al.m.c()) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void updateEmptyStatusImePadding(androidx.core.view.al r6) {
        int r0 = r6.a(androidx.core.view.al.m.a()).f1211c;
        int r1 = r6.a(androidx.core.view.al.m.c()).f1213e;
        int r7 = bh.a(r6);
        int r2 = this.emptyStatusInitialTopPadding + r0;
        OFloatingTitleBar r3 = this.searchTitleBar;
        OPageStatus r4 = null;
        if (r3 != null) goto L5;
        d.h.b.o.c("searchTitleBar");
        r3 = null;
    L5:
        int r5 = r2 + r3.getLayoutParams().height;
        int r8 = this.emptyStatusInitialBottomPadding + d.l.n.c(r1 - r7, 0);
        OPageStatus r9 = this.emptyStatus;
        if (r9 != null) goto L9;
        d.h.b.o.c("emptyStatus");
        r9 = null;
    L9:
        if (r9.getPaddingTop() != r5) goto L16;
        OPageStatus r10 = this.emptyStatus;
        if (r10 != null) goto L14;
        d.h.b.o.c("emptyStatus");
        r10 = null;
    L14:
        if (r10.getPaddingBottom() != r8) goto L16;
        return;
    L16:
        OPageStatus r11 = this.emptyStatus;
        if (r11 != null) goto L19;
        d.h.b.o.c("emptyStatus");
        r11 = null;
    L19:
        OPageStatus r12 = this.emptyStatus;
        if (r12 != null) goto L22;
        d.h.b.o.c("emptyStatus");
        r12 = null;
    L22:
        int r13 = r12.getPaddingLeft();
        OPageStatus r14 = this.emptyStatus;
        if (r14 != null) goto L25;
        d.h.b.o.c("emptyStatus");
    L26:
        r11.setPadding(r13, r5, r4.getPaddingRight(), r8);
        return;
    L25:
        r4 = r14;
        goto L26
    }

    private final void setupSearchPage() {
        OFloatingTitleBar r1 = this.searchTitleBar;
        RecyclerView r2 = null;
        if (r1 != null) goto L5;
        d.h.b.o.c("searchTitleBar");
        r1 = null;
    L5:
        View r3 = r1.addEndAction(ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_close, "drawable", "o_floating_title_bar_icon_close"), 0, new $$Lambda$SkillSearchActivity$H_x8_sMa2IrGtyzHb0e8_pALjSs(this));
        r3.setId(ZeusTransformUtils.mapRes(R.id.skill_search_back, DbHelper.COL_ID, "skill_search_back"));
        r3.setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_common_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_common_cancel")), CharSequence.class, "com.obric.aiagent.plugin"));
        OSearchBar r4 = this.searchBar;
        if (r4 != null) goto L8;
        d.h.b.o.c("searchBar");
        r4 = null;
    L8:
        r4.getInputView().addTextChangedListener((TextWatcher) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), TextWatcher.class, "com.obric.aiagent.plugin"));
        requestInitialSearchFocusAndIme();
        LinearLayoutManager r5 = new LinearLayoutManager((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"));
        RecyclerView r6 = this.searchList;
        if (r6 != null) goto L11;
        d.h.b.o.c("searchList");
        r6 = null;
    L11:
        r6.setLayoutManager((RecyclerView.h) ZeusTransformUtils.preCheckCast(r5, RecyclerView.h.class, "com.obric.aiagent.plugin"));
        c r7 = this.mode;
        if (r7 != null) goto L14;
        d.h.b.o.c(EXTRA_MODE);
        r7 = null;
    L14:
        int r8 = e.f20377a[r7.ordinal()];
        if (r8 == 1) goto L51;
        if (r8 != 2) goto L18;
    L22:
        RecyclerView r9 = this.searchList;
        if (r9 != null) goto L25;
        d.h.b.o.c("searchList");
        r9 = null;
    L25:
        r9.setItemAnimator(null);
        c r10 = this.mode;
        if (r10 != null) goto L29;
        d.h.b.o.c(EXTRA_MODE);
        r10 = null;
    L29:
        if (r10 != c.f20371d) goto L31;
        d.h.a.m r11 = new $$Lambda$SkillSearchActivity$d2OF2w2LGKDTh8jINwInSXQWBdQ(this);
    L32:
        com.obric.aiagent.skill.manager.impl.ui.g r12 = new com.obric.aiagent.skill.manager.impl.ui.g((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), new $$Lambda$SkillSearchActivity$WdEv7oVmJoEXE8I5PbjpUM4wrlk(this), new $$Lambda$SkillSearchActivity$J0XiE6oBOPpKlxOfT_5TdYBx4UY(this), r11);
        this.managementInteractionController = r12;
        d.h.a.b r13 = new $$Lambda$SkillSearchActivity$AucDsMaCfOo3VUucoNoZ5UpZ4PI(this);
        d.h.a.b r14 = (d.h.a.b) ZeusTransformUtils.preCheckCast(new t(r12), d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.a r15 = (d.h.a.a) ZeusTransformUtils.preCheckCast(new u(r12), d.h.a.a.class, "com.obric.aiagent.plugin");
        c r16 = this.mode;
        if (r16 != null) goto L36;
        d.h.b.o.c(EXTRA_MODE);
        r16 = null;
    L36:
        if (r16 != c.f20370c) goto L38;
        boolean r17 = true;
    L39:
        c r18 = this.mode;
        if (r18 != null) goto L43;
        d.h.b.o.c(EXTRA_MODE);
        r18 = null;
    L43:
        if (r18 != c.f20371d) goto L45;
        com.obric.aiagent.skill.manager.impl.ui.f r19 = com.obric.aiagent.skill.manager.impl.ui.f.f20777b;
    L46:
        com.obric.aiagent.skill.manager.impl.ui.h r20 = new com.obric.aiagent.skill.manager.impl.ui.h(r13, r14, r15, r17, r19);
        RecyclerView r21 = this.searchList;
        if (r21 != null) goto L49;
        d.h.b.o.c("searchList");
    L50:
        r2.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(r20, RecyclerView.a.class, "com.obric.aiagent.plugin"));
        this.managementAdapter = r20;
        return;
    L49:
        r2 = r21;
        goto L50
    L45:
        r19 = com.obric.aiagent.skill.manager.impl.ui.f.f20776a;
        goto L46
    L38:
        r17 = false;
        goto L39
    L31:
        r11 = null;
        goto L32
    L18:
        if (r8 == 3) goto L22;
        throw new d.k();
    L51:
        this.shopAdapter = new d(this);
        RecyclerView r22 = this.searchList;
        if (r22 != null) goto L54;
        d.h.b.o.c("searchList");
        r22 = null;
    L54:
        RecyclerView.a[] r23 = new RecyclerView.a[2];
        d r110 = this.shopAdapter;
        if (r110 != null) goto L57;
        d.h.b.o.c("shopAdapter");
        r110 = null;
    L57:
        r23[0] = r110;
        r23[1] = getShopLoadMoreAdapter();
        r22.setAdapter((RecyclerView.a) ZeusTransformUtils.preCheckCast(new com.obric.oui.orecyclerview.widget.g(r23), RecyclerView.a.class, "com.obric.aiagent.plugin"));
        RecyclerView r24 = this.searchList;
        if (r24 != null) goto L60;
        d.h.b.o.c("searchList");
    L61:
        r2.addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new s(this, r5), RecyclerView.m.class, "com.obric.aiagent.plugin"));
        return;
    L60:
        r2 = r24;
        goto L61
    }

    private static final void setupSearchPage$lambda$4(SkillSearchActivity r1, View r2) {
        ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillSearchActivity.class, "com.obric.aiagent.plugin")).finish();
    }

    private static final d.x setupSearchPage$lambda$5(SkillSearchActivity r2, com.obric.aiagent.skill.manager.api.e r3, d.h.a.a r4) {
        SkillSearchActivity r5 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        d.h.b.o.e(r6, "confirm");
        com.obric.aiagent.skill.manager.impl.ui.d.a((FragmentActivity) ZeusTransformUtils.preCheckCast(r5, FragmentActivity.class, "com.obric.aiagent.plugin"), r3, r6);
        return d.x.f38692a;
    }

    private static final ISkillManagerService setupSearchPage$lambda$6(SkillSearchActivity r2) {
        return ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).skillManager;
    }

    private static final d.x setupSearchPage$lambda$7(SkillSearchActivity r2) {
        com.obric.aiagent.skill.manager.impl.ui.h r3 = ((SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin")).managementAdapter;
        if (r3 == null) goto L6;
        r3.b();
    L6:
        return d.x.f38692a;
    }

    private static final d.x setupSearchPage$lambda$8(SkillSearchActivity r2, com.obric.aiagent.skill.manager.api.e r3) {
        SkillSearchActivity r4 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "skill");
        r4.openSkillDetail(r3);
        return d.x.f38692a;
    }

    private final void requestInitialSearchFocusAndIme() {
        if (this.shouldShowInitialIme == false) goto L11;
        OSearchBar r0 = this.searchBar;
        if (r0 == null) goto L12;
        if (r0 != null) goto L9;
        d.h.b.o.c("searchBar");
        r0 = null;
    L9:
        final OEditText r1 = r0.getInputView();
        r1.requestFocus();
        r1.post(new $$Lambda$SkillSearchActivity$vAHyVcyhlYKlnKppvjBnPxRm7Ik(this, r1));
        return;
    L12:
        return;
    }

    private static final void requestInitialSearchFocusAndIme$lambda$10(SkillSearchActivity r2, OEditText r3) {
        SkillSearchActivity r4 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin");
        if (r4.shouldShowInitialIme == true) goto L5;
        return;
    L5:
        if (r3.hasWindowFocus() == false) goto L13;
        androidx.core.view.am r5 = ViewCompat.x((View) ZeusTransformUtils.preCheckCast(r3, View.class, "com.obric.aiagent.plugin"));
        if (r5 != null) goto L10;
        return;
    L10:
        r4.shouldShowInitialIme = false;
        r5.a(androidx.core.view.al.m.c());
        return;
    }

    @Override // com.obric.aiagent.skill.manager.impl.ui.SkillGatedActivity, androidx.fragment.app.FragmentActivity
    public void onResume() {
        super.onResume();
        if (isSkillPageAvailable() == true) goto L5;
        return;
    L5:
        c r0 = this.mode;
        String r1 = null;
        if (r0 != null) goto L9;
        d.h.b.o.c(EXTRA_MODE);
        r0 = null;
    L9:
        if (r0 == c.f20370c) goto L11;
        return;
    L11:
        if (com.obric.aiagent.utils.shared_state.b.f22344a.a() == false) goto L13;
        r1 = com.obric.aiagent.utils.shared_state.b.f22344a.d();
    L13:
        com.obric.aiagent.skill.manager.impl.ui.h r2 = this.managementAdapter;
        if (r2 == null) goto L16;
        r2.a(r1);
    L16:
        refreshInstalledStoreMetadata();
    }

    private final void refreshInstalledStoreMetadata() {
        ISkillManagerService r0 = this.skillManager;
        if (ZeusTransformUtils.instanceOf(r0, SkillManager.class) == false) goto L5;
        SkillManager r1 = (SkillManager) ZeusTransformUtils.preCheckCast(r0, SkillManager.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        List r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r1.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L11;
        r2 = d.a.p.b();
    L11:
        Set r3 = d.n.m.i(d.n.m.a(d.n.m.d(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")), $$Lambda$SkillSearchActivity$hdKh7t_HzKdKNbsmkXkCnvrLei0.INSTANCE), (d.h.a.b) ZeusTransformUtils.preCheckCast(k.f20423a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(l.f20424a, d.h.a.b.class, "com.obric.aiagent.plugin")));
        if (r3.isEmpty() == false) goto L14;
        return;
    L14:
        kotlinx.coroutines.ca r4 = this.storeMetadataRefreshJob;
        if (r4 == null) goto L17;
        kotlinx.coroutines.ca.a.a(r4, null, 1, null);
    L17:
        this.storeMetadataRefreshJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new j(r1, r3, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final boolean refreshInstalledStoreMetadata$lambda$11(com.obric.aiagent.skill.manager.api.e r1) {
        d.h.b.o.e(r1, "skill");
        return ZeusTransformUtils.instanceOf(r1.g(), com.obric.aiagent.skill.manager.api.aq.e.class);
    }

    private final void ensureSkillObserverStarted() {
        ISkillManagerService r0 = this.skillManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.skillStateJob == null) goto L8;
        return;
    L8:
        kotlinx.coroutines.b.ak r1 = (kotlinx.coroutines.b.ak) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r0.observeInstalledSkills()), kotlinx.coroutines.b.ak.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L11;
        return;
    L11:
        this.skillStateJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(this, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void requestManagementDecisionRefreshOnce() {
        c r0 = this.mode;
        if (r0 != null) goto L6;
        d.h.b.o.c(EXTRA_MODE);
        r0 = null;
    L6:
        if (r0 != c.f20369b) goto L8;
        return;
    L8:
        if (this.searchPageVisible == true) goto L10;
        return;
    L10:
        if (this.decisionRefreshRequested == true) goto L25;
        ISkillManagerService r1 = this.skillManager;
        if (r1 != null) goto L15;
        return;
    L15:
        List r2 = (List) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.api.v.a(r1.getInstalledSkills()), List.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L18;
        r2 = d.a.p.b();
    L18:
        Set r3 = d.n.m.i(d.n.m.a(d.n.m.d(d.n.m.a(d.n.m.a(d.a.p.y((Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.aiagent.plugin")), new $$Lambda$SkillSearchActivity$nOLlBjuN1OjX7feD5IHOJYvohbQ(this)), (d.h.a.b) ZeusTransformUtils.preCheckCast(n.f20428a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(o.f20429a, d.h.a.b.class, "com.obric.aiagent.plugin")), (d.h.a.b) ZeusTransformUtils.preCheckCast(p.f20430a, d.h.a.b.class, "com.obric.aiagent.plugin")));
        if (r3.isEmpty() == false) goto L21;
        return;
    L21:
        this.decisionRefreshRequested = true;
        this.decisionRefreshJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new m(r3, r1, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    private static final boolean requestManagementDecisionRefreshOnce$lambda$12(SkillSearchActivity r3, com.obric.aiagent.skill.manager.api.e r4) {
        SkillSearchActivity r5 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r3, SkillSearchActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "skill");
        c r6 = r5.mode;
        if (r6 != null) goto L5;
        d.h.b.o.c(EXTRA_MODE);
        r6 = null;
    L5:
        int r7 = e.f20377a[r6.ordinal()];
        if (r7 != 1) goto L8;
        return false;
    L8:
        if (r7 == 2) goto L15;
        if (r7 != 3) goto L13;
        return d.h.b.o.a(r4.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a);
    L13:
        throw new d.k();
    L15:
        if (d.h.b.o.a(r4.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == false) goto L17;
        return false;
    L17:
        return true;
    }

    private final void onKeywordChanged(String r7) {
        String r8 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        Locale r0 = Locale.ROOT;
        d.h.b.o.c(r0, "ROOT");
        String r9 = r8.toLowerCase(r0);
        d.h.b.o.c(r9, "toLowerCase(...)");
        this.currentKeyword = r9;
        kotlinx.coroutines.ca r1 = this.searchJob;
        c r3 = null;
        if (r1 == null) goto L5;
        kotlinx.coroutines.ca.a.a(r1, null, 1, null);
    L5:
        c r2 = this.mode;
        if (r2 != null) goto L9;
        d.h.b.o.c(EXTRA_MODE);
        r2 = null;
    L9:
        if (r2 != c.f20369b) goto L12;
        getShopPager().c();
        getShopLoadMoreAdapter().b_(false);
    L12:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L15;
        renderInitialState();
        return;
    L15:
        c r4 = this.mode;
        if (r4 != null) goto L18;
        d.h.b.o.c(EXTRA_MODE);
    L19:
        int r5 = e.f20377a[r3.ordinal()];
        if (r5 != 1) goto L22;
        searchShop(r9);
        return;
    L22:
        if (r5 != 2) goto L24;
    L28:
        renderInstalledSearch(r9);
        return;
    L24:
        if (r5 == 3) goto L28;
        throw new d.k();
    L18:
        r3 = r4;
        goto L19
    }

    private final void renderInitialState() {
        submitResults(d.a.p.b());
        RecyclerView r0 = this.searchList;
        c r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("searchList");
        r0 = null;
    L5:
        r0.setVisibility(8);
        OPageStatus r2 = this.emptyStatus;
        if (r2 != null) goto L8;
        d.h.b.o.c("emptyStatus");
        r2 = null;
    L8:
        r2.setVisibility(0);
        OPageStatus r3 = this.emptyStatus;
        if (r3 != null) goto L11;
        d.h.b.o.c("emptyStatus");
        r3 = null;
    L11:
        r3.setType(0);
        OPageStatus r4 = this.emptyStatus;
        if (r4 != null) goto L14;
        d.h.b.o.c("emptyStatus");
        r4 = null;
    L14:
        r4.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_search_input_keyword, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_search_input_keyword")), CharSequence.class, "com.obric.aiagent.plugin"));
        OPageStatus r5 = this.emptyStatus;
        if (r5 != null) goto L17;
        d.h.b.o.c("emptyStatus");
        r5 = null;
    L17:
        c r6 = this.mode;
        if (r6 != null) goto L20;
        d.h.b.o.c(EXTRA_MODE);
    L21:
        int r7 = e.f20377a[r1.ordinal()];
        if (r7 != 1) goto L24;
        String r8 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_search_shop_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_search_shop_description"));
    L32:
        r5.setMessage((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L24:
        if (r7 != 2) goto L26;
        r8 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_search_management_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_search_management_description"));
        goto L32
    L26:
        if (r7 != 3) goto L29;
        r8 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_search_app_function_description, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_search_app_function_description"));
        goto L32
    L29:
        throw new d.k();
    L20:
        r1 = r6;
        goto L21
    }

    private final void renderLoadingState() {
        submitResults(d.a.p.b());
        RecyclerView r0 = this.searchList;
        OPageStatus r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("searchList");
        r0 = null;
    L5:
        r0.setVisibility(8);
        OPageStatus r2 = this.emptyStatus;
        if (r2 != null) goto L8;
        d.h.b.o.c("emptyStatus");
        r2 = null;
    L8:
        r2.setVisibility(0);
        OPageStatus r3 = this.emptyStatus;
        if (r3 != null) goto L11;
        d.h.b.o.c("emptyStatus");
        r3 = null;
    L11:
        r3.setType(0);
        OPageStatus r4 = this.emptyStatus;
        if (r4 != null) goto L14;
        d.h.b.o.c("emptyStatus");
        r4 = null;
    L14:
        r4.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_search_searching, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_search_searching")), CharSequence.class, "com.obric.aiagent.plugin"));
        OPageStatus r6 = this.emptyStatus;
        if (r6 != null) goto L17;
        d.h.b.o.c("emptyStatus");
    L18:
        r1.setMessage((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L17:
        r1 = r6;
        goto L18
    }

    private final void renderResult(List<com.obric.aiagent.skill.manager.api.e> r8) {
        List<com.obric.aiagent.skill.manager.api.e> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        submitResults(r9);
        RecyclerView r0 = this.searchList;
        OPageStatus r2 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c("searchList");
        r0 = null;
    L5:
        int r4 = 8;
        if (r9.isEmpty() == false) goto L8;
        int r3 = 8;
    L9:
        r0.setVisibility(r3);
        OPageStatus r1 = this.emptyStatus;
        if (r1 != null) goto L13;
        d.h.b.o.c("emptyStatus");
        r1 = null;
    L13:
        if (r9.isEmpty() == false) goto L15;
        r4 = 0;
    L15:
        r1.setVisibility(r4);
        if (r9.isEmpty() == false) goto L29;
        OPageStatus r10 = this.emptyStatus;
        if (r10 != null) goto L20;
        d.h.b.o.c("emptyStatus");
        r10 = null;
    L20:
        r10.setType(0);
        OPageStatus r11 = this.emptyStatus;
        if (r11 != null) goto L23;
        d.h.b.o.c("emptyStatus");
        r11 = null;
    L23:
        r11.setTitle((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_search_no_results, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_search_no_results")), CharSequence.class, "com.obric.aiagent.plugin"));
        OPageStatus r7 = this.emptyStatus;
        if (r7 != null) goto L26;
        d.h.b.o.c("emptyStatus");
    L27:
        r2.setMessage((CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"));
        return;
    L26:
        r2 = r7;
        goto L27
    L29:
        return;
    L8:
        r3 = 0;
        goto L9
    }

    private final void searchShop(String r2) {
        renderLoadingState();
        loadNextShopSearchPage(r2, true);
    }

    static /* synthetic */ void loadNextShopSearchPage$default(SkillSearchActivity r1, String r2, boolean r3, int r4, Object r5) {
        SkillSearchActivity r6 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r1, SkillSearchActivity.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r6.loadNextShopSearchPage(r2, r3);
    }

    private final void loadNextShopSearchPage(String r14, boolean r15) {
        c r0 = this.mode;
        if (r0 != null) goto L6;
        d.h.b.o.c(EXTRA_MODE);
        r0 = null;
    L6:
        if (r0 == c.f20369b) goto L8;
        return;
    L8:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L10;
        return;
    L10:
        if (d.h.b.o.a(this.currentKeyword, r14) == false) goto L22;
        gy r6 = getShopPager().d();
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.b() <= 1) goto L18;
        getShopLoadMoreAdapter().b_(true);
    L18:
        this.searchJob = kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new h(r15, this, r14, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    }

    private final void renderInstalledSearch(String r11) {
        kotlinx.coroutines.ca r0 = this.searchJob;
        if (r0 == null) goto L5;
        kotlinx.coroutines.ca.a.a(r0, null, 1, null);
    L5:
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(com.obric.aiagent.skill.manager.impl.bs.a(com.obric.aiagent.skill.manager.impl.bs.f19588a, (List) ZeusTransformUtils.preCheckCast(this.latestInstalledSkills, List.class, "com.obric.aiagent.plugin"), null, 2, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r2 = r1.iterator();
    L7:
        if (r2.hasNext() == false) goto L24;
        Object r6 = r2.next();
        com.obric.aiagent.skill.manager.api.e r7 = (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r6, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin");
        c r8 = this.mode;
        if (r8 != null) goto L11;
        d.h.b.o.c(EXTRA_MODE);
        r8 = null;
    L11:
        int r9 = e.f20377a[r8.ordinal()];
        boolean r10 = false;
        if (r9 == 1) goto L22;
        if (r9 == 2) goto L20;
        if (r9 != 3) goto L18;
        r10 = d.h.b.o.a(r7.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a);
        goto L22
    L18:
        throw new d.k();
    L20:
        if (d.h.b.o.a(r7.g(), com.obric.aiagent.skill.manager.api.aq.a.f19212a) == true) goto L22;
        r10 = true;
    L22:
        if (r10 == false) goto L7;
        r3.add(r6);
        goto L7
    L24:
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r12 = r4.iterator();
    L26:
        if (r12.hasNext() == false) goto L30;
        Object r13 = r12.next();
        if (com.obric.aiagent.skill.manager.impl.az.a((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r13, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin"), r11) == false) goto L26;
        r5.add(r13);
        goto L26
    L30:
        renderResult(com.obric.aiagent.skill.manager.impl.az.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin")));
    }

    private final void installShopSkill(com.obric.aiagent.skill.manager.api.e r11) {
        ISkillManagerService r0 = this.skillManager;
        if (r0 != null) goto L6;
        return;
    L6:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r11.a(), CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return;
    L9:
        if (this.processingSkillSlugs.add(r11.a()) == true) goto L11;
        return;
    L11:
        this.completedSkillSlugs.remove(r11.a());
        notifyVisibleAdapterChanged();
        kotlinx.coroutines.i.a(this.ioScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new g(r0, r11, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void scheduleSearchCompletionClear(String r7) {
        kotlinx.coroutines.i.a(this.mainScope, null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new q(this, r7, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    private final void upsertLatestInstalledSkill(com.obric.aiagent.skill.manager.api.e r6) {
        Iterator r0 = ((List) ZeusTransformUtils.preCheckCast(this.latestInstalledSkills, List.class, "com.obric.aiagent.plugin")).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r0.next(), com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r6.a()) == true) goto L10;
        r1 = r1 + 1;
    L10:
        if (r1 < 0) goto L12;
        this.latestInstalledSkills.set(r1, r6);
        return;
    L12:
        ((Collection) ZeusTransformUtils.preCheckCast(this.latestInstalledSkills, Collection.class, "com.obric.aiagent.plugin")).add(r6);
        return;
    L9:
        r1 = -1;
        goto L10
    }

    private final com.obric.aiagent.skill.manager.api.e withLatestInstalledState(com.obric.aiagent.skill.manager.api.e r5) {
        Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.latestInstalledSkills, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        Object r0 = r4.next();
        if (d.h.b.o.a(((com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a(), r5.a()) == false) goto L4;
    L10:
        return new com.obric.aiagent.skill.manager.impl.ui.p(r5, (com.obric.aiagent.skill.manager.api.e) ZeusTransformUtils.preCheckCast(r0, com.obric.aiagent.skill.manager.api.e.class, "com.obric.aiagent.plugin")).a();
    L8:
        r0 = null;
        goto L10
    }

    private final void useSearchSkill(final com.obric.aiagent.skill.manager.api.e r3) {
        co.a((FragmentActivity) ZeusTransformUtils.preCheckCast(this, FragmentActivity.class, "com.obric.aiagent.plugin"), r3, new $$Lambda$SkillSearchActivity$wkGaMi2xe9TXfrd1fuPdBbOV38(r3, this));
    }

    private static final d.x useSearchSkill$lambda$18(com.obric.aiagent.skill.manager.api.e r8, SkillSearchActivity r9) {
        final SkillSearchActivity r10 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r9, SkillSearchActivity.class, "com.obric.aiagent.plugin");
        if (r8.l() == true) goto L7;
        cm.f20758a.a((Activity) ZeusTransformUtils.preCheckCast(r10, Activity.class, "com.obric.aiagent.plugin"), cm.a.i);
        return d.x.f38692a;
    L7:
        if (com.obric.aiagent.skill.manager.impl.ui.r.a(com.obric.aiagent.skill.manager.impl.ui.r.f20808a, (Context) ZeusTransformUtils.preCheckCast(r10, Context.class, "com.obric.aiagent.plugin"), r10.skillManager, r8.a(), null, new $$Lambda$SkillSearchActivity$dfaP13OXQqX5HvBPNlJ2tkLPLU(r10), 8, null) == false) goto L10;
        r10.finish();
    L10:
        return d.x.f38692a;
    }

    private static final d.x useSearchSkill$lambda$18$lambda$17(SkillSearchActivity r2, String r3) {
        SkillSearchActivity r4 = (SkillSearchActivity) ZeusTransformUtils.wrapperContextForParams(r2, SkillSearchActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "message");
        r4.showUseError(r3);
        return d.x.f38692a;
    }

    private final void showUseError(String r3) {
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L6;
        ee.f19808a.c("SkillManager", "Open search skill chat failed", "Open search skill chat failed: " + r3);
        return;
    }

    private final void submitResults(List<com.obric.aiagent.skill.manager.api.e> r4) {
        List<com.obric.aiagent.skill.manager.api.e> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        c r0 = this.mode;
        d r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c(EXTRA_MODE);
        r0 = null;
    L5:
        int r2 = e.f20377a[r0.ordinal()];
        if (r2 != 1) goto L8;
        d r3 = this.shopAdapter;
        if (r3 != null) goto L20;
        d.h.b.o.c("shopAdapter");
    L21:
        r1.a(r5);
        return;
    L20:
        r1 = r3;
        goto L21
    L8:
        if (r2 != 2) goto L10;
    L14:
        com.obric.aiagent.skill.manager.impl.ui.h r6 = this.managementAdapter;
        if (r6 == null) goto L23;
        r6.a(r5);
        return;
    L23:
        return;
    L10:
        if (r2 == 3) goto L14;
        throw new d.k();
    }

    private final void notifyVisibleAdapterChanged() {
        c r0 = this.mode;
        d r1 = null;
        if (r0 != null) goto L5;
        d.h.b.o.c(EXTRA_MODE);
        r0 = null;
    L5:
        int r2 = e.f20377a[r0.ordinal()];
        if (r2 != 1) goto L8;
        d r3 = this.shopAdapter;
        if (r3 != null) goto L20;
        d.h.b.o.c("shopAdapter");
    L21:
        r1.g();
        return;
    L20:
        r1 = r3;
        goto L21
    L8:
        if (r2 != 2) goto L10;
    L14:
        com.obric.aiagent.skill.manager.impl.ui.h r4 = this.managementAdapter;
        if (r4 == null) goto L23;
        r4.b();
        return;
    L23:
        return;
    L10:
        if (r2 == 3) goto L14;
        throw new d.k();
    }

    private final void openSkillDetail(com.obric.aiagent.skill.manager.api.e r5) {
        c r0 = this.mode;
        if (r0 != null) goto L5;
        d.h.b.o.c(EXTRA_MODE);
        r0 = null;
    L5:
        int r1 = e.f20377a[r0.ordinal()];
        if (r1 != 1) goto L8;
        du r2 = br.f20662a.b();
    L16:
        launchFloatingActivity(SkillDetailPreviewActivity.Companion.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin"), r5.a(), r5.d(), r2));
        return;
    L8:
        if (r1 != 2) goto L10;
        r2 = br.f20662a.c();
        goto L16
    L10:
        if (r1 != 3) goto L13;
        r2 = br.f20662a.b();
        goto L16
    L13:
        throw new d.k();
    }
}
