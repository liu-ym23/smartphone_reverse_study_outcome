package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class DiffUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator f4059a = null;

    public static class DiffResult {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f4060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f4061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f4062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final b f4063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f4064e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f4065f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f4066g;

        public DiffResult(b r10, List r11, int[] r12, int[] r13, boolean r14) {
            this.f4060a = r11;
            this.f4061b = r12;
            this.f4062c = r13;
            Arrays.fill(r12, 0);
            Arrays.fill(r13, 0);
            this.f4063d = r10;
            this.f4064e = r10.getOldListSize();
            this.f4065f = r10.getNewListSize();
            this.f4066g = r14;
            a();
            d();
        }

        public static e f(Collection r10, int r11, boolean r12) {
            Iterator r13 = r10.iterator();
        L4:
            if (r13.hasNext() == false) goto L10;
            e r14 = (e) r13.next();
            if (r14.f4072a != r11) goto L4;
            if (r14.f4074c != r12) goto L4;
            r13.remove();
        L12:
            if (r13.hasNext() == false) goto L17;
            e r15 = (e) r13.next();
            if (r12 == true) goto L15;
            r15.f4073b++;
            goto L12
        L15:
            r15.f4073b--;
            goto L12
        L17:
            return r14;
        L10:
            r14 = null;
            goto L12
        }

        public final void a() {
            if (this.f4060a.isEmpty() == false) goto L5;
            d r10 = null;
        L6:
            if (r10 != null) goto L8;
        L11:
            this.f4060a.add(0, new d(0, 0, 0));
        L12:
            this.f4060a.add(new d(this.f4064e, this.f4065f, 0));
            return;
        L8:
            if (r10.f4069a != 0) goto L11;
            if (r10.f4070b == 0) goto L12;
        L5:
            r10 = (d) this.f4060a.get(0);
            goto L6
        }

        public void b(ListUpdateCallback r13) {
            if ((r13 instanceof androidx.recyclerview.widget.c) == false) goto L5;
            androidx.recyclerview.widget.c r14 = (androidx.recyclerview.widget.c) r13;
        L6:
            int r10 = this.f4064e;
            ArrayDeque r11 = new ArrayDeque();
            int r12 = this.f4064e;
            int r15 = this.f4065f;
            int r16 = this.f4060a.size() - 1;
        L7:
            if (r16 < 0) goto L38;
            d r17 = (d) this.f4060a.get(r16);
            int r18 = r17.a();
            int r19 = r17.b();
        L9:
            int r20 = 0;
            if (r12 <= r18) goto L20;
            r12 = r12 - 1;
            int r110 = this.f4061b[r12];
            if ((r110 & 12) != 0) goto L13;
            r14.onRemoved(r12, 1);
            r10 = r10 - 1;
            goto L9
        L13:
            int r111 = r110 >> 4;
            e r21 = f(r11, r111, false);
            if (r21 != null) goto L15;
            r11.add(new e(r12, (r10 - r12) - 1, true));
            goto L9
        L15:
            int r22 = (r10 - r21.f4073b) - 1;
            r14.onMoved(r12, r22);
            if ((r110 & 4) == 0) goto L9;
            r14.onChanged(r22, 1, this.f4063d.getChangePayload(r12, r111));
        L20:
            if (r15 <= r19) goto L30;
            r15 = r15 - 1;
            int r23 = this.f4062c[r15];
            if ((r23 & 12) != 0) goto L23;
            r14.onInserted(r12, 1);
            r10 = r10 + 1;
            goto L20
        L23:
            int r112 = r23 >> 4;
            e r113 = f(r11, r112, true);
            if (r113 == null) goto L25;
            r14.onMoved((r10 - r113.f4073b) - 1, r12);
            if ((r23 & 4) == 0) goto L20;
            r14.onChanged(r12, 1, this.f4063d.getChangePayload(r112, r15));
            goto L20
        L25:
            r11.add(new e(r15, r10 - r12, false));
            goto L20
        L30:
            int r24 = r17.f4069a;
            int r25 = r17.f4070b;
        L32:
            if (r20 >= r17.f4071c) goto L37;
            if ((this.f4061b[r24] & 15) != 2) goto L36;
            r14.onChanged(r24, 1, this.f4063d.getChangePayload(r24, r25));
        L36:
            r24 = r24 + 1;
            r25 = r25 + 1;
            r20 = r20 + 1;
            goto L32
        L37:
            r12 = r17.f4069a;
            r15 = r17.f4070b;
            r16 = r16 - 1;
            goto L7
        L38:
            r14.a();
            return;
        L5:
            r14 = new androidx.recyclerview.widget.c(r13);
            goto L6
        }

        public final void c(int r10) {
            int r11 = this.f4060a.size();
            int r12 = 0;
            int r13 = 0;
        L3:
            if (r12 >= r11) goto L19;
            d r14 = (d) this.f4060a.get(r12);
        L6:
            if (r13 >= r14.f4070b) goto L18;
            if (this.f4062c[r13] != 0) goto L17;
            if (this.f4063d.areItemsTheSame(r10, r13) == false) goto L17;
            if (this.f4063d.areContentsTheSame(r10, r13) == false) goto L14;
            int r15 = 8;
        L15:
            this.f4061b[r10] = (r13 << 4) | r15;
            this.f4062c[r13] = (r10 << 4) | r15;
            return;
        L14:
            r15 = 4;
        L17:
            r13 = r13 + 1;
            goto L6
        L18:
            r13 = r14.b();
            r12 = r12 + 1;
            goto L3
        }

        public final void d() {
            Iterator r10 = this.f4060a.iterator();
        L4:
            if (r10.hasNext() == false) goto L14;
            d r11 = (d) r10.next();
            int r12 = 0;
        L7:
            if (r12 >= r11.f4071c) goto L4;
            int r13 = r11.f4069a + r12;
            int r14 = r11.f4070b + r12;
            if (this.f4063d.areContentsTheSame(r13, r14) == false) goto L11;
            int r15 = 1;
        L12:
            this.f4061b[r13] = (r14 << 4) | r15;
            this.f4062c[r14] = (r13 << 4) | r15;
            r12 = r12 + 1;
            goto L7
        L11:
            r15 = 2;
            goto L12
        L14:
            if (this.f4066g == false) goto L21;
            e();
            return;
        }

        public final void e() {
            Iterator r10 = this.f4060a.iterator();
            int r11 = 0;
        L4:
            if (r10.hasNext() == false) goto L13;
            d r12 = (d) r10.next();
        L7:
            if (r11 >= r12.f4069a) goto L12;
            if (this.f4061b[r11] != 0) goto L11;
            c(r11);
        L11:
            r11 = r11 + 1;
            goto L7
        L12:
            r11 = r12.a();
            goto L4
        }
    }

    public static abstract class ItemCallback {
        public ItemCallback() {
        }

        public abstract boolean areContentsTheSame(Object r10, Object r11);

        public abstract boolean areItemsTheSame(Object r10, Object r11);

        @Nullable
        public Object getChangePayload(@NonNull Object r10, @NonNull Object r11) {
            return null;
        }
    }

    public class a implements Comparator {
        public a() {
        }

        public int a(d r10, d r11) {
            return r10.f4069a - r11.f4069a;
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((d) r10, (d) r11);
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract boolean areContentsTheSame(int r10, int r11);

        public abstract boolean areItemsTheSame(int r10, int r11);

        public abstract Object getChangePayload(int r10, int r11);

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f4067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4068b;

        public c(int r10) {
            int[] r11 = new int[r10];
            this.f4067a = r11;
            this.f4068b = r11.length / 2;
        }

        public int[] a() {
            return this.f4067a;
        }

        public int b(int r10) {
            return this.f4067a[r10 + this.f4068b];
        }

        public void c(int r10, int r11) {
            this.f4067a[r10 + this.f4068b] = r11;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f4069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4070b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4071c;

        public d(int r10, int r11, int r12) {
            this.f4069a = r10;
            this.f4070b = r11;
            this.f4071c = r12;
        }

        public int a() {
            return this.f4069a + this.f4071c;
        }

        public int b() {
            return this.f4070b + this.f4071c;
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f4074c;

        public e(int r10, int r11, boolean r12) {
            this.f4072a = r10;
            this.f4073b = r11;
            this.f4074c = r12;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4077c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4078d;

        public f() {
        }

        public int a() {
            return this.f4078d - this.f4077c;
        }

        public int b() {
            return this.f4076b - this.f4075a;
        }

        public f(int r10, int r11, int r12, int r13) {
            this.f4075a = r10;
            this.f4076b = r11;
            this.f4077c = r12;
            this.f4078d = r13;
        }
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4079a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f4080b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4081c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4082d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4083e;

        public g() {
        }

        public int a() {
            return Math.min(this.f4081c - this.f4079a, this.f4082d - this.f4080b);
        }

        public boolean b() {
            if ((this.f4082d - this.f4080b) == (this.f4081c - this.f4079a)) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean c() {
            if ((this.f4082d - this.f4080b) <= (this.f4081c - this.f4079a)) goto L5;
            return true;
        L5:
            return false;
        }

        public d d() {
            if (b() == true) goto L5;
            int r10 = this.f4079a;
            return new d(r10, this.f4080b, this.f4081c - r10);
        L5:
            if (this.f4083e == false) goto L9;
            return new d(this.f4079a, this.f4080b, a());
        L9:
            if (c() == false) goto L13;
            return new d(this.f4079a, this.f4080b + 1, a());
        L13:
            return new d(this.f4079a + 1, this.f4080b, a());
        }
    }

    static {
        f4059a = new a();
    }

    public static g a(f r11, b r12, c r13, c r14, int r15) {
        if (((r11.b() - r11.a()) % 2) != 0) goto L5;
        boolean r10 = true;
    L6:
        int r16 = r11.b() - r11.a();
        int r17 = -r15;
        int r18 = r17;
    L7:
        if (r18 > r15) goto L38;
        if (r18 == r17) goto L14;
        if (r18 != r15) goto L11;
    L13:
        int r19 = r14.b(r18 - 1);
        int r20 = r19 - 1;
    L15:
        int r21 = r11.f4078d - ((r11.f4076b - r20) - r18);
        if (r15 == 0) goto L20;
        if (r20 != r19) goto L20;
        int r22 = r21 + 1;
    L22:
        if (r20 <= r11.f4075a) goto L28;
        if (r21 <= r11.f4077c) goto L28;
        if (r12.areItemsTheSame(r20 - 1, r21 - 1) == false) goto L28;
        r20 = r20 - 1;
        r21 = r21 - 1;
    L28:
        r14.c(r18, r20);
        if (r10 == false) goto L37;
        int r23 = r16 - r18;
        if (r23 < r17) goto L37;
        if (r23 > r15) goto L37;
        if (r13.b(r23) < r20) goto L37;
        g r110 = new g();
        r110.f4079a = r20;
        r110.f4080b = r21;
        r110.f4081c = r19;
        r110.f4082d = r22;
        r110.f4083e = true;
        return r110;
    L37:
        r18 = r18 + 2;
    L20:
        r22 = r21;
        goto L22
    L11:
        if (r14.b(r18 + 1) >= r14.b(r18 - 1)) goto L13;
    L14:
        r19 = r14.b(r18 + 1);
        r20 = r19;
        goto L15
    L38:
        return null;
    L5:
        r10 = false;
        goto L6
    }

    public static DiffResult b(b r10) {
        return c(r10, true);
    }

    public static DiffResult c(b r10, boolean r11) {
        int r12 = r10.getOldListSize();
        int r13 = r10.getNewListSize();
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        r15.add(new f(0, r12, 0, r13));
        int r16 = ((((r12 + r13) + 1) / 2) * 2) + 1;
        c r17 = new c(r16);
        c r18 = new c(r16);
        ArrayList r19 = new ArrayList();
    L4:
        if (r15.isEmpty() == true) goto L16;
        f r20 = (f) r15.remove(r15.size() - 1);
        g r21 = e(r20, r10, r17, r18);
        if (r21 != null) goto L8;
        r19.add(r20);
        goto L4
    L8:
        if (r21.a() <= 0) goto L11;
        r14.add(r21.d());
    L11:
        if (r19.isEmpty() == false) goto L13;
        f r22 = new f();
    L14:
        r22.f4075a = r20.f4075a;
        r22.f4077c = r20.f4077c;
        r22.f4076b = r21.f4079a;
        r22.f4078d = r21.f4080b;
        r15.add(r22);
        r20.f4076b = r20.f4076b;
        r20.f4078d = r20.f4078d;
        r20.f4075a = r21.f4081c;
        r20.f4077c = r21.f4082d;
        r15.add(r20);
        goto L4
    L13:
        r22 = (f) r19.remove(r19.size() - 1);
        goto L14
    L16:
        Collections.sort(r14, f4059a);
        return new DiffResult(r10, r14, r17.a(), r18.a(), r11);
    }

    public static g d(f r11, b r12, c r13, c r14, int r15) {
        boolean r10 = true;
        if ((Math.abs(r11.b() - r11.a()) % 2) == 1) goto L6;
        r10 = false;
    L6:
        int r16 = r11.b() - r11.a();
        int r17 = -r15;
        int r18 = r17;
    L7:
        if (r18 > r15) goto L39;
        if (r18 == r17) goto L14;
        if (r18 != r15) goto L11;
    L13:
        int r19 = r13.b(r18 - 1);
        int r20 = r19 + 1;
    L15:
        int r21 = (r11.f4077c + (r20 - r11.f4075a)) - r18;
        if (r15 == 0) goto L20;
        if (r20 != r19) goto L20;
        int r22 = r21 - 1;
    L22:
        if (r20 >= r11.f4076b) goto L28;
        if (r21 >= r11.f4078d) goto L28;
        if (r12.areItemsTheSame(r20, r21) == false) goto L28;
        r20 = r20 + 1;
        r21 = r21 + 1;
    L28:
        r13.c(r18, r20);
        if (r10 == false) goto L38;
        int r23 = r16 - r18;
        if (r23 < (r17 + 1)) goto L38;
        if (r23 > (r15 - 1)) goto L38;
        if (r14.b(r23) > r20) goto L38;
        g r110 = new g();
        r110.f4079a = r19;
        r110.f4080b = r22;
        r110.f4081c = r20;
        r110.f4082d = r21;
        r110.f4083e = false;
        return r110;
    L38:
        r18 = r18 + 2;
    L20:
        r22 = r21;
        goto L22
    L11:
        if (r13.b(r18 + 1) <= r13.b(r18 - 1)) goto L13;
    L14:
        r19 = r13.b(r18 + 1);
        r20 = r19;
        goto L15
    L39:
        return null;
    }

    public static g e(f r10, b r11, c r12, c r13) {
        if (r10.b() >= 1) goto L5;
    L16:
        return null;
    L5:
        if (r10.a() < 1) goto L16;
        int r14 = ((r10.b() + r10.a()) + 1) / 2;
        r12.c(1, r10.f4075a);
        r13.c(1, r10.f4076b);
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L16;
        g r16 = d(r10, r11, r12, r13, r15);
        if (r16 != null) goto L11;
        g r17 = a(r10, r11, r12, r13, r15);
        if (r17 != null) goto L14;
        r15 = r15 + 1;
        goto L8
    L14:
        return r17;
    L11:
        return r16;
    }
}
