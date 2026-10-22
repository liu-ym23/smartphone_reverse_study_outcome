package com.obric.agent.intents.audio;

import android.media.session.MediaController;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayPreviousIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.b;
import d.c.d;
import d.h.b.o;

/* JADX INFO: compiled from: PlayPreviousIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlayPreviousIntent extends BaseAudioControlPlayPreviousIntent {
    public static /* synthetic */ void lambda$qoLqHedln3EE05aGKquaU5l7ZmM(MediaController r0) {
        doAction$lambda$1$lambda$0(r0);
    }

    public PlayPreviousIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPlayPreviousIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPlayPreviousIntent
    public Object doAction(Empty r15, DispatchContext r16, d<? super IntentResult<Empty>> r17) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r17, d.class, "com.obric.aiagent.plugin");
        final MediaController r1 = a.f14676a.f();
        if (r1 == null) goto L10;
        r1.getTransportControls().skipToPrevious();
        if (o.a(r1.getPackageName(), "app.podcast.cosmos") == false) goto L7;
        b.a(new Handler(Looper.getMainLooper()).postDelayed(new $$Lambda$PlayPreviousIntent$qoLqHedln3EE05aGKquaU5l7ZmM(r1), 5500));
    L9:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L7:
        r1.getTransportControls().play();
        goto L9
    L10:
        PlayPreviousIntent r2 = (PlayPreviousIntent) ZeusTransformUtils.preCheckCast(this, PlayPreviousIntent.class, "com.obric.aiagent.plugin");
        return new IntentResult(ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    }

    private static final void doAction$lambda$1$lambda$0(MediaController r0) {
        r0.getTransportControls().play();
    }
}
