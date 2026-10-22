package kotlin;

import O6.l;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.provider.c;
import h8.C4148a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0010\u0010\u0011J)\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001b\u0010\nJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u001c\u0010\nJ\u000f\u0010\u001d\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001d\u0010\u0003R\u0014\u0010\u001e\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001fR\u0016\u0010!\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$R\u0016\u0010&\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010\"R0\u0010)\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160'j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0016`(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010$R\u0016\u0010,\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010$R\u0016\u0010-\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010$R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001f¨\u0006."}, d2 = {"LK6/o;", "", "<init>", "()V", "", "f", "()Ljava/lang/String;", "channel", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "id", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "name", "k", "branch", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)V", "", com.stepos.ailauncher.container.wallpaper.a.PHASE_END, "c", "(Ljava/lang/String;Ljava/lang/String;Z)V", "", "branchElapsedMs", "e", "(Ljava/lang/String;Ljava/lang/String;J)V", DidiCardProvider.KEY_TRACE_ID, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "TAG", "Ljava/lang/String;", "", c.a.COL_SEQ, "I", "startMs", "J", "prevMs", "step", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "branchStartMs", "Ljava/util/HashMap;", "firstTokenMs", "firstShownMs", "firstFlushedMs", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.o, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0919o {
    private static final String TAG = "ChatTrace";
    private static volatile long firstFlushedMs;
    private static volatile long firstShownMs;
    private static volatile long firstTokenMs;
    private static volatile long prevMs;
    private static volatile int seq;
    private static volatile long startMs;
    private static volatile int step;
    public static final C0919o INSTANCE = new C0919o();
    private static volatile String channel = l.DATE_SEPARATOR;
    private static final HashMap<String, Long> branchStartMs = new HashMap<>();
    private static volatile String traceId = l.DATE_SEPARATOR;

    public static final synchronized void a(String channel2) {
        p.i(channel2, "channel");
        channel = channel2;
        seq++;
        step = 0;
        traceId = l.DATE_SEPARATOR;
        startMs = SystemClock.elapsedRealtime();
        prevMs = startMs;
        firstTokenMs = 0L;
        firstShownMs = 0L;
        firstFlushedMs = 0L;
        branchStartMs.clear();
        C4148a.k(TAG, "┃ [" + channel2 + Const.STR_MART_WELL + seq + " tid=" + traceId + "] ===== 发送链路开始（" + channel2 + "）=====", false, 4, null);
    }

    public static final synchronized void b(String branch, String name) {
        p.i(branch, "branch");
        p.i(name, "name");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        branchStartMs.put(branch, Long.valueOf(jElapsedRealtime));
        step++;
        long j10 = 0;
        if (startMs != 0) {
            j10 = jElapsedRealtime - startMs;
        }
        C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId + "] STEP " + step + " │ [" + branch + "] " + name + " （并行）│ 分支内 +0ms │ 累计 " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
    }

    public static final synchronized void c(String branch, String name, boolean end) {
        String str;
        try {
            p.i(branch, "branch");
            p.i(name, "name");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            step++;
            long j10 = 0;
            if (startMs != 0) {
                j10 = jElapsedRealtime - startMs;
            }
            HashMap<String, Long> map = branchStartMs;
            Long l10 = map.get(branch);
            if (l10 == null) {
                str = "分支内 (无起点)";
            } else {
                str = "分支内 +" + (jElapsedRealtime - l10.longValue()) + Const.SP_KEY_GSM_UPLOAD_MXSIZE;
            }
            C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId + "] STEP " + step + " │ [" + branch + "] " + name + " │ " + str + " │ 累计 " + j10 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
            if (end) {
                map.remove(branch);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void d(String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        c(str, str2, z10);
    }

    public static final synchronized void e(String branch, String name, long branchElapsedMs) {
        String str;
        try {
            p.i(branch, "branch");
            p.i(name, "name");
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            step++;
            if (startMs == 0) {
                str = "累计 -";
            } else {
                str = "累计 " + (jElapsedRealtime - startMs) + Const.SP_KEY_GSM_UPLOAD_MXSIZE;
            }
            C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId + "] STEP " + step + " │ [" + branch + "] " + name + " │ 分支内 +" + branchElapsedMs + "ms │ " + str, false, 4, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    public static final String f() {
        return traceId;
    }

    public static final synchronized void g(String traceId2) {
        p.i(traceId2, "traceId");
        if (traceId2.length() != 0 && p.d(traceId2, traceId)) {
            if (firstTokenMs != 0) {
                return;
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            firstTokenMs = jElapsedRealtime;
            if (startMs == 0) {
                C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId2 + "] STEP ? │ 回流·客户端收到首字 │ (无 begin 基准)", false, 4, null);
                prevMs = jElapsedRealtime;
                return;
            }
            step++;
            long j10 = jElapsedRealtime - prevMs;
            long j11 = jElapsedRealtime - startMs;
            C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId2 + "] STEP " + step + " │ 回流·客户端收到首字(发送→首字 " + j11 + "ms) │ 本步 +" + j10 + "ms │ 累计 " + j11 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
            prevMs = jElapsedRealtime;
        }
    }

    public static final synchronized void h() {
        if (firstFlushedMs != 0) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        firstFlushedMs = jElapsedRealtime;
        if (startMs == 0) {
            C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId + "] STEP ? │ 回流·首字流出节流 │ (无 begin 基准)", false, 4, null);
            prevMs = jElapsedRealtime;
            return;
        }
        step++;
        long j10 = jElapsedRealtime - prevMs;
        long j11 = jElapsedRealtime - startMs;
        C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId + "] STEP " + step + " │ 回流·首字流出节流(FlowCallback) │ 本步 +" + j10 + "ms │ 累计 " + j11 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
        prevMs = jElapsedRealtime;
    }

    public static final synchronized void i(String traceId2) {
        p.i(traceId2, "traceId");
        if (traceId2.length() != 0 && p.d(traceId2, traceId)) {
            if (firstTokenMs != 0 && firstShownMs == 0) {
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                firstShownMs = jElapsedRealtime;
                step++;
                long j10 = jElapsedRealtime - firstTokenMs;
                long j11 = startMs == 0 ? j10 : jElapsedRealtime - startMs;
                C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId2 + "] STEP " + step + " │ 回流·首字上屏 │ 收到首字→上屏 +" + j10 + "ms │ 累计 " + j11 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
                prevMs = jElapsedRealtime;
            }
        }
    }

    public static final synchronized void j(String id) {
        p.i(id, "id");
        if (id.length() != 0 && !p.d(id, traceId)) {
            traceId = id;
            C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId + "] 绑定 traceId", false, 4, null);
        }
    }

    public static final synchronized void k(String name) {
        p.i(name, "name");
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (startMs == 0) {
            C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId + "] STEP ? │ " + name + " │ (无 begin 基准)", false, 4, null);
            prevMs = jElapsedRealtime;
            return;
        }
        step++;
        long j10 = jElapsedRealtime - prevMs;
        long j11 = jElapsedRealtime - startMs;
        C4148a.k(TAG, "┃ [" + channel + Const.STR_MART_WELL + seq + " tid=" + traceId + "] STEP " + step + " │ " + name + " │ 本步 +" + j10 + "ms │ 累计 " + j11 + Const.SP_KEY_GSM_UPLOAD_MXSIZE, false, 4, null);
        prevMs = jElapsedRealtime;
    }
}
