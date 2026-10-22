package com.bytedance.android.livesdkapi.player.resolution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u0000 \u00032\u00020\u0001:\n\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\fB\u0005¢\u0006\u0002\u0010\u0002¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution;", "", "()V", "Item", "LEVEL", "NAME", "PICK_STRATEGY", "PickResult", "ResolutionPickStrategy", "SDKKEY", "SMOOTH_SWITCH_ERROR_CODE", "SMOOTH_SWITCH_REASON", "SWITCH_REASON", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayerResolution {
    public static final Item Item = null;
    private static final ResolutionItem auto = null;

    /* JADX INFO: renamed from: hd, reason: collision with root package name */
    private static final ResolutionItem f162648hd = null;

    /* JADX INFO: renamed from: ld, reason: collision with root package name */
    private static final ResolutionItem f162649ld = null;
    private static final ResolutionItem origin = null;

    /* JADX INFO: renamed from: sd, reason: collision with root package name */
    private static final ResolutionItem f162650sd = null;
    private static final ResolutionItem uhd = null;
    private static final ResolutionItem unknown = null;
    private static final ResolutionItem xuhd = null;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0017R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0011\u0010\u000f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0011\u0010\u0011\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0011\u0010\u0013\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$Item;", "", "()V", "auto", "Lcom/bytedance/android/livesdkapi/player/resolution/ResolutionItem;", "getAuto", "()Lcom/bytedance/android/livesdkapi/player/resolution/ResolutionItem;", SDKKEY.HD, "getHd", SDKKEY.LD, "getLd", SDKKEY.ORIGIN, "getOrigin", SDKKEY.SD, "getSd", SDKKEY.UHD, "getUhd", "unknown", "getUnknown", SDKKEY.XUHD, "getXuhd", "getItemByName", "name", "", "getItemBySdkKey", "sdkKey", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Item {
        private Item() {
        }

        public final ResolutionItem getAuto() {
            return PlayerResolution.access$getAuto$cp();
        }

        public final ResolutionItem getHd() {
            return PlayerResolution.access$getHd$cp();
        }

        public final ResolutionItem getLd() {
            return PlayerResolution.access$getLd$cp();
        }

        public final ResolutionItem getOrigin() {
            return PlayerResolution.access$getOrigin$cp();
        }

        public final ResolutionItem getSd() {
            return PlayerResolution.access$getSd$cp();
        }

        public final ResolutionItem getUhd() {
            return PlayerResolution.access$getUhd$cp();
        }

        public final ResolutionItem getUnknown() {
            return PlayerResolution.access$getUnknown$cp();
        }

        public final ResolutionItem getXuhd() {
            return PlayerResolution.access$getXuhd$cp();
        }

        public /* synthetic */ Item(DefaultConstructorMarker r100) {
            this();
        }

        public final ResolutionItem getItemByName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            switch(r100.hashCode()) {
                case 693628: goto L24;
                case 853726: goto L21;
                case 1052158: goto L18;
                case 1075212: goto L15;
                case 1151264: goto L12;
                case 1257005: goto L9;
                case 1034050350: goto L6;
                default: goto L27;
            };
        L6:
            if (r100.equals(NAME.XUHD) == false) goto L27;
            return getXuhd();
        L9:
            if (r100.equals(NAME.SD) == false) goto L27;
            return getSd();
        L12:
            if (r100.equals(NAME.HD) == false) goto L27;
            return getHd();
        L15:
            if (r100.equals(NAME.UHD) == false) goto L27;
            return getUhd();
        L18:
            if (r100.equals(NAME.AUTO) == false) goto L27;
            return getAuto();
        L21:
            if (r100.equals(NAME.LD) == false) goto L27;
            return getLd();
        L24:
            if (r100.equals(NAME.ORIGIN) == false) goto L27;
            return getOrigin();
        L27:
            return getUnknown();
        }

        public final ResolutionItem getItemBySdkKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "sdkKey");
            switch(r100.hashCode()) {
                case -1008619738: goto L24;
                case 3324: goto L21;
                case 3448: goto L18;
                case 3665: goto L15;
                case 115761: goto L12;
                case 3005871: goto L9;
                case 3690681: goto L6;
                default: goto L27;
            };
        L6:
            if (r100.equals(SDKKEY.XUHD) == false) goto L27;
            return getXuhd();
        L9:
            if (r100.equals("auto") == false) goto L27;
            return getAuto();
        L12:
            if (r100.equals(SDKKEY.UHD) == false) goto L27;
            return getUhd();
        L15:
            if (r100.equals(SDKKEY.SD) == false) goto L27;
            return getSd();
        L18:
            if (r100.equals(SDKKEY.LD) == false) goto L27;
            return getLd();
        L21:
            if (r100.equals(SDKKEY.HD) == false) goto L27;
            return getHd();
        L24:
            if (r100.equals(SDKKEY.ORIGIN) == false) goto L27;
            return getOrigin();
        L27:
            return getUnknown();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$LEVEL;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LEVEL {
        public static final int AUTO = 99;
        public static final Companion Companion = null;
        public static final int HD = 3;
        public static final int LD = 1;
        public static final int ORIGIN = 5;
        public static final int SD = 2;
        public static final int UHD = 4;
        public static final int UNKNOWN = 0;
        public static final int XUHD = 7;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$LEVEL$Companion;", "", "()V", "AUTO", "", "HD", "LD", "ORIGIN", "SD", "UHD", "UNKNOWN", "XUHD", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public LEVEL() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$NAME;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class NAME {
        public static final String AUTO = "自动";
        public static final Companion Companion = null;
        public static final String HD = "超清";
        public static final String LD = "标清";
        public static final String ORIGIN = "原画";
        public static final String SD = "高清";
        public static final String UHD = "蓝光";
        public static final String UNKNOWN = "未知";
        public static final String XUHD = "蓝光帧彩";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$NAME$Companion;", "", "()V", "AUTO", "", "HD", "LD", "ORIGIN", "SD", "UHD", "UNKNOWN", "XUHD", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public NAME() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$PICK_STRATEGY;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PICK_STRATEGY {
        public static final Companion Companion = null;
        public static final String FALLBACK = "-1";
        public static final String LOCAL_SAVE = "2";
        public static final String SDK_ABR = "6";
        public static final String SERVER_DEFAULT = "4";
        public static final String STRATEGY = "3";
        public static final String STREAM_STRATEGY = "7";
        public static final String TEMP_MOVE = "5";
        public static final String VPASS = "1";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$PICK_STRATEGY$Companion;", "", "()V", "FALLBACK", "", "LOCAL_SAVE", "SDK_ABR", "SERVER_DEFAULT", "STRATEGY", "STREAM_STRATEGY", "TEMP_MOVE", "VPASS", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public PICK_STRATEGY() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000b\"\u0004\b\u0017\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$PickResult;", "", "resultSdkKey", "", "pickStrategy", "shotStrategyId", "name", "player_resolution_Info", "defaultSdkKey", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDefaultSdkKey", "()Ljava/lang/String;", "setDefaultSdkKey", "(Ljava/lang/String;)V", "getName", "setName", "getPickStrategy", "setPickStrategy", "getPlayer_resolution_Info", "setPlayer_resolution_Info", "getResultSdkKey", "setResultSdkKey", "getShotStrategyId", "setShotStrategyId", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class PickResult {
        private String defaultSdkKey;
        private String name;
        private String pickStrategy;
        private String player_resolution_Info;
        private String resultSdkKey;
        private String shotStrategyId;

        public final String getDefaultSdkKey() {
            return this.defaultSdkKey;
        }

        public final String getName() {
            return this.name;
        }

        public final String getPickStrategy() {
            return this.pickStrategy;
        }

        public final String getPlayer_resolution_Info() {
            return this.player_resolution_Info;
        }

        public final String getResultSdkKey() {
            return this.resultSdkKey;
        }

        public final String getShotStrategyId() {
            return this.shotStrategyId;
        }

        public final void setDefaultSdkKey(String r100) {
            this.defaultSdkKey = r100;
        }

        public final void setName(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.name = r100;
        }

        public final void setPickStrategy(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.pickStrategy = r100;
        }

        public final void setPlayer_resolution_Info(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.player_resolution_Info = r100;
        }

        public final void setResultSdkKey(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.resultSdkKey = r100;
        }

        public final void setShotStrategyId(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.shotStrategyId = r100;
        }

        public PickResult(String r100, String r101, String r102, String r103, String r104, String r105) {
            Intrinsics.checkNotNullParameter(r100, "resultSdkKey");
            Intrinsics.checkNotNullParameter(r101, "pickStrategy");
            Intrinsics.checkNotNullParameter(r102, "shotStrategyId");
            Intrinsics.checkNotNullParameter(r103, "name");
            Intrinsics.checkNotNullParameter(r104, "player_resolution_Info");
            this.resultSdkKey = r100;
            this.pickStrategy = r101;
            this.shotStrategyId = r102;
            this.name = r103;
            this.player_resolution_Info = r104;
            this.defaultSdkKey = r105;
        }

        public /* synthetic */ PickResult(String r110, String r111, String r112, String r113, String r114, String r115, int r116, DefaultConstructorMarker r117) {
            if ((r116 & 4) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r116 & 8) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r116 & 16) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r116 & 32) == 0) goto L17;
            String r103 = "";
        L18:
            this(r110, r111, r100, r101, r102, r103);
            return;
        L17:
            r103 = r115;
            goto L18
        L13:
            r102 = r114;
            goto L15
        L9:
            r101 = r113;
            goto L11
        L5:
            r100 = r112;
            goto L7
        }
    }

    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$ResolutionPickStrategy;", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.FUNCTION})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface ResolutionPickStrategy {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$SDKKEY;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SDKKEY {
        public static final String AUTO = "auto";
        public static final Companion Companion = null;
        public static final String HD = "hd";
        public static final String LD = "ld";
        public static final String ORIGIN = "origin";
        public static final String SD = "sd";
        public static final String UHD = "uhd";
        public static final String UNKNOWN = "unknown";
        public static final String XUHD = "xuhd";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$SDKKEY$Companion;", "", "()V", "AUTO", "", "HD", "LD", "ORIGIN", "SD", "UHD", "UNKNOWN", "XUHD", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public SDKKEY() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$SMOOTH_SWITCH_ERROR_CODE;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SMOOTH_SWITCH_ERROR_CODE {
        public static final int CONFLICT_WITH_PLAYER_STRATEGY = -10004;
        public static final Companion Companion = null;
        public static final int NOT_SUPPORT_RES = -10000;
        public static final int NOT_SUPPORT_SMOOTH_SWITCH = -10003;
        public static final int PLAYER_STATUS_INVALID = -10002;
        public static final int SAME_RES = -10001;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$SMOOTH_SWITCH_ERROR_CODE$Companion;", "", "()V", "CONFLICT_WITH_PLAYER_STRATEGY", "", "NOT_SUPPORT_RES", "NOT_SUPPORT_SMOOTH_SWITCH", "PLAYER_STATUS_INVALID", "SAME_RES", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public SMOOTH_SWITCH_ERROR_CODE() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$SMOOTH_SWITCH_REASON;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SMOOTH_SWITCH_REASON {
        public static final Companion Companion = null;
        public static final int LIVE_STRATEGY = 2;
        public static final int MANUAL_SWITCH = 1;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$SMOOTH_SWITCH_REASON$Companion;", "", "()V", "LIVE_STRATEGY", "", "MANUAL_SWITCH", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public SMOOTH_SWITCH_REASON() {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$SWITCH_REASON;", "", "()V", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SWITCH_REASON {
        public static final String ANCHOR_DEGREE_STREAM_LEVEL = "anchor_degree_stream_level";
        public static final String ANCHOR_UP_STREAM_LEVEL = "anchor_up_stream_level";
        public static final String BACKGROUND_DELAY = "background_delay";
        public static final String BACKGROUND_NO_DELAY = "background_no_delay";
        public static final Companion Companion = null;
        public static final String EC_LYNX_CHANGE_RESOLUTION = "ec_lynx_change_resolution";
        public static final String FALLBACK_REASON = "fallback_reason";
        public static final String FOREGROUND_DELAY = "foreground_delay";
        public static final String FOREGROUND_NO_DELAY = "foreground_no_delay";
        public static final String LANDSCAPE_USER_SELECT = "landscape_user_select";
        public static final String LIVE_PLAYER_ABR = "live_player_abr";
        public static final String LOCK_SCREEN_DELAY = "lock_screen_delay";
        public static final String LOCK_SCREEN_NO_DELAY = "lock_screen_no_delay";
        public static final String PORTRAIT_USER_SELECT = "portrait_user_select";
        public static final String RECOMMEND_SELECT = "recommend_select";
        public static final String SHARE_OUTER_FLOAT_WINDOW_START = "share_outer_float_window_start";
        public static final String SHARE_PLAYER_RESUME = "share_player_resume";
        public static final String STALLMONITOR_DOWNGRADE = "stallMonitor_downgrade";
        public static final String SWITCH_TO_HORIZONTAL = "switch_to_horizontal";
        public static final String SWITCH_TO_PORTRAIT = "switch_to_portrait";
        public static final String UNLOCK_DELAY = "unlock_delay";
        public static final String UNLOCK_NO_DELAY = "unlock_no_delay";
        public static final String XLIVE_CHANGE_RESOLUTION = "xlive_change_resolution";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/player/resolution/PlayerResolution$SWITCH_REASON$Companion;", "", "()V", "ANCHOR_DEGREE_STREAM_LEVEL", "", "ANCHOR_UP_STREAM_LEVEL", "BACKGROUND_DELAY", "BACKGROUND_NO_DELAY", "EC_LYNX_CHANGE_RESOLUTION", "FALLBACK_REASON", "FOREGROUND_DELAY", "FOREGROUND_NO_DELAY", "LANDSCAPE_USER_SELECT", "LIVE_PLAYER_ABR", "LOCK_SCREEN_DELAY", "LOCK_SCREEN_NO_DELAY", "PORTRAIT_USER_SELECT", "RECOMMEND_SELECT", "SHARE_OUTER_FLOAT_WINDOW_START", "SHARE_PLAYER_RESUME", "STALLMONITOR_DOWNGRADE", "SWITCH_TO_HORIZONTAL", "SWITCH_TO_PORTRAIT", "UNLOCK_DELAY", "UNLOCK_NO_DELAY", "XLIVE_CHANGE_RESOLUTION", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public SWITCH_REASON() {
        }
    }

    public PlayerResolution() {
    }

    static {
        Item = new Item(null);
        f162649ld = new ResolutionItem(NAME.LD, SDKKEY.LD, 1);
        f162650sd = new ResolutionItem(NAME.SD, SDKKEY.SD, 2);
        f162648hd = new ResolutionItem(NAME.HD, SDKKEY.HD, 3);
        uhd = new ResolutionItem(NAME.UHD, SDKKEY.UHD, 4);
        xuhd = new ResolutionItem(NAME.XUHD, SDKKEY.XUHD, 7);
        origin = new ResolutionItem(NAME.ORIGIN, SDKKEY.ORIGIN, 5);
        auto = new ResolutionItem(NAME.AUTO, "auto", 99);
        unknown = new ResolutionItem(NAME.UNKNOWN, "unknown", 0);
    }

    public static final /* synthetic */ ResolutionItem access$getAuto$cp() {
        return auto;
    }

    public static final /* synthetic */ ResolutionItem access$getHd$cp() {
        return f162648hd;
    }

    public static final /* synthetic */ ResolutionItem access$getLd$cp() {
        return f162649ld;
    }

    public static final /* synthetic */ ResolutionItem access$getOrigin$cp() {
        return origin;
    }

    public static final /* synthetic */ ResolutionItem access$getSd$cp() {
        return f162650sd;
    }

    public static final /* synthetic */ ResolutionItem access$getUhd$cp() {
        return uhd;
    }

    public static final /* synthetic */ ResolutionItem access$getUnknown$cp() {
        return unknown;
    }

    public static final /* synthetic */ ResolutionItem access$getXuhd$cp() {
        return xuhd;
    }
}
