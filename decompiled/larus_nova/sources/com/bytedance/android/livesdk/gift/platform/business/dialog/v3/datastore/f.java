package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore;

import android.text.TextUtils;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, ArrayList<sz1.a>> f127288a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f127288a.clear();
    }

    public f() {
        this.f127288a = new HashMap();
    }

    public static int c(List r100, com.bytedance.android.livesdk.gift.model.n r101) {
        Intrinsics.checkNotNullParameter(r101, BrowserDependency.UrlClickType.CARD);
        if (r100 == null) goto L12;
        Iterator r102 = r100.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L11;
        if (gz1.b.c((com.bytedance.android.livesdk.gift.model.n) r102.next(), r101) == true) goto L13;
        r103 = r103 + 1;
    L13:
        if (r103 != (-1)) goto L16;
        return 0;
    L16:
        return r103;
    L11:
        r103 = -1;
        goto L13
    L12:
        r103 = 0;
        goto L13
    }

    public final List<com.bytedance.android.livesdk.gift.model.n> d(long r100, com.bytedance.android.livesdk.gift.model.p r101) {
        Intrinsics.checkNotNullParameter(r101, "diyGiftToolbarInfo");
        ArrayList r102 = new ArrayList();
        ArrayList<sz1.a> r103 = this.f127288a.get(String.valueOf(r100));
        if (r103 != null) goto L11;
        r103 = new ArrayList();
        ArrayList<String> r104 = ay1.b.b().get(String.valueOf(r100));
        if (r104 == null) goto L10;
        Iterator<T> r105 = r104.iterator();
    L8:
        if (r105.hasNext() == false) goto L10;
        String r106 = (String) r105.next();
        sz1.a r107 = new sz1.a();
        r107.convertFromString(r106);
        r103.add(r107);
    L10:
        this.f127288a.put(String.valueOf(r100), r103);
    L11:
        ArrayList r108 = new ArrayList();
        if (r103.size() > r101.getMaxLocalCardNumber()) goto L14;
        r108.addAll(r103);
    L17:
        ArrayList<com.bytedance.android.livesdk.gift.model.n> r109 = new ArrayList();
        if (Lists.isEmpty(r101.getForceIndexCards()) == false) goto L20;
        ArrayList<com.bytedance.android.livesdk.gift.model.n> r110 = new ArrayList();
    L22:
        if (Lists.isEmpty(r101.getCards()) == false) goto L24;
        ArrayList<com.bytedance.android.livesdk.gift.model.n> r111 = new ArrayList();
    L25:
        Iterator r112 = r108.iterator();
    L27:
        if (r112.hasNext() == false) goto L35;
        sz1.a r113 = (sz1.a) r112.next();
        if (a(r113, r109, r110) == true) goto L27;
        if (a(r113, r109, r111) == true) goto L27;
        if (r113.isNewCard() == false) goto L27;
        r109.add(r113);
        goto L27
    L35:
        Iterator r114 = CollectionsKt.take(r110, r101.getMaxTotalCardNumber()).iterator();
    L37:
        if (r114.hasNext() == false) goto L39;
        r102.add((com.bytedance.android.livesdk.gift.model.n) r114.next());
        goto L37
    L39:
        Iterator r115 = CollectionsKt.take(r109, r101.getMaxTotalCardNumber() - r102.size()).iterator();
    L41:
        if (r115.hasNext() == false) goto L43;
        r102.add((com.bytedance.android.livesdk.gift.model.n) r115.next());
        goto L41
    L43:
        Iterator r116 = CollectionsKt.take(r111, r101.getMaxTotalCardNumber() - r102.size()).iterator();
    L45:
        if (r116.hasNext() == false) goto L47;
        r102.add((com.bytedance.android.livesdk.gift.model.n) r116.next());
        goto L45
    L47:
        return r102;
    L24:
        r111 = new ArrayList(r101.getCards());
        goto L25
    L20:
        r110 = new ArrayList(r101.getForceIndexCards());
        goto L22
    L14:
        int r117 = r101.getMaxLocalCardNumber();
        int r118 = 0;
    L15:
        if (r118 >= r117) goto L17;
        r108.add(ListProtector.get(r103, r118));
        r118 = r118 + 1;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean a(sz1.a r100, ArrayList<com.bytedance.android.livesdk.gift.model.n> r101, ArrayList<com.bytedance.android.livesdk.gift.model.n> r102) {
        int r103 = r102.size();
        boolean r104 = false;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L19;
        if (gz1.c.h(gz1.c.g(r100), gz1.c.g((com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r102, r105))) == true) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        r104 = true;
        if (r100.isRecommend() == false) goto L17;
        com.bytedance.android.livesdk.gift.model.n r106 = (com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r102, r105);
        Intrinsics.checkNotNullParameter(r106, BrowserDependency.UrlClickType.CARD);
        if ((!r106.getNotCache()) == false) goto L17;
        com.bytedance.android.livesdk.gift.model.n r107 = (com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r102, r105);
        if (TextUtils.isEmpty(((com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r102, r105)).getMainTextAfterSend()) == true) goto L15;
        String r108 = ((com.bytedance.android.livesdk.gift.model.n) ListProtector.get(r102, r105)).getMainTextAfterSend();
        if (r108 != null) goto L16;
        r108 = s1.B(R.string.ttlive_diy_gift_last_send);
    L16:
        r107.setMainText(r108);
        goto L17
    L15:
        r108 = s1.B(R.string.ttlive_diy_gift_last_send);
    L17:
        r101.add(ListProtector.get(r102, r105));
    L20:
        if (r105 >= 0) goto L22;
    L24:
        return r104;
    L22:
        if (r105 >= r102.size()) goto L24;
        ListProtector.remove(r102, r105);
        goto L24
    L19:
        r105 = -1;
        goto L20
    }
}
