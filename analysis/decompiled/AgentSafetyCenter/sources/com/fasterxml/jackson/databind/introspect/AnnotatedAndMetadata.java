package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.databind.introspect.Annotated;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class AnnotatedAndMetadata<A extends Annotated, M> {
    public final A annotated;
    public final M metadata;

    public AnnotatedAndMetadata(A a10, M m6) {
        this.annotated = a10;
        this.metadata = m6;
    }

    public static <A extends Annotated, M> AnnotatedAndMetadata<A, M> of(A a10, M m6) {
        return new AnnotatedAndMetadata<>(a10, m6);
    }
}
