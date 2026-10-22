package com.fasterxml.jackson.core;

import a3.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public enum StreamReadCapability implements e {
    DUPLICATE_PROPERTIES,
    /* JADX INFO: Fake field, exist only in values array */
    SCALARS_AS_OBJECTS,
    UNTYPED_SCALARS;


    /* renamed from: a, reason: collision with root package name */
    public final int f3604a = 1 << ordinal();

    StreamReadCapability() {
    }

    @Override // a3.e
    public final boolean a() {
        return false;
    }

    @Override // a3.e
    public final int b() {
        return this.f3604a;
    }
}
