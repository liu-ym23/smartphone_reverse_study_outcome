package com.bytedanceos.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import i9.a;
import i9.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0014\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0014\u0010\u0018R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedanceos/ui/FrameLayoutCenterChildrenInDecorView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "widthMeasureSpec", "heightMeasureSpec", "", "onMeasure", "(II)V", "", "changed", "l", "t", "r", "b", "onLayout", "(ZIIII)V", "Landroid/view/ViewGroup;", "()Landroid/view/ViewGroup;", "a", "Landroid/view/ViewGroup;", "ancestor", "resource_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FrameLayoutCenterChildrenInDecorView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f10229a;

    @JvmOverloads
    public FrameLayoutCenterChildrenInDecorView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    public static /* synthetic */ WindowInsets a(View r10, WindowInsets r11) {
        return c(r10, r11);
    }

    public static final WindowInsets c(View r10, WindowInsets r11) {
        q.g(r10, "<anonymous parameter 0>");
        q.g(r11, "insets");
        int r12 = r11.getInsets(WindowInsetsCompat.Type.d() | WindowInsetsCompat.Type.a()).bottom;
        return r11;
    }

    public final ViewGroup b() {
        Context r10 = getContext();
        q.f(r10, "getContext(...)");
        Activity r11 = b.a(r10);
        if (r11 == null) goto L7;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L7;
        View r13 = r12.getDecorView();
    L9:
        if ((r13 instanceof ViewGroup) == true) goto L11;
        return null;
    L11:
        return (ViewGroup) r13;
    L7:
        r13 = null;
        goto L9
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        if (this.f10229a != null) goto L5;
        this.f10229a = b();
        Unit r15 = Unit.f21064a;
    L5:
        ViewGroup r16 = this.f10229a;
        if (r16 != null) goto L8;
        return;
    L8:
        if (r16 == null) goto L10;
        int r17 = r16.getHeight();
    L11:
        WindowInsetsCompat r18 = ViewCompat.H(this);
        int r19 = 0;
        if (r18 == null) goto L18;
        WindowInsets r110 = r18.x();
        if (r110 == null) goto L18;
        Insets r111 = r110.getInsets(WindowInsetsCompat.Type.a());
        if (r111 == null) goto L18;
        int r112 = r111.bottom;
    L19:
        int r20 = (r17 - r112) / 2;
        int r21 = b.b(this, r16);
        int r113 = getChildCount();
    L20:
        if (r19 >= r113) goto L25;
        View r22 = getChildAt(r19);
        if (r22.getVisibility() == 8) goto L24;
        int r23 = r22.getMeasuredWidth();
        int r24 = r22.getMeasuredHeight();
        int r25 = ((r13 - r11) - r23) / 2;
        int r26 = (r20 - (r24 / 2)) - r21;
        r22.layout(r25, r26, r23 + r25, r24 + r26);
    L24:
        r19 = r19 + 1;
        goto L20
    L25:
        return;
    L18:
        r112 = 0;
        goto L19
    L10:
        r17 = r14 - r12;
        goto L11
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        setOnApplyWindowInsetsListener(new a());
        super.onMeasure(r10, r11);
    }

    @JvmOverloads
    public FrameLayoutCenterChildrenInDecorView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ FrameLayoutCenterChildrenInDecorView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public FrameLayoutCenterChildrenInDecorView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
