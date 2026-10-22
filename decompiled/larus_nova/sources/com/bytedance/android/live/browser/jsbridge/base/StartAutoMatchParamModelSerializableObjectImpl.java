package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w20.ze;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\"\u0010\u0019\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/StartAutoMatchParamModelSerializableObjectImpl;", "Lw20/ze;", "", "matchType", "I", "getMatchType", "()I", "setMatchType", "(I)V", "matchStyleType", "W4", "setMatchStyleType", "scene", "getScene", "setScene", "", "activityType", "Ljava/lang/String;", "getActivityType", "()Ljava/lang/String;", "setActivityType", "(Ljava/lang/String;)V", "source", "getSource", "setSource", "extra", "getExtra", "setExtra", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class StartAutoMatchParamModelSerializableObjectImpl implements ze {

    @SerializedName("activityType")
    private String activityType;

    @SerializedName("extra")
    private String extra;

    @SerializedName("matchStyleType")
    private int matchStyleType;

    @SerializedName("matchType")
    private int matchType;

    @SerializedName("scene")
    private int scene;

    @SerializedName("source")
    private String source;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/StartAutoMatchParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(StartAutoMatchParamModelSerializableObjectImpl.class);
        }
    }

    public StartAutoMatchParamModelSerializableObjectImpl() {
        this.activityType = "";
        this.source = "";
        this.extra = "";
    }

    @Override // w20.ze
    public final int W4() {
        return this.matchStyleType;
    }

    @Override // w20.ze
    public final String getActivityType() {
        return this.activityType;
    }

    @Override // w20.ze
    public final String getExtra() {
        return this.extra;
    }

    @Override // w20.ze
    public final int getMatchType() {
        return this.matchType;
    }

    @Override // w20.ze
    public final int getScene() {
        return this.scene;
    }

    @Override // w20.ze
    public final String getSource() {
        return this.source;
    }
}
