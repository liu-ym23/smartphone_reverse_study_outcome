package com.fasterxml.jackson.databind.b.a;

/* JADX INFO: compiled from: ErrorThrowingDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends com.fasterxml.jackson.databind.l<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Error f12291a;

    public f(NoClassDefFoundError r1) {
        this.f12291a = r1;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        throw this.f12291a;
    }
}
