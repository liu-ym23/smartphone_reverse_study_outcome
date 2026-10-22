package com.bytedance.android.live.network.impl.interceptor;

import android.app.Activity;
import android.app.Dialog;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.RequestError;
import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdk.recharge.model.RechargeVerifyTraceStep;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class u implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Dialog f83894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f83895b = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f83896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t80.a f83897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f83898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f83899d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef f83900e;

        public a(Activity r100, t80.a r101, int r102, Ref.ObjectRef r103, Ref.ObjectRef r104) {
            this.f83896a = r100;
            this.f83897b = r101;
            this.f83898c = r102;
            this.f83899d = r103;
            this.f83900e = r104;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Integer r101 = (Integer) r100;
            String r102 = s1.B(R.string.ttlive_facedetect_notice);
            Dialog r103 = u.f83894a;
            Activity r104 = this.f83896a;
            c9.b r105 = new c9.b();
            r105.f112681a = r104;
            r105.f112682b = 2;
            r105.f112685e = s1.B(R.string.ttlive_warm_prompt);
            r105.f112686f = r102;
            r105.f112687g = 17;
            String r106 = s1.B(R.string.ttlive_cancel);
            s r107 = new s(this);
            r105.f112690j = r106;
            r105.f112691k = r107;
            String r108 = s1.B(R.string.ttlive_navigate_to_check);
            t r109 = new t(this);
            r105.f112692l = r108;
            r105.f112693m = r109;
            r105.f112696p = false;
            r105.f112697q = false;
            c9 r110 = new c9(r105.f112681a, r105);
            if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L10;
            DialogLancet.handleBlockedDialogShow(r110);
        L7:
            u.f83894a = r110;
            return;
        L10:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
        L6:
            DialogLancet.beforeDialogShow(r110);
            r110.show();
            DialogLancet.afterDialogShow(r110);
            goto L7
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f83901a = null;

        static {
            f83901a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
        }
    }

    public u() {
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final void c(String r100, ExtraResponse r101) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
    }

    static {
        f83895b = new u();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean d(int r100, RequestError r110, t80.a r111) {
        if (r100 == 4005178) goto L7;
        if (r100 == 4005177) goto L7;
        return false;
    L7:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        r101.element = "";
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        r102.element = "";
        if (r100 != 4005178) goto L10;
        r101.element = "coin_exchange_two_element";
        r102.element = "verify_two_element";
    L10:
        if (r100 != 4005177) goto L12;
        r101.element = "coin_exchange_face";
        r102.element = "webcast_risk_auth";
    L12:
        Activity r103 = ((IHostApp) jc1.k.n(IHostApp.class)).getCurrentActivity();
        if (r103 != null) goto L16;
        return false;
    L16:
        if (r110 == null) goto L18;
        r110.setBlockNotice(true);
    L18:
        Dialog r104 = f83894a;
        if (r104 != null) goto L21;
    L23:
        int r105 = do0.a.f469399a;
        RechargeVerifyTraceStep r106 = RechargeVerifyTraceStep.STEP_RECHARGE_COMMON_VERIFY_START;
        String r107 = (String) r101.element;
        String r108 = (String) r102.element;
        if (r110 == null) goto L26;
        String r112 = r110.url;
    L27:
        do0.a.b(r106, r100, r107, r108, r112);
        Observable.just(0).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r103, r111, r100, r101, r102), b.f83901a);
        return true;
    L26:
        r112 = null;
        goto L27
    L21:
        if (r104.isShowing() != true) goto L23;
        return true;
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final boolean b(int r100, com.bytedance.android.live.network.response.c r101, RequestError r102) {
        Intrinsics.checkNotNullParameter(r101, "response");
        Intrinsics.checkNotNullParameter("live_detail", "requestPage");
        return d(r100, r102, null);
    }

    @Override // com.bytedance.android.live.network.impl.interceptor.q
    public final boolean a(String r100, int r101, BaseResponse<?, ?> r102, String r103, RequestError r104) {
        Intrinsics.checkNotNullParameter(r102, "response");
        Intrinsics.checkNotNullParameter(r103, "requestPage");
        return d(r101, r104, null);
    }
}
