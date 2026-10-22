package dagger.hilt.android.internal.managers;

import android.view.SavedStateHandle;
import androidx.annotation.OptIn;
import dagger.hilt.InstallIn;
import dagger.hilt.android.UnstableApi;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.lifecycle.ActivityRetainedSavedState;
import dagger.hilt.android.scopes.ActivityRetainedScoped;

@InstallIn({ActivityRetainedComponent.class})
/* loaded from: classes2.dex */
abstract class ActivitySavedStateHandleModule {
    @OptIn(markerClass = {UnstableApi.class})
    @ActivityRetainedScoped
    @ActivityRetainedSavedState
    public static SavedStateHandle provideSavedStateHandle(SavedStateHandleHolder savedStateHandleHolder) {
        return savedStateHandleHolder.getSavedStateHandle();
    }
}
