package com.bytedance.android.latch.jsb2.internal;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a extends f<JSONObject, JSONObject> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f58397d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.latch.internal.jsb.c f58398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f58399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.latch.internal.jsb.a f58400c;

    /* JADX INFO: renamed from: com.bytedance.android.latch.jsb2.internal.a$a, reason: collision with other inner class name */
    public static final class C0929a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        com.bytedance.android.latch.internal.jsb.a r100 = this.f58400c;
        if (r100 == null) goto L8;
        Disposable r101 = r100.f58304d;
        if (r101 == null) goto L9;
        r101.dispose();
        return;
    L9:
        return;
    }

    public a(com.bytedance.android.latch.internal.jsb.c r100, Function0<Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "stateHolder");
        Intrinsics.checkNotNullParameter(r101, "onCall");
        this.f58398a = r100;
        this.f58399b = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(JSONObject r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.bytedance.android.latch.internal.jsb.a r102 = new com.bytedance.android.latch.internal.jsb.a(this.f58398a, this.f58399b, new AttachComponentMethod$invoke$1(this));
        r102.a();
        this.f58400c = r102;
    }
}
