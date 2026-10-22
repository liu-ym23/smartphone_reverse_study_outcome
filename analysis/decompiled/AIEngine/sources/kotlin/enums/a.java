package kotlin.enums;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {
    public static final <E extends Enum<E>> sb.a<E> a(E[] entries) {
        g.f(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
