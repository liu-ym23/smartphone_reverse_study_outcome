package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DefaultIndenter extends DefaultPrettyPrinter.NopIndenter {

    /* renamed from: d, reason: collision with root package name */
    public static final DefaultIndenter f3631d;

    /* renamed from: c, reason: collision with root package name */
    public final String f3634c;

    /* renamed from: b, reason: collision with root package name */
    public final int f3633b = 2;

    /* renamed from: a, reason: collision with root package name */
    public final char[] f3632a = new char[32];

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (Throwable unused) {
            property = "\n";
        }
        f3631d = new DefaultIndenter(property);
    }

    public DefaultIndenter(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            "  ".getChars(0, 2, this.f3632a, i10);
            i10 += 2;
        }
        this.f3634c = str;
    }

    @Override // com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter, com.fasterxml.jackson.core.util.DefaultPrettyPrinter.a
    public final void a(JsonGenerator jsonGenerator, int i10) {
        jsonGenerator.U0(this.f3634c);
        if (i10 <= 0) {
            return;
        }
        int length = i10 * this.f3633b;
        while (true) {
            char[] cArr = this.f3632a;
            if (length <= cArr.length) {
                jsonGenerator.W0(cArr, length);
                return;
            } else {
                jsonGenerator.W0(cArr, cArr.length);
                length -= cArr.length;
            }
        }
    }
}
