package com.bytedance.android.livesdkapi.depend.live.vs;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006R\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R$\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/vs/IVideoEventHub;", "", "firstFrame", "Landroidx/lifecycle/MutableLiveData;", "", "getFirstFrame", "()Landroidx/lifecycle/MutableLiveData;", "playPrepared", "getPlayPrepared", "playerMediaError", "", "getPlayerMediaError", "playerMute", "getPlayerMute", "playing", "getPlaying", "videoSizeChanged", "Lkotlin/Pair;", "", "getVideoSizeChanged", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVideoEventHub {
    MutableLiveData<Boolean> getFirstFrame();

    MutableLiveData<Boolean> getPlayPrepared();

    MutableLiveData<String> getPlayerMediaError();

    MutableLiveData<Boolean> getPlayerMute();

    MutableLiveData<Boolean> getPlaying();

    MutableLiveData<Pair<Integer, Integer>> getVideoSizeChanged();
}
