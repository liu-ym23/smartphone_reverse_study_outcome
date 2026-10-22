package a97;

import com.bytedance.reparo.core.i;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class h extends b<d97.e> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final y87.a f2297b;

    public h(i r100) {
        super(r100);
        this.f2297b = new y87.a();
    }

    @JvmStatic
    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
