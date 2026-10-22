package s4;

import La.H;
import O6.l;
import Y8.t;
import android.content.Context;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.ChatCoreSdk;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import kotlin.text.Regex;
import l9.i;
import l9.k;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJA\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010JC\u0010\u0012\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00112\b\b\u0002\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001d\u0010\u001aJ\u0011\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010 \u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\tH\u0002¢\u0006\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010(\u001a\u00020'8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u0010/R\u0014\u00101\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010/R \u00103\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0014028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00106R\u001c\u0010:\u001a\n 9*\u0004\u0018\u000108088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010<R\u0018\u0010=\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010$¨\u0006>"}, d2 = {"Ls4/c;", "", "<init>", "()V", "", x5.d.EXTRA_ENABLED, "LY8/t;", "e", "(Z)V", "", DidiCardProvider.KEY_TRACE_ID, "message", "payload", "level", "source", "k", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V", "", "n", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/io/File;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Ljava/io/File;", "logRoot", "today", Const.INTENT_KEY_UMID, "(Ljava/io/File;Ljava/lang/String;)V", Const.STR_FILE, "line", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/io/File;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "TAG", "Ljava/lang/String;", "ROOT_DIR", "DEFAULT_TRACE_ID", "", "RETENTION_DAYS", "I", "", "DAY_MS", "J", "Ljava/text/SimpleDateFormat;", "dayDirFormat", "Ljava/text/SimpleDateFormat;", "fileTimeFormat", "lineTimeFormat", "Ljava/util/concurrent/ConcurrentHashMap;", "fileCache", "Ljava/util/concurrent/ConcurrentHashMap;", "fileLock", "Ljava/lang/Object;", "cleanupLock", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "ioExecutor", "Ljava/util/concurrent/ExecutorService;", "Z", "lastCleanupDay", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: s4.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C5442c {
    private static final long DAY_MS = 86400000;
    private static final String DEFAULT_TRACE_ID = "unknown-trace";
    private static final int RETENTION_DAYS = 7;
    private static final String ROOT_DIR = "debuglog/chat";
    private static final String TAG = "ChatDebugLogger";
    private static volatile boolean enabled;
    private static volatile String lastCleanupDay;
    public static final C5442c INSTANCE = new C5442c();
    private static final SimpleDateFormat dayDirFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
    private static final SimpleDateFormat fileTimeFormat = new SimpleDateFormat("HH：mm", Locale.getDefault());
    private static final SimpleDateFormat lineTimeFormat = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.getDefault());
    private static final ConcurrentHashMap<String, File> fileCache = new ConcurrentHashMap<>();
    private static final Object fileLock = new Object();
    private static final Object cleanupLock = new Object();
    private static final ExecutorService ioExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: s4.a
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return C5442c.f(runnable);
        }
    });

    public static final Thread f(Runnable runnable) {
        Thread thread = new Thread(runnable, "chat-debug-logger");
        thread.setDaemon(true);
        return thread;
    }

    public static /* synthetic */ void l(C5442c c5442c, String str, String str2, Object obj, String str3, String str4, int i10, Object obj2) {
        if ((i10 & 4) != 0) {
            obj = null;
        }
        if ((i10 & 8) != 0) {
            str3 = "I";
        }
        if ((i10 & 16) != 0) {
            str4 = null;
        }
        c5442c.k(str, str2, obj, str3, str4);
    }

    public static final void m(String str, Object obj, String str2, String str3, String str4) {
        C5442c c5442c;
        File fileI;
        String str5;
        String json;
        if (enabled && (fileI = (c5442c = INSTANCE).i(str)) != null) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = lineTimeFormat;
            synchronized (simpleDateFormat) {
                str5 = simpleDateFormat.format(date);
            }
            String str6 = null;
            if (obj == null) {
                json = null;
            } else if (obj instanceof String) {
                json = (String) obj;
            } else {
                json = ExtKt.l().toJson(obj);
                p.h(json, "toJson(...)");
            }
            if (json == null) {
                json = "";
            }
            if (str2 != null) {
                str6 = "[" + c5442c.j(str2) + "] ";
            }
            if (str6 == null) {
                str6 = "";
            }
            if (obj != null) {
                str3 = json;
            }
            c5442c.c(fileI, str5 + " " + str4 + "/" + str6 + str3);
        }
    }

    public static /* synthetic */ void o(C5442c c5442c, String str, Map map, String str2, String str3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = "I";
        }
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        c5442c.n(str, map, str2, str3);
    }

    public final void c(File file, String line) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            synchronized (fileLock) {
                i.f(file, line + "\n", null, 2, null);
            }
            objB = Result.b(t.f7040a);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "appendLine failed file:" + file.getAbsolutePath() + " err:" + thE.getMessage(), thE, false, 8, null);
        }
    }

    public final void d(File logRoot, String today) {
        Object objB;
        Date date;
        if (p.d(lastCleanupDay, today)) {
            return;
        }
        synchronized (cleanupLock) {
            try {
                if (p.d(lastCleanupDay, today)) {
                    return;
                }
                try {
                    Result.Companion companion = Result.INSTANCE;
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objB = Result.b(C4849c.a(th));
                }
                if (!logRoot.exists()) {
                    lastCleanupDay = today;
                    return;
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                File[] fileArrListFiles = logRoot.listFiles();
                t tVar = null;
                if (fileArrListFiles != null) {
                    ArrayList<File> arrayList = new ArrayList();
                    for (File file : fileArrListFiles) {
                        if (file.isDirectory()) {
                            arrayList.add(file);
                        }
                    }
                    for (File file2 : arrayList) {
                        SimpleDateFormat simpleDateFormat = dayDirFormat;
                        synchronized (simpleDateFormat) {
                            date = simpleDateFormat.parse(file2.getName());
                        }
                        if (date == null) {
                            C4148a.u(TAG, "skip cleanup unknown day dir:" + file2.getName(), false, 4, null);
                        } else if ((jCurrentTimeMillis - date.getTime()) / 86400000 > 7) {
                            p.f(file2);
                            if (k.v(file2)) {
                                C4148a.k(TAG, "deleted expired debug log dir:" + file2.getAbsolutePath(), false, 4, null);
                            } else {
                                C4148a.u(TAG, "failed to delete expired debug log dir:" + file2.getAbsolutePath(), false, 4, null);
                            }
                        }
                    }
                    tVar = t.f7040a;
                }
                objB = Result.b(tVar);
                Throwable thE = Result.e(objB);
                if (thE != null) {
                    C4148a.t(TAG, "cleanupExpiredLogsIfNeeded failed:" + thE.getMessage(), thE, false, 8, null);
                }
                lastCleanupDay = today;
                t tVar2 = t.f7040a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void e(boolean enabled2) {
        enabled = enabled2;
    }

    public final String g(String traceId) {
        String string = traceId != null ? H.D1(traceId).toString() : null;
        if (string == null) {
            string = "";
        }
        if (string.length() == 0) {
            string = DEFAULT_TRACE_ID;
        }
        return new Regex("[\\\\/:*?\"<>|\\s]").l(string, "_");
    }

    public final File h() {
        Object objB;
        File filesDir;
        try {
            Result.Companion companion = Result.INSTANCE;
            Context contextC = ChatCoreSdk.INSTANCE.c();
            File filesDir2 = contextC.getFilesDir();
            if (filesDir2 == null || (filesDir = filesDir2.getParentFile()) == null) {
                filesDir = contextC.getFilesDir();
            }
            objB = Result.b(filesDir);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "resolveAppRoot failed:" + thE.getMessage(), thE, false, 8, null);
            objB = null;
        }
        return (File) objB;
    }

    public final File i(String traceId) {
        String str;
        String str2;
        String strG = g(traceId);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = dayDirFormat;
        synchronized (simpleDateFormat) {
            str = simpleDateFormat.format(date);
        }
        File fileH = h();
        if (fileH == null) {
            return null;
        }
        File file = new File(fileH, ROOT_DIR);
        p.f(str);
        d(file, str);
        File file2 = new File(file, str);
        if (!file2.exists() && !file2.mkdirs()) {
            C4148a.u(TAG, "resolveFile mkdirs failed path:" + file2.getAbsolutePath(), false, 4, null);
            return null;
        }
        String str3 = str + l.DATE_SEPARATOR + strG;
        ConcurrentHashMap<String, File> concurrentHashMap = fileCache;
        File file3 = concurrentHashMap.get(str3);
        if (file3 == null) {
            SimpleDateFormat simpleDateFormat2 = fileTimeFormat;
            synchronized (simpleDateFormat2) {
                str2 = simpleDateFormat2.format(date);
            }
            file3 = new File(file2, str2 + l.DATE_SEPARATOR + strG + ".log");
            File filePutIfAbsent = concurrentHashMap.putIfAbsent(str3, file3);
            if (filePutIfAbsent != null) {
                file3 = filePutIfAbsent;
            }
        }
        return file3;
    }

    public final String j(String source) {
        String string = H.D1(source).toString();
        if (string.length() == 0) {
            return string;
        }
        List listA1 = H.a1(string, new char[]{'.'}, false, 0, 6, null);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listA1) {
            if (((String) obj).length() > 0) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() <= 2) {
            return string;
        }
        return arrayList.get(arrayList.size() - 2) + "." + arrayList.get(arrayList.size() - 1);
    }

    public final void k(final String traceId, final String message, final Object payload, final String level, final String source) {
        p.i(message, "message");
        p.i(level, "level");
        if (enabled) {
            ioExecutor.execute(new Runnable() { // from class: s4.b
                @Override // java.lang.Runnable
                public final void run() {
                    C5442c.m(traceId, payload, source, message, level);
                }
            });
        }
    }

    public final void n(String traceId, Map<String, ? extends Object> payload, String level, String source) {
        p.i(payload, "payload");
        p.i(level, "level");
        k(traceId, "event", payload, level, source);
    }
}
