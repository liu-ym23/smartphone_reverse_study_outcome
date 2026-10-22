package com.android.ttcjpaysdk.thirdparty.utils;

import com.bytedance.caijing.sdk.infra.base.api.container.IContainerHostDepend;
import com.bytedance.caijing.sdk.infra.base.api.container.ILivePluginHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import ve4.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042:\b\u0002\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/utils/ExperimentHelper;", "", "()V", "isLynxBindCardReady", "", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "isLiveReady", "isBindCardOfflineResourceReady", "", "bdpay-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExperimentHelper {
    public static final ExperimentHelper INSTANCE = null;

    static {
        INSTANCE = new ExperimentHelper();
    }

    private ExperimentHelper() {
    }

    public final boolean isLynxBindCardReady(Function2<? super Boolean, ? super Boolean, Unit> r100) {
        a.f554342a.getClass();
        IContainerHostDepend r101 = (IContainerHostDepend) a.a(IContainerHostDepend.class);
        if (r101 == null) goto L7;
        ILivePluginHelper r102 = r101.getLivePluginHelper();
        if (r102 == null) goto L7;
        Boolean r103 = Boolean.valueOf(r102.hasPluginLoaded());
    L8:
        if (r103 == null) goto L10;
        boolean r104 = r103.booleanValue();
    L11:
        if (r100 == null) goto L13;
        r100.invoke(Boolean.valueOf(r104), Boolean.TRUE);
    L13:
        return r104;
    L10:
        r104 = false;
    L7:
        r103 = null;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean isLynxBindCardReady$default(ExperimentHelper r100, Function2 r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = null;
    L6:
        return r100.isLynxBindCardReady(r101);
    }
}
