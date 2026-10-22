package com.bytedance.android.livesdk.interactivity;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.config.il0;
import com.bytedance.android.livesdkapi.depend.model.live.BottomCard;
import com.bytedance.android.livesdkapi.publicscreen.AbsPublicScreenBottomWidget;
import com.bytedance.android.livesdkapi.publicscreen.IPublicScreenBottomListener;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.IExternalWidget;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<AbsPublicScreenBottomWidget, v> f141293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.a f141294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f141295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<String> f141296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f141297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<BottomCard> f141298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ViewGroup f141299g;

    public static final class a implements IPublicScreenBottomListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f141300a;

        @Override // com.bytedance.android.livesdkapi.publicscreen.IPublicScreenBottomListener
        public final void onFail() {
            if (com.bytedance.android.live.core.utils.v.a() == false) goto L5;
            f2.c("load " + ((AbsPublicScreenBottomWidget) this.f141300a.getKey()).getBusinessName() + " error", 0);
        L5:
            int r100 = t.f141184a;
            ALogger.e("PSBottomWidget", "load " + ((AbsPublicScreenBottomWidget) this.f141300a.getKey()).getBusinessName() + " error");
        }

        public a(Map.Entry r100) {
            this.f141300a = r100;
        }
    }

    public final void a() {
        int r100 = t.f141184a;
        ALogger.i("PSBottomWidget", "total widget count:" + this.f141293a.size());
        Iterator<Map.Entry<AbsPublicScreenBottomWidget, v>> r101 = this.f141293a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L25;
        Map.Entry<AbsPublicScreenBottomWidget, v> r102 = r101.next();
        Iterator<T> r103 = this.f141298f.iterator();
    L6:
        String r104 = null;
        if (r103.hasNext() == false) goto L16;
        Object r105 = r103.next();
        String r106 = ((BottomCard) r105).getName();
        if (r106 != null) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L6;
    L17:
        BottomCard r108 = (BottomCard) r105;
        if (r108 == null) goto L20;
        r104 = r108.getBizParams();
    L20:
        v r109 = r102.getValue();
        a r110 = new a(r102);
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "callback");
        if (r109.f141424a == true) goto L24;
        int r111 = t.f141184a;
        ALogger.i("PSBottomWidget", r109.f141428e.getBusinessName() + " onInit");
        r109.f141428e.onInit(r104, r110);
        r109.f141424a = true;
    L24:
        r102.getValue().onLoad();
        goto L4
    L11:
        if (r106.equals(r102.getKey().getBusinessName()) != true) goto L13;
        r107 = true;
        goto L14
    L16:
        r105 = null;
        goto L17
    }

    public final void b(IExternalWidget r100) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof AbsPublicScreenBottomWidget) == true) goto L5;
        IExternalWidget r101 = null;
    L6:
        AbsPublicScreenBottomWidget r102 = (AbsPublicScreenBottomWidget) r101;
        if (r102 != null) goto L9;
        return;
    L9:
        int r103 = t.f141184a;
        ALogger.i("PSBottomWidget", ((AbsPublicScreenBottomWidget) r100).getBusinessName() + " request dismiss");
        v r104 = this.f141293a.get(r102);
        if (r104 == null) goto L13;
        r104.onViewWillDetach();
        this.f141299g.removeAllViews();
        r104.onViewDetached();
        return;
    L13:
        return;
    L5:
        r101 = r100;
        goto L6
    }

    public u(List<BottomCard> r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "cardInfo");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f141298f = r100;
        this.f141299g = r101;
        this.f141293a = new HashMap();
        this.f141295c = il0.f120463a.getValue();
        this.f141296d = new ArrayList();
        Iterator<BottomCard> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        String r103 = r102.next().getName();
        if (r103 == null) goto L4;
        this.f141296d.add(r103);
        goto L4
    }
}
