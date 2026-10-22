package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import androidx.preference.Preference;

/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: T, reason: collision with root package name */
    protected boolean f11045T;

    /* renamed from: U, reason: collision with root package name */
    private CharSequence f11046U;

    /* renamed from: V, reason: collision with root package name */
    private CharSequence f11047V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f11048W;

    /* renamed from: X, reason: collision with root package name */
    private boolean f11049X;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }

    @Override // androidx.preference.Preference
    public boolean M0() {
        return (this.f11049X ? this.f11045T : !this.f11045T) || super.M0();
    }

    public boolean R0() {
        return this.f11045T;
    }

    public void S0(boolean z5) {
        boolean z6 = this.f11045T != z5;
        if (z6 || !this.f11048W) {
            this.f11045T = z5;
            this.f11048W = true;
            k0(z5);
            if (z6) {
                R(M0());
                Q();
            }
        }
    }

    public void T0(boolean z5) {
        this.f11049X = z5;
    }

    public void U0(CharSequence charSequence) {
        this.f11047V = charSequence;
        if (R0()) {
            return;
        }
        Q();
    }

    public void V0(CharSequence charSequence) {
        this.f11046U = charSequence;
        if (R0()) {
            Q();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void W0(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.widget.TextView r4 = (android.widget.TextView) r4
            boolean r0 = r3.f11045T
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r3.f11046U
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r3.f11046U
            r4.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r3.f11045T
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.f11047V
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.f11047V
            r4.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r3 = r3.G()
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.W0(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    protected void X() {
        super.X();
        boolean z5 = !R0();
        if (d(Boolean.valueOf(z5))) {
            S0(z5);
        }
    }

    protected void X0(l lVar) {
        W0(lVar.a(R.id.summary));
    }

    @Override // androidx.preference.Preference
    protected Object a0(TypedArray typedArray, int i5) {
        return Boolean.valueOf(typedArray.getBoolean(i5, false));
    }

    @Override // androidx.preference.Preference
    protected void e0(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(a.class)) {
            super.e0(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.e0(aVar.getSuperState());
        S0(aVar.f11050a);
    }

    @Override // androidx.preference.Preference
    protected Parcelable f0() {
        Parcelable parcelableF0 = super.f0();
        if (N()) {
            return parcelableF0;
        }
        a aVar = new a(parcelableF0);
        aVar.f11050a = R0();
        return aVar;
    }

    @Override // androidx.preference.Preference
    protected void g0(Object obj) {
        if (obj == null) {
            obj = Boolean.FALSE;
        }
        S0(w(((Boolean) obj).booleanValue()));
    }

    static class a extends Preference.b {
        public static final Parcelable.Creator<a> CREATOR = new C0142a();

        /* renamed from: a, reason: collision with root package name */
        boolean f11050a;

        /* renamed from: androidx.preference.TwoStatePreference$a$a, reason: collision with other inner class name */
        class C0142a implements Parcelable.Creator<a> {
            C0142a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public a[] newArray(int i5) {
                return new a[i5];
            }
        }

        a(Parcel parcel) {
            super(parcel);
            this.f11050a = parcel.readInt() == 1;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.f11050a ? 1 : 0);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i5) {
        this(context, attributeSet, i5, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TwoStatePreference(Context context) {
        this(context, null);
    }
}
