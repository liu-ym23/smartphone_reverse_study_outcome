package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import am2.x;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.model.LiveRequestSourceRole;
import com.bytedance.android.live.room.api.record.LiveScreenRecordGuideConfig;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness;
import com.bytedance.android.livehostapi.business.depend.highlight.PublishHighlightVideoData;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.comment.newinput.view.HighlightPreviewDialog;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.SaveVideoHandler$saveVideo$1;
import com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.p;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010L\u001a\u00020K\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bU\u0010VJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002J\u0006\u0010\u000e\u001a\u00020\u0006J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0004J\u0006\u0010\u0014\u001a\u00020\u0004J\u0006\u0010\u0015\u001a\u00020\u0004J\u0006\u0010\u0016\u001a\u00020\u0004R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\u00020\u001a8\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010(\u001a\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00104\u001a\u0002038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R$\u00107\u001a\u00020\u00062\u0006\u00106\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b7\u00109R!\u0010@\u001a\b\u0012\u0004\u0012\u00020;0:8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020D8\u0006¢\u0006\f\n\u0004\b\u0005\u0010E\u001a\u0004\bF\u0010GR\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00060A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bH\u0010CR\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00060D8\u0006¢\u0006\f\n\u0004\bI\u0010E\u001a\u0004\bJ\u0010GR\u0017\u0010L\u001a\u00020K8\u0006¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bN\u0010OR\u0017\u0010Q\u001a\u00020P8\u0006¢\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010T¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/RecordGuideContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/CloseDialogSource;", "source", "", "closeGuideDialog", "", "show", "notifyPublishLoadingShow", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordMetaData;", "metaData", "gotoPublish", ITTVideoEngineEventSource.KEY_MUTE, "mutePlayerClient", "isPublishLoading", "release", "onDialogCreate", "onDialogClose", "clickClose", "saveDraft", "openPreviewDialog", "saveVideo", "publish", "", "tag", "Ljava/lang/String;", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "highlightData", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "getHighlightData", "()Lcom/bytedance/android/livesdk/interactivity/comment/highlight/b;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dc", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDc", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/d;", "downloadHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/d;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/m;", "saveDraftHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/m;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/e;", "previewVideoHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/e;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/h;", "publishHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/h;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/p;", "saveVideoHandler", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/handler/p;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "<set-?>", "isReleased", "Z", "()Z", "", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/c;", "bizHandlers$delegate", "Lkotlin/Lazy;", "getBizHandlers", "()Ljava/util/List;", "bizHandlers", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "_closeGuideDialog", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "getCloseGuideDialog", "()Lcom/bytedance/android/live/core/arch/mvvm/d;", "_publishLoadingShow", "publishLoadingShow", "getPublishLoadingShow", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/n;", "info", "Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/n;", "getInfo", "()Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/n;", "<init>", "(Landroid/content/Context;Lcom/bytedance/android/livesdk/interactivity/comment/record/guide/n;)V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordGuideContext extends DataContext {
    private final PropertyOwner<CloseDialogSource> _closeGuideDialog;
    private final PropertyOwner<Boolean> _publishLoadingShow;
    private final Lazy bizHandlers$delegate;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f136112cd;
    private final com.bytedance.android.live.core.arch.mvvm.d<CloseDialogSource> closeGuideDialog;
    private final Context context;

    /* JADX INFO: renamed from: dc, reason: collision with root package name */
    private final DataCenter f136113dc;
    private final com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.d downloadHandler;
    private final com.bytedance.android.livesdk.interactivity.comment.highlight.b highlightData;
    private final n info;
    private boolean isReleased;
    private final com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e previewVideoHandler;
    private final com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.h publishHandler;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> publishLoadingShow;
    private final com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.m saveDraftHandler;
    private final p saveVideoHandler;
    private final String tag;

    public static final class a implements IMiddlewareHostBusiness.OnLiveHighlightPublish {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ILiveRecordService.RecordMetaData f136115b;

        @Override // com.bytedance.android.livehostapi.business.IMiddlewareHostBusiness.OnLiveHighlightPublish
        public final void onPublish(int r100) {
            if (r100 != 1) goto L6;
            f2.c("发布失败", 0);
        L6:
            String r101 = this.f136115b.getNewFile();
            if (r101 != null) goto L9;
        L14:
            RecordGuideContext.access$mutePlayerClient(this.f136114a, false);
            this.f136114a.release();
            return;
        L9:
            if (r2.a(r101) == true) goto L12;
            r101 = null;
        L12:
            if (r101 == null) goto L14;
            z22.c.b(r101);
            goto L14
        }

        public a(RecordGuideContext r100, ILiveRecordService.RecordMetaData r101) {
            this.f136114a = r100;
            this.f136115b = r101;
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136116a;

        public b(RecordGuideContext r100) {
            this.f136116a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            RecordGuideContext.access$notifyPublishLoadingShow(this.f136116a, true);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136117a;

        public c(RecordGuideContext r100) {
            this.f136117a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            RecordGuideContext.access$notifyPublishLoadingShow(this.f136117a, false);
            RecordGuideContext.access$closeGuideDialog(this.f136117a, CloseDialogSource.Publish);
            RecordGuideContext r101 = this.f136117a;
            RecordGuideContext.access$gotoPublish(r101, (ILiveRecordService.RecordMetaData) r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136118a;

        public d(RecordGuideContext r100) {
            this.f136118a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            RecordGuideContext.access$notifyPublishLoadingShow(this.f136118a, false);
            f2.c("发布失败", 0);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136119a;

        public e(RecordGuideContext r100) {
            this.f136119a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            RecordGuideContext.access$closeGuideDialog(this.f136119a, CloseDialogSource.SaveDraft);
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f136120a = null;

        static {
            f136120a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            if (((Boolean) r100).booleanValue() == false) goto L5;
            f2.c("已保存至草稿", 0);
            return;
        L5:
            f2.c("保存失败", 0);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f136121a = null;

        static {
            f136121a = new g();
        }

        public g() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            f2.c("保存失败", 0);
        }
    }

    public static final class h implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136122a;

        public h(RecordGuideContext r100) {
            this.f136122a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f136122a.release();
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136123a;

        public i(RecordGuideContext r100) {
            this.f136123a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Disposable r101 = (Disposable) r100;
            RecordGuideContext.access$closeGuideDialog(this.f136123a, CloseDialogSource.SaveLocal);
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136124a;

        public j(RecordGuideContext r100) {
            this.f136124a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Uri r101 = (Uri) r100;
            String r102 = r101.getPath();
            if (r102 != null) goto L5;
        L10:
            f2.c("保存失败", 0);
            Unit r103 = Unit.INSTANCE;
            return;
        L5:
            if (r2.a(r102) == true) goto L8;
            r102 = null;
        L8:
            if (r102 == null) goto L10;
            f2.c("下载成功至相册查看", 0);
            this.f136124a.getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r101));
        }
    }

    public static final class k<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecordGuideContext f136125a;

        public k(RecordGuideContext r100) {
            this.f136125a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            f2.c("保存失败", 0);
            this.f136125a.release();
        }
    }

    private final List<com.bytedance.android.livesdk.interactivity.comment.record.guide.c> getBizHandlers() {
        return (List) this.bizHandlers$delegate.getValue();
    }

    public final boolean isPublishLoading() {
        return this._publishLoadingShow.f64752a.booleanValue();
    }

    public final void release() {
        if (this.isReleased == false) goto L5;
        return;
    L5:
        this.isReleased = true;
        Iterator<T> r100 = getBizHandlers().iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((com.bytedance.android.livesdk.interactivity.comment.record.guide.c) r100.next()).b();
        goto L7
    L9:
        this.f136112cd.clear();
    }

    public final void clickClose() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return click close");
        return;
    L6:
        closeGuideDialog(CloseDialogSource.ClickBack);
        release();
    }

    public final void onDialogClose() {
        Iterator<T> r100 = getBizHandlers().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.comment.record.guide.c) r100.next()).onDialogDismiss();
        goto L4
    }

    public final void onDialogCreate() {
        Iterator<T> r100 = getBizHandlers().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.interactivity.comment.record.guide.c) r100.next()).a(this);
        goto L4
    }

    public final void openPreviewDialog() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return openPreviewDialog");
        return;
    L6:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e r100 = this.previewVideoHandler;
        n r101 = this.info;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "info");
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r102 = r101.f136184c;
        DataCenter r103 = r101.f136183b;
        if (r100.f136157b != null) goto L55;
        String r104 = r102.f();
        if (r104 != null) goto L12;
    L15:
        boolean r105 = true;
    L16:
        if (r105 == false) goto L18;
        f2.c("预览失败", 0);
        return;
    L18:
        String r106 = "";
        if (r103 == null) goto L26;
        Room r107 = z.o(r103);
        if (r107 == null) goto L26;
        User r108 = r107.mo8271getOwner();
        if (r108 == null) goto L26;
        String r109 = r108.getNickName();
        if (r109 == null) goto L26;
    L27:
        if (r103 == null) goto L34;
        IRoom r110 = a0.n(r103);
        if (r110 == null) goto L34;
        IBaseUser r111 = r110.getOwner();
        if (r111 == null) goto L34;
        String r112 = r111.getIdString();
        if (r112 == null) goto L34;
    L35:
        String r113 = "@".concat(r109);
        String r114 = "#" + r102.b();
        String r115 = r102.f();
        if (r115 == null) goto L39;
        r106 = r115;
    L39:
        zf1.h r116 = new zf1.h(r113, r114, r106);
        FragmentActivity r117 = ContextUtil.contextToFragmentActivity(r101.getContext());
        if ((r117 instanceof FragmentActivity) == true) goto L42;
        r117 = null;
    L42:
        if (r117 == null) goto L54;
        int r118 = HighlightPreviewDialog.f136080h;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e.a r119 = r100.f136158c;
        HighlightPreviewDialog r120 = new HighlightPreviewDialog();
        r120.f136083f = r116;
        r120.f136084g = r119;
        r100.f136157b = r120;
        FragmentManager r121 = r117.getSupportFragmentManager();
        LandscapeRestrictionOperation r122 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r120, "HighlightPreviewDialog", r122);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r121, r120, r122) == false) goto L51;
    L48:
        j0.l().sendLog("livesdk_comment_highlight_content_play", MapsKt.mapOf(new Pair[]{TuplesKt.to("highlights_content_id", String.valueOf(r102.e())), TuplesKt.to("anchor_id", r112), TuplesKt.to("tag_name", r102.b())}), new Object[]{IRoom.class, x.class});
        return;
    L51:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L50
    L47:
        r120.show(r121, "HighlightPreviewDialog");
        goto L48
    L54:
        return;
    L34:
        r112 = "";
    L26:
        r109 = "";
        goto L27
    L12:
        if (r104.length() == 0) goto L15;
        r105 = false;
        goto L16
    }

    public final void publish() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return publish");
        return;
    L6:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.h r100 = this.publishHandler;
        n r101 = this.info;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "info");
        Observable r102 = Observable.just(r101).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.f(r100, r101)).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.g(r101));
        if (r102 == null) goto L16;
        Observable r103 = RxUtilKt.h(r102);
        if (r103 == null) goto L17;
        Observable r104 = r103.doOnSubscribe(new b(this));
        if (r104 == null) goto L18;
        Disposable r105 = r104.subscribe(new c(this), new d(this));
        if (r105 == null) goto L19;
        RxUtilKt.c(r105, this.f136112cd);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void saveDraft() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return saveDraft");
        return;
    L6:
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.m r100 = this.saveDraftHandler;
        Context r101 = this.context;
        n r102 = this.info;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "info");
        Observable r103 = Observable.just(r102).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.i(r100, r102)).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.j(r102)).flatMap(new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.l(r102, r101));
        if (r103 == null) goto L16;
        Observable r104 = RxUtilKt.h(r103);
        if (r104 == null) goto L17;
        Observable r105 = r104.doOnSubscribe(new e(this));
        if (r105 == null) goto L18;
        Disposable r106 = r105.subscribe(f.f136120a, g.f136121a, new h(this));
        if (r106 == null) goto L19;
        RxUtilKt.c(r106, this.f136112cd);
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public final void saveVideo() {
        if (isPublishLoading() == false) goto L6;
        ALogger.i(this.tag, "publish loading, return saveVideo");
        return;
    L6:
        p r100 = this.saveVideoHandler;
        n r101 = this.info;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "info");
        RxUtilKt.c(RxUtilKt.h(Observable.create(new SaveVideoHandler$saveVideo$1(r100, r101))).doOnSubscribe(new i(this)).subscribe(new j(this), new k(this)), this.f136112cd);
    }

    public final com.bytedance.android.live.core.arch.mvvm.d<CloseDialogSource> getCloseGuideDialog() {
        return this.closeGuideDialog;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DataCenter getDc() {
        return this.f136113dc;
    }

    public final com.bytedance.android.livesdk.interactivity.comment.highlight.b getHighlightData() {
        return this.highlightData;
    }

    public final n getInfo() {
        return this.info;
    }

    public final com.bytedance.android.live.core.arch.mvvm.d<Boolean> getPublishLoadingShow() {
        return this.publishLoadingShow;
    }

    public final boolean isReleased() {
        return this.isReleased;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.d access$getDownloadHandler$p(RecordGuideContext r100) {
        return r100.downloadHandler;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e access$getPreviewVideoHandler$p(RecordGuideContext r100) {
        return r100.previewVideoHandler;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.h access$getPublishHandler$p(RecordGuideContext r100) {
        return r100.publishHandler;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.m access$getSaveDraftHandler$p(RecordGuideContext r100) {
        return r100.saveDraftHandler;
    }

    public static final /* synthetic */ p access$getSaveVideoHandler$p(RecordGuideContext r100) {
        return r100.saveVideoHandler;
    }

    private final void closeGuideDialog(CloseDialogSource r100) {
        this._closeGuideDialog.a(r100);
    }

    private final void gotoPublish(ILiveRecordService.RecordMetaData r110) {
        Activity r100 = ContextUtil.contextToActivity(this.context);
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = r110.getNewFile();
        if (r101 != null) goto L8;
        r101 = r110.getOriginFile();
    L8:
        String r102 = r101;
        DataCenter r103 = this.info.f136183b;
        String r104 = null;
        if (r103 == null) goto L11;
        Room r105 = z.o(r103);
    L12:
        if (r105 == null) goto L16;
        User r106 = r105.mo8271getOwner();
        if (r106 == null) goto L16;
        String r107 = r106.getNickName();
    L17:
        String r108 = String.valueOf(r107);
        String r109 = this.info.f136184c.b();
        if (r109 != null) goto L20;
    L27:
        r109 = r108.concat("的高光瞬间");
    L28:
        String r111 = r109;
        if (r105 == null) goto L31;
        String r112 = r105.getAnchorId();
    L32:
        String r113 = String.valueOf(r112);
        if (r105 == null) goto L35;
        String r114 = r105.getIdStr();
    L36:
        String r115 = String.valueOf(r114);
        String r116 = String.valueOf(this.info.f136184c.e());
        IMiddlewareUserService r117 = (IMiddlewareUserService) jc1.k.f(IMiddlewareUserService.class);
        if (r117 == null) goto L43;
        com.bytedance.android.livesdk.user.e r118 = r117.user();
        if (r118 == null) goto L43;
        IBaseUser r119 = r118.b();
        if (r119 == null) goto L43;
        r104 = r119.getIdString();
    L43:
        PublishHighlightVideoData r120 = new PublishHighlightVideoData(r102, r100, "active_publish", "live_detail", r113, r108, r116, r115, String.valueOf(r104), r111, "", new a(this, r110));
        r120.setHighlightsContentType("active_publish");
        mutePlayerClient(true);
        IMiddlewareHostBusiness r121 = (IMiddlewareHostBusiness) jc1.k.f(IMiddlewareHostBusiness.class);
        if (r121 == null) goto L47;
        r121.openEditAndPublishPage(r120);
        return;
    L47:
        return;
    L35:
        r114 = null;
        goto L36
    L31:
        r112 = null;
        goto L32
    L20:
        if (r109.length() <= 0) goto L22;
        boolean r122 = true;
    L23:
        if (r122 == true) goto L26;
        r109 = null;
    L26:
        if (r109 != null) goto L28;
    L22:
        r122 = false;
    L16:
        r107 = null;
        goto L17
    L11:
        r105 = null;
        goto L12
    }

    private final void mutePlayerClient(boolean r100) {
        if (r100 == false) goto L6;
        IInteractivityInjectService r101 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r101 == null) goto L9;
        r101.muteLivePlayerClient();
    L9:
        LiveScreenRecordGuideConfig.f99094c.getClass();
        if (((Boolean) LiveScreenRecordGuideConfig.f99093b.getValue()).booleanValue() == true) goto L12;
        return;
    L12:
        if (hd0.c.f().h() == true) goto L14;
        return;
    L14:
        if (r100 == false) goto L20;
        IPushStreamService r102 = (IPushStreamService) jc1.k.f(IPushStreamService.class);
        if (r102 == null) goto L28;
        com.bytedance.android.live.pushstream.d r103 = r102.getPushLiveStream();
        if (r103 == null) goto L29;
        r103.J0(LiveCommonConstants.REASON_COMMENT_HIGHLIGHT_RECORD_PUBLISH, new uv0.a(LiveRequestSourceRole.Business, "RecordGuideContext.mutePlayerClient", null));
        return;
    L29:
        return;
    L28:
        return;
    L20:
        IPushStreamService r104 = (IPushStreamService) jc1.k.f(IPushStreamService.class);
        if (r104 == null) goto L31;
        com.bytedance.android.live.pushstream.d r105 = r104.getPushLiveStream();
        if (r105 == null) goto L32;
        r105.q1(LiveCommonConstants.REASON_COMMENT_HIGHLIGHT_RECORD_PUBLISH, new uv0.a(LiveRequestSourceRole.Business, "RecordGuideContext.mutePlayerClient", null));
        return;
    L32:
        return;
    L31:
        return;
    L6:
        IInteractivityInjectService r106 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r106 == null) goto L9;
        r106.unmuteLivePlayerClient();
        goto L9
    }

    private final void notifyPublishLoadingShow(boolean r100) {
        this._publishLoadingShow.a(Boolean.valueOf(r100));
    }

    public RecordGuideContext(Context r100, n r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "info");
        this.context = r100;
        this.info = r101;
        this.tag = "RecordGuideContext";
        this.highlightData = r101.f136184c;
        this.f136113dc = r101.f136183b;
        com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.d r102 = new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.d();
        this.downloadHandler = r102;
        this.saveDraftHandler = new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.m(r102);
        this.previewVideoHandler = new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.e();
        this.publishHandler = new com.bytedance.android.livesdk.interactivity.comment.record.guide.handler.h(r102);
        this.saveVideoHandler = new p(r102);
        this.f136112cd = new CompositeDisposable();
        this.bizHandlers$delegate = LazyKt.lazy(new RecordGuideContext$bizHandlers$2(this));
        PropertyOwner<CloseDialogSource> r103 = new PropertyOwner(CloseDialogSource.Default);
        this._closeGuideDialog = r103;
        this.closeGuideDialog = r103;
        PropertyOwner<Boolean> r104 = new PropertyOwner(Boolean.FALSE);
        this._publishLoadingShow = r104;
        this.publishLoadingShow = r104;
    }

    public static final /* synthetic */ void access$closeGuideDialog(RecordGuideContext r100, CloseDialogSource r101) {
        r100.closeGuideDialog(r101);
    }

    public static final /* synthetic */ void access$gotoPublish(RecordGuideContext r100, ILiveRecordService.RecordMetaData r101) {
        r100.gotoPublish(r101);
    }

    public static final /* synthetic */ void access$mutePlayerClient(RecordGuideContext r100, boolean r101) {
        r100.mutePlayerClient(r101);
    }

    public static final /* synthetic */ void access$notifyPublishLoadingShow(RecordGuideContext r100, boolean r101) {
        r100.notifyPublishLoadingShow(r101);
    }
}
