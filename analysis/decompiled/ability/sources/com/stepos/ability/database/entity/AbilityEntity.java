package com.stepos.ability.database.entity;

import androidx.appfunctions.metadata.a;
import androidx.compose.foundation.b;
import androidx.room.Entity;
import androidx.room.Index;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Entity(indices = {@Index(unique = true, value = {"packageName"})}, tableName = "t_ability")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/database/entity/AbilityEntity;", "", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityEntity {

    /* renamed from: a, reason: collision with root package name */
    public final long f3080a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final long f;
    public final String g;
    public final long h;
    public final String i;

    public AbilityEntity(long j5, String packageName, String version, String status, String icon, long j6, String syncStatus, long j10, String tools) {
        k.f(packageName, "packageName");
        k.f(version, "version");
        k.f(status, "status");
        k.f(icon, "icon");
        k.f(syncStatus, "syncStatus");
        k.f(tools, "tools");
        this.f3080a = j5;
        this.b = packageName;
        this.c = version;
        this.d = status;
        this.e = icon;
        this.f = j6;
        this.g = syncStatus;
        this.h = j10;
        this.i = tools;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityEntity)) {
            return false;
        }
        AbilityEntity abilityEntity = (AbilityEntity) obj;
        return this.f3080a == abilityEntity.f3080a && k.b(this.b, abilityEntity.b) && k.b(this.c, abilityEntity.c) && k.b(this.d, abilityEntity.d) && k.b(this.e, abilityEntity.e) && this.f == abilityEntity.f && k.b(this.g, abilityEntity.g) && this.h == abilityEntity.h && k.b(this.i, abilityEntity.i);
    }

    public final int hashCode() {
        return this.i.hashCode() + a.c(B7.a.c(a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(Long.hashCode(this.f3080a) * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e), 31, this.f), 31, this.g), 31, this.h);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("AbilityEntity(id=");
        sb.append(this.f3080a);
        sb.append(", packageName=");
        sb.append(this.b);
        androidx.constraintlayout.core.dsl.a.A(sb, ", version=", this.c, ", status=", this.d);
        b.C(sb, ", icon=", this.e, ", updateTime=");
        sb.append(this.f);
        sb.append(", syncStatus=");
        sb.append(this.g);
        b.y(this.h, ", syncTime=", ", tools=", sb);
        return B7.a.q(sb, this.i, ")");
    }
}
