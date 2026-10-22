package com.bytedance.applet.aibridge;

import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class j implements a88.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f191172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f191173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f191174c;

    @Override // a88.d
    public final boolean b() {
        return this.f191174c;
    }

    @Override // a88.d
    public final boolean d() {
        return this.f191173b;
    }

    @Override // a88.d
    public final void a(String r100) {
        i r101 = i.f191168a;
        String r102 = this.f191172a;
        JsonObject r103 = new JsonObject();
        r103.addProperty("enterMethod", r100);
        Unit r104 = Unit.INSTANCE;
        i.l(r102, 2, r103);
    }

    @Override // a88.d
    public final void c(String r100) {
        i r101 = i.f191168a;
        String r102 = this.f191172a;
        JsonObject r103 = new JsonObject();
        r103.addProperty("enterMethod", r100);
        Unit r104 = Unit.INSTANCE;
        i.l(r102, 1, r103);
    }

    public j(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "musicId");
        this.f191172a = r100;
        this.f191173b = r101;
        this.f191174c = r102;
    }
}
