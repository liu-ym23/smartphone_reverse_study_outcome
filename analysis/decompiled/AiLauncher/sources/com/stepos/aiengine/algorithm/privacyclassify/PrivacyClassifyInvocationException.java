package com.stepos.aiengine.algorithm.privacyclassify;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/algorithm/privacyclassify/PrivacyClassifyInvocationException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "errorCode", "", "message", "<init>", "(ILjava/lang/String;)V", Const.INTENT_KEY_APIKEY, "I", "getErrorCode", "()I", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PrivacyClassifyInvocationException extends RuntimeException {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final int errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivacyClassifyInvocationException(int i10, String message) {
        super("privacy classify error: code=" + i10 + " msg=" + message);
        p.i(message, "message");
        this.errorCode = i10;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
