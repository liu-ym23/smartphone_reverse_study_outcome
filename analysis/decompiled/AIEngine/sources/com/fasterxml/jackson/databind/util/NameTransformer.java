package com.fasterxml.jackson.databind.util;

import java.io.Serializable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public abstract class NameTransformer {

    /* renamed from: a, reason: collision with root package name */
    public static final NopTransformer f4511a = new NopTransformer();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Chained extends NameTransformer implements Serializable {

        /* renamed from: b, reason: collision with root package name */
        public final NameTransformer f4512b;

        /* renamed from: c, reason: collision with root package name */
        public final NameTransformer f4513c;

        public Chained(NameTransformer nameTransformer, NameTransformer nameTransformer2) {
            this.f4512b = nameTransformer;
            this.f4513c = nameTransformer2;
        }

        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public final String a(String str) {
            return this.f4512b.a(this.f4513c.a(str));
        }

        public final String toString() {
            return "[ChainedTransformer(" + this.f4512b + ", " + this.f4513c + ")]";
        }
    }

    public abstract String a(String str);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class NopTransformer extends NameTransformer implements Serializable {
        @Override // com.fasterxml.jackson.databind.util.NameTransformer
        public final String a(String str) {
            return str;
        }
    }
}
