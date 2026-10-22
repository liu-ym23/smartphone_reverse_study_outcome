package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge;

import android.content.Context;
import com.bytedance.android.live.ktv.common.midi.k;

/* JADX INFO: loaded from: classes10.dex */
public interface a {
    void addKtvChallengeStatusChangedListener(b r100);

    int challengeTargetValue();

    void checkAutoOpenChallenge();

    int currentScoreValue();

    me2.a getChallengeConfig();

    boolean isKtvChallengeOpen();

    boolean needHideMidi();

    void onComponentClose();

    void onMidiScoreChanged(k r100);

    void openChallenge(String r100, Context r101);

    void openGiftDialog();

    void removeKtvChallengeStatusChangedListener(b r100);
}
