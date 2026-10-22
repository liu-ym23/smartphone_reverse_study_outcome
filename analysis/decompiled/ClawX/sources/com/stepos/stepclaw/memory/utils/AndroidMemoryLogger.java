package com.stepos.stepclaw.memory.utils;

import a6.f0;
import a6.i0;
import a6.r0;
import a6.x1;
import a8.b;
import b5.a0;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.base.util.ALog;
import com.stepos.stepclaw.provider.contract.OperationResult;
import f5.c;
import g5.a;
import h5.e;
import h6.d;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import x5.n;
import x5.u;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J/\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012J/\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016¢\u0006\u0004\b\u0014\u0010\u0012J9\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010#\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R \u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020-0,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/stepos/stepclaw/memory/utils/AndroidMemoryLogger;", "Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", "<init>", "()V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "sessionId", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "maxLen", "sanitizeSessionId", "(Ljava/lang/String;I)Ljava/lang/String;", "level", "tag", OperationResult.EXTRA_MESSAGE, "Lb5/a0;", "persistLog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lkotlin/Function0;", "logD", "(Ljava/lang/String;Ljava/lang/String;Lp5/a;)V", "logI", "logW", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "throwable", "logE", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lp5/a;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "debugEnable", "Z", "getDebugEnable", "()Z", "setDebugEnable", "(Z)V", "persistEnabled", "getPersistEnabled", "setPersistEnabled", "persistDir", "Ljava/lang/String;", "getPersistDir", "()Ljava/lang/String;", "setPersistDir", "(Ljava/lang/String;)V", "La6/f0;", "persistScope", "La6/f0;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Ljava/io/File;", "sessionFileCache", "Ljava/util/Map;", "Companion", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidMemoryLogger implements MemoryLogger {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FILE_SUFFIX = ".txt";
    private static final String FILE_TIME_PREFIX = "HH-mm-ss-";
    private static final int FS_MAX_FILENAME_LEN = 255;
    private static final int MAX_SESSION_CACHE = 128;
    private static final String PREFIX = "stepmem-";
    private boolean debugEnable;
    private String persistDir;
    private boolean persistEnabled;
    private final f0 persistScope;
    private final Map<String, File> sessionFileCache;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u000b\u001a\u00020\u0005*\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/memory/utils/AndroidMemoryLogger$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "PREFIX", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "FS_MAX_FILENAME_LEN", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "FILE_TIME_PREFIX", "FILE_SUFFIX", "MAX_SESSION_CACHE", "escapeForLog", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final String escapeForLog(String str) {
            p.e(str, "<this>");
            return u.a1(u.a1(u.a1(str, "\n", "\\n"), "\r", "\\r"), "\t", "\\t");
        }

        private Companion() {
        }
    }

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"La6/f0;", "Lb5/a0;", "<anonymous>", "(La6/f0;)V"}, k = 3, mv = {2, 2, 0})
    @e(c = "com.stepos.stepclaw.memory.utils.AndroidMemoryLogger$persistLog$1", f = "AndroidMemoryLogger.kt", l = {}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.stepclaw.memory.utils.AndroidMemoryLogger$persistLog$1, reason: invalid class name */
    public static final class AnonymousClass1 extends h5.i implements p5.p {
        final /* synthetic */ String $dir;
        final /* synthetic */ String $level;
        final /* synthetic */ String $message;
        final /* synthetic */ String $sessionId;
        final /* synthetic */ String $tag;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, String str3, String str4, String str5, c cVar) {
            super(2, cVar);
            this.$sessionId = str;
            this.$dir = str2;
            this.$level = str3;
            this.$tag = str4;
            this.$message = str5;
        }

        @Override // h5.a
        public final c create(Object obj, c cVar) {
            return AndroidMemoryLogger.this.new AnonymousClass1(this.$sessionId, this.$dir, this.$level, this.$tag, this.$message, cVar);
        }

        @Override // p5.p
        public final Object invoke(f0 f0Var, c cVar) {
            return ((AnonymousClass1) create(f0Var, cVar)).invokeSuspend(a0.f883a);
        }

        @Override // h5.a
        public final Object invokeSuspend(Object obj) throws IOException {
            File file;
            a aVar = a.f2984a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a.a.c0(obj);
            try {
                Date date = new Date();
                Locale locale = Locale.US;
                String str = new SimpleDateFormat("yyyy-MM-dd", locale).format(date);
                String str2 = new SimpleDateFormat("HH:mm:ss.SSS", locale).format(date);
                String strSanitizeSessionId = AndroidMemoryLogger.this.sanitizeSessionId(this.$sessionId, 242);
                Map map = AndroidMemoryLogger.this.sessionFileCache;
                AndroidMemoryLogger androidMemoryLogger = AndroidMemoryLogger.this;
                String str3 = this.$dir;
                synchronized (map) {
                    try {
                        Map map2 = androidMemoryLogger.sessionFileCache;
                        Object file2 = map2.get(strSanitizeSessionId);
                        if (file2 == null) {
                            String str4 = new SimpleDateFormat("HH-mm-ss", locale).format(date);
                            file2 = new File(new File(str3, str), str4 + "-" + strSanitizeSessionId + AndroidMemoryLogger.FILE_SUFFIX);
                            map2.put(strSanitizeSessionId, file2);
                        }
                        file = (File) file2;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileWriter fileWriter = new FileWriter(file, true);
                try {
                    fileWriter.write("[" + str2 + "][" + this.$level + "][" + this.$tag + "] " + this.$message + "\n");
                    fileWriter.close();
                } finally {
                }
            } catch (Exception unused) {
            }
            return a0.f883a;
        }
    }

    public AndroidMemoryLogger() {
        h6.e eVar = r0.f210a;
        d dVar = d.f3059c;
        x1 x1VarC = i0.c();
        dVar.getClass();
        this.persistScope = i0.b(h.I(dVar, x1VarC));
        Map<String, File> mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap<String, File>() { // from class: com.stepos.stepclaw.memory.utils.AndroidMemoryLogger$sessionFileCache$1
            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsKey(Object obj) {
                if (obj instanceof String) {
                    return containsKey((String) obj);
                }
                return false;
            }

            public /* bridge */ boolean containsValue(File file) {
                return super.containsValue((Object) file);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<Map.Entry<String, File>> entrySet() {
                return getEntries();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ File get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            public /* bridge */ Set<Map.Entry<String, File>> getEntries() {
                return super.entrySet();
            }

            public /* bridge */ Set<String> getKeys() {
                return super.keySet();
            }

            public final /* bridge */ File getOrDefault(Object obj, File file) {
                return !(obj instanceof String) ? file : getOrDefault((String) obj, file);
            }

            public /* bridge */ int getSize() {
                return super.size();
            }

            public /* bridge */ Collection<File> getValues() {
                return super.values();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Set<String> keySet() {
                return getKeys();
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ File remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap
            public boolean removeEldestEntry(Map.Entry<String, File> eldest) {
                return size() > 128;
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ int size() {
                return getSize();
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ Collection<File> values() {
                return getValues();
            }

            public /* bridge */ boolean containsKey(String str) {
                return super.containsKey((Object) str);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ boolean containsValue(Object obj) {
                if (obj instanceof File) {
                    return containsValue((File) obj);
                }
                return false;
            }

            public /* bridge */ File get(String str) {
                return (File) super.get((Object) str);
            }

            public /* bridge */ File getOrDefault(String str, File file) {
                return (File) super.getOrDefault((Object) str, (String) file);
            }

            public /* bridge */ File remove(String str) {
                return (File) super.remove((Object) str);
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object get(Object obj) {
                if (obj instanceof String) {
                    return get((String) obj);
                }
                return null;
            }

            @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
                return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (File) obj2);
            }

            @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
            public final /* bridge */ /* synthetic */ Object remove(Object obj) {
                if (obj instanceof String) {
                    return remove((String) obj);
                }
                return null;
            }

            @Override // java.util.HashMap, java.util.Map
            public final /* bridge */ boolean remove(Object obj, Object obj2) {
                if ((obj instanceof String) && (obj2 instanceof File)) {
                    return remove((String) obj, (File) obj2);
                }
                return false;
            }

            public /* bridge */ boolean remove(String str, File file) {
                return super.remove((Object) str, (Object) file);
            }
        });
        p.d(mapSynchronizedMap, "synchronizedMap(...)");
        this.sessionFileCache = mapSynchronizedMap;
    }

    private final void persistLog(String level, String tag, String message, String sessionId) {
        String str = this.persistDir;
        if (str == null) {
            return;
        }
        i0.q(this.persistScope, null, new AnonymousClass1(sessionId, str, level, tag, message, null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String sanitizeSessionId(String sessionId, int maxLen) {
        if (sessionId == null) {
            return "unknown";
        }
        if (n.t1(sessionId)) {
            sessionId = null;
        }
        if (sessionId == null) {
            return "unknown";
        }
        String strQ1 = n.Q1(maxLen, n.M1(sessionId, AbstractJsonLexerKt.COLON, sessionId));
        return strQ1.length() == 0 ? "unknown" : strQ1;
    }

    public final boolean getDebugEnable() {
        return this.debugEnable;
    }

    public final String getPersistDir() {
        return this.persistDir;
    }

    public final boolean getPersistEnabled() {
        return this.persistEnabled;
    }

    @Override // com.stepos.stepclaw.memory.utils.MemoryLogger
    public void logD(String tag, String sessionId, p5.a message) {
        p.e(tag, "tag");
        p.e(message, "message");
        boolean z = this.persistEnabled && this.persistDir != null;
        if (this.debugEnable || z) {
            String str = (String) message.invoke();
            if (this.debugEnable) {
                ALog.d$default(PREFIX.concat(tag), str, null, 4, null);
            }
            if (z) {
                persistLog("D", tag, str, sessionId);
            }
        }
    }

    @Override // com.stepos.stepclaw.memory.utils.MemoryLogger
    public void logE(String tag, String sessionId, Throwable throwable, p5.a message) {
        p.e(tag, "tag");
        p.e(message, "message");
        boolean z = this.persistEnabled && this.persistDir != null;
        if (this.debugEnable || z) {
            String strO = (String) message.invoke();
            if (this.debugEnable) {
                String strConcat = PREFIX.concat(tag);
                if (throwable != null) {
                    ALog.e(strConcat, strO, throwable);
                } else {
                    ALog.e$default(strConcat, strO, null, 4, null);
                }
            }
            if (z) {
                if (throwable != null) {
                    strO = b.o(strO, " | ", throwable.getMessage());
                }
                persistLog("E", tag, strO, sessionId);
            }
        }
    }

    @Override // com.stepos.stepclaw.memory.utils.MemoryLogger
    public void logI(String tag, String sessionId, p5.a message) {
        p.e(tag, "tag");
        p.e(message, "message");
        boolean z = this.persistEnabled && this.persistDir != null;
        if (this.debugEnable || z) {
            String str = (String) message.invoke();
            if (this.debugEnable) {
                ALog.i$default(PREFIX.concat(tag), str, null, 4, null);
            }
            if (z) {
                persistLog("I", tag, str, sessionId);
            }
        }
    }

    @Override // com.stepos.stepclaw.memory.utils.MemoryLogger
    public void logW(String tag, String sessionId, p5.a message) {
        p.e(tag, "tag");
        p.e(message, "message");
        boolean z = this.persistEnabled && this.persistDir != null;
        if (this.debugEnable || z) {
            String str = (String) message.invoke();
            if (this.debugEnable) {
                ALog.w$default(PREFIX.concat(tag), str, null, 4, null);
            }
            if (z) {
                persistLog("W", tag, str, sessionId);
            }
        }
    }

    public final void setDebugEnable(boolean z) {
        this.debugEnable = z;
    }

    public final void setPersistDir(String str) {
        this.persistDir = str;
    }

    public final void setPersistEnabled(boolean z) {
        this.persistEnabled = z;
    }
}
