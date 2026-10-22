package com.bytedance.android.livesdk.interactivity.comment.record.viewmodel;

import am2.x;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.a0;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.interactivity.comment.highlight.MarkHighlightApi;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.j;
import com.bytedance.revenue.platform.api.core.rx.f;
import com.ss.android.ttvecamera.TECameraSettings;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 Q2\u00020\u00012\u00020\u0002:\u0001RB\u001b\u0012\b\u0010F\u001a\u0004\u0018\u00010E\u0012\b\u0010K\u001a\u0004\u0018\u00010J¢\u0006\u0004\bO\u0010PJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0010\u001a\u00020\u0005R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0018\u0010\u001a\u001a\u00060\u0018j\u0002`\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010$\u001a\u0004\b\n\u0010%R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\"R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010$\u001a\u0004\b(\u0010%R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\"R \u0010*\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010$\u001a\u0004\b+\u0010%R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010\"R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010$\u001a\u0004\b.\u0010%R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00030 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010\"R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030#8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b0\u0010%R\"\u00102\u001a\u0002018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u0002018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b8\u00103\u001a\u0004\b9\u00105\"\u0004\b:\u00107R(\u0010=\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010;8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001b\u0010D\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u00105R\u0019\u0010F\u001a\u0004\u0018\u00010E8\u0006¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001c\u0010K\u001a\u0004\u0018\u00010J8\u0016X\u0096\u0004¢\u0006\f\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N¨\u0006S"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/comment/record/viewmodel/HighlightRecordContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lz22/a;", "", "isStart", "", "notifyRecordReqStart", "isStop", "notifyRecordReqStop", "cancelRecord", "isRecording", "changeIsRecording", "sendRecordStartLog", "notifyClickRecordStopBtn", "release", "reqRecord", "tryCancelRecord", "", "tag", "Ljava/lang/String;", "", "STATUS_SECURITY_BAN", "I", "STATUS_ANCHOR_CLOSE", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/revenue/platform/api/core/rx/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/Disposable;", "statRecordReqDp", "Lio/reactivex/disposables/Disposable;", "stopRecordReqDp", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "_isRecording", "Lcom/bytedance/android/live/core/arch/mvvm/PropertyOwner;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "Lcom/bytedance/android/live/core/arch/mvvm/d;", "()Lcom/bytedance/android/live/core/arch/mvvm/d;", "_clickRecordStopBtn", "clickRecordStopBtn", "getClickRecordStopBtn", "_recordReqStart", "recordReqStart", "getRecordReqStart", "_recordReqStop", "recordReqStop", "getRecordReqStop", "_cancelRecord", "getCancelRecord", "", "startRecordTimeMs", "J", "getStartRecordTimeMs", "()J", "setStartRecordTimeMs", "(J)V", "endRecordTimeMs", "getEndRecordTimeMs", "setEndRecordTimeMs", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/d;", "<set-?>", "recordResponse", "Lcom/bytedance/android/livesdk/interactivity/comment/highlight/d;", "getRecordResponse", "()Lcom/bytedance/android/livesdk/interactivity/comment/highlight/d;", "roomId$delegate", "Lkotlin/Lazy;", "getRoomId", "roomId", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "getDataCenter", "()Lcom/bytedance/ies/sdk/widgets/DataCenter;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;Lcom/bytedance/ies/sdk/widgets/DataCenter;)V", "Companion", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HighlightRecordContext extends DataContext implements z22.a {
    public static final b Companion = null;
    private final int STATUS_ANCHOR_CLOSE;
    private final int STATUS_SECURITY_BAN;
    private final PropertyOwner<Boolean> _cancelRecord;
    private final PropertyOwner<Boolean> _clickRecordStopBtn;
    private final PropertyOwner<Boolean> _isRecording;
    private final PropertyOwner<Boolean> _recordReqStart;
    private final PropertyOwner<Boolean> _recordReqStop;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> cancelRecord;

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f136216cd;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> clickRecordStopBtn;
    private final DataCenter dataCenter;
    private long endRecordTimeMs;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> isRecording;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> recordReqStart;
    private final com.bytedance.android.live.core.arch.mvvm.d<Boolean> recordReqStop;
    private com.bytedance.android.livesdk.interactivity.comment.highlight.d recordResponse;
    private final MiddlewareRoomContext roomContext;
    private final Lazy roomId$delegate;
    private long startRecordTimeMs;
    private Disposable statRecordReqDp;
    private Disposable stopRecordReqDp;
    private final String tag;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HighlightRecordContext f136217a;

        public a(HighlightRecordContext r100) {
            this.f136217a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            this.f136217a.release();
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static HighlightRecordContext a(MiddlewareRoomContext r100, DataCenter r101) {
            ViewModel r102 = null;
            if (r100 == null) goto L8;
            j<ViewModel> r103 = r100.getHighlightRecordContext();
            if (r103 == null) goto L8;
            ViewModel r104 = r103.getValue();
            if (r104 == null) goto L8;
        L15:
            if ((r104 instanceof HighlightRecordContext) == false) goto L19;
            r102 = r104;
        L19:
            return (HighlightRecordContext) r102;
        L8:
            MiddlewareRoomContext r105 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, r101, 0, 2);
            if (r105 == null) goto L13;
            j<ViewModel> r106 = r105.getHighlightRecordContext();
            if (r106 == null) goto L13;
            r104 = r106.getValue();
        L13:
            r104 = null;
            goto L15
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HighlightRecordContext f136218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f136219b;

        public c(HighlightRecordContext r100, boolean r101) {
            this.f136218a = r100;
            this.f136219b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            com.bytedance.android.livesdk.interactivity.comment.highlight.d r111 = (com.bytedance.android.livesdk.interactivity.comment.highlight.d) ((Response) r110).data;
            HighlightRecordContext.access$setRecordResponse$p(this.f136218a, r111);
            if (this.f136219b == false) goto L5;
            HighlightRecordContext.access$notifyRecordReqStart(this.f136218a, true);
            HighlightRecordContext.access$sendRecordStartLog(this.f136218a);
            return;
        L5:
            if (r111 == null) goto L28;
            com.bytedance.android.livesdk.interactivity.comment.highlight.b r112 = r111.a();
            if (r112 == null) goto L28;
            Long r100 = r112.g();
            boolean r101 = false;
            Long r102 = null;
            if (r100 != null) goto L11;
        L19:
            Long r113 = r112.d();
            if (r113 == null) goto L28;
            if (r113.longValue() <= 0) goto L24;
            r101 = true;
        L24:
            if (r101 == false) goto L26;
            r102 = r113;
        L26:
            if (r102 == null) goto L28;
            this.f136218a.setEndRecordTimeMs(r102.longValue() * 1000);
            goto L28
        L11:
            if (r100.longValue() <= 0) goto L13;
            boolean r103 = true;
        L14:
            if (r103 == true) goto L17;
            r100 = null;
        L17:
            if (r100 == null) goto L19;
            this.f136218a.setStartRecordTimeMs(r100.longValue() * 1000);
            goto L19
        L13:
            r103 = false;
        L28:
            HighlightRecordContext.access$notifyRecordReqStop(this.f136218a, true);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ HighlightRecordContext f136220a;

        public d(HighlightRecordContext r100) {
            this.f136220a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            HighlightRecordContext.access$changeIsRecording(this.f136220a, false);
            if ((r101 instanceof ApiServerException) == true) goto L5;
            Throwable r102 = null;
        L6:
            ApiServerException r103 = (ApiServerException) r102;
            if (r103 == null) goto L9;
            int r104 = r103.getErrorCode();
        L11:
            if (r104 != HighlightRecordContext.access$getSTATUS_SECURITY_BAN$p(this.f136220a)) goto L13;
        L16:
            if (r103 == null) goto L19;
            String r105 = r103.getPrompt();
            if (r105 == null) goto L19;
        L20:
            f2.c(r105, 0);
        L21:
            ALogger.e(HighlightRecordContext.access$getTag$p(this.f136220a), TECameraSettings.PictureCallback.ERROR_CODE_SPLIT_REGEX + r104, r101);
            return;
        L19:
            r105 = "该直播不支持录屏沉淀";
            goto L20
        L13:
            if (r104 == HighlightRecordContext.access$getSTATUS_ANCHOR_CLOSE$p(this.f136220a)) goto L16;
            f2.c("录制失败", 0);
            goto L21
        L9:
            r104 = 0;
            goto L11
        L5:
            r102 = r101;
            goto L6
        }
    }

    static {
        Companion = new b();
    }

    private final void cancelRecord() {
        changeIsRecording(false);
        this._cancelRecord.a(Boolean.TRUE);
    }

    private final long getRoomId() {
        return ((Number) this.roomId$delegate.getValue()).longValue();
    }

    @JvmStatic
    public static final HighlightRecordContext getShared(MiddlewareRoomContext r100, DataCenter r101) {
        Companion.getClass();
        return b.a(r100, r101);
    }

    public void notifyClickRecordStopBtn() {
        this._clickRecordStopBtn.a(Boolean.TRUE);
    }

    public void release() {
        Disposable r100 = this.statRecordReqDp;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Disposable r101 = this.stopRecordReqDp;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        setStartRecordTimeMs(0);
        setEndRecordTimeMs(0);
        this.recordResponse = null;
        changeIsRecording(false);
        this.f136216cd.clear();
    }

    private final void sendRecordStartLog() {
        j0 r100 = j0.l();
        Pair[] r101 = new Pair[4];
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r102 = this.recordResponse;
        String r103 = null;
        if (r102 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r104 = r102.a();
        if (r104 == null) goto L7;
        String r105 = String.valueOf(r104.e());
    L8:
        r101[0] = TuplesKt.to("highlights_content_id", r105);
        DataCenter r106 = getDataCenter();
        if (r106 == null) goto L15;
        IRoom r107 = a0.n(r106);
        if (r107 == null) goto L15;
        IBaseUser r108 = r107.getOwner();
        if (r108 == null) goto L15;
        r103 = r108.getIdString();
    L15:
        r101[1] = TuplesKt.to("anchor_id", String.valueOf(r103));
        r101[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, "record");
        r101[3] = TuplesKt.to("module_name", "comment_highlight_choose");
        r100.sendLog("livesdk_comment_highlight_record_click", MapsKt.mapOf(r101), new Object[]{IRoom.class, x.class});
        return;
    L7:
        r105 = null;
        goto L8
    }

    /* JADX INFO: renamed from: isRecording, reason: collision with other method in class */
    public boolean m8240isRecording() {
        return isRecording().getValue().booleanValue();
    }

    public final void tryCancelRecord() {
        if (m8240isRecording() == true) goto L5;
        return;
    L5:
        release();
        cancelRecord();
    }

    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> getCancelRecord() {
        return this.cancelRecord;
    }

    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> getClickRecordStopBtn() {
        return this.clickRecordStopBtn;
    }

    public DataCenter getDataCenter() {
        return this.dataCenter;
    }

    public long getEndRecordTimeMs() {
        return this.endRecordTimeMs;
    }

    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> getRecordReqStart() {
        return this.recordReqStart;
    }

    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> getRecordReqStop() {
        return this.recordReqStop;
    }

    public final com.bytedance.android.livesdk.interactivity.comment.highlight.d getRecordResponse() {
        return this.recordResponse;
    }

    public final MiddlewareRoomContext getRoomContext() {
        return this.roomContext;
    }

    public long getStartRecordTimeMs() {
        return this.startRecordTimeMs;
    }

    @Override // z22.a
    public com.bytedance.android.live.core.arch.mvvm.d<Boolean> isRecording() {
        return this.isRecording;
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.highlight.d access$getRecordResponse$p(HighlightRecordContext r100) {
        return r100.recordResponse;
    }

    public static final /* synthetic */ int access$getSTATUS_ANCHOR_CLOSE$p(HighlightRecordContext r100) {
        return r100.STATUS_ANCHOR_CLOSE;
    }

    public static final /* synthetic */ int access$getSTATUS_SECURITY_BAN$p(HighlightRecordContext r100) {
        return r100.STATUS_SECURITY_BAN;
    }

    public static final /* synthetic */ String access$getTag$p(HighlightRecordContext r100) {
        return r100.tag;
    }

    public static final /* synthetic */ void access$sendRecordStartLog(HighlightRecordContext r100) {
        r100.sendRecordStartLog();
    }

    private final void changeIsRecording(boolean r100) {
        this._isRecording.a(Boolean.valueOf(r100));
    }

    private final void notifyRecordReqStart(boolean r100) {
        this._recordReqStart.a(Boolean.valueOf(r100));
        changeIsRecording(true);
    }

    private final void notifyRecordReqStop(boolean r100) {
        changeIsRecording(false);
        this._recordReqStop.a(Boolean.valueOf(r100));
    }

    public final void reqRecord(boolean r110) {
        if (r110 == false) goto L11;
        if (m8240isRecording() == false) goto L7;
        ALogger.i(this.tag, "reqRecord,start record fail, now is recording");
        return;
    L7:
        Disposable r100 = this.statRecordReqDp;
        if (r100 == null) goto L17;
        r100.dispose();
    L17:
        if (r110 == false) goto L19;
        long r101 = 1;
    L20:
        long r111 = r101;
        long r102 = p6.b();
        long r103 = 0;
        if (r110 == false) goto L23;
        setStartRecordTimeMs(r102);
        long r104 = 0;
    L30:
        MarkHighlightApi.f134994a.getClass();
        MarkHighlightApi r105 = (MarkHighlightApi) com.bytedance.android.live.network.c.b().e(MarkHighlightApi.class);
        if (r105 == null) goto L46;
        long r106 = getRoomId();
        long r107 = r102 / ((long) 1000);
        DataCenter r108 = getDataCenter();
        if (r108 == null) goto L41;
        Room r109 = z.o(r108);
        if (r109 == null) goto L41;
        String r112 = r109.getAnchorId();
        if (r112 == null) goto L41;
        Long r113 = StringsKt.toLongOrNull(r112);
        if (r113 == null) goto L41;
        r103 = r113.longValue();
    L41:
        Observable<Response<com.bytedance.android.livesdk.interactivity.comment.highlight.d>> r114 = r105.startScreenRecordRequest(r106, r107, r103, r104, r111);
        if (r114 == null) goto L46;
        Observable r115 = RxUtilKt.h(r114);
        if (r115 == null) goto L46;
        Disposable r116 = r115.subscribe(new c(this, r110), new d(this));
    L47:
        if (r110 == false) goto L49;
        this.statRecordReqDp = r116;
        return;
    L49:
        this.stopRecordReqDp = r116;
        return;
    L46:
        r116 = null;
        goto L47
    L23:
        setEndRecordTimeMs(r102);
        com.bytedance.android.livesdk.interactivity.comment.highlight.d r117 = this.recordResponse;
        if (r117 == null) goto L28;
        com.bytedance.android.livesdk.interactivity.comment.highlight.b r118 = r117.a();
        if (r118 == null) goto L28;
        long r119 = r118.e();
    L29:
        r104 = r119;
    L28:
        r119 = 0;
        goto L29
    L19:
        r101 = 2;
        goto L20
    L11:
        if (m8240isRecording() == true) goto L14;
        ALogger.i(this.tag, "reqRecord: stop record fail, now is not recording");
        return;
    L14:
        Disposable r120 = this.stopRecordReqDp;
        if (r120 == null) goto L17;
        r120.dispose();
        goto L17
    }

    public void setEndRecordTimeMs(long r100) {
        this.endRecordTimeMs = r100;
    }

    public void setStartRecordTimeMs(long r100) {
        this.startRecordTimeMs = r100;
    }

    public HighlightRecordContext(MiddlewareRoomContext r100, DataCenter r101) {
        this.roomContext = r100;
        this.dataCenter = r101;
        this.tag = "HighlightRecordContext";
        this.STATUS_SECURITY_BAN = 4011137;
        this.STATUS_ANCHOR_CLOSE = 4003220;
        CompositeDisposable r102 = new CompositeDisposable();
        this.f136216cd = r102;
        Boolean r103 = Boolean.FALSE;
        PropertyOwner<Boolean> r104 = new PropertyOwner(r103);
        this._isRecording = r104;
        this.isRecording = r104;
        PropertyOwner<Boolean> r105 = new PropertyOwner(r103);
        this._clickRecordStopBtn = r105;
        this.clickRecordStopBtn = r105;
        PropertyOwner<Boolean> r106 = new PropertyOwner(r103);
        this._recordReqStart = r106;
        this.recordReqStart = r106;
        PropertyOwner<Boolean> r107 = new PropertyOwner(r103);
        this._recordReqStop = r107;
        this.recordReqStop = r107;
        PropertyOwner<Boolean> r108 = new PropertyOwner(r103);
        this._cancelRecord = r108;
        this.cancelRecord = r108;
        this.roomId$delegate = LazyKt.lazy(new HighlightRecordContext$roomId$2(this));
        f.a(getOnCleared().subscribe(new a(this)), r102);
    }

    public static final /* synthetic */ void access$changeIsRecording(HighlightRecordContext r100, boolean r101) {
        r100.changeIsRecording(r101);
    }

    public static final /* synthetic */ void access$notifyRecordReqStart(HighlightRecordContext r100, boolean r101) {
        r100.notifyRecordReqStart(r101);
    }

    public static final /* synthetic */ void access$notifyRecordReqStop(HighlightRecordContext r100, boolean r101) {
        r100.notifyRecordReqStop(r101);
    }

    public static final /* synthetic */ void access$setRecordResponse$p(HighlightRecordContext r100, com.bytedance.android.livesdk.interactivity.comment.highlight.d r101) {
        r100.recordResponse = r101;
    }
}
