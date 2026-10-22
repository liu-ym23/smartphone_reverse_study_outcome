package com.stepos.launcher.assistant.slidepanel;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import net.sqlcipher.database.SQLiteDatabase;

/* loaded from: classes.dex */
public final class OverlayAllTasksBroadcastHelper {
    public static final String ACTION_OPEN_ALL_TASK = "com.stepos.ailauncher.action.OPEN_ALL_TASK";
    private static final String AI_LAUNCHER_PACKAGE = "com.stepos.ailauncher";
    public static final String EXTRA_MORPH_SOURCE_BOUNDS = "com.stepos.ailauncher.chat.sheet.MORPH_SOURCE_BOUNDS";
    private static final String TAG = "OverlayAllTasksBroadcast";

    private OverlayAllTasksBroadcastHelper() {
    }

    private static Rect getViewBoundsOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i10 = iArr[0];
        return new Rect(i10, iArr[1], view.getWidth() + i10, iArr[1] + view.getHeight());
    }

    public static void openAllSessions(Context context, View view) {
        if (context == null || view == null) {
            return;
        }
        Rect viewBoundsOnScreen = getViewBoundsOnScreen(view);
        if (viewBoundsOnScreen.width() <= 0 || viewBoundsOnScreen.height() <= 0) {
            Log.w(TAG, "openAllSessions: invalid source bounds " + viewBoundsOnScreen);
            return;
        }
        Intent intentAddFlags = new Intent(ACTION_OPEN_ALL_TASK).setPackage(AI_LAUNCHER_PACKAGE).putExtra(EXTRA_MORPH_SOURCE_BOUNDS, viewBoundsOnScreen).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        Log.d(TAG, "send OPEN_ALL_TASK bounds=" + viewBoundsOnScreen);
        context.sendBroadcast(intentAddFlags);
    }
}
