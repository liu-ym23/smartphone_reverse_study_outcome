package com.obric.oui.orecyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
interface ViewTypeStorage {

    public interface ViewTypeLookup {
        void dispose();

        int globalToLocal(int r10);

        int localToGlobal(int r10);
    }

    @NonNull
    ViewTypeLookup createViewTypeWrapper(@NonNull NestedAdapterWrapper r10);

    @NonNull
    NestedAdapterWrapper getWrapperForGlobalType(int r10);
}
