package com.android.ttcjpaysdk.base.ui.widget;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.base.ktextension.CJPayBasicExtensionKt;
import com.bytedance.caijing.sdk.infra.base.api.fresco.FrescoGifService;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vd4.b;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\u0018\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H\u0014J\u0018\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"H\u0002J\u000e\u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020%R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/android/ttcjpaysdk/base/ui/widget/CJPayFollowNameView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "avatarContainer", "Landroid/widget/FrameLayout;", "followAvatar", "Landroid/widget/ImageView;", "imgService", "Lcom/bytedance/caijing/sdk/infra/base/api/fresco/FrescoGifService;", "getImgService", "()Lcom/bytedance/caijing/sdk/infra/base/api/fresco/FrescoGifService;", "imgService$delegate", "Lkotlin/Lazy;", "tvLeft", "Landroid/widget/TextView;", "tvRight", "bindData", "", "leftStr", "", "iconUrl", "rightStr", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAddiUIStyle", "textColor", "textSize", "", "setStyle", "type", "Lcom/android/ttcjpaysdk/base/ui/widget/FollowNameType;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayFollowNameView extends ConstraintLayout {
    private final FrameLayout avatarContainer;
    private final ImageView followAvatar;
    private final Lazy imgService$delegate;
    private final TextView tvLeft;
    private final TextView tvRight;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[FollowNameType.values().length];
            r100[FollowNameType.ADDI_WITH_VOUCHER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[FollowNameType.RETAIN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[FollowNameType.ADDI.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[FollowNameType.ADDI_NOT_CHOOSE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[FollowNameType.ADDI_OPT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public CJPayFollowNameView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 0, 6, null);
    }

    public CJPayFollowNameView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0, 4, null);
    }

    private final FrescoGifService getImgService() {
        return (FrescoGifService) this.imgService$delegate.getValue();
    }

    public static final /* synthetic */ ImageView access$getFollowAvatar$p(CJPayFollowNameView r100) {
        return r100.followAvatar;
    }

    public final void setStyle(FollowNameType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r101 != 1) goto L5;
        TextView r102 = this.tvRight;
        if (r102 == null) goto L25;
        r102.setTextColor(ContextCompat.getColor(getContext(), R.color.cj_pay_color_gold_B27C3F));
    L25:
        TextView r103 = this.tvLeft;
        if (r103 == null) goto L34;
        r103.setTextColor(ContextCompat.getColor(getContext(), R.color.cj_pay_color_gold_B27C3F));
        return;
    L34:
        return;
    L5:
        if (r101 != 2) goto L7;
        TextView r104 = this.tvRight;
        if (r104 == null) goto L19;
        r104.setTextColor(ContextCompat.getColor(getContext(), R.color.cj_pay_color_gray_161823_opacity_60));
    L19:
        TextView r105 = this.tvLeft;
        if (r105 == null) goto L32;
        r105.setTextColor(ContextCompat.getColor(getContext(), R.color.cj_pay_color_gray_161823_opacity_60));
        return;
    L32:
        return;
    L7:
        if (r101 != 3) goto L9;
        setAddiUIStyle(R.color.cj_pay_color_black_161823, 14.0f);
        return;
    L9:
        if (r101 != 4) goto L11;
        setAddiUIStyle(R.color.cj_pay_color_gray_161823_opacity_34, 14.0f);
        return;
    L11:
        if (r101 != 5) goto L35;
        setAddiUIStyle(R.color.cj_pay_color_gray_161823_opacity_75, 13.0f);
        return;
    }

    private final void setAddiUIStyle(int r100, float r101) {
        FrameLayout r102 = this.avatarContainer;
        if (r102 == null) goto L7;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 == null) goto L7;
        r103.height = CJPayBasicExtensionKt.dp(18);
        r103.width = CJPayBasicExtensionKt.dp(23);
    L7:
        ImageView r104 = this.followAvatar;
        if (r104 == null) goto L12;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if (r105 == null) goto L12;
        r105.height = CJPayBasicExtensionKt.dp(18);
        r105.width = CJPayBasicExtensionKt.dp(18);
    L12:
        int r106 = ContextCompat.getColor(getContext(), r100);
        TextView r107 = this.tvLeft;
        if (r107 == null) goto L16;
        r107.setTextSize(r101);
    L16:
        TextView r108 = this.tvLeft;
        if (r108 == null) goto L19;
        r108.setTextColor(r106);
    L19:
        TextView r109 = this.tvRight;
        if (r109 == null) goto L23;
        r109.setTextSize(r101);
    L23:
        TextView r110 = this.tvRight;
        if (r110 == null) goto L27;
        r110.setTextColor(r106);
        return;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int r100, int r101) {
        TextView r102 = this.tvLeft;
        if (r102 == null) goto L7;
        TextPaint r103 = r102.getPaint();
        if (r103 == null) goto L7;
        float r104 = r103.measureText(this.tvLeft.getText().toString());
    L8:
        TextView r105 = this.tvRight;
        if (r105 == null) goto L13;
        TextPaint r106 = r105.getPaint();
        if (r106 == null) goto L13;
        float r107 = r106.measureText(this.tvRight.getText().toString());
    L14:
        FrameLayout r108 = this.avatarContainer;
        if (r108 == null) goto L17;
        int r109 = r108.getMeasuredWidth();
    L18:
        float r110 = r109;
        float r111 = (r107 + r104) + r110;
        float r112 = View.MeasureSpec.makeMeasureSpec(r100, 0);
        if (r111 <= r112) goto L30;
        float r113 = (r112 - r104) - r110;
        if (r113 <= 0.0f) goto L30;
        TextView r114 = this.tvRight;
        if (r114 == null) goto L26;
        r114.setMaxWidth((int) r113);
    L26:
        TextView r115 = this.tvRight;
        if (r115 == null) goto L30;
        r115.setGravity(3);
    L30:
        super.onMeasure(r100, r101);
        return;
    L17:
        r109 = 0;
    L13:
        r107 = 0.0f;
    L7:
        r104 = 0.0f;
        goto L8
    }

    public CJPayFollowNameView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.imgService$delegate = LazyKt.lazy(CJPayFollowNameView$imgService$2.INSTANCE);
        LayoutInflater.from(r100).inflate(R.layout.cj_pay_follow_with_avatar_and_name, this, true);
        FrameLayout r103 = (FrameLayout) findViewById(R.id.follow_avatar_container);
        this.avatarContainer = r103;
        this.tvRight = (TextView) findViewById(R.id.follow_right_tv);
        this.tvLeft = (TextView) findViewById(R.id.follow_left_tv);
        ImageView r104 = getImgService().getSimpleDraweeView(r100);
        this.followAvatar = r104;
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(CJPayBasicExtensionKt.dp(14), CJPayBasicExtensionKt.dp(14));
        r105.leftMargin = CJPayBasicExtensionKt.dp(2);
        if (r103 == null) goto L6;
        r103.addView(r104, 0, r105);
        return;
    }

    public final void bindData(String r100, String r101, String r102) {
        TextView r103 = this.tvLeft;
        if (r103 == null) goto L6;
        r103.setText(r100);
    L6:
        TextView r104 = this.tvRight;
        if (r104 == null) goto L10;
        r104.setText(r102);
    L10:
        b r105 = new CJPayFollowNameView$bindData$imageListener$1(this);
        if (r101 != null) goto L13;
        return;
    L13:
        if (this.followAvatar == null) goto L17;
        getImgService().loadCircleImage(this.followAvatar, r101, getContext().getResources().getDrawable(R.drawable.cj_pay_follow_avatar_default), r105);
        return;
    }

    public /* synthetic */ CJPayFollowNameView(Context r100, AttributeSet r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 4) == 0) goto L8;
        r102 = 0;
    L8:
        this(r100, r101, r102);
    }
}
