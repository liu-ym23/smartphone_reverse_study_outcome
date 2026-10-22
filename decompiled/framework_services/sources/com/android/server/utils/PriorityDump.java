package com.android.server.utils;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class PriorityDump {
    public static final String PRIORITY_ARG = "--dump-priority";
    public static final String PRIORITY_ARG_CRITICAL = "CRITICAL";
    public static final String PRIORITY_ARG_HIGH = "HIGH";
    public static final String PRIORITY_ARG_NORMAL = "NORMAL";
    private static final int PRIORITY_TYPE_CRITICAL = 1;
    private static final int PRIORITY_TYPE_HIGH = 2;
    private static final int PRIORITY_TYPE_INVALID = 0;
    private static final int PRIORITY_TYPE_NORMAL = 3;
    public static final String PROTO_ARG = "--proto";

    public interface PriorityDumper {
        default void dumpCritical(FileDescriptor fd, PrintWriter pw, String[] args, boolean asProto) {
        }

        default void dumpHigh(FileDescriptor fd, PrintWriter pw, String[] args, boolean asProto) {
        }

        default void dumpNormal(FileDescriptor fd, PrintWriter pw, String[] args, boolean asProto) {
        }

        default void dump(FileDescriptor fd, PrintWriter pw, String[] args, boolean asProto) {
            dumpCritical(fd, pw, args, asProto);
            dumpHigh(fd, pw, args, asProto);
            dumpNormal(fd, pw, args, asProto);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface PriorityType {
    }

    private PriorityDump() {
        throw new UnsupportedOperationException();
    }

    public static void dump(PriorityDumper dumper, FileDescriptor fd, PrintWriter pw, String[] args) {
        boolean asProto = false;
        int priority = 0;
        if (args != null) goto L6;
        dumper.dump(fd, pw, args, false);
        return;
    L6:
        String[] strippedArgs = new String[args.length];
        int strippedCount = 0;
        int argIndex = 0;
    L8:
        if (argIndex >= args.length) goto L19;
        if (args[argIndex].equals("--proto") == false) goto L13;
        asProto = true;
    L18:
        argIndex = argIndex + 1;
        goto L8
    L13:
        if (args[argIndex].equals(PRIORITY_ARG) == true) goto L15;
        strippedArgs[strippedCount] = args[argIndex];
        strippedCount = strippedCount + 1;
        goto L18
    L15:
        if ((argIndex + 1) >= args.length) goto L18;
        argIndex = argIndex + 1;
        priority = getPriorityType(args[argIndex]);
        goto L18
    L19:
        int argIndex2 = args.length;
        if (strippedCount >= argIndex2) goto L22;
        strippedArgs = (String[]) Arrays.copyOf(strippedArgs, strippedCount);
    L22:
        switch(priority) {
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        dumper.dump(fd, pw, strippedArgs, asProto);
        return;
    L25:
        dumper.dumpNormal(fd, pw, strippedArgs, asProto);
        return;
    L27:
        dumper.dumpHigh(fd, pw, strippedArgs, asProto);
        return;
    L29:
        dumper.dumpCritical(fd, pw, strippedArgs, asProto);
    }

    private static int getPriorityType(String arg) {
        switch(arg.hashCode()) {
            case -1986416409: goto L12;
            case -1560189025: goto L9;
            case 2217378: goto L6;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L20;
            case 1: goto L19;
            case 2: goto L17;
            default: goto L16;
        };
    L16:
        return 0;
    L17:
        return 3;
    L19:
        return 2;
    L20:
        return 1;
    L6:
        if (arg.equals(PRIORITY_ARG_HIGH) == false) goto L14;
        r0 = 1;
        goto L15
    L9:
        if (arg.equals(PRIORITY_ARG_CRITICAL) == false) goto L14;
        r0 = 0;
        goto L15
    L12:
        if (arg.equals(PRIORITY_ARG_NORMAL) == false) goto L14;
        r0 = 2;
        goto L15
    }
}
