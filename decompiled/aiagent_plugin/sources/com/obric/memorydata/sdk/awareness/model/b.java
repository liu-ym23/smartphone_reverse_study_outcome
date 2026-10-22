package com.obric.memorydata.sdk.awareness.model;

import com.google.gson.Gson;

/* JADX INFO: compiled from: LocationInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Gson f33831a = null;

    public static final /* synthetic */ Gson a() {
        return f33831a;
    }

    public static final /* synthetic */ LocationInfo.AoiInfo a(LocationInfo.AoiInfo r0) {
        return b(r0);
    }

    static {
        f33831a = new Gson();
    }

    private static final LocationInfo.AoiInfo b(LocationInfo.AoiInfo r4) {
        String r0 = r4.getAoiId();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        String r2 = r4.getAoiName();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        String r3 = r4.getAoiType();
        if (r3 == null) goto L13;
        r1 = r3;
    L13:
        return r4.copy(r0, r2, r1);
    }
}
