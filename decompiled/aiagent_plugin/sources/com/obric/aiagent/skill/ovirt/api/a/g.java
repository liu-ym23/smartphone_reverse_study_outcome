package com.obric.aiagent.skill.ovirt.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: compiled from: FileSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g {

    /* JADX INFO: compiled from: FileSource.kt */
    public static final class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f20963a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20963a, r6.f20963a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20963a.hashCode();
        }

        public String toString() {
            return "HostFile(file=" + this.f20963a + ')';
        }

        public a(File r2) {
            o.e(r2, "file");
            this.f20963a = r2;
        }

        public final File a() {
            return this.f20963a;
        }
    }

    /* JADX INFO: compiled from: FileSource.kt */
    public static final class b implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InputStream f20964a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20964a, r6.f20964a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20964a.hashCode();
        }

        public String toString() {
            return "Stream(input=" + this.f20964a + ')';
        }

        public b(InputStream r2) {
            o.e(r2, "input");
            this.f20964a = r2;
        }

        public final InputStream a() {
            return this.f20964a;
        }
    }
}
