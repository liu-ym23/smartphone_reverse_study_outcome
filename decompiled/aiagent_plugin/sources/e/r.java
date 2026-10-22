package e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: Options.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class r extends d.a.c<h> implements RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f38742b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h[] f38743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f38744d;

    /* JADX INFO: compiled from: Options.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public final r a(h... r18) {
            d.h.b.o.e(r18, "byteStrings");
            int r3 = 0;
            if (r18.length != 0) goto L5;
            boolean r1 = true;
        L6:
            d.h.b.h r4 = null;
            if (r1 == true) goto L9;
            List r2 = d.a.i.h(r18);
            d.a.p.d(r2);
            Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(r18.length), Collection.class, "com.obric.aiagent.plugin");
            int r6 = r18.length;
            int r7 = 0;
        L11:
            if (r7 >= r6) goto L13;
            h r8 = r18[r7];
            r5.add(-1);
            r7 = r7 + 1;
            goto L11
        L13:
            Integer[] r9 = (Integer[]) ZeusTransformUtils.preCheckCast(((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin")).toArray(new Integer[0]), Integer[].class, "com.obric.aiagent.plugin");
            List r13 = d.a.p.c(Arrays.copyOf(r9, r9.length));
            int r11 = r18.length;
            int r12 = 0;
            int r14 = 0;
        L14:
            if (r12 >= r11) goto L17;
            r13.set(d.a.p.a(r2, (Comparable) ZeusTransformUtils.preCheckCast(r18[r12], Comparable.class, "com.obric.aiagent.plugin"), 0, 0, 6, null), Integer.valueOf(r14));
            r12 = r12 + 1;
            r14 = r14 + 1;
            goto L14
        L17:
            if (((h) ZeusTransformUtils.preCheckCast(r2.get(0), h.class, "com.obric.aiagent.plugin")).k() <= 0) goto L19;
            boolean r10 = true;
        L20:
            if (r10 == false) goto L48;
            int r15 = 0;
        L23:
            if (r15 >= r2.size()) goto L41;
            h r16 = (h) ZeusTransformUtils.preCheckCast(r2.get(r15), h.class, "com.obric.aiagent.plugin");
            int r17 = r15 + 1;
            int r19 = r17;
        L26:
            if (r19 >= r2.size()) goto L40;
            h r20 = (h) ZeusTransformUtils.preCheckCast(r2.get(r19), h.class, "com.obric.aiagent.plugin");
            if (r20.a(r16) == false) goto L40;
            if (r20.k() == r16.k()) goto L32;
            boolean r110 = true;
        L33:
            if (r110 == false) goto L39;
            if (((Number) ZeusTransformUtils.preCheckCast(r13.get(r19), Number.class, "com.obric.aiagent.plugin")).intValue() > ((Number) ZeusTransformUtils.preCheckCast(r13.get(r15), Number.class, "com.obric.aiagent.plugin")).intValue()) goto L36;
            r19 = r19 + 1;
            goto L26
        L36:
            r2.remove(r19);
            r13.remove(r19);
            goto L26
        L39:
            throw new IllegalArgumentException(("duplicate option: " + r20).toString());
        L32:
            r110 = false;
        L40:
            r15 = r17;
            goto L23
        L41:
            e r21 = new e();
            a(this, 0, r21, 0, r2, 0, 0, r13, 53, null);
            int[] r22 = new int[(int) a(r21)];
        L43:
            if (r21.h() == true) goto L45;
            r22[r3] = r21.m();
            r3 = r3 + 1;
            goto L43
        L45:
            Object[] r0 = Arrays.copyOf(r18, r18.length);
            d.h.b.o.c(r0, "copyOf(this, size)");
            return new r((h[]) ZeusTransformUtils.preCheckCast(r0, h[].class, "com.obric.aiagent.plugin"), r22, r4);
        L48:
            throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
        L19:
            r10 = false;
            goto L20
        L9:
            return new r(new h[0], new int[]{0, -1}, r4);
        L5:
            r1 = false;
            goto L6
        }

        static /* synthetic */ void a(a r11, long r12, e r14, int r15, List r16, int r17, int r18, List r19, int r20, Object r21) {
            List<? extends h> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r16, List.class, "com.obric.aiagent.plugin");
            List<Integer> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
            if ((r20 & 1) == 0) goto L5;
            long r3 = 0;
        L7:
            if ((r20 & 4) == 0) goto L9;
            int r6 = 0;
        L11:
            if ((r20 & 16) == 0) goto L13;
            int r8 = 0;
        L15:
            if ((r20 & 32) == 0) goto L17;
            int r9 = r7.size();
        L18:
            r11.a(r3, r14, r6, r7, r8, r9, r10);
            return;
        L17:
            r9 = r18;
            goto L18
        L13:
            r8 = r17;
            goto L15
        L9:
            r6 = r15;
            goto L11
        L5:
            r3 = r12;
            goto L7
        }

        private final void a(long r21, e r23, int r24, List<? extends h> r25, int r26, int r27, List<Integer> r28) {
            int r11 = r24;
            List<? extends h> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin");
            List<Integer> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.aiagent.plugin");
            if (r26 >= r27) goto L5;
            boolean r3 = true;
        L7:
            if (r3 == false) goto L75;
            int r4 = r26;
        L9:
            if (r4 >= r27) goto L18;
            if (((h) ZeusTransformUtils.preCheckCast(r14.get(r4), h.class, "com.obric.aiagent.plugin")).k() < r11) goto L13;
            boolean r5 = true;
        L14:
            if (r5 == false) goto L17;
            r4 = r4 + 1;
            goto L9
        L17:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L13:
            r5 = false;
            goto L14
        L18:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r14.get(r26), h.class, "com.obric.aiagent.plugin");
            h r7 = (h) ZeusTransformUtils.preCheckCast(r14.get(r27 - 1), h.class, "com.obric.aiagent.plugin");
            if (r11 != r6.k()) goto L21;
            int r8 = ((Number) ZeusTransformUtils.preCheckCast(r15.get(r26), Number.class, "com.obric.aiagent.plugin")).intValue();
            int r0 = r26 + 1;
            h r9 = (h) ZeusTransformUtils.preCheckCast(r14.get(r0), h.class, "com.obric.aiagent.plugin");
            int r10 = r0;
            int r1 = r8;
            r6 = r9;
        L23:
            if (r6.c(r11) == r7.c(r11)) goto L54;
            int r2 = r10 + 1;
            int r12 = 1;
        L25:
            if (r2 >= r27) goto L30;
            if (((h) ZeusTransformUtils.preCheckCast(r14.get(r2 - 1), h.class, "com.obric.aiagent.plugin")).c(r11) == ((h) ZeusTransformUtils.preCheckCast(r14.get(r2), h.class, "com.obric.aiagent.plugin")).c(r11)) goto L29;
            r12 = r12 + 1;
        L29:
            r2 = r2 + 1;
            goto L25
        L30:
            long r17 = ((r21 + a(r23)) + ((long) 2)) + ((long) (r12 * 2));
            r23.d(r12);
            r23.d(r1);
            int r13 = r10;
        L31:
            if (r13 >= r27) goto L38;
            byte r16 = ((h) ZeusTransformUtils.preCheckCast(r14.get(r13), h.class, "com.obric.aiagent.plugin")).c(r11);
            if (r13 != r10) goto L35;
        L36:
            r23.d(r16 & 255);
        L37:
            r13 = r13 + 1;
            goto L31
        L35:
            if (r16 == ((h) ZeusTransformUtils.preCheckCast(r14.get(r13 - 1), h.class, "com.obric.aiagent.plugin")).c(r11)) goto L37;
        L38:
            e r18 = new e();
        L39:
            if (r10 >= r27) goto L53;
            byte r19 = ((h) ZeusTransformUtils.preCheckCast(r14.get(r10), h.class, "com.obric.aiagent.plugin")).c(r11);
            int r20 = r10 + 1;
            int r22 = r20;
        L41:
            if (r22 >= r27) goto L46;
            if (r19 != ((h) ZeusTransformUtils.preCheckCast(r14.get(r22), h.class, "com.obric.aiagent.plugin")).c(r11)) goto L44;
            r22 = r22 + 1;
            goto L41
        L44:
            int r29 = r22;
        L47:
            if (r20 == r29) goto L49;
        L51:
            r23.d(((int) (r17 + a(r18))) * (-1));
            a(r17, r18, r11 + 1, r14, r10, r29, r15);
        L52:
            r18 = r18;
            r10 = r29;
            r14 = r14;
            goto L39
        L49:
            if ((r11 + 1) != ((h) ZeusTransformUtils.preCheckCast(r14.get(r10), h.class, "com.obric.aiagent.plugin")).k()) goto L51;
            r23.d(((Number) ZeusTransformUtils.preCheckCast(r15.get(r10), Number.class, "com.obric.aiagent.plugin")).intValue());
            goto L52
        L46:
            r29 = r27;
            goto L47
        L53:
            r23.a((aa) ZeusTransformUtils.preCheckCast(r18, aa.class, "com.obric.aiagent.plugin"));
            return;
        L54:
            int r30 = Math.min(r6.k(), r7.k());
            int r31 = r11;
            int r110 = 0;
        L55:
            if (r31 >= r30) goto L59;
            if (r6.c(r31) != r7.c(r31)) goto L59;
            r110 = r110 + 1;
            r31 = r31 + 1;
        L59:
            long r32 = (((r21 + a(r23)) + ((long) 2)) + ((long) r110)) + 1;
            r23.d(-r110);
            r23.d(r1);
            int r33 = r11 + r110;
        L60:
            if (r11 >= r33) goto L63;
            r23.d(r6.c(r11) & 255);
            r11 = r11 + 1;
            goto L60
        L63:
            if ((r10 + 1) == r27) goto L65;
            e r111 = new e();
            r23.d(((int) (a(r111) + r32)) * (-1));
            a(r32, r111, r33, r14, r10, r27, r15);
            r23.a((aa) ZeusTransformUtils.preCheckCast(r111, aa.class, "com.obric.aiagent.plugin"));
            return;
        L65:
            if (r33 != ((h) ZeusTransformUtils.preCheckCast(r14.get(r10), h.class, "com.obric.aiagent.plugin")).k()) goto L67;
            boolean r34 = true;
        L68:
            if (r34 == false) goto L71;
            r23.d(((Number) ZeusTransformUtils.preCheckCast(r15.get(r10), Number.class, "com.obric.aiagent.plugin")).intValue());
            return;
        L71:
            throw new IllegalStateException("Check failed.".toString());
        L67:
            r34 = false;
            goto L68
        L21:
            r10 = r26;
            r1 = -1;
            goto L23
        L75:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L5:
            r3 = false;
            goto L7
        }

        private final long a(e r3) {
            return r3.b() / ((long) 4);
        }
    }

    static {
        f38742b = new a(null);
    }

    public /* synthetic */ r(h[] r1, int[] r2, d.h.b.h r3) {
        this(r1, r2);
    }

    public boolean a(h r1) {
        return super.contains(r1);
    }

    public int b(h r1) {
        return super.indexOf(r1);
    }

    public int c(h r1) {
        return super.lastIndexOf(r1);
    }

    @Override // d.a.a, java.util.Collection
    public final boolean contains(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, h.class) == true) goto L7;
        return false;
    L7:
        return a((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.a.c, java.util.List
    public /* synthetic */ Object get(int r1) {
        return a(r1);
    }

    @Override // d.a.c, java.util.List
    public final int indexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, h.class) == true) goto L7;
        return -1;
    L7:
        return b((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.a.c, java.util.List
    public final int lastIndexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, h.class) == true) goto L7;
        return -1;
    L7:
        return c((h) ZeusTransformUtils.preCheckCast(r3, h.class, "com.obric.aiagent.plugin"));
    }

    public final h[] b() {
        return this.f38743c;
    }

    public final int[] c() {
        return this.f38744d;
    }

    private r(h[] r1, int[] r2) {
        this.f38743c = r1;
        this.f38744d = r2;
    }

    @Override // d.a.a
    public int a() {
        return this.f38743c.length;
    }

    public h a(int r1) {
        return this.f38743c[r1];
    }
}
