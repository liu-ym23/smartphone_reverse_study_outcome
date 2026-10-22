package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarBizSkin;
import com.bytedance.android.livesdkapi.depend.model.live.IToolbarComponentSkin;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class SkinLoader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList<w2> f114372b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f114373c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, v2> f114374a;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static boolean b() {
            return com.bytedance.android.livesdk.chatroom.setting.j.f111528a.getValue().booleanValue();
        }

        @JvmStatic
        public static void f() {
            com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.v r100 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.v.f116208a;
            Intrinsics.checkNotNullParameter(r100, "factory");
            Iterator<w2> r101 = SkinLoader.f114372b.iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            w2 r102 = r101.next();
            r102.getName();
            if (Intrinsics.areEqual("SkinAnimHandlerFactory", "SkinAnimHandlerFactory") == false) goto L4;
        L9:
            w2 r103 = r102;
            ArrayList<w2> r104 = SkinLoader.f114372b;
            if (r104 == null) goto L14;
            TypeIntrinsics.asMutableCollection(r104).remove(r103);
            r104.add(r100);
            return;
        L14:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        L8:
            r102 = null;
            goto L9
        }

        public static void c(Function0 r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L6;
            ALogger.i("SkinLoader", (String) r100.invoke());
            return;
        }

        public static SkinLoader e(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s r100) {
            if (r100 == null) goto L5;
            Map<String, v2> r101 = r100.f116199i;
        L7:
            return new SkinLoader(r101);
        L5:
            r101 = null;
            goto L7
        }

        public static HashMap a(boolean r100, IToolbarComponentSkin r101) {
            Intrinsics.checkNotNullParameter(r101, "skinComponent");
            HashMap r102 = new HashMap();
            Map<String, IToolbarBizSkin> r103 = r101.getGeneral();
            if (r103 == null) goto L11;
            Iterator<Map.Entry<String, IToolbarBizSkin>> r104 = r103.entrySet().iterator();
        L6:
            if (r104.hasNext() == false) goto L11;
            Map.Entry<String, IToolbarBizSkin> r105 = r104.next();
            String r106 = r105.getKey();
            py.k r107 = r105.getValue().getSkinImg();
            if (r106 == null) goto L6;
            if (r107 == null) goto L6;
            r102.put(r106, new v2(r107));
        L11:
            if (r100 == false) goto L13;
            Map<String, IToolbarBizSkin> r108 = r101.getVertical();
        L14:
            if (r108 == null) goto L22;
            Iterator<Map.Entry<String, IToolbarBizSkin>> r109 = r108.entrySet().iterator();
        L17:
            if (r109.hasNext() == false) goto L22;
            Map.Entry<String, IToolbarBizSkin> r110 = r109.next();
            String r111 = r110.getKey();
            py.k r112 = r110.getValue().getSkinImg();
            if (r111 == null) goto L17;
            if (r112 == null) goto L17;
            r102.put(r111, new v2(r112));
        L22:
            return r102;
        L13:
            r108 = r101.getLandscape();
            goto L14
        }

        public static SkinLoader d(int r100, Room r101, boolean r102) {
            if (r101 == null) goto L11;
            ILiveToolbarData r103 = r101.getToolbarData();
            if (r103 == null) goto L11;
            Map<Integer, IToolbarComponentSkin> r104 = r103.getSkinResource();
            if (r104 == null) goto L11;
            IToolbarComponentSkin r105 = r104.get(Integer.valueOf(r100));
            if (r105 == null) goto L11;
            HashMap r106 = a(r102, r105);
        L13:
            return new SkinLoader(r106);
        L11:
            r106 = null;
            goto L13
        }
    }

    static {
        f114373c = new a();
        f114372b = new ArrayList();
    }

    public SkinLoader(Map<String, v2> r100) {
        this.f114374a = r100;
    }

    public static z2 a(v2 r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.f114652a;
    L6:
        boolean r103 = r102 instanceof String;
        if (r103 == false) goto L18;
        py.k r104 = (py.k) vh7.f.c(py.k.class);
        if (r103 == false) goto L12;
        r101 = r102;
    L12:
        String r105 = (String) r101;
        if (r105 != null) goto L15;
        r105 = "";
    L15:
        r104.setUrls(CollectionsKt.listOf(r105));
        Unit r106 = Unit.INSTANCE;
        return new q2(r104);
    L18:
        if ((r102 instanceof py.k) == false) goto L22;
        return new q2((py.k) r102);
    L22:
        if ((r102 instanceof Integer) == false) goto L26;
        return new t1(r102);
    L26:
        if ((r102 instanceof Drawable) == true) goto L28;
        return null;
    L28:
        return new t1(r102);
    L5:
        r102 = null;
        goto L6
    }

    public final String b(x2 r100) {
        Intrinsics.checkNotNullParameter(r100, "resKey");
        Map<String, v2> r101 = this.f114374a;
        if (r101 == null) goto L8;
        v2 r102 = r101.get(r100.f114665a.getKey());
        if (r102 == null) goto L8;
        Object r103 = r102.f114652a;
        if (r103 == null) goto L8;
    L13:
        if ((r103 instanceof String) == false) goto L16;
        return (String) r103;
    L16:
        if ((r103 instanceof py.k) == true) goto L18;
        return null;
    L18:
        return (String) CollectionsKt.getOrNull(((py.k) r103).getUrls(), 0);
    L8:
        v2 r104 = r100.f114666b;
        if (r104 == null) goto L11;
        r103 = r104.f114652a;
        goto L13
    L11:
        r103 = null;
        goto L13
    }

    public final void c(x2 r100, View r101, a4 r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "view");
        if (r101.getVisibility() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        r102.b(SkinLoadResultType.ERROR, "warn:view is invisible");
    L8:
        ArrayList<v2> r104 = new ArrayList();
        Map<String, v2> r105 = this.f114374a;
        if (r105 == null) goto L13;
        v2 r106 = r105.get(r100.f114665a.getKey());
        if (r106 == null) goto L13;
        r104.add(r106);
    L13:
        v2 r107 = r100.f114666b;
        if (r107 == null) goto L16;
        r104.add(r107);
    L16:
        d(r104, 0, r101, r102);
        return;
    L5:
        r103 = false;
        goto L6
    }

    public final void d(ArrayList<v2> r100, int r110, View r111, a4 r112) {
        if (r110 < r100.size()) goto L7;
        if (r112 == null) goto L14;
        r112.b(SkinLoadResultType.ERROR, "all_data_failed");
        return;
    L14:
        return;
    L7:
        z2 r101 = a((v2) ListProtector.get(r100, r110));
        b4.a(r101, SkinLoader$loopLoadImg$1.INSTANCE);
        if (r101 == null) goto L15;
        Disposable r102 = r101.b(r111, new SkinLoader$loopLoadImg$2(this, r112, r110, r100, r111));
        if (r102 == null) goto L16;
        if (r112 == null) goto L17;
        r112.a(r102);
        return;
    L17:
        return;
    L16:
        return;
    }
}
