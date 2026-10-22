package androidx.camera.core.impl;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import androidx.arch.core.util.Function;
import androidx.camera.core.Logger;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class QuirkSettingsLoader implements Function<Context, QuirkSettings> {
    public static final String KEY_DEFAULT_QUIRK_ENABLED = "androidx.camera.core.quirks.DEFAULT_QUIRK_ENABLED";
    public static final String KEY_QUIRK_FORCE_DISABLED = "androidx.camera.core.quirks.FORCE_DISABLED";
    public static final String KEY_QUIRK_FORCE_ENABLED = "androidx.camera.core.quirks.FORCE_ENABLED";
    private static final String TAG = "QuirkSettingsLoader";

    public static class MetadataHolderService extends Service {
        private MetadataHolderService() {
        }

        @Override // android.app.Service
        public IBinder onBind(Intent r100) {
            throw new UnsupportedOperationException();
        }
    }

    public QuirkSettingsLoader() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_camera_core_impl_QuirkSettingsLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
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

    private static Class<? extends Quirk> resolveQuirkName(String r100) {
        Class<? extends Quirk> r101 = INVOKESTATIC_androidx_camera_core_impl_QuirkSettingsLoader_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);     // Catch: ClassNotFoundException -> L8
        if (Quirk.class.isAssignableFrom(r101) == false) goto L6;
        return r101;
    L6:
        Logger.w(TAG, r100 + " does not implement the Quirk interface.");     // Catch: ClassNotFoundException -> L8
        return null;
    L8:
        e = move-exception;
        Logger.w(TAG, "Class not found: " + r100, e);
        return null;
    }

    private static Set<Class<? extends Quirk>> resolveQuirkNames(String[] r100) {
        HashSet r101 = new HashSet();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        Class<? extends Quirk> r104 = resolveQuirkName(r100[r103]);
        if (r104 == null) goto L7;
        r101.add(r104);
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r101;
    }

    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public QuirkSettings apply2(Context r100) {
        PackageManager r101 = r100.getPackageManager();
        Bundle r102 = r101.getServiceInfo(new ComponentName(r100, MetadataHolderService.class), 640).metaData;     // Catch: PackageManager.NameNotFoundException -> L9
        if (r102 != null) goto L8;
        Logger.w(TAG, "No metadata in MetadataHolderService.");     // Catch: PackageManager.NameNotFoundException -> L9
        return null;
    L8:
        return buildQuirkSettings(r100, r102);
    L9:
        Logger.d(TAG, "QuirkSettings$MetadataHolderService is not found.");
        return null;
    }

    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ QuirkSettings apply(Context r100) {
        return apply2(r100);
    }

    private static QuirkSettings buildQuirkSettings(Context r100, Bundle r101) {
        boolean r102 = r101.getBoolean(KEY_DEFAULT_QUIRK_ENABLED, true);
        String[] r103 = loadQuirks(r100, r101, KEY_QUIRK_FORCE_ENABLED);
        String[] r104 = loadQuirks(r100, r101, KEY_QUIRK_FORCE_DISABLED);
        Logger.d(TAG, "Loaded quirk settings from metadata:");
        Logger.d(TAG, "  KEY_DEFAULT_QUIRK_ENABLED = " + r102);
        Logger.d(TAG, "  KEY_QUIRK_FORCE_ENABLED = " + Arrays.toString(r103));
        Logger.d(TAG, "  KEY_QUIRK_FORCE_DISABLED = " + Arrays.toString(r104));
        return new QuirkSettings.Builder().setEnabledWhenDeviceHasQuirk(r102).forceEnableQuirks(resolveQuirkNames(r103)).forceDisableQuirks(resolveQuirkNames(r104)).build();
    }

    private static String[] loadQuirks(Context r100, Bundle r101, String r102) {
        if (r101.containsKey(r102) == false) goto L5;
        int r103 = r101.getInt(r102, -1);
        if (r103 != (-1)) goto L15;
        Logger.w(TAG, "Resource ID not found for key: " + r102);
        return new String[0];
    L15:
        return r100.getResources().getStringArray(r103);
    L12:
        e = move-exception;
        Logger.w(TAG, "Quirk class names resource not found: " + r103, e);
        return new String[0];
    L5:
        return new String[0];
    }
}
