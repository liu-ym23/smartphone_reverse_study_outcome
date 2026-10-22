package com.bytedance.android.livesdk.interactivity.publicscreen.highlight.data;

import android.content.Context;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.IPSHighlightCompLifecycle$State;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.PSHighlightType;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.b;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.n;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommentTopicConfig;
import com.bytedance.android.livesdk.interactivity.api.settings.config.PSHighlightCommonConfig;
import com.bytedance.android.livesdk.interactivity.publicscreen.highlight.comp.PSHighlightCommonComp;
import com.bytedance.android.livesdk.message.model.RoomHighlightAreaContainerMessage;
import com.bytedance.android.livesdk.message.model.b6;
import com.bytedance.android.livesdk.utils.c1;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.HighlightAreaPriorityConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.live.datacontext.j;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lk1.c;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/highlight/data/PSHighlightCommonCompLauncher;", "Lcom/bytedance/android/livesdk/interactivity/api/publicscreen/highlight/b;", "Lvlc/l;", "Landroidx/lifecycle/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PSHighlightCommonCompLauncher extends b implements l, Observer<KVData> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, PSHighlightCommonComp> f138937e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<PSHighlightCommonComp> f138938f;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PSHighlightCommonCompLauncher f138939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PSHighlightCommonComp f138940b;

        public a(PSHighlightCommonCompLauncher r100, PSHighlightCommonComp r101) {
            this.f138939a = r100;
            this.f138940b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IPSHighlightCompLifecycle$State r101 = (IPSHighlightCompLifecycle$State) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (com.bytedance.android.livesdk.interactivity.publicscreen.highlight.data.a.f138941a[r101.ordinal()] != 1) goto L18;
            Map<String, PSHighlightCommonComp> r102 = this.f138939a.f138937e;
            PSHighlightCommonComp r103 = this.f138940b;
            if (r103 == null) goto L14;
            n r104 = r103.getType();
            if (r104 == null) goto L14;
            String r105 = r104.getType() + '_' + r104.getBizScene() + '_' + r103.e();
        L15:
            r102.remove(r105);
            o.c("common highlight comp is destroy, remove from curComps");
            return;
        L14:
            r105 = "";
            goto L15
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public final void a() {
        List<PSHighlightCommonComp> r100 = this.f138938f;
        if ((!r100.isEmpty()) == true) goto L6;
        r100 = null;
    L6:
        if (r100 == null) goto L17;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        Object r103 = r102.next();
        if ((!((PSHighlightCommonComp) r103).g()) == false) goto L9;
        r101.add(r103);
        goto L9
    L13:
        Iterator r104 = r101.iterator();
    L15:
        if (r104.hasNext() == false) goto L24;
        PSHighlightCommonComp r105 = (PSHighlightCommonComp) r104.next();
        r105.p("extra_key_reshow_from_rotate", Boolean.TRUE);
        r105.q();
        goto L15
    L24:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public final void b() {
        ((ArrayList) this.f138938f).clear();
        Map<String, PSHighlightCommonComp> r100 = this.f138937e;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();
        if ((!((PSHighlightCommonComp) r103.getValue()).g()) == false) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L8:
        ((ArrayList) this.f138938f).addAll(r101.values());
    }

    public PSHighlightCommonCompLauncher() {
        this.f138937e = new LinkedHashMap();
        this.f138938f = new ArrayList();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.b, com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.i
    public final void onUnload() {
        super.onUnload();
        Map<String, PSHighlightCommonComp> r100 = this.f138937e;
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = ((LinkedHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry r103 = (Map.Entry) r102.next();
        if ((!((PSHighlightCommonComp) r103.getValue()).g()) == false) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L8:
        Iterator r104 = r101.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((PSHighlightCommonComp) ((Map.Entry) r104.next()).getValue()).b();
        goto L10
    L12:
        k r105 = this.f133430b;
        if (r105 == null) goto L17;
        DataCenter r106 = r105.getDataCenter();
        if (r106 == null) goto L17;
        r106.removeObserver(this);
    L17:
        ((LinkedHashMap) this.f138937e).clear();
        ((ArrayList) this.f138938f).clear();
        j<d> r107 = this.f133431c;
        if (r107 == null) goto L27;
        r107.c(new AnonymousClass3(this));
        return;
    }

    public static String d(b6 r100) {
        return r100.getType() + '_' + r100.a() + '_' + r100.f();
    }

    public static boolean e(b6 r110) {
        Map<String, String> r100 = r110.c();
        Long r101 = null;
        if (r100 == null) goto L7;
        String r102 = r100.get("end_time");
        if (r102 == null) goto L7;
        Long r103 = StringsKt.toLongOrNull(r102);
    L8:
        boolean r104 = true;
        if (r103 != null) goto L12;
        o.c("msg endTime is null, default show");
        return true;
    L12:
        long r105 = r103.longValue() * 1000;
        Map<String, String> r111 = r110.c();
        if (r111 == null) goto L17;
        String r112 = r111.get("end_time_left_ms");
        if (r112 == null) goto L17;
        r101 = StringsKt.toLongOrNull(r112);
    L17:
        long r106 = p6.b();
        if (r101 == null) goto L25;
        long r107 = p6.b();
        long r108 = r105 - r107;
        if (r108 >= r101.longValue()) goto L23;
        r104 = false;
    L23:
        int r113 = o.f133452a;
        o.c("msg isInDisplayTime=" + r104 + ", endTime:" + r105 + ", now:" + r107 + ", canDisplayTime:" + r108 + ", endTimeLeftMs:" + r101);
    L29:
        return r104;
    L25:
        if (r106 <= r105) goto L28;
        r104 = false;
    L28:
        int r114 = o.f133452a;
        o.c("msg isInDisplayTime=" + r104 + ", endTime:" + r105 + ", now:" + r106);
    L7:
        r103 = null;
        goto L8
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(KVData r100) {
        KVData r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "kvData");
        String r102 = r101.getKey();
        if (r102.hashCode() == 62101746) goto L6;
        return;
    L6:
        if (r102.equals("live_highlight_common_comp_roomauth_change") == false) goto L35;
        Integer r103 = (Integer) r101.getData(Integer.valueOf((int) 0));
        if (r103 != null) goto L10;
        return;
    L10:
        if (r103.intValue() != ((int) 2)) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == true) goto L16;
        r103 = null;
    L16:
        if (r103 == null) goto L37;
        o.c("receive room auth msg,the disable");
        Map<String, PSHighlightCommonComp> r105 = this.f138937e;
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r107 = ((LinkedHashMap) r105).entrySet().iterator();
    L19:
        if (r107.hasNext() == false) goto L23;
        Map.Entry r108 = (Map.Entry) r107.next();
        if ((!((PSHighlightCommonComp) r108.getValue()).g()) == false) goto L19;
        r106.put(r108.getKey(), r108.getValue());
        goto L19
    L23:
        Iterator r109 = r106.entrySet().iterator();
    L25:
        if (r109.hasNext() == false) goto L27;
        ((PSHighlightCommonComp) ((Map.Entry) r109.next()).getValue()).b();
        goto L25
    L27:
        ((LinkedHashMap) this.f138937e).clear();
        return;
    L37:
        return;
    L12:
        r104 = false;
        goto L13
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r210) {
        if ((r210 instanceof RoomHighlightAreaContainerMessage) == false) goto L153;
        RoomHighlightAreaContainerMessage r100 = (RoomHighlightAreaContainerMessage) r210;
        Boolean r101 = null;
        if (r100 == null) goto L7;
        b6 r102 = r100.getHighlightAreaContainer();
    L8:
        if (r102 != null) goto L10;
        o.c("RoomHighlightAreaContainerMessage highlightAreaContainer is null");
        return;
    L10:
        k r103 = this.f133430b;
        boolean r104 = true;
        if (r103 == null) goto L29;
        DataCenter r105 = r103.getDataCenter();
        if (r105 == null) goto L29;
        c.f509546i2.getClass();
        mk1.a r106 = c.a.a(r105).getComponentStatus("room_auth_highlight_area_container");
        if (r106 == null) goto L29;
        if (r106.f514293a != 3) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == false) goto L22;
    L25:
        boolean r108 = true;
    L26:
        if (r108 != true) goto L29;
        boolean r109 = false;
    L30:
        if (r109 == true) goto L32;
        o.c("room auth is disable, doesn't work");
        return;
    L32:
        Long r110 = r102.getType();
        if (r110 != null) goto L36;
    L38:
        boolean r111 = false;
    L39:
        boolean r112 = Intrinsics.areEqual(r102.a(), "comment_topic");
        PSHighlightCommentTopicConfig.a r113 = PSHighlightCommentTopicConfig.f133757b;
        k r114 = this.f133430b;
        if (r114 == null) goto L42;
        DataCenter r115 = r114.getDataCenter();
    L43:
        r113.getClass();
        if (r115 != null) goto L46;
    L47:
        if (r115 == null) goto L52;
        if (a0.j(r115) != true) goto L52;
    L59:
        boolean r116 = false;
    L68:
        k r117 = this.f133430b;
        if (r117 != null) goto L71;
    L79:
        k r118 = this.f133430b;
        if (r118 != null) goto L82;
    L84:
        boolean r119 = false;
    L85:
        if (r111 == false) goto L90;
        if (r112 == false) goto L90;
        if (r116 == false) goto L89;
        if (r119 == false) goto L90;
    L89:
        boolean r120 = true;
    L91:
        int r121 = o.f133452a;
        o.c("disableTopicMsg, result=" + r120 + ",isTopicComp=" + r111 + ",isCommentTopicScene=" + r112 + ",enable=" + r116 + ",hasComp=" + r119);
        if (r120 == false) goto L94;
        o.c("interceptMsg");
        return;
    L94:
        Lazy r122 = PSHighlightType.CommonHighlightComp.f133417f;
        HighlightAreaPriorityConfig r123 = r102.e();
        if (r123 == null) goto L104;
        Long r124 = r102.getType();
        if (r124 == null) goto L99;
        long r125 = r124.longValue();
    L100:
        String r126 = r102.a();
        if (r126 != null) goto L103;
        r126 = "";
    L103:
        PSHighlightType.CommonHighlightComp r127 = new PSHighlightType.CommonHighlightComp(r125, r126, r123.getShowPriority(), r123.getLocationPriority());
    L106:
        if (r127.getType() != (-1)) goto L116;
        String r128 = r127.f133419c;
        if (r128 != null) goto L110;
    L113:
        boolean r129 = true;
    L114:
        if (r129 == false) goto L116;
    L117:
        if (r104 == false) goto L119;
        o.c("psHighlightType is invalid");
        return;
    L119:
        PSHighlightCommonConfig.f133759b.getClass();
        if (((PSHighlightCommonConfig) PSHighlightCommonConfig.f133758a.getValue()).c() == true) goto L130;
        PSHighlightCommonComp r130 = (PSHighlightCommonComp) ((LinkedHashMap) this.f138937e).get(d(r102));
        if (r130 == null) goto L127;
        if (r130.g() == true) goto L127;
        r130.update(r100);
        o.c("commonComp is exit, update info");
        return;
    L127:
        if (e(r102) == true) goto L129;
        o.c("msg is not in display time");
        return;
    L129:
        PSHighlightCommonComp r131 = c(r100, r127);
        this.f138937e.put(d(r102), r131);
        r131.q();
        return;
    L130:
        Long r132 = r102.d();
        if (r132 != null) goto L133;
    L143:
        PSHighlightCommonComp r133 = (PSHighlightCommonComp) ((LinkedHashMap) this.f138937e).get(d(r102));
        if (r133 == null) goto L149;
        if (r133.g() == true) goto L149;
        r133.update(r100);
        o.c("commonComp is exit, update info");
        return;
    L149:
        if (e(r102) == true) goto L151;
        o.c("msg is not in display time");
        return;
    L151:
        PSHighlightCommonComp r134 = c(r100, r127);
        this.f138937e.put(d(r102), r134);
        r134.q();
        return;
    L133:
        if (r132.longValue() == 0) goto L143;
        if (r132.longValue() != 1) goto L142;
        PSHighlightCommonComp r135 = (PSHighlightCommonComp) ((LinkedHashMap) this.f138937e).get(d(r102));
        if (r135 != null) goto L140;
        return;
    L140:
        if (r135.g() == true) goto L162;
        r135.b();
        o.c("commonComp is exit and operate is dismiss, dismiss comp");
        return;
    L162:
        return;
    L142:
        o.c("operate is not support");
        return;
    L110:
        if (r128.length() == 0) goto L113;
        r129 = false;
    L116:
        r104 = false;
        goto L117
    L99:
        r125 = -1;
        goto L100
    L104:
        r127 = new PSHighlightType.CommonHighlightComp(0);
    L90:
        r120 = false;
        goto L91
    L82:
        if (r118.getHasComponentShow() != true) goto L84;
        r119 = true;
        goto L85
    L71:
        if (r117.getHasComponentShow() == true) goto L79;
        k r136 = this.f133430b;
        if (r136 == null) goto L75;
        int r137 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.f140295a;
        r136.setHasComponentShow(com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.a(r136.getDataCenter()));
    L75:
        int r138 = o.f133452a;
        StringBuilder r139 = new StringBuilder("收到消息时挂载组件判断结果：");
        k r140 = this.f133430b;
        if (r140 == null) goto L78;
        r101 = Boolean.valueOf(r140.getHasComponentShow());
    L78:
        r139.append(r101);
        o.c(r139.toString());
    L52:
        if (c1.b(r115) == false) goto L54;
    L57:
        boolean r141 = true;
    L58:
        if (r141 == true) goto L59;
        if (r115 != null) goto L62;
    L64:
        boolean r142 = false;
    L65:
        if (r142 == false) goto L67;
        r116 = ((PSHighlightCommentTopicConfig) PSHighlightCommentTopicConfig.f133756a.getValue()).a();
        goto L68
    L67:
        r116 = ((PSHighlightCommentTopicConfig) PSHighlightCommentTopicConfig.f133756a.getValue()).b();
        goto L68
    L62:
        if (a0.d(r115, false) != true) goto L64;
        r142 = true;
        goto L65
    L54:
        if (c1.c(r115) == true) goto L57;
        r141 = false;
        goto L58
    L46:
        if (a0.k(r115) == true) goto L59;
    L42:
        r115 = null;
        goto L43
    L36:
        if (r110.longValue() != 1) goto L38;
        r111 = true;
        goto L39
    L22:
        if (r106.b() == true) goto L25;
        r108 = false;
        goto L26
    L19:
        r107 = false;
    L29:
        r109 = true;
        goto L30
    L7:
        r102 = null;
        goto L8
    }

    public final PSHighlightCommonComp c(RoomHighlightAreaContainerMessage r100, PSHighlightType.CommonHighlightComp r101) {
        Context r102 = getContext();
        k r103 = this.f133430b;
        if (r103 == null) goto L5;
        DataCenter r104 = r103.getDataCenter();
    L6:
        PSHighlightCommonComp r105 = new PSHighlightCommonComp(r100, r101, r102, r104);
        r105.p("extra_key_keep_show_when_rotation", Boolean.TRUE);
        RxUtilKt.c(r105.f133403b.subscribe(new a(this, r105)), this.f133432d);
        return r105;
    L5:
        r104 = null;
        goto L6
    }

    public final void f(Context r100, k r101) {
        Intrinsics.checkNotNullParameter(r101, "psHighlightContext");
        Intrinsics.checkNotNullParameter(r101, "psHighlightContext");
        this.f133429a = r100;
        this.f133430b = r101;
        MiddlewareRoomContext r102 = r101.getRoomContext();
        Long r103 = null;
        if (r102 == null) goto L5;
        j<d> r104 = r102.getMessageManager();
    L6:
        this.f133431c = r104;
        if (r101.getHasComponentShow() == true) goto L14;
        int r105 = com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.f140295a;
        r101.setHasComponentShow(com.bytedance.android.livesdk.interactivity.publicscreen.utils.d.a(r101.getDataCenter()));
        int r106 = o.f133452a;
        StringBuilder r107 = new StringBuilder("roomid：");
        DataCenter r108 = r101.getDataCenter();
        if (r108 == null) goto L13;
        Room r109 = z.o(r108);
        if (r109 == null) goto L13;
        r103 = Long.valueOf(r109.f162599id);
    L13:
        r107.append(r103);
        r107.append(",onLoad时挂载组件判断结果：");
        r107.append(r101.getHasComponentShow());
        o.c(r107.toString());
    L14:
        j<d> r110 = this.f133431c;
        if (r110 == null) goto L17;
        r110.c(new PSHighlightCommonCompLauncher$onLoad$1(this));
    L17:
        DataCenter r111 = r101.getDataCenter();
        if (r111 == null) goto L21;
        r111.observe("live_highlight_common_comp_roomauth_change", this);
        return;
    L21:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
