package com.android.contacts.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class EmptyFragment extends Fragment {
    public EmptyFragment() {
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        return new FrameLayout(getActivity());
    }
}
