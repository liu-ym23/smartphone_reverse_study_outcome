package zb;

import com.obric.download.base.DownloadTask;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f26320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f26321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f26322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f26323d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26324e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f26325f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f26326g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f26327h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f26328i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Map f26329j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f26330k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f26331l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f26332m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f26333n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long[] f26334o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f26335p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f26336q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f26337r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f26338s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f26339t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f26340u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f26341v;

    public a(String r10) {
        q.g(r10, "url");
        this.f26341v = r10;
        this.f26320a = "";
        this.f26323d = "";
        this.f26336q = "";
        this.f26337r = 500;
    }

    public final a a(String r10) {
        q.g(r10, "apkPackageName");
        this.f26325f = r10;
        return this;
    }

    public final a b(List r10) {
        q.g(r10, "backupUrls");
        this.f26321b = r10;
        return this;
    }

    public final DownloadTask c() {
        return new DownloadTask(this.f26341v, this.f26320a, this.f26321b, this.f26322c, this.f26323d, this.f26324e, this.f26325f, this.f26326g, this.f26327h, this.f26328i, this.f26329j, this.f26330k, this.f26331l, this.f26332m, this.f26333n, this.f26335p, this.f26336q, this.f26334o, "", -1, this.f26338s, this.f26337r, this.f26339t, this.f26340u);
    }

    public final a d(String r10) {
        q.g(r10, "extraInfo");
        this.f26339t = r10;
        return this;
    }

    public final a e(boolean r10) {
        this.f26340u = r10;
        return this;
    }

    public final a f(String r10) {
        q.g(r10, "name");
        this.f26320a = r10;
        return this;
    }

    public final a g(boolean r10) {
        this.f26327h = r10;
        return this;
    }

    public final a h(boolean r10) {
        this.f26338s = r10;
        return this;
    }

    public final a i(int r10) {
        this.f26332m = r10;
        return this;
    }

    public final a j(String r10) {
        q.g(r10, "savePath");
        this.f26323d = r10;
        return this;
    }

    public final a k(int r10) {
        this.f26324e = r10;
        return this;
    }

    public final a l(boolean r10) {
        this.f26328i = r10;
        return this;
    }

    public final a m(String r10) {
        q.g(r10, "title");
        this.f26322c = r10;
        return this;
    }
}
