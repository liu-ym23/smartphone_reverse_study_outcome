package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.SecurePrefs;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H¦@¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\f¨\u0006\u0011À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "isAvailable", "()Z", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "texts", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "embed", "(Ljava/util/List;Lf5/c;)Ljava/lang/Object;", "getId", "()Ljava/lang/String;", "id", "getDisplayName", "displayName", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface EmbeddingProvider {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/stepos/stepclaw/memory/embedding/EmbeddingProvider$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "id", "Lb5/a0;", "requireValidId", "(Ljava/lang/String;)V", "Lx5/l;", "ID_REGEX", "Lx5/l;", "getID_REGEX", "()Lx5/l;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "ID_PREFIXES", "Ljava/util/List;", "getID_PREFIXES", "()Ljava/util/List;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final x5.l ID_REGEX = new x5.l("[a-z0-9-]+");
        private static final List<String> ID_PREFIXES = c5.l.S(new String[]{"remote-", "local-"});

        private Companion() {
        }

        public final List<String> getID_PREFIXES() {
            return ID_PREFIXES;
        }

        public final x5.l getID_REGEX() {
            return ID_REGEX;
        }

        public final void requireValidId(String id) {
            p.e(id, "id");
            if (x5.n.t1(id)) {
                throw new IllegalArgumentException("EmbeddingProvider id must not be blank");
            }
            x5.l lVar = ID_REGEX;
            if (!lVar.e(id)) {
                String strPattern = lVar.f6301a.pattern();
                p.d(strPattern, "pattern(...)");
                throw new IllegalArgumentException(("EmbeddingProvider id '" + id + "' must match " + strPattern).toString());
            }
            List<String> list = ID_PREFIXES;
            if (list == null || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (u.c1(id, (String) it.next(), false)) {
                        return;
                    }
                }
            }
            throw new IllegalArgumentException(("EmbeddingProvider id '" + id + "' must start with one of " + ID_PREFIXES).toString());
        }
    }

    Object embed(List<String> list, f5.c cVar);

    String getDisplayName();

    String getId();

    boolean isAvailable();
}
