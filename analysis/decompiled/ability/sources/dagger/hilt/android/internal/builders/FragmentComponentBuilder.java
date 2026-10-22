package dagger.hilt.android.internal.builders;

import androidx.fragment.app.Fragment;
import dagger.hilt.DefineComponent;
import dagger.hilt.android.components.FragmentComponent;

@DefineComponent.Builder
/* loaded from: classes2.dex */
public interface FragmentComponentBuilder {
    FragmentComponent build();

    FragmentComponentBuilder fragment(Fragment fragment);
}
