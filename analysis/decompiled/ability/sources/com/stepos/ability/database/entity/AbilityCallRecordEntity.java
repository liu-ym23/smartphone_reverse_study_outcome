package com.stepos.ability.database.entity;

import androidx.room.Entity;
import kotlin.Metadata;

@Entity(tableName = "t_ability_call_record")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/database/entity/AbilityCallRecordEntity;", "", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityCallRecordEntity {
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityCallRecordEntity)) {
            return false;
        }
        ((AbilityCallRecordEntity) obj).getClass();
        return true;
    }

    public final int hashCode() {
        Long.hashCode(0L);
        throw null;
    }

    public final String toString() {
        return "AbilityCallRecordEntity(id=0, taskCode=null, abilityId=0, paramsJson=null, fromPkg=null, fromSign=null, toPkg=null, toSign=null, callTime=0, resultTime=0, result=null, error=null)";
    }
}
