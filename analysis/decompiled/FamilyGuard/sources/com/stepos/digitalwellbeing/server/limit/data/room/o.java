package com.stepos.digitalwellbeing.server.limit.data.room;

import java.util.Objects;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public String f14644a;

    /* renamed from: b, reason: collision with root package name */
    public int f14645b;

    /* renamed from: c, reason: collision with root package name */
    public long f14646c;

    public o() {
    }

    public int a() {
        return this.f14645b;
    }

    public String b() {
        return this.f14644a;
    }

    public void c(int i5) {
        this.f14645b = i5;
    }

    public void d(long j5) {
        this.f14646c = j5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f14645b == oVar.f14645b && this.f14646c == oVar.f14646c && Objects.equals(this.f14644a, oVar.f14644a);
    }

    public int hashCode() {
        return Objects.hash(this.f14644a, Integer.valueOf(this.f14645b), Long.valueOf(this.f14646c));
    }

    public String toString() {
        return "SuspendedRecordEntity " + hashCode() + "{packageName='" + this.f14644a + "', flags=" + this.f14645b + ", updateTime=" + this.f14646c + '}';
    }

    public o(String str, int i5, long j5) {
        this.f14644a = str;
        this.f14645b = i5;
        this.f14646c = j5;
    }
}
