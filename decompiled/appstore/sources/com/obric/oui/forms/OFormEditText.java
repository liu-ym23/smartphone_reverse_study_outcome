package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0014¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000f\u0010\fR\"\u0010\u0013\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006 "}, d2 = {"Lcom/obric/oui/forms/OFormEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "getLeftFadingEdgeStrength", "()F", "getRightFadingEdgeStrength", "getTopFadingEdgeStrength", "getBottomFadingEdgeStrength", "", "a", "Z", "isLeftFading", "()Z", "setLeftFading", "(Z)V", "b", "isRightFading", "setRightFading", "c", "isTopFading", "setTopFading", "d", "isBottomFading", "setBottomFading", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFormEditText extends AppCompatEditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f14648a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f14649b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14650c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f14651d;

    @JvmOverloads
    public OFormEditText(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.f14651d == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        if (this.f14648a == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        if (this.f14649b == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.f14650c == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    public final void setBottomFading(boolean r10) {
        this.f14651d = r10;
    }

    public final void setLeftFading(boolean r10) {
        this.f14648a = r10;
    }

    public final void setRightFading(boolean r10) {
        this.f14649b = r10;
    }

    public final void setTopFading(boolean r10) {
        this.f14650c = r10;
    }

    @JvmOverloads
    public OFormEditText(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ OFormEditText(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public OFormEditText(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
