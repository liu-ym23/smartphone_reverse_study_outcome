package ara;

import com.bytedance.bdturing.loginverify.LoginVerifyService;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class k extends ua7.a<xa7.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.a.b f16061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j.a.InterfaceC0214a f16062b;

    public final void a(xa7.c r100) {
        this.f16062b.a(r100);
        int r101 = a.f16045a;
        String r102 = this.f16061a.f16058g;
        long r103 = System.currentTimeMillis() - this.f16061a.f16057f;
        JSONObject r104 = new JSONObject();
        String r105 = this.f16061a.f16056e;
        if (r105 != null) goto L5;
    L10:
        r104.put("path", this.f16061a.f16055d);
        r104.put(com.alipay.sdk.m.p.e.f25671s, this.f16061a.f16053b);
        String r106 = r104.toString();
        JSONObject r107 = new JSONObject();
        if (r100 == null) goto L15;
        r107.put("code", r100.f549253g);
        String r108 = r100.f549255i;
        if (r108 == null) goto L15;
        r107.put("message", r108);
    L15:
        a.b(r102, r106, r107.toString(), r103, null, 112);
        return;
    L5:
        if (r105.length() <= 0) goto L7;
        boolean r109 = true;
    L8:
        if (r109 != true) goto L10;
        r104.put("host", this.f16061a.f16056e);
        goto L10
    L7:
        r109 = false;
        goto L8
    }

    @Override // ua7.a
    public final /* bridge */ /* synthetic */ void onResponse(ua7.b r100) {
        a((xa7.c) r100);
    }

    @Override // ua7.a
    public final Map onSendBDAccountEvent(ua7.b r100) {
        xa7.c r101 = (xa7.c) r100;
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = this.f16061a.f16054c;
        if (r103 != null) goto L6;
        r103 = "";
    L6:
        r102.put("callback_schema", r103);
        String r104 = null;
        if (r101 == null) goto L9;
        com.ss.android.account.d r105 = r101.f549279p;
    L10:
        if (r105 != null) goto L12;
    L32:
        return r102;
    L12:
        if (r101.f549279p.f541360a <= 0) goto L32;
        Iterator<T> r106 = r101.f549258l.iterator();
    L15:
        if (r106.hasNext() == false) goto L19;
        Object r107 = r106.next();
        if (StringsKt.equals(LoginVerifyService.X_TT_TOKEN, ((wqa.i) r107).f560775a, true) == false) goto L15;
    L20:
        wqa.i r108 = (wqa.i) r107;
        if (r108 == null) goto L23;
        r104 = r108.f560776b;
    L23:
        if (r104 != null) goto L25;
    L28:
        boolean r109 = true;
    L30:
        if ((!r109) == false) goto L32;
        tb7.a.d("UcSdkFetchMethod", "path=" + this.f16061a.f16055d + ", response has userInfo, not has x-tt-token");
        r102.put("scene", "h5_login");
        goto L32
    L25:
        if (r104.length() == 0) goto L28;
        r109 = false;
        goto L30
    L19:
        r107 = null;
        goto L20
    L9:
        r105 = null;
        goto L10
    }

    public k(j.a.b r100, l r101) {
        this.f16061a = r100;
        this.f16062b = r101;
    }
}
