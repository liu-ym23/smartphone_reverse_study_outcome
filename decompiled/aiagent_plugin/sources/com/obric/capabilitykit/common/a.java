package com.obric.capabilitykit.common;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.entity.UriTypeAdapter;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.f f32030a = null;

    /* JADX INFO: renamed from: com.obric.capabilitykit.common.a$a, reason: collision with other inner class name */
    public static final class C0876a extends d.h.b.p implements d.h.a.a<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0876a f32031a = null;

        static {
            f32031a = new C0876a();
        }

        public C0876a() {
            super(0);
        }

        public final Gson a() {
            return new GsonBuilder().registerTypeAdapter(Uri.class, new UriTypeAdapter()).create();
        }

        @Override // d.h.a.a
        public /* synthetic */ Gson invoke() {
            return a();
        }
    }

    static {
        f32030a = d.g.a(C0876a.f32031a);
    }

    public static final Gson a() {
        return (Gson) ZeusTransformUtils.preCheckCast(f32030a.b(), Gson.class, "com.obric.aiagent.plugin");
    }
}
