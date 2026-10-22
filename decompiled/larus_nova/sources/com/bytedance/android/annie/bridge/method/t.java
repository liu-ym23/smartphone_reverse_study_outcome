package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.FetchTimingSession;
import com.bytedance.android.annie.service.network.IAnnieNetworkService;
import com.bytedance.ugc.glue.monitor.UGCMonitor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.reactivex.functions.Function;
import java.io.ByteArrayOutputStream;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final class t<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f38821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f38822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ JsonObject f38823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<JsonObject> f38824d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ JsonObject f38825e;

    public t(s r100, String r101, JsonObject r102, Ref.ObjectRef<JsonObject> r103, JsonObject r104) {
        this.f38821a = r100;
        this.f38822b = r101;
        this.f38823c = r102;
        this.f38824d = r103;
        this.f38825e = r104;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r110) {
        String r111 = (String) r110;
        Intrinsics.checkNotNullParameter(r111, "it");
        FetchTimingSession r100 = this.f38821a.f38815d;
        if (r100 == null) goto L5;
        r100.recordNetStartTiming();
    L5:
        IAnnieNetworkService r101 = null;
        if (r111.hashCode() == 3446944) goto L9;
    L36:
        s r112 = this.f38821a;
        String r102 = this.f38822b;
        JsonObject r103 = this.f38823c;
        JsonObject r104 = this.f38824d.element;
        IAnnieNetworkService r105 = r112.f38814c;
        if (r105 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("service");
    L40:
        JsonObject r113 = s.k(r101.get(r112.j(r102, r104), r112.l(r103)).execute());
    L41:
        FetchTimingSession r106 = this.f38821a.f38815d;
        if (r106 == null) goto L44;
        r106.recordNetEndTiming();
    L44:
        return r113;
    L39:
        r101 = r105;
        goto L40
    L9:
        if (r111.equals(UGCMonitor.TYPE_POST) == false) goto L36;
        s r114 = this.f38821a;
        String r107 = this.f38822b;
        JsonObject r108 = this.f38823c;
        JsonObject r109 = this.f38824d.element;
        JsonObject r115 = this.f38825e;
        r114.getClass();
        JsonElement r116 = r108.get("Content-Type");
        if (r116 == null) goto L13;
        String r117 = r116.getAsString();
    L15:
        if (Intrinsics.areEqual(r117, "application/json") == false) goto L17;
        byte[] r118 = r115.toString().getBytes(Charsets.UTF_8);
        String r119 = "application/json; charset=UTF-8";
    L31:
        IAnnieNetworkService r120 = r114.f38814c;
        if (r120 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("service");
    L35:
        r113 = s.k(r101.post(r114.j(r107, r109), r114.l(r108), r119, r118).execute());
        goto L41
    L34:
        r101 = r120;
        goto L35
    L17:
        ByteArrayOutputStream r121 = new ByteArrayOutputStream();
        Iterator<T> r122 = r115.entrySet().iterator();
    L19:
        if (r122.hasNext() == false) goto L30;
        Map.Entry r123 = (Map.Entry) r122.next();
        if (r121.size() <= 0) goto L23;
        r121.write(38);
    L23:
        String r124 = URLEncoder.encode((String) r123.getKey(), "UTF-8");
        JsonElement r125 = (JsonElement) r123.getValue();
        if (r125 == null) goto L26;
        String r126 = r125.getAsString();
    L27:
        if (r126 != null) goto L29;
        r126 = "";
    L29:
        String r127 = URLEncoder.encode(r126, "UTF-8");
        r121.write(r124.getBytes(Charset.forName("UTF-8")));
        r121.write(61);
        r121.write(r127.getBytes(Charset.forName("UTF-8")));
        goto L19
    L26:
        r126 = null;
        goto L27
    L30:
        r118 = r121.toByteArray();
        r119 = "application/x-www-form-urlencoded; charset=UTF-8";
        goto L31
    L13:
        r117 = null;
        goto L15
    }
}
