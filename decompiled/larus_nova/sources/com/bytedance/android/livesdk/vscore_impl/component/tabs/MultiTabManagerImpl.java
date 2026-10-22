package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.content.res.Configuration;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.vscore_api.tab.MultiTabType;
import com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.MultiCameraLinkedRoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.vs.MultiTab;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class MultiTabManagerImpl implements ru2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, ou2.b> f159898a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f159899b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Long, a> f159900c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Integer, String> f159901d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final MultiTabManagerImpl f159902e = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f159903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f159904b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.f159903a == r101.f159903a) goto L8;
            return false;
        L8:
            if (this.f159904b == r101.f159904b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        public final int hashCode() {
            boolean r100 = this.f159903a;
            ?? r101 = 1;
            ?? r102 = r100;
            if (r100 == false) goto L5;
            r102 = 1;
        L5:
            int r103 = r102 * 31;
            boolean r104 = this.f159904b;
            if (r104 == true) goto L10;
            r101 = r104;
        L10:
            return r103 + r101;
        }

        public final String toString() {
            return "MultiTabRoomInfo(isMultiTab=" + this.f159903a + ", isVerticalRoom=" + this.f159904b + ")";
        }

        public a(boolean r100, boolean r101) {
            this.f159903a = r100;
            this.f159904b = r101;
        }
    }

    public MultiTabManagerImpl() {
    }

    static {
        f159902e = new MultiTabManagerImpl();
        f159898a = new LinkedHashMap();
        f159899b = LazyKt.lazy(MultiTabManagerImpl$enableMultiTab$2.INSTANCE);
        f159900c = new LinkedHashMap();
        f159901d = new LinkedHashMap();
    }

    public final void d() {
        ((LinkedHashMap) f159898a).clear();
        ((LinkedHashMap) f159900c).clear();
    }

    public final void e() {
        ((LinkedHashMap) f159900c).clear();
    }

    @Override // ru2.b
    public final void a() {
        Map<Integer, s> r100 = t.f160003a;
    }

    public static int c(IRoom r100) {
        if (r100 == null) goto L26;
        EpisodeExtraInfo r101 = lu2.c.a(r100);
        if (r101 == null) goto L27;
        MultiTab r102 = r101.getMultiTab();
        if (r102 == null) goto L28;
        List<MultiTab.TabItem> r103 = r102.getValidTabs();
        if (r103 == null) goto L29;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L12:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        if (((MultiTab.TabItem) r106).getTabType() != 3) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L12;
        r104.add(r106);
        goto L12
    L16:
        r107 = false;
        goto L17
    L20:
        return r104.size();
    L29:
        return 0;
    L28:
        return 0;
    L27:
        return 0;
    L26:
        return 0;
    }

    public static MultiTab.TabItem f(IRoom r100) {
        Object r101 = null;
        if (r100 == null) goto L26;
        EpisodeExtraInfo r102 = lu2.c.a(r100);
        if (r102 == null) goto L27;
        MultiTab r103 = r102.getMultiTab();
        if (r103 == null) goto L28;
        List<MultiTab.TabItem> r104 = r103.getValidTabs();
        if (r104 == null) goto L29;
        Iterator<T> r105 = r104.iterator();
    L12:
        if (r105.hasNext() == false) goto L20;
        Object r106 = r105.next();
        if (((MultiTab.TabItem) r106).getTabId() != MultiTabType.PUBLIC_INTERACT_TAB.getTabId()) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L12;
        r101 = r106;
        goto L20
    L16:
        r107 = false;
    L20:
        return (MultiTab.TabItem) r101;
    L29:
        return null;
    L28:
        return null;
    L27:
        return null;
    L26:
        return null;
    }

    public static boolean n(DataCenter r100) {
        if (u.a(r100) == true) goto L6;
        return false;
    L6:
        if (r100 == null) goto L11;
        IRoom r101 = lu2.c.f(r100);
        if (r101 == null) goto L11;
        if (r101.getCompoundSceneType() != 1) goto L11;
    L16:
        boolean r102 = true;
    L18:
        NextLiveData<Boolean> r103 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.z().d();
        if (r103 == null) goto L22;
        Boolean r104 = r103.getValue();
        if (r104 == null) goto L22;
    L23:
        boolean r105 = r104.booleanValue();
        MutableLiveData<Boolean> r106 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.z().f();
        if (r106 == null) goto L27;
        Boolean r107 = r106.getValue();
        if (r107 == null) goto L27;
    L28:
        boolean r108 = r107.booleanValue();
        if (r100 == null) goto L31;
        boolean r109 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.z().c(r100);
    L32:
        ALogger.i("MultiTab", "MultiTabManagerImpl ugcLayoutModeFilter  isMultiStream = " + r102 + "  isGameStickerLayout = " + r105 + "  isGameExtraViewLayout = " + r108 + "  isInLinkLayout= " + r109 + "  isLinkButNotGameLinkLayout = " + r109);
        if (r102 == true) goto L37;
        if (r105 == true) goto L37;
        if (r108 == true) goto L37;
        if (r109 == true) goto L37;
        return false;
    L37:
        return true;
    L31:
        r109 = false;
    L27:
        r107 = Boolean.FALSE;
    L22:
        r104 = Boolean.FALSE;
    L11:
        if (r100 == null) goto L17;
        IRoom r110 = lu2.c.f(r100);
        if (r110 == null) goto L17;
        if (r110.getCompoundSceneType() == 3) goto L16;
    L17:
        r102 = false;
        goto L18
    }

    public final boolean g(DataCenter r100) {
        if (h(r100) == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        ou2.a r102 = ou2.c.a(r100);
        if ((r102 instanceof MultiCameraLinkedRoomContext) == true) goto L11;
        r102 = null;
    L11:
        MultiCameraLinkedRoomContext r103 = (MultiCameraLinkedRoomContext) r102;
        if (r103 == null) goto L18;
        com.bytedance.live.datacontext.m<Boolean> r104 = r103.getHideByUgcMultiTabFilter();
        if (r104 == null) goto L18;
        Boolean r105 = r104.getValue();
        if (r105 == null) goto L18;
        boolean r106 = r105.booleanValue();
    L19:
        StringBuilder r107 = new StringBuilder("isMultiTabAndUgcPortraitFilter =");
        if (r101 == true) goto L24;
        if (r106 == true) goto L24;
        boolean r108 = false;
    L25:
        r107.append(r108);
        r107.append("  isUgcPortraitModeFilter=");
        r107.append(r101);
        r107.append(" isLayoutHeightFilter = ");
        r107.append(r106);
        ALogger.i("MultiTab", r107.toString());
        if (r101 == true) goto L28;
        if (r106 == true) goto L28;
        return false;
    L28:
        return true;
    L24:
        r108 = true;
    L18:
        r106 = false;
        goto L19
    L5:
        if (n(r100) == false) goto L7;
        r101 = true;
        goto L8
    }

    public final boolean h(DataCenter r110) {
        if (((Boolean) f159899b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        vr1.u r100 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r110, null, 2);
        if (r100 != null) goto L8;
        return false;
    L8:
        if (r110 == null) goto L11;
        IRoom r111 = lu2.c.f(r110);
        if (r111 == null) goto L11;
    L12:
        if (r111 != null) goto L14;
        return false;
    L14:
        boolean r101 = true;
        boolean r102 = !r111.isMergeVSRoom();
        Boolean r103 = r100.isVSVerticalStream();
        Map<Long, a> r104 = f159900c;
        if (r104.containsKey(Long.valueOf(r111.getId())) == false) goto L21;
        Object r105 = ((LinkedHashMap) r104).get(Long.valueOf(r111.getId()));
        Intrinsics.checkNotNull(r105);
        a r106 = (a) r105;
        if (Intrinsics.areEqual(Boolean.valueOf(r106.f159904b), r103) == false) goto L21;
        ALogger.i("MultiTab", "isMultiTabRoom  multiTabDecideMap, return multiTabRoomInfo.isMultiTab = " + r106.f159903a);
        return r106.f159903a;
    L21:
        if (r111.isMergeVSRoom() == true) goto L26;
        IBaseStreamUrl r107 = r111.getStreamUrl();
        if (r107 == null) goto L26;
        if (r107.getStreamOrientation() != 1) goto L26;
    L47:
        r104.put(Long.valueOf(r111.getId()), new a(false, Intrinsics.areEqual(r103, Boolean.TRUE)));
        ALogger.i("MultiTab", "isMultiTab  false");
        return false;
    L26:
        EpisodeExtraInfo r108 = lu2.c.a(r111);
        if (r108 == null) goto L47;
        MultiTab r109 = r108.getMultiTab();
        if (r109 == null) goto L47;
        if (r109.getValidTabs() == null) goto L47;
        if (c(r111) >= 1) goto L35;
    L39:
        r101 = false;
    L40:
        if (r102 == true) goto L42;
    L45:
        r104.put(Long.valueOf(r111.getId()), new a(r101, Intrinsics.areEqual(r103, Boolean.TRUE)));
        ALogger.i("MultiTab", "isMultiTabRoom return isMultiTabDataValid = " + r101);
        return r101;
    L42:
        if (u.f160006b == true) goto L45;
        ALogger.i("MultiTab", "isMultiTabRoom ugc switch off, isMultiTabRoom return false");
        r104.put(Long.valueOf(r111.getId()), new a(false, Intrinsics.areEqual(r103, Boolean.TRUE)));
        return false;
    L35:
        if (f(r111) == null) goto L39;
        if ((!Intrinsics.areEqual(r103, Boolean.TRUE)) == false) goto L39;
    L11:
        r111 = r100.k2();
        goto L12
    }

    public final boolean i(DataCenter r100) {
        if (((Boolean) f159899b.getValue()).booleanValue() == true) goto L5;
        return false;
    L5:
        vr1.u r101 = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.u(r100, null, 2);
        if (r101 != null) goto L8;
        return false;
    L8:
        if (r100 == null) goto L11;
        IRoom r102 = lu2.c.f(r100);
        if (r102 == null) goto L11;
    L12:
        EpisodeExtraInfo r103 = lu2.c.a(r102);
        if (r103 == null) goto L24;
        MultiTab r104 = r103.getMultiTab();
        if (r104 != null) goto L17;
        return false;
    L17:
        if (r104.getValidTabs() != null) goto L19;
        return false;
    L19:
        if (c(r102) >= 1) goto L21;
        return false;
    L21:
        if (f(r102) == null) goto L28;
        return true;
    L28:
        return false;
    L24:
        return false;
    L11:
        r102 = r101.k2();
        goto L12
    }

    public final ou2.b l(DataCenter r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.hashCode();
        Map<Integer, ou2.b> r102 = f159898a;
        LinkedHashMap r103 = (LinkedHashMap) r102;
        return (ou2.b) r103.get(Integer.valueOf(r101));
    }

    public final boolean m(DataCenter r100) {
        if (h(r100) == true) goto L5;
        return false;
    L5:
        if (r100 == null) goto L11;
        IRoom r101 = lu2.c.f(r100);
        if (r101 == null) goto L11;
        EpisodeExtraInfo r102 = lu2.c.a(r101);
        if (r102 == null) goto L11;
        MultiTab r103 = r102.getMultiTab();
    L12:
        if (r103 == null) goto L23;
        List<MultiTab.TabItem> r104 = r103.getValidTabs();
        if (r104 == null) goto L23;
        Iterator<T> r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L23;
        MultiTab.Bubble r106 = ((MultiTab.TabItem) r105.next()).getBubble();
        if (r106 == null) goto L17;
        if (r106.getSwitch() != 1) goto L17;
        return true;
    L23:
        return false;
    L11:
        r103 = null;
        goto L12
    }

    public final void b(View r100, Configuration r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "config");
        q.a(r100, r101);
    }

    public final boolean j(Room r100, boolean r101) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isMergeVSRoom() != true) goto L44;
        EpisodeExtraInfo r102 = lu2.c.a(r100);
        if (r102 == null) goto L11;
        MultiTab r103 = r102.getMultiTab();
        if (r103 == null) goto L11;
        List<MultiTab.TabItem> r104 = r103.getValidTabs();
    L12:
        if (r104 != null) goto L14;
    L19:
        boolean r105 = false;
    L20:
        if (r105 == false) goto L45;
        if (r104 == null) goto L46;
        List<MultiTab.TabItem> r106 = r104;
        if ((r106 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r107 = r106.iterator();
    L29:
        if (r107.hasNext() == false) goto L36;
        if (((MultiTab.TabItem) r107.next()).getTabId() != MultiTabType.CHANNEL_CHAT_TAB.getTabId()) goto L33;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L29;
        return false;
    L33:
        r108 = false;
    L36:
        return true;
    L25:
        if (r106.isEmpty() == false) goto L27;
    L46:
        return false;
    L45:
        return false;
    L14:
        if (c(r100) < 1) goto L19;
        if (f(r100) == null) goto L19;
        if (r101 == true) goto L19;
        r105 = true;
    L11:
        r104 = null;
        goto L12
    L44:
        return false;
    }

    public final boolean k(DataCenter r100, long r101) {
        Object r102 = null;
        if (r100 == null) goto L22;
        IRoom r103 = lu2.c.f(r100);
        if (r103 == null) goto L22;
        EpisodeExtraInfo r104 = lu2.c.a(r103);
        if (r104 == null) goto L22;
        MultiTab r105 = r104.getMultiTab();
        if (r105 == null) goto L22;
        List<MultiTab.TabItem> r106 = r105.getValidTabs();
        if (r106 == null) goto L22;
        Iterator<T> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L21;
        Object r108 = r107.next();
        if (((MultiTab.TabItem) r108).getTabId() != r101) goto L18;
        boolean r109 = true;
    L19:
        if (r109 == false) goto L14;
        r102 = r108;
        goto L21
    L18:
        r109 = false;
    L21:
        r102 = (MultiTab.TabItem) r102;
    L22:
        if (r102 != null) goto L31;
        return false;
    L31:
        return true;
    }
}
