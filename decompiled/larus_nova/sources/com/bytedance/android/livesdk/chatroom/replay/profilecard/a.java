package com.bytedance.android.livesdk.chatroom.replay.profilecard;

import android.os.Message;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdkapi.depend.handler.WeakHandler;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends q46.b<b> implements WeakHandler.IHandler {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC1656a f109926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f109927c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.replay.profilecard.a$a, reason: collision with other inner class name */
    public interface InterfaceC1656a {
    }

    public interface b extends q46.a {
        void N2(IBaseUser r100, boolean r101);

        void hide();

        void i7(Throwable r100);
    }

    public a() {
        new WeakHandler(this);
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
        ((b) r101).i7((Exception) r102);
        return;
    L12:
        if ((r102 instanceof IBaseUser) == false) goto L14;
        ((b) r101).N2((IBaseUser) r102, false);
        return;
    L14:
        ((b) r101).i7(new Exception("unknown msg.what"));
        return;
    }
}
