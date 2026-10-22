package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SizeConfigStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Bitmap.Config[] f3550a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Bitmap.Config[] f3551b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Bitmap.Config[] f3552c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f3553d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f3554e = null;
    private final b f;
    private final h<a, Bitmap> g;
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> h;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.a.n$1, reason: invalid class name */
    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3555a = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            f3555a = r0;
            r0[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f3555a[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f3555a[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f3555a[Bitmap.Config.ALPHA_8.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f3556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f3557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f3558c;

        public a(b r1) {
            this.f3557b = r1;
        }

        public void a(int r1, Bitmap.Config r2) {
            this.f3556a = r1;
            this.f3558c = r2;
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void a() {
            this.f3557b.a(this);
        }

        public String toString() {
            return n.a(this.f3556a, this.f3558c);
        }

        public boolean equals(Object r4) {
            if (ZeusTransformUtils.instanceOf(r4, a.class) == false) goto L10;
            a r5 = (a) ZeusTransformUtils.preCheckCast(r4, a.class, "com.obric.aiagent.plugin");
            if (this.f3556a == r5.f3556a) goto L7;
            return false;
        L7:
            if (com.bumptech.glide.f.k.a(this.f3558c, r5.f3558c) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.f3556a * 31;
            Bitmap.Config r1 = this.f3558c;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static class b extends d<a> {
        @Override // com.bumptech.glide.load.engine.a.d
        public /* synthetic */ m b() {
            return a();
        }

        b() {
        }

        public a a(int r3, Bitmap.Config r4) {
            a r2 = (a) ZeusTransformUtils.preCheckCast(c(), a.class, "com.obric.aiagent.plugin");
            r2.a(r3, r4);
            return r2;
        }

        public a a() {
            return new a(this);
        }
    }

    public n() {
        this.f = new b();
        this.g = new h();
        this.h = new HashMap();
    }

    static {
        Bitmap.Config[] r0 = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r0 = (Bitmap.Config[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r0, 3), Bitmap.Config[].class, "com.obric.aiagent.plugin");
        r0[r0.length - 1] = Bitmap.Config.RGBA_F16;
    L5:
        f3550a = r0;
        f3551b = r0;
        f3552c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f3553d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f3554e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public void a(Bitmap r4) {
        int r0 = com.bumptech.glide.f.k.a(r4);
        a r1 = this.f.a(r0, r4.getConfig());
        this.g.a(r1, r4);
        NavigableMap<Integer, Integer> r3 = a(r4.getConfig());
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r3.get(Integer.valueOf(r1.f3556a)), Integer.class, "com.obric.aiagent.plugin");
        Integer r2 = Integer.valueOf(r1.f3556a);
        int r6 = 1;
        if (r5 == null) goto L6;
        r6 = 1 + r5.intValue();
    L6:
        r3.put(r2, Integer.valueOf(r6));
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap a(int r5, int r6, Bitmap.Config r7) {
        a r0 = b(com.bumptech.glide.f.k.a(r5, r6, r7), r7);
        Bitmap r1 = (Bitmap) ZeusTransformUtils.preCheckCast(this.g.a(r0), Bitmap.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L5;
        a(Integer.valueOf(r0.f3556a), r1);
        r1.reconfigure(r5, r6, r7);
    L5:
        return r1;
    }

    private a b(int r9, Bitmap.Config r10) {
        a r0 = this.f.a(r9, r10);
        Bitmap.Config[] r1 = b(r10);
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L24;
        Bitmap.Config r4 = r1[r3];
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(a(r4).ceilingKey(Integer.valueOf(r9)), Integer.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L16;
        if (r5.intValue() > (r9 * 8)) goto L16;
        if (r5.intValue() != r9) goto L15;
        if (r4 != null) goto L14;
        if (r10 != null) goto L15;
        return r0;
    L14:
        if (r4.equals(r10) == false) goto L15;
        return r0;
    L15:
        this.f.a(r0);
        return this.f.a(r5.intValue(), r4);
    L16:
        r3 = r3 + 1;
        goto L3
    L24:
        return r0;
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap a() {
        Bitmap r0 = (Bitmap) ZeusTransformUtils.preCheckCast(this.g.a(), Bitmap.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L5;
        a(Integer.valueOf(com.bumptech.glide.f.k.a(r0)), r0);
    L5:
        return r0;
    }

    private void a(Integer r5, Bitmap r6) {
        NavigableMap<Integer, Integer> r0 = a(r6.getConfig());
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(r0.get(r5), Integer.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L10;
        if (r1.intValue() != 1) goto L7;
        r0.remove(r5);
        return;
    L7:
        r0.put(r5, Integer.valueOf(r1.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r5 + ", removed: " + b(r6) + ", this: " + this);
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config r4) {
        NavigableMap<Integer, Integer> r0 = (NavigableMap) ZeusTransformUtils.preCheckCast(this.h.get(r4), NavigableMap.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        TreeMap r1 = new TreeMap();
        this.h.put(r4, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(Bitmap r1) {
        return a(com.bumptech.glide.f.k.a(r1), r1.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(int r1, int r2, Bitmap.Config r3) {
        return a(com.bumptech.glide.f.k.a(r1, r2, r3), r3);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public int c(Bitmap r1) {
        return com.bumptech.glide.f.k.a(r1);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.g).append(", sortedSizes=(");
        Iterator<Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>>> r1 = this.h.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        r0.append(r2.getKey()).append('[').append(r2.getValue()).append("], ");
        goto L4
    L7:
        if (this.h.isEmpty() == true) goto L10;
        r0.replace(r0.length() - 2, r0.length(), "");
    L10:
        return r0.append(")}").toString();
    }

    static String a(int r2, Bitmap.Config r3) {
        return "[" + r2 + "](" + r3 + ")";
    }

    private static Bitmap.Config[] b(Bitmap.Config r3) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L8:
        int r0 = AnonymousClass1.f3555a[r3.ordinal()];
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L21;
        if (r0 == 4) goto L19;
        return new Bitmap.Config[]{r3};
    L19:
        return f3554e;
    L21:
        return f3553d;
    L23:
        return f3552c;
    L25:
        return f3550a;
    L5:
        if (Bitmap.Config.RGBA_F16.equals(r3) == false) goto L8;
        return f3551b;
    }
}
