package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.viewModel.topViewModel;

import com.bytedance.android.livesdk.gift.model.h0;
import java.util.Comparator;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f128997a = null;

    static {
        f128997a = new a();
    }

    public a() {
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        return ((h0) r100).getGroupCount() - ((h0) r101).getGroupCount();
    }
}
