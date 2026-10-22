package com.bytedance.android.livesdk.link.model;

import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b'\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u0006\u001a\u0004\b\r\u0010\nR\"\u0010\u0015\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013R6\u0010\u001d\u001a\u001e\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0018\u00010\u0016j\u000e\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0018\u0001`\u00198&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0006\u001a\u0004\b\u001e\u0010\u0004R\u001a\u0010#\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0006\u001a\u0004\b!\u0010\u0004R\"\u0010'\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b$\u0010%R\u001a\u0010*\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b(\u0010\u0004R\"\u0010-\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b+\u0010%R\u001a\u00100\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b/\u0010\u0006\u001a\u0004\b.\u0010\u0004R6\u00103\u001a\u001e\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0018\u00010\u0016j\u000e\u0012\b\u0012\u00060\u0017j\u0002`\u0018\u0018\u0001`\u00198&X§\u0004¢\u0006\f\u0012\u0004\b2\u0010\u0006\u001a\u0004\b1\u0010\u001bR\"\u00106\u001a\n\u0018\u00010\u0017j\u0004\u0018\u0001`\u00188&X§\u0004¢\u0006\f\u0012\u0004\b5\u0010\u0006\u001a\u0004\b4\u0010%R\u001a\u00109\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b8\u0010\u0006\u001a\u0004\b7\u0010\u0004R\u001a\u0010<\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b;\u0010\u0006\u001a\u0004\b:\u0010\u0004R\u001a\u0010?\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b>\u0010\u0006\u001a\u0004\b=\u0010\u0004¨\u0006@"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/m0;", "Lvh7/c;", "", "getActivityName", "()Ljava/lang/String;", "getActivityName$annotations", "()V", "activityName", "", "getStartTime", "()J", "getStartTime$annotations", DyPayConstant.KEY_START_TIME, "getEndTime", "getEndTime$annotations", "endTime", "Lcom/bytedance/android/live/base/model/message/a5;", "Lcom/bytedance/android/live/base/model/message/ITextKt;", "getDisplayTabText", "()Lcom/bytedance/android/live/base/model/message/a5;", "getDisplayTabText$annotations", "displayTabText", "", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getTabImageList", "()Ljava/util/List;", "getTabImageList$annotations", "tabImageList", "getSearchTabText", "getSearchTabText$annotations", "searchTabText", "getRulePageUrl", "getRulePageUrl$annotations", "rulePageUrl", "getRandomButtonImage", "()Lpy/k;", "getRandomButtonImage$annotations", "randomButtonImage", "getRandomButtonText", "getRandomButtonText$annotations", "randomButtonText", "getInviteButtonImage", "getInviteButtonImage$annotations", "inviteButtonImage", "getInviteButtonText", "getInviteButtonText$annotations", "inviteButtonText", "getBackgroundImageList", "getBackgroundImageList$annotations", "backgroundImageList", "getTopRightImage", "getTopRightImage$annotations", "topRightImage", "getTopRightUrl", "getTopRightUrl$annotations", "topRightUrl", "getHistoryPageUrl", "getHistoryPageUrl$annotations", "historyPageUrl", "getStep", "getStep$annotations", "step", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface m0 extends vh7.c<m0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "activity_name")
    String getActivityName();

    @FieldName(name = "back_ground_images")
    List<py.k> getBackgroundImageList();

    @FieldName(name = "display_tab_text")
    com.bytedance.android.live.base.model.message.a5 getDisplayTabText();

    @FieldName(name = "end_time")
    long getEndTime();

    @FieldName(name = "history_page_url")
    String getHistoryPageUrl();

    @FieldName(name = "invite_battle_button_image")
    py.k getInviteButtonImage();

    @FieldName(name = "invite_battle_button_text")
    String getInviteButtonText();

    @FieldName(name = "random_battle_button_image")
    py.k getRandomButtonImage();

    @FieldName(name = "random_battle_button_text")
    String getRandomButtonText();

    @FieldName(name = "rule_page_url")
    String getRulePageUrl();

    @FieldName(name = "search_tab_text")
    String getSearchTabText();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getStartTime();

    @FieldName(name = "step")
    String getStep();

    @FieldName(name = "display_tab_images")
    List<py.k> getTabImageList();

    @FieldName(name = "top_right_image")
    py.k getTopRightImage();

    @FieldName(name = "top_right_image_tab_url")
    String getTopRightUrl();
}
