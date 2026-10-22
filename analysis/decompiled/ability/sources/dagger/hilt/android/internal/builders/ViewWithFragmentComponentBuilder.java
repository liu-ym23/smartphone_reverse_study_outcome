package dagger.hilt.android.internal.builders;

import android.view.View;
import dagger.hilt.DefineComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;

@DefineComponent.Builder
/* loaded from: classes2.dex */
public interface ViewWithFragmentComponentBuilder {
    ViewWithFragmentComponent build();

    ViewWithFragmentComponentBuilder view(View view);
}
