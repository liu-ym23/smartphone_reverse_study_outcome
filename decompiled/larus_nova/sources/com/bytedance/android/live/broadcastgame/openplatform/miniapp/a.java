package com.bytedance.android.live.broadcastgame.openplatform.miniapp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f61737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f61738b;

    /* JADX INFO: renamed from: com.bytedance.android.live.broadcastgame.openplatform.miniapp.a$a, reason: collision with other inner class name */
    public static final class C1020a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<b> f61739a;

        public final a b() {
            a r100 = new a();
            Iterator<T> r101 = this.f61739a.iterator();
        L4:
            if (r101.hasNext() == false) goto L6;
            b r102 = (b) r101.next();
            ((ArrayList) r100.f61737a).add(r102);
            goto L4
        L6:
            return r100;
        }

        public C1020a() {
            this.f61739a = new ArrayList();
        }

        public final void a(b r100) {
            Intrinsics.checkNotNullParameter(r100, "node");
            ((ArrayList) this.f61739a).add(r100);
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(a r100);
    }

    public final void a() {
        List<b> r100 = this.f61737a;
        int r101 = this.f61738b;
        this.f61738b = r101 + 1;
        b r102 = (b) CollectionsKt.getOrNull(r100, r101);
        if (r102 == null) goto L6;
        r102.a(this);
        return;
    }

    public a() {
        this.f61737a = new ArrayList();
    }
}
