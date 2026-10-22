package androidx.constraintlayout.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: KeyCache.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    HashMap<Object, HashMap<String, float[]>> f619a;

    public d() {
        this.f619a = new HashMap();
    }

    public void a(Object r4, String r5, int r6, float r7) {
        if (this.f619a.containsKey(r4) == true) goto L5;
        HashMap<String, float[]> r0 = new HashMap();
        float[] r1 = new float[r6 + 1];
        r1[r6] = r7;
        r0.put(r5, r1);
        this.f619a.put(r4, r0);
        return;
    L5:
        HashMap<String, float[]> r2 = (HashMap) ZeusTransformUtils.preCheckCast(this.f619a.get(r4), HashMap.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L9;
        r2 = new HashMap();
    L9:
        if (r2.containsKey(r5) == true) goto L11;
        float[] r3 = new float[r6 + 1];
        r3[r6] = r7;
        r2.put(r5, r3);
        this.f619a.put(r4, r2);
        return;
    L11:
        float[] r8 = (float[]) ZeusTransformUtils.preCheckCast(r2.get(r5), float[].class, "com.obric.aiagent.plugin");
        if (r8 != null) goto L15;
        r8 = new float[0];
    L15:
        if (r8.length > r6) goto L17;
        r8 = Arrays.copyOf(r8, r6 + 1);
    L17:
        r8[r6] = r7;
        r2.put(r5, r8);
    }

    public float a(Object r3, String r4, int r5) {
        if (this.f619a.containsKey(r3) == true) goto L5;
        return Float.NaN;
    L5:
        HashMap r2 = (HashMap) ZeusTransformUtils.preCheckCast(this.f619a.get(r3), HashMap.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
    L17:
        return Float.NaN;
    L8:
        if (r2.containsKey(r4) == false) goto L17;
        float[] r6 = (float[]) ZeusTransformUtils.preCheckCast(r2.get(r4), float[].class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L14;
        return Float.NaN;
    L14:
        if (r6.length <= r5) goto L17;
        return r6[r5];
    }
}
