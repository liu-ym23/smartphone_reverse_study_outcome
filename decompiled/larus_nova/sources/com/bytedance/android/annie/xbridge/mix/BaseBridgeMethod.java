package com.bytedance.android.annie.xbridge.mix;

import androidx.lifecycle.LifecycleObserver;
import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/BaseBridgeMethod;", "Lz36/a;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/bytedance/sdk/xbridge/cn/protocol/h;", "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseBridgeMethod extends z36.a implements LifecycleObserver, com.bytedance.sdk.xbridge.cn.protocol.h {

    public static final class a extends com.bytedance.android.annie.xbridge.mix.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IBridgeMethod.a f40125a;

        public a(IBridgeMethod.a r100) {
            this.f40125a = r100;
        }

        public final void a(String r100) {
            IBridgeMethod.a r101 = this.f40125a;
            if (r100 != null) goto L5;
            r100 = "";
        L5:
            r101.onError(-1, r100);
        }

        public final void b(JSONObject r100) {
            this.f40125a.onComplete(r100);     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    public void b(JSONObject r100, a r101) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
    }

    public BaseBridgeMethod(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod
    public final void b70(JSONObject r100, IBridgeMethod.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        b(r100, new a(r101));
    }
}
