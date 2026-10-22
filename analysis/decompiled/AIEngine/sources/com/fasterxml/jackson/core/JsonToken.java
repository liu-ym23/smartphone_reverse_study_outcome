package com.fasterxml.jackson.core;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public enum JsonToken {
    NOT_AVAILABLE(-1, null),
    START_OBJECT(1, "{"),
    END_OBJECT(2, "}"),
    START_ARRAY(3, "["),
    END_ARRAY(4, "]"),
    FIELD_NAME(5, null),
    VALUE_EMBEDDED_OBJECT(12, null),
    VALUE_STRING(6, null),
    VALUE_NUMBER_INT(7, null),
    VALUE_NUMBER_FLOAT(8, null),
    VALUE_TRUE(9, "true"),
    VALUE_FALSE(10, "false"),
    VALUE_NULL(11, "null");


    /* renamed from: a, reason: collision with root package name */
    public final String f3594a;

    /* renamed from: b, reason: collision with root package name */
    public final char[] f3595b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f3596c;

    /* renamed from: d, reason: collision with root package name */
    public final int f3597d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f3598e;
    public final boolean h;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f3599j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f3600k;

    JsonToken(int i10, String str) {
        boolean z = false;
        if (str == null) {
            this.f3594a = null;
            this.f3595b = null;
            this.f3596c = null;
        } else {
            this.f3594a = str;
            char[] charArray = str.toCharArray();
            this.f3595b = charArray;
            int length = charArray.length;
            this.f3596c = new byte[length];
            for (int i11 = 0; i11 < length; i11++) {
                this.f3596c[i11] = (byte) this.f3595b[i11];
            }
        }
        this.f3597d = i10;
        if (i10 != 10) {
        }
        this.f3599j = i10 == 7 || i10 == 8;
        boolean z3 = i10 == 1 || i10 == 3;
        this.f3598e = z3;
        boolean z10 = i10 == 2 || i10 == 4;
        this.h = z10;
        if (!z3 && !z10 && i10 != 5 && i10 != -1) {
            z = true;
        }
        this.f3600k = z;
    }
}
