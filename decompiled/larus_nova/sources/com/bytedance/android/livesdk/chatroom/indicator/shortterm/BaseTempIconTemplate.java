package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

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
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.live.core.setting.b5;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature;
import com.bytedance.android.livesdkapi.sti.framework.IconTemplate;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR.\u0010$\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R.\u0010(\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b%\u0010\u001f\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u0010.\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020-8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u00102\u001a\u00020-2\u0006\u0010\u001d\u001a\u00020-8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b2\u0010/\"\u0004\b3\u00101¨\u0006<"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/BaseTempIconTemplate;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/livesdkapi/sti/framework/IconTemplate;", "Lcom/bytedance/android/livesdkapi/sti/framework/ICommonTemplateFeature;", "", "alpha", "", "setTemplateAlpha", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getLabelView", "()Landroid/widget/TextView;", "labelView", "b", "getSuperscriptView", "superscriptView", "Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/TempIconContent;", "c", "Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/TempIconContent;", "getMContentContainer", "()Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/TempIconContent;", "mContentContainer", "d", "Landroid/widget/FrameLayout;", "getIconOnlyFrameLayout", "()Landroid/widget/FrameLayout;", "iconOnlyFrameLayout", "", "value", "e", "Ljava/lang/String;", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "label", "f", "getSuperscript", "setSuperscript", "superscript", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "", "isMaskEnabled", "()Z", "setMaskEnabled", "(Z)V", "isBackgroundEnabled", "setBackgroundEnabled", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseTempIconTemplate extends FrameLayout implements IconTemplate, ICommonTemplateFeature {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f106524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f106525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TempIconContent f106526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f106527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f106528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f106529f;

    public BaseTempIconTemplate(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseTempIconTemplate(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IconTemplate
    public View getView() {
        return this;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public final boolean isMaskEnabled() {
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public final boolean isBackgroundEnabled() {
        return this.f106526c.f106542a;
    }

    public final FrameLayout getIconOnlyFrameLayout() {
        return this.f106527d;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public String getLabel() {
        return this.f106528e;
    }

    public final TextView getLabelView() {
        return this.f106524a;
    }

    public final TempIconContent getMContentContainer() {
        return this.f106526c;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public String getSuperscript() {
        return this.f106529f;
    }

    public final TextView getSuperscriptView() {
        return this.f106525b;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.IconTemplate
    public Animator getEntryAnimation(long r110) {
        this.f106526c.setScaleX(0.0f);
        this.f106526c.setScaleY(0.0f);
        this.f106524a.setAlpha(0.0f);
        this.f106525b.setAlpha(0.0f);
        AnimatorSet r100 = com.bytedance.android.live.core.utils.h.c(this.f106526c, new float[]{1.0f});
        r100.setDuration(250);
        r100.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator r101 = ObjectAnimator.ofFloat(this.f106524a, "alpha", new float[]{1.0f});
        r101.setDuration(200);
        r101.setStartDelay(400);
        r101.setInterpolator(new DecelerateInterpolator());
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this.f106525b, "alpha", new float[]{1.0f});
        r102.setDuration(200);
        r102.setStartDelay(400);
        r102.setInterpolator(new DecelerateInterpolator());
        AnimatorSet r103 = new AnimatorSet();
        r103.setStartDelay(r110);
        r103.play(r101).with(r102).after(r100);
        return r103;
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public void setBackgroundEnabled(boolean r100) {
        this.f106526c.setBackgroundEnabled(r100);
        this.f106526c.invalidate();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public void setLabel(String r100) {
        this.f106528e = r100;
        if (r100 != null) goto L5;
        this.f106524a.setVisibility(8);
        return;
    L5:
        this.f106524a.setText(r100);
        this.f106524a.setVisibility(0);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public void setMaskEnabled(boolean r100) {
        this.f106526c.invalidate();
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public void setSuperscript(String r100) {
        this.f106529f = r100;
        if (r100 != null) goto L5;
        this.f106525b.setVisibility(8);
        return;
    L5:
        this.f106525b.setText(r100);
        this.f106525b.setVisibility(0);
    }

    @Override // com.bytedance.android.livesdkapi.sti.framework.ICommonTemplateFeature
    public void setTemplateAlpha(float r100) {
        this.f106526c.setBackgroundAlpha(r100);
        this.f106526c.invalidate();
        this.f106524a.setAlpha(r100);
        this.f106525b.setAlpha(r100);
    }

    public BaseTempIconTemplate(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        TempIconContent r103 = new TempIconContent(r100, null, 6, 0);
        addView(r103);
        Unit r104 = Unit.INSTANCE;
        a1.p(r103, -1);
        a1.k(r103, -1);
        this.f106526c = r103;
        FrameLayout r105 = new FrameLayout(r100);
        this.f106527d = r105;
        r103.addView(r105, new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(36), UtilityKotlinExtentionsKt.i(36)));
        final TextView r106 = new TextView(r100);
        r105.addView(r106);
        a1.p(r106, UtilityKotlinExtentionsKt.i(30));
        a1.k(r106, UtilityKotlinExtentionsKt.i(10));
        a1.j(r106, 81);
        r106.setGravity(17);
        Intrinsics.checkNotNullParameter(r100, "$this$getDrawableCompat");
        r106.setBackground(ContextCompat.getDrawable(r100, R.drawable.ttlive_sti_label_bg));
        r106.setTextColor(-1);
        r106.setTextSize(1, 8.0f);
        r106.setIncludeFontPadding(false);
        r106.setVisibility(8);
        if (b5.f65220a.getValue().booleanValue() == false) goto L5;
        r3.e(r106, new BaseTempIconTemplate$3$1(r106));
    L5:
        this.f106524a = r106;
        TextView r107 = new TextView(r100);
        r105.addView(r107);
        a1.p(r107, -2);
        a1.k(r107, UtilityKotlinExtentionsKt.i(12));
        r107.setMinWidth(UtilityKotlinExtentionsKt.i(12));
        r107.setPadding(UtilityKotlinExtentionsKt.i(2), 0, UtilityKotlinExtentionsKt.i(2), 0);
        a1.j(r107, 53);
        r107.setGravity(17);
        Intrinsics.checkNotNullParameter(r100, "$this$getDrawableCompat");
        r107.setBackground(ContextCompat.getDrawable(r100, R.drawable.ttlive_sti_superscript_bg));
        r107.setTextColor(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED));
        r107.setTextSize(1, 9.0f);
        r107.setIncludeFontPadding(false);
        r107.setVisibility(8);
        this.f106525b = r107;
    }

    public /* synthetic */ BaseTempIconTemplate(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
