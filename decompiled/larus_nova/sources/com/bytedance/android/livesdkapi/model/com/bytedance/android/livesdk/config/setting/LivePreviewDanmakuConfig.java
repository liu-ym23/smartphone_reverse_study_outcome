package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdk.config.dk0;
import com.bytedance.android.livesdk.config.ek0;
import com.bytedance.android.livesdk.config.lk0;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00101\u001a\u00020+R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u001e\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR\u001e\u0010.\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001a¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/setting/LivePreviewDanmakuConfig;", "", "()V", "ageLevel", "", "getAgeLevel", "()I", "setAgeLevel", "(I)V", "ageLevelList", "", "getAgeLevelList", "()Ljava/util/List;", "setAgeLevelList", "(Ljava/util/List;)V", "danmakuTimeoutTime", "", "getDanmakuTimeoutTime", "()J", "setDanmakuTimeoutTime", "(J)V", "deviceScore", "", "getDeviceScore", "()F", "setDeviceScore", "(F)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "fromDeviceScore", "getFromDeviceScore", "setFromDeviceScore", "maxLongPressGuideCount", "getMaxLongPressGuideCount", "setMaxLongPressGuideCount", "speed", "getSpeed", "setSpeed", "supportEntrance", "", "getSupportEntrance", "setSupportEntrance", "toDeviceScore", "getToDeviceScore", "setToDeviceScore", "getDebugString", "Companion", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePreviewDanmakuConfig {
    public static final Companion Companion = null;

    @SerializedName("age_level")
    private int ageLevel;

    @SerializedName("age_level_list")
    private List<Integer> ageLevelList;

    @SerializedName("danmaku_timeout_time")
    private long danmakuTimeoutTime;

    @SerializedName("device_score")
    private float deviceScore;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("from_device_score")
    private float fromDeviceScore;

    @SerializedName("max_long_press_guide_count")
    private int maxLongPressGuideCount;

    @SerializedName("speed")
    private int speed;

    @SerializedName("support_entrance")
    private List<String> supportEntrance;

    @SerializedName("to_device_score")
    private float toDeviceScore;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0006\u0010\u0005\u001a\u00020\u0006J\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nJ\b\u0010\u000e\u001a\u00020\fH\u0007J\b\u0010\u000f\u001a\u00020\fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/setting/LivePreviewDanmakuConfig$Companion;", "", "()V", "getConfig", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/setting/LivePreviewDanmakuConfig;", "getDanmakuTimeoutTime", "", "getHistoryDanmakuTimeoutDuration", "getSupportFeedEntranceList", "", "", "isFeedEntranceEnable", "", "enterFromMerge", "isHistoryDanmakuEnable", "isPreviewDanmakuEnable", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        @JvmStatic
        public final LivePreviewDanmakuConfig getConfig() {
            return lk0.f120689a.getValue();
        }

        public final long getHistoryDanmakuTimeoutDuration() {
            return ek0.f120135a.getValue().longValue();
        }

        @JvmStatic
        public final boolean isHistoryDanmakuEnable() {
            return dk0.f120041a.getValue().booleanValue();
        }

        private final List<String> getSupportFeedEntranceList() {
            return getConfig().getSupportEntrance();
        }

        public final long getDanmakuTimeoutTime() {
            return getConfig().getDanmakuTimeoutTime();
        }

        @JvmStatic
        public final boolean isPreviewDanmakuEnable() {
            return getConfig().getEnable();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final boolean isFeedEntranceEnable(String r100) {
            if (r100 != null) goto L6;
            return false;
        L6:
            return getSupportFeedEntranceList().contains(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @JvmStatic
    public static final LivePreviewDanmakuConfig getConfig() {
        return Companion.getConfig();
    }

    @JvmStatic
    public static final boolean isHistoryDanmakuEnable() {
        return Companion.isHistoryDanmakuEnable();
    }

    @JvmStatic
    public static final boolean isPreviewDanmakuEnable() {
        return Companion.isPreviewDanmakuEnable();
    }

    public final String getDebugString() {
        return "LivePreviewDanmakuConfig(enable=" + this.enable + ", speed=" + this.speed + ", ageLevel=" + this.ageLevel + ", ageLevelList=" + this.ageLevelList + ", deviceScore=" + this.deviceScore + ", fromDeviceScore=" + this.fromDeviceScore + ", toDeviceScore=" + this.toDeviceScore + ", supportEntrance=" + this.supportEntrance + ", maxLongPressGuideCount=" + this.maxLongPressGuideCount + ", danmakuTimeoutTime=" + this.danmakuTimeoutTime + ')';
    }

    public LivePreviewDanmakuConfig() {
        this.speed = 52;
        this.ageLevel = 2;
        this.ageLevelList = CollectionsKt.mutableListOf(new Integer[]{0, 1, 2});
        this.deviceScore = 8.8f;
        this.fromDeviceScore = 8.8f;
        this.toDeviceScore = 9999.0f;
        this.supportEntrance = CollectionsKt.mutableListOf(new String[]{UserProfileEvent.DATA_TYPE_HOME_PAGE_HOT, "homepage_follow", "homepage_tablive"});
        this.maxLongPressGuideCount = 1;
        this.danmakuTimeoutTime = 1000;
    }

    public final int getAgeLevel() {
        return this.ageLevel;
    }

    public final List<Integer> getAgeLevelList() {
        return this.ageLevelList;
    }

    public final long getDanmakuTimeoutTime() {
        return this.danmakuTimeoutTime;
    }

    public final float getDeviceScore() {
        return this.deviceScore;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getFromDeviceScore() {
        return this.fromDeviceScore;
    }

    public final int getMaxLongPressGuideCount() {
        return this.maxLongPressGuideCount;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final List<String> getSupportEntrance() {
        return this.supportEntrance;
    }

    public final float getToDeviceScore() {
        return this.toDeviceScore;
    }

    public final void setAgeLevel(int r100) {
        this.ageLevel = r100;
    }

    public final void setAgeLevelList(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.ageLevelList = r100;
    }

    public final void setDanmakuTimeoutTime(long r100) {
        this.danmakuTimeoutTime = r100;
    }

    public final void setDeviceScore(float r100) {
        this.deviceScore = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setFromDeviceScore(float r100) {
        this.fromDeviceScore = r100;
    }

    public final void setMaxLongPressGuideCount(int r100) {
        this.maxLongPressGuideCount = r100;
    }

    public final void setSpeed(int r100) {
        this.speed = r100;
    }

    public final void setSupportEntrance(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.supportEntrance = r100;
    }

    public final void setToDeviceScore(float r100) {
        this.toDeviceScore = r100;
    }
}
