package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import androidx.core.internal.view.SupportMenuItem;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: MenuItemCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    private static final String TAG = "MenuItemCompat";

    /* JADX INFO: compiled from: MenuItemCompat.java */
    static class a {
        static MenuItem a(MenuItem r2, CharSequence r3) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).setContentDescription((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        static CharSequence a(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).getContentDescription();
        }

        static MenuItem b(MenuItem r2, CharSequence r3) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).setTooltipText((CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin"));
        }

        static CharSequence b(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).getTooltipText();
        }

        static MenuItem a(MenuItem r2, char r3, char r4, int r5, int r6) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).setShortcut(r3, r4, r5, r6);
        }

        static MenuItem a(MenuItem r2, char r3, int r4) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).setNumericShortcut(r3, r4);
        }

        static int c(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).getNumericModifiers();
        }

        static MenuItem b(MenuItem r2, char r3, int r4) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).setAlphabeticShortcut(r3, r4);
        }

        static int d(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).getAlphabeticModifiers();
        }

        static MenuItem a(MenuItem r2, ColorStateList r3) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).setIconTintList(r3);
        }

        static ColorStateList e(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).getIconTintList();
        }

        static MenuItem a(MenuItem r2, PorterDuff.Mode r3) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).setIconTintMode(r3);
        }

        static PorterDuff.Mode f(MenuItem r2) {
            return ((MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin")).getIconTintMode();
        }
    }

    /* JADX INFO: compiled from: MenuItemCompat.java */
    @Deprecated
    public interface b {
        boolean a(MenuItem r1);

        boolean b(MenuItem r1);
    }

    public static MenuItem a(MenuItem r2, androidx.core.view.a r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == true) goto L5;
        a(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return r4;
    L5:
        return ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.aiagent.plugin")).setSupportActionProvider(r3);
    }

    public static void a(MenuItem r2, CharSequence r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.aiagent.plugin")).setContentDescription(r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        a.a(r4, r5);
        return;
    }

    public static void b(MenuItem r2, CharSequence r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.aiagent.plugin")).setTooltipText(r5);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        a.b(r4, r5);
        return;
    }

    public static void a(MenuItem r2, char r3, int r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r5, SupportMenuItem.class, "com.obric.aiagent.plugin")).setNumericShortcut(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        a.a(r5, r3, r4);
        return;
    }

    public static void b(MenuItem r2, char r3, int r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r5, SupportMenuItem.class, "com.obric.aiagent.plugin")).setAlphabeticShortcut(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        a.b(r5, r3, r4);
        return;
    }

    public static void a(MenuItem r2, ColorStateList r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.aiagent.plugin")).setIconTintList(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        a.a(r4, r3);
        return;
    }

    public static void a(MenuItem r2, PorterDuff.Mode r3) {
        MenuItem r4 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r2, MenuItem.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, SupportMenuItem.class) == false) goto L6;
        ((SupportMenuItem) ZeusTransformUtils.preCheckCast(r4, SupportMenuItem.class, "com.obric.aiagent.plugin")).setIconTintMode(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        a.a(r4, r3);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }
}
