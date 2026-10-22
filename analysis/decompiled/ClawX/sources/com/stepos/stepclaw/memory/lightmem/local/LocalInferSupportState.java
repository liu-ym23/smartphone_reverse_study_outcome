package com.stepos.stepclaw.memory.lightmem.local;

import com.stepos.stepclaw.SecurePrefs;
import i5.a;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.i;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0012"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "code", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "OK", "NONE", "DOWNLOADING", "NEED_UPDATE", "NO_ALGORITHM", "UNKNOWN", "isReady", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "()Z", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LocalInferSupportState {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ LocalInferSupportState[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int code;
    public static final LocalInferSupportState OK = new LocalInferSupportState("OK", 0, 1);
    public static final LocalInferSupportState NONE = new LocalInferSupportState("NONE", 1, 0);
    public static final LocalInferSupportState DOWNLOADING = new LocalInferSupportState("DOWNLOADING", 2, 3);
    public static final LocalInferSupportState NEED_UPDATE = new LocalInferSupportState("NEED_UPDATE", 3, 5);
    public static final LocalInferSupportState NO_ALGORITHM = new LocalInferSupportState("NO_ALGORITHM", 4, -2);
    public static final LocalInferSupportState UNKNOWN = new LocalInferSupportState("UNKNOWN", 5, -999);

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "fromCode", "Lcom/stepos/stepclaw/memory/lightmem/local/LocalInferSupportState;", "code", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final LocalInferSupportState fromCode(int code) {
            Object next;
            Iterator<E> it = LocalInferSupportState.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (((LocalInferSupportState) next).getCode() == code) {
                    break;
                }
            }
            LocalInferSupportState localInferSupportState = (LocalInferSupportState) next;
            return localInferSupportState == null ? LocalInferSupportState.UNKNOWN : localInferSupportState;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ LocalInferSupportState[] $values() {
        return new LocalInferSupportState[]{OK, NONE, DOWNLOADING, NEED_UPDATE, NO_ALGORITHM, UNKNOWN};
    }

    static {
        LocalInferSupportState[] localInferSupportStateArr$values = $values();
        $VALUES = localInferSupportStateArr$values;
        $ENTRIES = a.a.F(localInferSupportStateArr$values);
        INSTANCE = new Companion(null);
    }

    private LocalInferSupportState(String str, int i8, int i9) {
        this.code = i9;
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static LocalInferSupportState valueOf(String str) {
        return (LocalInferSupportState) Enum.valueOf(LocalInferSupportState.class, str);
    }

    public static LocalInferSupportState[] values() {
        return (LocalInferSupportState[]) $VALUES.clone();
    }

    public final int getCode() {
        return this.code;
    }

    public final boolean isReady() {
        return this == OK || this == NONE;
    }
}
