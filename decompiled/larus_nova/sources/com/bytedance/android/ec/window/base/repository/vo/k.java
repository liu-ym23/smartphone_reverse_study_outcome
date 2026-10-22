package com.bytedance.android.ec.window.base.repository.vo;

import com.bytedance.android.ec.window.base.repository.dto.q;
import com.bytedance.services.apm.api.EnsureManager;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class k implements QModel {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f49502h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f49503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f49504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f49505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f49506d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f49507e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super k, Unit> f49508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f49509g;

    public static final class a {
        public static k a(q r100) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            k r101 = new k();
            r101.f49503a = r100.d();
            String r102 = r100.e();
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r101.f49504b = r102;
            r101.f49505c = r100.f();
            r101.f49506d = r100.b();
            r101.f49507e = r100.c();
            com.bytedance.android.ec.window.base.repository.dto.a r103 = r100.a();
            if (r103 == null) goto L7;
            Boolean r104 = r103.b();
            if (r104 == null) goto L7;
            boolean r105 = r104.booleanValue();
        L8:
            r101.f49509g = r105;
            Gson r106 = new Gson();     // Catch: Exception -> L15
            com.bytedance.android.ec.window.base.repository.dto.a r107 = r100.a();     // Catch: Exception -> L15
            if (r107 == null) goto L12;
            String r108 = r107.a();     // Catch: Exception -> L15
        L13:
            WindowRemoteStruct r109 = (WindowRemoteStruct) r106.fromJson(r108, WindowRemoteStruct.class);     // Catch: Exception -> L15
        L16:
            return r101;
        L12:
            r108 = null;
        L15:
            EnsureManager.ensureNotReachHere("e");
        L7:
            r105 = false;
            goto L8
        }
    }

    static {
    }

    @Override // com.ss.android.ugc.aweme.kiwi.model.QModel
    public final int modelType() {
        return 100;
    }

    public k() {
        this.f49504b = "";
    }
}
