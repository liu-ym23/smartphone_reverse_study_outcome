package androidx.constraintlayout.a.c;

import androidx.constraintlayout.a.c.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: HelperWidget.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends e implements i {
    public e[] ay;
    public int az;

    @Override // androidx.constraintlayout.a.c.i
    public void a(f r1) {
    }

    public j() {
        this.ay = new e[4];
        this.az = 0;
    }

    @Override // androidx.constraintlayout.a.c.i
    public void a(e r4) {
        if (r4 == this) goto L10;
        if (r4 == null) goto L11;
        int r0 = this.az + 1;
        e[] r1 = this.ay;
        if (r0 <= r1.length) goto L8;
        this.ay = (e[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r1, r1.length * 2), e[].class, "com.obric.aiagent.plugin");
    L8:
        e[] r2 = this.ay;
        int r3 = this.az;
        r2[r3] = r4;
        this.az = r3 + 1;
        return;
    L11:
        return;
    }

    @Override // androidx.constraintlayout.a.c.e
    public void a(e r6, HashMap<e, e> r7) {
        super.a(r6, r7);
        j r8 = (j) ZeusTransformUtils.preCheckCast(r6, j.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        this.az = 0;
        int r2 = r8.az;
    L3:
        if (r0 >= r2) goto L5;
        a((e) ZeusTransformUtils.preCheckCast(r7.get(r8.ay[r0]), e.class, "com.obric.aiagent.plugin"));
        r0 = r0 + 1;
        goto L3
    }

    @Override // androidx.constraintlayout.a.c.i
    public void a_() {
        this.az = 0;
        Arrays.fill(this.ay, null);
    }

    public void a(ArrayList<o> r4, int r5, o r6) {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r1 >= this.az) goto L7;
        r6.a(this.ay[r1]);
        r1 = r1 + 1;
    L7:
        if (r0 >= this.az) goto L9;
        androidx.constraintlayout.a.c.a.i.a(this.ay[r0], r5, r4, r6);
        r0 = r0 + 1;
        goto L7
    }

    public int L(int r5) {
        int r0 = 0;
    L4:
        if (r0 >= this.az) goto L18;
        e r1 = this.ay[r0];
        if (r5 != 0) goto L12;
        if (r1.aw == (-1)) goto L12;
        return r1.aw;
    L12:
        if (r5 != 1) goto L17;
        if (r1.ax == (-1)) goto L17;
        return r1.ax;
    L17:
        r0 = r0 + 1;
        goto L4
    L18:
        return -1;
    }
}
