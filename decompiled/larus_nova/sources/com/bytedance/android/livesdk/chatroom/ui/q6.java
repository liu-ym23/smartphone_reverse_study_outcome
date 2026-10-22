package com.bytedance.android.livesdk.chatroom.ui;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.MultiSceneEnterRoomStatisticsUtils;
import com.bytedance.android.livesdk.config.i10;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.feed.IInteractFeedView;
import com.bytedance.android.livesdkapi.model.InnerDrawPreloadDisableConfig;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class q6 implements md0.a.InterfaceC6802a, gs0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f113911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IInteractFeedView f113912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Room f113913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f113914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f113915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Pair<Integer, ? extends JSONObject> f113916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.liveinteract.api.utils.j f113917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public r6 f113918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<? extends SeiRegion> f113919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ViewGroup f113920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ii1.a f113921k;

    public static final class a {
    }

    static {
    }

    @Override // md0.a.InterfaceC6802a
    public final boolean isVersionSupported(int r100, int r101) {
        return true;
    }

    @Override // md0.a.InterfaceC6802a
    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r100) {
    }

    public final void a() {
        ALogger.d(this.f113911a, "[layoutLoad] clearInteractFeedView");
        IInteractFeedView r100 = this.f113912b;
        if (r100 == null) goto L11;
        if (r100 == null) goto L6;
        r100.reset();
    L6:
        ViewGroup r101 = this.f113920j;
        if (r101 == null) goto L9;
        r101.removeAllViews();
    L9:
        this.f113912b = null;
        return;
    }

    @Override // md0.a.InterfaceC6802a
    public final void onSeiUpdated(SeiAppData r110) {
        if (r110 != null) goto L4;
        return;
    L4:
        int r100 = r110.getUiLayout();
        int r101 = r110.getVersion();
        int r102 = r110.getSubScene();
        boolean r103 = false;
        if (this.f113914d != r101) goto L9;
        if (this.f113915e != r102) goto L9;
    L64:
        List<SeiRegion> r104 = r110.getGrids();
        if (r104 != null) goto L67;
    L91:
        IInteractFeedView r105 = this.f113912b;
        if (r105 == null) goto L106;
        r105.onSeiUpdated(r110);
        return;
    L106:
        return;
    L67:
        if ((!r104.isEmpty()) != true) goto L91;
        List<SeiRegion> r106 = r110.getGrids();
        List<? extends SeiRegion> r107 = this.f113919i;
        if (r107 != null) goto L71;
    L87:
        ALogger.d(this.f113911a, "[layoutLoad] onOnlineListChanged");
        IInteractFeedView r108 = this.f113912b;
        if (r108 == null) goto L90;
        r108.onOnlineListChanged();
    L90:
        this.f113919i = r106;
        goto L91
    L71:
        if (r107.size() != r106.size()) goto L87;
        List<? extends SeiRegion> r109 = this.f113919i;
        if (r109 != null) goto L75;
        r109 = CollectionsKt.emptyList();
    L75:
        List<? extends SeiRegion> r111 = r109;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r113 = r111.iterator();
    L77:
        if (r113.hasNext() == false) goto L79;
        r112.add(((SeiRegion) r113.next()).uidStr);
        goto L77
    L79:
        Set r114 = CollectionsKt.toMutableSet(r112);
        int r115 = r114.size();
        List<SeiRegion> r116 = r106;
        ArrayList r117 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator<T> r118 = r116.iterator();
    L81:
        if (r118.hasNext() == false) goto L83;
        r117.add(((SeiRegion) r118.next()).uidStr);
        goto L81
    L83:
        r114.addAll(r117);
        if (r114.size() == r115) goto L86;
        r103 = true;
    L86:
        if (r103 == false) goto L90;
    L9:
        if (this.f113920j == null) goto L64;
        a();
        List<? extends InnerDrawPreloadDisableConfig> r119 = i10.f120419a.getValue();
        if (r119 == null) goto L25;
        Iterator<T> r120 = r119.iterator();
    L15:
        if (r120.hasNext() == false) goto L25;
        InnerDrawPreloadDisableConfig r121 = (InnerDrawPreloadDisableConfig) r120.next();
        if (r121.getSeiVer() == (-1)) goto L15;
        if (r110.getVersion() != r121.getSeiVer()) goto L15;
        if (r121.getSubScene() == (-1)) goto L24;
        if (r110.getSubScene() != r121.getSubScene()) goto L15;
    L24:
        boolean r122 = true;
    L27:
        if (r122 == false) goto L29;
        this.f113912b = null;
    L30:
        Object r123 = this.f113912b;
        if ((r123 instanceof View) == true) goto L33;
        r123 = null;
    L33:
        View r124 = (View) r123;
        if (r124 == null) goto L63;
        this.f113920j.removeAllViews();
        this.f113920j.setVisibility(0);
        this.f113920j.addView(r124);
        Object r125 = this.f113912b;
        if ((r125 instanceof View) == true) goto L38;
        r125 = null;
    L38:
        View r126 = (View) r125;
        if (r126 == null) goto L43;
        ViewTreeObserver r127 = r126.getViewTreeObserver();
        if (r127 == null) goto L43;
        r127.removeOnDrawListener(this.f113918h);
    L43:
        this.f113918h = new r6(this);
        Object r128 = this.f113912b;
        if ((r128 instanceof View) == true) goto L46;
        r128 = null;
    L46:
        View r129 = (View) r128;
        if (r129 == null) goto L51;
        ViewTreeObserver r130 = r129.getViewTreeObserver();
        if (r130 == null) goto L51;
        r130.addOnDrawListener(this.f113918h);
    L51:
        ALogger.d(this.f113911a, "[layoutLoad] update room " + this.f113913c);
        Room r131 = this.f113913c;
        if (r131 == null) goto L56;
        IInteractFeedView r132 = this.f113912b;
        if (r132 == null) goto L56;
        r132.updateRoom(r131);
    L56:
        IInteractFeedView r133 = this.f113912b;
        if (r133 == null) goto L59;
        r133.refreshSeiCanvasAndSeiVersion(this.f113916f.getSecond(), this.f113916f.getFirst());
    L59:
        IInteractFeedView r134 = this.f113912b;
        if (r134 == null) goto L62;
        r134.setLivePlayerView(null);
    L62:
        this.f113920j.requestLayout();
    L63:
        this.f113914d = r101;
        this.f113915e = r102;
        goto L64
    L29:
        this.f113912b = ((IInteractService) jc1.k.n(IInteractService.class)).getInteractFeedView(this.f113920j.getContext(), r110, r100, 3);
    L25:
        r122 = false;
        goto L27
    }

    public q6(ViewGroup r100, MultiSceneEnterRoomStatisticsUtils r101, ii1.a r102) {
        Intrinsics.checkNotNullParameter(r101, "enterRoomStatistic");
        this.f113920j = r100;
        this.f113921k = r102;
        this.f113911a = "InteractPreloadManager";
        new HashMap();
        this.f113916f = new Pair(0, new JSONObject());
        this.f113917g = new com.bytedance.android.live.liveinteract.api.utils.j(this);
    }
}
