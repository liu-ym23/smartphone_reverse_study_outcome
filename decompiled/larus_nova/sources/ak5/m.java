package ak5;

import android.text.TextUtils;
import com.bytedance.ee.bear.net.CloudReqFun;
import com.bytedance.ee.bear.net.HttpException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Response;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f4037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f4038b;

    public m(o r100, com.bytedance.ee.bear.net.a.C3373a r101) {
        this.f4038b = r101;
        this.f4037a = r100;
    }

    public static FormBody a(Map r100, Map r101) {
        FormBody.Builder r102 = new FormBody.Builder();
        if (r100 == null) goto L8;
        Iterator r103 = r100.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry r104 = (Map.Entry) r103.next();
        r102.add((String) r104.getKey(), (String) r104.getValue());
    L8:
        if (r101 == null) goto L19;
        Iterator r105 = r101.keySet().iterator();
    L11:
        if (r105.hasNext() == false) goto L19;
        String r106 = (String) r105.next();
        List r107 = (List) r101.get(r106);
        if (r100 == null) goto L11;
        Iterator r108 = r107.iterator();
    L16:
        if (r108.hasNext() == false) goto L11;
        r102.add(r106, (String) r108.next());
    L19:
        return r102.build();
    }

    @Override // okhttp3.Callback
    public final void onFailure(Call r100, IOException r101) {
        com.bytedance.ee.bear.net.a.C3373a r102 = (com.bytedance.ee.bear.net.a.C3373a) this.f4038b;
        if (r102.f235102a.isCancelled() == true) goto L6;
        r102.f235102a.onError(new CloudReqFun.OkHttpReqException(r101));
        r102.f235102a.onComplete();
        return;
    }

    @Override // okhttp3.Callback
    public final void onResponse(Call r100, Response r101) {
        int r102 = r101.code();
        this.f4038b.getClass();
        String r103 = "";
        if (r100.request() == null) goto L5;
        String r104 = String.valueOf(r100.request().url());
    L20:
        if (r101.body() == null) goto L11;
        r103 = r101.body().string();     // Catch: IOException -> L10
    L11:
        tt5.a.b("OkHttpDataLoader", "onResponse() url = " + r104 + ", code = " + r102 + ", responseStr = " + r103 + ", responseHeaders = " + r101.headers());
        if (TextUtils.isEmpty(r103) == false) goto L14;
    L16:
        u r105 = this.f4038b;
        HttpException r106 = new HttpException(r102, r103);
        com.bytedance.ee.bear.net.a.C3373a r107 = (com.bytedance.ee.bear.net.a.C3373a) r105;
        if (r107.f235102a.isCancelled() == true) goto L23;
        r107.f235102a.onError(new CloudReqFun.OkHttpReqException(r106));
        r107.f235102a.onComplete();
        return;
    L23:
        return;
    L14:
        if (r102 != 200) goto L16;
        u r108 = this.f4038b;
        com.bytedance.ee.bear.net.a.C3373a r109 = (com.bytedance.ee.bear.net.a.C3373a) r108;
        r109.f235102a.onNext(new p(r104, r103, r101.headers().toMultimap()));
        r109.f235102a.onComplete();
        return;
    L5:
        r104 = "";
        goto L20
    }
}
