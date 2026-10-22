package com.bytedance.android.gamecp.base.gamedetail;

/* JADX INFO: loaded from: classes44.dex */
public interface d0 extends com.bytedance.ies.sve_list.a {

    public static final class a {
        public static int getType(d0 r100) {
            return r100.a().hashCode();
        }
    }

    String a();

    @Override // com.bytedance.ies.sve_list.a
    int getType();
}
