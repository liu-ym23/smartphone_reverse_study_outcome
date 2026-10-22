package androidx.viewpager2.adapter;

import androidx.fragment.app.Fragment;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/viewpager2/adapter/FragmentStateAdapterHelper;", "", "<init>", "()V", "TAG", "", "getFragmentByIndex", "Landroidx/fragment/app/Fragment;", "fragmentStateAdapter", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "index", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FragmentStateAdapterHelper {
    public static final FragmentStateAdapterHelper INSTANCE = null;
    private static final String TAG = "FragmentStateAdapterHelper";

    static {
        INSTANCE = new FragmentStateAdapterHelper();
    }

    private FragmentStateAdapterHelper() {
    }

    public final Fragment getFragmentByIndex(FragmentStateAdapter r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "fragmentStateAdapter");
        return r100.mFragments.get(r100.getItemId(r101));
    L5:
        FLogger.f375446a.e(TAG, "getFragmentByIndex error");
        return null;
    }
}
