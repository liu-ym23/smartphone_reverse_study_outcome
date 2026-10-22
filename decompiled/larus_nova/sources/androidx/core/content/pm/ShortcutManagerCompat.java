package androidx.core.content.pm;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import el9.a;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes6.dex */
public class ShortcutManagerCompat {
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    private static final int DEFAULT_MAX_ICON_DIMENSION_DP = 96;
    private static final int DEFAULT_MAX_ICON_DIMENSION_LOWRAM_DP = 48;
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    public static final int FLAG_MATCH_CACHED = 8;
    public static final int FLAG_MATCH_DYNAMIC = 2;
    public static final int FLAG_MATCH_MANIFEST = 1;
    public static final int FLAG_MATCH_PINNED = 4;
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static final String SHORTCUT_LISTENER_INTENT_FILTER_ACTION = "androidx.core.content.pm.SHORTCUT_LISTENER";
    private static final String SHORTCUT_LISTENER_META_DATA_KEY = "androidx.core.content.pm.shortcut_listener_impl";
    private static volatile List<ShortcutInfoChangeListener> sShortcutInfoChangeListeners;
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    public static class Api25Impl {
        private Api25Impl() {
        }

        public static String getShortcutInfoWithLowestRank(List<ShortcutInfo> r100) {
            Iterator<ShortcutInfo> r101 = r100.iterator();
            int r102 = -1;
            String r103 = null;
        L4:
            if (r101.hasNext() == false) goto L8;
            ShortcutInfo r104 = r101.next();
            if (r104.getRank() <= r102) goto L4;
            String r105 = r104.getId();
            r103 = r105;
            r102 = r104.getRank();
            goto L4
        L8:
            return r103;
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ShortcutMatchFlags {
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    private ShortcutManagerCompat() {
    }

    public static List<ShortcutInfoChangeListener> getShortcutInfoChangeListeners() {
        return sShortcutInfoChangeListeners;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_core_content_pm_ShortcutManagerCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context r100) {
        if (Build.VERSION.SDK_INT < 25) goto L13;
        List<ShortcutInfo> r101 = ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
        ArrayList r102 = new ArrayList(r101.size());
        Iterator<ShortcutInfo> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.add(new ShortcutInfoCompat.Builder(r100, r103.next()).build());
        goto L6
    L8:
        return r102;
    L13:
        return getShortcutInfoSaverInstance(r100).getShortcuts();
    L12:
        return new ArrayList();
    }

    public static int getIconMaxHeight(Context r100) {
        Preconditions.checkNotNull(r100);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).getIconMaxHeight();
    L7:
        return getIconDimensionInternal(r100, false);
    }

    public static int getIconMaxWidth(Context r100) {
        Preconditions.checkNotNull(r100);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).getIconMaxWidth();
    L7:
        return getIconDimensionInternal(r100, true);
    }

    public static int getMaxShortcutCountPerActivity(Context r100) {
        Preconditions.checkNotNull(r100);
        if (Build.VERSION.SDK_INT >= 25) goto L5;
        return 5;
    L5:
        return ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
    }

    private static String getShortcutInfoCompatWithLowestRank(List<ShortcutInfoCompat> r100) {
        Iterator<ShortcutInfoCompat> r101 = r100.iterator();
        int r102 = -1;
        String r103 = null;
    L4:
        if (r101.hasNext() == false) goto L8;
        ShortcutInfoCompat r104 = r101.next();
        if (r104.getRank() <= r102) goto L4;
        String r105 = r104.getId();
        r103 = r105;
        r102 = r104.getRank();
        goto L4
    L8:
        return r103;
    }

    private static List<ShortcutInfoChangeListener> getShortcutInfoListeners(Context r100) {
        if (sShortcutInfoChangeListeners != null) goto L23;
        ArrayList r101 = new ArrayList();
        PackageManager r102 = r100.getPackageManager();
        Intent r103 = new Intent(SHORTCUT_LISTENER_INTENT_FILTER_ACTION);
        r103.setPackage(r100.getPackageName());
        Iterator<ResolveInfo> r104 = r102.queryIntentActivities(r103, 128).iterator();
    L6:
        if (r104.hasNext() == false) goto L20;
        ActivityInfo r105 = r104.next().activityInfo;
        if (r105 == null) goto L6;
        Bundle r106 = r105.metaData;
        if (r106 == null) goto L6;
        String r107 = r106.getString(SHORTCUT_LISTENER_META_DATA_KEY);
        if (r107 == null) goto L6;
        r101.add((ShortcutInfoChangeListener) INVOKESTATIC_androidx_core_content_pm_ShortcutManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r107, false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r100}));     // Catch: Exception -> L18
        goto L6
    L20:
        if (sShortcutInfoChangeListeners != null) goto L23;
        sShortcutInfoChangeListeners = r101;
    L23:
        return sShortcutInfoChangeListeners;
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context r100) {
        if (sShortcutInfoCompatSaver != null) goto L13;
        if (Build.VERSION.SDK_INT < 23) goto L10;
        sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) INVOKESTATIC_androidx_core_content_pm_ShortcutManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", new Class[]{Context.class}).invoke(null, new Object[]{r100});     // Catch: Exception -> L8
    L10:
        if (sShortcutInfoCompatSaver != null) goto L13;
        sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
    L13:
        return sShortcutInfoCompatSaver;
    }

    public static boolean isRateLimitingActive(Context r100) {
        Preconditions.checkNotNull(r100);
        if (Build.VERSION.SDK_INT < 25) goto L7;
        return ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).isRateLimitingActive();
    L7:
        if (getShortcuts(r100, 3).size() != getMaxShortcutCountPerActivity(r100)) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isRequestPinShortcutSupported(Context r100) {
        if (Build.VERSION.SDK_INT < 26) goto L7;
        return ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
    L7:
        if (ContextCompat.checkSelfPermission(r100, INSTALL_SHORTCUT_PERMISSION) == 0) goto L9;
        return false;
    L9:
        Iterator<ResolveInfo> r101 = r100.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0).iterator();
    L11:
        if (r101.hasNext() == false) goto L18;
        String r102 = r101.next().activityInfo.permission;
        if (TextUtils.isEmpty(r102) == true) goto L16;
        if (INSTALL_SHORTCUT_PERMISSION.equals(r102) == false) goto L11;
        return true;
    L16:
        return true;
    L18:
        return false;
    }

    public static void removeAllDynamicShortcuts(Context r100) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
    L5:
        getShortcutInfoSaverInstance(r100).removeAllShortcuts();
        Iterator<ShortcutInfoChangeListener> r101 = getShortcutInfoListeners(r100).iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        r101.next().onAllShortcutsRemoved();
        goto L7
    }

    public static void setShortcutInfoChangeListeners(List<ShortcutInfoChangeListener> r100) {
        sShortcutInfoChangeListeners = r100;
    }

    public static void setShortcutInfoCompatSaver(ShortcutInfoCompatSaver<Void> r100) {
        sShortcutInfoCompatSaver = r100;
    }

    public static boolean addDynamicShortcuts(Context r100, List<ShortcutInfoCompat> r101) {
        List<ShortcutInfoCompat> r102 = removeShortcutsExcludedFromSurface(r101, 1);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 > 29) goto L6;
        convertUriIconsToBitmapIcons(r100, r102);
    L6:
        if (r103 < 25) goto L15;
        ArrayList r104 = new ArrayList();
        Iterator<ShortcutInfoCompat> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L12;
        r104.add(r105.next().toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) r100.getSystemService(ShortcutManager.class)).addDynamicShortcuts(r104) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r100).addShortcuts(r102);
        Iterator<ShortcutInfoChangeListener> r106 = getShortcutInfoListeners(r100).iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        r106.next().onShortcutAdded(r101);
        goto L17
    L19:
        return true;
    }

    public static boolean convertUriIconToBitmapIcon(Context r100, ShortcutInfoCompat r101) {
        IconCompat r102 = r101.mIcon;
        if (r102 != null) goto L5;
        return false;
    L5:
        int r103 = r102.mType;
        if (r103 != 6) goto L8;
    L10:
        InputStream r104 = r102.getUriInputStream(r100);
        if (r104 != null) goto L13;
        return false;
    L13:
        Bitmap r105 = BitmapFactory.decodeStream(r104);
        if (r105 != null) goto L16;
        return false;
    L16:
        if (r103 != 6) goto L18;
        IconCompat r106 = IconCompat.createWithAdaptiveBitmap(r105);
    L19:
        r101.mIcon = r106;
        return true;
    L18:
        r106 = IconCompat.createWithBitmap(r105);
        goto L19
    L8:
        if (r103 == 4) goto L10;
        return true;
    }

    public static void convertUriIconsToBitmapIcons(Context r100, List<ShortcutInfoCompat> r101) {
        Iterator r102 = new ArrayList(r101).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        ShortcutInfoCompat r103 = (ShortcutInfoCompat) r102.next();
        if (convertUriIconToBitmapIcon(r100, r103) == true) goto L4;
        r101.remove(r103);
        goto L4
    }

    public static Intent createShortcutResultIntent(Context r100, ShortcutInfoCompat r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Intent r102 = ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).createShortcutResultIntent(r101.toShortcutInfo());
    L6:
        if (r102 != null) goto L9;
        r102 = new Intent();
    L9:
        return r101.addToIntent(r102);
    L5:
        r102 = null;
        goto L6
    }

    public static void enableShortcuts(Context r100, List<ShortcutInfoCompat> r101) {
        List<ShortcutInfoCompat> r102 = removeShortcutsExcludedFromSurface(r101, 1);
        if (Build.VERSION.SDK_INT < 25) goto L9;
        ArrayList r103 = new ArrayList(r101.size());
        Iterator<ShortcutInfoCompat> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        r103.add(r104.next().mId);
        goto L6
    L8:
        ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).enableShortcuts(r103);
    L9:
        getShortcutInfoSaverInstance(r100).addShortcuts(r102);
        Iterator<ShortcutInfoChangeListener> r105 = getShortcutInfoListeners(r100).iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        r105.next().onShortcutAdded(r101);
        goto L11
    }

    private static int getIconDimensionInternal(Context r100, boolean r101) {
        ActivityManager r102 = (ActivityManager) r100.getSystemService("activity");
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        int r104 = 48;
    L12:
        int r105 = Math.max(1, r104);
        DisplayMetrics r106 = INVOKEVIRTUAL_androidx_core_content_pm_ShortcutManagerCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources());
        if (r101 == false) goto L15;
        float r107 = r106.xdpi;
    L17:
        return (int) (r105 * (r107 / 160.0f));
    L15:
        r107 = r106.ydpi;
        goto L17
    L11:
        r104 = 96;
        goto L12
    L5:
        if (r102.isLowRamDevice() == true) goto L8;
        r103 = false;
        goto L9
    }

    public static List<ShortcutInfoCompat> getShortcuts(Context r100, int r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 < 30) goto L7;
        return ShortcutInfoCompat.fromShortcuts(r100, ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).getShortcuts(r101));
    L7:
        if (r102 < 25) goto L20;
        ShortcutManager r103 = (ShortcutManager) r100.getSystemService(ShortcutManager.class);
        ArrayList r104 = new ArrayList();
        if ((r101 & 1) == 0) goto L12;
        r104.addAll(r103.getManifestShortcuts());
    L12:
        if ((r101 & 2) == 0) goto L15;
        r104.addAll(r103.getDynamicShortcuts());
    L15:
        if ((r101 & 4) == 0) goto L18;
        r104.addAll(r103.getPinnedShortcuts());
    L18:
        return ShortcutInfoCompat.fromShortcuts(r100, r104);
    L20:
        if ((r101 & 2) == 0) goto L24;
        return getShortcutInfoSaverInstance(r100).getShortcuts();
    L24:
        return Collections.emptyList();
    }

    public static boolean pushDynamicShortcut(Context r100, ShortcutInfoCompat r101) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        int r102 = Build.VERSION.SDK_INT;
        if (r102 <= 32) goto L5;
    L11:
        int r103 = getMaxShortcutCountPerActivity(r100);
        if (r103 != 0) goto L15;
        return false;
    L15:
        if (r102 > 29) goto L18;
        convertUriIconToBitmapIcon(r100, r101);
    L18:
        if (r102 < 30) goto L21;
        ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).pushDynamicShortcut(r101.toShortcutInfo());
    L29:
        ShortcutInfoCompatSaver<?> r104 = getShortcutInfoSaverInstance(r100);
        List<ShortcutInfoCompat> r105 = r104.getShortcuts();     // Catch: Throwable -> L40 Exception -> L47
        if (r105.size() < r103) goto L33;
        r104.removeShortcuts(Arrays.asList(new String[]{getShortcutInfoCompatWithLowestRank(r105)}));     // Catch: Throwable -> L40 Exception -> L47
    L33:
        r104.addShortcuts(Arrays.asList(new ShortcutInfoCompat[]{r101}));     // Catch: Throwable -> L40 Exception -> L47
        Iterator<ShortcutInfoChangeListener> r106 = getShortcutInfoListeners(r100).iterator();
    L36:
        if (r106.hasNext() == false) goto L38;
        r106.next().onShortcutAdded(Collections.singletonList(r101));
        goto L36
    L38:
        reportShortcutUsed(r100, r101.getId());
        return true;
    L47:
        Iterator<ShortcutInfoChangeListener> r107 = getShortcutInfoListeners(r100).iterator();
    L49:
        if (r107.hasNext() == false) goto L51;
        r107.next().onShortcutAdded(Collections.singletonList(r101));
        goto L49
    L51:
        reportShortcutUsed(r100, r101.getId());
        return false;
    L40:
        th = move-exception;
        Iterator<ShortcutInfoChangeListener> r108 = getShortcutInfoListeners(r100).iterator();
    L43:
        if (r108.hasNext() == false) goto L45;
        r108.next().onShortcutAdded(Collections.singletonList(r101));
        goto L43
    L45:
        reportShortcutUsed(r100, r101.getId());
        throw th;
    L21:
        if (r102 < 25) goto L29;
        ShortcutManager r109 = (ShortcutManager) r100.getSystemService(ShortcutManager.class);
        if (r109.isRateLimitingActive() == false) goto L25;
        return false;
    L25:
        List<ShortcutInfo> r110 = r109.getDynamicShortcuts();
        if (r110.size() < r103) goto L28;
        r109.removeDynamicShortcuts(Arrays.asList(new String[]{Api25Impl.getShortcutInfoWithLowestRank(r110)}));
    L28:
        r109.addDynamicShortcuts(Arrays.asList(new ShortcutInfo[]{r101.toShortcutInfo()}));
        goto L29
    L5:
        if (r101.isExcludedFromSurfaces(1) == false) goto L11;
        Iterator<ShortcutInfoChangeListener> r111 = getShortcutInfoListeners(r100).iterator();
    L8:
        if (r111.hasNext() == false) goto L10;
        r111.next().onShortcutAdded(Collections.singletonList(r101));
        goto L8
    L10:
        return true;
    }

    public static void removeDynamicShortcuts(Context r100, List<String> r101) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(r101);
    L5:
        getShortcutInfoSaverInstance(r100).removeShortcuts(r101);
        Iterator<ShortcutInfoChangeListener> r102 = getShortcutInfoListeners(r100).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onShortcutRemoved(r101);
        goto L7
    }

    public static void removeLongLivedShortcuts(Context r100, List<String> r101) {
        if (Build.VERSION.SDK_INT >= 30) goto L6;
        removeDynamicShortcuts(r100, r101);
        return;
    L6:
        ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).removeLongLivedShortcuts(r101);
        getShortcutInfoSaverInstance(r100).removeShortcuts(r101);
        Iterator<ShortcutInfoChangeListener> r102 = getShortcutInfoListeners(r100).iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        r102.next().onShortcutRemoved(r101);
        goto L8
    }

    private static List<ShortcutInfoCompat> removeShortcutsExcludedFromSurface(List<ShortcutInfoCompat> r100, int r101) {
        Objects.requireNonNull(r100);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r100;
    L5:
        ArrayList r102 = new ArrayList(r100);
        Iterator<ShortcutInfoCompat> r103 = r100.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        ShortcutInfoCompat r104 = r103.next();
        if (r104.isExcludedFromSurfaces(r101) == false) goto L7;
        r102.remove(r104);
        goto L7
    L11:
        return r102;
    }

    public static void reportShortcutUsed(Context r100, String r101) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).reportShortcutUsed(r101);
    L5:
        Iterator<ShortcutInfoChangeListener> r102 = getShortcutInfoListeners(r100).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r102.next().onShortcutUsageReported(Collections.singletonList(r101));
        goto L7
    }

    public static boolean setDynamicShortcuts(Context r100, List<ShortcutInfoCompat> r101) {
        Preconditions.checkNotNull(r100);
        Preconditions.checkNotNull(r101);
        List<ShortcutInfoCompat> r102 = removeShortcutsExcludedFromSurface(r101, 1);
        if (Build.VERSION.SDK_INT < 25) goto L12;
        ArrayList r103 = new ArrayList(r102.size());
        Iterator<ShortcutInfoCompat> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L9;
        r103.add(r104.next().toShortcutInfo());
        goto L6
    L9:
        if (((ShortcutManager) r100.getSystemService(ShortcutManager.class)).setDynamicShortcuts(r103) == true) goto L12;
        return false;
    L12:
        getShortcutInfoSaverInstance(r100).removeAllShortcuts();
        getShortcutInfoSaverInstance(r100).addShortcuts(r102);
        Iterator<ShortcutInfoChangeListener> r105 = getShortcutInfoListeners(r100).iterator();
    L14:
        if (r105.hasNext() == false) goto L16;
        ShortcutInfoChangeListener r106 = r105.next();
        r106.onAllShortcutsRemoved();
        r106.onShortcutAdded(r101);
        goto L14
    L16:
        return true;
    }

    public static boolean updateShortcuts(Context r100, List<ShortcutInfoCompat> r101) {
        List<ShortcutInfoCompat> r102 = removeShortcutsExcludedFromSurface(r101, 1);
        int r103 = Build.VERSION.SDK_INT;
        if (r103 > 29) goto L6;
        convertUriIconsToBitmapIcons(r100, r102);
    L6:
        if (r103 < 25) goto L15;
        ArrayList r104 = new ArrayList();
        Iterator<ShortcutInfoCompat> r105 = r102.iterator();
    L9:
        if (r105.hasNext() == false) goto L12;
        r104.add(r105.next().toShortcutInfo());
        goto L9
    L12:
        if (((ShortcutManager) r100.getSystemService(ShortcutManager.class)).updateShortcuts(r104) == true) goto L15;
        return false;
    L15:
        getShortcutInfoSaverInstance(r100).addShortcuts(r102);
        Iterator<ShortcutInfoChangeListener> r106 = getShortcutInfoListeners(r100).iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        r106.next().onShortcutUpdated(r101);
        goto L17
    L19:
        return true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_core_content_pm_ShortcutManagerCompat_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    public static void disableShortcuts(Context r100, List<String> r101, CharSequence r102) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        ((ShortcutManager) r100.getSystemService(ShortcutManager.class)).disableShortcuts(r101, r102);
    L5:
        getShortcutInfoSaverInstance(r100).removeShortcuts(r101);
        Iterator<ShortcutInfoChangeListener> r103 = getShortcutInfoListeners(r100).iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        r103.next().onShortcutRemoved(r101);
        goto L7
    }

    public static boolean requestPinShortcut(Context r110, ShortcutInfoCompat r111, final IntentSender r112) {
        int r100 = Build.VERSION.SDK_INT;
        if (r100 > 32) goto L8;
        if (r111.isExcludedFromSurfaces(1) == false) goto L8;
        return false;
    L8:
        if (r100 < 26) goto L12;
        return ((ShortcutManager) r110.getSystemService(ShortcutManager.class)).requestPinShortcut(r111.toShortcutInfo(), r112);
    L12:
        if (isRequestPinShortcutSupported(r110) == true) goto L14;
        return false;
    L14:
        Intent r101 = r111.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
        if (r112 != null) goto L18;
        r110.sendBroadcast(r101);
        return true;
    L18:
        r110.sendOrderedBroadcast(r101, null, new AnonymousClass1(r112), null, -1, null, null);
        return true;
    }
}
