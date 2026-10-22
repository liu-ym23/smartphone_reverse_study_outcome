package com.bytedance.android.ec.hybrid.card.api;

import com.bytedance.android.ec.hybrid.card.util.k;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0002'(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J/\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u001e\u0010\u001a\u001a\u00020\u00042\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0018H\u0016J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016J\u0010\u0010#\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!H\u0016J\u0012\u0010%\u001a\u00020\u00042\b\b\u0001\u0010$\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016¨\u0006)"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "", "", "time", "", "onCreateKitViewEnd", "start", "end", "onTransDataTime", "onLoadStart", "onRuntimeReady", "onLoadSuccess", "Lcom/bytedance/android/ec/hybrid/card/api/ECLynxCardErrorType;", "type", "", "errorCode", "", "errorMsg", "onLoadFailed", "(Lcom/bytedance/android/ec/hybrid/card/api/ECLynxCardErrorType;Ljava/lang/Integer;Ljava/lang/String;)V", "onFirstScreen", "Lcom/bytedance/lynx/service/model/b;", "error", "onReceivedError", "", "timingInfo", "onTimingSetup", "Lcom/bytedance/android/ec/hybrid/card/util/k;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "onTimingSetupPref", "onTimingUpdatePref", "createViewDuration", LiveCommonConstants.REASON_ON_DEDTROY, "", "status", "onPreCreateView", "cache", "useCache", "onRealSuccess", "Base", "ECLynxCardCacheType", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECLynxCardLifeCycle {

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u001e\u0010\u000b\u001a\u00020\u00022\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007H\u0016J+\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\bH\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle$Base;", "Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle;", "", "onLoadStart", "onRuntimeReady", "onLoadSuccess", "onFirstScreen", "", "", "", "timingInfo", "onTimingSetup", "Lcom/bytedance/android/ec/hybrid/card/api/ECLynxCardErrorType;", "type", "", "errorCode", "errorMsg", "onLoadFailed", "(Lcom/bytedance/android/ec/hybrid/card/api/ECLynxCardErrorType;Ljava/lang/Integer;Ljava/lang/String;)V", "", "time", "createViewDuration", "Lcom/bytedance/android/ec/hybrid/card/util/k;", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "onTimingUpdatePref", "onTimingSetupPref", "cache", "useCache", "<init>", "()V", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static class Base implements IECLynxCardLifeCycle {
        public Base() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void createViewDuration(long r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onCreateKitViewEnd(long r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onDestroy() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onFirstScreen() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onLoadStart() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onLoadSuccess() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onPreCreateView(boolean r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onRealSuccess() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onReceivedError(com.bytedance.lynx.service.model.b r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onRuntimeReady() {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onTimingSetup(Map<String, ? extends Object> r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onTimingSetupPref(k r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onTimingUpdatePref(k r100) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void onTransDataTime(long r100, long r101) {
        }

        @Override // com.bytedance.android.ec.hybrid.card.api.IECLynxCardLifeCycle
        public void useCache(String r100) {
            Intrinsics.checkNotNullParameter(r100, "cache");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0003B\u0000¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/api/IECLynxCardLifeCycle$ECLynxCardCacheType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ECLynxCardCacheType {
        public static final a Companion = null;
        public static final String DECODE_CACHE = "decode_cache";
        public static final String GECKO_CACHE = "gecko_cache";
        public static final String KIT_VIEW_CACHE = "kit_view_cache";
        public static final String RENDER_CACHE = "render_cache";

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f46362a = null;

            public a() {
            }

            static {
                f46362a = new a();
            }
        }

        static {
            Companion = a.f46362a;
        }
    }

    void createViewDuration(long r100);

    void onCreateKitViewEnd(long r100);

    void onDestroy();

    void onFirstScreen();

    void onLoadFailed(ECLynxCardErrorType r100, Integer r101, String r102);

    void onLoadStart();

    void onLoadSuccess();

    void onPreCreateView(boolean r100);

    void onRealSuccess();

    void onReceivedError(com.bytedance.lynx.service.model.b r100);

    void onRuntimeReady();

    void onTimingSetup(Map<String, ? extends Object> r100);

    void onTimingSetupPref(k r100);

    void onTimingUpdatePref(k r100);

    void onTransDataTime(long r100, long r101);

    void useCache(@ECLynxCardCacheType String r100);
}
