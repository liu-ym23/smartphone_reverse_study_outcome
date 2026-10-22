package com.bytedance.android.ecom.arch.slice.render.elements;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes44.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f50410a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f50411b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f50412c = null;

    static {
        int[] r100 = new int[JsonToken.values().length];
        f50410a = r100;
        JsonToken r101 = JsonToken.BEGIN_OBJECT;
        r100[r101.ordinal()] = 1;
        JsonToken r102 = JsonToken.NULL;
        r100[r102.ordinal()] = 2;
        int[] r103 = new int[JsonToken.values().length];
        f50411b = r103;
        r103[r102.ordinal()] = 1;
        r103[r101.ordinal()] = 2;
        r103[JsonToken.BEGIN_ARRAY.ordinal()] = 3;
        r103[JsonToken.STRING.ordinal()] = 4;
        int[] r104 = new int[JsonToken.values().length];
        f50412c = r104;
        r104[r101.ordinal()] = 1;
        r104[r102.ordinal()] = 2;
    }
}
