package com.bytedance.android.livesdk.chatroom.indicator.shortterm;

import am2.x;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.arch.mvvm.StatefulViewModel;
import com.bytedance.android.live.core.setting.e5;
import com.bytedance.android.livesdk.chatroom.utils.z3;
import com.bytedance.android.livesdk.log.b0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.ShortTermIndicatorConfig;
import com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager;
import com.bytedance.android.livesdkapi.sti.ITempShortTermManager;
import com.bytedance.android.livesdkapi.sti.ShortTermIcon;
import com.bytedance.android.livesdkapi.sti.ShortTermIndicatorEvent;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002B\u0007¢\u0006\u0004\bG\u0010HJ\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0014J\b\u0010\f\u001a\u00020\tH\u0016J&\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0016\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001a0\u001a0\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\u001e\u0010$\u001a\u00020\t2\u0014\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0016J\u0012\u0010'\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\n\u0010(\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010)H\u0016R\"\u0010,\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00040\u00040+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R \u00100\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\"\u00102\u001a\u0010\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u001a0\u001a0\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R$\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00101R\u0014\u00106\u001a\u0002058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0018\u00108\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0014\u0010=\u001a\u00020:8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u0010<R\u001a\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u001a\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010?R \u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030C8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/ShortTermIndicatorManager;", "Lcom/bytedance/android/livesdkapi/sti/IShortTermIndicatorManager;", "Lcom/bytedance/android/live/core/arch/mvvm/StatefulViewModel;", "", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIcon;", "", "typeId", "getPriority", "type", "", "addHighPriorityShortTerm", "onCleared", "refresh", "manager", "Lcom/bytedance/android/live/core/arch/mvvm/a;", "view", "Lio/reactivex/disposables/Disposable;", "subscribeLifetime", "icon", "add", "activate", "remove", "", "contains", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig;", "config", "Lcom/bytedance/android/livesdkapi/sti/ShortTermIndicatorEvent;", "event", "notify", "Lio/reactivex/subjects/PublishSubject;", "kotlin.jvm.PlatformType", "getNotification", "indexOf", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$ForbiddenType;", "forbiddenTypes", "setForbiddenTypesMap", "Lcom/bytedance/android/livesdkapi/sti/ITempShortTermManager;", "iTempShortTermManager", "setTempShortTermManager", "getTempShortTermManager", "", "getCurrentIconState", "Ljava/util/LinkedList;", "currentIcons", "Ljava/util/LinkedList;", "", "Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTermIndicatorConfig$Element;", "iconConfig", "Ljava/util/Map;", "eventSubject", "Lio/reactivex/subjects/PublishSubject;", "forbiddenTypesMap", "Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/m;", "shortTouchLazyShowController", "Lcom/bytedance/android/livesdk/chatroom/indicator/shortterm/m;", "mTempShortTermManager", "Lcom/bytedance/android/livesdkapi/sti/ITempShortTermManager;", "", "getTag", "()Ljava/lang/String;", "tag", "getData", "()Ljava/util/List;", "data", "getIcons", "icons", "Lio/reactivex/Observable;", "getOnIconChanged", "()Lio/reactivex/Observable;", "onIconChanged", "<init>", "()V", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTermIndicatorManager extends StatefulViewModel<List<? extends ShortTermIcon>, List<? extends ShortTermIcon>> implements IShortTermIndicatorManager {
    private final LinkedList<ShortTermIcon> currentIcons;
    private final PublishSubject<ShortTermIndicatorEvent> eventSubject;
    private Map<Integer, ShortTermIndicatorConfig.ForbiddenType> forbiddenTypesMap;
    private final Map<Integer, ShortTermIndicatorConfig.Element> iconConfig;
    private ITempShortTermManager mTempShortTermManager;
    private final m shortTouchLazyShowController;

    @Override // com.bytedance.android.live.core.arch.mvvm.StatefulViewModel
    public String getTag() {
        return "ShortTermIndicatorManager@" + hashCode();
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void refresh() {
        setCurrentState(CollectionsKt.toList(this.currentIcons));
    }

    public ShortTermIndicatorManager() {
        super(CollectionsKt.emptyList());
        this.currentIcons = new LinkedList(getCurrentState());
        this.iconConfig = new LinkedHashMap();
        this.eventSubject = PublishSubject.create();
        this.shortTouchLazyShowController = new m(this);
        b0 r100 = b0.o();
        String r101 = getTag();
        r100.getClass();
        com.bytedance.android.live.core.log.g.i(r101, "init");
    }

    @Override // com.bytedance.android.live.core.arch.mvvm.AbsViewModel
    public List<ShortTermIcon> getData() {
        return (List) getCurrentState();
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public List<ShortTermIcon> getIcons() {
        return (List) state();
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public /* bridge */ /* synthetic */ Observable getNotification() {
        return getNotification();
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public Observable<List<ShortTermIcon>> getOnIconChanged() {
        return stateChanged();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        b0 r100 = b0.o();
        String r101 = getTag();
        r100.getClass();
        com.bytedance.android.live.core.log.g.i(r101, "onCleared");
        this.currentIcons.clear();
        setCurrentState(CollectionsKt.emptyList());
        this.shortTouchLazyShowController.f106650b.clear();
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public List<ShortTermIcon> getCurrentIconState() {
        return this.currentIcons;
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public ITempShortTermManager getTempShortTermManager() {
        return this.mTempShortTermManager;
    }

    @Override // com.bytedance.android.live.core.arch.mvvm.AbsViewModel
    public /* bridge */ /* synthetic */ Object getData() {
        return getData();
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public PublishSubject<ShortTermIndicatorEvent> getNotification() {
        return this.eventSubject;
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void activate(ShortTermIcon r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        int r101 = this.currentIcons.indexOf(r100);
        int r102 = -1;
        if (r101 != (-1)) goto L6;
        b0 r103 = b0.o();
        r103.getClass();
        com.bytedance.android.live.core.log.g.n(getTag(), "activate: icon=" + r100 + " does not exist");
        return;
    L6:
        this.currentIcons.remove(r101);
        int r104 = getPriority(r100.getTypeId());
        LinkedList<ShortTermIcon> r105 = this.currentIcons;
        ListIterator<ShortTermIcon> r106 = r105.listIterator(r105.size());
    L8:
        if (r106.hasPrevious() == false) goto L15;
        if (getPriority(r106.previous().getTypeId()) >= r104) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L8;
        r102 = r106.nextIndex();
        goto L15
    L12:
        r107 = false;
    L15:
        int r108 = r102 + 1;
        b0 r109 = b0.o();
        r109.getClass();
        com.bytedance.android.live.core.log.g.i(getTag(), "activate: icon=" + r100 + " selfPos=" + r101 + " targetPos=" + r108);
        this.currentIcons.add(r108, r100);
        setCurrentState(CollectionsKt.toList(this.currentIcons));
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void add(ShortTermIcon r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        m r101 = this.shortTouchLazyShowController;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "icon");
        if (r100.isEnhancedTouch() == false) goto L6;
    L14:
        boolean r102 = true;
    L16:
        if (r102 == true) goto L19;
        return;
    L19:
        if (e5.f65290a.getValue().booleanValue() == false) goto L31;
        Map<Integer, ShortTermIndicatorConfig.ForbiddenType> r103 = this.forbiddenTypesMap;
        if (r103 == null) goto L31;
        if (r103.containsKey(Integer.valueOf(r100.getTypeId())) == false) goto L31;
        int r104 = indexOf(r100);
        ShortTermIndicatorConfig.ForbiddenType r105 = r103.get(Integer.valueOf(r100.getTypeId()));
        if (r105 == null) goto L28;
        String r106 = r105.getReason();
        if (r106 == null) goto L28;
    L29:
        int r107 = z3.f114681a;
        Intrinsics.checkNotNullParameter(r100, "icon");
        Intrinsics.checkNotNullParameter(r106, "forbiddenReason");
        Map<String, String> r108 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("icon_name", String.valueOf(r100.getTypeId())), TuplesKt.to("icon_order", String.valueOf(r104)), TuplesKt.to("icon_description", r100.getIconDesc()), TuplesKt.to("limitation_type", r106)});
        z3.a(r108, r100);
        j0.l().sendLog("icon_show_limited", r108, new Object[]{IRoom.class, x.class});
        return;
    L28:
        r106 = "reason为空，异常";
    L31:
        int r109 = getPriority(r100.getTypeId());
        LinkedList<ShortTermIcon> r110 = this.currentIcons;
        ListIterator<ShortTermIcon> r111 = r110.listIterator(r110.size());
    L33:
        if (r111.hasPrevious() == false) goto L40;
        if (getPriority(r111.previous().getTypeId()) >= r109) goto L37;
        boolean r112 = true;
    L38:
        if (r112 == false) goto L33;
        int r113 = r111.nextIndex();
    L41:
        int r114 = r113 + 1;
        b0 r115 = b0.o();
        String r116 = getTag();
        String r117 = "add: icon=" + r100 + " priority=" + r109 + " currentSize=" + getCurrentState().size() + " position=" + r114;
        r115.getClass();
        com.bytedance.android.live.core.log.g.i(r116, r117);
        this.currentIcons.add(r114, r100);
        setCurrentState(CollectionsKt.toList(this.currentIcons));
        return;
    L37:
        r112 = false;
        goto L38
    L40:
        r113 = -1;
        goto L41
    L6:
        if (r101.f106650b.size() <= 0) goto L8;
        boolean r118 = true;
    L9:
        if (r118 == false) goto L14;
        if (r101.f106650b.contains(Integer.valueOf(r100.getTypeId())) == false) goto L15;
        new Handler(Looper.getMainLooper()).post(new l(r101));
        goto L14
    L15:
        r101.f106651c.add(r100);
        r102 = false;
        goto L16
    L8:
        r118 = false;
        goto L9
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void addHighPriorityShortTerm(int r100) {
        this.shortTouchLazyShowController.f106650b.add(Integer.valueOf(r100));
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void config(ShortTermIndicatorConfig r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Map<Integer, ShortTermIndicatorConfig.Element> r101 = this.iconConfig;
        Map<Integer, ShortTermIndicatorConfig.Element> r102 = r100.getElements();
        if (r102 != null) goto L5;
        r102 = new LinkedHashMap();
    L5:
        r101.putAll(r102);
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public boolean contains(ShortTermIcon r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        return this.currentIcons.contains(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public int getPriority(int r100) {
        ShortTermIndicatorConfig.Element r101 = this.iconConfig.get(Integer.valueOf(r100));
        if (r101 != null) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return r101.getPriority();
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public int indexOf(ShortTermIcon r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        return this.currentIcons.indexOf(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void notify(ShortTermIndicatorEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        b0 r101 = b0.o();
        r101.getClass();
        com.bytedance.android.live.core.log.g.i(getTag(), "notify: event=" + r100);
        this.eventSubject.onNext(r100);
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void remove(ShortTermIcon r100) {
        Intrinsics.checkNotNullParameter(r100, "icon");
        boolean r101 = this.currentIcons.remove(r100);
        b0 r102 = b0.o();
        r102.getClass();
        com.bytedance.android.live.core.log.g.i(getTag(), "remove: icon=" + r100 + " success=" + r101);
        setCurrentState(CollectionsKt.toList(this.currentIcons));
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void setForbiddenTypesMap(Map<Integer, ShortTermIndicatorConfig.ForbiddenType> r100) {
        this.forbiddenTypesMap = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public void setTempShortTermManager(ITempShortTermManager r100) {
        this.mTempShortTermManager = r100;
    }

    @Override // com.bytedance.android.livesdkapi.sti.IShortTermIndicatorManager
    public Disposable subscribeLifetime(IShortTermIndicatorManager r100, com.bytedance.android.live.core.arch.mvvm.a<List<ShortTermIcon>> r101) {
        Intrinsics.checkNotNullParameter(r100, "manager");
        Intrinsics.checkNotNullParameter(r101, "view");
        if ((r100 instanceof ShortTermIndicatorManager) == true) goto L5;
        return null;
    L5:
        return ((ShortTermIndicatorManager) r100).subscribe(r101);
    }
}
