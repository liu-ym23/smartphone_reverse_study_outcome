package com.alibaba.gaiax.model;

import com.alibaba.gaiax.api.GXIDataListener;
import com.alibaba.gaiax.api.GXIEventListener;
import com.alibaba.gaiax.api.GXITrackListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u0013\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0014HÖ\u0001J\t\u0010*\u001a\u00020+HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006,"}, d2 = {"Lcom/alibaba/gaiax/model/GXTemplateData;", "", "data", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "dataListener", "Lcom/alibaba/gaiax/api/GXIDataListener;", "getDataListener", "()Lcom/alibaba/gaiax/api/GXIDataListener;", "setDataListener", "(Lcom/alibaba/gaiax/api/GXIDataListener;)V", "eventListener", "Lcom/alibaba/gaiax/api/GXIEventListener;", "getEventListener", "()Lcom/alibaba/gaiax/api/GXIEventListener;", "setEventListener", "(Lcom/alibaba/gaiax/api/GXIEventListener;)V", "scrollIndex", "", "getScrollIndex", "()I", "setScrollIndex", "(I)V", "tag", "getTag", "()Ljava/lang/Object;", "setTag", "(Ljava/lang/Object;)V", "trackListener", "Lcom/alibaba/gaiax/api/GXITrackListener;", "getTrackListener", "()Lcom/alibaba/gaiax/api/GXITrackListener;", "setTrackListener", "(Lcom/alibaba/gaiax/api/GXITrackListener;)V", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "GaiaXAndroidApi_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GXTemplateData {
    private final JSONObject data;
    private GXIDataListener dataListener;
    private GXIEventListener eventListener;
    private int scrollIndex;
    private Object tag;
    private GXITrackListener trackListener;

    public static /* synthetic */ GXTemplateData copy$default(GXTemplateData r100, JSONObject r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.data;
    L6:
        return r100.copy(r101);
    }

    public final JSONObject component1() {
        return this.data;
    }

    public final GXTemplateData copy(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        return new GXTemplateData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GXTemplateData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.data, ((GXTemplateData) r100).data) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public String toString() {
        return "GXTemplateData(data=" + this.data + ')';
    }

    public final JSONObject getData() {
        return this.data;
    }

    public final GXIDataListener getDataListener() {
        return this.dataListener;
    }

    public final GXIEventListener getEventListener() {
        return this.eventListener;
    }

    public final int getScrollIndex() {
        return this.scrollIndex;
    }

    public final Object getTag() {
        return this.tag;
    }

    public final GXITrackListener getTrackListener() {
        return this.trackListener;
    }

    public GXTemplateData(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.data = r100;
        this.scrollIndex = -1;
    }

    public final void setDataListener(GXIDataListener r100) {
        this.dataListener = r100;
    }

    public final void setEventListener(GXIEventListener r100) {
        this.eventListener = r100;
    }

    public final void setScrollIndex(int r100) {
        this.scrollIndex = r100;
    }

    public final void setTag(Object r100) {
        this.tag = r100;
    }

    public final void setTrackListener(GXITrackListener r100) {
        this.trackListener = r100;
    }
}
