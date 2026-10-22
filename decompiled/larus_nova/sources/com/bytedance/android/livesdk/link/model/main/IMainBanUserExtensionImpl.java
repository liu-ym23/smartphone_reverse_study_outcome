package com.bytedance.android.livesdk.link.model.main;

import com.bytedance.android.livesdk.link.model.j0;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.e;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0014\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/main/IMainBanUserExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/j0;", "Lcom/bytedance/android/livesdk/link/model/main/a;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getReason", "()Ljava/lang/String;", "setReason", "(Ljava/lang/String;)V", "reason", "getSchemaUrl", "schemaUrl", "getUrl", "url", "getUserId", "setUserId", "userId", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/j0;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainBanUserExtensionImpl extends ModelExtensionBase<j0, a> implements a, j0 {
    private final /* synthetic */ j0 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<j0>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<j0>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.main.a, com.bytedance.android.livesdk.link.model.j0
    public String getReason() {
        return this.$$delegate_0.getReason();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.a, com.bytedance.android.livesdk.link.model.j0
    public String getSchemaUrl() {
        return this.$$delegate_0.getSchemaUrl();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.a, com.bytedance.android.livesdk.link.model.j0
    public String getUrl() {
        return this.$$delegate_0.getUrl();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.a, com.bytedance.android.livesdk.link.model.j0
    public String getUserId() {
        return this.$$delegate_0.getUserId();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.a, com.bytedance.android.livesdk.link.model.j0
    public void setReason(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.$$delegate_0.setReason(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.main.a, com.bytedance.android.livesdk.link.model.j0
    public void setUserId(String r100) {
        this.$$delegate_0.setUserId(r100);
    }

    public IMainBanUserExtensionImpl(j0 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
