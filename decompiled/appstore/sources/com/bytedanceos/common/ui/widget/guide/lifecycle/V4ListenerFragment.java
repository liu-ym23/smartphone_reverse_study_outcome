package com.bytedanceos.common.ui.widget.guide.lifecycle;

import androidx.fragment.app.Fragment;
import com.bytedanceos.common.ui.widget.guide.util.GuideLogUtil;

/* JADX INFO: loaded from: classes2.dex */
public class V4ListenerFragment extends Fragment {
    FragmentLifecycle mFragmentLifecycle;

    public V4ListenerFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GuideLogUtil.d("onDestroy: ");
        FragmentLifecycle r10 = this.mFragmentLifecycle;
        if (r10 == null) goto L6;
        r10.onDestroy();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        FragmentLifecycle r10 = this.mFragmentLifecycle;
        if (r10 == null) goto L6;
        r10.onDestroyView();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        GuideLogUtil.d("onStart: ");
        FragmentLifecycle r10 = this.mFragmentLifecycle;
        if (r10 == null) goto L6;
        r10.onStart();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        FragmentLifecycle r10 = this.mFragmentLifecycle;
        if (r10 == null) goto L6;
        r10.onStop();
        return;
    }

    public void setFragmentLifecycle(FragmentLifecycle r10) {
        this.mFragmentLifecycle = r10;
    }
}
