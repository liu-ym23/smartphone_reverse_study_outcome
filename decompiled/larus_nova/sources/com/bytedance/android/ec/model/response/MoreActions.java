package com.bytedance.android.ec.model.response;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\fH\u0016R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/model/response/MoreActions;", "Ljava/io/Serializable;", "()V", SlcCommonAction.KEY_ACTIONS, "", "Lcom/bytedance/android/ec/model/response/Action;", "getActions", "()Ljava/util/List;", "setActions", "(Ljava/util/List;)V", "trackParams", "", "", "getTrackParams", "()Ljava/util/Map;", "setTrackParams", "(Ljava/util/Map;)V", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class MoreActions implements Serializable {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private List<Action> actions;

    @SerializedName("track_params")
    private Map<String, String> trackParams;

    public MoreActions() {
    }

    public String toString() {
        List<Action> r100 = this.actions;
        if (r100 == null) goto L10;
        List<Action> r101 = r100;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<T> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r102.add(((Action) r103.next()).getTitle());
        goto L6
    L8:
        String r104 = CollectionsKt.joinToString$default(r102, ",", null, null, 0, null, null, 62, null);
        if (r104 == null) goto L10;
        return r104;
    L10:
        return "";
    }

    public final List<Action> getActions() {
        return this.actions;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public final void setActions(List<Action> r100) {
        this.actions = r100;
    }

    public final void setTrackParams(Map<String, String> r100) {
        this.trackParams = r100;
    }
}
