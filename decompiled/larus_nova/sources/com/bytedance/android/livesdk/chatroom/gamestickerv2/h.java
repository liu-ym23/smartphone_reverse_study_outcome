package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerUpdateListener;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GameStickerTask f106348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Set f106349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Set f106350c;

    public h(GameStickerTask r100, Set r101, Set r102) {
        this.f106348a = r100;
        this.f106349b = r101;
        this.f106350c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Iterator r100 = ((ArrayList) this.f106348a.f106279h).iterator();     // Catch: Throwable -> L7
    L4:
        if (r100.hasNext() == false) goto L16;
        ((IGameStickerUpdateListener) r100.next()).onSeiSceneUpdate(this.f106349b, this.f106350c);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
