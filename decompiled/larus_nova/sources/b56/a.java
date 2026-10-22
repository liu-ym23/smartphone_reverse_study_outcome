package b56;

import android.content.Context;
import c56.b;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f17757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f17758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f17762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c56.a f17763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<String> f17764h;

    /* JADX INFO: renamed from: b56.a$a, reason: collision with other inner class name */
    public static class C0266a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f17765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f17766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17767c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f17768d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f17769e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public b f17770f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c56.a f17771g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final List<String> f17772h;

        public C0266a() {
            this.f17768d = true;
            this.f17772h = new ArrayList();
        }
    }

    public Context getContext() {
        return this.f17757a;
    }

    public a(C0266a r100) {
        this.f17757a = r100.f17765a;
        this.f17758b = r100.f17766b;
        boolean r101 = r100.f17769e;
        this.f17761e = r101;
        boolean r102 = false;
        if (r101 == false) goto L5;
        this.f17759c = false;
        this.f17760d = false;
    L11:
        this.f17762f = r100.f17770f;
        this.f17763g = r100.f17771g;
        this.f17764h = r100.f17772h;
        return;
    L5:
        boolean r103 = r100.f17767c;
        this.f17759c = r103;
        if (r103 == false) goto L8;
    L10:
        this.f17760d = r102;
        goto L11
    L8:
        if (r100.f17768d == false) goto L10;
        r102 = true;
        goto L10
    }
}
