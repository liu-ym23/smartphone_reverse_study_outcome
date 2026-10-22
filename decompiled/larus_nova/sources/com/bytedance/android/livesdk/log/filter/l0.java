package com.bytedance.android.livesdk.log.filter;

import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class l0 extends a<am2.w> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public am2.w f153305c;

    public l0() {
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void a(Map<String, String> r100) {
        super.a(r100);
        am2.w r101 = this.f153305c;
        if (r101 == null) goto L21;
        LiveMode r102 = r101.f4347a;
        LiveMode r103 = LiveMode.MEDIA;
        String r104 = null;
        if (r102 != r103) goto L7;
        String r105 = "media";
    L8:
        if (r105 == null) goto L25;
        if (r100 == null) goto L12;
        r100.put("live_type", r105);
    L12:
        am2.w r106 = this.f153305c;
        if (r106 != null) goto L15;
        return;
    L15:
        if (r106.f4347a != r103) goto L17;
        r104 = r106.f4348b;
    L17:
        if (r104 == null) goto L23;
        if (r100 == null) goto L24;
        r100.put("live_status", r104);
        return;
    L24:
        return;
    L23:
        return;
    L25:
        return;
    L7:
        r105 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.log.filter.a, com.bytedance.android.livesdk.log.filter.o
    public final void setData(Object r100) {
        this.f153305c = (am2.w) r100;
    }
}
