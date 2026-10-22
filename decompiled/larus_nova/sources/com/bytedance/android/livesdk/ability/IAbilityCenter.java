package com.bytedance.android.livesdk.ability;

import androidx.exifinterface.media.ExifInterface;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J'\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007J4\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\t0\u000bH&J&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00030\r\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&J-\u0010\u000e\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00062\u0006\u0010\u000f\u001a\u0002H\u0003H&¢\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¢\u0006\u0002\u0010\u0007J \u0010\u0012\u001a\u00020\t\"\b\b\u0000\u0010\u0003*\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H&¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ability/IAbilityCenter;", "", "getAbility", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/bytedance/android/livesdk/ability/IAbility;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Lcom/bytedance/android/livesdk/ability/IAbility;", "invokeAbilityIfExist", "", "func", "Lkotlin/Function1;", "observeAbility", "Lio/reactivex/Observable;", "registerAbility", "ability", "(Ljava/lang/Class;Lcom/bytedance/android/livesdk/ability/IAbility;)V", "requireAbility", "unregisterAbility", "room-flow_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IAbilityCenter {
    <T extends IAbility> T getAbility(Class<T> r100);

    <T extends IAbility> void invokeAbilityIfExist(Class<T> r100, Function1<? super T, Unit> r101);

    <T extends IAbility> Observable<T> observeAbility(Class<T> r100);

    <T extends IAbility> void registerAbility(Class<T> r100, T r101);

    <T extends IAbility> T requireAbility(Class<T> r100);

    <T extends IAbility> void unregisterAbility(Class<T> r100);
}
