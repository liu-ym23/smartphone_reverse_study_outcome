package com.bytedance.android.livesdkapi.roomplayer;

import android.net.Uri;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.player.utils.c;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.android.livesdkapi.model.AdaptiveGradingRequest;
import com.bytedance.android.livesdkapi.model.AesBoostConfig;
import com.bytedance.android.livesdkapi.model.AudioFirst;
import com.bytedance.android.livesdkapi.model.AudioFrameDrop;
import com.bytedance.android.livesdkapi.model.LiveStreamType;
import com.bytedance.android.livesdkapi.model.P2PSuggestInfo;
import com.bytedance.android.livesdkapi.model.PlayerSpeedRangeParams;
import com.bytedance.android.livesdkapi.model.RealTimeIP;
import com.bytedance.android.livesdkapi.model.SharpenParams;
import com.bytedance.android.livesdkapi.model.StreamSrConfig;
import com.bytedance.android.livesdkapi.model.SuperResolutionConfig;
import com.bytedance.android.livesdkapi.model.SvcParams;
import com.bytedance.android.livesdkapi.vr.LiveVrEffectInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0004Û\u0001Ü\u0001B\u0099\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0003¢\u0006\u0002\u0010\u001bJ\u0019\u0010Õ\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010X\u001a\u0004\u0018\u00010\u0003J)\u0010Ö\u0001\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0014\u0010×\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020t0Ø\u0001H\u0002J&\u0010Ù\u0001\u001a\u00020\u000b2\u0007\u0010Ú\u0001\u001a\u00020\u00002\u0014\u0010×\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020t0Ø\u0001R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u000101X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u0010\u000f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00107\"\u0004\b@\u00109R\u001a\u0010\u0017\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u00107\"\u0004\bB\u00109R\u001a\u0010C\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00107\"\u0004\bE\u00109R\u001a\u0010\u001a\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010GR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010GR \u0010L\u001a\b\u0012\u0004\u0012\u00020\u000b0MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010\r\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u00107\"\u0004\bS\u00109R \u0010T\u001a\b\u0012\u0004\u0012\u00020\u000b0MX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010O\"\u0004\bU\u0010QR\u001a\u0010V\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00107\"\u0004\bW\u00109R\u001c\u0010X\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010G\"\u0004\bZ\u0010IR\u001c\u0010[\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010G\"\u0004\b]\u0010IR\u001a\u0010^\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u00107\"\u0004\b`\u00109R\u001a\u0010a\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010'\"\u0004\bc\u0010)R\u001a\u0010\u000e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00107\"\u0004\be\u00109R\u001a\u0010f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u00107\"\u0004\bh\u00109R\u001a\u0010i\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u00107\"\u0004\bk\u00109R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bl\u00107R\u001c\u0010m\u001a\u0004\u0018\u00010nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\u001c\u0010s\u001a\u0004\u0018\u00010tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001c\u0010y\u001a\u0004\u0018\u00010zX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u001b\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u00107\"\u0005\b\u0080\u0001\u00109R\u001f\u0010\u0081\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\"\u0010\u0086\u0001\u001a\u0005\u0018\u00010\u0087\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R\u001c\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010G\"\u0005\b\u008d\u0001\u0010IR\u001f\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010G\"\u0005\b\u0090\u0001\u0010IR\u001d\u0010\u0091\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u00107\"\u0005\b\u0093\u0001\u00109R\u001f\u0010\u0094\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0083\u0001\"\u0006\b\u0096\u0001\u0010\u0085\u0001R\"\u0010\u0097\u0001\u001a\u0005\u0018\u00010\u0098\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R\"\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\"\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R\u0012\u0010\u0002\u001a\u00020\u0003¢\u0006\t\n\u0000\u001a\u0005\b©\u0001\u0010GR\u001e\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010«\u0001\"\u0006\b¬\u0001\u0010\u00ad\u0001R\"\u0010®\u0001\u001a\u0005\u0018\u00010¯\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b°\u0001\u0010±\u0001\"\u0006\b²\u0001\u0010³\u0001R\"\u0010´\u0001\u001a\u0005\u0018\u00010µ\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R\u001e\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bº\u0001\u0010\u0083\u0001\"\u0006\b»\u0001\u0010\u0085\u0001R\u001c\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010G\"\u0005\b½\u0001\u0010IR\"\u0010¾\u0001\u001a\u0005\u0018\u00010¿\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0001\u0010Á\u0001\"\u0006\bÂ\u0001\u0010Ã\u0001R\"\u0010Ä\u0001\u001a\u0005\u0018\u00010Å\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R\u001d\u0010Ê\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bË\u0001\u00107\"\u0005\bÌ\u0001\u00109R\u001f\u0010Í\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÎ\u0001\u0010\u0083\u0001\"\u0006\bÏ\u0001\u0010\u0085\u0001R\u001f\u0010Ð\u0001\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÑ\u0001\u0010\u0083\u0001\"\u0006\bÒ\u0001\u0010\u0085\u0001R\u001c\u0010\u0014\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÓ\u0001\u00107\"\u0005\bÔ\u0001\u00109¨\u0006Ý\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "", "streamData", "", "resolution", "triggerType", "streamType", "Lcom/bytedance/android/livesdkapi/model/LiveStreamType;", "enterLiveSource", "enterType", "preview", "", "openSei", "inBackground", ITTVideoEngineEventSource.KEY_MUTE, "blur", "blurStrength", "", "audioAddr", "", "wormholePrePlay", "textureRenderMode", "", "enableSetAudioAddrAfterPlay", "adaptiveGradingRequest", "Lcom/bytedance/android/livesdkapi/model/AdaptiveGradingRequest;", "enterLiveMethod", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/model/LiveStreamType;Ljava/lang/String;Ljava/lang/String;ZZZZZFJZIZLcom/bytedance/android/livesdkapi/model/AdaptiveGradingRequest;Ljava/lang/String;)V", "getAdaptiveGradingRequest", "()Lcom/bytedance/android/livesdkapi/model/AdaptiveGradingRequest;", "setAdaptiveGradingRequest", "(Lcom/bytedance/android/livesdkapi/model/AdaptiveGradingRequest;)V", "aesBoostConfig", "Lcom/bytedance/android/livesdkapi/model/AesBoostConfig;", "getAesBoostConfig", "()Lcom/bytedance/android/livesdkapi/model/AesBoostConfig;", "setAesBoostConfig", "(Lcom/bytedance/android/livesdkapi/model/AesBoostConfig;)V", "getAudioAddr", "()J", "setAudioAddr", "(J)V", "audioFirst", "Lcom/bytedance/android/livesdkapi/model/AudioFirst;", "getAudioFirst", "()Lcom/bytedance/android/livesdkapi/model/AudioFirst;", "setAudioFirst", "(Lcom/bytedance/android/livesdkapi/model/AudioFirst;)V", "audioFrameDrop", "Lcom/bytedance/android/livesdkapi/model/AudioFrameDrop;", "getAudioFrameDrop", "()Lcom/bytedance/android/livesdkapi/model/AudioFrameDrop;", "setAudioFrameDrop", "(Lcom/bytedance/android/livesdkapi/model/AudioFrameDrop;)V", "getBlur", "()Z", "setBlur", "(Z)V", "getBlurStrength", "()F", "setBlurStrength", "(F)V", "currentIsPrePullStreaming", "getCurrentIsPrePullStreaming", "setCurrentIsPrePullStreaming", "getEnableSetAudioAddrAfterPlay", "setEnableSetAudioAddrAfterPlay", "enableVrRecenter", "getEnableVrRecenter", "setEnableVrRecenter", "getEnterLiveMethod", "()Ljava/lang/String;", "setEnterLiveMethod", "(Ljava/lang/String;)V", "getEnterLiveSource", "getEnterType", "inAnchorInteractMode", "Landroidx/lifecycle/MutableLiveData;", "getInAnchorInteractMode", "()Landroidx/lifecycle/MutableLiveData;", "setInAnchorInteractMode", "(Landroidx/lifecycle/MutableLiveData;)V", "getInBackground", "setInBackground", "isPortrait", "setPortrait", "isSubStream", "setSubStream", "legacyPullUrl", "getLegacyPullUrl", "setLegacyPullUrl", "legacySdkParams", "getLegacySdkParams", "setLegacySdkParams", "manuallyRefresh", "getManuallyRefresh", "setManuallyRefresh", "mobileTrafficThreshold", "getMobileTrafficThreshold", "setMobileTrafficThreshold", "getMute", "setMute", "needRePullStream", "getNeedRePullStream", "setNeedRePullStream", "needRefreshExtraView", "getNeedRefreshExtraView", "setNeedRefreshExtraView", "getOpenSei", "p2pSuggestInfo", "Lcom/bytedance/android/livesdkapi/model/P2PSuggestInfo;", "getP2pSuggestInfo", "()Lcom/bytedance/android/livesdkapi/model/P2PSuggestInfo;", "setP2pSuggestInfo", "(Lcom/bytedance/android/livesdkapi/model/P2PSuggestInfo;)V", "picoInfo", "Lorg/json/JSONObject;", "getPicoInfo", "()Lorg/json/JSONObject;", "setPicoInfo", "(Lorg/json/JSONObject;)V", "playerSpeedRangeParams", "Lcom/bytedance/android/livesdkapi/model/PlayerSpeedRangeParams;", "getPlayerSpeedRangeParams", "()Lcom/bytedance/android/livesdkapi/model/PlayerSpeedRangeParams;", "setPlayerSpeedRangeParams", "(Lcom/bytedance/android/livesdkapi/model/PlayerSpeedRangeParams;)V", "getPreview", "setPreview", "qosConstraintOpt", "getQosConstraintOpt", "()I", "setQosConstraintOpt", "(I)V", "realTimeIP", "Lcom/bytedance/android/livesdkapi/model/RealTimeIP;", "getRealTimeIP", "()Lcom/bytedance/android/livesdkapi/model/RealTimeIP;", "setRealTimeIP", "(Lcom/bytedance/android/livesdkapi/model/RealTimeIP;)V", "getResolution", "setResolution", "resolutionPickStrategy", "getResolutionPickStrategy", "setResolutionPickStrategy", "sharePlayer", "getSharePlayer", "setSharePlayer", "sharpenOption", "getSharpenOption", "setSharpenOption", "sharpenParams", "Lcom/bytedance/android/livesdkapi/model/SharpenParams;", "getSharpenParams", "()Lcom/bytedance/android/livesdkapi/model/SharpenParams;", "setSharpenParams", "(Lcom/bytedance/android/livesdkapi/model/SharpenParams;)V", "srConfig", "Lcom/bytedance/android/livesdkapi/model/StreamSrConfig;", "getSrConfig", "()Lcom/bytedance/android/livesdkapi/model/StreamSrConfig;", "setSrConfig", "(Lcom/bytedance/android/livesdkapi/model/StreamSrConfig;)V", "srScale", "Lcom/bytedance/android/livesdkapi/model/StreamSrConfig$SrScale;", "getSrScale", "()Lcom/bytedance/android/livesdkapi/model/StreamSrConfig$SrScale;", "setSrScale", "(Lcom/bytedance/android/livesdkapi/model/StreamSrConfig$SrScale;)V", "getStreamData", "getStreamType", "()Lcom/bytedance/android/livesdkapi/model/LiveStreamType;", "setStreamType", "(Lcom/bytedance/android/livesdkapi/model/LiveStreamType;)V", "superResolutionConfig", "Lcom/bytedance/android/livesdkapi/model/SuperResolutionConfig;", "getSuperResolutionConfig", "()Lcom/bytedance/android/livesdkapi/model/SuperResolutionConfig;", "setSuperResolutionConfig", "(Lcom/bytedance/android/livesdkapi/model/SuperResolutionConfig;)V", "svcParams", "Lcom/bytedance/android/livesdkapi/model/SvcParams;", "getSvcParams", "()Lcom/bytedance/android/livesdkapi/model/SvcParams;", "setSvcParams", "(Lcom/bytedance/android/livesdkapi/model/SvcParams;)V", "getTextureRenderMode", "setTextureRenderMode", "getTriggerType", "setTriggerType", "vrEffectConfigBuilder", "Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;", "getVrEffectConfigBuilder", "()Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;", "setVrEffectConfigBuilder", "(Lcom/bytedance/android/livesdkapi/roomplayer/VideoEffectInitConfigBuilder;)V", "vrEffectInfo", "Lcom/bytedance/android/livesdkapi/vr/LiveVrEffectInfo;", "getVrEffectInfo", "()Lcom/bytedance/android/livesdkapi/vr/LiveVrEffectInfo;", "setVrEffectInfo", "(Lcom/bytedance/android/livesdkapi/vr/LiveVrEffectInfo;)V", "vrLive", "getVrLive", "setVrLive", "vrStrategy", "getVrStrategy", "setVrStrategy", "vrType", "getVrType", "setVrType", "getWormholePrePlay", "setWormholePrePlay", "forkNewRequestWithStreamDataOrUrl", "getDataFromStream", "getStreamDataObject", "Lkotlin/Function1;", "isSameStream", "liveRequest", "Builder", "TextureRenderMode", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveRequest {
    private AdaptiveGradingRequest adaptiveGradingRequest;
    private AesBoostConfig aesBoostConfig;
    private long audioAddr;
    private AudioFirst audioFirst;
    private AudioFrameDrop audioFrameDrop;
    private boolean blur;
    private float blurStrength;
    private boolean currentIsPrePullStreaming;
    private boolean enableSetAudioAddrAfterPlay;
    private boolean enableVrRecenter;
    private String enterLiveMethod;
    private final String enterLiveSource;
    private final String enterType;
    private MutableLiveData<Boolean> inAnchorInteractMode;
    private boolean inBackground;
    private MutableLiveData<Boolean> isPortrait;
    private boolean isSubStream;
    private String legacyPullUrl;
    private String legacySdkParams;
    private boolean manuallyRefresh;
    private long mobileTrafficThreshold;
    private boolean mute;
    private boolean needRePullStream;
    private boolean needRefreshExtraView;
    private final boolean openSei;
    private P2PSuggestInfo p2pSuggestInfo;
    private JSONObject picoInfo;
    private PlayerSpeedRangeParams playerSpeedRangeParams;
    private boolean preview;
    private int qosConstraintOpt;
    private RealTimeIP realTimeIP;
    private String resolution;
    private String resolutionPickStrategy;
    private boolean sharePlayer;
    private int sharpenOption;
    private SharpenParams sharpenParams;
    private StreamSrConfig srConfig;
    private StreamSrConfig.SrScale srScale;
    private final String streamData;
    private LiveStreamType streamType;
    private SuperResolutionConfig superResolutionConfig;
    private SvcParams svcParams;
    private int textureRenderMode;
    private String triggerType;
    private VideoEffectInitConfigBuilder vrEffectConfigBuilder;
    private LiveVrEffectInfo vrEffectInfo;
    private boolean vrLive;
    private int vrStrategy;
    private int vrType;
    private boolean wormholePrePlay;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\bJ\u0006\u0010'\u001a\u00020(J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0006J\u0010\u0010,\u001a\u00020\u00002\b\u0010,\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\fJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0006J\u000e\u0010.\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u00100\u001a\u00020\u0010J\u0010\u0010 \u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010!J\u0010\u0010\"\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010!J\u0010\u0010#\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u00010!J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\fJ\u000e\u0010%\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0006J\u000e\u00102\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest$Builder;", "", "()V", "audioAddr", "", "blur", "", "blurStrength", "", "enableAdaptiveGrading", "enableSetAudioAddrAfterPlay", "enterLiveMethod", "", "enterLiveSource", "enterType", "gradingBrightness", "", "gradingContrast", "gradingGopTime", "gradingSaturation", "inBackground", "isWormholePrePlay", ITTVideoEngineEventSource.KEY_MUTE, "openSei", "picoInfo_", "Lorg/json/JSONObject;", "preview", "resolution", "streamData", "streamType", "Lcom/bytedance/android/livesdkapi/model/LiveStreamType;", "textureRenderMode", "thresholdBrightness", "", "thresholdContrast", "thresholdSaturation", "triggerType", "vrRecenterEnable", TextureRenderKeys.KEY_IS_STRENGTH_FLOAT, "build", "Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest;", "enable", "value", "time", "picoInfo", "setEnableAudioAddrChange", "setProcessAudioAddr", "data", "mode", "threshold", "wormholePrePlay", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Builder {
        private long audioAddr;
        private boolean blur;
        private float blurStrength;
        private boolean enableAdaptiveGrading;
        private boolean enableSetAudioAddrAfterPlay;
        private String enterLiveMethod;
        private String enterLiveSource;
        private String enterType;
        private int gradingBrightness;
        private int gradingContrast;
        private int gradingGopTime;
        private int gradingSaturation;
        private boolean inBackground;
        private boolean isWormholePrePlay;
        private boolean mute;
        private boolean openSei;
        private JSONObject picoInfo_;
        private boolean preview;
        private String resolution;
        private String streamData;
        private LiveStreamType streamType;
        private int textureRenderMode;
        private float[] thresholdBrightness;
        private float[] thresholdContrast;
        private float[] thresholdSaturation;
        private String triggerType;
        private boolean vrRecenterEnable;

        public final LiveRequest build() {
            AdaptiveGradingRequest r100 = new AdaptiveGradingRequest(this.enableAdaptiveGrading, this.gradingBrightness, this.gradingContrast, this.gradingSaturation, this.thresholdBrightness, this.thresholdContrast, this.thresholdSaturation, this.gradingGopTime);
            LiveRequest r101 = new LiveRequest(this.streamData, this.resolution, this.triggerType, this.streamType, this.enterLiveSource, this.enterType, this.preview, this.openSei, this.inBackground, this.mute, this.blur, this.blurStrength, this.audioAddr, this.isWormholePrePlay, this.textureRenderMode, this.enableSetAudioAddrAfterPlay, r100, this.enterLiveMethod, null);
            r101.setEnableVrRecenter(this.vrRecenterEnable);
            r101.setPicoInfo(this.picoInfo_);
            return r101;
        }

        public Builder() {
            this.streamData = "";
            this.resolution = "";
            this.triggerType = "";
            this.streamType = LiveStreamType.VIDEO;
            this.enterLiveSource = "";
            this.enterType = "";
            this.openSei = true;
            this.blurStrength = 16.0f;
            this.audioAddr = -1;
            this.gradingBrightness = -1;
            this.gradingContrast = -1;
            this.gradingSaturation = -1;
            this.gradingGopTime = 2000;
            this.enterLiveMethod = "";
        }

        public final Builder blur(boolean r100) {
            this.blur = r100;
            return this;
        }

        public final Builder blurStrength(float r100) {
            this.blurStrength = r100;
            return this;
        }

        public final Builder enableAdaptiveGrading(boolean r100) {
            this.enableAdaptiveGrading = r100;
            return this;
        }

        public final Builder enterLiveMethod(String r100) {
            Intrinsics.checkNotNullParameter(r100, "enterLiveMethod");
            this.enterLiveMethod = r100;
            return this;
        }

        public final Builder enterLiveSource(String r100) {
            Intrinsics.checkNotNullParameter(r100, "enterLiveSource");
            this.enterLiveSource = r100;
            return this;
        }

        public final Builder enterType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "enterType");
            this.enterType = r100;
            return this;
        }

        public final Builder gradingBrightness(int r100) {
            if (r100 >= 0) goto L4;
        L5:
            r100 = -1;
        L6:
            this.gradingBrightness = r100;
            return this;
        L4:
            if (r100 <= 255) goto L6;
            goto L5
        }

        public final Builder gradingContrast(int r100) {
            if (r100 >= 0) goto L4;
        L5:
            r100 = -1;
        L6:
            this.gradingContrast = r100;
            return this;
        L4:
            if (r100 <= 100) goto L6;
            goto L5
        }

        public final Builder gradingGopTime(int r100) {
            if (r100 > 0) goto L4;
            r100 = 2000;
        L4:
            this.gradingGopTime = r100;
            return this;
        }

        public final Builder gradingSaturation(int r100) {
            if (r100 >= 0) goto L4;
        L5:
            r100 = -1;
        L6:
            this.gradingSaturation = r100;
            return this;
        L4:
            if (r100 <= 100) goto L6;
            goto L5
        }

        public final Builder inBackground(boolean r100) {
            this.inBackground = r100;
            return this;
        }

        public final Builder mute(boolean r100) {
            this.mute = r100;
            return this;
        }

        public final Builder openSei(boolean r100) {
            this.openSei = r100;
            return this;
        }

        public final Builder picoInfo(JSONObject r100) {
            this.picoInfo_ = r100;
            return this;
        }

        public final Builder preview(boolean r100) {
            this.preview = r100;
            return this;
        }

        public final Builder resolution(String r100) {
            Intrinsics.checkNotNullParameter(r100, "resolution");
            this.resolution = r100;
            return this;
        }

        public final Builder setEnableAudioAddrChange(boolean r100) {
            this.enableSetAudioAddrAfterPlay = r100;
            return this;
        }

        public final Builder setProcessAudioAddr(long r100) {
            this.audioAddr = r100;
            return this;
        }

        public final Builder streamData(String r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.streamData = r100;
            return this;
        }

        public final Builder streamType(LiveStreamType r100) {
            Intrinsics.checkNotNullParameter(r100, "streamType");
            this.streamType = r100;
            return this;
        }

        public final Builder textureRenderMode(@TextureRenderMode int r100) {
            this.textureRenderMode = r100;
            return this;
        }

        public final Builder thresholdBrightness(float[] r100) {
            if (r100 != null) goto L4;
        L8:
            r100 = null;
        L9:
            this.thresholdBrightness = r100;
            return this;
        L4:
            if (r100.length != 2) goto L8;
            if (r100[0] >= r100[1]) goto L8;
            goto L8
        }

        public final Builder thresholdContrast(float[] r100) {
            if (r100 != null) goto L4;
        L8:
            r100 = null;
        L9:
            this.thresholdContrast = r100;
            return this;
        L4:
            if (r100.length != 2) goto L8;
            if (r100[0] >= r100[1]) goto L8;
            goto L8
        }

        public final Builder thresholdSaturation(float[] r100) {
            if (r100 != null) goto L4;
        L8:
            r100 = null;
        L9:
            this.thresholdSaturation = r100;
            return this;
        L4:
            if (r100.length != 2) goto L8;
            if (r100[0] >= r100[1]) goto L8;
            goto L8
        }

        public final Builder triggerType(String r100) {
            Intrinsics.checkNotNullParameter(r100, "triggerType");
            this.triggerType = r100;
            return this;
        }

        public final Builder vrRecenterEnable(boolean r100) {
            this.vrRecenterEnable = r100;
            return this;
        }

        public final Builder wormholePrePlay(boolean r100) {
            this.isWormholePrePlay = r100;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest$TextureRenderMode;", "", "Companion", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TextureRenderMode {
        public static final Companion Companion = null;
        public static final int DISABLE = 2;
        public static final int ENABLE = 1;
        public static final int NONE = 0;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/LiveRequest$TextureRenderMode$Companion;", "", "()V", "DISABLE", "", "ENABLE", UserProfileEvent.POSITION_NONE, "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final int DISABLE = 2;
            public static final int ENABLE = 1;
            public static final int NONE = 0;

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    public final AdaptiveGradingRequest getAdaptiveGradingRequest() {
        return this.adaptiveGradingRequest;
    }

    public final AesBoostConfig getAesBoostConfig() {
        return this.aesBoostConfig;
    }

    public final long getAudioAddr() {
        return this.audioAddr;
    }

    public final AudioFirst getAudioFirst() {
        return this.audioFirst;
    }

    public final AudioFrameDrop getAudioFrameDrop() {
        return this.audioFrameDrop;
    }

    public final boolean getBlur() {
        return this.blur;
    }

    public final float getBlurStrength() {
        return this.blurStrength;
    }

    public final boolean getCurrentIsPrePullStreaming() {
        return this.currentIsPrePullStreaming;
    }

    public final boolean getEnableSetAudioAddrAfterPlay() {
        return this.enableSetAudioAddrAfterPlay;
    }

    public final boolean getEnableVrRecenter() {
        return this.enableVrRecenter;
    }

    public final String getEnterLiveMethod() {
        return this.enterLiveMethod;
    }

    public final String getEnterLiveSource() {
        return this.enterLiveSource;
    }

    public final String getEnterType() {
        return this.enterType;
    }

    public final MutableLiveData<Boolean> getInAnchorInteractMode() {
        return this.inAnchorInteractMode;
    }

    public final boolean getInBackground() {
        return this.inBackground;
    }

    public final String getLegacyPullUrl() {
        return this.legacyPullUrl;
    }

    public final String getLegacySdkParams() {
        return this.legacySdkParams;
    }

    public final boolean getManuallyRefresh() {
        return this.manuallyRefresh;
    }

    public final long getMobileTrafficThreshold() {
        return this.mobileTrafficThreshold;
    }

    public final boolean getMute() {
        return this.mute;
    }

    public final boolean getNeedRePullStream() {
        return this.needRePullStream;
    }

    public final boolean getNeedRefreshExtraView() {
        return this.needRefreshExtraView;
    }

    public final boolean getOpenSei() {
        return this.openSei;
    }

    public final P2PSuggestInfo getP2pSuggestInfo() {
        return this.p2pSuggestInfo;
    }

    public final JSONObject getPicoInfo() {
        return this.picoInfo;
    }

    public final PlayerSpeedRangeParams getPlayerSpeedRangeParams() {
        return this.playerSpeedRangeParams;
    }

    public final boolean getPreview() {
        return this.preview;
    }

    public final int getQosConstraintOpt() {
        return this.qosConstraintOpt;
    }

    public final RealTimeIP getRealTimeIP() {
        return this.realTimeIP;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final String getResolutionPickStrategy() {
        return this.resolutionPickStrategy;
    }

    public final boolean getSharePlayer() {
        return this.sharePlayer;
    }

    public final int getSharpenOption() {
        return this.sharpenOption;
    }

    public final SharpenParams getSharpenParams() {
        return this.sharpenParams;
    }

    public final StreamSrConfig getSrConfig() {
        return this.srConfig;
    }

    public final StreamSrConfig.SrScale getSrScale() {
        return this.srScale;
    }

    public final String getStreamData() {
        return this.streamData;
    }

    public final LiveStreamType getStreamType() {
        return this.streamType;
    }

    public final SuperResolutionConfig getSuperResolutionConfig() {
        return this.superResolutionConfig;
    }

    public final SvcParams getSvcParams() {
        return this.svcParams;
    }

    public final int getTextureRenderMode() {
        return this.textureRenderMode;
    }

    public final String getTriggerType() {
        return this.triggerType;
    }

    public final VideoEffectInitConfigBuilder getVrEffectConfigBuilder() {
        return this.vrEffectConfigBuilder;
    }

    public final LiveVrEffectInfo getVrEffectInfo() {
        return this.vrEffectInfo;
    }

    public final boolean getVrLive() {
        return this.vrLive;
    }

    public final int getVrStrategy() {
        return this.vrStrategy;
    }

    public final int getVrType() {
        return this.vrType;
    }

    public final boolean getWormholePrePlay() {
        return this.wormholePrePlay;
    }

    public final MutableLiveData<Boolean> isPortrait() {
        return this.isPortrait;
    }

    public final boolean isSubStream() {
        return this.isSubStream;
    }

    public final void setAdaptiveGradingRequest(AdaptiveGradingRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.adaptiveGradingRequest = r100;
    }

    public final void setAesBoostConfig(AesBoostConfig r100) {
        this.aesBoostConfig = r100;
    }

    public final void setAudioAddr(long r100) {
        this.audioAddr = r100;
    }

    public final void setAudioFirst(AudioFirst r100) {
        this.audioFirst = r100;
    }

    public final void setAudioFrameDrop(AudioFrameDrop r100) {
        this.audioFrameDrop = r100;
    }

    public final void setBlur(boolean r100) {
        this.blur = r100;
    }

    public final void setBlurStrength(float r100) {
        this.blurStrength = r100;
    }

    public final void setCurrentIsPrePullStreaming(boolean r100) {
        this.currentIsPrePullStreaming = r100;
    }

    public final void setEnableSetAudioAddrAfterPlay(boolean r100) {
        this.enableSetAudioAddrAfterPlay = r100;
    }

    public final void setEnableVrRecenter(boolean r100) {
        this.enableVrRecenter = r100;
    }

    public final void setEnterLiveMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterLiveMethod = r100;
    }

    public final void setInAnchorInteractMode(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.inAnchorInteractMode = r100;
    }

    public final void setInBackground(boolean r100) {
        this.inBackground = r100;
    }

    public final void setLegacyPullUrl(String r100) {
        this.legacyPullUrl = r100;
    }

    public final void setLegacySdkParams(String r100) {
        this.legacySdkParams = r100;
    }

    public final void setManuallyRefresh(boolean r100) {
        this.manuallyRefresh = r100;
    }

    public final void setMobileTrafficThreshold(long r100) {
        this.mobileTrafficThreshold = r100;
    }

    public final void setMute(boolean r100) {
        this.mute = r100;
    }

    public final void setNeedRePullStream(boolean r100) {
        this.needRePullStream = r100;
    }

    public final void setNeedRefreshExtraView(boolean r100) {
        this.needRefreshExtraView = r100;
    }

    public final void setP2pSuggestInfo(P2PSuggestInfo r100) {
        this.p2pSuggestInfo = r100;
    }

    public final void setPicoInfo(JSONObject r100) {
        this.picoInfo = r100;
    }

    public final void setPlayerSpeedRangeParams(PlayerSpeedRangeParams r100) {
        this.playerSpeedRangeParams = r100;
    }

    public final void setPortrait(MutableLiveData<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.isPortrait = r100;
    }

    public final void setPreview(boolean r100) {
        this.preview = r100;
    }

    public final void setQosConstraintOpt(int r100) {
        this.qosConstraintOpt = r100;
    }

    public final void setRealTimeIP(RealTimeIP r100) {
        this.realTimeIP = r100;
    }

    public final void setResolution(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resolution = r100;
    }

    public final void setResolutionPickStrategy(String r100) {
        this.resolutionPickStrategy = r100;
    }

    public final void setSharePlayer(boolean r100) {
        this.sharePlayer = r100;
    }

    public final void setSharpenOption(int r100) {
        this.sharpenOption = r100;
    }

    public final void setSharpenParams(SharpenParams r100) {
        this.sharpenParams = r100;
    }

    public final void setSrConfig(StreamSrConfig r100) {
        this.srConfig = r100;
    }

    public final void setSrScale(StreamSrConfig.SrScale r100) {
        this.srScale = r100;
    }

    public final void setStreamType(LiveStreamType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.streamType = r100;
    }

    public final void setSubStream(boolean r100) {
        this.isSubStream = r100;
    }

    public final void setSuperResolutionConfig(SuperResolutionConfig r100) {
        this.superResolutionConfig = r100;
    }

    public final void setSvcParams(SvcParams r100) {
        this.svcParams = r100;
    }

    public final void setTextureRenderMode(int r100) {
        this.textureRenderMode = r100;
    }

    public final void setTriggerType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.triggerType = r100;
    }

    public final void setVrEffectConfigBuilder(VideoEffectInitConfigBuilder r100) {
        this.vrEffectConfigBuilder = r100;
    }

    public final void setVrEffectInfo(LiveVrEffectInfo r100) {
        this.vrEffectInfo = r100;
    }

    public final void setVrLive(boolean r100) {
        this.vrLive = r100;
    }

    public final void setVrStrategy(int r100) {
        this.vrStrategy = r100;
    }

    public final void setVrType(int r100) {
        this.vrType = r100;
    }

    public final void setWormholePrePlay(boolean r100) {
        this.wormholePrePlay = r100;
    }

    private final String getDataFromStream(String r100, Function1<? super String, ? extends JSONObject> r101) {
        JSONObject r102 = r101.invoke(r100).optJSONObject("data");     // Catch: Exception -> L8
        if (r102 == null) goto L11;
        return r102.toString();
    L11:
        return null;
    L12:
        return null;
    }

    public final LiveRequest forkNewRequestWithStreamDataOrUrl(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "streamData");
        Builder r102 = new Builder();
        r102.blur(this.blur).blurStrength(this.blurStrength).enterLiveSource(this.enterLiveSource).enterType(this.enterType).inBackground(this.inBackground).mute(this.mute).openSei(this.openSei).preview(this.preview).resolution(this.resolution).streamData(r100).streamType(this.streamType).textureRenderMode(this.textureRenderMode).triggerType(this.triggerType).setProcessAudioAddr(this.audioAddr).wormholePrePlay(this.wormholePrePlay).setEnableAudioAddrChange(this.enableSetAudioAddrAfterPlay).vrRecenterEnable(this.enableVrRecenter).picoInfo(this.picoInfo).gradingBrightness(this.adaptiveGradingRequest.getTargetBrightness()).gradingContrast(this.adaptiveGradingRequest.getTargetContrast()).gradingSaturation(this.adaptiveGradingRequest.getTargetSaturation()).enableAdaptiveGrading(this.adaptiveGradingRequest.getEnable()).gradingGopTime(this.adaptiveGradingRequest.getGopTime()).thresholdBrightness(this.adaptiveGradingRequest.getThresholdBrightness()).thresholdContrast(this.adaptiveGradingRequest.getThresholdContrast()).thresholdSaturation(this.adaptiveGradingRequest.getThresholdSaturation()).enterLiveMethod(this.enterLiveMethod);
        LiveRequest r103 = r102.build();
        r103.sharePlayer = this.sharePlayer;
        r103.legacyPullUrl = r101;
        r103.legacySdkParams = this.legacySdkParams;
        r103.srConfig = this.srConfig;
        r103.aesBoostConfig = this.aesBoostConfig;
        r103.superResolutionConfig = this.superResolutionConfig;
        r103.needRePullStream = this.needRePullStream;
        r103.isPortrait = this.isPortrait;
        r103.inAnchorInteractMode = this.inAnchorInteractMode;
        r103.vrLive = this.vrLive;
        r103.vrType = this.vrType;
        r103.enableVrRecenter = this.enableVrRecenter;
        r103.picoInfo = this.picoInfo;
        r103.srScale = this.srScale;
        r103.qosConstraintOpt = this.qosConstraintOpt;
        r103.sharpenOption = this.sharpenOption;
        r103.needRefreshExtraView = this.needRefreshExtraView;
        r103.mobileTrafficThreshold = this.mobileTrafficThreshold;
        r103.manuallyRefresh = this.manuallyRefresh;
        r103.sharpenParams = this.sharpenParams;
        r103.svcParams = this.svcParams;
        r103.resolutionPickStrategy = this.resolutionPickStrategy;
        r103.realTimeIP = this.realTimeIP;
        r103.audioFirst = this.audioFirst;
        r103.audioFrameDrop = this.audioFrameDrop;
        return r103;
    }

    public final boolean isSameStream(LiveRequest r100, Function1<? super String, ? extends JSONObject> r101) {
        Intrinsics.checkNotNullParameter(r100, "liveRequest");
        Intrinsics.checkNotNullParameter(r101, "getStreamDataObject");
        if ((!StringsKt.isBlank(this.streamData)) == true) goto L5;
        Uri r102 = UriProtector.parse(this.legacyPullUrl);     // Catch: Exception -> L32
        Uri r103 = UriProtector.parse(r100.legacyPullUrl);     // Catch: Exception -> L32
        int r104 = c.f85851a;     // Catch: Exception -> L32
        String r105 = null;
        if (r102 == null) goto L12;
        String r106 = r102.getHost();     // Catch: Exception -> L32
    L13:
        if (r102 == null) goto L15;
        String r107 = r102.getPath();     // Catch: Exception -> L32
    L16:
        String r108 = Intrinsics.stringPlus(r106, r107);     // Catch: Exception -> L32
        if (r103 == null) goto L19;
        String r109 = r103.getHost();     // Catch: Exception -> L32
    L20:
        if (r103 == null) goto L22;
        r105 = r103.getPath();     // Catch: Exception -> L32
    L22:
        String r110 = Intrinsics.stringPlus(r109, r105);     // Catch: Exception -> L32
        Intrinsics.checkNotNullParameter(r110, "s2");     // Catch: Exception -> L32
        if (c.a(r108) == true) goto L25;
    L26:
        if (r108 == null) goto L30;
        if (Intrinsics.areEqual(r108, r110) == false) goto L30;
        return true;
    L30:
        return false;
    L25:
        if (c.a(r110) == false) goto L26;
        return true;
    L19:
        r109 = null;
        goto L20
    L15:
        r107 = null;
        goto L16
    L12:
        r106 = null;
    L39:
        return true;
    L5:
        if (Intrinsics.areEqual(this.streamData, r100.streamData) == false) goto L7;
        return true;
    L7:
        if (Intrinsics.areEqual(getDataFromStream(this.streamData, r101), getDataFromStream(r100.streamData, r101)) == false) goto L30;
        return true;
    }

    private LiveRequest(String r100, String r101, String r102, LiveStreamType r103, String r104, String r105, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, float r115, long r116, boolean r117, @TextureRenderMode int r118, boolean r210, AdaptiveGradingRequest r211, String r212) {
        this.streamData = r100;
        this.resolution = r101;
        this.triggerType = r102;
        this.streamType = r103;
        this.enterLiveSource = r104;
        this.enterType = r105;
        this.preview = r110;
        this.openSei = r111;
        this.inBackground = r112;
        this.mute = r113;
        this.blur = r114;
        this.blurStrength = r115;
        this.audioAddr = r116;
        this.wormholePrePlay = r117;
        this.textureRenderMode = r118;
        this.enableSetAudioAddrAfterPlay = r210;
        this.adaptiveGradingRequest = r211;
        this.enterLiveMethod = r212;
        MutableLiveData<Boolean> r106 = new MutableLiveData();
        r106.setValue(Boolean.TRUE);
        Unit r107 = Unit.INSTANCE;
        this.isPortrait = r106;
        MutableLiveData<Boolean> r108 = new MutableLiveData();
        r108.setValue(Boolean.FALSE);
        this.inAnchorInteractMode = r108;
        this.sharpenOption = -1;
        this.mobileTrafficThreshold = -1;
        this.resolutionPickStrategy = "-1";
    }

    public /* synthetic */ LiveRequest(String r100, String r101, String r102, LiveStreamType r103, String r104, String r105, boolean r106, boolean r107, boolean r108, boolean r110, boolean r111, float r112, long r113, boolean r114, int r115, boolean r116, AdaptiveGradingRequest r117, String r118, DefaultConstructorMarker r210) {
        this(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }
}
