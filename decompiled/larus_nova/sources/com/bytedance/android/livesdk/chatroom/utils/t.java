package com.bytedance.android.livesdk.chatroom.utils;

import com.bytedance.android.logsdk.format.Spm;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class t {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f114623e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f114624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f114625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f114626c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f114627d;

    public static final class a {
    }

    static {
    }

    public final Spm a() {
        Spm.a r100 = Spm.Companion;
        String r101 = this.f114624a;
        r100.getClass();
        Spm r102 = Spm.a.a(r101);
        Map<String, Object> r103 = this.f114627d;
        if (r103 == null) goto L5;
        r102.addArgs(r103);
    L5:
        String r104 = this.f114626c;
        if (r104 != null) goto L8;
    L11:
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
        r102.fromSpm(this.f114626c);
    L14:
        return r102;
    L8:
        if (r104.length() == 0) goto L11;
        r105 = false;
        goto L12
    }

    public t(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spm");
        Intrinsics.checkNotNullParameter(r101, "tagSuffix");
        this.f114624a = r100;
        this.f114625b = r101;
        this.f114626c = null;
        this.f114627d = null;
    }

    public final void b(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Spm r102 = a().result(r101).reason(r100);
        String r103 = "DynamicSpmMonitor" + this.f114625b;
        Intrinsics.checkNotNullParameter(r102, "$this$report");
        sw2.a.b(r102, r103);
    }

    public final void c(String r100, Map<String, Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Spm r102 = a().reason(r100);
        if (r101 == null) goto L5;
        r102.args(r101);
    L5:
        Unit r103 = Unit.INSTANCE;
        String r104 = "DynamicSpmMonitor" + this.f114625b;
        Intrinsics.checkNotNullParameter(r102, "$this$report");
        sw2.a.b(r102, r104);
    }
}
