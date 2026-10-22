package com.stepos.ability.database.entity;

import androidx.constraintlayout.core.dsl.a;
import androidx.room.Entity;
import androidx.room.Index;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Entity(indices = {@Index(unique = true, value = {"taskCode"})}, tableName = "t_ability_report_task")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/database/entity/AbilityReportTaskEntity;", "", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityReportTaskEntity {

    /* renamed from: a, reason: collision with root package name */
    public final long f3081a;
    public final long b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final int g;
    public final int h;

    public AbilityReportTaskEntity(long j5, long j6, String taskCode, String packageName, String installType, String payload, int i, int i6) {
        k.f(taskCode, "taskCode");
        k.f(packageName, "packageName");
        k.f(installType, "installType");
        k.f(payload, "payload");
        this.f3081a = j5;
        this.b = j6;
        this.c = taskCode;
        this.d = packageName;
        this.e = installType;
        this.f = payload;
        this.g = i;
        this.h = i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityReportTaskEntity)) {
            return false;
        }
        AbilityReportTaskEntity abilityReportTaskEntity = (AbilityReportTaskEntity) obj;
        return this.f3081a == abilityReportTaskEntity.f3081a && this.b == abilityReportTaskEntity.b && k.b(this.c, abilityReportTaskEntity.c) && k.b(this.d, abilityReportTaskEntity.d) && k.b(this.e, abilityReportTaskEntity.e) && k.b(this.f, abilityReportTaskEntity.f) && this.g == abilityReportTaskEntity.g && this.h == abilityReportTaskEntity.h;
    }

    public final int hashCode() {
        return Integer.hashCode(this.h) + a.a(this.g, B7.a.c(B7.a.c(B7.a.c(B7.a.c(androidx.appfunctions.metadata.a.c(Long.hashCode(this.f3081a) * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e), 31, this.f), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AbilityReportTaskEntity(id=");
        sb.append(this.f3081a);
        sb.append(", timestamp=");
        sb.append(this.b);
        sb.append(", taskCode=");
        sb.append(this.c);
        a.A(sb, ", packageName=", this.d, ", installType=", this.e);
        sb.append(", payload=");
        sb.append(this.f);
        sb.append(", status=");
        sb.append(this.g);
        sb.append(", retryCount=");
        sb.append(this.h);
        sb.append(")");
        return sb.toString();
    }
}
