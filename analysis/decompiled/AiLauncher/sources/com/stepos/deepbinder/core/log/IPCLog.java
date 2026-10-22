package com.stepos.deepbinder.core.log;

import Z8.F;
import Z8.r;
import android.util.Log;
import androidx.annotation.Keep;
import com.autonavi.aps.amapapi.config.Const;
import io.ktor.sse.ServerSentEventKt;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Keep
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ9\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ9\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ9\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0011\u0010\u000fJ9\u0010\u0012\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u000fJC\u0010\u0010\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0010\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/deepbinder/core/log/IPCLog;", "", "<init>", "()V", "", "message", "", "args", "buildLogMsg", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "tag", "buildLogTag", "(Ljava/lang/String;)Ljava/lang/String;", "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V", "e", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "w", "", "throwable", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V", "PRE_TAG", "Ljava/lang/String;", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IPCLog {
    public static final IPCLog INSTANCE = new IPCLog();
    private static final String PRE_TAG = "DBD.";

    private IPCLog() {
    }

    private final String buildLogMsg(String message, Object... args) {
        if (message == null && args.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(64);
        if (message != null) {
            sb2.append(message);
        }
        for (List list : F.e0(r.T0(args), 2)) {
            sb2.append(" ");
            Object objT0 = F.t0(list, 0);
            if (objT0 != null) {
                sb2.append(objT0);
            }
            if (list.size() > 1) {
                sb2.append(ServerSentEventKt.COLON);
                Object objT02 = F.t0(list, 1);
                if (objT02 != null) {
                    sb2.append(objT02);
                }
            }
        }
        String string = sb2.toString();
        p.h(string, "toString(...)");
        return string;
    }

    private final String buildLogTag(String tag) {
        return PRE_TAG + tag;
    }

    @Keep
    public final void d(String tag, String message, Object... args) {
        p.i(tag, "tag");
        p.i(args, "args");
        Log.d(buildLogTag(tag), buildLogMsg(message, Arrays.copyOf(args, args.length)));
    }

    @Keep
    public final void e(String tag, String message, Object... args) {
        p.i(tag, "tag");
        p.i(args, "args");
        Log.e(buildLogTag(tag), buildLogMsg(message, Arrays.copyOf(args, args.length)));
    }

    @Keep
    public final void i(String tag, String message, Object... args) {
        p.i(tag, "tag");
        p.i(args, "args");
        Log.i(buildLogTag(tag), buildLogMsg(message, Arrays.copyOf(args, args.length)));
    }

    @Keep
    public final void w(String tag, String message, Object... args) {
        p.i(tag, "tag");
        p.i(args, "args");
        Log.w(buildLogTag(tag), buildLogMsg(message, Arrays.copyOf(args, args.length)));
    }

    @Keep
    public final void e(String tag, String message, Throwable throwable, Object... args) {
        p.i(tag, "tag");
        p.i(args, "args");
        Log.e(buildLogTag(tag), buildLogMsg(message, Arrays.copyOf(args, args.length)), throwable);
    }
}
