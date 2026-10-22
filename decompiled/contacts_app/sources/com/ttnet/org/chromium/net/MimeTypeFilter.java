package com.ttnet.org.chromium.net;

import android.net.Uri;
import android.webkit.MimeTypeMap;
import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.io.FileFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class MimeTypeFilter implements FileFilter {
    private boolean mAcceptAllMimeTypes;
    private boolean mAcceptDirectory;
    private HashSet<String> mExtensions;
    private HashSet<String> mMimeSupertypes;
    private MimeTypeMap mMimeTypeMap;
    private HashSet<String> mMimeTypes;

    public MimeTypeFilter(List<String> r5, boolean r6) {
        this.mExtensions = new HashSet();
        this.mMimeTypes = new HashSet();
        this.mMimeSupertypes = new HashSet();
        Iterator<String> r7 = r5.iterator();
    L4:
        if (r7.hasNext() == false) goto L17;
        String r0 = r7.next().trim().toLowerCase(Locale.US);
        if (r0.startsWith(LibrarianImpl.Constants.DOT) == true) goto L7;
        if (r0.equals("*/*") == true) goto L10;
        if (r0.endsWith("/*") == true) goto L13;
        if (r0.contains(LibrarianImpl.Constants.SEPARATOR) == false) goto L4;
        this.mMimeTypes.add(r0);
        goto L4
    L13:
        this.mMimeSupertypes.add(r0.substring(0, r0.length() - 2));
        goto L4
    L10:
        this.mAcceptAllMimeTypes = true;
        goto L4
    L7:
        this.mExtensions.add(r0.substring(1));
        goto L4
    L17:
        this.mMimeTypeMap = MimeTypeMap.getSingleton();
        this.mAcceptDirectory = r6;
    }

    public boolean accept(Uri r3, String r4) {
        if (r3 == null) goto L9;
        String r5 = MimeTypeMap.getFileExtensionFromUrl(r3.toString()).toLowerCase(Locale.US);
        if (this.mExtensions.contains(r5) == false) goto L7;
        return true;
    L7:
        if (r4 != null) goto L9;
        r4 = getMimeTypeFromExtension(r5);
    L9:
        if (r4 != null) goto L11;
        return false;
    L11:
        if (this.mAcceptAllMimeTypes == false) goto L13;
    L16:
        return true;
    L13:
        if (this.mMimeTypes.contains(r4) == true) goto L16;
        if (this.mMimeSupertypes.contains(getMimeSupertype(r4)) == true) goto L16;
        return false;
    }

    @Override // java.io.FileFilter
    public boolean accept(File r2) {
        if (r2.isDirectory() == false) goto L7;
        return this.mAcceptDirectory;
    L7:
        return accept(Uri.fromFile(r2), null);
    }

    private String getMimeTypeFromExtension(String r1) {
        String r0 = this.mMimeTypeMap.getMimeTypeFromExtension(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toLowerCase(Locale.US);
    }

    private static String getMimeSupertype(String r2) {
        return r2.split(LibrarianImpl.Constants.SEPARATOR, 2)[0];
    }
}
