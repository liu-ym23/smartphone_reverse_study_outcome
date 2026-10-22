package com.stepos.ailauncher.container;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/container/b0;", "", "<init>", "()V", "", "px", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(I)V", "LXa/k;", "_keyboardHeightPx", "LXa/k;", "LXa/t;", "keyboardHeightPx", "LXa/t;", Const.INTENT_KEY_APIKEY, "()LXa/t;", "container_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b0 {
    public static final b0 INSTANCE = new b0();
    private static final Xa.k<Integer> _keyboardHeightPx;
    private static final Xa.t<Integer> keyboardHeightPx;

    static {
        Xa.k<Integer> kVarA = Xa.u.a(0);
        _keyboardHeightPx = kVarA;
        keyboardHeightPx = Xa.d.c(kVarA);
    }

    public final Xa.t<Integer> a() {
        return keyboardHeightPx;
    }

    public final void b(int px) {
        _keyboardHeightPx.setValue(Integer.valueOf(C5685n.f(px, 0)));
    }
}
