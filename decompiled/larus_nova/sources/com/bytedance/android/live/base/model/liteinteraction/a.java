package com.bytedance.android.live.base.model.liteinteraction;

import am3.g;
import com.bytedance.android.livesdkapi.message.TextPiece;
import com.bytedance.android.livesdkapi.message._TextPiece_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.data.LightInteractionAction")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Lcom/bytedance/android/live/base/model/liteinteraction/a;", "", "", ReportConstant.COMMON_ACTION_TYPE, "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setActionType", "(J)V", "", "toast", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setToast", "(Ljava/lang/String;)V", "", "requestParams", "Ljava/util/Map;", "d", "()Ljava/util/Map;", "setRequestParams", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/base/model/liteinteraction/c;", "clickMob", "Lcom/bytedance/android/live/base/model/liteinteraction/c;", "c", "()Lcom/bytedance/android/live/base/model/liteinteraction/c;", "setClickMob", "(Lcom/bytedance/android/live/base/model/liteinteraction/c;)V", "Lcom/bytedance/android/livesdkapi/message/TextPiece;", "afterClickPiece", "Lcom/bytedance/android/livesdkapi/message/TextPiece;", "b", "()Lcom/bytedance/android/livesdkapi/message/TextPiece;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a implements h {

    @SerializedName("action_type")
    protected long actionType;

    @SerializedName("after_click_piece")
    protected TextPiece afterClickPiece;

    @SerializedName("click_mob")
    protected c clickMob;

    @SerializedName("request_params")
    protected Map<String, String> requestParams;

    @SerializedName("toast")
    protected String toast;

    /* JADX INFO: renamed from: com.bytedance.android.live.base.model.liteinteraction.a$a, reason: collision with other inner class name */
    public static final class C0937a {
    }

    static {
    }

    public a() {
    }

    public final long a() {
        return this.actionType;
    }

    public final TextPiece b() {
        return this.afterClickPiece;
    }

    public final c c() {
        return this.clickMob;
    }

    public final Map<String, String> d() {
        return this.requestParams;
    }

    public final String e() {
        return this.toast;
    }

    public a(g r110) {
        this.requestParams = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L36;
        if (r101 != 1) goto L8;
        this.actionType = r110.j();
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.toast = am3.h.c(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        long r102 = r110.c();
        String r103 = null;
        String r104 = null;
    L19:
        int r105 = r110.f();
        if (r105 == (-1)) goto L26;
        if (r105 != 1) goto L22;
        r103 = am3.h.c(r110);
        goto L19
    L22:
        if (r105 != 2) goto L23;
        r104 = am3.h.c(r110);
        goto L19
    L23:
        am3.h.e(r110);
        goto L19
    L26:
        r110.d(r102);
        Map<String, String> r106 = this.requestParams;
        if (r103 == null) goto L33;
        if (r104 == null) goto L31;
        r106.put(r103, r104);
        goto L3
    L31:
        throw new IllegalStateException("Value must not be null");
    L33:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r101 != 4) goto L14;
        this.clickMob = new c(r110);
        goto L3
    L14:
        if (r101 != 5) goto L15;
        this.afterClickPiece = _TextPiece_ProtoDecoder.decodeStatic(r110);
        goto L3
    L15:
        am3.h.e(r110);
        goto L3
    L36:
        r110.d(r100);
    }
}
