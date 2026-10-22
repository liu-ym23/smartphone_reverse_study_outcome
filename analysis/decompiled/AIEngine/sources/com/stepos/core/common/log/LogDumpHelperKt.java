package com.stepos.core.common.log;

import java.io.PrintWriter;
import kotlin.jvm.internal.g;
import mb.l;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class LogDumpHelperKt {
    public static final void dumpAIEngineLogs(PrintWriter printWriter, String[] args) {
        g.f(printWriter, "<this>");
        g.f(args, "args");
        LogDumpHelper.dump(printWriter, (String[]) l.d0(args).toArray(new String[0]));
    }
}
