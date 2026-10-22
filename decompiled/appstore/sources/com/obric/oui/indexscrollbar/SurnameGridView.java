package com.obric.oui.indexscrollbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.GridView;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameGridView;", "Landroid/widget/GridView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroid/view/MotionEvent;", "ev", "", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "Lcom/obric/oui/indexscrollbar/SurnameGridView$OnPressChangeListener;", "listener", "", "setOnPressChangeListener", "(Lcom/obric/oui/indexscrollbar/SurnameGridView$OnPressChangeListener;)V", "a", "Lcom/obric/oui/indexscrollbar/SurnameGridView$OnPressChangeListener;", "mPressChangeListener", "", "b", "I", "mTouchedPosition", "c", "mPrePosition", "OnPressChangeListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SurnameGridView extends GridView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OnPressChangeListener f14946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f14947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14948c;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/oui/indexscrollbar/SurnameGridView$OnPressChangeListener;", "", "onTouched", "", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnPressChangeListener {
        void onTouched(int r10);
    }

    public SurnameGridView(@Nullable Context r10, @Nullable AttributeSet r11) {
        super(r10, r11);
        this.f14947b = -1;
        this.f14948c = -1;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent r10) {
        q.g(r10, "ev");
        int r11 = pointToPosition((int) r10.getX(), (int) r10.getY());
        int r12 = r10.getActionMasked();
        if (r12 != 0) goto L5;
        this.f14947b = r11;
    L15:
        if (this.f14948c == r11) goto L18;
        OnPressChangeListener r13 = this.f14946a;
        q.d(r13);
        r13.onTouched(r11);
        this.f14948c = r11;
    L18:
        return super.onTouchEvent(r10);
    L5:
        if (r12 != 1) goto L7;
    L9:
        r11 = -1;
        goto L15
    L7:
        if (r12 != 2) goto L9;
        int r14 = this.f14947b;
        if (r14 != r11) goto L9;
        r11 = r14;
        goto L15
    }

    public final void setOnPressChangeListener(@Nullable OnPressChangeListener r10) {
        this.f14946a = r10;
    }
}
