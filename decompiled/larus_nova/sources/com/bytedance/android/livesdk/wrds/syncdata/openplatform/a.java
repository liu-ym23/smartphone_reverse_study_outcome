package com.bytedance.android.livesdk.wrds.syncdata.openplatform;

import am3.g;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.ShelfSupplementInfo")
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/wrds/syncdata/openplatform/a;", "", "", "type", "Ljava/lang/String;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "avatars", "Ljava/util/List;", PerfLog.PARAM_KEY_CONTEXT_ID, "", "amount", "J", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("amount")
    public long amount;

    @SerializedName("user_img")
    public List<? extends ImageModel> avatars;

    @SerializedName(PerfLog.PARAM_KEY_CONTEXT_ID)
    public String context;

    @SerializedName("type_str")
    public String type;

    public a() {
    }

    public a(g r100) {
        this.avatars = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.context = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.type = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.amount = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.avatars.add(x.a(r100));
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }
}
