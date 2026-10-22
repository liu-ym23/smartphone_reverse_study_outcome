package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget;

import android.content.Context;
import com.bytedance.android.live.base.model.message.ITextPieceImage;
import com.bytedance.android.live.base.model.message.k0;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.message.t;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.presenter.n;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.config.ck0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.SimpleCommonTextDanmakuShooter;
import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.api.HistoryMsgApi;
import com.bytedance.android.livesdk.message.model.e2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.PublicAreaCommon;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.setting.LivePreviewDanmakuConfig;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vlc.l;

/* JADX INFO: loaded from: classes9.dex */
public final class PortraitSimpleZDanmakuPresenter extends n<IView> implements l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleCommonTextDanmakuShooter f141711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f141712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f141713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Disposable f141714h;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/simplewidget/PortraitSimpleZDanmakuPresenter$IView;", "Lcom/bytedance/android/livesdk/chatroom/viewmodule/IWidget;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface IView extends IWidget {
        int U();

        void X(Object r100, boolean r101);

        @Override // com.bytedance.android.livesdk.chatroom.viewmodule.IWidget
        /* synthetic */ Context getContext();

        Room getRoom();

        boolean isEnablePreviewDanmaku();

        void jR();

        p22.n mp();

        void ps();

        boolean t7();
    }

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitSimpleZDanmakuPresenter f141715a;

        public b(PortraitSimpleZDanmakuPresenter r100) {
            this.f141715a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Response r101 = (Response) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            IView r102 = (IView) this.f141715a.f531633a;
            if (r102 == null) goto L43;
            if (r102.isEnablePreviewDanmaku() != true) goto L43;
            im2.d r103 = new im2.d(z.e(this.f141715a.f107664c, false));
            List<com.bytedance.android.livesdk.chatroom.model.n> r104 = ((com.bytedance.android.livesdk.interactivity.api.barrage.model.b) r101.data).a();
            Integer r105 = null;
            if (r104 == null) goto L17;
            ArrayList r106 = new ArrayList();
            Iterator<T> r107 = r104.iterator();
        L10:
            if (r107.hasNext() == false) goto L18;
            tlc.d r108 = r103.b((com.bytedance.android.livesdk.chatroom.model.n) r107.next());
            if ((r108 instanceof e2) == true) goto L14;
            r108 = null;
        L14:
            e2 r109 = (e2) r108;
            if (r109 == null) goto L10;
            r106.add(r109);
        L18:
            long r110 = System.currentTimeMillis();
            if (r106 == null) goto L32;
            ArrayList r111 = new ArrayList();
            Iterator<T> r112 = r106.iterator();
        L22:
            if (r112.hasNext() == false) goto L33;
            e2 r113 = (e2) r112.next();
            if ((r113 instanceof k0) == true) goto L26;
            e2 r114 = null;
        L27:
            if (r114 == null) goto L29;
            r114.setDanmakuReceiveTime(r110);
        L29:
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r115 = com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a(r113);
            if (r115 == null) goto L22;
            r111.add(r115);
            goto L22
        L26:
            r114 = r113;
        L33:
            int r116 = i.f141754a;
            StringBuilder r117 = new StringBuilder("origin history message size: ");
            if (r106 == null) goto L36;
            Integer r118 = Integer.valueOf(r106.size());
        L37:
            r117.append(r118);
            r117.append(", text message size: ");
            if (r111 == null) goto L40;
            r105 = Integer.valueOf(r111.size());
        L40:
            r117.append(r105);
            i.c(r117.toString());
            return r111;
        L36:
            r118 = null;
            goto L37
        L32:
            r111 = null;
            goto L33
        L17:
            r106 = null;
        L43:
            throw new Exception("map#1, room auth is false or danmaku is off");
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitSimpleZDanmakuPresenter f141716a;

        public c(PortraitSimpleZDanmakuPresenter r100) {
            this.f141716a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            List r101 = (List) r100;
            i.c("request history danmaku success");
            this.f141716a.i0(2);
            IView r102 = (IView) this.f141716a.f531633a;
            if (r102 == null) goto L23;
            boolean r103 = true;
            if (r102.isEnablePreviewDanmaku() != true) goto L23;
            List r104 = r101;
            if (r104 != null) goto L10;
        L13:
            if (r103 == false) goto L15;
            i.c("history message is empty");
            this.f141716a.i0(4);
            return;
        L15:
            IView r105 = (IView) this.f141716a.f531633a;
            if (r105 == null) goto L18;
            r105.jR();
        L18:
            this.f141716a.i0(3);
            Iterator<T> r106 = r101.iterator();
        L20:
            if (r106.hasNext() == false) goto L22;
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r107 = (com.bytedance.android.livesdk.interactivity.api.publicscreen.d) r106.next();
            this.f141716a.k0(r107);
            goto L20
        L22:
            PortraitSimpleZDanmakuPresenter r108 = this.f141716a;
            r108.h0();
            r108.f141714h = Observable.timer(LivePreviewDanmakuConfig.Companion.getHistoryDanmakuTimeoutDuration(), TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.b(r108));
            return;
        L10:
            if (r104.isEmpty() == true) goto L13;
            r103 = false;
        L23:
            i.c("room auth is false or danmaku is off");
            this.f141716a.i0(4);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitSimpleZDanmakuPresenter f141717a;

        public d(PortraitSimpleZDanmakuPresenter r100) {
            this.f141717a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f141717a.i0(4);
            int r102 = i.f141754a;
            StringBuilder r103 = new StringBuilder("request history danmaku error, msg: ");
            if (r101 == null) goto L5;
            String r104 = r101.getMessage();
        L6:
            r103.append(r104);
            i.b(r103.toString());
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class e implements r22.b<com.bytedance.android.livesdk.interactivity.api.publicscreen.d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PortraitSimpleZDanmakuPresenter f141718a;

        @Override // r22.b
        public final boolean a() {
            return true;
        }

        public e(PortraitSimpleZDanmakuPresenter r100) {
            this.f141718a = r100;
        }

        @Override // r22.b
        public final void b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
            com.bytedance.android.livesdk.interactivity.api.publicscreen.d r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "danmaku");
            IView r102 = (IView) this.f141718a.f531633a;
            if (r102 == null) goto L6;
            r102.X(r101, false);
            return;
        }
    }

    static {
    }

    public final void l0() {
        i0(1);
        Disposable r100 = this.f141712f;
        if (r100 == null) goto L6;
        r100.dispose();
    L6:
        if (ck0.f119960a.getValue().booleanValue() == false) goto L8;
        i.c("request use bytelink");
        HistoryMsgApi r101 = (HistoryMsgApi) ac2.e.b().a(HistoryMsgApi.class);
    L9:
        HistoryMsgApi r102 = r101;
        IView r103 = (IView) this.f531633a;
        if (r103 == null) goto L14;
        Room r104 = r103.getRoom();
        if (r104 == null) goto L14;
        long r105 = r104.f162599id;
    L15:
        this.f141712f = r102.getHistoryMsg(1, r105, "preview").subscribeOn(Schedulers.io()).observeOn(Schedulers.computation()).map(new b(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this), new d(this));
        return;
    L14:
        r105 = 0;
        goto L15
    L8:
        i.c("request use http");
        r101 = (HistoryMsgApi) com.bytedance.android.live.network.c.b().e(HistoryMsgApi.class);
        goto L9
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n, q46.b
    public final void detachView() {
        this.f141711e.d();
        this.f141711e.getClass();
        Disposable r100 = this.f141712f;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f141712f = null;
        h0();
        i0(0);
        super.detachView();
    }

    public final void h0() {
        Disposable r100 = this.f141714h;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f141714h = null;
    }

    public final boolean j0() {
        int r100 = this.f141713g;
        if (r100 != 1) goto L5;
        return true;
    L5:
        if (r100 != 2) goto L7;
        return true;
    L7:
        if (r100 == 3) goto L13;
        return false;
    L13:
        return true;
    }

    public PortraitSimpleZDanmakuPresenter() {
        this.f141711e = new SimpleCommonTextDanmakuShooter(new e(this));
    }

    @Override // com.bytedance.android.livesdk.chatroom.presenter.n
    public final /* bridge */ /* synthetic */ void c0(IWidget r100) {
        g0((IView) r100);
    }

    public final void g0(IView r100) {
        super.c0(r100);
        this.f141711e.getClass();
    }

    public final void i0(int r100) {
        int r101 = i.f141754a;
        i.c("change history danmaku state, oldState: " + this.f141713g + ", newState: " + r100);
        this.f141713g = r100;
    }

    public final void k0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r110) {
        if (r110 != null) goto L5;
        return;
    L5:
        if ((r110 instanceof b0) == false) goto L36;
        p0 r111 = (p0) r110;
        IView r100 = (IView) this.f531633a;
        if (r100 == null) goto L49;
        int r101 = (int) r100.mp().f527445i;
        tb2.d r102 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.b.a(r111, r101);
        int r103 = (int) r100.mp().f527440d;
        Iterator<tb2.c> r104 = r102.f545242a.iterator();
    L11:
        if (r104.hasNext() == false) goto L34;
        tb2.c r105 = r104.next();
        ITextPieceImage r106 = r105.getImageValue();
        if (r106 == null) goto L11;
        if (r106.getScalingRate() == 0.0f) goto L11;
        float r107 = r101;
        if (((int) (r106.getScalingRate() * r107)) <= (r103 - s1.f(4.0f))) goto L19;
        int r108 = r103 - s1.f(4.0f);
    L21:
        if (r106.getWidth() != 0) goto L23;
    L25:
        r106.setScaleType(ITextPieceImage.ScaleType.FIT_Y);
        r106.setHeight(r108);
    L27:
        if ((r111 instanceof a0) == false) goto L11;
        if (r111.getDefaultContent().length() <= 0) goto L31;
        boolean r109 = true;
    L32:
        if (r109 == false) goto L11;
        r106.setEnableTextWhenFailed(true);
        r105.setText(r111.getDefaultContent());
        goto L11
    L31:
        r109 = false;
        goto L32
    L23:
        if (r106.getHeight() == 0) goto L25;
        r106.setWidth((int) ((r106.getWidth() / r106.getHeight()) * r108));
        r106.setHeight(r108);
        goto L27
    L19:
        r108 = (int) (r107 * r106.getScalingRate());
        goto L21
    L34:
        qb2.c.b(r102, new com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.a(this, r111), null, 16);
        return;
    L49:
        return;
    L36:
        this.f141711e.a(r110);
    }

    @Override // vlc.l
    public final void onMessage(tlc.d r100) {
        t r101 = null;
        if ((r100 instanceof t) == true) goto L5;
        tlc.d r102 = null;
    L6:
        t r103 = (t) r102;
        if (r103 != null) goto L9;
        return;
    L9:
        String r104 = r103.getMessageMethod();
        if (r104 != null) goto L13;
        return;
    L13:
        if (r104.hashCode() == 41447196) goto L16;
        return;
    L16:
        if (r104.equals("WebcastChatMessage") == false) goto L52;
        i.c("receive chat message");
        IView r105 = (IView) this.f531633a;
        if (r105 != null) goto L20;
    L50:
        i.c("room auth is false or danmaku is off");
        return;
    L20:
        if (r105.isEnablePreviewDanmaku() != true) goto L50;
        if ((r103 instanceof e2) == true) goto L25;
        t r106 = null;
    L26:
        e2 r107 = (e2) r106;
        if (r107 == null) goto L48;
        PublicAreaCommon r108 = r107.getOrInitPublicAreaCommon();
        if (r108 == null) goto L48;
        if (r108.getShowInDanmaku() != true) goto L48;
        if (j0() == false) goto L37;
        i.c("history danmaku is running, current history is " + this.f141713g);
        return;
    L37:
        IView r109 = (IView) this.f531633a;
        if (r109 == null) goto L41;
        r109.jR();
    L41:
        if ((r103 instanceof k0) == false) goto L44;
        r101 = r103;
    L44:
        k0 r110 = (k0) r101;
        if (r110 == null) goto L47;
        r110.setDanmakuReceiveTime(System.currentTimeMillis());
    L47:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.d.O0.getClass();
        k0(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.a.a((t) r100));
        return;
    L48:
        i.c("message isn't danmaku");
        return;
    L25:
        r106 = r103;
        goto L26
    L52:
        return;
    L5:
        r102 = r100;
        goto L6
    }
}
