package com.bytedance.android.livesdkapi.depend.message.wrds;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\f\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0006"}, d2 = {"checkFansRedPacketValid", "", "Lcom/bytedance/android/livesdkapi/depend/message/wrds/PreviewPromotionSyncData;", "bufferTime", "", "checkRedPacketValid", "livebase-model_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class PreviewPromotionSyncDataKt {
    public static final boolean checkRedPacketValid(PreviewPromotionSyncData r100) {
        if (r100 == null) goto L4;
        Integer r101 = r100.getType();
    L5:
        if (r101 != null) goto L8;
    L16:
        return false;
    L8:
        if (r101.intValue() != 2) goto L16;
        RedPacket r102 = r100.getRedPacket();
        if (r102 == null) goto L12;
        long r103 = r102.getExpireTime();
    L14:
        if (r103 <= (System.currentTimeMillis() / ((long) 1000))) goto L16;
        return true;
    L12:
        r103 = 0;
        goto L14
    L4:
        r101 = null;
        goto L5
    }

    public static final boolean checkFansRedPacketValid(PreviewPromotionSyncData r100, long r101) {
        if (r100 == null) goto L4;
        Integer r102 = r100.getType();
    L5:
        if (r102 != null) goto L8;
    L16:
        return false;
    L8:
        if (r102.intValue() != 4) goto L16;
        FansRedPacket r103 = r100.getFansRedPacket();
        if (r103 == null) goto L12;
        long r104 = r103.getExpireTime();
    L14:
        if (r104 <= ((System.currentTimeMillis() / ((long) 1000)) - r101)) goto L16;
        return true;
    L12:
        r104 = 0;
        goto L14
    L4:
        r102 = null;
        goto L5
    }
}
