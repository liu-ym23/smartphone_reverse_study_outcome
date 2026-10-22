package cl5;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f24109a;

    public static class a implements NetService.c<Result<?>> {
        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<?> parse(String r100) {
            Result<?> r101 = new Result();
            r101.code = new JSONObject(r100).optInt("code", 0);     // Catch: JSONException -> L5
        L7:
            return r101;
        L5:
            e = move-exception;
            tt5.a.d("OperationInfoRequester", "BusinessInfoResultParser() exception = " + e);
            goto L7
        }
    }

    public f(NetService r100) {
        this.f24109a = r100;
    }
}
