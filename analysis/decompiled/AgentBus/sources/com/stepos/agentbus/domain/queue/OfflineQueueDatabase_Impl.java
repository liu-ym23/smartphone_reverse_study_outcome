package com.stepos.agentbus.domain.queue;

import a7.d;
import ab.x;
import android.content.Context;
import g3.e;
import g3.k;
import i5.f;
import i5.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import m3.a;
import n3.h;

/* loaded from: classes.dex */
public final class OfflineQueueDatabase_Impl extends OfflineQueueDatabase {

    /* renamed from: l, reason: collision with root package name */
    public volatile f f2677l;

    /* renamed from: m, reason: collision with root package name */
    public volatile l f2678m;

    @Override // com.stepos.agentbus.domain.queue.OfflineQueueDatabase
    public final k d() {
        return new k(this, new HashMap(0), new HashMap(0), "offline_frame", "offline_frame_tombstone");
    }

    @Override // com.stepos.agentbus.domain.queue.OfflineQueueDatabase
    public final a e(e eVar) {
        x xVar = new x(eVar, new d(13, this));
        Context context = (Context) eVar.f3803c;
        q7.k.e(context, "context");
        return new h(context, "agentbus_offline_queue.db", xVar);
    }

    @Override // com.stepos.agentbus.domain.queue.OfflineQueueDatabase
    public final f f() {
        f fVar;
        if (this.f2677l != null) {
            return this.f2677l;
        }
        synchronized (this) {
            try {
                if (this.f2677l == null) {
                    this.f2677l = new f(this);
                }
                fVar = this.f2677l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }

    @Override // com.stepos.agentbus.domain.queue.OfflineQueueDatabase
    public final List g(Map map) {
        return new ArrayList();
    }

    @Override // com.stepos.agentbus.domain.queue.OfflineQueueDatabase
    public final Set i() {
        return new HashSet();
    }

    @Override // com.stepos.agentbus.domain.queue.OfflineQueueDatabase
    public final Map j() {
        HashMap map = new HashMap();
        List list = Collections.EMPTY_LIST;
        map.put(f.class, list);
        map.put(l.class, list);
        return map;
    }

    @Override // com.stepos.agentbus.domain.queue.OfflineQueueDatabase
    public final l o() {
        l lVar;
        if (this.f2678m != null) {
            return this.f2678m;
        }
        synchronized (this) {
            try {
                if (this.f2678m == null) {
                    this.f2678m = new l(this);
                }
                lVar = this.f2678m;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }
}
