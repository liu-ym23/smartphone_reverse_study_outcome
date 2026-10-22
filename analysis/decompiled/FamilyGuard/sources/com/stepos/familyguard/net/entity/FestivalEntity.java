package com.stepos.familyguard.net.entity;

import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class FestivalEntity {
    public List<FestivalEventEntity> activities;
    public long end;
    public Long id;
    public long start;
    public long updateTime;
    public String webUrl;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.id, ((FestivalEntity) obj).id);
    }

    public int hashCode() {
        return Objects.hash(this.id);
    }
}
