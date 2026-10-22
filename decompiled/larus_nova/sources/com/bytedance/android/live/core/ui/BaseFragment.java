package com.bytedance.android.live.core.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.utils.d;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.ref.WeakReference;
import java.util.Map;
import tw2.b;

/* JADX INFO: loaded from: classes45.dex */
public class BaseFragment extends Fragment implements b {
    private final CompositeDisposable compositeDisposable;
    protected boolean mStatusActive;
    protected boolean mStatusDestroyed;
    protected boolean mStatusViewValid;

    @Override // tw2.a
    public Map<String, Object> getEnvData() {
        return null;
    }

    @Override // tw2.b
    public Map<String, Object> getPropertyParams() {
        return null;
    }

    @Override // tw2.b
    public String getSpm() {
        return null;
    }

    @Override // tw2.b
    public boolean isIgnored() {
        return false;
    }

    public BaseFragment() {
        this.mStatusActive = false;
        this.mStatusViewValid = false;
        this.mStatusDestroyed = false;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mStatusViewValid = false;
        this.mStatusDestroyed = true;
        this.compositeDisposable.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mStatusViewValid = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mStatusActive = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mStatusActive = true;
        if (v.a() == false) goto L9;
        FragmentActivity r100 = getActivity();
        WeakReference<Activity> r101 = d.f158925a;
        if (v.a() == false) goto L10;
        if (r100 == null) goto L11;
        d.f158925a = new WeakReference(r100);
        return;
    L11:
        return;
    L10:
        return;
    }

    public boolean isActive() {
        return this.mStatusActive;
    }

    public boolean isDestroyed() {
        return this.mStatusDestroyed;
    }

    public boolean isViewValid() {
        return this.mStatusViewValid;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.mStatusActive = false;
        this.mStatusViewValid = false;
        this.mStatusDestroyed = false;
    }

    public void register(Disposable r100) {
        this.compositeDisposable.add(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.mStatusViewValid = true;
    }
}
