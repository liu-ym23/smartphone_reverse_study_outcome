package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003\u0016\u0017\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameDisplayRatioConfig;", "", "()V", "enable", "", "getEnable", "()Z", "enterRoomOptEnable", "getEnterRoomOptEnable", "isFoldScreenEnable", "supportPlayerScene", "", "", "getSupportPlayerScene", "()Ljava/util/List;", "supportRatio", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameDisplayRatioConfig$SupportRatio;", "getSupportRatio", "supportRoomScene", "getSupportRoomScene", "switch", "getSwitch", "DisplayPlayerScene", "DisplayRoomScene", "SupportRatio", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameDisplayRatioConfig {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enter_room_opt_enable")
    private final boolean enterRoomOptEnable;

    @SerializedName("is_foldscreen_enable")
    private final boolean isFoldScreenEnable;

    @SerializedName("support_player_scene")
    private final List<Integer> supportPlayerScene;

    @SerializedName("support_ratio")
    private final List<SupportRatio> supportRatio;

    @SerializedName("support_room_scene")
    private final List<Integer> supportRoomScene;

    /* JADX INFO: renamed from: switch, reason: not valid java name */
    @SerializedName("switch")
    private final boolean f93switch;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameDisplayRatioConfig$DisplayPlayerScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SCENE_PLAYER_NORMAL", "SCENE_PLAYER_WITH_EXTRA", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DisplayPlayerScene extends Enum<DisplayPlayerScene> {
        private static final /* synthetic */ DisplayPlayerScene[] $VALUES = null;
        public static final DisplayPlayerScene SCENE_PLAYER_NORMAL = null;
        public static final DisplayPlayerScene SCENE_PLAYER_WITH_EXTRA = null;
        private final int value;

        static {
            DisplayPlayerScene r100 = new DisplayPlayerScene("SCENE_PLAYER_NORMAL", 0, 0);
            SCENE_PLAYER_NORMAL = r100;
            DisplayPlayerScene r101 = new DisplayPlayerScene("SCENE_PLAYER_WITH_EXTRA", 1, 1);
            SCENE_PLAYER_WITH_EXTRA = r101;
            $VALUES = new DisplayPlayerScene[]{r100, r101};
        }

        public static DisplayPlayerScene valueOf(String r100) {
            return (DisplayPlayerScene) a.a(DisplayPlayerScene.class, r100);
        }

        public static DisplayPlayerScene[] values() {
            return (DisplayPlayerScene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        private DisplayPlayerScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameDisplayRatioConfig$DisplayRoomScene;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SCENE_ROOM_THIRD", "SCENE_ROOM_SCREEN_RECORD", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum DisplayRoomScene extends Enum<DisplayRoomScene> {
        private static final /* synthetic */ DisplayRoomScene[] $VALUES = null;
        public static final DisplayRoomScene SCENE_ROOM_SCREEN_RECORD = null;
        public static final DisplayRoomScene SCENE_ROOM_THIRD = null;
        private final int value;

        static {
            DisplayRoomScene r100 = new DisplayRoomScene("SCENE_ROOM_THIRD", 0, 2);
            SCENE_ROOM_THIRD = r100;
            DisplayRoomScene r101 = new DisplayRoomScene("SCENE_ROOM_SCREEN_RECORD", 1, 3);
            SCENE_ROOM_SCREEN_RECORD = r101;
            $VALUES = new DisplayRoomScene[]{r100, r101};
        }

        public static DisplayRoomScene valueOf(String r100) {
            return (DisplayRoomScene) a.a(DisplayRoomScene.class, r100);
        }

        public static DisplayRoomScene[] values() {
            return (DisplayRoomScene[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }

        private DisplayRoomScene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/GameDisplayRatioConfig$SupportRatio;", "", "ratioWidth", "", "ratioHeight", "(II)V", "getRatioHeight", "()I", "getRatioWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SupportRatio {

        @SerializedName("h")
        private final int ratioHeight;

        @SerializedName("w")
        private final int ratioWidth;

        public SupportRatio() {
            int r100 = 0;
            this(r100, r100, 3, null);
        }

        public static /* synthetic */ SupportRatio copy$default(SupportRatio r100, int r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.ratioWidth;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.ratioHeight;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.ratioWidth;
        }

        public final int component2() {
            return this.ratioHeight;
        }

        public final SupportRatio copy(int r100, int r101) {
            return new SupportRatio(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof SupportRatio) == false) goto L10;
            SupportRatio r101 = (SupportRatio) r100;
            if (this.ratioWidth == r101.ratioWidth) goto L8;
            return false;
        L8:
            if (this.ratioHeight == r101.ratioHeight) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            return (this.ratioWidth * 31) + this.ratioHeight;
        }

        public String toString() {
            return "SupportRatio(ratioWidth=" + this.ratioWidth + ", ratioHeight=" + this.ratioHeight + ")";
        }

        public final int getRatioHeight() {
            return this.ratioHeight;
        }

        public final int getRatioWidth() {
            return this.ratioWidth;
        }

        public SupportRatio(int r100, int r101) {
            this.ratioWidth = r100;
            this.ratioHeight = r101;
        }

        public /* synthetic */ SupportRatio(int r100, int r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 0;
        L8:
            this(r100, r101);
        }
    }

    public GameDisplayRatioConfig() {
        this.supportPlayerScene = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(DisplayPlayerScene.SCENE_PLAYER_NORMAL.getValue())});
        this.supportRoomScene = CollectionsKt.mutableListOf(new Integer[]{Integer.valueOf(DisplayRoomScene.SCENE_ROOM_THIRD.getValue()), Integer.valueOf(DisplayRoomScene.SCENE_ROOM_SCREEN_RECORD.getValue())});
        this.supportRatio = new ArrayList();
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getEnterRoomOptEnable() {
        return this.enterRoomOptEnable;
    }

    public final List<Integer> getSupportPlayerScene() {
        return this.supportPlayerScene;
    }

    public final List<SupportRatio> getSupportRatio() {
        return this.supportRatio;
    }

    public final List<Integer> getSupportRoomScene() {
        return this.supportRoomScene;
    }

    public final boolean getSwitch() {
        return this.f93switch;
    }

    public final boolean isFoldScreenEnable() {
        return this.isFoldScreenEnable;
    }
}
