package bs4;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public interface b {
    FragmentManager getPluginFragmentManager();

    DocumentPluginHost getPluginHost();

    <T extends ViewModel> T getViewModel(Class<T> r100);

    void handleOrientationState(boolean r100);

    mr4.a o();

    void p(String r100, String r101);

    void q(String r100, String r101, Map<String, Object> r102);
}
