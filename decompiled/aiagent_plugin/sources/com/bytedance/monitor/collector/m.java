package com.bytedance.monitor.collector;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: SamplingStackUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: compiled from: SamplingStackUtil.java */
    static class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f9019a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f9020b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f9021c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f9022d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f9023e;
        long f;
        long g;

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(a r3) {
            return a((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin"));
        }

        public a(boolean r2, int r3, long r4, long r6, long r8, long r10) {
            this.f9019a = false;
            this.f9019a = r2;
            this.f9020b = r3;
            this.f9021c = r4;
            this.f9022d = r6;
            this.f9023e = r8;
            this.f = r10;
            this.g = (r8 - r6) / 1000000;
        }

        public int a(a r4) {
            long r0 = this.f9022d;
            long r3 = r4.f9022d;
            if (r0 <= r3) goto L7;
            return 1;
        L7:
            if (r0 != r3) goto L10;
            return 0;
        L10:
            return -1;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder().append(this.f9020b).append(",");
            if (this.f9019a == false) goto L5;
            String r2 = "sys";
        L7:
            return r0.append(r2).append(",").append(this.f9021c).append(",").append(this.f9022d).append(",").append(this.f9023e).append(",").append(this.f).toString();
        L5:
            r2 = "app";
            goto L7
        }
    }

    public static String a(String r6, StringBuilder r7, int r8, long r9) {
        LinkedList<a> r10 = a(r6);
    L4:
        if (r10.size() <= r8) goto L11;
        long r2 = 21;
        Iterator<a> r0 = r10.iterator();
    L7:
        if (r0.hasNext() == false) goto L4;
        if (((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin")).g >= r2) goto L7;
        r0.remove();
        goto L7
    L11:
        Iterator<a> r11 = r10.iterator();
    L13:
        if (r11.hasNext() == false) goto L16;
        r7.append(((a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.aiagent.plugin")).toString()).append('\n');
        goto L13
    L16:
        if (r10.size() != 0) goto L20;
        return null;
    L20:
        return a(r10, r9);
    }

    private static LinkedList<a> a(String r19) {
        LinkedList<a> r0 = new LinkedList();
        String[] r1 = r19.split("\n");
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        String[] r5 = r1[r4].split(",");
        if (r5 == null) goto L10;
        if (r5.length < 6) goto L10;
        r0.add(new a(r5[1].startsWith("sys"), Integer.parseInt(r5[0]), Long.parseLong(r5[2]), Long.parseLong(r5[3]), Long.parseLong(r5[4]), Long.parseLong(r5[5])));
    L10:
        r4 = r4 + 1;
        goto L3
    L11:
        Collections.sort(r0);
        return r0;
    }

    public static String a(List<a> r9, long r10) {
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        StringBuilder r0 = new StringBuilder();
        long r12 = (long) (r10 * 0.3f);
        LinkedList r2 = new LinkedList();
        Iterator r3 = r11.iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.aiagent.plugin");
        if ((r4.f9023e - r4.f9022d) < r12) goto L4;
        r2.add(r4);
        goto L4
    L8:
        Collections.sort(r2, new AnonymousClass1());
        if (r2.isEmpty() == true) goto L11;
    L13:
        Iterator r13 = r2.iterator();
        if (r13.hasNext() == false) goto L17;
        r0.append(((a) ZeusTransformUtils.preCheckCast(r13.next(), a.class, "com.obric.aiagent.plugin")).f9021c + "\n");
    L17:
        return r0.toString();
    L11:
        if (r11.isEmpty() == true) goto L13;
        r2.add((a) ZeusTransformUtils.preCheckCast(r11.get(0), a.class, "com.obric.aiagent.plugin"));
        goto L13
    }
}
