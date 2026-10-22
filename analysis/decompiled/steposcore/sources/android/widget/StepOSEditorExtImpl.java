package android.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MenuItem;
import java.util.List;

/* loaded from: classes.dex */
public class StepOSEditorExtImpl implements IStepOSEditorExt {
    private static final String TAG = "StepOSEditorExtImpl";
    private Editor mHost;

    public void onAttach(Editor host) {
        this.mHost = host;
    }

    public void onDetach() {
        this.mHost = null;
    }

    public void onInitProcessTextMenuItem(Context context, MenuItem menuItem, ResolveInfo resolveInfo) {
        if (context == null || menuItem == null || resolveInfo == null) {
            return;
        }
        if (hasAppLauncherInfo(context, resolveInfo.activityInfo.packageName)) {
            menuItem.setShowAsAction(0);
        } else {
            menuItem.setShowAsAction(1);
        }
        menuItem.setIcon(getIcon(context, resolveInfo));
    }

    private Drawable getIcon(Context context, ResolveInfo resolveInfo) throws PackageManager.NameNotFoundException {
        PackageManager pm = context.getPackageManager();
        Drawable originalIcon = null;
        ApplicationInfo info = resolveInfo.getComponentInfo().applicationInfo;
        if (info != null && info.icon != 0) {
            try {
                originalIcon = pm.getApplicationIcon(info.packageName);
            } catch (Exception e) {
                Log.e(TAG, "getIcon error " + e.getMessage());
            }
        }
        if (originalIcon == null) {
            return resolveInfo.loadIcon(pm);
        }
        return originalIcon;
    }

    private boolean hasAppLauncherInfo(Context context, String pkgName) {
        Intent intent = new Intent();
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setAction("android.intent.action.MAIN");
        if (pkgName != null) {
            intent.setPackage(pkgName);
        }
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfoList = pm.queryIntentActivities(intent, 0);
        return resolveInfoList != null && resolveInfoList.size() > 0;
    }
}
