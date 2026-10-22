package com.bytedance.android.livesdk.chatroom.replay.paid.api;

import am3.g;
import com.bytedance.android.live.base.annotation.ForMain;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes7.dex */
@ForMain
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007R\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/replay/paid/api/a;", "", "", "Lcom/bytedance/android/livesdk/chatroom/replay/paid/api/b;", "mySellingTickets", "Ljava/util/List;", "getMySellingTickets", "()Ljava/util/List;", "moreSellingTickets", "getMoreSellingTickets", "searchedSellingTickets", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a implements h {

    @SerializedName("more_selling_tickets")
    protected List<b> moreSellingTickets;

    @SerializedName("my_selling_tickets")
    protected List<b> mySellingTickets;

    @SerializedName("searched_selling_tickets")
    protected List<b> searchedSellingTickets;

    public a() {
    }

    public a(g r100) {
        this.mySellingTickets = new ArrayList();
        this.moreSellingTickets = new ArrayList();
        this.searchedSellingTickets = new ArrayList();
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L16;
        if (r102 == 1) goto L14;
        if (r102 == 2) goto L13;
        if (r102 != 3) goto L11;
        List<b> r103 = this.searchedSellingTickets;
        b r104 = new b(r100);
    L15:
        r103.add(r104);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L13:
        r103 = this.moreSellingTickets;
        r104 = new b(r100);
        goto L15
    L14:
        r103 = this.mySellingTickets;
        r104 = new b(r100);
        goto L15
    L16:
        r100.d(r101);
    }

    public final List<b> a() {
        return this.searchedSellingTickets;
    }
}
