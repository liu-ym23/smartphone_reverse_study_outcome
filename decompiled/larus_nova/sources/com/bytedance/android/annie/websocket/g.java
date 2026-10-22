package com.bytedance.android.annie.websocket;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.cronet.websocket.IWsClient;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class g extends com.bytedance.android.annie.websocket.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f40119f = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IWsClient f40120e;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.annie.websocket.a
    public final void g() {
        String r100 = this.f40108b.f40116a;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        IWsClient r103 = this.f40120e;
        if (r103 == null) goto L70;
        HashMap r104 = new HashMap();
        HashMap r105 = new HashMap();
        Unit r106 = null;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L35
        JsonObject r108 = this.f40108b.f40117b;     // Catch: Throwable -> L35
        if (r108 == null) goto L32;
        Iterator<String> r109 = r108.keySet().iterator();     // Catch: Throwable -> L35
    L18:
        if (r109.hasNext() == false) goto L31;
        String r110 = r109.next();     // Catch: Throwable -> L35
        if (r110.length() != 0) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == true) goto L18;
        JsonElement r112 = r108.get(r110);     // Catch: Throwable -> L35
        if (r112 == null) goto L29;
        String r113 = r112.toString();     // Catch: Throwable -> L35
        if (r113 == null) goto L29;
    L30:
        r105.put(r110, r113);     // Catch: Throwable -> L35
    L29:
        r113 = "";
        goto L30
    L22:
        r111 = false;
        goto L23
    L31:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L35
    L33:
        Result.m9449constructorimpl(r114);     // Catch: Throwable -> L35
    L59:
        List<String> r115 = this.f40108b.f40118c;     // Catch: Throwable -> L53
        if (r115 == null) goto L51;
        int r116 = r115.size();     // Catch: Throwable -> L53
        StringBuilder r117 = new StringBuilder();     // Catch: Throwable -> L53
        int r118 = 0;
    L40:
        if (r118 >= r116) goto L45;
        r117.append((String) ListProtector.get(r115, r118));     // Catch: Throwable -> L53
        if (r118 == (r116 - 1)) goto L44;
        r117.append(",");     // Catch: Throwable -> L53
    L44:
        r118 = r118 + 1;     // Catch: Throwable -> L53
        goto L40
    L45:
        String r119 = r117.toString();     // Catch: Throwable -> L53
        if (r119.length() <= 0) goto L48;
        r101 = true;
    L48:
        if (r101 == false) goto L50;
        r105.put("Sec-WebSocket-Protocol", r119);     // Catch: Throwable -> L53
    L50:
        r106 = Unit.INSTANCE;     // Catch: Throwable -> L53
    L51:
        Result.m9449constructorimpl(r106);     // Catch: Throwable -> L53
    L55:
        r103.openConnection(r104, r105, CollectionsKt.listOf(this.f40108b.f40116a), false, false);
        return;
    L53:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L55
    L32:
        r114 = null;
    L35:
        th = move-exception;
        Result.Companion r121 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L59
    L70:
        return;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.annie.websocket.a
    public final void h() {
        IWsClient r100 = this.f40120e;     // Catch: Throwable -> L7
        if (r100 == null) goto L5;
        r100.stopConnection();     // Catch: Throwable -> L7
    L5:
        d();
    }

    @Override // com.bytedance.android.annie.websocket.b
    public final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        IWsClient r101 = this.f40120e;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L17;
        monitor-enter(this);
        int r104 = this.f40110d;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r104 != 1) goto L17;
        r102 = true;
    L14:
        th = move-exception;
        throw th;
    L17:
        if (r102 == true) goto L29;
        return "the socket is disconnected";
    L29:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L25
        IWsClient r106 = this.f40120e;     // Catch: Throwable -> L25
        if (r106 == null) goto L22;
        Boolean r107 = Boolean.valueOf(r106.sendMessage(r100.getBytes(StandardCharsets.UTF_8), 1));     // Catch: Throwable -> L25
    L23:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L25
        return null;
    L22:
        r107 = null;
    L25:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    L5:
        if (r101.isConnected() != true) goto L7;
        r103 = true;
        goto L8
    }

    @Override // com.bytedance.android.annie.websocket.b
    public final String sendMessage(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "byteData");
        IWsClient r101 = this.f40120e;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L17;
        monitor-enter(this);
        int r104 = this.f40110d;     // Catch: Throwable -> L14
        monitor-exit(this);
        if (r104 != 1) goto L17;
        r102 = true;
    L14:
        th = move-exception;
        throw th;
    L17:
        if (r102 == true) goto L29;
        return "the socket is disconnected";
    L29:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L25
        IWsClient r106 = this.f40120e;     // Catch: Throwable -> L25
        if (r106 == null) goto L22;
        Boolean r107 = Boolean.valueOf(r106.sendMessage(r100, 2));     // Catch: Throwable -> L25
    L23:
        Result.m9449constructorimpl(r107);     // Catch: Throwable -> L25
        return null;
    L22:
        r107 = null;
    L25:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    L5:
        if (r101.isConnected() != true) goto L7;
        r103 = true;
        goto L8
    }

    public g(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "requestTask");
        super(r100, r101);
    }
}
