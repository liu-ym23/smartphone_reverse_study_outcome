package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import w20.v7;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR*\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR$\u0010\u001a\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000f¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/ChangeGiftReceiverParamModelSerializableObjectImpl;", "Lw20/v7;", "", "user_id", "Ljava/lang/String;", "R0", "()Ljava/lang/String;", "setUser_id", "(Ljava/lang/String;)V", "", "is_all_mic", "Ljava/lang/Boolean;", "F0", "()Ljava/lang/Boolean;", "set_all_mic", "(Ljava/lang/Boolean;)V", "", "user_ids", "Ljava/util/List;", "j5", "()Ljava/util/List;", "setUser_ids", "(Ljava/util/List;)V", "specified_user", "A8", "setSpecified_user", "is_multi_user", "W6", "set_multi_user", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ChangeGiftReceiverParamModelSerializableObjectImpl implements v7 {

    @SerializedName("is_all_mic")
    private Boolean is_all_mic;

    @SerializedName("is_multi_user")
    private Boolean is_multi_user;

    @SerializedName("specified_user")
    private String specified_user;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("user_ids")
    private List<String> user_ids;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/ChangeGiftReceiverParamModelSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ChangeGiftReceiverParamModelSerializableObjectImpl.class);
        }
    }

    public ChangeGiftReceiverParamModelSerializableObjectImpl() {
    }

    @Override // w20.v7
    public final String A8() {
        return this.specified_user;
    }

    @Override // w20.v7
    public final Boolean F0() {
        return this.is_all_mic;
    }

    @Override // w20.v7
    public final String R0() {
        return this.user_id;
    }

    @Override // w20.v7
    public final Boolean W6() {
        return this.is_multi_user;
    }

    @Override // w20.v7
    public final List<String> j5() {
        return this.user_ids;
    }
}
