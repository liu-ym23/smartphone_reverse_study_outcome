package com.bytedance.android.livesdk.livecommerce.actionrecord.node;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/actionrecord/node/ErrorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "INTERNAL", "NETWORK", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ErrorType extends Enum<ErrorType> {
    public static final ErrorType INTERNAL = null;
    public static final ErrorType NETWORK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorType[] f147644a = null;
    private final String value;

    static {
        ErrorType r100 = new ErrorType("INTERNAL", 0, "client_error");
        INTERNAL = r100;
        ErrorType r101 = new ErrorType("NETWORK", 1, BuyNowCloseMethod.NETWORK_ERROR);
        NETWORK = r101;
        f147644a = new ErrorType[]{r100, r101};
    }

    public static ErrorType valueOf(String r100) {
        return (ErrorType) a.a(ErrorType.class, r100);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) f147644a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public ErrorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
