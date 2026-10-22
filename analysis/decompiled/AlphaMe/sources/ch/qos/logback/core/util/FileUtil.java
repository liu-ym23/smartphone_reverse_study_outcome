package ch.qos.logback.core.util;

import ch.qos.logback.core.Context;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
public class FileUtil extends ContextAwareBase {
    static final int BUF_SIZE = 32768;

    public FileUtil(Context context) {
        setContext(context);
    }

    public static boolean createMissingParentDirectories(File file) {
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new IllegalStateException(file + " should not have a null parent");
        }
        if (!parentFile.exists()) {
            return parentFile.mkdirs();
        }
        throw new IllegalStateException(file + " should not have existing parent directory");
    }

    public static URL fileToURL(File file) {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e4) {
            throw new RuntimeException("Unexpected exception on file [" + file + "]", e4);
        }
    }

    public static boolean isParentDirectoryCreationRequired(File file) {
        File parentFile = file.getParentFile();
        return (parentFile == null || parentFile.exists()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0075 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0070 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void copy(java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L43
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r3.<init>(r9)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L39 java.io.IOException -> L3c
            r3 = 32768(0x8000, float:4.5918E-41)
            byte[] r3 = new byte[r3]     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
        L1a:
            int r4 = r1.read(r3)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            r5 = -1
            if (r4 == r5) goto L2b
            r5 = 0
            r2.write(r3, r5, r4)     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            goto L1a
        L26:
            r7 = move-exception
        L27:
            r0 = r1
            goto L6e
        L29:
            r0 = move-exception
            goto L47
        L2b:
            r1.close()     // Catch: java.lang.Throwable -> L26 java.io.IOException -> L29
            r2.close()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L34
            return
        L32:
            r7 = move-exception
            goto L6e
        L34:
            r1 = move-exception
            r6 = r1
            r1 = r0
        L37:
            r0 = r6
            goto L47
        L39:
            r7 = move-exception
            r2 = r0
            goto L27
        L3c:
            r2 = move-exception
            r6 = r2
            r2 = r0
            goto L37
        L40:
            r7 = move-exception
            r2 = r0
            goto L6e
        L43:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r2
        L47:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L26
            r3.<init>()     // Catch: java.lang.Throwable -> L26
            java.lang.String r4 = "Failed to copy ["
            r3.append(r4)     // Catch: java.lang.Throwable -> L26
            r3.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = "] to ["
            r3.append(r8)     // Catch: java.lang.Throwable -> L26
            r3.append(r9)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = "]"
            r3.append(r8)     // Catch: java.lang.Throwable -> L26
            java.lang.String r8 = r3.toString()     // Catch: java.lang.Throwable -> L26
            r7.addError(r8, r0)     // Catch: java.lang.Throwable -> L26
            ch.qos.logback.core.rolling.RolloverFailure r7 = new ch.qos.logback.core.rolling.RolloverFailure     // Catch: java.lang.Throwable -> L26
            r7.<init>(r8)     // Catch: java.lang.Throwable -> L26
            throw r7     // Catch: java.lang.Throwable -> L26
        L6e:
            if (r0 == 0) goto L73
            r0.close()     // Catch: java.io.IOException -> L73
        L73:
            if (r2 == 0) goto L78
            r2.close()     // Catch: java.io.IOException -> L78
        L78:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: ch.qos.logback.core.util.FileUtil.copy(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0044: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:13:0x0044 */
    public String resourceAsString(ClassLoader classLoader, String str) throws Throwable {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        URL resource = classLoader.getResource(str);
        InputStreamReader inputStreamReader3 = null;
        try {
            if (resource == null) {
                addError("Failed to find resource [" + str + "]");
                return null;
            }
            try {
                URLConnection uRLConnectionOpenConnection = resource.openConnection();
                uRLConnectionOpenConnection.setUseCaches(false);
                inputStreamReader2 = new InputStreamReader(uRLConnectionOpenConnection.getInputStream());
                try {
                    char[] cArr = new char[128];
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i4 = inputStreamReader2.read(cArr, 0, 128);
                        if (i4 == -1) {
                            break;
                        }
                        sb.append(cArr, 0, i4);
                    }
                    String string = sb.toString();
                    try {
                        inputStreamReader2.close();
                    } catch (IOException unused) {
                    }
                    return string;
                } catch (IOException e4) {
                    e = e4;
                    this.addError("Failed to open " + str, e);
                    if (inputStreamReader2 != null) {
                        try {
                            inputStreamReader2.close();
                        } catch (IOException unused2) {
                        }
                    }
                    return null;
                }
            } catch (IOException e5) {
                e = e5;
                inputStreamReader2 = null;
            } catch (Throwable th) {
                th = th;
                if (inputStreamReader3 != null) {
                    try {
                        inputStreamReader3.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamReader3 = inputStreamReader;
        }
    }
}
