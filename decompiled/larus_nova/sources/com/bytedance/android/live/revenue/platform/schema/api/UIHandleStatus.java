package com.bytedance.android.live.revenue.platform.schema.api;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(UIHandleStatusSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus;", "Lvh7/j;", "Lzz0/j;", "HybridStatus", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "core.UIHandleStatus")
public interface UIHandleStatus extends j<zz0.j> {

    @JsonAdapter(UIHandleStatus_HybridStatusSerializableObjectImpl.Adapter.class)
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\n\u000bR\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus$HybridStatus;", "Lvh7/j;", "", "getType", "()I", "setType", "(I)V", "getType$annotations", "()V", "type", "b", "HybridStatusType", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    @RpcMessage(messageName = "core.UIHandleStatus.HybridStatus")
    public interface HybridStatus extends j<HybridStatus> {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus$HybridStatus$HybridStatusType;", "", "", "tag", "I", "getTag", "()I", "LOADING", "LOADED", "LOAD_FAILED", "RELEASED", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        public static final enum HybridStatusType extends Enum<HybridStatusType> {
            public static final HybridStatusType LOADED = null;
            public static final HybridStatusType LOADING = null;
            public static final HybridStatusType LOAD_FAILED = null;
            public static final HybridStatusType RELEASED = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ HybridStatusType[] f91650a = null;
            private final int tag;

            static {
                HybridStatusType r100 = new HybridStatusType("LOADING", 0, 0);
                LOADING = r100;
                HybridStatusType r101 = new HybridStatusType("LOADED", 1, 1);
                LOADED = r101;
                HybridStatusType r102 = new HybridStatusType("LOAD_FAILED", 2, 2);
                LOAD_FAILED = r102;
                HybridStatusType r103 = new HybridStatusType("RELEASED", 3, 3);
                RELEASED = r103;
                f91650a = new HybridStatusType[]{r100, r101, r102, r103};
            }

            public static HybridStatusType valueOf(String r100) {
                return (HybridStatusType) r27.a.a(HybridStatusType.class, r100);
            }

            public static HybridStatusType[] values() {
                return (HybridStatusType[]) f91650a.clone();
            }

            public final int getTag() {
                return this.tag;
            }

            public HybridStatusType(String r100, int r101, int r102) {
                super(r100, r101);
                this.tag = r102;
            }
        }

        @JsonAdapter(UIHandleStatus_HybridStatusSerializableObjectImpl.Adapter.class)
        @Metadata(k = 3, mv = {1, 5, 1})
        public static final class a {
        }

        @JsonAdapter(UIHandleStatus_HybridStatus_FailedInfoSerializableObjectImpl.Adapter.class)
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/revenue/platform/schema/api/UIHandleStatus$HybridStatus$b;", "Lvh7/j;", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
        @RpcMessage(messageName = "core.UIHandleStatus.HybridStatus.FailedInfo")
        public interface b extends j<b> {

            @JsonAdapter(UIHandleStatus_HybridStatus_FailedInfoSerializableObjectImpl.Adapter.class)
            @Metadata(k = 3, mv = {1, 5, 1})
            public static final class a {
            }

            @FieldName(name = "message#setter")
            void setMessage(String r100);
        }

        @FieldName(name = "failed_info#setter")
        void D8(b r100);

        @FieldName(name = "type")
        int getType();

        @FieldName(name = "type#setter")
        void setType(int r100);
    }

    @JsonAdapter(UIHandleStatusSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "hybrid_status#setter")
    void R2(HybridStatus r100);

    @FieldName(name = "hybrid_status")
    HybridStatus i7();
}
