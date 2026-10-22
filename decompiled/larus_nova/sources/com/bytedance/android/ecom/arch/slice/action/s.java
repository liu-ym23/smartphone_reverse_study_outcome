package com.bytedance.android.ecom.arch.slice.action;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f49997a = null;

    static {
        int[] r100 = new int[JsonToken.values().length];
        f49997a = r100;
        r100[JsonToken.NULL.ordinal()] = 1;
        r100[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
        r100[JsonToken.BEGIN_ARRAY.ordinal()] = 3;
    }
}
