package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.keva.KevaImpl;
import com.obric.capabilitykit.common.UiType;
import com.ss.android.socialbase.downloader.setting.DownloadSettingValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ProxySessionConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f10259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f10260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f10261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f10262e;
    private final int f;

    public r() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, r.class) == true) goto L8;
        return false;
    L8:
        r r6 = (r) ZeusTransformUtils.preCheckCast(r5, r.class, "com.obric.aiagent.plugin");
        if (this.f10258a == r6.f10258a) goto L12;
        return false;
    L12:
        if (this.f10259b == r6.f10259b) goto L15;
        return false;
    L15:
        if (this.f10260c == r6.f10260c) goto L18;
        return false;
    L18:
        if (this.f10261d == r6.f10261d) goto L21;
        return false;
    L21:
        if (this.f10262e == r6.f10262e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.f10258a) * 31) + Integer.hashCode(this.f10259b)) * 31) + Integer.hashCode(this.f10260c)) * 31) + Integer.hashCode(this.f10261d)) * 31) + Integer.hashCode(this.f10262e)) * 31) + Integer.hashCode(this.f);
    }

    public String toString() {
        return "ProxySessionConfig(connectTimeoutMillis=" + this.f10258a + ", helloTimeoutMillis=" + this.f10259b + ", defaultSendWindowBytes=" + this.f10260c + ", defaultReceiveWindowBytes=" + this.f10261d + ", maxPendingBytes=" + this.f10262e + ", maxStreams=" + this.f + ')';
    }

    public r(int r1, int r2, int r3, int r4, int r5, int r6) {
        this.f10258a = r1;
        this.f10259b = r2;
        this.f10260c = r3;
        this.f10261d = r4;
        this.f10262e = r5;
        this.f = r6;
        if (r2 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException("helloTimeoutMillis must be positive".toString());
    L5:
        r0 = false;
        goto L6
    }

    public /* synthetic */ r(int r5, int r6, int r7, int r8, int r9, int r10, int r11, d.h.b.h r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = DownloadSettingValues.SYNC_INTERVAL_MS_FG;
    L8:
        int r13 = r6;
        int r0 = 262144;
        if ((r11 & 4) == 0) goto L11;
        int r1 = 262144;
    L13:
        if ((r11 & 8) != 0) goto L17;
        r0 = r8;
    L17:
        if ((r11 & 16) == 0) goto L19;
        r9 = UiType.FLAG_APPLET_CARD;
    L19:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L22;
        r10 = 128;
    L22:
        this(r5, r13, r1, r0, r2, r10);
        return;
    L11:
        r1 = r7;
        goto L13
    }

    public final int a() {
        return this.f10258a;
    }

    public final int b() {
        return this.f10259b;
    }

    public final int c() {
        return this.f10261d;
    }

    public final int d() {
        return this.f10262e;
    }

    public final int e() {
        return this.f;
    }
}
