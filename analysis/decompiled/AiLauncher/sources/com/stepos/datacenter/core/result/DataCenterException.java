package com.stepos.datacenter.core.result;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/datacenter/core/result/DataCenterException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "Lcom/stepos/datacenter/core/result/DataCenterError;", "error", "", "message", "", "cause", "<init>", "(Lcom/stepos/datacenter/core/result/DataCenterError;Ljava/lang/String;Ljava/lang/Throwable;)V", Const.INTENT_KEY_APIKEY, "Lcom/stepos/datacenter/core/result/DataCenterError;", "()Lcom/stepos/datacenter/core/result/DataCenterError;", "database_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCenterException extends Exception {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final DataCenterError error;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataCenterException(DataCenterError error, String message, Throwable th) {
        super("[" + error.getCode() + "] " + message, th);
        p.i(error, "error");
        p.i(message, "message");
        this.error = error;
    }

    /* renamed from: a, reason: from getter */
    public final DataCenterError getError() {
        return this.error;
    }
}
