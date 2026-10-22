package com.bytedance.android.live.network.response;

import com.bytedance.android.live.base.model.Extra;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public abstract class b extends com.bytedance.android.live.network.response.a {

    public static final class a extends b implements c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f83939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RequestError f83940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Extra f83941e;

        @Override // com.bytedance.android.live.network.response.c
        public final Extra a() {
            return this.f83941e;
        }

        @Override // com.bytedance.android.live.network.response.c
        public final RequestError getError() {
            return this.f83940d;
        }

        @Override // com.bytedance.android.live.network.response.c
        public final int getStatusCode() {
            return this.f83939c;
        }

        public a(int r100, RequestError r101, Extra r102) {
            super(r102);
            this.f83939c = r100;
            this.f83940d = r101;
            this.f83941e = r102;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.network.response.b$b, reason: collision with other inner class name */
    public static final class C1274b extends b {
        public C1274b(Extra r100) {
            super(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        return "EmptyResponse<" + ((Unit) this.data).getClass().getCanonicalName() + "> : { log_id: " + this.logId + ", extra: " + this.extra + " }";
    }

    public b(Extra r100) {
        super(r100);
    }
}
