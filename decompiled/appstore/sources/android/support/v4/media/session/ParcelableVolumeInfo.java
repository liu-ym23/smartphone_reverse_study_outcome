package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = null;
    public int audioStream;
    public int controlType;
    public int currentVolume;
    public int maxVolume;
    public int volumeType;

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableVolumeInfo(int r10, int r11, int r12, int r13, int r14) {
        this.volumeType = r10;
        this.audioStream = r11;
        this.controlType = r12;
        this.maxVolume = r13;
        this.currentVolume = r14;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        r10.writeInt(this.volumeType);
        r10.writeInt(this.controlType);
        r10.writeInt(this.maxVolume);
        r10.writeInt(this.currentVolume);
        r10.writeInt(this.audioStream);
    }

    public ParcelableVolumeInfo(Parcel r10) {
        this.volumeType = r10.readInt();
        this.controlType = r10.readInt();
        this.maxVolume = r10.readInt();
        this.currentVolume = r10.readInt();
        this.audioStream = r10.readInt();
    }
}
