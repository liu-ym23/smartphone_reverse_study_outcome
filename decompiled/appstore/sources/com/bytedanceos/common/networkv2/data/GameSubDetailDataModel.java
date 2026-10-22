package com.bytedanceos.common.networkv2.data;

import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.eventbus.GameSubDetailEvent;
import com.bytedanceos.common.networkv2.entity.CategoryAppListEntity;
import com.bytedanceos.common.networkv2.entity.GameSubInfoEntity;
import com.bytedanceos.common.networkv2.entity.SubGiftEntity;
import com.bytedanceos.common.networkv2.params.NetValue;
import com.bytedanceos.common.networkv2.rest.AppStoreV15Rest;
import com.bytedanceos.common.networkv2.subscriber.ISubscriberManager;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.recycler.entity.AppPagerListItem;
import com.bytedanceos.common.ui.recycler.entity.GroupTitleItem;
import com.bytedanceos.common.ui.recycler.entity.SubAppInfoItem;
import com.bytedanceos.common.ui.recycler.entity.SubBriefItem;
import com.bytedanceos.common.ui.recycler.entity.SubGiftItem;
import com.bytedanceos.common.ui.recycler.entity.SubGiftListItem;
import com.bytedanceos.common.ui.recycler.entity.SubScreenItem;
import com.bytedanceos.common.ui.recycler.entity.SubScreenListItem;
import com.bytedanceos.common.ui.recycler.entity.SubVideoItem;
import com.bytedanceos.common.utils.h;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubDetailDataModel {
    private CategorySubscriber mCategoryBer;
    private String mId;
    private String mPageSource;
    private SubInfoSubscriber mSubInfoBer;
    private ISubscriberManager mSubscriberManager;

    /* JADX INFO: renamed from: com.bytedanceos.common.networkv2.data.GameSubDetailDataModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class CategorySubscriber extends NSubscriber<CategoryAppListEntity> {
        final /* synthetic */ GameSubDetailDataModel this$0;

        private CategorySubscriber(GameSubDetailDataModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            GameSubDetailEvent r11 = new GameSubDetailEvent();
            r11.errorType = h.f(r10);
            EventBus.getDefault().post(r11);
        }

        @Override // com.bytedanceos.common.networkv2.subscriber.NSubscriber, rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((CategoryAppListEntity) r10);
        }

        public /* synthetic */ CategorySubscriber(GameSubDetailDataModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(CategoryAppListEntity r10) {
            List<MultiItemEntity> r11 = GameSubDetailDataModel.access$500(this.this$0, r10);
            GameSubDetailEvent r12 = new GameSubDetailEvent();
            r12.setDataList(r11);
            EventBus.getDefault().post(r12);
        }
    }

    public class SubInfoSubscriber extends NSubscriber<GameSubInfoEntity> {
        final /* synthetic */ GameSubDetailDataModel this$0;

        private SubInfoSubscriber(GameSubDetailDataModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            GameSubDetailEvent r11 = new GameSubDetailEvent();
            r11.errorType = h.f(r10);
            EventBus.getDefault().post(r11);
        }

        @Override // com.bytedanceos.common.networkv2.subscriber.NSubscriber, rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((GameSubInfoEntity) r10);
        }

        public /* synthetic */ SubInfoSubscriber(GameSubDetailDataModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(GameSubInfoEntity r10) {
            GameSubDetailEvent r11 = new GameSubDetailEvent();
            r11.refreshType = 3;
            r11.setSubAppEntity(r10.getBody());
            r11.setDataList(GameSubDetailDataModel.access$200(this.this$0, r10));
            EventBus.getDefault().post(r11);
            GameSubDetailDataModel.access$400(this.this$0, r10.getBody().getParent_cid(), NetValue.TYPE_RANK, GameSubDetailDataModel.access$300(this.this$0));
        }
    }

    public GameSubDetailDataModel(ISubscriberManager r10) {
        this.mId = "";
        this.mPageSource = "";
        AnonymousClass1 r11 = null;
        this.mSubInfoBer = new SubInfoSubscriber(this, r11);
        this.mCategoryBer = new CategorySubscriber(this, r11);
        this.mSubscriberManager = r10;
    }

    public static /* synthetic */ List access$200(GameSubDetailDataModel r10, GameSubInfoEntity r11) {
        return r10.subInfo2List(r11);
    }

    public static /* synthetic */ String access$300(GameSubDetailDataModel r10) {
        return r10.mPageSource;
    }

    public static /* synthetic */ void access$400(GameSubDetailDataModel r10, String r11, String r12, String r13) {
        r10.requestCategoryApps(r11, r12, r13);
    }

    public static /* synthetic */ List access$500(GameSubDetailDataModel r10, CategoryAppListEntity r11) {
        return r10.category2List(r11);
    }

    private List category2List(CategoryAppListEntity r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.getBody() == null) goto L12;
        ArrayList r11 = new ArrayList();
        if (c.a(r10.getBody().getApps()) == true) goto L9;
        r11.add(GroupTitleItem.contain(BaseApplication.c().getString(R$string.maybe_you_like)));
        r11.add(AppPagerListItem.contain(h.i(r10.getBody().getApps())));
    L9:
        return r11;
    L12:
        return null;
    }

    private void requestCategoryApps(String r10, String r11, String r12) {
        e.z1(this.mCategoryBer);
        CategorySubscriber r13 = new CategorySubscriber(this, null);
        this.mCategoryBer = r13;
        ISubscriberManager r14 = this.mSubscriberManager;
        if (r14 == null) goto L5;
        r14.addNSubscriber(r13);
    L5:
        AppStoreV15Rest.instance().getCategoryApps(r10, r11, r12, this.mCategoryBer);
    }

    private void requestSubInfo() {
        e.z1(this.mSubInfoBer);
        SubInfoSubscriber r10 = new SubInfoSubscriber(this, null);
        this.mSubInfoBer = r10;
        ISubscriberManager r11 = this.mSubscriberManager;
        if (r11 == null) goto L5;
        r11.addNSubscriber(r10);
    L5:
        AppStoreV15Rest.instance().getGameSubcribeInfo(this.mId, this.mSubInfoBer);
    }

    private List subInfo2List(GameSubInfoEntity r10) {
        if (r10 != null) goto L4;
        return null;
    L4:
        if (r10.getBody() == null) goto L34;
        ArrayList r11 = new ArrayList();
        r11.add(SubVideoItem.contain(r10.getBody()));
        r11.add(SubAppInfoItem.contain(r10.getBody()));
        List<SubGiftEntity> r12 = r10.getBody().getGifts();
        int r13 = 0;
        if (c.a(r12) == true) goto L15;
        int r14 = r12.size();
        ArrayList r15 = new ArrayList();
        int r16 = 0;
    L9:
        if (r16 >= r14) goto L14;
        SubGiftItem r17 = SubGiftItem.contain(r12.get(r16));
        if (r16 != r14) goto L13;
        r17.setLast(true);
    L13:
        r15.add(r17);
        r16 = r16 + 1;
        goto L9
    L14:
        r11.add(SubGiftListItem.contain(r15));
    L15:
        List<String> r18 = r10.getBody().getScreens();
        if (c.a(r18) == true) goto L24;
        int r19 = r18.size();
        ArrayList r20 = new ArrayList();
    L18:
        if (r13 >= r19) goto L23;
        SubScreenItem r21 = SubScreenItem.contain(r18.get(r13));
        if (r13 != r19) goto L22;
        r21.setLast(true);
    L22:
        r20.add(r21);
        r13 = r13 + 1;
        goto L18
    L23:
        r11.add(SubScreenListItem.contain(r20));
    L24:
        r11.add(SubBriefItem.contain(r10.getBody().getBrief()));
        return r11;
    L34:
        return null;
    }

    public void doQueryData() {
        requestSubInfo();
    }

    public void setId(String r10) {
        this.mId = r10;
    }

    public void setPageSource(String r10) {
        this.mPageSource = r10;
    }
}
