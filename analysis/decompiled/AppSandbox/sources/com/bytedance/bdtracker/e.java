package com.bytedance.bdtracker;

import android.text.TextUtils;
import com.bytedance.applog.InitConfig;
import com.bytedance.applog.encryptor.IEncryptorType;
import com.bytedance.applog.event.AutoTrackEventType;
import com.bytedance.applog.exception.AppCrashType;
import com.bytedance.applog.log.EventBus;
import com.bytedance.mpaas.IEncryptor;
import com.stepos.cloudsdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e implements EventBus.DataFetcher {
    public final /* synthetic */ InitConfig a;
    public final /* synthetic */ d b;

    public e(d dVar, InitConfig initConfig) {
        this.b = dVar;
        this.a = initConfig;
    }

    @Override // com.bytedance.applog.log.EventBus.DataFetcher
    public Object fetch() {
        String strJoin;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.b.m);
            jSONObject.put("channel", this.a.getChannel());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("AppLog 版本号", "6.17.4");
            jSONObject2.put("AppLog 版本地区", "国内");
            jSONObject2.put("AppLog版本序号", 6170490);
            jSONObject2.put("请求加密开关", this.b.E);
            jSONObject2.put("响应加密开关", this.a.isResponseEncryptEnabled());
            if (this.b.E) {
                IEncryptor encryptor = this.a.getEncryptor();
                jSONObject2.put("是否配置了自定义加密", encryptor == null ? "未配置" : "客户端已配置");
                String strEncryptorType = "默认加密类型";
                if ((encryptor instanceof z) && !IEncryptorType.DEFAULT_ENCRYPTOR.equals(((z) encryptor).encryptorType())) {
                    strEncryptorType = ((z) encryptor).encryptorType();
                }
                jSONObject2.put("自定义加密类型", strEncryptorType);
            }
            jSONObject2.put("日志开关", this.a.isLogEnable());
            jSONObject2.put("自定义日志打印", this.a.getLogger() != null);
            jSONObject2.put("AB实验开关", this.a.isAbEnable());
            jSONObject2.put("自动启动图开关", this.a.autoStart());
            jSONObject2.put("自动激活开关", this.a.isAutoActive());
            jSONObject2.put("H5 打通开关", this.a.isH5BridgeEnable());
            jSONObject2.put("H5 全埋点注入", this.a.isH5CollectEnable());
            jSONObject2.put("H5 打通是否允许更新用户信息开关", this.a.isUseBridgeUpdateUUIDEnabled());
            if (this.a.getH5BridgeAllowlist() != null && !this.a.getH5BridgeAllowlist().isEmpty()) {
                jSONObject2.put("H5 域名白名单", TextUtils.join("、", this.a.getH5BridgeAllowlist()));
            }
            jSONObject2.put("不过滤 H5 域名开关", this.a.isH5BridgeAllowAll());
            jSONObject2.put("全埋点开关", this.a.isAutoTrackEnabled());
            ArrayList arrayList = new ArrayList();
            if (AutoTrackEventType.a(this.a.getAutoTrackEventType(), 4)) {
                arrayList.add("点击事件");
            }
            if (AutoTrackEventType.a(this.a.getAutoTrackEventType(), 2)) {
                arrayList.add("页面事件");
            }
            if (AutoTrackEventType.a(this.a.getAutoTrackEventType(), 8)) {
                arrayList.add("页面离开事件");
            }
            if (!arrayList.isEmpty()) {
                jSONObject.put("全埋点类型", TextUtils.join("、", arrayList));
            }
            jSONObject2.put("视图曝光开关", this.a.isExposureEnabled());
            jSONObject2.put("内部监控开关", this.a.isMonitorEnabled());
            jSONObject2.put("采集屏幕方向开关", this.a.isScreenOrientationEnabled());
            jSONObject2.put("初始化 UUID", this.a.getUserUniqueId());
            jSONObject2.put("初始化 UUID 类型", this.a.getUserUniqueIdType());
            jSONObject2.put("采集 OAID 开关", this.a.isOaidEnabled());
            jSONObject2.put("补偿 OAID 开关", this.a.isReportOaidEnable());
            jSONObject2.put("采集 MAC 开关", this.a.isMacEnable());
            jSONObject2.put("采集 ANDROID ID 开关", this.a.isAndroidIdEnabled());
            jSONObject2.put("采集运营商信息开关", this.a.isOperatorInfoEnabled());
            jSONObject2.put("采集 ICCID 开关", this.a.isIccIdEnabled());
            jSONObject2.put("采集 SerialNumber 开关", this.a.isSerialNumberEnable());
            jSONObject2.put("自动采集 FRAGMENT 开关", this.a.isAutoTrackFragmentEnabled());
            jSONObject2.put("后台静默开关", this.a.isSilenceInBackground());
            jSONObject2.put("鸿蒙设备采集开关", this.a.isHarmonyEnabled());
            jSONObject2.put("隐私模式开关", this.b.x);
            jSONObject2.put("禁止采集详细信息开关", !this.b.reportPhoneDetailInfo());
            jSONObject2.put("采集 Crash", AppCrashType.hasCrashType(this.a.getTrackCrashType(), 1) ? "JAVA" : "不采集");
            jSONObject2.put("ALINK 监听", this.b.z != null);
            jSONObject2.put("自定义激活参数", this.b.A != null);
            jSONObject2.put("延迟深度链接开关", this.a.isDeferredALinkEnabled());
            jSONObject2.put("缓存文件名称", this.a.getSpName());
            jSONObject2.put("数据库文件名称", this.a.getDbName());
            jSONObject2.put("监听生命周期", this.a.isHandleLifeCycle());
            jSONObject2.put("小版本号", this.a.getVersionMinor());
            jSONObject2.put("版本号编码", String.valueOf(this.a.getVersionCode()));
            jSONObject2.put("版本号", this.a.getVersion());
            jSONObject2.put("应用名称", this.a.getAppName());
            jSONObject2.put("圈选配置", this.a.getPicker() != null);
            jSONObject2.put("当前进程", this.b.o.j() ? "主进程" : "子进程");
            jSONObject2.put("地区", this.a.getRegion());
            jSONObject2.put("语言", this.a.getLanguage());
            jSONObject2.put("PLAY 开关", this.a.isPlayEnable());
            jSONObject2.put("Gaid 开关", this.a.isGaidEnabled());
            jSONObject2.put("屏幕信息开关", this.a.isDisplayDensityAndDpiEnabled());
            jSONObject2.put("CPU Abi 开关", this.a.isCPUAbiEnabled());
            jSONObject2.put("曝光事件是否重复产生开关", this.a.isAbTestExposureEventRepeatEnabled());
            jSONObject2.put("LaunchTerminate 开关", this.a.isLaunchTerminateEnabled());
            if (this.a.isGaidEnabled()) {
                jSONObject2.put("GAID 获取超时时间", this.a.getGaidTimeOutMilliSeconds());
            }
            jSONObject2.put("PageMeta 接口注解开关", this.a.isPageMetaAnnotationEnable());
            if (this.a.getUriConfig() != null) {
                ArrayList arrayList2 = new ArrayList();
                if (this.a.getUriConfig().getSendUris() != null) {
                    arrayList2.addAll(Arrays.asList(this.a.getUriConfig().getSendUris()));
                }
                if (r.d(this.a.getUriConfig().getRegisterUri())) {
                    arrayList2.add(this.a.getUriConfig().getRegisterUri());
                }
                if (r.d(this.a.getUriConfig().getSettingUri())) {
                    arrayList2.add(this.a.getUriConfig().getSettingUri());
                }
                if (r.d(this.a.getUriConfig().getAbUri())) {
                    arrayList2.add(this.a.getUriConfig().getAbUri());
                }
                if (r.d(this.a.getUriConfig().getActiveUri())) {
                    arrayList2.add(this.a.getUriConfig().getActiveUri());
                }
                if (r.d(this.a.getUriConfig().getSettingUri())) {
                    arrayList2.add(this.a.getUriConfig().getSettingUri());
                }
                if (r.d(this.a.getUriConfig().getBusinessUri())) {
                    arrayList2.add(this.a.getUriConfig().getBusinessUri());
                }
                if (r.d(this.a.getUriConfig().getProfileUri())) {
                    arrayList2.add(this.a.getUriConfig().getProfileUri());
                }
                if (r.d(this.a.getUriConfig().getReportOaidUri())) {
                    arrayList2.add(this.a.getUriConfig().getReportOaidUri());
                }
                if (r.d(this.a.getUriConfig().getAlinkAttributionUri())) {
                    arrayList2.add(this.a.getUriConfig().getAlinkAttributionUri());
                }
                if (r.d(this.a.getUriConfig().getAlinkQueryUri())) {
                    arrayList2.add(this.a.getUriConfig().getAlinkQueryUri());
                }
                strJoin = TextUtils.join("、", arrayList2);
            } else {
                strJoin = "SaaS 默认";
            }
            jSONObject2.put("服务域名配置", strJoin);
            jSONObject.put(Constants.PATH_CONFIG, jSONObject2);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
