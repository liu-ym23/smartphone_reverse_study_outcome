package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.VerticalTypeInfo")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0012\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/VerticalTypeInfo;", "", "()V", "eventExtra", "", "extra", "isSubTag", "", "Ljava/lang/Boolean;", "name", "priority", "", "tabType", "Ljava/lang/Long;", "tagId", "validTime", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VerticalTypeInfo implements h {

    @SerializedName("event_extra")
    public String eventExtra;

    @SerializedName("extra")
    public String extra;

    @SerializedName("is_sub_tag")
    public Boolean isSubTag;

    @SerializedName("name")
    public String name;

    @SerializedName("priority")
    public long priority;

    @SerializedName("tab_type")
    public Long tabType;

    @SerializedName("tag_id")
    public Long tagId;

    @SerializedName("valid_time")
    public long validTime;

    public VerticalTypeInfo() {
        this.isSubTag = Boolean.FALSE;
        this.validTime = -1;
        this.priority = -1;
    }

    public VerticalTypeInfo(g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L15;
        switch(r103) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L6;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L7:
        this.eventExtra = am3.h.c(r100);
        goto L3
    L8:
        this.extra = am3.h.c(r100);
        goto L3
    L9:
        this.priority = r100.j();
        r102 = r102 | 2;
        goto L3
    L10:
        this.validTime = r100.j();
        r102 = r102 | 1;
        goto L3
    L11:
        this.isSubTag = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L12:
        this.tagId = Long.valueOf(r100.j());
        goto L3
    L13:
        this.tabType = Long.valueOf(r100.j());
        goto L3
    L14:
        this.name = am3.h.c(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
        if (this.isSubTag != null) goto L19;
        this.isSubTag = Boolean.FALSE;
    L19:
        if ((r102 & 1) != 0) goto L22;
        this.validTime = -1;
    L22:
        if ((r102 & 2) != 0) goto L45;
        this.priority = -1;
        return;
    }
}
