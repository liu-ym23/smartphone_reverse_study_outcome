package com.bytedance.android.live.revlink.impl.pk.feedview.machine;

import com.bytedance.android.livesdk.link.model.c3;
import com.bytedance.android.livesdk.link.model.e3;

/* JADX INFO: loaded from: classes47.dex */
public abstract class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f96575a;

    public static final class a extends k {
        public a() {
            super("ShowLink");
        }
    }

    public static final class b extends k {
        public b() {
            super("ShowPenal");
        }
    }

    public static final class c extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e3 f96576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c3 f96577c;

        public c(e3 r100, c3 r101) {
            super("ShowPk");
            this.f96576b = r100;
            this.f96577c = r101;
        }
    }

    public k(String r100) {
        this.f96575a = r100;
    }
}
