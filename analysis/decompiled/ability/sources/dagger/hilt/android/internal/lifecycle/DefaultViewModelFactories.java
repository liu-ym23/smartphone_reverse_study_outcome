package dagger.hilt.android.internal.lifecycle;

import android.view.ComponentActivity;
import android.view.ViewModelProvider;
import androidx.fragment.app.Fragment;
import dagger.hilt.EntryPoint;
import dagger.hilt.EntryPoints;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.lifecycle.HiltViewModelMap;
import dagger.hilt.internal.Preconditions;
import java.util.Map;
import javax.inject.Inject;

/* loaded from: classes2.dex */
public final class DefaultViewModelFactories {

    @EntryPoint
    @InstallIn({ActivityComponent.class})
    public interface ActivityEntryPoint {
        InternalFactoryFactory getHiltInternalFactoryFactory();
    }

    @InstallIn({ActivityComponent.class})
    public interface ActivityModule {
        @HiltViewModelMap.KeySet
        Map<Class<?>, Boolean> viewModelKeys();
    }

    @EntryPoint
    @InstallIn({FragmentComponent.class})
    public interface FragmentEntryPoint {
        InternalFactoryFactory getHiltInternalFactoryFactory();
    }

    public static final class InternalFactoryFactory {
        private final Map<Class<?>, Boolean> keySet;
        private final ViewModelComponentBuilder viewModelComponentBuilder;

        @Inject
        public InternalFactoryFactory(@HiltViewModelMap.KeySet Map<Class<?>, Boolean> map, ViewModelComponentBuilder viewModelComponentBuilder) {
            this.keySet = map;
            this.viewModelComponentBuilder = viewModelComponentBuilder;
        }

        private ViewModelProvider.Factory getHiltViewModelFactory(ViewModelProvider.Factory factory) {
            return new HiltViewModelFactory(this.keySet, (ViewModelProvider.Factory) Preconditions.checkNotNull(factory), this.viewModelComponentBuilder);
        }

        public ViewModelProvider.Factory fromActivity(ComponentActivity componentActivity, ViewModelProvider.Factory factory) {
            return getHiltViewModelFactory(factory);
        }

        public ViewModelProvider.Factory fromFragment(Fragment fragment, ViewModelProvider.Factory factory) {
            return getHiltViewModelFactory(factory);
        }
    }

    private DefaultViewModelFactories() {
    }

    public static ViewModelProvider.Factory getActivityFactory(ComponentActivity componentActivity, ViewModelProvider.Factory factory) {
        return ((ActivityEntryPoint) EntryPoints.get(componentActivity, ActivityEntryPoint.class)).getHiltInternalFactoryFactory().fromActivity(componentActivity, factory);
    }

    public static ViewModelProvider.Factory getFragmentFactory(Fragment fragment, ViewModelProvider.Factory factory) {
        return ((FragmentEntryPoint) EntryPoints.get(fragment, FragmentEntryPoint.class)).getHiltInternalFactoryFactory().fromFragment(fragment, factory);
    }
}
