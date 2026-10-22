package ua;

import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

/* renamed from: ua.l, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5626l {

    /* renamed from: a, reason: collision with root package name */
    public static final a f42608a = a.f42609a;

    /* renamed from: ua.l$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f42609a = new a();

        /* renamed from: b, reason: collision with root package name */
        public static final InterfaceC5626l f42610b = new C0536a();

        /* renamed from: ua.l$a$a, reason: collision with other inner class name */
        public static final class C0536a implements InterfaceC5626l {
            @Override // ua.InterfaceC5626l
            public Pair a(ProtoBuf$Function proto, kotlin.reflect.jvm.internal.impl.descriptors.e ownerFunction, ea.h typeTable, TypeDeserializer typeDeserializer) {
                kotlin.jvm.internal.p.i(proto, "proto");
                kotlin.jvm.internal.p.i(ownerFunction, "ownerFunction");
                kotlin.jvm.internal.p.i(typeTable, "typeTable");
                kotlin.jvm.internal.p.i(typeDeserializer, "typeDeserializer");
                return null;
            }
        }

        public final InterfaceC5626l a() {
            return f42610b;
        }
    }

    Pair<a.InterfaceC0437a<?>, Object> a(ProtoBuf$Function protoBuf$Function, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, ea.h hVar, TypeDeserializer typeDeserializer);
}
