package dagger.hilt.android.internal.lifecycle;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.codegen.OriginatingElement;

@EntryPoint
@OriginatingElement(topLevelClass = HiltViewModelFactory.class)
@InstallIn({ActivityComponent.class})
/* loaded from: classes2.dex */
public interface HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint extends HiltViewModelFactory.ActivityCreatorEntryPoint {
}
