package com.stepos.taskrobot.taskmemory.entity;

import B7.a;
import androidx.compose.foundation.b;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Entity(tableName = "task_step")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;", "", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskStepEntity {

    /* renamed from: a, reason: collision with root package name */
    public long f4067a;
    public final String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public final String g;
    public String h;
    public String i;

    /* renamed from: j, reason: collision with root package name */
    public final String f4068j;
    public final int k;
    public long l;
    public Long m;
    public String n;
    public long o;
    public long p;

    /* renamed from: q, reason: collision with root package name */
    public String f4069q;

    public TaskStepEntity(long j5, String actionId, String taskId, String actionType, String str, String str2, String str3, String str4, String str5, String str6, int i, long j6, Long l, String str7, long j10, long j11, String str8) {
        k.f(actionId, "actionId");
        k.f(taskId, "taskId");
        k.f(actionType, "actionType");
        this.f4067a = j5;
        this.b = actionId;
        this.c = taskId;
        this.d = actionType;
        this.e = str;
        this.f = str2;
        this.g = str3;
        this.h = str4;
        this.i = str5;
        this.f4068j = str6;
        this.k = i;
        this.l = j6;
        this.m = l;
        this.n = str7;
        this.o = j10;
        this.p = j11;
        this.f4069q = str8;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskStepEntity)) {
            return false;
        }
        TaskStepEntity taskStepEntity = (TaskStepEntity) obj;
        return this.f4067a == taskStepEntity.f4067a && k.b(this.b, taskStepEntity.b) && k.b(this.c, taskStepEntity.c) && k.b(this.d, taskStepEntity.d) && k.b(this.e, taskStepEntity.e) && k.b(this.f, taskStepEntity.f) && k.b(this.g, taskStepEntity.g) && k.b(this.h, taskStepEntity.h) && k.b(this.i, taskStepEntity.i) && k.b(this.f4068j, taskStepEntity.f4068j) && this.k == taskStepEntity.k && this.l == taskStepEntity.l && k.b(this.m, taskStepEntity.m) && k.b(this.n, taskStepEntity.n) && this.o == taskStepEntity.o && this.p == taskStepEntity.p && k.b(this.f4069q, taskStepEntity.f4069q);
    }

    public final int hashCode() {
        int iC = a.c(a.c(a.c(Long.hashCode(this.f4067a) * 31, 31, this.b), 31, this.c), 31, this.d);
        String str = this.e;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.h;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.i;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f4068j;
        int iC2 = androidx.appfunctions.metadata.a.c(androidx.constraintlayout.core.dsl.a.a(this.k, (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31, 31), 31, this.l);
        Long l = this.m;
        int iHashCode6 = (iC2 + (l == null ? 0 : l.hashCode())) * 31;
        String str7 = this.n;
        int iC3 = androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((iHashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31, 31, this.o), 31, this.p);
        String str8 = this.f4069q;
        return iC3 + (str8 != null ? str8.hashCode() : 0);
    }

    public final String toString() {
        long j5 = this.f4067a;
        String str = this.c;
        String str2 = this.d;
        String str3 = this.e;
        String str4 = this.f;
        String str5 = this.h;
        String str6 = this.i;
        long j6 = this.l;
        Long l = this.m;
        String str7 = this.n;
        long j10 = this.o;
        long j11 = this.p;
        String str8 = this.f4069q;
        StringBuilder sb = new StringBuilder("TaskStepEntity(id=");
        sb.append(j5);
        sb.append(", actionId=");
        sb.append(this.b);
        androidx.constraintlayout.core.dsl.a.A(sb, ", taskId=", str, ", actionType=", str2);
        androidx.constraintlayout.core.dsl.a.A(sb, ", prompt=", str3, ", screenshotPath=", str4);
        androidx.constraintlayout.core.dsl.a.A(sb, ", actionContent=", this.g, ", appName=", str5);
        androidx.constraintlayout.core.dsl.a.A(sb, ", appVersion=", str6, ", currActivity=", this.f4068j);
        sb.append(", orientation=");
        sb.append(this.k);
        sb.append(", startTime=");
        sb.append(j6);
        sb.append(", endTime=");
        sb.append(l);
        b.C(sb, ", actionResult=", str7, ", screenshotUploadDuration=");
        sb.append(j10);
        b.y(j11, ", inferenceDuration=", ", durationData=", sb);
        return a.q(sb, str8, ")");
    }
}
