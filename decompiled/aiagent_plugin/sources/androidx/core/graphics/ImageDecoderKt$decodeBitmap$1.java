package androidx.core.graphics;

import android.graphics.ImageDecoder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;

/* JADX INFO: compiled from: ImageDecoder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ImageDecoderKt$decodeBitmap$1 implements ImageDecoder.OnHeaderDecodedListener {
    final /* synthetic */ d.h.a.q<ImageDecoder, ImageDecoder.ImageInfo, ImageDecoder.Source, x> $action;

    public ImageDecoderKt$decodeBitmap$1(d.h.a.q<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, x> r3) {
        this.$action = (d.h.a.q) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.q.class, "com.obric.aiagent.plugin");
    }

    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
    public final void onHeaderDecoded(ImageDecoder r1, ImageDecoder.ImageInfo r2, ImageDecoder.Source r3) {
        this.$action.invoke(r1, r2, r3);
    }
}
