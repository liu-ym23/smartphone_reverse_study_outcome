package com.apm.insight.log.a;

import com.apm.insight.log.a.b;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class c implements FilenameFilter {

    /* renamed from: a, reason: collision with root package name */
    private /* synthetic */ ArrayList f2191a;
    private /* synthetic */ Pattern b;
    private /* synthetic */ long c;
    private /* synthetic */ long d;
    private /* synthetic */ ArrayList e;

    public c(ArrayList arrayList, Pattern pattern, long j5, long j6, ArrayList arrayList2) {
        this.f2191a = arrayList;
        this.b = pattern;
        this.c = j5;
        this.d = j6;
        this.e = arrayList2;
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) throws NumberFormatException {
        String strGroup;
        this.f2191a.add(str);
        Matcher matcher = this.b.matcher(str);
        if (!matcher.find() || matcher.groupCount() != 1 || (strGroup = matcher.group(1)) == null) {
            return false;
        }
        long j5 = Long.parseLong(strGroup);
        if (j5 > 0 && j5 <= this.c) {
            File file2 = new File(file, str);
            long jLastModified = file2.lastModified();
            if (jLastModified > 0 && jLastModified >= this.d) {
                ArrayList arrayList = this.e;
                if (arrayList != null) {
                    arrayList.add(new b.a(file2, j5));
                }
                return true;
            }
        }
        return false;
    }
}
