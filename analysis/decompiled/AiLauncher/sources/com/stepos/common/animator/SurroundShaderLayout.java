package com.stepos.common.animator;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.stepos.common.animator.b;

/* loaded from: classes3.dex */
public class SurroundShaderLayout extends FrameLayout {
    private static final String TAG = "SurroundShaderLayout";
    private b mAnimator;
    private final b.e mCallback;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean mAnimatorHasStarted;

        public class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SurroundShaderLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " hasAnimStarted=" + this.mAnimatorHasStarted + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBoolean(this.mAnimatorHasStarted);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.mAnimatorHasStarted = parcel.readBoolean();
        }
    }

    public boolean a() {
        return this.mAnimator.h();
    }

    public void b() {
        this.mAnimator.t();
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.mAnimator.r(View.MeasureSpec.getSize(i10), View.MeasureSpec.getSize(i11));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (getContext().getApplicationInfo().targetSdkVersion <= 18) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        boolean z10 = savedState.mAnimatorHasStarted;
        Log.i(TAG, "onRestoreInstanceState and hasAnimStarted:" + z10);
        if (z10) {
            b();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        if (getContext().getApplicationInfo().targetSdkVersion <= 18) {
            return super.onSaveInstanceState();
        }
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        boolean zA = a();
        Log.i(TAG, "onSaveInstanceState and hasAnimStarted:" + zA);
        savedState.mAnimatorHasStarted = zA;
        return savedState;
    }

    public void setAnimType(int i10) {
        this.mAnimator.j(i10);
    }

    public void setColors(String[] strArr) {
        this.mAnimator.k(strArr);
    }

    public void setCornerRadius(float f10) {
        this.mAnimator.n(f10);
    }

    public void setGlowInner(boolean z10) {
        this.mAnimator.o(z10);
    }

    public void setIntensity(float f10) {
        this.mAnimator.p(f10);
    }

    public void setShaderRadius(int i10) {
        this.mAnimator.q(i10);
    }

    public void setSolidColor(int i10) {
        this.mAnimator.s(i10);
    }
}
