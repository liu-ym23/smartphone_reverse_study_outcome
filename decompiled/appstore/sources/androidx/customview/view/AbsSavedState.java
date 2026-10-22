package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = null;
    public static final AbsSavedState EMPTY_STATE = null;
    private final Parcelable mSuperState;

    public class a implements Parcelable.ClassLoaderCreator {
        public a() {
        }

        public AbsSavedState a(Parcel r10) {
            return b(r10, null);
        }

        public AbsSavedState b(Parcel r10, ClassLoader r11) {
            if (r10.readParcelable(r11) != null) goto L7;
            return AbsSavedState.EMPTY_STATE;
        L7:
            throw new IllegalStateException("superState must be null");
        }

        public AbsSavedState[] c(int r10) {
            return new AbsSavedState[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return c(r10);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10, ClassLoader r11) {
            return b(r10, r11);
        }
    }

    static {
        EMPTY_STATE = new AnonymousClass1();
        CREATOR = new a();
    }

    public /* synthetic */ AbsSavedState(AnonymousClass1 r10) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeParcelable(this.mSuperState, r11);
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    public AbsSavedState(@NonNull Parcelable r10) {
        if (r10 == null) goto L11;
        if (r10 != EMPTY_STATE) goto L8;
        r10 = null;
    L8:
        this.mSuperState = r10;
        return;
    L11:
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(@NonNull Parcel r10) {
        this(r10, null);
    }

    public AbsSavedState(@NonNull Parcel r10, @Nullable ClassLoader r11) {
        Parcelable r12 = r10.readParcelable(r11);
        if (r12 != null) goto L6;
        r12 = EMPTY_STATE;
    L6:
        this.mSuperState = r12;
    }
}
