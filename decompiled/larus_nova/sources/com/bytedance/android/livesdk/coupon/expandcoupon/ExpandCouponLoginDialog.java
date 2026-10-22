package com.bytedance.android.livesdk.coupon.expandcoupon;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import bt1.h;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.coupon.expandcoupon.model.e;
import com.bytedance.android.livesdk.user.f;
import com.bytedance.android.livesdk.user.l;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.bytedance.crash.d;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.functions.Consumer;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/expandcoupon/ExpandCouponLoginDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class ExpandCouponLoginDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f121887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f121888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Button f121889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f121890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f121891e;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandCouponLoginDialog f121892a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.coupon.expandcoupon.ExpandCouponLoginDialog$a$a, reason: collision with other inner class name */
        public static final class C1773a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f121893a;

            public C1773a(a r100) {
                this.f121893a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                IBaseUser r101 = (IBaseUser) r100;
                h r102 = this.f121893a.f121892a.f121890d;
                if (r102 == null) goto L5;
                r102.onSuccess();
            L5:
                this.f121893a.f121892a.f121890d = null;
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f121894a;

            public b(a r100) {
                this.f121894a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                h r102 = this.f121894a.f121892a.f121890d;
                if (r102 == null) goto L5;
                r102.onFail();
            L5:
                this.f121894a.f121892a.f121890d = null;
            }
        }

        public a(ExpandCouponLoginDialog r100) {
            this.f121892a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            IUserService r101 = (IUserService) k.f(IUserService.class);
            if (r101 == null) goto L5;
            f r102 = r101.user();
        L6:
            if (r102 == null) goto L8;
            l.a r103 = new l.a();
            r103.f158688d = "expand_coupon";
            r103.f158687c = -1;
            l r104 = new l(r103);
            r102.login(this.f121892a.getContext(), r104).subscribe(new C1773a(this), new b(this));
        L8:
            ExpandCouponLoginDialog r105 = this.f121892a;
            Handler r106 = DialogLancet.resolveDialogHandler(r105);
            if (r106 != null) goto L11;
        L13:
            DialogLancet.beforeDialogDismiss(r105);
            r105.dismiss();     // Catch: Throwable -> L16 Exception -> L18
        L22:
            DialogLancet.afterDialogDismiss(r105);
            return;
        L18:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
            Throwable r107 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
            if (r107 == null) goto L22;
            d.d(r107, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r105);
            throw th;
        L11:
            if (Looper.myLooper() == r106.getLooper()) goto L13;
            r106.post(DialogLancet.createDismissRunnable(r105));
            return;
        L5:
            r102 = null;
            goto L6
        }
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_expand_coupon_login_dialog;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f121887a = (TextView) findViewById(R.id.expand_coupon_info);
        this.f121888b = (TextView) findViewById(R.id.expand_coupon_num);
        this.f121889c = (Button) findViewById(R.id.expand_coupon_auth_confirm_btn);
        TextView r101 = this.f121887a;
        if (r101 == null) goto L5;
        com.bytedance.android.livesdk.coupon.util.a r102 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r103 = this.f121891e.c();
        r102.getClass();
        r101.setText(LiveResUtil.getString(R.string.ttlive_expand_coupon_threshold_text, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r103)}));
    L5:
        TextView r104 = this.f121888b;
        if (r104 == null) goto L8;
        com.bytedance.android.livesdk.coupon.util.a r105 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r106 = this.f121891e.d();
        r105.getClass();
        r104.setText(com.bytedance.android.livesdk.coupon.util.a.a(r106));
    L8:
        Button r107 = this.f121889c;
        if (r107 == null) goto L12;
        r107.setOnClickListener(new a(this));
        return;
    }

    public ExpandCouponLoginDialog(Context r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "couponInfo");
        super(r100, R.style.ttlive_expand_coupon_dialog);
        this.f121891e = r101;
    }
}
