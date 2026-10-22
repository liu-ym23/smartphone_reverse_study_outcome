package com.bytedance.android.live.livelink.guestlink.pipeline;

import android.content.Context;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.message.guestlink.LinkChannelMessageType;
import com.bytedance.android.live.base.model.message.guestlink.i;
import com.bytedance.android.live.liveinteract.plantform.permission.model.BaseCheckException;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.revenue.guestlink.dialog.GuestLinkMainPageDialogForLinker;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.kmp.live.livelink.api.guestlink.model.ChannelFinishReason;
import com.bytedance.live.kmp.util.KmpToastUtil;
import com.bytedance.live.livelink.kmp.impl.base.thread.ThreadManager;
import com.lynx.tasm.LynxError;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import yz0.g;

/* JADX INFO: loaded from: classes46.dex */
public final class GuestLinkPipeLineManager extends lb6.b implements sb6.b {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f81230o = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f81231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public nb6.a f81232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f81233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Long f81234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function0<Unit> f81235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f81236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f81237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Context f81238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final rb6.a f81239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final mb6.b f81240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final qb6.a f81241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ob6.a f81242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ub6.a f81243n;

    public static final class a {
    }

    public static final class b implements mb6.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkPipeLineManager f81244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f81245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f81246c;

        public static final class a implements ub6.a.InterfaceC7857a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ com.bytedance.android.live.base.model.message.guestlink.a f81247a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ b f81248b;

            @Override // ub6.a.InterfaceC7857a
            public final void n() {
                b r100 = this.f81248b;
                r100.f81244a.g(r100.f81245b, this.f81247a.getChannelId(), "onCountDownEnd", true);
                nb6.a r101 = this.f81248b.f81244a.f81232c;
                if (r101 == null) goto L10;
                CopyOnWriteArraySet<nb6.b> r102 = r101.f518518a;
                if (r102 == null) goto L12;
                Iterator<T> r103 = r102.iterator();
            L8:
                if (r103.hasNext() == false) goto L13;
                ((nb6.b) r103.next()).f518519a.n();
                goto L8
            L13:
                return;
            L12:
                return;
            }

            public a(com.bytedance.android.live.base.model.message.guestlink.a r100, b r101) {
                this.f81247a = r100;
                this.f81248b = r101;
            }

