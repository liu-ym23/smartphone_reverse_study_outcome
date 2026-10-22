package com.obric.oui.orecyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
interface StableIdStorage {

    public interface StableIdLookup {
        long localToGlobal(long r10);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}
