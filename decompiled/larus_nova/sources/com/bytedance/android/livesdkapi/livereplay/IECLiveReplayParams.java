package com.bytedance.android.livesdkapi.livereplay;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\u0006H&J@\u0010\u000f\u001a\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0006H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/livereplay/IECLiveReplayParams;", "", "addReplayProgressListener", "", "listener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "progress", "", "isFromUser", "getEcomLiveParams", "Lorg/json/JSONObject;", "getReplayProgress", "removeReplayProgressListener", "reportParams", "", "", "seekReplayProgress", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECLiveReplayParams {
    void addReplayProgressListener(Function2<? super Long, ? super Boolean, Unit> r100);

    JSONObject getEcomLiveParams();

    long getReplayProgress();

    void removeReplayProgressListener(Function2<? super Long, ? super Boolean, Unit> r100);

    Map<String, String> reportParams();

    void seekReplayProgress(long r100);
}
