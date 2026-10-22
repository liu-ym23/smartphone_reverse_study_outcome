package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import am2.x;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f135473o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TreeMap<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> f135474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TreeMap<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> f135475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> f135476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f f135477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> f135478e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> f135479f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f135480g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f135481h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f135482i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f135483j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final g f135484k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f135485l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HorizontalScrollView f135486m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HorizontalScrollView f135487n;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.comment.newinput.framework.b$b, reason: collision with other inner class name */
    public static final class C2131b<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C2131b f135488a = null;

        static {
            f135488a = new C2131b();
        }

        public C2131b() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return (((InputFunctionEnum) r101).getPriority() > ((InputFunctionEnum) r100).getPriority() ? 1 : (((InputFunctionEnum) r101).getPriority() == ((InputFunctionEnum) r100).getPriority() ? 0 : -1));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f135489a = null;

        static {
            f135489a = new c();
        }

        public c() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r100, Object r101) {
            return (((InputFunctionEnum) r101).getPriority() > ((InputFunctionEnum) r100).getPriority() ? 1 : (((InputFunctionEnum) r101).getPriority() == ((InputFunctionEnum) r100).getPriority() ? 0 : -1));
        }
    }

    static {
    }

    public final void a() {
        TreeMap<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r100 = this.f135474a;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r102 = r100.entrySet().iterator();
    L3:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L10;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r104 = r102.next();
        if (r104.getValue().n() != 2) goto L8;
        r103 = true;
    L8:
        if (r103 == false) goto L3;
        r101.put(r104.getKey(), r104.getValue());
        goto L3
    L10:
        Iterator r105 = r101.entrySet().iterator();
        boolean r106 = false;
    L12:
        if (r105.hasNext() == false) goto L16;
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) ((Map.Entry) r105.next()).getValue()).i() == false) goto L12;
        r106 = true;
        goto L12
    L16:
        TreeMap<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r107 = this.f135475b;
        LinkedHashMap r108 = new LinkedHashMap();
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r109 = r107.entrySet().iterator();
    L18:
        if (r109.hasNext() == false) goto L25;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r110 = r109.next();
        if (r110.getValue().n() != 2) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == false) goto L18;
        r108.put(r110.getKey(), r110.getValue());
        goto L18
    L22:
        r111 = false;
        goto L23
    L25:
        Iterator r112 = r108.entrySet().iterator();
    L27:
        if (r112.hasNext() == false) goto L31;
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) ((Map.Entry) r112.next()).getValue()).i() == false) goto L27;
        r106 = true;
        goto L27
    L31:
        Iterator r113 = ((LinkedHashMap) this.f135476c).entrySet().iterator();
    L33:
        if (r113.hasNext() == false) goto L37;
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) ((Map.Entry) r113.next()).getValue()).canShowRedDot() == false) goto L33;
        r106 = true;
        goto L33
    L37:
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r114 = this.f135477d;
        if (r114 == null) goto L66;
        r114.u(r106, true);
        return;
    }

    public final int b() {
        return this.f135475b.size() + this.f135474a.size();
    }

    public final int c(InputFunctionEnum r100) {
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r101 = this.f135474a.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r102 = r101.next();
        if (r102.getKey() != r100) goto L4;
        return r102.getValue().n();
    L9:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r103 = this.f135475b.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L16;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r104 = r103.next();
        if (r104.getKey() != r100) goto L11;
        return r104.getValue().n();
    L16:
        return 1;
    }

    public final void d(com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c r110) {
        Intrinsics.checkNotNullParameter(r110, "behavior");
        int r100 = com.bytedance.android.livesdk.interactivity.comment.newinput.framework.c.f135490a[r110.b().ordinal()];
        if (r100 != 1) goto L5;
        this.f135475b.put(r110.f135397f, r110);
        View r101 = r110.getView();
        if (r101 == null) goto L53;
        r101.setOnClickListener(this);
    L53:
        r110.r(this.f135484k);
        return;
    L5:
        if (r100 != 2) goto L7;
        InputFunctionEnum r102 = null;
        if ((r110 instanceof com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f) == true) goto L15;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.c r103 = null;
    L16:
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r104 = (com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f) r103;
        this.f135477d = r104;
        if (r104 == null) goto L19;
        InputFunctionManager$registerBehavior$1 r105 = new InputFunctionManager$registerBehavior$1(this);
        Intrinsics.checkNotNullParameter(r105, "action");
        r104.f135410n = r105;
    L19:
        View r106 = r110.getView();
        if (r106 == null) goto L22;
        r106.setOnClickListener(this);
    L22:
        com.bytedance.android.livesdk.interactivity.comment.newinput.c r107 = this.f135484k.V();
        if (r107 == null) goto L44;
        com.bytedance.android.livesdk.interactivity.comment.newinput.a r108 = r107.f135419g;
        if (r108 == null) goto L44;
        String r109 = r108.f135380p;
        if (r109 == null) goto L44;
        InputFunctionEnum.Companion.getClass();
        if (r109.length() != 0) goto L31;
        boolean r111 = true;
    L32:
        if (r111 == true) goto L40;
        InputFunctionEnum[] r112 = InputFunctionEnum.values();
        int r113 = r112.length;
        int r114 = 0;
    L35:
        if (r114 >= r113) goto L40;
        InputFunctionEnum r115 = r112[r114];
        if (Intrinsics.areEqual(r115.getLogValue(), r109) == true) goto L38;
        r114 = r114 + 1;
        goto L35
    L38:
        r102 = r115;
    L40:
        if (r102 == null) goto L44;
        if (c(r102) != 2) goto L44;
        boolean r116 = true;
    L45:
        HashMap r117 = new HashMap();
        r117.put("screen_type", "portrait");
        if (r116 == false) goto L48;
        String r118 = "on";
    L49:
        r117.put("extend_mode", r118);
        j0.l().sendLog("livesdk_comment_expansion_module_extend_show", r117, new Object[]{IRoom.class, x.class});
        goto L53
    L48:
        r118 = "off";
        goto L49
    L31:
        r111 = false;
    L44:
        r116 = false;
        goto L45
    L15:
        r103 = r110;
        goto L16
    L7:
        if (r100 == 3) goto L11;
        this.f135474a.put(r110.f135397f, r110);
        View r119 = r110.getView();
        if (r119 == null) goto L53;
        r119.setOnClickListener(this);
        goto L53
    L11:
        this.f135476c.put(r110.f135397f, r110);
        goto L53
    }

    public final void e(boolean r110) {
        StringBuilder r100 = new StringBuilder();
        int r101 = this.f135479f.size();
        List<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r102 = this.f135478e;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if ((true ^ this.f135479f.contains((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r105)) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r103.iterator();
    L9:
        boolean r108 = false;
        if (r107.hasNext() == false) goto L19;
        Object r109 = r107.next();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r111 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r109;
        if (r110 == false) goto L15;
    L13:
        r108 = true;
    L17:
        if (r108 == false) goto L9;
        r106.add(r109);
        goto L9
    L15:
        if (r111.n() != 1) goto L17;
    L19:
        ArrayList r112 = new ArrayList();
        Iterator r113 = r106.iterator();
    L21:
        if (r113.hasNext() == false) goto L28;
        Object r114 = r113.next();
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r114).q() == InputFunctionEnum.ChatInputCarrier_Audio) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == false) goto L21;
        r112.add(r114);
        goto L21
    L25:
        r115 = false;
        goto L26
    L28:
        Iterator r116 = r112.iterator();
    L30:
        if (r116.hasNext() == false) goto L32;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r117 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r116.next();
        r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r100.append(r117.q().getLogValue());
        this.f135479f.add(r117);
        goto L30
    L32:
        List<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r118 = this.f135478e;
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L34:
        if (r120.hasNext() == false) goto L38;
        Object r121 = r120.next();
        if ((!this.f135479f.contains((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r121)) == false) goto L34;
        r119.add(r121);
        goto L34
    L38:
        ArrayList r122 = new ArrayList();
        Iterator r123 = r119.iterator();
    L40:
        if (r123.hasNext() == false) goto L47;
        Object r124 = r123.next();
        if (((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r124).q() != InputFunctionEnum.ChatInputCarrier_Audio) goto L44;
        boolean r125 = true;
    L45:
        if (r125 == false) goto L40;
        r122.add(r124);
        goto L40
    L44:
        r125 = false;
        goto L45
    L47:
        Iterator r126 = r122.iterator();
    L49:
        if (r126.hasNext() == false) goto L56;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r127 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r126.next();
        r100.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        if (this.f135484k.f() != 0) goto L53;
        String r128 = "voice";
    L54:
        r100.append(r128);
        this.f135479f.add(r127);
        goto L49
    L53:
        r128 = "voice_to_text";
        goto L54
    L56:
        if (this.f135479f.size() != r101) goto L59;
        return;
    L59:
        if (r100.length() <= 0) goto L61;
        boolean r129 = true;
    L62:
        if (r129 == false) goto L64;
        r100.deleteCharAt(0);
    L64:
        StringBuilder r130 = new StringBuilder();
        List<com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r131 = this.f135478e;
        ArrayList r132 = new ArrayList();
        Iterator<T> r133 = r131.iterator();
    L66:
        if (r133.hasNext() == false) goto L76;
        Object r134 = r133.next();
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r135 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r134;
        if (r110 == false) goto L71;
    L69:
        boolean r136 = true;
    L74:
        if (r136 == false) goto L66;
        r132.add(r134);
        goto L66
    L71:
        if (r135.n() == 1) goto L69;
        r136 = false;
        goto L74
    L76:
        Iterator r137 = r132.iterator();
    L78:
        if (r137.hasNext() == false) goto L83;
        com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a r138 = (com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r137.next();
        if (r138.i() == false) goto L78;
        r130.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        r130.append(r138.q().getLogValue());
        goto L78
    L83:
        if (r130.length() <= 0) goto L85;
        boolean r139 = true;
    L86:
        if (r139 == false) goto L88;
        r130.deleteCharAt(0);
    L88:
        HashMap r140 = new HashMap();
        r140.put("show_icon", r100.toString());
        if (r110 == false) goto L91;
        String r141 = "on";
    L92:
        r140.put("extend_mode", r141);
        r140.put("screen_type", "portrait");
        r140.put("is_red_dot", r130.toString());
        IInteractivityInjectService r142 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r142 == null) goto L95;
        r142.buildVsRoomLog(null, r140);
    L95:
        j0.l().sendLog("livesdk_comment_expansion_module_show", r140, new Object[]{IRoom.class, x.class});
        return;
    L91:
        r141 = "off";
        goto L92
    L85:
        r139 = false;
        goto L86
    L61:
        r129 = false;
        goto L62
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r101 = this.f135474a.entrySet().iterator();
    L3:
        Object r102 = null;
        if (r101.hasNext() == false) goto L12;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r103 = r101.next();
        if (r100 == null) goto L9;
        r102 = r100.getTag();
    L9:
        if (r102 != r103.getKey()) goto L3;
        r103.getValue().t(r100, this.f135484k);
        return;
    L12:
        Iterator<Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a>> r104 = this.f135475b.entrySet().iterator();
    L14:
        if (r104.hasNext() == false) goto L23;
        Map.Entry<InputFunctionEnum, com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a> r105 = r104.next();
        if (r100 == null) goto L18;
        Object r106 = r100.getTag();
    L20:
        if (r106 != r105.getKey()) goto L14;
        r105.getValue().t(r100, this.f135484k);
        return;
    L18:
        r106 = null;
        goto L20
    L23:
        Iterator r107 = ((LinkedHashMap) this.f135476c).entrySet().iterator();
    L25:
        if (r107.hasNext() == false) goto L33;
        Map.Entry r108 = (Map.Entry) r107.next();
        if (r100 == null) goto L29;
        Object r109 = r100.getTag();
    L31:
        if (r109 != ((InputFunctionEnum) r108.getKey())) goto L25;
        ((com.bytedance.android.livesdk.interactivity.comment.newinput.framework.a) r108.getValue()).t(r100, this.f135484k);
        goto L25
    L29:
        r109 = null;
        goto L31
    L33:
        if (r100 == null) goto L36;
        r102 = r100.getTag();
    L36:
        if (r102 != InputFunctionEnum.ChatInputCarrier_Fold) goto L52;
        com.bytedance.android.livesdk.interactivity.comment.newinput.behavior.f r110 = this.f135477d;
        if (r110 == null) goto L53;
        r110.t(r100, this.f135484k);
        return;
    L53:
        return;
    }

    public b(g r100, ViewGroup r101, HorizontalScrollView r102, HorizontalScrollView r103) {
        Intrinsics.checkNotNullParameter(r100, "inputPanelBridges");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "rightScrollContainer");
        Intrinsics.checkNotNullParameter(r103, "leftScrollContainer");
        this.f135484k = r100;
        this.f135485l = r101;
        this.f135486m = r102;
        this.f135487n = r103;
        this.f135474a = new TreeMap(C2131b.f135488a);
        this.f135475b = new TreeMap(c.f135489a);
        this.f135476c = new LinkedHashMap();
        this.f135478e = new ArrayList();
        this.f135479f = new LinkedHashSet();
        int r104 = s1.k(R.dimen.ttlive_input_dialog_new_input_container_height);
        this.f135480g = r104;
        this.f135481h = s1.y() - r104;
        this.f135482i = UtilityKotlinExtentionsKt.i(4);
    }
}
