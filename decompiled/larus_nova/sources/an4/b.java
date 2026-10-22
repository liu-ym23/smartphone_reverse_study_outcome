package an4;

import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.core.widget.KeyboardPlaceholderView;
import com.bytedance.ee.bear.document.model.toolbar.ItemIdV2;
import com.bytedance.ee.bear.edit.toolbar.toolbar2.OfficeAbsToolbarV2PanelFragment;

/* JADX INFO: loaded from: classes15.dex */
public interface b {
    void a(ItemIdV2 r100, Object r101);

    ViewGroup b();

    ViewGroup c();

    void d();

    KeyboardPlaceholderView e();

    FragmentActivity getActivity();

    OfficeAbsToolbarV2PanelFragment getFragment();

    FragmentManager getFragmentManager();

    PluginHost getPluginHost();
}
