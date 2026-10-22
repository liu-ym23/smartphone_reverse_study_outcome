package com.obric.agent.intents.music.netease;

import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: DecryptData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f14828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14830c;

    /* JADX INFO: compiled from: DecryptData.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f14828a = new a(null);
    }

    public h() {
        this.f14829b = "";
        this.f14830c = "";
    }

    public final String a() {
        return this.f14829b;
    }

    public final void a(String r2) {
        o.e(r2, "<set-?>");
        this.f14829b = r2;
    }

    public final String b() {
        return this.f14830c;
    }

    public final void b(String r2) {
        o.e(r2, "<set-?>");
        this.f14830c = r2;
    }
}
