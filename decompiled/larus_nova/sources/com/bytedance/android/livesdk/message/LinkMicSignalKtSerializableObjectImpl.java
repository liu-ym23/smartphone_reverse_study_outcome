package com.bytedance.android.livesdk.message;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import gm2.j;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006("}, d2 = {"Lcom/bytedance/android/livesdk/message/LinkMicSignalKtSerializableObjectImpl;", "Lgm2/j;", "", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "targetUserId", "getTargetUserId", "setTargetUserId", "targetInteractId", "getTargetInteractId", "setTargetInteractId", "targetInteractIdStr", "getTargetInteractIdStr", "setTargetInteractIdStr", "senderUserId", "getSenderUserId", "setSenderUserId", "senderInteractId", "getSenderInteractId", "setSenderInteractId", "senderInteractIdStr", "getSenderInteractIdStr", "setSenderInteractIdStr", "", "priority", "I", "getPriority", "()I", "setPriority", "(I)V", "type", "getType", "setType", "<init>", "()V", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkMicSignalKtSerializableObjectImpl implements j {

    @SerializedName("priority")
    private int priority;

    @SerializedName("send_uid")
    private String senderInteractId;

    @SerializedName("send_uid_str")
    private String senderInteractIdStr;

    @SerializedName("send_id")
    private String senderUserId;

    @SerializedName("target_uid")
    private String targetInteractId;

    @SerializedName("target_uid_str")
    private String targetInteractIdStr;

    @SerializedName("target_id")
    private String targetUserId;

    @SerializedName("type")
    private int type;

    @SerializedName("ver")
    private String version;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/message/LinkMicSignalKtSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(LinkMicSignalKtSerializableObjectImpl.class);
        }
    }

    public LinkMicSignalKtSerializableObjectImpl() {
        this.version = "";
    }

    @Override // gm2.j
    public final int getType() {
        return this.type;
    }
}
