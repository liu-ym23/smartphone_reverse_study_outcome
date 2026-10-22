package com.stepos.ability.database.entity;

import B7.a;
import androidx.compose.foundation.b;
import androidx.room.Entity;
import androidx.room.Index;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Entity(indices = {@Index(unique = true, value = {"taskCode"})}, tableName = "t_ability_task")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/database/entity/AbilityTaskEntity;", "", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityTaskEntity {

    /* renamed from: a, reason: collision with root package name */
    public final long f3082a;
    public final String b;
    public final Long c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final int i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3083j;
    public final long k;
    public final boolean l;
    public final String m;
    public final String n;
    public final int o;

    public AbilityTaskEntity(long j5, String taskCode, Long l, String pkgName, String method, String str, String str2, String status, int i, int i6, long j6, boolean z10, String traceId, String tooCallId, int i10) {
        k.f(taskCode, "taskCode");
        k.f(pkgName, "pkgName");
        k.f(method, "method");
        k.f(status, "status");
        k.f(traceId, "traceId");
        k.f(tooCallId, "tooCallId");
        this.f3082a = j5;
        this.b = taskCode;
        this.c = l;
        this.d = pkgName;
        this.e = method;
        this.f = str;
        this.g = str2;
        this.h = status;
        this.i = i;
        this.f3083j = i6;
        this.k = j6;
        this.l = z10;
        this.m = traceId;
        this.n = tooCallId;
        this.o = i10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityTaskEntity)) {
            return false;
        }
        AbilityTaskEntity abilityTaskEntity = (AbilityTaskEntity) obj;
        return this.f3082a == abilityTaskEntity.f3082a && k.b(this.b, abilityTaskEntity.b) && k.b(this.c, abilityTaskEntity.c) && k.b(this.d, abilityTaskEntity.d) && k.b(this.e, abilityTaskEntity.e) && k.b(this.f, abilityTaskEntity.f) && k.b(this.g, abilityTaskEntity.g) && k.b(this.h, abilityTaskEntity.h) && this.i == abilityTaskEntity.i && this.f3083j == abilityTaskEntity.f3083j && this.k == abilityTaskEntity.k && this.l == abilityTaskEntity.l && k.b(this.m, abilityTaskEntity.m) && k.b(this.n, abilityTaskEntity.n) && this.o == abilityTaskEntity.o;
    }

    public final int hashCode() {
        int iC = a.c(Long.hashCode(this.f3082a) * 31, 31, this.b);
        Long l = this.c;
        int iC2 = a.c(a.c((iC + (l == null ? 0 : l.hashCode())) * 31, 31, this.d), 31, this.e);
        String str = this.f;
        int iHashCode = (iC2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        return Integer.hashCode(this.o) + a.c(a.c(androidx.appfunctions.metadata.a.d(androidx.appfunctions.metadata.a.c(androidx.constraintlayout.core.dsl.a.a(this.f3083j, androidx.constraintlayout.core.dsl.a.a(this.i, a.c((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31, 31, this.h), 31), 31), 31, this.k), 31, this.l), 31, this.m), 31, this.n);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AbilityTaskEntity(id=");
        sb.append(this.f3082a);
        sb.append(", taskCode=");
        sb.append(this.b);
        sb.append(", abilityId=");
        sb.append(this.c);
        sb.append(", pkgName=");
        sb.append(this.d);
        androidx.constraintlayout.core.dsl.a.A(sb, ", method=", this.e, ", paramsJson=", this.f);
        androidx.constraintlayout.core.dsl.a.A(sb, ", extra=", this.g, ", status=", this.h);
        sb.append(", retryCount=");
        sb.append(this.i);
        sb.append(", priority=");
        sb.append(this.f3083j);
        b.y(this.k, ", createTime=", ", isCloudAbility=", sb);
        sb.append(this.l);
        sb.append(", traceId=");
        sb.append(this.m);
        sb.append(", tooCallId=");
        sb.append(this.n);
        sb.append(", timeout=");
        sb.append(this.o);
        sb.append(")");
        return sb.toString();
    }
}
