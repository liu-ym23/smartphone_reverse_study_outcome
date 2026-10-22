package com.bytedance.android.livesdk.player;

import com.bytedance.android.live.base.model.message.n3;
import com.bytedance.android.live.base.model.message.o3;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveBusiness;
import com.bytedance.android.livesdkapi.roomplayer.IPaidLiveMessageListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c0 implements IPaidLiveBusiness, IPaidLiveMessageListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ILivePlayerClient f155162a;

    public c0() {
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IPaidLiveMessageListener
    public final void onPaidLiveDataMessage(n3 r100) {
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IPlayerBusiness
    public final ILivePlayerClient player() {
        return this.f155162a;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IPlayerBusiness
    public final void init(ILivePlayerClient r100) {
        Intrinsics.checkNotNullParameter(r100, "client");
        this.f155162a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IPaidLiveMessageListener, vlc.l
    public final void onMessage(tlc.d r100) {
        IPaidLiveMessageListener.DefaultImpls.onMessage(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.IPaidLiveMessageListener
    public final void onPaidLiveTypeModifyMessage(o3 r100) {
        IPaidLiveMessageListener.DefaultImpls.onPaidLiveTypeModifyMessage(this, r100);
    }
}
