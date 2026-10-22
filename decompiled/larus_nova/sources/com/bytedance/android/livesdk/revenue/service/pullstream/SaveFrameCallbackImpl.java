package com.bytedance.android.livesdk.revenue.service.pullstream;

import com.ss.texturerender.VideoSurface;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or2.g;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\"\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/revenue/service/pullstream/SaveFrameCallbackImpl;", "Lcom/ss/texturerender/VideoSurface$SaveFrameCallback;", "Ljava/nio/ByteBuffer;", "buffer", "", "width", "height", "onFrame", "Lor2/g;", "real", "Lor2/g;", "<init>", "(Lor2/g;)V", "revenue-host-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SaveFrameCallbackImpl implements VideoSurface.SaveFrameCallback {
    private final g real;

    public SaveFrameCallbackImpl(g r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
    }

    @Override // com.ss.texturerender.VideoSurface.SaveFrameCallback
    public int onFrame(ByteBuffer r100, int r101, int r102) {
        throw null;
    }
}
