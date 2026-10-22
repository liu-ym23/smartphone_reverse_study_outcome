package com.bytedance.android.live.lynx.ui;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes46.dex */
public final class m extends com.lynx.tasm.event.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f82746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f82747c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f82748d;

    @Override // com.lynx.tasm.event.a
    public final Map<String, Object> b() {
        LinkedHashMap r100 = new LinkedHashMap();
        r100.put("current", Integer.valueOf(this.f82746b));
        r100.put("total", Integer.valueOf(this.f82747c));
        r100.put("loopIndex", Integer.valueOf(this.f82748d));
        return r100;
    }

    public m(int r100, int r101, int r102, int r103, String r104) {
        this.f82746b = r100;
        this.f82747c = r101;
        this.f82748d = r102;
        super(r103, r104);
    }
}
