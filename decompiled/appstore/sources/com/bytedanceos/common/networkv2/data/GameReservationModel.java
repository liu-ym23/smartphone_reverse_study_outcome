package com.bytedanceos.common.networkv2.data;

import android.annotation.TargetApi;
import com.bytedanceos.common.core.ui.presenter.IView;
import com.bytedanceos.common.model.gameReservation.CategoryReservation;
import com.bytedanceos.common.model.gameReservation.GameReservationData;
import com.bytedanceos.common.model.gameReservation.MyReserveApp;
import com.bytedanceos.common.model.gameReservation.NoReservation;
import com.bytedanceos.common.networkv2.entity.ManagerSubListEntity;
import com.bytedanceos.common.networkv2.entity.MySubListEntity;
import com.bytedanceos.common.networkv2.entity.SubAppEntity;
import com.bytedanceos.common.networkv2.entity.SubGroupAppEntity;
import com.bytedanceos.common.networkv2.rest.AppStoreV15Rest;
import com.bytedanceos.common.networkv2.rest.AppStoreV16Rest;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.toolbox.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(11)
public class GameReservationModel {
    private CountDownLatch mCountDownLatch;
    private ArrayList<GameReservationData> mMyReservedGames;
    private ArrayList<GameReservationData> mRecommendGames;
    private RecommmendGameSciber mRecommmendGameSciber;
    private MySubSciber mReservedGameSciber;
    private AtomicBoolean mRquestResult;
    private IView<Boolean, ArrayList<GameReservationData>> mView;

    /* JADX INFO: renamed from: com.bytedanceos.common.networkv2.data.GameReservationModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class MySubSciber extends NSubscriber<MySubListEntity> {
        final /* synthetic */ GameReservationModel this$0;

        private MySubSciber(GameReservationModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            GameReservationModel r11 = this.this$0;
            GameReservationModel.access$300(r11, GameReservationModel.access$200(r11));
            GameReservationModel.access$400(this.this$0).set(false);
            this.this$0.postResponse();
        }

