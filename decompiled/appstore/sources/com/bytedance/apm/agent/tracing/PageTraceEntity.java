package com.bytedance.apm.agent.tracing;

/* JADX INFO: loaded from: classes.dex */
public class PageTraceEntity {
    public long onCreateEndTs;
    public long onCreateStartTs;
    public long onResumeEndTs;
    public long onResumeStartTs;
    public long onViewShowTs;
    public long onWindowFocusTs;
    public String pageName;

    public PageTraceEntity(String r10, long r11) {
        this.pageName = r10;
        this.onCreateStartTs = r11;
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

    public void setOnCreateEndTs(long r10) {
        this.onCreateEndTs = r10;
    }

    public void setOnCreateStartTs(long r10) {
        this.onCreateStartTs = r10;
    }

    public void setOnResumeEndTs(long r10) {
        this.onResumeEndTs = r10;
    }

    public void setOnResumeStartTs(long r10) {
        this.onResumeStartTs = r10;
    }

    public void setOnWindowFocusTs(long r10) {
        this.onWindowFocusTs = r10;
    }

    public void setPageName(String r10) {
        this.pageName = r10;
    }
}
