package com.bytedance.android.livesdk.player.extrarender.multirender;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ILivePlayerMultiRenderController.EventHub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f155357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Integer> f155358b;

    public a() {
        this.f155357a = new MutableLiveData(Boolean.FALSE);
        this.f155358b = new MutableLiveData(0);
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController.EventHub
    public final MutableLiveData<Integer> getMultiRenderBottom() {
        return this.f155358b;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerMultiRenderController.EventHub
    public final MutableLiveData<Boolean> getMultiRenderIsShow() {
        return this.f155357a;
    }
}
