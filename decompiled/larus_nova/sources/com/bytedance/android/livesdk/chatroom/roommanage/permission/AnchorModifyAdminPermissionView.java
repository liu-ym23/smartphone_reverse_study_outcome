package com.bytedance.android.livesdk.chatroom.roommanage.permission;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.x;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.livesdk.action.SelectablePage;
import com.bytedance.android.livesdk.chatroom.LiveRoomPermission;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.RoomPermissionContext;
import com.bytedance.android.livesdk.chatroom.roommanage.AnchorManageAdminDataContext;
import com.bytedance.android.livesdk.chatroom.roommanage.binder.RefineSettingItemBinder;
import com.bytedance.android.livesdk.chatroom.roommanage.d;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;
import mx.e;
import mx.l;
import mx.o;

/* JADX INFO: loaded from: classes7.dex */
public class AnchorModifyAdminPermissionView extends FrameLayout implements com.bytedance.android.livesdk.chatroom.roommanage.c, SelectablePage {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f111487m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f111488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f111489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f111490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f111491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f111492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AnchorManageAdminDataContext f111493f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f111494g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MultiTypeAdapter f111495h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f111496i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Room f111497j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f111498k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f111499l;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorModifyAdminPermissionView f111500a;

        public b(AnchorModifyAdminPermissionView r100) {
            this.f111500a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            if (r101 != null) goto L5;
        L8:
            boolean r102 = true;
        L9:
            if (r102 == false) goto L11;
            f2.c("权限列表获取失败，请稍后重试", 0);
            this.f111500a.f111498k.D0();
            return;
        L11:
            this.f111500a.h();
            return;
        L5:
            if (r101.isEmpty() == true) goto L8;
            r102 = false;
            goto L9
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorModifyAdminPermissionView f111502a;

        public c(AnchorModifyAdminPermissionView r100) {
            this.f111502a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f111502a.f111492e.scrollToPosition(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.chatroom.roommanage.c
    public final void a() {
        this.f111491d.setOnClickListener(x0.a(new AnchorModifyAdminPermissionView$bind$1(this)));
        i();
        RoomPermissionContext r100 = null;
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L7;
        n<RoomPermissionContext> r102 = r101.getPermissionContext();
        if (r102 == null) goto L7;
        r100 = r102.getValue();
    L7:
        if (r100 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        UtilityKotlinExtentionsKt.z(b(R.id.text_titlebar_remove_admin), r103);
        if (r103 == false) goto L15;
        ((TextView) b(R.id.text_titlebar_remove_admin)).setOnClickListener(new AnchorModifyAdminPermissionView$bind$2(this));
    L15:
        this.f111492e.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f111492e.setAdapter(getMultiTypeAdapter());
        if (r103 == true) goto L19;
        Items r104 = new Items();
        r104.add(new com.bytedance.android.livesdk.chatroom.roommanage.binder.a(this.f111497j));
        getMultiTypeAdapter().A2(r104);
        getMultiTypeAdapter().notifyDataSetChanged();
        return;
    L19:
        return;
    L9:
        if (r100.getShouldRefinePermission().getValue().booleanValue() == false) goto L11;
        r103 = true;
        goto L12
    }

    public final void f() {
        this.f111494g.dispose();
        Iterator<T> r100 = getMultiTypeAdapter().f513437a.iterator();
    L4:
        if (r100.hasNext() == false) goto L13;
        Object r101 = r100.next();
        if ((r101 instanceof l) == true) goto L8;
        r101 = null;
    L8:
        l r102 = (l) r101;
        if (r102 == null) goto L4;
        Disposable r103 = r102.f516149m;
        if (r103 == null) goto L4;
        r103.dispose();
        goto L4
    }

    public final void h() {
        AnchorManageAdminDataContext r100 = this.f111493f;
        if (r100 != null) goto L5;
        return;
    L5:
        List<LiveRoomPermission> r101 = r100.getAdminUserOperatingPermissions().getValue();
        Items r102 = new Items();
        Rect r103 = new Rect(16, 16, 16, 6);
        LiveRoomPermission.D.getClass();
        List<LiveRoomPermission> r104 = LiveRoomPermission.C;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L7:
        if (r106.hasNext() == false) goto L15;
        Object r107 = r106.next();
        if (((LiveRoomPermission) r107).getType() != 0) goto L11;
        boolean r108 = true;
    L12:
        if (r108 == false) goto L7;
        r105.add(r107);
        goto L7
    L11:
        r108 = false;
        goto L12
    L15:
        if ((!r105.isEmpty()) == false) goto L17;
        ArrayList r109 = r105;
    L19:
        if (r109 == null) goto L25;
        r102.add(new o("通用权限", 13.0f, r103));
        ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r111 = r105.iterator();
    L22:
        if (r111.hasNext() == false) goto L24;
        LiveRoomPermission r112 = (LiveRoomPermission) r111.next();
        r110.add(new com.bytedance.android.livesdk.chatroom.roommanage.binder.d(r112, r101.contains(r112), this.f111490c));
        goto L22
    L24:
        r102.addAll(r110);
    L25:
        Room r113 = this.f111497j;
        if (r113 != null) goto L28;
    L188:
        getMultiTypeAdapter().A2(r102);
        StringBuilder r114 = new StringBuilder("total ");
        LiveRoomPermission.D.getClass();
        r114.append(LiveRoomPermission.C.size());
        r114.append(", owned: ");
        r114.append(CollectionsKt.joinToString$default(r101, null, null, null, 0, null, AnchorModifyAdminPermissionView$initRefinedSettingItem$2.INSTANCE, 31, null));
        ALogger.d("LiveRoomPermission", r114.toString());
        getMultiTypeAdapter().notifyDataSetChanged();
        return;
    L28:
        if (r113.isMediaRoom() == true) goto L188;
        LiveRoomPermission.D.getClass();
        List<LiveRoomPermission> r115 = LiveRoomPermission.C;
        ArrayList r116 = new ArrayList();
        Iterator<T> r117 = r115.iterator();
    L31:
        if (r117.hasNext() == false) goto L38;
        Object r118 = r117.next();
        if (((LiveRoomPermission) r118).getType() != 1) goto L35;
        boolean r119 = true;
    L36:
        if (r119 == false) goto L31;
        r116.add(r118);
        goto L31
    L35:
        r119 = false;
        goto L36
    L38:
        LiveRoomPermission.D.getClass();
        List<LiveRoomPermission> r120 = LiveRoomPermission.C;
        ArrayList r121 = new ArrayList();
        Iterator<T> r122 = r120.iterator();
    L40:
        if (r122.hasNext() == false) goto L47;
        Object r123 = r122.next();
        if (((LiveRoomPermission) r123).getType() != 2) goto L44;
        boolean r124 = true;
    L45:
        if (r124 == false) goto L40;
        r121.add(r123);
        goto L40
    L44:
        r124 = false;
        goto L45
    L47:
        Room r125 = this.f111497j;
        if (r125 == null) goto L52;
        RoomAuthStatus r126 = r125.getRoomAuthStatus();
        if (r126 == null) goto L52;
        Long r127 = Long.valueOf(r126.showGamePlugin);
    L54:
        if (r127.longValue() != 1) goto L56;
    L61:
        RoomContext.a r128 = RoomContext.Companion;
        RoomContext r129 = RoomContext.a.c(r128, null, 0, 3);
        if (r129 == null) goto L70;
        j<com.bytedance.android.live.room.c> r130 = r129.getAnchorUnionLiveDataContext();
        if (r130 == null) goto L70;
        com.bytedance.android.live.room.c r131 = r130.getValue();
        if (r131 == null) goto L70;
        j<Boolean> r132 = r131.getEnable();
        if (r132 == null) goto L70;
        Boolean r133 = r132.getValue();
    L72:
        if ((!Intrinsics.areEqual(r133, Boolean.TRUE)) == true) goto L74;
    L79:
        RoomContext r134 = RoomContext.a.c(r128, null, 0, 3);
        if (r134 == null) goto L94;
        m<Room> r135 = r134.getRoom();
        if (r135 == null) goto L94;
        Room r136 = r135.getValue();
        if (r136 == null) goto L94;
        if (r136.isLiveTypeAudio() != true) goto L94;
        RoomContext r137 = RoomContext.a.c(r128, null, 0, 3);
        if (r137 == null) goto L101;
        j<f> r138 = r137.getVoiceTalkRoomSubScene();
        if (r138 == null) goto L101;
        f r139 = r138.getValue();
        if (r139 == null) goto L101;
        r139.t();
    L101:
        Map<Long, td1.b> r140 = r100.getAdminPrivilegeExtra().getValue();
        if (r140 != null) goto L104;
    L107:
        boolean r141 = true;
    L108:
        if (r141 == false) goto L110;
    L146:
        ArrayList r142 = r121;
        if (((IInteractService) k.n(IInteractService.class)).isMultiLinkScene() == true) goto L169;
        if ((!r116.isEmpty()) == true) goto L152;
        r116 = null;
    L152:
        if (r116 == null) goto L159;
        r102.add(new e(16.0f, 3));
        r102.add(new o("高级权限-通用（每项限" + r100.getMaxSpecialPermissionAdmins().getValue().intValue() + "人）", r103));
        ArrayList r143 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r144 = r116.iterator();
    L155:
        if (r144.hasNext() == false) goto L157;
        LiveRoomPermission r145 = (LiveRoomPermission) r144.next();
        r143.add(new com.bytedance.android.livesdk.chatroom.roommanage.binder.d(r145, r101.contains(r145), this.f111490c));
        goto L155
    L157:
        r102.addAll(r143);
    L159:
        if ((!r142.isEmpty()) == false) goto L161;
        ArrayList r146 = r142;
    L162:
        if (r146 == null) goto L188;
        r102.add(new e(16.0f, 3));
        r102.add(new o("高级权限-观众连线（每项限" + r100.getMaxSpecialPermissionAdmins().getValue().intValue() + "人）", r103));
        ArrayList r147 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r146, 10));
        Iterator r148 = r146.iterator();
    L165:
        if (r148.hasNext() == false) goto L167;
        LiveRoomPermission r149 = (LiveRoomPermission) r148.next();
        r147.add(new com.bytedance.android.livesdk.chatroom.roommanage.binder.d(r149, g(r149, r101), this.f111490c));
        goto L165
    L167:
        r102.addAll(r147);
        goto L188
    L161:
        r146 = null;
        goto L162
    L169:
        if ((!r142.isEmpty()) == false) goto L171;
        ArrayList r150 = r142;
    L172:
        if (r150 == null) goto L179;
        r102.add(new e(16.0f, 3));
        r102.add(new o("高级权限-观众连线（每项限" + r100.getMaxSpecialPermissionAdmins().getValue().intValue() + "人）", r103));
        ArrayList r151 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r150, 10));
        Iterator r152 = r150.iterator();
    L175:
        if (r152.hasNext() == false) goto L177;
        LiveRoomPermission r153 = (LiveRoomPermission) r152.next();
        r151.add(new com.bytedance.android.livesdk.chatroom.roommanage.binder.d(r153, g(r153, r101), this.f111490c));
        goto L175
    L177:
        r102.addAll(r151);
    L179:
        if ((!r116.isEmpty()) == false) goto L181;
        ArrayList r154 = r116;
    L182:
        if (r154 == null) goto L188;
        r102.add(new e(16.0f, 3));
        r102.add(new o("高级权限-通用（每项限" + r100.getMaxSpecialPermissionAdmins().getValue().intValue() + "人）", r103));
        ArrayList r155 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r154, 10));
        Iterator r156 = r154.iterator();
    L185:
        if (r156.hasNext() == false) goto L187;
        LiveRoomPermission r157 = (LiveRoomPermission) r156.next();
        r155.add(new com.bytedance.android.livesdk.chatroom.roommanage.binder.d(r157, r101.contains(r157), this.f111490c));
        goto L185
    L187:
        r102.addAll(r155);
        goto L188
    L181:
        r154 = null;
        goto L182
    L171:
        r150 = null;
        goto L172
    L110:
        if (TypeIntrinsics.isMutableList(r116) == true) goto L112;
        ArrayList r158 = null;
    L113:
        if (r158 == null) goto L115;
        Iterator r159 = r158.iterator();
    L116:
        if (r159 == null) goto L146;
    L118:
        if (r159.hasNext() == false) goto L146;
        LiveRoomPermission r160 = (LiveRoomPermission) r159.next();
        if (r140.get(Long.valueOf(r160.f105077a)) == null) goto L118;
        td1.b r161 = r140.get(Long.valueOf(r160.f105077a));
        if (r161 == null) goto L124;
        boolean r162 = r161.a();
    L125:
        r160.f105081e = r162;
        td1.b r163 = r140.get(Long.valueOf(r160.f105077a));
        String r164 = "";
        if (r163 == null) goto L129;
        String r165 = r163.b();
        if (r165 == null) goto L129;
    L130:
        Intrinsics.checkNotNullParameter(r165, "<set-?>");
        r160.f105079c = r165;
        ArrayList r166 = r121;
        td1.b r167 = r140.get(Long.valueOf(r160.f105077a));
        if (r167 == null) goto L136;
        String r168 = r167.c();
        if (r168 == null) goto L136;
        r164 = r168;
    L136:
        r160.f105082f = r164;
        td1.b r169 = r140.get(Long.valueOf(r160.f105077a));
        if (r169 == null) goto L139;
        long r170 = r169.d();
    L140:
        r160.f105083g = r170;
        if (r170 != 2) goto L143;
        r159.remove();
    L143:
        r121 = r166;
        goto L118
    L139:
        r170 = 0;
    L129:
        r165 = "";
        goto L130
    L124:
        r162 = false;
        goto L125
    L115:
        r159 = null;
        goto L116
    L112:
        r158 = r116;
        goto L113
    L104:
        if (r140.isEmpty() == true) goto L107;
        r141 = false;
    L94:
        RoomContext r171 = RoomContext.a.c(r128, null, 0, 3);
        if (r171 == null) goto L101;
        j<com.bytedance.android.livesdk.chatroom.viewmodel.e> r172 = r171.getVideoTalkRoomSubScene();
        if (r172 == null) goto L101;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r173 = r172.getValue();
        if (r173 == null) goto L101;
        r173.t();
        goto L101
    L74:
        if (TypeIntrinsics.isMutableList(r116) == true) goto L76;
        ArrayList r174 = null;
    L77:
        if (r174 == null) goto L79;
        LiveRoomPermission.D.getClass();
        r174.remove(LiveRoomPermission.A);
        goto L79
    L76:
        r174 = r116;
    L70:
        r133 = null;
        goto L72
    L56:
        if (TypeIntrinsics.isMutableList(r116) == true) goto L58;
        ArrayList r175 = null;
    L59:
        if (r175 == null) goto L61;
        LiveRoomPermission.D.getClass();
        r175.remove(LiveRoomPermission.f105066p);
        goto L61
    L58:
        r175 = r116;
    L52:
        r127 = null;
        goto L54
    L17:
        r109 = null;
        goto L19
    }

    @Override // com.bytedance.android.livesdk.action.SelectablePage
    public final void onPageSelected() {
        Disposable r100 = null;
        RoomContext r101 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r101 == null) goto L7;
        n<RoomPermissionContext> r102 = r101.getPermissionContext();
        if (r102 == null) goto L7;
        RoomPermissionContext r103 = r102.getValue();
    L9:
        if (r103 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L16;
        return;
    L16:
        DataContext r105 = com.bytedance.live.datacontext.d.d(Reflection.getOrCreateKotlinClass(AnchorManageAdminDataContext.class));
        if ((r105 instanceof AnchorManageAdminDataContext) == true) goto L19;
        r105 = null;
    L19:
        AnchorManageAdminDataContext r106 = (AnchorManageAdminDataContext) r105;
        this.f111493f = r106;
        x r107 = this.f111494g;
        if (r106 == null) goto L26;
        m<List<LiveRoomPermission>> r108 = r106.getAdminUserOperatingPermissions();
        if (r108 == null) goto L26;
        Observable<List<LiveRoomPermission>> r109 = r108.a();
        if (r109 == null) goto L26;
        r100 = r109.subscribe(new b(this));
    L26:
        r107.b(r100);
        AnchorManageAdminDataContext r110 = this.f111493f;
        if (r110 == null) goto L29;
        r110.fetchUserAttributeFromServer();
    L29:
        h();
        if ((!getMultiTypeAdapter().f513437a.isEmpty()) == false) goto L33;
        this.f111492e.post(new c(this));
        return;
    L33:
        return;
    L11:
        if (r103.getShouldRefinePermission().getValue().booleanValue() == false) goto L13;
        r104 = true;
    L7:
        r103 = null;
        goto L9
    }

    public void i() {
        MultiTypeAdapter r100 = getMultiTypeAdapter();
        r100.z2(com.bytedance.android.livesdk.chatroom.roommanage.binder.a.class, new com.bytedance.android.livesdk.chatroom.roommanage.binder.b());
        r100.z2(com.bytedance.android.livesdk.chatroom.roommanage.binder.d.class, new RefineSettingItemBinder());
        r100.z2(o.class, new mx.m(false));
        r100.z2(e.class, new mx.f());
    }

    public MultiTypeAdapter getMultiTypeAdapter() {
        return this.f111495h;
    }

    @Override // com.bytedance.android.livesdk.chatroom.roommanage.c
    public final void unbind() {
        f();
    }

    public final View b(int r100) {
        if (this.f111488a != null) goto L5;
        this.f111488a = new LinkedHashMap();
    L5:
        View r101 = this.f111488a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f111488a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public static boolean g(LiveRoomPermission r100, List r101) {
        LiveRoomPermission.D.getClass();
        if (Intrinsics.areEqual(r100, LiveRoomPermission.f105071u) == false) goto L18;
        if (r101.contains(r100) == false) goto L7;
    L16:
        return true;
    L7:
        if (r101.contains(LiveRoomPermission.f105067q) == true) goto L16;
        if (r101.contains(LiveRoomPermission.f105068r) == true) goto L16;
        if (r101.contains(LiveRoomPermission.f105069s) == true) goto L16;
        if (r101.contains(LiveRoomPermission.f105070t) == true) goto L16;
        return false;
    L18:
        return r101.contains(r100);
    }

    public AnchorModifyAdminPermissionView(Context r100, Room r101, d r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "panelHandle");
        Intrinsics.checkNotNullParameter(r103, "source");
        super(r100);
        this.f111497j = r101;
        this.f111498k = r102;
        this.f111499l = r103;
        this.f111488a = new LinkedHashMap();
        this.f111490c = "admin_list";
        LayoutInflater.from(r100).inflate(R.layout.ttlive_layout_live_room_admin_permission_set, this, true);
        View r104 = findViewById(R.id.admin_permission_set_container);
        this.f111489b = r104;
        int r105 = r103.hashCode();
        if (r105 == (-1271529498)) goto L17;
        if (r105 == (-135331059)) goto L8;
    L25:
        this.f111491d = findViewById(R.id.back);
        this.f111492e = (RecyclerView) findViewById(R.id.setting_list);
        this.f111494g = new x();
        this.f111495h = new MultiTypeAdapter();
        return;
    L8:
        if (r103.equals("from_chat_room") == false) goto L25;
        r104.setBackground(s1.m(R.drawable.ttlive_bg_white_radius8));
        TextView r106 = (TextView) b(R.id.tv_titlebar_admin_setting);
        if (r106 == null) goto L12;
        r106.setTextColor(s1.h(R.color.ttlive_color_161823));
    L12:
        TextView r107 = (TextView) b(R.id.text_titlebar_remove_admin);
        if (r107 == null) goto L15;
        r107.setTextColor(s1.h(R.color.ttlive_color_80_161823));
    L15:
        ((ImageView) b(R.id.iv_titlebar_back)).setImageResource(R.drawable.ttlive_icon_titlebar_back_black);
        goto L25
    L17:
        if (r103.equals("from_toolbar") == false) goto L25;
        r104.setBackground(s1.m(R.drawable.ttlive_bg_live_profile_header_drak));
        TextView r108 = (TextView) b(R.id.tv_titlebar_admin_setting);
        if (r108 == null) goto L21;
        r108.setTextColor(s1.h(R.color.ttlive_commonui_white_50));
    L21:
        TextView r109 = (TextView) b(R.id.text_titlebar_remove_admin);
        if (r109 == null) goto L24;
        r109.setTextColor(s1.h(R.color.ttlive_white_70));
    L24:
        ((ImageView) b(R.id.iv_titlebar_back)).setImageResource(R.drawable.ttlive_ic_live_room_manage_back);
        goto L25
    }
}
