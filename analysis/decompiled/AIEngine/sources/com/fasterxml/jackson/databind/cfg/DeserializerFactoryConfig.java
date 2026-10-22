package com.fasterxml.jackson.databind.cfg;

import androidx.datastore.preferences.protobuf.f;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializers;
import e3.b;
import e3.g;
import e3.h;
import e3.l;
import java.io.Serializable;
import q3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class DeserializerFactoryConfig implements Serializable {
    public static final g[] h = new g[0];

    /* renamed from: j, reason: collision with root package name */
    public static final b[] f3818j = new b[0];

    /* renamed from: k, reason: collision with root package name */
    public static final f[] f3819k = new f[0];

    /* renamed from: l, reason: collision with root package name */
    public static final l[] f3820l = new l[0];

    /* renamed from: m, reason: collision with root package name */
    public static final h[] f3821m = {new StdKeyDeserializers()};

    /* renamed from: a, reason: collision with root package name */
    public final g[] f3822a = h;

    /* renamed from: b, reason: collision with root package name */
    public final h[] f3823b = f3821m;

    /* renamed from: c, reason: collision with root package name */
    public final b[] f3824c = f3818j;

    /* renamed from: d, reason: collision with root package name */
    public final f[] f3825d = f3819k;

    /* renamed from: e, reason: collision with root package name */
    public final l[] f3826e = f3820l;

    public final c a() {
        return new c(this.f3824c);
    }

    public final c b() {
        return new c(this.f3822a);
    }

    public final boolean c() {
        return this.f3824c.length > 0;
    }
}
