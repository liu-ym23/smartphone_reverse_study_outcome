package com.bytedance.android.annie.xbridge.mix;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.z;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class h implements z<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CallContext f40164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BaseA2BBridgeMethod.a f40165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f40166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ies.web.jsbridge2.f<Object, Object> f40167d;

    public static final class a implements z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseA2BBridgeMethod.a f40168a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f40169b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.ies.web.jsbridge2.f<Object, Object> f40170c;

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void a(JSONObject r100) {
            this.f40168a.a(r100);
            this.f40169b.a(this.f40170c);
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onFailed(Throwable r100) {
            this.f40168a.onFailed(r100);
            this.f40169b.a(this.f40170c);
        }

        @Override // com.bytedance.ies.web.jsbridge2.z.a
        public final void onSucceed(Object r100) {
            this.f40168a.onSucceed(r100);
            this.f40169b.a(this.f40170c);
        }

        public a(BaseA2BBridgeMethod.a r100, l r101, com.bytedance.ies.web.jsbridge2.f<Object, Object> r102) {
            this.f40168a = r100;
            this.f40169b = r101;
            this.f40170c = r102;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final z.a getCallBack() {
        return new a(this.f40165b, this.f40166c, this.f40167d);
    }

    @Override // com.bytedance.ies.web.jsbridge2.z
    public final CallContext a() {
        return this.f40164a;
    }

    public h(CallContext r100, BaseA2BBridgeMethod.b r101, g r102, com.bytedance.ies.web.jsbridge2.f r103) {
        this.f40164a = r100;
        this.f40165b = r101;
        this.f40166c = r102;
        this.f40167d = r103;
    }
}
