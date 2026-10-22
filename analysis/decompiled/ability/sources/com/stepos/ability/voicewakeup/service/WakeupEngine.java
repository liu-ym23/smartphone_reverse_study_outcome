package com.stepos.ability.voicewakeup.service;

import java.util.Set;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012Je\u0010 \u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00030\u001dH&¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010H&¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0003H&¢\u0006\u0004\b$\u0010%¨\u0006&À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/voicewakeup/service/WakeupEngine;", "", "Lkotlin/Function0;", "LC7/r;", "cb", "setOnResourcesAvailable", "(LS7/a;)V", "setOnServiceDied", "", "attachModule", "()Z", "isSupportConcurrency", "", "getMaxSoundModels", "()I", "", "", "getLoadedWordIds", "()Ljava/util/Set;", "wordId", "modelPath", "", "userIds", "coarseLevel", "userConfidence", "keyphraseText", "keyphraseId", "", "opaqueRequest", "Lkotlin/Function1;", "LF4/b;", "onRecognition", "loadAndStart", "(Ljava/lang/String;Ljava/lang/String;[IIILjava/lang/String;I[BLS7/k;)I", "restart", "(Ljava/lang/String;)I", "release", "()V", "voicewakeup_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface WakeupEngine {
    boolean attachModule();

    Set<String> getLoadedWordIds();

    int getMaxSoundModels();

    boolean isSupportConcurrency();

    int loadAndStart(String wordId, String modelPath, int[] userIds, int coarseLevel, int userConfidence, String keyphraseText, int keyphraseId, byte[] opaqueRequest, S7.k onRecognition);

    void release();

    int restart(String wordId);

    void setOnResourcesAvailable(S7.a cb);

    void setOnServiceDied(S7.a cb);
}
