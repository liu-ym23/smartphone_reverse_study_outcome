package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001Bi\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\u001cJ\u0006\u0010!\u001a\u00020\u001cJ\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0018\u0010\u0013R\u001f\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceChooseConfig;", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceBaseConfig;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterFromType", "", "callback", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "commandCallback", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;", "outerChosenAnnouncementId", "", "chosenLinkAnnounceId", "announceTimeInMS", "outerParams", "", "", "(Landroid/content/Context;ILcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "getAnnounceTimeInMS", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getChosenLinkAnnounceId", "getCommandCallback", "()Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;", "getOuterChosenAnnouncementId", "getOuterParams", "()Ljava/util/Map;", "banEditFunc", "", "enableCreateBtnShow", "enableMoreFunction", "enableQuestBtnShow", "enableSettingShow", "enableShowShare", "isRedPacketSelectMode", "isSelectMode", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceChooseConfig extends OpenAnnounceBaseConfig {
    private final Long announceTimeInMS;
    private final Long chosenLinkAnnounceId;
    private final AnnounceCommandCallback commandCallback;
    private final Long outerChosenAnnouncementId;
    private final Map<String, String> outerParams;

    public final boolean isSelectMode() {
        Map<String, String> r100 = this.outerParams;     // Catch: Exception -> L16
        if (r100 == null) goto L8;
        String r101 = r100.get("list_display_mode");     // Catch: Exception -> L16
        if (r101 == null) goto L8;
        Integer r102 = Integer.valueOf(CastIntegerProtector.parseInt(r101));     // Catch: Exception -> L16
    L9:
        if (r102 == null) goto L21;
        if (r102.intValue() != 1) goto L22;
        return true;
    L22:
        return false;
    L21:
        return false;
    L8:
        r102 = null;
    L16:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public final boolean banEditFunc() {
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L5;
        String r101 = r100.get("ban_edit_when_select_mode");
    L7:
        return Boolean.parseBoolean(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean enableCreateBtnShow() {
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L5;
        String r101 = r100.get("hide_create_button");
    L7:
        if (Boolean.parseBoolean(r101) != true) goto L11;
        return false;
    L11:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean enableMoreFunction() {
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L5;
        String r101 = r100.get("hide_more_function_area");
    L7:
        if (Boolean.parseBoolean(r101) != true) goto L11;
        return false;
    L11:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean enableQuestBtnShow() {
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L5;
        String r101 = r100.get("hide_question_button");
    L7:
        return Boolean.parseBoolean(r101);
    L5:
        r101 = null;
        goto L7
    }

    public final boolean enableSettingShow() {
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L5;
        String r101 = r100.get("hide_setting_info_area");
    L7:
        if (Boolean.parseBoolean(r101) != true) goto L11;
        return false;
    L11:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean enableShowShare() {
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L5;
        String r101 = r100.get("hide_share_entrance");
    L7:
        if (Boolean.parseBoolean(r101) != true) goto L11;
        return false;
    L11:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final boolean isRedPacketSelectMode() {
        if (isSelectMode() == false) goto L11;
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L7;
        String r101 = r100.get("red_packet_limit");
    L9:
        if (Boolean.parseBoolean(r101) == false) goto L11;
        return true;
    L7:
        r101 = null;
    L11:
        return false;
    }

    public final Long getAnnounceTimeInMS() {
        return this.announceTimeInMS;
    }

    public final Long getChosenLinkAnnounceId() {
        return this.chosenLinkAnnounceId;
    }

    public final AnnounceCommandCallback getCommandCallback() {
        return this.commandCallback;
    }

    public final Long getOuterChosenAnnouncementId() {
        return this.outerChosenAnnouncementId;
    }

    public final Map<String, String> getOuterParams() {
        return this.outerParams;
    }

    public OpenAnnounceChooseConfig(Context r100, int r101, IAnnouncementService.AnnouncementDialogCallback r102, AnnounceCommandCallback r103, Long r104, Long r105, Long r106, Map<String, String> r107) {
        super(r100, r101, r102);
        this.commandCallback = r103;
        this.outerChosenAnnouncementId = r104;
        this.chosenLinkAnnounceId = r105;
        this.announceTimeInMS = r106;
        this.outerParams = r107;
    }

    public /* synthetic */ OpenAnnounceChooseConfig(Context r110, int r111, IAnnouncementService.AnnouncementDialogCallback r112, AnnounceCommandCallback r113, Long r114, Long r115, Long r116, Map r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 4) == 0) goto L5;
        IAnnouncementService.AnnouncementDialogCallback r100 = null;
    L7:
        if ((r211 & 8) == 0) goto L9;
        AnnounceCommandCallback r101 = null;
    L11:
        if ((r211 & 32) == 0) goto L13;
        Long r102 = 0L;
    L15:
        if ((r211 & 64) == 0) goto L17;
        Long r117 = 0L;
    L19:
        if ((r211 & 128) == 0) goto L21;
        Map r118 = null;
    L22:
        this(r110, r111, r100, r101, r114, r102, r117, r118);
        return;
    L21:
        r118 = r210;
        goto L22
    L17:
        r117 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
