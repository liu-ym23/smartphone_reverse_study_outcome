package com.obric.autogui.agents.vlm.models.omni.upload;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.UUID;

/* JADX INFO: compiled from: OmniUploadAtomicFilePublisher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f28819a = null;

    /* JADX INFO: compiled from: OmniUploadAtomicFilePublisher.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f28820a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f28820a == r6.f28820a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f28820a);
        }

        public String toString() {
            return "Result(isNewFile=" + this.f28820a + ')';
        }

        public a(boolean r1) {
            this.f28820a = r1;
        }

        public final boolean a() {
            return this.f28820a;
        }
    }

    static {
        f28819a = new n();
    }

    private n() {
    }

    public final a a(File r4, byte[] r5) {
        d.h.b.o.e(r4, "target");
        d.h.b.o.e(r5, "bytes");
        File r3 = r4.getParentFile();
        a r0 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.exists() == false) goto L8;
    L10:
        String r1 = UUID.randomUUID().toString();
        d.h.b.o.c(r1, "toString(...)");
        File r6 = d.f.k.a(r3, o.a(r1));
    L22:
        th = move-exception;
        if (r6.exists() == false) goto L26;
        r6.delete();
    L26:
        throw th;
    L12:
        if (r4.exists() == true) goto L14;
        boolean r2 = true;
    L15:
        d.f.k.a(r6, r5);     // Catch: Throwable -> L22
        if (r6.renameTo(r4) == false) goto L19;
        r0 = new a(r2);     // Catch: Throwable -> L22
    L19:
        if (r6.exists() == false) goto L21;
        r6.delete();
    L21:
        return r0;
    L14:
        r2 = false;
        goto L15
    L8:
        if (r3.mkdirs() == true) goto L10;
        return null;
    }
}
