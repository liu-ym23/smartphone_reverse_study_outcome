package ua;

import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import p9.InterfaceC5063a;

/* renamed from: ua.F, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5596F implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42527a;

    /* renamed from: b, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.protobuf.h f42528b;

    /* renamed from: c, reason: collision with root package name */
    public final AnnotatedCallableKind f42529c;

    public C5596F(C5601K c5601k, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind) {
        this.f42527a = c5601k;
        this.f42528b = hVar;
        this.f42529c = annotatedCallableKind;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.s(this.f42527a, this.f42528b, this.f42529c);
    }
}
