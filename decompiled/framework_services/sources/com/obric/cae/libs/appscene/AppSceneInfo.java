package com.obric.cae.libs.appscene;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class AppSceneInfo implements Parcelable {
    public static final Parcelable.Creator<AppSceneInfo> CREATOR = null;
    public static final int SCENE_COMMON = 0;
    public static final int SCENE_FILE_DOWNLOAD = 11;
    public static final int SCENE_FILE_UPLOAD = 10;
    public static final int SCENE_GAMEPLAY = 5;
    public static final int SCENE_GAME_LOBBY = 6;
    public static final int SCENE_LIVE_BROADCAST = 4;
    public static final int SCENE_LIVE_PLAY = 3;
    public static final int SCENE_LONG_VIDEO = 2;
    public static final int SCENE_MEETING = 9;
    public static final int SCENE_SHORT_VIDEO = 1;
    public static final int SCENE_VIDEO_CALL = 7;
    public static final int SCENE_VOICE_CALL = 8;
    public static final int SCENE_WEBPAGES = 12;
    public static final int STATUS_ENTER = 1;
    public static final int STATUS_EXIT = 0;
    private final String mPackageName;
    private final int mScene;
    private final int mStatus;

    public class a implements Parcelable.Creator<AppSceneInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final AppSceneInfo createFromParcel(Parcel r2) {
            return new AppSceneInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final AppSceneInfo[] newArray(int r1) {
            return new AppSceneInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public AppSceneInfo(String r1, int r2, int r3) {
        this.mPackageName = r1;
        this.mScene = r2;
        this.mStatus = r3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppSceneInfo) == true) goto L8;
        return false;
    L8:
        AppSceneInfo r6 = (AppSceneInfo) r5;
        if (this.mScene != r6.mScene) goto L16;
        if (this.mStatus != r6.mStatus) goto L16;
        if (Objects.equals(this.mPackageName, r6.mPackageName) == false) goto L16;
        return true;
    L16:
        return false;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public int getScene() {
        return this.mScene;
    }

    public int getStatus() {
        return this.mStatus;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.mPackageName, Integer.valueOf(this.mScene), Integer.valueOf(this.mStatus)});
    }

    public String toString() {
        return "AppSceneInfo{packageName='" + this.mPackageName + "', scene=" + this.mScene + ", status=" + this.mStatus + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.mPackageName);
        r1.writeInt(this.mScene);
        r1.writeInt(this.mStatus);
    }

    public AppSceneInfo(Parcel r2) {
        this.mPackageName = r2.readString();
        this.mScene = r2.readInt();
        this.mStatus = r2.readInt();
    }
}
