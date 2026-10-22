package com.bytedance.android.ec.core.buynow;

import com.google.gson.stream.JsonToken;

/* JADX INFO: loaded from: classes43.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f43912a = null;

    static {
        int[] r100 = new int[JsonToken.values().length];
        f43912a = r100;
        r100[JsonToken.BEGIN_ARRAY.ordinal()] = 1;
        r100[JsonToken.BEGIN_OBJECT.ordinal()] = 2;
        r100[JsonToken.STRING.ordinal()] = 3;
        r100[JsonToken.NUMBER.ordinal()] = 4;
        r100[JsonToken.BOOLEAN.ordinal()] = 5;
        r100[JsonToken.NULL.ordinal()] = 6;
    }
}
