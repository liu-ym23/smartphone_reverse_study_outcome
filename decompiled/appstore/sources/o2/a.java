package o2;

import android.text.TextUtils;
import com.bytedance.apm6.util.ListUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f22464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f22465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f22466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List f22467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f22468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f22469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f22470g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22471h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22472i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f22473j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f22474k;

    public a() {
        this.f22468e = true;
        this.f22469f = true;
    }

    public int a() {
        return this.f22474k;
    }

    public List b() {
        return this.f22466c;
    }

    public int c() {
        return this.f22472i;
    }

    public int d() {
        return this.f22471h;
    }

    public int e() {
        return this.f22473j;
    }

    public long f() {
        return this.f22464a;
    }

    public long g() {
        return this.f22470g;
    }

    public List h() {
        return this.f22465b;
    }

    public List i() {
        return this.f22467d;
    }

    public boolean j() {
        return this.f22468e;
    }

    public void k(int r10) {
        this.f22474k = r10;
    }

    public void l(boolean r10) {
        this.f22468e = r10;
    }

    public void m(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        ArrayList r11 = new ArrayList();
        this.f22466c = r11;
        r11.add(r10);
    }

    public void n(int r10) {
        this.f22472i = r10;
    }

    public void o(int r10) {
        this.f22471h = r10;
    }

    public void p(int r10) {
        this.f22473j = r10;
    }

    public void q(long r10) {
        this.f22464a = r10;
    }

    public void r(long r10) {
        this.f22470g = r10;
    }

    public void s(List r10) {
        if (ListUtils.b(r10) == false) goto L5;
        return;
    L5:
        this.f22465b = r10;
    }

    public void t(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        ArrayList r11 = new ArrayList();
        this.f22467d = r11;
        r11.add(r10);
    }

    public String toString() {
        return "SlardarHandlerConfig{onceReportMaxSizeBytes=" + this.f22464a + ", reportUrlList=" + this.f22465b + ", exceptionUrl=" + this.f22466c + ", traceReportUrl=" + this.f22467d + ", isEncrypt=" + this.f22468e + ", isUploadInternalExcetpion=" + this.f22469f + ", reportInterval=" + this.f22470g + ", maxSizeMB=" + this.f22471h + ", keepDays=" + this.f22472i + ", maxSizeMBToday=" + this.f22473j + '}';
    }

    public void u(boolean r10) {
        this.f22469f = r10;
    }
}
