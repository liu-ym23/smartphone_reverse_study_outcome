package com.stepos.ailauncher.common.utils;

import com.autonavi.aps.amapapi.config.Const;
import java.util.LinkedHashSet;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u000ej\b\u0012\u0004\u0012\u00020\u0002`\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/ailauncher/common/utils/K;", "", "", "capacity", "<init>", "(I)V", "sessionId", "", Const.INTENT_KEY_PKGNAME, "(I)Z", Const.INTENT_KEY_APIKEY, "I", "lock", "Ljava/lang/Object;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "sessions", "Ljava/util/LinkedHashSet;", "Companion", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class K {
    public static final int DEFAULT_CAPACITY = 16;
    private static final int INVALID_SESSION = 0;
    private final int capacity;
    private final Object lock;
    private final LinkedHashSet<Integer> sessions;

    public K(int i10) {
        this.capacity = i10;
        this.lock = new Object();
        this.sessions = new LinkedHashSet<>();
    }

    public final boolean a(int sessionId) {
        boolean zContains;
        if (sessionId <= 0) {
            return false;
        }
        synchronized (this.lock) {
            zContains = this.sessions.contains(Integer.valueOf(sessionId));
        }
        return zContains;
    }

    public final boolean b(int sessionId) {
        if (sessionId <= 0) {
            return false;
        }
        synchronized (this.lock) {
            if (!this.sessions.add(Integer.valueOf(sessionId))) {
                return false;
            }
            while (this.sessions.size() > this.capacity) {
                LinkedHashSet<Integer> linkedHashSet = this.sessions;
                linkedHashSet.remove(Z8.F.p0(linkedHashSet));
            }
            return true;
        }
    }

    public /* synthetic */ K(int i10, int i11, kotlin.jvm.internal.i iVar) {
        this((i11 & 1) != 0 ? 16 : i10);
    }
}
