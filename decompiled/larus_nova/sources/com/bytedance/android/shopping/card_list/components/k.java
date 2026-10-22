package com.bytedance.android.shopping.card_list.components;

/* JADX INFO: loaded from: classes13.dex */
public interface k extends com.bytedance.android.shopping.card_list.components.a {

    public static final class a {
        public static /* synthetic */ void a(k r100, String r110, boolean r111, com.bytedance.kmp.ec.yata.common.biz.callback.a r112, boolean r113, boolean r114, boolean r115, int r116) {
            if ((r116 & 8) == 0) goto L5;
            boolean r101 = false;
        L7:
            if ((r116 & 16) == 0) goto L9;
            boolean r102 = false;
        L11:
            if ((r116 & 32) == 0) goto L13;
            boolean r103 = false;
        L14:
            r100.c(r110, r111, r112, r101, r102, r103);
            return;
        L13:
            r103 = r115;
            goto L14
        L9:
            r102 = r114;
            goto L11
        L5:
            r101 = r113;
            goto L7
        }
    }

    void a(String r100, com.bytedance.kmp.ec.yata.common.biz.callback.a r101);

    void c(String r100, boolean r101, com.bytedance.kmp.ec.yata.common.biz.callback.a r102, boolean r103, boolean r104, boolean r105);

    boolean isLoading();
}
