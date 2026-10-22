package com.bytedance.android.live.broadcastgame.api.xplay;

import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {
    public static final String a(IByteRtcVideoFrame r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$dumpProperties");
        return "pixelFormat = " + r100.getPixelFormat() + ", width = " + r100.getWidth() + ", height = " + r100.getHeight() + ", textureId = " + r100.getTextureId() + ", timestampUs = " + r100.getTimestampUs();
    }

    public static final boolean b(IByteRtcVideoFrame r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$supportTextureMix");
        String r101 = r100.getPixelFormat();
        if (Intrinsics.areEqual(r101, IByteRtcVideoFrame.PixelFormat.TEXTURE_2D.getStringValue()) == false) goto L6;
        return true;
    L6:
        if (Intrinsics.areEqual(r101, IByteRtcVideoFrame.PixelFormat.TEXTURE_OES.getStringValue()) == true) goto L11;
        return false;
    L11:
        return true;
    }
}
