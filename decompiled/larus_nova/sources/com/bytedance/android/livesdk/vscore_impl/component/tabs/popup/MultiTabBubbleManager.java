package com.bytedance.android.livesdk.vscore_impl.component.tabs.popup;

import android.os.Handler;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.vscore_impl.component.tabs.LivePagerTabsStrip;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.ies.utility.SharedPrefHelper;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vr1.u;

/* JADX INFO: loaded from: classes11.dex */
public final class MultiTabBubbleManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LinkedList<MultiTab.Bubble> f159974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f159975b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f159976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference<LivePagerTabsStrip> f159977d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Long, Boolean> f159978e = null;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiTab.Bubble f159979a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.vscore_impl.component.tabs.popup.MultiTabBubbleManager$a$a, reason: collision with other inner class name */
        public static final class C2449a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f159980a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f159981b;

            public C2449a(a r100, int r101) {
                this.f159980a = r100;
                this.f159981b = r101;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                if (((Boolean) r100).booleanValue() == false) goto L6;
                xs2.b.a().post(new g(this.f159981b, this.f159980a.f159979a));
                LinkedList<MultiTab.Bubble> r101 = MultiTabBubbleManager.f159974a;
                MultiTabBubbleManager.b(this.f159980a.f159979a.getBubbleId() + " at tabid:" + this.f159980a.f159979a.getShowTabId() + " centerPos:" + this.f159981b + " try to show bubble send ShowMultiTabPopupEvent  after " + this.f159980a.f159979a.getDelay() + " second ");
                return;
            }
        }

        public a(MultiTab.Bubble r100) {
            this.f159979a = r100;
        }

        public final void a() {
            LinkedList<MultiTab.Bubble> r100 = MultiTabBubbleManager.f159974a;
            WeakReference<LivePagerTabsStrip> r101 = MultiTabBubbleManager.f159977d;
            if (r101 == null) goto L15;
            LivePagerTabsStrip r102 = r101.get();
            if (r102 == null) goto L15;
            MultiTabType.a r103 = MultiTabType.Companion;
            long r104 = this.f159979a.getShowTabId();
            r103.getClass();
            LivePagerTabsStrip.d r105 = r102.f159803d.get(String.valueOf(MultiTabType.a.a(r104).getTabId()));
            if (r105 == null) goto L15;
            TextView r106 = r105.f159834a;
            if (r106 == null) goto L15;
            int[] r107 = new int[2];
            ViewParent r108 = r106.getParent();
            if ((r108 instanceof ViewGroup) == false) goto L15;
            ViewGroup r109 = (ViewGroup) r108;
            r109.getLocationOnScreen(r107);
            int r110 = r107[0] + (r109.getWidth() / 2);
            r107[0] = r110;
            if (r110 <= 0) goto L15;
        L17:
            if (r110 <= 0) goto L36;
            MultiTabBubbleManager.f159978e.put(Long.valueOf(this.f159979a.getShowTabId()), Boolean.TRUE);
            if (r.u(null, null, 3) == null) goto L34;
            u r111 = r.u(null, null, 3);
            if (r111 == null) goto L27;
            m<Boolean> r112 = r111.j();
            if (r112 == null) goto L27;
            if (r112.getValue().booleanValue() == true) goto L34;
        L27:
            u r113 = r.u(null, null, 3);
            if (r113 == null) goto L35;
            m<Boolean> r114 = r113.j();
            if (r114 == null) goto L35;
            Observable<Boolean> r115 = r114.a();
            if (r115 == null) goto L35;
            r115.subscribe(new C2449a(this, r110));
        L35:
            xs2.b.a().post(new g(r110, this.f159979a));
            MultiTabBubbleManager.b(this.f159979a.getBubbleId() + " at tabid:" + this.f159979a.getShowTabId() + " centerPos:" + r110 + " try to show bubble send ShowMultiTabPopupEvent  after " + this.f159979a.getDelay() + " second ");
            return;
        L34:
            xs2.b.a().post(new g(r110, this.f159979a));
            MultiTabBubbleManager.b(this.f159979a.getBubbleId() + " at tabid:" + this.f159979a.getShowTabId() + " centerPos:" + r110 + " try to show bubble send ShowMultiTabPopupEvent  after " + this.f159979a.getDelay() + " second ");
            goto L35
        L36:
            MultiTabBubbleManager.b(this.f159979a.getBubbleId() + " at tabid:" + this.f159979a.getShowTabId() + " try to show bubble pollFirst " + this.f159979a + " abandon because centerPos:" + r110);
            return;
        L15:
            r110 = -1;
            goto L17
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public MultiTabBubbleManager() {
    }

    static {
        f159975b = LazyKt.lazy(MultiTabBubbleManager$mainHandler$2.INSTANCE);
        f159978e = new LinkedHashMap();
    }

    public static boolean a(long r100) {
        Map<Long, Boolean> r101 = f159978e;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        return Intrinsics.areEqual((Boolean) r102.get(Long.valueOf(r100)), Boolean.TRUE);
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        ALogger.d("MultiTabBubbleManager", r100);
    }

    public static void c(List r100, LivePagerTabsStrip r101) {
        b("try to show bubble");
        if (r101 == null) goto L5;
        f159977d = new WeakReference(r101);
    L5:
        WeakReference<LivePagerTabsStrip> r102 = f159977d;
        if (r102 == null) goto L8;
        LivePagerTabsStrip r103 = r102.get();
    L9:
        if (r103 != null) goto L12;
        b("try to show bubble fail because pagerTabRef is null");
        return;
    L12:
        boolean r104 = true;
        if (f159974a != null) goto L32;
        if (r100 != null) goto L16;
    L18:
        LinkedList<MultiTab.Bubble> r105 = new LinkedList();
        if (r100 == null) goto L29;
        Iterator r106 = r100.iterator();
    L22:
        if (r106.hasNext() == false) goto L29;
        MultiTab.TabItem r107 = (MultiTab.TabItem) r106.next();
        MultiTab.Bubble r108 = r107.getBubble();
        if (r108 == null) goto L22;
        if (r108.getSwitch() != 1) goto L22;
        r108.setShowTabId(r107.getTabId());
        r105.add(r108);
    L29:
        if (r105.size() <= 1) goto L31;
        CollectionsKt.sortWith(r105, new com.bytedance.android.livesdk.vscore_impl.component.tabs.popup.a());
    L31:
        f159974a = r105;
        goto L32
    L16:
        if (r100.isEmpty() != true) goto L18;
        r105 = null;
    L32:
        StringBuilder r109 = new StringBuilder("try to show bubble bubbleQueue is");
        LinkedList<MultiTab.Bubble> r110 = f159974a;
        if (r110 == null) goto L35;
        String r111 = r110.toString();
    L36:
        r109.append(r111);
        b(r109.toString());
        LinkedList<MultiTab.Bubble> r112 = f159974a;
        if (r112 == null) goto L60;
        MultiTab.Bubble r113 = r112.pollFirst();
        if (r113 == null) goto L60;
        if (SharedPrefHelper.b(s1.getContext()).h("live.key.KEY_LIVE_VS_MULTITAB_BUBBLE" + r113.getBubbleId(), -1) != (-1)) goto L43;
        boolean r114 = true;
    L45:
        if (r113.getSwitch() == 0) goto L58;
        if (r114 == false) goto L58;
        String r115 = r113.getBubbleText();
        if (r115 != null) goto L51;
    L54:
        if (r104 == false) goto L57;
        b("try to show bubble pollFirst " + r113 + " abandon because bubbleText is empty");
        c(null, null);
        return;
    L57:
        a r116 = new a(r113);
        f159976c = r116;
        ((Handler) f159975b.getValue()).postDelayed(r116, r113.getDelay() * 1000);
        return;
    L51:
        if (StringsKt.isBlank(r115) == true) goto L54;
        r104 = false;
    L58:
        b("try to show bubble pollFirst " + r113 + " abandon because switch:" + r113.getSwitch() + ",canshow:" + r114);
        c(null, null);
        return;
    L43:
        r114 = false;
    L60:
        b("try to show bubble abandon because bubbleQueue is empty");
        Unit r117 = Unit.INSTANCE;
        return;
    L35:
        r111 = null;
        goto L36
    L8:
        r103 = null;
        goto L9
    }
}
