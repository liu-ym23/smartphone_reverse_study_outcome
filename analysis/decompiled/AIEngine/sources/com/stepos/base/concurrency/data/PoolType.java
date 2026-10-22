package com.stepos.base.concurrency.data;

import com.stepos.base.task.data.TaskPriority;
import dc.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.g;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PoolType {

    /* renamed from: b, reason: collision with root package name */
    public static final a f6214b;

    /* renamed from: c, reason: collision with root package name */
    public static final PoolType f6215c;

    /* renamed from: d, reason: collision with root package name */
    public static final PoolType f6216d;

    /* renamed from: e, reason: collision with root package name */
    public static final PoolType f6217e;
    public static final PoolType h;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ PoolType[] f6218j;

    /* renamed from: a, reason: collision with root package name */
    public final int f6219a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
        public static PoolType a(TaskPriority priority) {
            g.f(priority, "priority");
            int iOrdinal = priority.ordinal();
            if (iOrdinal == 0) {
                return PoolType.f6215c;
            }
            if (iOrdinal == 1) {
                return PoolType.f6216d;
            }
            if (iOrdinal == 2) {
                return PoolType.f6217e;
            }
            if (iOrdinal == 3) {
                return PoolType.h;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        new e(7, 7, 1);
        PoolType poolType = new PoolType("REALTIME", 0, 2);
        f6215c = poolType;
        new e(4, 6, 1);
        PoolType poolType2 = new PoolType("IMPORTANT", 1, 4);
        f6216d = poolType2;
        new e(3, 6, 1);
        PoolType poolType3 = new PoolType("NORMAL", 2, 4);
        f6217e = poolType3;
        new e(0, 2, 1);
        PoolType poolType4 = new PoolType("BACKGROUND", 3, 2);
        h = poolType4;
        PoolType[] poolTypeArr = {poolType, poolType2, poolType3, poolType4};
        f6218j = poolTypeArr;
        kotlin.enums.a.a(poolTypeArr);
        f6214b = new a();
    }

    public PoolType(String str, int i10, int i11) {
        this.f6219a = i11;
    }

    public static PoolType valueOf(String str) {
        return (PoolType) Enum.valueOf(PoolType.class, str);
    }

    public static PoolType[] values() {
        return (PoolType[]) f6218j.clone();
    }
}
