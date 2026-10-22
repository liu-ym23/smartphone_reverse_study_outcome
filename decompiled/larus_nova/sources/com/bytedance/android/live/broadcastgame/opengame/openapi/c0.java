package com.bytedance.android.live.broadcastgame.opengame.openapi;

import io.reactivex.functions.Function;
import java.util.Locale;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes45.dex */
public final class c0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NetworkRequestMethod f60377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v0 f60378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f60379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f60380d;

    public c0(NetworkRequestMethod r100, v0 r101, String r102, String r103) {
        this.f60377a = r100;
        this.f60378b = r101;
        this.f60379c = r102;
        this.f60380d = r103;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        Intrinsics.checkNotNullParameter((v0) r110, "it");
        String r111 = this.f60378b.c();
        Locale r100 = Locale.ROOT;
        if (r111 == null) goto L48;
        String r101 = r111.toUpperCase(r100);
        Object r102 = null;
        switch(r101.hashCode()) {
            case -531492226: goto L39;
            case 70454: goto L36;
            case 79599: goto L17;
            case 2213344: goto L14;
            case 2461856: goto L11;
            case 2012838315: goto L8;
            default: goto L44;
        };
    L44:
        this.f60377a.n(OpenApiErrorInfo.NET_REQUEST_PRE_VERIFY_METHOD_UN_SUPPORT, null);
    L46:
        return Unit.INSTANCE;
    L8:
        if (r101.equals("DELETE") == false) goto L44;
    L40:
        Map<String, String> r103 = MapsKt.emptyMap();
        u10.b r104 = this.f60377a.f60310h;
        String r105 = this.f60379c;
        String r106 = this.f60380d;
        Map<String, String> r112 = this.f60378b.b();
        if (r112 != null) goto L43;
        r112 = MapsKt.emptyMap();
    L43:
        r104.b(r105, r101, r106, r112, r103, this.f60378b.d(), new NetworkRequestMethod$executeRequest$1$1(this), new NetworkRequestMethod$executeRequest$1$2(this), false);
        goto L46
    L11:
        if (r101.equals("POST") == false) goto L44;
    L18:
        Map<String, String> r113 = this.f60378b.b();
        if (r113 == null) goto L22;
        String r114 = r113.get("Content-Type");
        if (r114 == null) goto L22;
    L23:
        String r107 = r114;
        NetworkRequestMethod r115 = this.f60377a;
        Object r108 = this.f60378b.a();
        r115.getClass();
        if ((r108 instanceof String) == false) goto L27;
        r102 = r108;
    L27:
        String r109 = (String) r102;
        if (r109 == null) goto L30;
        byte[] r116 = r109.getBytes(Charsets.UTF_8);
    L31:
        byte[] r117 = r116;
        u10.b r118 = this.f60377a.f60310h;
        String r119 = this.f60379c;
        String r120 = this.f60380d;
        Map<String, String> r121 = this.f60378b.b();
        if (r121 != null) goto L34;
        r121 = MapsKt.emptyMap();
    L34:
        r118.a(r119, r101, r120, r121, r117, r107, this.f60378b.d(), new NetworkRequestMethod$executeRequest$1$3(this), new NetworkRequestMethod$executeRequest$1$4(this), false);
        goto L46
    L30:
        r116 = "".getBytes(Charsets.UTF_8);
    L22:
        r114 = "application/json; charset=UTF-8";
        goto L23
    L14:
        if (r101.equals("HEAD") == false) goto L44;
    L17:
        if (r101.equals("PUT") == false) goto L44;
    L36:
        if (r101.equals("GET") == false) goto L44;
    L39:
        if (r101.equals("OPTIONS") == false) goto L44;
    L48:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
