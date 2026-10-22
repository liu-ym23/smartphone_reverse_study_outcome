package com.bytedance.android.live.profile.reportdialog;

import android.os.Message;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;
import q46.b;

/* JADX INFO: loaded from: classes47.dex */
public final class a extends b<InterfaceC1326a> implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: com.bytedance.android.live.profile.reportdialog.a$a, reason: collision with other inner class name */
    public interface InterfaceC1326a extends q46.a {
        void N2(IBaseUser r100, boolean r101);

        void i7(Throwable r100);
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdkapi.depend.handler.WeakHandler.IHandler
    public final void handleMsg(Message r100) {
        if (r100.what != 0) goto L18;
        T r101 = this.f531633a;
        if (r101 != 0) goto L8;
        return;
    L8:
        Object r102 = r100.obj;
        if ((r102 instanceof Exception) == false) goto L12;
        ((InterfaceC1326a) r101).i7((Exception) r102);
        return;
    L12:
        if ((r102 instanceof IBaseUser) == false) goto L14;
        ((InterfaceC1326a) r101).N2((IBaseUser) r102, false);
        return;
    L14:
        ((InterfaceC1326a) r101).i7(new Exception("unknown msg.what"));
        return;
    }
}
