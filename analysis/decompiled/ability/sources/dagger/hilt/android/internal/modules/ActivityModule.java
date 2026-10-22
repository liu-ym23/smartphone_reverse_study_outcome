package dagger.hilt.android.internal.modules;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.qualifiers.ActivityContext;

@InstallIn({ActivityComponent.class})
/* loaded from: classes2.dex */
abstract class ActivityModule {
    private ActivityModule() {
    }

    public static FragmentActivity provideFragmentActivity(Activity activity) {
        try {
            return (FragmentActivity) activity;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Expected activity to be a FragmentActivity: " + activity, e);
        }
    }

    @ActivityContext
    public abstract Context provideContext(Activity activity);
}
