package com.stepos.aiengine.algorithm.imageextend;

import M5.b;
import Y8.t;
import android.graphics.Rect;
import android.os.Bundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH&¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/algorithm/imageextend/IImageExtend;", "", "extendImage", "Landroid/os/Bundle;", b.CREDENTIAL_TOKEN, "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", "seed", "", "extendPixels", "progressCallback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "Landroid/graphics/Rect;", "cancel", "", e.f30860s, "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IImageExtend {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Bundle extendImage(IImageExtend iImageExtend, AlgorithmToken token, Bundle image, long j10, Rect extendPixels, IBundleCallback iBundleCallback) {
            p.i(token, "token");
            p.i(image, "image");
            p.i(extendPixels, "extendPixels");
            Bundle bundle = new Bundle();
            bundle.putInt("left", extendPixels.left);
            bundle.putInt("top", extendPixels.top);
            bundle.putInt("right", extendPixels.right);
            bundle.putInt("bottom", extendPixels.bottom);
            t tVar = t.f7040a;
            return iImageExtend.extendImage(token, image, j10, bundle, iBundleCallback);
        }
    }

    boolean cancel(long identity);

    Bundle extendImage(AlgorithmToken token, Bundle image, long seed, Rect extendPixels, IBundleCallback progressCallback);

    Bundle extendImage(AlgorithmToken token, Bundle image, long seed, Bundle extendPixels, IBundleCallback progressCallback);
}
