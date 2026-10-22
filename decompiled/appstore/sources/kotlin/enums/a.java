package kotlin.enums;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final EnumEntries a(Enum[] r10) {
        q.g(r10, "entries");
        return new EnumEntriesList(r10);
    }
}
