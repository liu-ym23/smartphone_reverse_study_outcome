package com.stepos.widget.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.stepos.widget.R;
import com.stepos.widget.list.StepOSListItem;

/* loaded from: classes2.dex */
public final class SteposPreferenceBridgeBinding {
    private final StepOSListItem rootView;
    public final StepOSListItem steposPreferenceBridgeRow;

    private SteposPreferenceBridgeBinding(StepOSListItem stepOSListItem, StepOSListItem stepOSListItem2) {
        this.rootView = stepOSListItem;
        this.steposPreferenceBridgeRow = stepOSListItem2;
    }

    public static SteposPreferenceBridgeBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        StepOSListItem stepOSListItem = (StepOSListItem) view;
        return new SteposPreferenceBridgeBinding(stepOSListItem, stepOSListItem);
    }

    public static SteposPreferenceBridgeBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SteposPreferenceBridgeBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View viewInflate = layoutInflater.inflate(R.layout.stepos_preference_bridge, viewGroup, false);
        if (z10) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public StepOSListItem getRoot() {
        return this.rootView;
    }
}
