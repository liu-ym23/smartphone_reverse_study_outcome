package com.stepos.stepclaw.memory.utils;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import p5.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J1\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ1\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\n\u0010\tJ1\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\tJ=\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010À\u0006\u0003"}, d2 = {"Lcom/stepos/stepclaw/memory/utils/MemoryLogger;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "tag", "sessionId", "Lkotlin/Function0;", OperationResult.EXTRA_MESSAGE, "Lb5/a0;", "logD", "(Ljava/lang/String;Ljava/lang/String;Lp5/a;)V", "logI", "logW", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "throwable", "logE", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;Lp5/a;)V", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MemoryLogger {

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class DefaultImpls {
    }

    static /* synthetic */ void logD$default(MemoryLogger memoryLogger, String str, String str2, a aVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logD");
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        memoryLogger.logD(str, str2, aVar);
    }

    static /* synthetic */ void logE$default(MemoryLogger memoryLogger, String str, String str2, Throwable th, a aVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logE");
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        if ((i8 & 4) != 0) {
            th = null;
        }
        memoryLogger.logE(str, str2, th, aVar);
    }

    static /* synthetic */ void logI$default(MemoryLogger memoryLogger, String str, String str2, a aVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logI");
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        memoryLogger.logI(str, str2, aVar);
    }

    static /* synthetic */ void logW$default(MemoryLogger memoryLogger, String str, String str2, a aVar, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: logW");
        }
        if ((i8 & 2) != 0) {
            str2 = null;
        }
        memoryLogger.logW(str, str2, aVar);
    }

    void logD(String tag, String sessionId, a message);

    void logE(String tag, String sessionId, Throwable throwable, a message);

    void logI(String tag, String sessionId, a message);

    void logW(String tag, String sessionId, a message);
}