            @Override // ub6.a.InterfaceC7857a
            public final void e(long r100, long r101) {
                nb6.a r102 = this.f81248b.f81244a.f81232c;
                if (r102 == null) goto L10;
                CopyOnWriteArraySet<nb6.b> r103 = r102.f518518a;
                if (r103 == null) goto L12;
                Iterator<nb6.b> r104 = r103.iterator();
            L8:
                if (r104.hasNext() == false) goto L13;
                r104.next().f518519a.e(r100, r101);
                goto L8
            L13:
                return;
            L12:
                return;
            }
        }

        public b(GuestLinkPipeLineManager r100, long r101, long r102) {
            this.f81244a = r100;
            this.f81245b = r101;
            this.f81246c = r102;
        }

        @Override // mb6.b.a
        public final void h(long r110, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.b, Extra> r111, long r112) {
            Intrinsics.checkNotNullParameter(r111, "response");
            jy0.b.d("GuestLinkPipeLineManager", "onEnterChannelSuccess, duration: " + r110);
            if (r112 != 1) goto L5;
        L6:
            jy0.b.d("GuestLinkPipeLineManager", "onEnterChannelSuccess, leaveChannel");
            this.f81244a.f81240k.B(this.f81245b, this.f81246c, "enterChannelUpDown", null);
        L7:
            Intrinsics.checkNotNullParameter(r111, "response");
            this.f81244a.G().f541254c = true;
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r100 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r111.data;
            if (r100 == null) goto L10;
            this.f81244a.G().f541255d = r100;
        L10:
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r101 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r111.data;
            if (r101 == null) goto L15;
            com.bytedance.android.live.base.model.message.guestlink.a r102 = r101.getChannelInfo();
            if (r102 == null) goto L15;
            this.f81244a.G().b(r102, "enterChannel");
        L15:
            nb6.a r103 = this.f81244a.f81232c;
            if (r103 == null) goto L23;
            CopyOnWriteArraySet<nb6.b> r104 = r103.f518518a;
            if (r104 == null) goto L23;
            Iterator<T> r105 = r104.iterator();
        L21:
            if (r105.hasNext() == false) goto L23;
            ((nb6.b) r105.next()).f518519a.h(r110, r111, r112);
        L23:
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r113 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r111.data;
            if (r113 == null) goto L28;
            com.bytedance.android.live.base.model.message.guestlink.a r114 = r113.getChannelInfo();
            if (r114 == null) goto L28;
            this.f81244a.f81243n.E(r114.getCallDuration(), r114.getStartTimeMs());
            this.f81244a.f81243n.o(new a(r114, this));
        L28:
            com.bytedance.android.livesdk.multilink.base.model.guestlink.b r115 = (com.bytedance.android.livesdk.multilink.base.model.guestlink.b) r111.data;
            if (r115 == null) goto L35;
            com.bytedance.android.live.base.model.message.guestlink.a r116 = r115.getChannelInfo();
            if (r116 == null) goto L36;
            this.f81244a.f81241l.q(r116.getChannelId(), "enterChannel");
            return;
        L36:
            return;
        L35:
            return;
        L5:
            if (r112 != 2) goto L7;
            goto L6
        }

        @Override // mb6.b.a
        public final void o(long r100, Throwable r110, long r111) {
            Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
            jy0.b.b("GuestLinkPipeLineManager", "onEnterChannelFailed, duration: " + r100, r110);
            Intrinsics.checkNotNullParameter(r110, LynxError.LYNX_THROWABLE);
            if (r111 != 3) goto L5;
            this.f81244a.G().f541254c = false;
        L5:
            nb6.a r101 = this.f81244a.f81232c;
            if (r101 == null) goto L13;
            CopyOnWriteArraySet<nb6.b> r102 = r101.f518518a;
            if (r102 == null) goto L15;
            Iterator<T> r103 = r102.iterator();
        L11:
            if (r103.hasNext() == false) goto L16;
            ((nb6.b) r103.next()).f518519a.o(r100, r110, r111);
            goto L11
        L16:
            return;
        L15:
            return;
        }
    }

    public static final class c implements rb6.a.InterfaceC7456a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkPipeLineManager f81249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f81250b;

        public c(GuestLinkPipeLineManager r100, Function0 r101) {
            this.f81249a = r100;
            this.f81250b = r101;
        }

        @Override // rb6.a.InterfaceC7456a
        public final void W(long r100, OperateType r101) {
            Intrinsics.checkNotNullParameter(r101, "operationType");
            Intrinsics.checkNotNullParameter(r101, "operationType");
            jy0.b.d("GuestLinkPipeLineManager", "onPermissionCheckSuccess, duration: " + r100);
            this.f81250b.invoke();
        }

        @Override // rb6.a.InterfaceC7456a
        public final void c1(long r100, OperateType r101, BaseCheckException r102) {
            Intrinsics.checkNotNullParameter(r101, "operationType");
            Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            Intrinsics.checkNotNullParameter(r101, "operationType");
            Intrinsics.checkNotNullParameter(r102, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION);
            this.f81249a.G().f541252a = false;
            jy0.b.b("GuestLinkPipeLineManager", "onPermissionCheckFailed, duration: " + r100, r102);
            nb6.a r103 = this.f81249a.f81232c;
            if (r103 == null) goto L10;
            CopyOnWriteArraySet<nb6.b> r104 = r103.f518518a;
            if (r104 == null) goto L12;
            Iterator<nb6.b> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L13;
            r105.next().f518519a.o1(r100, new Throwable("onPermissionCheckFailed"));
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class d implements mb6.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkPipeLineManager f81251a;

        public d(GuestLinkPipeLineManager r100) {
            this.f81251a = r100;
        }

        @Override // mb6.b.d
        public final void i(long r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            jy0.b.b("GuestLinkPipeLineManager", "onLeaveChannelFailed, duration: " + r100, r101);
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            nb6.a r102 = this.f81251a.f81232c;
            if (r102 == null) goto L10;
            CopyOnWriteArraySet<nb6.b> r103 = r102.f518518a;
            if (r103 == null) goto L12;
            Iterator<T> r104 = r103.iterator();
        L8:
            if (r104.hasNext() == false) goto L13;
            ((nb6.b) r104.next()).f518519a.i(r100, r101);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        @Override // mb6.b.d
        public final void q(long r100, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.d, Extra> r101) {
            Intrinsics.checkNotNullParameter(r101, "response");
            jy0.b.d("GuestLinkPipeLineManager", "onLeaveChannelSuccess, duration: " + r100);
            Intrinsics.checkNotNullParameter(r101, "response");
            nb6.a r102 = this.f81251a.f81232c;
            if (r102 == null) goto L10;
            CopyOnWriteArraySet<nb6.b> r103 = r102.f518518a;
            if (r103 == null) goto L12;
            Iterator<T> r104 = r103.iterator();
        L8:
            if (r104.hasNext() == false) goto L13;
            ((nb6.b) r104.next()).f518519a.q(r100, r101);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    public static final class e implements qb6.a.InterfaceC7306a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkPipeLineManager f81252a;

        public e(GuestLinkPipeLineManager r100) {
            this.f81252a = r100;
        }

        @Override // qb6.a.InterfaceC7306a
        public final void f(i r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            nb6.a r101 = this.f81252a.f81232c;
            if (r101 == null) goto L10;
            CopyOnWriteArraySet<nb6.b> r102 = r101.f518518a;
            if (r102 == null) goto L10;
            Iterator<nb6.b> r103 = r102.iterator();
        L8:
            if (r103.hasNext() == false) goto L10;
            r103.next().f518519a.f(r100);
        L10:
            int r104 = r100.getMsgType();
            if (r104 != LinkChannelMessageType.LinkmicGuestLink_ChannelInfoUpdate.getValue()) goto L18;
            com.bytedance.android.live.base.model.message.guestlink.b r105 = r100.getUpdateChannelContent();
            if (r105 == null) goto L53;
            com.bytedance.android.live.base.model.message.guestlink.a r106 = r105.getChannelInfo();
            if (r106 == null) goto L54;
            this.f81252a.G().b(r106, "LinkmicGuestLink_ChannelInfoUpdate");
            return;
        L54:
            return;
        L53:
            return;
        L18:
            if (r104 != LinkChannelMessageType.LinkmicGuestLink_ChannelFinish.getValue()) goto L49;
            jy0.b.d("GuestLinkPipeLineManager", "received LinkmicGuestLinkMessage, finish_channel_content: " + r100.getFinishChannelContent());
            boolean r107 = true;
            if (this.f81252a.G().f541252a == false) goto L32;
            com.bytedance.android.live.base.model.message.guestlink.d r108 = r100.getFinishChannelContent();
            if (r108 == null) goto L43;
            String r109 = r108.getLinkerToast();
            if (r109 == null) goto L43;
            if (r109.length() > 0) goto L29;
            r107 = false;
        L29:
            if (r107 == false) goto L43;
            KmpToastUtil.a(r109, 0);
        L43:
            GuestLinkPipeLineManager r110 = this.f81252a;
            StringBuilder r111 = new StringBuilder("LinkmicGuestLink_ChannelFinish#");
            com.bytedance.android.live.base.model.message.guestlink.d r112 = r100.getFinishChannelContent();
            if (r112 == null) goto L46;
            String r113 = r112.getReason();
        L47:
            r111.append(r113);
            GuestLinkPipeLineManager.F(r110, r111.toString());
            return;
        L46:
            r113 = null;
            goto L47
        L32:
            if (this.f81252a.G().f541254c == false) goto L43;
            com.bytedance.android.live.base.model.message.guestlink.d r114 = r100.getFinishChannelContent();
            if (r114 == null) goto L43;
            String r115 = r114.getAduienceToast();
            if (r115 == null) goto L43;
            if (r115.length() > 0) goto L41;
            r107 = false;
        L41:
            if (r107 == false) goto L43;
            KmpToastUtil.a(r115, 0);
            goto L43
        L49:
            if (r104 != LinkChannelMessageType.LinkmicGuestLink_Finish.getValue()) goto L57;
            GuestLinkPipeLineManager.F(this.f81252a, "LinkmicGuestLink_Finish");
            return;
        }
    }

    public static final class f implements mb6.b.InterfaceC6793b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GuestLinkPipeLineManager f81253a;

        public f(GuestLinkPipeLineManager r100) {
            this.f81253a = r100;
        }

        @Override // mb6.b.InterfaceC6793b
        public final void r(long r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            jy0.b.b("GuestLinkPipeLineManager", "sendFinishChannelReq failed, duration: " + r100, r101);
            nb6.a r102 = this.f81253a.f81232c;
            if (r102 == null) goto L10;
            CopyOnWriteArraySet<nb6.b> r103 = r102.f518518a;
            if (r103 == null) goto L12;
            Iterator<T> r104 = r103.iterator();
        L8:
            if (r104.hasNext() == false) goto L13;
            ((nb6.b) r104.next()).f518519a.r(r100, r101);
            goto L8
        L13:
            return;
        L12:
            return;
        }

        @Override // mb6.b.InterfaceC6793b
        public final void j(long r100, String r101, ExtraResponse<? extends com.bytedance.android.livesdk.multilink.base.model.guestlink.a, Extra> r102) {
            Intrinsics.checkNotNullParameter(r101, "requestSource");
            Intrinsics.checkNotNullParameter(r102, "response");
            Intrinsics.checkNotNullParameter(r101, "requestSource");
            Intrinsics.checkNotNullParameter(r102, "response");
            jy0.b.d("GuestLinkPipeLineManager", "sendFinishChannelReq success, duration: " + r100);
            nb6.a r103 = this.f81253a.f81232c;
            if (r103 == null) goto L10;
            CopyOnWriteArraySet<nb6.b> r104 = r103.f518518a;
            if (r104 == null) goto L12;
            Iterator<nb6.b> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L13;
            r105.next().f518519a.j(r100, r101, r102);
            goto L8
        L13:
            return;
        L12:
            return;
        }
    }

    static {
    }

    public final sb6.a G() {
        return (sb6.a) this.f81231b.getValue();
    }

    @Override // lb6.b, lb6.d
    public final void attach() {
        this.f81241l.z(this.f81237h);
    }

    @Override // sb6.b
    public final boolean e() {
        boolean r100 = this.f81242m.C();
        jy0.b.d("GuestLinkPipeLineManager", "checkChannel: " + r100);
        if (r100 == true) goto L9;
        Long r101 = this.f81233d;
        if (r101 == null) goto L9;
        long r102 = r101.longValue();
        Long r103 = this.f81234e;
        if (r103 == null) goto L9;
        c(r102, r103.longValue(), "checkChannelFailed", ChannelFinishReason.CLIENT_CHECK.getRequestSource(), false);
    L9:
        return r100;
    }

    @Override // lb6.b, lb6.d
    public final void detach() {
        super.detach();
        k("GuestLinkPipeLineManager#detach");
        this.f81241l.r(this.f81237h);
        G().a();
        this.f81236g = true;
    }

    @Override // sb6.b
    public final sb6.a getLinkState() {
        return G();
    }

    public final Context getContext() {
        return this.f81238i;
    }

    @Override // sb6.b
    public final void b(lb6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        nb6.a r101 = this.f81232c;
        if (r101 == null) goto L14;
        Intrinsics.checkNotNullParameter(r100, "listener");
        Iterator<nb6.b> r102 = r101.f518518a.iterator();
    L6:
        if (r102.hasNext() == false) goto L15;
        nb6.b r103 = r102.next();
        if (Intrinsics.areEqual(r103.f518519a, r100) == false) goto L6;
        r101.f518518a.remove(r103);
        return;
    L15:
        return;
    }

    @Override // sb6.b
    public final void j(nb6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "linkConfig");
        this.f81232c = r100;
    }

    @Override // sb6.b
    public final void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (G().f541252a == false) goto L6;
        jy0.b.d("GuestLinkPipeLineManager", "releaseRtcEngine, reason: " + r100);
        this.f81242m.p();
        this.f81242m.destroyEngine();
        this.f81243n.release();
        return;
    }

    public static final void F(GuestLinkPipeLineManager r110, String r111) {
        r110.getClass();
        jy0.b.d("GuestLinkPipeLineManager", "releaseChannel, reason: " + r111);
        r110.f81236g = true;
        long r100 = 0;
        com.bytedance.android.live.base.model.message.guestlink.a r101 = null;
        if (r110.G().f541252a == false) goto L16;
        com.bytedance.android.live.base.model.message.guestlink.a r102 = r110.G().f541257f;
        if ((r102 instanceof pb6.a) == false) goto L7;
        r102 = null;
    L7:
        if (r102 == null) goto L16;
        g r103 = (g) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), g.class);
        if (r103 == null) goto L13;
        IRoomBase r104 = r103.getRoom();
        if (r104 == null) goto L13;
        long r105 = IRoomKtKt.getId(r104);
    L14:
        r110.c(r105, r102.getChannelId(), r111, ChannelFinishReason.CLIENT_CHECK.getRequestSource(), false);
    L13:
        r105 = 0;
    L16:
        if (r110.G().f541254c == false) goto L29;
        com.bytedance.android.live.base.model.message.guestlink.a r106 = r110.G().f541257f;
        if ((r106 instanceof pb6.a) == true) goto L21;
        r101 = r106;
    L21:
        if (r101 == null) goto L30;
        g r107 = (g) com.bytedance.android.live.revenue.core.util.f.d(j.C0.a(), g.class);
        if (r107 == null) goto L27;
        IRoomBase r108 = r107.getRoom();
        if (r108 == null) goto L27;
        r100 = IRoomKtKt.getId(r108);
    L27:
        r110.g(r100, r101.getChannelId(), r111, false);
        return;
    L30:
        return;
    }

    @Override // sb6.b
    public final void a(int r100, GuestLinkMainPageDialogForLinker.g r101) {
        this.f81239j.x(this.f81238i, OperateType.JOIN, r100, r101);
    }

    @Override // sb6.b
    public final void d(lb6.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        nb6.a r102 = this.f81232c;
        if (r102 == null) goto L20;
        Intrinsics.checkNotNullParameter(r100, "listener");
        Iterator<nb6.b> r103 = r102.f518518a.iterator();
    L6:
        if (r103.hasNext() == false) goto L12;
        nb6.b r104 = r103.next();
        if (Intrinsics.areEqual(r104.f518519a, r100) == false) goto L6;
        if (r104.f518520b != r101) goto L6;
        return;
    L12:
        r102.f518518a.add(new nb6.b(r100, r101));
        return;
    }

    @Override // sb6.b
    public final void g(long r110, long r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r112, "source");
        jy0.b.d("GuestLinkPipeLineManager", "leaveChannel, roomId: " + r110 + ", channelId: " + r111 + ", source: " + r112 + ", needSendLeaveChannelReq: " + r113);
        if (G().f541254c == true) goto L6;
        jy0.b.c("GuestLinkPipeLineManager", "leaveChannel return, cause: isEnterChannel is false", null, 4);
        return;
    L6:
        G().f541254c = false;
        if (r113 == false) goto L9;
        this.f81240k.B(r110, r111, r112, new d(this));
    L9:
        G().a();
        this.f81243n.release();
        this.f81241l.w("leaveChannel");
    }

    @Override // sb6.b
    public final void h(long r100, long r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r111, "source");
        Intrinsics.checkNotNullParameter(r112, "requestSource");
        jy0.b.d("GuestLinkPipeLineManager", "sendFinishChannelReq, roomId: " + r100 + ", channelId: " + r110 + ", source: " + r111 + ", requestSource: " + r112);
        this.f81240k.t(r100, r110, r111, r112, new f(this));
    }

    @Override // sb6.b
    public final void i(long r110, long r210, long r211, long r212) {
        jy0.b.d("GuestLinkPipeLineManager", "enterChannel, roomId: " + r110 + ", curChannelId: " + r210 + ", toChannelId: " + r211 + ", enterType: " + r212);
        this.f81240k.m(r110, r210, r211, r212, new b(this, r110, r210));
    }

    @Override // sb6.b
    public final void c(long r100, long r101, String r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "source");
        Intrinsics.checkNotNullParameter(r103, "requestSource");
        jy0.b.d("GuestLinkPipeLineManager", "finishChannel, roomId: " + r100 + ", channelId: " + r101 + ", reason: " + r102 + ", requestSource: " + r103 + ", needSendFinishChannelReq: " + r104);
        if (r104 == false) goto L5;
        h(r100, r101, r102, r103);
    L5:
        this.f81236g = true;
        k(r102);
        this.f81241l.w("finishChannel");
        this.f81243n.release();
        G().a();
    }

    public GuestLinkPipeLineManager(Context r100, rb6.a r101, mb6.b r102, qb6.a r103, ob6.a r104, ub6.a r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permissionManager");
        Intrinsics.checkNotNullParameter(r102, "apiManager");
        Intrinsics.checkNotNullParameter(r103, "msgManager");
        Intrinsics.checkNotNullParameter(r104, "mediaManager");
        Intrinsics.checkNotNullParameter(r105, "countDownManager");
        this.f81238i = r100;
        this.f81239j = r101;
        this.f81240k = r102;
        this.f81241l = r103;
        this.f81242m = r104;
        this.f81243n = r105;
        this.f81231b = LazyKt.lazy(GuestLinkPipeLineManager$mLinkState$2.INSTANCE);
        new ThreadManager();
        this.f81237h = new e(this);
    }

    @Override // sb6.b
    public final void l(final long r110, final long r111, final int r112, final int r113, final String r210, final String r211, long r212, boolean r213) {
        Intrinsics.checkNotNullParameter(r210, "rtcExtInfo");
        jy0.b.d("GuestLinkPipeLineManager", "joinChannel, roomId: " + r110 + ", channelId: " + r111 + ", rtcExtInfo: " + r210 + ", liveCoreInfo: " + r211 + ", needCheckPermission: " + r213);
        this.f81243n.setCallDuration(r212);
        G().f541252a = true;
        G().f541253b = true;
        this.f81233d = Long.valueOf(r110);
        this.f81234e = Long.valueOf(r111);
        Function0<Unit> r114 = new GuestLinkPipeLineManager$joinChannel$joinChannelTask$1(this, r111, r110, r112, r113, r210, r211);
        if (r213 == false) goto L5;
        this.f81239j.x(this.f81238i, OperateType.JOIN, r112, new c(this, r114));
        return;
    L5:
        r114.invoke();
    }
}
