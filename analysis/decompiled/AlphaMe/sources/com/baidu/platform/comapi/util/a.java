package com.baidu.platform.comapi.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f9281a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, CopyOnWriteArraySet<b>> f9282b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, Object> f9283c = new HashMap();

    /* renamed from: com.baidu.platform.comapi.util.a$a, reason: collision with other inner class name */
    public class RunnableC0049a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f9291a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Object f9292b;

        public RunnableC0049a(b bVar, Object obj) {
            this.f9291a = bVar;
            this.f9292b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.a(this.f9291a, this.f9292b);
        }
    }

    public class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final c f9301a;

        @Override // com.baidu.platform.comapi.util.a.c
        public void a(Object obj) {
            this.f9301a.a(obj);
        }

        public boolean equals(Object obj) {
            return this.f9301a.equals(obj);
        }
    }

    public interface c {
        void a(Object obj);
    }

    private a() {
    }

    public static a a() {
        return f9281a;
    }

    public void a(Object obj) {
        CopyOnWriteArraySet<b> copyOnWriteArraySet;
        if (this.f9282b.containsKey(obj.getClass())) {
            synchronized (this) {
                copyOnWriteArraySet = this.f9282b.get(obj.getClass());
            }
            Iterator<b> it = copyOnWriteArraySet.iterator();
            while (it.hasNext()) {
                MapTaskManager.postToMainThread(new RunnableC0049a(it.next(), obj), 0L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(c cVar, Object obj) {
        cVar.a(obj);
    }
}
