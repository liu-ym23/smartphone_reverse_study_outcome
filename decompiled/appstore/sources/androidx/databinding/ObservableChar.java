package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableChar extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = null;
    static final long serialVersionUID = 1;
    private char mValue;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public ObservableChar a(Parcel r10) {
            return new ObservableChar((char) r10.readInt());
        }

        public ObservableChar[] b(int r10) {
            return new ObservableChar[r10];
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

    public ObservableChar(char r10) {
        this.mValue = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public char get() {
        return this.mValue;
    }

    public void set(char r10) {
        if (r10 == this.mValue) goto L6;
        this.mValue = r10;
        notifyChange();
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.mValue);
    }

    public ObservableChar() {
    }

    public ObservableChar(Observable... r10) {
        super(r10);
    }
}
