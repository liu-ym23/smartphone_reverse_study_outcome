package com.bytedance.android.live.profit.format.voicechat.log;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mz0.n;
import vh6.c;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f87660c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f87661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f87662b;

    /* JADX INFO: renamed from: com.bytedance.android.live.profit.format.voicechat.log.a$a, reason: collision with other inner class name */
    public static final class C1334a {
        public static void a(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "eventName");
            Intrinsics.checkNotNullParameter(r101, "params");
            n r102 = new n();
            Map<String, String> r103 = r102.f516447a;
            Intrinsics.checkNotNullParameter(r103, "map");
            Intrinsics.checkNotNullParameter(r101, "map");
            r103.putAll(r101);
            ((kr2.a) c.b(kr2.a.class)).Xj(r100, r102.f516447a, r102.f516448b);
        }
    }

    static {
    }

    public a() {
        this.f87661a = new LinkedHashMap();
        this.f87662b = "";
    }

    public static /* synthetic */ void b(a r100, String r101) {
        r100.a(r101, VoiceChatLogger$sendCommonLog$1.INSTANCE);
    }

    public final void a(String r100, Function0<? extends Map<String, String>> r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, "paramsBuilder");
        C1334a.a(r100, MapsKt.plus(r101.invoke(), this.f87661a));
    }
}
