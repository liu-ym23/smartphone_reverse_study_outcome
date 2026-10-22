package g5;

import com.bytedance.apm.battery.config.BatteryFactorConfig;
import com.bytedanceos.common.toolbox.ServerElements;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static class a implements Comparator {
        public a() {
        }

        public int a(b r10, b r11) {
            return Long.compare(((long) (r11.f19941b + 1)) * (r11.f19944e - r11.f19943d), ((long) (r10.f19941b + 1)) * (r10.f19944e - r10.f19943d));
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((b) r10, (b) r11);
        }
    }

    public static class b implements Comparable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f19942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f19943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f19944e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f19945f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f19946g;

        public b(boolean r10, int r11, long r12, long r13, long r14, long r15) {
            this.f19940a = r10;
            this.f19941b = r11;
            this.f19942c = r12;
            this.f19943d = r13;
            this.f19944e = r14;
            this.f19945f = r15;
            this.f19946g = (r14 - r13) / BatteryFactorConfig.WIFI_BPS;
        }

        public int a(b r10) {
            long r11 = this.f19943d;
            long r12 = r10.f19943d;
            if (r11 <= r12) goto L7;
            return 1;
        L7:
            if (r11 != r12) goto L10;
            return 0;
        L10:
            return -1;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object r10) {
            return a((b) r10);
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append(this.f19941b);
            r10.append(",");
            if (this.f19940a == false) goto L5;
            String r11 = "sys";
        L6:
            r10.append(r11);
            r10.append(",");
            r10.append(this.f19942c);
            r10.append(",");
            r10.append(this.f19943d);
            r10.append(",");
            r10.append(this.f19944e);
            r10.append(",");
            r10.append(this.f19945f);
            return r10.toString();
        L5:
            r11 = ServerElements.APP;
            goto L6
        }
    }

    public static String a(List r10, long r11) {
        StringBuilder r12 = new StringBuilder();
        long r13 = (long) (r11 * 0.3f);
        LinkedList r14 = new LinkedList();
        Iterator r15 = r10.iterator();
    L4:
        if (r15.hasNext() == false) goto L8;
        b r16 = (b) r15.next();
        if ((r16.f19944e - r16.f19943d) < r13) goto L4;
        r14.add(r16);
        goto L4
    L8:
        Collections.sort(r14, new a());
        if (r14.isEmpty() == true) goto L11;
    L13:
        Iterator r17 = r14.iterator();
        if (r17.hasNext() == false) goto L17;
        r12.append(((b) r17.next()).f19942c + "\n");
    L17:
        return r12.toString();
    L11:
        if (r10.isEmpty() == true) goto L13;
        r14.add((b) r10.get(0));
        goto L13
    }

    public static String b(String r10) {
        if (r10 != null) goto L5;
        return null;
    L5:
        Iterator r11 = c(r10).iterator();
        StringBuilder r12 = new StringBuilder();
    L7:
        if (r11.hasNext() == false) goto L10;
        r12.append(((b) r11.next()).toString());
        r12.append('\n');
        goto L7
    L10:
        return r12.toString();
    }

    public static LinkedList c(String r19) {
        LinkedList r10 = new LinkedList();
        String[] r11 = r19.split("\n");
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L11;
        String[] r14 = r11[r13].split(",");
        if (r14 == null) goto L10;
        if (r14.length < 6) goto L10;
        r10.add(new b(r14[1].startsWith("sys"), Integer.parseInt(r14[0]), Long.parseLong(r14[2]), Long.parseLong(r14[3]), Long.parseLong(r14[4]), Long.parseLong(r14[5])));
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        Collections.sort(r10);
        return r10;
    }

    public static String d(String r10, StringBuilder r11, int r12, long r13) {
        LinkedList r14 = c(r10);
    L4:
        if (r14.size() <= r12) goto L11;
        long r15 = 21;
        Iterator r16 = r14.iterator();
    L7:
        if (r16.hasNext() == false) goto L4;
        if (((b) r16.next()).f19946g >= r15) goto L7;
        r16.remove();
        goto L7
    L11:
        Iterator r17 = r14.iterator();
    L13:
        if (r17.hasNext() == false) goto L16;
        r11.append(((b) r17.next()).toString());
        r11.append('\n');
        goto L13
    L16:
        if (r14.size() != 0) goto L20;
        return null;
    L20:
        return a(r14, r13);
    }
}
