package com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.framework;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/live/core/framework/InteractionMonitorConfig;", "", "()V", "enableReportProcessCost", "", "getEnableReportProcessCost", "()Z", "setEnableReportProcessCost", "(Z)V", "enableReportWidgetCost", "getEnableReportWidgetCost", "setEnableReportWidgetCost", "reportElementSize", "", "getReportElementSize", "()I", "setReportElementSize", "(I)V", "reportElementTypeList", "", "", "getReportElementTypeList", "()Ljava/util/List;", "setReportElementTypeList", "(Ljava/util/List;)V", "reportMinCostTime", "getReportMinCostTime", "setReportMinCostTime", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractionMonitorConfig {

    @SerializedName("enable_report_process_cost")
    private boolean enableReportProcessCost;

    @SerializedName("enable_report_widget_cost")
    private boolean enableReportWidgetCost;

    @SerializedName("report_element_size")
    private int reportElementSize;

    @SerializedName("report_element_type_list")
    private List<String> reportElementTypeList;

    @SerializedName("report_min_cost_time")
    private int reportMinCostTime;

    public InteractionMonitorConfig() {
        this.enableReportProcessCost = true;
        this.enableReportWidgetCost = true;
        this.reportElementSize = 5;
        this.reportMinCostTime = 10;
    }

    public final boolean getEnableReportProcessCost() {
        return this.enableReportProcessCost;
    }

    public final boolean getEnableReportWidgetCost() {
        return this.enableReportWidgetCost;
    }

    public final int getReportElementSize() {
        return this.reportElementSize;
    }

    public final List<String> getReportElementTypeList() {
        return this.reportElementTypeList;
    }

    public final int getReportMinCostTime() {
        return this.reportMinCostTime;
    }

    public final void setEnableReportProcessCost(boolean r100) {
        this.enableReportProcessCost = r100;
    }

    public final void setEnableReportWidgetCost(boolean r100) {
        this.enableReportWidgetCost = r100;
    }

    public final void setReportElementSize(int r100) {
        this.reportElementSize = r100;
    }

    public final void setReportElementTypeList(List<String> r100) {
        this.reportElementTypeList = r100;
    }

    public final void setReportMinCostTime(int r100) {
        this.reportMinCostTime = r100;
    }
}
