package com.bytedance.android.btm.impl.util;

import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import com.bytedance.android.btm.impl.setting.BtmSetting;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static MessageQueue f42496a;

    public static final class a implements MessageQueue.IdleHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0 f42497a;

        public a(Function0 r100) {
            this.f42497a = r100;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            this.f42497a.invoke();
            return false;
        }
    }

    static {
    }

    public static void a(Function0 r100) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L17:
        r100.invoke();
        return;
    L5:
        if (BtmSetting.f42469d.c().d().o() != 1) goto L17;
        if (f42496a != null) goto L13;
        Looper r101 = Looper.getMainLooper();
        if (r101 == null) goto L11;
        MessageQueue r102 = r101.getQueue();
    L12:
        f42496a = r102;
        goto L13
    L11:
        r102 = null;
    L13:
        MessageQueue r103 = f42496a;
        if (r103 == null) goto L16;
        r103.addIdleHandler(new a(r100));
        return;
    L16:
        r100.invoke();
    }
}
