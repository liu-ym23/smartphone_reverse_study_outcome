package com.bytedance.android.livesdk.chatroom.end.vs;

import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import vg1.e;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DataCenter f106185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f106186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f106187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Boolean> f106188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f106189e;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.end.vs.a$a, reason: collision with other inner class name */
    public static final class C1605a {
    }

    static {
    }

    public final Context getContext() {
        return this.f106187c;
    }

    public a(EndContainerWidgetForVs r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridContainer");
        this.f106189e = r100;
        r100.wq(new b(this));
    }

    public static String a(String r100, o r101) {
        if (r101 != null) goto L5;
        return "";
    L5:
        String r102 = r101.getMap().get(r100);
        if (r102 != null) goto L9;
        return "";
    L9:
        return r102;
    }
}
