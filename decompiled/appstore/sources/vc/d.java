package vc;

import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f25159a;

    public d() {
        this.f25159a = new HashMap();
    }

    public float a(Object r10, String r11, int r12) {
        if (this.f25159a.containsKey(r10) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap r13 = (HashMap) this.f25159a.get(r10);
        if (r13 != null) goto L8;
    L17:
        return Float.NaN;
    L8:
        if (r13.containsKey(r11) == false) goto L17;
        float[] r14 = (float[]) r13.get(r11);
        if (r14 != null) goto L14;
        return Float.NaN;
    L14:
        if (r14.length <= r12) goto L17;
        return r14[r12];
    }

    public void b(Object r10, String r11, int r12, float r13) {
        if (this.f25159a.containsKey(r10) == true) goto L5;
        HashMap r14 = new HashMap();
        float[] r15 = new float[r12 + 1];
        r15[r12] = r13;
        r14.put(r11, r15);
        this.f25159a.put(r10, r14);
        return;
    L5:
        HashMap r16 = (HashMap) this.f25159a.get(r10);
        if (r16 != null) goto L9;
        r16 = new HashMap();
    L9:
        if (r16.containsKey(r11) == true) goto L11;
        float[] r17 = new float[r12 + 1];
        r17[r12] = r13;
        r16.put(r11, r17);
        this.f25159a.put(r10, r16);
        return;
    L11:
        float[] r18 = (float[]) r16.get(r11);
        if (r18 != null) goto L15;
        r18 = new float[0];
    L15:
        if (r18.length > r12) goto L17;
        r18 = Arrays.copyOf(r18, r12 + 1);
    L17:
        r18[r12] = r13;
        r16.put(r11, r18);
    }
}
