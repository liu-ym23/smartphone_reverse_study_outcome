package kotlin.enums;

import java.io.Serializable;
import java.lang.Enum;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class EnumEntriesSerializationProxy<E extends Enum<E>> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Class<E> f10068a;

    public EnumEntriesSerializationProxy(E[] entries) {
        g.f(entries, "entries");
        Class<E> cls = (Class<E>) entries.getClass().getComponentType();
        g.c(cls);
        this.f10068a = cls;
    }

    private final Object readResolve() {
        E[] enumConstants = this.f10068a.getEnumConstants();
        g.e(enumConstants, "getEnumConstants(...)");
        return a.a(enumConstants);
    }
}
