package com.bytedance.android.livesdk.player;

/* JADX INFO: loaded from: classes11.dex */
public final class i implements com.ss.videoarch.liveplayer.d {
    public i() {
    }

    @Override // com.ss.videoarch.liveplayer.d
    public final void onNotReachHere() {
        com.bytedance.crash.d.f("LOG_TYPE_PUBLISH_FUSED_TEST", new RuntimeException("PUBLISH_FUSED_TEST_EXCEPTION"), "PUBLISH_FUSED_TEST_EXCEPTION");
    }
}
