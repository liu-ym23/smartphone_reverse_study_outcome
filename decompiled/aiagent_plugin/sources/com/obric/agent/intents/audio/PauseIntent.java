package com.obric.agent.intents.audio;

import android.media.session.MediaController;
import android.os.Parcelable;
import com.obric.agent.intents.music.netease.CMApiManager;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.ErrorCode;
import com.obric.capabilitykit.common.intent.BaseAudioControlPauseIntent;
import com.obric.capabilitykit.common.intent.Empty;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.d;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PauseIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PauseIntent extends BaseAudioControlPauseIntent {
    public PauseIntent() {
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPauseIntent, com.obric.capabilitykit.common.intent.IntentFunction
    public /* synthetic */ Object doAction(Parcelable r3, DispatchContext r4, d<? super IntentResult<Empty>> r5) {
        Parcelable r6 = (Parcelable) ZeusTransformUtils.wrapperContextForParams(r3, Parcelable.class, "com.obric.aiagent.plugin");
        d<? super IntentResult<Empty>> r7 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        return doAction((Empty) ZeusTransformUtils.preCheckCast(r6, Empty.class, "com.obric.aiagent.plugin"), r4, r7);
    }

    @Override // com.obric.capabilitykit.common.intent.BaseAudioControlPauseIntent
    public Object doAction(Empty r17, DispatchContext r18, d<? super IntentResult<Empty>> r19) {
        d r0 = (d) ZeusTransformUtils.wrapperContextForParams(r19, d.class, "com.obric.aiagent.plugin");
        List r1 = p.c((Collection) ZeusTransformUtils.preCheckCast(a.f14676a.b(), Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(a.f14676a.c(), Iterable.class, "com.obric.aiagent.plugin"));
        if (r1.isEmpty() == true) goto L5;
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L8:
        if (r2.hasNext() == false) goto L13;
        MediaController r3 = (MediaController) ZeusTransformUtils.preCheckCast(r2.next(), MediaController.class, "com.obric.aiagent.plugin");
        if (o.a(r3.getPackageName(), "com.netease.cloudmusic") == false) goto L12;
        r3.getTransportControls().play();
    L12:
        r3.getTransportControls().pause();
        goto L8
    L13:
        CMApiManager.INSTANCE.queryPause();
        return new IntentResult(0, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    L5:
        return new IntentResult(ErrorCode.AudioControl.NO_CONTROLLABLE_SESSION_ERROR, null, null, null, false, false, 0, null, null, null, DownloadErrorCode.ERROR_NO_CONNECTION, null);
    }
}
