package com.bytedance.android.livesdk.commerce.coupon;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieComposition;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.plugin_api.LivePluginSPIManager;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.platform.IHostMonitor;
import com.bytedance.android.livesdk.TTLiveSDKContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.user.f0;
import com.bytedance.android.livesdk.utils.t6;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponPresenter;", "Lq46/b;", "Lcom/bytedance/android/livesdk/commerce/coupon/LiveCouponPresenter$b;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveCouponPresenter extends q46.b<b> implements Observer<KVData> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f119543r = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f119544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f119545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.commerce.coupon.b f119546d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rg2.g f119547e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f119548f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final vl2.l f119549g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LiveCouponView f119550h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public e f119551i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f119552j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public vl2.b f119553k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public vl2.b f119554l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f119555m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f119556n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final d f119557o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f119558p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DataCenter f119559q;

    public static final class a {
    }

    public interface b extends q46.a {
        void Be(boolean r100);

        void HT(vl2.b r100);

        void Z80();
    }

    public static final class c implements vl2.l.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCouponPresenter f119560a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f119561b;

        @Override // vl2.l.a
        public final void onFail() {
        }

        @Override // vl2.l.a
        public final void a(vl2.a r100) {
            if ((r100 instanceof vl2.b) == true) goto L5;
            return;
        L5:
            if (this.f119561b != 6) goto L7;
            vl2.b r101 = (vl2.b) r100;
            this.f119560a.f119554l = r101;
        L8:
            LiveCouponView r102 = this.f119560a.f119550h;
            if (r102 == null) goto L11;
            r102.a((vl2.b) r100);
        L11:
            b r103 = (b) this.f119560a.f531633a;
            if (r103 == null) goto L16;
            r103.HT((vl2.b) r100);
            return;
        L16:
            return;
        L7:
            vl2.b r104 = (vl2.b) r100;
            this.f119560a.f119553k = r104;
            goto L8
        }

        public c(LiveCouponPresenter r100, int r101) {
            this.f119560a = r100;
            this.f119561b = r101;
        }
    }

    public static final class d implements LiveCouponView.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LiveCouponPresenter f119562a;

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponView.b
        public final void b() {
            LiveCouponPresenter r100 = this.f119562a;
            String[] r101 = {"coupon_result", "1", "button_info", s1.B(R.string.ttlive_live_try_show_goods)};
            r100.getClass();
            LiveCouponPresenter.i0("livesdk_coupon_more", r101);
            this.f119562a.h0();
        }

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponView.b
        public final void onCloseClick() {
            LiveCouponPresenter r100 = this.f119562a;
            int r101 = LiveCouponPresenter.f119543r;
            r100.h0();
        }

        public d(LiveCouponPresenter r100) {
            this.f119562a = r100;
        }

        @Override // com.bytedance.android.livesdk.commerce.coupon.LiveCouponView.b
        public final void a(String r100, Function0<Unit> r101) {
            Intrinsics.checkNotNullParameter(r101, "callback");
            this.f119562a.getClass();
            LiveCouponPresenter.i0("livesdk_coupon_get", new String[0]);
            LiveCouponPresenter r102 = this.f119562a;
            r102.getClass();
            if (TextUtils.isEmpty(r100) == false) goto L5;
            r102.f0(s1.B(R.string.ttlive_live_get_coupon_fail), true);
            return;
        L5:
            HashMap r103 = new HashMap();
            r103.put("room_id", String.valueOf(r102.f119544b));
            if (r100 != null) goto L8;
            String r104 = "";
        L9:
            r103.put("meta_id", r104);
            com.bytedance.android.livesdk.service.l.d().getClass();
            r102.f119548f = ((LiveCouponApi) com.bytedance.android.live.network.c.b().e(LiveCouponApi.class)).tryApplyCurCouponInfo(r103).compose(RxUtil.rxSchedulerHelper()).subscribe(new i(r102, r101, r100), new j(r102, r100));
            return;
        L8:
            r104 = r100;
            goto L9
        }
    }

    static {
    }

    @Override // q46.b
    public final void detachView() {
        this.f531633a = null;
        h0();
        rg2.g r100 = this.f119547e;
        if (r100 == null) goto L7;
        Map<String, LottieComposition> r101 = r100.f537690a;
        if (r101 == null) goto L7;
        ((WeakHashMap) r101).clear();
    L7:
        Disposable r102 = this.f119548f;
        if (r102 != null) goto L10;
    L14:
        this.f119559q.removeObserver(this);
        return;
    L10:
        if (r102.isDisposed() != true) goto L14;
        Disposable r103 = this.f119548f;
        if (r103 == null) goto L14;
        r103.dispose();
        goto L14
    }

    public final void h0() {
        String r100 = this.f119552j;
        LiveCouponView r101 = this.f119550h;
        if (r101 == null) goto L5;
        String r102 = r101.getMMetaId();
    L7:
        if (StringUtils.equal(r100, r102) == true) goto L9;
        this.f119555m = true;
    L9:
        b r103 = (b) this.f531633a;
        if (r103 == null) goto L12;
        r103.Be(this.f119555m);
    L12:
        e r104 = this.f119551i;
        if (r104 == null) goto L31;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L17;
    L19:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L22 Exception -> L24
    L28:
        DialogLancet.afterDialogDismiss(r104);
        goto L31
    L22:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L24:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
        if (r106 == null) goto L28;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
        goto L28
    L17:
        if (Looper.myLooper() == r105.getLooper()) goto L19;
        r105.post(DialogLancet.createDismissRunnable(r104));
    L31:
        this.f119551i = null;
        this.f119550h = null;
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void e0() {
        if (((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h().isLogin() == true) goto L5;
        Bundle r100 = new Bundle();
        r100.putString("enter_from", "live_detail");
        r100.putString("source", "live");
        com.bytedance.android.livesdk.user.f r101 = ((com.bytedance.android.livesdk.service.f) TTLiveSDKContext.getHostService()).h();
        Context r102 = this.f119558p;
        com.bytedance.android.livesdk.user.l.a r103 = new com.bytedance.android.livesdk.user.l.a();
        r103.f158685a = s1.B(R.string.ttlive_login_dialog_message);
        r103.f158689e = "live_detail";
        r103.f158688d = "live";
        ((f0) r101).login(r102, new com.bytedance.android.livesdk.user.l(r103)).subscribe(new h(this));
        boolean r104 = false;
    L6:
        if (r104 == true) goto L8;
        return;
    L8:
        i0("livesdk_coupon_click", new String[0]);
        e r105 = this.f119551i;
        if (r105 != null) goto L11;
    L13:
        LiveCouponView r106 = new LiveCouponView(this.f119558p, null, 6, 0);
        this.f119550h = r106;
        com.bytedance.android.livesdk.commerce.coupon.b r107 = this.f119546d;
        if (r107 != null) goto L16;
    L18:
        vl2.b r108 = this.f119553k;
    L19:
        r106.a(r108);
        LiveCouponView r109 = this.f119550h;
        if (r109 == null) goto L22;
        r109.setMLottieHelper(this.f119547e);
    L22:
        LiveCouponView r110 = this.f119550h;
        if (r110 == null) goto L25;
        r110.setMMetaId(this.f119552j);
    L25:
        LiveCouponView r111 = this.f119550h;
        if (r111 == null) goto L28;
        r111.setActivityData(this.f119546d);
    L28:
        this.f119551i = new e(this.f119558p, this.f119550h);
        LiveCouponView r112 = this.f119550h;
        if (r112 == null) goto L31;
        r112.setMCouponClick(this.f119557o);
    L31:
        LiveCouponView r113 = this.f119550h;
        if (r113 == null) goto L34;
        r113.setVisibility(0);
    L34:
        LiveCouponView r114 = this.f119550h;
        if (r114 == null) goto L44;
        vl2.b r115 = r114.f119584b;
        if (r115 == null) goto L43;
        WeakHandler r116 = r114.f119583a;
        String r117 = r115.f555639d;
        l56.b r118 = l56.b.a();
        vl2.e r119 = new vl2.e(r117);
        if (r118.f507529a == false) goto L42;
        r118.f507530b.execute(new l56.a(r116, r119, 200));
        goto L43
    L42:
        throw new IllegalStateException("TaskManager not init");
    L43:
        float r120 = (t6.b(r114.getContext()) / 2) + t6.a(r114.getContext(), 125.0f);
        float r121 = t6.a(r114.getContext(), 30.0f);
        ObjectAnimator r122 = ObjectAnimator.ofFloat(r114.f119586d, View.TRANSLATION_Y, new float[]{-r120, 0.0f});
        r122.setInterpolator(new AccelerateInterpolator());
        r122.setDuration(300);
        float r123 = -r121;
        ObjectAnimator r124 = ObjectAnimator.ofFloat(r114.f119586d, View.TRANSLATION_Y, new float[]{0.0f, r123});
        r124.setInterpolator(new DecelerateInterpolator());
        r124.setDuration(120);
        ObjectAnimator r125 = ObjectAnimator.ofFloat(r114.f119586d, View.TRANSLATION_Y, new float[]{r123, 0.0f});
        r125.setInterpolator(new AccelerateInterpolator());
        r125.setDuration(120);
        AnimatorSet r126 = new AnimatorSet();
        r126.playSequentially(new Animator[]{r122, r124, r125});
        r126.start();
    L44:
        Context r127 = this.f119558p;
        if ((r127 instanceof Activity) == true) goto L47;
        return;
    L47:
        if (((Activity) r127).isFinishing() == true) goto L60;
        e r128 = this.f119551i;
        if (r128 != null) goto L51;
        return;
    L51:
        if (DialogLancet.shouldBlockDialogShow(r128) == false) goto L57;
        DialogLancet.handleBlockedDialogShow(r128);
        return;
    L57:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L56
    L54:
        DialogLancet.beforeDialogShow(r128);
        r128.show();
        DialogLancet.afterDialogShow(r128);
        return;
    L60:
        return;
    L16:
        if (r107.activityType != 1) goto L18;
        r108 = this.f119554l;
        goto L19
    L11:
        if (r105.isShowing() != true) goto L13;
        return;
    L5:
        r104 = true;
        goto L6
    }

    public final void g0(int r100) {
        vl2.l r101 = this.f119549g;
        if (r101 == null) goto L6;
        Context r102 = this.f119558p;
        c r103 = new c(this, r100);
        LivePluginSPIManager.f85856e.getClass();
        LivePluginSPIManager.a().addOnSuccess(new vl2.j(r101, r102, r100, r103)).addOnFail(new vl2.h(r103)).syncCallbackIfReady(true).callbackOnMainThread().requireByUser("LiveResourceDownloadService");
        return;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        com.bytedance.android.livesdk.commerce.coupon.b r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.android.livesdk.commerce.coupon.a r103 = (com.bytedance.android.livesdk.commerce.coupon.a) r101.getData();
    L7:
        if ((r103 instanceof com.bytedance.android.livesdk.commerce.coupon.a) == true) goto L9;
        r103 = null;
    L9:
        if (r103 == null) goto L45;
        int r104 = r103.f119604a;
        boolean r105 = false;
        if (r104 != 1) goto L35;
        this.f119555m = true;
        b r106 = (b) this.f531633a;
        if (r106 == null) goto L15;
        r106.Z80();
    L15:
        this.f119552j = String.valueOf(r103.f119608e);
        String r107 = r103.getActivity();
        if (r107 != null) goto L18;
    L28:
        this.f119546d = r102;
        if (r102 != null) goto L31;
    L33:
        g0(5);
        return;
    L31:
        if (r102.activityType != 1) goto L33;
        g0(6);
        return;
    L18:
        if (r107.length() <= 0) goto L20;
        r105 = true;
    L20:
        if (r105 == true) goto L23;
        r107 = null;
    L23:
        if (r107 == null) goto L28;
        r102 = (com.bytedance.android.livesdk.commerce.coupon.b) GsonHelper.get().fromJson(r107, com.bytedance.android.livesdk.commerce.coupon.b.class);     // Catch: Exception -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L35:
        if (r104 == 2) goto L37;
        if (r104 == 3) goto L37;
        return;
    L37:
        if (r104 != 3) goto L39;
        com.bytedance.android.livesdk.log.g r108 = u.l();
        HashMap r109 = new HashMap();
        r109.put("coupon_id", this.f119552j);
        r109.put("room_id", String.valueOf(this.f119544b));
        r109.put("anchor_id", String.valueOf(this.f119545c));
        r109.put(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, String.valueOf(this.f119556n));
        r109.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        r109.put("duration", String.valueOf(System.currentTimeMillis() - r103.f119605b));
        r109.put("type", VideoEventOneOutSync.END_TYPE_FINISH);
        Unit r110 = Unit.INSTANCE;
        r108.sendLog("livesdk_send_coupons_duration", r109, new Object[0]);
    L39:
        this.f119555m = false;
        this.f119552j = "";
        b r111 = (b) this.f531633a;
        if (r111 == null) goto L49;
        r111.Z80();
        return;
    L49:
        return;
    L45:
        return;
    L5:
        r103 = null;
        goto L7
    }

    public LiveCouponPresenter(Context r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f119558p = r100;
        this.f119559q = r101;
        this.f119552j = "";
        this.f119555m = true;
        this.f119549g = new vl2.l();
        this.f119547e = new rg2.g();
        this.f119557o = new d(this);
    }

    public static void i0(String r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "extras");
        HashMap r102 = new HashMap();     // Catch: Exception -> L17
        if (r101.length != 0) goto L6;
        boolean r103 = true;
    L8:
        if ((!r103) == true) goto L10;
    L15:
        u.l().sendLog(r100, r102, new Object[]{new x(), Room.class});     // Catch: Exception -> L17
        return;
    L10:
        if ((r101.length % 2) != 0) goto L15;
        int r104 = 0;
    L13:
        if (r104 >= r101.length) goto L15;
        r102.put(r101[r104], r101[r104 + 1]);     // Catch: Exception -> L17
        r104 = r104 + 2;     // Catch: Exception -> L17
        goto L13
    L6:
        r103 = false;
    L17:
        e = move-exception;
        e.printStackTrace();
    }

    public final void f0(String r100, boolean r101) {
        if (r101 == false) goto L5;
        h0();
    L5:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        f2.i(this.f119558p, r100, 0);
        return;
    L7:
        f2.i(this.f119558p, s1.B(R.string.ttlive_live_get_coupon_fail), 0);
    }

    public static final void c0(LiveCouponPresenter r210, com.bytedance.android.livesdk.commerce.coupon.c r310, boolean r311) {
        r210.getClass();
        if (r311 == false) goto L7;
        if (r310 == null) goto L6;
        boolean r100 = r310.a();
    L8:
        r210.f119555m = r100;
        String r101 = "coupon_result";
        if (r310 == null) goto L158;
        if (r310.c() != 0) goto L158;
        if (r311 == false) goto L158;
        LiveCouponView r102 = r210.f119550h;
        if (r102 == null) goto L155;
        com.bytedance.android.livesdk.commerce.coupon.d r103 = r310.b();
        if (r103 == null) goto L155;
        r102.f119596n = r103;
        r102.f119595m = 1;
        TextView r104 = r102.f119588f;
        com.bytedance.android.livesdk.commerce.coupon.b r105 = r102.f119597o;
        if (r105 != null) goto L21;
    L31:
        String r106 = s1.B(R.string.ttlive_live_had_get_coupon);
    L32:
        r104.setText(r106);
        TextView r107 = r102.f119587e;
        com.bytedance.android.livesdk.commerce.coupon.b r108 = r102.f119597o;
        if (r108 != null) goto L35;
    L45:
        String r109 = s1.B(R.string.ttlive_live_try_show_goods);
    L46:
        r107.setText(r109);
        com.bytedance.android.livesdk.commerce.coupon.b r110 = r102.f119597o;
        if (r110 != null) goto L49;
    L103:
        r101 = "coupon_result";
        n r111 = new n(r103.type, r102.f119592j);
        ImageView r112 = r111.f119631a;
        if (r112 == null) goto L110;
        vl2.b r113 = r102.f119584b;
        if (r113 == null) goto L108;
        String r114 = r113.f555644i;
    L109:
        r112.setImageURI(UriProtector.parse(r114));
        goto L110
    L108:
        r114 = null;
    L110:
        View r115 = r111.f119633c;
        if (r115 == null) goto L113;
        r115.setVisibility(0);
    L113:
        long r116 = r111.f119632b;
        if (r116 != 1) goto L125;
        String r211 = n.a(String.valueOf(r103.discount));
        String r117 = s1.B(R.string.ttlive_live_get_coupon_discount);
        ArrayList r118 = new ArrayList();
        if (r211 == null) goto L118;
        r118.add(new m(r211, s1.I(36.0f), s1.h(R.color.ttlive_collect_coupon), 0, r111.f119637g));
    L118:
        if (r117 == null) goto L120;
        r118.add(new m(r117, s1.I(13.0f), s1.h(R.color.ttlive_collect_coupon), 0, Typeface.DEFAULT_BOLD));
    L120:
        LiveAlignTextView r119 = r111.f119636f;
        if (r119 == null) goto L123;
        r119.setTextList(CollectionsKt.toList(r118));
    L123:
        r111.b(r103);
    L147:
        vl2.m r120 = r102.f119598p;
        if (r120 != null) goto L150;
    L156:
        i0("livesdk_coupon_result", new String[]{r101, "1"});
        return;
    L150:
        if (r120.f555666a != 5) goto L156;
        r102.f119589g.removeAnimatorListener(r102.f119602t);
        r102.f119589g.addAnimatorListener(r102.f119602t);
        rg2.g r121 = r102.f119585c;
        if (r121 == null) goto L156;
        r121.a(r120, r102.f119589g, true);
        goto L156
    L125:
        if (r116 != 2) goto L136;
        String r122 = n.a(String.valueOf(r103.credit / 100.0f));
        String r212 = s1.B(R.string.ttlive_live_get_coupon_direct_reduce);
        ArrayList r123 = new ArrayList();
        if (r122 == null) goto L129;
        r123.add(new m(r122, s1.I(36.0f), s1.h(R.color.ttlive_collect_coupon), 0, r111.f119637g));
    L129:
        if (r212 == null) goto L131;
        r123.add(new m(r212, s1.I(13.0f), s1.h(R.color.ttlive_collect_coupon), s1.f(4.0f), Typeface.DEFAULT_BOLD));
    L131:
        LiveAlignTextView r124 = r111.f119636f;
        if (r124 == null) goto L134;
        r124.setTextList(CollectionsKt.toList(r123));
    L134:
        r111.b(r103);
        goto L147
    L136:
        if (r116 != 3) goto L147;
        String r213 = n.a(String.valueOf(r103.credit / 100.0f));
        ArrayList r125 = new ArrayList();
        if (r213 == null) goto L140;
        r125.add(new m(r213, s1.I(36.0f), s1.h(R.color.ttlive_collect_coupon), 0, r111.f119637g));
    L140:
        LiveAlignTextView r126 = r111.f119636f;
        if (r126 == null) goto L143;
        r126.setTextList(CollectionsKt.toList(r125));
    L143:
        TextView r127 = r111.f119634d;
        if (r127 == null) goto L146;
        r127.setText(s1.C(R.string.ttlive_live_get_coupon_full, new Object[]{n.a(String.valueOf(r103.threshold / 100.0f))}));
    L146:
        r111.b(r103);
        goto L147
    L49:
        if (r110.activityType != 1) goto L103;
        o r128 = new o(r103.type, r102.f119592j);
        ImageView r129 = r128.f119638a;
        if (r129 == null) goto L57;
        vl2.b r130 = r102.f119584b;
        if (r130 == null) goto L55;
        String r131 = r130.f555644i;
    L56:
        r129.setImageURI(UriProtector.parse(r131));
        goto L57
    L55:
        r131 = null;
    L57:
        View r132 = r128.f119641d;
        if (r132 == null) goto L60;
        r132.setVisibility(0);
    L60:
        long r133 = r128.f119640c;
        float r134 = 44.0f;
        if (r133 != 1) goto L70;
        String r135 = o.a(String.valueOf(r103.discount));
        TextView r136 = r128.f119645h;
        if (r136 == null) goto L65;
        SpannableString r137 = new SpannableString(r135 + s1.B(R.string.ttlive_live_get_coupon_discount));
        r137.setSpan(new AbsoluteSizeSpan((int) UIUtils.dip2Px(r128.f119639b, 44.0f)), 0, r135.length(), 17);
        r137.setSpan(new StyleSpan(1), 0, r135.length(), 17);
        r137.setSpan(new AbsoluteSizeSpan((int) UIUtils.dip2Px(r128.f119639b, 11.0f)), r135.length(), r135.length() + 1, 17);
        Unit r138 = Unit.INSTANCE;
        r136.setText(r137);
    L65:
        TextView r139 = r128.f119643f;
        if (r139 == null) goto L68;
        r139.setText(r103.typeString);
    L68:
        r128.b(r103);
    L102:
        r101 = "coupon_result";
        goto L147
    L70:
        if (r133 != 2) goto L86;
        String r140 = o.a(String.valueOf(r103.credit / 100.0f));
        TextView r141 = r128.f119643f;
        if (r141 == null) goto L74;
        r141.setText(s1.B(R.string.ttlive_live_get_coupon_direct_reduce));
    L74:
        LiveCouponPriceView r142 = r128.f119644g;
        if (r142 == null) goto L77;
        r142.setPriceText(r140);
    L77:
        LiveCouponPriceView r143 = r128.f119644g;
        if (r143 == null) goto L84;
        Context r144 = r128.f119639b;
        if (r140.length() < 6) goto L83;
        r134 = 24.0f;
    L83:
        float r145 = UIUtils.dip2Px(r144, r134);
        float r146 = UIUtils.dip2Px(r128.f119639b, 17.0f);
        r143.f119573k = r145;
        r143.f119564b.setTextSize(r145);
        r143.f119565c.setTextSize(r146);
        r143.requestLayout();
        r143.invalidate();
    L84:
        r128.b(r103);
        goto L102
    L86:
        if (r133 != 3) goto L102;
        String r147 = o.a(String.valueOf(r103.credit / 100.0f));
        TextView r148 = r128.f119643f;
        if (r148 == null) goto L91;
        r148.setText(s1.C(R.string.ttlive_live_get_coupon_full, new Object[]{o.a(String.valueOf(r103.threshold / 100.0f))}));
    L91:
        LiveCouponPriceView r149 = r128.f119644g;
        if (r149 == null) goto L94;
        r149.setPriceText(r147);
    L94:
        LiveCouponPriceView r150 = r128.f119644g;
        if (r150 == null) goto L101;
        Context r151 = r128.f119639b;
        if (r147.length() < 6) goto L100;
        r134 = 24.0f;
    L100:
        float r152 = UIUtils.dip2Px(r151, r134);
        float r153 = UIUtils.dip2Px(r128.f119639b, 17.0f);
        r150.f119573k = r152;
        r150.f119564b.setTextSize(r152);
        r150.f119565c.setTextSize(r153);
        r150.requestLayout();
        r150.invalidate();
    L101:
        r128.b(r103);
        goto L147
    L35:
        if (r108.activityType != 1) goto L37;
        boolean r154 = true;
    L38:
        if (r154 == true) goto L41;
        r108 = null;
    L41:
        if (r108 == null) goto L45;
        r109 = r108.afterButton;
        if (r109 == null) goto L45;
    L37:
        r154 = false;
        goto L38
    L21:
        if (r105.activityType != 1) goto L23;
        boolean r155 = true;
    L24:
        if (r155 == true) goto L27;
        r105 = null;
    L27:
        if (r105 == null) goto L31;
        r106 = r105.afterText;
        if (r106 == null) goto L31;
    L23:
        r155 = false;
    L155:
        r101 = "coupon_result";
    L158:
        if (r311 == false) goto L166;
        if (r310 == null) goto L162;
        String r156 = r310.d();
        if (r156 == null) goto L162;
    L164:
        if (TextUtils.isEmpty(r156) == false) goto L170;
        r156 = s1.B(R.string.ttlive_live_get_coupon_fail);
    L170:
        r210.f0(r156, r311);
        i0("livesdk_coupon_result", new String[]{"coupon_result", "0"});
        return;
    L162:
        r156 = "";
        goto L164
    L166:
        LiveCouponView r157 = r210.f119550h;
        if (r157 == null) goto L169;
        r157.f119595m = 0;
    L169:
        r156 = s1.B(R.string.ttlive_live_get_coupon_fail_network);
        goto L170
    L6:
        r100 = false;
        goto L8
    L7:
        r100 = true;
        goto L8
    }

    public static final void d0(LiveCouponPresenter r100, String r101, Integer r102, String... r103) {
        r100.getClass();
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L19
        int r105 = 0;
        int r106 = 1;
        if (r103.length != 0) goto L6;
        boolean r107 = true;
    L8:
        if ((!r107) == true) goto L10;
    L14:
        IHostMonitor r108 = TTLiveSDK.hostService().monitor();     // Catch: Exception -> L19
        if (r102 == null) goto L17;
        r106 = r102.intValue();     // Catch: Exception -> L19
    L17:
        r108.monitorStatusRate(r101, r106, r104);     // Catch: Exception -> L19
        return;
    L10:
        if ((r103.length % 2) != 0) goto L14;
    L12:
        if (r105 >= r103.length) goto L14;
        r104.put(r103[r105], r103[r105 + 1]);     // Catch: Exception -> L19
        r105 = r105 + 2;     // Catch: Exception -> L19
        goto L12
    L6:
        r107 = false;
    }
}
