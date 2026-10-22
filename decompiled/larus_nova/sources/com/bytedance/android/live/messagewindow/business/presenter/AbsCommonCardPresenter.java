package com.bytedance.android.live.messagewindow.business.presenter;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.room.api.messagewindow.monitor.CardAlogParamsBuilder;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.f;
import com.bytedance.ies.web.jsbridge2.g;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public abstract class AbsCommonCardPresenter<T> extends q46.b<a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CompositeDisposable f82950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f82951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DataCenter f82952d;

    public interface a extends q46.a {
        void CA();

        void IG(int r100, String r101);

        void bi(String r100);

        void gG(JsEventType r100, Map<String, ? extends Object> r101);

        void yA();
    }

    public final y61.a c0() {
        return (y61.a) this.f82951c.getValue();
    }

    public abstract String d0();

    @Override // q46.b
    public final void detachView() {
        this.f531633a = null;
        this.f82950b.clear();
    }

    public AbsCommonCardPresenter(DataCenter r100) {
        this.f82952d = r100;
        this.f82950b = new CompositeDisposable();
        this.f82951c = LazyKt.lazy(new AbsCommonCardPresenter$commonCardContext$2(this));
    }

    public final void e0(HybridCard r100) {
        y61.a r101 = c0();
        if (r101 == null) goto L7;
        Pair<String, g<JSONObject, JSONObject>> r102 = r101.provideShowJsMethod(new AbsCommonCardPresenter$registerJsMethod$$inlined$apply$lambda$1(this));
        if (r102 == null) goto L7;
        r100.registerMethod(r102.getFirst(), r102.getSecond());
    L7:
        y61.a r103 = c0();
        if (r103 == null) goto L12;
        Pair<String, g<JSONObject, JSONObject>> r104 = r103.provideHideJsMethod(new AbsCommonCardPresenter$registerJsMethod$$inlined$apply$lambda$2(this));
        if (r104 == null) goto L12;
        r100.registerMethod(r104.getFirst(), r104.getSecond());
    L12:
        y61.a r105 = c0();
        if (r105 == null) goto L17;
        Pair<String, g<JSONObject, JSONObject>> r106 = r105.provideCloseJsMethod(new AbsCommonCardPresenter$registerJsMethod$$inlined$apply$lambda$3(this));
        if (r106 == null) goto L17;
        r100.registerMethod(r106.getFirst(), r106.getSecond());
    L17:
        y61.a r107 = c0();
        if (r107 == null) goto L23;
        Pair<String, f.b> r108 = r107.provideWRDSJsMethod();
        if (r108 == null) goto L24;
        r100.registerMethod(r108.getFirst(), r108.getSecond());
        return;
    L24:
        return;
    }

    public final void f0(HybridCard r100, boolean r101) {
        i r102 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r102 == null) goto L6;
        CardAlogParamsBuilder r103 = new CardAlogParamsBuilder();
        r103.d(d0());
        r103.c("sendCardShowStateChangedEvent");
        r103.a("cardState", Integer.valueOf(r101 ? 1 : 0));
        Unit r104 = Unit.INSTANCE;
        r102.d(r103.b());
    L6:
        if (r100 == null) goto L9;
        JSONObject r105 = new JSONObject();
        r105.put("cardState", r101 ? 1 : 0);
        Unit r106 = Unit.INSTANCE;
        r100.sendJsEvent("commonCardShowStateChanged", r105);
        return;
    }

    public final void g0(HybridCard r100, String r101, String r102) {
        i r103 = com.bytedance.android.live.room.api.messagewindow.monitor.d.a();
        if (r103 == null) goto L14;
        CardAlogParamsBuilder r104 = new CardAlogParamsBuilder();
        r104.d(d0());
        r104.c("sendUpdateJsEvent");
        String r105 = "";
        if (r101 != null) goto L8;
        String r106 = "";
    L9:
        r104.a("containerPayload", r106);
        if (r102 == null) goto L13;
        r105 = r102;
    L13:
        r104.a("extra", r105);
        Unit r107 = Unit.INSTANCE;
        r103.d(r104.b());
        goto L14
    L8:
        r106 = r101;
    L14:
        if (r100 == null) goto L22;
        JSONObject r108 = new JSONObject();
        if (r101 == null) goto L18;
        r108.put("containerPayload", r101);
    L18:
        if (r102 == null) goto L20;
        r108.put("extra", r102);
    L20:
        Unit r109 = Unit.INSTANCE;
        r100.sendJsEvent("updateBottomRightCard", r108);
        return;
    }
}
