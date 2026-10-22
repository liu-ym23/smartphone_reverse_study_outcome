package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.base;

import android.os.Bundle;
import android.view.View;
import com.bytedance.android.live.core.ui.BaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/choose/page/base/MiniAppChooseBasePagerFragment;", "Lcom/bytedance/android/live/core/ui/BaseFragment;", "<init>", "()V", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniAppChooseBasePagerFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f84159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f84160e;

    public abstract void S90();

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f84160e = false;
        this.f84159d = false;
    }

    public MiniAppChooseBasePagerFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void setUserVisibleHint(boolean r100) {
        super.setUserVisibleHint(r100);
        if (r100 == true) goto L5;
        return;
    L5:
        if (getUserVisibleHint() == true) goto L7;
        return;
    L7:
        if (this.f84159d == true) goto L9;
        return;
    L9:
        if (this.f84160e == true) goto L15;
        S90();
        this.f84160e = true;
        return;
    }

    @Override // com.bytedance.android.live.core.ui.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f84159d = true;
        if (getUserVisibleHint() == true) goto L5;
        return;
    L5:
        if (this.f84159d == true) goto L7;
        return;
    L7:
        if (this.f84160e == true) goto L12;
        S90();
        this.f84160e = true;
        return;
    }
}
