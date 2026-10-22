package com.obric.aiagent.skill.credentials.impl.ui;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ai;
import androidx.core.view.al;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.plugin.R;
import com.obric.aiagent.skill.credentials.api.ISkillCredentialService;
import com.obric.aiagent.skill.credentials.api.o;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.oui.dialog.base.AbstractDialog;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.texteffects.OProtocolTextEffectTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.bduploader.BDNetworkSpeedTest;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.h.a.m;
import d.h.b.z;
import d.n;
import d.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.w;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: SidecarAuthActivity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SidecarAuthActivity extends FragmentActivity {
    private static final Set<String> CONDITIONAL_ACCESS_DENY_HOSTS = null;
    private static final String CONDITIONAL_ACCESS_DENY_PATH = "/conditionalaccess/deny";
    private static final long CREATE_APP_OPERATION_IN_PROGRESS_RETRY_INTERVAL_MS = 1000;
    private static final String CREATE_APP_PROFILE_NAME = "obric_sidecar_create_app";
    public static final a Companion = null;
    public static final String EXTRA_FLOW_ID = "com.obric.aiagent.skill.credentials.extra.FLOW_ID";
    private static final String EXTRA_GENERIC_URL = "url";
    private static final String EXTRA_LEGACY_URL = "extra_url";
    public static final String EXTRA_SESSION_ID = "com.obric.aiagent.skill.credentials.extra.SESSION_ID";
    public static final String EXTRA_URL = "com.obric.aiagent.skill.credentials.extra.AUTH_URL";
    private static final String FLOW_CONFIG_CREATE_APP = "configCreateApp";
    private static final int FULL_PROGRESS = 100;
    private static final Set<String> IMAGE_FILE_EXTENSIONS = null;
    private static final String IMAGE_MIME_TYPE = "image/*";
    private static final long INTENT_AUTH_CONFIRM_INTERVAL_MS = 1000;
    private static final int INTENT_AUTH_CONFIRM_MAX_ATTEMPTS = 30;
    private static final Set<String> LARK_CLI_PAGE_HOSTS = null;
    private static final int MAX_CONDITIONAL_ACCESS_CREATE_APP_RETRY = 1;
    private static final int MAX_CREATE_APP_OPERATION_IN_PROGRESS_RETRY = 3;
    private static final int REQUEST_CODE_IMAGE_FILE_CHOOSER = 7001;
    private static final String TAG = "SidecarAuthActivity";
    private static ca intentAuthConfirmJob;
    private static final am intentAuthConfirmScope = null;
    private static String intentAuthConfirmSessionId;
    private static WeakReference<SidecarAuthActivity> intentAuthOwner;
    private String activeAuthFlowId;
    private int activeConditionalAccessRetryAttempt;
    private d.h.a.a<x> activeConditionalAccessReturnCallback;
    private o bridgeController;
    private boolean closeAsCompleted;
    private boolean conditionalAccessRetryTriggered;
    private final d.f contentContainer$delegate;
    private boolean createAppProfileApplied;
    private final d.f errorStatus$delegate;
    private ValueCallback<Uri[]> imageFilePathCallback;
    private c intentAuthCloseState;
    private ca intentAuthCompletionJob;
    private boolean intentAuthFinished;
    private ca intentAuthJob;
    private final am intentAuthScope;
    private String intentAuthSessionId;
    private final d.f progressBar$delegate;
    private boolean sawConditionalAccessDeny;
    private String sessionId;
    private final d.f webView$delegate;

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    public static final class a {

        /* JADX INFO: renamed from: com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SidecarAuthActivity.kt */
        @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {1463, 1478}, d = "checkIntentAuthCompleted", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$Companion")
        static final class C0421a extends d.c.b.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f19090a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f19091b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            int f19092c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            /* synthetic */ Object f19093d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ a f19094e;
            int f;

            C0421a(a r3, d.c.d<? super C0421a> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f19094e = r3;
                super(r5);
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                this.f19093d = r3;
                this.f |= Integer.MIN_VALUE;
                return a.a(this.f19094e, null, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
            }
        }

        /* JADX INFO: compiled from: SidecarAuthActivity.kt */
        @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {BizStatus.StatusChangedReason.OPERATING_RESUME_FROM_USER_INTERRUPTED, 1423}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$Companion$startIntentAuthConfirmJob$1")
        static final class b extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f19095a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f19096b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f19097c;

            b(String r3, d.c.d<? super b> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                this.f19097c = r3;
                super(2, r5);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
                d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f19097c, r4), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x011d -> B:52:0x0134). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0131 -> B:52:0x0134). Please report as a decompilation issue!!! */
            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r12) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f19096b;
                boolean r6 = true;
                if (r1 == 0) goto L18;
                if (r1 == 1) goto L11;
                if (r1 != 2) goto L10;
                int r2 = this.f19095a;
                d.o.a(r12);     // Catch: Throwable -> L14 CancellationException -> L16
            L52:
                int r13 = r2 + 1;     // Catch: Throwable -> L14 CancellationException -> L16
            L20:
                if (r13 < 31) goto L22;
                ILogDepend.Companion.w(SidecarAuthActivity.TAG, "intent auth confirm timed out session=" + this.f19097c);     // Catch: Throwable -> L14 CancellationException -> L16
                if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthConfirmSessionId$cp(), this.f19097c) == false) goto L58;
                a r11 = SidecarAuthActivity.Companion;
                SidecarAuthActivity.access$setIntentAuthConfirmSessionId$cp(null);
                a r14 = SidecarAuthActivity.Companion;
                SidecarAuthActivity.access$setIntentAuthConfirmJob$cp(null);
            L58:
                return x.f38692a;
            L22:
                if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthConfirmSessionId$cp(), this.f19097c) == true) goto L28;
                ILogDepend.Companion.i(SidecarAuthActivity.TAG, "intent auth confirm stopped session=" + this.f19097c + " attempt=" + r13 + " reason=session_changed");     // Catch: Throwable -> L14 CancellationException -> L16
                x r15 = x.f38692a;     // Catch: Throwable -> L14 CancellationException -> L16
                if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthConfirmSessionId$cp(), this.f19097c) == false) goto L27;
                a r16 = SidecarAuthActivity.Companion;
                SidecarAuthActivity.access$setIntentAuthConfirmSessionId$cp(null);
                a r17 = SidecarAuthActivity.Companion;
                SidecarAuthActivity.access$setIntentAuthConfirmJob$cp(null);
            L27:
                return r15;
            L28:
                a r3 = SidecarAuthActivity.Companion;     // Catch: Throwable -> L14 CancellationException -> L16
                String r8 = this.f19097c;     // Catch: Throwable -> L14 CancellationException -> L16
                d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14 CancellationException -> L16
                this.f19095a = r13;     // Catch: Throwable -> L14 CancellationException -> L16
                this.f19096b = 1;     // Catch: Throwable -> L14 CancellationException -> L16
                Object r4 = a.a(r3, r8, r13, r9);     // Catch: Throwable -> L14 CancellationException -> L16
                if (r4 != r0) goto L31;
                return r0;
            L31:
                r2 = r13;
                r12 = r4;
            L33:
                if (((Boolean) ZeusTransformUtils.preCheckCast(r12, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L47;
                boolean r18 = com.obric.aiagent.skill.credentials.api.l.f18971a.a(this.f19097c, a.a(SidecarAuthActivity.Companion));     // Catch: Throwable -> L14 CancellationException -> L16
                ILogDepend.Companion r5 = ILogDepend.Companion;     // Catch: Throwable -> L14 CancellationException -> L16
                StringBuilder r7 = new StringBuilder().append("intent auth confirm completed session=").append(this.f19097c).append(" attempt=").append(r2).append(" completed=");     // Catch: Throwable -> L14 CancellationException -> L16
                if (r18 == true) goto L38;
                r6 = false;
            L38:
                r5.i(SidecarAuthActivity.TAG, r7.append(r6).toString());     // Catch: Throwable -> L14 CancellationException -> L16
                if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthConfirmSessionId$cp(), this.f19097c) == false) goto L41;
                a r19 = SidecarAuthActivity.Companion;     // Catch: Throwable -> L14 CancellationException -> L16
                SidecarAuthActivity.access$setIntentAuthConfirmSessionId$cp(null);     // Catch: Throwable -> L14 CancellationException -> L16
                a r110 = SidecarAuthActivity.Companion;     // Catch: Throwable -> L14 CancellationException -> L16
                SidecarAuthActivity.access$setIntentAuthConfirmJob$cp(null);     // Catch: Throwable -> L14 CancellationException -> L16
            L41:
                x r111 = x.f38692a;     // Catch: Throwable -> L14 CancellationException -> L16
                if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthConfirmSessionId$cp(), this.f19097c) == false) goto L45;
                a r112 = SidecarAuthActivity.Companion;
                SidecarAuthActivity.access$setIntentAuthConfirmSessionId$cp(null);
                a r113 = SidecarAuthActivity.Companion;
                SidecarAuthActivity.access$setIntentAuthConfirmJob$cp(null);
            L45:
                return r111;
            L47:
                if (r2 >= 30) goto L52;
                d.c.d r114 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14 CancellationException -> L16
                this.f19095a = r2;     // Catch: Throwable -> L14 CancellationException -> L16
                this.f19096b = 2;     // Catch: Throwable -> L14 CancellationException -> L16
                if (ax.a(1000, r114) != r0) goto L52;
                return r0;
            L10:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L11:
                r2 = this.f19095a;
                d.o.a(r12);     // Catch: Throwable -> L14 CancellationException -> L16
                goto L33
            L18:
                d.o.a(r12);
                r13 = 1;
            L16:
                e = move-exception;
                ILogDepend.Companion.i(SidecarAuthActivity.TAG, "intent auth confirm canceled session=" + this.f19097c);     // Catch: Throwable -> L14
                throw e;     // Catch: Throwable -> L14
            L14:
                th = move-exception;
                if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthConfirmSessionId$cp(), this.f19097c) == false) goto L64;
                a r115 = SidecarAuthActivity.Companion;
                SidecarAuthActivity.access$setIntentAuthConfirmSessionId$cp(null);
                a r116 = SidecarAuthActivity.Companion;
                SidecarAuthActivity.access$setIntentAuthConfirmJob$cp(null);
            L64:
                throw th;
            }
        }

        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        /* JADX INFO: renamed from: lambda$eca8qg5g86lX1-nxRLbuP4cMPCg, reason: not valid java name */
        public static /* synthetic */ CharSequence m258lambda$eca8qg5g86lX1nxRLbuP4cMPCg(String r0) {
            return h(r0);
        }

        private a() {
        }

        public static final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.c a(a r0) {
            return r0.a();
        }

        public static final /* synthetic */ Object a(a r2, String r3, int r4, d.c.d r5) {
            return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ String a(a r0, Intent r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ String a(a r0, Uri r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ String a(a r0, String r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ List a(a r0, WebChromeClient.FileChooserParams r1) {
            return r0.a(r1);
        }

        public static final /* synthetic */ boolean a(a r2, SidecarAuthActivity r3, String r4) {
            return r2.a((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin"), r4);
        }

        public static final /* synthetic */ boolean a(a r2, List r3) {
            return r2.a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ String b(a r2, List r3) {
            return r2.b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        }

        public static final /* synthetic */ boolean b(a r2, SidecarAuthActivity r3, String r4) {
            return r2.b((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin"), r4);
        }

        public static final /* synthetic */ boolean b(a r0, String r1) {
            return r0.b(r1);
        }

        public static final /* synthetic */ Uri[] b(a r0, Intent r1) {
            return r0.c(r1);
        }

        public static final /* synthetic */ void c(a r2, SidecarAuthActivity r3, String r4) {
            r2.c((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin"), r4);
        }

        public static final /* synthetic */ boolean c(a r0, String r1) {
            return r0.c(r1);
        }

        public static final /* synthetic */ void d(a r0, String r1) {
            r0.g(r1);
        }

        private final String a(Intent r5) {
            StringBuilder r0 = new StringBuilder().append("hasUrl=").append(b(r5)).append(" hasSession=");
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.getStringExtra(SidecarAuthActivity.EXTRA_SESSION_ID), CharSequence.class, "com.obric.aiagent.plugin");
            if (r1 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            StringBuilder r3 = r0.append(!r2).append(" action=").append(r5.getAction()).append(" data=");
            Uri r6 = r5.getData();
            if (r6 == null) goto L12;
            String r4 = a(r6);
        L14:
            return r3.append(r4).toString();
        L12:
            r4 = null;
            goto L14
        L5:
            if (d.o.o.d(r1) == true) goto L8;
            r2 = false;
            goto L9
        }

        private final boolean b(Intent r5) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.getStringExtra(SidecarAuthActivity.EXTRA_URL), CharSequence.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L5;
        L8:
            boolean r6 = true;
        L9:
            if (r6 == false) goto L27;
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.getStringExtra(SidecarAuthActivity.EXTRA_LEGACY_URL), CharSequence.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L13;
        L16:
            boolean r8 = true;
        L17:
            if (r8 == false) goto L27;
            CharSequence r9 = (CharSequence) ZeusTransformUtils.preCheckCast(r5.getStringExtra("url"), CharSequence.class, "com.obric.aiagent.plugin");
            if (r9 != null) goto L21;
        L24:
            boolean r10 = true;
        L25:
            if (r10 == false) goto L27;
            return false;
        L21:
            if (d.o.o.d(r9) == true) goto L24;
            r10 = false;
            goto L25
        L13:
            if (d.o.o.d(r7) == true) goto L16;
            r8 = false;
        L27:
            return true;
        L5:
            if (d.o.o.d(r4) == true) goto L8;
            r6 = false;
            goto L9
        }

        private final String a(Uri r6) {
            StringBuilder r5 = new StringBuilder();
            String r0 = r6.getScheme();
            if (r0 != null) goto L5;
            r0 = "";
        L5:
            r5.append(r0);
            CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getHost(), CharSequence.class, "com.obric.aiagent.plugin");
            boolean r2 = false;
            if (r1 != null) goto L8;
        L11:
            boolean r3 = true;
        L12:
            if (r3 == true) goto L14;
            r5.append("://");
            r5.append(r6.getHost());
        L14:
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r6.getPath(), CharSequence.class, "com.obric.aiagent.plugin");
            if (r4 != null) goto L17;
        L18:
            r2 = true;
        L19:
            if (r2 == true) goto L21;
            r5.append(r6.getPath());
        L21:
            String r7 = r5.toString();
            d.h.b.o.c(r7, "toString(...)");
            CharSequence r8 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.aiagent.plugin");
            if (d.o.o.d(r8) == false) goto L25;
            r8 = "<empty>";
        L25:
            return (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
        L17:
            if (d.o.o.d(r4) == false) goto L19;
        L8:
            if (d.o.o.d(r1) == true) goto L11;
            r3 = false;
            goto L12
        }

        private final String a(String r2) {
            if (r2 != null) goto L14;
            return "<empty>";
        L14:
            n.a r1 = n.f38560a;     // Catch: Throwable -> L7
            a r3 = SidecarAuthActivity.Companion;     // Catch: Throwable -> L7
            Uri r4 = Uri.parse(r2);     // Catch: Throwable -> L7
            d.h.b.o.c(r4, "parse(...)");     // Catch: Throwable -> L7
            Object r5 = n.f(r3.a(r4));     // Catch: Throwable -> L7
        L10:
            if (n.b(r5) == false) goto L13;
            r5 = "<invalid-url>";
        L13:
            return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
        L7:
            th = move-exception;
            n.a r6 = n.f38560a;
            r5 = n.f(d.o.a(th));
            goto L10
        }

        private final boolean b(String r7) {
            Uri r6 = d(r7);
            if (r6 != null) goto L6;
            return false;
        L6:
            if (d.o.o.a(r6.getScheme(), "https", true) == false) goto L29;
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(SidecarAuthActivity.access$getCONDITIONAL_ACCESS_DENY_HOSTS$cp(), Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r0, Collection.class) == true) goto L10;
        L12:
            Iterator r1 = r0.iterator();
        L14:
            if (r1.hasNext() == false) goto L11;
            if (SidecarAuthActivity.Companion.a(r6.getHost(), (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.aiagent.plugin")) == false) goto L14;
            boolean r2 = true;
        L18:
            if (r2 == false) goto L30;
            String r8 = r6.getPath();
            if (r8 != null) goto L23;
            r8 = "";
        L23:
            if (d.o.o.a(d.o.o.c(r8, new char[]{'/'}), SidecarAuthActivity.CONDITIONAL_ACCESS_DENY_PATH, true) == true) goto L25;
            return false;
        L25:
            return true;
        L30:
            return false;
        L11:
            r2 = false;
            goto L18
        L10:
            if (((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L12;
        L29:
            return false;
        }

        private final boolean c(String r6) {
            Uri r5 = d(r6);
            if (r5 != null) goto L5;
            return false;
        L5:
            String r0 = r5.getHost();
            String r1 = "";
            if (r0 != null) goto L8;
            r0 = "";
        L8:
            Locale r2 = Locale.US;
            d.h.b.o.c(r2, "US");
            String r3 = r0.toLowerCase(r2);
            d.h.b.o.c(r3, "toLowerCase(...)");
            if (d.o.o.a(r5.getScheme(), "https", true) == true) goto L11;
            return false;
        L11:
            if (SidecarAuthActivity.access$getLARK_CLI_PAGE_HOSTS$cp().contains(r3) == false) goto L21;
            String r7 = r5.getPath();
            if (r7 == null) goto L17;
            r1 = r7;
        L17:
            if (d.o.o.a(d.o.o.c(r1, new char[]{'/'}), "/page/cli", true) == true) goto L19;
            return false;
        L19:
            return true;
        L21:
            return false;
        }

        private final Uri d(String r3) {
            Object r2 = null;
            if (r3 != null) goto L5;
            return null;
        L5:
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L8;
            r3 = null;
        L8:
            if (r3 == null) goto L23;
            n.a r0 = n.f38560a;     // Catch: Throwable -> L12
            Object r4 = n.f(Uri.parse(r3));     // Catch: Throwable -> L12
        L15:
            if (n.b(r4) == true) goto L19;
            r2 = r4;
        L19:
            return (Uri) ZeusTransformUtils.preCheckCast(r2, Uri.class, "com.obric.aiagent.plugin");
        L12:
            th = move-exception;
            n.a r1 = n.f38560a;
            r4 = n.f(d.o.a(th));
            goto L15
        L23:
            return null;
        }

        private final boolean a(String r8, String r9) {
            if (r8 == null) goto L20;
            String r10 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin")).toString();
            if (r10 == null) goto L21;
            String r11 = d.o.o.c(r10, new char[]{'.'});
            if (r11 == null) goto L22;
            Locale r3 = Locale.US;
            d.h.b.o.c(r3, "US");
            String r12 = r11.toLowerCase(r3);
            d.h.b.o.c(r12, "toLowerCase(...)");
            if (r12 == null) goto L23;
            String r13 = d.o.o.c(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin")).toString(), new char[]{'.'});
            Locale r6 = Locale.US;
            d.h.b.o.c(r6, "US");
            String r14 = r13.toLowerCase(r6);
            d.h.b.o.c(r14, "toLowerCase(...)");
            if (d.o.o.c((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.aiagent.plugin"), '*', false, 2, null) == false) goto L15;
            return b(r12, r14);
        L15:
            if (d.h.b.o.a(r12, r14) == true) goto L19;
            if (d.o.o.c(r12, '.' + r14, false, 2, null) == true) goto L19;
            return false;
        L19:
            return true;
        L23:
            return false;
        L22:
            return false;
        L21:
            return false;
        L20:
            return false;
        }

        private final boolean b(String r17, String r18) {
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin");
            int r5 = 0;
            int r6 = 0;
        L3:
            boolean r9 = true;
            if (r5 >= r2.length()) goto L13;
            if (r2.charAt(r5) == '.') goto L9;
            r9 = false;
        L9:
            if (r9 == false) goto L11;
            r6 = r6 + 1;
        L11:
            r5 = r5 + 1;
            goto L3
        L13:
            if (r6 == f(r18)) goto L16;
            return false;
        L16:
            return new d.o.k(p.a((Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{'.'}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("\\.", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, $$Lambda$SidecarAuthActivity$a$eca8qg5g86lX1nxRLbuP4cMPCg.INSTANCE, 30, null), d.o.m.f38652a).a((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        private static final CharSequence h(String r2) {
            d.h.b.o.e(r2, "label");
            return (CharSequence) ZeusTransformUtils.preCheckCast(SidecarAuthActivity.Companion.e(r2), CharSequence.class, "com.obric.aiagent.plugin");
        }

        private final String e(String r4) {
            StringBuilder r3 = new StringBuilder();
            CharSequence r5 = (CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin");
            int r0 = 0;
        L4:
            if (r0 >= r5.length()) goto L10;
            char r1 = r5.charAt(r0);
            if (r1 != '*') goto L8;
            r3.append("[^.]*");
        L9:
            r0 = r0 + 1;
            goto L4
        L8:
            r3.append(d.o.k.f38646a.a(String.valueOf(r1)));
            goto L9
        L10:
            String r6 = r3.toString();
            d.h.b.o.c(r6, "toString(...)");
            return r6;
        }

        private final int f(String r5) {
            CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin");
            int r0 = 0;
            int r1 = 0;
        L4:
            if (r0 >= r4.length()) goto L12;
            if (r4.charAt(r0) != '.') goto L8;
            boolean r2 = true;
        L9:
            if (r2 == false) goto L11;
            r1 = r1 + 1;
        L11:
            r0 = r0 + 1;
            goto L4
        L8:
            r2 = false;
            goto L9
        L12:
            return r1;
        }

        private final List<String> a(WebChromeClient.FileChooserParams r11) {
            String[] r10 = r11.getAcceptTypes();
            int r12 = 0;
            if (r10 != null) goto L5;
            r10 = new String[0];
        L5:
            Collection r0 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            int r1 = r10.length;
        L6:
            if (r12 >= r1) goto L8;
            String r3 = r10[r12];
            d.h.b.o.a(r3);
            p.a(r0, (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"), new String[]{","}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin"));
            r12 = r12 + 1;
            goto L6
        L8:
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin");
            Collection r14 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r15 = r13.iterator();
        L10:
            if (r15.hasNext() == false) goto L17;
            String r4 = null;
            String r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(d.o.o.a((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.aiagent.plugin"), ";", null, 2, null), CharSequence.class, "com.obric.aiagent.plugin")).toString();
            Locale r5 = Locale.US;
            d.h.b.o.c(r5, "US");
            String r6 = r2.toLowerCase(r5);
            d.h.b.o.c(r6, "toLowerCase(...)");
            if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == false) goto L14;
            r4 = r6;
        L14:
            if (r4 == null) goto L10;
            r14.add(r4);
            goto L10
        L17:
            return (List) ZeusTransformUtils.preCheckCast(r14, List.class, "com.obric.aiagent.plugin");
        }

        private final boolean a(List<String> r7) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
            if (r6.isEmpty() == false) goto L5;
            return true;
        L5:
            Iterable r8 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r8, Collection.class) == true) goto L8;
        L10:
            Iterator r9 = r8.iterator();
        L12:
            if (r9.hasNext() == false) goto L25;
            String r10 = (String) ZeusTransformUtils.preCheckCast(r9.next(), String.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(r10, "*/*") == false) goto L16;
        L23:
            boolean r11 = true;
        L24:
            if (r11 == false) goto L12;
            return true;
        L16:
            if (d.h.b.o.a(r10, SidecarAuthActivity.IMAGE_MIME_TYPE) == true) goto L23;
            if (d.o.o.b(r10, "image/", false, 2, null) == true) goto L23;
            if (SidecarAuthActivity.access$getIMAGE_FILE_EXTENSIONS$cp().contains(r10) == true) goto L23;
            r11 = false;
        L25:
            return false;
        L8:
            if (((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L10;
            goto L10
        }

        private final String b(List<String> r11) {
            List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
            if (r10.isEmpty() == false) goto L6;
            return "<empty>";
        L6:
            return p.a((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.aiagent.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("|", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, null, 62, null);
        }

        private final Uri[] c(Intent r6) {
            if (r6 != null) goto L5;
            return null;
        L5:
            LinkedHashSet r0 = new LinkedHashSet();
            Uri r1 = r6.getData();
            if (r1 == null) goto L8;
            r0.add(r1);
        L8:
            ClipData r7 = r6.getClipData();
            if (r7 == null) goto L19;
            int r2 = r7.getItemCount();
            int r3 = 0;
        L11:
            if (r3 >= r2) goto L19;
            ClipData.Item r4 = r7.getItemAt(r3);
            if (r4 == null) goto L17;
            Uri r5 = r4.getUri();
            if (r5 == null) goto L17;
            r0.add(r5);
        L17:
            r3 = r3 + 1;
        L19:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).isEmpty()) == true) goto L22;
            r0 = null;
        L22:
            if (r0 != null) goto L24;
            return null;
        L24:
            return (Uri[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin")).toArray(new Uri[0]), Uri[].class, "com.obric.aiagent.plugin");
        }

        private final boolean a(SidecarAuthActivity r4, String r5) {
            SidecarAuthActivity r6 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r4, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            WeakReference r0 = SidecarAuthActivity.access$getIntentAuthOwner$cp();
            if (r0 == null) goto L5;
            SidecarAuthActivity r1 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r0.get(), SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        L6:
            if (r1 == null) goto L16;
            if (r1 == r6) goto L16;
            if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthSessionId$p(r1), r5) == false) goto L16;
            if (r1.isFinishing() == true) goto L16;
            if (r1.isDestroyed() == true) goto L16;
            return false;
        L16:
            c(r5, "new_owner");
            SidecarAuthActivity.access$setIntentAuthOwner$cp(new WeakReference(r6));
            return true;
        L5:
            r1 = null;
            goto L6
        }

        private final boolean b(SidecarAuthActivity r11, String r12) {
            SidecarAuthActivity r10 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r11, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            WeakReference r13 = SidecarAuthActivity.access$getIntentAuthOwner$cp();
            ActivityManager r1 = null;
            if (r13 == null) goto L5;
            SidecarAuthActivity r14 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r13.get(), SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        L6:
            boolean r2 = true;
            if (r14 == null) goto L31;
            if (r14 == r10) goto L31;
            if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthSessionId$p(r14), r12) == false) goto L31;
            if (r14.isFinishing() == true) goto L31;
            if (r14.isDestroyed() == true) goto L31;
            int r15 = r14.getTaskId();
            if (r15 >= 0) goto L20;
            ILogDepend.Companion.w(SidecarAuthActivity.TAG, "skip move intent auth owner task to front session=" + r12 + " ownerTaskId=" + r15 + " currentTaskId=" + r10.getTaskId());
            return false;
        L20:
            Object r8 = r10.getSystemService("activity");
            if (ZeusTransformUtils.instanceOf(r8, ActivityManager.class) == false) goto L23;
            r1 = (ActivityManager) ZeusTransformUtils.preCheckCast(r8, ActivityManager.class, "com.obric.aiagent.plugin");
        L23:
            if (r1 != null) goto L37;
            ILogDepend.Companion.w(SidecarAuthActivity.TAG, "skip move intent auth owner task to front session=" + r12 + " ownerTaskId=" + r15 + " currentTaskId=" + r10.getTaskId() + " reason=no_activity_manager");
            return false;
        L37:
            r1.moveTaskToFront(r15, 0);     // Catch: Exception -> L28
            ILogDepend.Companion.i(SidecarAuthActivity.TAG, "moved intent auth owner task to front session=" + r12 + " ownerTaskId=" + r15 + " currentTaskId=" + r10.getTaskId());     // Catch: Exception -> L28
            return true;
        L28:
            e = move-exception;
            ILogDepend.Companion.e(SidecarAuthActivity.TAG, "move intent auth owner task to front failed session=" + r12 + " ownerTaskId=" + r15 + " currentTaskId=" + r10.getTaskId(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
            return false;
        L31:
            ILogDepend.Companion r0 = ILogDepend.Companion;
            StringBuilder r16 = new StringBuilder().append("skip move intent auth owner task to front session=").append(r12).append(" ownerAvailable=");
            if (r14 != null) goto L35;
            r2 = false;
        L35:
            r0.w(SidecarAuthActivity.TAG, r16.append(r2).append(" currentTaskId=").append(r10.getTaskId()).toString());
            return false;
        L5:
            r14 = null;
            goto L6
        }

        private final void c(SidecarAuthActivity r4, String r5) {
            SidecarAuthActivity r3 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r4, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L5;
            return;
        L5:
            WeakReference r6 = SidecarAuthActivity.access$getIntentAuthOwner$cp();
            if (r6 == null) goto L8;
            SidecarAuthActivity r7 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r6.get(), SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        L9:
            if (r7 == r3) goto L11;
            return;
        L11:
            if (d.h.b.o.a(SidecarAuthActivity.access$getIntentAuthSessionId$p(r7), r5) == false) goto L15;
            SidecarAuthActivity.access$setIntentAuthOwner$cp(null);
            return;
        L15:
            return;
        L8:
            r7 = null;
            goto L9
        }

        private final void g(String r8) {
            c(r8, "restart");
            SidecarAuthActivity.access$setIntentAuthConfirmSessionId$cp(r8);
            SidecarAuthActivity.access$setIntentAuthConfirmJob$cp(kotlinx.coroutines.i.a(SidecarAuthActivity.access$getIntentAuthConfirmScope$cp(), null, null, (m) ZeusTransformUtils.preCheckCast(new b(r8, null), m.class, "com.obric.aiagent.plugin"), 3, null));
        }

        private final void c(String r4, String r5) {
            String r3 = SidecarAuthActivity.access$getIntentAuthConfirmSessionId$cp();
            ca r0 = SidecarAuthActivity.access$getIntentAuthConfirmJob$cp();
            if (d.h.b.o.a(r3, r4) == false) goto L7;
            if (r0 == null) goto L8;
            ILogDepend.Companion.i(SidecarAuthActivity.TAG, "intent auth confirm stop session=" + r4 + " reason=" + r5);
            ca.a.a(r0, null, 1, null);
            SidecarAuthActivity.access$setIntentAuthConfirmSessionId$cp(null);
            SidecarAuthActivity.access$setIntentAuthConfirmJob$cp(null);
            return;
        L8:
            return;
        }

        private final Object a(String r12, int r13, d.c.d<? super Boolean> r14) {
            d.c.d r15 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r15, C0421a.class) == false) goto L7;
            C0421a r0 = (C0421a) ZeusTransformUtils.preCheckCast(r15, C0421a.class, "com.obric.aiagent.plugin");
            if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
            r0.f -= Integer.MIN_VALUE;
        L8:
            Object r11 = r0.f19093d;
            Object r16 = d.c.a.b.a();
            int r2 = r0.f;
            boolean r7 = true;
            if (r2 == 0) goto L17;
            if (r2 == 1) goto L15;
            if (r2 != 2) goto L14;
            int r17 = r0.f19092c;
            String r18 = (String) ZeusTransformUtils.preCheckCast(r0.f19090a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r11);
            Object r19 = ((n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.aiagent.plugin")).a();
        L35:
            Throwable r110 = n.c(r19);
            if (r110 != null) goto L44;
            com.obric.aiagent.skill.credentials.api.a r111 = (com.obric.aiagent.skill.credentials.api.a) ZeusTransformUtils.preCheckCast(r19, com.obric.aiagent.skill.credentials.api.a.class, "com.obric.aiagent.plugin");
            ILogDepend.Companion r112 = ILogDepend.Companion;
            StringBuilder r113 = new StringBuilder().append("intent auth confirm check session=").append(r18).append(" attempt=").append(r17).append(" configuredApp=true statusApp=");
            if (r111.a() != null) goto L41;
            r7 = false;
        L41:
            r112.i(SidecarAuthActivity.TAG, r113.append(r7).append(" loggedIn=").append(r111.b()).append(" scopeCount=").append(r111.c().size()).toString());
            return d.c.b.a.b.a(r111.b());
        L44:
            if (ZeusTransformUtils.instanceOf(r110, CancellationException.class) == true) goto L47;
            SidecarAuthActivity.Companion.a(r18, r17, "status", r110);
            return d.c.b.a.b.a(false);
        L47:
            throw r110;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            int r114 = r0.f19092c;
            ISkillCredentialService r115 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r0.f19091b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            String r3 = (String) ZeusTransformUtils.preCheckCast(r0.f19090a, String.class, "com.obric.aiagent.plugin");
            d.o.a(r11);
            Object r116 = ((n) ZeusTransformUtils.preCheckCast(r11, n.class, "com.obric.aiagent.plugin")).a();
            int r10 = r114;
            ISkillCredentialService r117 = r115;
            r12 = r3;
        L16:
            int r4 = r10;
            Throwable r9 = n.c(r116);
            if (r9 != null) goto L49;
            if (((com.obric.aiagent.skill.credentials.api.b) ZeusTransformUtils.preCheckCast(r116, com.obric.aiagent.skill.credentials.api.b.class, "com.obric.aiagent.plugin")) != null) goto L31;
            ILogDepend.Companion.i(SidecarAuthActivity.TAG, "intent auth confirm check session=" + r12 + " attempt=" + r4 + " configuredApp=false loggedIn=false");
            return d.c.b.a.b.a(false);
        L31:
            ISkillCredentialService.a r118 = r117.getAccount();
            com.obric.aiagent.skill.credentials.api.f r119 = com.obric.aiagent.skill.credentials.api.f.f18949a;
            r0.f19090a = r12;
            r0.f19091b = null;
            r0.f19092c = r4;
            r0.f = 2;
            r19 = r118.b(r119, r0);
            if (r19 != r16) goto L34;
            return r16;
        L34:
            r18 = r12;
            r17 = r4;
            goto L35
        L49:
            if (ZeusTransformUtils.instanceOf(r9, CancellationException.class) == true) goto L52;
            SidecarAuthActivity.Companion.a(r12, r4, "getConfiguredApp", r9);
            return d.c.b.a.b.a(false);
        L52:
            throw r9;
        L17:
            d.o.a(r11);
            ISkillCredentialService r120 = ISkillCredentialService.Companion.a();
            if (r120 != null) goto L21;
            ILogDepend.Companion.e(SidecarAuthActivity.TAG, "intent auth confirm check failed session=" + r12 + " attempt=" + r13 + " reason=credential_service_unavailable");
            return d.c.b.a.b.a(false);
        L21:
            ISkillCredentialService.b r5 = r120.getApps();
            com.obric.aiagent.skill.credentials.api.f r20 = com.obric.aiagent.skill.credentials.api.f.f18949a;
            r0.f19090a = r12;
            r0.f19091b = r120;
            r0.f19092c = r13;
            r0.f = 1;
            Object r6 = r5.a(r20, r0);
            if (r6 != r16) goto L24;
            return r16;
        L24:
            r10 = r13;
            r117 = r120;
            r116 = r6;
        L7:
            r0 = new C0421a(this, r15);
            goto L8
        }

        private final void a(String r6, int r7, String r8, Throwable r9) {
            com.obric.aiagent.skill.credentials.api.h r0 = null;
            if (ZeusTransformUtils.instanceOf(r9, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L5;
            com.obric.aiagent.skill.credentials.api.e r5 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(r9, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
        L6:
            if (r5 == null) goto L9;
            r0 = r5.a();
        L9:
            if (r0 == null) goto L11;
            ILogDepend.Companion.w(SidecarAuthActivity.TAG, "intent auth confirm check failed session=" + r6 + " attempt=" + r7 + " method=" + r8 + " code=" + r0.b() + " type=" + r0.getType() + " subtype=" + r0.c());
            return;
        L11:
            ILogDepend.Companion.e(SidecarAuthActivity.TAG, "intent auth confirm check failed session=" + r6 + " attempt=" + r7 + " method=" + r8, r9);
            return;
        L5:
            r5 = null;
            goto L6
        }

        private final com.obric.aiagent.skill.credentials.api.l.c a() {
            return new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18986a, "Authorization flow completed.", null, null, 12, null);
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    private static final class b extends RuntimeException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f19098a;

        public final int a() {
            return this.f19098a;
        }

        public b(int r2) {
            super("Restart configCreateApp after Conditional Access return.");
            this.f19098a = r2;
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    private static final enum c extends Enum<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f19099a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f19100b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f19101c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f19102d = null;
        private static final /* synthetic */ c[] f = null;
        private static final /* synthetic */ d.d.a g = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f19103e;

        private static final /* synthetic */ c[] b() {
            return new c[]{f19099a, f19100b, f19101c, f19102d};
        }

        private c(String r1, int r2, String r3) {
            super(r1, r2);
            this.f19103e = r3;
        }

        public final String a() {
            return this.f19103e;
        }

        static {
            f19099a = new c("NONE", 0, OProtocolTextEffectTextView.EffectNameNone);
            f19100b = new c("COMPLETED", 1, "completed");
            f19101c = new c("CANCELED", 2, "canceled");
            f19102d = new c("DETACHED", 3, "detached");
            c[] r0 = b();
            f = r0;
            g = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static c valueOf(String r2) {
            return (c) ZeusTransformUtils.preCheckCast(Enum.valueOf(c.class, r2), c.class, "com.obric.aiagent.plugin");
        }

        public static c[] values() {
            return (c[]) ZeusTransformUtils.preCheckCast(f.clone(), c[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19104a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f19105b = null;

        static {
            int[] r0 = new int[com.obric.aiagent.skill.credentials.api.l.e.values().length];
            r0[com.obric.aiagent.skill.credentials.api.l.e.f18992b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L24:
            r0[com.obric.aiagent.skill.credentials.api.l.e.f18993c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L30:
            r0[com.obric.aiagent.skill.credentials.api.l.e.f18991a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L8:
            f19104a = r0;
            int[] r1 = new int[c.values().length];
            r1[c.f19100b.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L26:
            r1[c.f19101c.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L32:
            r1[c.f19099a.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L22:
            r1[c.f19102d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
        L13:
            f19105b = r1;
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {567}, d = "resetConfiguredApp", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity")
    static final class e extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f19107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarAuthActivity f19108c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f19109d;

        e(SidecarAuthActivity r3, d.c.d<? super e> r4) {
            SidecarAuthActivity r5 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19108c = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19107b = r3;
            this.f19109d |= Integer.MIN_VALUE;
            return SidecarAuthActivity.access$resetConfiguredApp(this.f19108c, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {481, 542, 558}, d = "runCreateAppWithRecovery", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity")
    static final class f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Object f19113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Object f19114e;
        int f;
        int g;
        /* synthetic */ Object h;
        final /* synthetic */ SidecarAuthActivity i;
        int j;

        f(SidecarAuthActivity r3, d.c.d<? super f> r4) {
            SidecarAuthActivity r5 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.i = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.h = r3;
            this.j |= Integer.MIN_VALUE;
            return SidecarAuthActivity.access$runCreateAppWithRecovery(this.i, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {1572}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$runCreateAppWithRecovery$2")
    static final class g extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarAuthActivity f19116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISkillCredentialService f19117c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f19118d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ z.d f19119e;
        final /* synthetic */ w<x> f;
        final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.b g;
        final /* synthetic */ z.a h;
        private /* synthetic */ Object i;

        /* JADX INFO: compiled from: SidecarAuthActivity.kt */
        @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$runCreateAppWithRecovery$2$1$1")
        static final class a extends l implements m<x, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f19120a;

            a(d.c.d<? super a> r3) {
                super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            public final Object a(x r3, d.c.d<? super x> r4) {
                return ((a) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
                return (d.c.d) ZeusTransformUtils.preCheckCast(new a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(x r3, d.c.d<? super x> r4) {
                return a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r1) {
                d.c.a.b.a();
                if (this.f19120a != 0) goto L7;
                d.o.a(r1);
                return x.f38692a;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SidecarAuthActivity.kt */
        @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$runCreateAppWithRecovery$2$1$2")
        static final class b extends l implements m<x, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            int f19121a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ au<x> f19122b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ z.d f19123c;

            b(au<x> r3, z.d r4, d.c.d<? super b> r5) {
                au<x> r6 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
                d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
                this.f19122b = r6;
                this.f19123c = r4;
                super(2, r7);
            }

            public final Object a(x r3, d.c.d<? super x> r4) {
                return ((b) ZeusTransformUtils.preCheckCast(create(r3, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
                d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f19122b, this.f19123c, r5), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(x r3, d.c.d<? super x> r4) {
                return a((x) ZeusTransformUtils.preCheckCast(r3, x.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r3) {
                d.c.a.b.a();
                if (this.f19121a != 0) goto L5;
                d.o.a(r3);
                ca.a.a((ca) ZeusTransformUtils.preCheckCast(this.f19122b, ca.class, "com.obric.aiagent.plugin"), null, 1, null);
                throw new b(this.f19123c.f38502a);
            L5:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: compiled from: SidecarAuthActivity.kt */
        @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {484, 483}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$runCreateAppWithRecovery$2$flowJob$1")
        static final class c extends l implements m<am, d.c.d<? super x>, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Object f19124a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            int f19125b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ SidecarAuthActivity f19126c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ ISkillCredentialService f19127d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ boolean f19128e;
            final /* synthetic */ z.d f;
            final /* synthetic */ w<x> g;
            final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.b h;
            final /* synthetic */ z.a i;

            c(SidecarAuthActivity r3, ISkillCredentialService r4, boolean r5, z.d r6, w<x> r7, com.obric.aiagent.skill.credentials.api.l.b r8, z.a r9, d.c.d<? super c> r10) {
                SidecarAuthActivity r11 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
                ISkillCredentialService r12 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillCredentialService.class, "com.obric.aiagent.plugin");
                w<x> r13 = (w) ZeusTransformUtils.wrapperContextForParams(r7, w.class, "com.obric.aiagent.plugin");
                d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
                this.f19126c = r11;
                this.f19127d = r12;
                this.f19128e = r5;
                this.f = r6;
                this.g = r13;
                this.h = r8;
                this.i = r9;
                super(2, r14);
            }

            public static /* synthetic */ x lambda$a7tf29SlpjTb_6icEbQxodmXZ5o(z.a r0) {
                return a(r0);
            }

            public static /* synthetic */ x lambda$tt1JJsb3HJQd7gA88fItsjjio6Y(w r0, com.obric.aiagent.skill.credentials.api.l.b r1, z.d r2) {
                return a(r0, r1, r2);
            }

            public final Object a(am r3, d.c.d<? super x> r4) {
                return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
            }

            @Override // d.c.b.a.a
            public final d.c.d<x> create(Object r11, d.c.d<?> r12) {
                d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
                return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f19126c, this.f19127d, this.f19128e, this.f, this.g, this.h, this.i, r9), d.c.d.class, "com.obric.aiagent.plugin");
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
                return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
            }

            @Override // d.c.b.a.a
            public final Object invokeSuspend(Object r13) {
                Object r0 = d.c.a.b.a();
                int r1 = this.f19125b;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                d.o.a(r13);
            L17:
                return x.f38692a;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                SidecarAuthActivity r2 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(this.f19124a, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
                d.o.a(r13);
            L13:
                SidecarAuthActivity r5 = r2;
                kotlinx.coroutines.b.h r6 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r13, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
                boolean r7 = this.f19128e;
                int r8 = this.f.f38502a;
                final w<x> r14 = this.g;
                final com.obric.aiagent.skill.credentials.api.l.b r3 = this.h;
                final z.d r4 = this.f;
                d.h.a.a r9 = new $$Lambda$SidecarAuthActivity$g$c$tt1JJsb3HJQd7gA88fItsjjio6Y(r14, r3, r4);
                final z.a r15 = this.i;
                d.h.a.a r10 = new $$Lambda$SidecarAuthActivity$g$c$a7tf29SlpjTb_6icEbQxodmXZ5o(r15);
                d.c.d r11 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f19124a = null;
                this.f19125b = 2;
                if (SidecarAuthActivity.access$runCredentialFlow(r5, r6, r7, r8, r9, r10, r11) != r0) goto L17;
                return r0;
            L10:
                d.o.a(r13);
                r2 = this.f19126c;
                ISkillCredentialService.b r16 = this.f19127d.getApps();
                com.obric.aiagent.skill.credentials.api.f r12 = com.obric.aiagent.skill.credentials.api.f.f18949a;
                d.c.d<? super kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c>> r17 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
                this.f19124a = r2;
                this.f19125b = 1;
                r13 = r16.b(r12, r17);
                if (r13 != r0) goto L13;
                return r0;
            }

            private static final x a(w r2, com.obric.aiagent.skill.credentials.api.l.b r3, z.d r4) {
                if (((w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.aiagent.plugin")).a(x.f38692a) == false) goto L6;
                ILogDepend.Companion.i(SidecarAuthActivity.TAG, "intent auth conditional access retry signaled session=" + r3.a() + " attempt=" + r4.f38502a);
            L6:
                return x.f38692a;
            }

            private static final x a(z.a r1) {
                r1.f38499a = true;
                return x.f38692a;
            }
        }

        g(SidecarAuthActivity r3, ISkillCredentialService r4, boolean r5, z.d r6, w<x> r7, com.obric.aiagent.skill.credentials.api.l.b r8, z.a r9, d.c.d<? super g> r10) {
            SidecarAuthActivity r11 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            ISkillCredentialService r12 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            w<x> r13 = (w) ZeusTransformUtils.wrapperContextForParams(r7, w.class, "com.obric.aiagent.plugin");
            d.c.d r14 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19116b = r11;
            this.f19117c = r12;
            this.f19118d = r5;
            this.f19119e = r6;
            this.f = r13;
            this.g = r8;
            this.h = r9;
            super(2, r14);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), g.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r12, d.c.d<?> r13) {
            d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r13, d.c.d.class, "com.obric.aiagent.plugin");
            g r14 = new g(this.f19116b, this.f19117c, this.f19118d, this.f19119e, this.f, this.g, this.h, r10);
            r14.i = r12;
            return (d.c.d) ZeusTransformUtils.preCheckCast(r14, d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r19) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f19115a;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            d.o.a(r19);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r19);
            au r3 = kotlinx.coroutines.i.b((am) ZeusTransformUtils.preCheckCast(this.i, am.class, "com.obric.aiagent.plugin"), null, null, (m) ZeusTransformUtils.preCheckCast(new c(this.f19116b, this.f19117c, this.f19118d, this.f19119e, this.f, this.g, this.h, null), m.class, "com.obric.aiagent.plugin"), 3, null);
            w<x> r4 = this.f;
            z.d r6 = this.f19119e;
            kotlinx.coroutines.e.i r7 = new kotlinx.coroutines.e.i(getContext());
            kotlinx.coroutines.e.c r8 = (kotlinx.coroutines.e.c) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.e.c.class, "com.obric.aiagent.plugin");
            r8.a(r3.g(), (m) ZeusTransformUtils.preCheckCast(new a(null), m.class, "com.obric.aiagent.plugin"));
            r8.a(r4.g(), (m) ZeusTransformUtils.preCheckCast(new b(r3, r6, null), m.class, "com.obric.aiagent.plugin"));
            this.f19115a = 1;
            if (r7.a(this) != r1) goto L12;
            return r1;
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    static final class h<T> implements kotlinx.coroutines.b.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f19129a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f19130b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f19131c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ SidecarAuthActivity f19132d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d.h.a.a<x> f19133e;

        h(d.h.a.a<x> r3, boolean r4, int r5, SidecarAuthActivity r6, d.h.a.a<x> r7) {
            d.h.a.a<x> r8 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
            SidecarAuthActivity r9 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r6, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            d.h.a.a<x> r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
            this.f19129a = r8;
            this.f19130b = r4;
            this.f19131c = r5;
            this.f19132d = r9;
            this.f19133e = r10;
        }

        @Override // kotlinx.coroutines.b.i
        public /* synthetic */ Object emit(Object r3, d.c.d r4) {
            d.c.d<? super x> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return a((com.obric.aiagent.skill.credentials.api.c) ZeusTransformUtils.preCheckCast(r3, com.obric.aiagent.skill.credentials.api.c.class, "com.obric.aiagent.plugin"), r5);
        }

        public final Object a(com.obric.aiagent.skill.credentials.api.c r10, d.c.d<? super x> r11) {
            com.obric.aiagent.skill.credentials.api.c r12 = (com.obric.aiagent.skill.credentials.api.c) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.aiagent.skill.credentials.api.c.class, "com.obric.aiagent.plugin");
            d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r11, d.c.d.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r12, com.obric.aiagent.skill.credentials.api.c.b.class) == false) goto L9;
            d.h.a.a<x> r14 = this.f19129a;
            if (r14 == null) goto L7;
            r14.invoke();
        L7:
            ILogDepend.Companion.i(SidecarAuthActivity.TAG, "credential verification url flowId=" + ((com.obric.aiagent.skill.credentials.api.c.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.b.class, "com.obric.aiagent.plugin")).a().a() + " expires=" + ((com.obric.aiagent.skill.credentials.api.c.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.b.class, "com.obric.aiagent.plugin")).a().c() + " preserveCreateAppProfile=" + this.f19130b + " caRetry=" + this.f19131c + " url=" + a.a(SidecarAuthActivity.Companion, ((com.obric.aiagent.skill.credentials.api.c.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.b.class, "com.obric.aiagent.plugin")).a().b()));
            SidecarAuthActivity.access$loadAuthUrl(this.f19132d, ((com.obric.aiagent.skill.credentials.api.c.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.b.class, "com.obric.aiagent.plugin")).a().b(), ((com.obric.aiagent.skill.credentials.api.c.b) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.b.class, "com.obric.aiagent.plugin")).a().a(), this.f19130b, this.f19131c, this.f19133e);
        L13:
            return x.f38692a;
        L9:
            if (ZeusTransformUtils.instanceOf(r12, com.obric.aiagent.skill.credentials.api.c.a.class) == false) goto L17;
            ILogDepend.Companion.i(SidecarAuthActivity.TAG, "credential flow completed ok=" + ((com.obric.aiagent.skill.credentials.api.c.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.a.class, "com.obric.aiagent.plugin")).a().a() + " code=" + ((com.obric.aiagent.skill.credentials.api.c.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.a.class, "com.obric.aiagent.plugin")).a().b() + " type=" + ((com.obric.aiagent.skill.credentials.api.c.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.a.class, "com.obric.aiagent.plugin")).a().getType() + " subtype=" + ((com.obric.aiagent.skill.credentials.api.c.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.a.class, "com.obric.aiagent.plugin")).a().c());
            if (((com.obric.aiagent.skill.credentials.api.c.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.a.class, "com.obric.aiagent.plugin")).a().a() == true) goto L13;
            throw new com.obric.aiagent.skill.credentials.api.e(((com.obric.aiagent.skill.credentials.api.c.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.skill.credentials.api.c.a.class, "com.obric.aiagent.plugin")).a());
        L17:
            throw new d.k();
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {BDNetworkSpeedTest.KeyIsEnableIntelligentSpeedTest, 441, AbstractDialog.HORIZONTAL_MAX_WIDTH, 451, 450}, d = "runIntentAuthFlow", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity")
    static final class i extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f19134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f19135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f19136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f19137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ SidecarAuthActivity f19138e;
        int f;

        i(SidecarAuthActivity r3, d.c.d<? super i> r4) {
            SidecarAuthActivity r5 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19138e = r5;
            super(r6);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f19137d = r3;
            this.f |= Integer.MIN_VALUE;
            return SidecarAuthActivity.access$runIntentAuthFlow(this.f19138e, null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {379}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$startIntentAuthFlowOrClose$1")
    static final class j extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.a f19140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ SidecarAuthActivity f19141c;

        j(com.obric.aiagent.skill.credentials.api.l.a r3, SidecarAuthActivity r4, d.c.d<? super j> r5) {
            SidecarAuthActivity r6 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r4, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19140b = r3;
            this.f19141c = r6;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((j) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), j.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new j(this.f19140b, this.f19141c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19139a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r5);
        L11:
            com.obric.aiagent.skill.credentials.api.l.c r6 = (com.obric.aiagent.skill.credentials.api.l.c) ZeusTransformUtils.preCheckCast(r5, com.obric.aiagent.skill.credentials.api.l.c.class, "com.obric.aiagent.plugin");
            if (SidecarAuthActivity.access$getIntentAuthFinished$p(this.f19141c) == true) goto L15;
            SidecarAuthActivity.access$setIntentAuthFinished$p(this.f19141c, true);
            ILogDepend.Companion.i(SidecarAuthActivity.TAG, "intent auth flow completed externally session=" + this.f19140b.a().a() + " status=" + r6.a().a());
            this.f19141c.finish();
        L15:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r5);
            w<com.obric.aiagent.skill.credentials.api.l.c> r7 = this.f19140b.b();
            d.c.d<? super com.obric.aiagent.skill.credentials.api.l.c> r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19139a = 1;
            r5 = r7.a(r2);
            if (r5 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: SidecarAuthActivity.kt */
    @d.c.b.a.f(b = "SidecarAuthActivity.kt", c = {392}, d = "invokeSuspend", e = "com.obric.aiagent.skill.credentials.impl.ui.SidecarAuthActivity$startIntentAuthFlowOrClose$2")
    static final class k extends l implements m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f19142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SidecarAuthActivity f19143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISkillCredentialService f19144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.obric.aiagent.skill.credentials.api.l.a f19145d;

        k(SidecarAuthActivity r3, ISkillCredentialService r4, com.obric.aiagent.skill.credentials.api.l.a r5, d.c.d<? super k> r6) {
            SidecarAuthActivity r7 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
            ISkillCredentialService r8 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r4, ISkillCredentialService.class, "com.obric.aiagent.plugin");
            d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f19143b = r7;
            this.f19144c = r8;
            this.f19145d = r5;
            super(2, r9);
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((k) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), k.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new k(this.f19143b, this.f19144c, this.f19145d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r13) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f19142a;
            if (r1 == 0) goto L13;
            if (r1 != 1) goto L12;
            d.o.a(r13);     // Catch: Throwable -> L7 CancellationException -> L9
        L17:
            SidecarAuthActivity.access$setIntentAuthFinished$p(this.f19143b, true);     // Catch: Throwable -> L7 CancellationException -> L9
            com.obric.aiagent.skill.credentials.api.l.f18971a.a(this.f19145d.a().a(), new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18986a, "Authorization flow completed.", null, null, 12, null));     // Catch: Throwable -> L7 CancellationException -> L9
            ILogDepend.Companion.i(SidecarAuthActivity.TAG, "intent auth completed session=" + this.f19145d.a().a());     // Catch: Throwable -> L7 CancellationException -> L9
            this.f19143b.finish();     // Catch: Throwable -> L7 CancellationException -> L9
        L41:
            return x.f38692a;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            d.o.a(r13);
            SidecarAuthActivity r14 = this.f19143b;     // Catch: Throwable -> L7 CancellationException -> L9
            ISkillCredentialService r2 = this.f19144c;     // Catch: Throwable -> L7 CancellationException -> L9
            com.obric.aiagent.skill.credentials.api.l.b r5 = this.f19145d.a();     // Catch: Throwable -> L7 CancellationException -> L9
            d.c.d r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L7 CancellationException -> L9
            this.f19142a = 1;     // Catch: Throwable -> L7 CancellationException -> L9
            if (SidecarAuthActivity.access$runIntentAuthFlow(r14, r2, r5, r6) != r0) goto L17;
            return r0;
        L9:
            e = move-exception;
            ILogDepend.Companion.i(SidecarAuthActivity.TAG, "intent auth coroutine canceled session=" + this.f19145d.a().a());
            throw e;
        L7:
            th = move-exception;
            SidecarAuthActivity.access$setIntentAuthFinished$p(this.f19143b, true);
            com.obric.aiagent.skill.credentials.api.l r3 = com.obric.aiagent.skill.credentials.api.l.f18971a;
            String r4 = this.f19145d.a().a();
            com.obric.aiagent.skill.credentials.api.l.d r7 = com.obric.aiagent.skill.credentials.api.l.d.f18988c;
            String r8 = th.getMessage();
            if (r8 != null) goto L22;
            r8 = "Authorization flow failed.";
        L22:
            String r9 = null;
            if (ZeusTransformUtils.instanceOf(th, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L25;
            com.obric.aiagent.skill.credentials.api.e r10 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(th, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
        L26:
            if (r10 == null) goto L30;
            com.obric.aiagent.skill.credentials.api.h r11 = r10.a();
            if (r11 == null) goto L30;
            String r12 = r11.getType();
        L32:
            if (ZeusTransformUtils.instanceOf(th, com.obric.aiagent.skill.credentials.api.e.class) == false) goto L34;
            com.obric.aiagent.skill.credentials.api.e r15 = (com.obric.aiagent.skill.credentials.api.e) ZeusTransformUtils.preCheckCast(th, com.obric.aiagent.skill.credentials.api.e.class, "com.obric.aiagent.plugin");
        L35:
            if (r15 == null) goto L39;
            com.obric.aiagent.skill.credentials.api.h r16 = r15.a();
            if (r16 == null) goto L39;
            r9 = r16.c();
        L39:
            r3.a(r4, new com.obric.aiagent.skill.credentials.api.l.c(r7, r8, r12, r9));
            ILogDepend.Companion.e(SidecarAuthActivity.TAG, "intent auth failed session=" + this.f19145d.a().a(), th);
            this.f19143b.finish();
            goto L41
        L34:
            r15 = null;
        L30:
            r12 = null;
            goto L32
        L25:
            r10 = null;
            goto L26
        }
    }

    public static /* synthetic */ View lambda$0kfPJni_CynbVCFzve4WM_OcQhU(SidecarAuthActivity r0) {
        return contentContainer_delegate$lambda$0(r0);
    }

    public static /* synthetic */ ProgressBar lambda$7RrzuDj6MCFZednbKpthUwEXUcs(SidecarAuthActivity r0) {
        return progressBar_delegate$lambda$2(r0);
    }

    public static /* synthetic */ x lambda$ArgA3la_OepPRVUSdTrOYXczMbY(SidecarAuthActivity r0, String r1, String r2, String r3) {
        return bindBridgeIfNeeded$lambda$29(r0, r1, r2, r3);
    }

    public static /* synthetic */ OPageStatus lambda$GeMZbAKXs9z3mLob1SpqLR6XL1w(SidecarAuthActivity r0) {
        return errorStatus_delegate$lambda$3(r0);
    }

    public static /* synthetic */ void lambda$HkfAbbZBENhMmOFyiOk9rMtDZFA(String r0, String r1, String r2, SidecarAuthActivity r3) {
        bindBridgeIfNeeded$lambda$29$lambda$28(r0, r1, r2, r3);
    }

    public static /* synthetic */ WebView lambda$OZ9WXWYUXOn2cYLD9iGeN0eJb1U(SidecarAuthActivity r0) {
        return webView_delegate$lambda$1(r0);
    }

    public static /* synthetic */ al lambda$SLhxAg3ng59T3fZAXAAZyuUEsA0(View r0, SidecarAuthActivity r1, OFloatingTitleBar r2, int r3, View r4, al r5) {
        return updatePaddingForTitleBarAndNavigationBar$lambda$34(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: lambda$ZiHmAEPjngYWGWqlDNtKnoLz-ns, reason: not valid java name */
    public static /* synthetic */ WindowInsets m254lambda$ZiHmAEPjngYWGWqlDNtKnoLzns(View r0, WindowInsets r1) {
        return configureGlassSystemBars$lambda$32(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$bkHCSRAT6SgfAOsNpf-4GV9cHzY, reason: not valid java name */
    public static /* synthetic */ void m255lambda$bkHCSRAT6SgfAOsNpf4GV9cHzY(SidecarAuthActivity r0, View r1) {
        initTitleBar$lambda$6$lambda$5(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$fmPM3Mknq-tfZZpM7nO1itoj3fI, reason: not valid java name */
    public static /* synthetic */ void m256lambda$fmPM3MknqtfZZpM7nO1itoj3fI(View r0, SidecarAuthActivity r1, OFloatingTitleBar r2, int r3, int r4) {
        updatePaddingForTitleBarAndNavigationBar$lambda$34$lambda$33(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$hvioymmvF1lgl-LQLsFzaMMRbFE, reason: not valid java name */
    public static /* synthetic */ void m257lambda$hvioymmvF1lglLQLsFzaMMRbFE(SidecarAuthActivity r0, String r1) {
        bindBridgeIfNeeded$lambda$31$lambda$30(r0, r1);
    }

    public static /* synthetic */ x lambda$iQuwyxEWCypnXGvGjVBEXRdRFQc(SidecarAuthActivity r0, String r1) {
        return bindBridgeIfNeeded$lambda$31(r0, r1);
    }

    public SidecarAuthActivity() {
        this.contentContainer$delegate = d.g.a(new $$Lambda$SidecarAuthActivity$0kfPJni_CynbVCFzve4WM_OcQhU(this));
        this.webView$delegate = d.g.a(new $$Lambda$SidecarAuthActivity$OZ9WXWYUXOn2cYLD9iGeN0eJb1U(this));
        this.progressBar$delegate = d.g.a(new $$Lambda$SidecarAuthActivity$7RrzuDj6MCFZednbKpthUwEXUcs(this));
        this.errorStatus$delegate = d.g.a(new $$Lambda$SidecarAuthActivity$GeMZbAKXs9z3mLob1SpqLR6XL1w(this));
        this.intentAuthScope = an.a();
        this.intentAuthCloseState = c.f19099a;
    }

    public static final /* synthetic */ void access$confirmIntentAuthCompletionOrDetach(SidecarAuthActivity r2) {
        ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).confirmIntentAuthCompletionOrDetach();
    }

    public static final /* synthetic */ Set access$getCONDITIONAL_ACCESS_DENY_HOSTS$cp() {
        return CONDITIONAL_ACCESS_DENY_HOSTS;
    }

    public static final /* synthetic */ Set access$getIMAGE_FILE_EXTENSIONS$cp() {
        return IMAGE_FILE_EXTENSIONS;
    }

    public static final /* synthetic */ ca access$getIntentAuthConfirmJob$cp() {
        return intentAuthConfirmJob;
    }

    public static final /* synthetic */ am access$getIntentAuthConfirmScope$cp() {
        return intentAuthConfirmScope;
    }

    public static final /* synthetic */ String access$getIntentAuthConfirmSessionId$cp() {
        return intentAuthConfirmSessionId;
    }

    public static final /* synthetic */ boolean access$getIntentAuthFinished$p(SidecarAuthActivity r2) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).intentAuthFinished;
    }

    public static final /* synthetic */ WeakReference access$getIntentAuthOwner$cp() {
        return intentAuthOwner;
    }

    public static final /* synthetic */ String access$getIntentAuthSessionId$p(SidecarAuthActivity r2) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).intentAuthSessionId;
    }

    public static final /* synthetic */ Set access$getLARK_CLI_PAGE_HOSTS$cp() {
        return LARK_CLI_PAGE_HOSTS;
    }

    public static final /* synthetic */ ProgressBar access$getProgressBar(SidecarAuthActivity r2) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).getProgressBar();
    }

    public static final /* synthetic */ void access$handleConditionalAccessNavigation(SidecarAuthActivity r2, String r3) {
        ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).handleConditionalAccessNavigation(r3);
    }

    public static final /* synthetic */ boolean access$handleImageFileChooser(SidecarAuthActivity r2, ValueCallback r3, WebChromeClient.FileChooserParams r4) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).handleImageFileChooser((ValueCallback) ZeusTransformUtils.wrapperContextForParams(r3, ValueCallback.class, "com.obric.aiagent.plugin"), r4);
    }

    public static final /* synthetic */ boolean access$handleNonHttpUrl(SidecarAuthActivity r2, Uri r3) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).handleNonHttpUrl(r3);
    }

    public static final /* synthetic */ void access$loadAuthUrl(SidecarAuthActivity r8, String r9, String r10, boolean r11, int r12, d.h.a.a r13) {
        ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r8, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).loadAuthUrl(r9, r10, r11, r12, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$resetConfiguredApp(SidecarAuthActivity r2, ISkillCredentialService r3, String r4, d.c.d r5) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).resetConfiguredApp((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$runCreateAppWithRecovery(SidecarAuthActivity r2, ISkillCredentialService r3, com.obric.aiagent.skill.credentials.api.l.b r4, d.c.d r5) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).runCreateAppWithRecovery((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$runCredentialFlow(SidecarAuthActivity r9, kotlinx.coroutines.b.h r10, boolean r11, int r12, d.h.a.a r13, d.h.a.a r14, d.c.d r15) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r9, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).runCredentialFlow((kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r10, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"), r11, r12, (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.a.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r15, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object access$runIntentAuthFlow(SidecarAuthActivity r2, ISkillCredentialService r3, com.obric.aiagent.skill.credentials.api.l.b r4, d.c.d r5) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).runIntentAuthFlow((ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r3, ISkillCredentialService.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ void access$setIntentAuthConfirmJob$cp(ca r2) {
        intentAuthConfirmJob = (ca) ZeusTransformUtils.wrapperContextForParams(r2, ca.class, "com.obric.aiagent.plugin");
    }

    public static final /* synthetic */ void access$setIntentAuthConfirmSessionId$cp(String r0) {
        intentAuthConfirmSessionId = r0;
    }

    public static final /* synthetic */ void access$setIntentAuthFinished$p(SidecarAuthActivity r2, boolean r3) {
        ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).intentAuthFinished = r3;
    }

    public static final /* synthetic */ void access$setIntentAuthOwner$cp(WeakReference r0) {
        intentAuthOwner = r0;
    }

    public static final /* synthetic */ void access$showError(SidecarAuthActivity r2) {
        ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).showError();
    }

    public static final /* synthetic */ void access$showLoading(SidecarAuthActivity r2) {
        ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).showLoading();
    }

    private static final View contentContainer_delegate$lambda$0(SidecarAuthActivity r3) {
        return ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.sidecar_auth_content_container, DbHelper.COL_ID, "sidecar_auth_content_container"));
    }

    private final View getContentContainer() {
        Object r2 = this.contentContainer$delegate.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (View) ZeusTransformUtils.preCheckCast(r2, View.class, "com.obric.aiagent.plugin");
    }

    private final WebView getWebView() {
        Object r2 = this.webView$delegate.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (WebView) ZeusTransformUtils.preCheckCast(r2, WebView.class, "com.obric.aiagent.plugin");
    }

    private static final WebView webView_delegate$lambda$1(SidecarAuthActivity r4) {
        return (WebView) ZeusTransformUtils.preCheckCast(((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r4, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.sidecar_auth_web_view, DbHelper.COL_ID, "sidecar_auth_web_view")), WebView.class, "com.obric.aiagent.plugin");
    }

    private final ProgressBar getProgressBar() {
        Object r2 = this.progressBar$delegate.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (ProgressBar) ZeusTransformUtils.preCheckCast(r2, ProgressBar.class, "com.obric.aiagent.plugin");
    }

    private static final ProgressBar progressBar_delegate$lambda$2(SidecarAuthActivity r4) {
        return (ProgressBar) ZeusTransformUtils.preCheckCast(((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r4, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.sidecar_auth_progress, DbHelper.COL_ID, "sidecar_auth_progress")), ProgressBar.class, "com.obric.aiagent.plugin");
    }

    private static final OPageStatus errorStatus_delegate$lambda$3(SidecarAuthActivity r4) {
        return (OPageStatus) ZeusTransformUtils.preCheckCast(((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r4, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).findViewById(ZeusTransformUtils.mapRes(R.id.sidecar_auth_error_status, DbHelper.COL_ID, "sidecar_auth_error_status")), OPageStatus.class, "com.obric.aiagent.plugin");
    }

    private final OPageStatus getErrorStatus() {
        Object r2 = this.errorStatus$delegate.b();
        d.h.b.o.c(r2, "getValue(...)");
        return (OPageStatus) ZeusTransformUtils.preCheckCast(r2, OPageStatus.class, "com.obric.aiagent.plugin");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity
    public void onCreate(Bundle r5) {
        super.onCreate(r5);
        ILogDepend.Companion r6 = ILogDepend.Companion;
        StringBuilder r0 = new StringBuilder().append("onCreate ");
        a r1 = Companion;
        Intent r2 = getIntent();
        d.h.b.o.c(r2, "getIntent(...)");
        r6.i(TAG, r0.append(a.a(r1, r2)).toString());
        configureGlassSystemBars();
        setContentView(ZeusTransformUtils.mapRes(R.layout.activity_sidecar_auth, "layout", "activity_sidecar_auth"));
        initTitleBar();
        setupWebView();
        View r7 = getContentContainer();
        View r3 = findViewById(ZeusTransformUtils.mapRes(R.id.sidecar_auth_title_bar, DbHelper.COL_ID, "sidecar_auth_title_bar"));
        d.h.b.o.c(r3, "findViewById(...)");
        updatePaddingForTitleBarAndNavigationBar(r7, (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(r3, OFloatingTitleBar.class, "com.obric.aiagent.plugin"));
        bindBridgeIfNeeded();
        loadUrlFromIntent();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onNewIntent(Intent r5) {
        super.onNewIntent(r5);
        if (r5 == null) goto L5;
        setIntent(r5);
    L5:
        ILogDepend.Companion r6 = ILogDepend.Companion;
        StringBuilder r0 = new StringBuilder().append("onNewIntent ");
        a r1 = Companion;
        Intent r2 = getIntent();
        d.h.b.o.c(r2, "getIntent(...)");
        r6.i(TAG, r0.append(a.a(r1, r2)).toString());
        bindBridgeIfNeeded();
        loadUrlFromIntent();
    }

    private final void initTitleBar() {
        OFloatingTitleBar r3 = (OFloatingTitleBar) ZeusTransformUtils.preCheckCast(findViewById(ZeusTransformUtils.mapRes(R.id.sidecar_auth_title_bar, DbHelper.COL_ID, "sidecar_auth_title_bar")), OFloatingTitleBar.class, "com.obric.aiagent.plugin");
        r3.setFloatingTransitionEnabled(true);
        OFloatingTitleBar.removeAllStartAction$default(r3, false, 1, null);
        OFloatingTitleBar.removeAllEndAction$default(r3, false, 1, null);
        r3.setCenterTitle(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_title"));
        OFloatingTitleBar.addStartAction$default(r3, ZeusTransformUtils.mapRes(R.drawable.o_floating_title_bar_icon_back, "drawable", "o_floating_title_bar_icon_back"), 0, new $$Lambda$SidecarAuthActivity$bkHCSRAT6SgfAOsNpf4GV9cHzY(this), 2, null).setContentDescription((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_back, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_back")), CharSequence.class, "com.obric.aiagent.plugin"));
    }

    private static final void initTitleBar$lambda$6$lambda$5(SidecarAuthActivity r1, View r2) {
        ((SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r1, SidecarAuthActivity.class, "com.obric.aiagent.plugin")).handleCloseRequest();
    }

    private final void setupWebView() {
        WebSettings r0 = getWebView().getSettings();
        r0.setJavaScriptEnabled(true);
        r0.setDomStorageEnabled(true);
        r0.setLoadWithOverviewMode(true);
        r0.setUseWideViewPort(true);
        r0.setCacheMode(-1);
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r0.setMixedContentMode(2);
    L5:
        applyEnterpriseAuthenticationAppLinkPolicy();
        getWebView().setWebViewClient((WebViewClient) ZeusTransformUtils.preCheckCast(new C11142(this), WebViewClient.class, "com.obric.aiagent.plugin"));
        getWebView().setWebChromeClient((WebChromeClient) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this), WebChromeClient.class, "com.obric.aiagent.plugin"));
    }

    private final boolean handleImageFileChooser(ValueCallback<Uri[]> r7, WebChromeClient.FileChooserParams r8) {
        ValueCallback<Uri[]> r9 = (ValueCallback) ZeusTransformUtils.wrapperContextForParams(r7, ValueCallback.class, "com.obric.aiagent.plugin");
        a r0 = Companion;
        List r1 = a.a(r0, r8);
        if (r8.getMode() != 1) goto L5;
        boolean r2 = true;
    L7:
        if (a.a(r0, r1) == true) goto L10;
        ILogDepend.Companion.i(TAG, "cancel unsupported webview file chooser acceptTypes=" + a.b(r0, r1) + " mode=" + r8.getMode());
        r9.onReceiveValue(null);
        return true;
    L10:
        ValueCallback<Uri[]> r3 = this.imageFilePathCallback;
        if (r3 == null) goto L13;
        r3.onReceiveValue(null);
    L13:
        this.imageFilePathCallback = r9;
        if (launchImagePicker(r8, r2) == true) goto L16;
        this.imageFilePathCallback = null;
        r9.onReceiveValue(null);
    L16:
        return true;
    L5:
        r2 = false;
        goto L7
    }

    private final boolean launchImagePicker(WebChromeClient.FileChooserParams r3, boolean r4) {
        Intent r0 = createSystemImagePickerIntent(r4);
        if (r0 == null) goto L9;
        if (startImagePickerIntent(r0, r3, "photo_picker") == false) goto L9;
        return true;
    L9:
        return startImagePickerIntent(createFallbackImagePickerIntent(r4), r3, "get_content");
    }

    private final Intent createSystemImagePickerIntent(boolean r2) {
        if (Build.VERSION.SDK_INT >= 33) goto L6;
        return null;
    L6:
        Intent r1 = new Intent("android.provider.action.PICK_IMAGES");
        r1.setType(IMAGE_MIME_TYPE);
        r1.addFlags(1);
        if (r2 == false) goto L9;
        r1.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        r1.putExtra("android.provider.extra.PICK_IMAGES_MAX", MediaStore.getPickImagesMaxLimit());
    L9:
        return r1;
    }

    private final Intent createFallbackImagePickerIntent(boolean r2) {
        Intent r1 = new Intent("android.intent.action.GET_CONTENT");
        r1.addCategory("android.intent.category.OPENABLE");
        r1.setType(IMAGE_MIME_TYPE);
        r1.addFlags(1);
        if (r2 == false) goto L5;
        r1.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
    L5:
        return r1;
    }

    private final boolean startImagePickerIntent(Intent r5, WebChromeClient.FileChooserParams r6, String r7) {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L5
        ZeusTransformUtils.startActivityForResult((SidecarAuthActivity) ZeusTransformUtils.preCheckCast(this, SidecarAuthActivity.class, "com.obric.aiagent.plugin"), r5, 7001, "com.obric.aiagent.plugin");     // Catch: Throwable -> L5
        Object r4 = n.f(x.f38692a);     // Catch: Throwable -> L5
    L8:
        if (n.a(r4) == false) goto L10;
        x r8 = (x) ZeusTransformUtils.preCheckCast(r4, x.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion r9 = ILogDepend.Companion;
        StringBuilder r0 = new StringBuilder().append("start image picker source=").append(r7).append(" mode=").append(r6.getMode()).append(" acceptTypes=");
        a r2 = Companion;
        r9.i(TAG, r0.append(a.b(r2, a.a(r2, r6))).append(" capture=").append(r6.isCaptureEnabled()).toString());
    L10:
        Throwable r10 = n.c(r4);
        if (r10 == null) goto L17;
        if (ZeusTransformUtils.instanceOf(r10, ActivityNotFoundException.class) == false) goto L15;
        ILogDepend.Companion.w(TAG, "image picker unavailable source=" + r7);
        goto L17
    L15:
        ILogDepend.Companion.e(TAG, "start image picker failed source=" + r7, r10);
    L17:
        return n.a(r4);
    L5:
        th = move-exception;
        n.a r11 = n.f38560a;
        r4 = n.f(d.o.a(th));
        goto L8
    }

    private final void loadUrlFromIntent() {
        String r0 = getIntent().getStringExtra(EXTRA_URL);
        if (r0 != null) goto L7;
        r0 = getIntent().getStringExtra(EXTRA_LEGACY_URL);
        if (r0 != null) goto L7;
        r0 = getIntent().getStringExtra("url");
    L7:
        String r2 = r0;
        String r1 = getIntent().getStringExtra(EXTRA_FLOW_ID);
        if (r1 != null) goto L10;
        r1 = "";
    L10:
        String r3 = r1;
        CharSequence r4 = (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L18:
        if (r5 == false) goto L21;
        ILogDepend.Companion.i(TAG, "no url extra, try active lark cli intent auth flow");
        startIntentAuthFlowOrClose();
        return;
    L21:
        ILogDepend.Companion.i(TAG, "load explicit auth url flowId=" + r3 + " url=" + a.a(Companion, r2));
        loadAuthUrl$default(this, r2, r3, false, 0, null, 28, null);
        return;
    L13:
        if (d.o.o.d(r4) == true) goto L16;
        r5 = false;
        goto L18
    }

    private final void startIntentAuthFlowOrClose() {
        com.obric.aiagent.skill.credentials.api.l.a r0 = com.obric.aiagent.skill.credentials.api.l.f18971a.a();
        if (r0 != null) goto L6;
        ILogDepend.Companion.w(TAG, "no active lark cli intent auth flow, close activity");
        finish();
        return;
    L6:
        ISkillCredentialService r2 = ISkillCredentialService.Companion.a();
        if (r2 != null) goto L11;
        ILogDepend.Companion.e(TAG, "credential service unavailable for intent auth session=" + r0.a().a());
        com.obric.aiagent.skill.credentials.api.l.f18971a.a("ISkillCredentialService is unavailable.", "credential_service_unavailable");
        finish();
        return;
    L11:
        if (d.h.b.o.a(this.intentAuthSessionId, r0.a().a()) == true) goto L13;
    L16:
        a r3 = Companion;
        if (a.a(r3, this, r0.a().a()) == true) goto L20;
        ILogDepend.Companion.i(TAG, "intent auth already owned by another activity session=" + r0.a().a() + " movedToFront=" + a.b(r3, this, r0.a().a()) + " currentTaskId=" + getTaskId());
        finish();
        return;
    L20:
        this.intentAuthSessionId = r0.a().a();
        this.intentAuthFinished = false;
        this.intentAuthCloseState = c.f19099a;
        ca r4 = this.intentAuthJob;
        if (r4 == null) goto L23;
        ca.a.a(r4, null, 1, null);
    L23:
        ca r5 = this.intentAuthCompletionJob;
        if (r5 == null) goto L26;
        ca.a.a(r5, null, 1, null);
    L26:
        com.obric.aiagent.skill.credentials.api.l.f18971a.b(r0.a().a());
        ILogDepend.Companion.i(TAG, "start intent auth session=" + r0.a().a() + " authType=" + r0.a().e().a() + " requiresAppSetup=" + r0.a().g() + " missingScopes=" + r0.a().d());
        this.intentAuthCompletionJob = kotlinx.coroutines.i.a(this.intentAuthScope, null, null, (m) ZeusTransformUtils.preCheckCast(new j(r0, this, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        this.intentAuthJob = kotlinx.coroutines.i.a(this.intentAuthScope, null, null, (m) ZeusTransformUtils.preCheckCast(new k(this, r2, r0, null), m.class, "com.obric.aiagent.plugin"), 3, null);
        return;
    L13:
        if (this.intentAuthFinished == true) goto L16;
        ILogDepend.Companion.i(TAG, "intent auth already running in current activity session=" + r0.a().a());
    }

    private final Object runIntentAuthFlow(ISkillCredentialService r17, com.obric.aiagent.skill.credentials.api.l.b r18, d.c.d<? super x> r19) {
        SidecarAuthActivity r0 = this;
        com.obric.aiagent.skill.credentials.api.l.b r1 = r18;
        ISkillCredentialService r3 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r17, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, i.class) == false) goto L7;
        i r6 = (i) ZeusTransformUtils.preCheckCast(r5, i.class, "com.obric.aiagent.plugin");
        if ((r6.f & Integer.MIN_VALUE) == 0) goto L7;
        r6.f -= Integer.MIN_VALUE;
    L8:
        i r13 = r6;
        Object r7 = r13.f19137d;
        Object r8 = d.c.a.b.a();
        int r9 = r13.f;
        if (r9 == 0) goto L24;
        if (r9 == 1) goto L23;
        if (r9 == 2) goto L21;
        if (r9 == 3) goto L20;
        if (r9 == 4) goto L18;
        if (r9 != 5) goto L17;
        d.o.a(r7);
    L39:
        return x.f38692a;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r0 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r13.f19134a, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
    L19:
        SidecarAuthActivity r10 = r0;
        kotlinx.coroutines.b.h r2 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        r13.f19134a = null;
        r13.f = 5;
        if (runCredentialFlow$default(r10, r2, false, 0, null, null, r13, 30, null) != r8) goto L39;
        return r8;
    L20:
        d.o.a(r7);
    L53:
        return x.f38692a;
    L21:
        r0 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r13.f19134a, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
    L22:
        SidecarAuthActivity r11 = r0;
        kotlinx.coroutines.b.h r12 = (kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        r13.f19134a = null;
        r13.f = 3;
        if (runCredentialFlow$default(r11, r12, false, 0, null, null, r13, 30, null) != r8) goto L53;
        return r8;
    L23:
        com.obric.aiagent.skill.credentials.api.l.b r4 = (com.obric.aiagent.skill.credentials.api.l.b) ZeusTransformUtils.preCheckCast(r13.f19136c, com.obric.aiagent.skill.credentials.api.l.b.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r14 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r13.f19135b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SidecarAuthActivity r15 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r13.f19134a, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r7);
        r3 = r14;
        r1 = r4;
        r0 = r15;
    L46:
        ILogDepend.Companion.i(TAG, "intent auth login start session=" + r1.a() + " scopeCount=" + r1.c().size());
        ISkillCredentialService.a r16 = r3.getAccount();
        com.obric.aiagent.skill.credentials.api.f r20 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        List<String> r21 = r1.c();
        r13.f19134a = r0;
        r13.f19135b = null;
        r13.f19136c = null;
        r13.f = 2;
        r7 = r16.a(r20, r21, r13);
        if (r7 != r8) goto L22;
        return r8;
    L24:
        d.o.a(r7);
        int r22 = d.f19104a[r18.e().ordinal()];
        if (r22 == 1) goto L41;
        if (r22 == 2) goto L32;
        if (r22 != 3) goto L31;
        ILogDepend.Companion.i(TAG, "intent auth no-op session=" + r18.a());
        return x.f38692a;
    L31:
        throw new d.k();
    L32:
        ILogDepend.Companion.i(TAG, "intent auth requestGrant start session=" + r18.a() + " missingScopes=" + r18.d());
        ISkillCredentialService.a r23 = r3.getAccount();
        com.obric.aiagent.skill.credentials.api.f r24 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        List<String> r25 = r18.d();
        r13.f19134a = r0;
        r13.f = 4;
        r7 = r23.b(r24, r25, r13);
        if (r7 != r8) goto L19;
        return r8;
    L41:
        if (r18.g() == false) goto L45;
        ILogDepend.Companion.i(TAG, "intent auth configCreateApp start session=" + r18.a());
        r13.f19134a = r0;
        r13.f19135b = r3;
        r13.f19136c = r1;
        r13.f = 1;
        if (r0.runCreateAppWithRecovery(r3, r1, r13) != r8) goto L46;
        return r8;
    L45:
        ILogDepend.Companion.i(TAG, "intent auth skip configCreateApp session=" + r18.a());
    L7:
        r6 = new i(r0, r5);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x028a -> B:62:0x0293). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:68:0x02a0 -> B:62:0x0293). Please report as a decompilation issue!!! */
    private final Object runCreateAppWithRecovery(ISkillCredentialService r28, com.obric.aiagent.skill.credentials.api.l.b r29, d.c.d<? super x> r30) {
        ISkillCredentialService r1 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r28, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r30, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, f.class) == false) goto L7;
        f r4 = (f) ZeusTransformUtils.preCheckCast(r3, f.class, "com.obric.aiagent.plugin");
        if ((r4.j & Integer.MIN_VALUE) == 0) goto L7;
        r4.j -= Integer.MIN_VALUE;
        SidecarAuthActivity r5 = this;
    L8:
        Object r6 = r4.h;
        Object r7 = d.c.a.b.a();
        int r8 = r4.j;
        ca r11 = null;
        int r14 = 1;
        if (r8 == 0) goto L24;
        if (r8 == 1) goto L17;
        if (r8 == 2) goto L16;
        if (r8 != 3) goto L15;
        int r2 = r4.g;
        int r9 = r4.f;
        z.d r10 = (z.d) ZeusTransformUtils.preCheckCast(r4.f19113d, z.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.l.b r12 = (com.obric.aiagent.skill.credentials.api.l.b) ZeusTransformUtils.preCheckCast(r4.f19112c, com.obric.aiagent.skill.credentials.api.l.b.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r13 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r4.f19111b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SidecarAuthActivity r0 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r4.f19110a, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        ISkillCredentialService r15 = r13;
        Object r16 = r7;
        z.d r17 = r10;
        f r18 = r4;
        int r19 = r9;
        r5 = r0;
        int r20 = r2;
        com.obric.aiagent.skill.credentials.api.l.b r21 = r12;
        ca r110 = null;
    L62:
        r11 = r110;
    L50:
        r14 = 1;
    L25:
        w r22 = y.a(r11, r14, r11);
        z.a r111 = new z.a();
        if (r17.f38502a <= 0) goto L28;
        int r23 = r14;
    L71:
    L39:
        com.obric.aiagent.skill.credentials.api.e e2 = e;
        SidecarAuthActivity r112 = r5;
        int r24 = r19;
        z.a r25 = r111;
        com.obric.aiagent.skill.credentials.api.l.b r113 = r21;
        int r26 = r20;
        r4 = r18;
        r7 = r16;
    L42:
        if (com.obric.aiagent.skill.credentials.api.d.b(e2.a()) == true) goto L44;
        com.obric.aiagent.skill.credentials.api.l.b r27 = r113;
        if (r25.f38499a == true) goto L63;
        if (r24 != 0) goto L63;
        if (com.obric.aiagent.skill.credentials.api.d.a(e2.a()) == false) goto L63;
        ILogDepend.Companion.w(TAG, "intent auth recover create app conflict session=" + r27.a() + " code=" + e2.a().b() + " subtype=" + e2.a().c());
        r4.f19110a = r112;
        r4.f19111b = r15;
        r4.f19112c = r27;
        r4.f19113d = r17;
        r110 = null;
        r4.f19114e = null;
        r4.f = 1;
        r4.g = r26;
        r4.j = 3;
        if (r112.resetConfiguredApp(r15, "intent auth create app", r4) != r7) goto L61;
        return r7;
    L61:
        r5 = r112;
        r19 = 1;
        f r210 = r4;
        r20 = r26;
        r21 = r27;
        r16 = r7;
        r18 = r210;
    L63:
        throw e2;
    L44:
        if (r26 >= 3) goto L51;
        int r31 = r26 + 1;
        ILogDepend.Companion.w(TAG, "intent auth retry create app because previous operation is in progress session=" + r113.a() + " retryCount=" + r31);
        com.obric.aiagent.skill.credentials.api.l.b r211 = r113;
        r4.f19110a = r112;
        r4.f19111b = r15;
        r4.f19112c = r211;
        r4.f19113d = r17;
        r4.f19114e = null;
        r4.f = r24;
        r4.g = r31;
        r4.j = 2;
        if (ax.a(1000, r4) != r7) goto L48;
        return r7;
    L48:
        int r32 = r24;
        r5 = r112;
        f r212 = r4;
        r20 = r31;
        r21 = r211;
        r16 = r7;
        r18 = r212;
        r19 = r32;
        r11 = null;
        goto L50
    L51:
        ILogDepend.Companion.w(TAG, "intent auth create app still in progress session=" + r113.a() + " retryCount=" + r26 + " reason=retry_exhausted");
        throw e2;
    L64:
        b e3 = e;
        r110 = r11;
    L67:
        if (r17.f38502a >= 1) goto L69;
        r17.f38502a++;
        ILogDepend.Companion.i(TAG, "intent auth restart configCreateApp after conditional access session=" + r21.a() + " nextAttempt=" + r17.f38502a + " preserveCreateAppProfile=true");
        goto L62
    L69:
        ILogDepend.Companion.w(TAG, "intent auth conditional access retry ignored session=" + r21.a() + " attempt=" + e3.a() + " reason=retry_exhausted");
        throw e3;
    L30:
        if (r23 == 0) goto L32;
        boolean r114 = r14;
    L33:
        m r33 = (m) ZeusTransformUtils.preCheckCast(new g(r5, r15, r114, r17, r22, r21, r111, null), m.class, "com.obric.aiagent.plugin");     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        r18.f19110a = r5;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        r18.f19111b = r15;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        r18.f19112c = r21;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        r18.f19113d = r17;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        r18.f19114e = r111;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        r18.f = r19;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        r18.g = r20;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        r18.j = r14;     // Catch: com.obric.aiagent.skill.credentials.api.e -> L39 b -> L64
        if (an.a(r33, r18) != r16) goto L36;
        return r16;
    L36:
        r112 = r5;
        r24 = r19;
        r25 = r111;
        r113 = r21;
        r26 = r20;
        r4 = r18;
        r7 = r16;
        z.d r34 = r17;
        ISkillCredentialService r115 = r15;
    L37:
        return x.f38692a;
    L20:
        e2 = e;
        r15 = r115;
        r17 = r34;
    L22:
        e3 = e;
        r19 = r24;
        r15 = r115;
        r5 = r112;
        r17 = r34;
        r16 = r7;
        r18 = r4;
        r20 = r26;
        r21 = r113;
        r110 = r11;
        goto L67
    L32:
        r114 = 0;
        goto L33
    L28:
        r23 = 0;
        goto L71
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        int r35 = r4.g;
        int r36 = r4.f;
        z.d r37 = (z.d) ZeusTransformUtils.preCheckCast(r4.f19113d, z.d.class, "com.obric.aiagent.plugin");
        com.obric.aiagent.skill.credentials.api.l.b r38 = (com.obric.aiagent.skill.credentials.api.l.b) ZeusTransformUtils.preCheckCast(r4.f19112c, com.obric.aiagent.skill.credentials.api.l.b.class, "com.obric.aiagent.plugin");
        ISkillCredentialService r116 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r4.f19111b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        SidecarAuthActivity r39 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r4.f19110a, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
        r17 = r37;
        r15 = r116;
        r5 = r39;
        f r213 = r4;
        r20 = r35;
        r21 = r38;
        r16 = r7;
        r18 = r213;
        r19 = r36;
        r11 = null;
        goto L50
    L17:
        r26 = r4.g;
        r24 = r4.f;
        r25 = (z.a) ZeusTransformUtils.preCheckCast(r4.f19114e, z.a.class, "com.obric.aiagent.plugin");
        r34 = (z.d) ZeusTransformUtils.preCheckCast(r4.f19113d, z.d.class, "com.obric.aiagent.plugin");
        r113 = (com.obric.aiagent.skill.credentials.api.l.b) ZeusTransformUtils.preCheckCast(r4.f19112c, com.obric.aiagent.skill.credentials.api.l.b.class, "com.obric.aiagent.plugin");
        r115 = (ISkillCredentialService) ZeusTransformUtils.preCheckCast(r4.f19111b, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        r112 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(r4.f19110a, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.o.a(r6);     // Catch: com.obric.aiagent.skill.credentials.api.e -> L20 b -> L22
        goto L37
    L24:
        d.o.a(r6);
        r17 = new z.d();
        r15 = r1;
        r16 = r7;
        r19 = 0;
        r21 = r29;
        r18 = r4;
        r20 = 0;
    L7:
        r5 = this;
        r4 = new f(r5, r3);
        goto L8
    }

    private final Object resetConfiguredApp(ISkillCredentialService r5, String r6, d.c.d<? super x> r7) {
        ISkillCredentialService r8 = (ISkillCredentialService) ZeusTransformUtils.wrapperContextForParams(r5, ISkillCredentialService.class, "com.obric.aiagent.plugin");
        d.c.d r9 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, e.class) == false) goto L7;
        e r0 = (e) ZeusTransformUtils.preCheckCast(r9, e.class, "com.obric.aiagent.plugin");
        if ((r0.f19109d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f19109d -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.f19107b;
        Object r10 = d.c.a.b.a();
        int r2 = r0.f19109d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r6 = (String) ZeusTransformUtils.preCheckCast(r0.f19106a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r4);
        Object r11 = ((n) ZeusTransformUtils.preCheckCast(r4, n.class, "com.obric.aiagent.plugin")).a();
    L17:
        Throwable r12 = n.c(r11);
        if (r12 != null) goto L25;
        com.obric.aiagent.skill.credentials.api.h r13 = (com.obric.aiagent.skill.credentials.api.h) ZeusTransformUtils.preCheckCast(r11, com.obric.aiagent.skill.credentials.api.h.class, "com.obric.aiagent.plugin");
        if (r13.a() == true) goto L22;
        ILogDepend.Companion.e(TAG, r6 + " delete configured app rejected code=" + r13.b() + " type=" + r13.getType() + " subtype=" + r13.c());
        throw new com.obric.aiagent.skill.credentials.api.e(r13);
    L22:
        return x.f38692a;
    L25:
        ILogDepend.Companion.e(TAG, r6 + " delete configured app failed", r12);
        throw r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r4);
        ISkillCredentialService.b r14 = r8.getApps();
        com.obric.aiagent.skill.credentials.api.f r15 = com.obric.aiagent.skill.credentials.api.f.f18949a;
        r0.f19106a = r6;
        r0.f19109d = 1;
        r11 = r14.c(r15, r0);
        if (r11 != r10) goto L17;
        return r10;
    L7:
        r0 = new e(this, r9);
        goto L8
    }

    static /* synthetic */ Object runCredentialFlow$default(SidecarAuthActivity r2, kotlinx.coroutines.b.h r3, boolean r4, int r5, d.h.a.a r6, d.h.a.a r7, d.c.d r8, int r9, Object r10) {
        SidecarAuthActivity r11 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c> r12 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r13 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r6, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r14 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r7, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r0 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r8, d.c.d.class, "com.obric.aiagent.plugin");
        int r15 = 0;
        if ((r9 & 2) == 0) goto L5;
        boolean r16 = false;
    L7:
        if ((r9 & 4) != 0) goto L11;
        r15 = r5;
    L11:
        if ((r9 & 8) == 0) goto L13;
        d.h.a.a<x> r1 = null;
    L15:
        if ((r9 & 16) == 0) goto L17;
        d.h.a.a<x> r17 = null;
    L19:
        return r11.runCredentialFlow(r12, r16, r15, r1, r17, r0);
    L17:
        r17 = r14;
        goto L19
    L13:
        r1 = r13;
        goto L15
    L5:
        r16 = r4;
        goto L7
    }

    private final Object runCredentialFlow(kotlinx.coroutines.b.h<? extends com.obric.aiagent.skill.credentials.api.c> r9, boolean r10, int r11, d.h.a.a<x> r12, d.h.a.a<x> r13, d.c.d<? super x> r14) {
        kotlinx.coroutines.b.h r15 = (kotlinx.coroutines.b.h) ZeusTransformUtils.wrapperContextForParams(r9, kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin");
        d.h.a.a r7 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.h.a.a r3 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r13, d.h.a.a.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r16 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r14, d.c.d.class, "com.obric.aiagent.plugin");
        Object r8 = r15.collect((kotlinx.coroutines.b.i) ZeusTransformUtils.preCheckCast(new h(r3, r10, r11, this, r7), kotlinx.coroutines.b.i.class, "com.obric.aiagent.plugin"), r16);
        if (r8 != d.c.a.b.a()) goto L6;
        return r8;
    L6:
        return x.f38692a;
    }

    static /* synthetic */ void loadAuthUrl$default(SidecarAuthActivity r7, String r8, String r9, boolean r10, int r11, d.h.a.a r12, int r13, Object r14) {
        SidecarAuthActivity r1 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r7, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.h.a.a<x> r15 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r12, d.h.a.a.class, "com.obric.aiagent.plugin");
        if ((r13 & 4) == 0) goto L5;
        boolean r4 = false;
    L7:
        if ((r13 & 8) == 0) goto L9;
        int r5 = 0;
    L11:
        if ((r13 & 16) == 0) goto L13;
        r15 = null;
    L13:
        r1.loadAuthUrl(r8, r9, r4, r5, r15);
        return;
    L9:
        r5 = r11;
        goto L11
    L5:
        r4 = r10;
        goto L7
    }

    private final void loadAuthUrl(String r4, String r5, boolean r6, int r7, d.h.a.a<x> r8) {
        d.h.a.a<x> r9 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "load auth url flowId=" + r5 + " preserveCreateAppProfile=" + r6 + " caRetry=" + r7 + " url=" + a.a(Companion, r4));
        this.activeAuthFlowId = r5;
        this.activeConditionalAccessRetryAttempt = r7;
        this.activeConditionalAccessReturnCallback = r9;
        this.sawConditionalAccessDeny = false;
        this.conditionalAccessRetryTriggered = false;
        prepareStorageForFlow(r5, r6);
        getErrorStatus().setVisibility(8);
        getWebView().setVisibility(0);
        getWebView().loadUrl(r4);
    }

    static /* synthetic */ void prepareStorageForFlow$default(SidecarAuthActivity r1, String r2, boolean r3, int r4, Object r5) {
        SidecarAuthActivity r6 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r1, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = false;
    L5:
        r6.prepareStorageForFlow(r2, r3);
    }

    private final void prepareStorageForFlow(String r2, boolean r3) {
        getWebView().clearHistory();
        getWebView().clearFormData();
        if (d.h.b.o.a(r2, FLOW_CONFIG_CREATE_APP) == false) goto L6;
        applyCreateAppProfile(r3);
        return;
    }

    private final void applyCreateAppProfile(boolean r6) {
        if (androidx.webkit.k.a("MULTI_PROFILE") == true) goto L23;
        ILogDepend.Companion.w(TAG, "create-app webview profile unsupported, fallback to default storage");
    L18:
        if (r6 == false) goto L21;
        ILogDepend.Companion.i(TAG, "preserve default webview storage for configCreateApp retry");
        return;
    L21:
        ILogDepend.Companion.i(TAG, "clear default webview storage for configCreateApp flow");
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
        WebStorage.getInstance().deleteAllData();
        return;
    L23:
        n.a r0 = n.f38560a;     // Catch: Throwable -> L12
        SidecarAuthActivity r5 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(this, SidecarAuthActivity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        androidx.webkit.a r1 = androidx.webkit.b.a().a(CREATE_APP_PROFILE_NAME);     // Catch: Throwable -> L12
        d.h.b.o.c(r1, "getOrCreateProfile(...)");     // Catch: Throwable -> L12
        if (r5.createAppProfileApplied == true) goto L7;
        androidx.webkit.j.a(r5.getWebView(), r1.a());     // Catch: Throwable -> L12
        r5.createAppProfileApplied = true;     // Catch: Throwable -> L12
    L7:
        if (r6 == false) goto L10;
        ILogDepend.Companion.i(TAG, "create-app profile applied with preserved data name=" + r1.a());     // Catch: Throwable -> L12
        return;
    L10:
        r1.b().removeAllCookies(null);     // Catch: Throwable -> L12
        r1.b().flush();     // Catch: Throwable -> L12
        r1.c().deleteAllData();     // Catch: Throwable -> L12
        ILogDepend.Companion.i(TAG, "create-app profile applied and cleared name=" + r1.a());     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        n.a r2 = n.f38560a;
        Object r7 = n.f(d.o.a(th));
        Throwable r3 = n.c(r7);
        if (r3 == null) goto L16;
        ILogDepend.Companion.e(TAG, "apply create-app webview profile failed, fallback to default storage", r3);
    L16:
        n.g(r7);
        goto L18
    }

    private final void applyEnterpriseAuthenticationAppLinkPolicy() {
        if (androidx.webkit.k.a("ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY") == true) goto L17;
        ILogDepend.Companion.i(TAG, "enterprise auth app link policy unsupported");
        return;
    L17:
        n.a r1 = n.f38560a;     // Catch: Throwable -> L8
        SidecarAuthActivity r5 = (SidecarAuthActivity) ZeusTransformUtils.preCheckCast(this, SidecarAuthActivity.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L8
        androidx.webkit.i.a(r5.getWebView().getSettings(), true);     // Catch: Throwable -> L8
        Object r6 = n.f(Boolean.valueOf(androidx.webkit.i.a(r5.getWebView().getSettings())));     // Catch: Throwable -> L8
    L11:
        if (n.a(r6) == false) goto L13;
        ILogDepend.Companion.i(TAG, "enterprise auth app link policy configured enabled=" + ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue());
    L13:
        Throwable r7 = n.c(r6);
        if (r7 == null) goto L19;
        ILogDepend.Companion.e(TAG, "enterprise auth app link policy failed", r7);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        n.a r2 = n.f38560a;
        r6 = n.f(d.o.a(th));
        goto L11
    }

    private final void handleConditionalAccessNavigation(String r9) {
        a r0 = Companion;
        if (a.b(r0, r9) == false) goto L13;
        if (this.sawConditionalAccessDeny == true) goto L10;
        ILogDepend.Companion r1 = ILogDepend.Companion;
        StringBuilder r6 = new StringBuilder().append("conditional access deny observed flowId=");
        String r7 = this.activeAuthFlowId;
        if (r7 != null) goto L9;
        r7 = "";
    L9:
        r1.w(TAG, r6.append(r7).append(" caRetry=").append(this.activeConditionalAccessRetryAttempt).append(" url=").append(a.a(r0, r9)).toString());
    L10:
        this.sawConditionalAccessDeny = true;
        return;
    L13:
        if (this.sawConditionalAccessDeny == false) goto L20;
        if (a.c(r0, r9) == false) goto L20;
        if (d.h.b.o.a(this.activeAuthFlowId, FLOW_CONFIG_CREATE_APP) == false) goto L20;
        logConditionalAccessReturnDecision(r9);
    L20:
        if (d.h.b.o.a(this.activeAuthFlowId, FLOW_CONFIG_CREATE_APP) == true) goto L22;
        return;
    L22:
        if (this.activeConditionalAccessRetryAttempt <= 0) goto L24;
        return;
    L24:
        if (this.conditionalAccessRetryTriggered == false) goto L26;
        return;
    L26:
        if (this.sawConditionalAccessDeny == true) goto L28;
        return;
    L28:
        if (a.c(r0, r9) == false) goto L39;
        this.conditionalAccessRetryTriggered = true;
        ILogDepend.Companion.i(TAG, "conditional_access_return_retry flowId=" + this.activeAuthFlowId + " caRetry=" + this.activeConditionalAccessRetryAttempt + " url=" + a.a(r0, r9));
        d.h.a.a<x> r8 = this.activeConditionalAccessReturnCallback;
        if (r8 == null) goto L38;
        r8.invoke();
        return;
    L38:
        return;
    }

    private final void logConditionalAccessReturnDecision(String r5) {
        if (this.activeConditionalAccessRetryAttempt <= 0) goto L6;
        String r0 = "already_retrying";
    L12:
        ILogDepend.Companion r1 = ILogDepend.Companion;
        StringBuilder r2 = new StringBuilder().append("conditional access returned to cli page flowId=");
        String r3 = this.activeAuthFlowId;
        if (r3 != null) goto L15;
        r3 = "";
    L15:
        r1.i(TAG, r2.append(r3).append(" caRetry=").append(this.activeConditionalAccessRetryAttempt).append(" reason=").append(r0).append(" url=").append(a.a(Companion, r5)).toString());
        return;
    L6:
        if (this.conditionalAccessRetryTriggered == false) goto L9;
        r0 = "retry_already_triggered";
        goto L12
    L9:
        if (this.activeConditionalAccessReturnCallback != null) goto L11;
        r0 = "callback_missing";
        goto L12
    L11:
        r0 = "will_retry";
        goto L12
    }

    private final boolean handleNonHttpUrl(Uri r6) {
        String r1 = r6.getScheme();
        if (r1 != null) goto L6;
        r1 = "";
    L6:
        if (d.h.b.o.a(r1, "http") == false) goto L8;
        return false;
    L8:
        if (d.h.b.o.a(r1, "https") == true) goto L26;
        n.a r2 = n.f38560a;     // Catch: Throwable -> L12
        ZeusTransformUtils.startActivity((SidecarAuthActivity) ZeusTransformUtils.preCheckCast(this, SidecarAuthActivity.class, "com.obric.aiagent.plugin"), new Intent("android.intent.action.VIEW", r6), "com.obric.aiagent.plugin");     // Catch: Throwable -> L12
        Object r5 = n.f(x.f38692a);     // Catch: Throwable -> L12
    L15:
        if (n.a(r5) == false) goto L17;
        x r7 = (x) ZeusTransformUtils.preCheckCast(r5, x.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "delegate non-http url scheme=" + r1);
    L17:
        Throwable r8 = n.c(r5);
        if (r8 == null) goto L21;
        ILogDepend.Companion.e(TAG, "delegate non-http url failed scheme=" + r1, r8);
    L21:
        return n.a(r5);
    L12:
        th = move-exception;
        n.a r9 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L15
    L26:
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onActivityResult(int r3, int r4, Intent r5) {
        if (r3 != 7001) goto L15;
        ValueCallback<Uri[]> r6 = this.imageFilePathCallback;
        Uri[] r0 = null;
        this.imageFilePathCallback = null;
        if (r4 != (-1)) goto L7;
        r0 = a.b(Companion, r5);
    L7:
        ILogDepend.Companion r2 = ILogDepend.Companion;
        StringBuilder r7 = new StringBuilder().append("image picker result resultCode=").append(r4).append(" uriCount=");
        if (r0 == null) goto L10;
        int r8 = r0.length;
    L11:
        r2.i(TAG, r7.append(r8).toString());
        if (r6 == null) goto L17;
        r6.onReceiveValue(r0);
        return;
    L17:
        return;
    L10:
        r8 = 0;
        goto L11
    L15:
        super.onActivityResult(r3, r4, r5);
    }

    private final void showLoading() {
        getErrorStatus().setVisibility(8);
        getWebView().setVisibility(0);
        getProgressBar().setVisibility(0);
    }

    private final void showError() {
        getProgressBar().setVisibility(8);
        getWebView().setVisibility(8);
        getErrorStatus().setVisibility(0);
    }

    @Override // androidx.activity.ComponentActivity
    public void onBackPressed() {
        if (getWebView().canGoBack() == false) goto L5;
        getWebView().goBack();
        return;
    L5:
        handleCloseRequest();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        String r0 = this.intentAuthSessionId;
        if (r0 != null) goto L5;
    L13:
        ca r1 = this.intentAuthJob;
        ViewGroup r3 = null;
        if (r1 == null) goto L16;
        ca.a.a(r1, null, 1, null);
    L16:
        ca r2 = this.intentAuthCompletionJob;
        if (r2 == null) goto L19;
        ca.a.a(r2, null, 1, null);
    L19:
        ValueCallback<Uri[]> r4 = this.imageFilePathCallback;
        if (r4 == null) goto L22;
        r4.onReceiveValue(null);
    L22:
        this.imageFilePathCallback = null;
        a.c(Companion, this, this.intentAuthSessionId);
        an.a(this.intentAuthScope, null, 1, null);
        o r5 = this.bridgeController;
        if (r5 == null) goto L30;
        String r6 = this.sessionId;
        if (r6 == null) goto L30;
        if (this.closeAsCompleted == false) goto L29;
        ILogDepend.Companion.i(TAG, "unbind sidecar webview without notify session=" + r6);
        com.obric.aiagent.skill.credentials.api.m.f18996a.c(r6, r5);
        goto L30
    L29:
        ILogDepend.Companion.i(TAG, "unbind sidecar webview session=" + r6);
        com.obric.aiagent.skill.credentials.api.m.f18996a.b(r6, r5);
    L30:
        ViewParent r7 = getWebView().getParent();
        if (ZeusTransformUtils.instanceOf(r7, ViewGroup.class) == false) goto L33;
        r3 = (ViewGroup) ZeusTransformUtils.preCheckCast(r7, ViewGroup.class, "com.obric.aiagent.plugin");
    L33:
        if (r3 == null) goto L35;
        r3.removeView((View) ZeusTransformUtils.preCheckCast(getWebView(), View.class, "com.obric.aiagent.plugin"));
    L35:
        WebView r8 = getWebView();
        r8.stopLoading();
        r8.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
        r8.clearHistory();
        r8.destroy();
        super.onDestroy();
        return;
    L5:
        if (this.intentAuthFinished == true) goto L13;
        c r9 = this.intentAuthCloseState;
        if (shouldKeepAuthFlowPendingOnDestroy(r9) == true) goto L9;
        com.obric.aiagent.skill.credentials.api.l.c r10 = toAuthResult(r9);
        ILogDepend.Companion.i(TAG, "intent auth finished by activity destroy session=" + r0 + " closeState=" + r9.a() + " status=" + r10.a().a());
        com.obric.aiagent.skill.credentials.api.l.f18971a.a(r0, r10);
        goto L13
    L9:
        if (r9 != c.f19099a) goto L11;
        a.d(Companion, r0);
    L11:
        ILogDepend.Companion.i(TAG, "intent auth detached by activity destroy session=" + r0 + " closeState=" + r9.a());
        goto L13
    }

    private final void handleCloseRequest() {
        if (this.intentAuthSessionId == null) goto L6;
        ILogDepend.Companion.i(TAG, "close requested for intent auth session=" + this.intentAuthSessionId);
        showIntentAuthCloseConfirmDialog();
        return;
    L6:
        com.obric.oui.dialog.v2.alert.a r0 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_close_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_close_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_close_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_close_message")), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_close_confirm_exit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_close_confirm_exit"));
        d.h.b.o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r7 = r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), com.obric.oui.dialog.v2.alert.style.a.b.f35142c);
        String r13 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_close_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_close_cancel"));
        d.h.b.o.c(r13, "getString(...)");
        com.obric.oui.dialog.v2.alert.a.b(r7, (CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new AnonymousClass2(), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null).h();
    }

    private final void showIntentAuthCloseConfirmDialog() {
        com.obric.oui.dialog.v2.alert.a r0 = com.obric.oui.dialog.v2.alert.a.a(com.obric.oui.dialog.v2.alert.a.a(new com.obric.oui.dialog.v2.alert.a((Context) ZeusTransformUtils.preCheckCast(this, Context.class, "com.obric.aiagent.plugin")).b(false), (CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_close_title, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_close_title")), CharSequence.class, "com.obric.aiagent.plugin"), false, 2, null).a((CharSequence) ZeusTransformUtils.preCheckCast(getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_close_message, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_close_message")), CharSequence.class, "com.obric.aiagent.plugin")), false, 1, null);
        String r1 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_close_confirm_exit, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_close_confirm_exit"));
        d.h.b.o.c(r1, "getString(...)");
        com.obric.oui.dialog.v2.alert.a r7 = r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new DialogInterfaceOnClickListenerC11151(this), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), com.obric.oui.dialog.v2.alert.style.a.b.f35142c);
        String r2 = getString(ZeusTransformUtils.mapRes(R.string.obric_skill_credentials_sidecar_auth_close_cancel, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_skill_credentials_sidecar_auth_close_cancel"));
        d.h.b.o.c(r2, "getString(...)");
        com.obric.oui.dialog.v2.alert.a.b(r7, (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"), (DialogInterface.OnClickListener) ZeusTransformUtils.preCheckCast(new DialogInterfaceOnClickListenerC11162(this), DialogInterface.OnClickListener.class, "com.obric.aiagent.plugin"), null, 4, null).h();
    }

    private final void confirmIntentAuthCompletionOrDetach() {
        String r0 = this.intentAuthSessionId;
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L10:
        if (r2 == false) goto L13;
        ILogDepend.Companion.w(TAG, "intent auth confirm ignored, missing session");
        finish();
        return;
    L13:
        ILogDepend.Companion.i(TAG, "intent auth confirm requested session=" + r0 + " maxAttempts=30");
        a.d(Companion, r0);
        this.intentAuthCloseState = c.f19102d;
        ca r3 = this.intentAuthJob;
        if (r3 == null) goto L16;
        ca.a.a(r3, null, 1, null);
    L16:
        ca r4 = this.intentAuthCompletionJob;
        if (r4 == null) goto L19;
        ca.a.a(r4, null, 1, null);
    L19:
        ILogDepend.Companion.i(TAG, "intent auth close confirmed as detached session=" + r0);
        finish();
        return;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L10
    }

    private final void bindBridgeIfNeeded() {
        final String r0 = getIntent().getStringExtra(EXTRA_SESSION_ID);
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        if (d.h.b.o.a(r0, this.sessionId) == true) goto L13;
    L15:
        o r3 = this.bridgeController;
        if (r3 == null) goto L20;
        String r4 = this.sessionId;
        if (r4 == null) goto L20;
        ILogDepend.Companion.i(TAG, "rebind sidecar webview oldSession=" + r4 + " newSession=" + r0);
        com.obric.aiagent.skill.credentials.api.m.f18996a.b(r4, r3);
    L20:
        this.sessionId = r0;
        o r5 = new o(new $$Lambda$SidecarAuthActivity$ArgA3la_OepPRVUSdTrOYXczMbY(this, r0), new $$Lambda$SidecarAuthActivity$iQuwyxEWCypnXGvGjVBEXRdRFQc(this, r0));
        this.bridgeController = r5;
        com.obric.aiagent.skill.credentials.api.m.f18996a.a(r0, r5);
        ILogDepend.Companion.i(TAG, "bind sidecar webview session=" + r0);
        return;
    L13:
        if (this.bridgeController == null) goto L15;
        return;
    L5:
        if (d.o.o.d(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    private static final x bindBridgeIfNeeded$lambda$29(SidecarAuthActivity r2, final String r3, final String r4, final String r5) {
        final SidecarAuthActivity r6 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "url");
        d.h.b.o.e(r5, "flowId");
        r6.runOnUiThread(new $$Lambda$SidecarAuthActivity$HkfAbbZBENhMmOFyiOk9rMtDZFA(r3, r5, r4, r6));
        return x.f38692a;
    }

    private static final void bindBridgeIfNeeded$lambda$29$lambda$28(String r8, String r9, String r10, SidecarAuthActivity r11) {
        SidecarAuthActivity r0 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r11, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        ILogDepend.Companion.i(TAG, "bridge load callback session=" + r8 + " flowId=" + r9 + " url=" + a.a(Companion, r10));
        loadAuthUrl$default(r0, r10, r9, false, 0, null, 28, null);
    }

    private static final x bindBridgeIfNeeded$lambda$31(SidecarAuthActivity r2, final String r3) {
        final SidecarAuthActivity r4 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r2, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        r4.runOnUiThread(new $$Lambda$SidecarAuthActivity$hvioymmvF1lglLQLsFzaMMRbFE(r4, r3));
        return x.f38692a;
    }

    private static final void bindBridgeIfNeeded$lambda$31$lambda$30(SidecarAuthActivity r3, String r4) {
        SidecarAuthActivity r5 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        r5.closeAsCompleted = true;
        ILogDepend.Companion.i(TAG, "bridge close callback session=" + r4);
        r5.finish();
    }

    private final void configureGlassSystemBars() {
        if ((ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r0 = true;
    L7:
        if (Build.VERSION.SDK_INT < 16) goto L14;
        int r3 = 1280;
        if (r0 == false) goto L11;
    L13:
        getWindow().getDecorView().setSystemUiVisibility(r3);
        goto L14
    L11:
        if (Build.VERSION.SDK_INT < 23) goto L13;
        r3 = 9472;
    L14:
        getWindow().getDecorView().setBackgroundColor(getColorCompat(ZeusTransformUtils.mapRes(R.color.oui_basic_bg_base_1, "color", "oui_basic_bg_base_1")));
        if (Build.VERSION.SDK_INT < 21) goto L18;
        getWindow().setStatusBarColor(0);
    L18:
        if (Build.VERSION.SDK_INT < 29) goto L20;
        getWindow().setStatusBarContrastEnforced(false);
        getWindow().setNavigationBarContrastEnforced(false);
    L20:
        ai.a(getWindow(), false);
        ai.a(getWindow(), getWindow().getDecorView()).b(!r0);
        if (Build.VERSION.SDK_INT < 20) goto L24;
        getWindow().getDecorView().setOnApplyWindowInsetsListener($$Lambda$SidecarAuthActivity$ZiHmAEPjngYWGWqlDNtKnoLzns.INSTANCE);
        return;
    L24:
        return;
    L5:
        r0 = false;
        goto L7
    }

    private static final WindowInsets configureGlassSystemBars$lambda$32(View r3, WindowInsets r4) {
        d.h.b.o.e(r3, "view");
        d.h.b.o.e(r4, "insets");
        if (Build.VERSION.SDK_INT < 30) goto L5;
        int r0 = r4.getInsets(WindowInsets.Type.systemBars()).left;
    L7:
        if (Build.VERSION.SDK_INT < 30) goto L9;
        int r1 = r4.getInsets(WindowInsets.Type.systemBars()).right;
    L10:
        r3.setPadding(r0, 0, r1, 0);
        return r4;
    L9:
        r1 = r4.getSystemWindowInsetRight();
        goto L10
    L5:
        r0 = r4.getSystemWindowInsetLeft();
        goto L7
    }

    private final int getColorCompat(int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(r4, getTheme());
    L6:
        return ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getColor(r4);
    }

    private final void updatePaddingForTitleBarAndNavigationBar(final View r5, final OFloatingTitleBar r6) {
        final int r0 = r5.getPaddingBottom();
        int r1 = getTitleContainerHeight(r6);
        r5.setPadding(r5.getPaddingLeft(), r1, r5.getPaddingRight(), r0);
        ViewCompat.a(r5, new $$Lambda$SidecarAuthActivity$SLhxAg3ng59T3fZAXAAZyuUEsA0(r5, this, r6, r0));
        ViewCompat.u(r5);
    }

    private static final al updatePaddingForTitleBarAndNavigationBar$lambda$34(View r6, SidecarAuthActivity r7, final OFloatingTitleBar r8, final int r9, final View r10, al r11) {
        final SidecarAuthActivity r2 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r7, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "view");
        d.h.b.o.e(r11, "insets");
        androidx.core.graphics.g r12 = r11.a(al.m.b());
        d.h.b.o.c(r12, "getInsets(...)");
        androidx.core.graphics.g r1 = r11.a(al.m.e());
        d.h.b.o.c(r1, "getInsets(...)");
        final int r5 = Math.max(r12.f1213e, r1.f1213e);
        r6.post(new $$Lambda$SidecarAuthActivity$fmPM3MknqtfZZpM7nO1itoj3fI(r10, r2, r8, r9, r5));
        return r11;
    }

    private static final void updatePaddingForTitleBarAndNavigationBar$lambda$34$lambda$33(View r2, SidecarAuthActivity r3, OFloatingTitleBar r4, int r5, int r6) {
        SidecarAuthActivity r7 = (SidecarAuthActivity) ZeusTransformUtils.wrapperContextForParams(r3, SidecarAuthActivity.class, "com.obric.aiagent.plugin");
        d.h.b.o.a(r2);
        int r8 = r7.getTitleContainerHeight(r4);
        int r9 = r5 + r6;
        r2.setPadding(r2.getPaddingLeft(), r8, r2.getPaddingRight(), r9);
    }

    private final int getTitleContainerHeight(OFloatingTitleBar r5) {
        View r4 = r5.findViewById(ZeusTransformUtils.mapRes(R.id.title_bar_container, DbHelper.COL_ID, "title_bar_container"));
        ViewGroup.MarginLayoutParams r0 = null;
        if (r4 == null) goto L5;
        ViewGroup.LayoutParams r1 = r4.getLayoutParams();
    L7:
        if (ZeusTransformUtils.instanceOf(r1, ViewGroup.MarginLayoutParams.class) == false) goto L9;
        r0 = (ViewGroup.MarginLayoutParams) ZeusTransformUtils.preCheckCast(r1, ViewGroup.MarginLayoutParams.class, "com.obric.aiagent.plugin");
    L9:
        if (r0 == null) goto L11;
        int r2 = r0.topMargin;
    L12:
        if (r4 == null) goto L14;
        int r6 = r4.getMinimumHeight();
    L16:
        return r6 + r2;
    L14:
        r6 = ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getDimensionPixelSize(ZeusTransformUtils.mapRes(R.dimen.oui_title_bar_mask_height, "dimen", "oui_title_bar_mask_height"));
        goto L16
    L11:
        r2 = 0;
        goto L12
    L5:
        r1 = null;
        goto L7
    }

    static {
        Companion = new a(null);
        CONDITIONAL_ACCESS_DENY_HOSTS = d.a.ax.a(new String[]{"security.larkoffice.com", "security-*.larkoffice.com", "security.feishu.cn"});
        LARK_CLI_PAGE_HOSTS = d.a.ax.a(new String[]{"open.feishu.cn", "open.larkoffice.com"});
        IMAGE_FILE_EXTENSIONS = d.a.ax.a(new String[]{".avif", ".bmp", ".gif", ".heic", ".heif", ".jpeg", ".jpg", ".png", ".webp"});
        intentAuthConfirmScope = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin")));
    }

    private final boolean shouldKeepAuthFlowPendingOnDestroy(c r1) {
        if (r1 != c.f19099a) goto L5;
    L8:
        return true;
    L5:
        if (r1 == c.f19102d) goto L8;
        return false;
    }

    private final com.obric.aiagent.skill.credentials.api.l.c toAuthResult(c r15) {
        int r14 = d.f19105b[r15.ordinal()];
        if (r14 == 1) goto L16;
        if (r14 == 2) goto L19;
        if (r14 == 3) goto L18;
        if (r14 != 4) goto L12;
        return new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18988c, "Authorization activity detached without completion.", "auth_activity_detached", null, 8, null);
    L12:
        throw new d.k();
    L18:
        return new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18988c, "Authorization activity was closed before completion.", "auth_activity_destroyed", null, 8, null);
    L19:
        return new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18987b, "Authorization canceled by user.", null, null, 12, null);
    L16:
        return new com.obric.aiagent.skill.credentials.api.l.c(com.obric.aiagent.skill.credentials.api.l.d.f18986a, "Authorization flow completed.", null, null, 12, null);
    }
}
