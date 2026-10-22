package com.obric.aiagent.skill.ovirt.api.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.File;

/* JADX INFO: compiled from: FileTransferResult.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d {

    /* JADX INFO: compiled from: FileTransferResult.kt */
    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20954a = null;

        static {
            f20954a = new a();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, a.class) == true) goto L9;
            return false;
        L9:
            a r2 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1119037747;
        }

        public String toString() {
            return "Default";
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: FileTransferResult.kt */
    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f20955a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f20955a, r6.f20955a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f20955a.hashCode();
        }

        public String toString() {
            return "HostFile(file=" + this.f20955a + ')';
        }

        public b(File r2) {
            o.e(r2, "file");
            this.f20955a = r2;
        }

        public final File a() {
            return this.f20955a;
        }
    }
}
