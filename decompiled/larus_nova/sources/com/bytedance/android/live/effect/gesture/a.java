package com.bytedance.android.live.effect.gesture;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f68015c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f68016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1112a f68017b;

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.gesture.a$a, reason: collision with other inner class name */
    public static class C1112a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f68018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f68019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f68020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f68021d;

        public C1112a() {
        }
    }

    static {
        f68015c = Arrays.asList(new String[]{"BEGAN", "MOVED", "STATIONARY", "ENDED", "CANCELED"});
    }

    public a(int r100, C1112a r101) {
        this.f68016a = r100;
        this.f68017b = r101;
    }
}
