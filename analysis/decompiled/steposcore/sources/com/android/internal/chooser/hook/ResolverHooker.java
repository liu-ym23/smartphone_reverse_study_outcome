package com.android.internal.chooser.hook;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

/* loaded from: classes.dex */
public interface ResolverHooker {

    public interface ActivityBridge {
        void showUserGuide(View view);
    }

    void finish();

    void onActivityResult(int i, int i2, Intent intent);

    void onBackPressed();

    void onConfigurationChanged(Configuration configuration);

    void onCreate(Bundle bundle);

    void onDestroy();

    void onPause();

    void onRestart();

    void onRestoreInstanceState(Bundle bundle);

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void onStart();

    void onStop();

    boolean shouldHook();

    default void registerActivityBridgeListener(ActivityBridge listener) {
    }
}
