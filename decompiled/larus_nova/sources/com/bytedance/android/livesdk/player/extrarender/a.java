package com.bytedance.android.livesdk.player.extrarender;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.player.event.PlayerNextLiveData;
import com.bytedance.android.livesdkapi.model.PlayerExtraRenderSeiInfo;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController;
import kotlin.Unit;

/* JADX INFO: loaded from: classes11.dex */
public final class a implements ILivePlayerExtraRenderController.EventHub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<Integer> f155256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f155257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f155258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<Boolean> f155259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PlayerNextLiveData<PlayerExtraRenderSeiInfo> f155260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<Integer> f155261f;

    public a() {
        MutableLiveData<Integer> r100 = new MutableLiveData();
        r100.setValue(0);
        Unit r101 = Unit.INSTANCE;
        this.f155256a = r100;
        MutableLiveData<Boolean> r102 = new MutableLiveData();
        Boolean r103 = Boolean.FALSE;
        r102.setValue(r103);
        this.f155257b = r102;
        MutableLiveData<Boolean> r104 = new MutableLiveData();
        r104.setValue(r103);
        this.f155258c = r104;
        MutableLiveData<Boolean> r105 = new MutableLiveData();
        r105.setValue(r103);
        this.f155259d = r105;
        PlayerNextLiveData<PlayerExtraRenderSeiInfo> r106 = new PlayerNextLiveData();
        r106.setValue(new PlayerExtraRenderSeiInfo());
        this.f155260e = r106;
        MutableLiveData<Integer> r107 = new MutableLiveData();
        r107.setValue(0);
        this.f155261f = r107;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController.EventHub
    public final MutableLiveData<Boolean> getExtraRenderIsShow() {
        return this.f155259d;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController.EventHub
    public final MutableLiveData<Integer> getExtraViewBottom() {
        return this.f155261f;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController.EventHub
    public final MutableLiveData<Integer> getExtraViewWidth() {
        return this.f155256a;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController.EventHub
    public final MutableLiveData<Boolean> getMainFrameChanged() {
        return this.f155257b;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController.EventHub
    public final MutableLiveData getOnRenderSeiInfoUpdate() {
        return this.f155260e;
    }

    @Override // com.bytedance.android.livesdkapi.roomplayer.ILivePlayerExtraRenderController.EventHub
    public final MutableLiveData<Boolean> getRotateToPortrait() {
        return this.f155258c;
    }
}
