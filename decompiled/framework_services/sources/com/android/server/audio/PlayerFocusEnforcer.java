package com.android.server.audio;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: classes.dex */
public interface PlayerFocusEnforcer {
    boolean duckPlayers(FocusRequester r1, FocusRequester r2, boolean r3);

    boolean fadeOutPlayers(FocusRequester r1, FocusRequester r2);

    void forgetUid(int r1);

    long getFadeInDelayForOffendersMillis(AudioAttributes r1);

    long getFadeOutDurationMillis(AudioAttributes r1);

    void mutePlayersForCall(int[] r1);

    void restoreVShapedPlayers(FocusRequester r1);

    boolean shouldEnforceFade();

    void unmutePlayersForCall();
}
