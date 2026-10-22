package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.airbnb.lottie.h;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class ActivityPrivacySettingBinding {

    @NonNull
    public final FrameLayout fragmentContainer;

    @NonNull
    private final FrameLayout rootView;

    @NonNull
    public final View topLine;

    private ActivityPrivacySettingBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull View view) {
        this.rootView = frameLayout;
        this.fragmentContainer = frameLayout2;
        this.topLine = view;
    }

    @NonNull
    public static ActivityPrivacySettingBinding bind(@NonNull View view) {
        View viewN;
        int i4 = R.id.fragment_container;
        FrameLayout frameLayout = (FrameLayout) h.n(i4, view);
        if (frameLayout == null || (viewN = h.n((i4 = R.id.top_line), view)) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
        }
        return new ActivityPrivacySettingBinding((FrameLayout) view, frameLayout, viewN);
    }

    @NonNull
    public static ActivityPrivacySettingBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPrivacySettingBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.activity_privacy_setting, viewGroup, false);
        if (z4) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
