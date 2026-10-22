package com.bytedance.android.livesdk.coupon.expandcoupon;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.ui.GradientTextView;
import com.bytedance.android.livesdk.widget.CommonBottomDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/coupon/expandcoupon/ExpandCouponEnterRoomDialog;", "Lcom/bytedance/android/livesdk/widget/CommonBottomDialog;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class ExpandCouponEnterRoomDialog extends CommonBottomDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f121870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f121871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public GradientTextView f121872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f121873d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public GradientTextView f121874e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Button f121875f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f121876g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GradientTextView f121877h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GradientTextView f121878i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f121879j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int[] f121880k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final f f121881l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final com.bytedance.android.livesdk.coupon.expandcoupon.model.a f121882m;

    public static final class a {
    }

    public interface b {
        void a();

        void b();

        void c();
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandCouponEnterRoomDialog f121883a;

        public c(ExpandCouponEnterRoomDialog r100) {
            this.f121883a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f121883a.f121876g;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public static final class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandCouponEnterRoomDialog f121884a;

        public d(ExpandCouponEnterRoomDialog r100) {
            this.f121884a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f121884a.f121876g;
            if (r101 == null) goto L6;
            r101.c();
            return;
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandCouponEnterRoomDialog f121885a;

        public e(ExpandCouponEnterRoomDialog r100) {
            this.f121885a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f121885a.f121876g;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    public static final class f implements GradientTextView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ExpandCouponEnterRoomDialog f121886a;

        public f(ExpandCouponEnterRoomDialog r100) {
            this.f121886a = r100;
        }

        @Override // com.bytedance.android.live.ui.GradientTextView.a
        public final LinearGradient a(int r100, int r110) {
            return new LinearGradient(0.0f, 0.0f, 0.0f, r110, this.f121886a.f121880k, null, Shader.TileMode.CLAMP);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog
    public final int getLayoutId() {
        return R.layout.ttlive_expand_coupon_enter_room_dialog;
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
    L17:
        this.f121876g = null;
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        com.bytedance.crash.d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
        goto L17
    }

    @Override // com.bytedance.android.livesdk.widget.CommonBottomDialog, com.bytedance.android.livesdk.widget.LiveBottomSheetDialog, androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        this.f121870a = (TextView) findViewById(R.id.tv_coupon_title);
        this.f121871b = (TextView) findViewById(R.id.tv_grow_ago_coupon_info);
        this.f121872c = (GradientTextView) findViewById(R.id.tv_grow_ago_coupon_num);
        this.f121873d = (TextView) findViewById(R.id.tv_grow_after_coupon_info);
        this.f121874e = (GradientTextView) findViewById(R.id.tv_grow_after_coupon_num);
        this.f121875f = (Button) findViewById(R.id.btn_direct_exit_room);
        this.f121877h = (GradientTextView) findViewById(R.id.tv_grow_ago_coupon_prefix);
        this.f121878i = (GradientTextView) findViewById(R.id.tv_grow_after_coupon_prefix);
        this.f121879j = findViewById(R.id.blank_area_view);
        Button r111 = this.f121875f;
        if (r111 == null) goto L5;
        r111.setOnClickListener(new c(this));
    L5:
        Button r112 = (Button) findViewById(R.id.btn_coupon_grow);
        if (r112 == null) goto L8;
        r112.setOnClickListener(new d(this));
    L8:
        View r113 = this.f121879j;
        if (r113 == null) goto L11;
        r113.setOnClickListener(new e(this));
    L11:
        TextView r114 = this.f121870a;
        if (r114 != null) goto L14;
    L21:
        GradientTextView r115 = this.f121877h;
        if (r115 == null) goto L24;
        r115.setLinearGradientCreator(this.f121881l);
    L24:
        GradientTextView r116 = this.f121878i;
        if (r116 == null) goto L27;
        r116.setLinearGradientCreator(this.f121881l);
    L27:
        GradientTextView r117 = this.f121872c;
        if (r117 == null) goto L30;
        r117.setLinearGradientCreator(this.f121881l);
    L30:
        GradientTextView r118 = this.f121874e;
        if (r118 == null) goto L33;
        r118.setLinearGradientCreator(this.f121881l);
    L33:
        TextView r119 = this.f121871b;
        if (r119 == null) goto L36;
        com.bytedance.android.livesdk.coupon.util.a r100 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r101 = this.f121882m.f121896b;
        r100.getClass();
        r119.setText(LiveResUtil.getString(R.string.ttlive_expand_coupon_threshold_text, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r101)}));
    L36:
        GradientTextView r120 = this.f121872c;
        if (r120 == null) goto L39;
        com.bytedance.android.livesdk.coupon.util.a r102 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r103 = this.f121882m.f121895a;
        r102.getClass();
        r120.setText(com.bytedance.android.livesdk.coupon.util.a.a(r103));
    L39:
        TextView r121 = this.f121873d;
        if (r121 == null) goto L42;
        com.bytedance.android.livesdk.coupon.util.a r104 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r105 = this.f121882m;
        long r106 = r105.f121896b + r105.f121898d.b();
        r104.getClass();
        r121.setText(LiveResUtil.getString(R.string.ttlive_expand_coupon_threshold_text, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r106)}));
    L42:
        GradientTextView r122 = this.f121874e;
        if (r122 == null) goto L45;
        com.bytedance.android.livesdk.coupon.util.a r107 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r108 = this.f121882m;
        long r109 = r108.f121895a + r108.f121898d.c();
        r107.getClass();
        r122.setText(com.bytedance.android.livesdk.coupon.util.a.a(r109));
    L45:
        Button r123 = this.f121875f;
        if (r123 == null) goto L51;
        com.bytedance.android.livesdk.coupon.util.a r124 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r125 = this.f121882m.f121895a;
        r124.getClass();
        r123.setText(LiveResUtil.getString(R.string.ttlive_expand_coupon_direct_obtain_text, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r125)}));
        return;
    L51:
        return;
    L14:
        if (this.f121882m.f121897c == 1) goto L49;
    L19:
        SpannableStringBuilder r126 = null;
    L20:
        r114.setText(r126);
        goto L21
    L49:
        r126 = new SpannableStringBuilder();     // Catch: Throwable -> L17
        int r127 = LiveResUtil.getColor(R.color.ttlive_color_FE2C55);     // Catch: Throwable -> L17
        r126.append("观看直播间");     // Catch: Throwable -> L17
        int r128 = r126.length();     // Catch: Throwable -> L17
        r126.append(String.valueOf(this.f121882m.f121898d.a()) + "秒\n");     // Catch: Throwable -> L17
        r126.setSpan(new ForegroundColorSpan(r127), r128, r126.length(), 33);     // Catch: Throwable -> L17
        r126.append("优惠券金额可膨胀至");     // Catch: Throwable -> L17
        int r129 = r126.length();     // Catch: Throwable -> L17
        StringBuilder r130 = new StringBuilder();     // Catch: Throwable -> L17
        com.bytedance.android.livesdk.coupon.util.a r131 = com.bytedance.android.livesdk.coupon.util.a.f121922a;     // Catch: Throwable -> L17
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r132 = this.f121882m;     // Catch: Throwable -> L17
        long r133 = r132.f121895a + r132.f121898d.c();     // Catch: Throwable -> L17
        r131.getClass();     // Catch: Throwable -> L17
        r130.append(com.bytedance.android.livesdk.coupon.util.a.a(r133));     // Catch: Throwable -> L17
        r130.append("元");     // Catch: Throwable -> L17
        r126.append(r130.toString());     // Catch: Throwable -> L17
        r126.setSpan(new ForegroundColorSpan(r127), r129, r126.length(), 33);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        ALogger.e("ExpandCouponDialog", "createTimeTaskTitle Error. " + Log.getStackTraceString(th));
        goto L19
    }

    public ExpandCouponEnterRoomDialog(Context r100, com.bytedance.android.livesdk.coupon.expandcoupon.model.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "couponData");
        super(r100, R.style.ttlive_expand_coupon_dialog);
        this.f121882m = r101;
        this.f121880k = new int[]{LiveResUtil.getColor(R.color.ttlive_expand_coupon_value_gradient_start), LiveResUtil.getColor(R.color.ttlive_expand_coupon_value_gradient_middle), LiveResUtil.getColor(R.color.ttlive_expand_coupon_value_gradient_end)};
        this.f121881l = new f(this);
    }
}
