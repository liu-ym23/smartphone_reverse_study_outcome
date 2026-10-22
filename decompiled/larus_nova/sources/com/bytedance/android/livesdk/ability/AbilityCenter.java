package com.bytedance.android.livesdk.ability;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J'\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010\f*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0016¢\u0006\u0002\u0010\u000eJ4\u0010\u000f\u001a\u00020\u0010\"\b\b\u0000\u0010\f*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00100\u0012H\u0016J&\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\f0\u0014\"\b\b\u0000\u0010\f*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0016J\u0006\u0010\u0015\u001a\u00020\u0010J-\u0010\u0016\u001a\u00020\u0010\"\b\b\u0000\u0010\f*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\u0006\u0010\u0017\u001a\u0002H\fH\u0016¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0016¢\u0006\u0002\u0010\u000eJ \u0010\u001a\u001a\u00020\u0010\"\b\b\u0000\u0010\f*\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0016R$\u0010\u0003\u001a\u0018\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000RD\u0010\u0007\u001a8\u00124\u00122\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0006 \n*\u0018\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/ability/AbilityCenter;", "Lcom/bytedance/android/livesdk/ability/IAbilityCenter;", "()V", "abilityMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/bytedance/android/livesdk/ability/IAbility;", "registerSubject", "Lio/reactivex/subjects/PublishSubject;", "Lkotlin/Pair;", "kotlin.jvm.PlatformType", "getAbility", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Ljava/lang/Class;)Lcom/bytedance/android/livesdk/ability/IAbility;", "invokeAbilityIfExist", "", "func", "Lkotlin/Function1;", "observeAbility", "Lio/reactivex/Observable;", "onClear", "registerAbility", "ability", "(Ljava/lang/Class;Lcom/bytedance/android/livesdk/ability/IAbility;)V", "requireAbility", "unregisterAbility", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AbilityCenter implements IAbilityCenter {
    private final ConcurrentHashMap<Class<? extends IAbility>, IAbility> abilityMap;
    private final PublishSubject<Pair<Class<? extends IAbility>, IAbility>> registerSubject;

    public final void onClear() {
        Iterator<Map.Entry<Class<? extends IAbility>, IAbility>> r100 = this.abilityMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().onAbilityClear();
        goto L4
    L6:
        this.abilityMap.clear();
    }

    public AbilityCenter() {
        this.abilityMap = new ConcurrentHashMap();
        this.registerSubject = PublishSubject.create();
    }

    @Override // com.bytedance.android.livesdk.ability.IAbilityCenter
    public <T extends IAbility> T getAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        IAbility r101 = this.abilityMap.get(r100);
        if ((r101 instanceof IAbility) == true) goto L6;
        r101 = null;
    L6:
        return (T) r101;
    }

    @Override // com.bytedance.android.livesdk.ability.IAbilityCenter
    public <T extends IAbility> Observable<T> observeAbility(final Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        IAbility r101 = this.abilityMap.get(r100);
        if ((r101 instanceof IAbility) == true) goto L5;
        r101 = null;
    L5:
        IAbility r102 = r101;
        if (r102 == null) goto L9;
        return Single.just(r102).toObservable();
    L9:
        return (Observable<T>) this.registerSubject.filter(new AnonymousClass1(r100)).map(AnonymousClass2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.ability.IAbilityCenter
    public <T extends IAbility> T requireAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        IAbility r101 = this.abilityMap.get(r100);
        if ((r101 instanceof IAbility) == true) goto L5;
        r101 = null;
    L5:
        T r102 = (T) r101;
        if (r102 == null) goto L9;
        return r102;
    L9:
        throw new RuntimeException("获取IAbility失败，未注册[" + r100.getSimpleName() + "]的实现类");
    }

    @Override // com.bytedance.android.livesdk.ability.IAbilityCenter
    public <T extends IAbility> void unregisterAbility(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        this.abilityMap.remove(r100);
    }

    @Override // com.bytedance.android.livesdk.ability.IAbilityCenter
    public <T extends IAbility> void invokeAbilityIfExist(Class<T> r100, Function1<? super T, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "func");
        IAbility r102 = this.abilityMap.get(r100);
        if ((r102 instanceof IAbility) == true) goto L5;
        r102 = null;
    L5:
        IAbility r103 = r102;
        if (r103 == null) goto L9;
        r101.invoke(r103);
        return;
    }

    @Override // com.bytedance.android.livesdk.ability.IAbilityCenter
    public <T extends IAbility> void registerAbility(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "ability");
        this.abilityMap.put(r100, r101);
        this.registerSubject.onNext(TuplesKt.to(r100, r101));
    }
}
