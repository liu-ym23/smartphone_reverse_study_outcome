package com.android.ttcjpaysdk.base.service;

import android.content.Context;
import android.webkit.WebView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\u0014\u0015\u0016J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J(\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u000eH&J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\fH&J(\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H&¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService;", "Lcom/android/ttcjpaysdk/base/service/ICJPayService;", "getBrowserDeviceFinger", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "callback", "Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$DeviceFingerResultCallback;", "startDDCIFrame", "webView", "Landroid/webkit/WebView;", "url", "", "token", "Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$DDCResultCallback;", "startDMIFrame", "uniqueSessionId", "startStepUpIFrame", "hashCode", "", "BrowserDeviceFingerBean", "DDCResultCallback", "DeviceFingerResultCallback", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ICJPayCybsService extends ICJPayService {

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B}\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u0005R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0010\"\u0004\b\u001f\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012¨\u0006+"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$BrowserDeviceFingerBean;", "Ljava/io/Serializable;", "httpBrowserJavaEnabled", "", "httpAcceptContent", "", "httpBrowserLanguage", "httpBrowserColorDepth", "httpBrowserScreenHeight", "httpBrowserScreenWidth", "httpBrowserTimeDifference", "userAgentBrowserValue", "ipAddress", "httpBrowserJavaScriptEnabled", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getHttpAcceptContent", "()Ljava/lang/String;", "setHttpAcceptContent", "(Ljava/lang/String;)V", "getHttpBrowserColorDepth", "setHttpBrowserColorDepth", "getHttpBrowserJavaEnabled", "()Ljava/lang/Boolean;", "setHttpBrowserJavaEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getHttpBrowserJavaScriptEnabled", "setHttpBrowserJavaScriptEnabled", "getHttpBrowserLanguage", "setHttpBrowserLanguage", "getHttpBrowserScreenHeight", "setHttpBrowserScreenHeight", "getHttpBrowserScreenWidth", "setHttpBrowserScreenWidth", "getHttpBrowserTimeDifference", "setHttpBrowserTimeDifference", "getIpAddress", "setIpAddress", "getUserAgentBrowserValue", "setUserAgentBrowserValue", "getJSON", "Lorg/json/JSONObject;", "toJsonString", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BrowserDeviceFingerBean implements Serializable {
        private String httpAcceptContent;
        private String httpBrowserColorDepth;
        private Boolean httpBrowserJavaEnabled;
        private Boolean httpBrowserJavaScriptEnabled;
        private String httpBrowserLanguage;
        private String httpBrowserScreenHeight;
        private String httpBrowserScreenWidth;
        private String httpBrowserTimeDifference;
        private String ipAddress;
        private String userAgentBrowserValue;

        public BrowserDeviceFingerBean() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        public final JSONObject getJSON() {
            JSONObject r100 = new JSONObject();
            r100.put("http_browser_java_enabled", this.httpBrowserJavaEnabled);
            r100.put("device_information_http_accept_content", this.httpAcceptContent);
            r100.put("device_information_http_browser_language", this.httpBrowserLanguage);
            r100.put("device_information_http_browser_colordepth", this.httpBrowserColorDepth);
            r100.put("device_information_http_browser_screenheight", this.httpBrowserScreenHeight);
            r100.put("device_information_http_browser_screenwidth", this.httpBrowserScreenWidth);
            r100.put("device_information_http_browser_timedifference", this.httpBrowserTimeDifference);
            r100.put("device_information_user_agent_browser_value", this.userAgentBrowserValue);
            r100.put("device_information_ipaddress", this.ipAddress);
            r100.put("device_information_http_browser_javascript_enabled", this.httpBrowserJavaScriptEnabled);
            r100.put("consumer_authentication_information_device_channel", "Browser");
            return r100;
        }

        public final String toJsonString() {
            return getJSON().toString();
        }

        public final String getHttpAcceptContent() {
            return this.httpAcceptContent;
        }

        public final String getHttpBrowserColorDepth() {
            return this.httpBrowserColorDepth;
        }

        public final Boolean getHttpBrowserJavaEnabled() {
            return this.httpBrowserJavaEnabled;
        }

        public final Boolean getHttpBrowserJavaScriptEnabled() {
            return this.httpBrowserJavaScriptEnabled;
        }

        public final String getHttpBrowserLanguage() {
            return this.httpBrowserLanguage;
        }

        public final String getHttpBrowserScreenHeight() {
            return this.httpBrowserScreenHeight;
        }

        public final String getHttpBrowserScreenWidth() {
            return this.httpBrowserScreenWidth;
        }

        public final String getHttpBrowserTimeDifference() {
            return this.httpBrowserTimeDifference;
        }

        public final String getIpAddress() {
            return this.ipAddress;
        }

        public final String getUserAgentBrowserValue() {
            return this.userAgentBrowserValue;
        }

        public final void setHttpAcceptContent(String r100) {
            this.httpAcceptContent = r100;
        }

        public final void setHttpBrowserColorDepth(String r100) {
            this.httpBrowserColorDepth = r100;
        }

        public final void setHttpBrowserJavaEnabled(Boolean r100) {
            this.httpBrowserJavaEnabled = r100;
        }

        public final void setHttpBrowserJavaScriptEnabled(Boolean r100) {
            this.httpBrowserJavaScriptEnabled = r100;
        }

        public final void setHttpBrowserLanguage(String r100) {
            this.httpBrowserLanguage = r100;
        }

        public final void setHttpBrowserScreenHeight(String r100) {
            this.httpBrowserScreenHeight = r100;
        }

        public final void setHttpBrowserScreenWidth(String r100) {
            this.httpBrowserScreenWidth = r100;
        }

        public final void setHttpBrowserTimeDifference(String r100) {
            this.httpBrowserTimeDifference = r100;
        }

        public final void setIpAddress(String r100) {
            this.ipAddress = r100;
        }

        public final void setUserAgentBrowserValue(String r100) {
            this.userAgentBrowserValue = r100;
        }

        public BrowserDeviceFingerBean(Boolean r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r108, Boolean r110) {
            this.httpBrowserJavaEnabled = r100;
            this.httpAcceptContent = r101;
            this.httpBrowserLanguage = r102;
            this.httpBrowserColorDepth = r103;
            this.httpBrowserScreenHeight = r104;
            this.httpBrowserScreenWidth = r105;
            this.httpBrowserTimeDifference = r106;
            this.userAgentBrowserValue = r107;
            this.ipAddress = r108;
            this.httpBrowserJavaScriptEnabled = r110;
        }

        public /* synthetic */ BrowserDeviceFingerBean(Boolean r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, Boolean r211, int r212, DefaultConstructorMarker r213) {
            if ((r212 & 1) == 0) goto L5;
            Boolean r100 = Boolean.FALSE;
        L6:
            String r101 = "";
            if ((r212 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r212 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r212 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r212 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r212 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r212 & 64) == 0) goto L29;
            String r107 = "";
        L31:
            if ((r212 & 128) == 0) goto L33;
            String r108 = "";
        L35:
            if ((r212 & 256) != 0) goto L39;
            r101 = r210;
        L39:
            if ((r212 & 512) == 0) goto L41;
            Boolean r109 = Boolean.FALSE;
        L42:
            this(r100, r102, r103, r104, r105, r106, r107, r108, r101, r109);
            return;
        L41:
            r109 = r211;
            goto L42
        L33:
            r108 = r117;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r100 = r110;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$DDCResultCallback;", "", "resultCallback", "", "ret", "", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DDCResultCallback {
        void resultCallback(String r100);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$DeviceFingerResultCallback;", "", "resultCallback", "", "ret", "Lcom/android/ttcjpaysdk/base/service/ICJPayCybsService$BrowserDeviceFingerBean;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DeviceFingerResultCallback {
        void resultCallback(BrowserDeviceFingerBean r100);
    }

    void getBrowserDeviceFinger(Context r100, DeviceFingerResultCallback r101);

    void startDDCIFrame(WebView r100, String r101, String r102, DDCResultCallback r103);

    void startDMIFrame(WebView r100, String r101);

    void startStepUpIFrame(Context r100, String r101, String r102, int r103);
}
