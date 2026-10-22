package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\b&\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH$¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\"\u0010\u001a\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/forms/AbsOInput;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/widget/EditText;", "getInterEditText", "()Landroid/widget/EditText;", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "", "a", "F", "lastScrollY", "b", "lastScrollX", "c", "Z", "isInScrollView", "()Z", "setInScrollView", "(Z)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsOInput extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f14584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f14585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f14586c;

    @JvmOverloads
    public AbsOInput(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r10) {
        if (r10 == null) goto L36;
        if (this.f14586c == false) goto L36;
        float r11 = r10.getX();
        float r12 = r10.getY();
        int r13 = r10.getAction();
        if (r13 != 0) goto L8;
        this.f14584a = r12;
        goto L36
    L8:
        if (r13 != 1) goto L10;
        super.requestDisallowInterceptTouchEvent(false);
        goto L36
    L10:
        if (r13 != 2) goto L12;
        EditText r14 = getInterEditText();
        if (r11 <= this.f14585b) goto L20;
        if (r14.canScrollHorizontally(-1) == false) goto L20;
    L31:
        super.requestDisallowInterceptTouchEvent(true);
    L32:
        this.f14585b = r11;
        this.f14584a = r12;
    L20:
        if (r11 >= this.f14585b) goto L24;
        if (r14.canScrollHorizontally(1) == true) goto L31;
    L24:
        if (r12 >= this.f14584a) goto L28;
        if (r14.canScrollVertically(1) == true) goto L31;
    L28:
        if (r12 <= this.f14584a) goto L32;
        if (r14.canScrollVertically(-1) == false) goto L32;
    L12:
        if (r13 != 3) goto L36;
        super.requestDisallowInterceptTouchEvent(false);
    L36:
        return super.dispatchTouchEvent(r10);
    }

    @NotNull
    public abstract EditText getInterEditText();

    public final void setInScrollView(boolean r10) {
        this.f14586c = r10;
    }

    @JvmOverloads
    public AbsOInput(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ AbsOInput(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public AbsOInput(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
