package cn.com.chinatelecom.account.api;

import android.content.Context;
import com.bytedance.librarian.a;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class Helper {
    static {
        INVOKESTATIC_cn_com_chinatelecom_account_api_Helper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("CtaApiLib");
    }

    public Helper() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public static native String cepahsul(boolean r100);

    public static native String dnepah(Context r100, String r101, String r102, String r103, long r104, boolean r105, boolean r106, String r107);

    public static native byte[] dnepmret(byte[] r100, String r101);

    public static native byte[] dneulret(byte[] r100);

    public static native String dnprecobjs(Context r100, long r101, String r102);

    public static native String dnprecohdjs();

    public static native String eneulret(String r100);

    public static native String gscret(Context r100, String r101);

    public static native String guulam(Context r100, String r101);

    public static native String sgwret(String r100);

    public static native String testEncrypt(String r100, String r101);

    @JvmStatic
    public static void INVOKESTATIC_cn_com_chinatelecom_account_api_Helper_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }
}
