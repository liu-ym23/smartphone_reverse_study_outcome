package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/container/d0;", "", "<init>", "()V", "", "covering", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Z)V", "LXa/k;", "_covering", "LXa/k;", "LXa/t;", "LXa/t;", Const.INTENT_KEY_APIKEY, "()LXa/t;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d0 {
    public static final d0 INSTANCE = new d0();
    private static final Xa.k<Boolean> _covering;
    private static final Xa.t<Boolean> covering;

    static {
        Xa.k<Boolean> kVarA = Xa.u.a(Boolean.FALSE);
        _covering = kVarA;
        covering = Xa.d.c(kVarA);
    }

    public final Xa.t<Boolean> a() {
        return covering;
    }

    public final void b(boolean covering2) {
        _covering.setValue(Boolean.valueOf(covering2));
    }
}
