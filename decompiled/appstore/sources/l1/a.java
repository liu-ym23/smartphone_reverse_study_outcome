package l1;

import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.data.pipeline.ICommonDataInnerListener;
import org.json.JSONObject;
import w0.c;

/* JADX INFO: loaded from: classes.dex */
public class a extends k1.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static volatile a f21793h;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ICommonDataInnerListener f21794g;

    public a() {
    }

    public static a p() {
        if (f21793h != null) goto L16;
        monitor-enter(a.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f21793h != null) goto L11;
        f21793h = new a();     // Catch: Throwable -> L9
    L11:
        monitor-exit(a.class);     // Catch: Throwable -> L9
    L16:
        return f21793h;
    }

    @Override // k1.a
    public void f(ITypeData r10) {
        JSONObject r11 = r10.packLog();
        boolean r12 = r10.isSampled(r11);
        if (c.B() == true) goto L16;
    L8:
        if (r12 == false) goto L10;
    L12:
        l(r10.getTypeLabel(), r10.getSubTypeLabel(), r11, r12, false);
        ICommonDataInnerListener r13 = this.f21794g;
        if (r13 == null) goto L18;
        r13.deliver(r10.getTypeLabel(), r10.getSubTypeLabel(), r11);
        return;
    L18:
        return;
    L10:
        if (r10.supportFetch() == true) goto L12;
        return;
    L16:
        s1.c.e(s1.b.f24487e, new Object[]{"logType: " + r10.getTypeLabel() + ", subType: " + r10.getSubTypeLabel() + "data: " + r11, " ,sample: " + r12});     // Catch: Exception -> L6
    L6:
        e = move-exception;
        e.printStackTrace();
        goto L8
    }

    public void q(ICommonDataInnerListener r10) {
        this.f21794g = r10;
    }
}
