package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/AssetServiceOptSerializableObjectImpl;", "Lcom/bytedance/android/livesdk/gift/configmodel/h;", "", "handleTaskAsync", "Z", "p7", "()Z", "prepareUrl", "Z6", "changeInitOrder", "r7", "cancelWriteSp", "o4", "asyncRequestAssets", "N7", "asyncUpdateAssetsModel", "v3", "resultLogOpt", "x3", "threadSwitchOpt", "O2", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetServiceOptSerializableObjectImpl implements h {

    @SerializedName("async_request_assets")
    private final boolean asyncRequestAssets;

    @SerializedName("async_update_assets_model")
    private final boolean asyncUpdateAssetsModel;

    @SerializedName("cancel_record")
    private final boolean cancelWriteSp;

    @SerializedName("change_init_order")
    private final boolean changeInitOrder;

    @SerializedName("task_async")
    private final boolean handleTaskAsync;

    @SerializedName("prepare_url")
    private final boolean prepareUrl;

    @SerializedName("result_log")
    private final boolean resultLogOpt;

    @SerializedName("thread_switch_opt")
    private final boolean threadSwitchOpt;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/AssetServiceOptSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(AssetServiceOptSerializableObjectImpl.class);
        }
    }

    public AssetServiceOptSerializableObjectImpl() {
        this.handleTaskAsync = false;
        this.prepareUrl = false;
        this.changeInitOrder = false;
        this.cancelWriteSp = false;
        this.asyncRequestAssets = false;
        this.asyncUpdateAssetsModel = false;
        this.resultLogOpt = false;
        this.threadSwitchOpt = false;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.h
    public final boolean N7() {
        return this.asyncRequestAssets;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.h
    public final boolean O2() {
        return this.threadSwitchOpt;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.h
    public final boolean Z6() {
        return this.prepareUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.h
    public final boolean o4() {
        return this.cancelWriteSp;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.h
    public final boolean p7() {
        return this.handleTaskAsync;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.h
    public final boolean r7() {
        return this.changeInitOrder;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.h
    public final boolean v3() {
        return this.asyncUpdateAssetsModel;
    }

    @Override // com.bytedance.android.livesdk.gift.configmodel.h
    public final boolean x3() {
        return this.resultLogOpt;
    }
}
