package com.bytedance.ai.bridge.method.net.core;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ai/bridge/method/net/core/RequestMethod;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "PUT", "DELETE", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RequestMethod extends Enum<RequestMethod> {
    public static final RequestMethod DELETE = null;
    public static final RequestMethod GET = null;
    public static final RequestMethod POST = null;
    public static final RequestMethod PUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RequestMethod[] f35635a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f35636b = null;

    public static EnumEntries<RequestMethod> getEntries() {
        return f35636b;
    }

    static {
        RequestMethod r100 = new RequestMethod("GET", 0);
        GET = r100;
        RequestMethod r101 = new RequestMethod("POST", 1);
        POST = r101;
        RequestMethod r102 = new RequestMethod("PUT", 2);
        PUT = r102;
        RequestMethod r103 = new RequestMethod("DELETE", 3);
        DELETE = r103;
        RequestMethod[] r104 = {r100, r101, r102, r103};
        f35635a = r104;
        f35636b = EnumEntriesKt.enumEntries(r104);
    }

    public static RequestMethod[] values() {
        return (RequestMethod[]) f35635a.clone();
    }

    public static RequestMethod valueOf(String r100) {
        return (RequestMethod) a.a(RequestMethod.class, r100);
    }

    public RequestMethod(String r100, int r101) {
        super(r100, r101);
    }
}
