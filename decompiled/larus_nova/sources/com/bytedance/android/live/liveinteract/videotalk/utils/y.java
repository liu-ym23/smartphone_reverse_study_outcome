package com.bytedance.android.live.liveinteract.videotalk.utils;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes46.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f79896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef f79897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ILinkPlayerInfoBridge f79898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ti6.f f79899d;

    public y(z r100, Ref.ObjectRef r101, ILinkPlayerInfoBridge r102, ti6.f r103) {
        this.f79896a = r100;
        this.f79897b = r101;
        this.f79898c = r102;
        this.f79899d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.e("VideoTalkAudioMixerV2", (Throwable) r100);
        z r101 = this.f79896a;
        r101.f79903d.put((String) this.f79897b.element, r101.f79905f);
        z r102 = this.f79896a;
        r102.c(this.f79898c, this.f79899d, (String) this.f79897b.element, r102.f79905f, true);
    }
}
