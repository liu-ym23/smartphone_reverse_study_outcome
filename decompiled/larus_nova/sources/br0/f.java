package br0;

import android.os.Bundle;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.android.live.openplatform.impl.minigamecommon.context.MiniGameContext;
import com.bytedance.android.livesdk.config.c90;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends lr0.a {
    public f(MiniGameContext r100) {
        Intrinsics.checkNotNullParameter(r100, "miniGameContext");
        super(r100);
    }

    @Override // com.bytedance.android.livehostapi.business.depend.openplatform.IEventListener
    public final Bundle onEvent(Bundle r100) {
        boolean r101 = zq0.b.a();
        Bundle r102 = new Bundle();
        if (r101 == true) goto L15;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r103 = AnchorMiniGameDataContext.a.a();
        if (r103 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r104 = r103.getOpenCamera();
        if (r104 == null) goto L11;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L11;
    L13:
        if (r105.booleanValue() == false) goto L15;
        boolean r106 = true;
    L16:
        r102.putBoolean("camera_capture_status", r106);
        return r102;
    L11:
        r105 = c90.f119929a.getValue();
    L15:
        r106 = false;
        goto L16
    }
}
