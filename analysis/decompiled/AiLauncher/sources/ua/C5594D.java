package ua;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import p9.InterfaceC5063a;

/* renamed from: ua.D, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5594D implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42521a;

    /* renamed from: b, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.protobuf.h f42522b;

    /* renamed from: c, reason: collision with root package name */
    public final AnnotatedCallableKind f42523c;

    public C5594D(C5601K c5601k, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind) {
        this.f42521a = c5601k;
        this.f42522b = hVar;
        this.f42523c = annotatedCallableKind;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.n(this.f42521a, this.f42522b, this.f42523c);
    }
}
