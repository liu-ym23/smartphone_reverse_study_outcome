package com.bytedance.android.livesdk.utils;

import com.bytedance.android.live.core.log.ALogger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<Object, ArrayList<WeakReference<a<?>>>> f158955a = null;

    public interface a<T> {
        boolean a(T r100, c<T> r101);
    }

    public static final class b {
        public static c a(Object r100, Function1 r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            ALogger.i("BusinessTaskChain", "postTask：" + r100);
            HashMap<Object, ArrayList<WeakReference<a<?>>>> r102 = g0.f158955a;
            ArrayList<WeakReference<a<?>>> r103 = r102.get(r100);
            if (r103 != null) goto L6;
            r103 = r102.get(r100.getClass());
        L6:
            if ((r103 instanceof ArrayList) == true) goto L8;
            r103 = null;
        L8:
            if (r103 != null) goto L10;
            return null;
        L10:
            if (r103.isEmpty() == true) goto L18;
            ArrayList r104 = new ArrayList();
            r104.addAll(r103);
            ALogger.i("BusinessTaskChain", "postTask：" + r100 + ",has handlers:" + r103.size());
            if (r101 == null) goto L16;
            new WeakReference(r101);
        L16:
            return new c(r100, r104);
        L18:
            return null;
        }
    }

    public static final class c<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f158956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f158957b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<WeakReference<a<T>>> f158958c;

        public final boolean b() {
            return a(this.f158957b, this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Object r100, ArrayList r101) {
            this.f158957b = r100;
            this.f158958c = r101;
        }

        @Override // com.bytedance.android.livesdk.utils.g0.a
        public final boolean a(T r100, c<T> r101) {
            Intrinsics.checkNotNullParameter(r101, "taskChain");
            ArrayList<WeakReference<a<T>>> r102 = this.f158958c;
            boolean r103 = false;
            if (r102 != null) goto L5;
        L31:
            return r103;
        L5:
            if (r102 != null) goto L7;
        L9:
            ArrayList<WeakReference<a<T>>> r104 = this.f158958c;
            if (r104 != null) goto L12;
            return false;
        L12:
            ArrayList r105 = new ArrayList();
            Iterator<T> r106 = r104.iterator();
        L14:
            if (r106.hasNext() == false) goto L19;
            WeakReference r107 = (WeakReference) r106.next();
            if (r107.get() == null) goto L14;
            r105.add(r107);
            goto L14
        L19:
            if (r105.isEmpty() == false) goto L21;
            return false;
        L21:
            r104.clear();
            r104.addAll(r105);
            this.f158958c = r104;
            Iterator<WeakReference<a<T>>> r108 = r104.iterator();
        L23:
            if (r108.hasNext() == false) goto L31;
            a<T> r109 = r108.next().get();
            if (r109 == null) goto L23;
            if (r109.a(r100, this) == false) goto L29;
            r103 = true;
            goto L23
        L29:
            r108.remove();
            goto L23
        L7:
            if (r102.isEmpty() != true) goto L9;
            goto L9
        }
    }

    static {
        f158955a = new HashMap();
    }
}
