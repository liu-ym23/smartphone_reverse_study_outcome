package com.obric.eventkit.task.model;

import android.os.Parcel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;

/* JADX INFO: compiled from: TimerTask.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f33227a = null;

    public static /* synthetic */ Gson lambda$p3rE66cVWyfX7HdnigvabhM_SS8() {
        return b();
    }

    static {
        f33227a = g.a($$Lambda$b$p3rE66cVWyfX7HdnigvabhM_SS8.INSTANCE);
    }

    public static final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f33227a.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    private static final Gson b() {
        return new GsonBuilder().create();
    }

    public static final String a(Parcel r1) {
        o.e(r1, "<this>");
        String r2 = r1.readString();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }

    public static final TimerTaskAction a(String r2) {
        o.e(r2, "<this>");
        return (TimerTaskAction) ZeusTransformUtils.preCheckCast(a().fromJson(r2, TimerTaskAction.class), TimerTaskAction.class, "com.obric.aiagent.plugin");
    }
}
