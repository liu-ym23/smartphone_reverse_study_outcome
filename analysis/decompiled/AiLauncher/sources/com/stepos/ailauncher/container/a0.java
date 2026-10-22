package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/container/a0;", "", "<init>", "()V", "LXa/j;", "LY8/t;", "_events", "LXa/j;", "LXa/o;", "events", "LXa/o;", Const.INTENT_KEY_APIKEY, "()LXa/o;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a0 {
    public static final a0 INSTANCE = new a0();
    private static final Xa.j<Y8.t> _events;
    private static final Xa.o<Y8.t> events;

    static {
        Xa.j<Y8.t> jVarB = Xa.p.b(0, 1, null, 5, null);
        _events = jVarB;
        events = Xa.d.b(jVarB);
    }

    public final Xa.o<Y8.t> a() {
        return events;
    }
}
