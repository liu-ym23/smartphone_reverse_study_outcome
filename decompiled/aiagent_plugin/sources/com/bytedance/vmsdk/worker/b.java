package com.bytedance.vmsdk.worker;

import com.bytedance.vmsdk.net.Request;
import com.bytedance.vmsdk.net.Response;

/* JADX INFO: compiled from: IWorkerDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {
    com.bytedance.vmsdk.net.b a(Request r1, com.bytedance.vmsdk.net.a<Response> r2, com.bytedance.vmsdk.net.a<Throwable> r3);

    String a(String r1);
}
