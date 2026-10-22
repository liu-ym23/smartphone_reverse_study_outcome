package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.livesdk.gift.model.h0;
import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f129004a = null;

    static {
        f129004a = new d();
    }

    public d() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return ((h0) r100).getGroupCount() - ((h0) r101).getGroupCount();
    }
}
