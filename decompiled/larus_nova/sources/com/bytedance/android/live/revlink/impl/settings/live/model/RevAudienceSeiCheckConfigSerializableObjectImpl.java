package com.bytedance.android.live.revlink.impl.settings.live.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w41.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u000b\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0016\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0019\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevAudienceSeiCheckConfigSerializableObjectImpl;", "Lw41/a;", "", "waitThreshold", "J", "a1", "()J", "unloadReportThreshold", "getUnloadReportThreshold", "", "reportControl", "Z", "H3", "()Z", "pkWaitThreshold", "getPkWaitThreshold", "pkUnloadReportThreshold", "getPkUnloadReportThreshold", "pkReportControl", "getPkReportControl", "illegalReportControl", "q8", "pkIllegalReportControl", "Z8", "", "maxStack", "I", "O4", "()I", "<init>", "()V", "Adapter", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevAudienceSeiCheckConfigSerializableObjectImpl implements a {

    @SerializedName("illegal_report_control")
    private final boolean illegalReportControl;

    @SerializedName("max_stack")
    private final int maxStack;

    @SerializedName("pk_illegal_report_control")
    private final boolean pkIllegalReportControl;

    @SerializedName("pk_report_control")
    private final boolean pkReportControl;

    @SerializedName("pk_unload_report_threshold")
    private final long pkUnloadReportThreshold;

    @SerializedName("pk_wait_sei_threshold")
    private final long pkWaitThreshold;

    @SerializedName("report_control")
    private final boolean reportControl;

    @SerializedName("unload_report_threshold")
    private final long unloadReportThreshold;

    @SerializedName("wait_sei_threshold")
    private final long waitThreshold;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/settings/live/model/RevAudienceSeiCheckConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(RevAudienceSeiCheckConfigSerializableObjectImpl.class);
        }
    }

    public RevAudienceSeiCheckConfigSerializableObjectImpl() {
        this.waitThreshold = 15000;
        this.unloadReportThreshold = 10000;
        this.reportControl = true;
        this.pkWaitThreshold = 15000;
        this.pkUnloadReportThreshold = 10000;
        this.pkReportControl = true;
        this.illegalReportControl = true;
        this.pkIllegalReportControl = true;
        this.maxStack = 3;
    }

    @Override // w41.a
    public final boolean H3() {
        return this.reportControl;
    }

    @Override // w41.a
    public final int O4() {
        return this.maxStack;
    }

    @Override // w41.a
    public final boolean Z8() {
        return this.pkIllegalReportControl;
    }

    @Override // w41.a
    public final long a1() {
        return this.waitThreshold;
    }

    @Override // w41.a
    public final boolean q8() {
        return this.illegalReportControl;
    }
}
