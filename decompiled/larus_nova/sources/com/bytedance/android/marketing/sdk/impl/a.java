package com.bytedance.android.marketing.sdk.impl;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.EventCenter;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import fx2.f;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, f> f162690a = null;

    /* JADX INFO: renamed from: com.bytedance.android.marketing.sdk.impl.a$a, reason: collision with other inner class name */
    public static final class C2485a implements JsEventSubscriber {
        public C2485a() {
        }

        @Override // com.bytedance.ies.xbridge.event.JsEventSubscriber
        public final void onReceiveJsEvent(Js2NativeEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "jsEvent");
            XReadableMap r101 = r100.getParams();
            ViewParent r102 = null;
            if (r101 == null) goto L5;
            String r103 = r101.getString("component_id");
        L6:
            HashMap<String, f> r104 = a.f162690a;
            if (r103 != null) goto L9;
        L12:
            boolean r105 = true;
        L13:
            if (r105 == true) goto L31;
            f r106 = a.f162690a.get(r103);
            if (r106 == null) goto L30;
            View r107 = r106.getHybridView();
            if (r107 == null) goto L20;
            ViewParent r108 = r107.getParent();
        L22:
            if ((r108 instanceof ViewGroup) == false) goto L25;
            r102 = r108;
        L25:
            ViewGroup r109 = (ViewGroup) r102;
            if (r109 == null) goto L28;
            r109.removeView(r107);
        L28:
            r106.release();
            return;
        L20:
            r108 = null;
            goto L22
        L30:
            return;
        L31:
            return;
        L9:
            if (r103.length() == 0) goto L12;
            r105 = false;
            goto L13
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        f162690a = new HashMap();
        EventCenter.registerJsEventSubscriber("ecom.marketing.close_event", new C2485a());
    }

    public static void a(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, BdpAppEventConstant.PARAMS_RIT);
        FragmentActivity r103 = null;
        if ((r100 instanceof ContextWrapper) == true) goto L5;
        r100 = null;
    L5:
        ContextWrapper r104 = (ContextWrapper) r100;
        boolean r105 = true;
        if (r104 == null) goto L25;
        int r106 = 50;
    L9:
        if (r106 <= 0) goto L11;
        r106 = r106 - 1;
        boolean r107 = true;
    L12:
        if (r107 == false) goto L25;
        if ((r104 instanceof FragmentActivity) == true) goto L16;
        ContextWrapper r108 = null;
    L17:
        FragmentActivity r109 = (FragmentActivity) r108;
        if (r109 != null) goto L19;
        Context r110 = r104.getBaseContext();
        if ((r110 instanceof ContextWrapper) == true) goto L23;
        r110 = null;
    L23:
        r104 = (ContextWrapper) r110;
        if (r104 != null) goto L9;
    L19:
        r103 = r109;
        goto L25
    L16:
        r108 = r104;
        goto L17
    L11:
        r107 = false;
    L25:
        if (r103 != null) goto L27;
        return;
    L27:
        String r111 = r103.hashCode() + '_' + r101;
        if (r111 != null) goto L30;
    L33:
        if (r105 == false) goto L35;
        return;
    L35:
        f r112 = f162690a.get(r111);
        if (r112 == null) goto L48;
        View r113 = r112.getHybridView();
        if (r102 == false) goto L41;
        if (r113 == null) goto L49;
        r113.setVisibility(0);
        return;
    L49:
        return;
    L41:
        if (r113 == null) goto L51;
        r113.setVisibility(8);
        return;
    L51:
        return;
    L48:
        return;
    L30:
        if (r111.length() == 0) goto L33;
        r105 = false;
        goto L33
    }
}
