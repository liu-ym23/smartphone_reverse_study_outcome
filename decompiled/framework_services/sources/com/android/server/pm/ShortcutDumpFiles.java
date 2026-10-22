package com.android.server.pm;

import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutDumpFiles {
    private static final boolean DEBUG = false;
    private static final String TAG = "ShortcutService";
    private final ShortcutService mService;

    /* JADX INFO: renamed from: $r8$lambda$Dp01k4Jw-eRRUd9hDAYA4PwvU9o, reason: not valid java name */
    public static /* synthetic */ void m6901$r8$lambda$Dp01k4JweRRUd9hDAYA4PwvU9o(byte[] r0, PrintWriter r1) {
        lambda$save$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$Ezn0Ei_tjz43Z-MaaOD-FGb-7DE, reason: not valid java name */
    public static /* synthetic */ boolean m6902$r8$lambda$Ezn0Ei_tjz43ZMaaODFGb7DE(File r0) {
        return lambda$dumpAll$1(r0);
    }

    public static /* synthetic */ String $r8$lambda$HLKfdv_pARS01WpPd1x5IsCgDYk(File r0) {
        return lambda$dumpAll$2(r0);
    }

    public ShortcutDumpFiles(ShortcutService service) {
        this.mService = service;
    }

    public boolean save(String filename, Consumer<PrintWriter> dumper) {
        File directory = this.mService.getDumpPath();     // Catch: Throwable -> L7
        directory.mkdirs();     // Catch: Throwable -> L7
        if (directory.exists() == true) goto L9;
        Slog.e(TAG, "Failed to create directory: " + directory);     // Catch: Throwable -> L7
        return false;
    L9:
        File path = new File(directory, filename);     // Catch: Throwable -> L7
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileOutputStream(path)));     // Catch: Throwable -> L7
        dumper.accept(pw);     // Catch: Throwable -> L14
        pw.close();     // Catch: Throwable -> L7 Throwable -> L7
        return true;
    L14:
        th = move-exception;
        pw.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L7 Throwable -> L7
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L7 Throwable -> L7
    L7:
        e = move-exception;
        Slog.w(TAG, "Failed to create dump file: " + filename, e);
        return false;
    }

    private static /* synthetic */ void lambda$save$0(byte[] utf8bytes, PrintWriter pw) {
        pw.println(StandardCharsets.UTF_8.decode(ByteBuffer.wrap(utf8bytes)).toString());
    }

    public boolean save(String filename, final byte[] utf8bytes) {
        return save(filename, new ShortcutDumpFiles$$ExternalSyntheticLambda0(utf8bytes));
    }

    public void dumpAll(PrintWriter pw) {
        File directory = this.mService.getDumpPath();     // Catch: Throwable -> L20
        File[] files = directory.listFiles(new ShortcutDumpFiles$$ExternalSyntheticLambda1());     // Catch: Throwable -> L20
        if (directory.exists() == false) goto L28;
        if (ArrayUtils.isEmpty(files) == true) goto L28;
        Arrays.sort(files, Comparator.comparing(new ShortcutDumpFiles$$ExternalSyntheticLambda2()));     // Catch: Throwable -> L20
        int r2 = files.length;     // Catch: Throwable -> L20
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L40;
        File path = files[r3];     // Catch: Throwable -> L20
        pw.print("*** Dumping: ");     // Catch: Throwable -> L20
        pw.println(path.getName());     // Catch: Throwable -> L20
        pw.print("mtime: ");     // Catch: Throwable -> L20
        pw.println(ShortcutService.formatTime(path.lastModified()));     // Catch: Throwable -> L20
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));     // Catch: Throwable -> L20
    L34:
        String line = reader.readLine();     // Catch: Throwable -> L15
        if (line == null) goto L18;
        pw.println(line);     // Catch: Throwable -> L15
        goto L34
    L18:
        reader.close();     // Catch: Throwable -> L20 Throwable -> L20
        r3 = r3 + 1;
    L15:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L24
    L26:
        throw th;     // Catch: Throwable -> L20 Throwable -> L20
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L20 Throwable -> L20
        goto L26
    L40:
        return;
    L28:
        pw.print("  No dump files found.");     // Catch: Throwable -> L20 Throwable -> L20
        return;
    L20:
        e = move-exception;
        Slog.w(TAG, "Failed to print dump files", e);
    }

    private static /* synthetic */ boolean lambda$dumpAll$1(File f) {
        return f.isFile();
    }

    private static /* synthetic */ String lambda$dumpAll$2(File f) {
        return f.getName();
    }
}
