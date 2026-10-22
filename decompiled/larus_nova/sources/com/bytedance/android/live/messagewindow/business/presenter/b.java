package com.bytedance.android.live.messagewindow.business.presenter;

import android.text.TextUtils;
import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.room.api.messagewindow.service.dependenceproxy.IMsgWindowProxyService;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.message.model.m1;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.follow.IFollowPair;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import jc1.k;
import kotlin.Deprecated;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends AbsCommonCardPresenter<m1> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f82968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Float f82969f;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.messagewindow.business.presenter.b$b, reason: collision with other inner class name */
    public static final class C1262b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f82970a;

        public C1262b(b r100) {
            this.f82970a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            SubscriberJsEvent r101 = (SubscriberJsEvent) r100;
            ALogger.i(this.f82970a.f82968e, "subscribe jsEvent: close_bottom_right_card");
            if (TextUtils.equals("close_bottom_right_card", r101.getEventName()) == false) goto L7;
            ((AbsCommonCardPresenter.a) this.f82970a.f531633a).gG(JsEventType.CLOSE_CARD, r101.getParams());
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f82971a = null;

        static {
            f82971a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IFollowPair r101 = (IFollowPair) r100;
            if (r101 == null) goto L13;
            int r102 = r101.getFollowStatus();
            l71.c r103 = ((IMsgWindowProxyService) k.n(IMsgWindowProxyService.class)).getExternalBrowserService();
            if (r103 == null) goto L14;
            JSONObject r104 = new JSONObject();
            boolean r105 = true;
            if (r102 == 2) goto L11;
            if (r102 == 1) goto L11;
            r105 = false;
        L11:
            r104.put("follow_status", r105);
            Unit r106 = Unit.INSTANCE;
            r103.enqueueEvent("follow_card_status_change", r104);
            return;
        L14:
            return;
        }
    }

    static {
    }

    @Deprecated(message = "新卡片不再使用该jsEvent通信")
    public final void h0() {
        this.f82950b.add(((IBaseBrowserService) k.n(IBaseBrowserService.class)).registerJsEventSubscriber("close_bottom_right_card").observeOn(AndroidSchedulers.mainThread()).subscribe(new C1262b(this)));
    }

    @Deprecated(message = "新卡片不再使用该jsEvent通信")
    public final void i0() {
        CompositeDisposable r100 = this.f82950b;
        com.bytedance.android.livesdk.user.e r101 = ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user();
        DataCenter r102 = this.f82952d;
        if (r102 == null) goto L8;
        IRoom r103 = (IRoom) r102.get("data_room", null);
        if (r103 == null) goto L8;
        String r104 = r103.getOwnerUserIdString();
        if (r104 == null) goto L8;
    L9:
        r100.add(r101.u0(r104).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(c.f82971a));
        return;
    L8:
        r104 = "0";
        goto L9
    }

    @Override // com.bytedance.android.live.messagewindow.business.presenter.AbsCommonCardPresenter
    public final String d0() {
        return this.f82968e;
    }

    public b(DataCenter r100) {
        super(r100);
        this.f82968e = "PortraitBottomRightCommonCardPresenter";
    }
}
