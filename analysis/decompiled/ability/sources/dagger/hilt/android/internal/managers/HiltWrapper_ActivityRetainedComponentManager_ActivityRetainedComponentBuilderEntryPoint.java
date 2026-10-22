package dagger.hilt.android.internal.managers;

import dagger.hilt.EntryPoint;
import dagger.hilt.InstallIn;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;

@EntryPoint
@OriginatingElement(topLevelClass = ActivityRetainedComponentManager.class)
@InstallIn({SingletonComponent.class})
/* loaded from: classes2.dex */
public interface HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint extends ActivityRetainedComponentManager.ActivityRetainedComponentBuilderEntryPoint {
}
