package com.bytedance.android.live.network.response;

import com.bytedance.android.live.base.model.Extra;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public abstract class f<DATA> extends e<DATA> {

    public static final class a extends f<Object> implements c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f83945c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RequestError f83946d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Extra f83947e;

        @Override // com.bytedance.android.live.network.response.c
        public final Extra a() {
            return this.f83947e;
        }

        @Override // com.bytedance.android.live.network.response.c
        public final RequestError getError() {
            return this.f83946d;
        }

        @Override // com.bytedance.android.live.network.response.c
        public final int getStatusCode() {
            return this.f83945c;
        }

        public a(int r100, RequestError r101, Extra r102) {
            super(Unit.INSTANCE, r102);
            this.f83945c = r100;
            this.f83946d = r101;
            this.f83947e = r102;
        }
    }

    public static final class b extends f<Object> {
        public b(Object r100, Extra r101) {
            super(r100, r101);
        }
    }

    public f() {
        throw null;
    }

    public final String toString() {
        return "SimpleResponse<" + this.data.getClass().getCanonicalName() + "> : { log_id: " + this.logId + ", data: " + this.data + ", extra: " + this.extra + " }";
    }

    public f(Object r100, Extra r101) {
        super(r100, r101);
    }
}
