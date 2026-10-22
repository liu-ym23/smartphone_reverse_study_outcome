package androidx.camera.core.impl.utils;

import android.view.Surface;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public class SurfaceUtil {
    public static final String JNI_LIB_NAME = "surface_util_jni";
    private static final String TAG = "SurfaceUtil";

    public static class SurfaceInfo {
        public int format;
        public int height;
        public int width;

        public SurfaceInfo() {
            this.format = 0;
            this.width = 0;
            this.height = 0;
        }
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native int[] nativeGetSurfaceInfo(Surface r100);

    static {
        INVOKESTATIC_androidx_camera_core_impl_utils_SurfaceUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(JNI_LIB_NAME);
    }

    private SurfaceUtil() {
    }

    @JvmStatic
    public static void INVOKESTATIC_androidx_camera_core_impl_utils_SurfaceUtil_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static SurfaceInfo getSurfaceInfo(Surface r100) {
        int[] r101 = nativeGetSurfaceInfo(r100);
        SurfaceInfo r102 = new SurfaceInfo();
        r102.format = r101[0];
        r102.width = r101[1];
        r102.height = r101[2];
        return r102;
    }
}
