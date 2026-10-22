package com.gyf.barlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleImmersionFragment extends Fragment implements SimpleImmersionOwner {
    private SimpleImmersionProxy mSimpleImmersionProxy;

    @Override // com.gyf.barlibrary.SimpleImmersionOwner
    public boolean immersionBarEnabled() {
        return true;
    }

    public SimpleImmersionFragment() {
        this.mSimpleImmersionProxy = new SimpleImmersionProxy(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean r1) {
        super.setUserVisibleHint(r1);
        this.mSimpleImmersionProxy.setUserVisibleHint(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r1) {
        super.onActivityCreated(r1);
        this.mSimpleImmersionProxy.onActivityCreated(r1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mSimpleImmersionProxy.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean r1) {
        super.onHiddenChanged(r1);
        this.mSimpleImmersionProxy.onHiddenChanged(r1);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r1) {
        super.onConfigurationChanged(r1);
        this.mSimpleImmersionProxy.onConfigurationChanged(r1);
    }
}
