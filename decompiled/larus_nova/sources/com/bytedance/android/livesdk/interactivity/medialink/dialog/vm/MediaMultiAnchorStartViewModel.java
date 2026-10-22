package com.bytedance.android.livesdk.interactivity.medialink.dialog.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.liveinteract.multianchor.model.AnchorLinkUser;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import gy.c;
import hy.e;
import hy.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004J\u0010\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\t0\u001c8\u0006¢\u0006\f\n\u0004\b\"\u0010\u001e\u001a\u0004\b#\u0010 R\u001b\u0010)\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0014\u0010+\u001a\u00020*8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/medialink/dialog/vm/MediaMultiAnchorStartViewModel;", "Landroidx/lifecycle/ViewModel;", "", "onCleared", "", "Lcom/bytedance/android/live/base/model/user/User;", "getOnLineList", "", "uid", "", "isOrganizer", "loadData", "isOverLimit", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "room", "Lcom/bytedance/android/livesdkapi/depend/model/live/Room;", "Lgy/f;", "rtcManager", "Lgy/f;", "Lhy/e;", "anchorInfoCenter", "Lhy/e;", "Lvlc/d;", "messageManager", "Lvlc/d;", "Landroidx/lifecycle/MutableLiveData;", "_finishState", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/LiveData;", "finishState", "Landroidx/lifecycle/LiveData;", "getFinishState", "()Landroidx/lifecycle/LiveData;", "_onlineStateNotify", "onlineStateNotify", "getOnlineStateNotify", "Lgy/b;", "rtcListener$delegate", "Lkotlin/Lazy;", "getRtcListener", "()Lgy/b;", "rtcListener", "Lhy/f$a;", "anchorLinkCallback", "Lhy/f$a;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MediaMultiAnchorStartViewModel extends ViewModel {
    public static final a Companion = null;
    public static final String TAG = "MediaMultiAnchorStartViewModel";
    private final MutableLiveData<Boolean> _finishState;
    private final MutableLiveData<Boolean> _onlineStateNotify;
    private final e anchorInfoCenter;
    private final f.a anchorLinkCallback;
    private final LiveData<Boolean> finishState;
    private final d messageManager;
    private final LiveData<Boolean> onlineStateNotify;
    private final Room room;
    private final Lazy rtcListener$delegate;
    private final gy.f rtcManager;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MediaMultiAnchorStartViewModel f138162a;

        public b(MediaMultiAnchorStartViewModel r100) {
            this.f138162a = r100;
        }

        @Override // hy.f.a, hy.f.b
        public final void d(int r100, List<AnchorLinkUser> r101) {
            MediaMultiAnchorStartViewModel.access$get_onlineStateNotify$p(this.f138162a).postValue(Boolean.TRUE);
        }
    }

    static {
        Companion = new a();
    }

    private final gy.b getRtcListener() {
        return (gy.b) this.rtcListener$delegate.getValue();
    }

    public final List<User> getOnLineList() {
        e r100 = this.anchorInfoCenter;
        if (r100 == null) goto L14;
        List<AnchorLinkUser> r101 = r100.getOnlineUserList();
        if (r101 == null) goto L14;
        List<AnchorLinkUser> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L18;
        IBaseUser r105 = ((AnchorLinkUser) r104.next()).getUser();
        if (r105 == null) goto L13;
        r103.add((User) r105);
        goto L8
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.base.model.user.User");
    L18:
        return r103;
    L14:
        return null;
    }

    public final void loadData() {
        e r100 = this.anchorInfoCenter;
        if (r100 == null) goto L6;
        r100.b(4, "show_link_list_dialog");
        return;
    }

    public MediaMultiAnchorStartViewModel() {
        RoomContext.a r100 = RoomContext.Companion;
        d r101 = null;
        RoomContext r102 = RoomContext.a.c(r100, null, 0, 3);
        if (r102 == null) goto L7;
        m<Room> r103 = r102.getRoom();
        if (r103 == null) goto L7;
        Room r104 = r103.getValue();
    L8:
        this.room = r104;
        c.f483309c2.getClass();
        c r105 = c.a.a();
        if (r105 == null) goto L11;
        gy.f r106 = r105.getRtcManager();
    L12:
        this.rtcManager = r106;
        com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.b r107 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
        if (r107 == null) goto L15;
        e r108 = r107.Np();
    L16:
        this.anchorInfoCenter = r108;
        RoomContext r109 = RoomContext.a.c(r100, null, 0, 3);
        if (r109 == null) goto L21;
        j<d> r110 = r109.getMessageManager();
        if (r110 == null) goto L21;
        r101 = r110.getValue();
    L21:
        this.messageManager = r101;
        MutableLiveData<Boolean> r111 = new MutableLiveData();
        this._finishState = r111;
        this.finishState = r111;
        MutableLiveData<Boolean> r112 = new MutableLiveData();
        this._onlineStateNotify = r112;
        this.onlineStateNotify = r112;
        this.rtcListener$delegate = LazyKt.lazy(new MediaMultiAnchorStartViewModel$rtcListener$2(this));
        b r113 = new b(this);
        this.anchorLinkCallback = r113;
        if (r106 == null) goto L24;
        r106.m(getRtcListener());
    L24:
        if (r108 == null) goto L27;
        r108.i(r113);
        return;
    L27:
        return;
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = null;
    L7:
        r104 = null;
        goto L8
    }

    public final boolean isOverLimit() {
        List<User> r100 = getOnLineList();
        if (r100 == null) goto L5;
        int r101 = r100.size();
    L7:
        if (r101 < 4) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        e r100 = this.anchorInfoCenter;
        if (r100 == null) goto L5;
        r100.h(this.anchorLinkCallback);
    L5:
        gy.f r101 = this.rtcManager;
        if (r101 == null) goto L9;
        r101.e(getRtcListener());
        return;
    }

    public final LiveData<Boolean> getFinishState() {
        return this.finishState;
    }

    public final LiveData<Boolean> getOnlineStateNotify() {
        return this.onlineStateNotify;
    }

    public static final /* synthetic */ MutableLiveData access$get_finishState$p(MediaMultiAnchorStartViewModel r100) {
        return r100._finishState;
    }

    public static final /* synthetic */ MutableLiveData access$get_onlineStateNotify$p(MediaMultiAnchorStartViewModel r100) {
        return r100._onlineStateNotify;
    }

    public final boolean isOrganizer(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        e r101 = this.anchorInfoCenter;
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.N(r100);
    }

    public static boolean isOrganizer$default(MediaMultiAnchorStartViewModel r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = ey.c.b();
    L6:
        return r100.isOrganizer(r101);
    }
}
