package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import com.bytedanceos.appstore.utils.d;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class DeleteMyAppRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DeleteMyAppRepository f9025a = null;

    static {
        f9025a = new DeleteMyAppRepository();
    }

    public DeleteMyAppRepository() {
    }

    public final Object f(List r10, Continuation r11) {
        if (d.a() == false) goto L7;
        return e(new DeleteMyAppRepository$deleteMyApps$2(r10, null), r11);
    L7:
        return e(new DeleteMyAppRepository$deleteMyApps$3(r10, null), r11);
    }
}
