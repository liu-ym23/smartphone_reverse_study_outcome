package com.bytedance.bdtracker;

import com.bytedance.bdtracker.b;

/* loaded from: classes.dex */
public final class v implements b.g {
    public final /* synthetic */ o4 a;

    public v(o4 o4Var) {
        this.a = o4Var;
    }

    @Override // com.bytedance.bdtracker.b.g
    public boolean a(d dVar) {
        if (b.d.a(dVar) && !dVar.isAutoTrackPageIgnored(this.a.E)) {
            return !this.a.D || dVar.getInitConfig() == null || dVar.getInitConfig().isAutoTrackFragmentEnabled();
        }
        return false;
    }
}
