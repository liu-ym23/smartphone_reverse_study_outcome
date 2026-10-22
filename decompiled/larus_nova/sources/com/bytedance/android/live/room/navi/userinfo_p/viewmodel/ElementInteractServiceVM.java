package com.bytedance.android.live.room.navi.userinfo_p.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.live.datacontext.DataContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J/\u0010\b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0003*\u00020\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\b\u0010\tJ'\u0010\n\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\n\u0010\u000bR(\u0010\r\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0004\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementInteractServiceVM;", "Lcom/bytedance/live/datacontext/DataContext;", "Ln91/a;", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/Class;", "clazz", "service", "", "registerService", "(Ljava/lang/Class;Ln91/a;)V", "getService", "(Ljava/lang/Class;)Ln91/a;", "", "map", "Ljava/util/Map;", "Lio/reactivex/disposables/CompositeDisposable;", "cd", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ElementInteractServiceVM extends DataContext {

    /* JADX INFO: renamed from: cd, reason: collision with root package name */
    private final CompositeDisposable f100158cd;
    private final Map<Class<? extends n91.a>, n91.a> map;

    public static final class a implements Action {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ElementInteractServiceVM f100159a;

        public a(ElementInteractServiceVM r100) {
            this.f100159a = r100;
        }

        @Override // io.reactivex.functions.Action
        public final void run() {
            ElementInteractServiceVM.access$getMap$p(this.f100159a).clear();
            ElementInteractServiceVM.access$getCd$p(this.f100159a).dispose();
        }
    }

    public ElementInteractServiceVM() {
        this.map = new ConcurrentHashMap();
        CompositeDisposable r100 = new CompositeDisposable();
        this.f100158cd = r100;
        RxUtilKt.c(getOnCleared().subscribe(new a(this)), r100);
    }

    public static final /* synthetic */ CompositeDisposable access$getCd$p(ElementInteractServiceVM r100) {
        return r100.f100158cd;
    }

    public static final /* synthetic */ Map access$getMap$p(ElementInteractServiceVM r100) {
        return r100.map;
    }

    public final <S extends n91.a> S getService(Class<S> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        n91.a r101 = this.map.get(r100);
        if ((r101 instanceof n91.a) == true) goto L6;
        r101 = null;
    L6:
        return (S) r101;
    }

    public final <S extends n91.a> void registerService(Class<? extends S> r100, S r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "service");
        this.map.put(r100, r101);
    }
}
