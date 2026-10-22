package com.bytedance.android.livesdk.chatroom.replay.player.seekbar.thumbprogress;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static File a(Context r100) {
        File r101 = r100.getCacheDir();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return new PolarisFileWrapper("/data/data/" + r100.getPackageName() + "/cache/");
    }
}
