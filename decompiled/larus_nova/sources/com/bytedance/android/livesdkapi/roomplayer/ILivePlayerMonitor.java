package com.bytedance.android.livesdkapi.roomplayer;

import android.view.View;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&J,\u0010\b\u001a\u00020\u00032\"\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\nj\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u000bH&J$\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H&J\b\u0010\r\u001a\u00020\u0003H&J&\u0010\u000e\u001a\u00020\u00032\u001c\u0010\u000f\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u00110\u0010j\u0002`\u0013H&J&\u0010\u0014\u001a\u00020\u00032\u001c\u0010\u000f\u001a\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u00110\u0010j\u0002`\u0013H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerMonitor;", "", "assemblePlayerParams", "", "eventName", "", "params", "", "assembleStabilityParams", "mapOut", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "assembleVolumeParams", "checkAsyncStreamException", "registerMuteAudioCheck", "handler", "Lkotlin/Function0;", "Lkotlin/Pair;", "", "Lcom/bytedance/android/livesdkapi/roomplayer/OnAbnormalMuteAudioHandler;", "unRegisterMuteAudioCheck", "updateContextPage", "view", "Landroid/view/View;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerMonitor {
    void assemblePlayerParams(String r100, Map<String, String> r101);

    void assembleStabilityParams(HashMap<String, String> r100);

    void assembleVolumeParams(String r100, Map<String, String> r101);

    void checkAsyncStreamException();

    void registerMuteAudioCheck(Function0<Pair<Integer, String>> r100);

    void unRegisterMuteAudioCheck(Function0<Pair<Integer, String>> r100);

    void updateContextPage(View r100);
}
