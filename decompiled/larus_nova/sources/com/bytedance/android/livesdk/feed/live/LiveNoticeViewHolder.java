package com.bytedance.android.livesdk.feed.live;

import am2.x;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.base.model.banner.a;
import com.bytedance.android.live.base.model.feed.FeedItem;
import com.bytedance.android.live.core.utils.rxutils.j;
import com.bytedance.android.live.core.viewholder.BaseViewHolder;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.feed.ui.NoticeViewSwitcher;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import g60.c;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jc1.k;
import jw1.a0;
import jw1.b0;
import jw1.c0;
import jw1.d0;
import jw1.y;
import jw1.z;
import uv1.e;
import xs2.b;

/* JADX INFO: loaded from: classes8.dex */
public class LiveNoticeViewHolder extends BaseViewHolder<FeedItem> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f124156e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NoticeViewSwitcher f124157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Disposable f124158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<a> f124159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f124160d;

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final boolean fullSpan() {
        return true;
    }

    public final void U3() {
        j.a r100 = j.f66356a;
        this.f124158b = j.c(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new y(this), new z());
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewAttachedToWindow() {
        super.onViewAttachedToWindow();
        U3();
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void onViewDetachedFromWindow() {
        super.onViewDetachedFromWindow();
        Disposable r100 = this.f124158b;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        this.f124158b.dispose();
        return;
    }

    public final void T3(a r100) {
        if (TextUtils.isEmpty(r100.d()) == false) goto L5;
        return;
    L5:
        HashMap r101 = new HashMap(1);
        r101.put("notice_id", String.valueOf(r100.getId()));
        if (TTLiveService.getLiveService() == null) goto L11;
        if (TTLiveService.getLiveService().getLiveOntologyRecord() == null) goto L11;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_VS_DRAWER_PAGE, TTLiveService.getLiveService().getLiveOntologyRecord().getEnterFromMerge());
    L11:
        if (e5.n() == false) goto L13;
        String r102 = "landscape";
    L14:
        r101.put("screen_direction", r102);
        u.l().sendLog("livesdk_notice_entrance_click", r101, new Object[]{x.class});
        ((IRoomService) k.f(IRoomService.class)).actionHandler().handle(this.itemView.getContext(), r100.d());
        b.a().post(new e(0));
        return;
    L13:
        r102 = "portrait";
        goto L14
    }

    @Override // com.bytedance.android.live.core.viewholder.BaseViewHolder
    public final void bind(FeedItem r100, int r101) {
        FeedItem r102 = r100;
        if (r102 == null) goto L13;
        com.bytedance.android.live.base.model.banner.b r103 = r102.bannerContainer;
        if (r103 == null) goto L16;
        List<a> r104 = r103.a();
        this.f124159c = r104;
        if (r104.isEmpty() == true) goto L14;
        int r105 = this.f124159c.size();
        int r106 = this.f124160d;
        if (r105 <= r106) goto L15;
        NoticeViewSwitcher r107 = this.f124157a;
        List<a> r108 = this.f124159c;
        r107.setCurrentText(((a) ListProtector.get(r108, r106 % r108.size())).f());
        this.f124157a.getCurrentView().setOnClickListener(new d0(this));
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    public LiveNoticeViewHolder(View r100, PublishSubject r101, PublishSubject r102, PublishSubject r103) {
        super(r100);
        this.f124160d = 0;
        this.f124157a = (NoticeViewSwitcher) r100.findViewById(R.id.switcher_notice);
        r103.subscribe(new a0(this), new c());
        r101.subscribe(new b0(this), new c());
        r102.subscribe(new c0(this), new c());
    }
}
