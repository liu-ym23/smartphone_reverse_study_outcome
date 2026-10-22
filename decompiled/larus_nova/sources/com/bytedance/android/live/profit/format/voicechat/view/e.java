package com.bytedance.android.live.profit.format.voicechat.view;

import com.bytedance.android.live.profit.format.voicechat.model.VoiceChatState;

/* JADX INFO: loaded from: classes47.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f87787a = null;

    static {
        int[] r100 = new int[VoiceChatState.values().length];
        f87787a = r100;
        r100[VoiceChatState.CONNECTING.ordinal()] = 1;
        r100[VoiceChatState.TIME_UP.ordinal()] = 2;
        r100[VoiceChatState.SPEAKING.ordinal()] = 3;
        r100[VoiceChatState.THINKING.ordinal()] = 4;
        r100[VoiceChatState.LISTENING.ordinal()] = 5;
        r100[VoiceChatState.WAITING.ordinal()] = 6;
    }
}
