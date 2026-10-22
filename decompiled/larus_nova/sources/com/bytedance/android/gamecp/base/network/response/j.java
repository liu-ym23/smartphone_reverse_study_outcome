package com.bytedance.android.gamecp.base.network.response;

import com.bytedance.android.gamecp.host_api.model.network.Extra;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public abstract class j<DATA> extends i<DATA> {

    public static final class a extends j<Object> implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f51694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RequestError f51695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Extra f51696c;

        @Override // com.bytedance.android.gamecp.base.network.response.e
        public final Extra a() {
            return this.f51696c;
        }

        @Override // com.bytedance.android.gamecp.base.network.response.e
        public final RequestError getError() {
            return this.f51695b;
        }

        @Override // com.bytedance.android.gamecp.base.network.response.e
        public final int getStatusCode() {
            return this.f51694a;
        }

        public a(int r100, RequestError r101, Extra r102) {
            Intrinsics.checkNotNullParameter(r101, "error");
            Intrinsics.checkNotNullParameter(r102, "errorExtra");
            super(Unit.INSTANCE, r102);
            this.f51694a = r100;
            this.f51695b = r101;
            this.f51696c = r102;
        }
    }

    public static final class b extends j<Object> {
        public b(Object r100, Extra r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            Intrinsics.checkNotNullParameter(r101, "extra");
            super(r100, r101);
        }
    }

    public j() {
        throw null;
    }

    public final String toString() {
        return "SimpleResponse<" + this.data.getClass().getCanonicalName() + "> : { log_id: " + this.logId + ", data: " + this.data + ", extra: " + this.extra + " }";
    }

    public j(Object r100, Extra r101) {
        super(r100, r101);
    }
}
