package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.o0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.MaybeSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.logs.MediaMultiEnterRoomTracer;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorTitleView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import y82.m;
import y82.n;
import y82.o;
import zg1.f0;
import zg1.h1;
import zg1.u1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u0001\u000eJ\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\n¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/MediaMultiLinkAudienceWindowManager;", "Lhy/f$a;", "Lmd0/a$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Ly82/o;", "Ly82/a;", "", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/a;", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/l;", "Lzg1/h1;", "event", "", "onEvent", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAudienceWindowManager extends hy.f.a implements md0.a.InterfaceC6802a, Observer<KVData>, o, y82.a, com.bytedance.android.livesdk.interactivity.medialink.ui.window.a, l {
    public static final /* synthetic */ int C = 0;
    public final hy.e A;
    public final MediaMultiAnchorLinkContext B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f138391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f138392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.api.utils.j f138393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<MediaMultiAnchorWindowV2> f138394d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public y82.b f138395e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MediaMultiAnchorTitleView f138396f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f138397g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Room f138398h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h1 f138399i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LifecycleOwner f138400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f138401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f138402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f138403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SeiAppData f138404n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Integer f138405o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f138406p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f138407q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final HashMap<String, Boolean> f138408r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f138409s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public n f138410t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final e92.n f138411u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.medialink.contract.h f138412v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f138413w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final FrameLayout f138414x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final RoomContext f138415y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final DataCenter f138416z;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaMultiLinkAudienceWindowManager f138417a;

        public b(MediaMultiLinkAudienceWindowManager r100) {
            this.f138417a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            KVData r101 = (KVData) r100;
            if (r101 != null) goto L6;
            return;
        L6:
            if (Intrinsics.areEqual("cmd_gift_dialog_switch", r101.getKey()) == false) goto L41;
            MediaMultiLinkAudienceWindowManager r102 = this.f138417a;
            f0 r103 = (f0) r101.getData();
            int r104 = MediaMultiLinkAudienceWindowManager.C;
            r102.getClass();
            if (r103 != null) goto L10;
            return;
        L10:
            if (FoldScreenUtils.f() == false) goto L12;
            return;
        L12:
            if (PadConfigUtils.c() == false) goto L15;
            return;
        L15:
            if (r102.f138394d.size() != 3) goto L17;
            int r105 = r103.f571826a;
            u1 r106 = (u1) r102.f138416z.get("cmd_multi_state_change", null);
            int r107 = s1.w();
            if (r106 == null) goto L25;
            int r108 = r106.f571952g;
        L26:
            int r109 = r107 - r108;
            if (r109 < r105) goto L29;
        L33:
            if (r105 == 0) goto L35;
        L39:
            r102.f138409s = r105;
            return;
        L35:
            if (r103.f571827b == true) goto L39;
            MediaMultiAnchorWindowV2 r110 = r102.j();
            if (r110 == null) goto L39;
            r110.f138242l.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.interactivity.medialink.ui.g(r110, 0));
            goto L39
        L29:
            if (r105 == r102.f138409s) goto L33;
            int r111 = r105 - r109;
            MediaMultiAnchorWindowV2 r112 = r102.j();
            if (r112 == null) goto L33;
            r112.f138242l.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.interactivity.medialink.ui.g(r112, r111));
            goto L33
        L25:
            r108 = 0;
            goto L26
        L17:
            if ((!r102.f138394d.isEmpty()) == false) goto L21;
            MediaMultiAnchorWindowV2 r113 = r102.j();
            if (r113 == null) goto L21;
            r113.f138242l.getViewTreeObserver().addOnGlobalLayoutListener(new com.bytedance.android.livesdk.interactivity.medialink.ui.g(r113, 0));
        L21:
            r102.f138409s = 0;
            return;
        L41:
            if (Intrinsics.areEqual("data_video_size_pair", r101.getKey()) == false) goto L64;
            Pair r114 = (Pair) this.f138417a.f138416z.get("data_video_size_pair", new Pair(0, 0));
            int r115 = ((Number) r114.component1()).intValue();
            int r116 = ((Number) r114.component2()).intValue();
            Integer r117 = this.f138417a.f138405o;
            if (r117 != null) goto L46;
        L53:
            MediaMultiLinkAudienceWindowManager r118 = this.f138417a;
            String r119 = r118.f138403m;
            if (r119 == null) goto L65;
            y82.b r120 = r118.f138395e;
            if (r120 == null) goto L58;
            r120.b(r118, r119);
        L58:
            this.f138417a.s();
            this.f138417a.f138405o = Integer.valueOf(r115);
            this.f138417a.f138406p = Integer.valueOf(r116);
            return;
        L65:
            return;
        L46:
            if (r115 != r117.intValue()) goto L53;
            Integer r121 = this.f138417a.f138406p;
            if (r121 == null) goto L53;
            if (r116 != r121.intValue()) goto L53;
            return;
        }
    }

    static {
    }

    @Override // md0.a.InterfaceC6802a
    public final boolean isVersionSupported(int r100, int r101) {
        if (r100 != 19) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // md0.a.InterfaceC6802a
    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r100) {
    }

    @Override // y82.a
    public final com.bytedance.android.livesdk.interactivity.medialink.ui.o f() {
        if (PadConfigUtils.c() == true) goto L6;
        return new com.bytedance.android.livesdk.interactivity.medialink.ui.o(false, 0, null, null, null);
    L6:
        if (this.f138407q == false) goto L9;
        return new com.bytedance.android.livesdk.interactivity.medialink.ui.o(true, s1.f(this.f138391a), Integer.valueOf(R.drawable.ttlive_bg_multi_anchor_link_title_pad), Integer.valueOf(UtilityKotlinExtentionsKt.i(32)), Integer.valueOf(UtilityKotlinExtentionsKt.i(112)));
    L9:
        return new com.bytedance.android.livesdk.interactivity.medialink.ui.o(true, s1.f(this.f138392b), Integer.valueOf(R.drawable.ttlive_bg_multi_anchor_link_title_pad), Integer.valueOf(UtilityKotlinExtentionsKt.i(32)), Integer.valueOf(UtilityKotlinExtentionsKt.i(112)));
    }

    @Override // y82.a
    public final int h() {
        return this.f138394d.size();
    }

    @Override // y82.a
    public final boolean isPortrait() {
        int r100 = this.f138402l;
        if (r100 != (-1)) goto L8;
        if (e5.n() == false) goto L12;
    L10:
        return false;
    L12:
        return true;
    L8:
        if (e5.o(r100) == true) goto L10;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.a
    public final MediaMultiAnchorWindowV2 j() {
        Iterator<MediaMultiAnchorWindowV2> r100 = this.f138394d.iterator();
    L3:
        String r101 = null;
        if (r100.hasNext() == false) goto L17;
        MediaMultiAnchorWindowV2 r102 = r100.next();
        AnchorLinkUser r103 = r102.getAnchorLinkUser();
        if (r103 == null) goto L10;
        IBaseUser r104 = r103.getUser();
        if (r104 == null) goto L10;
        String r105 = r104.getIdString();
    L11:
        Room r106 = this.f138398h;
        if (r106 == null) goto L15;
        r101 = r106.getOwnerUserIdString();
    L15:
        if (Intrinsics.areEqual(r105, r101) == false) goto L3;
        return r102;
    L10:
        r105 = null;
        goto L11
    L17:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.l
    public final int l() {
        if (this.f138407q == false) goto L6;
        return s1.f(this.f138391a);
    L6:
        return s1.f(this.f138392b);
    }

    @Override // y82.a
    public final boolean m() {
        Activity r100 = ContextUtil.contextToActivity(this.f138414x.getContext());
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100.getWindow().getAttributes().flags & 1024) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public final void s() {
        y82.b r100 = this.f138395e;
        if (r100 == null) goto L14;
        u1 r101 = r100.c(this);
        if (r101 == null) goto L16;
        Pair r102 = new Pair(Integer.valueOf(r101.f571952g), this.f138416z.get("data_pk_renderview_width", 0));
        this.f138416z.put("cmd_multi_state_change", r101);
        this.f138416z.put("cmd_adjust_video_interact_stream_bottom", r102);
        HSImageView r103 = (HSImageView) this.f138414x.findViewById(R.id.ttlive_multi_anchor_top_bg);
        if (r103 == null) goto L10;
        this.f138414x.removeView(r103);
    L10:
        HSImageView r104 = (HSImageView) this.f138414x.findViewById(R.id.ttlive_multi_anchor_bottom_bg);
        if (r104 == null) goto L15;
        this.f138414x.removeView(r104);
        return;
    L15:
        return;
    L16:
        return;
    }

    @Override // y82.a
    public final List<MediaMultiAnchorWindowV2> n() {
        return this.f138394d;
    }

    @Override // y82.o
    public final void i(m r100) {
        this.f138395e = r100;
        onSeiUpdated(this.f138404n);
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == (-2068819755)) goto L12;
        return;
    L12:
        if (r102.equals("DATA_IS_HIDE_INTERACTION") == true) goto L14;
        return;
    L14:
        if (wt2.a.f(Boolean.FALSE) == false) goto L43;
        Boolean r103 = (Boolean) r101.getData();
        if (r103 == null) goto L40;
        Iterator<MediaMultiAnchorWindowV2> r104 = this.f138394d.iterator();
    L20:
        if (r104.hasNext() == false) goto L44;
        MediaMultiAnchorWindowV2 r105 = r104.next();
        AnchorLinkUser r106 = r105.getAnchorLinkUser();
        if (r106 == null) goto L26;
        User r107 = r106.getMUser();
        if (r107 == null) goto L26;
        String r108 = r107.getIdString();
    L27:
        Room r109 = this.f138398h;
        if (r109 == null) goto L30;
        String r110 = r109.getOwnerUserIdString();
    L32:
        if ((!Intrinsics.areEqual(r108, r110)) == false) goto L20;
        r105.f(r103.booleanValue());
        goto L20
    L30:
        r110 = null;
    L26:
        r108 = null;
        goto L27
    L44:
        return;
    L40:
        return;
    L43:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final void onEvent(h1 r100) {
        if (r100 == null) goto L20;
        this.f138399i = r100;
        int r101 = r100.f571836a;
        if (r101 != 30) goto L12;
        if (Lists.isEmpty(this.f138394d) == true) goto L10;
        MediaMultiAnchorWindowV2 r102 = j();
        if (r102 == null) goto L10;
        r102.r(false, this.f138394d.size());
    L10:
        HashMap r103 = new HashMap();
        r103.put("interact_function", "anchor_connect");
        r103.put("anchor_status", "background");
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r103, new Object[]{x.class, Room.class});
        return;
    L12:
        if (r101 == 31) goto L14;
        return;
    L14:
        if (Lists.isEmpty(this.f138394d) == true) goto L18;
        MediaMultiAnchorWindowV2 r104 = j();
        if (r104 == null) goto L18;
        r104.r(true, this.f138394d.size());
    L18:
        HashMap r105 = new HashMap();
        r105.put("interact_function", "anchor_connect");
        r105.put("anchor_status", "suspend");
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r105, new Object[]{x.class, Room.class});
        return;
    }

    @Override // md0.a.InterfaceC6802a
    public final void onSeiUpdated(SeiAppData r110) {
        SeiAppData r100 = r110;
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "$this$sortGrids");
        List<SeiRegion> r101 = r110.getGrids();
        if (r101 == null) goto L7;
        CollectionsKt.sortWith(r101, e92.o.f471481a);
    L7:
        Unit r102 = Unit.INSTANCE;
    L9:
        boolean r103 = isPortrait();
        this.f138407q = r103;
        n r104 = this.f138410t;
        if (r104 == null) goto L12;
        r104.b(r103);
    L12:
        y82.b r105 = this.f138395e;
        this.f138401k = true;
        this.f138404n = r100;
        if (r100 == null) goto L179;
        MediaMultiEnterRoomTracer.MultiLoadSource r106 = MediaMultiEnterRoomTracer.f138214a;
        MediaMultiEnterRoomTracer.f138220g = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "seiUpdateStart source=" + MediaMultiEnterRoomTracer.f138214a);
        Iterator<Map.Entry<String, Boolean>> r107 = this.f138408r.entrySet().iterator();
    L16:
        if (r107.hasNext() == false) goto L18;
        this.f138408r.put(r107.next().getKey(), Boolean.FALSE);
        goto L16
    L18:
        x82.e.A2.getClass();
        x82.e r108 = x82.e.a.a();
        if (r108 == null) goto L22;
        r108.Oe(r100);
    L22:
        if (r100.getGrids() == null) goto L98;
        Iterator<T> r109 = r100.getGrids().iterator();
        int r111 = 0;
    L25:
        if (r109.hasNext() == false) goto L98;
        SeiRegion r112 = (SeiRegion) r109.next();
        if (this.f138408r.containsKey(r112.getInteractId()) == false) goto L96;
        MediaMultiAnchorWindowV2 r113 = q(r112.getInteractId());
        if (r113 == null) goto L31;
        SeiRegion r114 = r113.getMSeiRegion();
    L32:
        if (r114 != null) goto L35;
    L44:
        boolean r115 = true;
    L45:
        if (r115 == false) goto L51;
        this.f138414x.removeView(r113);
        ArrayList<MediaMultiAnchorWindowV2> r116 = this.f138394d;
        if (r116 == null) goto L50;
        TypeIntrinsics.asMutableCollection(r116).remove(r113);
        p(r112, r100, r111);
    L93:
        if (r113 == null) goto L95;
        r113.setMSeiRegion(r112);
        r113.setMPosition(Integer.valueOf(r111));
    L95:
        this.f138408r.put(r112.getInteractId(), Boolean.TRUE);
    L97:
        r111 = r111 + 1;
        goto L25
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L51:
        if (r113 == null) goto L93;
        hy.e r117 = this.A;
        if (r117 == null) goto L55;
        AnchorLinkUser r118 = r117.f(r112.getInteractId(), false);
    L56:
        hy.e r119 = this.A;
        if (r119 == null) goto L61;
        List<AnchorLinkUser> r120 = r119.getOnlineUserList();
        if (r120 == null) goto L61;
        r120.size();
    L61:
        r113.s(r118);
        if (r113.f138246p == false) goto L64;
    L72:
        r113.p(r112.isMuteAudio());
        AnchorLinkUser r121 = r113.getAnchorLinkUser();
        if (r121 == null) goto L77;
        User r122 = r121.getMUser();
        if (r122 == null) goto L77;
        String r123 = r122.getIdString();
    L78:
        Room r124 = this.f138398h;
        if (r124 == null) goto L81;
        String r125 = r124.getOwnerUserIdString();
    L83:
        if ((!Intrinsics.areEqual(r123, r125)) == false) goto L93;
        AnchorInteractInfo r126 = r100.getAnchorInteractInfo();
        if (r126 == null) goto L89;
        if (r111 == r126.getOwnerIndex()) goto L93;
    L89:
        if (r112.getStatus() != 0) goto L91;
        boolean r127 = true;
    L92:
        r113.r(r127, r100.getGrids().size());
        goto L93
    L91:
        r127 = false;
        goto L92
    L81:
        r125 = null;
    L77:
        r123 = null;
        goto L78
    L64:
        if (r112.isMuteAudio() == false) goto L72;
        Object[] r128 = new Object[1];
        AnchorLinkUser r129 = r113.getAnchorLinkUser();
        if (r129 == null) goto L70;
        IBaseUser r130 = r129.getUser();
        if (r130 == null) goto L70;
        String r131 = r130.getRealNickName();
    L71:
        r128[0] = r131;
        f2.c(s1.C(R.string.ttlive_media_anchor_link_mute_anchor, r128), 0);
    L70:
        r131 = null;
        goto L71
    L55:
        r118 = null;
        goto L56
    L35:
        if (r114.getX() != r112.getX()) goto L44;
        if (r114.getY() != r112.getY()) goto L44;
        if (r114.getWidth() != r112.getWidth()) goto L44;
        if (r114.getHeight() != r112.getHeight()) goto L44;
        r115 = false;
        goto L45
    L31:
        r114 = null;
        goto L32
    L96:
        p(r112, r100, r111);
    L98:
        String r132 = this.f138403m;
        if (r132 == null) goto L102;
        if (r105 == null) goto L102;
        r105.b(this, r132);
    L102:
        Iterator<Map.Entry<String, Boolean>> r133 = this.f138408r.entrySet().iterator();
    L104:
        if (r133.hasNext() == false) goto L116;
        Map.Entry<String, Boolean> r134 = r133.next();
        String r135 = r134.getKey();
        if (r134.getValue().booleanValue() == true) goto L104;
        MediaMultiAnchorWindowV2 r136 = q(r135);
        this.f138414x.removeView(r136);
        ArrayList<MediaMultiAnchorWindowV2> r137 = this.f138394d;
        if (r137 == null) goto L115;
        TypeIntrinsics.asMutableCollection(r137).remove(r136);
        StringBuilder r138 = new StringBuilder("remove ");
        if (r136 == null) goto L112;
        String r139 = r136.g();
    L113:
        r138.append(r139);
        r138.append(" not in windowsMap ");
        r138.append(this.f138408r);
        ALogger.w("ttlive_anchor_link_wm", r138.toString());
        goto L104
    L112:
        r139 = null;
        goto L113
    L115:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    L116:
        List<SeiRegion> r140 = r100.getGrids();
        if (r140 == null) goto L150;
        Iterator<T> r141 = r140.iterator();
    L120:
        if (r141.hasNext() == false) goto L150;
        SeiRegion r142 = (SeiRegion) r141.next();
        MediaMultiAnchorWindowV2 r143 = q(r142.getInteractId());
        if (r143 == null) goto L148;
        String r144 = r142.getInteractId();
        AnchorInteractInfo r145 = r100.getAnchorInteractInfo();
        if (r145 == null) goto L126;
        int r146 = r145.getLayoutType();
    L127:
        if (r146 == 1) goto L129;
        UILayout r147 = UILayout.Normal;
    L130:
        AnchorInteractInfo r148 = r100.getAnchorInteractInfo();
        if (r148 == null) goto L134;
        String r149 = r148.getFocusID();
        if (r149 == null) goto L134;
    L135:
        if (r144 != null) goto L141;
        if (r147 != UILayout.Enlarge) goto L139;
        WindowLayoutType r150 = WindowLayoutType.EnlargeSmall;
    L147:
        r143.setWindowLayoutType(r150);
        goto L148
    L139:
        r150 = WindowLayoutType.Normal;
        goto L147
    L141:
        if (r147 == UILayout.Enlarge) goto L143;
        r150 = WindowLayoutType.Normal;
        goto L147
    L143:
        if (Intrinsics.areEqual(r144, r149) == false) goto L145;
        r150 = WindowLayoutType.EnlargeBig;
        goto L147
    L145:
        r150 = WindowLayoutType.EnlargeSmall;
    L134:
        r149 = "";
        goto L135
    L129:
        r147 = UILayout.Enlarge;
        goto L130
    L126:
        r146 = 0;
    L148:
        if (r143 == null) goto L120;
        r143.setTotalWindowCount(this.f138394d.size());
    L150:
        MediaMultiAnchorLinkContext r151 = this.B;
        if (r151 == null) goto L157;
        com.bytedance.live.datacontext.m<Integer> r152 = r151.getWindowCount();
        if (r152 == null) goto L157;
        if (this.f138394d.size() == r152.getValue().intValue()) goto L157;
        r152.setValue(Integer.valueOf(this.f138394d.size()));
    L157:
        s();
        onEvent(this.f138399i);
        if (this.f138394d.size() > 0) goto L160;
        return;
    L160:
        if (MediaMultiEnterRoomTracer.f138221h != 0) goto L181;
        MediaMultiEnterRoomTracer.f138221h = System.currentTimeMillis();
        ALogger.w("MediaLinkEnterRoomTracer", "seiUpdateDone source=" + MediaMultiEnterRoomTracer.f138214a);
        MediaMultiEnterRoomTracer.a();
        return;
    L181:
        return;
    L179:
        return;
    L8:
        r100 = null;
        goto L9
    }

    public final MediaMultiAnchorWindowV2 q(String r100) {
        Iterator<MediaMultiAnchorWindowV2> r101 = this.f138394d.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        MediaMultiAnchorWindowV2 r102 = r101.next();
        o0.f58946a.getClass();
        if (o0.a.b("0") == false) goto L11;
        if (Intrinsics.areEqual(r102.getUid(), "0") == false) goto L11;
        return r102;
    L11:
        if (TextUtils.equals(r102.getInteractId(), r100) == false) goto L4;
        return r102;
    L13:
        return null;
    }

    @Override // hy.f.a, hy.f.b
    public final void d(int r100, List<AnchorLinkUser> r101) {
        if (r101 == null) goto L12;
        int r102 = r101.size();
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L18;
        Iterator<MediaMultiAnchorWindowV2> r104 = this.f138394d.iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        MediaMultiAnchorWindowV2 r105 = r104.next();
        if (TextUtils.equals(((AnchorLinkUser) ListProtector.get(r101, r103)).getInteractId(), r105.getInteractId()) == false) goto L7;
        AnchorLinkUser r106 = (AnchorLinkUser) ListProtector.get(r101, r103);
        this.f138394d.size();
        r105.s(r106);
    L11:
        r103 = r103 + 1;
        goto L4
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.a
    public final void g(UILayout r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uiLayout");
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r100, "uiLayout");
        Intrinsics.checkNotNullParameter(r101, "source");
    }

    public final void p(SeiRegion r110, SeiAppData r111, int r112) {
        Context r100 = this.f138414x.getContext();
        String r101 = r110.getInteractId();
        hy.e r102 = this.A;
        String r103 = null;
        if (r102 == null) goto L5;
        AnchorLinkUser r104 = r102.f(r110.getInteractId(), false);
    L6:
        MediaMultiAnchorWindowV2 r105 = new MediaMultiAnchorWindowV2(r100, this.f138416z, r101, (AnchorLinkUser) jm2.a.d(r104), this);
        hy.e r106 = this.A;
        if (r106 == null) goto L9;
        AnchorLinkUser r107 = r106.f(r110.getInteractId(), false);
    L10:
        hy.e r108 = this.A;
        if (r108 == null) goto L15;
        List<AnchorLinkUser> r109 = r108.getOnlineUserList();
        if (r109 == null) goto L15;
        r109.size();
    L15:
        r105.s(r107);
        r105.p(r110.isMuteAudio());
        AnchorLinkUser r113 = r105.getAnchorLinkUser();
        if (r113 == null) goto L20;
        IBaseUser r114 = r113.getUser();
        if (r114 == null) goto L20;
        String r115 = r114.getIdString();
    L21:
        Room r116 = this.f138398h;
        if (r116 == null) goto L24;
        r103 = r116.getOwnerUserIdString();
    L24:
        boolean r117 = true;
        if ((!Intrinsics.areEqual(r115, r103)) == false) goto L35;
        AnchorInteractInfo r118 = r111.getAnchorInteractInfo();
        if (r118 == null) goto L31;
        if (r112 == r118.getOwnerIndex()) goto L35;
    L31:
        if (r110.getStatus() == 0) goto L34;
        r117 = false;
    L34:
        r105.r(r117, r111.getGrids().size());
    L35:
        this.f138414x.addView(r105, 0);
        if (PadConfigUtils.c() == false) goto L38;
        boolean r119 = this.f138407q;
        r111.getGrids().size();
        r105.f138247q = r119;
        r105.k();
    L38:
        this.f138394d.add(r105);
        r105.setMSeiRegion(r110);
        r105.setMPosition(Integer.valueOf(r112));
        this.f138408r.put(r110.getInteractId(), Boolean.TRUE);
        return;
    L20:
        r115 = null;
        goto L21
    L9:
        r107 = null;
        goto L10
    L5:
        r104 = null;
        goto L6
    }

    @Override // y82.a
    public final void k(y82.d r100, final Integer r101, final Integer r102, final Integer r103) {
        Intrinsics.checkNotNullParameter(r100, "layoutData");
        MediaMultiAnchorTitleView r104 = this.f138396f;
        if (r104 != null) goto L6;
        return;
    L6:
        if (r104.getView().getParent() != null) goto L8;
        this.f138414x.addView(r104.getView());
    L8:
        y82.c.b(r104.getView(), r100);
        Function1<com.bytedance.android.livesdk.interactivity.medialink.contract.h, Unit> r105 = new MediaMultiLinkAudienceWindowManager$layoutTitleView$1(r101, r102, r103);
        Intrinsics.checkNotNullParameter(r105, "procedure");
        r105.invoke(this.f138412v);
        MediaMultiAnchorTitleView r106 = this.f138396f;
        if (r106 == null) goto L12;
        r106.setState(this.f138412v);
        return;
    }

    public static void r(MediaMultiLinkAudienceWindowManager r110, String r111, boolean r112, boolean r113, int r210) {
        if ((r210 & 2) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r210 & 4) == 0) goto L9;
        boolean r101 = false;
    L10:
        r110.f138411u.getClass();
        if (r111 != null) goto L14;
    L50:
        Integer r102 = null;
    L51:
        if (r102 != null) goto L54;
    L56:
        r110.f138393c.d(r111);
        if (r101 == true) goto L63;
        if (r100 == true) goto L63;
        if (r110.f138401k == false) goto L74;
        ((MaybeSubscribeProxy) Single.just(r111).map(new f(r111)).filter(g.f138426a).as(AutoDispose.bind(r110.f138400j))).subscribe(new h(r110), i.f138428a);
        return;
    L74:
        return;
    L63:
        ALogger.e("ttlive_anchor_link_wm", "onSei: isInit:" + r100 + " isFirstSei:" + r101 + ' ' + r111);
        if (r111 != null) goto L66;
        return;
    L66:
        if (StringsKt.contains$default(r111, "TTLiveSDK_Android", false, 2, null) == false) goto L68;
        return;
    L68:
        if (StringsKt.contains$default(r111, "TTLiveSDK_IOS", false, 2, null) == true) goto L78;
        LiveSeiUtil.f71508i.getClass();
        if (LiveSeiUtil.d(r111) == true) goto L79;
        StringsKt.contains$default(r111, "TTLiveSDK_Windows", false, 2, null);
        return;
    L79:
        return;
    L78:
        return;
    L54:
        if (r102.intValue() != 19) goto L56;
        r110.f138403m = r111;
        goto L56
    L14:
        if (TextUtils.isEmpty(r111) == true) goto L50;
        LiveSeiUtil.f71508i.getClass();     // Catch: JSONException -> L42
        JSONObject r114 = LiveSeiUtil.c(r111);     // Catch: JSONException -> L42
        if (r114.has("info") == false) goto L28;
        if (r114.has("source") == false) goto L28;
        if (TextUtils.equals(r114.optString("source"), "zego") == false) goto L28;
        Object r103 = r114.get("info");     // Catch: JSONException -> L42
        if (r103 == null) goto L26;
        r114 = (JSONObject) r103;     // Catch: JSONException -> L42
        goto L28
    L26:
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");     // Catch: JSONException -> L42
    L28:
        if (r114.has("app_data") == false) goto L34;
        JSONObject r104 = new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r114, "app_data"), ""));     // Catch: JSONException -> L42
        if (r104.has("ver") == false) goto L50;
        r102 = Integer.valueOf(r104.optInt("ver"));     // Catch: JSONException -> L42
        goto L51
    L34:
        if (TextUtils.equals(r114.optString("source"), "TTLiveSDK_Android") == true) goto L44;
        if (TextUtils.equals(r114.optString("source"), "TTLiveSDK_IOS") == true) goto L44;
        if (LiveSeiUtil.d(r114.optString("source")) == true) goto L44;
        if (TextUtils.equals(r114.optString("source"), "TTLiveSDK_Windows") == false) goto L50;
    L44:
        if (r114.has("stream_type") == true) goto L46;
    L48:
        r102 = 0;     // Catch: JSONException -> L42
        goto L51
    L46:
        if (JSONObjectProtectorUtils.getInt(r114, "stream_type") != 1) goto L48;
        r102 = -1;     // Catch: JSONException -> L42
        goto L51
    L9:
        r101 = r113;
        goto L10
    L5:
        r100 = r112;
        goto L7
    }

    public MediaMultiLinkAudienceWindowManager(FrameLayout r100, RoomContext r101, DataCenter r102, hy.e r103, MediaMultiAnchorLinkContext r104, LifecycleOwner r105) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r105, "lifecycleOwner");
        this.f138414x = r100;
        this.f138415y = r101;
        this.f138416z = r102;
        this.A = r103;
        this.B = r104;
        this.f138391a = 16.0f;
        this.f138392b = 40.0f;
        this.f138393c = new com.bytedance.android.live.liveinteract.api.utils.j(this);
        this.f138394d = new ArrayList();
        this.f138397g = new CompositeDisposable();
        this.f138400j = r105;
        this.f138402l = -1;
        this.f138407q = true;
        this.f138408r = new HashMap();
        System.currentTimeMillis();
        this.f138411u = new e92.n();
        this.f138412v = new com.bytedance.android.livesdk.interactivity.medialink.contract.h(false);
        this.f138413w = new b(this);
    }
}
