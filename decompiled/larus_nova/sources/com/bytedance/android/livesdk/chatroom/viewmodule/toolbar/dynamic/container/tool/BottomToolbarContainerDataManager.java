package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.tool;

import bp1.j;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ErrorReason;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.ToolbarReasonTag;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.container.ListActionEnum;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.d0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.q;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.s;
import com.bytedance.android.livesdk.config.pg;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveToolbarData;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zo1.i;

/* JADX INFO: loaded from: classes8.dex */
public final class BottomToolbarContainerDataManager extends zo1.a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f116047g = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f116048b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f116049c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f116050d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final DataCenter f116051e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function1<Integer, Boolean> f116052f;

    public final int r() {
        int r100 = 5;
        if (((Boolean) this.f116048b.getValue()).booleanValue() == false) goto L16;
        o r101 = j.b(this.f116051e);
        if (r101 == null) goto L15;
        m<IRoom> r102 = r101.getRoom();
        if (r102 == null) goto L15;
        IRoom r103 = r102.getValue();
        if (r103 == null) goto L15;
        ILiveToolbarData r104 = r103.getToolbarData();
        if (r104 == null) goto L15;
        Integer r105 = r104.getMaxCount();
        if (r105 == null) goto L15;
        int r106 = r105.intValue();
    L26:
        if (r106 == 0) goto L28;
    L33:
        int r107 = Math.max(r106, 0);
        if (v.a() == false) goto L39;
        pg r108 = pg.f120976a;
        if (r108.getValue().intValue() > 0) goto L38;
        return r107;
    L38:
        return r108.getValue().intValue();
    L39:
        return r107;
    L28:
        if (((Boolean) this.f116050d.getValue()).booleanValue() == false) goto L33;
        u("max slot size is 0.");
        if (((Boolean) this.f116048b.getValue()).booleanValue() == false) goto L32;
        r100 = 4;
    L32:
        r106 = r100;
    L15:
        r106 = 4;
        goto L26
    L16:
        o r109 = j.b(this.f116051e);
        if (r109 == null) goto L25;
        m<IRoom> r110 = r109.getRoom();
        if (r110 == null) goto L25;
        IRoom r111 = r110.getValue();
        if (r111 == null) goto L25;
        ILiveToolbarData r112 = r111.getToolbarData();
        if (r112 == null) goto L25;
        r106 = r112.getMaxCountLandscape();
    L25:
        r106 = 5;
        goto L26
    }

    @Override // zo1.f
    public final boolean f(s r110) {
        final s r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "data");
        Function1<String, Unit> r100 = new BottomToolbarContainerDataManager$addModel$errorReport$1(this, r111);
        i r101 = n();
        Object r102 = null;
        if (r101 == null) goto L5;
        List r103 = r101.f573100a;
    L7:
        if (r103 != null) goto L9;
        u("showing list empty.");
        q(r111.f116191a, "list empty");
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a r104 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a.f116165b;
        r104.g(r111.f116191a, r104.e(), "ListEmpty");
        r100.invoke(ErrorReason.SHOWING_LIST_EMPTY.getValue());
        return false;
    L9:
        Iterator r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L18;
        Object r106 = r105.next();
        if (((s) r106).f116196f != r111.f116196f) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L11;
    L19:
        s r108 = (s) r106;
        if (r108 == null) goto L23;
        u(r111 + " try replace same group " + r108);
        return t(r108, r111, "same group");
    L23:
        if (r103.size() >= r()) goto L26;
        u("add " + r111 + " when space enough.");
        o(r111);
        return true;
    L26:
        if (r103.size() != r()) goto L43;
        Iterator r109 = r103.iterator();
        if (r109.hasNext() == false) goto L39;
        r102 = r109.next();
        if (r109.hasNext() == false) goto L39;
        int r112 = s(((s) r102).f116196f);
    L34:
        Object r113 = r109.next();
        int r114 = s(((s) r113).f116196f);
        if (r112 <= r114) goto L38;
        r102 = r113;
        r112 = r114;
    L38:
        if (r109.hasNext() == true) goto L34;
    L39:
        s r115 = (s) r102;
        if (r115 == null) goto L42;
        u("try replace with lowest data " + r115);
        return t(r115, r111, "lowest");
    L42:
        u("list null error. size = " + r());
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a r116 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a.f116165b;
        r116.g(r111.f116191a, r116.e(), "list null error. ");
        r100.invoke(ErrorReason.REPLACE_LIST_EMPTY.getValue());
        return false;
    L43:
        u("over size error. size = " + r());
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a r117 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a.f116165b;
        r117.g(r111.f116191a, r117.e(), "over size error.");
        r100.invoke(ErrorReason.REPLACE_LIST_OVER_SIZE.getValue());
        return false;
    L15:
        r107 = false;
        goto L16
    L18:
        r106 = null;
        goto L19
    L5:
        r103 = null;
        goto L7
    }

    @Override // zo1.a, zo1.f
    public final Integer getComponentByGroupId(int r100) {
        i r101 = n();
        if (r101 == null) goto L19;
        AbstractCollection r102 = r101.f573100a;
        if (r102 == null) goto L19;
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if (((s) r104).f116196f != r100) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L8;
    L16:
        s r106 = (s) r104;
        if (r106 == null) goto L19;
        int r107 = r106.f116191a;
    L21:
        return Integer.valueOf(r107);
    L12:
        r105 = false;
        goto L13
    L15:
        r104 = null;
    L19:
        r107 = -1;
        goto L21
    }

    @Override // zo1.f
    public final boolean i(s r110) {
        s r111 = r110;
        Intrinsics.checkNotNullParameter(r111, "data");
        i r100 = n();
        Object r101 = null;
        if (r100 == null) goto L5;
        Boolean r102 = Boolean.valueOf(r100.b(r111, ListActionEnum.REMOVE));
    L6:
        i r103 = e();
        if (r103 == null) goto L9;
        Boolean r104 = Boolean.valueOf(r103.b(r111, ListActionEnum.REMOVE));
    L10:
        Boolean r105 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r105) == false) goto L14;
        u("remove " + r111 + " from showing list.");
    L14:
        if (Intrinsics.areEqual(r104, r105) == false) goto L17;
        u("remove " + r111 + " from ready list.");
    L17:
        if (Intrinsics.areEqual(r102, r105) == false) goto L56;
        i r112 = e();
        if (r112 == null) goto L21;
        Collection r113 = r112.f573100a;
    L22:
        if (r113 != null) goto L24;
    L26:
        if (r113 == null) goto L56;
        List r114 = CollectionsKt.sortedWith(r113, new a(this));
        if (r114 == null) goto L56;
        Iterator r115 = r114.iterator();
    L31:
        if (r115.hasNext() == false) goto L53;
        Object r106 = r115.next();
        s r107 = (s) r106;
        i r108 = n();
        if (r108 == null) goto L47;
        AbstractCollection r109 = r108.f573100a;
        if (r109 == null) goto L47;
        Iterator r116 = r109.iterator();
    L38:
        if (r116.hasNext() == false) goto L45;
        Object r117 = r116.next();
        if (r107.f116196f != ((s) r117).f116196f) goto L42;
        boolean r118 = true;
    L43:
        if (r118 == false) goto L38;
    L46:
        s r119 = (s) r117;
    L48:
        if (r119 != null) goto L50;
        boolean r120 = true;
    L51:
        if (r120 == false) goto L31;
        r101 = r106;
        goto L53
    L50:
        r120 = false;
        goto L51
    L42:
        r118 = false;
        goto L43
    L45:
        r117 = null;
    L47:
        r119 = null;
    L53:
        s r121 = (s) r101;
        if (r121 == null) goto L56;
        u("find " + r121 + " from ready list, then load");
        o(r121);
        goto L56
    L24:
        if ((!r113.isEmpty()) != true) goto L26;
        u("try load data from ready list.");
        goto L26
    L21:
        r113 = null;
    L56:
        Boolean r122 = Boolean.TRUE;
        if (Intrinsics.areEqual(r102, r122) == false) goto L59;
    L60:
        return true;
    L59:
        if (Intrinsics.areEqual(r104, r122) == true) goto L60;
        return false;
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @Override // zo1.f
    public final boolean m(s r100) {
        s r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        i r102 = e();
        Boolean r103 = null;
        if (r102 == null) goto L5;
        Boolean r104 = Boolean.valueOf(r102.b(r101, ListActionEnum.UPDATE));
    L6:
        i r105 = n();
        if (r105 == null) goto L9;
        r103 = Boolean.valueOf(r105.b(r101, ListActionEnum.UPDATE));
    L9:
        u("update " + r101);
        Boolean r106 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r106) == false) goto L12;
    L15:
        return true;
    L12:
        if (Intrinsics.areEqual(r103, r106) == true) goto L15;
        return false;
    L5:
        r104 = null;
        goto L6
    }

    public final void o(s r100) {
        i r101 = e();
        if (r101 == null) goto L5;
        r101.b(r100, ListActionEnum.REMOVE);
    L5:
        i r102 = n();
        if (r102 == null) goto L8;
        r102.b(r100, ListActionEnum.ADD);
    L8:
        p(r100, true);
    }

    public final int s(int r100) {
        List r101 = (List) this.f116049c.getValue();
        if (r101.isEmpty() == false) goto L5;
        u("priority list is empty");
    L5:
        int r102 = r101.indexOf(Integer.valueOf(r100));
        if (r102 != (-1)) goto L10;
        u("cant find priority by group id :" + r100);
        return 0;
    L10:
        return r101.size() - r102;
    }

    public final void u(String r100) {
        ALogger.i(com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a.f116165b.b(), "data " + r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BottomToolbarContainerDataManager(DataCenter r100, Function1<? super Integer, Boolean> r101) {
        Intrinsics.checkNotNullParameter(r101, "checkViewFunc");
        this.f116051e = r100;
        this.f116052f = r101;
        this.f116048b = LazyKt.lazy(new BottomToolbarContainerDataManager$isPortrait$2(this));
        this.f116049c = LazyKt.lazy(new BottomToolbarContainerDataManager$priorityList$2(this));
        this.f116050d = LazyKt.lazy(BottomToolbarContainerDataManager$needForceDefault$2.INSTANCE);
        i r102 = new i(new ArrayList(), new ArrayList());
        Intrinsics.checkNotNullParameter("showing", "key");
        Intrinsics.checkNotNullParameter(r102, "list");
        this.f573098a.put("showing", r102);
        i r103 = new i(new ArrayList(), new ArrayList());
        Intrinsics.checkNotNullParameter("ready", "key");
        Intrinsics.checkNotNullParameter(r103, "list");
        this.f573098a.put("ready", r103);
    }

    public final void p(s r100, boolean r101) {
        if (this.f116052f.invoke(Integer.valueOf(r100.f116191a)).booleanValue() == r101) goto L6;
        com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a r102 = com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic.p005new.a.f116165b;
        r102.g(r100.f116191a, r102.e(), "CheckViewError");
        return;
    }

    public final void q(int r100, String r101) {
        i r102 = n();
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = r102.a();
        if (r104 == null) goto L6;
    L7:
        i r105 = e();
        if (r105 == null) goto L13;
        String r106 = r105.a();
        if (r106 == null) goto L13;
        r103 = r106;
    L13:
        HashMap<String, String> r107 = q.f116173a;
        q.a(r100, ToolbarReasonTag.MUTEX_ERROR, " " + r101 + " slot_size:" + r() + " Showings:" + r104 + "  WouldShow:" + r103);
        return;
    L6:
        r104 = "";
        goto L7
    }

    public final boolean t(s r100, s r101, String r110) {
        if (s(r100.f116196f) > s(r101.f116196f)) goto L5;
        boolean r102 = true;
    L7:
        if (r102 == false) goto L18;
        u("replace from " + r100 + " to " + r101);
        if ((!Intrinsics.areEqual(r101, r100)) == false) goto L17;
        i r103 = n();
        if (r103 == null) goto L13;
        r103.b(r100, ListActionEnum.REMOVE);
    L13:
        i r104 = e();
        if (r104 == null) goto L16;
        r104.b(r100, ListActionEnum.ADD);
    L16:
        p(r100, false);
    L17:
        o(r101);
        q(r100.f116191a, r110 + " priority is lower than " + r101 + ", so hide it.");
        return true;
    L18:
        u(r101 + " priority below " + r100);
        i r105 = n();
        if (r105 == null) goto L21;
        r105.b(r101, ListActionEnum.REMOVE);
    L21:
        i r106 = e();
        if (r106 == null) goto L24;
        r106.b(r101, ListActionEnum.ADD);
    L24:
        p(r101, false);
        q(r101.f116191a, r110 + " priority is lower than " + r100 + ", so not show.");
        int r107 = d0.f116096a;
        d0.a(String.valueOf(r101.f116191a), this.f116051e, r101.f116202l.f116104b, ErrorReason.LOW_PRIORITY.getValue(), r110 + " priority is lower than " + r100 + ", so not show.");
        return false;
    L5:
        r102 = false;
        goto L7
    }
}
