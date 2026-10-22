package com.bytedance.android.shopping.abscontainer.arch.core.data;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/arch/core/data/ResponseType;", "", ConfirmNextAction.ACTION_TYPE_QUERY, "UPLINK", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ResponseType extends Enum<ResponseType> {
    public static final ResponseType QUERY = null;
    public static final ResponseType UPLINK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResponseType[] f164133a = null;

    static {
        ResponseType r100 = new ResponseType(ConfirmNextAction.ACTION_TYPE_QUERY, 0);
        QUERY = r100;
        ResponseType r101 = new ResponseType("UPLINK", 1);
        UPLINK = r101;
        f164133a = new ResponseType[]{r100, r101};
    }

    public static ResponseType valueOf(String r100) {
        return (ResponseType) a.a(ResponseType.class, r100);
    }

    public static ResponseType[] values() {
        return (ResponseType[]) f164133a.clone();
    }

    public ResponseType(String r100, int r101) {
        super(r100, r101);
    }
}
