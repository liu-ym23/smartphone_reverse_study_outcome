package androidx.camera.camera2.internal.compat.params;

import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
class OutputConfigurationCompatBaseImpl implements OutputConfigurationCompat.OutputConfigurationCompatImpl {
    static final String TAG = "OutputConfigCompat";
    final Object mObject;

    public static final class OutputConfigurationParamsApi21 {
        private static final String DETECT_SURFACE_TYPE_METHOD = "detectSurfaceType";
        private static final String GET_GENERATION_ID_METHOD = "getGenerationId";
        private static final String GET_SURFACE_SIZE_METHOD = "getSurfaceSize";
        private static final String LEGACY_CAMERA_DEVICE_CLASS = "android.hardware.camera2.legacy.LegacyCameraDevice";
        static final int MAX_SURFACES_COUNT = 1;
        final int mConfiguredFormat;
        final int mConfiguredGenerationId;
        final Size mConfiguredSize;
        long mDynamicRangeProfile;
        boolean mIsShared;
        String mPhysicalCameraId;
        final List<Surface> mSurfaces;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        public int hashCode() {
            int r100 = this.mSurfaces.hashCode() ^ 31;
            int r101 = (r100 << 5) - r100;
            int r102 = this.mConfiguredGenerationId ^ r101;
            int r103 = (r102 << 5) - r102;
            int r104 = this.mConfiguredSize.hashCode() ^ r103;
            int r105 = (r104 << 5) - r104;
            int r106 = this.mConfiguredFormat ^ r105;
            int r107 = (r106 << 5) - r106;
            int r108 = (this.mIsShared ? 1 : 0) ^ r107;
            int r109 = (r108 << 5) - r108;
            String r110 = this.mPhysicalCameraId;
            if (r110 != null) goto L5;
            int r111 = 0;
        L6:
            int r112 = r111 ^ r109;
            int r113 = (r112 << 5) - r112;
            long r114 = this.mDynamicRangeProfile;
            return ((int) (r114 ^ (r114 >>> 32))) ^ r113;
        L5:
            r111 = r110.hashCode();
            goto L6
        }

