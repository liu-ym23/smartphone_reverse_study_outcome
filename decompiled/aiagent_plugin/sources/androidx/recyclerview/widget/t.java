package androidx.recyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: OpReorderer.java */
/* JADX INFO: loaded from: classes.dex */
class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a f2582a;

    /* JADX INFO: compiled from: OpReorderer.java */
    interface a {
        androidx.recyclerview.widget.a.b a(int r1, int r2, int r3, Object r4);

        void a(androidx.recyclerview.widget.a.b r1);
    }

    t(a r3) {
        this.f2582a = (a) ZeusTransformUtils.wrapperContextForParams(r3, a.class, "com.obric.aiagent.plugin");
    }

    void a(List<androidx.recyclerview.widget.a.b> r3) {
        List<androidx.recyclerview.widget.a.b> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    L3:
        int r0 = b(r4);
        if (r0 == (-1)) goto L6;
        a(r4, r0, r0 + 1);
        goto L3
    }

    private void a(List<androidx.recyclerview.widget.a.b> r9, int r10, int r11) {
        List<androidx.recyclerview.widget.a.b> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        androidx.recyclerview.widget.a.b r5 = (androidx.recyclerview.widget.a.b) ZeusTransformUtils.preCheckCast(r3.get(r10), androidx.recyclerview.widget.a.b.class, "com.obric.aiagent.plugin");
        androidx.recyclerview.widget.a.b r7 = (androidx.recyclerview.widget.a.b) ZeusTransformUtils.preCheckCast(r3.get(r11), androidx.recyclerview.widget.a.b.class, "com.obric.aiagent.plugin");
        int r12 = r7.f2418a;
        if (r12 != 1) goto L5;
        c(r3, r10, r5, r11, r7);
        return;
    L5:
        if (r12 != 2) goto L7;
        a(r3, r10, r5, r11, r7);
        return;
    L7:
        if (r12 != 4) goto L15;
        b(r3, r10, r5, r11, r7);
        return;
    }

    void a(List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        List r14 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        boolean r2 = false;
        if (r11.f2419b >= r11.f2421d) goto L11;
        if (r13.f2419b == r11.f2419b) goto L7;
    L9:
        boolean r0 = false;
    L17:
        if (r11.f2421d >= r13.f2419b) goto L20;
        r13.f2419b--;
    L25:
        androidx.recyclerview.widget.a.b r6 = null;
        if (r11.f2419b > r13.f2419b) goto L29;
        r13.f2419b++;
    L31:
        if (r2 == false) goto L34;
        r14.set(r10, r13);
        r14.remove(r12);
        this.f2582a.a(r11);
        return;
    L34:
        if (r0 == false) goto L48;
        if (r6 == null) goto L43;
        if (r11.f2419b <= r6.f2419b) goto L40;
        r11.f2419b -= r6.f2421d;
    L40:
        if (r11.f2421d <= r6.f2419b) goto L43;
        r11.f2421d -= r6.f2421d;
    L43:
        if (r11.f2419b <= r13.f2419b) goto L46;
        r11.f2419b -= r13.f2421d;
    L46:
        if (r11.f2421d <= r13.f2419b) goto L61;
        r11.f2421d -= r13.f2421d;
    L61:
        r14.set(r10, r13);
        if (r11.f2419b == r11.f2421d) goto L64;
        r14.set(r12, r11);
    L65:
        if (r6 == null) goto L69;
        r14.add(r10, r6);
        return;
    L69:
        return;
    L64:
        r14.remove(r12);
        goto L65
    L48:
        if (r6 == null) goto L56;
        if (r11.f2419b < r6.f2419b) goto L53;
        r11.f2419b -= r6.f2421d;
    L53:
        if (r11.f2421d < r6.f2419b) goto L56;
        r11.f2421d -= r6.f2421d;
    L56:
        if (r11.f2419b < r13.f2419b) goto L59;
        r11.f2419b -= r13.f2421d;
    L59:
        if (r11.f2421d < r13.f2419b) goto L61;
        r11.f2421d -= r13.f2421d;
        goto L61
    L29:
        if (r11.f2419b >= (r13.f2419b + r13.f2421d)) goto L31;
        r6 = this.f2582a.a(2, r11.f2419b + 1, (r13.f2419b + r13.f2421d) - r11.f2419b, null);
        r13.f2421d = r11.f2419b - r13.f2419b;
        goto L31
    L20:
        if (r11.f2421d >= (r13.f2419b + r13.f2421d)) goto L25;
        r13.f2421d--;
        r11.f2418a = 2;
        r11.f2421d = 1;
        if (r13.f2421d != 0) goto L68;
        r14.remove(r12);
        this.f2582a.a(r13);
        return;
    L68:
        return;
    L7:
        if (r13.f2421d != (r11.f2421d - r11.f2419b)) goto L9;
        r0 = false;
        r2 = true;
        goto L17
    L11:
        if (r13.f2419b == (r11.f2421d + 1)) goto L13;
    L15:
        r0 = true;
        goto L17
    L13:
        if (r13.f2421d != (r11.f2419b - r11.f2421d)) goto L15;
        r0 = true;
        r2 = true;
        goto L17
    }

    private void c(List<androidx.recyclerview.widget.a.b> r3, int r4, androidx.recyclerview.widget.a.b r5, int r6, androidx.recyclerview.widget.a.b r7) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        if (r5.f2421d >= r7.f2419b) goto L5;
        int r8 = -1;
    L7:
        if (r5.f2419b >= r7.f2419b) goto L10;
        r8 = r8 + 1;
    L10:
        if (r7.f2419b > r5.f2419b) goto L13;
        r5.f2419b += r7.f2421d;
    L13:
        if (r7.f2419b > r5.f2421d) goto L15;
        r5.f2421d += r7.f2421d;
    L15:
        r7.f2419b += r8;
        r2.set(r4, r7);
        r2.set(r6, r5);
        return;
    L5:
        r8 = 0;
        goto L7
    }

    void b(List<androidx.recyclerview.widget.a.b> r8, int r9, androidx.recyclerview.widget.a.b r10, int r11, androidx.recyclerview.widget.a.b r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        androidx.recyclerview.widget.a.b r3 = null;
        if (r10.f2421d >= r12.f2419b) goto L6;
        r12.f2419b--;
    L8:
        androidx.recyclerview.widget.a.b r0 = null;
    L10:
        if (r10.f2419b > r12.f2419b) goto L13;
        r12.f2419b++;
    L15:
        r13.set(r11, r10);
        if (r12.f2421d <= 0) goto L18;
        r13.set(r9, r12);
    L19:
        if (r0 == null) goto L21;
        r13.add(r9, r0);
    L21:
        if (r3 == null) goto L24;
        r13.add(r9, r3);
        return;
    L24:
        return;
    L18:
        r13.remove(r9);
        this.f2582a.a(r12);
        goto L19
    L13:
        if (r10.f2419b >= (r12.f2419b + r12.f2421d)) goto L15;
        int r1 = (r12.f2419b + r12.f2421d) - r10.f2419b;
        r3 = this.f2582a.a(4, r10.f2419b + 1, r1, r12.f2420c);
        r12.f2421d -= r1;
        goto L15
    L6:
        if (r10.f2421d >= (r12.f2419b + r12.f2421d)) goto L8;
        r12.f2421d--;
        r0 = this.f2582a.a(4, r10.f2419b, 1, r12.f2420c);
        goto L10
    }

    private int b(List<androidx.recyclerview.widget.a.b> r6) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r7 = r5.size() - 1;
        boolean r2 = false;
    L3:
        if (r7 < 0) goto L10;
        if (((androidx.recyclerview.widget.a.b) ZeusTransformUtils.preCheckCast(r5.get(r7), androidx.recyclerview.widget.a.b.class, "com.obric.aiagent.plugin")).f2418a != 8) goto L8;
        if (r2 == false) goto L9;
        return r7;
    L9:
        r7 = r7 - 1;
        goto L3
    L8:
        r2 = true;
        goto L9
    L10:
        return -1;
    }
}
