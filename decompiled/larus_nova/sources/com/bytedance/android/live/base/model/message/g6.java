package com.bytedance.android.live.base.model.message;

import java.util.Map;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes45.dex */
public final class g6 implements d3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m0 f58865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f58866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f58867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f58868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public transient long f58869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f58870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f58871g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f58872h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f58873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f58874j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f58875k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f58876l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f58877m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f58878n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f58879o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f58880p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public byte[] f58881q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Map<String, String> f58882r;

    public g6() {
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getConsumeTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getDecodeEndTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getDecodeStartTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getEnqueueDispatchTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getHttpSendTime() {
        throw null;
    }

    @Override // tlc.d, com.bytedance.android.livesdkapi.message.IExternalLiveMessage
    public final int getIntType() {
        return -1;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final byte[] getRawPayload() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getReceiveTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setCommonMessageData(m0 r100) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setGeneralMessageType(int r100) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setMessageExtra(Map<String, String> r100) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setMessageFrom(int r100) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setRawPayload(byte[] r100) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setTimestamp(long r100) {
        throw null;
    }

    @Override // tlc.d
    public final long getDelayDispatchMs() {
        m0 r100 = this.f58865a;
        if (r100 == null) goto L14;
        Long r101 = Long.valueOf(r100.getRandomDispatchMs());
        if (r101.longValue() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L14;
        long r103 = r101.longValue();
        return Random.Default.nextLong(r103);
    L7:
        r102 = false;
    L14:
        return 0;
    }

    @Override // tlc.d
    public final long getMessageId() {
        m0 r100 = this.f58865a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getMessageId();
    }

    @Override // tlc.d
    public final long getRoomId() {
        m0 r100 = this.f58865a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getRoomId();
    }

    @Override // xlc.b
    public final String getWRDSKey() {
        m0 r100 = this.f58865a;
        if (r100 == null) goto L6;
        String r101 = r100.getMethod();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "Unknown";
    }

    @Override // tlc.d
    public final boolean isGlobalMessage() {
        m0 r100 = this.f58865a;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.getRoomId() != (-1)) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final boolean isTimeCostCanUse() {
        if (this.f58870f == false) goto L5;
        return false;
    L5:
        long r100 = this.f58872h;
        if (r100 > 0) goto L8;
    L10:
        long r101 = this.f58875k;
        if (r101 <= this.f58874j) goto L18;
        long r102 = this.f58876l;
        if (r102 > r101) goto L15;
        return false;
    L15:
        if (this.f58877m <= r102) goto L20;
        return true;
    L20:
        return false;
    L18:
        return false;
    L8:
        if (this.f58873i > r100) goto L10;
        return false;
    }

    @Override // tlc.d
    public final boolean needMonitor() {
        m0 r100 = this.f58865a;
        if (r100 != null) goto L5;
    L6:
        m0 r101 = this.f58865a;
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.getMonitor() != 2) goto L11;
        return true;
    L5:
        if (r100.getMonitor() != 1) goto L6;
        return true;
    }

    @Override // tlc.d
    public final int getGeneralMessageType() {
        return this.f58868d;
    }

    @Override // tlc.d
    public final int getMessageFrom() {
        return this.f58866b;
    }

    @Override // tlc.d
    public final String getMessageMethod() {
        return this.f58867c;
    }

    @Override // xlc.b
    public final String getWRDSSubKey() {
        return this.f58880p;
    }

    @Override // xlc.b
    public final long getWRDSVersion() {
        return this.f58879o;
    }

    @Override // tlc.d
    public final boolean isFromFirstRequest() {
        return this.f58871g;
    }

    @Override // xlc.b
    public final boolean isWRDSMessage() {
        return this.f58878n;
    }

    @Override // tlc.d
    public final void setConsumeTime(long r100) {
        this.f58877m = r100;
    }

    @Override // tlc.d
    public final void setDecodeEndTime(long r100) {
        this.f58875k = r100;
    }

    @Override // tlc.d
    public final void setDecodeStartTime(long r100) {
        this.f58874j = r100;
    }

    @Override // tlc.d
    public final void setEnqueueDispatchTime(long r100) {
        this.f58876l = r100;
    }

    @Override // tlc.d
    public final void setHttpSendTime(long r100) {
        this.f58872h = r100;
    }

    @Override // tlc.d
    public final void setIsFromFirstRequest(boolean r100) {
        this.f58871g = r100;
    }

    @Override // tlc.d
    public final void setIsInsert(boolean r100) {
        this.f58870f = true;
    }

    @Override // tlc.d
    public final void setMessageMethod(String r100) {
        this.f58867c = r100;
    }

    @Override // tlc.d
    public final void setReceiveTime(long r100) {
        this.f58873i = r100;
    }

    @Override // xlc.b
    public final void setWRDSMessage(boolean r100) {
        this.f58878n = r100;
    }

    @Override // xlc.b
    public final void setWRDSSubKey(String r100) {
        this.f58880p = r100;
    }

    @Override // xlc.b
    public final void setWRDSVersion(long r100) {
        this.f58879o = r100;
    }
}
