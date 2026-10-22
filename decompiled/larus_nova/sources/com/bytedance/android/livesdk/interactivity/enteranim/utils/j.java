package com.bytedance.android.livesdk.interactivity.enteranim.utils;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes9.dex */
public final class j<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap<Long, Deque<E>> f136795a;

    public static final class a<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f136796a = null;

        static {
            f136796a = new a();
        }

        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return (((Long) r101).longValue() > ((Long) r100).longValue() ? 1 : (((Long) r101).longValue() == ((Long) r100).longValue() ? 0 : -1));
        }
    }

    public j() {
        this.f136795a = new TreeMap(a.f136796a);
    }

    public final List a(int r100) {
        LinkedList r101 = new LinkedList();
    L4:
        if (this.f136795a.isEmpty() == true) goto L16;
        if (r100 <= 0) goto L16;
        Map.Entry<Long, Deque<E>> r102 = this.f136795a.lastEntry();
        Long r103 = r102.getKey();
        if (r103.longValue() >= 90000) goto L16;
        Deque<E> r104 = r102.getValue();
        int r105 = Math.min(r104.size(), r100);
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L13;
        r101.add(r104.pollFirst());
        r106 = r106 + 1;
        goto L10
    L13:
        if (r104.isEmpty() == false) goto L15;
        this.f136795a.remove(r103);
    L15:
        r100 = r100 - r105;
    L16:
        return r101;
    }
}
