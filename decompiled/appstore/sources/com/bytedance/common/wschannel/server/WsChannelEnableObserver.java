package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsConstants;

/* JADX INFO: loaded from: classes.dex */
public class WsChannelEnableObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f7078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OnWsChannelEnableChangedObserver f7080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ContentObserver f7082e;

    public interface OnWsChannelEnableChangedObserver {
        void onWsChannelEnableChange(boolean r10);
    }

    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ WsChannelEnableObserver f7083a;

        public a(WsChannelEnableObserver r10, Handler r11) {
            this.f7083a = r10;
            super(r11);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r10) {
            if (Logger.debug() == false) goto L5;
            Logger.d("WsChannelService", "KEY_FRONTIER_ENABLED");
        L5:
            WsChannelEnableObserver.a(this.f7083a);
        }
    }

    public WsChannelEnableObserver(Context r10, Handler r11, OnWsChannelEnableChangedObserver r12) {
        this.f7078a = r11;
        this.f7079b = r10;
        this.f7080c = r12;
        d();
        this.f7082e = new a(this, r11);
        e();
    }

    public static /* synthetic */ void a(WsChannelEnableObserver r10) {
        r10.b();
    }

    public final void b() {
        boolean r10 = this.f7081d;     // Catch: Exception -> L8
        d();     // Catch: Exception -> L8
        boolean r11 = this.f7081d;     // Catch: Exception -> L8
        if (r10 == r11) goto L11;
        OnWsChannelEnableChangedObserver r12 = this.f7080c;     // Catch: Exception -> L8
        if (r12 == null) goto L12;
        r12.onWsChannelEnableChange(r11);     // Catch: Exception -> L8
        return;
    L12:
        return;
    L11:
        return;
    }

    public boolean c() {
        return this.f7081d;
    }

    public final void d() {
        boolean r10 = com.bytedance.common.wschannel.b.d(this.f7079b).e();     // Catch: Throwable -> L9
        if (Logger.debug() == false) goto L6;
        Logger.d("WsChannelService", "pushSdkEnabled = " + r10);     // Catch: Throwable -> L9
    L6:
        if (r10 == this.f7081d) goto L12;
        this.f7081d = r10;     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public final void e() {
        this.f7079b.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.h(this.f7079b, WsConstants.KEY_FRONTIER_ENABLED, "boolean"), true, this.f7082e);     // Catch: Throwable -> L4
        return;
    }
}
