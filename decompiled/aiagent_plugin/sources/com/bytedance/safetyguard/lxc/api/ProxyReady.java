package com.bytedance.safetyguard.lxc.api;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ProxySessionReady.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyReady {
    private final long acceptedFeatureBitmap;
    private final int dataChunkSize;
    private final int maxFramePayload;
    private final boolean reused;
    private final String sessionId;
    private final int streamWindow;

    public static /* synthetic */ ProxyReady copy$default(ProxyReady r5, String r6, boolean r7, long r8, int r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.sessionId;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.reused;
    L8:
        boolean r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.acceptedFeatureBitmap;
    L11:
        long r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r10 = r5.maxFramePayload;
    L14:
        int r2 = r10;
        if ((r13 & 16) == 0) goto L17;
        r11 = r5.dataChunkSize;
    L17:
        int r3 = r11;
        if ((r13 & 32) == 0) goto L20;
        r12 = r5.streamWindow;
    L20:
        String r9 = r6;
        return r5.copy(r9, r15, r0, r2, r3, r12);
    }

    public final String component1() {
        return this.sessionId;
    }

    public final boolean component2() {
        return this.reused;
    }

    public final long component3() {
        return this.acceptedFeatureBitmap;
    }

    public final int component4() {
        return this.maxFramePayload;
    }

    public final int component5() {
        return this.dataChunkSize;
    }

    public final int component6() {
        return this.streamWindow;
    }

    public final ProxyReady copy(String r9, boolean r10, long r11, int r13, int r14, int r15) {
        o.e(r9, ObricMemoryConstants.KEY_SESSION_ID);
        return new ProxyReady(r9, r10, r11, r13, r14, r15);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProxyReady.class) == true) goto L8;
        return false;
    L8:
        ProxyReady r10 = (ProxyReady) ZeusTransformUtils.preCheckCast(r9, ProxyReady.class, "com.obric.aiagent.plugin");
        if (o.a(this.sessionId, r10.sessionId) == true) goto L12;
        return false;
    L12:
        if (this.reused == r10.reused) goto L15;
        return false;
    L15:
        if (this.acceptedFeatureBitmap == r10.acceptedFeatureBitmap) goto L18;
        return false;
    L18:
        if (this.maxFramePayload == r10.maxFramePayload) goto L21;
        return false;
    L21:
        if (this.dataChunkSize == r10.dataChunkSize) goto L24;
        return false;
    L24:
        if (this.streamWindow == r10.streamWindow) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        return (((((((((this.sessionId.hashCode() * 31) + Boolean.hashCode(this.reused)) * 31) + Long.hashCode(this.acceptedFeatureBitmap)) * 31) + Integer.hashCode(this.maxFramePayload)) * 31) + Integer.hashCode(this.dataChunkSize)) * 31) + Integer.hashCode(this.streamWindow);
    }

    public String toString() {
        return "ProxyReady(sessionId=" + this.sessionId + ", reused=" + this.reused + ", acceptedFeatureBitmap=" + this.acceptedFeatureBitmap + ", maxFramePayload=" + this.maxFramePayload + ", dataChunkSize=" + this.dataChunkSize + ", streamWindow=" + this.streamWindow + ')';
    }

    public ProxyReady(String r2, boolean r3, long r4, int r6, int r7, int r8) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        this.sessionId = r2;
        this.reused = r3;
        this.acceptedFeatureBitmap = r4;
        this.maxFramePayload = r6;
        this.dataChunkSize = r7;
        this.streamWindow = r8;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final boolean getReused() {
        return this.reused;
    }

    public final long getAcceptedFeatureBitmap() {
        return this.acceptedFeatureBitmap;
    }

    public final int getMaxFramePayload() {
        return this.maxFramePayload;
    }

    public final int getDataChunkSize() {
        return this.dataChunkSize;
    }

    public final int getStreamWindow() {
        return this.streamWindow;
    }
}
