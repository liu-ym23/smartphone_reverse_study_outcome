package com.stepos.aiengine.algorithm.imagecaption;

import android.os.Bundle;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0010"}, d2 = {"Lcom/stepos/aiengine/algorithm/imagecaption/IImageCaption;", "", "caption", "", "token", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "image", "Landroid/os/Bundle;", HighlightArgsBundle.KEY_PROMPT, "", "callback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "cancel", "", "identity", "", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IImageCaption {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ int caption$default(IImageCaption iImageCaption, AlgorithmToken algorithmToken, Bundle bundle, String str, IBundleCallback iBundleCallback, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: caption");
            }
            if ((i & 4) != 0) {
                str = "";
            }
            return iImageCaption.caption(algorithmToken, bundle, str, iBundleCallback);
        }
    }

    boolean cancel(long identity);

    int caption(AlgorithmToken token, Bundle image, String prompt, IBundleCallback callback);
}
