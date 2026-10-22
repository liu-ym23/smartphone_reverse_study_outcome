package dagger.hilt.android.internal.builders;

import android.app.Service;
import dagger.hilt.DefineComponent;
import dagger.hilt.android.components.ServiceComponent;

@DefineComponent.Builder
/* loaded from: classes2.dex */
public interface ServiceComponentBuilder {
    ServiceComponent build();

    ServiceComponentBuilder service(Service service);
}
