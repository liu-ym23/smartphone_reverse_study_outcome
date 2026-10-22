package com.bytedance.ai.miniappevent;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonObject;
import com.heytap.mcssdk.constant.b;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f36709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f36710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonObject f36711d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AIMiniAppNativeTrigger f36712e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f36713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f36714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f36715h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f36708a, r101.f36708a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f36709b, r101.f36709b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f36710c, r101.f36710c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f36711d, r101.f36711d) == true) goto L21;
        return false;
    L21:
        if (this.f36712e == r101.f36712e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f36713f, r101.f36713f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f36714g, r101.f36714g) == true) goto L30;
        return false;
    L30:
        if (this.f36715h == r101.f36715h) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f36708a.hashCode() * 31) + this.f36709b.hashCode()) * 31) + this.f36710c.hashCode()) * 31) + this.f36711d.hashCode()) * 31) + this.f36712e.hashCode()) * 31;
        String r101 = this.f36713f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f36714g;
        if (r105 == null) goto L10;
        r102 = r105.hashCode();
    L10:
        long r106 = this.f36715h;
        return ((r104 + r102) * 31) + ((int) (r106 ^ (r106 >>> 32)));
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AIMiniAppNativeEvent(appletId=" + this.f36708a + ", eventId=" + this.f36709b + ", eventName=" + this.f36710c + ", payload=" + this.f36711d + ", trigger=" + this.f36712e + ", msgId=" + this.f36713f + ", logId=" + this.f36714g + ", ttlMillis=" + this.f36715h + ')';
    }

    public a(String r100, String r101, JsonObject r102, AIMiniAppNativeTrigger r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, IFlowAppIntentIDL.PARAM_APPLET_ID);
        Intrinsics.checkNotNullParameter(r101, b.f276361k);
        Intrinsics.checkNotNullParameter("action_bar_exposed", "eventName");
        Intrinsics.checkNotNullParameter(r102, WsConstants.KEY_PAYLOAD);
        Intrinsics.checkNotNullParameter(r103, "trigger");
        this.f36708a = r100;
        this.f36709b = r101;
        this.f36710c = "action_bar_exposed";
        this.f36711d = r102;
        this.f36712e = r103;
        this.f36713f = null;
        this.f36714g = r104;
        this.f36715h = 30000;
    }
}
