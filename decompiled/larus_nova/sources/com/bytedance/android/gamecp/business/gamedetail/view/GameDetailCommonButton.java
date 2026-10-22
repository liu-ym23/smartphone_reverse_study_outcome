package com.bytedance.android.gamecp.business.gamedetail.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.gamecp.base.gamedetail.x;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010$\u001a\u00020#\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%\u0012\b\b\u0002\u0010'\u001a\u00020\t¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\tH\u0002J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002J\u000e\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0010R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006*"}, d2 = {"Lcom/bytedance/android/gamecp/business/gamedetail/view/GameDetailCommonButton;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/gamecp/base/gamedetail/x;", "btnUIStyle", "", "setProcessViewColor", "", "buttonText", "setButtonText", "", "textColor", "setButtonTextColor", "(Ljava/lang/Integer;)V", "Landroid/graphics/Rect;", GXTemplateKey.FLEXBOX_PADDING, "setButtonTextPadding", "", "buttonTextSizeSp", "setButtonTextSizeSp", "(Ljava/lang/Float;)V", "buttonTextTypeface", "setButtonTextTypeface", "Landroid/graphics/drawable/Drawable;", "drawable", "setBackGround", "stokeWidthDp", "setStrokeWidth", "Landroid/widget/TextView;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Landroid/widget/TextView;", "getTvDes", "()Landroid/widget/TextView;", "setTvDes", "(Landroid/widget/TextView;)V", "tvDes", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDetailCommonButton extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f55658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ProcessView f55659b;

    public GameDetailCommonButton(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GameDetailCommonButton(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void S5() {
        TextView r100 = this.f55658a;
        if (r100 == null) goto L8;
        TextPaint r101 = r100.getPaint();
        if (r101 == null) goto L9;
        r101.setFakeBoldText(true);
        return;
    L9:
        return;
    }

    public final TextView getTvDes() {
        return this.f55658a;
    }

    private final void setBackGround(Drawable r100) {
        if (r100 == null) goto L5;
        setBackground(r100);
        return;
    }

    private final void setButtonText(String r100) {
        if (r100 == null) goto L7;
        TextView r101 = this.f55658a;
        if (r101 == null) goto L8;
        r101.setText(r100);
        return;
    L8:
        return;
    }

    private final void setButtonTextColor(Integer r100) {
        if (r100 == null) goto L7;
        int r101 = r100.intValue();
        TextView r102 = this.f55658a;
        if (r102 == null) goto L8;
        r102.setTextColor(r101);
        return;
    L8:
        return;
    }

    private final void setButtonTextPadding(Rect r100) {
        if (r100 == null) goto L7;
        TextView r101 = this.f55658a;
        if (r101 == null) goto L8;
        r101.setPadding(r100.left, r100.top, r100.right, r100.bottom);
        return;
    L8:
        return;
    }

    private final void setButtonTextSizeSp(Float r100) {
        if (r100 == null) goto L7;
        float r101 = r100.floatValue();
        TextView r102 = this.f55658a;
        if (r102 == null) goto L8;
        r102.setTextSize(2, r101);
        return;
    L8:
        return;
    }

    private final void setButtonTextTypeface(int r100) {
        TextView r101 = this.f55658a;
        if (r101 == null) goto L5;
        r101.setTypeface(Typeface.defaultFromStyle(r100));
    L5:
        TextView r102 = this.f55658a;
        if (r102 == null) goto L9;
        yt.o.a(r102, 500);
        return;
    }

    private final void setProcessViewColor(x r100) {
        Integer r101 = r100.b(getContext());
        if (r101 == null) goto L8;
        int r102 = r101.intValue();
        ProcessView r103 = this.f55659b;
        if (r103 == null) goto L9;
        r103.setColor(r102);
        return;
    L9:
        return;
    }

    public final void R5(x r100) {
        Intrinsics.checkNotNullParameter(r100, "btnUIStyle");
        setButtonText(r100.d(getContext()));
        setButtonTextColor(r100.c(getContext()));
        setButtonTextPadding(r100.f(getContext()));
        setButtonTextSizeSp(Float.valueOf(r100.e(getContext())));
        r100.g(getContext());
        setButtonTextTypeface(0);
        setBackGround(r100.a(getContext()));
        setProcessViewColor(r100);
    }

    public final void setStrokeWidth(float r100) {
        ProcessView r101 = this.f55659b;
        if (r101 == null) goto L6;
        r101.setStrokeWidth(y0.b(r100));
        return;
    }

    public final void setTvDes(TextView r100) {
        this.f55658a = r100;
    }

    public GameDetailCommonButton(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View.inflate(r100, R.layout.gamecp_game_promote_detail_common_button, this);
        this.f55658a = (TextView) findViewById(R.id.tv_desc);
        this.f55659b = (ProcessView) findViewById(R.id.process_loading_view);
        setStrokeWidth(2.0f);
    }

    public /* synthetic */ GameDetailCommonButton(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
