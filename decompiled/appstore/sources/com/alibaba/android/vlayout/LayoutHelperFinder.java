package com.alibaba.android.vlayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LayoutHelperFinder implements Iterable<LayoutHelper> {
    public LayoutHelperFinder() {
    }

    @Nullable
    public abstract LayoutHelper getLayoutHelper(int r10);

    @NonNull
    public abstract List<LayoutHelper> getLayoutHelpers();

    public abstract Iterable<LayoutHelper> reverse();

    public abstract void setLayouts(@Nullable List<LayoutHelper> r10);
}
