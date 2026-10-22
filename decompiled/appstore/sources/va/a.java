package va;

import com.bytedanceos.common.model.MobileInfo;
import com.bytedanceos.common.toolbox.d;
import com.bytedanceos.common.toolbox.e;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.appstore.network.entity.CommonBodyEntity;
import com.obric.appstore.network.entity.CommonParams;
import com.obric.appstore.util.k;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import kotlin.Result;
import kotlin.Unit;
import kotlin.c;
import kotlin.jvm.internal.q;
import kotlin.text.o;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f25124a = null;

    static {
        f25124a = new a();
    }

    public a() {
    }

    public final RequestBody a(RequestBody r10) {
        CommonBodyEntity r11 = b(d(r10));
        String r12 = k.f11081a.c().toJson(r11);
        RequestBody r13 = RequestBody.c(MediaType.c("application/json; charset=utf-8"), r12);
        q.f(r13, "create(...)");
        return r13;
    }

    public final CommonBodyEntity b(JsonElement r19) {
        MobileInfo r10 = pa.a.f23414a.a().i();
        q.f(r10, "getMobileInfo(...)");
        int r11 = 3;
    L3:
        if (r11 <= 0) goto L14;
        String r12 = r10.getClientId();
        if (r12 != null) goto L7;
    L8:
        r11 = r11 - 1;
        Result.a r13 = Result.Companion;     // Catch: Throwable -> L11
        Thread.sleep(500);     // Catch: Throwable -> L11
        Result.m35constructorimpl(Unit.f21064a);     // Catch: Throwable -> L11
    L13:
        r10 = pa.a.f23414a.a().i();
        q.f(r10, "getMobileInfo(...)");
    L11:
        th = move-exception;
        Result.a r14 = Result.Companion;
        Result.m35constructorimpl(c.a(th));
        goto L13
    L7:
        if (r12.length() == 0) goto L8;
    L14:
        String r15 = r10.mImei1;
        if (r15 != null) goto L17;
        String r16 = "";
    L18:
        String r17 = r10.mAndroid_Id;
        if (r17 != null) goto L21;
        String r18 = "";
    L22:
        String r20 = d.f10009a;
        String r21 = r10.mVersionName;
        if (r21 != null) goto L25;
        String r110 = "";
    L26:
        int r111 = r10.mVersionCode;
        String r22 = e.U(false);
        if (r22 != null) goto L29;
        String r112 = "";
    L30:
        if (r15 != null) goto L32;
        String r113 = "";
    L33:
        String r23 = r10.mOvr;
        if (r23 != null) goto L36;
        String r114 = "";
    L37:
        String r24 = r10.mImei1;
        if (r24 != null) goto L40;
        String r115 = "";
    L41:
        String r25 = r10.mImei2;
        if (r25 != null) goto L44;
        String r116 = "";
    L45:
        q.d(r20);
        return new CommonBodyEntity(new CommonParams("ocean_store", r16, "sn", r18, r20, r110, r112, "mobile", r111, r113, r114, r115, r116), r19);
    L44:
        r116 = r25;
        goto L45
    L40:
        r115 = r24;
        goto L41
    L36:
        r114 = r23;
        goto L37
    L32:
        r113 = r15;
        goto L33
    L29:
        r112 = r22;
        goto L30
    L25:
        r110 = r21;
        goto L26
    L21:
        r18 = r17;
        goto L22
    L17:
        r16 = r15;
        goto L18
    }

    public final String c(RequestBody r10) {
        Buffer r11 = new Buffer();
        r10.g(r11);
        MediaType r12 = r10.b();
        if (r12 == null) goto L5;
        Charset r13 = r12.b(StandardCharsets.UTF_8);
    L6:
        if (r13 != null) goto L9;
        r13 = StandardCharsets.UTF_8;
        q.f(r13, "UTF_8");
    L9:
        if (b.a(r11) == false) goto L15;
        String r14 = r11.readString(r13);
        if (o.r(r14) == true) goto L14;
        return r14;
    L14:
        return new JSONObject().toString();
    L15:
        return null;
    L5:
        r13 = null;
        goto L6
    }

    public final JsonElement d(RequestBody r10) {
        if (r10 == null) goto L13;
        String r11 = c(r10);
        if (r11 == null) goto L14;
        Object r12 = new JSONTokener(r11).nextValue();
        if ((r12 instanceof JSONObject) == false) goto L10;
        return (JsonElement) k.f11081a.c().fromJson(r11, JsonObject.class);
    L10:
        if ((r12 instanceof JSONArray) == true) goto L12;
        return null;
    L12:
        return (JsonElement) k.f11081a.c().fromJson(r11, JsonArray.class);
    L14:
        return null;
    L13:
        return null;
    }
}
