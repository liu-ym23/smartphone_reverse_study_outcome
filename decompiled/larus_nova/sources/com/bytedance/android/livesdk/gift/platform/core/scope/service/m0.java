package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class m0 implements com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, ArrayList<sz1.a>> f131633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, ArrayList<com.bytedance.android.livesdk.gift.model.e3>> f131634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.core.giftlist.i f131635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f f131636d;

    public static final class a<T> implements SingleOnSubscribe {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m0 f131637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f131638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f131639c;

        public a(m0 r100, ArrayList r101, long r102) {
            this.f131637a = r100;
            this.f131638b = r101;
            this.f131639c = r102;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public final void subscribe(SingleEmitter<Object> r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            this.f131637a.d(this.f131638b, this.f131639c);
        }
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
        this.f131633a.clear();
        this.f131634b.clear();
    }

    public final void d(ArrayList<sz1.a> r100, long r101) {
        ArrayList<String> r102 = new ArrayList();
        Iterator<sz1.a> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add(r103.next().convertToString());
        goto L4
    L6:
        Map<String, ArrayList<String>> r104 = ay1.b.b();
        r104.put(String.valueOf(r101), r102);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        ay1.b.f16723y.setValue(null, ay1.b.f16675a[27], r104);
    }

    public m0(e1 r100, com.bytedance.android.livesdk.gift.platform.core.giftlist.i r101, com.bytedance.android.livesdk.gift.platform.business.dialog.v3.datastore.f r102) {
        Intrinsics.checkNotNullParameter(r100, "giftListService");
        Intrinsics.checkNotNullParameter(r101, "giftListRepo");
        Intrinsics.checkNotNullParameter(r102, "giftDiyDataStore");
        this.f131635c = r101;
        this.f131636d = r102;
        this.f131633a = new HashMap();
        this.f131634b = new HashMap();
    }

    public final void c(ArrayList<com.bytedance.android.livesdk.gift.model.e3> r100, long r101, boolean r110) {
        ArrayList<sz1.a> r102 = this.f131633a.get(String.valueOf(r101));
        int r103 = 0;
        if (r102 == null) goto L5;
        int r104 = r102.size();
    L6:
        int r105 = 0;
    L7:
        sz1.a r106 = null;
        if (r105 >= r104) goto L18;
        if (r102 == null) goto L13;
        sz1.a r107 = (sz1.a) ListProtector.get(r102, r105);
        if (r107 == null) goto L13;
        ArrayList<com.bytedance.android.livesdk.gift.model.e3> r108 = gz1.c.g(r107);
    L15:
        if (gz1.c.h(r108, r100) == true) goto L18;
        r105 = r105 + 1;
    L13:
        r108 = null;
    L18:
        if (r110 == false) goto L61;
        ArrayList<sz1.a> r111 = this.f131636d.f127288a.get(String.valueOf(r101));
        if (r111 == null) goto L22;
        int r109 = r111.size();
    L23:
        int r112 = 0;
    L24:
        if (r112 >= r109) goto L34;
        if (r111 == null) goto L29;
        sz1.a r113 = (sz1.a) ListProtector.get(r111, r112);
        if (r113 == null) goto L29;
        ArrayList<com.bytedance.android.livesdk.gift.model.e3> r114 = gz1.c.g(r113);
    L31:
        if (gz1.c.h(r114, r100) == true) goto L35;
        r112 = r112 + 1;
    L35:
        if (r112 < 0) goto L41;
        if (r111 == null) goto L38;
        r103 = r111.size();
    L38:
        if (r112 >= r103) goto L41;
        if (r111 == null) goto L41;
        sz1.a r115 = (sz1.a) ListProtector.remove(r111, r112);
    L41:
        ArrayList<String> r116 = ay1.b.b().get(String.valueOf(r101));
        if (r116 != null) goto L44;
        r116 = new ArrayList();
    L44:
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r116.iterator();
    L46:
        if (r118.hasNext() == false) goto L51;
        String r119 = (String) r118.next();
        sz1.a r120 = new sz1.a();
        r120.convertFromString(r119);
        if (gz1.c.h(r100, gz1.c.g(r120)) == false) goto L50;
        r106 = r120;
    L50:
        r117.add(r120);
        goto L46
    L51:
        if (r106 == null) goto L62;
        r117.remove(r106);
        Single.create(new a(this, r117, r101)).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.livesdk.user.h());
        return;
    L62:
        return;
    L29:
        r114 = null;
        goto L31
    L34:
        r112 = -1;
        goto L35
    L22:
        r109 = 0;
        goto L23
    L61:
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public static final void a(m0 r100, long r101, sz1.a r102, ArrayList r103) {
        r100.getClass();
        ArrayList<String> r104 = ay1.b.b().get(String.valueOf(r101));
        if (r104 != null) goto L5;
        r104 = new ArrayList();
    L5:
        ArrayList<sz1.a> r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
        sz1.a r107 = null;
    L7:
        if (r106.hasNext() == false) goto L18;
        String r108 = (String) r106.next();
        sz1.a r109 = new sz1.a();
        r109.convertFromString(r108);
        if (r102 != null) goto L11;
    L12:
        if (r103 == null) goto L16;
        if (gz1.c.h(r103, gz1.c.g(r109)) == false) goto L16;
    L15:
        r107 = r109;
    L16:
        r105.add(r109);
        goto L7
    L11:
        if (gz1.b.c(r109, r102) == true) goto L15;
    L18:
        if (r107 != null) goto L20;
        if (r102 == null) goto L27;
    L32:
        if (r102 == null) goto L40;
        ListProtector.add(r105, 0, r102);
        r100.d(r105, r101);
        return;
    L40:
        return;
    L27:
        if (Lists.isEmpty(r103) == true) goto L32;
        r102 = new sz1.a();
        if (r103 == null) goto L31;
        Intrinsics.checkNotNullParameter(r102, "$this$plugins");
        Intrinsics.checkNotNullParameter(r103, "value");
        r102.setPluginsFlex(r103);
    L31:
        r102.setRecommend(true);
        goto L32
    L20:
        if (r105.remove(r107) == false) goto L24;
        if (r102 != null) goto L23;
        r102 = r107;
    L23:
        ListProtector.add(r105, 0, r102);
    L24:
        r100.d(r105, r101);
    }
}
