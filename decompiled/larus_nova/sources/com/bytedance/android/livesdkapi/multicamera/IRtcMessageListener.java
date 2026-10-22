package com.bytedance.android.livesdkapi.multicamera;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nH\u0016¢\u0006\u0002\u0010\u000bJ5\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0010\"\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0002\u0010\u0011J1\u0010\u0012\u001a\u00020\u00032\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/multicamera/IRtcMessageListener;", "", LynxVideoManagerLite.EVENT_ON_ERROR, "", "code1", "", "code2", "", "msg", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ILjava/lang/Long;Ljava/lang/Exception;)V", "onInfo", "type", "errorCode", "params", "", "(IJ[Ljava/lang/Object;)V", "onVolumeChange", "userId", "", "talkState", "", ITTVideoEngineEventSource.KEY_VOLUME, "", "([Ljava/lang/String;[Z[I)V", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRtcMessageListener {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void onError(IRtcMessageListener r100, int r101, Long r102, Exception r103) {
        }

        public static void onInfo(IRtcMessageListener r100, int r101, long r102, Object... r103) {
            Intrinsics.checkNotNullParameter(r103, "params");
        }

        public static void onVolumeChange(IRtcMessageListener r100, String[] r101, boolean[] r102, int[] r103) {
        }
    }

    void onError(int r100, Long r101, Exception r102);

    void onInfo(int r100, long r101, Object... r102);

    void onVolumeChange(String[] r100, boolean[] r101, int[] r102);
}
