package com.android.ttcjpaysdk.base.auth;

import android.content.Context;
import androidx.core.util.Pair;
import com.android.ttcjpaysdk.base.BuildConfig;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.auth.activity.CJPayRealNameAuthActivity;
import com.android.ttcjpaysdk.base.service.ICJPayRealNameAuthService;
import com.android.ttcjpaysdk.base.service.annotation.CJPayModuleEntryReport;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNameAuthCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J+\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\bH\u0016¢\u0006\u0002\u0010\u000bJ4\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0017J>\u0010\u0015\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0017¨\u0006\u001c"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/CJPayRealNameAuthService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayRealNameAuthService;", "()V", "getPackageName", "", "setEventExtParams", "", "array", "", "Landroidx/core/util/Pair;", "", "([Landroidx/core/util/Pair;)V", "startCJPayRealNameAuthActivity", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attributes", "eventTrack", "callback", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayRealNameAuthCallback;", "hostInfoJSONObject", "Lorg/json/JSONObject;", "startCJPayRealNameByInfo", "info", "activity_info", "Lorg/json/JSONArray;", "noiseReduceStyle", "", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayRealNameAuthService implements ICJPayRealNameAuthService {
    public static final Companion Companion = null;
    private static Pair<? extends String, Object>[] extParams;
    private static CJPayHostInfo hostInfo;
    private static TTCJPayRealNameAuthCallback realNameAuthCallback;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0018\u0012\u0012\u0012\u0010\u0012\u0006\b\u0001\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/auth/CJPayRealNameAuthService$Companion;", "", "()V", "extParams", "", "Landroidx/core/util/Pair;", "", "getExtParams", "()[Landroidx/core/util/Pair;", "setExtParams", "([Landroidx/core/util/Pair;)V", "[Landroidx/core/util/Pair;", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "getHostInfo", "()Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "setHostInfo", "(Lcom/android/ttcjpaysdk/base/CJPayHostInfo;)V", "realNameAuthCallback", "Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayRealNameAuthCallback;", "getRealNameAuthCallback", "()Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayRealNameAuthCallback;", "setRealNameAuthCallback", "(Lcom/android/ttcjpaysdk/ttcjpayapi/TTCJPayRealNameAuthCallback;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final Pair<? extends String, Object>[] getExtParams() {
            return CJPayRealNameAuthService.access$getExtParams$cp();
        }

        public final CJPayHostInfo getHostInfo() {
            return CJPayRealNameAuthService.access$getHostInfo$cp();
        }

        public final TTCJPayRealNameAuthCallback getRealNameAuthCallback() {
            return CJPayRealNameAuthService.access$getRealNameAuthCallback$cp();
        }

        public final void setExtParams(Pair<? extends String, Object>[] r100) {
            CJPayRealNameAuthService.access$setExtParams$cp(r100);
        }

        public final void setHostInfo(CJPayHostInfo r100) {
            CJPayRealNameAuthService.access$setHostInfo$cp(r100);
        }

        public final void setRealNameAuthCallback(TTCJPayRealNameAuthCallback r100) {
            CJPayRealNameAuthService.access$setRealNameAuthCallback$cp(r100);
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return BuildConfig.LIBRARY_PACKAGE_NAME;
    }

    public CJPayRealNameAuthService() {
    }

    public static final /* synthetic */ Pair[] access$getExtParams$cp() {
        return extParams;
    }

    public static final /* synthetic */ CJPayHostInfo access$getHostInfo$cp() {
        return hostInfo;
    }

    public static final /* synthetic */ TTCJPayRealNameAuthCallback access$getRealNameAuthCallback$cp() {
        return realNameAuthCallback;
    }

    public static final /* synthetic */ void access$setExtParams$cp(Pair[] r100) {
        extParams = r100;
    }

    public static final /* synthetic */ void access$setHostInfo$cp(CJPayHostInfo r100) {
        hostInfo = r100;
    }

    public static final /* synthetic */ void access$setRealNameAuthCallback$cp(TTCJPayRealNameAuthCallback r100) {
        realNameAuthCallback = r100;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayRealNameAuthService
    public void setEventExtParams(Pair<? extends String, Object>[] r100) {
        extParams = r100;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayRealNameAuthService
    @CJPayModuleEntryReport
    public void startCJPayRealNameAuthActivity(Context r100, String r101, String r102, TTCJPayRealNameAuthCallback r103, JSONObject r104) {
        Intrinsics.checkNotNullParameter(r101, "attributes");
        Intrinsics.checkNotNullParameter(r102, "eventTrack");
        Intrinsics.checkNotNullParameter(r103, "callback");
        if (r100 == null) goto L6;
        hostInfo = CJPayHostInfo.Companion.toBean(r104);
        realNameAuthCallback = r103;
        CJPayRealNameAuthActivity.Companion.start(r100, r101, r102);
        return;
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayRealNameAuthService
    @CJPayModuleEntryReport
    public void startCJPayRealNameByInfo(Context r100, String r101, TTCJPayRealNameAuthCallback r102, JSONObject r103, JSONArray r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "info");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (r100 == null) goto L6;
        hostInfo = CJPayHostInfo.Companion.toBean(r103);
        realNameAuthCallback = r102;
        CJPayRealNameAuthActivity.Companion.start(r100, r101, r104, r105);
        return;
    }
}
