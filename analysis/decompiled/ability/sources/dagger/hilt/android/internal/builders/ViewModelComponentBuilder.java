package dagger.hilt.android.internal.builders;

import android.view.SavedStateHandle;
import dagger.hilt.DefineComponent;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.components.ViewModelComponent;

@DefineComponent.Builder
/* loaded from: classes2.dex */
public interface ViewModelComponentBuilder {
    ViewModelComponent build();

    ViewModelComponentBuilder savedStateHandle(SavedStateHandle savedStateHandle);

    ViewModelComponentBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle);
}
