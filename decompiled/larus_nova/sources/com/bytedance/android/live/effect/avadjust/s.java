package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import com.ss.texturerender.TextureRenderKeys;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f66895a = 0;

    static {
    }

    public static void a(String r100, int r101, Sticker r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "eventPage");
        Intrinsics.checkNotNullParameter(r103, ReportConstant.COMMON_ACTION_TYPE);
        if (r102 == null) goto L32;
        HashMap r104 = new HashMap();
        r104.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, r100);
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, "adjust");
        String r105 = r102.getName();
        if (r105 == null) goto L7;
        String r106 = (String) r104.put(MobConstants.EFFECT_NAME, r105);
    L7:
        r104.put("live_type", "video_live");
        r104.put(MobConstants.EFFECT_ID, r102.getEffectId());
        r104.put(TextureRenderKeys.KEY_IS_EFFECT_ORDER, String.valueOf(r101));
        r104.put("action_type", r103);
        Sticker.ComposerConfig r107 = r102.getSmallItemConfig();
        if (r107 == null) goto L10;
        Integer r108 = Integer.valueOf(r107.getDefaultValue());
    L11:
        r104.put(ComposerHelper.COMPOSER_DEFAULT_VALUE, String.valueOf(r108));
        List<String> r109 = LiveEffectContext.f66734h;
        ILiveEffectComposerManager r110 = LiveEffectContext.a.a(LiveEffectContextFactoryDelegate$Type.DEFAULT).a();
        String r111 = r102.getEffectId();
        String r112 = "";
        if (r111 != null) goto L14;
        r111 = "";
    L14:
        Sticker.ComposerConfig r113 = r102.getSmallItemConfig();
        if (r113 == null) goto L20;
        String r114 = r113.getTag();
        if (r114 == null) goto L20;
        r112 = r114;
    L20:
        Float r115 = r110.G(r111, r112);
        if (r115 == null) goto L23;
        float r116 = r115.floatValue();
    L24:
        int r117 = com.bytedance.android.live.effect.q.b(r102, r116);
        r104.put("effect_value", String.valueOf(r117));
        Sticker.ComposerConfig r118 = r102.getSmallItemConfig();
        if (r118 != null) goto L27;
    L29:
        String r119 = "0";
    L30:
        r104.put("is_default_value", r119);
        com.bytedance.android.live.effect.utils.c.a("livesdk_beauty_panel_item_select", r104, r100);
        return;
    L27:
        if (r117 != r118.getDefaultValue()) goto L29;
        r119 = "1";
        goto L30
    L23:
        r116 = 0.0f;
        goto L24
    L10:
        r108 = null;
        goto L11
    }
}
