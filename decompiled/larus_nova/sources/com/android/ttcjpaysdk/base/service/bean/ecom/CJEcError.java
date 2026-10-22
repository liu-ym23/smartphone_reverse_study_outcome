package com.android.ttcjpaysdk.base.service.bean.ecom;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import tf4.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\n\u001a\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/ecom/CJEcError;", "", "Ltf4/a;", "createOrderError$delegate", "Lkotlin/Lazy;", "getCreateOrderError", "()Ltf4/a;", "createOrderError", "createOrderSkipPayError$delegate", "getCreateOrderSkipPayError", "createOrderSkipPayError", "<init>", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class CJEcError {
    public static final CJEcError INSTANCE = null;
    private static final Lazy createOrderError$delegate = null;
    private static final Lazy createOrderSkipPayError$delegate = null;

    private CJEcError() {
    }

    static {
        INSTANCE = new CJEcError();
        createOrderError$delegate = LazyKt.lazy(CJEcError$createOrderError$2.INSTANCE);
        createOrderSkipPayError$delegate = LazyKt.lazy(CJEcError$createOrderSkipPayError$2.INSTANCE);
    }

    public final a getCreateOrderError() {
        return (a) createOrderError$delegate.getValue();
    }

    public final a getCreateOrderSkipPayError() {
        return (a) createOrderSkipPayError$delegate.getValue();
    }
}
