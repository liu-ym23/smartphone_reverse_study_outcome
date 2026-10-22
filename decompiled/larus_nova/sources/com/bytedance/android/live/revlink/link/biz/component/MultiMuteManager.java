package com.bytedance.android.live.revlink.link.biz.component;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revlink.link.domain.service.RevLinkDomainAnchorService;
import com.bytedance.android.live.revlink.link.utils.UtilsKt;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class MultiMuteManager implements com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.impl.multianchor.ui.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f97895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<com.bytedance.android.live.revlink.impl.multianchor.ui.q> f97896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<String> f97897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f97898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CompositeDisposable f97899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f97900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d21.b f97901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a f97902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RevLinkDomainAnchorService f97903i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final com.bytedance.android.live.revenuelink.rtc.i f97904j;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.link.biz.component.MultiMuteManager$attach$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Ls51/c;", "p1", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<List<? extends s51.c>, Unit> {
        public AnonymousClass2(MultiMuteManager r100) {
            super(1, r100, MultiMuteManager.class, "refreshMuteStateSubscribe", "refreshMuteStateSubscribe(Ljava/util/List;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<s51.c> r100) {
            final MultiMuteManager r101 = (MultiMuteManager) this.receiver;
            r101.f97900f.clear();
            if (r100 == null) goto L8;
            Iterator<T> r102 = r100.iterator();
        L6:
            if (r102.hasNext() == false) goto L10;
            final s51.c r103 = (s51.c) r102.next();
            jy0.b.a(com.bytedance.android.live.revlink.link.biz.service.e.a.a(r101), "add mic muteState subscribe for uid: " + r103.f540701d);
            com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.e(r103.f540706i.f98470b, false, new MultiMuteManager$refreshMuteStateSubscribe$$inlined$forEach$lambda$1(r103, r101)), r101.f97900f);
            goto L6
        L10:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends s51.c> r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getTAG() {
        return "RevenueLinkAnchorComponent";
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void a() {
        Iterator r100 = ((ArrayList) this.f97896b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.live.revlink.impl.multianchor.ui.q) r100.next()).a();
        goto L4
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void attach() {
        List<s51.b> r100 = this.f97903i.f98500d.getValue();
        if (r100 == null) goto L10;
        Iterator<T> r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        s51.b r102 = (s51.b) r101.next();
        if (com.bytedance.android.live.revlink.link.domain.mic.component.m.a(r102) == false) goto L6;
        this.f97897c.add(r102.c());
    L10:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.i(this.f97903i.f98501e, new AnonymousClass2(this)), this.f97899e);
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final void detach() {
        this.f97899e.clear();
        this.f97900f.clear();
        ((ArrayList) this.f97896b).clear();
        this.f97897c.clear();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean h() {
        List<s51.c> r100 = this.f97903i.f98501e.getValue();
        List<s51.c> r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return false;
    L11:
        List<s51.c> r103 = r100;
        if ((r103 instanceof Collection) == true) goto L14;
    L16:
        Iterator<T> r104 = r103.iterator();
    L18:
        if (r104.hasNext() == false) goto L32;
        s51.c r105 = (s51.c) r104.next();
        String r106 = r105.f();
        boolean r107 = !Intrinsics.areEqual(r105.f540701d, this.f97903i.f98514r.getRoomContext().getCommonUser().getIdString());
        if (r107 == false) goto L22;
        boolean r108 = this.f97903i.c(r106);
    L24:
        if (com.bytedance.android.live.revlink.link.domain.mic.component.m.a(r105) == true) goto L29;
        if (r108 == true) goto L29;
        if (r107 == false) goto L29;
        boolean r109 = false;
    L30:
        if (r109 == true) goto L18;
        return false;
    L29:
        r109 = true;
        goto L30
    L22:
        r108 = false;
    L32:
        return true;
    L14:
        if (r103.isEmpty() == false) goto L16;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public /* bridge */ /* synthetic */ com.bytedance.android.live.revlink.link.infra.lifecontrol.context.d getContext() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.k
    public final com.bytedance.android.live.revlink.impl.global.c getLinkInstanceService() {
        return getContext();
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.e
    public final String getComponentName() {
        return this.f97895a;
    }

    @Override // com.bytedance.android.live.revlink.link.biz.service.c, com.bytedance.android.live.revlink.link.biz.service.e, com.bytedance.android.live.revlink.link.biz.service.j
    public com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a getContext() {
        return this.f97902h;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void b(String r100) {
        HashSet<String> r101 = this.f97897c;
        if (r101 == null) goto L7;
        TypeIntrinsics.asMutableCollection(r101).remove(r100);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final Disposable d(final com.bytedance.android.live.revlink.impl.multianchor.ui.q r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        g(r100);
        int r101 = com.bytedance.revenue.platform.api.core.rx.h.f267513a;
        return com.bytedance.revenue.platform.api.core.rx.h.a(new MultiMuteManager$subscribeMuteStateChange$1(this, r100));
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "linkMicId");
        return this.f97897c.contains(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void g(com.bytedance.android.live.revlink.impl.multianchor.ui.q r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) this.f97896b).contains(r100) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.f97896b).add(r100);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void k(com.bytedance.android.live.revlink.impl.multianchor.ui.q r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) this.f97896b).remove(r100);
    }

    public final void m(boolean r110) {
        if (h() != r110) goto L5;
        return;
    L5:
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        List<s51.c> r100 = this.f97903i.f98501e.getValue();
        if (r100 == null) goto L66;
        Iterator<T> r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L66;
        s51.c r102 = (s51.c) r101.next();
        String r103 = r102.f();
        String r104 = r102.f540701d;
        boolean r105 = !Intrinsics.areEqual(r104, this.f97903i.f98514r.getRoomContext().getCommonUser().getIdString());
        if (r105 == false) goto L13;
        boolean r106 = this.f97903i.c(r103);
    L14:
        if (r106 == true) goto L9;
        if (r105 == false) goto L9;
        if (r110 == false) goto L18;
        this.f97897c.add(r103);
    L19:
        String r107 = "";
        if (this.f97898d == false) goto L52;
        com.bytedance.android.livesdk.link.model.p r108 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(r104, r103);
        if (r108 == null) goto L52;
        com.bytedance.android.livesdk.link.model.bridge.j r109 = com.bytedance.android.livesdk.link.model.q.b(r108);
        if (r109 == null) goto L52;
        if (Intrinsics.areEqual(r103, r109.getMainLinkMicId()) == false) goto L35;
        com.bytedance.android.live.revenuelink.rtc.i r111 = this.f97904j;
        String r112 = r109.getBackupLinkMicId();
        if (r112 != null) goto L30;
        r112 = "";
    L30:
        r111.h(r112, r110, "syncMainToBack");
        String r113 = r109.getBackupLinkMicId();
        if (r113 != null) goto L33;
        r113 = "";
    L33:
        Intrinsics.checkNotNullParameter(r113, "linkMicId");
        r102.f540706i.g(r113, r110);
    L35:
        if (Intrinsics.areEqual(r103, r109.getBackupLinkMicId()) == false) goto L43;
        com.bytedance.android.live.revenuelink.rtc.i r114 = this.f97904j;
        String r115 = r109.getMainLinkMicId();
        if (r115 != null) goto L39;
        r115 = "";
    L39:
        r114.h(r115, r110, "syncBackToMain");
        String r116 = r109.getMainLinkMicId();
        if (r116 != null) goto L42;
        r116 = "";
    L42:
        Intrinsics.checkNotNullParameter(r116, "linkMicId");
        r102.f540706i.g(r116, r110);
    L43:
        if (r110 == false) goto L51;
        HashSet<String> r117 = this.f97897c;
        String r118 = r109.getMainLinkMicId();
        if (r118 != null) goto L47;
        r118 = "";
    L47:
        r117.add(r118);
        HashSet<String> r119 = this.f97897c;
        String r120 = r109.getBackupLinkMicId();
        if (r120 != null) goto L50;
        r120 = "";
    L50:
        r119.add(r120);
        goto L52
    L51:
        this.f97897c.remove(r109.getMainLinkMicId());
        this.f97897c.remove(r109.getBackupLinkMicId());
    L52:
        com.bytedance.android.live.revlink.link.domain.mic.component.l r121 = r102.f540706i;
        if (Intrinsics.areEqual(r121.f98470b.getValue(), Boolean.valueOf(r110)) == true) goto L9;
        com.bytedance.android.live.revenuelink.rtc.i r122 = r121.f98475g;
        if (r122 == null) goto L61;
        String r123 = r121.f98473e;
        if (r123 != null) goto L60;
        r123 = "";
    L60:
        r122.h(r123, r110, "MuteComponent_allmute");
    L61:
        String r124 = r121.f98473e;
        if (r124 == null) goto L65;
        r107 = r124;
    L65:
        r121.g(r107, r110);
        r121.f98470b.setValue(Boolean.valueOf(r110));
        goto L9
    L18:
        this.f97897c.remove(r103);
        goto L19
    L13:
        r106 = false;
    L66:
        if (r110 == false) goto L72;
        r31.a r125 = getContext().getLinkNetwork();
        long r126 = getContext().getRoomID();
        long r127 = com.bytedance.android.live.revlink.link.biz.service.i.A(this).a();
        int r128 = t11.a.f544143a;
        if (r110 == false) goto L70;
        int r129 = 1;
    L71:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r125.M(r126, 7, r127, r129, true, "")).subscribe(i.f98056a, j.f98057a), this.f97899e);
        goto L72
    L70:
        r129 = 2;
    L72:
        if (r110 == false) goto L74;
        int r130 = ToastUtil.f90810a;
        com.bytedance.live.kmp.util.c r131 = com.bytedance.live.kmp.util.c.f255167a;
        int r132 = w11.a.f557889a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(R.string.ttlive_multi_link_mic_mute_all_toast, new Object[0]), 0);
        return;
    L74:
        int r133 = ToastUtil.f90810a;
        com.bytedance.live.kmp.util.c r134 = com.bytedance.live.kmp.util.c.f255167a;
        int r135 = w11.a.f557889a;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(R.string.ttlive_multi_link_mic_unmute_all_toast, new Object[0]), 0);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void c(boolean r100, boolean r101) {
        Iterator r102 = ((ArrayList) this.f97896b).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.live.revlink.impl.multianchor.ui.q) r102.next()).b(r100, r101);
        goto L4
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final boolean j(String r100, String r101) {
        s51.c r102 = this.f97903i.d(r100, r101);
        String r103 = "";
        if (r102 == null) goto L6;
        String r104 = r102.f();
        if (r104 == null) goto L6;
    L7:
        if (r102 == null) goto L13;
        String r105 = r102.f540701d;
        if (r105 == null) goto L13;
        r103 = r105;
    L13:
        if ((!Intrinsics.areEqual(r103, this.f97903i.f98514r.getRoomContext().getCommonUser().getIdString())) == false) goto L15;
        boolean r106 = this.f97903i.c(r104);
    L16:
        if (r102 != null) goto L18;
    L19:
        if (r106 == true) goto L24;
        return false;
    L24:
        return true;
    L18:
        if (com.bytedance.android.live.revlink.link.domain.mic.component.m.a(r102) != true) goto L19;
        return true;
    L15:
        r106 = false;
    L6:
        r104 = "";
        goto L7
    }

    public MultiMuteManager(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.a r100, RevLinkDomainAnchorService r101, com.bytedance.android.live.revenuelink.rtc.i r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "domainService");
        Intrinsics.checkNotNullParameter(r102, "rtcManager");
        this.f97902h = r100;
        this.f97903i = r101;
        this.f97904j = r102;
        this.f97895a = "MultiMuteManager";
        this.f97896b = new ArrayList();
        this.f97897c = new HashSet();
        this.f97898d = !y41.a.f565924c.a();
        this.f97899e = new CompositeDisposable();
        this.f97900f = new CompositeDisposable();
        this.f97901g = new d21.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void i(final boolean r100, final com.bytedance.android.live.revlink.impl.multianchor.ui.r.c r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "source");
        if (r100 == true) goto L5;
    L8:
        m(r100);
        return;
    L5:
        if (((Boolean) l51.a.T.getValue(null, l51.a.f507436a[48])).booleanValue() == false) goto L8;
        if (r102 == true) goto L8;
        getContext().ko().i(new MultiMuteManager$setAllMuteState$1(this, r100, r101));
    }

    public final void n(String r210, String r211, boolean r212) {
        s51.c r100 = this.f97903i.d(r210, r211);
        String r101 = "";
        if (r100 == null) goto L6;
        String r102 = r100.f();
        if (r102 == null) goto L6;
    L7:
        if (r100 == null) goto L10;
        String r103 = r100.f540701d;
        if (r103 == null) goto L10;
    L11:
        if (r212 == false) goto L13;
        this.f97897c.add(r102);
    L14:
        com.bytedance.android.live.revlink.link.biz.service.i.d0(this).getClass();
        if (this.f97898d == false) goto L52;
        com.bytedance.android.livesdk.link.model.p r104 = com.bytedance.android.live.revlink.link.biz.service.i.t(this).getGuestInfo(r103, r102);
        if (r104 == null) goto L52;
        com.bytedance.android.livesdk.link.model.bridge.j r105 = com.bytedance.android.livesdk.link.model.q.b(r104);
        if (r105 == null) goto L52;
        if (Intrinsics.areEqual(r102, r105.getMainLinkMicId()) == false) goto L32;
        com.bytedance.android.live.revenuelink.rtc.i r106 = this.f97904j;
        String r107 = r105.getBackupLinkMicId();
        if (r107 != null) goto L25;
        r107 = "";
    L25:
        r106.h(r107, r212, "syncMainToBack");
        if (r100 == null) goto L32;
        String r108 = r105.getBackupLinkMicId();
        if (r108 != null) goto L30;
        r108 = "";
    L30:
        Intrinsics.checkNotNullParameter(r108, "linkMicId");
        r100.f540706i.g(r108, r212);
    L32:
        if (Intrinsics.areEqual(r102, r105.getBackupLinkMicId()) == false) goto L42;
        com.bytedance.android.live.revenuelink.rtc.i r109 = this.f97904j;
        String r110 = r105.getMainLinkMicId();
        if (r110 != null) goto L36;
        r110 = "";
    L36:
        r109.h(r110, r212, "syncBackToMain");
        if (r100 == null) goto L42;
        String r111 = r105.getMainLinkMicId();
        if (r111 != null) goto L41;
        r111 = "";
    L41:
        Intrinsics.checkNotNullParameter(r111, "linkMicId");
        r100.f540706i.g(r111, r212);
    L42:
        if (r212 == false) goto L50;
        HashSet<String> r112 = this.f97897c;
        String r113 = r105.getMainLinkMicId();
        if (r113 != null) goto L46;
        r113 = "";
    L46:
        r112.add(r113);
        HashSet<String> r114 = this.f97897c;
        String r115 = r105.getBackupLinkMicId();
        if (r115 != null) goto L49;
        r115 = "";
    L49:
        r114.add(r115);
        goto L52
    L50:
        this.f97897c.remove(r105.getMainLinkMicId());
        this.f97897c.remove(r105.getBackupLinkMicId());
    L52:
        if (r100 == null) goto L80;
        com.bytedance.android.live.revlink.link.domain.mic.component.l r116 = r100.f540706i;
        if (Intrinsics.areEqual(r116.f98470b.getValue(), Boolean.valueOf(r212)) == true) goto L80;
        com.bytedance.android.live.revenuelink.rtc.i r117 = r116.f98475g;
        if (r117 == null) goto L62;
        String r118 = r116.f98473e;
        if (r118 != null) goto L61;
        r118 = "";
    L61:
        r117.h(r118, r212, "MuteComponent_mute");
    L62:
        String r119 = r116.f98473e;
        if (r119 != null) goto L65;
        r119 = "";
    L65:
        r116.g(r119, r212);
        r116.f98470b.setValue(Boolean.valueOf(r212));
        y41.e r120 = y41.e.f565958o;
        r120.getClass();
        if (((Boolean) y41.e.f565956m.getValue(r120, y41.e.f565944a[11])).booleanValue() == false) goto L78;
        com.bytedance.android.livesdk.link.model.p r121 = r116.f98474f.getGuestInfo(r116.f98472d, null);
        if (r121 == null) goto L72;
        IBaseUser r122 = r121.getUser();
        if (r122 == null) goto L72;
        long r123 = com.bytedance.android.live.base.model.user.n.a(r122);
    L73:
        long r124 = r123;
        r31.a r125 = r116.f98471c.getLinkNetwork();
        long r126 = r116.f98471c.getRoomID();
        int r127 = r116.f98471c.getScene();
        String r128 = r116.f98472d;
        long r129 = r116.f98471c.G();
        int r130 = t11.a.f544143a;
        if (r212 == false) goto L76;
        int r131 = 1;
    L77:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r125.p(r126, r127, r128, r129, r124, r131)).subscribe(com.bytedance.android.live.revlink.link.domain.mic.component.h.f98465a, com.bytedance.android.live.revlink.link.domain.mic.component.i.f98466a), r116.f98469a);
        goto L80
    L76:
        r131 = 2;
    L72:
        r123 = 0;
        goto L73
    L78:
        if (r212 == false) goto L80;
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r116.f98471c.getLinkNetwork().mute(r116.f98471c.getRoomID(), r116.f98471c.getScene(), r116.f98472d, r116.f98471c.G())).subscribe(com.bytedance.android.live.revlink.link.domain.mic.component.j.f98467a, com.bytedance.android.live.revlink.link.domain.mic.component.k.f98468a), r116.f98469a);
    L80:
        if (r212 == false) goto L93;
        int r132 = ToastUtil.f90810a;
        com.bytedance.live.kmp.util.c r133 = com.bytedance.live.kmp.util.c.f255167a;
        int r134 = w11.a.f557889a;
        Object[] r135 = new Object[1];
        if (r100 == null) goto L91;
        com.bytedance.android.livesdk.link.model.p r136 = r100.f540703f.getGuestInfo(r100.f540701d, null);
        if (r136 == null) goto L91;
        IBaseUser r137 = r136.getUser();
        if (r137 == null) goto L91;
        String r138 = r137.getNickName();
        if (r138 == null) goto L91;
        r101 = r138;
    L91:
        r135[0] = r101;
        ToastUtil.b(com.bytedance.live.kmp.util.c.a(R.string.ttlive_interact_anchor_link_has_muted_xxx_anchor, r135), 0);
        return;
    L93:
        return;
    L13:
        this.f97897c.remove(r102);
    L10:
        r103 = "";
    L6:
        r102 = "";
        goto L7
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void f(final String r100, final String r110, final boolean r111, final com.bytedance.android.live.revlink.impl.multianchor.ui.r r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r112, "source");
        if (r111 == true) goto L5;
    L20:
        n(r100, r110, r111);
        return;
    L5:
        if (l51.a.h() == false) goto L20;
        if (r113 == true) goto L20;
        s51.c r114 = this.f97903i.d(r100, r110);
        d21.b r101 = this.f97901g;
        if (r114 == null) goto L15;
        com.bytedance.android.livesdk.link.model.p r115 = r114.f540703f.getGuestInfo(r114.f540701d, null);
        if (r115 == null) goto L15;
        IBaseUser r116 = r115.getUser();
        if (r116 == null) goto L15;
        String r117 = r116.getNickName();
        if (r117 == null) goto L15;
    L16:
        r101.getClass();
        String r118 = d21.b.a(r117);
        if (r118 != null) goto L19;
        com.bytedance.live.kmp.util.c r119 = com.bytedance.live.kmp.util.c.f255167a;
        int r120 = w11.a.f557889a;
        r118 = com.bytedance.live.kmp.util.c.a(R.string.ttlive_interact_link_mute_confirm_dialog_top_tip_default_guest, new Object[0]);
    L19:
        final String r102 = r118;
        getContext().ko().i(new MultiMuteManager$setMuteState$1(this, r100, r110, r111, r112, r102));
        return;
    L15:
        r117 = "";
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.live.revlink.impl.multianchor.ui.i
    public final void l(String r110, boolean r111, boolean r210, boolean r211, boolean r212) {
        s51.c r100 = this.f97903i.d(r110, null);
        if (r100 == null) goto L6;
        String r101 = r100.f();
        if (r101 == null) goto L6;
    L7:
        String r102 = r101;
        int r103 = 0;
        if (r210 == false) goto L22;
        com.bytedance.android.live.revenuelink.rtc.i r104 = this.f97904j;
        if (r111 == false) goto L12;
        boolean r105 = false;
    L13:
        r104.h(r102, r105, "syncChorusState");
        if (r111 == true) goto L22;
        this.f97904j.b0(r102, 100, "multiChorusAutoUnMute");
        if (r211 == false) goto L22;
        r31.a r112 = getContext().getLinkNetwork();
        long r113 = getContext().getRoomID();
        if (r100 == null) goto L20;
        String r114 = r100.f540701d;
    L21:
        com.bytedance.revenue.platform.api.core.rx.f.a(UtilsKt.a(r112.mute(r113, 7, r114, com.bytedance.android.live.revlink.link.biz.service.i.A(this).a())).subscribe(k.f98058a, l.f98059a), this.f97899e);
        goto L22
    L20:
        r114 = null;
        goto L21
    L12:
        r105 = r211;
    L22:
        if (r212 == false) goto L28;
        com.bytedance.android.live.revenuelink.rtc.i r106 = this.f97904j;
        if (r111 == true) goto L27;
        r103 = 100;
    L27:
        r106.b0(r102, r103, "multiChorus");
    L28:
        if (r111 == false) goto L32;
        if (r210 == true) goto L32;
        if (r212 == false) goto L32;
        com.bytedance.tools.kcp.spongepreference.runtime.a r107 = l51.a.R;
        KProperty<?>[] r108 = l51.a.f507436a;
        r107.setValue(null, r108[46], Integer.valueOf(((Number) r107.getValue(null, r108[46])).intValue() + 1));
    L32:
        Iterator r115 = ((ArrayList) this.f97896b).iterator();
    L34:
        if (r115.hasNext() == false) goto L40;
        com.bytedance.android.live.revlink.impl.multianchor.ui.q r109 = (com.bytedance.android.live.revlink.impl.multianchor.ui.q) r115.next();
        if (r100 == null) goto L38;
        String r116 = r100.f540701d;
    L39:
        r109.c(r116, r102, r111, r210, r212);
        goto L34
    L38:
        r116 = null;
        goto L39
    L40:
        return;
    L6:
        r101 = "";
        goto L7
    }
}
