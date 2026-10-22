package com.obric.autogui.resourcemanage;

import java.io.File;

/* JADX INFO: compiled from: ResourceFileSelector.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface s {

    /* JADX INFO: compiled from: ResourceFileSelector.kt */
    public static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f30684a;

        public a(String r2) {
            d.h.b.o.e(r2, "extension");
            this.f30684a = r2;
        }

        @Override // com.obric.autogui.resourcemanage.s
        public File a(File r5) {
            d.h.b.o.e(r5, "installDir");
            return a(r5, String.valueOf(d.o.o.b(this.f30684a, new char[]{'.'})));
        }

        private final File a(File r13, String r14) {
            if (r13.isDirectory() == true) goto L5;
            return null;
        L5:
            File[] r15 = r13.listFiles();
            if (r15 != null) goto L8;
            return null;
        L8:
            int r0 = r15.length;
            int r2 = 0;
            int r3 = 0;
        L9:
            if (r3 >= r0) goto L19;
            File r4 = r15[r3];
            if (r4.isFile() == false) goto L18;
            String r6 = r4.getAbsolutePath();
            String r5 = r4.getName();
            d.h.b.o.c(r5, "getName(...)");
            if (d.o.o.b(r5, "._", false, 2, null) == false) goto L15;
            d.h.b.o.a(r6);
            r6 = d.o.o.a(r6, "._", "", false, 4, null);
        L15:
            d.h.b.o.a(r6);
            if (d.o.o.c(r6, r14, true) == false) goto L18;
            return r4;
        L18:
            r3 = r3 + 1;
            goto L9
        L19:
            int r1 = r15.length;
        L20:
            if (r2 >= r1) goto L27;
            File r7 = r15[r2];
            if (r7.isDirectory() == false) goto L26;
            d.h.b.o.a(r7);
            File r8 = a(r7, r14);
            if (r8 == null) goto L26;
            return r8;
        L26:
            r2 = r2 + 1;
            goto L20
        L27:
            return null;
        }
    }

    File a(File r1);
}
