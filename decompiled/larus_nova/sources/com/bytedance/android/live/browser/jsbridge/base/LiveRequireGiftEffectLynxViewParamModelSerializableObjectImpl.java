package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w20.cb;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR$\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR$\u0010 \u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveRequireGiftEffectLynxViewParamModelSerializableObjectImpl;", "Lw20/cb;", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", "setSchema", "(Ljava/lang/String;)V", "", "draggable", "Ljava/lang/Boolean;", "U2", "()Ljava/lang/Boolean;", "setDraggable", "(Ljava/lang/Boolean;)V", "", "type", "Ljava/lang/Integer;", "getType", "()Ljava/lang/Integer;", "setType", "(Ljava/lang/Integer;)V", "action", "getAction", "setAction", "touchable", "I5", "setTouchable", "channel", "getChannel", "setChannel", "superViewIdentifier", "i2", "setSuperViewIdentifier", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveRequireGiftEffectLynxViewParamModelSerializableObjectImpl implements cb {

    @SerializedName("action")
    private Integer action;

    @SerializedName("channel")
    private String channel;

    @SerializedName("draggable")
    private Boolean draggable;

    @SerializedName("schema")
    private String schema;

    @SerializedName("superViewIdentifier")
    private String superViewIdentifier;

    @SerializedName("touchable")
    private Boolean touchable;

    @SerializedName("type")
    private Integer type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveRequireGiftEffectLynxViewParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LiveRequireGiftEffectLynxViewParamModelSerializableObjectImpl.class);
        }
    }

    public LiveRequireGiftEffectLynxViewParamModelSerializableObjectImpl() {
    }

    @Override // w20.cb
    public final Boolean I5() {
        return this.touchable;
    }

    @Override // w20.cb
    public final Boolean U2() {
        return this.draggable;
    }

    @Override // w20.cb
    public final Integer getAction() {
        return this.action;
    }

    @Override // w20.cb
    public final String getChannel() {
        return this.channel;
    }

    @Override // w20.cb
    public final String getSchema() {
        return this.schema;
    }

    @Override // w20.cb
    public final Integer getType() {
        return this.type;
    }

    @Override // w20.cb
    public final String i2() {
        return this.superViewIdentifier;
    }
}
