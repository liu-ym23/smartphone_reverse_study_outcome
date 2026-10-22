package com.bytedance.android.livesdk.chatroom.resolution.tips.rec;

import android.content.Context;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.bpea.cert.token.TokenCert;
import com.ss.texturerender.TextureRenderKeys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements d {
    public a() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.rec.d
    public final void D() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.rec.d
    public final void a(Context r100, TokenCert r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, TextureRenderKeys.KEY_IS_CERT);
    }

    @Override // com.bytedance.android.livesdk.chatroom.resolution.tips.rec.d
    public final void b(NetworkUtils.NetworkType r100) {
        Intrinsics.checkNotNullParameter(r100, "networkType");
    }
}
