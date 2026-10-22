package com.stepos.stepclaw.base.util;

import android.util.Log;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\f\u0010\u000bJ+\u0010\r\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\r\u0010\u000bJ+\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000bJ+\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u000bJ+\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/stepclaw/base/util/ALog;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tag", OperationResult.EXTRA_MESSAGE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tr", "Lb5/a0;", "v", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "i", "d", "w", "e", "wtf", "PRE_TAG", "Ljava/lang/String;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "DEBUG_ALL", "Z", "step-base_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ALog {
    private static final boolean DEBUG_ALL = false;
    public static final ALog INSTANCE = new ALog();
    private static final String PRE_TAG = "StepClaw-";

    private ALog() {
    }

    public static final void d(String tag, String message, Throwable tr) {
        p.e(tag, "tag");
        p.e(message, "message");
        if (DEBUG_ALL) {
            Log.d(PRE_TAG.concat(tag), message, tr);
        }
    }

    public static /* synthetic */ void d$default(String str, String str2, Throwable th, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            th = null;
        }
        d(str, str2, th);
    }

    public static final void e(String tag, String message, Throwable tr) {
        p.e(tag, "tag");
        p.e(message, "message");
        Log.e(PRE_TAG.concat(tag), message, tr);
    }

    public static /* synthetic */ void e$default(String str, String str2, Throwable th, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            th = null;
        }
        e(str, str2, th);
    }

    public static final void i(String tag, String message, Throwable tr) {
        p.e(tag, "tag");
        p.e(message, "message");
        if (DEBUG_ALL) {
            Log.i(PRE_TAG.concat(tag), message, tr);
        }
    }

    public static /* synthetic */ void i$default(String str, String str2, Throwable th, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            th = null;
        }
        i(str, str2, th);
    }

    public static final void v(String tag, String message, Throwable tr) {
        p.e(tag, "tag");
        p.e(message, "message");
        if (DEBUG_ALL) {
            Log.v(PRE_TAG.concat(tag), message, tr);
        }
    }

    public static /* synthetic */ void v$default(String str, String str2, Throwable th, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            th = null;
        }
        v(str, str2, th);
    }

    public static final void w(String tag, String message, Throwable tr) {
        p.e(tag, "tag");
        p.e(message, "message");
        Log.w(PRE_TAG.concat(tag), message, tr);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            th = null;
        }
        w(str, str2, th);
    }

    public static final void wtf(String tag, String message, Throwable tr) {
        p.e(tag, "tag");
        p.e(message, "message");
        Log.wtf(PRE_TAG.concat(tag), message, tr);
    }

    public static /* synthetic */ void wtf$default(String str, String str2, Throwable th, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            th = null;
        }
        wtf(str, str2, th);
    }
}