        @Override // com.bytedanceos.common.networkv2.subscriber.NSubscriber, rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((MySubListEntity) r10);
        }

        public /* synthetic */ MySubSciber(GameReservationModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(MySubListEntity r10) {
            if (r10 != null) goto L4;
        L6:
            GameReservationModel r11 = this.this$0;
            GameReservationModel.access$300(r11, GameReservationModel.access$200(r11));
        L7:
            this.this$0.postResponse();
            return;
        L4:
            if (r10.isOk() == false) goto L6;
            GameReservationModel r12 = this.this$0;
            GameReservationModel.access$500(r12, r10, GameReservationModel.access$200(r12));
            goto L7
        }
    }

    public class RecommmendGameSciber extends NSubscriber<ManagerSubListEntity> {
        final /* synthetic */ GameReservationModel this$0;

        private RecommmendGameSciber(GameReservationModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            this.this$0.postResponse();
        }

        @Override // com.bytedanceos.common.networkv2.subscriber.NSubscriber, rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((ManagerSubListEntity) r10);
        }

        public /* synthetic */ RecommmendGameSciber(GameReservationModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(ManagerSubListEntity r10) {
            if (r10 != null) goto L4;
        L6:
            this.this$0.postResponse();
            return;
        L4:
            if (r10.isOk() == false) goto L6;
            GameReservationModel r11 = this.this$0;
            GameReservationModel.access$700(r11, r10, GameReservationModel.access$600(r11));
            goto L6
        }
    }

    public GameReservationModel(IView<Boolean, ArrayList<GameReservationData>> r10) {
        this.mMyReservedGames = new ArrayList();
        this.mRecommendGames = new ArrayList();
        this.mRquestResult = new AtomicBoolean(true);
        this.mView = r10;
    }

    public static /* synthetic */ ArrayList access$200(GameReservationModel r10) {
        return r10.mMyReservedGames;
    }

    public static /* synthetic */ void access$300(GameReservationModel r10, ArrayList r11) {
        r10.fillNoReservationHeader(r11);
    }

    public static /* synthetic */ AtomicBoolean access$400(GameReservationModel r10) {
        return r10.mRquestResult;
    }

    public static /* synthetic */ void access$500(GameReservationModel r10, MySubListEntity r11, ArrayList r12) {
        r10.fillMySubList(r11, r12);
    }

    public static /* synthetic */ ArrayList access$600(GameReservationModel r10) {
        return r10.mRecommendGames;
    }

    public static /* synthetic */ void access$700(GameReservationModel r10, ManagerSubListEntity r11, ArrayList r12) {
        r10.fillNewGameList(r11, r12);
    }

    private void fillMySubList(MySubListEntity r10, ArrayList<GameReservationData> r11) {
        monitor-enter(r11);
        if (r10 != null) goto L25;
    L20:
        fillNoReservationHeader(r11);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L25:
    L12:
        th = move-exception;
        throw th;
    L5:
        if (r10.getBody() == null) goto L20;
        List<SubAppEntity> r12 = r10.getBody().getApps();     // Catch: Throwable -> L12
        if (c.a(r12) == false) goto L14;
        fillNoReservationHeader(r11);     // Catch: Throwable -> L12
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L14:
        Iterator<SubAppEntity> r13 = r12.iterator();     // Catch: Throwable -> L12
    L16:
        if (r13.hasNext() == false) goto L18;
        SubAppEntity r14 = r13.next();     // Catch: Throwable -> L12
        MyReserveApp r15 = new MyReserveApp();     // Catch: Throwable -> L12
        r15.mDataType = 1;     // Catch: Throwable -> L12
        r15.mUrl = r14.getLogo();     // Catch: Throwable -> L12
        r15.mGameName = r14.getName();     // Catch: Throwable -> L12
        r15.mAppId = r14.getId();     // Catch: Throwable -> L12
        r15.mGameOnlineTime = e.T(r14.getOnline_time());     // Catch: Throwable -> L12
        r15.mGameState = r14.getStatus();     // Catch: Throwable -> L12
        r11.add(r15);     // Catch: Throwable -> L12
        goto L16
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L12
    }

    private void fillNewGameList(ManagerSubListEntity r10, ArrayList<GameReservationData> r11) {
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (r10.getBody() == null) goto L20;
        Iterator<SubGroupAppEntity> r12 = r10.getBody().iterator();     // Catch: Throwable -> L12
    L7:
        if (r12.hasNext() == false) goto L18;
        SubGroupAppEntity r13 = r12.next();     // Catch: Throwable -> L12
        CategoryReservation r14 = new CategoryReservation();     // Catch: Throwable -> L12
        r14.mDataType = 2;     // Catch: Throwable -> L12
        r14.mCategory = r13.getName();     // Catch: Throwable -> L12
        ArrayList r15 = new ArrayList();     // Catch: Throwable -> L12
        r15.add(r14);     // Catch: Throwable -> L12
        Iterator<SubAppEntity> r16 = r13.getApps().iterator();     // Catch: Throwable -> L12
    L10:
        if (r16.hasNext() == false) goto L15;
        SubAppEntity r17 = r16.next();     // Catch: Throwable -> L12
        MyReserveApp r18 = new MyReserveApp();     // Catch: Throwable -> L12
        r18.mDataType = 3;     // Catch: Throwable -> L12
        r18.mAppId = r17.getId();     // Catch: Throwable -> L12
        r18.mUrl = r17.getLogo();     // Catch: Throwable -> L12
        r18.mGameName = r17.getName();     // Catch: Throwable -> L12
        r18.mGameOnlineTime = e.T(r17.getOnline_time());     // Catch: Throwable -> L12
        r18.mGameCategory = r17.getCategory();     // Catch: Throwable -> L12
        r18.mGameState = r17.getStatus();     // Catch: Throwable -> L12
        r15.add(r18);     // Catch: Throwable -> L12
        goto L10
    L15:
        if (r15.size() != 1) goto L17;
        r15.clear();     // Catch: Throwable -> L12
    L17:
        r11.addAll(r15);     // Catch: Throwable -> L12
        goto L7
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L12
        return;
    L20:
        monitor-exit(r11);     // Catch: Throwable -> L12
    }

    private void fillNoReservationHeader(ArrayList<GameReservationData> r10) {
        monitor-enter(r10);
        NoReservation r11 = new NoReservation();     // Catch: Throwable -> L6
        r11.mDataType = 0;     // Catch: Throwable -> L6
        r10.add(r11);     // Catch: Throwable -> L6
        monitor-exit(r10);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void fetchData() {
        this.mRquestResult.set(true);
        this.mCountDownLatch = new CountDownLatch(2);
        MySubSciber r10 = this.mReservedGameSciber;
        if (r10 == null) goto L5;
        r10.unsubscribe();
    L5:
        this.mMyReservedGames.clear();
        AnonymousClass1 r11 = null;
        this.mReservedGameSciber = new MySubSciber(this, r11);
        AppStoreV15Rest.instance().getMySubList(this.mReservedGameSciber);
        RecommmendGameSciber r12 = this.mRecommmendGameSciber;
        if (r12 == null) goto L8;
        r12.unsubscribe();
    L8:
        this.mRecommendGames.clear();
        this.mRecommmendGameSciber = new RecommmendGameSciber(this, r11);
        AppStoreV16Rest.instance().getManagerSubList(this.mRecommmendGameSciber);
    }

    public void onDestroy() {
        MySubSciber r10 = this.mReservedGameSciber;
        if (r10 == null) goto L5;
        r10.unsubscribe();
        this.mReservedGameSciber = null;
    L5:
        RecommmendGameSciber r11 = this.mRecommmendGameSciber;
        if (r11 == null) goto L9;
        r11.unsubscribe();
        this.mReservedGameSciber = null;
        return;
    }

    public void postResponse() {
        this.mCountDownLatch.countDown();
        if (this.mView != null) goto L5;
        return;
    L5:
        if (this.mCountDownLatch.getCount() <= 0) goto L8;
        return;
    L8:
        if (this.mRquestResult.get() == false) goto L10;
    L12:
        this.mMyReservedGames.addAll(this.mRecommendGames);
        this.mView.onUpdateView(0, Boolean.TRUE, this.mMyReservedGames);
        return;
    L10:
        if (this.mRecommendGames.isEmpty() == false) goto L12;
        this.mView.onUpdateView(0, Boolean.FALSE, null);
    }
}
