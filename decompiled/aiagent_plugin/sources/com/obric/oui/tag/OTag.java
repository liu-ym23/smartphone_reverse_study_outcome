package com.obric.oui.tag;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: OTag.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OTag extends AppCompatTextView {
    private int bgEndColor;
    private int bgStartColor;
    private int borderColor;
    private boolean bordered;
    private int tagSize;

    public OTag(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTag(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    private static /* synthetic */ void getTagSize$annotations() {
    }

    public /* synthetic */ OTag(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public OTag(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, R.styleable.OTag, 0, 0);
        this.tagSize = r11.getInteger(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_size, "styleable", "OTag_oui_size"), 0);     // Catch: Throwable -> L18
        this.bordered = r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_bordered, "styleable", "OTag_oui_bordered"), false);     // Catch: Throwable -> L18
        this.borderColor = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_borderColor, "styleable", "OTag_oui_borderColor"), 0);     // Catch: Throwable -> L18
        this.bgStartColor = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_bgGradientStartColor, "styleable", "OTag_oui_bgGradientStartColor"), 0);     // Catch: Throwable -> L18
        this.bgEndColor = r11.getColor(ZeusTransformUtils.mapRes(R.styleable.OTag_oui_bgGradientEndColor, "styleable", "OTag_oui_bgGradientEndColor"), 0);     // Catch: Throwable -> L18
        r11.recycle();
        int r12 = this.tagSize;
        if (r12 == 0) goto L9;
        if (r12 == 2) goto L8;
        int r13 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 1);
        int r14 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 3);
    L10:
        setPadding(r14, r13, r14, r13);
        if (this.bgStartColor != 0) goto L13;
    L15:
        GradientDrawable r15 = new GradientDrawable();
    L16:
        r15.setCornerRadius(g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2));
        setBackground((Drawable) ZeusTransformUtils.preCheckCast(r15, Drawable.class, "com.obric.aiagent.plugin"));
        return;
    L13:
        if (this.bgEndColor == 0) goto L15;
        r15 = new GradientDrawable(GradientDrawable.Orientation.TL_BR, new int[]{this.bgStartColor, this.bgEndColor});
        goto L16
    L8:
        r13 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 2);
        r14 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 4);
        goto L10
    L9:
        r14 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 3);
        r13 = g.a((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"), 1);
    L18:
        th = move-exception;
        r11.recycle();
        throw th;
    }
}
