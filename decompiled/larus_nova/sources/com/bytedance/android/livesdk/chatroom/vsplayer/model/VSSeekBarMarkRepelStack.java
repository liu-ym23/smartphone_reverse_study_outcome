package com.bytedance.android.livesdk.chatroom.vsplayer.model;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes8.dex */
public final class VSSeekBarMarkRepelStack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f118394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Pair<String, List<e>>> f118395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PublishSubject<VSSeekBarMarkRepelStack> f118396c;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.vsplayer.model.VSSeekBarMarkRepelStack$update$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/e;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/android/livesdk/chatroom/vsplayer/model/e;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
    final class AnonymousClass1 extends Lambda implements Function1<e, Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(e r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(e r100) {
            invoke2(r100);
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final Pair<String, List<e>> a() {
        return (Pair) ListProtector.get(this.f118395b, 0);
    L4:
        return null;
    }

    public VSSeekBarMarkRepelStack() {
        this.f118394a = "notify_change_type_init";
        this.f118395b = new ArrayList();
        PublishSubject<VSSeekBarMarkRepelStack> r100 = PublishSubject.create();
        r100.observeOn(AndroidSchedulers.mainThread());
        Unit r101 = Unit.INSTANCE;
        this.f118396c = r100;
    }

    public final void b(Pair<String, ? extends List<e>> r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Iterator<Pair<String, List<e>>> r101 = this.f118395b.iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L9;
        if (Intrinsics.areEqual(r101.next().getFirst(), r100.getFirst()) == true) goto L10;
        r102 = r102 + 1;
    L10:
        if (r102 == (-1)) goto L12;
        List<Pair<String, List<e>>> r103 = CollectionsKt.toMutableList(CollectionsKt.drop(this.f118395b, RangesKt.coerceAtLeast(r102, 0)));
        this.f118395b = r103;
        ListProtector.set(r103, 0, r100);
    L13:
        this.f118394a = "notify_change_type_push_delete";
        this.f118396c.onNext(this);
        return;
    L12:
        ListProtector.add(this.f118395b, 0, r100);
        goto L13
    L9:
        r102 = -1;
        goto L10
    }

    public final boolean delete(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        boolean r101 = CollectionsKt.removeAll(this.f118395b, new VSSeekBarMarkRepelStack$delete$b$1(r100));
        this.f118394a = "notify_change_type_push_delete";
        this.f118396c.onNext(this);
        return r101;
    }

    public final void update(String r100, Function1<? super e, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "updateAction");
        Iterator<T> r102 = this.f118395b.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if (Intrinsics.areEqual((String) ((Pair) r103).getFirst(), r100) == false) goto L4;
    L9:
        Pair r104 = (Pair) r103;
        if (r104 == null) goto L17;
        List r105 = (List) r104.getSecond();
        if (r105 == null) goto L17;
        Iterator r106 = r105.iterator();
    L15:
        if (r106.hasNext() == false) goto L17;
        r101.invoke((e) r106.next());
    L17:
        this.f118394a = "notify_change_type_update";
        this.f118396c.onNext(this);
        return;
    L8:
        r103 = null;
        goto L9
    }
}
