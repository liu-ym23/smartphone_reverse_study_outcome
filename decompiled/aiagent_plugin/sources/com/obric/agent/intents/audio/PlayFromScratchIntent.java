package com.obric.agent.intents.audio;

import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayFromScratchIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.d;
import d.c.b.a.f;
import d.o;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: PlayFromScratchIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlayFromScratchIntent extends BaseAudioControlPlayFromScratchIntent {

    /* JADX INFO: compiled from: PlayFromScratchIntent.kt */
    @f(b = "PlayFromScratchIntent.kt", c = {18}, d = "doAction", e = "com.obric.agent.intents.audio.PlayFromScratchIntent")
    static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f14667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f14668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PlayFromScratchIntent f14669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f14670d;

        a(PlayFromScratchIntent r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f14669c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f14668b = r3;
            this.f14670d |= Integer.MIN_VALUE;
            return this.f14669c.doAction(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public PlayFromScratchIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPlayFromScratchIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d.c.d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d.c.d<? super IntentResult<Empty>> r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPlayFromScratchIntent
    public Object doAction(Empty r17, DispatchContext r18, d.c.d<? super IntentResult<Empty>> r19) {
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r19, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, a.class) == false) goto L7;
        a r3 = (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.aiagent.plugin");
        if ((r3.f14670d & Integer.MIN_VALUE) == 0) goto L7;
        r3.f14670d -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f14668b;
        Object r4 = b.a();
        int r5 = r3.f14670d;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        MediaController r0 = (MediaController) ZeusTransformUtils.preCheckCast(r3.f14667a, MediaController.class, "com.obric.aiagent.plugin");
        o.a(r2);
    L26:
        MediaController r6 = r0;
    L27:
        r6.getTransportControls().seekTo(0);
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        o.a(r2);
        r6 = com.obric.agent.intents.audio.a.f14676a.f();
        if (r6 == null) goto L29;
        PlaybackState r7 = r6.getPlaybackState();
        boolean r8 = false;
        if (r7 != null) goto L19;
    L21:
        if (r8 == true) goto L27;
        r6.getTransportControls().play();
        r3.f14667a = r6;
        r3.f14670d = 1;
        if (ax.a(100, r3) != r4) goto L25;
        return r4;
    L25:
        r0 = r6;
        goto L26
    L19:
        if (r7.isActive() != true) goto L21;
        r8 = true;
        goto L21
    L29:
        PlayFromScratchIntent r9 = (PlayFromScratchIntent) ZeusTransformUtils.preCheckCast(this, PlayFromScratchIntent.class, "com.obric.aiagent.plugin");
        return new IntentResult(ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L7:
        r3 = new a(this, r1);
        goto L8
    }
}
