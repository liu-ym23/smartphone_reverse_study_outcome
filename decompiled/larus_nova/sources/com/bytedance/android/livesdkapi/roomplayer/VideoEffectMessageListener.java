package com.bytedance.android.livesdkapi.roomplayer;

import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectMessageListener;", "", "onMessage", "", RemoteMessageConst.MSGID, "", "param1", "", "param2", "param3", "", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface VideoEffectMessageListener {
    void onMessage(int r100, long r101, long r102, String r103);
}
