package com.danikula.videocache.file;

import android.text.TextUtils;
import com.bytedance.librarian.LibrarianImpl;
import com.danikula.videocache.ProxyCacheUtils;

/* JADX INFO: loaded from: classes2.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    private static final int MAX_EXTENSION_LENGTH = 4;

    public Md5FileNameGenerator() {
    }

    private String getExtension(String r10) {
        int r11 = r10.lastIndexOf(46);
        int r12 = r10.lastIndexOf(47);
        if (r11 == (-1)) goto L8;
        if (r11 <= r12) goto L8;
        if ((r11 + 6) <= r10.length()) goto L8;
        return r10.substring(r11 + 1, r10.length());
    L8:
        return "";
    }

    @Override // com.danikula.videocache.file.FileNameGenerator
    public String generate(String r10) {
        String r11 = getExtension(r10);
        String r12 = ProxyCacheUtils.computeMD5(r10);
        if (TextUtils.isEmpty(r11) == false) goto L6;
        return r12;
    L6:
        return r12 + LibrarianImpl.Constants.DOT + r11;
    }
}
