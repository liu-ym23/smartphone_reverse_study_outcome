package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.linksecurity.rts.RTSDataContext;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
public final class v extends com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ch0.h> f76526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ch0.g f76527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ch0.d f76528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f76529e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f76530f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CompositeDisposable f76531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f76532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f76533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public eg6.b f76534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f76535k;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f76536a;

        public a(v r100) {
            this.f76536a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            sh6.b r101 = (sh6.b) r100;
            ph0.b r102 = (ph0.b) sh6.c.b(r101);
            String r103 = null;
            if (r102 == null) goto L5;
            String r104 = r102.f529232b;
        L6:
            boolean r105 = true;
            if (r104 != null) goto L9;
        L12:
            boolean r106 = true;
        L13:
            if (r106 == true) goto L25;
            ph0.b r107 = (ph0.b) sh6.c.b(r101);
            if (r107 != null) goto L17;
        L19:
            r105 = false;
        L20:
            d r108 = this.f76536a.f76533i;
            ph0.b r109 = (ph0.b) sh6.c.b(r101);
            if (r109 == null) goto L23;
            r103 = r109.f529232b;
        L23:
            Intrinsics.checkNotNull(r103);
            r108.c(r103, r105);
            return;
        L17:
            if (r107.f529233c != 2) goto L19;
        L25:
            return;
        L9:
            if (StringsKt.isBlank(r104) == true) goto L12;
            r106 = false;
            goto L13
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class b {
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f76537a;

        public c(v r100) {
            this.f76537a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ch0.d r101 = (ch0.d) r100;
            this.f76537a.a().l1().getClass();
        }
    }

    public static final class d extends eg6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ v f76538a;

        @Override // eg6.a, eg6.c
        public final void o() {
            gh0.a.a("RtcListener", "call onLocalUserLeaved", true);
            ch0.d r100 = v.f(this.f76538a);
            boolean r101 = false;
            if (r100 == null) goto L5;
            v r102 = this.f76538a;
            r102.getClass();
            r102.f76527c = new ch0.g("", 0, 0, 0, 0);
            ch0.g r103 = this.f76538a.f76527c;
            Intrinsics.checkNotNull(r103);
            r100 = ch0.d.a(r100, 0, 0, r103, 7);
            r101 = true;
        L5:
            v.d(this.f76538a, r101, r100);
            v r104 = this.f76538a;
            if ((true ^ ((CopyOnWriteArrayList) r104.f76526b).isEmpty()) == false) goto L9;
            gh0.a.b("RtcListener", "clear", 4);
            ((CopyOnWriteArrayList) r104.f76526b).clear();
            r104.c();
            return;
        }

        public d(v r100) {
            this.f76538a = r100;
        }

        @Override // eg6.a, eg6.c
        public final void b(String r110) {
            Intrinsics.checkNotNullParameter(r110, "interactId");
            gh0.a.b("RtcListener", "call onFirstRemoteVideoFrame, interactId: " + r110, 4);
            Iterator r100 = ((CopyOnWriteArrayList) this.f76538a.f76526b).iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            Object r101 = r100.next();
            if (Intrinsics.areEqual(((ch0.h) r101).f23733a, r110) == false) goto L4;
        L9:
            ch0.h r102 = (ch0.h) r101;
            if (r102 != null) goto L12;
        L15:
            boolean r111 = false;
        L16:
            v.e(this.f76538a, r111);
            return;
        L12:
            if (r102.f23735c == false) goto L15;
            ch0.h r112 = ch0.h.a(r102, null, false, false, false, 0, 123);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).remove(r102);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).add(r112);
            r111 = true;
            goto L16
        L8:
            r101 = null;
            goto L9
        }

        @Override // eg6.a, eg6.c
        public final void d(int r100) {
            boolean r101 = true;
            gh0.a.a("RtcListener", "call onLocalUserVideoCaptureStateChanged, status: " + r100, true);
            ch0.d r102 = v.f(this.f76538a);
            boolean r103 = false;
            if (r102 == null) goto L12;
            ch0.g r104 = this.f76538a.f76527c;
            if (r104 != null) goto L7;
        L10:
            r101 = false;
        L11:
            r103 = r101;
            goto L12
        L7:
            if (r104.f23729b == r100) goto L10;
            r104.f23729b = r100;
            Intrinsics.checkNotNull(r104);
            r102 = ch0.d.a(r102, 0, 0, r104, 7);
        L12:
            v.d(this.f76538a, r103, r102);
            r(r103, r102);
        }

        @Override // eg6.a, eg6.c
        public final void i(String r110) {
            boolean r100 = true;
            gh0.a.a("RtcListener", "call onLocalUserJoined", true);
            ch0.d r101 = v.f(this.f76538a);
            boolean r102 = false;
            if (r101 == null) goto L10;
            if (r110 != null) goto L6;
        L8:
            r100 = false;
        L9:
            r102 = r100;
            goto L10
        L6:
            if (TextUtils.equals(r110, v.f(this.f76538a).f23723d.f23728a) == true) goto L8;
            ch0.g r103 = new ch0.g(r110, 0, 0, 1, 1);
            this.f76538a.f76527c = r103;
            Intrinsics.checkNotNull(r103);
            r101 = ch0.d.a(r101, 0, 0, r103, 7);
        L10:
            v.d(this.f76538a, r102, r101);
            if (r110 == null) goto L14;
            p(r110);
            b(r110);
            return;
        }

        @Override // eg6.a, eg6.c
        public final void j(int r100) {
            boolean r101 = true;
            gh0.a.a("RtcListener", "call onLocalUserVideoPublishStateChanged videoPublishStatus = " + r100, true);
            ch0.d r102 = v.f(this.f76538a);
            boolean r103 = false;
            if (r102 == null) goto L12;
            ch0.g r104 = this.f76538a.f76527c;
            if (r104 != null) goto L7;
        L10:
            r101 = false;
        L11:
            r103 = r101;
            goto L12
        L7:
            if (r104.f23731d == r100) goto L10;
            r104.f23731d = r100;
            Intrinsics.checkNotNull(r104);
            r102 = ch0.d.a(r102, 0, 0, r104, 7);
        L12:
            v.d(this.f76538a, r103, r102);
            r(r103, r102);
        }

        @Override // eg6.a, eg6.c
        public final void l(String r100) {
            Intrinsics.checkNotNullParameter(r100, "interactId");
            gh0.a.b("RtcListener", "call onRemoteUserLeaved, interactId: ".concat(r100), 4);
            Iterator r101 = ((CopyOnWriteArrayList) this.f76538a.f76526b).iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            Object r102 = r101.next();
            if (Intrinsics.areEqual(((ch0.h) r102).f23733a, r100) == false) goto L4;
        L9:
            ch0.h r103 = (ch0.h) r102;
            if (r103 == null) goto L12;
            ((CopyOnWriteArrayList) this.f76538a.f76526b).remove(r103);
            boolean r104 = true;
        L13:
            v.e(this.f76538a, r104);
            return;
        L12:
            r104 = false;
            goto L13
        L8:
            r102 = null;
            goto L9
        }

        @Override // eg6.a, eg6.c
        public final void m(int r100) {
            boolean r101 = true;
            gh0.a.a("RtcListener", "call onLocalUserAudioCaptureStateChanged, status: " + r100, true);
            ch0.d r102 = v.f(this.f76538a);
            boolean r103 = false;
            if (r102 == null) goto L12;
            ch0.g r104 = this.f76538a.f76527c;
            if (r104 != null) goto L7;
        L10:
            r101 = false;
        L11:
            r103 = r101;
            goto L12
        L7:
            if (r104.f23730c == r100) goto L10;
            r104.f23730c = r100;
            Intrinsics.checkNotNull(r104);
            r102 = ch0.d.a(r102, 0, 0, r104, 7);
        L12:
            v.d(this.f76538a, r103, r102);
            a(r103, r102);
        }

        @Override // eg6.a, eg6.c
        public final void n(int r100) {
            boolean r101 = true;
            gh0.a.a("RtcListener", "call onLocalUserAudioPublishStateChanged", true);
            ch0.d r102 = v.f(this.f76538a);
            boolean r103 = false;
            if (r102 == null) goto L12;
            ch0.g r104 = this.f76538a.f76527c;
            if (r104 != null) goto L7;
        L10:
            r101 = false;
        L11:
            r103 = r101;
            goto L12
        L7:
            if (r104.f23732e == r100) goto L10;
            r104.f23732e = r100;
            Intrinsics.checkNotNull(r104);
            r102 = ch0.d.a(r102, 0, 0, r104, 7);
        L12:
            v.d(this.f76538a, r103, r102);
            a(r103, r102);
        }

        @Override // eg6.a, eg6.c
        public final void p(String r100) {
            Intrinsics.checkNotNullParameter(r100, "interactId");
            gh0.a.b("RtcListener", "call onRemoteUserJoined, interactId: " + r100, 4);
            Iterator r101 = ((CopyOnWriteArrayList) this.f76538a.f76526b).iterator();
        L4:
            if (r101.hasNext() == false) goto L8;
            Object r102 = r101.next();
            if (Intrinsics.areEqual(((ch0.h) r102).f23733a, r100) == false) goto L4;
        L10:
            if (((ch0.h) r102) != null) goto L12;
            ((CopyOnWriteArrayList) this.f76538a.f76526b).add(new ch0.h(r100, true, true, this.f76538a.f76529e, 32));
            boolean r103 = true;
        L13:
            v.e(this.f76538a, r103);
            return;
        L12:
            r103 = false;
            goto L13
        L8:
            r102 = null;
            goto L10
        }

        @Override // eg6.a, eg6.c
        public final void q(int r100) {
            v r101 = this.f76538a;
            if (r101.f76529e != r100) goto L5;
            return;
        L5:
            r101.f76529e = r100;
            Iterator r102 = ((CopyOnWriteArrayList) r101.f76526b).iterator();
        L7:
            if (r102.hasNext() == false) goto L9;
            ch0.h r103 = (ch0.h) r102.next();
            ch0.h r104 = ch0.h.a(r103, null, false, false, false, this.f76538a.f76529e, 63);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).remove(r103);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).add(r104);
            goto L7
        L9:
            v.e(this.f76538a, true);
        }

        public final void a(boolean r100, ch0.d r101) {
            if (r100 == false) goto L19;
            ch0.g r102 = r101.f23723d;
            int r103 = r102.f23730c;
            boolean r104 = false;
            if (r103 == 2) goto L8;
            if (r103 == 1) goto L8;
            boolean r105 = false;
        L10:
            if (r102.f23732e != 1) goto L12;
            boolean r106 = true;
        L13:
            String r107 = r102.f23728a;
            if (r105 == false) goto L16;
            if (r106 == false) goto L16;
        L17:
            k(r107, r104);
            return;
        L16:
            r104 = true;
            goto L17
        L12:
            r106 = false;
        L8:
            r105 = true;
            goto L10
        }

        @Override // eg6.a, eg6.c
        public final void c(String r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r110, "interactId");
            gh0.a.b("RtcListener", "call onRemoteVideoMute, interactId: " + r110 + ", isMuteVideo: " + r111, 4);
            Iterator r100 = ((CopyOnWriteArrayList) this.f76538a.f76526b).iterator();
        L3:
            String r101 = null;
            if (r100.hasNext() == false) goto L8;
            Object r102 = r100.next();
            if (Intrinsics.areEqual(((ch0.h) r102).f23733a, r110) == false) goto L3;
        L9:
            ch0.h r103 = (ch0.h) r102;
            boolean r104 = false;
            if (r103 != null) goto L12;
        L29:
            v.e(this.f76538a, r104);
            return;
        L12:
            if (r103.f23735c == r111) goto L29;
            ch0.e r105 = this.f76538a.a().n1();
            if (r105 == null) goto L20;
            ILinkPlayerInfoBridge r106 = r105.f23724a;
            if (r106 == null) goto L20;
            r101 = r106.getInteractId();
        L20:
            if (Intrinsics.areEqual(r101, r110) == true) goto L22;
        L24:
            boolean r112 = false;
        L25:
            if (r112 == false) goto L27;
            boolean r107 = false;
        L28:
            ch0.h r113 = ch0.h.a(r103, null, r107, false, false, 0, 123);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).remove(r103);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).add(r113);
            r104 = true;
            goto L29
        L27:
            r107 = r111;
            goto L28
        L22:
            if (((IInteractService) jc1.k.n(IInteractService.class)).isLinkCasting() == false) goto L24;
            r112 = true;
            goto L25
        L8:
            r102 = null;
            goto L9
        }

        @Override // eg6.a, eg6.c
        public final void f(String r110, View r111) {
            Intrinsics.checkNotNullParameter(r110, "interactId");
            gh0.a.b("RtcListener", "call onFirstRemoteVideoFrame, interactId: " + r110 + ", view: " + r111, 4);
            Iterator r100 = ((CopyOnWriteArrayList) this.f76538a.f76526b).iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            Object r101 = r100.next();
            if (Intrinsics.areEqual(((ch0.h) r101).f23733a, r110) == false) goto L4;
        L9:
            ch0.h r102 = (ch0.h) r101;
            if (r102 != null) goto L12;
        L15:
            v.e(this.f76538a, true);
            return;
        L12:
            if (r102.f23734b == r111) goto L15;
            ch0.h r112 = ch0.h.a(r102, r111, false, false, false, 0, 121);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).remove(r102);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).add(r112);
            goto L15
        L8:
            r101 = null;
            goto L9
        }

        @Override // eg6.a, eg6.c
        public final void k(String r110, boolean r111) {
            Intrinsics.checkNotNullParameter(r110, "interactId");
            gh0.a.b("RtcListener", "call onRemoteAudioMute, interactId: " + r110 + ", isMuteAudio: " + r111, 4);
            Iterator r100 = ((CopyOnWriteArrayList) this.f76538a.f76526b).iterator();
        L4:
            if (r100.hasNext() == false) goto L8;
            Object r101 = r100.next();
            if (Intrinsics.areEqual(((ch0.h) r101).f23733a, r110) == false) goto L4;
        L9:
            ch0.h r102 = (ch0.h) r101;
            if (r102 != null) goto L12;
        L15:
            boolean r112 = false;
        L16:
            v.e(this.f76538a, r112);
            return;
        L12:
            if (r102.f23736d == r111) goto L15;
            ch0.h r113 = ch0.h.a(r102, null, false, r111, false, 0, 119);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).remove(r102);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).add(r113);
            r112 = true;
            goto L16
        L8:
            r101 = null;
            goto L9
        }

        @Override // eg6.a, eg6.c
        public final void onTalkStateUpdated(String[] r110, boolean[] r111) {
            if (r110 == null) goto L36;
            if (r111 != null) goto L5;
            return;
        L5:
            if (r110.length != r111.length) goto L38;
            int r100 = r110.length;
            int r101 = 0;
            boolean r102 = false;
        L8:
            if (r101 >= r100) goto L27;
            String r103 = r110[r101];
            boolean r112 = r111[r101];
            Iterator r104 = ((CopyOnWriteArrayList) this.f76538a.f76526b).iterator();
        L11:
            if (r104.hasNext() == false) goto L15;
            Object r105 = r104.next();
            if (Intrinsics.areEqual(((ch0.h) r105).f23733a, r103) == false) goto L11;
        L16:
            ch0.h r106 = (ch0.h) r105;
            if (r106 == null) goto L26;
            if (r106.f23737e == r112) goto L26;
            ch0.h r107 = ch0.h.a(r106, null, false, false, r112, 0, 111);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).remove(r106);
            ((CopyOnWriteArrayList) this.f76538a.f76526b).add(r107);
            if (r112 == false) goto L24;
            r107.f23738f = System.currentTimeMillis();
        L25:
            r102 = true;
            goto L26
        L24:
            r107.f23738f = 0;
        L26:
            r101 = r101 + 1;
            goto L8
        L15:
            r105 = null;
            goto L16
        L27:
            v.e(this.f76538a, r102);
            return;
        L38:
            return;
        }

        public final void r(boolean r100, ch0.d r101) {
            if (r100 == false) goto L21;
            ch0.g r102 = r101.f23723d;
            int r103 = r102.f23729b;
            boolean r104 = false;
            if (r103 != 2) goto L6;
        L10:
            boolean r105 = true;
        L12:
            if (r102.f23731d != 1) goto L14;
            boolean r106 = true;
        L15:
            String r107 = r102.f23728a;
            if (r105 == false) goto L18;
            if (r106 == false) goto L18;
        L19:
            c(r107, r104);
            return;
        L18:
            r104 = true;
            goto L19
        L14:
            r106 = false;
            goto L15
        L6:
            if (r103 == 3) goto L10;
            if (r103 == 1) goto L10;
            r105 = false;
            goto L12
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        eg6.b r100 = this.f76534j;
        if (r100 == null) goto L5;
        r100.s(this.f76533i);
    L5:
        this.f76531g.clear();
        this.f76532h = false;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        this.f76528d = a().l1();
        eg6.b r100 = this.f76534j;
        if (r100 == null) goto L5;
        r100.h0(this.f76533i);
    L5:
        RxUtilKt.c(a().a1().subscribe(new c(this)), this.f76531g);
        this.f76532h = true;
    }

    public static final /* synthetic */ ch0.d f(v r100) {
        ch0.d r101 = r100.f76528d;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("currentUserMergeData");
    L5:
        return r101;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.a, com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final h.a b(List<ch0.e> r110) {
        Intrinsics.checkNotNullParameter(r110, "oldMergeDataList");
        if (this.f76530f == false) goto L5;
    L23:
        List<ch0.h> r100 = this.f76526b;
        LinkedHashMap r101 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r100, 10)), 16));
        Iterator r102 = ((CopyOnWriteArrayList) r100).iterator();
    L25:
        if (r102.hasNext() == false) goto L27;
        Object r103 = r102.next();
        r101.put(((ch0.h) r103).f23733a, r103);
        goto L25
    L27:
        List<ch0.e> r111 = r110;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r112 = r111.iterator();
        boolean r105 = false;
        ch0.e r106 = null;
    L29:
        if (r112.hasNext() == false) goto L44;
        ch0.e r107 = (ch0.e) r112.next();
        ch0.h r108 = (ch0.h) r101.get(r107.f23724a.getInteractId());
        if (r107.c(r108) == false) goto L33;
        boolean r109 = r105;
        ch0.e r113 = r107;
    L34:
        IBaseUser r114 = r113.f23724a.getUser();
        if (r114 == null) goto L37;
        String r115 = r114.getIdString();
    L39:
        if (Intrinsics.areEqual(r115, gh0.a.c()) == false) goto L42;
        if (r113 == r107) goto L42;
        r106 = r113;
    L42:
        r104.add(r113);
        r105 = r109;
        goto L29
    L37:
        r115 = null;
        goto L39
    L33:
        r113 = ch0.e.a(r107, null, r108, null, null, 13);
        r109 = true;
        goto L34
    L44:
        return new h.a(r105, r104, r106);
    L5:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.n(this.f76535k, null, 2).isAnchor(), Boolean.TRUE) == false) goto L23;
        Iterator<T> r116 = r110.iterator();
    L8:
        if (r116.hasNext() == false) goto L16;
        Object r117 = r116.next();
        IBaseUser r118 = ((ch0.e) r117).f23724a.getUser();
        if (r118 == null) goto L12;
        String r119 = r118.getIdString();
    L14:
        if (Intrinsics.areEqual(r119, gh0.a.c()) == false) goto L8;
    L17:
        ch0.e r120 = (ch0.e) r117;
        if (r120 == null) goto L23;
        String r121 = r120.f23724a.getInteractId();
        if (r121 != null) goto L22;
        r121 = "";
    L22:
        ch0.h r122 = new ch0.h(r121, false, false, 1, 32);
        this.f76530f = true;
        ((CopyOnWriteArrayList) this.f76526b).add(r122);
        gh0.a.b("RtcListener", "initAnchorRtcRemoteUserInfo success", 4);
        goto L23
    L12:
        r119 = null;
        goto L14
    L16:
        r117 = null;
        goto L17
    }

    public static final void e(v r100, boolean r101) {
        if (r101 == false) goto L4;
        r100.c();
        return;
    L4:
        r100.getClass();
    }

    public v(eg6.b r100, DataCenter r101, boolean r102) {
        this.f76534j = r100;
        this.f76535k = r101;
        this.f76526b = new CopyOnWriteArrayList();
        CompositeDisposable r103 = new CompositeDisposable();
        this.f76531g = r103;
        if (r103.isDisposed() == false) goto L5;
        this.f76531g = new CompositeDisposable();
    L5:
        if (r102 == false) goto L15;
        RTSDataContext r104 = RTSDataContext.Companion.getContext();
        if (r104 == null) goto L15;
        com.bytedance.live.datacontext.n<ph0.b> r105 = r104.getLinkTypeEvent();
        if (r105 == null) goto L15;
        Observable<sh6.b<ph0.b>> r106 = r105.a();
        if (r106 == null) goto L15;
        Disposable r107 = r106.subscribe(new a(this));
        if (r107 == null) goto L15;
        RxUtilKt.c(r107, this.f76531g);
    L15:
        this.f76533i = new d(this);
    }

    public static final void d(v r100, boolean r101, ch0.d r102) {
        if (r101 == false) goto L4;
        r100.a().z0(r102);
        return;
    L4:
        r100.getClass();
    }
}
