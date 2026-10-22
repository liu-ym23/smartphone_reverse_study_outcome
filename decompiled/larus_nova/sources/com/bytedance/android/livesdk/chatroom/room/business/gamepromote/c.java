package com.bytedance.android.livesdk.chatroom.room.business.gamepromote;

import com.bytedance.android.livehostapi.business.IHostGameCP;
import jc1.k;

/* JADX INFO: loaded from: classes7.dex */
public final class c extends g61.a.C5987a {
    @Override // g61.a.C5987a, g61.a
    public final boolean a() {
        IHostGameCP r100 = (IHostGameCP) k.f(IHostGameCP.class);
        if (r100 == null) goto L7;
        r100.inDegradeScene(false);
        return true;
    L7:
        return true;
    }

    @Override // g61.a.C5987a, g61.a
    public final boolean b() {
        IHostGameCP r100 = (IHostGameCP) k.f(IHostGameCP.class);
        if (r100 == null) goto L5;
        r100.inDegradeScene(true);
    L5:
        return true;
    }

    public c() {
    }
}
