package com.bytedance.ai.monitor;

import com.bytedance.ai.utils.g;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class AppletJSBEvent extends AppletMonitorableEvent {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f37131k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f37132l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public JSBType f37133m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f37134n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f37135o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public JSONObject f37136p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f37137q;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ai/monitor/AppletJSBEvent$JSBType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "AppletJSB", "XBridge", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum JSBType extends Enum<JSBType> {
        public static final JSBType AppletJSB = null;
        public static final JSBType XBridge = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ JSBType[] f37138a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f37139b = null;
        private final int type;

        public static EnumEntries<JSBType> getEntries() {
            return f37139b;
        }

        static {
            JSBType r100 = new JSBType("AppletJSB", 0, 0);
            AppletJSB = r100;
            JSBType r101 = new JSBType("XBridge", 1, 1);
            XBridge = r101;
            JSBType[] r102 = {r100, r101};
            f37138a = r102;
            f37139b = EnumEntriesKt.enumEntries(r102);
        }

        public static JSBType[] values() {
            return (JSBType[]) f37138a.clone();
        }

        public final int getType() {
            return this.type;
        }

        public static JSBType valueOf(String r100) {
            return (JSBType) r27.a.a(JSBType.class, r100);
        }

        public JSBType(String r100, int r101, int r102) {
            super(r100, r101);
            this.type = r102;
        }
    }

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final JSONObject a() {
        JSONObject r100 = new JSONObject();
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        r100.putOpt("packageId", this.f37145f);     // Catch: Throwable -> L5
        r100.putOpt("appId", this.f37146g);     // Catch: Throwable -> L5
        r100.putOpt("bridgeName", this.f37131k);     // Catch: Throwable -> L5
        r100.putOpt("code", Integer.valueOf(this.f37132l));     // Catch: Throwable -> L5
        r100.putOpt("jsbType", this.f37133m.name());     // Catch: Throwable -> L5
        r100.putOpt("message", this.f37134n);     // Catch: Throwable -> L5
        r100.putOpt("success", Boolean.valueOf(this.f37135o));     // Catch: Throwable -> L5
        r100.putOpt("url", this.f37137q);     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(r100.putOpt("containerType", null));     // Catch: Throwable -> L5
    L7:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L10;
        g.f37637a.w("AppletJSBEvent", "Exception when get category: " + r103);
    L10:
        return r100;
    L5:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final boolean b() {
        if (super.b() == true) goto L5;
        return false;
    L5:
        if ((!StringsKt.isBlank(this.f37131k)) == true) goto L7;
        return false;
    L7:
        if (this.f37131k.length() <= 0) goto L9;
        boolean r100 = true;
    L10:
        if (r100 == false) goto L15;
        return true;
    L15:
        return false;
    L9:
        r100 = false;
        goto L10
    }

    @Override // com.bytedance.ai.monitor.AppletMonitorableEvent
    public final JSONObject n() {
        JSONObject r100 = super.n();
        if (r100.length() != 0) goto L11;
        return r100;
    L11:
    L9:
        g.f37637a.w("AppletJSBEvent", "Exception occurred when parse jsb event to json");
    L10:
        return r100;
    L6:
        if (this.f37135o == true) goto L10;
        r100.putOpt("params", this.f37136p);     // Catch: JSONException -> L9
        goto L10
    }

    public AppletJSBEvent(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "bridgeName");
        super("applet_jsb_event");
        this.f37133m = JSBType.AppletJSB;
        this.f37135o = true;
        Intrinsics.checkNotNullParameter("jsb_event", "<set-?>");
        this.f37141b = "jsb_event";
        this.f37131k = r100;
        this.f37132l = r101;
    }
}
