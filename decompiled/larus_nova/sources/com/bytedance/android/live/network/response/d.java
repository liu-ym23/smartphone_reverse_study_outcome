package com.bytedance.android.live.network.response;

import com.bytedance.android.live.base.model.Extra;
import kotlin.Unit;

/* JADX INFO: loaded from: classes46.dex */
public abstract class d<DATA, EXTRA extends Extra> extends ExtraResponse<DATA, EXTRA> {

    public static final class a extends d<Object, Extra> implements c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f83942c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final RequestError f83943d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Extra f83944e;

        @Override // com.bytedance.android.live.network.response.c
        public final Extra a() {
            return this.f83944e;
        }

        @Override // com.bytedance.android.live.network.response.c
        public final RequestError getError() {
            return this.f83943d;
        }

        @Override // com.bytedance.android.live.network.response.c
        public final int getStatusCode() {
            return this.f83942c;
        }

        public a(int r100, RequestError r101, Extra r102) {
            super(Unit.INSTANCE, r102);
            this.f83942c = r100;
            this.f83943d = r101;
            this.f83944e = r102;
        }
    }

    public static final class b extends d<Object, Extra> {
        public b(Object r100, Extra r101) {
            super(r100, r101);
        }
    }

    public d() {
        throw null;
    }

    public final String toString() {
        return "ExtraResponse<" + this.data.getClass().getCanonicalName() + ", " + this.extra.getClass().getCanonicalName() + "> : { log_id: " + this.logId + ", data: " + this.data + ", extra: " + this.extra + " }";
    }

    public d(Object r100, Extra r101) {
        super(r100, r101);
    }
}
