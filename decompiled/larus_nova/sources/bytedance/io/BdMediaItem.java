package bytedance.io;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes28.dex */
public class BdMediaItem implements Parcelable {
    public static final Parcelable.Creator<BdMediaItem> CREATOR = null;
    private String album;
    private long albumId;
    private String artist;
    private long bucketId;
    private String bucketName;
    private long dateAdded;
    private long dateToken;
    private long duration;
    private long fileSize;
    private int height;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private long f21485id;
    private String mimeType;
    private long modify;
    private int musicType;
    private String name;
    private int orientation;
    private String relativePath;
    private String resolution;
    private String title;
    private Uri uri;
    private int width;

    public static class a implements Parcelable.Creator<BdMediaItem> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BdMediaItem createFromParcel(Parcel r100) {
            return new BdMediaItem(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BdMediaItem[] newArray(int r100) {
            return new BdMediaItem[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "BdMediaItem{id=" + this.f21485id + ", name='" + this.name + "', modify=" + this.modify + ", dateAdded=" + this.dateAdded + ", mimeType='" + this.mimeType + "', duration=" + this.duration + ", fileSize=" + this.fileSize + ", width=" + this.width + ", height=" + this.height + ", musicType=" + this.musicType + ", uri=" + this.uri + ", relativePath='" + this.relativePath + "', dateToken=" + this.dateToken + ", orientation=" + this.orientation + ", resolution='" + this.resolution + "', album='" + this.album + "', artist='" + this.artist + "', title='" + this.title + "', albumId=" + this.albumId + ", bucketId=" + this.bucketId + ", bucketName=" + this.bucketName + '}';
    }

    public BdMediaItem() {
    }

    public String getAlbum() {
        return this.album;
    }

    public long getAlbumId() {
        return this.albumId;
    }

    public String getArtist() {
        return this.artist;
    }

    public long getBucketId() {
        return this.bucketId;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public long getDateAdded() {
        return this.dateAdded;
    }

    public long getDateToken() {
        return this.dateToken;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getFileSize() {
        return this.fileSize;
    }

    public int getHeight() {
        return this.height;
    }

    public long getId() {
        return this.f21485id;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public long getModify() {
        return this.modify;
    }

    public int getMusicType() {
        return this.musicType;
    }

    public String getName() {
        return this.name;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public String getRelativePath() {
        return this.relativePath;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getTitle() {
        return this.title;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int getWidth() {
        return this.width;
    }

    public BdMediaItem(Parcel r100) {
        this.f21485id = r100.readLong();
        this.name = r100.readString();
        this.modify = r100.readLong();
        this.dateAdded = r100.readLong();
        this.mimeType = r100.readString();
        this.duration = r100.readLong();
        this.fileSize = r100.readLong();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.musicType = r100.readInt();
        this.uri = (Uri) r100.readParcelable(Uri.class.getClassLoader());
        this.relativePath = r100.readString();
        this.dateToken = r100.readLong();
        this.orientation = r100.readInt();
        this.resolution = r100.readString();
        this.album = r100.readString();
        this.artist = r100.readString();
        this.title = r100.readString();
        this.albumId = r100.readLong();
        this.bucketId = r100.readLong();
        this.bucketName = r100.readString();
    }

    public void readFromParcel(Parcel r100) {
        this.f21485id = r100.readLong();
        this.name = r100.readString();
        this.modify = r100.readLong();
        this.dateAdded = r100.readLong();
        this.mimeType = r100.readString();
        this.duration = r100.readLong();
        this.fileSize = r100.readLong();
        this.width = r100.readInt();
        this.height = r100.readInt();
        this.musicType = r100.readInt();
        this.uri = (Uri) r100.readParcelable(Uri.class.getClassLoader());
        this.relativePath = r100.readString();
        this.dateToken = r100.readLong();
        this.orientation = r100.readInt();
        this.resolution = r100.readString();
        this.album = r100.readString();
        this.artist = r100.readString();
        this.title = r100.readString();
        this.albumId = r100.readLong();
        this.bucketId = r100.readLong();
        this.bucketName = r100.readString();
    }

    public void setAlbum(String r100) {
        this.album = r100;
    }

    public void setAlbumId(long r100) {
        this.albumId = r100;
    }

    public void setArtist(String r100) {
        this.artist = r100;
    }

    public void setBucketId(long r100) {
        this.bucketId = r100;
    }

    public void setBucketName(String r100) {
        this.bucketName = r100;
    }

    public void setDateAdded(long r100) {
        this.dateAdded = r100;
    }

    public void setDateToken(long r100) {
        this.dateToken = r100;
    }

    public void setDuration(long r100) {
        this.duration = r100;
    }

    public void setFileSize(long r100) {
        this.fileSize = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setId(long r100) {
        this.f21485id = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setModify(long r100) {
        this.modify = r100;
    }

    public void setMusicType(int r100) {
        this.musicType = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setOrientation(int r100) {
        this.orientation = r100;
    }

    public void setRelativePath(String r100) {
        this.relativePath = r100;
    }

    public void setResolution(String r100) {
        this.resolution = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }

    public void setUri(Uri r100) {
        this.uri = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeLong(this.f21485id);
        r100.writeString(this.name);
        r100.writeLong(this.modify);
        r100.writeLong(this.dateAdded);
        r100.writeString(this.mimeType);
        r100.writeLong(this.duration);
        r100.writeLong(this.fileSize);
        r100.writeInt(this.width);
        r100.writeInt(this.height);
        r100.writeInt(this.musicType);
        r100.writeParcelable(this.uri, r101);
        r100.writeString(this.relativePath);
        r100.writeLong(this.dateToken);
        r100.writeInt(this.orientation);
        r100.writeString(this.resolution);
        r100.writeString(this.album);
        r100.writeString(this.artist);
        r100.writeString(this.title);
        r100.writeLong(this.albumId);
        r100.writeLong(this.bucketId);
        r100.writeString(this.bucketName);
    }
}
