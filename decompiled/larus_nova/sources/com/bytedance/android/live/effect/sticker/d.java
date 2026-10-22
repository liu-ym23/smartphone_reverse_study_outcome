package com.bytedance.android.live.effect.sticker;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.UrlModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.MVBindStickerInfo;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.ss.android.ugc.effectmanager.MobConstants;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    public class a extends TypeToken<Sticker.AigcEffectInfo> {
        public a() {
        }
    }

    public class b extends TypeToken<Sticker.EffectTipsInfo> {
        public b() {
        }
    }

    public class c extends TypeToken<List<MVBindStickerInfo>> {
        public c() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.d$d, reason: collision with other inner class name */
    public class C1116d extends TypeToken<List<Sticker.ComposerConfig>> {
        public C1116d() {
        }
    }

    public class e extends TypeToken<List<Sticker.ComposerConfig>> {
        public e() {
        }
    }

    public static Effect a(Sticker r100) {
        if (r100.getEffect() != null) goto L5;
        Effect r101 = new Effect();
        r101.setId(r100.getRealId());
        r101.setEffectId(r100.getEffectId());
        UrlModel r102 = r100.getIcon();
        if (r102 != null) goto L9;
        com.ss.android.ugc.effectmanager.common.model.UrlModel r103 = new com.ss.android.ugc.effectmanager.common.model.UrlModel();
    L10:
        r101.setIconUrl(r103);
        r101.setUnzipPath(r100.getUnzipPath());
        r101.setHint(r100.getHint());
        r101.setTags(r100.getTags());
        r101.setDownloaded(r100.isDownloaded());
        r101.setEffectId(r100.getEffectId());
        String r104 = r100.getTagsUpdatedAt();
        if (r104 == null) goto L13;
        r101.setTagsUpdatedAt(r104);
    L13:
        r101.setExtra(r100.getExtra());
        r101.setTypes(r100.getTypes());
        String r105 = r100.getSdkExtra();
        if (r105 == null) goto L16;
        r101.setSdkExtra(r105);
    L16:
        return r101;
    L9:
        com.ss.android.ugc.effectmanager.common.model.UrlModel r106 = new com.ss.android.ugc.effectmanager.common.model.UrlModel();
        r106.setUri(r102.getUri());
        r106.setUrlList(r102.getUrlList());
        r103 = r106;
        goto L10
    L5:
        return r100.getEffect();
    }

    public static Sticker b(Effect r100) {
        SystemClock.uptimeMillis();
        Sticker r101 = new Sticker();
        com.ss.android.ugc.effectmanager.common.model.UrlModel r102 = r100.getIconUrl();
        if (r102 != null) goto L5;
        UrlModel r103 = new UrlModel();
    L6:
        r101.setIcon(r103);
        r101.setId(CastLongProtector.valueOf(r100.getEffectId()).longValue());
        r101.setRealId(r100.getId());
        r101.setResourceId(r100.getResourceId());
        r101.setEffectId(r100.getEffectId());
        r101.setUnzipPath(r100.getUnzipPath());
        r101.setHint(r100.getHint());
        r101.setDownloaded(r100.isDownloaded());
        r101.setTags(r100.getTags());
        String r104 = r100.getTagsUpdatedAt();
        if (r104 == null) goto L9;
        r101.setTagsUpdatedAt(r104);
    L9:
        r101.setTypes(r100.getTypes());
        r101.setName(r100.getName());
        r101.setEffect(r100);
        r101.setExtra(r100.getExtra());
        int r105 = com.bytedance.android.live.effect.utils.n.f68880a;
        r101.setComposerConfigList(com.bytedance.android.live.effect.utils.n.b(r100.getExtra()));
        if (r101.getEffect() == null) goto L12;
        r101.setStickerPanel(r101.getEffect().getPanel());
    L12:
        String r106 = r100.getSdkExtra();
        if (r106 == null) goto L15;
        r101.setSdkExtra(r106);
    L15:
        h(r101);
        i(r101);
        com.bytedance.android.live.effect.utils.n.c(r101.getEffect(), r101);
        return r101;
    L5:
        UrlModel r107 = new UrlModel();
        r107.setUri(r102.getUri());
        r107.setUrlList(r102.getUrlList());
        r103 = r107;
        goto L6
    }

    public static Single<Sticker> c(final Effect r100) {
        return Single.create(new com.bytedance.android.live.effect.sticker.c(r100)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }

    public static Single<List<Sticker>> e(final List<Effect> r100) {
        return Single.create(new com.bytedance.android.live.effect.sticker.b(r100)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread());
    }

    public static void h(Sticker r210) {
        if (StringUtils.isEmpty(r210.getExtra()) == false) goto L93;
        if (d0.f66753c.equals(r210.getStickerPanel()) == false) goto L7;
    L10:
        r210.getCoexistGroup().addAll(Arrays.asList(new Integer[]{1, 2}));
        return;
    L7:
        if (d0.f66755e.equals(r210.getStickerPanel()) == true) goto L10;
        if ("live_camera_move".equals(r210.getStickerPanel()) == true) goto L10;
        return;
    L93:
        JsonObject r100 = new JsonParser().parse(r210.getExtra()).getAsJsonObject();     // Catch: Throwable -> L88
        if (r100.has("RepelPanel") == false) goto L17;
        r210.setStickerFeature(r100.get("RepelPanel").getAsInt());     // Catch: Throwable -> L88
    L17:
        if (r100.has("disableEffectPreview") == false) goto L20;
        r210.setDisableEffectPreview(r100.get("disableEffectPreview").getAsInt());     // Catch: Throwable -> L88
    L20:
        if (r100.has("is_blessing_sticker") == false) goto L23;
        r210.setBlessing(r100.get("is_blessing_sticker").getAsBoolean());     // Catch: Throwable -> L88
    L23:
        if (r100.has("game") == false) goto L26;
        r210.setGame(r100.get("game").getAsBoolean());     // Catch: Throwable -> L88
    L26:
        if (r100.has("video_tag") == false) goto L30;
        r210.setVideoTag(r100.get("video_tag").getAsString());     // Catch: Throwable -> L88
    L30:
        if (r100.has("beautyConfig") == false) goto L91;
        List<Sticker.ComposerConfig> r101 = (List) GsonHelper.get().fromJson(new JsonParser().parse(r100.get("beautyConfig").getAsString()).getAsJsonObject().getAsJsonArray("items"), new C1116d().getType());     // Catch: Throwable -> L88
        r210.setComposerConfigList(r101);     // Catch: Throwable -> L88
        Iterator<Sticker.ComposerConfig> r102 = r101.iterator();     // Catch: Throwable -> L88
    L33:
        if (r102.hasNext() == false) goto L91;
        r210.getUpdateKeys().add(r102.next().getTag());     // Catch: Throwable -> L88
    L91:
    L48:
        th = move-exception;
        ALogger.e("stickerSdkExtraToModel", th);     // Catch: Throwable -> L88
    L51:
        if (LiveEffectSettings.LIVE_ENABLE_STICKER_BEAUTY_TEMPLATE.getValue().booleanValue() == false) goto L56;
        if (r100.has("styleType") == false) goto L56;
        r210.setStyleType(r100.get("styleType").getAsInt());     // Catch: Throwable -> L88
    L56:
        if (d0.f66753c.equals(r210.getStickerPanel()) == false) goto L58;
    L61:
        f(r100, r210);     // Catch: Throwable -> L88
    L63:
        if (r100.has("Review_original_frame") == false) goto L66;
        r210.setReviewOriginalFrame(r100.get("Review_original_frame").getAsBoolean());     // Catch: Throwable -> L88
    L66:
        if (LiveEffectSettings.LIVE_ANCHOR_PREVIEW_ENABLE_CAMPAIGN_EFFECT_INSERT.getValue().booleanValue() == false) goto L71;
        if (r100.has("forbidden_linkage_share") == false) goto L71;
        r210.setDisableEffectLink(r100.get("forbidden_linkage_share").getAsBoolean());     // Catch: Throwable -> L88
    L71:
        if (r100.has("enable_customize_duration") == false) goto L74;
        r210.setHasCustomizeDurationConfigFromLoki(true);     // Catch: Throwable -> L88
        r210.setEnableCustomizeDurationFromLoki(r100.get("enable_customize_duration").getAsBoolean());     // Catch: Throwable -> L88
    L74:
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_EXTRA_TIPS.getValue().booleanValue() == false) goto L82;
        if (r100.has("tip_text") == false) goto L82;
        Sticker.EffectTipsInfo r103 = new Sticker.EffectTipsInfo();     // Catch: Throwable -> L88
        r103.setTipText(r100.get("tip_text").getAsString());     // Catch: Throwable -> L88
        if (r100.has("jump_url") == false) goto L80;
        r103.setJumpUrl(r100.get("jump_url").getAsString());     // Catch: Throwable -> L88
    L80:
        r210.setEffectExtraTipsInfo(r103);     // Catch: Throwable -> L88
    L82:
        if (r100.has("transfer_type") == false) goto L85;
        r210.setTransferType(r100.get("transfer_type").getAsInt());     // Catch: Throwable -> L88
    L85:
        if (r100.has("layer_map") == false) goto L97;
        r210.setLayerMap(r100.get("layer_map").getAsString());     // Catch: Throwable -> L88
        return;
    L97:
        return;
    L58:
        if (d0.f66755e.equals(r210.getStickerPanel()) == true) goto L61;
        if ("live_camera_move".equals(r210.getStickerPanel()) == false) goto L63;
    L37:
        if (r100.has(MobConstants.PANEL_INFO_BEAUTIFY) == false) goto L43;
        List<Sticker.ComposerConfig> r104 = (List) GsonHelper.get().fromJson(new JsonParser().parse(r100.get(MobConstants.PANEL_INFO_BEAUTIFY).getAsString()).getAsJsonObject().getAsJsonArray("items"), new e().getType());     // Catch: Throwable -> L48
        r210.setComposerConfigList(r104);     // Catch: Throwable -> L48
        Iterator<Sticker.ComposerConfig> r105 = r104.iterator();     // Catch: Throwable -> L48
    L40:
        if (r105.hasNext() == false) goto L43;
        r210.getUpdateKeys().add(r105.next().getTag());     // Catch: Throwable -> L48
    L43:
        if (r100.has("is_style") == false) goto L51;
        if (r100.get("is_style").getAsBoolean() == false) goto L51;
        r210.setStyleType(1);     // Catch: Throwable -> L48
    L88:
        th = move-exception;
        th.printStackTrace();
    }

    public static void i(Sticker r110) {
        if (StringUtils.isEmpty(r110.getSdkExtra()) == true) goto L38;
        r110.setSdkExtraModel((Sticker.StickerSDKExtra) GsonProtectorUtils.fromJson(GsonHelper.get(), r110.getSdkExtra(), Sticker.StickerSDKExtra.class));
    L31:
        th = move-exception;
        ALogger.e("stickerSdkExtraToModel", th);
        return;
    L7:
        if (r110.getSdkExtra() == null) goto L36;
        JsonObject r100 = new JsonParser().parse(r110.getSdkExtra()).getAsJsonObject();     // Catch: Throwable -> L31
        if (r100.has("live_custom_data") == false) goto L20;
        JsonObject r101 = r100.getAsJsonObject("live_custom_data");     // Catch: Throwable -> L31
        if (r101.has("aigc_info") == false) goto L14;
        JsonObject r102 = r101.getAsJsonObject("aigc_info");     // Catch: Throwable -> L31
        Type r103 = new a().getType();     // Catch: Throwable -> L31
        r110.setAigcEffectInfo((Sticker.AigcEffectInfo) GsonHelper.get().fromJson(r102, r103));     // Catch: Throwable -> L31
    L14:
        if (r101.has("interact_info") == false) goto L17;
        r110.setInteractRules(r101.getAsJsonObject("interact_info").toString());     // Catch: Throwable -> L31
    L17:
        if (r101.has("effect_tips") == false) goto L20;
        JsonObject r104 = r101.getAsJsonObject("effect_tips");     // Catch: Throwable -> L31
        Type r105 = new b().getType();     // Catch: Throwable -> L31
        r110.setEffectTipsInfo((Sticker.EffectTipsInfo) GsonHelper.get().fromJson(r104, r105));     // Catch: Throwable -> L31
    L20:
        if (r100.has("attachment_effect") == false) goto L25;
        String r106 = r100.getAsJsonArray("attachment_effect").toString();     // Catch: Throwable -> L31
        Type r107 = new c().getType();     // Catch: Throwable -> L31
        List r108 = (List) GsonHelper.get().fromJson(r106, r107);     // Catch: Throwable -> L31
        if (r108.isEmpty() == true) goto L25;
        r110.setMvBindStickerInfo((MVBindStickerInfo) ListProtector.get(r108, 0));     // Catch: Throwable -> L31
    L25:
        if (r100.has("enable_customize_duration") == false) goto L28;
        r110.setEnableCustomizeDurationFromExtra(r100.get("enable_customize_duration").getAsBoolean());     // Catch: Throwable -> L31
    L28:
        if (r100.has("effect_duration") == false) goto L37;
        r110.setDefaultDuration(r100.get("effect_duration").getAsLong());     // Catch: Throwable -> L31
        return;
    L37:
        return;
    L36:
        return;
    }

    public static Sticker d(Effect r100, String r101) {
        SystemClock.uptimeMillis();
        Sticker r102 = new Sticker();
        com.ss.android.ugc.effectmanager.common.model.UrlModel r103 = r100.getIconUrl();
        if (r103 != null) goto L5;
        UrlModel r104 = new UrlModel();
    L6:
        r102.setIcon(r104);
        r102.setId(CastLongProtector.valueOf(r100.getEffectId()).longValue());
        r102.setRealId(r100.getId());
        r102.setResourceId(r100.getResourceId());
        r102.setEffectId(r100.getEffectId());
        r102.setUnzipPath(r100.getUnzipPath());
        r102.setHint(r100.getHint());
        r102.setDownloaded(r100.isDownloaded());
        r102.setTags(r100.getTags());
        String r105 = r100.getTagsUpdatedAt();
        if (r105 == null) goto L9;
        r102.setTagsUpdatedAt(r105);
    L9:
        r102.setTypes(r100.getTypes());
        r102.setName(r100.getName());
        r102.setEffect(r100);
        r102.setExtra(r100.getExtra());
        int r106 = com.bytedance.android.live.effect.utils.n.f68880a;
        r102.setComposerConfigList(com.bytedance.android.live.effect.utils.n.b(r100.getExtra()));
        if (r101 == null) goto L15;
        if (r101.isEmpty() == true) goto L15;
        r102.setStickerPanel(r101);
    L17:
        String r107 = r100.getSdkExtra();
        if (r107 == null) goto L20;
        r102.setSdkExtra(r107);
    L20:
        h(r102);
        i(r102);
        com.bytedance.android.live.effect.utils.n.c(r102.getEffect(), r102);
        return r102;
    L15:
        if (r102.getEffect() == null) goto L17;
        r102.setStickerPanel(r102.getEffect().getPanel());
        goto L17
    L5:
        UrlModel r108 = new UrlModel();
        r108.setUri(r103.getUri());
        r108.setUrlList(r103.getUrlList());
        r104 = r108;
        goto L6
    }

    public static void f(JsonObject r100, Sticker r101) {
        if (r100.has(IPerformanceManager.MODULE_GIFT_STICKER) == true) goto L5;
    L7:
        boolean r102 = false;
    L9:
        if (r100.has("gift_sticker_repel_high") == true) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r102 == true) goto L17;
        if (r103 == true) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == true) goto L20;
        if (r103 == true) goto L20;
        return;
    L20:
        r101.getCoexistGroup().clear();
        r101.getCoexistGroup().addAll(Arrays.asList(new Integer[]{1, 2}));
        if (r103 == false) goto L25;
        r101.setHighCost(true);
        return;
    L25:
        return;
    L17:
        r104 = false;
        goto L18
    L11:
        if (r100.get("gift_sticker_repel_high").getAsBoolean() == false) goto L13;
        r103 = true;
        goto L14
    L5:
        if (r100.get(IPerformanceManager.MODULE_GIFT_STICKER).getAsBoolean() == false) goto L7;
        r102 = true;
        goto L9
    }

    public static boolean g(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        JsonObject r102 = new JsonParser().parse(r100).getAsJsonObject();     // Catch: Throwable -> L11
        if (r102.has(r101) == false) goto L18;
        return r102.get(r101).getAsBoolean();
    L18:
        return false;
    L11:
        th = move-exception;
        th.printStackTrace();
        return false;
    L19:
        return false;
    }
}
