package com.bytedance.android.live.browser.jsbridge.base;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w20.ce;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SendEffectMessageParamModelSerializableObjectImpl;", "Lw20/ce;", "", "msgID", "Ljava/lang/Integer;", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Integer;", "setMsgID", "(Ljava/lang/Integer;)V", "arg1", "g3", "setArg1", "arg2", "w3", "setArg2", "", "arg3", "Ljava/lang/String;", "q3", "()Ljava/lang/String;", "setArg3", "(Ljava/lang/String;)V", "channel", "getChannel", "setChannel", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SendEffectMessageParamModelSerializableObjectImpl implements ce {

    @SerializedName("arg1")
    private Integer arg1;

    @SerializedName("arg2")
    private Integer arg2;

    @SerializedName("arg3")
    private String arg3;

    @SerializedName("channel")
    private String channel;

    @SerializedName("msgID")
    private Integer msgID;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/SendEffectMessageParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SendEffectMessageParamModelSerializableObjectImpl.class);
        }
    }

    public SendEffectMessageParamModelSerializableObjectImpl() {
    }

    @Override // w20.ce
    public final Integer T() {
        return this.msgID;
    }

    @Override // w20.ce
    public final Integer g3() {
        return this.arg1;
    }

    @Override // w20.ce
    public final String getChannel() {
        return this.channel;
    }

    @Override // w20.ce
    public final String q3() {
        return this.arg3;
    }

    @Override // w20.ce
    public final Integer w3() {
        return this.arg2;
    }
}
