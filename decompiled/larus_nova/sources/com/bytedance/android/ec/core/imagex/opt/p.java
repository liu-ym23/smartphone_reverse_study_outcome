package com.bytedance.android.ec.core.imagex.opt;

/* JADX INFO: loaded from: classes43.dex */
public final class p {
    public static final DomainPreConnect a() {
        ImageDomainPreConnectConfig r100 = ImageDomainPreConnectConfig.f44797d;
        r100.getClass();
        if (((Boolean) ImageDomainPreConnectConfig.f44795b.getValue()).booleanValue() == false) goto L14;
        com.bytedance.android.shopping.api.image.a0 r101 = (com.bytedance.android.shopping.api.image.a0) ImageDomainPreConnectConfig.f44796c.getValue(r100, ImageDomainPreConnectConfig.f44794a[0]);
        if (r101 == null) goto L7;
        Integer r102 = r101.a();
    L8:
        if (r102 != null) goto L11;
        return null;
    L11:
        if (r102.intValue() == 1) goto L13;
        return null;
    L13:
        return DomainPreConnect.f44729c;
    L7:
        r102 = null;
        goto L8
    L14:
        return null;
    }
}
