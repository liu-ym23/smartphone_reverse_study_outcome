package com.bytedance.android.livesdkapi.depend.model.live.episode;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR$\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0016\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMainShowGeneralInfoExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IShowGeneralInfo;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IMainShowGeneralInfo;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "isCommerceReplay", "()Z", "setCommerceReplay", "(Z)V", "Lpy/k;", "getFirstFrame", "()Lpy/k;", "setFirstFrame", "(Lpy/k;)V", "firstFrame", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IShowGeneralInfo;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IMainShowGeneralInfoExtensionImpl extends ModelExtensionBase<IShowGeneralInfo, IMainShowGeneralInfo> implements IMainShowGeneralInfo, IShowGeneralInfo {
    private final /* synthetic */ IShowGeneralInfo $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<IShowGeneralInfo>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<IShowGeneralInfo>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMainShowGeneralInfo
    public k getFirstFrame() {
        return (k) get(1002, IMainShowGeneralInfo.class);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMainShowGeneralInfo
    public boolean isCommerceReplay() {
        return ((Boolean) get(1001, IMainShowGeneralInfo.class, Boolean.FALSE)).booleanValue();
    }

    public IMainShowGeneralInfoExtensionImpl(IShowGeneralInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMainShowGeneralInfo
    public void setCommerceReplay(boolean r100) {
        set(1001, "is_commerce_replay", IMainShowGeneralInfo.class, Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IMainShowGeneralInfo
    public void setFirstFrame(k r100) {
        set(1002, "video_first_frame", IMainShowGeneralInfo.class, r100);
    }
}
