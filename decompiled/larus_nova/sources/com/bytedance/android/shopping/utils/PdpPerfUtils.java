package com.bytedance.android.shopping.utils;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0087 ¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/utils/PdpPerfUtils;", "", "()V", "stackBlurBitmap", "", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "radius", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PdpPerfUtils {
    public static final PdpPerfUtils INSTANCE = null;

    private PdpPerfUtils() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public final native void stackBlurBitmap(Bitmap r100, int r101);

    static {
        INSTANCE = new PdpPerfUtils();
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        INVOKESTATIC_com_bytedance_android_shopping_utils_PdpPerfUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("ec_pdp_perf");     // Catch: Throwable -> L5
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_android_shopping_utils_PdpPerfUtils_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
