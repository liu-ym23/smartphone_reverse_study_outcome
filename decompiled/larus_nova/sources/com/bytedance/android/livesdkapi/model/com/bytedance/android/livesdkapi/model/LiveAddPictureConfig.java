package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010%\"\u0004\b*\u0010'R \u0010+\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u0002018\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR\"\u00109\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001e\u0010<\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdkapi/model/LiveAddPictureConfig;", "", "()V", "addPictureOffset", "", "getAddPictureOffset", "()Ljava/lang/Float;", "setAddPictureOffset", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "cameraResetEnable", "", "getCameraResetEnable", "()Ljava/lang/Boolean;", "setCameraResetEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "guideFuncBlockIdentifiers", "", "", "getGuideFuncBlockIdentifiers", "()Ljava/util/List;", "setGuideFuncBlockIdentifiers", "(Ljava/util/List;)V", "maxImageCnt", "", "getMaxImageCnt", "()I", "setMaxImageCnt", "(I)V", "maxScale", "getMaxScale", "()F", "setMaxScale", "(F)V", "minScale", "getMinScale", "setMinScale", "permissionScheme", "getPermissionScheme", "()Ljava/lang/String;", "setPermissionScheme", "(Ljava/lang/String;)V", "resetDelay", "", "getResetDelay", "()J", "setResetDelay", "(J)V", "resolutionOptEnable", "getResolutionOptEnable", "setResolutionOptEnable", "tempBoundsOffset", "getTempBoundsOffset", "setTempBoundsOffset", "timeoutDuration", "getTimeoutDuration", "setTimeoutDuration", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveAddPictureConfig {

    @SerializedName("add_picture_offset")
    private Float addPictureOffset;

    @SerializedName("camera_reset_enable")
    private Boolean cameraResetEnable;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("guide_func_block_identifiers")
    private List<String> guideFuncBlockIdentifiers;

    @SerializedName("max_image_cnt")
    private int maxImageCnt;

    @SerializedName(TextureRenderKeys.KEY_IS_VR_MAX_SCALE)
    private float maxScale;

    @SerializedName(TextureRenderKeys.KEY_IS_VR_MIN_SCALE)
    private float minScale;

    @SerializedName("permission_scheme")
    private String permissionScheme;

    @SerializedName("reset_delay")
    private long resetDelay;

    @SerializedName("resolution_opt_enable")
    private Boolean resolutionOptEnable;

    @SerializedName("temp_bounds_offset")
    private Float tempBoundsOffset;

    @SerializedName("timeout_duration")
    private int timeoutDuration;

    public LiveAddPictureConfig() {
        this.guideFuncBlockIdentifiers = CollectionsKt.emptyList();
        this.timeoutDuration = 10;
        this.permissionScheme = "sslocal://webcast_lynxview?type=popup&hide_nav_bar=1&hide_status_bar=1&gravity=bottom&height=600&enable_latch=1&url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fcommunity_openlive_douyin%2Fpages%2Fapply_live_permission_platform%2Ftemplate.js";
        this.maxImageCnt = 3;
        this.maxScale = 5.0f;
        this.minScale = 0.05f;
        this.addPictureOffset = Float.valueOf(0.0f);
        this.tempBoundsOffset = Float.valueOf(50.0f);
        this.cameraResetEnable = Boolean.FALSE;
        this.resetDelay = 300;
        this.resolutionOptEnable = Boolean.TRUE;
    }

    public final Float getAddPictureOffset() {
        return this.addPictureOffset;
    }

    public final Boolean getCameraResetEnable() {
        return this.cameraResetEnable;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final List<String> getGuideFuncBlockIdentifiers() {
        return this.guideFuncBlockIdentifiers;
    }

    public final int getMaxImageCnt() {
        return this.maxImageCnt;
    }

    public final float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return this.minScale;
    }

    public final String getPermissionScheme() {
        return this.permissionScheme;
    }

    public final long getResetDelay() {
        return this.resetDelay;
    }

    public final Boolean getResolutionOptEnable() {
        return this.resolutionOptEnable;
    }

    public final Float getTempBoundsOffset() {
        return this.tempBoundsOffset;
    }

    public final int getTimeoutDuration() {
        return this.timeoutDuration;
    }

    public final void setAddPictureOffset(Float r100) {
        this.addPictureOffset = r100;
    }

    public final void setCameraResetEnable(Boolean r100) {
        this.cameraResetEnable = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setGuideFuncBlockIdentifiers(List<String> r100) {
        this.guideFuncBlockIdentifiers = r100;
    }

    public final void setMaxImageCnt(int r100) {
        this.maxImageCnt = r100;
    }

    public final void setMaxScale(float r100) {
        this.maxScale = r100;
    }

    public final void setMinScale(float r100) {
        this.minScale = r100;
    }

    public final void setPermissionScheme(String r100) {
        this.permissionScheme = r100;
    }

    public final void setResetDelay(long r100) {
        this.resetDelay = r100;
    }

    public final void setResolutionOptEnable(Boolean r100) {
        this.resolutionOptEnable = r100;
    }

    public final void setTempBoundsOffset(Float r100) {
        this.tempBoundsOffset = r100;
    }

    public final void setTimeoutDuration(int r100) {
        this.timeoutDuration = r100;
    }
}
