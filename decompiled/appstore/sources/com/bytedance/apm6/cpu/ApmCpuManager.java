package com.bytedance.apm6.cpu;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.watson.assist.api.IAssistStat;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public class ApmCpuManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile ApmCpuManager f6748b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CopyOnWriteArraySet f6749a;

    public interface ICpuDataListener {
        void onCpuData(double r10, double r11, String r12, @Nullable IAssistStat.b r13, NetworkUtils.NetworkType r14);
    }

    public interface ICpuExceptionFilter {
        boolean needFilter();
    }

    public interface ICpuExceptionListener {
        void onException(double r10);
    }

    public ApmCpuManager() {
        this.f6749a = new CopyOnWriteArraySet();
    }

    public static ApmCpuManager c() {
        if (f6748b != null) goto L16;
        monitor-enter(ApmCpuManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f6748b != null) goto L11;
        f6748b = new ApmCpuManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ApmCpuManager.class);     // Catch: Throwable -> L9
    L16:
        return f6748b;
    }

    public CopyOnWriteArraySet a() {
        return this.f6749a;
    }

    public String b() {
        String r10 = ListUtils.a(this.f6749a.toArray(), "#");
        if (TextUtils.isEmpty(r10) == true) goto L5;
        return r10;
    L5:
        return "";
    }
}
