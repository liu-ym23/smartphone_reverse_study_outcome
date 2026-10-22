package com.stepos.taskrobot.llmapi.stepfun.logging;

import B7.a;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import f6.AbstractC1436a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import l6.c;
import stepai.android.logger.ILogger;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\tJ\u001f\u0010\r\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/logging/LogUtilILogger;", "Lstepai/android/logger/ILogger;", AppAgent.CONSTRUCT, "()V", "", "tag", NotificationCompat.CATEGORY_MESSAGE, "LC7/r;", "i", "(Ljava/lang/String;Ljava/lang/String;)V", "d", "e", "w", "v", "vendorDid", "()Ljava/lang/String;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LogUtilILogger implements ILogger {
    public static final LogUtilILogger INSTANCE = new LogUtilILogger();

    private LogUtilILogger() {
    }

    @Override // stepai.android.logger.ILogger
    public void d(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        AbstractC1436a.a(tag, msg, false);
    }

    @Override // stepai.android.logger.ILogger
    public void e(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        AbstractC1436a.b(tag, msg, false);
    }

    @Override // stepai.android.logger.ILogger
    public void i(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        AbstractC1436a.d(tag, msg, false);
    }

    @Override // stepai.android.logger.ILogger
    public void v(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        if (AbstractC1436a.f4439a) {
            c.f5288a.v(a.B(tag, " : ", msg), new Object[0]);
        }
    }

    @Override // stepai.android.logger.ILogger
    public String vendorDid() {
        return "logutil";
    }

    @Override // stepai.android.logger.ILogger
    public void w(String tag, String msg) {
        k.f(tag, "tag");
        k.f(msg, "msg");
        AbstractC1436a.e(tag, msg, false);
    }
}
