package com.android.server;

import android.content.Context;
import android.os.Binder;
import android.util.proto.ProtoOutputStream;
import com.android.i18n.timezone.DebugInfo;
import com.android.i18n.timezone.I18nModuleDebug;
import com.android.internal.util.DumpUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class RuntimeService extends Binder {
    private static final String TAG = "RuntimeService";
    private final Context mContext;

    public RuntimeService(Context context) {
        this.mContext = context;
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpAndUsageStatsPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        boolean protoFormat = hasOption(args, "--proto");
        ProtoOutputStream proto = null;
        DebugInfo i18nLibraryDebugInfo = I18nModuleDebug.getDebugInfo();
        if (protoFormat == false) goto L8;
        proto = new ProtoOutputStream(fd);
        reportTimeZoneInfoProto(i18nLibraryDebugInfo, proto);
    L9:
        if (protoFormat == false) goto L12;
        proto.flush();
        return;
    L12:
        return;
    L8:
        reportTimeZoneInfo(i18nLibraryDebugInfo, pw);
        goto L9
    }

    private static boolean hasOption(String[] args, String arg) {
        int r0 = args.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        String opt = args[r2];
        if (arg.equals(opt) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private static void reportTimeZoneInfo(DebugInfo coreLibraryDebugInfo, PrintWriter pw) {
        pw.println("Core Library Debug Info: ");
        Iterator r0 = coreLibraryDebugInfo.getDebugEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DebugInfo.DebugEntry debugEntry = (DebugInfo.DebugEntry) r0.next();
        pw.print(debugEntry.getKey());
        pw.print(": \"");
        pw.print(debugEntry.getStringValue());
        pw.println("\"");
        goto L4
    }

    private static void reportTimeZoneInfoProto(DebugInfo coreLibraryDebugInfo, ProtoOutputStream protoStream) {
        Iterator r0 = coreLibraryDebugInfo.getDebugEntries().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        DebugInfo.DebugEntry debugEntry = (DebugInfo.DebugEntry) r0.next();
        long entryToken = protoStream.start(2246267895809L);
        protoStream.write(1138166333441L, debugEntry.getKey());
        protoStream.write(1138166333442L, debugEntry.getStringValue());
        protoStream.end(entryToken);
        goto L4
    }
}
