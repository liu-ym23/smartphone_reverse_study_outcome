package com.bytedance.android.livesdk.interactivity.medialink.ui.window;

import am2.x;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkMicIdInfo;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.live.liveinteract.utils.r1;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.interactivity.medialink.contract.MediaMultiAnchorLinkContext;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorTitleView;
import com.bytedance.android.livesdk.interactivity.medialink.ui.MediaMultiAnchorWindowV2;
import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.message.model.AnchorUpdateLayoutContent;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import e92.p;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import nc0.r;
import nc0.s;
import uf2.m1;
import uf2.z;
import zg1.h1;
import zg1.u1;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u0007:\u0001\fJ\u0010\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/MediaMultiLinkAnchorWindowManager;", "Lhy/f$a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lf92/b;", "", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/a;", "Lcom/bytedance/android/livesdk/interactivity/medialink/ui/window/l;", "Lzg1/h1;", "event", "", "onEvent", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiLinkAnchorWindowManager extends hy.f.a implements Observer<KVData>, f92.b, com.bytedance.android.livesdk.interactivity.medialink.ui.window.a, l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f138366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<MediaMultiAnchorWindowV2> f138367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, z.a> f138368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f138369d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f138370e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final double f138371f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final double f138372g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MediaMultiAnchorWindowV2 f138373h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewGroup f138374i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MediaMultiAnchorTitleView f138375j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CompositeDisposable f138376k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Room f138377l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LifecycleOwner f138378m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final HashMap<String, Boolean> f138379n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final p f138380o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Disposable f138381p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f138382q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.medialink.contract.h f138383r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Map<String, ? extends WindowsPosition> f138384s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final FrameLayout f138385t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final RoomContext f138386u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final DataCenter f138387v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final hy.e f138388w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final MediaMultiEnlargeWidget f138389x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final MediaMultiAnchorLinkContext f138390y;

    public static final class a {
    }

    static {
    }

    public static f92.f r() {
        x82.e.A2.getClass();
        x82.e r100 = x82.e.a.a();
        if (r100 == null) goto L7;
        f92.f r101 = r100.Q8();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new f92.g();
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.a
    public final MediaMultiAnchorWindowV2 j() {
        Iterator<MediaMultiAnchorWindowV2> r100 = this.f138367b.iterator();
    L3:
        String r101 = null;
        if (r100.hasNext() == false) goto L17;
        MediaMultiAnchorWindowV2 r102 = r100.next();
        AnchorLinkUser r103 = r102.getAnchorLinkUser();
        if (r103 == null) goto L10;
        User r104 = r103.getMUser();
        if (r104 == null) goto L10;
        String r105 = r104.getIdStr();
    L11:
        Room r106 = this.f138377l;
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
        return s1.f(16.0f);
    }

    public final String u() {
        hy.e r100 = this.f138388w;
        if (r100 == null) goto L27;
        List<AnchorLinkUser> r101 = r100.getOnlineUserList();
        if (r101 == null) goto L27;
        Iterator<T> r102 = r101.iterator();
    L7:
        Object r103 = null;
        if (r102.hasNext() == false) goto L23;
        Object r104 = r102.next();
        IBaseUser r105 = ((AnchorLinkUser) r104).getUser();
        if (r105 == null) goto L12;
        String r106 = r105.getIdString();
    L13:
        RoomContext.a r107 = RoomContext.Companion;
        DataCenter r108 = this.f138387v;
        r107.getClass();
        RoomContext r109 = RoomContext.a.a(r108, 0);
        if (r109 == null) goto L21;
        m<Room> r110 = r109.getRoom();
        if (r110 == null) goto L21;
        Room r111 = r110.getValue();
        if (r111 == null) goto L21;
        r103 = r111.getOwnerUserIdString();
    L21:
        if (Intrinsics.areEqual(r106, r103) == false) goto L7;
        r103 = r104;
        goto L23
    L12:
        r106 = null;
    L23:
        AnchorLinkUser r112 = (AnchorLinkUser) r103;
        if (r112 == null) goto L27;
        String r113 = r112.getInteractId();
        if (r113 == null) goto L27;
        return r113;
    L27:
        return "";
    }

    public final List<String> v() {
        ArrayList r100 = new ArrayList();
        Iterator<MediaMultiAnchorWindowV2> r101 = this.f138367b.iterator();
    L4:
        if (r101.hasNext() == false) goto L11;
        String r102 = r101.next().getInteractId();
        if (r102 == null) goto L4;
        if (TextUtils.isEmpty(r102) == true) goto L4;
        r100.add(r102);
        goto L4
    L11:
        return r100;
    }

    public final int s() {
        return (int) (r().a(RangesKt.coerceAtLeast(this.f138367b.size(), 2)).c() * ((double) this.f138370e));
    }

    @Override // f92.b
    public final Map<String, WindowsPosition> e() {
        return this.f138384s;
    }

    public final void A(Function1<? super com.bytedance.android.livesdk.interactivity.medialink.contract.h, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "procedure");
        r100.invoke(this.f138383r);
        MediaMultiAnchorTitleView r101 = this.f138375j;
        if (r101 == null) goto L6;
        r101.setState(this.f138383r);
        return;
    }

    @Override // f92.b
    public final WindowsPosition o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interactId");
        hy.e r101 = this.f138388w;
        if (r101 == null) goto L5;
        AnchorLinkUser r102 = r101.g(r100);
    L6:
        if (r102 != null) goto L11;
        Map<String, ? extends WindowsPosition> r103 = this.f138384s;
        if (r103 != null) goto L10;
        return null;
    L10:
        return r103.get(r100);
    L11:
        MediaMultiAnchorWindowV2 r104 = t(r100);
        if (r104 == null) goto L27;
        String r105 = r104.getInteractId();
        if (Intrinsics.areEqual(r104.getLinkMicId(), r100) == false) goto L28;
        if (r105 != null) goto L17;
    L20:
        boolean r106 = true;
    L21:
        if (r106 == true) goto L29;
        Map<String, ? extends WindowsPosition> r107 = this.f138384s;
        if (r107 != null) goto L25;
        return null;
    L25:
        return r107.get(r105);
    L29:
        return null;
    L17:
        if (r105.length() == 0) goto L20;
        r106 = false;
        goto L21
    L28:
        return null;
    L27:
        return null;
    L5:
        r102 = null;
        goto L6
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
        if (wt2.a.f(Boolean.TRUE) == false) goto L43;
        A(AnonymousClass1.INSTANCE);
        Boolean r103 = (Boolean) r101.getData();
        if (r103 == null) goto L40;
        Iterator<MediaMultiAnchorWindowV2> r104 = this.f138367b.iterator();
    L20:
        if (r104.hasNext() == false) goto L44;
        MediaMultiAnchorWindowV2 r105 = r104.next();
        AnchorLinkUser r106 = r105.getAnchorLinkUser();
        if (r106 == null) goto L26;
        User r107 = r106.getMUser();
        if (r107 == null) goto L26;
        String r108 = r107.getIdStr();
    L27:
        Room r109 = this.f138377l;
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
        if (r100 == null) goto L16;
        int r101 = r100.f571836a;
        if (r101 != 30) goto L10;
        if (Lists.isEmpty(this.f138367b) == true) goto L8;
        ((MediaMultiAnchorWindowV2) ListProtector.get(this.f138367b, 0)).r(false, this.f138367b.size());
    L8:
        HashMap r102 = new HashMap();
        r102.put("interact_function", "anchor_connect");
        r102.put("anchor_status", "background");
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r102, new Object[]{x.class, Room.class});
        return;
    L10:
        if (r101 == 31) goto L12;
        return;
    L12:
        if (Lists.isEmpty(this.f138367b) == true) goto L14;
        ((MediaMultiAnchorWindowV2) ListProtector.get(this.f138367b, 0)).r(true, this.f138367b.size());
    L14:
        HashMap r103 = new HashMap();
        r103.put("interact_function", "anchor_connect");
        r103.put("anchor_status", "suspend");
        u.l().sendLog("livesdk_anchor_suspend_reminder_show", r103, new Object[]{x.class, Room.class});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.util.Map, java.util.Map<java.lang.String, ? extends com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition>] */
    /* JADX WARN: Type inference failed for: r5v27, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v9, types: [java.util.HashMap] */
    public final void p(String r210) {
        StringBuilder r100 = new StringBuilder("adjustWindowList ");
        r100.append(r210);
        r100.append(" windowCnt:");
        r100.append(this.f138367b.size());
        r100.append(' ');
        ArrayList<MediaMultiAnchorWindowV2> r101 = this.f138367b;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<MediaMultiAnchorWindowV2> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r102.add("Window" + r103.next().getLinkMicId());
        goto L4
    L6:
        r100.append(r102);
        ALogger.w("ttlive_media_anchor_link_wm", r100.toString());
        this.f138385t.removeAllViews();
        MediaMultiAnchorTitleView r104 = this.f138375j;
        if (r104 == null) goto L10;
        this.f138385t.removeView(r104.getView());
        A(MediaMultiLinkAnchorWindowManager$reLayoutTitleView$1.INSTANCE);
        FrameLayout r105 = this.f138385t;
        View r106 = r104.getView();
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.gravity = 1;
        r107.topMargin = s();
        r105.addView(r106, r107);
    L10:
        MediaMultiAnchorTitleView r108 = this.f138375j;
        if (r108 == null) goto L16;
        View r109 = r108.getView();
        if (r109 == null) goto L16;
        r109.bringToFront();
    L16:
        if (this.f138367b.size() == 1) goto L18;
    L24:
        List<String> r110 = v();
        gy.c.f483309c2.getClass();
        gy.c r111 = gy.c.a.a();
        if (r111 == null) goto L27;
        gy.f r112 = r111.getRtcManager();
    L28:
        ArrayList r113 = (ArrayList) r110;
        Iterator r114 = r113.iterator();
    L30:
        if (r114.hasNext() == false) goto L42;
        String r115 = (String) r114.next();
        if (r112 == null) goto L30;
        s r116 = r112.L();
        if (r116 == null) goto L30;
        r r117 = r116.e(r115);
        if (r117 == null) goto L30;
        Pair<Integer, Integer> r118 = r117.f518620a.f91963i;
        if (r118 == null) goto L30;
        MediaMultiAnchorWindowV2 r119 = t(r115);
        if (r119 == null) goto L30;
        r119.setDebugText(r118.getFirst().intValue() + " x " + r118.getSecond().intValue());
        goto L30
    L42:
        x82.d.f562892z2.getClass();
        x82.d r120 = x82.d.a.a();
        if (r120 == null) goto L47;
        ?? r121 = r120.gc(r110);
        if (r121 == 0) goto L47;
    L91:
        Iterator<MediaMultiAnchorWindowV2> r122 = this.f138367b.iterator();
    L93:
        if (r122.hasNext() == false) goto L161;
        MediaMultiAnchorWindowV2 r123 = r122.next();
        WindowsPosition r124 = (WindowsPosition) r121.get(r123.getInteractId());
        f92.f r125 = r();
        if (r124 != null) goto L97;
    L149:
        MediaMultiAnchorWindowV2 r211 = r123;
    L150:
        String r126 = r211.getInteractId();
        if (r126 != null) goto L153;
        String r127 = "0";
    L154:
        WindowsPosition r128 = (WindowsPosition) r121.get(r127);
        if (r128 == null) goto L93;
        WindowLayoutType r129 = (WindowLayoutType) ArraysKt.getOrNull(WindowLayoutType.values(), r().c(r128).b());
        if (r129 != null) goto L159;
        r129 = WindowLayoutType.Normal;
    L159:
        r211.setWindowLayoutType(r129);
        goto L93
    L153:
        r127 = r126;
        goto L154
    L97:
        if (r124 == WindowsPosition.IGNORE) goto L149;
        f92.i r130 = r125.c(r124);
        Intrinsics.checkNotNullParameter(r124, "windowsPosition");
        double r131 = r125.b(r124).c();
        Intrinsics.checkNotNullParameter(r124, "windowsPosition");
        double r132 = r125.b(r124).b();
        WindowsPosition r133 = WindowsPosition.SINGLE;
        if (r124 != r133) goto L102;
        WindowsPosition r134 = WindowsPosition.TWO_LEFT;
        f92.i r135 = r125.c(r134);
        Intrinsics.checkNotNullParameter(r134, "windowsPosition");
        double r136 = r125.b(r134).c();
        Intrinsics.checkNotNullParameter(r134, "windowsPosition");
        double r137 = r125.b(r134).b();
        r130 = r135;
        r131 = r136;
    L103:
        FrameLayout.LayoutParams r138 = new FrameLayout.LayoutParams((int) (((double) this.f138369d) * r130.d()), (int) (((double) this.f138370e) * r130.a()));
        r138.topMargin = (int) (((double) this.f138370e) * r130.f());
        r138.leftMargin = (int) (((double) this.f138369d) * r130.e());
        this.f138385t.addView(r123, 0, r138);
        if (r124 == r133) goto L149;
        String r139 = r123.getInteractId();
        float r140 = (float) r130.e();
        float r141 = (float) (r130.e() + r130.d());
        float r142 = (float) r137;
        float r143 = ((float) (r130.f() - r131)) / r142;
        double r144 = r130.f() + r130.a();
        r211 = r123;
        f92.i r145 = r130;
        StringBuilder r146 = new StringBuilder("updateLayer ");
        r146.append(r139);
        r146.append("---  left: ");
        r146.append(r140);
        r146.append(", right: ");
        r146.append(r141);
        r146.append(", top:");
        r146.append(r143);
        r146.append(", bottom: ");
        r146.append(((float) (r144 - r131)) / r142);
        r146.append("---");
        gy.c.f483309c2.getClass();
        gy.c r147 = gy.c.a.a();
        if (r147 == null) goto L112;
        gy.f r148 = r147.getRtcManager();
        if (r148 == null) goto L112;
        if (r148.G() != true) goto L112;
        boolean r149 = true;
    L113:
        r146.append(r149);
        ALogger.d("ttlive_media_anchor_link_wm", r146.toString());
        gy.c r150 = gy.c.a.a();
        if (r150 == null) goto L120;
        gy.f r151 = r150.getRtcManager();
        if (r151 == null) goto L120;
        if (r151.G() == true) goto L120;
    L148:
        ALogger.e("ttlive_media_anchor_link_wm", "windowPosition: " + r124 + ", left: " + ((float) r145.e()) + ", right:" + ((float) (r145.e() + r145.d())) + ", top: " + (((float) (r145.f() - r131)) / r142) + ", bottom: " + (((float) ((r145.f() + r145.a()) - r131)) / r142));
    L120:
        if (r139 == null) goto L148;
        z.a r152 = this.f138368c.get(r139);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r153 = ILiveWrappedLivePusher.a.b();
        if (r153 == null) goto L126;
        m1.b r154 = null;
        m1.b r155 = r153.newVideoMixerDescription(null);
        if (r155 == null) goto L127;
        r155.e();
        r155.c();
        r155.b();
        r155.f();
        r155.i();
        r155.g();
        r155.h();
    L128:
        if (r152 == null) goto L148;
        m1.b r156 = r152.Y();
        if (r156 == null) goto L148;
        if (r155 == null) goto L148;
        if (r156.getLeft() == r155.getLeft()) goto L137;
    L146:
        r152.b();
        goto L148
    L137:
        if (r156.getTop() != r155.getTop()) goto L146;
        if (r156.getRight() != r155.getRight()) goto L146;
        if (r156.getBottom() != r155.getBottom()) goto L146;
        if (r156.isVisible() != r155.isVisible()) goto L146;
        if (r156.getMode() == r155.getMode()) goto L148;
    L127:
        r155 = r154;
        goto L128
    L126:
        r154 = null;
    L112:
        r149 = false;
        goto L113
    L102:
        r137 = r132;
        goto L103
    L161:
        MediaMultiAnchorWindowV2 r157 = this.f138373h;
        if (r157 == null) goto L167;
        String r158 = r157.getInteractId();
        if (r158 == null) goto L167;
        String r159 = r158;
    L168:
        WindowsPosition r160 = (WindowsPosition) r121.get(r159);
        if (r160 == null) goto L173;
        x82.e.A2.getClass();
        x82.e r161 = x82.e.a.a();
        if (r161 == null) goto L173;
        r161.of(r().c(r160).c());
    L173:
        this.f138384s = r121;
        HSImageView r162 = new HSImageView(this.f138385t.getContext());
        GenericDraweeHierarchy r163 = r162.getHierarchy();
        ScalingUtils.ScaleType r164 = ScalingUtils.ScaleType.FIT_XY;
        r163.setActualImageScaleType(r164);
        this.f138385t.addView(r162, new FrameLayout.LayoutParams(-1, s()));
        ImageLoader.bindImage(r162, "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_top_bg_denoise2.png");
        HSImageView r165 = new HSImageView(this.f138385t.getContext());
        r165.getHierarchy().setActualImageScaleType(r164);
        int r166 = (this.f138385t.getHeight() - s()) - ((int) (r().d(this.f138367b.size()) * ((double) this.f138370e)));
        if (r166 > 0) goto L176;
        r166 = (s1.w() - s()) - ((int) (r().d(this.f138367b.size()) * ((double) this.f138370e)));
    L176:
        FrameLayout.LayoutParams r167 = new FrameLayout.LayoutParams(-1, r166);
        r167.topMargin = s() + ((int) (r().d(this.f138367b.size()) * ((double) this.f138370e)));
        this.f138385t.addView(r165, r167);
        ImageLoader.bindImage(r165, "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_bottom_bg.png");
        Iterator<MediaMultiAnchorWindowV2> r168 = this.f138367b.iterator();
    L178:
        if (r168.hasNext() == false) goto L191;
        MediaMultiAnchorWindowV2 r169 = r168.next();
        if (Intrinsics.areEqual(r169, this.f138373h) == false) goto L188;
        if (this.f138367b.size() != 3) goto L188;
        if (this.f138381p != null) goto L189;
        r169.setCoverVisible(0);
        this.f138381p = Observable.timer(5, TimeUnit.SECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(new e(r169));
    L189:
        r169.q(this.f138367b.size());
        r169.setTotalWindowCount(this.f138367b.size());
    L188:
        r169.setCoverVisible(4);
        goto L189
    L191:
        if (this.f138367b.size() <= 0) goto L225;
        ViewGroup.LayoutParams r170 = ((MediaMultiAnchorWindowV2) ListProtector.get(this.f138367b, 0)).getLayoutParams();
        if (r170 == null) goto L224;
        FrameLayout.LayoutParams r171 = (FrameLayout.LayoutParams) r170;
        FrameLayout.LayoutParams r172 = new FrameLayout.LayoutParams(r171.width, r171.height);
        r172.topMargin = r171.topMargin;
        r172.leftMargin = r171.leftMargin;
        u1 r173 = new u1();
        r173.f571954i = this.f138367b.size();
        r173.f571951f = 1;
        r173.f571953h = r171.topMargin;
        r173.f571952g = s() + ((int) (r().d(this.f138367b.size()) * ((double) this.f138370e)));
        r173.f571956k = e92.m.a().ordinal();
        if (e92.m.a() != UILayout.Enlarge) goto L213;
        x82.d.f562892z2.getClass();
        x82.d r174 = x82.d.a.a();
        if (r174 == null) goto L199;
        String r175 = r174.zd();
    L200:
        MediaMultiAnchorWindowV2 r176 = t(r175);
        if (r176 == null) goto L203;
        ViewGroup.LayoutParams r177 = r176.getLayoutParams();
    L205:
        if ((r177 instanceof FrameLayout.LayoutParams) == true) goto L207;
        ViewGroup.LayoutParams r178 = null;
    L208:
        FrameLayout.LayoutParams r179 = (FrameLayout.LayoutParams) r178;
        if (r179 == null) goto L211;
        int r180 = RangesKt.coerceAtLeast(((this.f138369d - r179.width) - r179.leftMargin) - UtilityKotlinExtentionsKt.i(24), 0);
    L212:
        r173.f571957l = r180;
        goto L213
    L211:
        r180 = 0;
        goto L212
    L207:
        r178 = r177;
        goto L208
    L203:
        r177 = null;
        goto L205
    L199:
        r175 = null;
    L213:
        gy.c.f483309c2.getClass();
        gy.c r181 = gy.c.a.a();
        if (r181 == null) goto L220;
        gy.f r182 = r181.getRtcManager();
        if (r182 == null) goto L220;
        if (r182.G() == false) goto L220;
        r182.G();
        r172.height = (int) (r().d(this.f138367b.size()) * ((double) this.f138370e));
        r172.topMargin = s();
    L220:
        this.f138387v.put("cmd_multi_state_change", r173);
        x82.e.A2.getClass();
        x82.e r183 = x82.e.a.a();
        if (r183 == null) goto L225;
        r183.ah();
        goto L225
    L224:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L225:
        MediaMultiAnchorLinkContext r184 = this.f138390y;
        if (r184 == null) goto L232;
        m<Integer> r185 = r184.getWindowCount();
        if (r185 == null) goto L232;
        if (this.f138367b.size() == r185.getValue().intValue()) goto L232;
        r185.setValue(Integer.valueOf(this.f138367b.size()));
    L232:
        x82.b.f562888u2.getClass();
        x82.b r186 = x82.b.a.a();
        if (r186 == null) goto L277;
        r186.f();
        return;
    L277:
        return;
    L167:
        r159 = "0";
    L47:
        p r187 = this.f138380o;
        String r188 = u();
        r187.getClass();
        Intrinsics.checkNotNullParameter(r110, "linkIdList");
        if (TextUtils.isEmpty(r188) == true) goto L50;
    L52:
        r121 = new HashMap();
        if (r113.size() != 1) goto L56;
        r121.put(ListProtector.get(r110, 0), WindowsPosition.SINGLE);
        goto L91
    L56:
        if (r113.size() != 2) goto L65;
        Iterator r189 = r113.iterator();
    L59:
        if (r189.hasNext() == false) goto L91;
        String r190 = (String) r189.next();
        if (TextUtils.equals(r188, r190) == true) goto L62;
        r121.put(r190, WindowsPosition.TWO_RIGHT);
        goto L59
    L62:
        r121.put(r190, WindowsPosition.TWO_LEFT);
        goto L59
    L65:
        if (r113.size() != 3) goto L76;
        Iterator r191 = r113.iterator();
        boolean r192 = false;
    L68:
        if (r191.hasNext() == false) goto L91;
        String r193 = (String) r191.next();
        if (TextUtils.equals(r188, r193) == true) goto L71;
        if (r192 == false) goto L73;
        r121.put(r193, WindowsPosition.THREE_RIGHT_BOTTOM);
        goto L68
    L73:
        r121.put(r193, WindowsPosition.THREE_RIGHT_TOP);
        r192 = true;
        goto L68
    L71:
        r121.put(r193, WindowsPosition.THREE_LEFT);
        goto L68
    L76:
        if (r113.size() < 4) goto L91;
        Iterator r194 = r113.iterator();
        int r195 = 0;
    L79:
        if (r194.hasNext() == false) goto L91;
        String r196 = (String) r194.next();
        if (TextUtils.equals(r188, r196) == true) goto L82;
        if (r195 != 0) goto L85;
        r121.put(r196, WindowsPosition.FOUR_RIGHT_TOP);
    L90:
        r195 = r195 + 1;
        goto L79
    L85:
        if (r195 != 1) goto L87;
        r121.put(r196, WindowsPosition.FOUR_RIGHT_BOTTOM);
        goto L90
    L87:
        if (r195 != 2) goto L89;
        r121.put(r196, WindowsPosition.FOUR_LEFT_BOTTOM);
        goto L90
    L89:
        r121.put(r196, WindowsPosition.IGNORE);
        goto L90
    L82:
        r121.put(r196, WindowsPosition.FOUR_LEFT_TOP);
        goto L79
    L50:
        if (Lists.isEmpty(r110) == true) goto L52;
        r188 = (String) ListProtector.get(r110, 0);
        goto L52
    L27:
        r112 = null;
        goto L28
    L18:
        if (this.f138374i != null) goto L24;
        f92.f r197 = r();
        View r198 = LayoutInflater.from(this.f138385t.getContext()).inflate(R.layout.ttlive_view_media_waiting, this.f138385t, false);
        if (r198 == null) goto L23;
        ViewGroup r199 = (ViewGroup) r198;
        this.f138374i = r199;
        r1.b((SimpleDraweeView) r199.findViewById(R.id.anim), this.f138366a);
        f92.i r200 = r197.c(WindowsPosition.TWO_RIGHT);
        FrameLayout.LayoutParams r201 = new FrameLayout.LayoutParams((int) this.f138371f, (int) this.f138372g);
        r201.topMargin = (int) (((double) this.f138370e) * r200.f());
        r201.leftMargin = (int) (((double) this.f138369d) * r200.e());
        this.f138385t.addView(this.f138374i, 0, r201);
        goto L24
    L23:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final MediaMultiAnchorWindowV2 t(String r100) {
        Iterator<MediaMultiAnchorWindowV2> r101 = this.f138367b.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        MediaMultiAnchorWindowV2 r102 = r101.next();
        if (q0.a("0") == false) goto L11;
        if (Intrinsics.areEqual(r102.getUid(), "0") == false) goto L11;
        return r102;
    L11:
        if (TextUtils.equals(r102.getInteractId(), r100) == false) goto L4;
        return r102;
    L13:
        return null;
    }

    public final void w(String r100) {
        int r101 = ((ArrayList) v()).size();
        if (r101 == this.f138382q) goto L22;
        this.f138382q = r101;
        MediaMultiEnlargeWidget r102 = this.f138389x;
        if (r102 == null) goto L22;
        AnchorUpdateLayoutContent.AnchorLayoutRange r103 = AnchorUpdateLayoutContent.AnchorLayoutRange.AnchorLayoutRangeMyRoom;
        AnchorUpdateLayoutContent.UpdateAnchorLayoutType r104 = AnchorUpdateLayoutContent.UpdateAnchorLayoutType.UpdateAnchorLayoutTypeUnknown;
        if (r101 < 4) goto L19;
        x82.e.a r105 = x82.e.A2;
        r105.getClass();
        x82.e r106 = x82.e.a.a();
        if (r106 == null) goto L12;
        UILayout r107 = r106.getDefaultUILayout();
    L14:
        if (r107 != UILayout.Enlarge) goto L16;
        r102.xq(true, ey.c.b(), true, "default enlarge", false);
        goto L22
    L16:
        r102.f138345d = false;
        r102.f138344c = "";
        r102.f138346e = false;
        r105.getClass();
        x82.e r108 = x82.e.a.a();
        if (r108 == null) goto L22;
        r108.kg(UILayout.Normal, "default UILayout is normal", false);
        goto L22
    L12:
        r107 = null;
        goto L14
    L19:
        r102.f138345d = false;
        r102.f138344c = "";
        r102.f138346e = false;
        x82.e.A2.getClass();
        x82.e r109 = x82.e.a.a();
        if (r109 == null) goto L22;
        r109.kg(UILayout.Normal, "windowCount < 4", false);
    L22:
        p(r100);
    }

    public final void z(String r100) {
        MediaMultiAnchorWindowV2 r101 = t(r100);
        ArrayList<MediaMultiAnchorWindowV2> r102 = this.f138367b;
        if (r102 == null) goto L23;
        boolean r103 = TypeIntrinsics.asMutableCollection(r102).remove(r101);
        StringBuilder r104 = new StringBuilder("remove window removed:");
        r104.append(r103);
        r104.append(' ');
        r104.append(r100);
        r104.append(' ');
        if (r101 == null) goto L7;
        String r105 = r101.g();
    L8:
        r104.append(r105);
        ALogger.i("ttlive_media_anchor_link_wm", r104.toString());
        z.a r106 = this.f138368c.get(r100);
        if (r106 == null) goto L20;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r107 = ILiveWrappedLivePusher.a.b();
        if (r107 == null) goto L15;
        m1.b r108 = r107.newVideoMixerDescription(null);
        if (r108 == null) goto L15;
        r108.i();
    L15:
        r106.b();
        HashMap<String, z.a> r109 = this.f138368c;
        if (r109 == null) goto L19;
        z.a r110 = (z.a) TypeIntrinsics.asMutableMap(r109).remove(r100);
        goto L20
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L20:
        w("rtcUserLeave");
        return;
    L7:
        r105 = null;
        goto L8
    L23:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // hy.f.a, hy.f.b
    public final void d(int r110, List<AnchorLinkUser> r111) {
        if (r111 == null) goto L56;
        int r112 = r111.size();
        int r100 = 0;
    L4:
        if (r100 >= r112) goto L73;
        AnchorLinkUser r101 = (AnchorLinkUser) ListProtector.get(r111, r100);
        AnchorLinkMicIdInfo r102 = r101.getAnchorLinkMicIdInfo();
        if (r102 == null) goto L34;
        ArrayList<MediaMultiAnchorWindowV2> r103 = this.f138367b;
        ArrayList r104 = new ArrayList();
        Iterator<MediaMultiAnchorWindowV2> r105 = r103.iterator();
    L8:
        boolean r106 = true;
        if (r105.hasNext() == false) goto L19;
        MediaMultiAnchorWindowV2 r107 = r105.next();
        MediaMultiAnchorWindowV2 r113 = r107;
        if (Intrinsics.areEqual(r102.mainLinkMicId, r113.getInteractId()) == false) goto L13;
    L16:
        if (r106 == false) goto L8;
        r104.add(r107);
        goto L8
    L13:
        if (Intrinsics.areEqual(r102.backupLinkMicId, r113.getInteractId()) == true) goto L16;
        r106 = false;
        goto L16
    L19:
        if (r104.size() <= 1) goto L34;
        Iterator r108 = r104.iterator();
    L22:
        if (r108.hasNext() == false) goto L34;
        MediaMultiAnchorWindowV2 r109 = (MediaMultiAnchorWindowV2) r108.next();
        if ((!Intrinsics.areEqual(r109.getInteractId(), r102.getInUseLinkMicId())) == false) goto L22;
        ALogger.e("ttlive_media_anchor_link_wm", "remove duplicate window " + r109.g() + " when onlineListChanged, " + r102);
        this.f138367b.remove(r109);
        z.a r114 = this.f138368c.get(r109.getInteractId());
        if (r114 == null) goto L33;
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r115 = ILiveWrappedLivePusher.a.b();
        if (r115 == null) goto L32;
        m1.b r116 = r115.newVideoMixerDescription(null);
        if (r116 == null) goto L32;
        r116.i();
    L32:
        r114.b();
    L33:
        w("removeDuplicateWindow_" + r109.getInteractId());
    L34:
        Iterator<MediaMultiAnchorWindowV2> r117 = this.f138367b.iterator();
    L36:
        if (r117.hasNext() == false) goto L55;
        MediaMultiAnchorWindowV2 r118 = r117.next();
        if (TextUtils.equals(r101.getInteractId(), r118.getInteractId()) == true) goto L46;
        AnchorLinkMicIdInfo r119 = r101.getAnchorLinkMicIdInfo();
        if (r119 == null) goto L42;
        String r120 = r119.backupLinkMicId;
    L44:
        if (TextUtils.equals(r120, r118.getInteractId()) == false) goto L36;
    L42:
        r120 = null;
    L46:
        if (r118.getAnchorLinkUser() == null) goto L48;
    L54:
        AnchorLinkUser r121 = (AnchorLinkUser) ListProtector.get(r111, r100);
        this.f138367b.size();
        r118.s(r121);
        goto L55
    L48:
        if (r101.getAnchorLinkMicIdInfo() == null) goto L54;
        AnchorLinkMicIdInfo r122 = r101.getAnchorLinkMicIdInfo();
        if (r122 == null) goto L54;
        ALogger.e("ttlive_media_anchor_link_wm", "ensureStreamStateWhenFirstSetLinkUser " + r118.g() + ' ' + r101.toSimpleString() + ' ' + r122);
        x82.b.f562888u2.getClass();
        x82.b r123 = x82.b.a.a();
        if (r123 == null) goto L54;
        r123.D6();
    L55:
        r100 = r100 + 1;
        goto L4
    L73:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.medialink.ui.window.a
    public final void g(UILayout r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uiLayout");
        Intrinsics.checkNotNullParameter(r101, "source");
        p(r101);
    }

    public final MediaMultiAnchorWindowV2 q(Context r100, String r110, AnchorLinkUser r111) {
        if (r111 == null) goto L12;
        Intrinsics.checkNotNullParameter(r111, "$this$backupLinkMicIdEquals");
        AnchorLinkMicIdInfo r101 = r111.getAnchorLinkMicIdInfo();
        if (r101 != null) goto L6;
    L9:
        boolean r102 = false;
    L10:
        if (r102 != true) goto L12;
        String r103 = r111.getInteractId();
        ALogger.e("ttlive_media_anchor_link_wm", "backup window must use mainLinkMicId " + r110 + " -> " + r103);
        String r104 = r103;
    L14:
        return new MediaMultiAnchorWindowV2(r100, this.f138387v, r104, (AnchorLinkUser) jm2.a.d(r111), this);
    L6:
        if (Intrinsics.areEqual(r101.backupLinkMicId, r110) == false) goto L9;
        if (r110 == null) goto L9;
        r102 = true;
    L12:
        r104 = r110;
        goto L14
    }

    public final void x(String r100, View r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "reqSrc");
        AnchorLinkUser r103 = null;
        if (r101 == null) goto L5;
        String r104 = r101.getClass().getSimpleName();
    L6:
        hy.e r105 = this.f138388w;
        if (r105 == null) goto L9;
        r103 = r105.f(r100, true);
    L9:
        MediaMultiAnchorWindowV2 r106 = q(this.f138385t.getContext(), r100, r103);
        hy.e r107 = this.f138388w;
        if (r107 == null) goto L14;
        List<AnchorLinkUser> r108 = r107.getOnlineUserList();
        if (r108 == null) goto L14;
        r108.size();
    L14:
        r106.s(r103);
        if (r101 != null) goto L17;
        this.f138373h = r106;
    L17:
        MediaMultiAnchorWindowV2 r109 = t(r100);
        if (r109 == null) goto L20;
        ALogger.e("ttlive_media_anchor_link_wm", "onUserJoin" + r104 + ' ' + r102 + ", remove " + r100 + ' ' + r106.g());
        this.f138367b.remove(r109);
    L20:
        if (r101 == null) goto L28;
        r106.removeView(r106.f138231a);
        ViewParent r110 = r101.getParent();
        if (r110 != null) goto L25;
    L27:
        r101.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Unit r111 = Unit.INSTANCE;
        r106.f138231a = r101;
        r106.addView(r101, 0);
        goto L28
    L25:
        if ((r110 instanceof ViewGroup) == false) goto L27;
        ((ViewGroup) r110).removeView(r101);
    L28:
        this.f138367b.add(r106);
        w(LynxVideoManagerLite.EVENT_ON_FIRST_FRAME);
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void y(String r100, z.a r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "reqSrc");
        if (r100 == null) goto L5;
        this.f138368c.put(r100, r101);
    L5:
        hy.e r103 = this.f138388w;
        if (r103 == null) goto L8;
        AnchorLinkUser r104 = r103.f(r100, true);
    L9:
        MediaMultiAnchorWindowV2 r105 = q(this.f138385t.getContext(), r100, r104);
        hy.e r106 = this.f138388w;
        if (r106 == null) goto L14;
        List<AnchorLinkUser> r107 = r106.getOnlineUserList();
        if (r107 == null) goto L14;
        r107.size();
    L14:
        r105.s(r104);
        String r108 = MediaMultiAnchorLinkContext.Companion.b();
        if (r108 != null) goto L18;
        r108 = u();
    L18:
        if (TextUtils.equals(r108, r100) == false) goto L20;
        this.f138373h = r105;
    L20:
        MediaMultiAnchorWindowV2 r109 = t(r100);
        if (r109 == null) goto L23;
        ALogger.e("ttlive_media_anchor_link_wm", "onUserJoinLayer " + r102 + ", remove " + r100 + ' ' + r105.g());
        this.f138367b.remove(r109);
    L23:
        this.f138367b.add(r105);
        w("onFirstLayer_".concat(r102));
        return;
    L8:
        r104 = null;
        goto L9
    }

    public MediaMultiLinkAnchorWindowManager(FrameLayout r100, RoomContext r101, DataCenter r102, hy.e r103, gy.f r104, MediaMultiEnlargeWidget r105, MediaMultiAnchorLinkContext r106, LifecycleOwner r107) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        Intrinsics.checkNotNullParameter(r107, "lifecycleOwner");
        this.f138385t = r100;
        this.f138386u = r101;
        this.f138387v = r102;
        this.f138388w = r103;
        this.f138389x = r105;
        this.f138390y = r106;
        this.f138366a = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/dy_pk_rematch_loading.webp";
        this.f138367b = new ArrayList();
        this.f138368c = new HashMap();
        int r108 = Math.min(UIUtils.getScreenWidth(s1.getContext()), UIUtils.getScreenHeight(s1.getContext()));
        this.f138369d = r108;
        int r109 = (r108 * 16) / 9;
        this.f138370e = r109;
        this.f138371f = ((double) r108) * 0.49583333333333335d;
        int r110 = f92.c.f475949i;
        this.f138372g = ((double) r109) * 0.40286458333333336d;
        this.f138376k = new CompositeDisposable();
        this.f138378m = r107;
        this.f138379n = new HashMap();
        this.f138380o = new p();
        new f92.g();
        this.f138383r = new com.bytedance.android.livesdk.interactivity.medialink.contract.h(true);
    }
}
