package com.alibaba.gaiax.render.view.basic;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.alibaba.gaiax.GXRegisterCenter;
import com.alibaba.gaiax.render.view.GXIRoundCorner;
import com.alibaba.gaiax.render.view.GXIViewBindData;
import com.alibaba.gaiax.render.view.GXViewExtKt;
import com.alibaba.gaiax.render.view.basic.richtext.RichTextModel;
import com.alibaba.gaiax.render.view.drawable.GXColorGradientDrawable;
import com.alibaba.gaiax.render.view.drawable.GXRoundCornerBorderGradientDrawable;
import com.alibaba.gaiax.template.GXCss;
import com.alibaba.gaiax.template.GXSize;
import com.alibaba.gaiax.template.GXStyle;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.alibaba.gaiax.utils.SpanUtil;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J\"\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0006\u0010!\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0015J\u0014\u0010#\u001a\u0004\u0018\u00010\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010$\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010%\u001a\u00020\u0017H\u0014J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0015J \u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020,H\u0016J\u0010\u0010/\u001a\u00020\u00172\b\u0010\u001e\u001a\u0004\u0018\u00010\u0015J\u000e\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u000202R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/alibaba/gaiax/render/view/basic/GXText;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lcom/alibaba/gaiax/render/view/GXIViewBindData;", "Lcom/alibaba/gaiax/render/view/GXIRoundCorner;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "preview", "", "getPreview", "()Z", "setPreview", "(Z)V", "taskList", "Ljava/util/LinkedList;", "", "addTask", "", "task", "bindDesc", "textView", "Landroid/widget/TextView;", "content", "", "data", "Lorg/json/JSONObject;", "bindText", "clearTask", "containsTask", "getContent", "onBindData", "onDetachedFromWindow", "removeTask", "setRoundCornerBorder", "borderColor", "borderWidth", "", "radius", "", "setRoundCornerRadius", "radiusArray", "setText", "setTextStyle", GXTemplateKey.GAIAX_CSS, "Lcom/alibaba/gaiax/template/GXCss;", "GaiaX"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class GXText extends AppCompatTextView implements GXIViewBindData, GXIRoundCorner {
    private boolean preview;
    private final LinkedList<Object> taskList;

    public final void clearTask() {
        this.taskList.clear();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.taskList.clear();
    }

    public final boolean getPreview() {
        return this.preview;
    }

    public GXText(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.taskList = new LinkedList();
    }

    private final Object getContent(Object r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if ((r100 instanceof String) == false) goto L7;
        return r100;
    L7:
        if ((r100 instanceof CharSequence) == false) goto L10;
        return r100;
    L10:
        if ((r100 instanceof JSONObject) == true) goto L15;
        return r100;
    L15:
        return ((JSONObject) r100).opt("value");
    }

    public final void addTask(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        this.taskList.add(r100);
    }

    public final boolean containsTask(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        return this.taskList.contains(r100);
    }

    @Override // com.alibaba.gaiax.render.view.GXIViewBindData
    public void onBindData(JSONObject r100) {
        Object r101 = getContent(r100);
        setText(r101);
        bindDesc(this, String.valueOf(r101), r100);
    }

    public final void removeTask(Object r100) {
        Intrinsics.checkNotNullParameter(r100, "task");
        this.taskList.remove(r100);
    }

    public final void setPreview(boolean r100) {
        this.preview = r100;
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerRadius(float[] r100) {
        Intrinsics.checkNotNullParameter(r100, "radiusArray");
        boolean r101 = false;
        final float r102 = r100[0];
        float r103 = r100[2];
        if (r102 != r103) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L20;
        float r105 = r100[4];
        if (r103 != r105) goto L10;
        boolean r106 = true;
    L11:
        if (r106 == true) goto L13;
        return;
    L13:
        if (r105 != r100[6]) goto L15;
        r101 = true;
    L15:
        if (r101 == true) goto L17;
        return;
    L17:
        if (r102 <= 0.0f) goto L23;
        setClipToOutline(true);
        setOutlineProvider(new AnonymousClass1(this, r102));
        return;
    L23:
        return;
    L10:
        r106 = false;
        goto L11
    L20:
        return;
    L5:
        r104 = false;
        goto L6
    }

    public final void setText(Object r100) {
        if ((r100 instanceof String) == false) goto L6;
        setText((CharSequence) r100);
        return;
    L6:
        if ((r100 instanceof JSONObject) == false) goto L8;
        RichTextModel r101 = RichTextModel.Companion.createByExtend((JSONObject) r100);
        SpanUtil.INSTANCE.buildSpanForTextView(this, r101, this.preview);
        return;
    L8:
        if (r100 == null) goto L13;
        setText(r100.toString());
        return;
    }

    public final void setTextStyle(GXCss r100) {
        Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_CSS);
        GXStyle r101 = r100.getStyle();
        r100.getFlexBox();
        GXViewExtKt.setFontPadding(this, r101.getPadding());
        GXSize r102 = r101.getFontSize();
        if (r102 == null) goto L5;
        Float r103 = Float.valueOf(r102.getValueFloat());
    L6:
        GXViewExtKt.setFontSize(this, r103);
        GXViewExtKt.setFontFamilyAndFontWeight(this, r101);
        GXViewExtKt.setFontColor(this, r101);
        GXViewExtKt.setFontBackgroundImage(this, r101.getBackgroundImage());
        GXViewExtKt.setFontLines(this, r101.getFontLines());
        GXViewExtKt.setFontTextOverflow(this, r101);
        GXViewExtKt.setFontTextAlign(this, r101);
        GXViewExtKt.setFontTextLineHeight(this, r101);
        GXViewExtKt.setFontTextDecoration(this, r101.getFontTextDecoration());
        return;
    L5:
        r103 = null;
        goto L6
    }

    public GXText(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.taskList = new LinkedList();
    }

    public void bindText(TextView r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, "content");
        r100.setText(r101);
    }

    public GXText(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.taskList = new LinkedList();
    }

    private final void bindDesc(TextView r100, CharSequence r101, JSONObject r102) {
        boolean r103 = false;
        if (r102 != null) goto L38;
        Object r104 = null;
    L9:
        if ((r104 instanceof String) == false) goto L11;
        String r105 = (String) r104;     // Catch: Exception -> L5
    L13:
        if (r105 != null) goto L15;
    L17:
        r100.setContentDescription(null);     // Catch: Exception -> L5
        if (r101.length() <= 0) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == false) goto L23;
        r100.setImportantForAccessibility(1);     // Catch: Exception -> L5
    L24:
        if (r102 != null) goto L26;
        return;
    L26:
        if (r102.optBoolean(GXTemplateKey.GAIAX_ACCESSIBILITY_ENABLE) == false) goto L28;
        r100.setImportantForAccessibility(1);     // Catch: Exception -> L5
        return;
    L28:
        r100.setImportantForAccessibility(2);     // Catch: Exception -> L5
        return;
    L23:
        r100.setImportantForAccessibility(2);     // Catch: Exception -> L5
        goto L24
    L20:
        r106 = false;
        goto L21
    L15:
        if ((!StringsKt.isBlank(r105)) == false) goto L17;
        r100.setContentDescription(r105);     // Catch: Exception -> L5
        r100.setImportantForAccessibility(1);     // Catch: Exception -> L5
        goto L24
    L11:
        r105 = null;
        goto L13
    L38:
        r104 = r102.opt(GXTemplateKey.GAIAX_ACCESSIBILITY_DESC);     // Catch: Exception -> L5
    L5:
        e = move-exception;
        GXRegisterCenter.GXIExtensionCompatibility r107 = GXRegisterCenter.Companion.getInstance().getExtensionCompatibility$GaiaX();
        if (r107 != null) goto L33;
    L35:
        if (r103 == false) goto L40;
        throw e;
    L40:
        return;
    L33:
        if (r107.isPreventAccessibilityThrowException() == true) goto L35;
        r103 = true;
        goto L35
    }

    @Override // com.alibaba.gaiax.render.view.GXIRoundCorner
    public void setRoundCornerBorder(int r100, float r101, float[] r102) {
        Intrinsics.checkNotNullParameter(r102, "radius");
        if ((getBackground() instanceof GXColorGradientDrawable) == false) goto L5;
        Drawable r103 = getBackground();
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.alibaba.gaiax.render.view.drawable.GXColorGradientDrawable");
        ((GXColorGradientDrawable) r103).setStroke(MathKt.roundToInt(r101), r100);
        return;
    L5:
        GXRoundCornerBorderGradientDrawable r104 = new GXRoundCornerBorderGradientDrawable();
        r104.setShape(0);
        r104.setCornerRadii(r102);
        r104.setStroke(MathKt.roundToInt(r101), r100);
        setBackground(r104);
    }
}
