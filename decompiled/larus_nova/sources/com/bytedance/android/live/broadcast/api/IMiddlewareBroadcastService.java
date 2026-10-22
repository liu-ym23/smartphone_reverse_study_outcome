package com.bytedance.android.live.broadcast.api;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.broadcast.api.model.o0;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import m00.c;
import m00.e;
import m00.g;
import m00.h;
import nz.u;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u0000 c2\u00020\u0001:\u0001dJ\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0007H&J@\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J(\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u000bH&J\u0010\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0003H&J$\u0010$\u001a\u00020#2\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\"\u001a\u00020\u0003H&J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0003H&J\u001b\u0010'\u001a\u00020\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b'\u0010(J\u001b\u0010)\u001a\u00020\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b)\u0010(J\b\u0010*\u001a\u00020\u0005H&J\u001b\u0010+\u001a\u00020\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b+\u0010(J\b\u0010,\u001a\u00020\u0005H&J#\u0010+\u001a\u00020\u00052\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010-\u001a\u00020\u000bH&¢\u0006\u0004\b+\u0010.J\b\u0010/\u001a\u00020\u0003H&J\b\u00100\u001a\u00020\u0007H&J\u0012\u00103\u001a\u00020\u00072\b\u00102\u001a\u0004\u0018\u000101H&J0\u0010:\u001a\u00020\u00052\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u00108\u001a\u0002042\u0006\u00109\u001a\u00020\u0003H&J@\u0010>\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u000b2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u00108\u001a\u0002042\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0003H&J\n\u0010?\u001a\u0004\u0018\u00010\u000bH&J\b\u0010@\u001a\u00020\u0007H&J|\u0010P\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010A2\b\u0010D\u001a\u0004\u0018\u00010C2\b\u0010F\u001a\u0004\u0018\u00010E2\b\u0010G\u001a\u0004\u0018\u00010\u00192\b\u0010I\u001a\u0004\u0018\u00010H2\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u0005\u0018\u00010J2#\u0010O\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u00020\u0005\u0018\u00010JH&¢\u0006\u0004\bP\u0010QJ\b\u0010R\u001a\u00020\u0007H&J\n\u0010T\u001a\u0004\u0018\u00010SH&J\u0012\u0010V\u001a\u0004\u0018\u00010U2\u0006\u0010\n\u001a\u00020\tH&J0\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H&J7\u0010a\u001a\u0004\u0018\u00010`2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\\\u001a\u0004\u0018\u00010\u00192\b\u0010]\u001a\u0004\u0018\u00010\u000b2\u0006\u0010_\u001a\u00020^H&¢\u0006\u0004\ba\u0010b¨\u0006e"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/IMiddlewareBroadcastService;", "Lcom/bytedance/android/live/base/IService;", "Lio/reactivex/Observable;", "", "loadShortVideoRes", "", "init", "", "isAudienceCasting", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "liveCoreSettings", "isVideo", "supportStickerGift", "needStartAudioCaptureOnInit", "Lm00/g$a;", "onVideoCaptureModelCallback", "Lm00/g;", "createVideoTalkView", "Lm00/h;", "createVoiceRoomVideoView", "Ln00/a;", "broadcastFloatWindowManager", "itemType", "", "itemID", "eventSceneType", "extra", "justReportRoomEvent", "scene", "shouldShowGuidePromptBubble", "Lcom/bytedance/android/live/pushstream/d;", "liveStream", "type", "Lm00/e;", "createLinkInRoomView", "markPopupShown", "source", "resumeCast", "(Ljava/lang/Integer;)V", "pauseCast", "minimizeCast", "stopCast", "releaseCastService", "appId", "(Ljava/lang/Integer;Ljava/lang/String;)V", "getCastingType", "isCasting", "Lcom/bytedance/android/live/broadcast/api/model/t;", "castOptions", "startCast", "", "left", "top", "right", "bottom", "zOrder", "updateOriginalStreamCastSize", "pluginId", "width", "height", "updateCastSize", "getLiveCoreVersion", "isPlayingGame", "Landroidx/fragment/app/FragmentActivity;", "activity", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;", "liveMode", "gameCategory", "Lgz/b;", "inputPoiStruct", "Lkotlin/Function1;", "poiChangeCallback", "Lkotlin/ParameterName;", "name", "isNewRoomIntroOn", "onRoomIntroChangeCallback", "openRoomIntroDialog", "(Landroidx/fragment/app/FragmentActivity;Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;Lcom/bytedance/android/livesdkapi/depend/model/live/LiveMode;Ljava/lang/Long;Lgz/b;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "hasPoiPermission", "Lnz/u;", "linkEffectHelper", "Lm00/c;", "createDigitAvatarPreView", "Lm00/d$a;", "config", "liveCoreSetting", "Lm00/d;", "createLinkVideoView", "componentType", "sourcePage", "Lcom/bytedance/android/live/broadcast/api/model/o0;", "callback", "Lio/reactivex/disposables/Disposable;", "checkToolbarPermission", "(Landroid/content/Context;Ljava/lang/Long;Ljava/lang/String;Lcom/bytedance/android/live/broadcast/api/model/o0;)Lio/reactivex/disposables/Disposable;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareBroadcastService extends IService {
    public static final a Companion = null;
    public static final int TYPE_LINK_IN_ROOM_VIEW_RADIO = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f58966a = null;

        public a() {
        }

        static {
            f58966a = new a();
        }
    }

    public static final class b {
        public static /* synthetic */ void a(IMiddlewareBroadcastService r100) {
            r100.resumeCast(0);
        }

        public static /* synthetic */ void b(IMiddlewareBroadcastService r100) {
            r100.stopCast(0);
        }
    }

    static {
        Companion = a.f58966a;
    }

    n00.a broadcastFloatWindowManager();

    Disposable checkToolbarPermission(Context r100, Long r101, String r102, o0 r103);

    c createDigitAvatarPreView(Context r100);

    e createLinkInRoomView(d r100, Context r101, int r102);

    m00.d createLinkVideoView(Context r100, m00.d.a r101, String r102, boolean r103);

    g createVideoTalkView(Context r100, String r101, boolean r102, boolean r103, boolean r104, g.a r105);

    h createVoiceRoomVideoView(Context r100, String r101);

    int getCastingType();

    String getLiveCoreVersion();

    boolean hasPoiPermission();

    void init();

    boolean isAudienceCasting();

    boolean isCasting();

    boolean isPlayingGame();

    void justReportRoomEvent(int r100, long r101, int r102, String r103);

    u linkEffectHelper();

    Observable<Integer> loadShortVideoRes();

    void markPopupShown(int r100);

    void minimizeCast();

    void openRoomIntroDialog(FragmentActivity r100, IRoom r101, LiveMode r102, Long r103, gz.b r104, Function1<? super gz.b, Unit> r105, Function1<? super Boolean, Unit> r106);

    void pauseCast(Integer r100);

    void releaseCastService();

    void resumeCast(Integer r100);

    boolean shouldShowGuidePromptBubble(int r100);

    boolean startCast(t r100);

    void stopCast(Integer r100);

    void stopCast(Integer r100, String r101);

    void updateCastSize(String r100, float r101, float r102, float r103, float r104, int r105, int r106);

    void updateOriginalStreamCastSize(float r100, float r101, float r102, float r103, int r104);
}
