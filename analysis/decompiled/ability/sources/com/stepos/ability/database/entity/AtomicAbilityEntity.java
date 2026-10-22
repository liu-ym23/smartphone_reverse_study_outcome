package com.stepos.ability.database.entity;

import B7.a;
import androidx.compose.foundation.b;
import androidx.room.Entity;
import androidx.room.Index;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Entity(indices = {@Index({"toolName"})}, primaryKeys = {"packageName", "functionName"}, tableName = "t_atomic_ability")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/ability/database/entity/AtomicAbilityEntity;", "", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AtomicAbilityEntity {

    /* renamed from: a, reason: collision with root package name */
    public final String f3084a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final String f;
    public final String g;
    public final String h;
    public final Integer i;

    /* renamed from: j, reason: collision with root package name */
    public final String f3085j;
    public final String k;
    public final String l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;

    /* renamed from: q, reason: collision with root package name */
    public final String f3086q;

    /* renamed from: r, reason: collision with root package name */
    public final String f3087r;

    /* renamed from: s, reason: collision with root package name */
    public final String f3088s;

    /* renamed from: t, reason: collision with root package name */
    public final String f3089t;
    public final String u;

    /* renamed from: v, reason: collision with root package name */
    public final String f3090v;

    /* renamed from: w, reason: collision with root package name */
    public final long f3091w;

    /* renamed from: x, reason: collision with root package name */
    public final String f3092x;

    public AtomicAbilityEntity(String packageName, String toolName, String functionName, int i, int i6, String description, String callType, String callingMethod, Integer num, String deviceType, String str, String str2, String str3, String str4, String str5, String str6, String str7, String appName, String str8, String str9, String str10, String str11, long j5, String str12) {
        k.f(packageName, "packageName");
        k.f(toolName, "toolName");
        k.f(functionName, "functionName");
        k.f(description, "description");
        k.f(callType, "callType");
        k.f(callingMethod, "callingMethod");
        k.f(deviceType, "deviceType");
        k.f(appName, "appName");
        this.f3084a = packageName;
        this.b = toolName;
        this.c = functionName;
        this.d = i;
        this.e = i6;
        this.f = description;
        this.g = callType;
        this.h = callingMethod;
        this.i = num;
        this.f3085j = deviceType;
        this.k = str;
        this.l = str2;
        this.m = str3;
        this.n = str4;
        this.o = str5;
        this.p = str6;
        this.f3086q = str7;
        this.f3087r = appName;
        this.f3088s = str8;
        this.f3089t = str9;
        this.u = str10;
        this.f3090v = str11;
        this.f3091w = j5;
        this.f3092x = str12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AtomicAbilityEntity)) {
            return false;
        }
        AtomicAbilityEntity atomicAbilityEntity = (AtomicAbilityEntity) obj;
        return k.b(this.f3084a, atomicAbilityEntity.f3084a) && k.b(this.b, atomicAbilityEntity.b) && k.b(this.c, atomicAbilityEntity.c) && this.d == atomicAbilityEntity.d && this.e == atomicAbilityEntity.e && k.b(this.f, atomicAbilityEntity.f) && k.b(this.g, atomicAbilityEntity.g) && k.b(this.h, atomicAbilityEntity.h) && k.b(this.i, atomicAbilityEntity.i) && k.b(this.f3085j, atomicAbilityEntity.f3085j) && k.b(this.k, atomicAbilityEntity.k) && k.b(this.l, atomicAbilityEntity.l) && k.b(this.m, atomicAbilityEntity.m) && k.b(this.n, atomicAbilityEntity.n) && k.b(this.o, atomicAbilityEntity.o) && k.b(this.p, atomicAbilityEntity.p) && k.b(this.f3086q, atomicAbilityEntity.f3086q) && k.b(this.f3087r, atomicAbilityEntity.f3087r) && k.b(this.f3088s, atomicAbilityEntity.f3088s) && k.b(this.f3089t, atomicAbilityEntity.f3089t) && k.b(this.u, atomicAbilityEntity.u) && k.b(this.f3090v, atomicAbilityEntity.f3090v) && this.f3091w == atomicAbilityEntity.f3091w && k.b(this.f3092x, atomicAbilityEntity.f3092x);
    }

    public final int hashCode() {
        int iC = a.c(a.c(a.c(androidx.constraintlayout.core.dsl.a.a(this.e, androidx.constraintlayout.core.dsl.a.a(this.d, a.c(a.c(this.f3084a.hashCode() * 31, 31, this.b), 31, this.c), 31), 31), 31, this.f), 31, this.g), 31, this.h);
        Integer num = this.i;
        int iC2 = a.c((iC + (num == null ? 0 : num.hashCode())) * 31, 31, this.f3085j);
        String str = this.k;
        int iHashCode = (iC2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.l;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.m;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.n;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.o;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.p;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f3086q;
        int iC3 = a.c((iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31, 31, this.f3087r);
        String str8 = this.f3088s;
        int iHashCode7 = (iC3 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.f3089t;
        int iHashCode8 = (iHashCode7 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.u;
        int iHashCode9 = (iHashCode8 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.f3090v;
        int iC4 = androidx.appfunctions.metadata.a.c((iHashCode9 + (str11 == null ? 0 : str11.hashCode())) * 31, 31, this.f3091w);
        String str12 = this.f3092x;
        return iC4 + (str12 != null ? str12.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbW = a.w("AtomicAbilityEntity(packageName=", this.f3084a, ", toolName=", this.b, ", functionName=");
        b.B(sbW, this.c, ", abilityId=", this.d, ", appId=");
        sbW.append(this.e);
        sbW.append(", description=");
        sbW.append(this.f);
        sbW.append(", callType=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.g, ", callingMethod=", this.h, ", timeout=");
        sbW.append(this.i);
        sbW.append(", deviceType=");
        sbW.append(this.f3085j);
        sbW.append(", type=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.k, ", capabilityType=", this.l, ", permission=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.m, ", inputSchemaJson=", this.n, ", outputSchemaJson=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.o, ", extraJson=", this.p, ", toolVersion=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.f3086q, ", appName=", this.f3087r, ", appVersion=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.f3088s, ", appSource=", this.f3089t, ", authType=");
        androidx.constraintlayout.core.dsl.a.A(sbW, this.u, ", signature=", this.f3090v, ", updateTime=");
        sbW.append(this.f3091w);
        sbW.append(", slaScene=");
        sbW.append(this.f3092x);
        sbW.append(")");
        return sbW.toString();
    }
}
