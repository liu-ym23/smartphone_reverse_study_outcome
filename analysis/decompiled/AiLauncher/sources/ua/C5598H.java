package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import p9.InterfaceC5063a;

/* renamed from: ua.H, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5598H implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42536a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5604N f42537b;

    /* renamed from: c, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.protobuf.h f42538c;

    /* renamed from: d, reason: collision with root package name */
    public final AnnotatedCallableKind f42539d;

    /* renamed from: e, reason: collision with root package name */
    public final int f42540e;

    /* renamed from: f, reason: collision with root package name */
    public final ProtoBuf$ValueParameter f42541f;

    public C5598H(C5601K c5601k, AbstractC5604N abstractC5604N, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind, int i10, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        this.f42536a = c5601k;
        this.f42537b = abstractC5604N;
        this.f42538c = hVar;
        this.f42539d = annotatedCallableKind;
        this.f42540e = i10;
        this.f42541f = protoBuf$ValueParameter;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.l(this.f42536a, this.f42537b, this.f42538c, this.f42539d, this.f42540e, this.f42541f);
    }
}
