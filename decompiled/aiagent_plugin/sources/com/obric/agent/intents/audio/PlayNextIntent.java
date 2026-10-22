package com.obric.agent.intents.audio;

import android.media.session.MediaController;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayNextIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.b;
import d.c.d;
import d.h.b.o;

/* JADX INFO: compiled from: PlayNextIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlayNextIntent extends BaseAudioControlPlayNextIntent {
    /* JADX INFO: renamed from: lambda$yn9Mddj3Kcb1-osfxL1qwFzW_MM, reason: not valid java name */
    public static /* synthetic */ void m83lambda$yn9Mddj3Kcb1osfxL1qwFzW_MM(MediaController r0) {
        doAction$lambda$1$lambda$0(r0);
    }

    public PlayNextIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPlayNextIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPlayNextIntent
    public Object doAction(Empty r15, DispatchContext r16, d<? super IntentResult<Empty>> r17) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r17, d.class, "com.obric.aiagent.plugin");
        final MediaController r1 = a.f14676a.f();
        if (r1 == null) goto L10;
        r1.getTransportControls().skipToNext();
        if (o.a(r1.getPackageName(), "app.podcast.cosmos") == false) goto L7;
        b.a(new Handler(Looper.getMainLooper()).postDelayed(new $$Lambda$PlayNextIntent$yn9Mddj3Kcb1osfxL1qwFzW_MM(r1), 5500));
    L9:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L7:
        r1.getTransportControls().play();
        goto L9
    L10:
        PlayNextIntent r2 = (PlayNextIntent) ZeusTransformUtils.preCheckCast(this, PlayNextIntent.class, "com.obric.aiagent.plugin");
        return new IntentResult(ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    }

    private static final void doAction$lambda$1$lambda$0(MediaController r0) {
        r0.getTransportControls().play();
    }
}
