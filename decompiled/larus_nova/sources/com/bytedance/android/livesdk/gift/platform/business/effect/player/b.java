package com.bytedance.android.livesdk.gift.platform.business.effect.player;

import com.ss.ttm.player.AudioProcessor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends AudioProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f129428a;

    @Override // com.ss.ttm.player.AudioProcessor
    public final void audioClose() {
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public final void audioOpen(int r100, int r101, int r102, int r103) {
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public final void audioRelease(int r100) {
    }

    public b() {
        this.f129428a = 1.0f;
    }

    @Override // com.ss.ttm.player.AudioProcessor
    public final void audioProcess(ByteBuffer[] r100, int r101, long r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        FloatBuffer[] r103 = new FloatBuffer[r100.length];
        int r104 = 0;
    L6:
        if (r104 >= r100.length) goto L14;
        ByteBuffer r105 = r100[r104];
        if (r105 == null) goto L13;
        r103[r104] = r105.order(ByteOrder.nativeOrder()).asFloatBuffer();
        int r106 = 0;
    L11:
        if (r106 >= r101) goto L13;
        float r107 = r103[r104].get(r106);
        r103[r104].put(r106, r107 * this.f129428a);
        r106 = r106 + 1;
    L13:
        r104 = r104 + 1;
        goto L6
    }
}
