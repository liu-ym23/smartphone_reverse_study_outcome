package com.stepos.alphame.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.stepos.alphame.R;

/* loaded from: classes.dex */
public final class MapMarkerBinding {

    @NonNull
    private final ImageView rootView;

    private MapMarkerBinding(@NonNull ImageView imageView) {
        this.rootView = imageView;
    }

    @NonNull
    public static MapMarkerBinding bind(@NonNull View view) {
        if (view != null) {
            return new MapMarkerBinding((ImageView) view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static MapMarkerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static MapMarkerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z4) {
        View viewInflate = layoutInflater.inflate(R.layout.map_marker, viewGroup, false);
        if (z4) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    @NonNull
    public ImageView getRoot() {
        return this.rootView;
    }
}
