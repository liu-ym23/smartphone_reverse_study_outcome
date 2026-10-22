package dagger.hilt.android.internal.builders;

import android.view.View;
import dagger.hilt.DefineComponent;
import dagger.hilt.android.components.ViewComponent;

@DefineComponent.Builder
/* loaded from: classes2.dex */
public interface ViewComponentBuilder {
    ViewComponent build();

    ViewComponentBuilder view(View view);
}
