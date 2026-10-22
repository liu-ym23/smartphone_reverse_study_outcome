package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.api.LinkApis;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.chatroom.model.SyncStreamInfo;
import io.reactivex.disposables.Disposable;
import java.util.LinkedList;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class IMStreamInfoSender implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<SyncStreamInfo> f77423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f77424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f77425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f77426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkApis f77427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Long f77428f;

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.q
    public final void onClose() {
        if (((Disposable) this.f77426d.getValue()).isDisposed() == true) goto L6;
        ((Disposable) this.f77426d.getValue()).dispose();
        return;
    }

    public IMStreamInfoSender() {
        this.f77423a = new LinkedList();
        this.f77424b = 25600;
        this.f77425c = ((IMiddleWareHostContext) jc1.k.n(IMiddleWareHostContext.class)).liveId();
        this.f77426d = LazyKt.lazy(new IMStreamInfoSender$internalTask$2(this));
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.utils.q
    public final void a(String r100, JSONObject r101) {
        if (((Disposable) this.f77426d.getValue()).isDisposed() == true) goto L14;
        if (r101 == null) goto L14;
        LinkedList<SyncStreamInfo> r102 = this.f77423a;
        monitor-enter(r102);
        this.f77423a.add(new SyncStreamInfo(com.bytedance.android.livesdk.utils.ntp.e.a(), r100, r101.toString()));     // Catch: Throwable -> L11
        monitor-exit(r102);
        return;
    L11:
        th = move-exception;
        throw th;
    L14:
        ALogger.e("IMStreamInfoPipe", "sendStreamInfo but internalTask is disposed");
    }
}
