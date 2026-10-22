package com.android.ttcjpaysdk.base.service;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J*\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH&J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0014\u0010\u0010\u001a\u00020\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016¨\u0006\u0014"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/INormalBindCardCallback;", "", "isUnifyProcess", "", "needNotifyBindCardResult", "onBindCardCancel", "", "cancelReason", "", "onBindCardResult", "result", "Lorg/json/JSONObject;", "memberBizOrderNo", "ext", "onEntranceResult", "onExtraInvokeBeforePayNewCard", "onUnifyBindCardResult", "payParams", "useNativeProcess", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface INormalBindCardCallback {
    public static final Companion Companion = null;
    public static final String FAIL = "0";
    public static final String SUCCESS = "1";

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/INormalBindCardCallback$Companion;", "", "()V", "FAIL", "", "SUCCESS", "isSuccess", "", "result", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String FAIL = "0";
        public static final String SUCCESS = "1";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }

        public final boolean isSuccess(String r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            return TextUtils.equals("1", r100);
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean isUnifyProcess(INormalBindCardCallback r100) {
            return false;
        }

        public static boolean needNotifyBindCardResult(INormalBindCardCallback r100) {
            return true;
        }

        public static void onBindCardCancel(INormalBindCardCallback r100, String r101) {
        }

        public static void onBindCardResult(INormalBindCardCallback r100, JSONObject r101, String r102, JSONObject r103) {
        }

        public static void onExtraInvokeBeforePayNewCard(INormalBindCardCallback r100, JSONObject r101) {
        }

        public static void onUnifyBindCardResult(INormalBindCardCallback r100, JSONObject r101) {
        }

        public static boolean useNativeProcess(INormalBindCardCallback r100) {
            return false;
        }

        public static /* synthetic */ void onUnifyBindCardResult$default(INormalBindCardCallback r100, JSONObject r101, int r102, Object r103) {
            if (r103 != null) goto L9;
            if ((r102 & 1) == 0) goto L6;
            r101 = null;
        L6:
            r100.onUnifyBindCardResult(r101);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onUnifyBindCardResult");
        }

        public static /* synthetic */ void onBindCardResult$default(INormalBindCardCallback r100, JSONObject r101, String r102, JSONObject r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            r100.onBindCardResult(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBindCardResult");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean isUnifyProcess();

    boolean needNotifyBindCardResult();

    void onBindCardCancel(String r100);

    void onBindCardResult(JSONObject r100, String r101, JSONObject r102);

    void onEntranceResult(String r100);

    void onExtraInvokeBeforePayNewCard(JSONObject r100);

    void onUnifyBindCardResult(JSONObject r100);

    boolean useNativeProcess();
}
