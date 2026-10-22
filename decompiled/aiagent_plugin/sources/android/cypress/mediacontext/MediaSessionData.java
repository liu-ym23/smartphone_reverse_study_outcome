package android.cypress.mediacontext;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionData implements Parcelable {
    public static final Parcelable.Creator<MediaSessionData> CREATOR = null;
    public List<MediaSessionMetaEntry> data;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public MediaSessionData() {
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        int r4 = r2.dataPosition();
        r2.writeInt(0);
        r2.writeTypedList(this.data);
        int r1 = r2.dataPosition();
        r2.setDataPosition(r4);
        r2.writeInt(r1 - r4);
        r2.setDataPosition(r1);
    }

    public final void readFromParcel(Parcel r4) {
        int r0 = r4.dataPosition();
        int r1 = r4.readInt();
        if (r1 >= 0) goto L15;
        return;
    L15:
        this.data = r4.createTypedArrayList(MediaSessionMetaEntry.CREATOR);     // Catch: Throwable -> L12
        if ((r4.dataPosition() - r0) < r1) goto L10;
        r4.setDataPosition(r0 + r1);
        return;
    L10:
        r4.setDataPosition(r0 + r1);
        return;
    L12:
        th = move-exception;
        r4.setDataPosition(r0 + r1);
        throw th;
    }
}
