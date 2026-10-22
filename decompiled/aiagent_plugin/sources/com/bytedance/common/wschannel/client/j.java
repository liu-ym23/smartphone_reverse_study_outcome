package com.bytedance.common.wschannel.client;

import android.content.Context;
import android.os.Parcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;

/* JADX INFO: compiled from: WsChannelApi.java */
/* JADX INFO: loaded from: classes.dex */
public interface j {

    /* JADX INFO: compiled from: WsChannelApi.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f6938a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Parcelable f6939b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f6940c;

        public a() {
        }
    }

    void a(Context r1);

    void a(Context r1, int r2);

    void a(Context r1, SsWsApp r2);

    void a(Context r1, WsChannelMsg r2);

    void a(Context r1, boolean r2, boolean r3);

    void b(Context r1);

    void b(Context r1, SsWsApp r2);
}
