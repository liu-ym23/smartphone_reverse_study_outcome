package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: ContentInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f1486a;

    /* JADX INFO: compiled from: ContentInfoCompat.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC0040b f1487a;

        public a(ClipData r3, int r4) {
            if (Build.VERSION.SDK_INT < 31) goto L5;
            this.f1487a = new c(r3, r4);
            return;
        L5:
            this.f1487a = new d(r3, r4);
        }

        public a a(int r2) {
            this.f1487a.a(r2);
            return this;
        }

        public a a(Uri r2) {
            this.f1487a.a(r2);
            return this;
        }

        public a a(Bundle r2) {
            this.f1487a.a(r2);
            return this;
        }

        public b a() {
            return this.f1487a.a();
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContentInfoCompat.java */
    private interface InterfaceC0040b {
        b a();

        void a(int r1);

        void a(Uri r1);

        void a(Bundle r1);
    }

    /* JADX INFO: compiled from: ContentInfoCompat.java */
    private static final class c implements InterfaceC0040b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentInfo.Builder f1488a;

        c(ClipData r2, int r3) {
            this.f1488a = new ContentInfo.Builder(r2, r3);
        }

        @Override // androidx.core.view.b.InterfaceC0040b
        public void a(int r1) {
            this.f1488a.setFlags(r1);
        }

        @Override // androidx.core.view.b.InterfaceC0040b
        public void a(Uri r1) {
            this.f1488a.setLinkUri(r1);
        }

        @Override // androidx.core.view.b.InterfaceC0040b
        public void a(Bundle r1) {
            this.f1488a.setExtras(r1);
        }

        @Override // androidx.core.view.b.InterfaceC0040b
        public b a() {
            return new b(new f(this.f1488a.build()));
        }
    }

    /* JADX INFO: compiled from: ContentInfoCompat.java */
    private static final class d implements InterfaceC0040b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ClipData f1489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1490b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f1491c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Uri f1492d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Bundle f1493e;

        d(ClipData r1, int r2) {
            this.f1489a = r1;
            this.f1490b = r2;
        }

        @Override // androidx.core.view.b.InterfaceC0040b
        public void a(int r1) {
            this.f1491c = r1;
        }

        @Override // androidx.core.view.b.InterfaceC0040b
        public void a(Uri r1) {
            this.f1492d = r1;
        }

        @Override // androidx.core.view.b.InterfaceC0040b
        public void a(Bundle r1) {
            this.f1493e = r1;
        }

        @Override // androidx.core.view.b.InterfaceC0040b
        public b a() {
            return new b(new g(this));
        }
    }

    /* JADX INFO: compiled from: ContentInfoCompat.java */
    private interface e {
        ContentInfo a();

        ClipData b();

        int c();

        int d();
    }

    /* JADX INFO: compiled from: ContentInfoCompat.java */
    private static final class f implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentInfo f1494a;

        f(ContentInfo r3) {
            this.f1494a = (ContentInfo) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r3), ContentInfo.class, "com.obric.aiagent.plugin");
        }

        @Override // androidx.core.view.b.e
        public ContentInfo a() {
            return this.f1494a;
        }

        @Override // androidx.core.view.b.e
        public ClipData b() {
            return this.f1494a.getClip();
        }

        @Override // androidx.core.view.b.e
        public int c() {
            return this.f1494a.getSource();
        }

        @Override // androidx.core.view.b.e
        public int d() {
            return this.f1494a.getFlags();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.f1494a + "}";
        }
    }

    /* JADX INFO: compiled from: ContentInfoCompat.java */
    private static final class g implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ClipData f1495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1497c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Uri f1498d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Bundle f1499e;

        @Override // androidx.core.view.b.e
        public ContentInfo a() {
            return null;
        }

        g(d r5) {
            this.f1495a = (ClipData) ZeusTransformUtils.preCheckCast(androidx.core.util.g.a(r5.f1489a), ClipData.class, "com.obric.aiagent.plugin");
            this.f1496b = androidx.core.util.g.a(r5.f1490b, 0, 5, DBHelper.BATTERY_COL_SOURCE);
            this.f1497c = androidx.core.util.g.a(r5.f1491c, 1);
            this.f1498d = r5.f1492d;
            this.f1499e = r5.f1493e;
        }

        @Override // androidx.core.view.b.e
        public ClipData b() {
            return this.f1495a;
        }

        @Override // androidx.core.view.b.e
        public int c() {
            return this.f1496b;
        }

        @Override // androidx.core.view.b.e
        public int d() {
            return this.f1497c;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder().append("ContentInfoCompat{clip=").append(this.f1495a.getDescription()).append(", source=").append(b.a(this.f1496b)).append(", flags=").append(b.b(this.f1497c));
            String r2 = "";
            if (this.f1498d != null) goto L5;
            String r1 = "";
        L6:
            StringBuilder r3 = r0.append(r1);
            if (this.f1499e == null) goto L11;
            r2 = ", hasExtras";
        L11:
            return r3.append(r2).append("}").toString();
        L5:
            r1 = ", hasLinkUri(" + this.f1498d.toString().length() + ")";
            goto L6
        }
    }

    static String a(int r1) {
        if (r1 != 0) goto L4;
        return "SOURCE_APP";
    L4:
        if (r1 != 1) goto L6;
        return "SOURCE_CLIPBOARD";
    L6:
        if (r1 != 2) goto L8;
        return "SOURCE_INPUT_METHOD";
    L8:
        if (r1 != 3) goto L10;
        return "SOURCE_DRAG_AND_DROP";
    L10:
        if (r1 != 4) goto L12;
        return "SOURCE_AUTOFILL";
    L12:
        if (r1 != 5) goto L14;
        return "SOURCE_PROCESS_TEXT";
    L14:
        return String.valueOf(r1);
    }

    static String b(int r1) {
        if ((r1 & 1) == 0) goto L7;
        return "FLAG_CONVERT_TO_PLAIN_TEXT";
    L7:
        return String.valueOf(r1);
    }

    b(e r3) {
        this.f1486a = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
    }

    public static b a(ContentInfo r2) {
        return new b(new f(r2));
    }

    public ContentInfo a() {
        return (ContentInfo) ZeusTransformUtils.preCheckCast(Objects.requireNonNull(this.f1486a.a()), ContentInfo.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        return this.f1486a.toString();
    }

    public ClipData b() {
        return this.f1486a.b();
    }

    public int c() {
        return this.f1486a.c();
    }

    public int d() {
        return this.f1486a.d();
    }
}
