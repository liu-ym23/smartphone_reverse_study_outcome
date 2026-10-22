package com.bytedance.android.live.revlink.link.biz.service;

/* JADX INFO: loaded from: classes47.dex */
public interface e extends j {

    public static final class a {
        public static String a(e r100) {
            return r100.getTAG() + '.' + r100.getComponentName() + '.' + r100.hashCode();
        }
    }

    void attach();

    void detach();

    String getComponentName();

    @Override // com.bytedance.android.live.revlink.link.biz.service.j
    /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext();

    String getTAG();
}