        public OutputConfigurationParamsApi21(Surface r100) {
            this.mIsShared = false;
            this.mDynamicRangeProfile = 1;
            Preconditions.checkNotNull(r100, "Surface must not be null");
            this.mSurfaces = Collections.singletonList(r100);
            this.mConfiguredSize = getSurfaceSize(r100);
            this.mConfiguredFormat = getSurfaceFormat(r100);
            this.mConfiguredGenerationId = getSurfaceGenerationId(r100);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_camera_camera2_internal_compat_params_OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        private static int getSurfaceFormat(Surface r100) {
            Method r101 = INVOKESTATIC_androidx_camera_camera2_internal_compat_params_OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(LEGACY_CAMERA_DEVICE_CLASS).getDeclaredMethod(DETECT_SURFACE_TYPE_METHOD, new Class[]{Surface.class});     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 Throwable -> L14
            if (Build.VERSION.SDK_INT >= 22) goto L6;
            r101.setAccessible(true);     // Catch: InvocationTargetException -> L8 IllegalAccessException -> L10 NoSuchMethodException -> L12 Throwable -> L14
        L6:
            return ((Integer) r101.invoke(null, new Object[]{r100})).intValue();
        L14:
            e = move-exception;
            Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface format.", e);
            return 0;
        }

        private static int getSurfaceGenerationId(Surface r100) {
            return ((Integer) Surface.class.getDeclaredMethod(GET_GENERATION_ID_METHOD, new Class[0]).invoke(r100, new Object[0])).intValue();
        L6:
            e = move-exception;
            Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface generation id.", e);
            return -1;
        }

        private static Size getSurfaceSize(Surface r100) {
            Method r101 = INVOKESTATIC_androidx_camera_camera2_internal_compat_params_OutputConfigurationCompatBaseImpl$OutputConfigurationParamsApi21_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(LEGACY_CAMERA_DEVICE_CLASS).getDeclaredMethod(GET_SURFACE_SIZE_METHOD, new Class[]{Surface.class});     // Catch: Throwable -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
            r101.setAccessible(true);     // Catch: Throwable -> L5 IllegalAccessException -> L7 NoSuchMethodException -> L9 ClassNotFoundException -> L11
            return (Size) r101.invoke(null, new Object[]{r100});
        L5:
            e = move-exception;
            Logger.e(OutputConfigurationCompatBaseImpl.TAG, "Unable to retrieve surface size.", e);
            return null;
        }

        public boolean equals(Object r100) {
            if ((r100 instanceof OutputConfigurationParamsApi21) == true) goto L5;
            return false;
        L5:
            OutputConfigurationParamsApi21 r101 = (OutputConfigurationParamsApi21) r100;
            if (this.mConfiguredSize.equals(r101.mConfiguredSize) == true) goto L8;
        L26:
            return false;
        L8:
            if (this.mConfiguredFormat != r101.mConfiguredFormat) goto L26;
            if (this.mConfiguredGenerationId != r101.mConfiguredGenerationId) goto L26;
            if (this.mIsShared != r101.mIsShared) goto L26;
            if (this.mDynamicRangeProfile != r101.mDynamicRangeProfile) goto L26;
            if (Objects.equals(this.mPhysicalCameraId, r101.mPhysicalCameraId) == false) goto L26;
            int r102 = Math.min(this.mSurfaces.size(), r101.mSurfaces.size());
            int r103 = 0;
        L19:
            if (r103 >= r102) goto L24;
            if (ListProtector.get(this.mSurfaces, r103) != ListProtector.get(r101.mSurfaces, r103)) goto L22;
            r103 = r103 + 1;
            goto L19
        L22:
            return false;
        L24:
            return true;
        }
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMaxSharedSurfaceCount() {
        return 1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getMirrorMode() {
        return 0;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Object getOutputConfiguration() {
        return null;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getStreamUseCase() {
        return -1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public int getSurfaceGroupId() {
        return -1;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setMirrorMode(int r100) {
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setStreamUseCase(long r100) {
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void enableSurfaceSharing() {
        ((OutputConfigurationParamsApi21) this.mObject).mIsShared = true;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public long getDynamicRangeProfile() {
        return ((OutputConfigurationParamsApi21) this.mObject).mDynamicRangeProfile;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public String getPhysicalCameraId() {
        return ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public Surface getSurface() {
        List<Surface> r100 = ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
        if (r100.size() != 0) goto L7;
        return null;
    L7:
        return (Surface) ListProtector.get(r100, 0);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public List<Surface> getSurfaces() {
        return ((OutputConfigurationParamsApi21) this.mObject).mSurfaces;
    }

    public int hashCode() {
        return this.mObject.hashCode();
    }

    public boolean isSurfaceSharingEnabled() {
        return ((OutputConfigurationParamsApi21) this.mObject).mIsShared;
    }

    public OutputConfigurationCompatBaseImpl(Surface r100) {
        this.mObject = new OutputConfigurationParamsApi21(r100);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void addSurface(Surface r100) {
        Preconditions.checkNotNull(r100, "Surface must not be null");
        if (getSurface() == r100) goto L11;
        if (isSurfaceSharingEnabled() == true) goto L9;
        throw new IllegalStateException("Cannot have 2 surfaces for a non-sharing configuration");
    L9:
        throw new IllegalArgumentException("Exceeds maximum number of surfaces");
    L11:
        throw new IllegalStateException("Surface is already added!");
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof OutputConfigurationCompatBaseImpl) == true) goto L7;
        return false;
    L7:
        return Objects.equals(this.mObject, ((OutputConfigurationCompatBaseImpl) r100).mObject);
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void removeSurface(Surface r100) {
        if (getSurface() != r100) goto L7;
        throw new IllegalArgumentException("Cannot remove surface associated with this output configuration");
    L7:
        throw new IllegalArgumentException("Surface is not part of this output configuration");
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setDynamicRangeProfile(long r100) {
        ((OutputConfigurationParamsApi21) this.mObject).mDynamicRangeProfile = r100;
    }

    @Override // androidx.camera.camera2.internal.compat.params.OutputConfigurationCompat.OutputConfigurationCompatImpl
    public void setPhysicalCameraId(String r100) {
        ((OutputConfigurationParamsApi21) this.mObject).mPhysicalCameraId = r100;
    }

    public OutputConfigurationCompatBaseImpl(Object r100) {
        this.mObject = r100;
    }
}
