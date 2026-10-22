package com.bytedance.android.livesdkapi.announcement;

import android.content.Context;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\r\u0018\u00002\u00020\u0001Be\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\u0002\u0010\u0012J\u0006\u0010\u001c\u001a\u00020\rJ\u0006\u0010\u001d\u001a\u00020\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0019R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceSettingConfig;", "Lcom/bytedance/android/livesdkapi/announcement/OpenAnnounceBaseConfig;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "enterFromType", "", "callback", "Lcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;", "commandCallback", "Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;", "announcementId", "", "fromChosenDialog", "", "isFromFansGroupEdit", "outerParams", "", "", "(Landroid/content/Context;ILcom/bytedance/android/livesdkapi/announcement/IAnnouncementService$AnnouncementDialogCallback;Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;Ljava/lang/Long;ZZLjava/util/Map;)V", "getAnnouncementId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCommandCallback", "()Lcom/bytedance/android/livesdkapi/announcement/AnnounceCommandCallback;", "getFromChosenDialog", "()Z", "getOuterParams", "()Ljava/util/Map;", "hideRedPackageItem", "returnWithoutCreateSucceed", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenAnnounceSettingConfig extends OpenAnnounceBaseConfig {
    private final Long announcementId;
    private final AnnounceCommandCallback commandCallback;
    private final boolean fromChosenDialog;
    private final boolean isFromFansGroupEdit;
    private final Map<String, String> outerParams;

    public final boolean hideRedPackageItem() {
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L7;
        String r101 = r100.get("hide_lucky_money_item");
        if (r101 == null) goto L7;
        return Boolean.parseBoolean(r101);
    L7:
        return false;
    }

    public final boolean returnWithoutCreateSucceed() {
        Map<String, String> r100 = this.outerParams;
        if (r100 == null) goto L7;
        String r101 = r100.get("return_after_create_succeed");
        if (r101 == null) goto L7;
        return Boolean.parseBoolean(r101);
    L7:
        return false;
    }

    public final Long getAnnouncementId() {
        return this.announcementId;
    }

    public final AnnounceCommandCallback getCommandCallback() {
        return this.commandCallback;
    }

    public final boolean getFromChosenDialog() {
        return this.fromChosenDialog;
    }

    public final Map<String, String> getOuterParams() {
        return this.outerParams;
    }

    public final boolean isFromFansGroupEdit() {
        return this.isFromFansGroupEdit;
    }

    public OpenAnnounceSettingConfig(Context r100, int r101, IAnnouncementService.AnnouncementDialogCallback r102, AnnounceCommandCallback r103, Long r104, boolean r105, boolean r106, Map<String, String> r107) {
        super(r100, r101, r102);
        this.commandCallback = r103;
        this.announcementId = r104;
        this.fromChosenDialog = r105;
        this.isFromFansGroupEdit = r106;
        this.outerParams = r107;
    }

    public /* synthetic */ OpenAnnounceSettingConfig(Context r110, int r111, IAnnouncementService.AnnouncementDialogCallback r112, AnnounceCommandCallback r113, Long r114, boolean r115, boolean r116, Map r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 4) == 0) goto L5;
        IAnnouncementService.AnnouncementDialogCallback r100 = null;
    L7:
        if ((r211 & 8) == 0) goto L9;
        AnnounceCommandCallback r101 = null;
    L11:
        if ((r211 & 32) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r211 & 64) == 0) goto L17;
        boolean r117 = false;
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
