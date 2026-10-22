package com.bytedanceos.common.networkv2.data;

import android.text.TextUtils;
import com.bytedanceos.common.core.ui.presenter.IView;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.entity.AppEntity;
import com.bytedanceos.common.networkv2.entity.EmptyEntity;
import com.bytedanceos.common.networkv2.entity.FirstRecommendBannerEntity;
import com.bytedanceos.common.networkv2.entity.FirstRecommendDescEntity;
import com.bytedanceos.common.networkv2.entity.FirstRecommendWrap;
import com.bytedanceos.common.networkv2.rest.AppStoreV16Rest;
import com.bytedanceos.common.toolbox.j;
import com.bytedanceos.common.utils.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import retrofit2.Response;
import rx.Subscriber;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes2.dex */
public class FirstReCommendListModel {
    private static final int SPAN_COUNT_MAX = 8;
    private static final int SPAN_COUNT_NORMAL = 4;
    private List<AppInfo> mAppInfoList;
    private FirstReCommendListSubscriber mFirstReCommendListSubscriber;
    private Func1<Response<FirstRecommendWrap>, List<Object>> mResponseMap;
    private IView<List, String> mView;

    /* JADX INFO: renamed from: com.bytedanceos.common.networkv2.data.FirstReCommendListModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class FirstReCommendListSubscriber extends Subscriber {
        final /* synthetic */ FirstReCommendListModel this$0;

        private FirstReCommendListSubscriber(FirstReCommendListModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            j.e("Counts onCompleted:");
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            j.e("sync count error:" + r10.getMessage());
            if (FirstReCommendListModel.access$500(this.this$0) == null) goto L6;
            FirstReCommendListModel.access$500(this.this$0).onRequestError(r10);
            return;
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((List) r10);
        }

        public /* synthetic */ FirstReCommendListSubscriber(FirstReCommendListModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(List<Object> r10) {
            if (FirstReCommendListModel.access$500(this.this$0) == null) goto L6;
            FirstReCommendListModel.access$500(this.this$0).onUpdateView(0, r10, null);
            return;
        }
    }

    public class RecommendMap implements Func1<Response<FirstRecommendWrap>, List<Object>> {
        final /* synthetic */ FirstReCommendListModel this$0;

