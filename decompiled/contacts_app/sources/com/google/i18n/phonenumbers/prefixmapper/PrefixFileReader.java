package com.google.i18n.phonenumbers.prefixmapper;

import com.bytedance.sysoptimizer.StackLeakChecker;
import com.google.i18n.phonenumbers.Phonenumber;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public class PrefixFileReader {
    private static final Logger logger = null;
    private Map<String, PhonePrefixMap> availablePhonePrefixMaps;
    private MappingFileProvider mappingFileProvider;
    private final String phonePrefixDataDirectory;

    static {
        logger = Logger.getLogger(PrefixFileReader.class.getName());
    }

    public PrefixFileReader(String r2) {
        this.mappingFileProvider = new MappingFileProvider();
        this.availablePhonePrefixMaps = new HashMap();
        this.phonePrefixDataDirectory = r2;
        loadMappingFileProvider();
    }

    private void loadMappingFileProvider() {
        ObjectInputStream r1 = null;
        ObjectInputStream r2 = new ObjectInputStream(PrefixFileReader.class.getResourceAsStream(this.phonePrefixDataDirectory + "config"));     // Catch: Throwable -> L10 IOException -> L12
        this.mappingFileProvider.readExternal(r2);     // Catch: Throwable -> L6 IOException -> L8
        close(r2);
    L18:
        return;
    L8:
        e = e;
        r1 = r2;
    L13:
        logger.log(Level.WARNING, e.toString());     // Catch: Throwable -> L10
        close(r1);
    L6:
        th = th;
        r1 = r2;
    L16:
        close(r1);
        throw th;
    L10:
        th = th;
    L12:
        e = e;
        goto L13
    }

    private PhonePrefixMap getPhonePrefixDescriptions(int r2, String r3, String r4, String r5) {
        String r6 = this.mappingFileProvider.getFileName(r2, r3, r4, r5);
        monitor-enter(PrefixFileReader.class);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (r6.length() != 0) goto L10;
        monitor-exit(PrefixFileReader.class);     // Catch: Throwable -> L15
        return null;
    L10:
        if (this.availablePhonePrefixMaps.containsKey(r6) == true) goto L12;
        loadPhonePrefixMapFromFile(r6);     // Catch: Throwable -> L15
    L12:
        monitor-exit(PrefixFileReader.class);     // Catch: Throwable -> L15
        return this.availablePhonePrefixMaps.get(r6);
    }

    private void loadPhonePrefixMapFromFile(String r4) {
        ObjectInputStream r1 = null;
        ObjectInputStream r2 = new ObjectInputStream(PrefixFileReader.class.getResourceAsStream(this.phonePrefixDataDirectory + r4));     // Catch: Throwable -> L10 IOException -> L12
        PhonePrefixMap r0 = new PhonePrefixMap();     // Catch: Throwable -> L6 IOException -> L8
        r0.readExternal(r2);     // Catch: Throwable -> L6 IOException -> L8
        this.availablePhonePrefixMaps.put(r4, r0);     // Catch: Throwable -> L6 IOException -> L8
        close(r2);
        return;
    L8:
        e = e;
        r1 = r2;
    L13:
        logger.log(Level.WARNING, e.toString());     // Catch: Throwable -> L10
        close(r1);
        return;
    L6:
        th = th;
        r1 = r2;
    L16:
        close(r1);
        throw th;
    L12:
        e = e;
    L10:
        th = th;
        goto L16
    }

    private static void close(InputStream r2) {
        if (r2 == null) goto L10;
        r2.close();     // Catch: IOException -> L5
        return;
    L5:
        e = move-exception;
        logger.log(Level.WARNING, e.toString());
        return;
    }

    public String getDescriptionForNumber(Phonenumber.PhoneNumber r5, String r6, String r7, String r8) {
        int r0 = r5.getCountryCode();
        if (r0 != 1) goto L6;
        r0 = ((int) (r5.getNationalNumber() / StackLeakChecker.CHECK_INTERVAL_10_SEC)) + 1000;
    L6:
        PhonePrefixMap r9 = getPhonePrefixDescriptions(r0, r6, r7, r8);
        if (r9 == null) goto L9;
        String r10 = r9.lookup(r5);
    L11:
        if (r10 == null) goto L15;
        if (r10.length() == 0) goto L15;
    L20:
        if (r10 != null) goto L22;
        return "";
    L22:
        return r10;
    L15:
        if (mayFallBackToEnglish(r6) == false) goto L20;
        PhonePrefixMap r4 = getPhonePrefixDescriptions(r0, "en", "", "");
        if (r4 != null) goto L19;
        return "";
    L19:
        r10 = r4.lookup(r5);
        goto L20
    L9:
        r10 = null;
        goto L11
    }

    private boolean mayFallBackToEnglish(String r1) {
        if (r1.equals("zh") == false) goto L5;
    L9:
        return false;
    L5:
        if (r1.equals("ja") == true) goto L9;
        if (r1.equals("ko") == true) goto L9;
        return true;
    }
}
