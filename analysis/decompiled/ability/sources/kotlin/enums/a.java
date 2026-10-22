package kotlin.enums;

import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public abstract class a {
    public static final K7.a a(Enum[] entries) {
        k.f(entries, "entries");
        return new EnumEntriesList(entries);
    }
}
