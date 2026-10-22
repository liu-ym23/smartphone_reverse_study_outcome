package com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/ComponentBatchPriorityConfig;", "", "()V", "cells", "", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/ComponentBatchPriorityCellConfig;", "getCells", "()Ljava/util/List;", "setCells", "(Ljava/util/List;)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "priorityMapping", "Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/ComponentBatchPriorityMappingConfig;", "getPriorityMapping", "()Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/ComponentBatchPriorityMappingConfig;", "setPriorityMapping", "(Lcom/bytedance/android/livesdkapi/model/com/bytedance/android/livesdk/config/ComponentBatchPriorityMappingConfig;)V", "strategyList", "", "getStrategyList", "setStrategyList", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ComponentBatchPriorityConfig {

    @SerializedName("cells")
    private List<ComponentBatchPriorityCellConfig> cells;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("priority_mapping")
    private ComponentBatchPriorityMappingConfig priorityMapping;

    @SerializedName("strategy_list")
    private List<Integer> strategyList;

    public ComponentBatchPriorityConfig() {
        ComponentBatchPriorityMappingConfig r100 = new ComponentBatchPriorityMappingConfig();
        r100.setP0_start(0);
        r100.setP0_end(2);
        r100.setP1_start(3);
        r100.setP1_end(3);
        r100.setP2_start(4);
        r100.setP2_end(4);
        r100.setP3_start(5);
        r100.setP3_end(8);
        Unit r101 = Unit.INSTANCE;
        this.priorityMapping = r100;
        ArrayList r102 = new ArrayList();
        r102.add(81);
        r102.add(85);
        r102.add(75);
        this.strategyList = r102;
        ArrayList r103 = new ArrayList();
        ComponentBatchPriorityCellConfig r104 = new ComponentBatchPriorityCellConfig();
        r104.setStart(0.1d);
        r104.setEnd(0.11d);
        r104.setBatch(0);
        r104.setDelay(200);
        r103.add(r104);
        ComponentBatchPriorityCellConfig r105 = new ComponentBatchPriorityCellConfig();
        r105.setStart(0.11d);
        r105.setEnd(0.2d);
        r105.setBatch(1);
        r105.setDelay(200);
        r103.add(r105);
        ComponentBatchPriorityCellConfig r106 = new ComponentBatchPriorityCellConfig();
        r106.setStart(0.2d);
        r106.setEnd(1.0d);
        r106.setBatch(2);
        r106.setDelay(200);
        r103.add(r106);
        ComponentBatchPriorityCellConfig r107 = new ComponentBatchPriorityCellConfig();
        r107.setStart(1.0d);
        r107.setEnd(1.1d);
        r107.setBatch(3);
        r107.setDelay(1000);
        r103.add(r107);
        ComponentBatchPriorityCellConfig r108 = new ComponentBatchPriorityCellConfig();
        r108.setStart(2.0d);
        r108.setEnd(3.0d);
        r108.setBatch(4);
        r108.setDelay(1000);
        r103.add(r108);
        ComponentBatchPriorityCellConfig r109 = new ComponentBatchPriorityCellConfig();
        r109.setStart(3.0d);
        r109.setEnd(3.4d);
        r109.setBatch(5);
        r109.setDelay(300);
        r103.add(r109);
        ComponentBatchPriorityCellConfig r110 = new ComponentBatchPriorityCellConfig();
        r110.setStart(3.4d);
        r110.setEnd(3.5d);
        r110.setBatch(6);
        r110.setDelay(200);
        r103.add(r110);
        ComponentBatchPriorityCellConfig r111 = new ComponentBatchPriorityCellConfig();
        r111.setStart(3.5d);
        r111.setEnd(3.7d);
        r111.setBatch(7);
        r111.setDelay(200);
        r103.add(r111);
        ComponentBatchPriorityCellConfig r112 = new ComponentBatchPriorityCellConfig();
        r112.setStart(3.7d);
        r112.setEnd(4.0d);
        r112.setBatch(8);
        r112.setDelay(200);
        r103.add(r112);
        this.cells = r103;
    }

    public final List<ComponentBatchPriorityCellConfig> getCells() {
        return this.cells;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final ComponentBatchPriorityMappingConfig getPriorityMapping() {
        return this.priorityMapping;
    }

    public final List<Integer> getStrategyList() {
        return this.strategyList;
    }

    public final void setCells(List<ComponentBatchPriorityCellConfig> r100) {
        this.cells = r100;
    }

    public final void setEnable(boolean r100) {
        this.enable = r100;
    }

    public final void setPriorityMapping(ComponentBatchPriorityMappingConfig r100) {
        this.priorityMapping = r100;
    }

    public final void setStrategyList(List<Integer> r100) {
        this.strategyList = r100;
    }
}
