package com.bytedance.android.livesdk.landscapeslide;

import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.d1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0002)*B\u0017\u0012\u0006\u0010!\u001a\u00020 \u0012\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002J\u0006\u0010\n\u001a\u00020\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eR\u0014\u0010\u0012\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R\"\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006+"}, d2 = {"Lcom/bytedance/android/livesdk/landscapeslide/LiveLandSlideContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "getLandFeedSize", "", "delta", "", "checkSlideIntercept", "prefetchSize", "checkLoad", "getRelateRoomIndex", "", "getInitRoomId", "getCurrentRoomId", "Lcom/bytedance/android/livesdk/widget/LiveVerticalViewPager;", "viewPager", "Lcom/bytedance/android/livesdk/vs/a;", "createScrollLimiter", "initRoomId", "J", "Lcom/bytedance/live/datacontext/m;", "isDataReady$delegate", "Lcom/bytedance/live/datacontext/p;", "isDataReady", "()Lcom/bytedance/live/datacontext/m;", "isDataEmpty$delegate", "isDataEmpty", "curRoomId", "getCurRoomId", "()J", "setCurRoomId", "(J)V", "Lcom/bytedance/android/livesdk/landscapeslide/b;", "listProvider", "Lcom/bytedance/android/livesdk/landscapeslide/b;", "Lcom/bytedance/android/livesdk/landscapeslide/LiveLandSlideContext$b;", "listHelper", "Lcom/bytedance/android/livesdk/landscapeslide/LiveLandSlideContext$b;", "<init>", "(Lcom/bytedance/android/livesdk/landscapeslide/b;Lcom/bytedance/android/livesdk/landscapeslide/LiveLandSlideContext$b;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "liveroom-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveLandSlideContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private static String SHARE_KEY = null;
    private static final String TAG = "LiveLandSlideContext";
    private static final List<i> supportEnterSource = null;
    private long curRoomId;
    private final long initRoomId;
    private final p isDataEmpty$delegate;
    private final p isDataReady$delegate;
    private final b listHelper;
    private final com.bytedance.android.livesdk.landscapeslide.b listProvider;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static LiveLandSlideContext a() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(LiveLandSlideContext.access$getSHARE_KEY$cp());
            if ((r100 instanceof LiveLandSlideContext) == true) goto L5;
            r100 = null;
        L5:
            LiveLandSlideContext r101 = (LiveLandSlideContext) r100;
            if (r101 != null) goto L8;
            return null;
        L8:
            if (com.bytedance.android.livesdk.utils.landscape.f.a() == true) goto L10;
            return null;
        L10:
            return r101;
        }

        @JvmStatic
        public static boolean b() {
            LiveLandSlideContext r100 = a();
            if (r100 == null) goto L9;
            m<Boolean> r101 = r100.isDataReady();
            if (r101 == null) goto L9;
            Boolean r102 = r101.getValue();
            if (r102 == null) goto L9;
            return r102.booleanValue();
        L9:
            return false;
        }
    }

    public interface b {
    }

    public static final class c implements com.bytedance.android.livesdk.vs.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f146994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ LiveLandSlideContext f146995b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ LiveVerticalViewPager f146996c;

        @Override // com.bytedance.android.livesdk.vs.a
        public final boolean onInterceptTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "ev");
            if (r100.getAction() != 0) goto L6;
            this.f146994a = r100.getY();
            this.f146996c.setIgnoreSpeed(false);
        L11:
            return false;
        L6:
            if (r100.getAction() != 2) goto L11;
            if (this.f146995b.checkSlideIntercept(r100.getY() - this.f146994a) == false) goto L11;
            this.f146996c.requestDisallowInterceptTouchEvent(true);
            return true;
        }

        @Override // com.bytedance.android.livesdk.vs.a
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "ev");
            if (this.f146995b.checkSlideIntercept(r100.getY() - this.f146994a) == true) goto L6;
            return false;
        L6:
            if (r100.getAction() != 2) goto L9;
            return true;
        L9:
            if (r100.getAction() != 1) goto L11;
            this.f146996c.setIgnoreSpeed(true);
        L11:
            return false;
        }

        public c(LiveLandSlideContext r100, LiveVerticalViewPager r101) {
            this.f146995b = r100;
            this.f146996c = r101;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(LiveLandSlideContext.class, "isDataReady", "isDataReady()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(LiveLandSlideContext.class, "isDataEmpty", "isDataEmpty()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
        SHARE_KEY = TAG;
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L8;
        List<i> r100 = new ArrayList();
        Iterator<T> r101 = com.bytedance.android.livesdk.utils.landscape.f.f159074a.e().iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        r100.add(new i((String) r101.next(), MatchMode.EQUALS));
    L9:
        supportEnterSource = r100;
        return;
    L8:
        MatchMode r102 = MatchMode.EQUALS;
        r100 = CollectionsKt.listOf(new i[]{new i("homepage_hot_live_cell", r102), new i("homepage_hot_video_head", r102)});
        goto L9
    }

    @JvmStatic
    public static final LiveLandSlideContext getShared() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final boolean isSlideAble() {
        Companion.getClass();
        return a.b();
    }

    public final m<Boolean> isDataEmpty() {
        return (m) this.isDataEmpty$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Boolean> isDataReady() {
        return (m) this.isDataReady$delegate.a(this, $$delegatedProperties[0]);
    }

    private final int getLandFeedSize() {
        return this.listProvider.i() + 1;
    }

    @JvmStatic
    public static final long getSelectedRoom() {
        Companion.getClass();
        LiveLandSlideContext r100 = a.a();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.getCurRoomId();
    }

    @JvmStatic
    public static final boolean isEnable() {
        Companion.getClass();
        if (a.a() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final long getCurrentRoomId() {
        ((ti1.h) this.listHelper).getClass();
        RoomContext r100 = RoomContext.getShared();
        if (r100 != null) goto L7;
        return -1000;
    L7:
        return r100.getRoom().getValue().getRoomId();
    }

    public final int getRelateRoomIndex() {
        int r100 = ((ti1.h) this.listHelper).f546033a.f546035b.f490188e.getCurrentItem() - this.listProvider.e();
        if (r100 > 0) goto L7;
        return 0;
    L7:
        return r100;
    }

    public static final /* synthetic */ String access$getSHARE_KEY$cp() {
        return SHARE_KEY;
    }

    public static final /* synthetic */ List access$getSupportEnterSource$cp() {
        return supportEnterSource;
    }

    public final long getCurRoomId() {
        return this.curRoomId;
    }

    public final long getInitRoomId() {
        return this.initRoomId;
    }

    public static final /* synthetic */ void access$setSHARE_KEY$cp(String r100) {
        SHARE_KEY = r100;
    }

    @JvmStatic
    private static final void log(String r100) {
        Companion.getClass();
        f.c(r100, TAG);
    }

    @JvmStatic
    public static final void setCurFragmentKey(Fragment r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        access$setSHARE_KEY$cp(TAG + r100.hashCode());
    }

    @JvmStatic
    public static final void setSelectedRoom(long r100) {
        Companion.getClass();
        LiveLandSlideContext r101 = a.a();
        if (r101 == null) goto L6;
        r101.setCurRoomId(r100);
        return;
    }

    public final boolean checkLoad(int r100) {
        int r101 = getRelateRoomIndex();
        if (r101 >= 0) goto L6;
        return false;
    L6:
        if ((getLandFeedSize() - r101) > r100) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean checkSlideIntercept(float r100) {
        Companion.getClass();
        if (a.b() == true) goto L5;
        return false;
    L5:
        float r101 = 0;
        if (r100 <= r101) goto L10;
        if (((ti1.h) this.listHelper).f546033a.f546035b.f490188e.getCurrentItem() > this.listProvider.e()) goto L10;
    L13:
        return true;
    L10:
        if (r100 < r101) goto L12;
        return false;
    L12:
        if (getRelateRoomIndex() >= (getLandFeedSize() - 1)) goto L13;
        return false;
    }

    public final com.bytedance.android.livesdk.vs.a createScrollLimiter(LiveVerticalViewPager r100) {
        Intrinsics.checkNotNullParameter(r100, "viewPager");
        return new c(this, r100);
    }

    public final void setCurRoomId(long r100) {
        this.curRoomId = r100;
    }

    public LiveLandSlideContext(com.bytedance.android.livesdk.landscapeslide.b r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "listProvider");
        Intrinsics.checkNotNullParameter(r101, "listHelper");
        this.listProvider = r100;
        this.listHelper = r101;
        String r102 = SHARE_KEY;
        int r103 = com.bytedance.live.datacontext.d.f255080a;
        Intrinsics.checkNotNullParameter(this, "self");
        com.bytedance.live.datacontext.b.a(this, r102);
        ((ti1.h) r101).getClass();
        RoomContext r104 = RoomContext.getShared();
        if (r104 == null) goto L5;
        long r105 = r104.getRoom().getValue().getRoomId();
    L6:
        this.initRoomId = r105;
        Boolean r106 = Boolean.FALSE;
        this.isDataReady$delegate = q.d(this, r106);
        this.isDataEmpty$delegate = q.d(this, r106);
        return;
    L5:
        r105 = -1000;
        goto L6
    }

    @JvmStatic
    public static final Pair<LiveLandSlideContext, Disposable> initAndLoad(final com.bytedance.android.livesdk.landscapeslide.b r100, final b r101) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "listProvider");
        Intrinsics.checkNotNullParameter(r101, "listHelper");
        return com.bytedance.live.datacontext.d.a(new LiveLandSlideContext$Companion$initAndLoad$1(r100, r101));
    }

    @JvmStatic
    public static final boolean checkEnv(String r100, String r101, ds0.d r102) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "enterMerge");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        String r103 = r100 + '_' + r101;
        int r104 = i.f147014c;
        if (i.a.a(access$getSupportEnterSource$cp(), r103) == true) goto L5;
        f.c("not support source " + r100 + '_' + r101, TAG);
        return false;
    L5:
        f.c("support source " + r100 + '_' + r101, TAG);
        IRoom r105 = null;
        Room r106 = null;
        r106 = null;
        r105 = null;
        r105 = null;
        if (com.bytedance.android.livesdk.utils.landscape.f.a() == false) goto L15;
        MiddlewareRoomContext r107 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, null, 0, 3);
        if (r107 == null) goto L13;
        m<Room> r108 = r107.getRoom();
        if (r108 == null) goto L13;
        r106 = r108.getValue();
    L13:
        if (f.b(r106, "init") == true) goto L38;
        f.c("extension is not horizontal live", TAG);
        return false;
    L38:
        if (PadConfigUtils.a() == false) goto L40;
        return false;
    L40:
        if (a.a() == null) goto L42;
        boolean r109 = true;
    L43:
        if (r109 == true) goto L50;
        return true;
    L50:
        return false;
    L42:
        r109 = false;
        goto L43
    L15:
        IRoomContextService r110 = (IRoomContextService) k.f(IRoomContextService.class);
        if (r110 == null) goto L22;
        o r111 = IRoomContextService.a.a(r110, null, 0, 3);
        if (r111 == null) goto L22;
        m<IRoom> r112 = r111.getRoom();
        if (r112 == null) goto L22;
        r105 = r112.getValue();
    L22:
        if (r105 != null) goto L24;
    L26:
        if (r102 != null) goto L29;
        boolean r113 = d1.a(r105);
    L35:
        if (r113 == true) goto L38;
        f.c("is not game live", TAG);
        return false;
    L29:
        if (d1.a(r102.w()) == false) goto L31;
    L34:
        r113 = true;
        goto L35
    L31:
        if (r102.f().getBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_GAME_LIVE, false) == true) goto L34;
    L33:
        r113 = false;
        goto L35
    L24:
        if (r105.isMergeVSRoom() != true) goto L26;
        ALogger.i(TAG, "room is VS stream room roomid " + r105.getId());
        goto L33
    }
}
