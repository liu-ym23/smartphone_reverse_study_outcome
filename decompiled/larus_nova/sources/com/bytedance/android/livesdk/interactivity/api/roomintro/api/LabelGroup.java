package com.bytedance.android.livesdk.interactivity.api.roomintro.api;

import am3.g;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR&\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/roomintro/api/LabelGroup;", "", "()V", "groupName", "", "getGroupName", "()Ljava/lang/String;", "setGroupName", "(Ljava/lang/String;)V", "groupText", "getGroupText", "setGroupText", "labels", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/RoomIntroLabel;", "getLabels", "()Ljava/util/List;", "setLabels", "(Ljava/util/List;)V", "interactivity-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LabelGroup implements h {

    @SerializedName("group_name")
    protected String groupName;

    @SerializedName("group_text")
    protected String groupText;

    @SerializedName("labels")
    protected List<RoomIntroLabel> labels;

    public LabelGroup() {
    }

    public LabelGroup(g r100) {
        this.labels = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.groupName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.groupText = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.labels.add(new RoomIntroLabel(r100));
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final String getGroupText() {
        return this.groupText;
    }

    public final List<RoomIntroLabel> getLabels() {
        return this.labels;
    }

    public final void setGroupName(String r100) {
        this.groupName = r100;
    }

    public final void setGroupText(String r100) {
        this.groupText = r100;
    }

    public final void setLabels(List<RoomIntroLabel> r100) {
        this.labels = r100;
    }
}
