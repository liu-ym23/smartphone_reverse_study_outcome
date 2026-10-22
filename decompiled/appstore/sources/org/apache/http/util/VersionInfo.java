package org.apache.http.util;

import com.bytedance.librarian.LibrarianImpl;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes4.dex */
public class VersionInfo {
    public static final String PROPERTY_MODULE = "info.module";
    public static final String PROPERTY_RELEASE = "info.release";
    public static final String PROPERTY_TIMESTAMP = "info.timestamp";
    public static final String UNAVAILABLE = "UNAVAILABLE";
    public static final String VERSION_PROPERTY_FILE = "version.properties";
    private final String infoClassloader;
    private final String infoModule;
    private final String infoPackage;
    private final String infoRelease;
    private final String infoTimestamp;

    public VersionInfo(String r10, String r11, String r12, String r13, String r14) {
        Args.notNull(r10, "Package identifier");
        this.infoPackage = r10;
        if (r11 != null) goto L6;
        r11 = UNAVAILABLE;
    L6:
        this.infoModule = r11;
        if (r12 != null) goto L10;
        r12 = UNAVAILABLE;
    L10:
        this.infoRelease = r12;
        if (r13 != null) goto L14;
        r13 = UNAVAILABLE;
    L14:
        this.infoTimestamp = r13;
        if (r14 != null) goto L18;
        r14 = UNAVAILABLE;
    L18:
        this.infoClassloader = r14;
    }

    public static VersionInfo fromMap(String r10, Map<?, ?> r11, ClassLoader r12) {
        Args.notNull(r10, "Package identifier");
        String r13 = null;
        if (r11 == null) goto L25;
        String r14 = (String) r11.get(PROPERTY_MODULE);
        if (r14 != null) goto L7;
    L9:
        String r15 = (String) r11.get(PROPERTY_RELEASE);
        if (r15 != null) goto L12;
    L16:
        String r16 = (String) r11.get(PROPERTY_TIMESTAMP);
        if (r16 != null) goto L19;
    L24:
        String r17 = r16;
    L23:
        String r18 = r14;
        String r19 = r15;
    L26:
        if (r12 == null) goto L29;
        r13 = r12.toString();
    L29:
        return new VersionInfo(r10, r18, r19, r17, r13);
    L19:
        if (r16.length() >= 1) goto L21;
    L22:
        r17 = null;
        goto L23
    L21:
        if (r16.equals("${mvn.timestamp}") == false) goto L24;
    L12:
        if (r15.length() >= 1) goto L14;
    L15:
        r15 = null;
        goto L16
    L14:
        if (r15.equals("${pom.version}") == false) goto L16;
    L7:
        if (r14.length() >= 1) goto L9;
        r14 = null;
        goto L9
    L25:
        r18 = null;
        r19 = null;
        r17 = null;
        goto L26
    }

    public static String getUserAgent(String r10, String r11, Class<?> r12) {
        VersionInfo r13 = loadVersionInfo(r11, r12.getClassLoader());
        if (r13 == null) goto L5;
        String r14 = r13.getRelease();
    L7:
        return String.format("%s/%s (Java/%s)", new Object[]{r10, r14, System.getProperty("java.version")});
    L5:
        r14 = UNAVAILABLE;
        goto L7
    }

    public static VersionInfo[] loadVersionInfo(String[] r10, ClassLoader r11) {
        Args.notNull(r10, "Package identifier array");
        ArrayList r12 = new ArrayList(r10.length);
        int r13 = r10.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L9;
        VersionInfo r15 = loadVersionInfo(r10[r14], r11);
        if (r15 == null) goto L7;
        r12.add(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    L9:
        return (VersionInfo[]) r12.toArray(new VersionInfo[r12.size()]);
    }

    public final String getClassloader() {
        return this.infoClassloader;
    }

    public final String getModule() {
        return this.infoModule;
    }

    public final String getPackage() {
        return this.infoPackage;
    }

    public final String getRelease() {
        return this.infoRelease;
    }

    public final String getTimestamp() {
        return this.infoTimestamp;
    }

    public String toString() {
        StringBuilder r10 = new StringBuilder(((((this.infoPackage.length() + 20) + this.infoModule.length()) + this.infoRelease.length()) + this.infoTimestamp.length()) + this.infoClassloader.length());
        r10.append("VersionInfo(");
        r10.append(this.infoPackage);
        r10.append(':');
        r10.append(this.infoModule);
        if (UNAVAILABLE.equals(this.infoRelease) == true) goto L6;
        r10.append(':');
        r10.append(this.infoRelease);
    L6:
        if (UNAVAILABLE.equals(this.infoTimestamp) == true) goto L8;
        r10.append(':');
        r10.append(this.infoTimestamp);
    L8:
        r10.append(')');
        if (UNAVAILABLE.equals(this.infoClassloader) == true) goto L12;
        r10.append('@');
        r10.append(this.infoClassloader);
    L12:
        return r10.toString();
    }

    public static VersionInfo loadVersionInfo(String r10, ClassLoader r11) {
        Args.notNull(r10, "Package identifier");
        if (r11 != null) goto L25;
        r11 = Thread.currentThread().getContextClassLoader();
    L25:
        InputStream r12 = r11.getResourceAsStream(r10.replace('.', '/') + LibrarianImpl.Constants.SEPARATOR + VERSION_PROPERTY_FILE);     // Catch: IOException -> L20
        if (r12 == null) goto L15;
        Properties r13 = new Properties();     // Catch: Throwable -> L12
        r13.load(r12);     // Catch: Throwable -> L12
        goto L15
    L23:
        r12.close();     // Catch: IOException -> L19
    L16:
        if (r13 != null) goto L18;
        return null;
    L18:
        return fromMap(r10, r13, r11);
    L12:
        th = move-exception;
        r12.close();     // Catch: IOException -> L20
        throw th;     // Catch: IOException -> L20
    L15:
        r13 = null;
        goto L16
    }
}
