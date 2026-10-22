package com.bytedance.android.monitorV2.event;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a extends HybridEvent {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f163018p = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public fz2.b f163019m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public jz2.b f163020n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public JSONObject f163021o;

    /* JADX INFO: renamed from: com.bytedance.android.monitorV2.event.a$a, reason: collision with other inner class name */
    public static final class C2492a {
        public static a a(String r100, fz2.b r101) {
            Intrinsics.checkNotNullParameter(r100, "eventType");
            return b(r100, r101, null);
        }

        public static a b(String r100, fz2.b r101, Function1 r102) {
            Intrinsics.checkNotNullParameter(r100, "eventType");
            a r103 = new a(r100);
            r103.f163019m = r101;
            if (r102 == null) goto L5;
            r102.invoke(r103);
        L5:
            r103.c();
            return r103;
        }
    }

    static {
    }

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        super(r100);
    }
}
