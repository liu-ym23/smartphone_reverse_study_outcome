package com.fasterxml.jackson.databind.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PlaceholderForType.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends m {
    protected final int f;
    protected com.fasterxml.jackson.databind.k g;

    @Override // com.fasterxml.jackson.databind.k
    public boolean equals(Object r1) {
        if (r1 != this) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.fasterxml.jackson.databind.k
    public boolean q() {
        return false;
    }

    public i(int r10) {
        super(Object.class, n.a(), o.c(), null, 1, null, null, false);
        this.f = r10;
    }

    public com.fasterxml.jackson.databind.k H() {
        return this.g;
    }

    public void c(com.fasterxml.jackson.databind.k r1) {
        this.g = r1;
    }

    @Override // com.fasterxml.jackson.databind.k.m
    public String I() {
        return toString();
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder a(StringBuilder r1) {
        return b(r1);
    }

    @Override // com.fasterxml.jackson.databind.k
    public StringBuilder b(StringBuilder r2) {
        r2.append('$').append(this.f + 1);
        return r2;
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Object r2) {
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(J(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k b(Object r2) {
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(J(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k c(Object r2) {
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(J(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k d(Object r2) {
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(J(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.k r2) {
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(J(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k d() {
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(J(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.k
    public com.fasterxml.jackson.databind.k a(Class<?> r1, n r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.k[] r4) {
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(J(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.k
    public String toString() {
        return b(new StringBuilder()).toString();
    }

    private <T> T J() {
        throw new UnsupportedOperationException("Operation should not be attempted on " + getClass().getName());
    }
}
