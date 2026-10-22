package com.bytedance.framwork.core.sdklog;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public abstract class LogLib {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ILogDelegate f7557a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f7558b;

    public interface ILogDelegate {
        boolean isNetworkAvailable(Context r10);
    }

    public static class a implements ILogDelegate {
        public a() {
        }

        @Override // com.bytedance.framwork.core.sdklog.LogLib.ILogDelegate
        public boolean isNetworkAvailable(Context r10) {
            return false;
        }
    }

    static {
        f7557a = new a();
    }

    public static void a(ILogDelegate r10) {
        if (f7558b == false) goto L5;
        return;
    L5:
        if (r10 == null) goto L7;
        f7557a = r10;
    L7:
        f7558b = true;
    }

    public static boolean b(Context r10) {
        return f7557a.isNetworkAvailable(r10);
    }

    public static byte[] c(String r10) {
        if (r10 != null) goto L10;
    L8:
        return null;
    L10:
        if (r10.length() <= 0) goto L8;
        return r10.getBytes("UTF-8");
    L12:
        return r10.getBytes();
    }
}
