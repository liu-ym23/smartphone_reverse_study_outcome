package androidx.lifecycle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes17.dex */
public class ViewModelStores {
    private ViewModelStores() {
    }

    public static ViewModelStore of(Fragment r100) {
        return r100.getViewModelStore();
    }

    public static ViewModelStore of(FragmentActivity r100) {
        return r100.getViewModelStore();
    }
}
