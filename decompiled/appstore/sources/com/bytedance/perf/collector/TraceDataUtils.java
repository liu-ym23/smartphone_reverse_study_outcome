package com.bytedance.perf.collector;

import android.util.Log;
import g1.e;
import g1.f;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public abstract class TraceDataUtils {

    public interface IStructuredDataFilter {
        void fallback(List<f> r10, int r11);

        int getFilterMaxCount();

        boolean isFilter(long r10, int r11);
    }

    public static class a implements Comparator {
        public a() {
        }

        public int a(f r10, f r11) {
            return Integer.compare((r11.f19885d + 1) * r11.f19883b, (r10.f19885d + 1) * r10.f19883b);
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((f) r10, (f) r11);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f7861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f7862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public LinkedList f7863c;

        public b(f r10, b r11) {
            this.f7863c = new LinkedList();
            this.f7861a = r10;
            this.f7862b = r11;
        }

        public static /* synthetic */ int a(b r10) {
            return r10.d();
        }

        public static /* synthetic */ void b(b r10, b r11) {
            r10.c(r11);
        }

        public final void c(b r10) {
            this.f7863c.addFirst(r10);
        }

        public final int d() {
            f r10 = this.f7861a;
            if (r10 != null) goto L6;
            return 0;
        L6:
            return r10.f19885d;
        }
    }

    public static int a(LinkedList r10, f r11) {
        if (c.B() == false) goto L6;
        Log.v("TraceDataUtils", "method:" + r11);
    L6:
        if (r10.isEmpty() == true) goto L8;
        f r12 = (f) r10.peek();
    L9:
        if (r12 != null) goto L11;
    L20:
        r10.push(r11);
        return r11.f19883b;
    L11:
        if (r12.f19882a != r11.f19882a) goto L20;
        int r13 = r12.f19885d;
        int r14 = r11.f19885d;
        if (r13 != r14) goto L20;
        if (r14 == 0) goto L20;
        int r15 = r11.f19883b;
        if (r15 != 5000) goto L18;
        r15 = r12.f19883b;
    L18:
        r11.f19883b = r15;
        r12.a(r15);
        return r12.f19883b;
    L8:
        r12 = null;
        goto L9
    }

    public static int b(long r10) {
        return (int) ((r10 >> 43) & 1048575);
    }

    public static long c(long r10) {
        return r10 & 8796093022207L;
    }

    public static String d(List r10, long r11) {
        StringBuilder r12 = new StringBuilder();
        long r13 = (long) (r11 * 0.3f);
        LinkedList r14 = new LinkedList();
        Iterator r15 = r10.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        f r16 = (f) r15.next();
        if (r16.f19883b < r13) goto L4;
        r14.add(r16);
        goto L4
    L8:
        Collections.sort(r14, new a());
        if (r14.isEmpty() == false) goto L14;
        if (r10.isEmpty() == true) goto L14;
        r14.add((f) r10.get(0));
    L18:
        Iterator r17 = r14.iterator();
        if (r17.hasNext() == false) goto L22;
        r12.append(((f) r17.next()).f19882a + "\n");
    L22:
        return r12.toString();
    L14:
        if (r14.size() <= 1) goto L18;
        if (((f) r14.peek()).f19882a != 1048574) goto L18;
        r14.removeFirst();
        goto L18
    }

    public static boolean e(long r10) {
        if (((r10 >> 63) & 1) != 1) goto L5;
        return true;
    L5:
        return false;
    }

    public static void f(List r10, int r11) {
        if (r11 >= 0) goto L5;
        r10.clear();
        return;
    L5:
        ListIterator r12 = r10.listIterator(r10.size());
    L7:
        if (r12.hasPrevious() == false) goto L11;
        if (((f) r12.previous()).f19883b >= r11) goto L7;
        r12.remove();
        goto L7
    }

    public static long g(LinkedList r10, StringBuilder r11) {
        Iterator r12 = r10.iterator();
        long r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L8;
        f r14 = (f) r12.next();
        r11.append(r14.toString());
        r11.append('\n');
        int r15 = r14.f19883b;
        if (r13 >= r15) goto L4;
        r13 = r15;
        goto L4
    L8:
        return r13;
    }

    public static int h(LinkedList r10, b r11) {
        ListIterator r12 = r10.listIterator(0);
        b r13 = null;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L31;
        b r15 = new b((f) r12.next(), r13);
        r14 = r14 + 1;
        if (r13 == null) goto L8;
    L13:
        int r16 = b.a(r15);
        if (r13 == null) goto L29;
        if (r16 == 0) goto L29;
        if (b.a(r13) < r16) goto L28;
    L19:
        if (r13 == null) goto L23;
        if (b.a(r13) <= r16) goto L23;
        r13 = r13.f7862b;
    L23:
        if (r13 == null) goto L4;
        b r17 = r13.f7862b;
        if (r17 == null) goto L30;
        r15.f7862b = r17;
        b.b(r13.f7862b, r15);
    L30:
        r13 = r15;
        goto L4
    L28:
        b.b(r13, r15);
    L29:
        b.b(r11, r15);
        goto L30
    L8:
        if (b.a(r15) == 0) goto L13;
        if (c.B() == false) goto L12;
        com.bytedance.apm.logging.a.a("TraceDataUtils", "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!", new Object[0]);
    L12:
        return 0;
    L31:
        com.bytedance.apm.logging.a.b("SceneMethodsInfo", "[stackToTree] count [%d] ", new Object[]{Integer.valueOf(r14)});
        return r14;
    }

    public static void i(int r25, long[] r26, LinkedList r27, boolean r28, long r29, int r31) {
        if (r26 != null) goto L5;
        return;
    L5:
        if (r26.length == 0) goto L113;
        int r10 = 1;
        long r11 = 0;
        if (r26[r26.length - 1] == 0) goto L10;
        long r12 = c(r26[r26.length - 1]);
    L11:
        int r13 = 0;
    L13:
        if (r13 >= r26.length) goto L18;
        if (c(r26[r13]) < r12) goto L18;
        r13 = r13 + 1;
    L18:
        if (r25 > 0) goto L20;
        int r14 = 1048574;
    L21:
        LinkedList r15 = new LinkedList();
        int r16 = 0;
        int r17 = 0;
    L23:
        if (r13 >= r26.length) goto L73;
        long r18 = r26[r13];
        if (r11 != r18) goto L27;
    L26:
        long r19 = r11;
    L72:
        r13 = r13 + 1;
        r11 = r19;
        r10 = 1;
        goto L23
    L27:
        if (r28 == false) goto L38;
        if (e(r18) == true) goto L31;
    L33:
        if (r17 != 0) goto L38;
        if (b(r18) <= 1048000) goto L26;
        com.bytedance.apm.logging.a.b("SceneMethodsInfo", "s2 pass this method[%s], isIn [%b] ", new Object[]{Integer.valueOf(b(r18)), Boolean.valueOf(e(r18))});
        goto L26
    L31:
        if (r14 != b(r18)) goto L33;
        r17 = r10;
    L38:
        if (e(r18) == true) goto L40;
        int r20 = b(r18);
        if (r15.isEmpty() == true) goto L69;
        Long r21 = (Long) r15.pop();
        long r110 = r21.longValue();
        r16 = r16 - 1;
        LinkedList r22 = new LinkedList();
        r22.push(r21);
    L47:
        int r23 = b(r110);
        if (r23 == r20) goto L55;
        if (r15.isEmpty() == true) goto L55;
        if (c.B() == false) goto L54;
        com.bytedance.apm.logging.a.c("TraceDataUtils", "pop inMethodId[%s] to continue match ouMethodId[%s]", new Object[]{Integer.valueOf(r23), Integer.valueOf(r20)});
    L54:
        Long r24 = (Long) r15.pop();
        r110 = r24.longValue();
        r16 = r16 - 1;
        r22.push(r24);
    L55:
        if (r23 == r20) goto L58;
        if (r23 != r14) goto L58;
        c.B();
        r15.addAll(r22);
        r16 = r16 + r15.size();
    L43:
        r19 = 0;
    L58:
        long r111 = c(r18) + e.C();
    L60:
        if (r22.size() == 0) goto L43;
        long r210 = c(((Long) r22.pop()).longValue()) + e.C();
        LinkedList r211 = r22;
        long r30 = r111 - r210;
        if (r30 < 0) goto L64;
        a(r27, new f(r20, (int) r30, r210, r16));
        r22 = r211;
        goto L60
    L64:
        if (c.B() == false) goto L66;
        com.bytedance.apm.logging.a.a("TraceDataUtils", "[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(r30)});
    L66:
        r15.clear();
        r27.clear();
        return;
    L69:
        r19 = 0;
        if (c.B() == false) goto L72;
        com.bytedance.apm.logging.a.c("TraceDataUtils", "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(r20)});
        goto L72
    L40:
        if (b(r18) != r14) goto L42;
        r15.clear();
        r16 = 0;
    L42:
        r16 = r16 + r10;
        r15.push(Long.valueOf(r18));
        goto L43
    L73:
        com.bytedance.apm.logging.a.b("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + r27.size() + ", " + r15.size(), new Object[0]);
    L75:
        if (r15.isEmpty() == true) goto L86;
        long r32 = ((Long) r15.pop()).longValue();
        int r112 = b(r32);
        boolean r33 = e(r32);
        long r113 = c(r32) + e.C();
        if (c.B() == false) goto L79;
        com.bytedance.apm.logging.a.c("TraceDataUtils", "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(r112), Boolean.valueOf(r33), Long.valueOf(r113), Long.valueOf(r29), Integer.valueOf(r15.size())});
    L79:
        if (r33 == false) goto L81;
        if (r31 <= 0) goto L85;
        if (r16 > r31) goto L75;
    L85:
        a(r27, new f(r112, (int) (r29 - r113), r113, r15.size()));
        goto L75
    L81:
        if (c.B() == false) goto L75;
        com.bytedance.apm.logging.a.a("TraceDataUtils", "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(r112)});
        goto L75
    L86:
        b r34 = new b(null, null);
        h(r27, r34);
        r27.clear();
        k(r34, r27);
        return;
    L20:
        r14 = r25;
        goto L21
    L10:
        r12 = Long.MAX_VALUE;
        goto L11
    }

    public static void j(long[] r10, LinkedList r11, boolean r12, long r13) {
        i(1048574, r10, r11, r12, r13, -1);
    }

    public static void k(b r10, LinkedList r11) {
        LinkedList r12 = new LinkedList();
    L3:
        if (r10 == null) goto L13;
        f r13 = r10.f7861a;
        if (r13 == null) goto L7;
        r11.add(r13);
    L7:
        LinkedList r14 = r10.f7863c;
        if (r14.isEmpty() == true) goto L12;
        int r15 = r14.size() - 1;
    L10:
        if (r15 < 0) goto L12;
        r12.add(r14.get(r15));
        r15 = r15 - 1;
    L12:
        r10 = (b) r12.pollLast();
        goto L3
    }

    public static void l(List r10, int r11) {
        ListIterator r12 = r10.listIterator(r10.size());
    L4:
        if (r12.hasPrevious() == false) goto L10;
        f r13 = (f) r12.previous();
        if (r13 == null) goto L4;
        if (r13.f19883b >= r11) goto L4;
        r12.remove();
        goto L4
    }

    public static void m(List r10, int r11, IStructuredDataFilter r12) {
        if (r11 >= 0) goto L5;
        r10.clear();
        return;
    L5:
        int r13 = r10.size();
        int r14 = 1;
    L6:
        if (r13 <= r11) goto L17;
        ListIterator r15 = r10.listIterator(r10.size());
    L9:
        if (r15.hasPrevious() == false) goto L15;
        if (r12.isFilter(((f) r15.previous()).f19883b, r14) == false) goto L9;
        r15.remove();
        r13 = r13 - 1;
        if (r13 > r11) goto L9;
        return;
    L15:
        r13 = r10.size();
        r14 = r14 + 1;
        if (r12.getFilterMaxCount() >= r14) goto L6;
    L17:
        int r16 = r10.size();
        if (r16 <= r11) goto L30;
        r12.fallback(r10, r16);
        return;
    }
}
