package com.bytedance.android.livesdk.player.extrarender.gamev2;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerGameExtraRenderController;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ILivePlayerGameExtraRenderController.EventHub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Boolean> f155323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Integer> f155324b;

    public a() {
        MutableLiveData<Boolean> r100 = new MutableLiveData();
        r100.setValue(Boolean.FALSE);
        Unit r101 = Unit.INSTANCE;
        this.f155323a = r100;
        MutableLiveData<Integer> r102 = new MutableLiveData();
        r102.setValue(0);
        this.f155324b = r102;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerGameExtraRenderController.EventHub
    public final MutableLiveData<Boolean> getExtraRenderIsShow() {
        return this.f155323a;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerGameExtraRenderController.EventHub
    public final MutableLiveData<Integer> getExtraViewBottom() {
        return this.f155324b;
    }
}
