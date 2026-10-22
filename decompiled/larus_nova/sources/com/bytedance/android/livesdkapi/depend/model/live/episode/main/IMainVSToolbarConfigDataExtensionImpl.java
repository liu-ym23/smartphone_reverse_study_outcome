package com.bytedance.android.livesdkapi.depend.model.live.episode.main;

import com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0018\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR(\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001b\u001a\u00020\u00168\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014R\u0016\u0010!\u001a\u0004\u0018\u00010\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b \u0010\u0014R\u0016\u0010#\u001a\u0004\u0018\u00010\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u000eR\u001c\u0010&\u001a\u00020\u00168\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b$\u0010\u0018\"\u0004\b%\u0010\u001aR\u001e\u0010*\u001a\u0004\u0018\u00010\u00128\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b'\u0010\u0014\"\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/episode/main/IMainVSToolbarConfigDataExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSToolbarConfigData;", "Lcom/bytedance/android/livesdkapi/depend/model/live/episode/main/IMainVSToolbarConfigData;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "value", "getExtra", "()Ljava/lang/String;", "setExtra", "(Ljava/lang/String;)V", "extra", "Lpy/k;", "getBottomIcon", "()Lpy/k;", "bottomIcon", "", "getDisplayType", "()I", "setDisplayType", "(I)V", "displayType", "getDynamicBottomIcon", "dynamicBottomIcon", "getDynamicIcon", "dynamicIcon", "getIcon", "icon", "getSchema", "schema", "getToolbarType", "setToolbarType", "toolbarType", "getVerticalIcon", "setVerticalIcon", "(Lpy/k;)V", "verticalIcon", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/live/episode/IVSToolbarConfigData;)V", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public class IMainVSToolbarConfigDataExtensionImpl extends ModelExtensionBase<IVSToolbarConfigData, IMainVSToolbarConfigData> implements IMainVSToolbarConfigData, IVSToolbarConfigData {
    private final /* synthetic */ IVSToolbarConfigData $$delegate_0;

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<IVSToolbarConfigData>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castTo(r100);
    }

    @Override // com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase, com.bytedance.android.live.core.resources.f, com.bytedance.android.live.core.resources.e, vh7.c
    public <R extends e<IVSToolbarConfigData>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.$$delegate_0.castToOrNull(r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getBottomIcon() {
        return this.$$delegate_0.getBottomIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public int getDisplayType() {
        return this.$$delegate_0.getDisplayType();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getDynamicBottomIcon() {
        return this.$$delegate_0.getDynamicBottomIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getDynamicIcon() {
        return this.$$delegate_0.getDynamicIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getIcon() {
        return this.$$delegate_0.getIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public String getSchema() {
        return this.$$delegate_0.getSchema();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public int getToolbarType() {
        return this.$$delegate_0.getToolbarType();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public k getVerticalIcon() {
        return this.$$delegate_0.getVerticalIcon();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public void setDisplayType(int r100) {
        this.$$delegate_0.setDisplayType(r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public void setToolbarType(int r100) {
        this.$$delegate_0.setToolbarType(r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.IVSToolbarConfigData
    public void setVerticalIcon(k r100) {
        this.$$delegate_0.setVerticalIcon(r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainVSToolbarConfigData
    public String getExtra() {
        return (String) get(10, IMainVSToolbarConfigData.class);
    }

    public IMainVSToolbarConfigDataExtensionImpl(IVSToolbarConfigData r100) {
        Intrinsics.checkNotNullParameter(r100, "base");
        super(r100);
        this.$$delegate_0 = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainVSToolbarConfigData
    public void setExtra(String r100) {
        set(10, "extra", IMainVSToolbarConfigData.class, r100);
    }
}
