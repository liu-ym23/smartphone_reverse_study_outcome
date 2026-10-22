package com.obric.aiagent.skill.virt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: VirtFileBridge.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: VirtFileBridge.kt */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f21558a = null;

        static {
            f21558a = new a();
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
            return -1729348944;
        }

        public String toString() {
            return "Default";
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: VirtFileBridge.kt */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f21559a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f21559a, r6.f21559a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f21559a.hashCode();
        }

        public String toString() {
            return "HostFile(file=" + this.f21559a + ')';
        }

        public b(File r2) {
            d.h.b.o.e(r2, "file");
            this.f21559a = r2;
        }

        public final File a() {
            return this.f21559a;
        }
    }
}
