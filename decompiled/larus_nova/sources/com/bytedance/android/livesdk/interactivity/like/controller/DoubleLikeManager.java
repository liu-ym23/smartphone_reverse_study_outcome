package com.bytedance.android.livesdk.interactivity.like.controller;

import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.utils.n3;
import com.bytedance.android.livesdk.interactivity.like.wrdsmodel.DoubleLikeSyncModel;
import com.bytedance.android.livesdk.message.model.c4;
import com.bytedance.android.livesdk.message.model.d4;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import u32.l;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b=\u0010>J\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0014J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0005H\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J \u0010\u001b\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0003H\u0016J\u0010\u0010$\u001a\u00020\n2\u0006\u0010 \u001a\u00020#H\u0016R\u0016\u0010%\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010&R\u0016\u0010(\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u0012018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u001d\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00107R\u0017\u00109\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/like/controller/DoubleLikeManager;", "Landroidx/lifecycle/ViewModel;", "Lu32/l;", "", "seqId", "", "doubleFlag", "checkAndUpdateSeqId", "Lcom/bytedance/android/livesdk/interactivity/like/controller/b$a;", "info", "", "notifyActivityStart", "notifyActivityEnd", "notifyActivityRenewalUpdate", "notifyActivityUserRankUpdate", "notifyActivitySummary", "onCleared", "isDoubleLike", "Lu32/l$a;", "listener", "notifyLatest", "addListener", "removeListener", "", "count", "doubleLikeFlag", "doubleLikeFlagV2", "onLocalLikeResult", "onLocalLike", "enable", "setDoubleLikeEnable", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/b;", "message", "version", "onDoubleLikeSyncData", "Lcom/bytedance/android/livesdk/message/model/c4;", "onDoubleLikeTopUserMessage", "lastDisableSeqId", "J", "lastEnableSeqId", "currentRealLocalDoubleLikeCount", "I", "currentLocalDoubleLikeCount", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;", "currentDoubleLikeDetail", "Lcom/bytedance/android/livesdk/interactivity/api/like/model/a;", "Lcom/bytedance/android/livesdk/interactivity/like/controller/b;", "stateMachine", "Lcom/bytedance/android/livesdk/interactivity/like/controller/b;", "", "listeners", "Ljava/util/List;", "Lio/reactivex/disposables/Disposable;", "roomDataSyncModelSubscribe", "Lio/reactivex/disposables/Disposable;", "Z", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "getRoomContext", "()Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "<init>", "(Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class DoubleLikeManager extends ViewModel implements l {
    private com.bytedance.android.livesdk.interactivity.api.like.model.a currentDoubleLikeDetail;
    private int currentLocalDoubleLikeCount;
    private int currentRealLocalDoubleLikeCount;
    private boolean enable;
    private long lastDisableSeqId;
    private long lastEnableSeqId;
    private final List<l.a> listeners;
    private final MiddlewareRoomContext roomContext;
    private Disposable roomDataSyncModelSubscribe;
    private final com.bytedance.android.livesdk.interactivity.like.controller.b stateMachine;

    public static final class a implements com.bytedance.android.livesdk.interactivity.like.controller.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleLikeManager f137613a;

        public a(DoubleLikeManager r100) {
            this.f137613a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.controller.b.c
        public final void a(com.bytedance.android.livesdk.interactivity.like.controller.b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            com.bytedance.android.livesdk.interactivity.api.like.model.a r101 = DoubleLikeManager.access$getCurrentDoubleLikeDetail$p(this.f137613a);
            long r102 = 0;
            if (r101 == null) goto L5;
            long r103 = r101.b();
        L6:
            com.bytedance.android.livesdk.interactivity.api.like.model.a r104 = r100.f137631b;
            if (r104 == null) goto L10;
            r102 = r104.b();
        L10:
            if (r103 >= r102) goto L12;
            DoubleLikeManager.access$setCurrentDoubleLikeDetail$p(this.f137613a, r100.f137631b);
            DoubleLikeManager.access$notifyActivityRenewalUpdate(this.f137613a, r100);
        L12:
            DoubleLikeManager.access$notifyActivityUserRankUpdate(this.f137613a, r100);
            return;
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.controller.b.c
        public final void b(com.bytedance.android.livesdk.interactivity.like.controller.b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            DoubleLikeManager.access$notifyActivitySummary(this.f137613a, r100);
            DoubleLikeManager.access$setCurrentRealLocalDoubleLikeCount$p(this.f137613a, 0);
            DoubleLikeManager.access$setCurrentLocalDoubleLikeCount$p(this.f137613a, 0);
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.controller.b.c
        public final void c(com.bytedance.android.livesdk.interactivity.like.controller.b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            DoubleLikeManager.access$notifyActivityEnd(this.f137613a);
        }

        @Override // com.bytedance.android.livesdk.interactivity.like.controller.b.c
        public final void d(com.bytedance.android.livesdk.interactivity.like.controller.b.a r100) {
            Intrinsics.checkNotNullParameter(r100, "info");
            DoubleLikeManager.access$setCurrentDoubleLikeDetail$p(this.f137613a, r100.f137631b);
            DoubleLikeManager.access$notifyActivityStart(this.f137613a, r100);
            DoubleLikeManager.access$notifyActivityUserRankUpdate(this.f137613a, r100);
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DoubleLikeManager f137614a;

        public b(DoubleLikeManager r100) {
            this.f137614a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            dc2.c.b r101 = (dc2.c.b) r100;
            this.f137614a.onDoubleLikeSyncData((com.bytedance.android.livesdk.interactivity.api.like.model.b) r101.f467859b, r101.f467858a);
        }
    }

    private final void notifyActivityEnd() {
        Iterator<T> r100 = this.listeners.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((l.a) r100.next()).e(this, this.currentLocalDoubleLikeCount);
        goto L4
    }

    public boolean isDoubleLike() {
        return Intrinsics.areEqual(this.stateMachine.f137629a.b(), com.bytedance.android.livesdk.interactivity.like.controller.b.e.a.f137643b);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.listeners.clear();
        Disposable r100 = this.roomDataSyncModelSubscribe;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public final MiddlewareRoomContext getRoomContext() {
        return this.roomContext;
    }

    public DoubleLikeManager(MiddlewareRoomContext r100) {
        Intrinsics.checkNotNullParameter(r100, "roomContext");
        this.roomContext = r100;
        this.lastDisableSeqId = -1;
        this.lastEnableSeqId = -1;
        this.listeners = new ArrayList();
        this.enable = true;
        this.stateMachine = new com.bytedance.android.livesdk.interactivity.like.controller.b(new a(this));
        this.roomDataSyncModelSubscribe = ((DoubleLikeSyncModel) dc2.b.a(n3.g(r100), DoubleLikeManager$roomDataSyncModel$1.INSTANCE)).getDoubleLikeSyncData().f467853e.subscribe(new b(this));
    }

    public static final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.like.model.a access$getCurrentDoubleLikeDetail$p(DoubleLikeManager r100) {
        return r100.currentDoubleLikeDetail;
    }

    public static final /* synthetic */ int access$getCurrentLocalDoubleLikeCount$p(DoubleLikeManager r100) {
        return r100.currentLocalDoubleLikeCount;
    }

    public static final /* synthetic */ int access$getCurrentRealLocalDoubleLikeCount$p(DoubleLikeManager r100) {
        return r100.currentRealLocalDoubleLikeCount;
    }

    public static final /* synthetic */ void access$notifyActivityEnd(DoubleLikeManager r100) {
        r100.notifyActivityEnd();
    }

    private final void notifyActivityRenewalUpdate(com.bytedance.android.livesdk.interactivity.like.controller.b.a r100) {
        Iterator<T> r101 = this.listeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        l.a r102 = (l.a) r101.next();
        com.bytedance.android.livesdk.interactivity.api.like.model.a r103 = r100.f137631b;
        if (r103 == null) goto L4;
        r102.l(this, r103);
        goto L4
    }

    private final void notifyActivityStart(com.bytedance.android.livesdk.interactivity.like.controller.b.a r100) {
        Iterator<T> r101 = this.listeners.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        l.a r102 = (l.a) r101.next();
        com.bytedance.android.livesdk.interactivity.api.like.model.a r103 = r100.f137631b;
        if (r103 == null) goto L4;
        r102.b(this, r103);
        goto L4
    }

    private final void notifyActivitySummary(com.bytedance.android.livesdk.interactivity.like.controller.b.a r100) {
        if (r100.f137633d != null) goto L5;
        return;
    L5:
        if (r100.f137634e == null) goto L12;
        Iterator<T> r101 = this.listeners.iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        ((l.a) r101.next()).d(this, this.currentLocalDoubleLikeCount, this.currentRealLocalDoubleLikeCount, r100.f137633d, r100.f137634e);
        goto L8
    L13:
        return;
    }

    private final void notifyActivityUserRankUpdate(com.bytedance.android.livesdk.interactivity.like.controller.b.a r100) {
        List<d4> r101 = r100.f137632c;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((!r101.isEmpty()) == false) goto L12;
        Iterator<T> r102 = this.listeners.iterator();
    L8:
        if (r102.hasNext() == false) goto L13;
        ((l.a) r102.next()).k(this, r100.f137632c);
        goto L8
    L13:
        return;
    }

    public void onDoubleLikeTopUserMessage(c4 r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC2184b.C2185b(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(0, null, r110.E(), null, null, 27)));
    }

    @Override // u32.l
    public void onLocalLike(int r100) {
        if (isDoubleLike() == false) goto L6;
        this.currentLocalDoubleLikeCount += r100;
        return;
    }

    @Override // u32.l
    public void removeListener(l.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.listeners.remove(r100);
    }

    @Override // u32.l
    public void setDoubleLikeEnable(boolean r110) {
        this.enable = r110;
        if (r110 == true) goto L6;
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC2184b.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(0, null, null, null, null, 30)));
        return;
    }

    public static final /* synthetic */ void access$notifyActivityRenewalUpdate(DoubleLikeManager r100, com.bytedance.android.livesdk.interactivity.like.controller.b.a r101) {
        r100.notifyActivityRenewalUpdate(r101);
    }

    public static final /* synthetic */ void access$notifyActivityStart(DoubleLikeManager r100, com.bytedance.android.livesdk.interactivity.like.controller.b.a r101) {
        r100.notifyActivityStart(r101);
    }

    public static final /* synthetic */ void access$notifyActivitySummary(DoubleLikeManager r100, com.bytedance.android.livesdk.interactivity.like.controller.b.a r101) {
        r100.notifyActivitySummary(r101);
    }

    public static final /* synthetic */ void access$notifyActivityUserRankUpdate(DoubleLikeManager r100, com.bytedance.android.livesdk.interactivity.like.controller.b.a r101) {
        r100.notifyActivityUserRankUpdate(r101);
    }

    public static final /* synthetic */ void access$setCurrentDoubleLikeDetail$p(DoubleLikeManager r100, com.bytedance.android.livesdk.interactivity.api.like.model.a r101) {
        r100.currentDoubleLikeDetail = r101;
    }

    public static final /* synthetic */ void access$setCurrentLocalDoubleLikeCount$p(DoubleLikeManager r100, int r101) {
        r100.currentLocalDoubleLikeCount = r101;
    }

    public static final /* synthetic */ void access$setCurrentRealLocalDoubleLikeCount$p(DoubleLikeManager r100, int r101) {
        r100.currentRealLocalDoubleLikeCount = r101;
    }

    private final boolean checkAndUpdateSeqId(long r100, boolean r101) {
        if (r101 == false) goto L9;
        long r102 = Math.max(this.lastEnableSeqId, r100);
        this.lastEnableSeqId = r102;
        if (r100 > this.lastDisableSeqId) goto L7;
    L12:
        return false;
    L7:
        if (r100 < r102) goto L12;
        return true;
    L9:
        this.lastDisableSeqId = Math.max(this.lastDisableSeqId, r100);
        if (r100 < this.lastEnableSeqId) goto L12;
        return true;
    }

    @Override // u32.l
    public void addListener(l.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.listeners.contains(r100) == true) goto L13;
        this.listeners.add(r100);
        if (r101 == true) goto L7;
        return;
    L7:
        if (Intrinsics.areEqual(this.stateMachine.f137629a.b(), com.bytedance.android.livesdk.interactivity.like.controller.b.e.a.f137643b) == false) goto L11;
        com.bytedance.android.livesdk.interactivity.api.like.model.a r102 = this.currentDoubleLikeDetail;
        if (r102 == null) goto L15;
        r100.b(this, r102);
        return;
    L15:
        return;
    L11:
        r100.e(this, this.currentLocalDoubleLikeCount);
        return;
    }

    public void onDoubleLikeSyncData(com.bytedance.android.livesdk.interactivity.api.like.model.b r110, long r111) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if (this.enable == true) goto L5;
        return;
    L5:
        com.bytedance.android.livesdk.interactivity.api.like.model.a r100 = r110.a();
        if (r100 != null) goto L8;
        return;
    L8:
        if (checkAndUpdateSeqId(r100.c(), r100.a()) == true) goto L12;
        com.bytedance.android.livesdk.interactivity.like.utils.d r112 = com.bytedance.android.livesdk.interactivity.like.utils.d.f137725a;
        Intrinsics.checkNotNullParameter(r100, "detail");
        r112.a("onSeqIdInValid, msgId is " + r111 + ", detail info is " + JsonUtil.toJSONString(r100) + ' ');
        return;
    L12:
        if (r100.a() == false) goto L14;
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC2184b.C2185b(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(r111, r100, null, null, null, 28)));
        return;
    L14:
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC2184b.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(r111, r100, null, null, null, 28)));
        if (r110.b() != null) goto L17;
        return;
    L17:
        if (r110.c() == null) goto L23;
        this.stateMachine.a(new com.bytedance.android.livesdk.interactivity.like.controller.b.AbstractC2184b.c(new com.bytedance.android.livesdk.interactivity.like.controller.b.a(r111, r100, null, r110.b(), r110.c(), 4)));
        return;
    }

    @Override // u32.l
    public void onLocalLikeResult(int r100, boolean r101, boolean r102) {
        if (r102 == false) goto L5;
        this.currentRealLocalDoubleLikeCount += r100;
        return;
    }
}
