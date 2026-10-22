package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;
import stepos.support.v7.widget.StepOSRecyclerView;

/* loaded from: classes.dex */
public final class PersonalMainFragmentBinding {

    @NonNull
    private final StepOSRecyclerView rootView;

    @NonNull
    public final StepOSRecyclerView viewRv;

    private PersonalMainFragmentBinding(@NonNull StepOSRecyclerView stepOSRecyclerView, @NonNull StepOSRecyclerView stepOSRecyclerView2) {
        this.rootView = stepOSRecyclerView;
        this.viewRv = stepOSRecyclerView2;
    }

    @NonNull
    public static PersonalMainFragmentBinding bind(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        StepOSRecyclerView stepOSRecyclerView = (StepOSRecyclerView) view;
        return new PersonalMainFragmentBinding(stepOSRecyclerView, stepOSRecyclerView);
    }

    @NonNull
    public static PersonalMainFragmentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static PersonalMainFragmentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.personal_main_fragment, viewGroup, false);
        if (z4) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public StepOSRecyclerView getRoot() {
        return this.rootView;
    }
}
