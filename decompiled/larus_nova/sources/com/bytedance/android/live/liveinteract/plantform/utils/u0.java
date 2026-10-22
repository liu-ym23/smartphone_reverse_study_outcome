package com.bytedance.android.live.liveinteract.plantform.utils;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.chatroom.viewmodel.LivePlayModeLogContext;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes46.dex */
public final class u0 {
    public static final String b() {
        ArrayList r100 = new ArrayList();
        com.bytedance.live.datacontext.j<LivePlayModeLogContext> r101 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r101 == null) goto L19;
        LivePlayModeLogContext r102 = r101.getValue();
        if (r102 == null) goto L19;
        com.bytedance.live.datacontext.m<Set<Integer>> r103 = r102.getPlayModes();
        if (r103 == null) goto L19;
        Set<Integer> r104 = r103.getValue();
        if (r104 == null) goto L19;
        Sequence r105 = CollectionsKt.asSequence(r104);
        if (r105 == null) goto L19;
        Iterator r106 = r105.iterator();
    L14:
        if (r106.hasNext() == false) goto L19;
        String r107 = k(((Number) r106.next()).intValue());
        if ((!Intrinsics.areEqual(r107, "normal")) == false) goto L14;
        r100.add(r107);
    L19:
        if (je0.d.f() != 16) goto L22;
        r100.add("link_room");
    L22:
        if (r100.size() != 0) goto L25;
        r100.add("normal");
    L25:
        return CollectionsKt.joinToString$default(r100, ",", "[", "]", 0, null, null, 56, null);
    }

    public static final List<Integer> d() {
        com.bytedance.live.datacontext.j<LivePlayModeLogContext> r100 = com.bytedance.android.live.liveinteract.api.utils.m.d().J();
        if (r100 == null) goto L13;
        LivePlayModeLogContext r101 = r100.getValue();
        if (r101 == null) goto L13;
        com.bytedance.live.datacontext.m<Set<Integer>> r102 = r101.getPlayModes();
        if (r102 == null) goto L13;
        Set<Integer> r103 = r102.getValue();
        if (r103 == null) goto L13;
        List<Integer> r104 = CollectionsKt.toList(r103);
        if (r104 == null) goto L13;
        return r104;
    L13:
        return CollectionsKt.emptyList();
    }

    public static final String c(IRoom r100) {
        ArrayList r101 = new ArrayList();
        if (r100 == null) goto L15;
        z5 r102 = r100.getLinkerDetail();
        if (r102 == null) goto L15;
        List<Long> r103 = r102.getPlayModes();
        if (r103 == null) goto L15;
        Iterator<T> r104 = r103.iterator();
    L10:
        if (r104.hasNext() == false) goto L15;
        String r105 = k((int) ((Number) r104.next()).longValue());
        if ((!Intrinsics.areEqual(r105, "normal")) == false) goto L10;
        r101.add(r105);
    L15:
        if (je0.d.f() != 16) goto L18;
        r101.add("link_room");
    L18:
        if (r101.size() != 0) goto L21;
        r101.add("normal");
    L21:
        return CollectionsKt.joinToString$default(r101, ",", "[", "]", 0, null, null, 56, null);
    }

    public static final String e(List<Integer> r110) {
        Intrinsics.checkNotNullParameter(r110, "playmodes");
        ArrayList r100 = new ArrayList();
        Sequence r111 = CollectionsKt.asSequence(r110);
        if (r111 == null) goto L11;
        Iterator r112 = r111.iterator();
    L6:
        if (r112.hasNext() == false) goto L11;
        String r101 = k(((Number) r112.next()).intValue());
        if ((!Intrinsics.areEqual(r101, "normal")) == false) goto L6;
        r100.add(r101);
    L11:
        if (je0.d.f() != 16) goto L14;
        r100.add("link_room");
    L14:
        if (r100.size() != 0) goto L17;
        r100.add("normal");
    L17:
        return CollectionsKt.joinToString$default(r100, ",", "[", "]", 0, null, null, 56, null);
    }

    public static String j(Integer r100) {
        return i(r100, je0.d.d(), Integer.valueOf(TalkRoomLogUtils.f77434b.f77481a));
    }

    public static final String k(int r100) {
        StringBuilder r101 = new StringBuilder();
        String r102 = com.bytedance.android.live.liveinteract.utils.x.f78837a.get(Integer.valueOf(r100));
        if (r102 != null) goto L5;
        r102 = "normal";
    L5:
        r101.append(r102);
        r101.append("");
        return r101.toString();
    }

    public static final String a(Integer r100, Integer r101) {
        com.bytedance.live.datacontext.j<DataCenter> r102 = com.bytedance.android.live.liveinteract.api.utils.m.i().A2();
        if (r102 == null) goto L5;
        DataCenter r103 = r102.getValue();
    L5:
        int r104 = 0;
        if (r100 == null) goto L8;
        int r105 = r100.intValue();
    L9:
        if (r101 == null) goto L11;
        r104 = r101.intValue();
    L11:
        if (r105 != 0) goto L13;
        return "live";
    L13:
        if (r105 == 5) goto L22;
        if (r105 == 9) goto L18;
        return "radio";
    L18:
        if (r104 != 61) goto L20;
        return "chorus";
    L20:
        return "ktv";
    L22:
        if (r104 != 22) goto L28;
        return "party";
    L28:
        return "radio";
    L8:
        r105 = 0;
        goto L9
    }

    public static final String h(Integer r100, List<Integer> r101) {
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r101) == false) goto L33;
        if (r100 != null) goto L7;
    L10:
        IInteractService r102 = (IInteractService) jc1.k.f(IInteractService.class);
        String r103 = null;
        if (r102 == null) goto L29;
        com.bytedance.android.live.liveinteract.plantform.base.i<ILinkPlayerInfoBridge> r104 = r102.getLinkUserInfoCenter();
        if (r104 == null) goto L29;
        Iterable r105 = r104.getOnlineUserList();
        if (r105 == null) goto L29;
        Iterator r106 = r105.iterator();
    L18:
        if (r106.hasNext() == false) goto L22;
        Object r107 = r106.next();
        if (((ILinkPlayerInfoBridge) r107).isEnlarged() == false) goto L18;
    L23:
        ILinkPlayerInfoBridge r108 = (ILinkPlayerInfoBridge) r107;
        if (r108 == null) goto L29;
        IBaseUser r109 = r108.getUser();
        if (r109 == null) goto L29;
        r103 = r109.getIdString();
        goto L29
    L22:
        r107 = null;
    L29:
        if (Intrinsics.areEqual(r103, je0.d.a()) == false) goto L31;
        return "anchor";
    L31:
        return "guest";
    L7:
        if (r100.intValue() != 43) goto L10;
        return ItemStyle.ITEM_STYLE_DOUBLE;
    L33:
        return "normal";
    }

    public static final String i(Integer r100, List<Integer> r101, Integer r102) {
        if (r100 == null) goto L47;
        r100.intValue();
        com.bytedance.live.datacontext.m<IRoom> r103 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        if (r103 == null) goto L28;
        IRoom r104 = r103.getValue();
        if (r104 == null) goto L28;
        if (r104.isLiveTypeAudio() != true) goto L28;
        if (r100.intValue() != 30) goto L14;
        return "stage_enlarge";
    L14:
        if (r100.intValue() != 26) goto L22;
        if (r102 == null) goto L22;
        if (r102.intValue() != 26) goto L22;
        return "seat_enlarge_double";
    L22:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r101) == false) goto L25;
        return "seat_enlarge";
    L25:
        if (r100.intValue() != 28) goto L27;
        return "seat_enlarge";
    L27:
        return "normal";
    L28:
        int r105 = r100.intValue();
        if (r105 != 2) goto L31;
    L45:
        return "seat_fit";
    L31:
        if (r105 == 3) goto L50;
        if (r105 == 6) goto L50;
        if (r105 == 7) goto L45;
        if (r105 == 43) goto L50;
        if (r105 != 102) goto L41;
    L43:
        return "big_frame";
    L41:
        if (r105 == 103) goto L43;
        return "normal";
    L50:
        return "seat_enlarge";
    L47:
        return null;
    }

    public static final String g(Integer r100, Integer r101, List r102, List r103) {
        if (r100 != null) goto L6;
    L12:
        if (r100 != null) goto L15;
    L23:
        if (r102 == null) goto L38;
        Iterator r104 = r102.iterator();
        int r105 = 0;
    L26:
        if (r104.hasNext() == false) goto L31;
        if (((ILinkPlayerInfoBridge) r104.next()).isEnlarged() == false) goto L26;
        r105 = r105 + 1;
        goto L26
    L31:
        if (r105 != 2) goto L38;
        if (r101 != null) goto L35;
    L37:
        return "double_normal";
    L35:
        if (r101.intValue() != 26) goto L37;
    L36:
        return "stable_double";
    L38:
        return null;
    L15:
        if (r100.intValue() != 28) goto L23;
        if (r103 == null) goto L21;
        if (r103.contains(2L) != true) goto L38;
    L21:
        if (Intrinsics.areEqual(TalkRoomLogUtils.f77445m, Boolean.TRUE) == false) goto L38;
    L6:
        if (r100.intValue() != 26) goto L12;
        if (r101 == null) goto L37;
        if (r101.intValue() != 26) goto L37;
        goto L37
    }

    public static String f(Integer r100, Integer r101, List r102, Integer r103, List r104, List r105, int r106) {
        if ((r106 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r106 & 16) == 0) goto L9;
        r104 = null;
    L9:
        if ((r106 & 32) == 0) goto L11;
        r105 = null;
    L11:
        if (r100 == null) goto L48;
        r100.intValue();
        if (r101 == null) goto L49;
        r101.intValue();
        com.bytedance.android.livesdk.chatroom.o r107 = com.bytedance.android.live.liveinteract.api.utils.m.i();
        if (r107 == null) goto L23;
        com.bytedance.live.datacontext.m<IRoom> r108 = r107.getRoom();
        if (r108 == null) goto L23;
        IRoom r109 = r108.getValue();
        if (r109 == null) goto L23;
        if (r109.isLiveTypeAudio() != true) goto L23;
        return g(r100, r103, r104, r105);
    L23:
        boolean r110 = com.bytedance.android.livesdk.chatroom.interact.model.d0.e(r102);
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.c(r102) == true) goto L26;
        return null;
    L26:
        if (r100.intValue() != 43) goto L29;
    L36:
        return "double_normal";
    L29:
        if (r100.intValue() != 28) goto L38;
        HamletAvatarContext r111 = HamletAvatarContext.Companion.getContext();
        if (r111 == null) goto L52;
        com.bytedance.live.datacontext.m<Boolean> r112 = r111.isMultiAvatarMode();
        if (r112 != null) goto L35;
        return null;
    L35:
        if (r112.getValue().booleanValue() == true) goto L36;
        return null;
    L52:
        return null;
    L38:
        if (r101.intValue() != 12) goto L44;
        if (r110 == false) goto L41;
        String r113 = "party_fit";
    L56:
        return r113;
    L41:
        r113 = "party_normal";
        goto L56
    L44:
        if (r101.intValue() != 8) goto L57;
        if (r110 == false) goto L47;
        r113 = "video_fit";
        goto L56
    L47:
        r113 = "video_normal";
        goto L56
    L57:
        return null;
    L49:
        return null;
    L48:
        return null;
    }
}
