package com.bytedance.reparo.core.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.reparo.core.WandTrick;
import com.bytedance.reparo.core.b.j;
import com.bytedance.reparo.core.g;
import com.bytedance.reparo.core.g.k;
import com.bytedance.reparo.core.i;
import com.obric.capabilitykit.entity.ResultCode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SoLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends b<com.bytedance.reparo.core.h.e> {
    private static final String TAG = "SoLoader";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.reparo.core.c.a f9201b;

    public void a() {
    }

    public e(g r1) {
        super(r1);
        this.f9201b = new com.bytedance.reparo.core.c.a();
    }

    public void a(com.bytedance.reparo.core.h.e r6, a r7, com.bytedance.reparo.core.h.b r8) {
        List<k.a> r9 = r6.h();
        a(r6);
        int r0 = r9.size() - 1;
    L4:
        if (r0 < 0) goto L13;
        String r2 = ((k.a) ZeusTransformUtils.preCheckCast(r9.get(r0), k.a.class, "com.obric.aiagent.plugin")).f9248a;
        if (WandTrick.a(r2) == true) goto L10;
        if (WandTrick.a().isSoLoaded(r2) == false) goto L10;
        throw new j("loadLibrary failed due to loaded!!! : " + r2, 301);
    L10:
        r0 = r0 - 1;
        goto L4
    L13:
        this.f9201b.a(r6.g());
        int r10 = r9.size() - 1;
    L14:
        if (r10 < 0) goto L23;
        k.a r1 = (k.a) ZeusTransformUtils.preCheckCast(r9.get(r10), k.a.class, "com.obric.aiagent.plugin");
        String r3 = a(r1.f9248a);
        if (WandTrick.a(r1.f9248a) == true) goto L19;
        System.loadLibrary(r3);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw new j(String.format("System.loadLibrary(%s) failed", new Object[]{r3}), th, ResultCode.ERROR_MEMORY_SERVICE_DISABLED);
    L19:
        r10 = r10 - 1;
        goto L14
    L23:
        r7.b();
    }

    private void a(com.bytedance.reparo.core.h.e r11) {
        long r0 = SystemClock.elapsedRealtime();
        List<k.a> r10 = r11.h();
        Iterator<k.a> r2 = r10.iterator();
    L4:
        if (r2.hasNext() == false) goto L10;
        k.a r3 = (k.a) ZeusTransformUtils.preCheckCast(r2.next(), k.a.class, "com.obric.aiagent.plugin");
        File r6 = new File(r11.g(), r3.f9248a);
        String r8 = com.bytedance.reparo.core.a.b.a.a(com.bytedance.reparo.core.a.b.a.a(r6));
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.a().get(r11.j()), String.class, "com.obric.aiagent.plugin");
        if (TextUtils.equals(r8, r4) == true) goto L4;
        j r12 = new j(String.format("the so file's key is illegal, key=%s, while key in so-info.txt is %s, %s", new Object[]{r8, r4, r6.getAbsolutePath()}), 300);
        i.a(TAG, false, r10).a(r0).a(r12).d();
        throw r12;
    L10:
        i.a(TAG, true, r10).a(r0).b().d();
    }

    private String a(String r2) {
        if (r2.startsWith("lib") == false) goto L5;
        String r1 = r2.substring(3);
    L7:
        if (r2.endsWith(".so") == true) goto L9;
        return r1;
    L9:
        return r1.substring(0, r1.lastIndexOf(".so"));
    L5:
        r1 = r2;
        goto L7
    }
}
