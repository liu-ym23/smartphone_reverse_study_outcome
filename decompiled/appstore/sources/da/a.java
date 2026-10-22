package da;

import com.monitor.cloudmessage.upload.callback.IFileUploadCallback;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class a extends b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f19130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public IFileUploadCallback f19131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f19132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f19133k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f19134l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f19135m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f19136n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f19137o;

    public a(String r10, long r11, boolean r12, String r13, IFileUploadCallback r14, HashMap r15) {
        super(r11, r12, r13, r15);
        this.f19132j = true;
        this.f19133k = true;
        this.f19134l = true;
        this.f19135m = false;
        this.f19136n = false;
        this.f19130h = r10;
        this.f19131i = r14;
    }

    public IFileUploadCallback j() {
        return this.f19131i;
    }

    public String k() {
        return this.f19130h;
    }

    public List l() {
        return this.f19137o;
    }

    public boolean m() {
        return this.f19133k;
    }

    public boolean n() {
        return this.f19135m;
    }

    public boolean o() {
        return this.f19136n;
    }

    public boolean p() {
        return this.f19134l;
    }

    public boolean q() {
        return this.f19132j;
    }

    public void r(boolean r10) {
        this.f19133k = r10;
    }

    public void s(boolean r10) {
        this.f19135m = r10;
    }

    public void t(boolean r10) {
        this.f19136n = r10;
    }

    public void u(List r10) {
        this.f19137o = r10;
    }
}
