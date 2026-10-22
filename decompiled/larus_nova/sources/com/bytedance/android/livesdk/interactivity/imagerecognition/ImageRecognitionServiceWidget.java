package com.bytedance.android.livesdk.interactivity.imagerecognition;

import android.content.Context;
import android.os.SystemClock;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livehostapi.foundation.depend.PluginType;
import com.bytedance.android.livehostapi.platform.IHostAction;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.widget.RoomRecyclableWidget;
import com.bytedance.android.livesdk.config.d8;
import com.bytedance.android.livesdk.config.f81;
import com.bytedance.android.livesdk.config.setting.l;
import com.bytedance.android.livesdk.config.y00;
import com.bytedance.android.livesdk.interactivity.imagerecognition.util.ImageRecognitionUtil;
import com.bytedance.android.livesdk.utils.guide.LongPressGuideScene;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomOthersData;
import com.bytedance.android.livesdkapi.depend.model.live.StreamRecognitionCandidate;
import com.bytedance.android.livesdkapi.depend.model.live.StreamRecognitionContainers;
import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;
import com.bytedance.android.livesdkapi.distribution.IExternalConfigJudger;
import com.bytedance.android.livesdkapi.distribution.config.GestureAction;
import com.bytedance.android.livesdkapi.distribution.config.GuideAction;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionBusiness;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionButton;
import com.bytedance.android.livesdkapi.imagerecognition.ImageRecognitionEntry;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s32.f;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/imagerecognition/ImageRecognitionServiceWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/RoomRecyclableWidget;", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ImageRecognitionServiceWidget extends RoomRecyclableWidget {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageRecognitionTask f136947a;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Integer.valueOf(((StreamRecognitionCandidate) r101).priority), Integer.valueOf(((StreamRecognitionCandidate) r100).priority));
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRecognitionServiceWidget f136948a;

        public b(ImageRecognitionServiceWidget r100) {
            this.f136948a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.livesdk.interactivity.imagerecognition.a r111 = (com.bytedance.android.livesdk.interactivity.imagerecognition.a) r110;
            ImageRecognitionServiceWidget r100 = this.f136948a;
            ImageRecognitionTask r101 = r100.f136947a;
            if (r101 != null) goto L5;
        L7:
            int r102 = s32.b.f540445a;
            DataCenter r103 = r100.dataCenter;
            ImageRecognitionEntry r104 = r111.f136980b;
            Intrinsics.checkNotNullParameter(r104, "entry");
            if (r103 == null) goto L20;
            int r105 = s32.a.f540444a[r104.ordinal()];
            if (r105 != 1) goto L13;
            ImageRecognitionButton r106 = s32.b.c(r103);
        L18:
            if (r106 == null) goto L20;
            boolean r107 = true;
        L21:
            if (r107 == false) goto L61;
            Map<Integer, ImageRecognitionBusiness> r108 = s32.c.f540446a;
            int r109 = r111.f136979a;
            ImageRecognitionBusiness r112 = (ImageRecognitionBusiness) ((HashMap) s32.c.f540446a).get(Integer.valueOf(r109));
            if (r112 != null) goto L26;
            int r113 = f.f540454a;
            f.a("no business for scene " + r111.f136979a);
            return;
        L26:
            d8 r114 = y00.f121644a.getValue();
            int r115 = r111.f136979a;
            ImageRecognitionEntry r116 = r111.f136980b;
            String r117 = r111.f136981c;
            Context r118 = r100.context;
            Widget.WidgetCallback r119 = r100.widgetCallback;
            ImageRecognitionDialogFragment r120 = null;
            if (r119 == null) goto L31;
            WidgetManager r121 = r119.getWidgetManager();
            if (r121 == null) goto L31;
            FragmentManager r122 = r121.getParentFragmentManager();
        L32:
            final ImageRecognitionTask r123 = new ImageRecognitionTask(r114, r115, r116, r117, r112, r118, r122, new com.bytedance.android.livesdk.interactivity.imagerecognition.b(r100));
            String r124 = a0.p(r100.dataCenter);
            if (r123.f136951a != 0) goto L52;
            r123.f136951a = 1;
            if (r123.f136953c != null) goto L51;
            int r125 = ImageRecognitionDialogFragment.f136938j;
            ImageRecognitionEntry r126 = r123.f136961k;
            FragmentManager r127 = r123.f136965o;
            Function0<Unit> r128 = new ImageRecognitionTask$openRecognitionDialog$1(r123);
            Intrinsics.checkNotNullParameter(r126, "entry");
            Intrinsics.checkNotNullParameter(r128, "onCancel");
            if (r127 != null) goto L57;
        L50:
            r123.f136953c = r120;
            r123.f136954d = SystemClock.elapsedRealtime() + r123.f136959i.d();
            goto L51
        L57:
        L48:
            e = move-exception;
            SafetyGuard.a("open ImageRecognitionDialogFragment failed", e, null);
            goto L50
        L39:
            if (r127.isDestroyed() == true) goto L50;
            if (r127.isStateSaved() == true) goto L50;
            ImageRecognitionDialogFragment r129 = new ImageRecognitionDialogFragment(r126, r124, r128);     // Catch: Exception -> L48
            LandscapeRestrictionOperation r130 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L48
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r129, "ImageRecognitionDialogFragment", r130);     // Catch: Exception -> L48
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r127, r129, r130) == false) goto L55;
        L47:
            r120 = r129;
            goto L50
        L55:
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L54
        L46:
            r129.show(r127, "ImageRecognitionDialogFragment");     // Catch: Exception -> L48
        L51:
            r123.f136952b = System.currentTimeMillis();
            final ImageRecognitionTask$startRecognition$1 r131 = new ImageRecognitionTask$startRecognition$1(r123);
            int r132 = ImageRecognitionUtil.f136998a;
            ImageRecognitionUtil.d(new ImageRecognitionTask$startRecognition$2(r131));
        L52:
            Unit r133 = Unit.INSTANCE;
            r100.f136947a = r123;
            return;
        L31:
            r122 = null;
            goto L32
        L61:
            return;
        L13:
            if (r105 != 2) goto L16;
            r106 = s32.b.b(r103);
            goto L18
        L16:
            throw new NoWhenBranchMatchedException();
        L20:
            r107 = false;
            goto L21
        L5:
            if (r101.d() != true) goto L7;
            f.a("recognizing");
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRecognitionServiceWidget f136949a;

        public c(ImageRecognitionServiceWidget r100) {
            this.f136949a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            IUserService r102 = (IUserService) k.f(IUserService.class);
            boolean r103 = true;
            if (r102 == null) goto L9;
            com.bytedance.android.livesdk.user.f r104 = r102.user();
            if (r104 == null) goto L9;
            if (r104.isLogin() != true) goto L9;
            boolean r105 = true;
        L11:
            if (this.f136949a.dataCenter != null) goto L13;
        L23:
            f.a("cannot show long press guide");
            return;
        L13:
            if (l.c() == true) goto L19;
            if (r105 == false) goto L16;
        L18:
            r103 = false;
            goto L19
        L16:
            if (f81.f120182a.getValue().a() == false) goto L18;
        L19:
            if (r103 == true) goto L23;
            int r106 = s32.b.f540445a;
            if (s32.b.c(this.f136949a.dataCenter) == null) goto L23;
            bu2.a r107 = new bu2.a(LongPressGuideScene.STREAM_RECOGNITION, s1.B(R.string.ttlive_image_recognition_long_press_tips));
            r107.f20723a = ImageRecognitionServiceWidget$onLoad$3$1.INSTANCE;
            xs2.b.a().post(r107);
            f.b("send ShowLongPressGuideEvent");
            return;
        L9:
            r105 = false;
            goto L11
        }
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r100) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        Map<Integer, ImageRecognitionBusiness> r100 = s32.c.f540446a;
        ((HashMap) s32.c.f540446a).clear();
        ImageRecognitionTask r101 = this.f136947a;
        if (r101 == null) goto L5;
        r101.b();
    L5:
        this.f136947a = null;
    }

    public ImageRecognitionServiceWidget() {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r100) {
        Integer r101 = null;
        RoomContext r102 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r102 == null) goto L20;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L20;
        Room r104 = r103.getValue();
        if (r104 == null) goto L20;
        RoomOthersData r105 = r104.others;
        if (r105 == null) goto L20;
        StreamRecognitionContainers r106 = r105.getRecognitionContainers();
        if (r106 == null) goto L20;
        List<StreamRecognitionCandidate> r107 = r106.recognitionCandidates;
        if (r107 == null) goto L15;
        List<StreamRecognitionCandidate> r108 = CollectionsKt.sortedWith(r107, new a());
    L16:
        r106.recognitionCandidates = r108;
        int r109 = f.f540454a;
        StringBuilder r110 = new StringBuilder("recognitionCandidate num is ");
        if (r108 == null) goto L19;
        r101 = Integer.valueOf(r108.size());
    L19:
        r110.append(r101);
        f.b(r110.toString());
        goto L20
    L15:
        r108 = null;
    L20:
        s32.c.a(1, new d82.a());
        if (PluginType.Search.isInstalled() == false) goto L26;
        IHostAction r111 = (IHostAction) k.f(IHostAction.class);
        if (r111 == null) goto L25;
        r111.registerLynxPhotoSearchResult();
    L25:
        s32.c.a(2, new e82.b());
    L27:
        ((ObservableSubscribeProxy) xs2.b.a().b(com.bytedance.android.livesdk.interactivity.imagerecognition.a.class).as(autoDispose())).subscribe(new b(this));
        if (com.bytedance.android.livesdk.sharedpref.b.Z.getValue().booleanValue() == true) goto L49;
        RoomContext r112 = getDataContext();
        if (r112 == null) goto L36;
        n<IExternalConfigJudger> r113 = r112.getExternalConfigJudger();
        if (r113 == null) goto L36;
        IExternalConfigJudger r114 = r113.getValue();
        if (r114 == null) goto L36;
        boolean r115 = IExternalConfigJudger.DefaultImpls.canUse$default(r114, EXTERNAL_CONFIG_TYPE.Gesture, GestureAction.longPress, false, 4, null);
    L37:
        if (r115 != true) goto L50;
        RoomContext r116 = getDataContext();
        if (r116 == null) goto L45;
        n<IExternalConfigJudger> r117 = r116.getExternalConfigJudger();
        if (r117 == null) goto L45;
        IExternalConfigJudger r118 = r117.getValue();
        if (r118 == null) goto L45;
        boolean r119 = IExternalConfigJudger.DefaultImpls.canUse$default(r118, EXTERNAL_CONFIG_TYPE.Guide, GuideAction.longPressGuide, false, 4, null);
    L46:
        if (r119 != true) goto L51;
        f.b("show long press guide in 10 seconds");
        ((ObservableSubscribeProxy) Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new c(this));
        return;
    L51:
        return;
    L45:
        r119 = true;
        goto L46
    L50:
        return;
    L36:
        r115 = true;
        goto L37
    L49:
        return;
    L26:
        f.a("search plugin has not installed yet");
        goto L27
    }
}
