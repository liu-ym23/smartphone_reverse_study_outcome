package com.stepos.taskrobot.taskmemory.entity;

import androidx.appfunctions.metadata.a;
import androidx.room.Entity;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Entity(tableName = "task_device_info")
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class TaskDeviceInfoEntity {

    /* renamed from: a, reason: collision with root package name */
    public final long f4063a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final float i;

    /* renamed from: j, reason: collision with root package name */
    public final long f4064j;

    public TaskDeviceInfoEntity(long j5, String brand, String userId, String deviceId, String model, String product, String osVersion, String resolution, float f, long j6) {
        k.f(brand, "brand");
        k.f(userId, "userId");
        k.f(deviceId, "deviceId");
        k.f(model, "model");
        k.f(product, "product");
        k.f(osVersion, "osVersion");
        k.f(resolution, "resolution");
        this.f4063a = j5;
        this.b = brand;
        this.c = userId;
        this.d = deviceId;
        this.e = model;
        this.f = product;
        this.g = osVersion;
        this.h = resolution;
        this.i = f;
        this.f4064j = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TaskDeviceInfoEntity)) {
            return false;
        }
        TaskDeviceInfoEntity taskDeviceInfoEntity = (TaskDeviceInfoEntity) obj;
        return this.f4063a == taskDeviceInfoEntity.f4063a && k.b(this.b, taskDeviceInfoEntity.b) && k.b(this.c, taskDeviceInfoEntity.c) && k.b(this.d, taskDeviceInfoEntity.d) && k.b(this.e, taskDeviceInfoEntity.e) && k.b(this.f, taskDeviceInfoEntity.f) && k.b(this.g, taskDeviceInfoEntity.g) && k.b(this.h, taskDeviceInfoEntity.h) && Float.compare(this.i, taskDeviceInfoEntity.i) == 0 && this.f4064j == taskDeviceInfoEntity.f4064j;
    }

    public final int hashCode() {
        return Long.hashCode(this.f4064j) + a.b(this.i, B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(B7.a.c(Long.hashCode(this.f4063a) * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e), 31, this.f), 31, this.g), 31, this.h), 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TaskDeviceInfoEntity(id=");
        sb.append(this.f4063a);
        sb.append(", brand=");
        sb.append(this.b);
        androidx.constraintlayout.core.dsl.a.A(sb, ", userId=", this.c, ", deviceId=", this.d);
        androidx.constraintlayout.core.dsl.a.A(sb, ", model=", this.e, ", product=", this.f);
        androidx.constraintlayout.core.dsl.a.A(sb, ", osVersion=", this.g, ", resolution=", this.h);
        sb.append(", density=");
        sb.append(this.i);
        sb.append(", createTime=");
        return androidx.constraintlayout.core.dsl.a.e(this.f4064j, ")", sb);
    }
}
