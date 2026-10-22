package android.cypress.mediacontext;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionMetaEntry implements Parcelable {
    public static final Parcelable.Creator<MediaSessionMetaEntry> CREATOR = null;
    public String key;
    public String value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediaSessionMetaEntry() {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        int r4 = r2.dataPosition();
        r2.writeInt(0);
        r2.writeString(this.key);
        r2.writeString(this.value);
        int r1 = r2.dataPosition();
        r2.setDataPosition(r4);
        r2.writeInt(r1 - r4);
        r2.setDataPosition(r1);
    }

    public final void readFromParcel(Parcel r4) {
        int r0 = r4.dataPosition();
        int r1 = r4.readInt();
        if (r1 >= 0) goto L19;
        return;
    L19:
        this.key = r4.readString();     // Catch: Throwable -> L16
        if ((r4.dataPosition() - r0) < r1) goto L10;
    L8:
        r4.setDataPosition(r0 + r1);
        return;
    L10:
        this.value = r4.readString();     // Catch: Throwable -> L16
        if ((r4.dataPosition() - r0) >= r1) goto L8;
        r4.setDataPosition(r0 + r1);
        return;
    L16:
        th = move-exception;
        r4.setDataPosition(r0 + r1);
        throw th;
    }
}
