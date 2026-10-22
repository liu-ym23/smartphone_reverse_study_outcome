package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableInt extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = null;
    static final long serialVersionUID = 1;
    private int mValue;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public ObservableInt a(Parcel r10) {
            return new ObservableInt(r10.readInt());
        }

        public ObservableInt[] b(int r10) {
            return new ObservableInt[r10];
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

    public ObservableInt(int r10) {
        this.mValue = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int get() {
        return this.mValue;
    }

    public void set(int r10) {
        if (r10 == this.mValue) goto L6;
        this.mValue = r10;
        notifyChange();
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mValue);
    }

    public ObservableInt() {
    }

    public ObservableInt(Observable... r10) {
        super(r10);
    }
}
