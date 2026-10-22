package com.bytedance.android.bcm.impl.model;

import com.bytedance.android.btm.impl.page.model.PageInfo;
import com.bytedance.android.btm.impl.page.model.g;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f41818a = null;

    public c() {
    }

    static {
        f41818a = new c();
    }

    @Override // com.bytedance.android.btm.impl.page.model.g
    public final PageInfo create() {
        return new BcmPageInfo();
    }
}
