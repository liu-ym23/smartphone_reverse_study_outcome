package a15;

import android.text.TextUtils;
import b15.b;
import b15.c;
import com.bytedance.ee.bear.contract.d;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.LarkContext;
import e0c.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f1373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f1374b;

    /* JADX INFO: renamed from: a15.a$a, reason: collision with other inner class name */
    public static final class C0002a {
    }

    static {
    }

    public abstract void c();

    public abstract void e();

    public abstract void f(String r100);

    public abstract void g();

    public abstract void h(String r100, String r101, String r102, String r103, String r104);

    public abstract void j();

    public abstract void k(String r100);

    public abstract void l(String r100);

    public abstract void m();

    public abstract void n(String r100, String r101, String r102);

    public abstract void p();

    public a(d r100) {
        this.f1373a = r100;
        this.f1374b = new HashMap();
        if (r100 == null) goto L5;
        HashMap<String, Object> r101 = r100.m("docCommonParams");
    L6:
        if (r101 == null) goto L11;
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Map.Entry<String, Object> r103 = r102.next();
        this.f1374b.put(r103.getKey(), r103.getValue());
        goto L9
    L13:
        return;
    L11:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HashMap r101 = new HashMap(2);
        r101.put("click", "back");
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        q(r100, r101);
    }

    @JvmStatic
    public static final a a(d r100, int r101) {
        if (r101 != 22) goto L6;
        return new b(r100);
    L6:
        if (r101 != 3) goto L9;
        return new c(r100);
    L9:
        return new b15.a(r100);
    }

    @JvmStatic
    public static final a b(d r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "url");
        int r102 = ((t45.c) k.a(LarkContext.getApplication(), t45.c.class)).Z(r101).a();
        if (r102 != 22) goto L6;
        return new b(r100);
    L6:
        if (r102 != 3) goto L9;
        return new c(r100);
    L9:
        return new b15.a(r100);
    }

    public final void q(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Intrinsics.checkNotNullParameter(r101, "params");
        ((HashMap) r101).putAll(this.f1374b);
        tt5.a.b("EditionAnalytic", "reportEventV2: event = " + r100 + ", params = " + r101);
        d r102 = this.f1373a;
        if (r102 == null) goto L6;
        r102.n(r100, r101);
        return;
    }

    public final void o(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HashMap r104 = new HashMap();
        r104.put("click", r101);
        r104.put(PickerReporterConstants.KEY.TARGET, r103);
        r104.put("target_version_id", r102);
        q(r100, r104);
    }

    public final void i(String r100, String r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "event");
        HashMap r106 = new HashMap(2);
        r106.put("click", r101);
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r106.put(PickerReporterConstants.KEY.TARGET, r102);
    L6:
        if (TextUtils.isEmpty(r103) == true) goto L9;
        r106.put("show_type", r103);
    L9:
        if (TextUtils.isEmpty(r104) == true) goto L12;
        r106.put("download_type", r104);
    L12:
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r106.put(CommonConstant.ReqAccessTokenParam.LANGUAGE_LABEL, r105);
    L14:
        q(r100, r106);
    }
}
