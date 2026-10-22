package com.stepos.launcher.assistant.quickstep;

import android.appwidget.AppWidgetProviderInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceControl;
import com.stepos.launcher.client.a;

/* loaded from: classes.dex */
public class RemoteTransitionParams {
    private static final String TAG = "RemoteTransitionParams";
    public SurfaceControl.Transaction finishTransaction;
    public int transitMode;
    public int widgetId;
    public AppWidgetProviderInfo widgetInfo;

    public RemoteTransitionParams(int i10, AppWidgetProviderInfo appWidgetProviderInfo, int i11, SurfaceControl.Transaction transaction) {
        this.widgetId = i10;
        this.widgetInfo = appWidgetProviderInfo;
        this.transitMode = i11;
        this.finishTransaction = transaction;
    }

    public static RemoteTransitionParams from(Bundle bundle) {
        try {
            int i10 = bundle.getInt("key:widgetId", -1);
            AppWidgetProviderInfo appWidgetProviderInfo = (AppWidgetProviderInfo) bundle.getParcelable("key:widgetInfo", AppWidgetProviderInfo.class);
            int i11 = bundle.getInt("key:transitMode", 0);
            SurfaceControl.Transaction transaction = (SurfaceControl.Transaction) bundle.getParcelable("key:finishTransaction", SurfaceControl.Transaction.class);
            a.a(appWidgetProviderInfo);
            return new RemoteTransitionParams(i10, appWidgetProviderInfo, i11, transaction);
        } catch (Exception e10) {
            Log.e(TAG, "Failed to construct transition params from " + bundle, e10);
            return null;
        }
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt("key:widgetId", this.widgetId);
        bundle.putParcelable("key:widgetInfo", this.widgetInfo);
        bundle.putInt("key:transitMode", this.transitMode);
        bundle.putParcelable("key:finishTransaction", this.finishTransaction);
        return bundle;
    }
}
