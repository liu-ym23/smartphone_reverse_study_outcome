package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.app.Activity;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.browser.jsbridge.base.OpenCustomEmojiPreviewResultModel;
import com.bytedance.android.livehostapi.business.IHostEmoji;
import com.bytedance.android.livehostapi.business.model.emoji.SelfEmoji;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.account.platform.api.IGoogleService;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openCustomEmojiPreview")
public final class q8 extends w20.g4<w20.fc, OpenCustomEmojiPreviewResultModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f63614a;

    public final Activity getActivity() {
        return this.f63614a;
    }

    public q8(Activity r100) {
        this.f63614a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        w20.fc r102 = (w20.fc) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        SelfEmoji r103 = new SelfEmoji();
        JsonObject r104 = r102.b();
        JsonArray r105 = null;
        if (r104 == null) goto L7;
        JsonElement r106 = r104.get("id");
        if (r106 == null) goto L7;
        String r107 = r106.getAsString();
    L8:
        r103.setId(r107);
        boolean r108 = false;
        if (r104 == null) goto L15;
        JsonElement r109 = r104.get("width");
        if (r109 == null) goto L15;
        String r110 = r109.getAsString();
        if (r110 == null) goto L15;
        int r111 = CastIntegerProtector.parseInt(r110);
    L16:
        r103.setViewWidth(r111);
        if (r104 == null) goto L23;
        JsonElement r112 = r104.get("height");
        if (r112 == null) goto L23;
        String r113 = r112.getAsString();
        if (r113 == null) goto L23;
        int r114 = CastIntegerProtector.parseInt(r113);
    L24:
        r103.setViewHeight(r114);
        if (r104 == null) goto L31;
        JsonElement r115 = r104.get("is_gif");
        if (r115 == null) goto L31;
        String r116 = r115.getAsString();
        if (r116 == null) goto L31;
        r108 = Boolean.parseBoolean(r116);
    L31:
        r103.setGif(r108);
        if (r104 == null) goto L36;
        JsonElement r117 = r104.get("web_uri");
        if (r117 == null) goto L36;
        String r118 = r117.getAsString();
    L37:
        r103.setWebUri(r118);
        if (r104 == null) goto L42;
        JsonElement r119 = r104.get("animate_type");
        if (r119 == null) goto L42;
        String r120 = r119.getAsString();
    L43:
        r103.setAnimateType(r120);
        if (r104 == null) goto L48;
        JsonElement r121 = r104.get(IGoogleService.ResponseKey.DISPLAY_NAME);
        if (r121 == null) goto L48;
        String r122 = r121.getAsString();
    L49:
        r103.setDisplayName(r122);
        if (r104 == null) goto L54;
        JsonElement r123 = r104.get(ScoreTags.STAR_URL_LIST);
        if (r123 == null) goto L54;
        r105 = r123.getAsJsonArray();
    L54:
        ArrayList r124 = new ArrayList();
        if (r105 == null) goto L60;
        Iterator<JsonElement> r125 = r105.iterator();
    L58:
        if (r125.hasNext() == false) goto L60;
        r124.add(r125.next().getAsString());
    L60:
        r103.setUrls(r124);
        ImageModel r126 = new ImageModel();
        r126.setUrls(r124);
        r126.width = r103.getViewWidth();
        r126.height = r103.getViewHeight();
        r126.setUri(r103.getWebUri());
        r103.setAnimatedImage(r126);
        r103.setStaticImage(r103.getAnimatedImage());
        String r127 = r102.a();
        if (r127 != null) goto L64;
    L69:
        ((IHostEmoji) jc1.k.n(IHostEmoji.class)).previewSelfEmoji(this.f63614a, r103);
        return;
    L64:
        if (r127.hashCode() != 96417) goto L69;
        if (r127.equals("add") == false) goto L69;
        ((IHostEmoji) jc1.k.n(IHostEmoji.class)).addSelfEmoji(this.f63614a, r103);
        return;
    L48:
        r122 = null;
    L42:
        r120 = null;
    L36:
        r118 = null;
    L23:
        r114 = 0;
    L15:
        r111 = 0;
    L7:
        r107 = null;
        goto L8
    }
}
