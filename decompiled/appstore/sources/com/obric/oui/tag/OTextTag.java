package com.obric.oui.tag;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import bg.h;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u000f\u0010\u0010J7\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\u001a\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\u001e\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u0016\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001bJ\u000f\u0010\u001f\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/obric/oui/tag/OTextTag;", "Lcom/obric/oui/text/OTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "d", "()V", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/drawable/Drawable;", "setCompoundDrawables", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "start", "end", "setCompoundDrawablesRelative", "c", "()Z", "hasStartDrawable", "b", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OTextTag extends OTextView {
    @JvmOverloads
    public OTextTag(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    private final void d() {
        ColorStateList r10 = ColorStateList.valueOf(getCurrentTextColor());
        q.f(r10, "valueOf(textColor)");
        setCompoundDrawableTintList(r10);
        b(c());
    }

    public final void b(boolean r10) {
        int r11 = getPaddingTop();
        int r12 = getPaddingEnd();
        int r13 = getPaddingBottom();
        int r14 = h.d(getCompoundDrawablePadding(), 0);
        if (r10 == false) goto L5;
        int r15 = h.d(r12 - r14, 0);
    L7:
        if (r15 == getPaddingStart()) goto L10;
        setPaddingRelative(r15, r11, r12, r13);
        return;
    L10:
        return;
    L5:
        r15 = r12;
        goto L7
    }

    public final boolean c() {
        Drawable[] r10 = getCompoundDrawables();
        q.f(r10, "getCompoundDrawables()");
        if (n.u(r10, 0) != null) goto L6;
        Drawable[] r11 = getCompoundDrawablesRelative();
        q.f(r11, "getCompoundDrawablesRelative()");
        if (n.u(r11, 0) != null) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // com.obric.oui.text.OTextView, android.widget.TextView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawables(r10, r11, r12, r13);
        if (r10 == null) goto L5;
        boolean r14 = true;
    L6:
        b(r14);
        return;
    L5:
        r14 = false;
        goto L6
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable r10, Drawable r11, Drawable r12, Drawable r13) {
        super.setCompoundDrawablesRelative(r10, r11, r12, r13);
        if (r10 == null) goto L5;
        boolean r14 = true;
    L6:
        b(r14);
        return;
    L5:
        r14 = false;
        goto L6
    }

    @JvmOverloads
    public OTextTag(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OTextTag(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OTextTag(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12, null, 8, null);
        d();
    }
}
