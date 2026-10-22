package com.bytedance.android.livesdk.chatroom.interact.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.api.battle.RivalsRecommendResponse.TabRivals")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R0\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/interact/model/p;", "", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/l;", "rivals", "Ljava/util/List;", "getRivals", "()Ljava/util/List;", "setRivals", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/chatroom/interact/model/n;", "tab", "Lcom/bytedance/android/livesdk/chatroom/interact/model/n;", "getTab", "()Lcom/bytedance/android/livesdk/chatroom/interact/model/n;", "setTab", "(Lcom/bytedance/android/livesdk/chatroom/interact/model/n;)V", "", "", "Lcom/bytedance/android/livesdk/chatroom/interact/model/GroupRivals;", "groupRivals", "Ljava/util/Map;", "getGroupRivals", "()Ljava/util/Map;", "setGroupRivals", "(Ljava/util/Map;)V", "", "defaultGroup", "I", "getDefaultGroup", "()I", "setDefaultGroup", "(I)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class p implements vh7.h {

    @SerializedName("default_group")
    protected int defaultGroup;

    @SerializedName("group_rivals")
    protected Map<Long, GroupRivals> groupRivals;

    @SerializedName("rivals")
    protected List<l> rivals;

    /* JADX INFO: renamed from: tab, reason: collision with root package name */
    @SerializedName("tab")
    protected n f106764tab;

    public p() {
    }

    public p(am3.g r110) {
        this.rivals = new ArrayList();
        this.groupRivals = new HashMap();
        long r100 = r110.c();
    L3:
        int r101 = r110.f();
        if (r101 == (-1)) goto L33;
        if (r101 != 1) goto L8;
        this.rivals.add(new l(r110));
        goto L3
    L8:
        if (r101 != 2) goto L10;
        this.f106764tab = new n(r110);
        goto L3
    L10:
        if (r101 != 3) goto L12;
        long r102 = r110.c();
        Long r103 = null;
        GroupRivals r104 = null;
    L16:
        int r105 = r110.f();
        if (r105 == (-1)) goto L23;
        if (r105 != 1) goto L19;
        r103 = Long.valueOf(r110.j());
        goto L16
    L19:
        if (r105 != 2) goto L20;
        r104 = new GroupRivals(r110);
        goto L16
    L20:
        am3.h.e(r110);
        goto L16
    L23:
        r110.d(r102);
        Map<Long, GroupRivals> r106 = this.groupRivals;
        if (r103 == null) goto L30;
        if (r104 == null) goto L28;
        r106.put(r103, r104);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L12:
        if (r101 != 4) goto L13;
        this.defaultGroup = r110.i();
        goto L3
    L13:
        am3.h.e(r110);
        goto L3
    L33:
        r110.d(r100);
    }
}
