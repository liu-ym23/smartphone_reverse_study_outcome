package com.stepos.datacenter.core.storage;

import La.C0953c;
import Y6.d;
import Z8.M;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.SingleFileBundle;
import h9.InterfaceC4149a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import v9.C5685n;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0012\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/datacenter/core/storage/FileMagic;", "", "", SingleFileBundle.KEY_BYTES, "<init>", "(Ljava/lang/String;I[B)V", "[B", "getBytes", "()[B", "Companion", Const.INTENT_KEY_APIKEY, "MANIFEST", "MIGRATION_LOG", "QUARANTINE", "VECTOR_REGISTRY", "AME_HVD_VECTORS", "AME_IVF_CENTROIDS", "AME_COLLECTION_MANIFEST", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileMagic {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ FileMagic[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final byte[] HNSW_GRAPH_SHORT_MAGIC;
    private final byte[] bytes;
    public static final FileMagic MANIFEST = new FileMagic("MANIFEST", 0, d.b("DCMNFST"));
    public static final FileMagic MIGRATION_LOG = new FileMagic("MIGRATION_LOG", 1, d.b("DCMIGLG"));
    public static final FileMagic QUARANTINE = new FileMagic("QUARANTINE", 2, d.b("DCQRNTN"));
    public static final FileMagic VECTOR_REGISTRY = new FileMagic("VECTOR_REGISTRY", 3, d.b("DCVCTRG"));
    public static final FileMagic AME_HVD_VECTORS = new FileMagic("AME_HVD_VECTORS", 4, new byte[]{65, 77, 69, 95, 86, 68, 66, 0});
    public static final FileMagic AME_IVF_CENTROIDS = new FileMagic("AME_IVF_CENTROIDS", 5, new byte[]{65, 77, 69, 67, 69, 78, 10, 0});
    public static final FileMagic AME_COLLECTION_MANIFEST = new FileMagic("AME_COLLECTION_MANIFEST", 6, d.b("AMECOLL"));

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/stepos/datacenter/core/storage/FileMagic$a;", "", "<init>", "()V", "", "head", "Lcom/stepos/datacenter/core/storage/FileMagic;", Const.INTENT_KEY_APIKEY, "([B)Lcom/stepos/datacenter/core/storage/FileMagic;", "HNSW_GRAPH_SHORT_MAGIC", "[B", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: com.stepos.datacenter.core.storage.FileMagic$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final FileMagic a(byte[] head) {
            p.i(head, "head");
            FileMagic fileMagic = null;
            if (head.length < 8) {
                return null;
            }
            loop0: for (FileMagic fileMagic2 : FileMagic.getEntries()) {
                FileMagic fileMagic3 = fileMagic2;
                Iterable iterableS = C5685n.s(0, 8);
                if (!(iterableS instanceof Collection) || !((Collection) iterableS).isEmpty()) {
                    Iterator it = iterableS.iterator();
                    while (it.hasNext()) {
                        int iNextInt = ((M) it).nextInt();
                        if (head[iNextInt] == fileMagic3.getBytes()[iNextInt]) {
                        }
                    }
                }
                fileMagic = fileMagic2;
            }
            return fileMagic;
        }

        public Companion() {
        }
    }

    private static final /* synthetic */ FileMagic[] $values() {
        return new FileMagic[]{MANIFEST, MIGRATION_LOG, QUARANTINE, VECTOR_REGISTRY, AME_HVD_VECTORS, AME_IVF_CENTROIDS, AME_COLLECTION_MANIFEST};
    }

    static {
        FileMagic[] fileMagicArr$values = $values();
        $VALUES = fileMagicArr$values;
        $ENTRIES = kotlin.enums.a.a(fileMagicArr$values);
        INSTANCE = new Companion(null);
        byte[] bytes = "AMEH".getBytes(C0953c.US_ASCII);
        p.h(bytes, "getBytes(...)");
        HNSW_GRAPH_SHORT_MAGIC = bytes;
    }

    private FileMagic(String str, int i10, byte[] bArr) {
        this.bytes = bArr;
        if (bArr.length == 8) {
            return;
        }
        throw new IllegalArgumentException(("FileMagic " + name() + " must be exactly 8 bytes, got " + bArr.length).toString());
    }

    public static InterfaceC4149a<FileMagic> getEntries() {
        return $ENTRIES;
    }

    public static FileMagic valueOf(String str) {
        return (FileMagic) Enum.valueOf(FileMagic.class, str);
    }

    public static FileMagic[] values() {
        return (FileMagic[]) $VALUES.clone();
    }

    public final byte[] getBytes() {
        return this.bytes;
    }
}
