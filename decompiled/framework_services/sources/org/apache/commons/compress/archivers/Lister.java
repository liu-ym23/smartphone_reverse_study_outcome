package org.apache.commons.compress.archivers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import org.apache.commons.compress.archivers.sevenz.SevenZFile;

/* JADX INFO: loaded from: classes3.dex */
public final class Lister {
    private static final ArchiveStreamFactory factory = null;

    public Lister() {
    }

    static {
        factory = new ArchiveStreamFactory();
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 0) goto L6;
        usage();
        return;
    L6:
        System.out.println("Analysing " + args[0]);
        File f = new File(args[0]);
        if (f.isFile() == true) goto L10;
        System.err.println(f + " doesn't exist or is a directory");
    L10:
        if (args.length <= 1) goto L12;
        String format = args[1];
    L14:
        if (ArchiveStreamFactory.SEVEN_Z.equalsIgnoreCase(format) == false) goto L16;
        list7z(f);
        return;
    L16:
        listStream(f, args);
        return;
    L12:
        format = detectFormat(f);
        goto L14
    }

    private static void listStream(File f, String[] args) throws ArchiveException, IOException {
        InputStream fis = new BufferedInputStream(Files.newInputStream(f.toPath(), new OpenOption[0]));
        ArchiveInputStream ais = createArchiveInputStream(args, fis);     // Catch: Throwable -> L15
        System.out.println("Created " + ais.toString());     // Catch: Throwable -> L9
    L5:
        ArchiveEntry ae = ais.getNextEntry();     // Catch: Throwable -> L9
        if (ae == null) goto L12;
        System.out.println(ae.getName());     // Catch: Throwable -> L9
    L12:
        ais.close();     // Catch: Throwable -> L15
        fis.close();
        return;
    L9:
        th = move-exception;
        if (ais != null) goto L28;
    L22:
        throw th;     // Catch: Throwable -> L15
    L28:
        ais.close();     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        fis.close();     // Catch: Throwable -> L25
    L27:
        throw th;
    L25:
        th = move-exception;
        th.addSuppressed(th);
        goto L27
    }

    private static ArchiveInputStream createArchiveInputStream(String[] args, InputStream fis) throws ArchiveException {
        if (args.length <= 1) goto L7;
        return factory.createArchiveInputStream(args[1], fis);
    L7:
        return factory.createArchiveInputStream(fis);
    }

    private static String detectFormat(File f) throws ArchiveException, IOException {
        InputStream fis = new BufferedInputStream(Files.newInputStream(f.toPath(), new OpenOption[0]));
        String r1 = ArchiveStreamFactory.detect(fis);     // Catch: Throwable -> L6
        fis.close();
        return r1;
    L6:
        th = move-exception;
        fis.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static void list7z(File f) throws ArchiveException, IOException {
        SevenZFile z = new SevenZFile(f);
        System.out.println("Created " + z.toString());     // Catch: Throwable -> L8
    L4:
        ArchiveEntry ae = z.getNextEntry();     // Catch: Throwable -> L8
        if (ae == null) goto L10;
        System.out.println(ae.getName());     // Catch: Throwable -> L8
        goto L4
    L10:
        z.close();
        return;
    L8:
        th = move-exception;
        z.close();     // Catch: Throwable -> L14
    L16:
        throw th;
    L14:
        th = move-exception;
        th.addSuppressed(th);
        goto L16
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [archive-type]");
    }
}
