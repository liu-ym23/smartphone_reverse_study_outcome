package I2;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.familyguard.R;
import com.stepos.minor.ui.MinorMainActivity;
import java.util.ArrayList;
import java.util.Iterator;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class c {

    class a implements D3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f2957a;

        a(Context context) {
            this.f2957a = context;
        }

        @Override // D3.a
        public void run() {
            try {
                ArrayList arrayList = new ArrayList();
                int iG = c.g(this.f2957a);
                ShortcutManager shortcutManager = (ShortcutManager) androidx.core.content.a.h(this.f2957a.getApplicationContext(), ShortcutManager.class);
                Iterator<ShortcutInfo> it = shortcutManager.getPinnedShortcuts().iterator();
                while (it.hasNext()) {
                    String id = it.next().getId();
                    if (TextUtils.equals(id, "minor_shortcut_id")) {
                        if (TextUtils.isEmpty(id)) {
                            Log.d("ShortcutUtils", "shortcutId is empty");
                            return;
                        }
                        arrayList.add(c.c(this.f2957a, iG));
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                shortcutManager.updateShortcuts(arrayList);
            } catch (Exception e6) {
                e6.printStackTrace();
                Log.d("ShortcutUtils", "update shortcut failed, exception: " + e6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ShortcutInfo c(Context context, int i5) {
        String string = context.getString(R.string.fg_minor_title);
        ShortcutInfo.Builder intent = new ShortcutInfo.Builder(context, "minor_shortcut_id").setShortLabel(string).setLongLabel(string).setIcon(Icon.createWithResource(context, i5)).setIntent(f(context));
        intent.setLongLived(true);
        try {
            intent.setActivity(new ComponentName(context, (Class<?>) MinorMainActivity.class));
        } catch (Exception e6) {
            Log.d("ShortcutUtils", "set shortcut activity failed, exception: " + e6);
        }
        return intent.build();
    }

    private static void d(Context context) {
        ShortcutManager shortcutManager = (ShortcutManager) androidx.core.content.a.h(context.getApplicationContext(), ShortcutManager.class);
        int iG = g(context);
        if (shortcutManager == null || !shortcutManager.isRequestPinShortcutSupported()) {
            return;
        }
        Log.d("ShortcutUtils", "createShortcut.ret : " + shortcutManager.requestPinShortcut(c(context, iG), null));
    }

    public static void e(Context context) {
        d(context);
    }

    private static Intent f(Context context) {
        Intent intent = new Intent(context, (Class<?>) MinorMainActivity.class);
        intent.setAction("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int g(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        ContentResolver contentResolver = context.getContentResolver();
        boolean z5 = uiModeManager.getNightMode() == 2;
        int i5 = Settings.System.getInt(contentResolver, "current_launcher_icon_color", 0);
        return i5 == 1 ? R.mipmap.ic_minor : (i5 == 2 || z5) ? R.mipmap.ic_minor_dark : R.mipmap.ic_minor;
    }

    public static void h(Context context, boolean z5) {
        context.getSharedPreferences("minor_sp", 0).edit().putBoolean("add_shortcut", z5).apply();
    }

    private static boolean i(Context context) {
        Log.d("ShortcutUtils", "shortcutDataInLauncherAfterAndroidP");
        ShortcutManager shortcutManager = (ShortcutManager) androidx.core.content.a.h(context.getApplicationContext(), ShortcutManager.class);
        if (shortcutManager == null) {
            return false;
        }
        for (ShortcutInfo shortcutInfo : shortcutManager.getPinnedShortcuts()) {
            if (shortcutInfo != null && TextUtils.equals(shortcutInfo.getId(), "minor_shortcut_id")) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(Context context, String str, String str2) {
        Log.d("ShortcutUtils", "shortcutExists");
        Log.d("ShortcutUtils", "isAfterAndroidP");
        return i(context);
    }

    public static boolean k(Context context) {
        return context.getSharedPreferences("minor_sp", 0).getBoolean("add_shortcut", false);
    }

    public static void l(Context context) {
        AbstractC1286b.c(new a(context)).j(T3.a.c()).f();
    }
}
