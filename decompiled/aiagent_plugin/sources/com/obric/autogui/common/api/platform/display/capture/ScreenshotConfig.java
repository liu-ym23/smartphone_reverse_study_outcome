package com.obric.autogui.common.api.platform.display.capture;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: ScreenshotConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ScreenshotConfig {
    private final List<String> excludingPackages;
    private final HeifConfig heifConfig;
    private final float scale;

    /* JADX INFO: compiled from: ScreenshotConfig.kt */
    public static final class HeifConfig {
        private final int downscalePreference;
        private final int qp;

        public HeifConfig() {
            int r0 = 0;
            this(r0, r0, 3, null);
        }

        public static /* synthetic */ HeifConfig copy$default(HeifConfig r0, int r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.qp;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.downscalePreference;
        L9:
            return r0.copy(r1, r2);
        }

        public final int component1() {
            return this.qp;
        }

        public final int component2() {
            return this.downscalePreference;
        }

        public final HeifConfig copy(int r1, int r2) {
            return new HeifConfig(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, HeifConfig.class) == true) goto L8;
            return false;
        L8:
            HeifConfig r6 = (HeifConfig) ZeusTransformUtils.preCheckCast(r5, HeifConfig.class, "com.obric.aiagent.plugin");
            if (this.qp == r6.qp) goto L12;
            return false;
        L12:
            if (this.downscalePreference == r6.downscalePreference) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.qp) * 31) + Integer.hashCode(this.downscalePreference);
        }

        public String toString() {
            return "HeifConfig(qp=" + this.qp + ", downscalePreference=" + this.downscalePreference + ')';
        }

        public HeifConfig(int r1, int r2) {
            this.qp = r1;
            this.downscalePreference = r2;
        }

        public /* synthetic */ HeifConfig(int r1, int r2, int r3, h r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = 35;
        L6:
            if ((r3 & 2) == 0) goto L8;
            r2 = 0;
        L8:
            this(r1, r2);
        }

        public final int getQp() {
            return this.qp;
        }

        public final int getDownscalePreference() {
            return this.downscalePreference;
        }
    }

    public ScreenshotConfig() {
        this(null, 0.0f, null, 7, null);
    }

    public static /* synthetic */ ScreenshotConfig copy$default(ScreenshotConfig r1, List r2, float r3, HeifConfig r4, int r5, Object r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = r1.excludingPackages;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.scale;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r1.heifConfig;
    L12:
        return r1.copy(r7, r3, r4);
    }

    public final List<String> component1() {
        return this.excludingPackages;
    }

    public final float component2() {
        return this.scale;
    }

    public final HeifConfig component3() {
        return this.heifConfig;
    }

    public final ScreenshotConfig copy(List<String> r2, float r3, HeifConfig r4) {
        return new ScreenshotConfig((List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin"), r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenshotConfig.class) == true) goto L8;
        return false;
    L8:
        ScreenshotConfig r6 = (ScreenshotConfig) ZeusTransformUtils.preCheckCast(r5, ScreenshotConfig.class, "com.obric.aiagent.plugin");
        if (o.a(this.excludingPackages, r6.excludingPackages) == true) goto L12;
        return false;
    L12:
        if (Float.compare(this.scale, r6.scale) == 0) goto L15;
        return false;
    L15:
        if (o.a(this.heifConfig, r6.heifConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<String> r0 = this.excludingPackages;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + Float.hashCode(this.scale)) * 31;
        HeifConfig r4 = this.heifConfig;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ScreenshotConfig(excludingPackages=" + this.excludingPackages + ", scale=" + this.scale + ", heifConfig=" + this.heifConfig + ')';
    }

    public ScreenshotConfig(List<String> r3, float r4, HeifConfig r5) {
        this.excludingPackages = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        this.scale = r4;
        this.heifConfig = r5;
    }

    public /* synthetic */ ScreenshotConfig(List r2, float r3, HeifConfig r4, int r5, h r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r5 & 1) == 0) goto L6;
        r7 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = 1.0f;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r7, r3, r4);
    }

    public final List<String> getExcludingPackages() {
        return this.excludingPackages;
    }

    public final float getScale() {
        return this.scale;
    }

    public final HeifConfig getHeifConfig() {
        return this.heifConfig;
    }
}
