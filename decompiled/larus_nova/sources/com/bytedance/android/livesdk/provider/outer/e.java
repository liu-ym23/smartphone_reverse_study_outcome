package com.bytedance.android.livesdk.provider.outer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.m2;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.utils.l3;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.livestate.ILiveStateChecker;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class e extends FrameLayout implements md0.a.InterfaceC6802a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f156719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f156720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LivePlayerView f156721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f156722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.livesdk.preview.audio.b f156723e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.preview.video.a f156724f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f156725g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.api.utils.j f156726h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Room f156727i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f156728j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f156729k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f156730l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f156731m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f156732n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f156733o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f156734p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f156735q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f156736r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f156737s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List<? extends SeiRegion> f156738t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f156739u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f156740v;

    public static final class a implements ILiveStateChecker.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f156741a;

        @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateChecker.Callback
        public final void onError() {
            this.f156741a.f156736r++;
        }

        public a(e r100) {
            this.f156741a = r100;
        }

        @Override // com.bytedance.android.livesdkapi.livestate.ILiveStateChecker.Callback
        public final void onSuccess(boolean r100) {
            e r101 = this.f156741a;
            if (r100 == r101.f156728j) goto L5;
            r101.f156728j = r100;
            r101.b(true);
        L5:
            this.f156741a.getLiveStatusListener();
            if (r100 == true) goto L15;
            LivePlayerView r102 = this.f156741a.f156721c;
            if (r102 == null) goto L12;
            ILivePlayerClient r103 = r102.getClient();
            if (r103 == null) goto L12;
            r103.stopAndRelease(this.f156741a.getContext());
        L12:
            LivePlayerView r104 = this.f156741a.f156721c;
            if (r104 == null) goto L15;
            r104.setVisibility(8);
        L15:
            this.f156741a.f156736r = 0;
        }
    }

    public e(Context r100) {
        this(r100, false, 14);
    }

    public final ty.c getLiveStatusListener() {
        return null;
    }

    @Override // md0.a.InterfaceC6802a
    public final /* synthetic */ void onBusinessAppSeiUpdate(JSONObject r100) {
    }

    public final void setLiveStatusListener(ty.c r100) {
    }

    public final void c() {
        if (this.f156727i != null) goto L5;
        return;
    L5:
        ILiveService r100 = TTLiveService.getLiveService();
        if (r100 == null) goto L11;
        ILiveStateChecker r101 = r100.getLiveStateChecker();
        if (r101 == null) goto L12;
        Room r102 = this.f156727i;
        Intrinsics.checkNotNull(r102);
        r101.checkAlive(r102.f162599id, new a(this));
        return;
    L12:
        return;
    }

    public final void a(int r100) {
        LivePlayerView r101 = this.f156721c;
        if (r101 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r101);
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
        if (r102 == null) goto L31;
        ViewGroup.MarginLayoutParams r103 = (ViewGroup.MarginLayoutParams) r102;
        if (r100 != 0) goto L10;
        this.f156725g = false;
        r103.topMargin = 0;
    L26:
        if (this.f156740v == true) goto L28;
        r103.topMargin = 0;
    L28:
        LivePlayerView r104 = this.f156721c;
        Intrinsics.checkNotNull(r104);
        r104.setLayoutParams(r103);
        return;
    L10:
        if (r100 != 1) goto L12;
        this.f156725g = true;
        if (this.f156733o >= this.f156732n) goto L22;
        int r105 = (int) UtilityKotlinExtentionsKt.h(124.0f);
    L23:
        r103.topMargin = r105;
        goto L26
    L22:
        r105 = 0;
        goto L23
    L12:
        if (r100 != 2) goto L26;
        this.f156725g = true;
        if (this.f156733o >= this.f156732n) goto L17;
        int r106 = (int) UtilityKotlinExtentionsKt.h(124.0f);
    L18:
        r103.topMargin = r106;
        goto L26
    L17:
        r106 = 0;
        goto L18
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }

    public final void b(boolean r100) {
        Room r101 = this.f156727i;
        if (r101 != null) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.preview.audio.b r102 = this.f156723e;
        if (r102 == null) goto L8;
        Intrinsics.checkNotNull(r101);
        r102.c(r101, this.f156728j);
    L8:
        com.bytedance.android.livesdk.preview.video.a r103 = this.f156724f;
        if (r103 == null) goto L12;
        Room r104 = this.f156727i;
        Intrinsics.checkNotNull(r104);
        Intrinsics.checkNotNullParameter(r104, "room");
        r103.f156633g = r104;
        r103.c();
    L12:
        if (this.f156722d != null) goto L15;
    L34:
        a(0);
        if (r100 == true) goto L38;
        c();
        return;
    L38:
        return;
    L15:
        if (this.f156727i == null) goto L34;
        if (this.f156740v == false) goto L34;
        com.bytedance.android.livesdk.preview.video.a r105 = this.f156724f;
        if (r105 == null) goto L25;
        Intrinsics.checkNotNull(r105);
        if (r105.f156634h == true) goto L34;
    L25:
        if (this.f156735q == true) goto L34;
        this.f156735q = true;
        Room r106 = this.f156727i;
        Intrinsics.checkNotNull(r106);
        py.k r107 = r106.getBackground();
        if (r107 == null) goto L30;
        ImageLoader.bindImage(this.f156722d, new ImageModel(r107.getUri(), r107.getUrls()), new l3(5, 0.0f, null));
        goto L34
    L30:
        float r108 = LiveResUtil.getScreenWidth() / LiveResUtil.getScreenHeight();
        Room r109 = this.f156727i;
        Intrinsics.checkNotNull(r109);
        if (r109.getCover() == null) goto L33;
        HSImageView r110 = this.f156722d;
        Room r111 = this.f156727i;
        Intrinsics.checkNotNull(r111);
        ImageLoader.bindImage(r110, r111.getCover(), new l3(2, r108, null));
        goto L34
    L33:
        ImageLoader.bindImage(this.f156722d, "res://" + getContext().getPackageName() + "/2131251156", new l3(5, r108, null));
        goto L34
    }

    @Override // md0.a.InterfaceC6802a
    public final void onSeiUpdated(SeiAppData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        boolean r101 = false;
        if (m2.a(Integer.valueOf(r100.getVersion()), new Object[]{3, 5}) == false) goto L51;
        List<SeiRegion> r102 = r100.getGrids();
        if (r102 != null) goto L9;
    L12:
        boolean r103 = true;
    L13:
        if (r103 == true) goto L50;
        List<SeiRegion> r104 = r100.getGrids();
        Intrinsics.checkNotNull(r104);
        List<? extends SeiRegion> r105 = this.f156738t;
        if (r105 == null) goto L31;
        List r106 = CollectionsKt.zip(r105, r104);
        if (r106 == null) goto L31;
        List r107 = r106;
        if ((r107 instanceof Collection) == true) goto L21;
    L23:
        Iterator r108 = r107.iterator();
    L25:
        if (r108.hasNext() == false) goto L29;
        Pair r109 = (Pair) r108.next();
        if (Intrinsics.areEqual(((SeiRegion) r109.getFirst()).uidStr, ((SeiRegion) r109.getSecond()).uidStr) == true) goto L25;
        boolean r110 = false;
    L30:
        if (r110 != true) goto L31;
    L37:
        this.f156738t = r104;
        int r111 = r104.size();
        ArrayList r112 = new ArrayList();
        boolean[] r113 = new boolean[r111];
        int r114 = 0;
    L38:
        if (r114 >= r111) goto L40;
        SeiRegion r115 = (SeiRegion) ListProtector.get(r104, r114);
        r112.add(r115.getInteractId().toString());
        r113[r114] = r115.isTalking();
        r114 = r114 + 1;
        goto L38
    L40:
        Object[] r116 = r112.toArray(new String[0]);
        if (r116 == null) goto L49;
        String[] r117 = (String[]) r116;
        com.bytedance.android.livesdk.preview.video.a r118 = this.f156724f;
        if (r118 == null) goto L45;
        r118.e(r117, r113);
    L45:
        com.bytedance.android.livesdk.preview.audio.b r119 = this.f156723e;
        if (r119 == null) goto L96;
        r119.g(r117, r113);
        return;
    L96:
        return;
    L49:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L29:
        r110 = true;
        goto L30
    L21:
        if (r107.isEmpty() == false) goto L23;
    L31:
        com.bytedance.android.livesdk.preview.audio.b r120 = this.f156723e;
        if (r120 == null) goto L34;
        r120.f();
    L34:
        com.bytedance.android.livesdk.preview.video.a r121 = this.f156724f;
        if (r121 == null) goto L37;
        r121.d();
        goto L37
    L50:
        return;
    L9:
        if (r102.isEmpty() == true) goto L12;
        r103 = false;
        goto L13
    L51:
        this.f156739u = 0;
        List<SeiRegion> r122 = r100.getGrids();
        if (r122 != null) goto L54;
        return;
    L54:
        Room r123 = this.f156727i;
        if (r123 == null) goto L98;
        String r124 = r123.getOwnerUserIdString();
        if (r124 == null) goto L99;
        Iterator<SeiRegion> r125 = r122.iterator();
    L61:
        if (r125.hasNext() == false) goto L68;
        SeiRegion r126 = r125.next();
        if (r126 == null) goto L61;
        if ((!Intrinsics.areEqual(r126.getAccount(), r124)) == false) goto L61;
        this.f156739u++;
        goto L61
    L68:
        if (r122.size() <= 0) goto L70;
        r101 = true;
    L70:
        LivePlayerView r127 = this.f156721c;
        if (r127 == null) goto L83;
        Intrinsics.checkNotNull(r127);
        ViewGroup.LayoutParams r128 = r127.getRenderView().getLayoutParams();
        if ((r128 instanceof FrameLayout.LayoutParams) == true) goto L76;
        r128 = null;
    L76:
        FrameLayout.LayoutParams r129 = (FrameLayout.LayoutParams) r128;
        if (r129 == null) goto L83;
        if (r101 == false) goto L81;
        int r130 = 85;
    L82:
        r129.gravity = r130;
        LivePlayerView r131 = this.f156721c;
        Intrinsics.checkNotNull(r131);
        r131.getRenderView().setLayoutParams(r129);
        goto L83
    L81:
        r130 = 17;
    L83:
        a(this.f156739u);
        return;
    L99:
        return;
    }

    public final void setMute(boolean r100) {
        this.f156734p = r100;
        if (r100 == false) goto L9;
        LivePlayerView r101 = this.f156721c;
        if (r101 == null) goto L15;
        ILivePlayerClient r102 = r101.getClient();
        if (r102 == null) goto L16;
        r102.mute();
        return;
    L16:
        return;
    L15:
        return;
    L9:
        LivePlayerView r103 = this.f156721c;
        if (r103 == null) goto L18;
        ILivePlayerClient r104 = r103.getClient();
        if (r104 == null) goto L19;
        r104.unmute();
        return;
    L19:
        return;
    }

    public final void setShouldDestroy(boolean r100) {
        LivePlayerView r101 = this.f156721c;
        if (r101 == null) goto L8;
        ILivePlayerClient r102 = r101.getClient();
        if (r102 == null) goto L9;
        r102.setShouldDestroy(r100);
        return;
    L9:
        return;
    }

    @Override // md0.a.InterfaceC6802a
    public final boolean isVersionSupported(int r100, int r101) {
        com.bytedance.android.livesdk.preview.video.a r102 = this.f156724f;
        if (r102 == null) goto L5;
        r102.b(r100);
    L5:
        com.bytedance.android.livesdk.preview.audio.b r103 = this.f156723e;
        if (r103 == null) goto L9;
        r103.d(r100);
    L9:
        return m2.a(Integer.valueOf(r100), new Object[]{1, 3, 5});
    }

    public e(Context r100, boolean r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = true;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, null, 0);
        this.f156740v = r101;
        this.f156728j = true;
        this.f156731m = 5000;
        this.f156734p = true;
        this.f156737s = 5;
        LayoutInflater.from(r100).inflate(R.layout.ttlive_preview_live_cover_base, this);
        ViewGroup r103 = (ViewGroup) getRootView().findViewById(R.id.view_rootview);
        this.f156719a = r103;
        this.f156720b = (ViewGroup) getRootView().findViewById(R.id.player_view_container);
        if (r101 == false) goto L9;
        this.f156722d = (HSImageView) getRootView().findViewById(R.id.riv_cover);
        this.f156723e = new com.bytedance.android.livesdk.preview.audio.b(r103);
        this.f156724f = new com.bytedance.android.livesdk.preview.video.a(r100, r103);
        return;
    }
}
