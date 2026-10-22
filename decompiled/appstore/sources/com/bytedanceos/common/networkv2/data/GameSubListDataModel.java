package com.bytedanceos.common.networkv2.data;

import com.bytedanceos.common.eventbus.GameSubListEvent;
import com.bytedanceos.common.networkv2.entity.AppEntity;
import com.bytedanceos.common.networkv2.entity.GameSubListEntity;
import com.bytedanceos.common.networkv2.entity.GroupAppEntity;
import com.bytedanceos.common.networkv2.entity.SubAppEntity;
import com.bytedanceos.common.networkv2.entity.SubGroupAppEntity;
import com.bytedanceos.common.networkv2.entity.SubVideoEntity;
import com.bytedanceos.common.networkv2.rest.AppStoreV16Rest;
import com.bytedanceos.common.networkv2.subscriber.ISubscriberManager;
import com.bytedanceos.common.networkv2.subscriber.NSubscriber;
import com.bytedanceos.common.toolbox.c;
import com.bytedanceos.common.toolbox.e;
import com.bytedanceos.common.ui.recycler.entity.AppItem;
import com.bytedanceos.common.ui.recycler.entity.GroupTitleItem;
import com.bytedanceos.common.ui.recycler.entity.SubAppItem;
import com.bytedanceos.common.ui.recycler.entity.SubGroupAppItem;
import com.bytedanceos.common.ui.recycler.entity.SubVideoItem;
import com.bytedanceos.common.utils.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubListDataModel {
    private NSubscriber<GameSubListEntity> mNSubscriber;
    private ISubscriberManager mSubscriberManager;

    /* JADX INFO: renamed from: com.bytedanceos.common.networkv2.data.GameSubListDataModel$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class InnerSubscriber extends NSubscriber<GameSubListEntity> {
        final /* synthetic */ GameSubListDataModel this$0;

        private InnerSubscriber(GameSubListDataModel r10) {
            this.this$0 = r10;
        }

        @Override // rx.Observer
        public void onError(Throwable r10) {
            GameSubListEvent r11 = new GameSubListEvent();
            r11.errorType = h.f(r10);
            EventBus.getDefault().post(r11);
        }

        @Override // com.bytedanceos.common.networkv2.subscriber.NSubscriber, rx.Observer
        public /* bridge */ /* synthetic */ void onNext(Object r10) {
            onNext((GameSubListEntity) r10);
        }

        public /* synthetic */ InnerSubscriber(GameSubListDataModel r10, AnonymousClass1 r11) {
            this(r10);
        }

        public void onNext(GameSubListEntity r10) {
            List r11 = GameSubListDataModel.access$100(this.this$0, r10);
            GameSubListEvent r12 = new GameSubListEvent();
            r12.setDataList(r11);
            if (r10 != null) goto L5;
        L21:
            EventBus.getDefault().post(r12);
            return;
        L5:
            if (r10.getBody() == null) goto L21;
            List<SubVideoEntity> r13 = r10.getBody().getTop_apps();
            SubGroupAppEntity r14 = r10.getBody().getGroup_apps();
            SubGroupAppEntity r15 = r10.getBody().getOther_apps();
            if (r13 != null) goto L9;
        L10:
            if (r14 != null) goto L12;
        L15:
            if (r15 == null) goto L21;
            if (r15.getApps() == null) goto L21;
            if (r15.getApps().size() <= 0) goto L21;
        L20:
            r12.setHasSubscribe(true);
            goto L21
        L12:
            if (r14.getApps() == null) goto L15;
            if (r14.getApps().size() > 0) goto L20;
        L9:
            if (r13.size() > 0) goto L20;
            goto L10
        }
    }

    public GameSubListDataModel(int r10, ISubscriberManager r11) {
        this.mNSubscriber = new InnerSubscriber(this, null);
        this.mSubscriberManager = r11;
    }

    public static /* synthetic */ List access$100(GameSubListDataModel r10, GameSubListEntity r11) {
        return r10.entity2List(r11);
    }

    private List entity2List(GameSubListEntity r10) {
        if (r10 != null) goto L5;
    L36:
        return null;
    L5:
        if (r10.getBody() == null) goto L36;
        ArrayList r11 = new ArrayList();
        List<SubVideoEntity> r12 = r10.getBody().getTop_apps();
        int r13 = 0;
        int r14 = 1;
        if (c.a(r12) == true) goto L10;
        SubVideoEntity r15 = r12.get(0);
        SubVideoItem r16 = SubVideoItem.contain(r15);
        r16.setControlVisable(false);
        r16.setOrder(1);
        r11.add(r16);
        SubAppItem r17 = SubAppItem.contain(r15);
        r17.setOrder(2);
        r11.add(r17);
        r14 = 3;
    L10:
        SubGroupAppEntity r18 = r10.getBody().getGroup_apps();
        if (r18 == null) goto L18;
        List<SubAppEntity> r19 = r18.getApps();
        if (c.a(r19) == true) goto L18;
        r11.add(GroupTitleItem.contain(r18.getName()));
        int r20 = 0;
    L16:
        if (r20 >= r19.size()) goto L18;
        SubGroupAppItem r21 = SubGroupAppItem.contain(r19.get(r20));
        r21.setOrder(r14);
        r11.add(r21);
        r20 = r20 + 1;
        r14 = r14 + 1;
    L18:
        SubGroupAppEntity r22 = r10.getBody().getOther_apps();
        if (r22 == null) goto L26;
        List<SubAppEntity> r23 = r22.getApps();
        if (c.a(r23) == true) goto L26;
        r11.add(GroupTitleItem.contain(r22.getName()));
        int r24 = 0;
    L24:
        if (r24 >= r23.size()) goto L26;
        SubAppItem r25 = SubAppItem.contain(r23.get(r24));
        r25.setOrder(r14);
        r11.add(r25);
        r24 = r24 + 1;
        r14 = r14 + 1;
    L26:
        GroupAppEntity r26 = r10.getBody().getHot_games();
        if (r26 == null) goto L34;
        List<AppEntity> r27 = r26.getApps();
        if (c.a(r27) == true) goto L34;
        r11.add(GroupTitleItem.contain(r26.getName()));
        h.i(r27);
    L32:
        if (r13 >= r27.size()) goto L34;
        r11.add(AppItem.contain(r27.get(r13), r14));
        r13 = r13 + 1;
        r14 = r14 + 1;
    L34:
        r11.removeAll(Collections.singleton(null));
        return r11;
    }

    public void doQueryData() {
        e.z1(this.mNSubscriber);
        InnerSubscriber r10 = new InnerSubscriber(this, null);
        this.mNSubscriber = r10;
        ISubscriberManager r11 = this.mSubscriberManager;
        if (r11 == null) goto L5;
        r11.addNSubscriber(r10);
    L5:
        AppStoreV16Rest.instance().getGameSubcribeList(this.mNSubscriber);
    }

    public GameSubListDataModel(ISubscriberManager r10) {
        this(20, r10);
    }
}
