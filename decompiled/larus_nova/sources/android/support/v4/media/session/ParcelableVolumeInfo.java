package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes2.dex */
public class ParcelableVolumeInfo implements Parcelable {
    public static final Parcelable.Creator<ParcelableVolumeInfo> CREATOR = null;
    public int audioStream;
    public int controlType;
    public int currentVolume;
    public int maxVolume;
    public int volumeType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new AnonymousClass1();
    }

    public ParcelableVolumeInfo(Parcel r100) {
        this.volumeType = r100.readInt();
        this.controlType = r100.readInt();
        this.maxVolume = r100.readInt();
        this.currentVolume = r100.readInt();
        this.audioStream = r100.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(this.volumeType);
        r100.writeInt(this.controlType);
        r100.writeInt(this.maxVolume);
        r100.writeInt(this.currentVolume);
        r100.writeInt(this.audioStream);
    }

    public ParcelableVolumeInfo(int r100, int r101, int r102, int r103, int r104) {
        this.volumeType = r100;
        this.audioStream = r101;
        this.controlType = r102;
        this.maxVolume = r103;
        this.currentVolume = r104;
    }
}
