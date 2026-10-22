package org.apache.commons.compress.compressors;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class FileNameUtil {
    private final Map<String, String> compressSuffix;
    private final String defaultExtension;
    private final int longestCompressedSuffix;
    private final int longestUncompressedSuffix;
    private final int shortestCompressedSuffix;
    private final int shortestUncompressedSuffix;
    private final Map<String, String> uncompressSuffix;

    public FileNameUtil(Map<String, String> uncompressSuffix, String defaultExtension) {
        this.compressSuffix = new HashMap();
        this.uncompressSuffix = Collections.unmodifiableMap(uncompressSuffix);
        int lc = Integer.MIN_VALUE;
        int sc = Integer.MAX_VALUE;
        int lu = Integer.MIN_VALUE;
        int su = Integer.MAX_VALUE;
        Iterator<Map.Entry<String, String>> r4 = uncompressSuffix.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L20;
        Map.Entry<String, String> ent = r4.next();
        int cl = ent.getKey().length();
        if (cl <= lc) goto L8;
        lc = cl;
    L8:
        if (cl >= sc) goto L10;
        sc = cl;
    L10:
        String u = ent.getValue();
        int ul = u.length();
        if (ul <= 0) goto L4;
        if (this.compressSuffix.containsKey(u) == true) goto L15;
        this.compressSuffix.put(u, ent.getKey());
    L15:
        if (ul <= lu) goto L17;
        lu = ul;
    L17:
        if (ul >= su) goto L4;
        su = ul;
        goto L4
    L20:
        this.longestCompressedSuffix = lc;
        this.longestUncompressedSuffix = lu;
        this.shortestCompressedSuffix = sc;
        this.shortestUncompressedSuffix = su;
        this.defaultExtension = defaultExtension;
    }

    public boolean isCompressedFilename(String filename) {
        String lower = filename.toLowerCase(Locale.ENGLISH);
        int n = lower.length();
        int i = this.shortestCompressedSuffix;
    L4:
        if (i > this.longestCompressedSuffix) goto L11;
        if (i >= n) goto L16;
        if (this.uncompressSuffix.containsKey(lower.substring(n - i)) == true) goto L8;
        i = i + 1;
        goto L4
    L8:
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public String getUncompressedFilename(String filename) {
        String lower = filename.toLowerCase(Locale.ENGLISH);
        int n = lower.length();
        int i = this.shortestCompressedSuffix;
    L4:
        if (i > this.longestCompressedSuffix) goto L11;
        if (i >= n) goto L11;
        String suffix = this.uncompressSuffix.get(lower.substring(n - i));
        if (suffix != null) goto L9;
        i = i + 1;
        goto L4
    L9:
        return filename.substring(0, n - i) + suffix;
    L11:
        return filename;
    }

    public String getCompressedFilename(String filename) {
        String lower = filename.toLowerCase(Locale.ENGLISH);
        int n = lower.length();
        int i = this.shortestUncompressedSuffix;
    L4:
        if (i > this.longestUncompressedSuffix) goto L12;
        if (i >= n) goto L12;
        String suffix = this.compressSuffix.get(lower.substring(n - i));
        if (suffix != null) goto L9;
        i = i + 1;
        goto L4
    L9:
        return filename.substring(0, n - i) + suffix;
    L12:
        return filename + this.defaultExtension;
    }
}
