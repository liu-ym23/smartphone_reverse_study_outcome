package com.obric.oui.orecyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class NestedAdapterWrapper {

    public interface Callback {
        void onChanged(@NonNull NestedAdapterWrapper r10);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper r10, int r11, int r12);

        void onItemRangeChanged(@NonNull NestedAdapterWrapper r10, int r11, int r12, @Nullable Object r13);

        void onItemRangeInserted(@NonNull NestedAdapterWrapper r10, int r11, int r12);

        void onItemRangeMoved(@NonNull NestedAdapterWrapper r10, int r11, int r12);

        void onItemRangeRemoved(@NonNull NestedAdapterWrapper r10, int r11, int r12);

        void onStateRestorationPolicyChanged(NestedAdapterWrapper r10);
    }
}
