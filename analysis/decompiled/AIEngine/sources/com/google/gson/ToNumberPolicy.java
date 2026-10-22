package com.google.gson;

import androidx.datastore.preferences.protobuf.b1;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.MalformedJsonException;
import d5.t;
import java.io.IOException;
import k5.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class ToNumberPolicy implements t {

    /* renamed from: a, reason: collision with root package name */
    public static final ToNumberPolicy f5438a;

    /* renamed from: b, reason: collision with root package name */
    public static final ToNumberPolicy f5439b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ToNumberPolicy[] f5440c;

    static {
        ToNumberPolicy toNumberPolicy = new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.1
            @Override // d5.t
            public final Number a(a aVar) {
                return Double.valueOf(aVar.I0());
            }
        };
        f5438a = toNumberPolicy;
        ToNumberPolicy toNumberPolicy2 = new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.2
            @Override // d5.t
            public final Number a(a aVar) {
                return new LazilyParsedNumber(aVar.P0());
            }
        };
        f5439b = toNumberPolicy2;
        f5440c = new ToNumberPolicy[]{toNumberPolicy, toNumberPolicy2, new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.3
            public static Double b(String str, a aVar) throws MalformedJsonException, NumberFormatException {
                try {
                    Double dValueOf = Double.valueOf(str);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!(aVar.f9921b == Strictness.f5434a)) {
                            throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + aVar.g0());
                        }
                    }
                    return dValueOf;
                } catch (NumberFormatException e10) {
                    StringBuilder sbQ = a0.a.q("Cannot parse ", str, "; at path ");
                    sbQ.append(aVar.g0());
                    throw new JsonParseException(sbQ.toString(), e10);
                }
            }

            @Override // d5.t
            public final Number a(a aVar) throws IOException {
                String strP0 = aVar.P0();
                if (strP0.indexOf(46) >= 0) {
                    return b(strP0, aVar);
                }
                try {
                    return Long.valueOf(Long.parseLong(strP0));
                } catch (NumberFormatException unused) {
                    return b(strP0, aVar);
                }
            }
        }, new ToNumberPolicy() { // from class: com.google.gson.ToNumberPolicy.4
            @Override // d5.t
            public final Number a(a aVar) throws IOException {
                String strP0 = aVar.P0();
                try {
                    return b1.R(strP0);
                } catch (NumberFormatException e10) {
                    StringBuilder sbQ = a0.a.q("Cannot parse ", strP0, "; at path ");
                    sbQ.append(aVar.g0());
                    throw new JsonParseException(sbQ.toString(), e10);
                }
            }
        }};
    }

    public ToNumberPolicy() {
        throw null;
    }

    public static ToNumberPolicy valueOf(String str) {
        return (ToNumberPolicy) Enum.valueOf(ToNumberPolicy.class, str);
    }

    public static ToNumberPolicy[] values() {
        return (ToNumberPolicy[]) f5440c.clone();
    }
}
