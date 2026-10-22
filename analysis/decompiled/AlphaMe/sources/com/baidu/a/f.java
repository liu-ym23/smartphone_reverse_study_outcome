package com.baidu.a;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f4661a;

    /* renamed from: b, reason: collision with root package name */
    private final LruCache<String, a> f4662b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);

    /* renamed from: c, reason: collision with root package name */
    private boolean f4663c;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private ArrayList<String> f4664a;

        /* renamed from: b, reason: collision with root package name */
        private ArrayList<String> f4665b;

        /* renamed from: c, reason: collision with root package name */
        private long f4666c;

        /* renamed from: d, reason: collision with root package name */
        private long f4667d;

        public void a(long j4) {
            this.f4666c = j4;
        }

        public ArrayList<String> b() {
            return this.f4664a;
        }

        public ArrayList<String> c() {
            return this.f4665b;
        }

        public long d() {
            return this.f4666c;
        }

        public long e() {
            return this.f4667d;
        }

        public void a(ArrayList<String> arrayList) {
            this.f4664a = arrayList;
        }

        public void b(long j4) {
            this.f4667d = j4;
        }

        public boolean a() {
            return e() + this.f4666c < System.currentTimeMillis() / 1000;
        }

        public void b(ArrayList<String> arrayList) {
            this.f4665b = arrayList;
        }
    }

    public f(String str, boolean z4) {
        this.f4663c = false;
        this.f4661a = str;
        this.f4663c = z4;
    }

    public a a(String str) {
        a aVar = this.f4662b.get(str);
        if (aVar == null || !aVar.a() || !this.f4663c) {
            return aVar;
        }
        this.f4662b.remove(str);
        j.a("Remove expired entry from %s cache while reading, host(%s)", this.f4661a, str);
        return null;
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = this.f4662b.snapshot().keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public void a() {
        this.f4662b.evictAll();
        j.a("Clear %s cache", this.f4661a);
    }

    public void b(String str) {
        a aVarA = a(str);
        if (aVarA == null || !aVarA.a()) {
            return;
        }
        this.f4662b.remove(str);
        j.a("Remove expired entry from %s cache, host(%s)", this.f4661a, str);
    }

    public void a(String str, a aVar) {
        ArrayList<String> arrayListB = aVar.b();
        ArrayList<String> arrayListC = aVar.c();
        if ((arrayListB == null || arrayListB.isEmpty()) && (arrayListC == null || arrayListC.isEmpty())) {
            return;
        }
        this.f4662b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f4661a;
        objArr[1] = str;
        objArr[2] = arrayListB != null ? arrayListB.toString() : null;
        objArr[3] = arrayListC != null ? arrayListC.toString() : null;
        objArr[4] = Long.valueOf(aVar.d());
        j.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    public void a(boolean z4) {
        this.f4663c = z4;
    }
}
