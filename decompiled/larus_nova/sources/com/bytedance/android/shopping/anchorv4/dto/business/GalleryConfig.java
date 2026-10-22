package com.bytedance.android.shopping.anchorv4.dto.business;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/dto/business/GalleryConfig;", "Ljava/io/Serializable;", RemoteMessageConst.Notification.VISIBILITY, "", "", "Lcom/bytedance/android/shopping/anchorv4/dto/business/GallerySliceVisibilityConfig;", "enableScreenShot", "", "screenShotHideVideo", "(Ljava/util/Map;ZZ)V", "getEnableScreenShot", "()Z", "getScreenShotHideVideo", "getVisibility", "()Ljava/util/Map;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GalleryConfig implements Serializable {

    @SerializedName("enable_screen_shot")
    private final boolean enableScreenShot;

    @SerializedName("screen_shot_hide_video")
    private final boolean screenShotHideVideo;

    @SerializedName(RemoteMessageConst.Notification.VISIBILITY)
    private final Map<String, GallerySliceVisibilityConfig> visibility;

    public GalleryConfig() {
        this(null, false, false, 7, null);
    }

    public final boolean getEnableScreenShot() {
        return this.enableScreenShot;
    }

    public final boolean getScreenShotHideVideo() {
        return this.screenShotHideVideo;
    }

    public final Map<String, GallerySliceVisibilityConfig> getVisibility() {
        return this.visibility;
    }

    public GalleryConfig(Map<String, GallerySliceVisibilityConfig> r100, boolean r101, boolean r102) {
        this.visibility = r100;
        this.enableScreenShot = r101;
        this.screenShotHideVideo = r102;
    }

    public /* synthetic */ GalleryConfig(Map r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = false;
    L11:
        this(r100, r101, r102);
    }
}
