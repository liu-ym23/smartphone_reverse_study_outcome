package com.bytedance.android.live.emoji.online.model;

import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 ,2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b*\u0010+J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000e\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\"\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u000e\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012R\"\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000e\u001a\u0004\b(\u0010\u0010\"\u0004\b)\u0010\u0012¨\u0006."}, d2 = {"Lcom/bytedance/android/live/emoji/online/model/OnlineSmallEmojiResInfo;", "Ljava/io/Serializable;", "", "isValid", "", "toString", "", "id", "J", "getId", "()J", "setId", "(J)V", CommonConstant.KEY_DISPLAY_NAME, "Ljava/lang/String;", "getDisplayName", "()Ljava/lang/String;", "setDisplayName", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "miniCover", "getMiniCover", "setMiniCover", "", "Lcom/bytedance/android/live/emoji/online/model/OnlineSmallEmoji;", "stickers", "Ljava/util/List;", "getStickers", "()Ljava/util/List;", "setStickers", "(Ljava/util/List;)V", "md5", "getMd5", "setMd5", "resDirPath", "getResDirPath", "setResDirPath", "picFileDirPath", "getPicFileDirPath", "setPicFileDirPath", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveemoji-impl_release"}, k = 1, mv = {1, 4, 3})
public final class OnlineSmallEmojiResInfo implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName(IGoogleService.ResponseKey.DISPLAY_NAME)
    private String displayName;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f68941id;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f68942md5;

    @SerializedName("mini_cover")
    private String miniCover;
    private String picFileDirPath;
    private String resDirPath;

    @SerializedName("stickers")
    private List<OnlineSmallEmoji> stickers;

    @SerializedName("version")
    private long version;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isValid() {
        List<OnlineSmallEmoji> r100 = this.stickers;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        if (this.f68942md5.length() <= 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == true) goto L16;
        return false;
    L16:
        if (this.resDirPath.length() <= 0) goto L18;
        boolean r103 = true;
    L19:
        if (r103 == true) goto L21;
        return false;
    L21:
        if (this.picFileDirPath.length() <= 0) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L30;
        return true;
    L30:
        return false;
    L23:
        r104 = false;
        goto L24
    L18:
        r103 = false;
        goto L19
    L13:
        r102 = false;
        goto L14
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("OnlineSmallEmojiResInfo{md5=");
        r100.append(this.f68942md5);
        r100.append(", resDirPath=");
        r100.append(this.resDirPath);
        r100.append(", picFilePath=");
        r100.append(this.picFileDirPath);
        r100.append(", stickers=");
        List<OnlineSmallEmoji> r101 = this.stickers;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.size());
    L6:
        r100.append(r102);
        r100.append('}');
        return r100.toString();
    L5:
        r102 = null;
        goto L6
    }

    public OnlineSmallEmojiResInfo() {
        this.displayName = "";
        this.miniCover = "";
        this.f68942md5 = "";
        this.resDirPath = "";
        this.picFileDirPath = "";
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final long getId() {
        return this.f68941id;
    }

    public final String getMd5() {
        return this.f68942md5;
    }

    public final String getMiniCover() {
        return this.miniCover;
    }

    public final String getPicFileDirPath() {
        return this.picFileDirPath;
    }

    public final String getResDirPath() {
        return this.resDirPath;
    }

    public final List<OnlineSmallEmoji> getStickers() {
        return this.stickers;
    }

    public final long getVersion() {
        return this.version;
    }

    public final void setDisplayName(String r100) {
        this.displayName = r100;
    }

    public final void setId(long r100) {
        this.f68941id = r100;
    }

    public final void setMd5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f68942md5 = r100;
    }

    public final void setMiniCover(String r100) {
        this.miniCover = r100;
    }

    public final void setPicFileDirPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.picFileDirPath = r100;
    }

    public final void setResDirPath(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resDirPath = r100;
    }

    public final void setStickers(List<OnlineSmallEmoji> r100) {
        this.stickers = r100;
    }

    public final void setVersion(long r100) {
        this.version = r100;
    }
}
