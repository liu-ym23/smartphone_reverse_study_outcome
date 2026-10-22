package com.bytedance.apm.agent.v2.instrumentation;

import S0.b;
import Y.a;
import Y.d;
import android.text.TextUtils;
import androidx.annotation.Keep;
import ca.AbstractC0897f;
import com.bytedance.apm.agent.v2.InstructOperationSwitch;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedDeque;

@Keep
/* loaded from: classes2.dex */
public class ActivityAgent {
    private static final String TAG = "ActivityInstrumentation";

    @Keep
    public static void onTrace(String str, String str2, boolean z10) {
        d dVar;
        if (z10 && InstructOperationSwitch.sUiSwitch && TextUtils.equals("onResume", str2)) {
            b.M(str, true);
        }
        if (InstructOperationSwitch.sPageLoadSwitch) {
            HashSet hashSet = Y.b.f1557a;
            if (TextUtils.equals(AppAgent.ON_CREATE, str2)) {
                if (!z10) {
                    if (AbstractC0897f.u == 0) {
                        AbstractC0897f.u = System.currentTimeMillis();
                    }
                    AbstractC0897f.k = System.currentTimeMillis();
                    d dVar2 = (d) Y.b.b.peekLast();
                    if (dVar2 == null || TextUtils.isEmpty(dVar2.f1558a)) {
                        return;
                    }
                    dVar2.c = System.currentTimeMillis();
                    return;
                }
                if (AbstractC0897f.f2123t == 0) {
                    AbstractC0897f.f2123t = System.currentTimeMillis();
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                AbstractC0897f.f2119j = jCurrentTimeMillis;
                if (jCurrentTimeMillis - AbstractC0897f.i < 800) {
                    AbstractC0897f.f2121r = true;
                }
                ConcurrentLinkedDeque concurrentLinkedDeque = Y.b.b;
                if (concurrentLinkedDeque.size() > 10) {
                    concurrentLinkedDeque.clear();
                }
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                d dVar3 = new d();
                dVar3.f1558a = str;
                dVar3.b = jCurrentTimeMillis2;
                concurrentLinkedDeque.add(dVar3);
                return;
            }
            if (TextUtils.equals("onResume", str2)) {
                if (!z10) {
                    L0.d.f925a.b(new a(str, 0));
                    d dVar4 = (d) Y.b.b.peekLast();
                    if (dVar4 == null || TextUtils.isEmpty(dVar4.f1558a)) {
                        return;
                    }
                    dVar4.e = System.currentTimeMillis();
                    return;
                }
                if (AbstractC0897f.f2124v == 0) {
                    AbstractC0897f.f2124v = System.currentTimeMillis();
                }
                AbstractC0897f.l = System.currentTimeMillis();
                d dVar5 = (d) Y.b.b.peekLast();
                if (dVar5 == null || TextUtils.isEmpty(dVar5.f1558a)) {
                    return;
                }
                dVar5.d = System.currentTimeMillis();
                return;
            }
            if (TextUtils.equals("onWindowFocusChanged", str2)) {
                if (!z10 || (dVar = (d) Y.b.b.peekLast()) == null || dVar.f != 0 || TextUtils.isEmpty(dVar.f1558a)) {
                    return;
                }
                dVar.f = System.currentTimeMillis();
                if (((Integer) K.a.f902a.get(str)) == null) {
                    L0.d.f925a.b(new A1.a(13));
                    return;
                }
                return;
            }
            if (TextUtils.equals("onRestart", str2)) {
                if (z10) {
                    AbstractC0897f.n = System.currentTimeMillis();
                    return;
                } else {
                    AbstractC0897f.o = System.currentTimeMillis();
                    return;
                }
            }
            if (TextUtils.equals("onStart", str2)) {
                if (z10) {
                    if (AbstractC0897f.y == 0) {
                        AbstractC0897f.y = System.currentTimeMillis();
                    }
                    AbstractC0897f.p = System.currentTimeMillis();
                } else {
                    if (AbstractC0897f.f2127z == 0) {
                        AbstractC0897f.f2127z = System.currentTimeMillis();
                    }
                    AbstractC0897f.f2120q = System.currentTimeMillis();
                }
            }
        }
    }
}
