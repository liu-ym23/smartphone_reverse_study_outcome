package com.byted.cast.common.bean;

/* JADX INFO: loaded from: classes39.dex */
public class DlnaCycleSearchSettings {
    private int cycleSearchCount;
    private int cycleSearchInterval;
    private boolean enableCycleSearch;

    public DlnaCycleSearchSettings() {
    }

    public String toString() {
        return "DlnaCycleSearchSettings{enableCycleSearch=" + this.enableCycleSearch + ", cycleSearchInterval=" + this.cycleSearchInterval + ", cycleSearchCount=" + this.cycleSearchCount + '}';
    }

    public int getCycleSearchCount() {
        return this.cycleSearchCount;
    }

    public int getCycleSearchInterval() {
        return this.cycleSearchInterval;
    }

    public boolean isEnableCycleSearch() {
        return this.enableCycleSearch;
    }

    public void setCycleSearchCount(int r100) {
        this.cycleSearchCount = r100;
    }

    public void setCycleSearchInterval(int r100) {
        this.cycleSearchInterval = r100;
    }

    public void setEnableCycleSearch(boolean r100) {
        this.enableCycleSearch = r100;
    }
}
