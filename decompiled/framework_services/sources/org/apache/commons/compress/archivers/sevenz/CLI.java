package org.apache.commons.compress.archivers.sevenz;

import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class CLI {

    /* JADX INFO: renamed from: org.apache.commons.compress.archivers.sevenz.CLI$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static abstract enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode EXTRACT = null;
        public static final Mode LIST = null;
        private final String message;

        public abstract void takeAction(SevenZFile r1, SevenZArchiveEntry r2) throws IOException;

        private static /* synthetic */ Mode[] $values() {
            return new Mode[]{LIST, EXTRACT};
        }

        /* synthetic */ Mode(String x0, int x1, String x2, AnonymousClass1 x3) {
            this(x0, x1, x2);
        }

        public static Mode valueOf(String name) {
            return (Mode) Enum.valueOf(Mode.class, name);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }

        static {
            final int r1 = 0;
            final String r2 = "Analysing";
            final String r3 = "LIST";
            LIST = new AnonymousClass1(r3, r1, r2);
            final int r4 = 1;
            final String r5 = "Extracting";
            final String r6 = "EXTRACT";
            EXTRACT = new AnonymousClass2(r6, r4, r5);
            $VALUES = $values();
        }

        private Mode(String r1, int r2, String message) {
            super(r1, r2);
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public CLI() {
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 0) goto L6;
        usage();
        return;
    L6:
        Mode mode = grabMode(args);
        System.out.println(mode.getMessage() + " " + args[0]);
        File f = new File(args[0]);
        if (f.isFile() == true) goto L9;
        System.err.println(f + " doesn't exist or is a directory");
    L9:
        SevenZFile archive = new SevenZFile(f);
    L25:
        SevenZArchiveEntry ae = archive.getNextEntry();     // Catch: Throwable -> L14
        if (ae == null) goto L16;
        mode.takeAction(archive, ae);     // Catch: Throwable -> L14
        goto L25
    L16:
        archive.close();
        return;
    L14:
        th = move-exception;
        archive.close();     // Catch: Throwable -> L20
    L22:
        throw th;
    L20:
        th = move-exception;
        th.addSuppressed(th);
        goto L22
    }

    private static void usage() {
        System.out.println("Parameters: archive-name [list|extract]");
    }

    private static Mode grabMode(String[] args) {
        if (args.length >= 2) goto L7;
        return Mode.LIST;
    L7:
        return (Mode) Enum.valueOf(Mode.class, args[1].toUpperCase());
    }
}
