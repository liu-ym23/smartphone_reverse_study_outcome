package com.android.contacts.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TableLayout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: DialpadContainer.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/android/contacts/widget/DialpadContainer;", "Landroid/widget/TableLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxScrollY", "", "getMaxScrollY", "()I", "onHide", "Lkotlin/Function0;", "", "getOnHide", "()Lkotlin/jvm/functions/Function0;", "setOnHide", "(Lkotlin/jvm/functions/Function0;)V", "totalScrollY", "touchDetector", "Landroid/view/GestureDetector;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialpadContainer extends TableLayout {
    private final int maxScrollY;
    private Function0<Unit> onHide;
    private int totalScrollY;
    private final GestureDetector touchDetector;

    public static final /* synthetic */ int access$getTotalScrollY$p(DialpadContainer r0) {
        return r0.totalScrollY;
    }

    public static final /* synthetic */ void access$setTotalScrollY$p(DialpadContainer r0, int r1) {
        r0.totalScrollY = r1;
    }

    public DialpadContainer(final Context r3, AttributeSet r4) {
        super(r3, r4);
        this.onHide = DialpadContainer$onHide$1.INSTANCE;
        this.maxScrollY = MathKt.roundToInt(TypedValue.applyDimension(1, 150, Resources.getSystem().getDisplayMetrics()));
        this.touchDetector = new GestureDetector(r3, new DialpadContainer$touchDetector$1(r3, this));
    }

    public final Function0<Unit> getOnHide() {
        return this.onHide;
    }

    public final void setOnHide(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.onHide = r2;
    }

    public final int getMaxScrollY() {
        return this.maxScrollY;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        boolean r1 = this.touchDetector.onTouchEvent(r3);
        if (super.dispatchTouchEvent(r3) == true) goto L8;
        if (r1 == true) goto L8;
        return false;
    L8:
        return true;
    }
}
