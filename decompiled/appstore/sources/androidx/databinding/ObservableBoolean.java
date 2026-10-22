package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableBoolean extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = null;
    static final long serialVersionUID = 1;
    private boolean mValue;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public ObservableBoolean a(Parcel r10) {
            boolean r11 = true;
            if (r10.readInt() == 1) goto L7;
            r11 = false;
        L7:
            return new ObservableBoolean(r11);
        }

        public ObservableBoolean[] b(int r10) {
            return new ObservableBoolean[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Object[] newArray(int r10) {
            return b(r10);
        }
    }

    static {
        CREATOR = new a();
    }

    public ObservableBoolean(boolean r10) {
        this.mValue = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean get() {
        return this.mValue;
    }

    public void set(boolean r10) {
        if (r10 == this.mValue) goto L6;
        this.mValue = r10;
        notifyChange();
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mValue ? 1 : 0);
    }

    public ObservableBoolean() {
    }

    public ObservableBoolean(Observable... r10) {
        super(r10);
    }
}
