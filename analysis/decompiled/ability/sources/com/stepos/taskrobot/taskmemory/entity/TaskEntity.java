package com.stepos.taskrobot.taskmemory.entity;

import B7.a;
import androidx.compose.foundation.b;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Entity(tableName = "task")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskEntity {

    /* renamed from: a, reason: collision with root package name */
    public final long f4065a;
    public String b;
    public final long c;
    public String d;
    public final String e;
    public final String f;
    public final String g;
    public final long h;
    public final Long i;

    /* renamed from: j, reason: collision with root package name */
    public final Long f4066j;
    public final String k;

    public TaskEntity(long j5, String taskId, long j6, String taskName, String taskDesc, String str, String str2, long j10, Long l, Long l5, String str3) {
        k.f(taskId, "taskId");
        k.f(taskName, "taskName");
        k.f(taskDesc, "taskDesc");
        this.f4065a = j5;
        this.b = taskId;
        this.c = j6;
        this.d = taskName;
        this.e = taskDesc;
        this.f = str;
        this.g = str2;
        this.h = j10;
        this.i = l;
        this.f4066j = l5;
        this.k = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskEntity)) {
            return false;
        }
        TaskEntity taskEntity = (TaskEntity) obj;
        return this.f4065a == taskEntity.f4065a && k.b(this.b, taskEntity.b) && this.c == taskEntity.c && k.b(this.d, taskEntity.d) && k.b(this.e, taskEntity.e) && k.b(this.f, taskEntity.f) && k.b(this.g, taskEntity.g) && this.h == taskEntity.h && k.b(this.i, taskEntity.i) && k.b(this.f4066j, taskEntity.f4066j) && k.b(this.k, taskEntity.k);
    }

    public final int hashCode() {
        int iC = a.c(a.c(androidx.appfunctions.metadata.a.c(a.c(Long.hashCode(this.f4065a) * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e);
        String str = this.f;
        int iHashCode = (iC + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.g;
        int iC2 = androidx.appfunctions.metadata.a.c((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31, 31, this.h);
        Long l = this.i;
        int iHashCode2 = (iC2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l5 = this.f4066j;
        int iHashCode3 = (iHashCode2 + (l5 == null ? 0 : l5.hashCode())) * 31;
        String str3 = this.k;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        String str = this.b;
        String str2 = this.d;
        StringBuilder sb = new StringBuilder("TaskEntity(id=");
        sb.append(this.f4065a);
        sb.append(", taskId=");
        sb.append(str);
        b.y(this.c, ", deviceInfoId=", ", taskName=", sb);
        androidx.constraintlayout.core.dsl.a.A(sb, str2, ", taskDesc=", this.e, ", guiTree=");
        androidx.constraintlayout.core.dsl.a.A(sb, this.f, ", result=", this.g, ", createTime=");
        sb.append(this.h);
        sb.append(", endTime=");
        sb.append(this.i);
        sb.append(", durationTime=");
        sb.append(this.f4066j);
        sb.append(", coverImage=");
        sb.append(this.k);
        sb.append(")");
        return sb.toString();
    }
}
