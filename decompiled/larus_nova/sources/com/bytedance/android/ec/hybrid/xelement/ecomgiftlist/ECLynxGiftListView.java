package com.bytedance.android.ec.hybrid.xelement.ecomgiftlist;

import android.content.Context;
import android.view.View;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.host.api.ui.xelement.IECGiftListView;
import com.bytedance.common.utility.Logger;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.view.UISimpleView;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tencent.connect.share.QzonePublish;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0007J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/ec/hybrid/xelement/ecomgiftlist/ECLynxGiftListView;", "Lcom/lynx/tasm/behavior/ui/view/UISimpleView;", "Lcom/bytedance/android/ec/host/api/ui/xelement/IECGiftListView;", "Lcom/lynx/react/bridge/ReadableArray;", "dataList", "", "bind", "Lcom/lynx/react/bridge/ReadableMap;", "contentInset", "contentInsetFromLynx", QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, "videoSizeFromLynx", "", "space", "spaceFromLynx", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-xelement_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLynxGiftListView extends UISimpleView<IECGiftListView> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f47745b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f47746a;

    public static final class a {
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECLynxGiftListView f47747a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f47748b;

        public b(ECLynxGiftListView r100, Class r101) {
            this.f47747a = r100;
            this.f47748b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            HashMap r101 = (HashMap) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            ECLynxGiftListView r102 = this.f47747a;
            Class r103 = this.f47748b;
            int r104 = ECLynxGiftListView.f47745b;
            r102.getClass();
            return ECLynxGiftListView.O(r101, r103);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f47749a;

        public c(Function1 r100) {
            this.f47749a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(T r100) {
            this.f47749a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.ec.hybrid.xelement.ecomgiftlist.ECLynxGiftListView$createView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "p1", "", "p2", "", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    final /* synthetic */ class C98501 extends FunctionReferenceImpl implements Function2<String, Map<String, ? extends Object>, Unit> {
        public C98501(ECLynxGiftListView r100) {
            super(2, r100, ECLynxGiftListView.class, "setStateChangeReporter", "setStateChangeReporter(Ljava/lang/String;Ljava/util/Map;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String r100, Map<String, ? extends Object> r101) {
            Intrinsics.checkNotNullParameter(r100, "p1");
            Intrinsics.checkNotNullParameter(r101, "p2");
            ECLynxGiftListView r102 = (ECLynxGiftListView) this.receiver;
            int r103 = ECLynxGiftListView.f47745b;
            r102.getClass();
            HashMap r104 = new HashMap();
            int r105 = r100.hashCode();
            if (r105 == (-982489716)) goto L16;
            if (r105 == (-301924039)) goto L13;
            if (r105 == 1506338761) goto L10;
        L18:
            String r106 = "";
            r101 = r104;
        L19:
            LynxContext r107 = r102.getLynxContext();
            if (r107 == null) goto L38;
            EventEmitter r108 = r107.getEventEmitter();
            if (r108 != null) goto L24;
            return;
        L24:
            if (r106.length() <= 0) goto L26;
            boolean r109 = true;
        L27:
            if (r109 == true) goto L30;
            r108 = null;
        L30:
            if (r108 == null) goto L40;
            m7a.a r110 = new m7a.a(r102.getSign(), r106);
            Iterator<Map.Entry<String, ? extends Object>> r111 = r101.entrySet().iterator();
        L33:
            if (r111.hasNext() == false) goto L35;
            Map.Entry<String, ? extends Object> r112 = r111.next();
            r110.a(r112.getKey(), r112.getValue());
            goto L33
        L35:
            Unit r113 = Unit.INSTANCE;
            r108.sendCustomEvent(r110);
            return;
        L40:
            return;
        L26:
            r109 = false;
            goto L27
        L38:
            return;
        L10:
            if (r100.equals("onVideoScroll") == false) goto L18;
            r106 = "videoscroll";
            goto L19
        L13:
            if (r100.equals("onCardClick") == false) goto L18;
            r106 = "cardclick";
            goto L19
        L16:
            if (r100.equals("onRadioClick") == false) goto L18;
            r106 = "radioclick";
            goto L19
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(String r100, Map<String, ? extends Object> r101) {
            invoke2(r100, r101);
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f47750a = null;

        static {
            f47750a = new d();
        }

        public d() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            ((Throwable) r100).printStackTrace();
        }
    }

    public static final class e implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ECLynxGiftListView f47751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f47752b;

        public e(ECLynxGiftListView r100, int r101) {
            this.f47751a = r100;
            this.f47752b = r101;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            int r100 = this.f47752b;
            ECLynxGiftListView r101 = this.f47751a;
            int r102 = ECLynxGiftListView.f47745b;
            if (r100 >= r101.M().size()) goto L6;
            ListProtector.remove(this.f47751a.M(), this.f47752b);
            return;
        }
    }

    static {
    }

    public final List<Disposable> M() {
        return (List) this.f47746a.getValue();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        Iterator<Disposable> r100 = M().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        Disposable r101 = r100.next();
        if (r101.isDisposed() == true) goto L4;
        r101.dispose();
        goto L4
    L8:
        M().clear();
        super.destroy();
    }

    public ECLynxGiftListView(LynxContext r100) {
        super(r100);
        this.f47746a = LazyKt.lazy(ECLynxGiftListView$disposableList$2.INSTANCE);
    }

    @LynxProp(name = "datalist")
    public final void bind(ReadableArray r100) {
        Intrinsics.checkNotNullParameter(r100, "dataList");
        Intrinsics.checkNotNullParameter(r100, "dataList");
        int r101 = M().size();
        Disposable r102 = Flowable.just(r100).map(new com.bytedance.android.ec.hybrid.xelement.ecomgiftlist.a(this)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.ec.hybrid.xelement.ecomgiftlist.b(this), com.bytedance.android.ec.hybrid.xelement.ecomgiftlist.c.f47755a, new com.bytedance.android.ec.hybrid.xelement.ecomgiftlist.d(this, r101));
        M().add(r102);
    }

    @LynxProp(name = "contentinset")
    public final void contentInsetFromLynx(ReadableMap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        N(r100.toHashMap(), IECGiftListView.ContentInset.class, new AnonymousClass1(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = com.bytedance.android.ec.hybrid.xelement.b.f47713a;
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @LynxProp(name = "space")
    public final void spaceFromLynx(float r100) {
        ((IECGiftListView) getView()).c();
    }

    @LynxProp(name = "videosize")
    public final void videoSizeFromLynx(ReadableMap r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        N(r100.toHashMap(), IECGiftListView.VideoSize.class, new C98511(this));
    }

    public static Object O(HashMap r100, Class r101) {
        return u0.b(u0.d(r100), r101);
    L4:
        e = move-exception;
        Logger.e("ecom-gift-list", "gson call exception: " + e);
        return r101.newInstance();
    }

    public final <T> void N(HashMap<String, Object> r100, Class<T> r101, Function1<? super T, Unit> r102) {
        int r103 = M().size();
        Disposable r104 = Flowable.just(r100).map(new b(this, r101)).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(r102), d.f47750a, new e(this, r103));
        M().add(r104);
    }
}
