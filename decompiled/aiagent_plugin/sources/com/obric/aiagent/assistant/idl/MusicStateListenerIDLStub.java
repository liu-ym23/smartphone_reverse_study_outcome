package com.obric.aiagent.assistant.idl;

import android.os.Bundle;
import android.os.IBinder;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: MusicStateListenerIDLExt.kt */
/* JADX INFO: loaded from: classes2.dex */
final class MusicStateListenerIDLStub extends IMusicStateListenerIDL.Stub implements IMusicStateListenerIDL {
    private final /* synthetic */ IMusicStateListenerIDL $$delegate_0;

    @Override // com.obric.aiagent.assistant.idl.IMusicStateListenerIDL
    public void onMusicStateChanged(Bundle r1) {
        this.$$delegate_0.onMusicStateChanged(r1);
    }

    public MusicStateListenerIDLStub() {
        Object r0 = (IMusicStateListenerIDLSPI) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(IMusicStateListenerIDLSPI.class), IMusicStateListenerIDLSPI.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        r0 = new IMusicStateListenerIDL.Default();
    L6:
        this.$$delegate_0 = (IMusicStateListenerIDL) ZeusTransformUtils.preCheckCast(r0, IMusicStateListenerIDL.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.aiagent.assistant.idl.IMusicStateListenerIDL.Stub, android.os.IInterface
    public IBinder asBinder() {
        IBinder r1 = super.asBinder();
        d.h.b.o.c(r1, "asBinder(...)");
        return r1;
    }
}
