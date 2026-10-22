package com.bytedance.bdtracker;

import com.bytedance.applog.event.AutoTrackEventType;
import com.bytedance.bdtracker.b;

/* loaded from: classes.dex */
public final class u implements b.g {
    @Override // com.bytedance.bdtracker.b.g
    public boolean a(d dVar) {
        return dVar.isBavEnabled() && dVar.getInitConfig() != null && AutoTrackEventType.a(dVar.getInitConfig().getAutoTrackEventType(), 8);
    }
}
