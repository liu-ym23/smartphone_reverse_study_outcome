package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.common.utility.Logger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadAsyncTask;

/* JADX INFO: loaded from: classes7.dex */
public final class b extends PthreadAsyncTask<String[], Void, Void> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f108048h = null;

    static {
        f108048h = b.class.getSimpleName();
    }

    public b() {
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] r100) {
        String[][] r101 = (String[][]) r100;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.length >= 1) goto L7;
        return null;
    L7:
        if (r101[0].length < 1) goto L26;
        int r102 = 0;
    L10:
        String[] r103 = r101[0];
        if (r102 >= r103.length) goto L27;
        if (r103[r102] == null) goto L18;
        if (new PolarisFileWrapper(r101[0][r102]).delete() == true) goto L18;
        Logger.e(f108048h, "Delete file failed, file path is " + r101[0]);
    L18:
        r102 = r102 + 1;
        goto L10
    L27:
        return null;
    L26:
        return null;
    }
}
