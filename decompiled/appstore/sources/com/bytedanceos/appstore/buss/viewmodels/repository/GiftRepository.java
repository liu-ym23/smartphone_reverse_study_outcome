package com.bytedanceos.appstore.buss.viewmodels.repository;

import com.bytedanceos.appstore.buss.network.base.BaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class GiftRepository extends BaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GiftRepository f9028a = null;

    static {
        f9028a = new GiftRepository();
    }

    public GiftRepository() {
    }

    public final Object f(int r10, int r11, Continuation r12) {
        return e(new GiftRepository$getAllGift$2(r10, r11, null), r12);
    }

    public final Object g(int r10, int r11, Continuation r12) {
        return e(new GiftRepository$getMyGift$2(r10, r11, null), r12);
    }
}
