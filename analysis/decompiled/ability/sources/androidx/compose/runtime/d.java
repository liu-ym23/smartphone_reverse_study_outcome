package androidx.compose.runtime;

import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComposerKt.InvalidationLocationAscending$lambda$13((Invalidation) obj, (Invalidation) obj2);
    }
}
