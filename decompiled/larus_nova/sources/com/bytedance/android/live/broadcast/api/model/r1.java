package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.anchor.TemplateListComponent")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/r1;", "", "", "Lcom/bytedance/android/live/broadcast/api/model/z;", "ideaTemplateInfo", "Ljava/util/List;", "Lcom/bytedance/android/live/broadcast/api/model/y;", "ideaEffectInfo", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r1 implements vh7.h {

    @SerializedName("idea_effect_info")
    public List<y> ideaEffectInfo;

    @SerializedName("idea_template_info")
    public List<z> ideaTemplateInfo;

    public r1() {
    }

    public r1(am3.g r100) {
        this.ideaTemplateInfo = new ArrayList();
        this.ideaEffectInfo = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        if (r102 == 1) goto L11;
        if (r102 != 2) goto L9;
        List r103 = this.ideaEffectInfo;
        vh7.h r104 = new y(r100);
    L12:
        r103.add(r104);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L11:
        r103 = this.ideaTemplateInfo;
        r104 = new z(r100);
        goto L12
    L13:
        r100.d(r101);
    }
}
