package com.bytedance.android.livesdk.chatroom.methodchannel.ablity;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f106844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sy.a f106845b;

    public f(Ref.ObjectRef r100, sy.a r101) {
        this.f106844a = r100;
        this.f106845b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        ALogger.d("CheckLiveRoomMethod", "timeout");
        Disposable r102 = (Disposable) this.f106844a.element;
        if (r102 == null) goto L5;
        r102.dispose();
    L5:
        this.f106845b.invoke(Boolean.TRUE);
    }
}
