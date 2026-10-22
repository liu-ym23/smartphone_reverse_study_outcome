package com.bytedance.android.livesdk.player;

import com.bytedance.android.livesdkapi.roomplayer.AudioProcessorWrapper;
import com.ss.ttm.player.AudioProcessor;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h extends AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AudioProcessorWrapper f155400a;

    @Override // com.ss.ttm.player.AudioProcessor
    public final void audioClose() {
        this.f155400a.audioClose();
    }

    public h(AudioProcessorWrapper r100) {
        Intrinsics.checkNotNullParameter(r100, "audioProcessorWrapper");
        this.f155400a = r100;
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public final void audioRelease(int r100) {
        this.f155400a.audioRelease(r100);
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public final void audioProcess(ByteBuffer[] r100, int r101, long r102) {
        this.f155400a.audioProcess(r100, r101, r102);
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public final void audioOpen(int r100, int r101, int r102, int r103) {
        this.f155400a.audioOpen(r100, r101, r102, r103);
    }
}
