package com.bytedance.android.livesdk.ktvimpl.feed;

import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.livesdk.ktvimpl.base.sei.h;
import com.bytedance.android.livesdk.ktvimpl.base.sei.i;
import com.bytedance.android.livesdk.ktvimpl.base.sei.k;
import com.bytedance.android.livesdk.ktvimpl.base.sei.l;
import com.bytedance.android.livesdk.ktvimpl.base.sei.m;
import com.bytedance.android.livesdk.ktvimpl.base.sei.w;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvComponentFeedViewModel implements com.bytedance.android.livesdk.ktvimpl.base.sei.b, com.bytedance.android.livesdk.ktvimpl.base.sei.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.ktvimpl.base.sei.a f143827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> f143828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f143829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final NextLiveData<StateMachine.c.b<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b>> f143830d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NextLiveData<ld0.a> f143831e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m f143832f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f143833g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f143834h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f143835i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public IRoom f143836j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f143837k;

    public interface a {
        void i3(com.bytedance.android.livesdk.ktvimpl.base.sei.g r100);

        void k3(k r100);

        void s1();
    }

    public KtvComponentFeedViewModel(a r100) {
        this.f143837k = r100;
        KtvRoomLyricsStateMachineConfig r101 = KtvRoomLyricsStateMachineConfig.f145381a;
        Function1<StateMachine.c<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b>, Unit> r102 = new KtvComponentFeedViewModel$stateMachine$1(this);
        r101.getClass();
        StateMachine<KtvRoomLyricsStateMachineConfig.d, KtvRoomLyricsStateMachineConfig.a, KtvRoomLyricsStateMachineConfig.b> r103 = KtvRoomLyricsStateMachineConfig.a(r102, null);
        this.f143828b = r103;
        this.f143829c = new b(r103);
        this.f143830d = new NextLiveData();
        this.f143831e = new NextLiveData();
        r103.d(KtvRoomLyricsStateMachineConfig.a.g.f145393c, null);
        l r104 = new l();
        r104.a("ktv_sei", k.class);
        r104.a("ktv_score_sei", com.bytedance.android.livesdk.ktvimpl.base.sei.g.class);
        r104.a("ktv_midi_sei", i.class);
        r104.a("ktv_midi_feedback_sei", h.class);
        Unit r105 = Unit.INSTANCE;
        m r106 = new m(r104);
        this.f143832f = r106;
        r106.c(this, 5.0f);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final boolean accept(w r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r100, "result");
        return true;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.sei.c
    public final void onSeiResult(w r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        com.bytedance.android.livesdk.ktvimpl.base.sei.a r101 = r100.f143344b;
        if ((r101 instanceof k) == false) goto L61;
        IRoom r102 = this.f143836j;
        if (r102 == null) goto L7;
        r102.getOwnerUserIdString();
    L7:
        ((k) r100.f143344b).getClass();
        Integer r103 = Integer.valueOf(((k) r100.f143344b).z());
        Integer r104 = Integer.valueOf(((k) r100.f143344b).u());
        int r105 = 0;
        if (r103 != null) goto L11;
        int r106 = 0;
    L19:
        int r107 = ((k) r100.f143344b).z();
        Integer r108 = this.f143833g;
        if (r108 != null) goto L23;
    L24:
        this.f143833g = Integer.valueOf(((k) r100.f143344b).z());
    L26:
        if (((k) r100.f143344b).z() == 3) goto L29;
        r105 = ((k) r100.f143344b).u();
    L29:
        Integer r109 = this.f143834h;
        if (r109 != null) goto L33;
    L34:
        this.f143834h = Integer.valueOf(r105);
    L35:
        Integer r110 = this.f143835i;
        if (r110 != null) goto L39;
    L40:
        a r111 = this.f143837k;
        if (r111 == null) goto L43;
        r111.s1();
    L43:
        this.f143835i = Integer.valueOf(r106);
    L44:
        a r112 = this.f143837k;
        if (r112 == null) goto L48;
        r112.k3((k) r100.f143344b);
    L48:
        if (((k) r100.f143344b).F() == false) goto L53;
        if (((k) r100.f143344b).d() == 1) goto L53;
        this.f143829c.g((k) r100.f143344b, new JSONObject(r100.f143343a));
    L53:
        if (((k) r100.f143344b).d() != 1) goto L58;
        this.f143829c.f((k) r100.f143344b);
        if (((k) r100.f143344b).C() != 0) goto L58;
        this.f143831e.setValue(new ld0.a());
    L58:
        if (Lists.isEmpty(((k) r100.f143344b).l()) == true) goto L69;
        this.f143827a = r100.f143344b;
        return;
    L69:
        return;
    L39:
        if (r110.intValue() == r106) goto L44;
    L33:
        if (r105 == r109.intValue()) goto L35;
    L23:
        if (r107 == r108.intValue()) goto L26;
    L11:
        if (r103.intValue() != 3) goto L13;
        r106 = 3;
        goto L19
    L13:
        if (r104 != null) goto L16;
    L18:
        r106 = 1;
        goto L19
    L16:
        if (r104.intValue() != 1) goto L18;
        r106 = 2;
        goto L19
    L61:
        if ((r101 instanceof com.bytedance.android.livesdk.ktvimpl.base.sei.g) == false) goto L71;
        IRoom r113 = this.f143836j;
        if (r113 == null) goto L65;
        r113.getOwnerUserIdString();
    L65:
        ((com.bytedance.android.livesdk.ktvimpl.base.sei.g) r100.f143344b).getClass();
        a r114 = this.f143837k;
        if (r114 == null) goto L72;
        r114.i3((com.bytedance.android.livesdk.ktvimpl.base.sei.g) r100.f143344b);
        return;
    L72:
        return;
    }
}
