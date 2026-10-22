package com.bytedance.applet.aibridge.navigation;

import com.google.gson.JsonObject;
import kotlin.Unit;

/* JADX INFO: loaded from: classes14.dex */
public final class f0 extends com.bytedance.applet.aibridge.baidunavi.h.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f191316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ float f191317d;

    public f0(float r100) {
        this.f191317d = r100;
        this.f191316c = Float.NaN;
    }

    @Override // com.bytedance.applet.aibridge.baidunavi.h.a
    public final void a(float r100) {
        if (Float.isNaN(this.f191316c) == false) goto L5;
    L6:
        this.f191316c = r100;
        int r101 = g.f191318a;
        JsonObject r102 = new JsonObject();
        r102.addProperty("degree", Float.valueOf(r100));
        Unit r103 = Unit.INSTANCE;
        g.a("flow.onHeadingChange", r102);
        return;
    L5:
        if (Math.abs(this.f191316c - r100) >= this.f191317d) goto L6;
    }
}
