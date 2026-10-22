package com.stepos.agentframework.chatcore.audit;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000-\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u000f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/agentframework/chatcore/audit/RecentModerationKeySet;", "", "", "capacity", "<init>", "(I)V", "", "key", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)Z", "LY8/t;", "c", "()V", "I", "com/stepos/agentframework/chatcore/audit/RecentModerationKeySet$keys$1", "keys", "Lcom/stepos/agentframework/chatcore/audit/RecentModerationKeySet$keys$1;", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RecentModerationKeySet {
    private final int capacity;
    private final RecentModerationKeySet$keys$1 keys;

    public RecentModerationKeySet(int i10) {
        this.capacity = i10;
        if (i10 <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        this.keys = new RecentModerationKeySet$keys$1(this, i10);
    }

    public final boolean b(String key) {
        boolean z10;
        p.i(key, "key");
        synchronized (this.keys) {
            try {
                if (this.keys.containsKey(key)) {
                    this.keys.get(key);
                    z10 = false;
                } else {
                    this.keys.put(key, t.f7040a);
                    z10 = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return z10;
    }

    public final void c() {
        synchronized (this.keys) {
            this.keys.clear();
            t tVar = t.f7040a;
        }
    }
}
