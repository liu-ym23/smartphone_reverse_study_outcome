package com.bytedance.android.live;

import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/LiveShareBaseFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveShareBaseFragment extends Fragment {

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ALogger.d("match_live_share", "LiveShareBaseFragment on resume");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        ALogger.d("match_live_share", "LiveShareBaseFragment on stop");
    }

    public LiveShareBaseFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }
}
