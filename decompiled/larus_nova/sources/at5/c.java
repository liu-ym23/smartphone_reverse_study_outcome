package at5;

import com.bytedance.ee.larkwebview.bridge.Status;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements j18.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f16250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f16251b;

    @Override // j18.c
    public final void onSuccess(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "successParams");
        Log.d("JSBridge", this.f16250a + " handled by plugin success");
        this.f16251b.a(Status.SUCCESS, r100);
    }

    public c(String r100, d r101) {
        this.f16250a = r100;
        this.f16251b = r101;
    }

    @Override // j18.c
    public final void onFail(int r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "failParams");
        Log.e("JSBridge", this.f16250a + " handled by plugin failed");
        this.f16251b.a(Status.FAILURE, r101);
    }
}
