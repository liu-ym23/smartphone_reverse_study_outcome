package com.bytedance.apm.agent.tracing;

/* JADX INFO: loaded from: classes14.dex */
public class PageTraceEntity {
    public long onCreateEndTs;
    public long onCreateStartTs;
    public long onResumeEndTs;
    public long onResumeStartTs;
    public long onViewShowTs;
    public long onWindowFocusTs;
    public String pageName;

    public boolean isCreateAndResumeValid() {
        if (this.onCreateStartTs > 0) goto L5;
    L11:
        return false;
    L5:
        if (this.onCreateEndTs <= 0) goto L11;
        if (this.onResumeStartTs <= 0) goto L11;
        if (this.onResumeEndTs <= 0) goto L11;
        return true;
    }

    public long getOnCreateEndTs() {
        return this.onCreateEndTs;
    }

    public long getOnCreateStartTs() {
        return this.onCreateStartTs;
    }

    public long getOnResumeEndTs() {
        return this.onResumeEndTs;
    }

    public long getOnResumeStartTs() {
        return this.onResumeStartTs;
    }

    public long getOnWindowFocusTs() {
        return this.onWindowFocusTs;
    }

    public String getPageName() {
        return this.pageName;
    }

    public void setOnCreateEndTs(long r100) {
        this.onCreateEndTs = r100;
    }

    public void setOnCreateStartTs(long r100) {
        this.onCreateStartTs = r100;
    }

    public void setOnResumeEndTs(long r100) {
        this.onResumeEndTs = r100;
    }

    public void setOnResumeStartTs(long r100) {
        this.onResumeStartTs = r100;
    }

    public void setOnWindowFocusTs(long r100) {
        this.onWindowFocusTs = r100;
    }

    public void setPageName(String r100) {
        this.pageName = r100;
    }

    public PageTraceEntity(String r100, long r101) {
        this.pageName = r100;
        this.onCreateStartTs = r101;
    }
}
