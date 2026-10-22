package com.bytedance.android.shopping.commentv3.audio;

import android.content.Context;
import com.bytedance.android.shopping.api.video.AVScene;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b0 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f172612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AVScene f172613b;

    public b0(Context r100) {
        AVScene r101 = AVScene.CONTENT_DEFAULT;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "avScene");
        this.f172612a = r100;
        this.f172613b = r101;
    }

    @Override // com.bytedance.android.shopping.commentv3.audio.m
    public final TTVideoEngineAudioPlayer a(e r100) {
        Intrinsics.checkNotNullParameter(r100, "audioInfo");
        return new TTVideoEngineAudioPlayer(this.f172612a, this.f172613b);
    }
}
