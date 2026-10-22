package com.stepos.ailauncher.chat.util;

import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/ailauncher/chat/util/s;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "timestampMs", "nowMs", "", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;JJ)Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/util/n;", ChatTracker.CLICK_COPY, Const.INTENT_KEY_PKGNAME, "(JJLcom/stepos/ailauncher/chat/util/n;)Ljava/lang/String;", "", "e", "(JJ)Z", "pattern", Const.INTENT_KEY_UMID, "(JLjava/lang/String;)Ljava/lang/String;", "MINUTE_MS", "J", "HOUR_MS", "DAY_MS", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class s {
    private static final long DAY_MS = 86400000;
    private static final long HOUR_MS = 3600000;
    public static final s INSTANCE = new s();
    private static final long MINUTE_MS = 60000;

    public static /* synthetic */ String c(s sVar, Context context, long j10, long j11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j11 = System.currentTimeMillis();
        }
        return sVar.a(context, j10, j11);
    }

    public final String a(Context context, long timestampMs, long nowMs) {
        kotlin.jvm.internal.p.i(context, "context");
        return b(timestampMs, nowMs, n.INSTANCE.d(context));
    }

    public final String b(long timestampMs, long nowMs, n copy) {
        kotlin.jvm.internal.p.i(copy, "copy");
        if (timestampMs <= 0) {
            return "";
        }
        long jG = C5685n.g(nowMs - timestampMs, 0L);
        return jG < 60000 ? copy.getJustNow() : jG < 3600000 ? copy.d().invoke(Integer.valueOf((int) (jG / 60000))) : jG < 86400000 ? copy.b().invoke(Integer.valueOf((int) (jG / 3600000))) : jG < 172800000 ? copy.getYesterday() : jG <= 604800000 ? copy.a().invoke(Integer.valueOf((int) (jG / 86400000))) : e(timestampMs, nowMs) ? d(timestampMs, "M/d") : d(timestampMs, "yyyy/M/d");
    }

    public final String d(long timestampMs, String pattern) {
        String str = new SimpleDateFormat(pattern, Locale.getDefault()).format(new Date(timestampMs));
        kotlin.jvm.internal.p.h(str, "format(...)");
        return str;
    }

    public final boolean e(long timestampMs, long nowMs) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestampMs);
        int i10 = calendar.get(1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(nowMs);
        return i10 == calendar2.get(1);
    }
}
