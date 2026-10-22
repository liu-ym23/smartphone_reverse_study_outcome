package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: InputContentInfoCompat.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0042c f1511a;

    /* JADX INFO: compiled from: InputContentInfoCompat.java */
    private static final class a implements InterfaceC0042c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final InputContentInfo f1512a;

        a(Object r3) {
            this.f1512a = (InputContentInfo) ZeusTransformUtils.preCheckCast(r3, InputContentInfo.class, "com.obric.aiagent.plugin");
        }

        a(Uri r2, ClipDescription r3, Uri r4) {
            this.f1512a = new InputContentInfo(r2, r3, r4);
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public Uri a() {
            return this.f1512a.getContentUri();
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public ClipDescription b() {
            return this.f1512a.getDescription();
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public Uri c() {
            return this.f1512a.getLinkUri();
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public Object d() {
            return this.f1512a;
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public void e() {
            this.f1512a.requestPermission();
        }
    }

    /* JADX INFO: compiled from: InputContentInfoCompat.java */
    private static final class b implements InterfaceC0042c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f1513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ClipDescription f1514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Uri f1515c;

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public Object d() {
            return null;
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public void e() {
        }

        b(Uri r1, ClipDescription r2, Uri r3) {
            this.f1513a = r1;
            this.f1514b = r2;
            this.f1515c = r3;
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public Uri a() {
            return this.f1513a;
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public ClipDescription b() {
            return this.f1514b;
        }

        @Override // androidx.core.view.inputmethod.c.InterfaceC0042c
        public Uri c() {
            return this.f1515c;
        }
    }

    /* JADX INFO: renamed from: androidx.core.view.inputmethod.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: InputContentInfoCompat.java */
    private interface InterfaceC0042c {
        Uri a();

        ClipDescription b();

        Uri c();

        Object d();

        void e();
    }

    public c(Uri r3, ClipDescription r4, Uri r5) {
        if (Build.VERSION.SDK_INT < 25) goto L5;
        this.f1511a = new a(r3, r4, r5);
        return;
    L5:
        this.f1511a = new b(r3, r4, r5);
    }

    private c(InterfaceC0042c r3) {
        this.f1511a = (InterfaceC0042c) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0042c.class, "com.obric.aiagent.plugin");
    }

    public Uri a() {
        return this.f1511a.a();
    }

    public ClipDescription b() {
        return this.f1511a.b();
    }

    public Uri c() {
        return this.f1511a.c();
    }

    public static c a(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (Build.VERSION.SDK_INT >= 25) goto L9;
        return null;
    L9:
        return new c(new a(r3));
    }

    public Object d() {
        return this.f1511a.d();
    }

    public void e() {
        this.f1511a.e();
    }
}
