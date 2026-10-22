package com.bytedance.android.livesdk.livecommerce.intro.card.widget.secondframe;

import android.content.Context;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.view.GradientAndItalicTextView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/secondframe/IntroCustomEllipsisTextView;", "Lcom/bytedance/android/livesdk/livecommerce/view/GradientAndItalicTextView;", "", "text", "", "setOriginalText", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroCustomEllipsisTextView extends GradientAndItalicTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CharSequence f148108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f148109g;

    public static final class a {
    }

    static {
    }

    public IntroCustomEllipsisTextView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public IntroCustomEllipsisTextView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void setOriginalText(CharSequence r100) {
        this.f148108f = r100;
        this.f148109g = -1;
        setText(r100);
        setContentDescription(String.valueOf(r100));
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    public final void onMeasure(int r100, int r110) {
        int r101 = View.MeasureSpec.getMode(r100);
        int r102 = View.MeasureSpec.getSize(r100);
        if (r101 != 0) goto L5;
        int r103 = Integer.MAX_VALUE;
    L6:
        if (r103 > 0) goto L8;
    L32:
        super.onMeasure(r100, r110);
        return;
    L8:
        if (r103 == this.f148109g) goto L32;
        CharSequence r104 = this.f148108f;
        if (r104 == null) goto L32;
        this.f148109g = r103;
        TextPaint r105 = getPaint();
        String r106 = String.valueOf(r104);
        float r107 = r103;
        if (r105.measureText("“" + r104 + Typography.rightDoubleQuote) > r107) goto L14;
        String r108 = "“" + r104 + Typography.rightDoubleQuote;
    L30:
        if ((!Intrinsics.areEqual(getText().toString(), r108.toString())) == false) goto L32;
        setText(r108);
        goto L32
    L14:
        float r109 = r105.measureText("“");
        float r111 = ((r107 - r109) - r105.measureText("”")) - r105.measureText("…");
        if (r111 > 0) goto L18;
        r108 = "";
    L18:
        if (r106.length() <= 0) goto L20;
        boolean r112 = true;
    L21:
        if (r112 == false) goto L28;
        if (r105.measureText(r106) <= r111) goto L28;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L26
        r106 = r106.substring(0, r106.length() - 1);     // Catch: Throwable -> L26
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L28:
        r108 = "“" + r106 + "…”";
        goto L30
    L20:
        r112 = false;
        goto L21
    L5:
        r103 = (r102 - getPaddingLeft()) - getPaddingRight();
        goto L6
    }

    public IntroCustomEllipsisTextView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f148109g = -1;
    }

    public /* synthetic */ IntroCustomEllipsisTextView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
