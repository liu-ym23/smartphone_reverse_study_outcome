package com.bytedance.android.livesdk.livecommerce.ability;

import android.content.Context;

/* JADX INFO: loaded from: classes10.dex */
public interface b {

    public static final class a {
        public static /* synthetic */ void a(b r100, Context r101, f r110, Object r111, il2.a r112, e r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            Object r102 = null;
        L7:
            if ((r114 & 8) == 0) goto L9;
            il2.a r103 = null;
        L11:
            if ((r114 & 16) == 0) goto L13;
            e r104 = null;
        L14:
            r100.d(r101, r110, r102, r103, r104);
            return;
        L13:
            r104 = r113;
            goto L14
        L9:
            r103 = r112;
            goto L11
        L5:
            r102 = r111;
            goto L7
        }
    }

    <T> void a(Context r100, f<T> r101, com.bytedance.android.shopping.ligo.strategy.decision.scheduler.a r102);

    void b(String r100, d<?> r101);

    void c();

    <T> void d(Context r100, f<T> r101, Object r102, il2.a r103, e r104);

    h e();

    <T extends d<?>> T get(String r100);
}
