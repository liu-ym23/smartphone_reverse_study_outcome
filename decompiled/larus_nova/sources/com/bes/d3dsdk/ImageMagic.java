package com.bes.d3dsdk;

import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.image.entity.LoadParams;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes39.dex */
public class ImageMagic {
    public native void MagickImageCommande(String r100, String r101);

    public ImageMagic() throws Exception {
        a("ImageMagic");
        a("imagequant");
        a(LoadParams.ImageFormat.PNG);
        a("quantcmd");
        a("lcms2");
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r100));
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r100));
    }
}
