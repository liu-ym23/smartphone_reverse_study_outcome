package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableByte extends b implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = null;
    static final long serialVersionUID = 1;
    private byte mValue;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public ObservableByte a(Parcel r10) {
            return new ObservableByte(r10.readByte());
        }

        public ObservableByte[] b(int r10) {
            return new ObservableByte[r10];
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

    public ObservableByte(byte r10) {
        this.mValue = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte get() {
        return this.mValue;
    }

    public void set(byte r10) {
        if (r10 == this.mValue) goto L6;
        this.mValue = r10;
        notifyChange();
        return;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeByte(this.mValue);
    }

    public ObservableByte() {
    }

    public ObservableByte(Observable... r10) {
        super(r10);
    }
}
