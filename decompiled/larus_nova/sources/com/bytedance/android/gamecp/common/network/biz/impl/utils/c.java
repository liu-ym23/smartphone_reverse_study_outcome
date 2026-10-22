package com.bytedance.android.gamecp.common.network.biz.impl.utils;

import androidx.core.content.ContextCompat;
import com.bytedance.android.gamecp.common.utils.u;

/* JADX INFO: loaded from: classes44.dex */
public final class c {
    public static boolean a(String r100) {
        if (ContextCompat.checkSelfPermission(u.f57306a.getApplicationContext(), r100) != 0) goto L12;
        return true;
    L12:
        return false;
    L7:
        e = move-exception;
        e.getLocalizedMessage();
        return false;
    }
}
