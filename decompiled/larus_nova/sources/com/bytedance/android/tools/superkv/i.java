package com.bytedance.android.tools.superkv;

import android.util.LruCache;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f187644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static transient boolean f187645b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2748a f187646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f187647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f187648c;

        /* JADX INFO: renamed from: com.bytedance.android.tools.superkv.i$a$a, reason: collision with other inner class name */
        public class C2748a extends LruCache<String, d> {
            public C2748a() {
                super(8);
            }

            @Override // android.util.LruCache
            public final void entryRemoved(boolean r100, String r101, d r102, d r103) {
                r102.f187617b.release();
            }
        }

        public a() {
            this.f187646a = new C2748a();
        }
    }

    static {
        f187644a = new a();
        f187645b = false;
    }
}
