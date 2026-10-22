package com.stepos.widget.dialog;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import j4.g;
import j4.k;

/* loaded from: classes.dex */
public final class StepOSCheckableLayout extends LinearLayout implements Checkable {

    /* renamed from: b, reason: collision with root package name */
    private static final a f16146b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f16147c = {R.attr.state_checked};

    /* renamed from: a, reason: collision with root package name */
    private boolean f16148a;

    private static final class a {
        public /* synthetic */ a(g gVar) {
            this();
        }

        private a() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSCheckableLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.g(context, "context");
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f16148a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i5) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i5 + 1);
        if (this.f16148a) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f16147c);
        }
        k.d(iArrOnCreateDrawableState);
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z5) {
        if (this.f16148a == z5) {
            return;
        }
        this.f16148a = z5;
        refreshDrawableState();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f16148a);
    }

    public /* synthetic */ StepOSCheckableLayout(Context context, AttributeSet attributeSet, int i5, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSCheckableLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        k.g(context, "context");
    }
}
