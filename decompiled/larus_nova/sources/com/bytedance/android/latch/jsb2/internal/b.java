package com.bytedance.android.latch.jsb2.internal;

import android.content.Context;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.bytedance.android.latch.LatchOptions;
import com.bytedance.android.latch.internal.f;
import com.bytedance.ies.web.jsbridge2.c0;
import com.bytedance.ies.web.jsbridge2.o;
import com.bytedance.vmsdk.worker.JsWorker;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.subjects.MaybeSubject;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.ies.web.jsbridge2.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f58401n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LatchOptions f58402o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f58403p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final d f58404q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final a f58405r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WorkerBridgeModuleForJsb2Impl f58406s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public JsWorker f58407t;

    public static final class a extends View implements gx.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f58408a;

        public Context getAndroidContext() {
            return getContext();
        }

        @Override // gx.a
        public String getUrl() {
            return this.f58408a;
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f58408a = "";
        }

        public void setUrl(String r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f58408a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.latch.jsb2.internal.b$b, reason: collision with other inner class name */
    public static final class C0930b extends com.bytedance.ies.web.jsbridge2.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f58409c;

        @Override // com.bytedance.ies.web.jsbridge2.a
        public final View b() {
            return this.f58409c.f58405r;
        }

        public C0930b(b r100) {
            this.f58409c = r100;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void p() {
        super.p();
        JsWorker r100 = this.f58407t;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("jsWorker");
        r100 = null;
    L6:
        r100.terminate();
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final String h() {
        return this.f58403p;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public Context getContext(o r100) {
        return this.f58401n;
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void j(o r100) {
        this.f249303g = new C0930b(this);
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        r(new JSONObject(r100));
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void l(JSONObject r100) {
        r(r100);
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void o(c0 r100) {
        Intrinsics.checkNotNullParameter(r100, NotificationCompat.CATEGORY_CALL);
        if (this.f249302f == false) goto L5;
        return;
    L5:
        d r101 = this.f58404q;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "js2JavaCall");
        com.bytedance.android.latch.internal.a r102 = r101.f58299a;
        if (r102 == null) goto L8;
        r102.f(r100.f249321f, r100.f249319d);
    L8:
        r101.f58300b.put(r100.f249321f, new MaybeSubject());
        if (this.f58402o.f58200c.contains(r100.f249319d) == false) goto L11;
        i(r100);
        return;
    L11:
        super.o(r100);
    }

    public final void r(JSONObject r100) {
        if (this.f58407t != null) goto L5;
        return;
    L5:
        Object r101 = r100.remove("__event_id");
        JsWorker r102 = null;
        if ((r101 instanceof String) == false) goto L8;
        String r103 = (String) r101;
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        Object r104 = r100.remove("__params");
        if (r104 == null) goto L19;
        JsWorker r105 = this.f58407t;
        if (r105 == null) goto L16;
        r102 = r105;
    L17:
        JSONObject r106 = new JSONObject();
        r106.put("name", r103);
        r106.put("code", 1);
        r106.put("data", r104);
        r102.postMessage(r106.toString());
        return;
    L16:
        Intrinsics.throwUninitializedPropertyAccessException("jsWorker");
        goto L17
    L19:
        return;
    L8:
        r103 = null;
        goto L9
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void m(String r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        n(new JSONObject(r100), r101);
    }

    @Override // com.bytedance.ies.web.jsbridge2.b
    public final void n(JSONObject r100, c0 r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r101 != null) goto L5;
        return;
    L5:
        d r102 = this.f58404q;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "js2JavaCall");
        com.bytedance.android.latch.internal.a r103 = r102.f58299a;
        if (r103 == null) goto L8;
        r103.e(r101.f249321f, r101.f249319d);
    L8:
        r102.a(r101.f249321f).onSuccess(f.b(r100, r101.f249321f));
        WorkerBridgeModuleForJsb2Impl r104 = this.f58406s;
        if (r104 == null) goto L12;
        r104.invokeCallback$latch_jsb2_release(r100, r101);
        return;
    }

    public b(Context r100, LatchOptions r101, String r102, d r103) {
        Intrinsics.checkNotNullParameter(r100, "androidContext");
        Intrinsics.checkNotNullParameter(r101, "options");
        Intrinsics.checkNotNullParameter(r102, "url");
        Intrinsics.checkNotNullParameter(r103, "methodListenerStore");
        this.f58401n = r100;
        this.f58402o = r101;
        this.f58403p = r102;
        this.f58404q = r103;
        a r104 = new a(r100);
        r104.setUrl(r102);
        this.f58405r = r104;
    }
}
