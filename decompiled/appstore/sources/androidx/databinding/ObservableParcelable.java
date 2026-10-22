package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class ObservableParcelable<T extends Parcelable> extends ObservableField<T> implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = null;
    static final long serialVersionUID = 1;

    public static class a implements Parcelable.Creator {
        public a() {
        }

        public ObservableParcelable a(Parcel r10) {
            return new ObservableParcelable(r10.readParcelable(a.class.getClassLoader()));
        }

        public ObservableParcelable[] b(int r10) {
            return new ObservableParcelable[r10];
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

    public ObservableParcelable(T r10) {
        super(r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeParcelable(get(), 0);
    }

    public ObservableParcelable() {
    }
}
