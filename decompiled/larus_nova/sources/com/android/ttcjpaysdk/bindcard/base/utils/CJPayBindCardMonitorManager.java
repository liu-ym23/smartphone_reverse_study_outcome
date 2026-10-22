package com.android.ttcjpaysdk.bindcard.base.utils;

import com.android.ttcjpaysdk.base.service.ICJPayTimeTrackCallback;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/CJPayBindCardMonitorManager;", "", "()V", "Companion", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayBindCardMonitorManager {
    public static final Companion Companion = null;
    private static boolean isFirstShow;
    private static ICJPayTimeTrackCallback timeTrackCallback;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\bH\u0007J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/utils/CJPayBindCardMonitorManager$Companion;", "", "()V", "isFirstShow", "", "timeTrackCallback", "Lcom/android/ttcjpaysdk/base/service/ICJPayTimeTrackCallback;", "doFirstPageShow", "", "bindCardType", "", "initState", "setPayTimeTrackCallback", "callback", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final void initState() {
            CJPayBindCardMonitorManager.access$setFirstShow$cp(true);
        }

        @JvmStatic
        public final void doFirstPageShow(String r100) {
            Intrinsics.checkNotNullParameter(r100, "bindCardType");
            if (CJPayBindCardMonitorManager.access$isFirstShow$cp() == false) goto L7;
            ICJPayTimeTrackCallback r101 = CJPayBindCardMonitorManager.access$getTimeTrackCallback$cp();
            if (r101 == null) goto L7;
            r101.onShow(r100);
        L7:
            CJPayBindCardMonitorManager.access$setFirstShow$cp(false);
        }

        @JvmStatic
        public final void setPayTimeTrackCallback(ICJPayTimeTrackCallback r100) {
            CJPayBindCardMonitorManager.access$setTimeTrackCallback$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public CJPayBindCardMonitorManager() {
    }

    @JvmStatic
    public static final void doFirstPageShow(String r100) {
        Companion.doFirstPageShow(r100);
    }

    @JvmStatic
    public static final void initState() {
        Companion.initState();
    }

    @JvmStatic
    public static final void setPayTimeTrackCallback(ICJPayTimeTrackCallback r100) {
        Companion.setPayTimeTrackCallback(r100);
    }

    public static final /* synthetic */ ICJPayTimeTrackCallback access$getTimeTrackCallback$cp() {
        return timeTrackCallback;
    }

    public static final /* synthetic */ boolean access$isFirstShow$cp() {
        return isFirstShow;
    }

    public static final /* synthetic */ void access$setFirstShow$cp(boolean r100) {
        isFirstShow = r100;
    }

    public static final /* synthetic */ void access$setTimeTrackCallback$cp(ICJPayTimeTrackCallback r100) {
        timeTrackCallback = r100;
    }
}
