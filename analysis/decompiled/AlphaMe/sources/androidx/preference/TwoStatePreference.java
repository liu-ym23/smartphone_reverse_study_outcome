package androidx.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: N, reason: collision with root package name */
    public boolean f4128N;

    /* renamed from: O, reason: collision with root package name */
    public CharSequence f4129O;

    /* renamed from: P, reason: collision with root package name */
    public CharSequence f4130P;

    /* renamed from: Q, reason: collision with root package name */
    public boolean f4131Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f4132R;

    public TwoStatePreference(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            return
        L5:
            android.widget.TextView r4 = (android.widget.TextView) r4
            boolean r0 = r3.f4128N
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r3.f4129O
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r3.f4129O
            r4.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r3.f4128N
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.f4130P
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.f4130P
            r4.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r3 = r3.f()
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L3e
            r4.setText(r3)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r3 = r4.getVisibility()
            if (r1 == r3) goto L4c
            r4.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.A(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    public final void m() {
        boolean z4 = !this.f4128N;
        if (a(Boolean.valueOf(z4))) {
            z(z4);
        }
    }

    @Override // androidx.preference.Preference
    public final Object o(TypedArray typedArray, int i4) {
        return Boolean.valueOf(typedArray.getBoolean(i4, false));
    }

    @Override // androidx.preference.Preference
    public final void p(Parcelable parcelable) {
        if (!parcelable.getClass().equals(SavedState.class)) {
            super.p(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.p(savedState.getSuperState());
        z(savedState.f4133a);
    }

    @Override // androidx.preference.Preference
    public final Parcelable q() {
        this.f4073J = true;
        AbsSavedState absSavedState = AbsSavedState.EMPTY_STATE;
        if (this.f4094r) {
            return absSavedState;
        }
        SavedState savedState = new SavedState(absSavedState);
        savedState.f4133a = this.f4128N;
        return savedState;
    }

    @Override // androidx.preference.Preference
    public final void r(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        if (x()) {
            zBooleanValue = this.f4078b.b().getBoolean(this.f4088l, zBooleanValue);
        }
        z(zBooleanValue);
    }

    @Override // androidx.preference.Preference
    public final boolean w() {
        if (!this.f4132R ? this.f4128N : !this.f4128N) {
            if (!super.w()) {
                return false;
            }
        }
        return true;
    }

    public final void z(boolean z4) {
        boolean z5 = this.f4128N != z4;
        if (z5 || !this.f4131Q) {
            this.f4128N = z4;
            this.f4131Q = true;
            if (x()) {
                boolean z6 = !z4;
                if (x()) {
                    z6 = this.f4078b.b().getBoolean(this.f4088l, z6);
                }
                if (z4 != z6) {
                    SharedPreferences.Editor editorA = this.f4078b.a();
                    editorA.putBoolean(this.f4088l, z4);
                    y(editorA);
                }
            }
            if (z5) {
                i(w());
                h();
            }
        }
    }

    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new P();

        /* renamed from: a, reason: collision with root package name */
        public boolean f4133a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f4133a = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeInt(this.f4133a ? 1 : 0);
        }

        public SavedState(AbsSavedState absSavedState) {
            super(absSavedState);
        }
    }
}
