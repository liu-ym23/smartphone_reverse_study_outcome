package com.bytedance.framwork.core.sdklog;

import android.content.Context;
import android.text.TextUtils;
import f5.b;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LogHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f7551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IConfig f7552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public b f7553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f7554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IResponseConfig f7555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7556f;

    public interface IConfig {
        List<String> getChannels();

        long getLogExpireTime();

        String getLogType();

        int getMaxRetryCount();

        String getRedirectUrl();

        long getRetryInterval();
    }

    public interface IResponseConfig {
        boolean getMoreChannelSwitch();

        boolean getRemoveSwitch();

        int getStatusCode();

        long getStopInterval();

        long getStopMoreChannelInterval();
    }

    public static abstract class a implements IConfig {
        public a() {
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public long getLogExpireTime() {
            return 604800000;
        }
    }

    public LogHandler(Context r10, IConfig r11, IResponseConfig r12) {
        this.f7552b = r11;
        this.f7555e = r12;
        if (r11 == null) goto L14;
        if (r12 == null) goto L12;
        String r13 = r11.getLogType();
        this.f7551a = r13;
        if (TextUtils.isEmpty(r13) == true) goto L10;
        b r14 = b.c(r10);
        this.f7553c = r14;
        r14.h(this.f7551a, this);
        return;
    L10:
        throw new IllegalArgumentException("type is empty.");
    L12:
        throw new IllegalArgumentException("responseConfig is null");
    L14:
        throw new IllegalArgumentException("config is null.");
    }

    public boolean a(String r10) {
        return b(LogLib.c(r10));
    }

    public boolean b(byte[] r10) {
        return this.f7553c.a(this.f7551a, r10);
    }

    public IConfig c() {
        return this.f7552b;
    }

    public long d() {
        return this.f7556f;
    }

    public String e() {
        return this.f7554d;
    }

    public IResponseConfig f() {
        return this.f7555e;
    }

    public void g(byte[] r10, boolean r11) {
    }

    public abstract boolean h(String r10, byte[] r11);

    public void i(long r10) {
        this.f7556f = r10;
    }

    public void j(String r10) {
        this.f7554d = r10;
    }
}
