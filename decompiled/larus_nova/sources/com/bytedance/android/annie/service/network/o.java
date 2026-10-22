package com.bytedance.android.annie.service.network;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.ugc.effectplatform.bridge.network.NetResponse;
import java.util.LinkedHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f39912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LinkedHashMap<String, String> f39913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ j f39914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Integer f39915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f39916e;

    public o(String r100, LinkedHashMap<String, String> r101, j r102, Integer r103, int r104) {
        this.f39912a = r100;
        this.f39913b = r101;
        this.f39914c = r102;
        this.f39915d = r103;
        this.f39916e = r104;
    }

    public final void a() {
        String r100 = "";
        String r101 = this.f39912a;
        LinkedHashMap<String, String> r102 = this.f39913b;
        j r103 = this.f39914c;
        Integer r104 = this.f39915d;
        int r105 = this.f39916e;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L36
        Unit r107 = null;
        JSONObject r108 = new JSONObject(r101);     // Catch: Throwable -> L7
        r101 = null;
        th = null;
        String r109 = null;
    L14:
        boolean r110 = false;
        if (r109 != null) goto L17;
    L22:
        if (r110 == true) goto L27;
        if (th != null) goto L27;
        if (r101 != null) goto L27;
        r103.a(r108, r102, r104, r105);     // Catch: Throwable -> L36
        r107 = Unit.INSTANCE;     // Catch: Throwable -> L36
    L34:
        Object r111 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L36
    L38:
        j r112 = this.f39914c;
        LinkedHashMap<String, String> r113 = this.f39913b;
        Integer r114 = this.f39915d;
        int r115 = this.f39916e;
        Throwable r116 = Result.m9452exceptionOrNullimpl(r111);
        if (r116 == null) goto L47;
        r112.b(new JSONObject(), r113, "", r116, r114, r115);
        return;
    L47:
        return;
    L27:
        if (r101 == null) goto L30;
        r100 = r101;
    L30:
        if (th != null) goto L32;
        Throwable r117 = new Throwable(r109);     // Catch: Throwable -> L36
    L33:
        r103.b(r108, r102, r100, r117, r104, r105);     // Catch: Throwable -> L36
        goto L34
    L32:
        r117 = th;
        goto L33
    L17:
        if (r109.length() <= 0) goto L19;
        boolean r118 = true;
    L20:
        if (r118 != true) goto L22;
        r110 = true;
        goto L22
    L19:
        r118 = false;
        goto L20
    L7:
        th = th;
        JSONObject r119 = new JSONObject();     // Catch: Throwable -> L36
        n.f39906a.getClass();     // Catch: Throwable -> L36
        if (r102.containsKey(NetResponse.HEADER_KEY_LOG_ID) == false) goto L12;
        String r120 = r102.get(NetResponse.HEADER_KEY_LOG_ID);     // Catch: Throwable -> L36
        if (r120 == null) goto L12;
    L13:
        r108 = r119.put("_Header_RequestID", r120);     // Catch: Throwable -> L36
        r109 = th.getClass().toString() + ':' + th.getMessage();     // Catch: Throwable -> L36
    L12:
        r120 = "";
    L36:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L38
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
