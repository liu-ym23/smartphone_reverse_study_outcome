package com.android.ttcjpaysdk.integrated.counter.outerpay;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.android.ttcjpaysdk.base.CJOuterPayBean;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJOuterPayCallback;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.caijing.sdk.infra.utils.h;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u00010B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u000e\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#J.\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+J\u001c\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040-2\u0006\u0010.\u001a\u00020/R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00061"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/outerpay/CJOuterPayManager;", "", "()V", "CJ_PAY_CURRENT_VERSION", "", "CJ_PAY_VERSION_V1", "KEY_APP_ID", "KEY_APP_NAME", "KEY_AVATAR", "KEY_BINDPHONE", "KEY_COLD_START", "KEY_DY_PAY_VERSION", "KEY_HIDE_LOADING_CALLBACK", "KEY_NICKNAME", "KEY_PAY_INFO", "KEY_PAY_SOURCE", "KEY_PKG_NAME", "KEY_ROOTER_TIME", "KEY_TOKEN", "KEY_VERSION", "startCounterActivityTime", "", "getStartCounterActivityTime", "()J", "setStartCounterActivityTime", "(J)V", "getOuterPayBean", "Lcom/android/ttcjpaysdk/base/CJOuterPayBean;", "intent", "Landroid/content/Intent;", "hostInfo", "Lcom/android/ttcjpaysdk/base/CJPayHostInfo;", "getOuterType", "Lcom/android/ttcjpaysdk/integrated/counter/outerpay/CJOuterPayManager$OuterType;", "type", "", "startIntegratedOuterCounter", "", "activity", "Landroid/app/Activity;", "hostJson", "Lorg/json/JSONObject;", "callback", "Lcom/android/ttcjpaysdk/base/service/CJOuterPayCallback;", "uriQueryToMap", "", "uri", "Landroid/net/Uri;", "OuterType", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJOuterPayManager {
    public static final String CJ_PAY_CURRENT_VERSION = "3";
    public static final String CJ_PAY_VERSION_V1 = "1";
    public static final CJOuterPayManager INSTANCE = null;
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_APP_NAME = "appName";
    public static final String KEY_AVATAR = "avatar";
    public static final String KEY_BINDPHONE = "bindPhone";
    public static final String KEY_COLD_START = "cold_start";
    public static final String KEY_DY_PAY_VERSION = "dypay_version";
    public static final String KEY_HIDE_LOADING_CALLBACK = "hide_loading_callback";
    public static final String KEY_NICKNAME = "nickName";
    public static final String KEY_PAY_INFO = "payInfo";
    public static final String KEY_PAY_SOURCE = "pay_source";
    public static final String KEY_PKG_NAME = "pkgName";
    public static final String KEY_ROOTER_TIME = "rooter_create_time";
    public static final String KEY_TOKEN = "token";
    public static final String KEY_VERSION = "version";
    private static long startCounterActivityTime;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/integrated/counter/outerpay/CJOuterPayManager$OuterType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "TYPE_THIRD_APP", "TYPE_BROWSER", "TYPE_UNKNOWN", "integrated-counter_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum OuterType extends Enum<OuterType> {
        private static final /* synthetic */ OuterType[] $VALUES = null;
        public static final OuterType TYPE_BROWSER = null;
        public static final OuterType TYPE_THIRD_APP = null;
        public static final OuterType TYPE_UNKNOWN = null;
        private final int value;

        private static final /* synthetic */ OuterType[] $values() {
            return new OuterType[]{TYPE_THIRD_APP, TYPE_BROWSER, TYPE_UNKNOWN};
        }

        public static OuterType valueOf(String r100) {
            return (OuterType) a.a(OuterType.class, r100);
        }

        public static OuterType[] values() {
            return (OuterType[]) $VALUES.clone();
        }

        static {
            TYPE_THIRD_APP = new OuterType("TYPE_THIRD_APP", 0, 1);
            TYPE_BROWSER = new OuterType("TYPE_BROWSER", 1, 2);
            TYPE_UNKNOWN = new OuterType("TYPE_UNKNOWN", 2, -1);
            $VALUES = $values();
        }

        public final int getValue() {
            return this.value;
        }

        private OuterType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        INSTANCE = new CJOuterPayManager();
    }

    private CJOuterPayManager() {
    }

    public final long getStartCounterActivityTime() {
        return startCounterActivityTime;
    }

    public final OuterType getOuterType(int r100) {
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        return OuterType.TYPE_UNKNOWN;
    L11:
        return OuterType.TYPE_BROWSER;
    L9:
        return OuterType.TYPE_THIRD_APP;
    }

    public final void setStartCounterActivityTime(long r100) {
        startCounterActivityTime = r100;
    }

    public final Map<String, String> uriQueryToMap(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<String> r102 = UriProtector.getQueryParameterNames(r100).iterator();     // Catch: Exception -> L8
    L5:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();     // Catch: Exception -> L8
        r101.put(r103, UriProtector.getQueryParameter(r100, r103));     // Catch: Exception -> L8
    L10:
        return r101;
    L8:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJOuterPayManager#uriQueryToMap", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJOuterPayManager#uriQueryToMap", e);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final CJOuterPayBean getOuterPayBean(Intent r210, CJPayHostInfo r211) {
        if (r210 == null) goto L17;
        ResultReceiver r100 = (ResultReceiver) r210.getParcelableExtra(KEY_HIDE_LOADING_CALLBACK);
        if (r100 == null) goto L7;
        r100.send(0, new Bundle());
    L7:
        Uri r101 = r210.getData();
        if (r101 == null) goto L19;
        Map<String, String> r102 = h.a(r101);
        Object[] r110 = 0 == true ? 1 : 0;
        Object[] r111 = 0 == true ? 1 : 0;
        CJOuterPayBean r103 = new CJOuterPayBean(null, null, 0, null, null, null, null, null, null, null, false, null, null, null, r110, r111, null, null, null, false, 1048575, null).toOuterPayBean(KtSafeMethodExtensionKt.safeToJson(r102));
        if (r103 == null) goto L13;
        r103.dataMap = r102;
    L13:
        if (r103 == null) goto L16;
        r103.hostInfo = CJPayHostInfo.Companion.copy(r211);
    L16:
        return r103;
    L19:
        return null;
    L17:
        return null;
    }

    public final void startIntegratedOuterCounter(Activity r100, Intent r101, JSONObject r102, CJOuterPayCallback r103) {
        new IntegratedOuterPayRooter(r100, getOuterPayBean(r101, CJPayHostInfo.Companion.toBean(r102)), r101, r103).gotoTargetPageBySource();
    }
}
