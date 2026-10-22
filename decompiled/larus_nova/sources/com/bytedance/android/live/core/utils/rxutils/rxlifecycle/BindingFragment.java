package com.bytedance.android.live.core.utils.rxutils.rxlifecycle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import io.reactivex.subjects.BehaviorSubject;

/* JADX INFO: loaded from: classes45.dex */
public class BindingFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BehaviorSubject<LifecycleEvent> f66371d;

    public BindingFragment() {
        this.f66371d = BehaviorSubject.create();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f66371d.onNext(LifecycleEvent.DESTROY);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f66371d.onNext(LifecycleEvent.DESTROY_VIEW);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        super.onDetach();
        this.f66371d.onNext(LifecycleEvent.DETACH);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        this.f66371d.onNext(LifecycleEvent.PAUSE);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f66371d.onNext(LifecycleEvent.RESUME);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f66371d.onNext(LifecycleEvent.START);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f66371d.onNext(LifecycleEvent.STOP);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Activity r100) {
        super.onAttach(r100);
        this.f66371d.onNext(LifecycleEvent.ATTACH);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f66371d.onNext(LifecycleEvent.CREATE);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        this.f66371d.onNext(LifecycleEvent.ATTACH);
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        this.f66371d.onNext(LifecycleEvent.CREATE_VIEW);
        return null;
    }
}
