package com.bytedance.android.live.core.feature;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/core/feature/RoomInfoItem;", "", "anchorId", "", "roomId", "deviceId", "userCount", "fansCount", "liveType", "roomMethod", "(JJJJJJJ)V", "getAnchorId", "()J", "getDeviceId", "getFansCount", "getLiveType", "getRoomId", "getRoomMethod", "getUserCount", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomInfoItem {
    private final long anchorId;
    private final long deviceId;
    private final long fansCount;
    private final long liveType;
    private final long roomId;
    private final long roomMethod;
    private final long userCount;

    public final long getAnchorId() {
        return this.anchorId;
    }

    public final long getDeviceId() {
        return this.deviceId;
    }

    public final long getFansCount() {
        return this.fansCount;
    }

    public final long getLiveType() {
        return this.liveType;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getRoomMethod() {
        return this.roomMethod;
    }

    public final long getUserCount() {
        return this.userCount;
    }

    public RoomInfoItem(long r100, long r101, long r102, long r103, long r104, long r110, long r111) {
        this.anchorId = r100;
        this.roomId = r101;
        this.deviceId = r102;
        this.userCount = r103;
        this.fansCount = r104;
        this.liveType = r110;
        this.roomMethod = r111;
    }

    public /* synthetic */ RoomInfoItem(long r110, long r210, long r211, long r212, long r213, long r214, long r310, int r311, DefaultConstructorMarker r312) {
        if ((r311 & 4) == 0) goto L5;
        long r100 = 0;
    L7:
        if ((r311 & 8) == 0) goto L9;
        long r111 = 0;
    L11:
        if ((r311 & 16) == 0) goto L13;
        long r112 = 0;
    L15:
        if ((r311 & 32) == 0) goto L17;
        long r113 = 0;
    L19:
        if ((r311 & 64) == 0) goto L21;
        long r114 = 0;
    L22:
        this(r110, r210, r100, r111, r112, r113, r114);
        return;
    L21:
        r114 = r310;
        goto L22
    L17:
        r113 = r214;
        goto L19
    L13:
        r112 = r213;
        goto L15
    L9:
        r111 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }
}
