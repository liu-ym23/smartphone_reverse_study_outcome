package com.bytedance.android.livesdk.livecommerce.room.widgets.coupon;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.livecommerce.utils.o0;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import th.a;
import yd.c;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR.\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/BaseIconTemplate;", "Landroid/widget/FrameLayout;", "Lyd/c;", "Lcom/bytedance/android/livesdkapi/room/handler/viewinterface/sti/IExternalIconTemplate;", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/SquircleIconContent;", "c", "Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/SquircleIconContent;", "getContentContainer", "()Lcom/bytedance/android/livesdk/livecommerce/room/widgets/coupon/SquircleIconContent;", "contentContainer", "", "value", "d", "Ljava/lang/String;", "getSuperscript", "()Ljava/lang/String;", "setSuperscript", "(Ljava/lang/String;)V", "superscript", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseIconTemplate extends FrameLayout implements c, IExternalIconTemplate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f152071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f152072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SquircleIconContent f152073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f152074d;

    public BaseIconTemplate(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseIconTemplate(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // yd.c, com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate
    public View getView() {
        return this;
    }

    public final SquircleIconContent getContentContainer() {
        return this.f152073c;
    }

    public final String getSuperscript() {
        return this.f152074d;
    }

    @Override // yd.c, com.bytedance.android.livesdkapi.room.handler.viewinterface.sti.IExternalIconTemplate
    public final Animator getEntryAnimation(long r110) {
        this.f152073c.setScaleX(0.0f);
        this.f152073c.setScaleY(0.0f);
        this.f152071a.setAlpha(0.0f);
        this.f152072b.setAlpha(0.0f);
        SquircleIconContent r100 = this.f152073c;
        float[] r101 = {1.0f};
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "values");
        AnimatorSet r102 = new AnimatorSet();
        r102.playTogether(new Animator[]{ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_X, Arrays.copyOf(r101, 1)), ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.SCALE_Y, Arrays.copyOf(r101, 1))});
        r102.setDuration(250);
        r102.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator r103 = ObjectAnimator.ofFloat(this.f152071a, "alpha", new float[]{1.0f});
        r103.setDuration(200);
        r103.setStartDelay(400);
        r103.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this.f152072b, "alpha", new float[]{1.0f});
        r104.setDuration(200);
        r104.setStartDelay(400);
        r104.setInterpolator(new DecelerateInterpolator());
        AnimatorSet r105 = new AnimatorSet();
        r105.setStartDelay(r110);
        r105.play(r103).with(r104).after(r102);
        return r105;
    }

    public final void setSuperscript(String r100) {
        this.f152074d = r100;
        if (r100 != null) goto L5;
        this.f152072b.setVisibility(8);
        return;
    L5:
        this.f152072b.setText(r100);
        this.f152072b.setVisibility(0);
    }

    public BaseIconTemplate(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        SquircleIconContent r103 = new SquircleIconContent(r100, null, 6, 0);
        addView(r103);
        Unit r104 = Unit.INSTANCE;
        o0.f(r103, -1);
        o0.d(r103, -1);
        this.f152073c = r103;
        TextView r105 = new TextView(r100);
        addView(r105);
        o0.f(r105, UtilityKotlinExtentionsKt.d(30));
        o0.d(r105, UtilityKotlinExtentionsKt.d(10));
        o0.c(r105, 81);
        r105.setGravity(17);
        r105.setBackgroundDrawable(ContextCompat.getDrawable(r100, R.drawable.ec_sti_label_bg));
        r105.setTextColor(-1);
        r105.setTextSize(1, 8.0f);
        r105.setIncludeFontPadding(false);
        r105.setVisibility(8);
        this.f152071a = r105;
        TextView r106 = new TextView(r100);
        addView(r106);
        o0.f(r106, -2);
        o0.d(r106, UtilityKotlinExtentionsKt.d(12));
        r106.setMinWidth(UtilityKotlinExtentionsKt.d(12));
        r106.setPadding(UtilityKotlinExtentionsKt.d(2), 0, UtilityKotlinExtentionsKt.d(2), 0);
        o0.c(r106, 53);
        r106.setGravity(17);
        r106.setBackground(ContextCompat.getDrawable(r100, R.drawable.ec_sti_superscript_bg));
        r106.setTextColor(a.a(r100, R.color.shopping_std_brand));
        r106.setTextSize(1, 9.0f);
        r106.setIncludeFontPadding(false);
        r106.setVisibility(8);
        r106.setImportantForAccessibility(2);
        this.f152072b = r106;
    }

    public /* synthetic */ BaseIconTemplate(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
