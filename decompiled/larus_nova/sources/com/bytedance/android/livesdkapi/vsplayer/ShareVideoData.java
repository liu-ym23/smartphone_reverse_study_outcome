package com.bytedance.android.livesdkapi.vsplayer;

import kotlin.Metadata;
import qic.d;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/vsplayer/ShareVideoData;", "", "Lqic/d;", "snapshotInfo", "Lqic/d;", "getSnapshotInfo", "()Lqic/d;", "setSnapshotInfo", "(Lqic/d;)V", "<init>", "()V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShareVideoData {
    public static final ShareVideoData INSTANCE = null;
    private static d snapshotInfo;

    private ShareVideoData() {
    }

    static {
        INSTANCE = new ShareVideoData();
    }

    public final d getSnapshotInfo() {
        return snapshotInfo;
    }

    public final void setSnapshotInfo(d r100) {
        snapshotInfo = r100;
    }
}