        private RecommendMap(FirstReCommendListModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.functions.Func1
        public /* bridge */ /* synthetic */ List<Object> call(Response<FirstRecommendWrap> r10) {
            return call2(r10);
        }

        public /* synthetic */ RecommendMap(FirstReCommendListModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public List<Object> call2(Response<FirstRecommendWrap> r11) {
            List<FirstRecommendWrap.FirstRecommend> r12 = ((FirstRecommendWrap) r11.a()).getBody();
            ArrayList r10 = new ArrayList();
            EmptyEntity r13 = new EmptyEntity();
            int r14 = 0;
        L4:
            if (r14 >= r12.size()) goto L28;
            FirstRecommendWrap.FirstRecommend r15 = r12.get(r14);
            List<AppEntity> r16 = r15.getApps();
            if (r16.size() < 4) goto L26;
            List r17 = h.i(r16);
            List r18 = h.g(r17);
            int r19 = r18.size();
            if (r19 == 0) goto L26;
            if (r19 > 4) goto L16;
            if (r17.size() < 4) goto L26;
            List r20 = r17.subList(0, 4);
            FirstReCommendListModel.access$200(this.this$0, r20, r18);
        L19:
            List r21 = FirstReCommendListModel.access$300(this.this$0, r20, r14 + 1, 1);
            if (FirstReCommendListModel.access$400(this.this$0, r15.getImage()) == false) goto L23;
            FirstRecommendBannerEntity r22 = new FirstRecommendBannerEntity();
            r22.setImage(r15.getImage());
            r10.add(r22);
        L23:
            if (TextUtils.isEmpty(r15.getDescription()) == true) goto L25;
            FirstRecommendDescEntity r23 = new FirstRecommendDescEntity();
            r23.setDescription(r15.getDescription());
            r10.add(r23);
        L25:
            r10.addAll(r21);
            r10.add(r13);
            goto L26
        L16:
            if (r17.size() < 8) goto L18;
            r20 = r17.subList(0, 8);
            goto L19
        L18:
            r20 = r17.subList(0, 4);
        L26:
            r14 = r14 + 1;
            goto L4
        L28:
            if (r10.size() != 0) goto L50;
            int r24 = 0;
        L31:
            if (r24 >= r12.size()) goto L50;
            FirstRecommendWrap.FirstRecommend r25 = r12.get(r24);
            List<AppEntity> r26 = r25.getApps();
            if (r26.size() < 4) goto L49;
            List r27 = h.i(r26);
            if (r27.size() < 4) goto L49;
            List r28 = FirstReCommendListModel.access$300(this.this$0, r27.subList(0, 4), r24 + 1, 1);
            Iterator r29 = r28.iterator();
        L40:
            if (r29.hasNext() == false) goto L43;
            ((AppInfo) r29.next()).default_check = 0;
            goto L40
        L43:
            if (FirstReCommendListModel.access$400(this.this$0, r25.getImage()) == false) goto L46;
            FirstRecommendBannerEntity r30 = new FirstRecommendBannerEntity();
            r30.setImage(r25.getImage());
            r10.add(r30);
        L46:
            if (TextUtils.isEmpty(r25.getDescription()) == true) goto L48;
            FirstRecommendDescEntity r31 = new FirstRecommendDescEntity();
            r31.setDescription(r25.getDescription());
            r10.add(r31);
        L48:
            r10.addAll(r28);
            r10.add(r13);
        L49:
            r24 = r24 + 1;
        L50:
            return r10;
        }
    }

    public FirstReCommendListModel(IView<List, String> r10, List<AppInfo> r11) {
        this.mView = r10;
        this.mAppInfoList = r11;
    }

    public static /* synthetic */ void access$200(FirstReCommendListModel r10, List r11, List r12) {
        r10.filterInstalledApps(r11, r12);
    }

    public static /* synthetic */ List access$300(FirstReCommendListModel r10, List r11, int r12, int r13) {
        return r10.parse2AppInfo(r11, r12, r13);
    }

    public static /* synthetic */ boolean access$400(FirstReCommendListModel r10, String r11) {
        return r10.hasBannerData(r11);
    }

    public static /* synthetic */ IView access$500(FirstReCommendListModel r10) {
        return r10.mView;
    }

    private void filterInstalledApps(List<AppEntity> r10, List<AppEntity> r11) {
        Iterator<AppEntity> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        AppEntity r13 = r12.next();
        if (r11.contains(r13) == true) goto L4;
        r13.setDefault_check(0);
        goto L4
    }

    private boolean hasBannerData(String r10) {
        return false;
    }

    private List<AppInfo> parse2AppInfo(List<AppEntity> r10, int r11, int r12) {
        ArrayList r13 = new ArrayList();
        int r14 = 0;
    L4:
        if (r14 >= r10.size()) goto L9;
        AppEntity r15 = r10.get(r14);
        r15.addItemPosition(String.valueOf(r11));
        AppInfo r16 = r15.convertAppInfo();
        r13.add(r16);
        if (r15.getDefault_check() != 1) goto L8;
        this.mAppInfoList.add(r16);
    L8:
        r14 = r14 + 1;
        goto L4
    L9:
        return r13;
    }

    public void getFirstReCommendList() {
        FirstReCommendListSubscriber r10 = this.mFirstReCommendListSubscriber;
        if (r10 == null) goto L5;
        r10.unsubscribe();
    L5:
        AnonymousClass1 r11 = null;
        if (this.mResponseMap != null) goto L8;
        this.mResponseMap = new RecommendMap(this, r11);
    L8:
        this.mFirstReCommendListSubscriber = new FirstReCommendListSubscriber(this, r11);
        AppStoreV16Rest.instance().getFirstRecommendList().f(this.mResponseMap).q(this.mFirstReCommendListSubscriber);
    }

    public void onDestroy() {
        FirstReCommendListSubscriber r10 = this.mFirstReCommendListSubscriber;
        if (r10 == null) goto L6;
        r10.unsubscribe();
        this.mFirstReCommendListSubscriber = null;
        return;
    }
}
