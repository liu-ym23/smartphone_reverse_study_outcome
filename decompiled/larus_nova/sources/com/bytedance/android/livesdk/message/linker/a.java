package com.bytedance.android.livesdk.message.linker;

import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.multianchor.model.BizExtra;
import com.bytedance.android.live.liveinteract.plantform.model.RoomLinkerContent;
import com.bytedance.android.live.liveinteract.plantform.model.p1;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.api.linkmic.ListResponse.ResponseData")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/message/linker/a;", "", "", "Lcom/bytedance/android/live/liveinteract/multianchor/model/AnchorLinkUser;", "mLinkUsers", "Ljava/util/List;", "b", "()Ljava/util/List;", "setMLinkUsers", "(Ljava/util/List;)V", "", "", "Lcom/bytedance/android/live/liveinteract/plantform/model/RoomLinkerContent;", "linkerContentMap", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setLinkerContentMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/live/liveinteract/multianchor/model/BizExtra;", "extra", "Lcom/bytedance/android/live/liveinteract/multianchor/model/BizExtra;", "getExtra", "()Lcom/bytedance/android/live/liveinteract/multianchor/model/BizExtra;", "setExtra", "(Lcom/bytedance/android/live/liveinteract/multianchor/model/BizExtra;)V", "<init>", "()V", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements vh7.h {

    @SerializedName("extra")
    protected BizExtra extra;

    @SerializedName("linker_content_map")
    protected Map<Long, ? extends RoomLinkerContent> linkerContentMap;

    @SerializedName("user")
    protected List<AnchorLinkUser> mLinkUsers;

    public a() {
    }

    public final String toString() {
        return "AnchorLinkUserList{mLinkUsers=" + this.mLinkUsers + ", linkerContentMap=" + this.linkerContentMap + '}';
    }

    public final Map<Long, RoomLinkerContent> a() {
        return this.linkerContentMap;
    }

    public final List<AnchorLinkUser> b() {
        return this.mLinkUsers;
    }

    public a(am3.g r110) {
        this.mLinkUsers = new ArrayList();
        this.linkerContentMap = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L31;
        if (r101 != 1) goto L8;
        this.mLinkUsers.add(new AnchorLinkUser(r110));
        goto L3
    L8:
        if (r101 != 3) goto L10;
        long r102 = r110.c();
        Long r103 = null;
        RoomLinkerContent r104 = null;
    L14:
        int r105 = r110.f();
        if (r105 == (-1)) goto L22;
        if (r105 != 1) goto L18;
        r103 = Long.valueOf(r110.j());
        goto L14
    L18:
        if (r105 != 2) goto L19;
        r104 = p1.a(r110);
        goto L14
    L19:
        am3.h.e(r110);
        goto L14
    L22:
        r110.d(r102);
        Map<Long, ? extends RoomLinkerContent> r106 = this.linkerContentMap;
        if (r103 == null) goto L29;
        if (r104 == null) goto L27;
        r106.put(r103, r104);
        goto L3
    L27:
        throw new IllegalStateException("Value must not be null");
    L29:
        throw new IllegalStateException("Key must not be null");
    L10:
        if (r101 != 7) goto L11;
        this.extra = new BizExtra(r110);
        goto L3
    L11:
        am3.h.e(r110);
        goto L3
    L31:
        r110.d(r100);
    }
}
