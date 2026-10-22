package com.bytedance.android.livesdk.interactivity.api;

import android.content.Context;
import android.os.Bundle;
import androidx.core.util.Consumer;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.model.v0;
import com.bytedance.android.livesdk.interactivity.api.comment.CommonInputParams;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.api.AICloneConvItem;
import com.bytedance.android.livesdk.interactivity.comment.CommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.MediaLandscapeCommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.VSLandscapeCommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.VSSpiltLandscapeCommentWidget;
import com.bytedance.android.livesdk.interactivity.comment.input.LiveCommonInputDialog;
import com.bytedance.android.livesdk.interactivity.comment.share.api.InteractivityShareApi;
import com.bytedance.android.livesdk.interactivity.service.model.ICommunityRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import com.ss.android.socialbase.downloader.exception.BaseException;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class CommentService implements ICommentService {

    public class a implements IJsMethodsProvideService.IFactory {
        public a() {
        }

        @Override // com.bytedance.android.livesdkapi.jsb.IJsMethodsProvideService.IFactory
        public final Map<String, n56.c> buildMethods(WeakReference<Context> r100, n56.a r101) {
            HashMap r102 = new HashMap();
            r102.put("crossplatformComment", new com.bytedance.android.livesdk.interactivity.comment.js.a());
            return r102;
        }
    }

    public class b implements e72.b.InterfaceC5750b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObservableEmitter f132746a;

        public b(ObservableEmitter r100) {
            this.f132746a = r100;
        }

        @Override // e72.b.InterfaceC5750b
        public final void onProgress(int r100) {
            this.f132746a.onNext(Integer.valueOf((r100 * 90) / 100));
        }

        @Override // e72.b.InterfaceC5750b
        public final void onSuccess(List<Pair<String, String>> r100) {
            this.f132746a.onComplete();
        }

        @Override // e72.b.InterfaceC5750b
        public final void a(List<Pair<String, String>> r100, BaseException r101) {
            if (r101 != null) goto L4;
            this.f132746a.onError(new RuntimeException("download failed."));
            return;
        L4:
            this.f132746a.onError(r101);
        }
    }

    public CommentService() {
    }

    public static /* synthetic */ void b(CommentService r100, List r101, ObservableEmitter r102) {
        r100.lambda$createDownloadTask$0(r101, r102);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public IJsMethodsProvideService.IFactory getCommentJsFactory() {
        return new a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public j70.h<d90.d> getHighlightRecordDescriptor() {
        return new com.bytedance.android.livesdk.interactivity.comment.record.view.f();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Class<? extends LiveRecyclableWidget> getCommentWidgetClass() {
        return CommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Class<? extends LiveRecyclableWidget> getMediaLandScapeCommentWidgetClass() {
        return MediaLandscapeCommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Class<? extends LiveRecyclableWidget> getVSLandscapeCommentWidgetClass() {
        return VSLandscapeCommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Class<? extends LiveRecyclableWidget> getVSSpiltLandscapeCommentWidgetClass() {
        return VSSpiltLandscapeCommentWidget.class;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public t22.c createCommonInputDialog(CommonInputParams r100) {
        int r101 = LiveCommonInputDialog.f135018p;
        Intrinsics.checkNotNullParameter(r100, "commonInputParams");
        LiveCommonInputDialog r102 = new LiveCommonInputDialog();
        Bundle r103 = new Bundle();
        r103.putParcelable("common_input_params", r100);
        Unit r104 = Unit.INSTANCE;
        r102.setArguments(r103);
        return r102;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Observable<Integer> createDownloadTask(final List<Pair<String, String>> r100) {
        return Observable.create(new com.bytedance.android.livesdk.interactivity.api.a(this, r100));
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public String getCacheFilePath(Context r100) {
        return e72.c.c(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Map<String, String> getLiveAnchorChooseButtonReportParam(String r100) {
        return ((IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class)).getLiveAnchorChooseButtonReportParam(r100);
    }

    private void lambda$createDownloadTask$0(List r100, ObservableEmitter r101) throws Exception {
        e72.b r102 = new e72.b(r100, new b(r101));
        if (r102.f471159a == true) goto L7;
        r102.f471159a = true;
        r102.a();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public Observable<Response<v0>> sendCommentChat(IRoom r110, String r111) {
        if (r110.castToOrNull(ICommunityRoom.class) != null) goto L5;
        String r100 = null;
    L7:
        return new g92.a(r110.getId(), r111, 0, r110.getRequestId(), r100, null, null).b(null, null, false);
    L5:
        r100 = ((ICommunityRoom) r110.castToOrNull(ICommunityRoom.class)).getLabels();
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public void startInteractivityShare(w22.a r100, Consumer<Boolean> r101) {
        int r102 = c72.c.f22639a;
        Intrinsics.checkNotNullParameter(r100, "shareContent");
        IRoomContextService r103 = (IRoomContextService) jc1.k.f(IRoomContextService.class);
        if (r103 == null) goto L12;
        com.bytedance.android.livesdk.chatroom.o r104 = IRoomContextService.a.a(r103, null, 0, 3);
        if (r104 == null) goto L13;
        com.bytedance.live.datacontext.m<IRoom> r105 = r104.getRoom();
        if (r105 == null) goto L14;
        IRoom r106 = r105.getValue();
        if (r106 == null) goto L15;
        long r107 = r106.getRoomId();
        com.bytedance.android.livesdk.interactivity.comment.share.model.b r108 = new com.bytedance.android.livesdk.interactivity.comment.share.model.b();
        r108.roomId = r107;
        r108.itemType = r100.f557988b;
        r108.itemId = r100.f557987a;
        r108.extra = r100.f557989c;
        r108.schema = r100.f557990d;
        InteractivityShareApi.f136224a.getClass();
        ((InteractivityShareApi) com.bytedance.android.live.network.c.b().e(InteractivityShareApi.class)).shareItem(r108.a()).compose(RxUtil.rxSchedulerHelper()).subscribe(new c72.a(r107, r100, r101), new c72.b(r101));
        return;
    L15:
        return;
    L14:
        return;
    L13:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public k22.b getAIEntranceManager(DataContext r100, DataCenter r101, List<AICloneConvItem> r102) {
        s62.a r103 = new s62.a(r100, r101);
        Intrinsics.checkNotNullParameter(r102, "list");
        r103.f540783e = r102;
        StringBuilder r104 = new StringBuilder("aiCloneList:");
        List<AICloneConvItem> r105 = r103.f540783e;
        if (r105 == null) goto L8;
        List<AICloneConvItem> r106 = r105;
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r106, 10));
        Iterator<T> r108 = r106.iterator();
    L6:
        if (r108.hasNext() == false) goto L9;
        r107.add(((AICloneConvItem) r108.next()).getConvItem());
    L9:
        r104.append(String.valueOf(r107));
        ALogger.i("AICloneTag", r104.toString());
        return r103;
    L8:
        r107 = null;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public void inputActivityEmoji(long r100, String r101, Map<String, String> r102) {
        q r103 = q.f133747a;
        com.bytedance.android.livesdk.interactivity.api.emoji.d r104 = null;
        h r105 = i.b(null, 3);
        if (r105 == null) goto L7;
        com.bytedance.live.datacontext.j<com.bytedance.android.livesdk.interactivity.api.emoji.d> r106 = r105.getActivityEmojiManager();
        if (r106 == null) goto L7;
        r104 = r106.getValue();
    L7:
        if (r104 == null) goto L10;
        r104.inputActivityEmoji(r100, r101, r102);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.ICommentService
    public void inputFusionEmoji(long r100, @Nullable String r101, String r102, Map<String, String> r103) {
        com.bytedance.android.livesdk.interactivity.api.emoji.e r104 = q.d();
        if (r104 == null) goto L6;
        r104.e(r100, r101, r102);
        return;
    }
}
