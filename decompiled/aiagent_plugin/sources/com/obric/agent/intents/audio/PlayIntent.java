package com.obric.agent.intents.audio;

import android.media.session.MediaController;
import android.media.session.PlaybackState;
import android.os.Parcelable;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseAudioControlPlayIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.d;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PlayIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PlayIntent extends BaseAudioControlPlayIntent {
    public PlayIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPlayIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPlayIntent
    public Object doAction(Empty r18, DispatchContext r19, d<? super IntentResult<Empty>> r20) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r20, d.class, "com.obric.aiagent.plugin");
        if (a.f14676a.e() == null) goto L5;
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(a.f14676a.a(), Iterable.class, "com.obric.aiagent.plugin");
        boolean r3 = true;
        if (ZeusTransformUtils.instanceOf(r1, Collection.class) == true) goto L9;
    L11:
        Iterator r2 = r1.iterator();
    L13:
        if (r2.hasNext() == false) goto L10;
        PlaybackState r4 = ((MediaController) ZeusTransformUtils.preCheckCast(r2.next(), MediaController.class, "com.obric.aiagent.plugin")).getPlaybackState();
        if (r4 != null) goto L17;
    L19:
        boolean r5 = false;
    L20:
        if (r5 == false) goto L13;
    L21:
        if (r3 == true) goto L23;
        MediaController r6 = a.f14676a.e();
        if (r6 == null) goto L30;
        MediaController.TransportControls r7 = r6.getTransportControls();
        if (r7 == null) goto L30;
        r7.play();
    L30:
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L23:
        return new IntentResult(ErrorCode.AudioControl.EXISTED_PLAYING_SESSION_ERROR, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L17:
        if (r4.isActive() != true) goto L19;
        r5 = true;
    L10:
        r3 = false;
        goto L21
    L9:
        if (((Collection) ZeusTransformUtils.preCheckCast(r1, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L11;
    L5:
        return new IntentResult(ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    }
}
