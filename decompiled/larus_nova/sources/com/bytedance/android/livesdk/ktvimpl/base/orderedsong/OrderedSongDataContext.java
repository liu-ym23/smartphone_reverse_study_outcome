package com.bytedance.android.livesdk.ktvimpl.base.orderedsong;

import android.util.Log;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.util.j;
import com.bytedance.android.livesdk.message.model.InteractiveSongUserInfo;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 22\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u00013B\u0007¢\u0006\u0004\b0\u00101J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0016\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0016J\u0016\u0010\u0017\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016J0\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\u001cH\u0016J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u0005H\u0016J\u0016\u0010!\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bH\u0016J0\u0010\"\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0\u001cH\u0016J0\u0010#\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0\u001cH\u0016R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R'\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b\u0011\u0010*R'\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000b0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b \u0010*R'\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u000b0'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b.\u0010)\u001a\u0004\b\u0007\u0010*¨\u00064"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/OrderedSongDataContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/a;", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/b;", "Lcom/bytedance/android/livesdk/ktvimpl/base/orderedsong/c;", "", "Lcom/bytedance/android/live/multilink/ktv/SongUniqueInfo;", "getKtvSongUniqueInfoList", "getKtvPublicSongUniqueInfoList", "getKtvPrivateSongUniqueInfoList", "getSelfKtvSongUniqueInfoList", "", "list", "", "updateKtvSongUniqueInfoList", "Lcom/bytedance/android/livesdk/message/model/MusicPanel;", "getKtvPublicOrderedSongList", "getKtvOrderedSongList", "", "uid", "getKtvCurSelfOrderedSongList", "getKtvPublicFirstOrderedSong", "getKtvPublicSecondOrderedSong", "updateKtvOrderedSongList", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "needObserveOnUi", "Lio/reactivex/functions/Consumer;", "observer", "Lio/reactivex/disposables/Disposable;", "observerKtvOrderedSongListChange", "getKtvSingSongList", "updateKtvSingSongList", "observerKtvSingSongListChange", "observerKtvSongUniqueInfoListChange", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "Lcom/bytedance/live/datacontext/m;", "ktvOrderedSongList$delegate", "Lcom/bytedance/live/datacontext/p;", "()Lcom/bytedance/live/datacontext/m;", "ktvOrderedSongList", "ktvSingSongList$delegate", "ktvSingSongList", "ktvSongUniqueInfoList$delegate", "ktvSongUniqueInfoList", "<init>", "()V", "Companion", "b", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class OrderedSongDataContext extends DataContext implements com.bytedance.android.livesdk.ktvimpl.base.orderedsong.a, com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b, c {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final b Companion = null;
    public static final String TAG = "OrderedSongDataContext";
    private final CompositeDisposable compositeDisposable;
    private final p ktvOrderedSongList$delegate;
    private final p ktvSingSongList$delegate;
    private final p ktvSongUniqueInfoList$delegate;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrderedSongDataContext f143277a;

        public a(OrderedSongDataContext r100) {
            this.f143277a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            if (v.a() == false) goto L5;
            ALogger.i(OrderedSongDataContext.TAG, "onCleared ;; " + this.f143277a.getClass().getSimpleName() + " ;; " + this.f143277a.hashCode() + " ;; trace == " + Log.getStackTraceString(new Throwable()));
        L6:
            OrderedSongDataContext.access$getCompositeDisposable$p(this.f143277a).clear();
            return;
        L5:
            ALogger.i(OrderedSongDataContext.TAG, "onCleared ;; " + this.f143277a.getClass().getSimpleName() + " ;; " + this.f143277a.hashCode());
            goto L6
        }
    }

    public static final class b {
        public b() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(OrderedSongDataContext.class, "ktvOrderedSongList", "getKtvOrderedSongList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(OrderedSongDataContext.class, "ktvSingSongList", "getKtvSingSongList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(OrderedSongDataContext.class, "ktvSongUniqueInfoList", "getKtvSongUniqueInfoList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new b();
    }

    private final m<List<MusicPanel>> getKtvOrderedSongList() {
        return (m) this.ktvOrderedSongList$delegate.a(this, $$delegatedProperties[0]);
    }

    private final m<List<MusicPanel>> getKtvSingSongList() {
        return (m) this.ktvSingSongList$delegate.a(this, $$delegatedProperties[1]);
    }

    private final m<List<SongUniqueInfo>> getKtvSongUniqueInfoList() {
        return (m) this.ktvSongUniqueInfoList$delegate.a(this, $$delegatedProperties[2]);
    }

    public OrderedSongDataContext() {
        CompositeDisposable r100 = new CompositeDisposable();
        this.compositeDisposable = r100;
        Disposable r101 = getOnCleared().subscribe(new a(this));
        if (r101 == null) goto L5;
        RxUtilKt.c(r101, r100);
    L5:
        this.ktvOrderedSongList$delegate = q.d(this, new ArrayList());
        this.ktvSingSongList$delegate = q.d(this, new ArrayList());
        this.ktvSongUniqueInfoList$delegate = q.d(this, new ArrayList());
    }

    /* JADX INFO: renamed from: getKtvOrderedSongList, reason: collision with other method in class */
    public List<MusicPanel> m8256getKtvOrderedSongList() {
        return getKtvOrderedSongList().getValue();
    }

    public List<SongUniqueInfo> getKtvPrivateSongUniqueInfoList() {
        List<SongUniqueInfo> r100 = getKtvSongUniqueInfoList().getValue();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((!((SongUniqueInfo) r103).isPublic()) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    public MusicPanel getKtvPublicFirstOrderedSong() {
        MusicPanel r100 = (MusicPanel) CollectionsKt.firstOrNull(m8257getKtvSingSongList());
        if (r100 == null) goto L10;
        j.f143561l.getClass();
        if (j.a() == true) goto L7;
        return r100;
    L7:
        if (j.d(r100.f153577a) == false) goto L12;
        return null;
    L12:
        return r100;
    L10:
        return r100;
    }

    public List<MusicPanel> getKtvPublicOrderedSongList() {
        List<MusicPanel> r100 = m8256getKtvOrderedSongList();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (((MusicPanel) r103).f153581e == true) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    public MusicPanel getKtvPublicSecondOrderedSong() {
        return (MusicPanel) CollectionsKt.getOrNull(m8257getKtvSingSongList(), 1);
    }

    public List<SongUniqueInfo> getKtvPublicSongUniqueInfoList() {
        List<SongUniqueInfo> r100 = getKtvSongUniqueInfoList().getValue();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (((SongUniqueInfo) r103).isPublic() == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    /* JADX INFO: renamed from: getKtvSingSongList, reason: collision with other method in class */
    public List<MusicPanel> m8257getKtvSingSongList() {
        return getKtvSingSongList().getValue();
    }

    /* JADX INFO: renamed from: getKtvSongUniqueInfoList, reason: collision with other method in class */
    public List<SongUniqueInfo> m8258getKtvSongUniqueInfoList() {
        return getKtvSongUniqueInfoList().getValue();
    }

    public List<SongUniqueInfo> getSelfKtvSongUniqueInfoList() {
        List<SongUniqueInfo> r100 = getKtvSongUniqueInfoList().getValue();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual(((SongUniqueInfo) r103).getUserId(), ((IMiddlewareUserService) k.n(IMiddlewareUserService.class)).user().n().toString()) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        return r101;
    }

    public static final /* synthetic */ CompositeDisposable access$getCompositeDisposable$p(OrderedSongDataContext r100) {
        return r100.compositeDisposable;
    }

    public List<MusicPanel> getKtvCurSelfOrderedSongList(String r100) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        List<MusicPanel> r101 = m8256getKtvOrderedSongList();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        OrderInfo r105 = ((MusicPanel) r104).d();
        if (r105 == null) goto L11;
        InteractiveSongUserInfo r106 = r105.getTopUser();
        if (r106 == null) goto L11;
        String r107 = r106.getIdString();
        if (r107 == null) goto L11;
    L13:
        if (Intrinsics.areEqual(r107, r100) == false) goto L4;
        r102.add(r104);
    L11:
        r107 = "";
        goto L13
    L15:
        return r102;
    }

    public void updateKtvOrderedSongList(List<MusicPanel> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (v.a() == false) goto L5;
        ALogger.i(TAG, "updateKtvOrderedSongList ;; list.size == " + r100.size() + " ;; trace == " + Log.getStackTraceString(new Throwable()));
    L7:
        if (((Boolean) KtvSettingHelper.f70670w.getValue()).booleanValue() == true) goto L9;
        getKtvOrderedSongList().setValue(r100);
        return;
    L9:
        if (isCleared() == true) goto L13;
        getKtvOrderedSongList().setValue(r100);
        return;
    L13:
        return;
    L5:
        ALogger.i(TAG, "updateKtvOrderedSongList ;; list.size == " + r100.size());
        goto L7
    }

    public void updateKtvSingSongList(List<MusicPanel> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (((Boolean) KtvSettingHelper.f70670w.getValue()).booleanValue() == true) goto L5;
        getKtvSingSongList().setValue(r100);
        return;
    L5:
        if (isCleared() == true) goto L9;
        getKtvSingSongList().setValue(r100);
        return;
    }

    public void updateKtvSongUniqueInfoList(List<SongUniqueInfo> r100) {
        Intrinsics.checkNotNullParameter(r100, "list");
        if (((Boolean) KtvSettingHelper.f70670w.getValue()).booleanValue() == true) goto L5;
        getKtvSongUniqueInfoList().setValue(r100);
        return;
    L5:
        if (isCleared() == true) goto L9;
        getKtvSongUniqueInfoList().setValue(r100);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.orderedsong.a
    public Disposable observerKtvOrderedSongListChange(LifecycleOwner r100, boolean r101, Consumer<List<MusicPanel>> r102) {
        Intrinsics.checkNotNullParameter(r102, "observer");
        if (r100 == null) goto L7;
        if (r101 == false) goto L12;
        return ((ObservableSubscribeProxy) RxUtilKt.h(getKtvOrderedSongList().a()).as(AutoDispose.bind(r100))).subscribe(r102);
    L12:
        return ((ObservableSubscribeProxy) getKtvOrderedSongList().a().as(AutoDispose.bind(r100))).subscribe(r102);
    L7:
        if (r101 == false) goto L10;
        return RxUtilKt.h(getKtvOrderedSongList().a()).subscribe(r102);
    L10:
        return getKtvOrderedSongList().a().subscribe(r102);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.orderedsong.b
    public Disposable observerKtvSingSongListChange(LifecycleOwner r100, boolean r101, Consumer<List<MusicPanel>> r102) {
        Intrinsics.checkNotNullParameter(r102, "observer");
        if (r100 == null) goto L7;
        if (r101 == false) goto L12;
        return ((ObservableSubscribeProxy) RxUtilKt.h(getKtvSingSongList().a()).as(AutoDispose.bind(r100))).subscribe(r102);
    L12:
        return ((ObservableSubscribeProxy) getKtvSingSongList().a().as(AutoDispose.bind(r100))).subscribe(r102);
    L7:
        if (r101 == false) goto L10;
        return RxUtilKt.h(getKtvSingSongList().a()).subscribe(r102);
    L10:
        return getKtvSingSongList().a().subscribe(r102);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c
    public Disposable observerKtvSongUniqueInfoListChange(LifecycleOwner r100, boolean r101, Consumer<List<SongUniqueInfo>> r102) {
        Intrinsics.checkNotNullParameter(r102, "observer");
        if (r100 == null) goto L7;
        if (r101 == false) goto L12;
        return ((ObservableSubscribeProxy) RxUtilKt.h(getKtvSongUniqueInfoList().a()).as(AutoDispose.bind(r100))).subscribe(r102);
    L12:
        return ((ObservableSubscribeProxy) getKtvSongUniqueInfoList().a().as(AutoDispose.bind(r100))).subscribe(r102);
    L7:
        if (r101 == false) goto L10;
        return RxUtilKt.h(getKtvSongUniqueInfoList().a()).subscribe(r102);
    L10:
        return getKtvSongUniqueInfoList().a().subscribe(r102);
    }
}
