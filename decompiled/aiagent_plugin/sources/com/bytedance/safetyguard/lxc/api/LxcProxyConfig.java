package com.bytedance.safetyguard.lxc.api;

import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;

/* JADX INFO: compiled from: SafetyGuardProxyConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LxcProxyConfig {
    private final int connectTimeoutMillis;
    private final int helloTimeoutMillis;
    private final int maxPendingBytes;
    private final int maxStreams;
    private final int recoveryTimeoutMillis;

    public LxcProxyConfig() {
        this(0, 0, 0, 0, 0, 31, null);
    }

    public static /* synthetic */ LxcProxyConfig copy$default(LxcProxyConfig r3, int r4, int r5, int r6, int r7, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.connectTimeoutMillis;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.maxStreams;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.maxPendingBytes;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.helloTimeoutMillis;
    L14:
        int r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.recoveryTimeoutMillis;
    L17:
        int r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final int component1() {
        return this.connectTimeoutMillis;
    }

    public final int component2() {
        return this.maxStreams;
    }

    public final int component3() {
        return this.maxPendingBytes;
    }

    public final int component4() {
        return this.helloTimeoutMillis;
    }

    public final int component5() {
        return this.recoveryTimeoutMillis;
    }

    public final LxcProxyConfig copy(int r7, int r8, int r9, int r10, int r11) {
        return new LxcProxyConfig(r7, r8, r9, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, LxcProxyConfig.class) == true) goto L8;
        return false;
    L8:
        LxcProxyConfig r6 = (LxcProxyConfig) ZeusTransformUtils.preCheckCast(r5, LxcProxyConfig.class, "com.obric.aiagent.plugin");
        if (this.connectTimeoutMillis == r6.connectTimeoutMillis) goto L12;
        return false;
    L12:
        if (this.maxStreams == r6.maxStreams) goto L15;
        return false;
    L15:
        if (this.maxPendingBytes == r6.maxPendingBytes) goto L18;
        return false;
    L18:
        if (this.helloTimeoutMillis == r6.helloTimeoutMillis) goto L21;
        return false;
    L21:
        if (this.recoveryTimeoutMillis == r6.recoveryTimeoutMillis) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.connectTimeoutMillis) * 31) + Integer.hashCode(this.maxStreams)) * 31) + Integer.hashCode(this.maxPendingBytes)) * 31) + Integer.hashCode(this.helloTimeoutMillis)) * 31) + Integer.hashCode(this.recoveryTimeoutMillis);
    }

    public String toString() {
        return "LxcProxyConfig(connectTimeoutMillis=" + this.connectTimeoutMillis + ", maxStreams=" + this.maxStreams + ", maxPendingBytes=" + this.maxPendingBytes + ", helloTimeoutMillis=" + this.helloTimeoutMillis + ", recoveryTimeoutMillis=" + this.recoveryTimeoutMillis + ')';
    }

    public LxcProxyConfig(int r1, int r2, int r3, int r4, int r5) {
        this.connectTimeoutMillis = r1;
        this.maxStreams = r2;
        this.maxPendingBytes = r3;
        this.helloTimeoutMillis = r4;
        this.recoveryTimeoutMillis = r5;
    }

    public /* synthetic */ LxcProxyConfig(int r2, int r3, int r4, int r5, int r6, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = 10000;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = 128;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = UiType.FLAG_APPLET_CARD;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = 10000;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public final int getMaxStreams() {
        return this.maxStreams;
    }

    public final int getMaxPendingBytes() {
        return this.maxPendingBytes;
    }

    public final int getHelloTimeoutMillis() {
        return this.helloTimeoutMillis;
    }

    public final int getRecoveryTimeoutMillis() {
        return this.recoveryTimeoutMillis;
    }
}
