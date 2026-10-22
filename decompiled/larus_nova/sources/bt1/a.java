package bt1;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.ui.GradientTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f20492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f20493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Button f20494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f20495d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int[] f20496e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.coupon.expandcoupon.model.a f20497f;

    /* JADX INFO: renamed from: bt1.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0358a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f20498a;

        public ViewOnClickListenerC0358a(a r100) {
            this.f20498a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            g r101 = this.f20498a.f20495d;
            if (r101 == null) goto L6;
            r101.b();
            return;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f20499a;

        public b(a r100) {
            this.f20499a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            g r101 = this.f20499a.f20495d;
            if (r101 == null) goto L6;
            r101.c();
            return;
        }
    }

    public static final class c implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f20500a;

        public c(a r100) {
            this.f20500a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            g r101 = this.f20500a.f20495d;
            if (r101 == null) goto L6;
            r101.a();
            return;
        }
    }

    public static final class d {
    }

    public static final class e implements GradientTextView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f20501a;

        public e(a r100) {
            this.f20501a = r100;
        }

        @Override // com.bytedance.android.live.ui.GradientTextView.a
        public final LinearGradient a(int r100, int r110) {
            return new LinearGradient(0.0f, 0.0f, 0.0f, r110, this.f20501a.f20496e, null, Shader.TileMode.CLAMP);
        }
    }

    static {
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        com.bytedance.android.livesdk.f.d().a();
    }

    @Override // android.app.Dialog
    public final void onStop() {
        super.onStop();
        this.f20495d = null;
        com.bytedance.android.livesdk.f.d().f();
    }

    public final void a(long r110) {
        TextView r100 = this.f20493b;
        int r101 = LiveResUtil.getColor(R.color.ttlive_color_FE2C55);     // Catch: Throwable -> L5
        SpannableStringBuilder r102 = new SpannableStringBuilder();     // Catch: Throwable -> L5
        r102.append("就剩");     // Catch: Throwable -> L5
        int r103 = r102.length();     // Catch: Throwable -> L5
        r102.append(String.valueOf(r110) + "秒");     // Catch: Throwable -> L5
        r102.setSpan(new ForegroundColorSpan(r101), r103, r102.length(), 33);     // Catch: Throwable -> L5
        r102.append("即可膨胀为");     // Catch: Throwable -> L5
        int r111 = r102.length();     // Catch: Throwable -> L5
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.coupon.util.a r104 = com.bytedance.android.livesdk.coupon.util.a.f121922a;     // Catch: Throwable -> L5
        com.bytedance.android.livesdk.coupon.expandcoupon.model.a r105 = this.f20497f;     // Catch: Throwable -> L5
        long r106 = r105.f121895a + r105.f121898d.c();     // Catch: Throwable -> L5
        r104.getClass();     // Catch: Throwable -> L5
        r112.append(com.bytedance.android.livesdk.coupon.util.a.a(r106));     // Catch: Throwable -> L5
        r112.append("元");     // Catch: Throwable -> L5
        r102.append(r112.toString());     // Catch: Throwable -> L5
        r102.setSpan(new ForegroundColorSpan(r101), r111, r102.length(), 33);     // Catch: Throwable -> L5
    L7:
        r100.setText(r102);
        return;
    L5:
        th = move-exception;
        ALogger.e("ExpandCouponCloseRoomDialog", "createCouponTitle error " + Log.getStackTraceString(th));
        r102 = null;
        goto L7
    }

    public a(Context r110, com.bytedance.android.livesdk.coupon.expandcoupon.model.a r111, long r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "couponData");
        super(r110, R.style.ttlive_expand_coupon_close_room_dialog);
        this.f20497f = r111;
        View r100 = LayoutInflater.from(r110).inflate(R.layout.ttlive_expand_coupon_close_room_dialog, null);
        this.f20492a = r100;
        this.f20493b = (TextView) r100.findViewById(R.id.tv_coupon_title);
        Button r101 = (Button) r100.findViewById(R.id.btn_direct_exit_room);
        Button r102 = (Button) r100.findViewById(R.id.continue_watch_or_use_btn);
        this.f20494c = r102;
        TextView r103 = (TextView) r100.findViewById(R.id.tv_grow_ago_coupon_info);
        TextView r104 = (TextView) r100.findViewById(R.id.tv_grow_after_coupon_info);
        GradientTextView r105 = (GradientTextView) r100.findViewById(R.id.tv_grow_ago_coupon_prefix);
        GradientTextView r106 = (GradientTextView) r100.findViewById(R.id.tv_grow_after_coupon_prefix);
        GradientTextView r107 = (GradientTextView) r100.findViewById(R.id.tv_grow_ago_coupon_num);
        GradientTextView r113 = (GradientTextView) r100.findViewById(R.id.tv_grow_after_coupon_num);
        this.f20496e = new int[]{LiveResUtil.getColor(R.color.ttlive_expand_coupon_value_gradient_start), LiveResUtil.getColor(R.color.ttlive_expand_coupon_value_gradient_middle), LiveResUtil.getColor(R.color.ttlive_expand_coupon_value_gradient_end)};
        e r114 = new e(this);
        setContentView(r100);
        r102.setOnClickListener(new ViewOnClickListenerC0358a(this));
        r101.setOnClickListener(new b(this));
        setOnCancelListener(new c(this));
        com.bytedance.android.livesdk.coupon.util.a r108 = com.bytedance.android.livesdk.coupon.util.a.f121922a;
        long r115 = r111.f121896b;
        r108.getClass();
        r103.setText(LiveResUtil.getString(R.string.ttlive_expand_coupon_threshold_text, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r115)}));
        r104.setText(LiveResUtil.getString(R.string.ttlive_expand_coupon_threshold_text, new Object[]{com.bytedance.android.livesdk.coupon.util.a.a(r111.f121896b + r111.f121898d.b())}));
        r105.setLinearGradientCreator(r114);
        r106.setLinearGradientCreator(r114);
        r107.setLinearGradientCreator(r114);
        r113.setLinearGradientCreator(r114);
        r107.setText(com.bytedance.android.livesdk.coupon.util.a.a(r111.f121895a));
        r113.setText(com.bytedance.android.livesdk.coupon.util.a.a(r111.f121895a + r111.f121898d.c()));
        a(r112);
    }
}
