package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<AbstractC1277a> f84142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f84143b;

    /* JADX INFO: renamed from: com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC1277a {
        public AbstractC1277a() {
        }

        public abstract void a(a r100);
    }

    public final void a() {
        List<AbstractC1277a> r100 = this.f84142a;
        int r101 = this.f84143b;
        this.f84143b = r101 + 1;
        AbstractC1277a r102 = (AbstractC1277a) CollectionsKt.getOrNull(r100, r101);
        if (r102 == null) goto L6;
        r102.a(this);
        return;
    }

    public a() {
        this.f84142a = new ArrayList();
    }
}
