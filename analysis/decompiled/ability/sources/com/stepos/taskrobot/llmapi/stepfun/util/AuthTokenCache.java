package com.stepos.taskrobot.llmapi.stepfun.util;

import J7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import f6.AbstractC1436a;
import f6.C1438c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.k;
import w9.InterfaceC2108a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006H\u0086@¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0010R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0010R\u0016\u0010\u0019\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/util/AuthTokenCache;", "", AppAgent.CONSTRUCT, "()V", "Lf6/c;", "util", "LC7/r;", "init", "(Lf6/c;)V", "refreshForTaskStart", "(LH7/c;)Ljava/lang/Object;", "", "getToken", "()Ljava/lang/String;", "getUid", "TAG", "Ljava/lang/String;", "", "REFRESH_DEDUPE_WINDOW_MS", "J", "REFRESH_TIMEOUT_MS", "accountUtil", "Lf6/c;", "cachedToken", "cachedUid", "lastRefreshAtMs", "Lw9/a;", "refreshMutex", "Lw9/a;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AuthTokenCache {
    private static final long REFRESH_DEDUPE_WINDOW_MS = 1800000;
    private static final long REFRESH_TIMEOUT_MS = 2000;
    private static final String TAG = "AuthTokenCache";
    private static volatile C1438c accountUtil;
    private static volatile String cachedToken;
    private static volatile String cachedUid;
    private static volatile long lastRefreshAtMs;
    public static final AuthTokenCache INSTANCE = new AuthTokenCache();
    private static final InterfaceC2108a refreshMutex = new kotlinx.coroutines.sync.a();

    @c(c = "com.stepos.taskrobot.llmapi.stepfun.util.AuthTokenCache", f = "AuthTokenCache.kt", l = {132, 82}, m = "refreshForTaskStart", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.taskrobot.llmapi.stepfun.util.AuthTokenCache$refreshForTaskStart$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        long J$0;
        long J$1;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AuthTokenCache.this.refreshForTaskStart(this);
        }
    }

    private AuthTokenCache() {
    }

    public final String getToken() {
        String str = cachedToken;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        C1438c c1438c = accountUtil;
        String strA = c1438c != null ? c1438c.a() : null;
        if (strA == null) {
            strA = "";
        }
        if (strA.length() > 0) {
            cachedToken = strA;
            AbstractC1436a.d(TAG, "token lazy-filled", true);
        }
        return strA;
    }

    public final String getUid() {
        String str = cachedUid;
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        C1438c c1438c = accountUtil;
        String strB = c1438c != null ? c1438c.b() : null;
        if (strB == null) {
            strB = "";
        }
        if (strB.length() > 0) {
            cachedUid = strB;
            AbstractC1436a.d(TAG, "uid lazy-filled", true);
        }
        return strB;
    }

    public final void init(C1438c util) {
        k.f(util, "util");
        accountUtil = util;
        AbstractC1436a.d(TAG, "init done", true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ed, code lost:
    
        if (r0 == r5) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshForTaskStart(H7.c<? super C7.r> r23) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.util.AuthTokenCache.refreshForTaskStart(H7.c):java.lang.Object");
    }
}
