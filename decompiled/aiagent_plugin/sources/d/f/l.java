package d.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: FilePathComponents.kt */
/* JADX INFO: loaded from: classes4.dex */
class l {
    private static final int a(String r9) {
        int r0 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), File.separatorChar, 0, false, 4, null);
        if (r0 != 0) goto L18;
        if (r9.length() > 1) goto L7;
    L16:
        return 1;
    L7:
        if (r9.charAt(1) != File.separatorChar) goto L16;
        int r1 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), File.separatorChar, 2, false, 4, null);
        if (r1 < 0) goto L16;
        int r2 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), File.separatorChar, r1 + 1, false, 4, null);
        if (r2 < 0) goto L15;
        return r2 + 1;
    L15:
        return r9.length();
    L18:
        if (r0 <= 0) goto L24;
        if (r9.charAt(r0 - 1) != ':') goto L24;
        return r0 + 1;
    L24:
        if (r0 == (-1)) goto L26;
    L29:
        return 0;
    L26:
        if (d.o.o.b((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.aiagent.plugin"), ':', false, 2, null) == false) goto L29;
        return r9.length();
    }

    public static final boolean a(File r1) {
        d.h.b.o.e(r1, "<this>");
        String r2 = r1.getPath();
        d.h.b.o.c(r2, "getPath(...)");
        if (a(r2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final g b(File r11) {
        d.h.b.o.e(r11, "<this>");
        String r12 = r11.getPath();
        d.h.b.o.a(r12);
        int r0 = a(r12);
        String r2 = r12.substring(0, r0);
        d.h.b.o.c(r2, "substring(...)");
        String r13 = r12.substring(r0);
        d.h.b.o.c(r13, "substring(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        List r14 = d.a.p.b();
    L14:
        return new g(new File(r2), r14);
    L8:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin"), new char[]{File.separatorChar}, false, 0, 6, null), Iterable.class, "com.obric.aiagent.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(d.a.p.a(r15, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r16 = r15.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        r3.add(new File((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.aiagent.plugin")));
        goto L10
    L12:
        r14 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.aiagent.plugin");
        goto L14
    L5:
        r1 = false;
        goto L6
    }
}
