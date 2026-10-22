package com.bytedance.android.ec.host.api.hybrid;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¨\u0006\b"}, d2 = {"Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "Lcom/bytedance/android/ec/model/hybrid/IECBridgeMethod;", "Landroidx/lifecycle/LifecycleObserver;", "Landroid/content/Context;", "getContext", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-host-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECBaseBridgeMethod implements IECBridgeMethod, LifecycleObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<Context> f46173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IECBridgeMethod.c f46174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final IECBridgeMethod.Access f46175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WeakReference<CallContext> f46176d;

    public interface a {
        void a(JSONObject r100);

        void b(Object r100);

        void onFailed(int r100, String r101);

        void onSuccess(Object r100);
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IECBridgeMethod.b f46177a;

        public b(IECBridgeMethod.b r100) {
            this.f46177a = r100;
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod.a
        public final void a(JSONObject r100) {
            if (r100 == null) goto L10;
            this.f46177a.onComplete(r100);     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            ye.a.b(e);
            return;
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod.a
        public final void b(Object r100) {
            JSONObject r101 = new JSONObject();     // Catch: JSONException -> L5
            r101.put("code", 1);     // Catch: JSONException -> L5
            r101.put("msg", "");     // Catch: JSONException -> L5
            r101.put("data", r100);     // Catch: JSONException -> L5
            this.f46177a.onComplete(r101);     // Catch: JSONException -> L5
            return;
        L5:
            e = move-exception;
            ye.a.b(e);
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod.a
        public final void onSuccess(Object r100) {
            JSONObject r101 = new JSONObject();     // Catch: JSONException -> L4
            r101.put("code", 1);     // Catch: JSONException -> L4
            r101.put("data", r100);     // Catch: JSONException -> L4
            this.f46177a.onComplete(r101);     // Catch: JSONException -> L4
            return;
        L4:
            e = move-exception;
            ye.a.b(e);
        }

        @Override // com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod.a
        public final void onFailed(int r100, String r101) {
            IECBridgeMethod.b r102 = this.f46177a;
            if (r101 != null) goto L5;
            r101 = "";
        L5:
            r102.onError(r100, r101);
        }
    }

    public abstract void c(JSONObject r100, a r101) throws JSONException;

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public void release() {
    }

    public final ti.a b() {
        WeakReference<CallContext> r100 = this.f46176d;
        if (r100 == null) goto L7;
        CallContext r101 = r100.get();
        if (r101 == null) goto L7;
        View r102 = r101.f249269d;
    L9:
        return new ti.a(r102);
    L7:
        r102 = null;
        goto L9
    }

    public final Context getContext() {
        WeakReference<Context> r100 = this.f46173a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    public ECBaseBridgeMethod() {
        this.f46175c = IECBridgeMethod.Access.PRIVATE;
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final IECBridgeMethod.Access getAccess() {
        return this.f46175c;
    }

    @Override // com.bytedance.android.ec.model.hybrid.IECBridgeMethod
    public final void a(Context r100, JSONObject r101, IECBridgeMethod.b r102, IECBridgeMethod.c r103, Object r104) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "eventSender");
        if (r100 == null) goto L5;
        this.f46173a = new WeakReference(r100);
    L5:
        boolean r105 = r104 instanceof CallContext;
        Object r106 = null;
        if (r105 == true) goto L8;
        Object r107 = null;
    L9:
        CallContext r108 = (CallContext) r107;
        if (r108 == null) goto L12;
        this.f46176d = new WeakReference(r108);
    L12:
        this.f46174b = r103;
        b r109 = new b(r102);
        c(r101, r109);
        if (r105 == false) goto L17;
        r106 = r104;
    L17:
        if (((CallContext) r106) == null) goto L20;
        CallContext r110 = (CallContext) r104;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r109, "iReturn");
        return;
    L20:
        return;
    L8:
        r107 = r104;
        goto L9
    }
}
