package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class ActivityFragmentBinding {

    @NonNull
    public final FrameLayout fragmentContainer;

    @NonNull
    private final View rootView;

    @NonNull
    public final View topLine;

    private ActivityFragmentBinding(@NonNull View view, @NonNull FrameLayout frameLayout, @NonNull View view2) {
        this.rootView = view;
        this.fragmentContainer = frameLayout;
        this.topLine = view2;
    }

    @NonNull
    public static ActivityFragmentBinding bind(@NonNull View view) {
        View viewN;
        int i4 = R.id.fragment_container;
        FrameLayout frameLayout = (FrameLayout) h.n(i4, view);
        if (frameLayout == null || (viewN = h.n((i4 = R.id.top_line), view)) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
        }
        return new ActivityFragmentBinding(view, frameLayout, viewN);
    }

    @NonNull
    public static ActivityFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R.layout.activity_fragment, viewGroup);
        return bind(viewGroup);
    }

    @NonNull
    public View getRoot() {
        return this.rootView;
    }
}
