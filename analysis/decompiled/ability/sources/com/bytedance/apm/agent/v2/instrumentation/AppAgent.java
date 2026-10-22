package com.bytedance.apm.agent.v2.instrumentation;

import H.h;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.Keep;
import ca.AbstractC0897f;

@Keep
/* loaded from: classes2.dex */
public class AppAgent {
    public static final String ATTACH_BASE_CONTEXT = "attachBaseContext";
    public static final String CONSTRUCT = "<init>";
    public static final String ON_CREATE = "onCreate";
    private static long attachBaseContextEndTime;
    private static long attachBaseContextStartTime;
    private static long constructorEndTime;
    private static long constructorStartTime;
    private static long onCreateEndTime;
    private static long onCreateStartTime;

    @Keep
    public static void onTrace(String str, boolean z10) {
        if (TextUtils.equals(str, CONSTRUCT)) {
            if (z10) {
                constructorStartTime = System.currentTimeMillis();
                return;
            } else {
                constructorEndTime = System.currentTimeMillis();
                return;
            }
        }
        if (TextUtils.equals(str, ATTACH_BASE_CONTEXT)) {
            if (z10) {
                attachBaseContextStartTime = System.currentTimeMillis();
                return;
            } else {
                attachBaseContextEndTime = System.currentTimeMillis();
                return;
            }
        }
        if (TextUtils.equals(str, ON_CREATE)) {
            if (z10) {
                onCreateStartTime = System.currentTimeMillis();
                return;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            onCreateEndTime = jCurrentTimeMillis;
            long j5 = constructorStartTime;
            long j6 = constructorEndTime;
            long j10 = attachBaseContextStartTime;
            long j11 = attachBaseContextEndTime;
            long j12 = onCreateStartTime;
            AbstractC0897f.d = j5;
            AbstractC0897f.e = j6;
            AbstractC0897f.f = j10;
            AbstractC0897f.g = j11;
            AbstractC0897f.h = j12;
            AbstractC0897f.i = jCurrentTimeMillis;
            Application application = h.f711a;
            if (j5 <= 0) {
                return;
            }
            long j13 = h.k;
            if (j13 == 0 || j5 < j13) {
                h.k = j5;
            }
        }
    }
}
