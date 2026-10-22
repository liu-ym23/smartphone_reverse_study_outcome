package com.bytedance.android.live.liveinteract.bgComponent.theme.audioScene;

import am2.x;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.ui.p;
import com.bytedance.android.livesdk.chatroom.interact.model.d0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.live.datacontext.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import je0.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0007\u0018\u0000 +2\u00020\u0001:\u0001,B\u000f\u0012\u0006\u0010'\u001a\u00020\u0006¢\u0006\u0004\b)\u0010*J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\"\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J.\u0010\u0017\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\u0019\u001a\u00020\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u001a\u0010\u001a\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001e\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u001f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010 \u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/bytedance/android/live/liveinteract/bgComponent/theme/audioScene/AudioLiveThemeReporter;", "Lcom/bytedance/android/live/ui/p;", "", "duration", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "newTheme", "", "isChange", "", "reportThemeDuration", "calculateDuration", "theme", "fromStart", "collectDurationParams", "", "", "collectAnchorParams", "collectAudienceParams", "reportAudienceThemeThemeDuration", "reportAnchorThemeSelectDuration", "params", "", "bgType", "putLiveTypeAndFunctionTypes", "type", "putFormatType", "logThemeShowWhenEnterRoom", "Lcom/bytedance/android/livesdkapi/depend/model/live/IRoom;", "room", "getCurrentPlayModesFromRoom", "onThemeStart", "onThemeChanged", "onThemeEnd", DyPayConstant.KEY_START_TIME, "J", "lastTheme", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "cachedParams", "Ljava/util/Map;", "isAnchor", "Z", "<init>", "(Z)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudioLiveThemeReporter implements p {
    public static final a Companion = null;
    private static final Lazy reporter$delegate = null;
    private final Map<String, String> cachedParams;
    private boolean isAnchor;
    private IVoiceLiveTheme lastTheme;
    private long startTime;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        reporter$delegate = LazyKt.lazy(AudioLiveThemeReporter$Companion$reporter$2.INSTANCE);
    }

    private final long calculateDuration() {
        if (this.startTime > 0) goto L5;
        return 0;
    L5:
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    public static final /* synthetic */ Lazy access$getReporter$cp() {
        return reporter$delegate;
    }

    public AudioLiveThemeReporter(boolean r100) {
        this.isAnchor = r100;
        this.cachedParams = new LinkedHashMap();
    }

    public static final /* synthetic */ boolean access$isAnchor$p(AudioLiveThemeReporter r100) {
        return r100.isAnchor;
    }

    private final Map<String, String> collectAnchorParams(IVoiceLiveTheme r100) {
        LinkedHashMap r101 = new LinkedHashMap();
        if (r100 == null) goto L6;
        String r102 = r100.getImageUri();
        if (r102 == null) goto L6;
    L7:
        r101.put("pic_uri", r102);
        if (r100 == null) goto L10;
        Long r103 = Long.valueOf(r100.getId());
    L11:
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, String.valueOf(r103));
        if (r100 == null) goto L14;
        int r104 = r100.getBgType();
    L15:
        putLiveTypeAndFunctionTypes(r101, r104, r100);
        if (r100 == null) goto L18;
        int r105 = r100.getFormatType();
    L19:
        putFormatType(r101, r105);
        r101.put(FastStartLiveConfig.PLAY_MODE, w.a());
        return r101;
    L18:
        r105 = 0;
        goto L19
    L14:
        r104 = 2;
        goto L15
    L10:
        r103 = null;
    L6:
        r102 = "";
        goto L7
    }

    private final String getCurrentPlayModesFromRoom(IRoom r110) {
        ArrayList r100 = new ArrayList();
        if (r110 == null) goto L15;
        z5 r111 = r110.getLinkerDetail();
        if (r111 == null) goto L15;
        List<Long> r112 = r111.getPlayModes();
        if (r112 == null) goto L15;
        Iterator<T> r113 = r112.iterator();
    L10:
        if (r113.hasNext() == false) goto L15;
        String r101 = u0.k((int) ((Number) r113.next()).longValue());
        if ((!Intrinsics.areEqual(r101, "normal")) == false) goto L10;
        r100.add(r101);
    L15:
        if (d.f() != 16) goto L18;
        r100.add("link_room");
    L18:
        if (r100.size() != 0) goto L21;
        r100.add("normal");
    L21:
        return CollectionsKt.joinToString$default(r100, ",", "[", "]", 0, null, null, 56, null);
    }

    @Override // com.bytedance.android.live.ui.p
    public void onThemeChanged(IVoiceLiveTheme r110) {
        if (r110 != null) goto L5;
    L36:
        if (r110 == null) goto L39;
        r110.setChoosing(false);
        return;
    L39:
        return;
    L5:
        if (r110.getChoosing() == true) goto L36;
        if (r110.getBgType() == 2) goto L15;
        if (r110.getBgType() == 5) goto L15;
        if (r110.getBgType() == 100) goto L15;
        return;
    L15:
        if (Intrinsics.areEqual(this.lastTheme, r110) == false) goto L18;
        return;
    L18:
        if (this.isAnchor == true) goto L30;
        int r100 = r110.getBgType();
        int r101 = c.f71737a;
        LinkedHashMap r102 = new LinkedHashMap();
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, String.valueOf(r110.getId()));
        String r103 = r110.getImageUri();
        String r104 = "";
        if (r103 != null) goto L22;
        r103 = "";
    L22:
        r102.put("pic_uri", r103);
        int r105 = r110.getFormatType();
        if (r105 == 1) goto L27;
        if (r105 != 2) goto L28;
        r104 = "dynamic";
    L28:
        r102.put(com.bytedance.android.ec.core.event.a.KEY_PIC_TYPE, r104);
        c.d(r102, r100);
        r102.put(FastStartLiveConfig.PLAY_MODE, w.a());
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, String.valueOf(r110.getId()));
        j0.l().sendLog("livesdk_live_theme_show", r102, new Object[]{IRoom.class, x.class});
    L34:
        reportThemeDuration(calculateDuration(), r110, true);
        this.startTime = SystemClock.elapsedRealtime();
        this.lastTheme = r110;
        collectDurationParams(r110, false);
        return;
    L27:
        r104 = "static";
        goto L28
    L30:
        if (this.lastTheme == null) goto L32;
        boolean r106 = true;
    L33:
        c.b(r110, r106, r110.getBgType());
        goto L34
    L32:
        r106 = false;
        goto L33
    }

    @Override // com.bytedance.android.live.ui.p
    public void onThemeEnd(IVoiceLiveTheme r100) {
        reportThemeDuration(calculateDuration(), r100, false);
        this.lastTheme = null;
        this.startTime = 0;
        this.cachedParams.clear();
    }

    @Override // com.bytedance.android.live.ui.p
    public void onThemeStart(IVoiceLiveTheme r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getBgType() == 2) goto L12;
        if (r100.getBgType() == 5) goto L12;
        if (r100.getBgType() == 100) goto L12;
        return;
    L12:
        if (this.isAnchor == true) goto L15;
        logThemeShowWhenEnterRoom(r100, r100.getBgType());
    L19:
        this.startTime = SystemClock.elapsedRealtime();
        this.lastTheme = r100;
        collectDurationParams(r100, true);
        return;
    L15:
        if (this.lastTheme == null) goto L17;
        boolean r101 = true;
    L18:
        c.b(r100, r101, r100.getBgType());
        goto L19
    L17:
        r101 = false;
        goto L18
    }

    public static final /* synthetic */ void access$setAnchor$p(AudioLiveThemeReporter r100, boolean r101) {
        r100.isAnchor = r101;
    }

    private final Map<String, String> collectAudienceParams(IVoiceLiveTheme r100, boolean r101) {
        LinkedHashMap r102 = new LinkedHashMap();
        if (r100 == null) goto L6;
        String r103 = r100.getImageUri();
        if (r103 == null) goto L6;
    L7:
        r102.put("pic_uri", r103);
        IRoom r104 = null;
        if (r100 == null) goto L10;
        Long r105 = Long.valueOf(r100.getId());
    L11:
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, String.valueOf(r105));
        if (r100 == null) goto L14;
        int r106 = r100.getBgType();
    L15:
        putLiveTypeAndFunctionTypes(r102, r106, r100);
        if (r100 == null) goto L18;
        int r107 = r100.getFormatType();
    L19:
        putFormatType(r102, r107);
        if (r101 == false) goto L25;
        m<IRoom> r108 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r108 == null) goto L24;
        r104 = r108.getValue();
    L24:
        String r109 = getCurrentPlayModesFromRoom(r104);
    L26:
        r102.put(FastStartLiveConfig.PLAY_MODE, r109);
        return r102;
    L25:
        r109 = w.a();
        goto L26
    L18:
        r107 = 0;
        goto L19
    L14:
        r106 = 2;
        goto L15
    L10:
        r105 = null;
    L6:
        r103 = "";
        goto L7
    }

    private final void collectDurationParams(IVoiceLiveTheme r100, boolean r101) {
        this.cachedParams.clear();
        Map<String, String> r102 = this.cachedParams;
        if (this.isAnchor == false) goto L5;
        Map<String, String> r103 = collectAnchorParams(r100);
    L6:
        r102.putAll(r103);
        return;
    L5:
        r103 = collectAudienceParams(r100, r101);
        goto L6
    }

    private final void logThemeShowWhenEnterRoom(IVoiceLiveTheme r100, int r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        LinkedHashMap r101 = new LinkedHashMap();
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, String.valueOf(r100.getId()));
        String r102 = r100.getImageUri();
        String r103 = "";
        if (r102 != null) goto L7;
        r102 = "";
    L7:
        r101.put("pic_uri", r102);
        int r104 = r100.getFormatType();
        if (r104 == 1) goto L12;
        if (r104 != 2) goto L13;
        r103 = "dynamic";
    L13:
        r101.put(com.bytedance.android.ec.core.event.a.KEY_PIC_TYPE, r103);
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, String.valueOf(r100.getId()));
        c.d(r101, r110);
        m<IRoom> r105 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r105 == null) goto L16;
        IRoom r106 = r105.getValue();
    L17:
        r101.put(FastStartLiveConfig.PLAY_MODE, getCurrentPlayModesFromRoom(r106));
        j0.l().sendLog("livesdk_live_theme_show", r101, new Object[]{IRoom.class, x.class});
        return;
    L16:
        r106 = null;
        goto L17
    L12:
        r103 = "static";
        goto L13
    }

    private final void putFormatType(Map<String, String> r100, int r101) {
        if (r101 != 1) goto L5;
        String r102 = "static";
    L9:
        r100.put(com.bytedance.android.ec.core.event.a.KEY_PIC_TYPE, r102);
        return;
    L5:
        if (r101 == 2) goto L7;
        r102 = "";
        goto L9
    L7:
        r102 = "dynamic";
        goto L9
    }

    private final void reportAnchorThemeSelectDuration(IVoiceLiveTheme r100, long r101) {
        if (r101 != 0) goto L5;
        return;
    L5:
        this.cachedParams.put("duration", "" + r101);
        Map<String, String> r102 = this.cachedParams;
        if (r100 == null) goto L8;
        Long r103 = Long.valueOf(r100.getId());
    L9:
        r102.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, String.valueOf(r103));
        j0.l().sendLog("livesdk_anchor_theme_select_duration", MapsKt.toMap(this.cachedParams), new Object[]{IRoom.class, x.class});
        return;
    L8:
        r103 = null;
        goto L9
    }

    private final void putLiveTypeAndFunctionTypes(Map<String, String> r100, int r101, IVoiceLiveTheme r110) {
        int r102 = 0;
        if (r101 != 1) goto L5;
        r100.put("live_type", "voice_live");
        r100.put("function_type", "ktv");
        if (r110 == null) goto L41;
        r102 = r110.getPlayMode();
    L41:
        if (r102 != 0) goto L44;
        r100.put("function_type2", "ktv");
    L44:
        if (TextUtils.isEmpty(r100.get("function_type2")) == false) goto L47;
        r100.put("function_type2", ((IInteractService) k.n(IInteractService.class)).getFunctionType2());
        return;
    L47:
        return;
    L5:
        if (r101 != 2) goto L7;
        r100.put("live_type", "voice_live");
        r100.put("function_type", "radio");
        if (r110 == null) goto L24;
        int r103 = r110.getPlayMode();
    L25:
        if (r103 != 0) goto L27;
        r100.put("function_type2", "radio");
    L27:
        m<IRoom> r104 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r104 == null) goto L30;
        IRoom r105 = r104.getValue();
    L32:
        if (d0.h(r105) == false) goto L44;
        r100.put("function_type", "party");
        if (r110 == null) goto L36;
        r102 = r110.getPlayMode();
    L36:
        if (r102 != 0) goto L44;
        r100.put("function_type2", "party");
        goto L44
    L30:
        r105 = null;
        goto L32
    L24:
        r103 = 0;
        goto L25
    L7:
        if (r101 != 5) goto L9;
        r100.put("live_type", "voice_live");
        r100.put("function_type", "live");
        if (r110 == null) goto L19;
        r102 = r110.getPlayMode();
    L19:
        if (r102 != 0) goto L44;
        r100.put("function_type2", "radio");
        goto L44
    L9:
        if (r101 != 100) goto L44;
        r100.put("live_type", "voice_live");
        r100.put("function_type", "chorus");
        if (r110 == null) goto L14;
        r102 = r110.getPlayMode();
    L14:
        if (r102 != 0) goto L44;
        r100.put("function_type2", "chorus");
        goto L44
    }

    private final void reportAudienceThemeThemeDuration(long r100, IVoiceLiveTheme r101, boolean r102) {
        if (r100 != 0) goto L5;
        return;
    L5:
        Map<String, String> r103 = this.cachedParams;
        String r104 = "anchor";
        if (r102 == true) goto L13;
        if (r101 != null) goto L10;
    L12:
        r104 = "leave";
        goto L13
    L10:
        if (r101.getChangeByAnchor() != true) goto L12;
        r101.setChangeByAnchor(false);
    L13:
        r103.put("end_type", r104);
        Map<String, String> r105 = this.cachedParams;
        if (r101 == null) goto L16;
        Long r106 = Long.valueOf(r101.getId());
    L17:
        r105.put(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID, String.valueOf(r106));
        this.cachedParams.put("duration", "" + r100);
        j0.l().sendLog("livesdk_live_theme_duration", MapsKt.toMap(this.cachedParams), new Object[]{IRoom.class, x.class});
        return;
    L16:
        r106 = null;
        goto L17
    }

    private final void reportThemeDuration(long r100, IVoiceLiveTheme r101, boolean r102) {
        if (this.isAnchor == false) goto L5;
        reportAnchorThemeSelectDuration(r101, r100);
        return;
    L5:
        reportAudienceThemeThemeDuration(r100, r101, r102);
    }
}
