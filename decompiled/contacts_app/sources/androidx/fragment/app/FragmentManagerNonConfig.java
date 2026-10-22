package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class FragmentManagerNonConfig {
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
    private final Collection<Fragment> mFragments;
    private final Map<String, ViewModelStore> mViewModelStores;

    FragmentManagerNonConfig(Collection<Fragment> r1, Map<String, FragmentManagerNonConfig> r2, Map<String, ViewModelStore> r3) {
        this.mFragments = r1;
        this.mChildNonConfigs = r2;
        this.mViewModelStores = r3;
    }

    boolean isRetaining(Fragment r1) {
        Collection<Fragment> r0 = this.mFragments;
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.contains(r1);
    }

    Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }
}
