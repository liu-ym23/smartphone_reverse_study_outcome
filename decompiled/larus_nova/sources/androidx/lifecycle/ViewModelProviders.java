package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes17.dex */
public class ViewModelProviders {

    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        public DefaultFactory(Application r100) {
            super(r100);
        }
    }

    public ViewModelProviders() {
    }

    private static Activity checkActivity(Fragment r100) {
        FragmentActivity r101 = r100.getActivity();
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    private static Application checkApplication(Activity r100) {
        Application r101 = r100.getApplication();
        if (r101 == null) goto L6;
        return r101;
    L6:
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    public static ViewModelProvider of(Fragment r100) {
        return of(r100, null);
    }

    public static ViewModelProvider of(FragmentActivity r100) {
        return of(r100, null);
    }

    public static ViewModelProvider of(Fragment r100, ViewModelProvider.Factory r101) {
        Application r102 = checkApplication(checkActivity(r100));
        if (r101 != null) goto L6;
        r101 = ViewModelProvider.AndroidViewModelFactory.getInstance(r102);
    L6:
        return new ViewModelProvider(r100.getViewModelStore(), r101);
    }

    public static ViewModelProvider of(FragmentActivity r100, ViewModelProvider.Factory r101) {
        Application r102 = checkApplication(r100);
        if (r101 != null) goto L6;
        r101 = ViewModelProvider.AndroidViewModelFactory.getInstance(r102);
    L6:
        return new ViewModelProvider(r100.getViewModelStore(), r101);
    }
}
