package com.bytedance.watson.assist.b.c;

/* JADX INFO: compiled from: ThreadStatInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends d {
    public f() {
    }

    @Override // com.bytedance.watson.assist.b.c.d
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("thread_stat:{tid=").append(this.f11841b).append(" thread_name:").append(this.f11840a).append(" cpu_time:").append(a()).append(" cpu_usage:").append(this.f * 100.0d).append("%").append(" cpu_speed:").append(this.h).append("}");
        return r0.toString();
    }
}
