package bt1;

import am2.x;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.bytedance.android.live.LiveGsonHelper;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog;
import com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponLoginDialog;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;
import com.bytedance.android.livesdkapi.AppLifeCycleMonitor;
import com.bytedance.android.livesdkapi.ILiveOntologyInfoManager;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.IMiddlewareLiveService;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.common.utility.Logger;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.live.datacontext.j;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.larus.nova.R;
import com.lynx.tasm.LynxError;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends com.bytedance.android.livesdk.coupon.a<com.bytedance.android.livesdk.coupon.expandcoupon.model.b> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f20502q = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C0359b f20503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ExpandCouponEnterRoomDialog f20504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ExpandCouponLoginDialog f20505i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public bt1.a f20506j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public bt1.c f20507k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.android.livesdk.coupon.expandcoupon.model.e f20508l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.livesdk.coupon.expandcoupon.model.d f20509m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ct1.b f20510n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f20511o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f20512p;

    public static final class a {
    }

    /* JADX INFO: renamed from: bt1.b$b, reason: collision with other inner class name */
    public final class C0359b implements com.bytedance.android.livesdk.coupon.jsb.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20513a;

        @Override // com.bytedance.android.livesdk.coupon.jsb.f
        public final com.bytedance.android.livesdk.coupon.expandcoupon.model.d a() {
            return this.f20513a.f20509m;
        }

        @Override // com.bytedance.android.livesdk.coupon.jsb.f
        public final ct1.b b() {
            return this.f20513a.f20510n;
        }

        @Override // com.bytedance.android.livesdk.coupon.jsb.f
        public final void c() {
            b.m(this.f20513a, true);
        }

        public C0359b(b r100) {
            this.f20513a = r100;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f20514a = null;

        static {
            f20514a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IBaseUser r101 = (IBaseUser) r100;
            ALogger.d("ExpandCouponController", "loginBeforeObtainCoupon login success");
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f20515a = null;

        static {
            f20515a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ALogger.e("ExpandCouponController", "loginBeforeObtainCoupon login error, " + Log.getStackTraceString((Throwable) r100));
        }
    }

    public static final class e implements ExpandCouponEnterRoomDialog.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20516a;

        @Override // com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog.b
        public final void a() {
            this.f20516a.getClass();
            b.r("close");
            ExpandCouponEnterRoomDialog r100 = this.f20516a.f20504h;
            if (r100 == null) goto L6;
            d(r100);
            return;
        }

        @Override // com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog.b
        public final void b() {
            this.f20516a.getClass();
            if (b.o() == true) goto L5;
            this.f20516a.s();
            return;
        L5:
            b r100 = this.f20516a;
            com.bytedance.android.livesdk.coupon.expandcoupon.model.d r101 = r100.f20509m;
            if (r101 == null) goto L8;
            r101.f121902d = true;
        L8:
            r100.e();
            ExpandCouponEnterRoomDialog r102 = this.f20516a.f20504h;
            if (r102 == null) goto L11;
            d(r102);
        L11:
            this.f20516a.getClass();
            b.r("receive_directly");
        }

        @Override // com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponEnterRoomDialog.b
        public final void c() {
            b.m(this.f20516a, false);
            IBrowserService r100 = (IBrowserService) k.f(IBrowserService.class);
            if (r100 == null) goto L6;
            int r101 = com.bytedance.android.livesdk.coupon.jsb.b.f121915a;
            b r102 = this.f20516a;
            r100.enqueueEvent("start_expand_task", com.bytedance.android.livesdk.coupon.jsb.b.a(r102.f20509m, r102.f20510n));
            return;
        }

        public e(b r100) {
            this.f20516a = r100;
        }

        public static void d(ExpandCouponEnterRoomDialog r100) {
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L5;
        L8:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
        L17:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L13:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
            if (r102 == null) goto L17;
            com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L5:
            if (Looper.myLooper() == r101.getLooper()) goto L8;
            r101.post(DialogLancet.createDismissRunnable(r100));
        }
    }

    public static final class f implements DialogInterface.OnDismissListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f20517a;

        public f(b r100) {
            this.f20517a = r100;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r100) {
            this.f20517a.f20504h = null;
        }
    }

    static {
    }

    public static boolean o() {
        IUserService r100 = (IUserService) k.f(IUserService.class);
        if (r100 == null) goto L7;
        com.bytedance.android.livesdk.user.f r101 = r100.user();
        if (r101 == null) goto L7;
        return r101.isLogin();
    L7:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> a() {
        HashMap r100 = new HashMap();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r101 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        Long r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.b());
    L6:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_BENEFIT_TYPE, r103);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r104 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r104 == null) goto L9;
        String r105 = r104.e();
    L10:
        r100.put("req_id", r105);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r106 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r106 == null) goto L13;
        String r107 = r106.f();
    L14:
        r100.put("ad_token", r107);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r108 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r108 == null) goto L17;
        Long r109 = Long.valueOf(r108.d());
    L18:
        r100.put("cid", r109);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r110 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r110 == null) goto L21;
        Long r111 = Long.valueOf(r110.a());
    L22:
        r100.put("ad_id", r111);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r112 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r112 == null) goto L25;
        String r113 = r112.c();
    L26:
        r100.put("ad_scene", r113);
        if (p() == false) goto L32;
        ct1.b r114 = this.f20510n;
        if (r114 == null) goto L31;
        r102 = Long.valueOf(r114.f465307j);
    L31:
        r100.put("qcpx_expansion_task_id_list", r102);
    L32:
        return r100;
    L25:
        r113 = null;
        goto L26
    L21:
        r111 = null;
        goto L22
    L17:
        r109 = null;
        goto L18
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.coupon.a
    public final Map<String, Object> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r101 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        Long r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.e();
    L6:
        r100.put("req_id", r103);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r104 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r104 == null) goto L9;
        String r105 = r104.f();
    L10:
        r100.put("ad_token", r105);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r106 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r106 == null) goto L13;
        Long r107 = Long.valueOf(r106.d());
    L14:
        r100.put("cid", r107);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r108 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r108 == null) goto L17;
        r102 = Long.valueOf(r108.a());
    L17:
        r100.put("ad_id", r102);
        r100.put("popup_type", 2);
        return r100;
    L13:
        r107 = null;
        goto L14
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void j() {
        Logger.d("ExpandCouponController", "expandCouponController release");
        ct1.b r100 = this.f20510n;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.f465301d != 1) goto L7;
    L8:
        if (r101 == false) goto L10;
        e();
    L10:
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, this.f121822c.f16210b, 0, 2);
        if (r102 == null) goto L17;
        j<CopyOnWriteArrayList<kf1.a>> r103 = r102.getCloseRoomInterceptors();
        if (r103 == null) goto L17;
        CopyOnWriteArrayList<kf1.a> r104 = r103.getValue();
        if (r104 == null) goto L17;
        r104.remove(this.f20507k);
    L17:
        ct1.b r105 = this.f20510n;
        if (r105 == null) goto L23;
        ct1.b.CountDownTimerC5582b r106 = r105.f465300c;
        if (r106 == null) goto L22;
        r106.cancel();
    L22:
        r105.f465301d = 0;
        r105.f465303f = false;
        AppLifeCycleMonitor.INSTANCE.getAppEnterBackgroundOb().removeObserver(r105.f465305h);
        r105.f465302e.d();
        r105.f465302e.c(r105.f465304g);
        r105.f465298a = null;
    L23:
        ExpandCouponLoginDialog r107 = this.f20505i;
        if (r107 == null) goto L42;
        Handler r108 = DialogLancet.resolveDialogHandler(r107);
        if (r108 != null) goto L28;
    L30:
        DialogLancet.beforeDialogDismiss(r107);
        r107.dismiss();     // Catch: Throwable -> L33 Exception -> L35
    L39:
        DialogLancet.afterDialogDismiss(r107);
        goto L42
    L33:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r107);
        throw th;
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
        Throwable r109 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
        if (r109 == null) goto L39;
        com.bytedance.crash.d.d(r109, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
        goto L39
    L28:
        if (Looper.myLooper() == r108.getLooper()) goto L30;
        r108.post(DialogLancet.createDismissRunnable(r107));
    L42:
        ExpandCouponEnterRoomDialog r110 = this.f20504h;
        if (r110 == null) goto L45;
        l(r110);
    L45:
        bt1.a r111 = this.f20506j;
        if (r111 == null) goto L48;
        k(r111);
    L48:
        this.f20512p = false;
        return;
    L7:
        r101 = false;
        goto L8
    }

    public final boolean p() {
        ct1.b r100 = this.f20510n;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.f465301d != 3) goto L7;
        return true;
    }

    public final void q() {
        HashMap r100 = new HashMap();
        if (p() == false) goto L5;
        String r101 = "1";
    L6:
        r100.put("is_expanded", r101);
        u.l().sendLog("tobsdk_livesdk_coupon_expand_quit_popup_show", r100, new Object[]{Room.class, x.class});
        return;
    L5:
        r101 = "0";
        goto L6
    }

    public final void s() {
        IUserService r100 = (IUserService) k.f(IUserService.class);
        if (r100 == null) goto L5;
        com.bytedance.android.livesdk.user.f r101 = r100.user();
    L6:
        if (r101 == null) goto L9;
        l.a r102 = new l.a();
        r102.f158688d = "expand_coupon";
        r102.f158687c = -1;
        l r103 = new l(r102);
        r101.login(this.f121822c.getContext(), r103).subscribe(c.f20514a, d.f20515a);
        return;
    L9:
        return;
    L5:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t() {
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r100 = this.f20508l;
        if (r100 == null) goto L41;
        Map<Long, com.bytedance.android.livesdk.coupon.expandcoupon.model.c> r101 = r100.b();
        if (r101 == null) goto L42;
        int r102 = ct1.a.f465297a;
        Context r103 = this.f121822c.getContext();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "taskMap");
        if (r101.get(1L) == null) goto L9;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.c r104 = r101.get(1L);
        Intrinsics.checkNotNull(r104);
        ct1.b r105 = new ct1.b(r103, r104);
    L10:
        this.f20510n = r105;
        if (r105 == null) goto L14;
        r105.b(new bt1.d(this));
    L14:
        if (this.f20510n != null) goto L16;
        return;
    L16:
        Context r106 = this.f121822c.getContext();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r107 = this.f20508l;
        Intrinsics.checkNotNull(r107);
        long r108 = r107.d();
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r109 = this.f20508l;
        Intrinsics.checkNotNull(r109);
        long r110 = r109.c();
        ct1.b r111 = this.f20510n;
        Intrinsics.checkNotNull(r111);
        long r112 = r111.f465307j;
        ct1.b r113 = this.f20510n;
        Intrinsics.checkNotNull(r113);
        this.f20504h = new ExpandCouponEnterRoomDialog(r106, new com.bytedance.android.livesdk.coupon.expandcoupon.model.a(r108, r110, r112, r113.f465308k));
        com.bytedance.android.livesdk.coupon.expandcoupon.model.b r114 = (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) this.f121821b;
        if (r114 == null) goto L23;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.d r115 = new com.bytedance.android.livesdk.coupon.expandcoupon.model.d(r114);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r116 = this.f20508l;
        if (r116 != null) goto L21;
    L24:
        this.f20509m = r115;
        ExpandCouponEnterRoomDialog r117 = this.f20504h;
        if (r117 == null) goto L27;
        r117.f121876g = new e(this);
    L27:
        if (r117 == null) goto L29;
        r117.setOnDismissListener(new f(this));
    L29:
        ExpandCouponEnterRoomDialog r118 = this.f20504h;
        if (r118 != null) goto L32;
    L36:
        u.l().sendLog("tobsdk_livesdk_coupon_expand_popup_show", null, new Object[]{Room.class, x.class});
        return;
    L32:
        if (DialogLancet.shouldBlockDialogShow(r118) == false) goto L39;
        DialogLancet.handleBlockedDialogShow(r118);
        goto L36
    L39:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L38
    L35:
        DialogLancet.beforeDialogShow(r118);
        r118.show();
        DialogLancet.afterDialogShow(r118);
        goto L36
    L21:
        if (this.f20510n == null) goto L24;
        com.bytedance.android.livesdk.coupon.util.a r119 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        Intrinsics.checkNotNull(r116);
        long r120 = r116.d();
        r119.getClass();
        String r121 = com.bytedance.android.livesdk.coupon.util.a.a(r120);
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r115.f121900b = r121;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r122 = this.f20508l;
        Intrinsics.checkNotNull(r122);
        long r123 = r122.d();
        ct1.b r124 = this.f20510n;
        Intrinsics.checkNotNull(r124);
        String r125 = com.bytedance.android.livesdk.coupon.util.a.a(r123 + r124.f465308k.c());
        Intrinsics.checkNotNullParameter(r125, "<set-?>");
        r115.f121901c = r125;
        goto L24
    L23:
        r115 = null;
        goto L24
    L9:
        r105 = null;
        goto L10
    L42:
        return;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final boolean d() {
        return this.f20512p;
    }

    public static void k(bt1.a r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void l(ExpandCouponEnterRoomDialog r100) {
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r100);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r102 == null) goto L17;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L5:
        if (Looper.myLooper() == r101.getLooper()) goto L8;
        r101.post(DialogLancet.createDismissRunnable(r100));
    }

    public static void r(String r100) {
        HashMap r101 = new HashMap();
        r101.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r100);
        u.l().sendLog("tobsdk_livesdk_coupon_expand_popup_click", r101, new Object[]{Room.class, x.class});
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void f(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
        bt1.a r101 = this.f20506j;
        if (r101 == null) goto L5;
        k(r101);
    L5:
        ALogger.e("ExpandCouponController", "obtain coupon fail " + Log.getStackTraceString(r100));
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void g(com.bytedance.android.livesdk.coupon.balancecoupon.model.b r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        this.f20512p = true;
        f2.c(r110.d(), 0);
        if (r110.c() == 1) goto L5;
        return;
    L5:
        if (p() == false) goto L22;
        com.bytedance.android.livesdk.log.g r100 = u.l();
        LinkedHashMap r101 = new LinkedHashMap();
        IUserService r102 = (IUserService) k.f(IUserService.class);
        if (r102 == null) goto L12;
        com.bytedance.android.livesdk.user.f r103 = r102.user();
        if (r103 == null) goto L12;
        String r104 = r103.n();
        if (r104 == null) goto L12;
    L13:
        r101.put("user_id", r104);
        ct1.b r105 = this.f20510n;
        if (r105 == null) goto L16;
        Long r106 = Long.valueOf(r105.f465307j);
    L17:
        r101.put("task_id", String.valueOf(r106));
        if (this.f20511o == false) goto L20;
        String r107 = "任务面板";
    L21:
        r101.put("coupon_resource", r107);
        Unit r108 = Unit.INSTANCE;
        r100.sendLog("tobsdk_livesdk_coupon_expanded_toast_show", r101, new Object[]{Room.class, x.class});
        goto L22
    L20:
        r107 = "引导弹窗";
        goto L21
    L16:
        r106 = null;
    L12:
        r104 = "0";
    L22:
        bt1.a r109 = this.f20506j;
        if (r109 == null) goto L30;
        r109.f20494c.setText(LiveResUtil.getString(R.string.ttlive_use_expand_coupon));
        int r111 = LiveResUtil.getColor(R.color.ttlive_color_FE2C55);
        SpannableStringBuilder r112 = new SpannableStringBuilder();
        r112.append("优惠券已膨胀为");     // Catch: Throwable -> L27
        int r113 = r112.length();     // Catch: Throwable -> L27
        StringBuilder r114 = new StringBuilder();     // Catch: Throwable -> L27
        com.bytedance.android.livesdk.coupon.util.a r115 = com.bytedance.android.livesdk.coupon.util.a.f121922a;     // Catch: Throwable -> L27
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r116 = r109.f20497f;     // Catch: Throwable -> L27
        long r117 = r116.f121895a + r116.f121898d.c();     // Catch: Throwable -> L27
        r115.getClass();     // Catch: Throwable -> L27
        r114.append(com.bytedance.android.livesdk.coupon.util.a.a(r117));     // Catch: Throwable -> L27
        r114.append("元");     // Catch: Throwable -> L27
        r112.append(r114.toString());     // Catch: Throwable -> L27
        r112.setSpan(new ForegroundColorSpan(r111), r113, r112.length(), 33);     // Catch: Throwable -> L27
        r109.f20493b.setText(r112);     // Catch: Throwable -> L27
    L29:
        q();
    L27:
        th = move-exception;
        ALogger.e("ExpandCouponCloseRoomDialog", "onTaskFinish error " + Log.getStackTraceString(th));
    L30:
        com.bytedance.android.livesdk.coupon.expandcoupon.model.d r118 = this.f20509m;
        if (r118 == null) goto L37;
        String r119 = r110.a();
        Intrinsics.checkNotNullParameter(r119, "<set-?>");
        r118.f121899a = r119;
        return;
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final void h(com.bytedance.android.livesdk.coupon.balancecoupon.model.c r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r100.a() == false) goto L34;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r101 = r100.c();
        if (r101 == null) goto L34;
        if (r101.a() == true) goto L34;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r102 = r100.c();
        if (r102 == null) goto L11;
        Map<Long, com.bytedance.android.livesdk.coupon.expandcoupon.model.c> r103 = r102.b();
    L12:
        if (r103 == null) goto L34;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r104 = r100.c();
        if (r104 == null) goto L42;
        this.f20508l = r104;
        if (o() == true) goto L32;
        ExpandCouponLoginDialog r105 = new ExpandCouponLoginDialog(this.f121822c.getContext(), r104);
        this.f20505i = r105;
        bt1.e r106 = new bt1.e(this, r104);
        Intrinsics.checkNotNullParameter(r106, "callback");
        r105.f121890d = r106;
        ExpandCouponLoginDialog r107 = this.f20505i;
        if (r107 == null) goto L22;
        r107.setOnDismissListener(new bt1.f(this));
    L22:
        ExpandCouponLoginDialog r108 = this.f20505i;
        if (r108 == null) goto L25;
        r108.setCanceledOnTouchOutside(true);
    L25:
        ExpandCouponLoginDialog r109 = this.f20505i;
        if (r109 != null) goto L28;
        return;
    L28:
        if (DialogLancet.shouldBlockDialogShow(r109) == false) goto L37;
        DialogLancet.handleBlockedDialogShow(r109);
        return;
    L37:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
    L31:
        DialogLancet.beforeDialogShow(r109);
        r109.show();
        DialogLancet.afterDialogShow(r109);
        return;
    L32:
        t();
        return;
    L42:
        return;
    L11:
        r103 = null;
    L34:
        Logger.d("ExpandCouponController", "coupon can not show");
    }

    @Override // com.bytedance.android.livesdk.coupon.a
    public final com.bytedance.android.livesdk.coupon.expandcoupon.model.b i(at1.a r110) {
        String r100 = "";
        Intrinsics.checkNotNullParameter(r110, "couponContext");
        Long r101 = (Long) r110.f16210b.get("data_room_id", 0L);
        IMiddlewareLiveService r102 = (IMiddlewareLiveService) k.f(IMiddlewareLiveService.class);
        if (r102 == null) goto L5;
        ILiveOntologyInfoManager r103 = r102.getLiveOntologyRecord();
    L6:
        boolean r104 = false;
        if (r103 == null) goto L9;
        boolean r105 = r103.isFirstRoom(r101.longValue());
    L10:
        if (r105 == false) goto L59;
        SettingKey<String> r106 = LiveInfraSettingKeys.LIVE_MOCK_EXPAND_COUPON_PARAM;
        String r107 = r106.getValue();
        if (r107 != null) goto L15;
    L18:
        boolean r108 = true;
    L19:
        if (r108 == false) goto L54;
        String r111 = (String) r110.f16210b.get("data_enter_ecom_live_params", "");     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
        if (r111 == null) goto L26;
        r100 = r111;
    L26:
        if (TextUtils.isEmpty(r100) == false) goto L28;
        ALogger.i("ExpandCouponController", "could not find ecomParams");     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
        JSONObject r112 = null;
    L29:
        if (r112 == null) goto L31;
        String r109 = r112.toString();     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
    L32:
        if (r109 != null) goto L34;
    L35:
        r104 = true;
    L36:
        if (r104 == true) goto L55;
        Gson r113 = LiveGsonHelper.get();     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
        if (r112 == null) goto L42;
        JSONObject r114 = r112.optJSONObject("expand_coupon");     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
        if (r114 == null) goto L42;
        String r115 = r114.toString();     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
    L43:
    L56:
        return (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) GsonProtectorUtils.fromJson(r113, r115, com.bytedance.android.livesdk.coupon.expandcoupon.model.b.class);
    L42:
        r115 = null;
        goto L43
    L55:
        return null;
    L34:
        if (r109.length() != 0) goto L36;
    L31:
        r109 = null;
        goto L32
    L28:
        r112 = new JSONObject(r100);     // Catch: JsonParseException -> L45 JsonSyntaxException -> L47 JSONException -> L49
    L47:
        e = move-exception;
        ALogger.e("ExpandCouponController", "JsonSyntaxException, " + Log.getStackTraceString(e));
        return null;
    L45:
        e = move-exception;
        ALogger.e("ExpandCouponController", "JsonSyntaxException, " + Log.getStackTraceString(e));
        return null;
    L49:
        e = move-exception;
        ALogger.e("ExpandCouponController", "build ecom params error: " + e);
        return null;
    L54:
        return (com.bytedance.android.livesdk.coupon.expandcoupon.model.b) GsonProtectorUtils.fromJson(LiveGsonHelper.get(), r106.getValue(), com.bytedance.android.livesdk.coupon.expandcoupon.model.b.class);
    L15:
        if (r107.length() == 0) goto L18;
        r108 = false;
        goto L19
    L59:
        return null;
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public static final void m(b r100, boolean r101) {
        if (r100.f20508l == null) goto L49;
        r100.f20511o = r101;
        if (o() == true) goto L8;
        r100.s();
    L39:
        if (r101 == true) goto L46;
        IBrowserService r102 = (IBrowserService) k.f(IBrowserService.class);
        if (r102 == null) goto L47;
        w30.a r103 = r102.getStorageProcessor(r100.f121822c.getContext());
        if (r103 == null) goto L48;
        r103.setStorage("task_center_flash_exchange_qcpx_coupon", String.valueOf(System.currentTimeMillis()));
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L8:
        ExpandCouponEnterRoomDialog r104 = r100.f20504h;
        if (r104 == null) goto L11;
        l(r104);
    L11:
        ct1.b r105 = r100.f20510n;
        if (r105 != null) goto L14;
    L20:
        ct1.b r106 = r100.f20510n;
        if (r106 == null) goto L39;
        if (r106.f465301d != 1) goto L39;
        f2.c(LiveResUtil.getString(R.string.ttlive_coupon_expand_task_start), 0);
        com.bytedance.android.livesdk.coupon.expandcoupon.model.e r107 = r100.f20508l;
        ct1.b r108 = r100.f20510n;
        if (r108 != null) goto L27;
    L38:
        r(BitableAnalytic.LinkSceneClickType.EXPAND);
        goto L39
    L27:
        if (r108.f465301d != 1) goto L38;
        RoomContext r109 = RoomContext.a.c(RoomContext.Companion, r100.f121822c.f16210b, 0, 2);
        if (r109 == null) goto L34;
        j<CopyOnWriteArrayList<kf1.a>> r110 = r109.getCloseRoomInterceptors();
        if (r110 == null) goto L34;
        CopyOnWriteArrayList<kf1.a> r111 = r110.getValue();
    L35:
        bt1.c r112 = new bt1.c(r100, r111, r107);
        r100.f20507k = r112;
        if (r111 == null) goto L38;
        Intrinsics.checkNotNull(r112);
        r111.add(0, r112);
    L34:
        r111 = null;
        goto L35
    L14:
        if (NetworkUtils.f(r105.f465306i) == true) goto L16;
        f2.c(LiveResUtil.getString(R.string.ttlive_toast_network_exception), 0);
        goto L20
    L16:
        ct1.b.CountDownTimerC5582b r113 = r105.f465300c;
        if (r113 == null) goto L19;
        r113.cancel();
    L19:
        AppLifeCycleMonitor r114 = AppLifeCycleMonitor.INSTANCE;
        r114.getAppEnterBackgroundOb().removeObserver(r105.f465305h);
        r114.getAppEnterBackgroundOb().observeForever(r105.f465305h);
        LiveNetworkBroadcastReceiver r115 = r105.f465302e;
        Context r116 = r105.f465306i;
        TokenCert r117 = LiveNetworkBroadcastReceiver.f158755d;
        r115.b(r116, r117);
        r105.f465302e.a(r105.f465304g, r117);
        r105.a(r105.f465299b);
        goto L20
    }

    public static final void n(b r100, String r101) {
        r100.getClass();
        HashMap r102 = new HashMap();
        if (r100.p() == false) goto L5;
        String r103 = "1";
    L6:
        r102.put("is_expanded", r103);
        r102.put(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r101);
        u.l().sendLog("tobsdk_livesdk_coupon_expand_quit_popup_click", r102, new Object[]{Room.class, x.class});
        return;
    L5:
        r103 = "0";
        goto L6
    }

    public b(at1.a r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "couponContext");
        super(r100, r101, r102);
        this.f20503g = new C0359b(this);
    }
}
