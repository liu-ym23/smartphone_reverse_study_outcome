package com.bytedance.android.livesdk.livecommerce.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u000b\b\"\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&J\b\u0010\u0004\u001a\u00020\u0003H&R$\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/utils/LogRule;", "Ljava/io/Serializable;", "parse", "", "getIntrinsicOn", "on", "Ljava/lang/String;", "getOn", "()Ljava/lang/String;", "setOn", "(Ljava/lang/String;)V", "require", "getRequire", "setRequire", "", "involveLive", "I", "getInvolveLive", "()I", "setInvolveLive", "(I)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
abstract class LogRule implements Serializable {
    public static final a Companion = null;
    public static final String REQUIRE_HAS_AUTHORITY = "has_authority";
    public static final String REQUIRE_HAS_CART = "has_cart";
    public static final String REQUIRE_NO_AUTHORITY = "no_authority";
    public static final String REQUIRE_NO_CART = "no_cart";
    private int involveLive;

    /* JADX INFO: renamed from: on, reason: collision with root package name */
    private String f153049on;
    private String require;

    public static final class a {
        public a() {
        }

        public static LogRule a(JsonObject r100) {
            Intrinsics.checkNotNullParameter(r100, "jsonObject");
            JsonElement r101 = r100.get("on");
            if (r101 == null) goto L5;
            String r102 = r101.getAsString();
        L6:
            String r103 = "";
            if (r102 != null) goto L9;
            r102 = "";
        L9:
            JsonElement r104 = r100.get("require");
            if (r104 == null) goto L12;
            String r105 = r104.getAsString();
        L13:
            if (r105 == null) goto L16;
            r103 = r105;
        L16:
            JsonElement r106 = r100.get("involve_live");
            if (r106 == null) goto L19;
            int r107 = r106.getAsInt();
        L21:
            if (StringsKt.startsWith$default(r102, LogRuleRevMsg.RULE_STR_REV_MSG, false, 2, null) == false) goto L24;
            LogRule r108 = new LogRuleRevMsg();
        L27:
            if (r108 == null) goto L30;
            r108.setOn(r102);
            r108.setRequire(r103);
            r108.setInvolveLive(r107);
            return r108.parse();
        L30:
            return null;
        L24:
            if (StringsKt.startsWith$default(r102, LogRuleInsertDelay.RULE_STR_CART_INSERT_DELAY, false, 2, null) == false) goto L26;
            r108 = new LogRuleInsertDelay();
            goto L27
        L26:
            r108 = null;
            goto L27
        L19:
            r107 = 0;
            goto L21
        L12:
            r105 = null;
            goto L13
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    public LogRule() {
    }

    public abstract String getIntrinsicOn();

    public abstract LogRule parse();

    public final int getInvolveLive() {
        return this.involveLive;
    }

    public final String getOn() {
        return this.f153049on;
    }

    public final String getRequire() {
        return this.require;
    }

    public final void setInvolveLive(int r100) {
        this.involveLive = r100;
    }

    public final void setOn(String r100) {
        this.f153049on = r100;
    }

    public final void setRequire(String r100) {
        this.require = r100;
    }
}
