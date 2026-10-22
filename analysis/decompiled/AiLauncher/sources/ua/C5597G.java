package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import p9.InterfaceC5063a;

/* renamed from: ua.G, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5597G implements InterfaceC5063a {

    /* renamed from: a, reason: collision with root package name */
    public final C5601K f42530a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC5604N f42531b;

    /* renamed from: c, reason: collision with root package name */
    public final kotlin.reflect.jvm.internal.impl.protobuf.h f42532c;

    /* renamed from: d, reason: collision with root package name */
    public final AnnotatedCallableKind f42533d;

    /* renamed from: e, reason: collision with root package name */
    public final int f42534e;

    /* renamed from: f, reason: collision with root package name */
    public final ProtoBuf$ValueParameter f42535f;

    public C5597G(C5601K c5601k, AbstractC5604N abstractC5604N, kotlin.reflect.jvm.internal.impl.protobuf.h hVar, AnnotatedCallableKind annotatedCallableKind, int i10, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        this.f42530a = c5601k;
        this.f42531b = abstractC5604N;
        this.f42532c = hVar;
        this.f42533d = annotatedCallableKind;
        this.f42534e = i10;
        this.f42535f = protoBuf$ValueParameter;
    }

    @Override // p9.InterfaceC5063a
    public Object invoke() {
        return C5601K.F(this.f42530a, this.f42531b, this.f42532c, this.f42533d, this.f42534e, this.f42535f);
    }
}
