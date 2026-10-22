package androidx.fragment.app;

import androidx.lifecycle.ViewModelStore;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes17.dex */
public class FragmentManagerNonConfig {
    private final Map<String, FragmentManagerNonConfig> mChildNonConfigs;
    private final Collection<Fragment> mFragments;
    private final Map<String, ViewModelStore> mViewModelStores;

    public Map<String, FragmentManagerNonConfig> getChildNonConfigs() {
        return this.mChildNonConfigs;
    }

    public Collection<Fragment> getFragments() {
        return this.mFragments;
    }

    public Map<String, ViewModelStore> getViewModelStores() {
        return this.mViewModelStores;
    }

    public boolean isRetaining(Fragment r100) {
        Collection<Fragment> r101 = this.mFragments;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.contains(r100);
    }

    public FragmentManagerNonConfig(Collection<Fragment> r100, Map<String, FragmentManagerNonConfig> r101, Map<String, ViewModelStore> r102) {
        this.mFragments = r100;
        this.mChildNonConfigs = r101;
        this.mViewModelStores = r102;
    }
}
