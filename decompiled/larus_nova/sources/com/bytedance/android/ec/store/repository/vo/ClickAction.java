package com.bytedance.android.ec.store.repository.vo;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007R\"\u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/ec/store/repository/vo/ClickAction;", "Ljava/io/Serializable;", "()V", "sliceData", "", "", "", "(Ljava/util/Map;)V", ReportConstant.COMMON_ACTION_TYPE, "", "getActionType", "()Ljava/lang/Integer;", "setActionType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "jumpUrl", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "toastText", "getToastText", "setToastText", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ClickAction implements Serializable {

    @SerializedName("action_type")
    private Integer actionType;

    @SerializedName("jump_url")
    private String jumpUrl;
    private Map<String, ? extends Object> sliceData;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT)
    private String toastText;

    public ClickAction() {
    }

    public final Integer getActionType() {
        return this.actionType;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getToastText() {
        return this.toastText;
    }

    public ClickAction(Map<String, ? extends Object> r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        this.sliceData = r100;
        Object r101 = r100.get("action_type");
        Object r102 = null;
        if ((r101 instanceof Number) == true) goto L8;
        r101 = null;
    L8:
        Number r103 = (Number) r101;
        if (r103 == null) goto L11;
        Integer r104 = Integer.valueOf(r103.intValue());
    L12:
        this.actionType = r104;
        Object r105 = r100.get("jump_url");
        if ((r105 instanceof String) == true) goto L15;
        r105 = null;
    L15:
        this.jumpUrl = (String) r105;
        Object r106 = r100.get(ILiveRoomPlayFragmentConstant.EXTRA_TASK_TOKEN_TOAST_TEXT);
        if ((r106 instanceof String) == false) goto L19;
        r102 = r106;
    L19:
        this.toastText = (String) r102;
        return;
    L11:
        r104 = null;
        goto L12
    }

    public final void setActionType(Integer r100) {
        this.actionType = r100;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public final void setToastText(String r100) {
        this.toastText = r100;
    }
}
