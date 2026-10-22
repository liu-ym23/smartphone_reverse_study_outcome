package com.bytedance.android.live.browser.utils;

import android.view.View;
import com.bytedance.android.live.core.setting.r0;
import com.bytedance.android.livesdkapi.depend.message.wrds.IPreviewSyncDataType;
import com.bytedance.android.livesdkapi.message.OnWRDSDataUpdateListener;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.larus.nova.R;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f64317a = 0;

    static {
    }

    public static void b(CallContext r100) {
        if (r0.f65396a.getValue().booleanValue() == false) goto L9;
        if (r100 == null) goto L10;
        View r101 = r100.f249269d;
        if (r101 == null) goto L11;
        r101.setTag(R.id.listeners_msg, null);
        return;
    L11:
        return;
    L10:
        return;
    }

    public static void a(View r100, ylc.e r101, MessageHub r102) {
        r0 r103 = r0.f65396a;
        if (r103.getValue().booleanValue() == true) goto L5;
        return;
    L5:
        if (r102 == null) goto L22;
        if (r103.getValue().booleanValue() == false) goto L52;
        Object r104 = r100.getTag(R.id.listeners_msg_wrds_feed);
        if ((r104 instanceof LinkedHashSet) == true) goto L11;
        r104 = null;
    L11:
        LinkedHashSet r105 = (LinkedHashSet) r104;
        if (r105 == null) goto L20;
        Iterator r106 = r105.iterator();
    L15:
        if (r106.hasNext() == false) goto L20;
        Pair r107 = (Pair) r106.next();
        IPreviewSyncDataType r108 = (IPreviewSyncDataType) r107.getFirst();
        OnWRDSDataUpdateListener r109 = (OnWRDSDataUpdateListener) r107.getSecond();
        if (r108 == null) goto L15;
        if (r109 == null) goto L15;
        r102.removeWRDSListener(r108, r109);
    L20:
        r100.setTag(R.id.listeners_msg_wrds_feed, null);
        return;
    L52:
        return;
    L22:
        if (r103.getValue().booleanValue() == false) goto L54;
        Object r110 = r100.getTag(R.id.listeners_msg_wrds);
        if ((r110 instanceof LinkedHashSet) == true) goto L26;
        r110 = null;
    L26:
        LinkedHashSet r111 = (LinkedHashSet) r110;
        if (r111 == null) goto L35;
        Iterator r112 = r111.iterator();
    L30:
        if (r112.hasNext() == false) goto L35;
        ylc.c r113 = (ylc.c) r112.next();
        if (r113 == null) goto L30;
        if (r101 == null) goto L30;
        Intrinsics.checkNotNullParameter(r113, "listener");
        r101.i(r113);
    L35:
        r100.setTag(R.id.listeners_msg_wrds, null);
        return;
    }

    public static void c(CallContext r100, Object r101, vlc.l r102) {
        if (r0.f65396a.getValue().booleanValue() == false) goto L15;
        if (r100 == null) goto L16;
        View r103 = r100.f249269d;
        if (r103 == null) goto L17;
        Object r104 = r103.getTag(R.id.listeners_msg);
        if ((r104 instanceof LinkedHashSet) == true) goto L10;
        r104 = null;
    L10:
        LinkedHashSet r105 = (LinkedHashSet) r104;
        if (r105 != null) goto L13;
        r105 = new LinkedHashSet();
        r103.setTag(R.id.listeners_msg, r105);
    L13:
        r105.add(new Pair(r101, r102));
        return;
    L17:
        return;
    L16:
        return;
    }

    public static void d(View r100, DataCenter r101, MessageHub r102) {
        if (r0.f65396a.getValue().booleanValue() == false) goto L51;
        Object r103 = r100.getTag(R.id.listeners_msg);
        if ((r103 instanceof LinkedHashSet) == true) goto L7;
        r103 = null;
    L7:
        LinkedHashSet r104 = (LinkedHashSet) r103;
        if (r102 == null) goto L22;
        if (r104 == null) goto L34;
        Iterator r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L34;
        Pair r106 = (Pair) r105.next();
        Object r107 = r106.getFirst();
        vlc.l r108 = (vlc.l) r106.getSecond();
        if (r108 == null) goto L12;
        if ((r107 instanceof String) == true) goto L18;
        if ((r107 instanceof Integer) == false) goto L12;
        r102.removeMessageListener(((Number) r107).intValue(), r108);
        goto L12
    L18:
        r102.removeMessageListener((String) r107, r108);
    L34:
        r100.setTag(R.id.listeners_msg, null);
        return;
    L22:
        if (r101 == null) goto L24;
        vlc.d r109 = (vlc.d) r101.get("data_message_manager", null);
    L25:
        if (r109 == null) goto L34;
        if (r104 == null) goto L34;
        Iterator r110 = r104.iterator();
    L29:
        if (r110.hasNext() == false) goto L34;
        vlc.l r111 = (vlc.l) ((Pair) r110.next()).getSecond();
        if (r111 == null) goto L29;
        r109.removeMessageListener(r111);
        goto L29
    L24:
        r109 = null;
        goto L25
    }
}
