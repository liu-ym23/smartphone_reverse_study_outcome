package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.b.o;
import d.h.b.p;

/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final f f33214a = null;

    public static final class a extends p implements d.h.a.a<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f33215a = null;

        static {
            f33215a = new a();
        }

        public a() {
            super(0);
        }

        public final Gson a() {
            return new GsonBuilder().create();
        }

        @Override // d.h.a.a
        public /* synthetic */ Gson invoke() {
            return a();
        }
    }

    static {
        f33214a = g.a(a.f33215a);
    }

    public static final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f33214a.b(), Gson.class, "com.obric.aiagent.plugin");
    }

    public static final String a(Parcel r1) {
        o.e(r1, "<this>");
        String r2 = r1.readString();
        if (r2 != null) goto L6;
        return "";
    L6:
        return r2;
    }
}
