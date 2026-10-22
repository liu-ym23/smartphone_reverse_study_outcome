package com.bytedance.android.livesdk.interactivity.like.api;

import am3.g;
import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes9.dex */
@ProtoMessage("webcast.api.room.GetLikeIconListResponse.ResponseData")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/api/b;", "", "", "Lcom/bytedance/android/live/base/model/ImageModel;", IconList.ELEM_NAME, "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "setIconList", "(Ljava/util/List;)V", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements h {

    @SerializedName("icons")
    protected List<? extends ImageModel> iconList;

    public b() {
    }

    public b(g r100) {
        this.iconList = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.iconList.add(x.a(r100));
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final List<ImageModel> a() {
        return this.iconList;
    }
}
