package com.bytedance.android.livesdk.chatroom.model.interact;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\f\u001a\u00020\b8&X§\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001a\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010!\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0006\u001a\u0004\b\u001f\u0010\u0014R\u001a\u0010$\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b#\u0010\u0006\u001a\u0004\b\"\u0010\u0014R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178&X§\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0006\u001a\u0004\b%\u0010\u0019R\u001a\u0010*\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b)\u0010\u0006\u001a\u0004\b(\u0010\u0004R\u001a\u0010-\u001a\u00020\u00128&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0006\u001a\u0004\b+\u0010\u0014R\u001a\u00102\u001a\u00020.8&X§\u0004¢\u0006\f\u0012\u0004\b1\u0010\u0006\u001a\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/b2;", "Lvh7/c;", "", "getTheme", "()Ljava/lang/String;", "getTheme$annotations", "()V", "theme", "", "getThemeType", "()I", "getThemeType$annotations", "themeType", "getSelectionType", "setSelectionType", "(I)V", "getSelectionType$annotations", "selectionType", "", "getWinCount", "()J", "getWinCount$annotations", "winCount", "", "getJudgesAwemeIdList", "()Ljava/util/List;", "getJudgesAwemeIdList$annotations", "judgesAwemeIdList", "getJudgesOpenIdList", "getJudgesOpenIdList$annotations", "judgesOpenIdList", "getMaxJudgesCount", "getMaxJudgesCount$annotations", "maxJudgesCount", "getMaxWinCount", "getMaxWinCount$annotations", "maxWinCount", "getServerThemeList", "getServerThemeList$annotations", "serverThemeList", "getCustomTheme", "getCustomTheme$annotations", "customTheme", "getMaxScore", "getMaxScore$annotations", "maxScore", "", "getCanEditScore", "()Z", "getCanEditScore$annotations", "canEditScore", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface b2 extends vh7.c<b2> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "can_edit_score")
    boolean getCanEditScore();

    @FieldName(name = "custom_theme")
    String getCustomTheme();

    @FieldName(name = "judges_user_id_list")
    List<Long> getJudgesAwemeIdList();

    @FieldName(name = "judges_open_id_list")
    List<String> getJudgesOpenIdList();

    @FieldName(name = "max_judges_count")
    long getMaxJudgesCount();

    @FieldName(name = "max_score")
    long getMaxScore();

    @FieldName(name = "max_win_count")
    long getMaxWinCount();

    @FieldName(name = "selection_type")
    int getSelectionType();

    @FieldName(name = "server_theme_list")
    List<String> getServerThemeList();

    @FieldName(name = "theme")
    String getTheme();

    @FieldName(name = "theme_type")
    int getThemeType();

    @FieldName(name = "win_count")
    long getWinCount();

    @FieldName(name = "selection_type#setter")
    void setSelectionType(int r100);
}
