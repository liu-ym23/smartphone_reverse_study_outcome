package com.bytedance.android.live.revenuelink.connect;

import com.bytedance.android.livesdk.link.model.a7;

/* JADX INFO: loaded from: classes47.dex */
public interface o {

    public static final class a {
        public static /* synthetic */ void a(o r110, long r111, String r112, String r113, long r114, a7 r115, Throwable r116, int r210) {
            if ((r210 & 16) == 0) goto L5;
            a7 r100 = null;
        L7:
            if ((r210 & 32) == 0) goto L9;
            Throwable r117 = null;
        L10:
            r110.a(r111, r112, r113, r114, r100, r117);
            return;
        L9:
            r117 = r116;
            goto L10
        L5:
            r100 = r115;
            goto L7
        }
    }

    void a(long r100, String r101, String r102, long r103, a7 r104, Throwable r105);
}
