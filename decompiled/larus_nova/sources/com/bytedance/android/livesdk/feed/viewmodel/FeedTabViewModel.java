package com.bytedance.android.livesdk.feed.viewmodel;

import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.UserEvent;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import com.bytedance.android.livesdk.feed.tab.monitor.FeedTabMonitor;
import com.bytedance.android.livesdk.model.a1;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public class FeedTabViewModel extends RxViewModel {
    private com.bytedance.android.livesdk.feed.j feedTabRepository;
    private com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> mTabListDiff;
    private BehaviorSubject<List<com.bytedance.android.livesdk.feed.feed.e>> tabList;
    private PublishSubject<Integer> tabPos;

    public static /* synthetic */ boolean Mo(List r100) {
        return lambda$queryTab$3(r100);
    }

    public static /* synthetic */ boolean No(FeedTabViewModel r100, List r101) {
        return r100.lambda$queryRemoteTabAndSave$9(r101);
    }

    public static /* synthetic */ boolean Oo(List r100) {
        return lambda$queryRemoteTabAndSave$7(r100);
    }

    public static /* synthetic */ void Po(Throwable r100) {
        lambda$queryRemoteTabAndSave$11(r100);
    }

    public static /* synthetic */ void Qo(FeedTabViewModel r100, IBaseUser.Status r101) {
        r100.lambda$new$2(r101);
    }

    public static /* synthetic */ boolean So(FeedTabViewModel r100, List r101) {
        return r100.lambda$queryTab$5(r101);
    }

    public static /* synthetic */ List To(List r100) {
        return lambda$queryRemoteTabAndSave$8(r100);
    }

    public static /* synthetic */ IBaseUser.Status Wo(UserEvent r100) {
        return lambda$new$0(r100);
    }

    public static /* synthetic */ void Yo(FeedTabViewModel r100, List r101) {
        r100.lambda$queryTab$6(r101);
    }

    public static /* synthetic */ List Zo(List r100) {
        return lambda$queryTab$4(r100);
    }

    public static /* synthetic */ void ap(FeedTabViewModel r100, List r101) {
        r100.lambda$queryRemoteTabAndSave$10(r101);
    }

    public static /* synthetic */ boolean yo(IBaseUser.Status r100) {
        return lambda$new$1(r100);
    }

    private void queryRemoteTabAndSave() {
        register(this.feedTabRepository.a(FeedTabMonitor.Action.TRIGGER_ACTION_OPEN_TAB_PAGE).filter(new s()).map(new t()).filter(new i(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(this), new k()));
    }

    public List<com.bytedance.android.livesdk.feed.feed.e> getAllTabs() {
        return this.feedTabRepository.c();
    }

    public String getTitle() {
        if (this.feedTabRepository.getExtra() == null) goto L5;
        String r100 = this.feedTabRepository.getExtra().getTitle();
    L7:
        if (TextUtils.isEmpty(r100) == true) goto L9;
        return r100;
    L9:
        if (Lists.isEmpty(this.feedTabRepository.c()) == false) goto L11;
        return r100;
    L11:
        if (ListProtector.get(this.feedTabRepository.c(), 0) != null) goto L13;
        return r100;
    L13:
        return ((com.bytedance.android.livesdk.feed.feed.e) ListProtector.get(this.feedTabRepository.c(), 0)).i();
    L5:
        r100 = null;
        goto L7
    }

    public void queryTab() {
        register(this.feedTabRepository.e().filter(new h()).map(new l()).filter(new m(this)).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this), new o()));
    }

    public Observable<List<com.bytedance.android.livesdk.feed.feed.e>> tabList() {
        return this.tabList;
    }

    private static /* synthetic */ IBaseUser.Status lambda$new$0(UserEvent r100) throws Exception {
        return r100.getStatus();
    }

    private static /* synthetic */ boolean lambda$new$1(IBaseUser.Status r100) throws Exception {
        if (r100 != IBaseUser.Status.Login) goto L5;
    L8:
        return true;
    L5:
        if (r100 == IBaseUser.Status.Logout) goto L8;
        return false;
    }

    private /* synthetic */ void lambda$new$2(IBaseUser.Status r100) throws Exception {
        queryTab();
    }

    private /* synthetic */ void lambda$queryRemoteTabAndSave$10(List r100) throws Exception {
        this.tabList.onNext(r100);
    }

    private static /* synthetic */ void lambda$queryRemoteTabAndSave$11(Throwable r100) throws Exception {
        ALogger.e("Tab Request", r100);
    }

    private static /* synthetic */ boolean lambda$queryRemoteTabAndSave$7(List r100) throws Exception {
        return !Lists.isEmpty(r100);
    }

    private static /* synthetic */ List lambda$queryRemoteTabAndSave$8(List r100) throws Exception {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.feed.feed.e r103 = (com.bytedance.android.livesdk.feed.feed.e) r102.next();
        if (r103 == null) goto L4;
        if (r103.q() == false) goto L4;
        r101.add(r103);
        goto L4
    L10:
        return r101;
    }

    private /* synthetic */ boolean lambda$queryRemoteTabAndSave$9(List r100) throws Exception {
        return !this.mTabListDiff.a(r100, this.tabList.getValue());
    }

    private static /* synthetic */ boolean lambda$queryTab$3(List r100) throws Exception {
        return !Lists.isEmpty(r100);
    }

    private static /* synthetic */ List lambda$queryTab$4(List r100) throws Exception {
        ArrayList r101 = new ArrayList();
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        com.bytedance.android.livesdk.feed.feed.e r103 = (com.bytedance.android.livesdk.feed.feed.e) r102.next();
        if (r103 == null) goto L4;
        if (r103.q() == false) goto L4;
        r101.add(r103);
        goto L4
    L10:
        return r101;
    }

    private /* synthetic */ boolean lambda$queryTab$5(List r100) throws Exception {
        return !this.mTabListDiff.a(r100, this.tabList.getValue());
    }

    private /* synthetic */ void lambda$queryTab$6(List r100) throws Exception {
        this.tabList.onNext(r100);
    }

    public com.bytedance.android.livesdk.feed.feed.e getTabById(long r100) {
        return this.feedTabRepository.d(r100);
    }

    public FeedTabViewModel(com.bytedance.android.livesdk.feed.j r100, com.bytedance.android.livesdk.feed.k<com.bytedance.android.livesdk.feed.feed.e> r101, hw1.a r102) {
        this.tabList = BehaviorSubject.create();
        this.tabPos = PublishSubject.create();
        this.feedTabRepository = r100;
        this.mTabListDiff = r101;
        register(r102.m().map(new p()).filter(new q()).subscribe(new r(this), new g60.c()));
        if (a1.a() == false) goto L5;
        queryRemoteTabAndSave();
    L5:
        a1.f153926c = true;
    }
}
