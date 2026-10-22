package com.bytedance.android.live.room.discovery.inspector;

import android.animation.AnimatorSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.room.api.INavigationService;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.info.WidgetInfo;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/room/discovery/inspector/OfficialInspectorWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "experience-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OfficialInspectorWidget extends LiveRecyclableWidget {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f99530l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f99531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageView f99532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f99533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f99534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f99535e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Disposable f99536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Disposable f99537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f99538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatorSet f99539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AnimatorSet f99540j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f99541k;

    public static final class a {
    }

    public final class b implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f99542a;

        public b(Function1 r100) {
            this.f99542a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f99542a.invoke(r100);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.inspector.OfficialInspectorWidget$onLoad$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/ies/sdk/widgets/KVData;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<KVData, Unit> {
        public AnonymousClass1(OfficialInspectorWidget r100) {
            super(1, r100, OfficialInspectorWidget.class, "onChange", "onChange(Lcom/bytedance/ies/sdk/widgets/KVData;)V", 0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KVData r100) {
            OfficialInspectorWidget r101 = (OfficialInspectorWidget) this.receiver;
            int r102 = OfficialInspectorWidget.f99530l;
            r101.getClass();
            if (r100 == null) goto L64;
            String r103 = r100.getKey();
            if (r103.hashCode() == (-738124344)) goto L9;
            return;
        L9:
            if (r103.equals("cmd_official_inspector") == false) goto L60;
            com.bytedance.android.live.room.discovery.inspector.a r104 = (com.bytedance.android.live.room.discovery.inspector.a) r100.getData();
            if (r104 != null) goto L14;
            return;
        L14:
            if (r104.getType() != 0) goto L67;
            l r105 = r104.f99544b;
            if (r105 != null) goto L19;
            return;
        L19:
            if (r101.isViewValid() == true) goto L22;
            return;
        L22:
            if (r101.f99535e == false) goto L24;
            ALogger.e("OfficialInspectorWidget", "widget is showing when onShowStart");
            return;
        L24:
            r101.f99535e = true;
            r101.wq();
            LinearLayout r106 = r101.f99531a;
            if (r106 == null) goto L27;
            r106.setAlpha(0.0f);
        L27:
            LinearLayout r107 = r101.f99531a;
            if (r107 == null) goto L30;
            r107.setVisibility(0);
        L30:
            ImageView r108 = r101.f99532b;
            if (r108 == null) goto L33;
            r108.setVisibility(0);
        L33:
            TextView r109 = r101.f99533c;
            if (r109 == null) goto L36;
            r109.setVisibility(0);
        L36:
            TextView r110 = r101.f99534d;
            if (r110 == null) goto L39;
            r110.setVisibility(0);
        L39:
            ImageView r111 = r101.f99532b;
            if (r111 == null) goto L42;
            r111.setImageBitmap(null);
        L42:
            r101.yq();
            if (r105.f99558a == false) goto L50;
            TextView r112 = r101.f99533c;
            if (r112 == null) goto L47;
            r112.setVisibility(0);
        L47:
            TextView r113 = r101.f99533c;
            if (r113 == null) goto L53;
            r113.setText(r105.f99562e);
        L53:
            TextView r114 = r101.f99534d;
            if (r114 == null) goto L56;
            r114.setText(r105.f99563f);
        L56:
            r101.f99536f = a1.k(r105.f99559b).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.live.room.discovery.inspector.b(r101, r105), new c(r101, r105));
            r101.f99537g = Observable.timer(r105.f99561d, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).onErrorReturnItem(-1L).subscribe(new d(r101));
            LinearLayout r115 = r101.f99531a;
            if (r115 == null) goto L63;
            r115.setOnClickListener(new f(new OfficialInspectorWidget$onShowStart$4(r101)));
            return;
        L63:
            return;
        L50:
            TextView r116 = r101.f99533c;
            if (r116 == null) goto L53;
            r116.setVisibility(8);
            goto L53
        L67:
            return;
        L60:
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KVData r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    @Override // com.bytedance.ies.sdk.widgets.Widget
    public final int getLayoutId() {
        return R.layout.ttlive_widget_official_inspector;
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Disposable r100 = this.f99536f;
        if (r100 != null) goto L5;
    L6:
        Disposable r101 = this.f99536f;
        if (r101 == null) goto L9;
        r101.dispose();
    L9:
        Disposable r102 = this.f99537g;
        if (r102 != null) goto L12;
    L13:
        Disposable r103 = this.f99537g;
        if (r103 == null) goto L16;
        r103.dispose();
    L16:
        this.f99535e = false;
        this.f99541k = false;
        wq();
        LinearLayout r104 = this.f99531a;
        if (r104 == null) goto L20;
        r104.setOnClickListener(null);
        return;
    L20:
        return;
    L12:
        if (r102.isDisposed() == true) goto L16;
    L5:
        if (r100.isDisposed() == true) goto L9;
        goto L6
    }

    public final void wq() {
        AnimatorSet r100 = this.f99539i;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        AnimatorSet r101 = this.f99540j;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f99539i = null;
        this.f99540j = null;
    }

    public final void yq() {
        TextView r100 = this.f99533c;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
    L7:
        if (r101 == null) goto L9;
        r101.width = -2;
    L9:
        if (r101 == null) goto L11;
        r101.height = -2;
    L11:
        TextView r102 = this.f99533c;
        if (r102 == null) goto L14;
        r102.setLayoutParams(r101);
    L14:
        TextView r103 = this.f99533c;
        if (r103 == null) goto L17;
        r103.setText("");
    L17:
        TextView r104 = this.f99533c;
        if (r104 == null) goto L20;
        r104.setAlpha(1.0f);
    L20:
        TextView r105 = this.f99533c;
        if (r105 == null) goto L24;
        r105.clearAnimation();
        return;
    L24:
        return;
    L5:
        r101 = null;
        goto L7
    }

    public final void xq() {
        yq();
        LinearLayout r100 = this.f99531a;
        if (r100 == null) goto L5;
        r100.setAlpha(0.0f);
    L5:
        LinearLayout r101 = this.f99531a;
        if (r101 == null) goto L8;
        r101.setVisibility(8);
    L8:
        this.f99541k = false;
        this.f99535e = false;
        wq();
        this.dataCenter.put("cmd_official_inspector", new com.bytedance.android.live.room.discovery.inspector.a(2, null));
    }

    public OfficialInspectorWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
        this.f99531a = (LinearLayout) findViewById(R.id.inspector_container);
        this.f99532b = (ImageView) findViewById(R.id.inspector_icon_hsiv);
        this.f99533c = (TextView) findViewById(R.id.inspector_anim_tv);
        this.f99534d = (TextView) findViewById(R.id.inspector_suffix_tv);
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        ViewGroup r101 = this.containerView;
        if (r101 == null) goto L9;
        WidgetInfo r102 = getWidgetInfo(((INavigationService) jc1.k.n(INavigationService.class)).getUserInfoWidget(getDataCenter()));
        if (r102 == null) goto L7;
        int r103 = r102.getContentViewHeight();
    L8:
        com.bytedance.android.live.core.utils.a1.o(r101, r103);
        goto L9
    L7:
        r103 = 156;
    L9:
        DataCenter r104 = this.dataCenter;
        if (r104 == null) goto L13;
        r104.observe("cmd_official_inspector", new b(new AnonymousClass1(this)));
        return;
    }
}
