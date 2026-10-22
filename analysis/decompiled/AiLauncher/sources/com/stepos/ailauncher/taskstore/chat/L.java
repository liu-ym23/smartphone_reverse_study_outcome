package com.stepos.ailauncher.taskstore.chat;

import Z8.Y;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import u6.C5578a;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/H;", "", "c", "(Lcom/stepos/ailauncher/taskstore/chat/H;)Z", "", "", "IMAGE_EXTENSIONS", "Ljava/util/Set;", "taskstore_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class L {
    private static final Set<String> IMAGE_EXTENSIONS = Y.j("png", C5578a.DST_JPG, "jpeg", "gif", "webp", "bmp", "svg", "heic", "heif");

    /* JADX WARN: Removed duplicated region for block: B:13:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean c(com.stepos.ailauncher.taskstore.chat.TaskResultFileItem r6) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.p.i(r6, r0)
            java.lang.String r0 = r6.getMimeType()
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L34
            r3 = 59
            java.lang.String r0 = La.H.w1(r0, r3, r2, r1, r2)
            if (r0 == 0) goto L34
            java.lang.CharSequence r0 = La.H.D1(r0)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L34
            java.util.Locale r3 = java.util.Locale.ROOT
            java.lang.String r0 = r0.toLowerCase(r3)
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.p.h(r0, r3)
            if (r0 == 0) goto L34
            int r3 = r0.length()
            if (r3 <= 0) goto L34
            goto L35
        L34:
            r0 = r2
        L35:
            r3 = 0
            r4 = 1
            if (r0 == 0) goto L42
            java.lang.String r5 = "image/"
            boolean r0 = La.D.X(r0, r5, r3, r1, r2)
            if (r0 != r4) goto L42
            return r4
        L42:
            java.lang.String r0 = r6.getFileName()
            java.lang.String r6 = r6.getTitle()
            java.lang.String[] r6 = new java.lang.String[]{r0, r6}
            Ka.j r6 = Ka.t.w(r6)
            Ka.j r6 = kotlin.sequences.SequencesKt___SequencesKt.H(r6)
            com.stepos.ailauncher.taskstore.chat.J r0 = new com.stepos.ailauncher.taskstore.chat.J
            r0.<init>()
            Ka.j r6 = kotlin.sequences.SequencesKt___SequencesKt.R(r6, r0)
            com.stepos.ailauncher.taskstore.chat.K r0 = new com.stepos.ailauncher.taskstore.chat.K
            r0.<init>()
            Ka.j r6 = kotlin.sequences.SequencesKt___SequencesKt.R(r6, r0)
            java.util.Iterator r6 = r6.iterator()
        L6c:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L81
            java.lang.Object r0 = r6.next()
            java.lang.String r0 = (java.lang.String) r0
            java.util.Set<java.lang.String> r1 = com.stepos.ailauncher.taskstore.chat.L.IMAGE_EXTENSIONS
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L6c
            return r4
        L81:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.chat.L.c(com.stepos.ailauncher.taskstore.chat.H):boolean");
    }

    public static final String d(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        return La.H.w1(La.H.w1(it, '?', null, 2, null), '#', null, 2, null);
    }

    public static final String e(String it) {
        kotlin.jvm.internal.p.i(it, "it");
        String lowerCase = La.H.q1(it, '.', "").toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.p.h(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }
}
