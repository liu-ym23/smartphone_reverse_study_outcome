package com.bytedance.android.live.browser;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.LiveDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/HybridBaseService;", "Lcom/bytedance/android/live/browser/IHybridBaseService;", "()V", "showHybridDebugFragment", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "url", "", "isLynx", "", "originSchema", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class HybridBaseService implements IHybridBaseService {
    public HybridBaseService() {
    }

    @Override // com.bytedance.android.live.browser.IHybridBaseService
    public void showHybridDebugFragment(FragmentActivity r100, String r101, boolean r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "url");
        int r104 = HybridDebugFragment.f62558k;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "url");
        Bundle r105 = new Bundle();
        r105.putString("url", r101);
        r105.putBoolean("is_lynx", r102);
        r105.putString("origin_schema", "");
        HybridDebugFragment r106 = new HybridDebugFragment();
        r106.setArguments(r105);
        LiveDialogFragment.Companion.getClass();
        LiveDialogFragment.a.a(r100, r106);
    }
}
