package com.bytedance.android.latch.internal.util;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\u0018\u0000 \u00112\u00060\u0001j\u0002`\u0002:\u0001\u0012B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/latch/internal/util/LatchException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "", "cause", "<init>", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "latch-core_release"}, k = 1, mv = {1, 4, 3})
public final class LatchException extends RuntimeException {
    public static final a Companion = null;
    public static final int ERR_CODE_INIT_JS_NOT_FOUND = -1001;
    public static final int ERR_CODE_NATIVE_ERROR = -1000;
    public static final int ERR_CODE_PREFETCH_JS_NOT_FOUND = -1002;
    public static final int ERR_CODE_PREFETCH_NOT_INITIALIZE = -2002;
    public static final int ERR_CODE_PREFETCH_RULE_NOT_MATCH = -2007;
    public static final int ERR_CODE_PREFETCH_VERSION_NOT_MATCH = -2006;
    public static final int ERR_CODE_SCRIPT_CONTENT_STILL_LOADING = -1003;
    public static final int ERR_CODE_TEMPLATE_VERSION_NOT_MATCH = -1004;
    private final int code;
    private final String message;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public LatchException(int r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r101, "message");
        super(r101, r102);
        this.code = r100;
        this.message = r101;
    }

    public /* synthetic */ LatchException(int r100, String r101, Throwable r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }
}
