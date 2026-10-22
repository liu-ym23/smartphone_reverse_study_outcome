package com.bytedance.android.ec.core.legacy;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import eh.a;

/* JADX INFO: loaded from: classes43.dex */
public abstract class AbsFragment extends Fragment implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f45105d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f45106e;

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f45106e = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f45105d = true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.f45105d = false;
    }

    public AbsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f45105d = false;
        this.f45106e = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r100) {
        if (r100 == null) goto L4;
        r100.putBoolean("WORKAROUND_FOR_BUG_19917_KEY", true);
    L4:
        super.onSaveInstanceState(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
    }
}
