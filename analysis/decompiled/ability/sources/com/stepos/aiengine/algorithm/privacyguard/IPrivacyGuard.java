package com.stepos.aiengine.algorithm.privacyguard;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&JR\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J6\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0007H&¨\u0006\u0018"}, d2 = {"Lcom/stepos/aiengine/algorithm/privacyguard/IPrivacyGuard;", "", "preload", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "args", "Landroid/os/Bundle;", "analyze", "", "token", "imageFds", "", "Landroid/os/ParcelFileDescriptor;", "imagePaths", "", "imageBitmaps", "Landroid/graphics/Bitmap;", HighlightArgsBundle.KEY_PROMPT, "callback", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "cancel", "", "identity", "", "getMaxTokenLimit", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IPrivacyGuard {

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int analyze(IPrivacyGuard iPrivacyGuard, AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, String prompt, Bundle args, IBundleCallback callback) {
            k.f(token, "token");
            k.f(imageFds, "imageFds");
            k.f(prompt, "prompt");
            k.f(args, "args");
            k.f(callback, "callback");
            EmptyList emptyList = EmptyList.f4893a;
            return iPrivacyGuard.analyze(token, imageFds, emptyList, emptyList, prompt, args, callback);
        }
    }

    int analyze(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, String prompt, Bundle args, IBundleCallback callback);

    int analyze(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String prompt, Bundle args, IBundleCallback callback);

    boolean cancel(long identity);

    int getMaxTokenLimit();

    AlgorithmToken preload(Bundle args);
}
