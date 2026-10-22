package com.bytedance.android.annie.xbridge.mix;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleObserver;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/xbridge/mix/BaseA2BBridgeMethod;", "Lcom/bytedance/ies/bullet/core/kit/bridge/j;", "Landroidx/lifecycle/LifecycleObserver;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "annie_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseA2BBridgeMethod extends com.bytedance.ies.bullet.core.kit.bridge.j implements LifecycleObserver {

    public interface a {

        /* JADX INFO: renamed from: com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC0752a implements a {
            public AbstractC0752a() {
            }
        }

        void a(JSONObject r100);

        void onFailed(Throwable r100);

        void onSucceed(Object r100);
    }

    public static final class b extends a.AbstractC0752a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.bullet.service.base.bridge.b.a f40124a;

        public b(com.bytedance.ies.bullet.service.base.bridge.b.a r100) {
            this.f40124a = r100;
        }

        @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod.a
        public final void a(JSONObject r100) {
            com.bytedance.ies.bullet.service.base.bridge.b.a r101 = this.f40124a;
            if (r100 != null) goto L5;
            r100 = null;
        L8:
            r101.a(r100);
            return;
        L5:
            if (com.bytedance.ies.bullet.service.base.h.n() == false) goto L8;
            r100.put("ignoreJSB2Error", 1);
            goto L8
        }

        public final void b(Object r100) {
            if (r100 != null) goto L4;
        L8:
            JSONObject r101 = null;
        L9:
            if (r101 == null) goto L11;
            this.f40124a.a(r101);
            return;
        L11:
            this.f40124a.a(c.c(r100));
            return;
        L4:
            if ((r100 instanceof JSONObject) == false) goto L8;
            ((JSONObject) r100).put("code", 1);     // Catch: JSONException -> L13
            r101 = (JSONObject) r100;     // Catch: JSONException -> L13
            goto L9
        }

        @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod.a
        public final void onFailed(Throwable r100) {
            com.bytedance.ies.bullet.service.base.bridge.b.a r101 = this.f40124a;
            JSONObject r102 = new JSONObject();
            r102.put("code", 0);     // Catch: JSONException -> L9
            if (r100 == null) goto L12;
            if (TextUtils.isEmpty(r100.getMessage()) == true) goto L12;
            r102.put("msg", r100.getMessage());     // Catch: JSONException -> L9
        L12:
            if (com.bytedance.ies.bullet.service.base.h.n() == false) goto L14;
            r102.put("ignoreJSB2Error", 1);
        L14:
            r101.a(r102);
            return;
        L9:
            e = move-exception;
            r102.put("msg", "ignored error:" + e.getMessage());
            goto L12
        }

        @Override // com.bytedance.android.annie.xbridge.mix.BaseA2BBridgeMethod.a
        public final void onSucceed(Object r100) {
            if (r100 != null) goto L4;
        L8:
            JSONObject r101 = null;
        L9:
            if (r101 == null) goto L11;
            this.f40124a.a(r101);
            return;
        L11:
            this.f40124a.a(c.c(r100));
            return;
        L4:
            if ((r100 instanceof JSONObject) == false) goto L8;
            ((JSONObject) r100).put("code", 1);     // Catch: JSONException -> L13
            r101 = (JSONObject) r100;     // Catch: JSONException -> L13
            goto L9
        }
    }

    public void a(JSONObject r100, b r101) throws JSONException {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "iReturn");
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.a
    public boolean i90() {
        return false;
    }

    public BaseA2BBridgeMethod(m16.b r100) {
        Intrinsics.checkNotNullParameter(r100, "contextProviderFactory");
        super(r100);
    }

    @Override // com.bytedance.ies.bullet.service.base.bridge.b
    public final void C50(JSONObject r100, com.bytedance.ies.bullet.service.base.bridge.b.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        a(r100, new b(r101));
    }
}
