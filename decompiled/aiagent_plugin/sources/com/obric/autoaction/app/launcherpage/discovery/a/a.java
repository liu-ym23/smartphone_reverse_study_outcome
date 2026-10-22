package com.obric.autoaction.app.launcherpage.discovery.a;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: DiscoveryCategory.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.discovery.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiscoveryCategory.kt */
    public static final class C0523a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0523a f23571a = null;

        static {
            f23571a = new C0523a();
        }

        private C0523a() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: DiscoveryCategory.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f23572a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f23572a, r6.f23572a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f23572a.hashCode();
        }

        public String toString() {
            return "Group(title=" + this.f23572a + ')';
        }

        public b(String r2) {
            d.h.b.o.e(r2, DBDefinition.TITLE);
            super(null);
            this.f23572a = r2;
        }

        public final String a() {
            return this.f23572a;
        }
    }

    public /* synthetic */ a(d.h.b.h r1) {
        this();
    }

    private a() {
    }
}
