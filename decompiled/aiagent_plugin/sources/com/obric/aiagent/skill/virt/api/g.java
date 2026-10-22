package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: compiled from: VirtFileBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: compiled from: VirtFileBridge.kt */
    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f21569a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21569a, r6.f21569a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f21569a.hashCode();
        }

        public String toString() {
            return "HostDirectory(dir=" + this.f21569a + ')';
        }

        public a(File r2) {
            d.h.b.o.e(r2, "dir");
            this.f21569a = r2;
        }

        public final File a() {
            return this.f21569a;
        }
    }

    /* JADX INFO: compiled from: VirtFileBridge.kt */
    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f21570a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21570a, r6.f21570a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f21570a.hashCode();
        }

        public String toString() {
            return "HostFile(file=" + this.f21570a + ')';
        }

        public b(File r2) {
            d.h.b.o.e(r2, "file");
            this.f21570a = r2;
        }

        public final File a() {
            return this.f21570a;
        }
    }

    /* JADX INFO: compiled from: VirtFileBridge.kt */
    public static final class c implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f21571a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21572b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21571a, r6.f21571a) == true) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f21572b, r6.f21572b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.f21571a.hashCode() * 31;
            String r1 = this.f21572b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Stream(input=" + this.f21571a + ", suggestedName=" + this.f21572b + ')';
        }

        public c(InputStream r2, String r3) {
            d.h.b.o.e(r2, "input");
            this.f21571a = r2;
            this.f21572b = r3;
        }

        public final InputStream a() {
            return this.f21571a;
        }

        public final String b() {
            return this.f21572b;
        }
    }
}
