package com.bytedance.android.gamecp.base.network.response;

import com.bytedance.android.gamecp.host_api.model.network.Extra;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class d extends c {

    public static final class a extends d implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f51688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RequestError f51689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Extra f51690c;

        @Override // com.bytedance.android.gamecp.base.network.response.e
        public final Extra a() {
            return this.f51690c;
        }

        @Override // com.bytedance.android.gamecp.base.network.response.e
        public final RequestError getError() {
            return this.f51689b;
        }

        @Override // com.bytedance.android.gamecp.base.network.response.e
        public final int getStatusCode() {
            return this.f51688a;
        }

        public a(int r100, RequestError r101, Extra r102) {
            Intrinsics.checkNotNullParameter(r101, "error");
            Intrinsics.checkNotNullParameter(r102, "errorExtra");
            super(r102);
            this.f51688a = r100;
            this.f51689b = r101;
            this.f51690c = r102;
        }
    }

    public static final class b extends d {
        public b(Extra r100) {
            Intrinsics.checkNotNullParameter(r100, "extra");
            super(r100);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        return "EmptyResponse<" + ((Unit) this.data).getClass().getCanonicalName() + "> : { log_id: " + this.logId + ", extra: " + this.extra + " }";
    }

    public d(Extra r100) {
        super(r100);
    }
}
