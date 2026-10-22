package com.bytedance.android.livesdkapi.feed;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdkapi/feed/LiveDrawOperateRecorder;", "", "()V", "mLastPosition", "", "mRead", "mRooms", "Ljava/util/HashMap;", "", "Lcom/bytedance/android/livesdkapi/feed/DrawOperate;", "Lkotlin/collections/HashMap;", "obtainDrawOperate", "roomId", "position", "total", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveDrawOperateRecorder {
    private int mLastPosition;
    private int mRead;
    private final HashMap<String, DrawOperate> mRooms;

    public LiveDrawOperateRecorder() {
        this.mRooms = new HashMap();
    }

    public final DrawOperate obtainDrawOperate(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        DrawOperate r103 = this.mRooms.get(r100);
        if (r103 != null) goto L5;
        r103 = new DrawOperate();
        this.mRooms.put(r100, r103);
    L5:
        int r104 = RangesKt.coerceAtLeast(this.mRead, r101);
        this.mRead = r104;
        int r105 = this.mLastPosition;
        if (r105 <= r101) goto L8;
        int r106 = 1;
    L11:
        this.mLastPosition = r101;
        r103.updateItem(r101, r102, r104, r106);
        return r103;
    L8:
        if (r105 >= r101) goto L10;
        r106 = 2;
        goto L11
    L10:
        r106 = 0;
        goto L11
    }
}
