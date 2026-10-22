package bs4;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;

/* JADX INFO: loaded from: classes15.dex */
public interface d {
    FragmentManager getPluginFragmentManager();

    DocumentPluginHost getPluginHost();

    <T extends ViewModel> T getViewModel(Class<T> r100);

    void handleOrientationState(boolean r100);
}
