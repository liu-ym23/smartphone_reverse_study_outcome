package com.stepos.core.common.cloud;

import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.error.AIEngineError;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CloudErrorUserMessage {
    public static final String MSG_CTA_NOT_GRANTED_DURING_SETUP = "检测到AI引擎相关系统增强服务未开启，请您前往增强服务页开启";
    private static final String TAG = "CloudErrorUserMessage";
    public static final CloudErrorUserMessage INSTANCE = new CloudErrorUserMessage();
    public static final String MSG_CTA_NOT_GRANTED_POST_SETUP = "检测到AI引擎相关系统增强服务未开启，请您前往设置-通用-系统增强服务开启";
    private static final Map<Integer, String> MESSAGES = kotlin.collections.b.g0(new Pair(Integer.valueOf(AIEngineError.CLOUD_ENDPOINT_NOT_CONFIGURED), "服务暂不可用"), new Pair(Integer.valueOf(AIEngineError.CLOUD_AUTH_FAILED), "获取账号授权失败"), new Pair(Integer.valueOf(AIEngineError.CLOUD_INSUFFICIENT_BALANCE), "服务暂不可用"), new Pair(Integer.valueOf(AIEngineError.CLOUD_NETWORK_UNAVAILABLE), "网络错误，请先连接网络"), new Pair(Integer.valueOf(AIEngineError.CLOUD_NETWORK_ERROR), "网络错误，请先连接网络"), new Pair(Integer.valueOf(AIEngineError.CLOUD_REQUEST_TIMEOUT), "网络超时，请稍后重试"), new Pair(Integer.valueOf(AIEngineError.CLOUD_STREAM_TRUNCATED), "网络不稳定，结果不完整，请稍后重试"), new Pair(Integer.valueOf(AIEngineError.CLOUD_SERVER_ERROR), "服务异常，请稍后重试"), new Pair(Integer.valueOf(AIEngineError.CLOUD_TASK_FAILED), "服务异常，请稍后重试"), new Pair(Integer.valueOf(AIEngineError.CLOUD_QUOTA_EXCEEDED), "服务繁忙，请稍后重试"), new Pair(Integer.valueOf(AIEngineError.CLOUD_TOKEN_TEMP_UNAVAILABLE), "网络异常，请稍后重试"), new Pair(Integer.valueOf(AIEngineError.CLOUD_RESPONSE_INVALID), "服务异常"), new Pair(Integer.valueOf(AIEngineError.CLOUD_INVALID_REQUEST), "请求异常"), new Pair(Integer.valueOf(AIEngineError.CLOUD_RISK_BLOCKED), "内容不合规，请更换后重试"), new Pair(Integer.valueOf(AIEngineError.INPUT_AUDIO_SIZE_TOO_LARGE), "音频文件过大，请更换更小的音频"), new Pair(Integer.valueOf(AIEngineError.INPUT_AUDIO_FORMAT_UNSUPPORTED), "音频格式不支持，请更换后重试"), new Pair(Integer.valueOf(AIEngineError.INPUT_AUDIO_DURATION_UNKNOWN), "音频文件异常，请更换后重试"), new Pair(Integer.valueOf(AIEngineError.ABILITY_DISABLED), "该功能当前不可用"), new Pair(Integer.valueOf(AIEngineError.LOCAL_MODEL_DISABLED), "该功能当前不可用"), new Pair(Integer.valueOf(AIEngineError.CLOUD_MODEL_DISABLED), "该功能当前不可用"), new Pair(Integer.valueOf(AIEngineError.CTA_NOT_GRANTED), MSG_CTA_NOT_GRANTED_POST_SETUP), new Pair(Integer.valueOf(AIEngineError.CLOUD_SCENE_TYPE_NOT_PERMITTED), "未开通云端场景权限，请向 AIEngine 业务申请 scene_type（需提供包名与调用接口）"));
    private static final ConcurrentHashMap.KeySetView<Integer, Boolean> warnedMissing = ConcurrentHashMap.newKeySet();

    private CloudErrorUserMessage() {
    }

    public final boolean has(int i10) {
        return MESSAGES.containsKey(Integer.valueOf(i10));
    }

    public final String of(int i10) {
        String str = MESSAGES.get(Integer.valueOf(i10));
        if (str != null) {
            return str;
        }
        if (warnedMissing.add(Integer.valueOf(i10))) {
            AIEngineLogger.w(LogModule.ABILITY, TAG, "no user-facing message registered for code=" + i10 + "; business will see the English engine text. Register it in MESSAGES (see class KDoc constraint #5).");
        }
        return AIEngineError.INSTANCE.getMessage(i10);
    }

    public final String ofCtaNotGranted(boolean z) {
        return z ? MSG_CTA_NOT_GRANTED_POST_SETUP : MSG_CTA_NOT_GRANTED_DURING_SETUP;
    }

    public final String orElse(int i10, String fallback) {
        kotlin.jvm.internal.g.f(fallback, "fallback");
        String str = MESSAGES.get(Integer.valueOf(i10));
        return str == null ? fallback : str;
    }
}
