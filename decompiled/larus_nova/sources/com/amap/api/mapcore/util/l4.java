package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.AMapEngineUtils;

/* JADX INFO: loaded from: classes28.dex */
class l4 extends a9 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ m4 f27514b;

    @Override // com.amap.api.mapcore.util.a9
    public void runTask() {
        if (m4.a(this.f27514b) == false) goto L5;
        return;
    L5:
        this.f27514b.a(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME, 0);
        this.f27514b.a(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME, 1);
        if ("".equals(q3.a(m4.b(this.f27514b), "amap_web_logo", "md5_day", "")) == true) goto L8;
        return;
    L8:
        if (m4.c(this.f27514b) != null) goto L10;
    L15:
        q3.b(m4.b(this.f27514b), "amap_web_logo", "md5_day", "0b718b5f291b09d2b62be725dfb977b3");
        q3.b(m4.b(this.f27514b), "amap_web_logo", "md5_night", "4b1405462a5c910de0e0723ffd96c018");
        return;
    L10:
        if (m4.d(this.f27514b) == null) goto L15;
        String r100 = t5.b(AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME);
        q3.b(m4.b(this.f27514b), "amap_web_logo", "md5_day", r100);
        String r101 = t5.b(AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME);
        if ("".equals(r101) == true) goto L14;
        q3.b(m4.b(this.f27514b), "amap_web_logo", "md5_night", r101);
    L14:
        this.f27514b.c(true);
    }

    public l4(m4 r100) {
        this.f27514b = r100;
    }
}
