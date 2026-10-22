package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import com.bytedance.android.shopping.anchorv3.repository.dto.GroupInfoResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f167957a = null;

    static {
        f167957a = new d();
    }

    public d() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        GroupInfoResponse r101 = (GroupInfoResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return r101.getGroupInfo();
    }
}
