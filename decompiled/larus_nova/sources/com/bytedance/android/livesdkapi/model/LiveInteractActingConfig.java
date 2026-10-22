package com.bytedance.android.livesdkapi.model;

import com.tencent.connect.common.Constants;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR&\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveInteractActingConfig;", "", "()V", "changeInteractRole", "", "", "getChangeInteractRole", "()Ljava/util/Map;", "setChangeInteractRole", "(Ljava/util/Map;)V", "changeInteractRoleGuide", "getChangeInteractRoleGuide", "setChangeInteractRoleGuide", "interactActingLaunch", "getInteractActingLaunch", "setInteractActingLaunch", "interactActingLaunchGuide", "getInteractActingLaunchGuide", "setInteractActingLaunchGuide", "supportSceneList", "", "getSupportSceneList", "()Ljava/util/List;", "setSupportSceneList", "(Ljava/util/List;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveInteractActingConfig {
    private Map<String, String> changeInteractRole;
    private Map<String, String> changeInteractRoleGuide;
    private Map<String, String> interactActingLaunch;
    private Map<String, String> interactActingLaunchGuide;
    private List<String> supportSceneList;

    public LiveInteractActingConfig() {
        this.supportSceneList = CollectionsKt.listOf(new String[]{"5", Constants.VIA_REPORT_TYPE_START_WAP});
        this.interactActingLaunch = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/interact_acting_douyin/pages/interact_acting_launch/template.js?cache_first=0&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D"), TuplesKt.to("schema", "sslocal://webcast_lynxview?type=popup&gravity=bottom&hide_loading=0&show_error=1&enable_latch=1&mask_alpha=0&rate_height=430&width_percent=100&horizontal_width_percent=100")});
        this.changeInteractRole = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/interact_acting_douyin/pages/change_interact_role/template.js%?initialProps%3D%255B%2522current_user%2522%252C%2522current_room%2522%252C%2522linkmic%2522%255D"), TuplesKt.to("schema", "sslocal://webcast_lynxview?type=popup&gravity=bottom&hide_loading=0&show_error=1&enable_latch=1&mask_alpha=0&height=452&width_percent=100&horizontal_width_percent=100")});
        this.interactActingLaunchGuide = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/common_page_lynx_douyin/pages/common_guide_page/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=livelinkmic&business_group=livelinkmic&new_ui=true&type=3"), TuplesKt.to("schema", "sslocal://webcast_lynxview?type=popup&gravity=bottom&mask_alpha=0&rate_height=430&enable_latch=1&disable_input_scroll=1&load_taro=0")});
        this.changeInteractRoleGuide = MapsKt.mapOf(new Pair[]{TuplesKt.to("url", "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/common_page_lynx_douyin/pages/common_guide_page/template.js?initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D&business_type=livelinkmic&business_group=livelinkmic&new_ui=true&type=2"), TuplesKt.to("schema", "sslocal://webcast_lynxview?type=popup&gravity=bottom&mask_alpha=0&height_percent=40&enable_latch=1&disable_input_scroll=1&load_taro=0")});
    }

    public final Map<String, String> getChangeInteractRole() {
        return this.changeInteractRole;
    }

    public final Map<String, String> getChangeInteractRoleGuide() {
        return this.changeInteractRoleGuide;
    }

    public final Map<String, String> getInteractActingLaunch() {
        return this.interactActingLaunch;
    }

    public final Map<String, String> getInteractActingLaunchGuide() {
        return this.interactActingLaunchGuide;
    }

    public final List<String> getSupportSceneList() {
        return this.supportSceneList;
    }

    public final void setChangeInteractRole(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.changeInteractRole = r100;
    }

    public final void setChangeInteractRoleGuide(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.changeInteractRoleGuide = r100;
    }

    public final void setInteractActingLaunch(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interactActingLaunch = r100;
    }

    public final void setInteractActingLaunchGuide(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.interactActingLaunchGuide = r100;
    }

    public final void setSupportSceneList(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.supportSceneList = r100;
    }
}
