package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.autoaction.app.launcherpage.donation.model.Question;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.app.AOWindowingTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.screen.capture.IAutoActionCollectingApi;
import com.obric.autogui.common.api.platform.screen.capture.IScreenOperationListener;
import com.obric.autogui.common.api.platform.screen.capture.OScreenEvent;
import com.obric.autogui.common.api.presentation.IDonationTaskStateApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: DataRecordManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "DataRecordManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23724a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static WeakReference<FrameLayout> f23725b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Context f23726c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.f f23727d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f23728e;
    private static final List<com.obric.autoaction.app.launcherpage.donation.model.c> f = null;
    private static IScreenOperationListener g;
    private static boolean h;
    private static Question i;
    private static String j;

    /* JADX INFO: compiled from: DataRecordManager.kt */
    public static final class a implements IScreenOperationListener {
        a() {
        }

        @Override // com.obric.autogui.common.api.platform.screen.capture.IScreenOperationListener
        public void onError(int r3, String r4) {
            o.e(r4, "errorMessage");
            Loog.INSTANCE.d(b.TAG, "onError: " + r3 + ", " + r4);
        }

        @Override // com.obric.autogui.common.api.platform.screen.capture.IScreenOperationListener
        public void onEvent(OScreenEvent r10, Bitmap r11) {
            o.e(r10, "event");
            Loog.INSTANCE.d(b.TAG, "onEvent: " + r10);
            int r0 = b.f23724a.a().size();
            String r3 = null;
            if (ZeusTransformUtils.instanceOf(r10, OScreenEvent.OScreenTouchEvent.class) == false) goto L34;
            if (((OScreenEvent.OScreenTouchEvent) ZeusTransformUtils.preCheckCast(r10, OScreenEvent.OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getAction() != OScreenEvent.OScreenTouchEvent.OTouchAction.SCROLLED) goto L34;
            List<com.obric.autoaction.app.launcherpage.donation.model.c> r12 = b.f23724a.a();
            ListIterator<com.obric.autoaction.app.launcherpage.donation.model.c> r13 = r12.listIterator(r12.size());
        L8:
            if (r13.hasPrevious() == false) goto L27;
            com.obric.autoaction.app.launcherpage.donation.model.c r1 = r13.previous();
            com.obric.autoaction.app.launcherpage.donation.model.c r2 = (com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin");
            if (ZeusTransformUtils.instanceOf(r2.a(), OScreenEvent.OScreenTouchEvent.class) == true) goto L12;
        L24:
            boolean r4 = false;
        L25:
            if (r4 == false) goto L8;
        L28:
            com.obric.autoaction.app.launcherpage.donation.model.c r14 = (com.obric.autoaction.app.launcherpage.donation.model.c) ZeusTransformUtils.preCheckCast(r1, com.obric.autoaction.app.launcherpage.donation.model.c.class, "com.obric.aiagent.plugin");
            if (r14 != null) goto L32;
            a r9 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");
            Loog.INSTANCE.e(b.TAG, "onEvent: scroll end without start");
            return;
        L32:
            r0 = b.f23724a.a().indexOf(r14);
            b.f23724a.a().remove(r14);
            r11 = r14.b();
            goto L34
        L12:
            if (((OScreenEvent.OScreenTouchEvent) ZeusTransformUtils.preCheckCast(r2.a(), OScreenEvent.OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getAction() != OScreenEvent.OScreenTouchEvent.OTouchAction.SCROLL_START) goto L24;
            if (((OScreenEvent.OScreenTouchEvent) ZeusTransformUtils.preCheckCast(r2.a(), OScreenEvent.OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getTouchInfo().getX() != ((OScreenEvent.OScreenTouchEvent) ZeusTransformUtils.preCheckCast(r10, OScreenEvent.OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getTouchInfo().getX()) goto L16;
            boolean r7 = true;
        L17:
            if (r7 == false) goto L24;
            if (((OScreenEvent.OScreenTouchEvent) ZeusTransformUtils.preCheckCast(r2.a(), OScreenEvent.OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getTouchInfo().getY() != ((OScreenEvent.OScreenTouchEvent) ZeusTransformUtils.preCheckCast(r10, OScreenEvent.OScreenTouchEvent.class, "com.obric.aiagent.plugin")).getTouchInfo().getY()) goto L21;
            boolean r5 = true;
        L22:
            if (r5 == false) goto L24;
            r4 = true;
            goto L25
        L21:
            r5 = false;
            goto L22
        L16:
            r7 = false;
            goto L17
        L27:
            r1 = null;
        L34:
            if (ZeusTransformUtils.instanceOf(r10, OScreenEvent.OAppStateEvent.class) == true) goto L36;
        L38:
            List<com.obric.autoaction.app.launcherpage.donation.model.c> r15 = b.f23724a.a();
            com.obric.autoaction.app.launcherpage.donation.model.c r6 = new com.obric.autoaction.app.launcherpage.donation.model.c(r10, r11);
            r6.b(r3);
            x r16 = x.f38692a;
            r15.add(r0, r6);
            IDonationTaskStateApi r17 = (IDonationTaskStateApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDonationTaskStateApi.class), IDonationTaskStateApi.class, "com.obric.aiagent.plugin");
            if (r17 == null) goto L47;
            r17.updateStep(b.f23724a.a().size());
            return;
        L47:
            return;
        L36:
            if (((OScreenEvent.OAppStateEvent) ZeusTransformUtils.preCheckCast(r10, OScreenEvent.OAppStateEvent.class, "com.obric.aiagent.plugin")).getState() != OScreenEvent.OAppStateEvent.AppState.OPEN) goto L38;
            r3 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(ZeusTransformUtils.mapRes(R.string.obric_donation_thought_open_app, WsChannelMultiProcessSharedProvider.STRING_TYPE, "obric_donation_thought_open_app"), new Object[]{r10.getAppName()});
            goto L38
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DataRecordManager.kt */
    @d.c.b.a.f(b = "DataRecordManager.kt", c = {50}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DataRecordManager$startRecord$1")
    static final class C0532b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23729a;

        C0532b(d.c.d<? super C0532b> r3) {
            super(2, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d.c.d<? super x> r4) {
            return ((C0532b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), C0532b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r1, d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new C0532b((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23729a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            b.a(b.f23724a);
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23729a = 1;
            if (ax.a(500, r7) != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ WindowManager lambda$js_s8KVYhhBlOtNQXL_FKWizOpw() {
        return i();
    }

    private b() {
    }

    public static final /* synthetic */ void a(b r0) {
        r0.e();
    }

    static {
        f23724a = new b();
        f23726c = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        f23727d = d.g.a($$Lambda$b$js_s8KVYhhBlOtNQXL_FKWizOpw.INSTANCE);
        f = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
    }

    private final WindowManager d() {
        return (WindowManager) ZeusTransformUtils.preCheckCast(f23727d.b(), WindowManager.class, "com.obric.aiagent.plugin");
    }

    private static final WindowManager i() {
        Context r0 = f23726c;
        if (r0 == null) goto L5;
        Object r1 = r0.getSystemService("window");
    L6:
        o.a(r1, "null cannot be cast to non-null type android.view.WindowManager");
        return (WindowManager) ZeusTransformUtils.preCheckCast(r1, WindowManager.class, "com.obric.aiagent.plugin");
    L5:
        r1 = null;
        goto L6
    }

    public final List<com.obric.autoaction.app.launcherpage.donation.model.c> a() {
        return f;
    }

    public final boolean b() {
        return h;
    }

    public final void a(Question r7, String r8) {
        o.e(r7, "question");
        o.e(r8, "target");
        i = r7;
        j = r8;
        h = true;
        f.clear();
        g();
        IDonationTaskStateApi r6 = (IDonationTaskStateApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDonationTaskStateApi.class), IDonationTaskStateApi.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        r6.create();
    L5:
        kotlinx.coroutines.i.a(an.a(), (d.c.g) ZeusTransformUtils.preCheckCast(bd.b(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new C0532b(null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void c() {
        IDonationTaskStateApi r0 = (IDonationTaskStateApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IDonationTaskStateApi.class), IDonationTaskStateApi.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        r0.end();
    L5:
        h();
        f();
        h = false;
        Context r10 = f23726c;
        if (r10 == null) goto L17;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L18;
        Question r2 = i;
        if (r2 != null) goto L12;
        return;
    L12:
        String r3 = j;
        if (r3 != null) goto L15;
        return;
    L15:
        RecordDataListActivity.a.a(RecordDataListActivity.Companion, r1, r2, r3, f, -1, null, null, 96, null);
        return;
    L18:
        return;
    }

    private final void e() {
        IAutoActionCollectingApi r3 = AOPlatformTools.INSTANCE.collecting();
        if (r3.isSupported() == true) goto L6;
        Loog.INSTANCE.e(TAG, "registerScreenOperationListener: Collecting API isn't supported.");
        return;
    L6:
        a r0 = new a();
        r3.registerScreenOperationListener((IScreenOperationListener) ZeusTransformUtils.preCheckCast(r0, IScreenOperationListener.class, "com.obric.aiagent.plugin"));
        g = (IScreenOperationListener) ZeusTransformUtils.preCheckCast(r0, IScreenOperationListener.class, "com.obric.aiagent.plugin");
    }

    private final void f() {
        IAutoActionCollectingApi r2 = AOPlatformTools.INSTANCE.collecting();
        if (r2.isSupported() == true) goto L6;
        Loog.INSTANCE.e(TAG, "unregisterScreenOperationListener: Collecting API isn't supported.");
        return;
    L6:
        IScreenOperationListener r0 = g;
        if (r0 == null) goto L10;
        r2.unregisterScreenOperationListener(r0);
        g = null;
        return;
    }

    private final void g() {
        Context r1 = f23726c;
        if (r1 != null) goto L5;
        return;
    L5:
        WindowManager r13 = d();
        if (r13 != null) goto L8;
        return;
    L8:
        MaskFrameLayout r6 = new MaskFrameLayout(r1, null, 0, 6, null);
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams(-1, -1, 2038, 792, -3);
        r0.gravity = 8388659;
        r0.x = 0;
        r0.y = 0;
        r0.height = r13.getCurrentWindowMetrics().getBounds().height();
        r0.width = r13.getCurrentWindowMetrics().getBounds().width();
        AOWindowingTools.INSTANCE.setTrustedOverlay(r0);
        r13.addView((View) ZeusTransformUtils.preCheckCast(r6, View.class, "com.obric.aiagent.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r0, ViewGroup.LayoutParams.class, "com.obric.aiagent.plugin"));
        f23725b = new WeakReference(r6);
        f23728e = true;
    }

    private final void h() {
        WeakReference<FrameLayout> r3 = f23725b;
        if (r3 == null) goto L11;
        FrameLayout r4 = (FrameLayout) ZeusTransformUtils.preCheckCast(r3.get(), FrameLayout.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L12;
        WindowManager r0 = f23724a.d();
        if (r0 == null) goto L9;
        r0.removeView((View) ZeusTransformUtils.preCheckCast(r4, View.class, "com.obric.aiagent.plugin"));
    L9:
        f23728e = false;
        f23725b = null;
        return;
    L12:
        return;
    }
}
