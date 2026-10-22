package com.bytedanceos.common.networkv2.data;

import com.bytedanceos.common.core.ui.presenter.IView;
import com.bytedanceos.common.networkv2.entity.AppManagerCountsEntity;
import com.bytedanceos.common.networkv2.entity.AppManagerRecomendAppsEntity;
import com.bytedanceos.common.networkv2.entity.CategoryAppsEntity;
import com.bytedanceos.common.networkv2.rest.AppStoreV14Rest;
import com.bytedanceos.common.networkv2.rest.AppStoreV16Rest;
import com.bytedanceos.common.toolbox.j;
import retrofit2.Response;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class AppManagerDataModel<T> {
    public static final String PATH_NAME_RECOMMEND = "recommend";
    public static final String PATH_NAME_UPDATE = "Updatable";
    public static final String PATH_NAME_WISH = "wish";
    private AppManagerDataModel<T>.CategoryAppsSubscriber mCategoryAppsEntity;
    private AppManagerDataModel<T>.AppManagerCountsSubscriber mCountSubscriber;
    private AppManagerDataModel<T>.AppManagerRecommendSubscriber mRecommendSubscriber;
    private IView<T, String> mView;

    /* JADX INFO: renamed from: com.bytedanceos.common.networkv2.data.AppManagerDataModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class AppManagerCountsSubscriber extends Subscriber {
        final /* synthetic */ AppManagerDataModel this$0;

        private AppManagerCountsSubscriber(AppManagerDataModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            j.e("Counts onCompleted:");
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            j.e("sync count error:" + r10.getMessage());
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((Response) r10);
        }

        public /* synthetic */ AppManagerCountsSubscriber(AppManagerDataModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(Response<AppManagerCountsEntity> r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.a() == null) goto L12;
            Object r11 = r10.a();
            if (AppManagerDataModel.access$300(this.this$0) == null) goto L11;
            AppManagerDataModel.access$300(this.this$0).onUpdateView(0, r11, null);
            return;
        L11:
            return;
        }
    }

    public class AppManagerRecommendSubscriber extends Subscriber {
        final /* synthetic */ AppManagerDataModel this$0;

        private AppManagerRecommendSubscriber(AppManagerDataModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            j.e("Recommend,onCompleted:");
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            j.e("sync recomend apps error:" + r10.getMessage());
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((Response) r10);
        }

        public /* synthetic */ AppManagerRecommendSubscriber(AppManagerDataModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(Response<AppManagerRecomendAppsEntity> r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.a() == null) goto L12;
            Object r11 = r10.a();
            if (AppManagerDataModel.access$300(this.this$0) == null) goto L11;
            AppManagerDataModel.access$300(this.this$0).onUpdateView(0, r11, null);
            return;
        L11:
            return;
        }
    }

    public class CategoryAppsSubscriber extends Subscriber {
        final /* synthetic */ AppManagerDataModel this$0;

        private CategoryAppsSubscriber(AppManagerDataModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onCompleted() {
            j.e("Category,onCompleted:");
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            j.e("sync Category apps error:" + r10.getMessage());
            if (AppManagerDataModel.access$300(this.this$0) == null) goto L6;
            AppManagerDataModel.access$300(this.this$0).onUpdateView(1600000, null, null);
            return;
        }

        @Override // rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((Response) r10);
        }

        public /* synthetic */ CategoryAppsSubscriber(AppManagerDataModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(Response<CategoryAppsEntity> r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if (r10.a() == null) goto L12;
            Object r11 = r10.a();
            if (AppManagerDataModel.access$300(this.this$0) == null) goto L11;
            AppManagerDataModel.access$300(this.this$0).onUpdateView(1600000, r11, null);
            return;
        L11:
            return;
        }
    }

    public AppManagerDataModel(IView<T, String> r10) {
        this.mView = r10;
    }

    public static /* synthetic */ IView access$300(AppManagerDataModel r10) {
        return r10.mView;
    }

    public void getAppManagerRecommendApps(String r10) {
        AppManagerDataModel<T>.AppManagerRecommendSubscriber r11 = this.mRecommendSubscriber;
        if (r11 == null) goto L5;
        r11.unsubscribe();
    L5:
        this.mRecommendSubscriber = new AppManagerRecommendSubscriber(this, null);
        AppStoreV16Rest.instance().getAppManagerRecommendApps(r10, this.mRecommendSubscriber);
    }

    public void getCountData() {
        AppManagerDataModel<T>.AppManagerCountsSubscriber r10 = this.mCountSubscriber;
        if (r10 == null) goto L5;
        r10.unsubscribe();
    L5:
        this.mCountSubscriber = new AppManagerCountsSubscriber(this, null);
        AppStoreV16Rest.instance().getCountData(this.mCountSubscriber);
    }

    public void getSystemApps() {
        AppManagerDataModel<T>.CategoryAppsSubscriber r10 = this.mCategoryAppsEntity;
        if (r10 == null) goto L5;
        r10.unsubscribe();
    L5:
        this.mCategoryAppsEntity = new CategoryAppsSubscriber(this, null);
        AppStoreV14Rest.instance().getCategoryApps("122", 1, this.mCategoryAppsEntity);
    }

    public void onDestroy() {
        AppManagerDataModel<T>.AppManagerCountsSubscriber r10 = this.mCountSubscriber;
        if (r10 == null) goto L5;
        r10.unsubscribe();
        this.mCountSubscriber = null;
    L5:
        AppManagerDataModel<T>.AppManagerRecommendSubscriber r11 = this.mRecommendSubscriber;
        if (r11 == null) goto L8;
        r11.unsubscribe();
        this.mRecommendSubscriber = null;
    L8:
        AppManagerDataModel<T>.CategoryAppsSubscriber r12 = this.mCategoryAppsEntity;
        if (r12 == null) goto L11;
        r12.unsubscribe();
        this.mCategoryAppsEntity = null;
    L11:
        this.mView = null;
    }
}
