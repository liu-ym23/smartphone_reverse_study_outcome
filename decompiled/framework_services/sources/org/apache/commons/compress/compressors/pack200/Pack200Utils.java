package org.apache.commons.compress.compressors.pack200;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;
import java.util.jar.Pack200;

/* JADX INFO: loaded from: classes3.dex */
public class Pack200Utils {
    private Pack200Utils() {
    }

    public static void normalize(File jar) throws IOException {
        normalize(jar, jar, null);
    }

    public static void normalize(File jar, Map<String, String> props) throws IOException {
        normalize(jar, jar, props);
    }

    public static void normalize(File from, File to) throws IOException {
        normalize(from, to, null);
    }

    public static void normalize(File from, File to, Map<String, String> props) throws IOException {
        if (props != null) goto L4;
        props = new HashMap();
    L4:
        props.put("pack.segment.limit", "-1");
        File tempFile = File.createTempFile("commons-compress", "pack200normalize");
        FileOutputStream fos = new FileOutputStream(tempFile);     // Catch: Throwable -> L16
        JarFile jarFile = new JarFile(from);     // Catch: Throwable -> L24
        Pack200.Packer packer = Pack200.newPacker();     // Catch: Throwable -> L26
        packer.properties().putAll(props);     // Catch: Throwable -> L26
        packer.pack(jarFile, fos);     // Catch: Throwable -> L26
        jarFile.close();     // Catch: Throwable -> L24
        fos.close();     // Catch: Throwable -> L16
        Pack200.Unpacker unpacker = Pack200.newUnpacker();     // Catch: Throwable -> L16
        JarOutputStream jos = new JarOutputStream(new FileOutputStream(to));     // Catch: Throwable -> L16
        unpacker.unpack(tempFile, jos);     // Catch: Throwable -> L18
        jos.close();     // Catch: Throwable -> L16
        if (tempFile.delete() == true) goto L53;
        tempFile.deleteOnExit();
        return;
    L53:
        return;
    L18:
        th = move-exception;
        jos.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: Throwable -> L16
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16
        goto L23
    L26:
        th = move-exception;
        jarFile.close();     // Catch: Throwable -> L29
    L31:
        throw th;     // Catch: Throwable -> L24
    L29:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L34
    L36:
        throw th;     // Catch: Throwable -> L16
    L34:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (tempFile.delete() == true) goto L40;
        tempFile.deleteOnExit();
    L40:
        throw th;
    }
}
