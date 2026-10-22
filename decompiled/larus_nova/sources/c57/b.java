package c57;

import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.utils.GsonUtils;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.bytedance.pia.core.utils.d;
import com.bytedance.pia.core.utils.j;
import com.google.gson.JsonObject;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;
import m47.h;
import m47.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.c f22486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l47.a<PiaMethod.Error> f22487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l47.a<a.d> f22488c;

    public b(a.c r100, i r101, h r102) {
        this.f22486a = r100;
        this.f22487b = r101;
        this.f22488c = r102;
    }

    public final void a() {
        d.b("[SnapShot] pia.removeSnapshot called (Query: " + this.f22486a.a() + ", URL: " + this.f22486a.c() + ", SDK: " + this.f22486a.b() + ')', null, 14);
        Number r100 = this.f22486a.b();
        if (r100 == null) goto L5;
        r100.intValue();
    L5:
        String r101 = this.f22486a.c();
        JsonObject r102 = this.f22486a.a();
        if (r102 == null) goto L9;
        String r103 = r102.toString();
        if (r103 == null) goto L9;
    L10:
        if (r101 != null) goto L12;
        this.f22487b.accept(new PiaMethod.InvalidParamsError());
        return;
    L12:
        JSONObject r104 = (JSONObject) GsonUtils.a(r103, JSONObject.class);
        if (r104 != null) goto L16;
        this.f22487b.accept(new PiaMethod.InvalidParamsError(""));
        return;
    L16:
        b57.d.f17777a.getClass();
        Intrinsics.checkNotNullParameter(r104, "query");
        Intrinsics.checkNotNullParameter(r101, "url");
        d.l("[SnapShot] Remove a snapshot (URL: " + r101 + ", Query: " + r104 + ')', null, 14);
        ThreadUtil.a().post(b57.b.f17774a);
        com.bytedance.pia.snapshot.storage.a r105 = com.bytedance.pia.snapshot.storage.a.f266521a;
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r104, "query");
        this.f22488c.accept(new a.d(com.bytedance.pia.snapshot.storage.a.f(j.d(UriProtector.parse(r101)), r104, com.bytedance.pia.snapshot.storage.a.d(r104))));
        return;
    L9:
        r103 = "";
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
