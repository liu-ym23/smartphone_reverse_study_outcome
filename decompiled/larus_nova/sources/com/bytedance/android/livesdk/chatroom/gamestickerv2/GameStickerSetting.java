package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerSetting;
import com.bytedance.android.livesdkapi.gamestickerv2.config.AlignMode;
import com.bytedance.android.livesdkapi.gamestickerv2.config.ComponentMode;
import com.bytedance.android.livesdkapi.gamestickerv2.config.InvisibleCode;
import com.bytedance.android.livesdkapi.gamestickerv2.config.SizeMode;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameSticker;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.InvisibleCodeConfig;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class GameStickerSetting implements IGameStickerSetting {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f106265a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f106266b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f106267c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f106268d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f106269e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final GameStickerSetting f106270f = null;

    public GameStickerSetting() {
    }

    public static com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameStickerSetting c() {
        return (com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameStickerSetting) f106266b.getValue();
    }

    public static List e() {
        return (List) f106267c.getValue();
    }

    static {
        f106270f = new GameStickerSetting();
        Lazy r100 = LazyKt.lazy(AnonymousClass2.INSTANCE);
        f106265a = r100;
        f106266b = LazyKt.lazy(GameStickerSetting$loadConfig$2.INSTANCE);
        f106267c = LazyKt.lazy(GameStickerSetting$stickerConfig$2.INSTANCE);
        Lazy r101 = LazyKt.lazy(GameStickerSetting$invisibleCode$2.INSTANCE);
        f106268d = r101;
        Lazy r102 = LazyKt.lazy(GameStickerSetting$enableScene$2.INSTANCE);
        f106269e = r102;
        if (v.a() == false) goto L6;
        ALogger.e("GameStickerSetting", "loadConfig:" + c().getEnable());
        ALogger.e("GameStickerSetting", "stickerConfig:" + e());
        ALogger.e("GameStickerSetting", "invisibleCode:" + ((List) r101.getValue()));
        ALogger.e("GameStickerSetting", "enableRefactor:" + ((Boolean) r100.getValue()));
        ALogger.e("GameStickerSetting", "enableScene:" + ((List) r102.getValue()));
        return;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerSetting
    public final boolean enableRefactor() {
        return ((Boolean) f106265a.getValue()).booleanValue();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerSetting
    public final boolean enable() {
        if (FoldScreenUtils.f() == false) goto L11;
        if (c().getEnable() == true) goto L7;
        return false;
    L7:
        if (((List) f106269e.getValue()).contains("fold_screen") == false) goto L21;
        return true;
    L21:
        return false;
    L11:
        if (PadConfigUtils.a() == false) goto L19;
        if (c().getEnable() == true) goto L15;
        return false;
    L15:
        if (((List) f106269e.getValue()).contains(CommonCmd.AIDL_PLATFORM_TYPE_PAD) == false) goto L23;
        return true;
    L23:
        return false;
    L19:
        return c().getEnable();
    }

    public static AlignMode a(GameStickerInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        return (AlignMode) d(r100, GameStickerSetting$getAlignMode$1.INSTANCE, GameStickerSetting$getAlignMode$2.INSTANCE, AlignMode.UNKNOWN);
    }

    public static ComponentMode b(GameStickerInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        return (ComponentMode) d(r100, GameStickerSetting$getComponentMode$1.INSTANCE, GameStickerSetting$getComponentMode$2.INSTANCE, ComponentMode.UNKNOWN);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerSetting
    public final boolean enableLandscape(int r100) {
        if (enableStickerType(r100) == true) goto L5;
        return false;
    L5:
        List r101 = e();
        Object r102 = null;
        if (r101 == null) goto L19;
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        GameSticker r105 = (GameSticker) r104;
        if (r105.getStickerType() == r100) goto L13;
    L15:
        boolean r106 = false;
    L16:
        if (r106 == false) goto L9;
        r102 = r104;
        goto L18
    L13:
        if (r105.getEnableLandscape() == false) goto L15;
        r106 = true;
    L18:
        r102 = (GameSticker) r102;
    L19:
        if (r102 == null) goto L27;
        return true;
    L27:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerSetting
    public final boolean enableStickerType(int r100) {
        if (enable() == true) goto L5;
        return false;
    L5:
        List r101 = e();
        Object r102 = null;
        if (r101 == null) goto L25;
        Iterator r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L24;
        Object r104 = r103.next();
        GameSticker r105 = (GameSticker) r104;
        if (r105.getEnable() == true) goto L13;
    L21:
        boolean r106 = false;
    L22:
        if (r106 == false) goto L9;
        r102 = r104;
        goto L24
    L13:
        if (r105.getStickerType() != r100) goto L21;
        if (AlignMode.Companion.strToAlignMode(r105.getAlignMode()) == AlignMode.UNKNOWN) goto L21;
        if (SizeMode.Companion.strToSizeMode(r105.getSizeMode()) == SizeMode.UNKNOWN) goto L21;
        if (ComponentMode.Companion.strToComponentMode(r105.getComponentMode()) == ComponentMode.UNKNOWN) goto L21;
        r106 = true;
    L24:
        r102 = (GameSticker) r102;
    L25:
        if (r102 == null) goto L33;
        return true;
    L33:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerSetting
    public final SizeMode getSizeMode(GameStickerInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        return (SizeMode) d(r100, AnonymousClass1.INSTANCE, C100052.INSTANCE, SizeMode.UNKNOWN);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IGameStickerSetting
    public final InvisibleCode isInvisibleCode(int r100) {
        List r101 = (List) f106268d.getValue();
        if (r101 == null) goto L21;
        Iterator r102 = r101.iterator();
    L6:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if (((InvisibleCodeConfig) r103).getCode() != r100) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L6;
    L14:
        InvisibleCodeConfig r105 = (InvisibleCodeConfig) r103;
        if (r105 == null) goto L21;
        int r106 = r105.getCode();
        String r107 = r105.getMsg();
        if (r107 != null) goto L20;
        r107 = "";
    L20:
        return new InvisibleCode(r106, r107);
    L10:
        r104 = false;
        goto L11
    L13:
        r103 = null;
    L21:
        return null;
    }

    public static Object d(GameStickerInfo r100, Function1 r101, Function1 r110, Object r111) {
        List r102 = e();
        Object r103 = null;
        if (r102 == null) goto L27;
        Iterator r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L20;
        Object r105 = r104.next();
        GameSticker r106 = (GameSticker) r105;
        if (r106.getStickerType() == r100.getStickerType()) goto L10;
    L17:
        boolean r107 = false;
    L18:
        if (r107 == false) goto L6;
    L21:
        GameSticker r108 = (GameSticker) r105;
        if (r108 == null) goto L27;
        Object r109 = r110.invoke(r101.invoke(r108));
        if (r109 == null) goto L27;
        r103 = r109;
    L42:
        if (r103 != null) goto L45;
        return r111;
    L45:
        return r103;
    L10:
        if (Intrinsics.areEqual(r106.getGameId(), r100.getStickerGameId()) == false) goto L17;
        if (r100.getStickerGameId().length() <= 0) goto L14;
        boolean r112 = true;
    L15:
        if (r112 == false) goto L17;
        r107 = true;
        goto L18
    L14:
        r112 = false;
        goto L15
    L20:
        r105 = null;
    L27:
        List r113 = e();
        if (r113 == null) goto L42;
        Iterator r114 = r113.iterator();
    L31:
        if (r114.hasNext() == false) goto L38;
        Object r115 = r114.next();
        if (((GameSticker) r115).getStickerType() != r100.getStickerType()) goto L35;
        boolean r116 = true;
    L36:
        if (r116 == false) goto L31;
    L39:
        GameSticker r117 = (GameSticker) r115;
        if (r117 == null) goto L42;
        r103 = r110.invoke(r101.invoke(r117));
        goto L42
    L35:
        r116 = false;
        goto L36
    L38:
        r115 = null;
        goto L39
    }
}
