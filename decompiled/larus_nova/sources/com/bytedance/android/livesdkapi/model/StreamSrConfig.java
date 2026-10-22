package com.bytedance.android.livesdkapi.model;

import com.ss.texturerender.TextureRenderKeys;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001\u0016B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\f\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/StreamSrConfig;", "", "enable", "", "antiAlias", TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, "", "sharpLevel", "reason", "", "(ZZIILjava/lang/String;)V", "getAntiAlias$annotations", "()V", "getAntiAlias", "()Z", "getEnable", "getReason", "()Ljava/lang/String;", "getSharpLevel", "()I", "getStrength$annotations", "getStrength", "SrScale", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StreamSrConfig {
    private final boolean antiAlias;
    private final boolean enable;
    private final String reason;
    private final int sharpLevel;
    private final int strength;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/StreamSrConfig$SrScale;", "", "()V", "initValue", "", "getInitValue", "()I", "setInitValue", "(I)V", "processValue", "getProcessValue", "setProcessValue", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class SrScale {
        public static final Companion Companion = null;
        public static final int SR_SCALE_1_1 = 4;
        public static final int SR_SCALE_1_2 = 8;
        public static final int SR_SCALE_1_3 = 16;
        public static final int SR_SCALE_1_4 = 32;
        public static final int SR_SCALE_1_5 = 1;
        public static final int SR_SCALE_2_0 = 2;
        public static final int SR_SCALE_ALL = 32768;
        public static final int SR_SCALE_DISABLE = 32769;
        private int initValue;
        private int processValue;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/StreamSrConfig$SrScale$Companion;", "", "()V", "SR_SCALE_1_1", "", "SR_SCALE_1_2", "SR_SCALE_1_3", "SR_SCALE_1_4", "SR_SCALE_1_5", "SR_SCALE_2_0", "SR_SCALE_ALL", "SR_SCALE_DISABLE", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
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

        public SrScale() {
        }

        public final int getInitValue() {
            return this.initValue;
        }

        public final int getProcessValue() {
            return this.processValue;
        }

        public final void setInitValue(int r100) {
            this.initValue = r100;
        }

        public final void setProcessValue(int r100) {
            this.processValue = r100;
        }
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getAntiAlias$annotations() {
    }

    @Deprecated(message = "")
    public static /* synthetic */ void getStrength$annotations() {
    }

    public final boolean getAntiAlias() {
        return this.antiAlias;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final String getReason() {
        return this.reason;
    }

    public final int getSharpLevel() {
        return this.sharpLevel;
    }

    public final int getStrength() {
        return this.strength;
    }

    public StreamSrConfig(boolean r100, boolean r101, int r102, int r103, String r104) {
        Intrinsics.checkNotNullParameter(r104, "reason");
        this.enable = r100;
        this.antiAlias = r101;
        this.strength = r102;
        this.sharpLevel = r103;
        this.reason = r104;
    }

    public /* synthetic */ StreamSrConfig(boolean r100, boolean r101, int r102, int r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 4) == 0) goto L5;
        int r103 = 0;
    L6:
        this(r100, r101, r103, r110, r111);
        return;
    L5:
        r103 = r102;
        goto L6
    }
}
