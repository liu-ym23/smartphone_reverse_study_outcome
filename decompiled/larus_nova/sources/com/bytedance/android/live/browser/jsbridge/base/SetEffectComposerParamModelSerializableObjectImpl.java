package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import w20.me;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0019\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R$\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerParamModelSerializableObjectImpl;", "Lw20/me;", "", "", "nodePaths", "Ljava/util/List;", "w", "()Ljava/util/List;", "setNodePaths", "(Ljava/util/List;)V", PromotionProductPrivilegesStruct.TAGS, "getTags", "setTags", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "scene", "getScene", "setScene", "channel", "getChannel", "setChannel", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SetEffectComposerParamModelSerializableObjectImpl implements me {

    @SerializedName("channel")
    private String channel;

    @SerializedName("name")
    private String name;

    @SerializedName("nodePaths")
    private List<String> nodePaths;

    @SerializedName("scene")
    private String scene;

    @SerializedName(PromotionProductPrivilegesStruct.TAGS)
    private List<String> tags;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SetEffectComposerParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SetEffectComposerParamModelSerializableObjectImpl.class);
        }
    }

    public SetEffectComposerParamModelSerializableObjectImpl() {
    }

    @Override // w20.me
    public final String getChannel() {
        return this.channel;
    }

    @Override // w20.me
    public final String getName() {
        return this.name;
    }

    @Override // w20.me
    public final String getScene() {
        return this.scene;
    }

    @Override // w20.me
    public final List<String> getTags() {
        return this.tags;
    }

    @Override // w20.me
    public final List<String> w() {
        return this.nodePaths;
    }
}
