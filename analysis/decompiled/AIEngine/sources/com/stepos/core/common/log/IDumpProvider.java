package com.stepos.core.common.log;

import java.io.PrintWriter;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IDumpProvider {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class DefaultImpls {
        public static String getHelp(IDumpProvider iDumpProvider) {
            return "";
        }

        public static boolean supportsArg(IDumpProvider iDumpProvider, String arg) {
            g.f(arg, "arg");
            return false;
        }
    }

    void dump(PrintWriter printWriter, String[] strArr);

    void dumpStats(PrintWriter printWriter);

    String getHelp();

    LogModule getLogModule();

    String getModuleName();

    boolean supportsArg(String str);
}
