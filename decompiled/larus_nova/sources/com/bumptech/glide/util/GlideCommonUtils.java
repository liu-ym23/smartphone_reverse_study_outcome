package com.bumptech.glide.util;

import com.bumptech.glide.IGlideDependency;
import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.CipherManager;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR!\u0010\u000e\u001a\u00020\u000f8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bumptech/glide/util/GlideCommonUtils;", "", "<init>", "()V", "TAG", "", "KEY_USE_IMAGE_LOAD_IMPROVE", "dependency", "Lcom/bumptech/glide/IGlideDependency;", "getDependency$annotations", "getDependency", "()Lcom/bumptech/glide/IGlideDependency;", "setDependency", "(Lcom/bumptech/glide/IGlideDependency;)V", "useImageLoadImprove", "", "getUseImageLoadImprove$annotations", "getUseImageLoadImprove", "()Z", "useImageLoadImprove$delegate", "Lkotlin/Lazy;", "getDecryptFile", "Ljava/io/File;", "file", "lark-glide_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GlideCommonUtils {
    public static final GlideCommonUtils INSTANCE = null;
    private static final String KEY_USE_IMAGE_LOAD_IMPROVE = "use_image_load_improve";
    private static final String TAG = "GlideCommonUtils";
    private static IGlideDependency dependency;
    private static final Lazy useImageLoadImprove$delegate = null;

    private GlideCommonUtils() {
    }

    @JvmStatic
    public static /* synthetic */ void getDependency$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getUseImageLoadImprove$annotations() {
    }

    static {
        INSTANCE = new GlideCommonUtils();
        dependency = (IGlideDependency) ClaymoreServiceLoader.loadFirstOrNull(IGlideDependency.class);
        useImageLoadImprove$delegate = LazyKt.lazy(GlideCommonUtils$useImageLoadImprove$2.INSTANCE);
    }

    public static final boolean getUseImageLoadImprove() {
        return ((Boolean) useImageLoadImprove$delegate.getValue()).booleanValue();
    }

    public static final IGlideDependency getDependency() {
        return dependency;
    }

    @JvmStatic
    public static final File getDecryptFile(File r100) {
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.canRead() != true) goto L7;
    L8:
        if (r101 == true) goto L18;
        return r100;
    L18:
    L16:
        GlideLogUtil.e(TAG, "getDecryptFile failed");
    L17:
        return r100;
    L11:
        if (getUseImageLoadImprove() == false) goto L17;
        PolarisFileWrapper r102 = CipherManager.e(r100, false);     // Catch: Exception -> L16
        if (Intrinsics.areEqual(r100.getPath(), r102.getPath()) == true) goto L15;
        Log.w(TAG, "really decrypt file");     // Catch: Exception -> L16
    L15:
        return r102;
    L7:
        r101 = false;
        goto L8
    }

    public static final void setDependency(IGlideDependency r100) {
        dependency = r100;
    }
}
