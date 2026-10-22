package ua;

import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import ya.AbstractC5990d0;

/* renamed from: ua.w, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public interface InterfaceC5637w {

    /* renamed from: ua.w$a */
    public static final class a implements InterfaceC5637w {

        /* renamed from: a, reason: collision with root package name */
        public static final a f42654a = new a();

        @Override // ua.InterfaceC5637w
        public ya.S a(ProtoBuf$Type proto, String flexibleId, AbstractC5990d0 lowerBound, AbstractC5990d0 upperBound) {
            kotlin.jvm.internal.p.i(proto, "proto");
            kotlin.jvm.internal.p.i(flexibleId, "flexibleId");
            kotlin.jvm.internal.p.i(lowerBound, "lowerBound");
            kotlin.jvm.internal.p.i(upperBound, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    ya.S a(ProtoBuf$Type protoBuf$Type, String str, AbstractC5990d0 abstractC5990d0, AbstractC5990d0 abstractC5990d02);
}
