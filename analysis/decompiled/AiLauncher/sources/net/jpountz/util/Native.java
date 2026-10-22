package net.jpountz.util;

import com.fasterxml.jackson.core.JsonPointer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes5.dex */
public enum Native {
    ;

    private static boolean loaded = false;

    public enum OS {
        WINDOWS("win32", "so"),
        LINUX("linux", "so"),
        MAC("darwin", "dylib"),
        SOLARIS("solaris", "so");

        public final String libExtension;
        public final String name;

        OS(String str, String str2) {
            this.name = str;
            this.libExtension = str2;
        }
    }

    public static class a implements FilenameFilter {

        /* renamed from: a, reason: collision with root package name */
        public final String f37302a = "liblz4-java-";

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith("liblz4-java-") && !str.endsWith(".lck");
        }
    }

    private static String arch() {
        return System.getProperty("os.arch");
    }

    private static void cleanupOldTempLibs() {
        File[] fileArrListFiles = new File(new File(System.getProperty("java.io.tmpdir")).getAbsolutePath()).listFiles(new a());
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                if (!new File(file.getAbsolutePath() + ".lck").exists()) {
                    try {
                        file.delete();
                    } catch (SecurityException e10) {
                        System.err.println("Failed to delete old temp lib" + e10.getMessage());
                    }
                }
            }
        }
    }

    public static synchronized boolean isLoaded() {
        return loaded;
    }

    public static synchronized void load() {
        File fileCreateTempFile;
        File file;
        if (loaded) {
            return;
        }
        cleanupOldTempLibs();
        try {
            System.loadLibrary("lz4-java");
            loaded = true;
        } catch (UnsatisfiedLinkError unused) {
            String strResourceName = resourceName();
            InputStream resourceAsStream = Native.class.getResourceAsStream(strResourceName);
            if (resourceAsStream == null) {
                throw new UnsupportedOperationException("Unsupported OS/arch, cannot find " + strResourceName + ". Please try building from source.");
            }
            File file2 = null;
            try {
                try {
                    fileCreateTempFile = File.createTempFile("liblz4-java-", "." + os().libExtension + ".lck");
                    try {
                        file = new File(fileCreateTempFile.getAbsolutePath().replaceFirst(".lck$", ""));
                    } catch (IOException e10) {
                        e = e10;
                    }
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e11) {
                e = e11;
            } catch (Throwable th2) {
                th = th2;
                fileCreateTempFile = null;
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i10 = resourceAsStream.read(bArr);
                        if (i10 == -1) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, i10);
                        }
                    }
                    fileOutputStream.close();
                    System.load(file.getAbsolutePath());
                    loaded = true;
                    String str = System.getenv("LZ4JAVA_KEEP_TEMP_JNI_LIB");
                    String property = System.getProperty("lz4java.jnilib.temp.keep");
                    if ((str == null || !str.equals("true")) && (property == null || !property.equals("true"))) {
                        file.deleteOnExit();
                    }
                    fileCreateTempFile.deleteOnExit();
                } finally {
                }
            } catch (IOException e12) {
                e = e12;
                throw new ExceptionInInitializerError("Cannot unpack liblz4-java: " + e);
            } catch (Throwable th3) {
                th = th3;
                file2 = file;
                if (loaded) {
                    String str2 = System.getenv("LZ4JAVA_KEEP_TEMP_JNI_LIB");
                    String property2 = System.getProperty("lz4java.jnilib.temp.keep");
                    if ((str2 == null || !str2.equals("true")) && (property2 == null || !property2.equals("true"))) {
                        file2.deleteOnExit();
                    }
                    fileCreateTempFile.deleteOnExit();
                } else {
                    if (file2 != null && file2.exists() && !file2.delete()) {
                        throw new ExceptionInInitializerError("Cannot unpack liblz4-java / cannot delete a temporary native library " + file2);
                    }
                    if (fileCreateTempFile != null && fileCreateTempFile.exists() && !fileCreateTempFile.delete()) {
                        throw new ExceptionInInitializerError("Cannot unpack liblz4-java / cannot delete a temporary lock file " + fileCreateTempFile);
                    }
                }
                throw th;
            }
        }
    }

    private static OS os() {
        String property = System.getProperty("os.name");
        if (property.contains("Linux")) {
            return OS.LINUX;
        }
        if (property.contains("Mac")) {
            return OS.MAC;
        }
        if (property.contains("Windows")) {
            return OS.WINDOWS;
        }
        if (property.contains("Solaris") || property.contains("SunOS")) {
            return OS.SOLARIS;
        }
        throw new UnsupportedOperationException("Unsupported operating system: " + property);
    }

    private static String resourceName() {
        OS os = os();
        return "/" + Native.class.getPackage().getName().replace('.', JsonPointer.SEPARATOR) + "/" + os.name + "/" + arch() + "/liblz4-java." + os.libExtension;
    }
}
