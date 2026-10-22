package com.bytedance.android.livesdk.vs.model.message;

import com.bytedance.android.live.base.model.message.h1;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ku2.b;
import vh7.e;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tJ\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0001R\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000f¨\u0006 "}, d2 = {"Lcom/bytedance/android/livesdk/vs/model/message/VSInRoomBannerMessageExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/base/model/message/h1;", "Lku2/b;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lcom/google/gson/JsonObject;", "extra", "", "getPosition", "()I", "position", "getContainerType", "containerType", "getExtra", "()Lcom/google/gson/JsonObject;", "", "getH5Url", "()Ljava/lang/String;", "h5Url", "getLynxUrl", "lynxUrl", "getOperationType", "operationType", "base", "<init>", "(Lcom/bytedance/android/live/base/model/message/h1;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class VSInRoomBannerMessageExtensionImpl extends ModelExtensionBase<h1, b> implements b, h1 {
    private final /* synthetic */ h1 $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<h1>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<h1>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // ku2.b, com.bytedance.android.live.base.model.message.h1
    public JsonObject extra() {
        return this.$$delegate_0.extra();
    }

    @Override // ku2.b, com.bytedance.android.live.base.model.message.h1
    public int getContainerType() {
        return this.$$delegate_0.getContainerType();
    }

    @Override // ku2.b, com.bytedance.android.live.base.model.message.h1
    public JsonObject getExtra() {
        return this.$$delegate_0.getExtra();
    }

    @Override // ku2.b, com.bytedance.android.live.base.model.message.h1
    public String getH5Url() {
        return this.$$delegate_0.getH5Url();
    }

    @Override // ku2.b, com.bytedance.android.live.base.model.message.h1
    public String getLynxUrl() {
        return this.$$delegate_0.getLynxUrl();
    }

    @Override // ku2.b, com.bytedance.android.live.base.model.message.h1
    public int getOperationType() {
        return this.$$delegate_0.getOperationType();
    }

    @Override // ku2.b, com.bytedance.android.live.base.model.message.h1
    public int getPosition() {
        return ((Number) get(3, b.class, 1)).intValue();
    }

    public VSInRoomBannerMessageExtensionImpl(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
