package com.bytedance.android.livehostapi.business.castscreen.bean;

import com.ss.ttvideoengine.net.DNSParser;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H&J\n\u0010\b\u001a\u0004\u0018\u00010\u0001H&J\n\u0010\t\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH&J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\fH&J\b\u0010\u0015\u001a\u00020\fH\u0016J\b\u0010\u0016\u001a\u00020\fH&J\b\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u0005H&J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0005H&J\b\u0010\u001c\u001a\u00020\fH&J\b\u0010\u001d\u001a\u00020\fH&J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\fH&J\b\u0010!\u001a\u00020\u001fH&¨\u0006\"À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/castscreen/bean/ILiveCastSourceUIDevice;", "", "commonParams", "Lorg/json/JSONObject;", "deviceName", "", "firstProtocol", "getDLNAVendorName", "getRawDevice", "getSinkOSVersion", DNSParser.DNS_RESULT_IP, "isBDLinkDevice", "", "isBdleSupport4K", "isBdleSupportAutoResolution", "isCloudDevice", "isCommonDevice", "isHisenseDLNADevice", "isMiracastDevice", "isSupportBdleCustomizedService", "isSupportLaunchXsgDLNADevice", "isSupportStretch", "isTCastDevice", "port", "", "protocols", "sinkOSVersionCompareTo", "other", "supportDanmaku", "supportLive", "updateBDLink4KConfig", "", "support", "updateLiveDeviceProtocols", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveCastSourceUIDevice {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.castscreen.bean.ILiveCastSourceUIDevice$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$isBdleSupport4K(ILiveCastSourceUIDevice r100) {
            return false;
        }

        public static boolean $default$isBdleSupportAutoResolution(ILiveCastSourceUIDevice r100) {
            return false;
        }

        public static boolean $default$isCommonDevice(ILiveCastSourceUIDevice r100) {
            return false;
        }

        public static boolean $default$isMiracastDevice(ILiveCastSourceUIDevice r100) {
            return false;
        }

        public static boolean $default$isSupportBdleCustomizedService(ILiveCastSourceUIDevice r100) {
            return false;
        }

        public static boolean $default$isSupportStretch(ILiveCastSourceUIDevice r100) {
            return false;
        }

        public static String $default$firstProtocol(ILiveCastSourceUIDevice r100) {
            String r101 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r100.protocols(), new String[]{","}, false, 0, 6, null));
            if (r101 != null) goto L6;
            return "";
        L6:
            return r101;
        }

        public static /* synthetic */ String access$firstProtocol$jd(ILiveCastSourceUIDevice r100) {
            return $default$firstProtocol(r100);
        }

        public static /* synthetic */ boolean access$isBdleSupport4K$jd(ILiveCastSourceUIDevice r100) {
            return $default$isBdleSupport4K(r100);
        }

        public static /* synthetic */ boolean access$isBdleSupportAutoResolution$jd(ILiveCastSourceUIDevice r100) {
            return $default$isBdleSupportAutoResolution(r100);
        }

        public static /* synthetic */ boolean access$isCommonDevice$jd(ILiveCastSourceUIDevice r100) {
            return $default$isCommonDevice(r100);
        }

        public static /* synthetic */ boolean access$isMiracastDevice$jd(ILiveCastSourceUIDevice r100) {
            return $default$isMiracastDevice(r100);
        }

        public static /* synthetic */ boolean access$isSupportBdleCustomizedService$jd(ILiveCastSourceUIDevice r100) {
            return $default$isSupportBdleCustomizedService(r100);
        }

        public static /* synthetic */ boolean access$isSupportStretch$jd(ILiveCastSourceUIDevice r100) {
            return $default$isSupportStretch(r100);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static String firstProtocol(ILiveCastSourceUIDevice r100) {
            return CC.access$firstProtocol$jd(r100);
        }

        public static boolean isBdleSupport4K(ILiveCastSourceUIDevice r100) {
            return CC.access$isBdleSupport4K$jd(r100);
        }

        public static boolean isBdleSupportAutoResolution(ILiveCastSourceUIDevice r100) {
            return CC.access$isBdleSupportAutoResolution$jd(r100);
        }

        public static boolean isCommonDevice(ILiveCastSourceUIDevice r100) {
            return CC.access$isCommonDevice$jd(r100);
        }

        public static boolean isMiracastDevice(ILiveCastSourceUIDevice r100) {
            return CC.access$isMiracastDevice$jd(r100);
        }

        public static boolean isSupportBdleCustomizedService(ILiveCastSourceUIDevice r100) {
            return CC.access$isSupportBdleCustomizedService$jd(r100);
        }

        public static boolean isSupportStretch(ILiveCastSourceUIDevice r100) {
            return CC.access$isSupportStretch$jd(r100);
        }
    }

    JSONObject commonParams();

    String deviceName();

    String firstProtocol();

    String getDLNAVendorName();

    Object getRawDevice();

    String getSinkOSVersion();

    String ip();

    boolean isBDLinkDevice();

    boolean isBdleSupport4K();

    boolean isBdleSupportAutoResolution();

    boolean isCloudDevice();

    boolean isCommonDevice();

    boolean isHisenseDLNADevice();

    boolean isMiracastDevice();

    boolean isSupportBdleCustomizedService();

    boolean isSupportLaunchXsgDLNADevice();

    boolean isSupportStretch();

    boolean isTCastDevice();

    int port();

    String protocols();

    int sinkOSVersionCompareTo(String r100);

    boolean supportDanmaku();

    boolean supportLive();

    void updateBDLink4KConfig(boolean r100);

    void updateLiveDeviceProtocols();
}
