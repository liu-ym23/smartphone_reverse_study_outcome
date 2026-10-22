package com.bytedance.android.livesdk.link.model.main;

import com.bytedance.android.livesdk.link.model.t0;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001b\u001a\u00060\u0017j\u0002`\u00188\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00138\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R\u0018\u0010 \u001a\u00060\u0013j\u0002`\u001e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0014\u0010\"\u001a\u00020\u00138\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u0015¨\u0006&"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/main/IMainBattleAuxiliaryMessage_MainAuxiliaryScoreInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/link/model/t0$a;", "Lcom/bytedance/android/livesdk/link/model/main/b$b;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getNoNeedUpdateScore", "()Z", "noNeedUpdateScore", "", "getAnchorScore", "()Ljava/lang/String;", "anchorScore", "", "getAnchorScoreInt", "()J", "anchorScoreInt", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getAuxiliaryImg", "()Lpy/k;", "auxiliaryImg", "getAuxiliaryType", "auxiliaryType", "Lcom/bytedance/android/livesdkapi/depend/model/live/typedef/GiftId;", "getGiftId", "giftId", "getIndex", "index", "base", "<init>", "(Lcom/bytedance/android/livesdk/link/model/t0$a;)V", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainBattleAuxiliaryMessage_MainAuxiliaryScoreInfoExtensionImpl extends ModelExtensionBase<t0.a, b.InterfaceC2288b> implements b.InterfaceC2288b, t0.a {
    private final /* synthetic */ t0.a $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<t0.a>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<t0.a>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdk.link.model.main.b.InterfaceC2288b, com.bytedance.android.livesdk.link.model.t0.a
    public String getAnchorScore() {
        return this.$$delegate_0.getAnchorScore();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.b.InterfaceC2288b, com.bytedance.android.livesdk.link.model.t0.a
    public long getAnchorScoreInt() {
        return this.$$delegate_0.getAnchorScoreInt();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.b.InterfaceC2288b, com.bytedance.android.livesdk.link.model.t0.a
    public k getAuxiliaryImg() {
        return this.$$delegate_0.getAuxiliaryImg();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.b.InterfaceC2288b, com.bytedance.android.livesdk.link.model.t0.a
    public long getAuxiliaryType() {
        return this.$$delegate_0.getAuxiliaryType();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.b.InterfaceC2288b, com.bytedance.android.livesdk.link.model.t0.a
    public long getGiftId() {
        return this.$$delegate_0.getGiftId();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.b.InterfaceC2288b, com.bytedance.android.livesdk.link.model.t0.a
    public long getIndex() {
        return this.$$delegate_0.getIndex();
    }

    @Override // com.bytedance.android.livesdk.link.model.main.b.InterfaceC2288b
    public boolean getNoNeedUpdateScore() {
        return ((Boolean) get(7, b.InterfaceC2288b.class, Boolean.FALSE)).booleanValue();
    }

    public IMainBattleAuxiliaryMessage_MainAuxiliaryScoreInfoExtensionImpl(t0.a r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }
}
