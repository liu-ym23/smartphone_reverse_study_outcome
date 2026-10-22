package com.bytedance.android.livesdk.room.Task;

import hs2.b;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/room/Task/LiveTaskException;", "Ljava/lang/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveTaskException extends RuntimeException {
    public LiveTaskException(String r100) {
        super(r100);
        if (r100 == null) goto L6;
        b.b(r100);
        return;
    }
}
