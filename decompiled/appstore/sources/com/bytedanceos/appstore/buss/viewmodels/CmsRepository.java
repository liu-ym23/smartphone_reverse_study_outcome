package com.bytedanceos.appstore.buss.viewmodels;

import com.bytedanceos.appstore.buss.network.cms.CmsBaseRepository;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class CmsRepository extends CmsBaseRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CmsRepository f8944a = null;

    static {
        f8944a = new CmsRepository();
    }

    public CmsRepository() {
    }

    public final Object d(String r10, Continuation r11) {
        return c(new CmsRepository$getCMSPage$4(r10, null), r11);
    }
}
