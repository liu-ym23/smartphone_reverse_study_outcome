package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.byted.cast.common.auth.AuthConstants;
import com.bytedance.android.live.base.model.live.a;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.WelfareProjectInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u0011\u0010\u0018\u001a\u00020\u00178F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/WelfareProjectInfo;", "Lcom/bytedance/android/live/base/model/live/a;", "", "getProjectId", "_projectId", "J", "get_projectId", "()J", "set_projectId", "(J)V", "_showFrequency", "get_showFrequency", "set_showFrequency", "", "_containerCardUrl", "Ljava/lang/String;", "get_containerCardUrl", "()Ljava/lang/String;", "set_containerCardUrl", "(Ljava/lang/String;)V", "_welfareDetailPageUrl", "get_welfareDetailPageUrl", "set_welfareDetailPageUrl", "", "isValid", "()Z", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WelfareProjectInfo implements a, h {

    @SerializedName("container_card_url")
    protected String _containerCardUrl;

    @SerializedName(AuthConstants.PARAM_KEY_LICENSE_PROJECT_ID)
    protected long _projectId;

    @SerializedName("show_frequency")
    protected long _showFrequency;

    @SerializedName("welfare_detail_page_url")
    protected String _welfareDetailPageUrl;

    public WelfareProjectInfo() {
    }

    public final boolean isValid() {
        if (getProjectId() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.base.model.live.a
    public long getProjectId() {
        return this._projectId;
    }

    public final String get_containerCardUrl() {
        return this._containerCardUrl;
    }

    public final long get_projectId() {
        return this._projectId;
    }

    public final long get_showFrequency() {
        return this._showFrequency;
    }

    public final String get_welfareDetailPageUrl() {
        return this._welfareDetailPageUrl;
    }

    public WelfareProjectInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this._projectId = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this._showFrequency = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this._containerCardUrl = am3.h.c(r100);
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this._welfareDetailPageUrl = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void set_containerCardUrl(String r100) {
        this._containerCardUrl = r100;
    }

    public final void set_projectId(long r100) {
        this._projectId = r100;
    }

    public final void set_showFrequency(long r100) {
        this._showFrequency = r100;
    }

    public final void set_welfareDetailPageUrl(String r100) {
        this._welfareDetailPageUrl = r100;
    }
}
