package bytedance.io;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes28.dex */
public class BdMediaFolder implements Parcelable {
    public static final Parcelable.Creator<BdMediaFolder> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f21475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Uri f21477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f21478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f21479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f21480f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f21481g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList<BdMediaItem> f21482h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList<BdMediaItem> f21483i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<BdMediaItem> f21484j;

    public static class a implements Parcelable.Creator<BdMediaFolder> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BdMediaFolder createFromParcel(Parcel r100) {
            return new BdMediaFolder(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BdMediaFolder[] newArray(int r100) {
            return new BdMediaFolder[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public BdMediaFolder() {
        this.f21475a = -1;
        this.f21482h = new ArrayList();
        this.f21483i = new ArrayList();
        this.f21484j = new ArrayList();
    }

    public BdMediaFolder(Parcel r100) {
        this.f21475a = -1;
        this.f21482h = new ArrayList();
        this.f21483i = new ArrayList();
        this.f21484j = new ArrayList();
        this.f21475a = r100.readLong();
        this.f21476b = r100.readString();
        this.f21477c = (Uri) r100.readParcelable(Uri.class.getClassLoader());
        this.f21478d = r100.readString();
        this.f21479e = r100.readLong();
        this.f21480f = r100.readInt();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f21481g = r101;
        Parcelable.Creator<BdMediaItem> r102 = BdMediaItem.CREATOR;
        this.f21482h = r100.createTypedArrayList(r102);
        this.f21483i = r100.createTypedArrayList(r102);
        this.f21484j = r100.createTypedArrayList(r102);
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f21475a);
        r100.writeString(this.f21476b);
        r100.writeParcelable(this.f21477c, r101);
        r100.writeString(this.f21478d);
        r100.writeLong(this.f21479e);
        r100.writeInt(this.f21480f);
        r100.writeByte(this.f21481g ? 1 : 0);
        r100.writeTypedList(this.f21482h);
        r100.writeTypedList(this.f21483i);
        r100.writeTypedList(this.f21484j);
    }
}
