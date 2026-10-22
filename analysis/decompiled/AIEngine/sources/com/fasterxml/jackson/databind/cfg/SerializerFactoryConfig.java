package com.fasterxml.jackson.databind.cfg;

import java.io.Serializable;
import n3.b;
import n3.g;
import q3.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SerializerFactoryConfig implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final g[] f3836d = new g[0];

    /* renamed from: e, reason: collision with root package name */
    public static final b[] f3837e = new b[0];

    /* renamed from: a, reason: collision with root package name */
    public final g[] f3838a;

    /* renamed from: b, reason: collision with root package name */
    public final g[] f3839b;

    /* renamed from: c, reason: collision with root package name */
    public final b[] f3840c;

    public SerializerFactoryConfig() {
        g[] gVarArr = f3836d;
        this.f3838a = gVarArr;
        this.f3839b = gVarArr;
        this.f3840c = f3837e;
    }

    public final boolean a() {
        return this.f3840c.length > 0;
    }

    public final c b() {
        return new c(this.f3840c);
    }
}
