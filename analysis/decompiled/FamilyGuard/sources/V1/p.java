package V1;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import f2.C0702g;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class p extends AppWidgetProvider {
    private static void a(AppWidgetManager appWidgetManager, int i5) {
        if (appWidgetManager == null) {
            return;
        }
        C0702g.b("DWAWPB", "id = " + i5 + " bundle = " + C0702g.i(appWidgetManager.getAppWidgetOptions(i5)));
    }

    private static void b(AppWidgetManager appWidgetManager, int[] iArr) {
        for (int i5 : iArr) {
            a(appWidgetManager, i5);
        }
    }

    private void d(Context context, String str, int[] iArr) {
        Intent intent = new Intent();
        intent.setClass(context, AppWidgetManagerService.class);
        intent.putExtra("APP_WIDGET_TYPE", c().ordinal());
        intent.setAction(str);
        AppWidgetManagerService.C(context, intent);
    }

    protected abstract A c();

    @Override // android.appwidget.AppWidgetProvider
    public void onAppWidgetOptionsChanged(Context context, AppWidgetManager appWidgetManager, int i5, Bundle bundle) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, i5, bundle);
        d(context, "android.appwidget.action.APPWIDGET_UPDATE_OPTIONS", new int[]{i5});
        C0702g.b("DWAWPB", "onAppWidgetOptionsChanged: appWidgetId = " + i5 + " newOptions = " + bundle);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDeleted(Context context, int[] iArr) {
        super.onDeleted(context, iArr);
        C0702g.b("DWAWPB", "onDeleted() called with: context = [" + context + "], appWidgetIds = " + C0702g.f(iArr));
        d(context, "android.appwidget.action.APPWIDGET_DELETED", iArr);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onDisabled(Context context) {
        super.onDisabled(context);
        C0702g.b("DWAWPB", "onDisabled() called with: context = [" + context + "]");
        d(context, "android.appwidget.action.APPWIDGET_DISABLED", null);
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onEnabled(Context context) {
        super.onEnabled(context);
        C0702g.b("DWAWPB", "onEnabled() called with: context = [" + context + "]");
        d(context, "android.appwidget.action.APPWIDGET_ENABLED", null);
    }

    @Override // android.appwidget.AppWidgetProvider, android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
        C0702g.b("DWAWPB", "onReceive() called with: context = [" + context + "], intent = [" + intent + "]");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onRestored(Context context, int[] iArr, int[] iArr2) {
        super.onRestored(context, iArr, iArr2);
        C0702g.b("DWAWPB", "onRestored() called with: context = [" + context + "], oldWidgetIds = [" + Arrays.toString(iArr) + "], newWidgetIds = [" + Arrays.toString(iArr2) + "]");
    }

    @Override // android.appwidget.AppWidgetProvider
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] iArr) {
        super.onUpdate(context, appWidgetManager, iArr);
        C0702g.b("DWAWPB", "onUpdate() called with: context = [" + context + "], appWidgetManager = [" + appWidgetManager + "], appWidgetIds = [" + C0702g.f(iArr) + "]");
        if (!p2.g.x(context)) {
            com.stepos.digitalwellbeing.appwidget.b.v(context, appWidgetManager, c(), iArr);
            return;
        }
        com.stepos.digitalwellbeing.appwidget.b.e(context, appWidgetManager, c(), iArr);
        d(context, "android.appwidget.action.APPWIDGET_UPDATE", iArr);
        b(appWidgetManager, iArr);
    }
}
