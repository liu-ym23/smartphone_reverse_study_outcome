package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.android.live.core.utils.s1;

/* JADX INFO: loaded from: classes8.dex */
public final class y {
    public static void a(int r100) {
        Context r101 = s1.getContext();
        if (r101 == null) goto L7;
        b(r101.getString(r100), 0);
        return;
    }

    public static void b(final String r100, final int r101) {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        UtilityKotlinExtentionsKt.g(new x(r100, r101));
        return;
    L6:
        Context r102 = s1.getContext();
        if (r102 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100) == false) goto L12;
        return;
    L12:
        if (com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.x().centerToast(r102, r100, r101) == true) goto L16;
        Toast r103 = Toast.makeText(r102, r100, r101);
        r103.setGravity(17, 0, 0);
        r103.show();
        return;
    }
}
