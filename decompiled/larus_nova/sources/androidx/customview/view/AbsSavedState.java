package androidx.customview.view;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes17.dex */
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = null;
    public static final AbsSavedState EMPTY_STATE = null;
    private final Parcelable mSuperState;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        EMPTY_STATE = new AnonymousClass1();
        CREATOR = new AnonymousClass2();
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    public AbsSavedState(Parcelable r100) {
        if (r100 == null) goto L11;
        if (r100 != EMPTY_STATE) goto L8;
        r100 = null;
    L8:
        this.mSuperState = r100;
        return;
    L11:
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(Parcel r100) {
        this(r100, null);
    }

    public /* synthetic */ AbsSavedState(AnonymousClass1 r100) {
        this();
    }

    public AbsSavedState(Parcel r100, ClassLoader r101) {
        Parcelable r102 = r100.readParcelable(r101);
        if (r102 != null) goto L6;
        r102 = EMPTY_STATE;
    L6:
        this.mSuperState = r102;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeParcelable(this.mSuperState, r101);
    }
}
