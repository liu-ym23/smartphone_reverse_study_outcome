package com.stepos.core.common.telemetry;

import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.log.Sanitizer;
import fc.p;
import gc.o;
import gc.q;
import java.util.ArrayList;
import java.util.List;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class FailStack {
    public static final FailStack INSTANCE = new FailStack();
    private static final int MAX_CAUSES = 3;
    public static final int MAX_CHARS = 3500;
    private static final int MAX_FRAMES = 20;
    private static final int MSG_CHARS = 256;

    private FailStack() {
    }

    public static /* synthetic */ String format$default(FailStack failStack, Throwable th, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = MAX_CHARS;
        }
        return failStack.format(th, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.List] */
    private final List<StackTraceElement> selectFrames(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            String className = stackTraceElement.getClassName();
            kotlin.jvm.internal.g.e(className, "getClassName(...)");
            if (o.k0(className, "com.stepos", false)) {
                arrayList.add(stackTraceElement);
            }
        }
        boolean zIsEmpty = arrayList.isEmpty();
        ArrayList arrayListM0 = arrayList;
        if (zIsEmpty) {
            arrayListM0 = l.m0(stackTraceElementArr);
        }
        return kotlin.collections.a.J0(20, arrayListM0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toLines$lambda$0(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return q.N0(it).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean toLines$lambda$1(String it) {
        kotlin.jvm.internal.g.f(it, "it");
        return it.length() > 0;
    }

    public final String format(Throwable t8, int i10) {
        String strSubstring;
        String str;
        kotlin.jvm.internal.g.f(t8, "t");
        StringBuilder sb2 = new StringBuilder(VadSessionManager.FRAME_BYTES);
        for (int i11 = 0; t8 != null && i11 < 3 && sb2.length() < i10; i11++) {
            if (i11 > 0) {
                sb2.append("Caused by: ");
            }
            sb2.append(t8.getClass().getName());
            sb2.append(": ");
            sb2.append(Sanitizer.text(t8.getMessage(), 256));
            sb2.append('\n');
            StackTraceElement[] stackTrace = t8.getStackTrace();
            kotlin.jvm.internal.g.e(stackTrace, "getStackTrace(...)");
            for (StackTraceElement stackTraceElement : selectFrames(stackTrace)) {
                sb2.append("  at ");
                sb2.append(stackTraceElement.getClassName());
                sb2.append('.');
                sb2.append(stackTraceElement.getMethodName());
                sb2.append('(');
                String fileName = stackTraceElement.getFileName();
                if (fileName == null) {
                    fileName = "Unknown";
                }
                sb2.append(fileName);
                sb2.append(':');
                sb2.append(stackTraceElement.getLineNumber());
                sb2.append(")\n");
                if (sb2.length() >= i10) {
                    break;
                }
            }
            t8 = t8.getCause();
        }
        if (sb2.length() <= i10) {
            strSubstring = sb2.toString();
            str = "toString(...)";
        } else {
            strSubstring = sb2.substring(0, i10);
            str = "substring(...)";
        }
        kotlin.jvm.internal.g.e(strSubstring, str);
        return strSubstring;
    }

    public final List<String> toLines(String stack) {
        kotlin.jvm.internal.g.f(stack, "stack");
        int i10 = 1;
        return p.A(new fc.f(new fc.q(new fc.l(stack, i10), new b(i10)), new com.stepos.core.common.cloud.d(6)));
    }
}
