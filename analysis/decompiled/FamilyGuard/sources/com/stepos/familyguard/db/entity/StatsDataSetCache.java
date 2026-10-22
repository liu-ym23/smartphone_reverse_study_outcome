package com.stepos.familyguard.db.entity;

/* loaded from: classes.dex */
public class StatsDataSetCache {
    private String data;
    private long id;
    private long relationId;

    public StatsDataSetCache(long j5, String str) {
        this.relationId = j5;
        this.data = str;
    }

    public String getData() {
        return this.data;
    }

    public long getId() {
        return this.id;
    }

    public long getRelationId() {
        return this.relationId;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setId(long j5) {
        this.id = j5;
    }

    public void setRelationId(long j5) {
        this.relationId = j5;
    }
}
