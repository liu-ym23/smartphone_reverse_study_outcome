package androidx.recyclerview.widget;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
interface StableIdStorage {

    public interface StableIdLookup {
        long localToGlobal(long r10);
    }

    @NonNull
    StableIdLookup createStableIdLookup();
}
