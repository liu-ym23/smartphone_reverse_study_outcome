package com.bytedance.android.live.anchormodelink.handlers;

import com.bytedance.android.live.anchormodelink.model.DynamicCenterGetType;
import com.bytedance.android.live.anchormodelink.model.DynamicCenterUpdateType;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements iy.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JsonObject f58656a;

    /* JADX INFO: renamed from: com.bytedance.android.live.anchormodelink.handlers.a$a, reason: collision with other inner class name */
    public static final class C0933a {
    }

    static {
    }

    @Override // iy.e
    public final void onStart() {
    }

    @Override // iy.e
    public final void onStop() {
    }

    public a() {
        this.f58656a = new JsonObject();
    }

    @Override // iy.e
    public final JsonObject C(my.b r100) {
        Intrinsics.checkNotNullParameter(r100, "getStatusData");
        jy0.b.d("DynamicCenterBasicHandler", "type: " + r100.getType() + ", extraInfo=" + r100.f516351b);
        if (b.f58658b[r100.getType().ordinal()] != 1) goto L15;
        JsonObject r101 = r100.f516351b;
        if (r101 != null) goto L8;
        return null;
    L8:
        JsonElement r102 = r101.get("key");
        if (r102 == null) goto L11;
        String r103 = r102.getAsString();
    L12:
        if (r103 == null) goto L15;
        JsonElement r104 = this.f58656a.get(r103);
        JsonObject r105 = new JsonObject();
        r105.add("value", r104);
        jy0.b.d("DynamicCenterBasicHandler", "getLinkMicStatus key=" + r103 + ", result=" + r105);
        return r105;
    L11:
        r103 = null;
    L15:
        return null;
    }

    @Override // iy.e
    public final boolean a(DynamicCenterUpdateType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != DynamicCenterUpdateType.common_set_data) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // iy.e
    public final boolean c(DynamicCenterGetType r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        if (r100 != DynamicCenterGetType.common_get_data) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // iy.e
    public final void b(my.c r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "updateStatus");
        Intrinsics.checkNotNullParameter(r101, "updateCallback");
        jy0.b.d("DynamicCenterBasicHandler", "type: " + r100.getType() + ", extraInfo=" + r100.f516353b);
        if (b.f58657a[r100.getType().ordinal()] != 1) goto L14;
        JsonObject r102 = r100.f516353b;
        if (r102 == null) goto L14;
        JsonElement r103 = r102.get("key");
        if (r103 == null) goto L10;
        String r104 = r103.getAsString();
    L11:
        JsonElement r105 = r102.get("data");
        if (r104 == null) goto L14;
        this.f58656a.add(r104, r105);
        goto L14
    L10:
        r104 = null;
    L14:
        r101.a(1, "", null);
    }
}
