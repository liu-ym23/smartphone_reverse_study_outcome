package com.obric.oui.tag;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.obric.oui.text.OTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.h;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: OTextTag.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OTextTag extends OTextView {
    public OTextTag(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public OTextTag(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public /* synthetic */ OTextTag(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public OTextTag(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        super(r3, r4, r12, null, 8, null);
        initView();
    }

    private final void initView() {
        ColorStateList r0 = ColorStateList.valueOf(getCurrentTextColor());
        o.c(r0, "valueOf(textColor)");
        setCompoundDrawableTintList(r0);
        adjustPaddingStart(hasStartDrawable());
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawables(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        adjustPaddingStart(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        super.setCompoundDrawablesRelative(r1, r2, r3, r4);
        if (r1 == null) goto L5;
        boolean r5 = true;
    L6:
        adjustPaddingStart(r5);
        return;
    L5:
        r5 = false;
        goto L6
    }

    private final boolean hasStartDrawable() {
        Drawable[] r0 = getCompoundDrawables();
        o.c(r0, "getCompoundDrawables()");
        if (i.b((Object[]) ZeusTransformUtils.preCheckCast(r0, Object[].class, "com.obric.aiagent.plugin"), 0) != null) goto L6;
        Drawable[] r3 = getCompoundDrawablesRelative();
        o.c(r3, "getCompoundDrawablesRelative()");
        if (i.b((Object[]) ZeusTransformUtils.preCheckCast(r3, Object[].class, "com.obric.aiagent.plugin"), 0) != null) goto L6;
        return false;
    L6:
        return true;
    }

    private final void adjustPaddingStart(boolean r6) {
        int r0 = getPaddingTop();
        int r1 = getPaddingEnd();
        int r2 = getPaddingBottom();
        int r3 = n.c(getCompoundDrawablePadding(), 0);
        if (r6 == false) goto L5;
        int r7 = n.c(r1 - r3, 0);
    L7:
        if (r7 == getPaddingStart()) goto L10;
        setPaddingRelative(r7, r0, r1, r2);
        return;
    L10:
        return;
    L5:
        r7 = r1;
        goto L7
    }
}
