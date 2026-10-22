package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveKtvFirstLevelTabConfig;", "", "()V", "liveKtvFirstLevelTabConfig", "", "Lcom/bytedance/android/livesdkapi/model/LiveKtvFirstLevelTabConfigData;", "getLiveKtvFirstLevelTabConfig", "", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveKtvFirstLevelTabConfig {

    @SerializedName("live_ktv_first_level_tab_config")
    private final List<LiveKtvFirstLevelTabConfigData> liveKtvFirstLevelTabConfig;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveKtvFirstLevelTabConfig() {
        ArrayList r100 = new ArrayList();
        this.liveKtvFirstLevelTabConfig = r100;
        r100.clear();
        int r101 = 2;
        LiveKtvFirstLevelTabConfigData r102 = new LiveKtvFirstLevelTabConfigData(ModeType.KTV_MODE.getValue(), null, r101, 0 == true ? 1 : 0);
        List<LiveKtvFirstLevelTab> r103 = r102.getLiveKtvFirstLevelTabList();
        TabName r104 = TabName.ORDERED_SONG;
        String r105 = r104.getValue();
        UserType r106 = UserType.ALL;
        r103.add(new LiveKtvFirstLevelTab(r105, r106.getValue(), false));
        List<LiveKtvFirstLevelTab> r107 = r102.getLiveKtvFirstLevelTabList();
        TabName r108 = TabName.ORDER_SONG;
        r107.add(new LiveKtvFirstLevelTab(r108.getValue(), r106.getValue(), true));
        List<LiveKtvFirstLevelTab> r109 = r102.getLiveKtvFirstLevelTabList();
        TabName r110 = TabName.MY_SONG;
        r109.add(new LiveKtvFirstLevelTab(r110.getValue(), r106.getValue(), true));
        Unit r111 = Unit.INSTANCE;
        r100.add(r102);
        LiveKtvFirstLevelTabConfigData r112 = new LiveKtvFirstLevelTabConfigData(ModeType.SOLO_KTV.getValue(), 0 == true ? 1 : 0, r101, 0 == true ? 1 : 0);
        r112.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(r108.getValue(), r106.getValue(), true));
        r112.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(r110.getValue(), r106.getValue(), true));
        r100.add(r112);
        LiveKtvFirstLevelTabConfigData r113 = new LiveKtvFirstLevelTabConfigData(ModeType.KTV_COMPONENT.getValue(), 0 == true ? 1 : 0, r101, 0 == true ? 1 : 0);
        r113.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(r104.getValue(), r106.getValue(), false));
        r113.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(TabName.WANT_LISTEN.getValue(), UserType.AUDIENCE.getValue(), false));
        r113.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(r108.getValue(), r106.getValue(), true));
        r113.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(TabName.AUDIENCE_SING.getValue(), UserType.ANCHOR.getValue(), false));
        r113.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(r110.getValue(), r106.getValue(), true));
        r100.add(r113);
        LiveKtvFirstLevelTabConfigData r114 = new LiveKtvFirstLevelTabConfigData(ModeType.VIDEO_CHORUS.getValue(), 0 == true ? 1 : 0, r101, 0 == true ? 1 : 0);
        r114.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(r104.getValue(), r106.getValue(), false));
        r114.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(r108.getValue(), r106.getValue(), true));
        r114.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(r110.getValue(), r106.getValue(), true));
        r100.add(r114);
        LiveKtvFirstLevelTabConfigData r115 = new LiveKtvFirstLevelTabConfigData(ModeType.MUSIC_EFFECT.getValue(), 0 == true ? 1 : 0, r101, 0 == true ? 1 : 0);
        r115.getLiveKtvFirstLevelTabList().add(new LiveKtvFirstLevelTab(TabName.EFFECT_MUSIC.getValue(), r106.getValue(), false));
        r100.add(r115);
    }

    public final List<LiveKtvFirstLevelTabConfigData> getLiveKtvFirstLevelTabConfig() {
        return this.liveKtvFirstLevelTabConfig;
    }
}
