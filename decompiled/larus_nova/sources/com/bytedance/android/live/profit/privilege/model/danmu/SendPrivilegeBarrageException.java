package com.bytedance.android.live.profit.privilege.model.danmu;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\rB\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/danmu/SendPrivilegeBarrageException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "reason", "I", "getReason", "()I", "", "message", "<init>", "(ILjava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SendPrivilegeBarrageException extends Exception {
    public static final a Companion = null;
    public static final int REASON_RETURN = 1;
    private final int reason;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final int getReason() {
        return this.reason;
    }

    public SendPrivilegeBarrageException(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "message");
        super(r101);
        this.reason = r100;
    }
}
