package com.uxsense;

import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.uxsense.core.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ)\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\u000bJ)\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bJ)\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000e\u0010\u000bJ)\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/uxsense/AndroidLogger;", "Lcom/uxsense/core/utils/Logger;", AppAgent.CONSTRUCT, "()V", "", "tag", "message", "", "tr", "LC7/r;", "v", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "d", "i", "w", "e", "uxsense_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
final class AndroidLogger implements Logger {
    @Override // com.uxsense.core.utils.Logger
    public void d(String tag, String message, Throwable tr) {
        k.f(tag, "tag");
        k.f(message, "message");
        if (tr != null) {
            Log.d(tag, message, tr);
        } else {
            Log.d(tag, message);
        }
    }

    @Override // com.uxsense.core.utils.Logger
    public void e(String tag, String message, Throwable tr) {
        k.f(tag, "tag");
        k.f(message, "message");
        if (tr != null) {
            Log.e(tag, message, tr);
        } else {
            Log.e(tag, message);
        }
    }

    @Override // com.uxsense.core.utils.Logger
    public void i(String tag, String message, Throwable tr) {
        k.f(tag, "tag");
        k.f(message, "message");
        if (tr != null) {
            Log.i(tag, message, tr);
        } else {
            Log.i(tag, message);
        }
    }

    @Override // com.uxsense.core.utils.Logger
    public void v(String tag, String message, Throwable tr) {
        k.f(tag, "tag");
        k.f(message, "message");
        if (tr != null) {
            Log.v(tag, message, tr);
        } else {
            Log.v(tag, message);
        }
    }

    @Override // com.uxsense.core.utils.Logger
    public void w(String tag, String message, Throwable tr) {
        k.f(tag, "tag");
        k.f(message, "message");
        if (tr != null) {
            Log.w(tag, message, tr);
        } else {
            Log.w(tag, message);
        }
    }
}
