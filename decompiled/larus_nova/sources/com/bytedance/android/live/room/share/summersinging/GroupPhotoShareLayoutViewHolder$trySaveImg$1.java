package com.bytedance.android.live.room.share.summersinging;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"onPermissionGranted", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class GroupPhotoShareLayoutViewHolder$trySaveImg$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0 $onFailure;
    final /* synthetic */ Function1 $onSuccess;
    final /* synthetic */ l this$0;

    public static final class a<V> implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupPhotoShareLayoutViewHolder$trySaveImg$1 f100339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f100340b;

        public a(GroupPhotoShareLayoutViewHolder$trySaveImg$1 r100, Bitmap r101) {
            this.f100339a = r100;
            this.f100340b = r101;
        }

        @Override // java.util.concurrent.Callable
        public final String call() {
            GroupPhotoShareLayoutViewHolder$trySaveImg$1 r100 = this.f100339a;
            return com.bytedance.android.livesdk.share.g.d(r100.$context, this.f100340b, r100.this$0.f100359d.SD());
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return call();
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupPhotoShareLayoutViewHolder$trySaveImg$1 f100341a;

        public b(GroupPhotoShareLayoutViewHolder$trySaveImg$1 r100) {
            this.f100341a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            String r101 = (String) r100;
            if (r101 != null) goto L5;
        L12:
            ALogger.e("GroupPhotoShareLayoutViewHolder", "save bitmap error, url is null or empty");
            f2.b(R.string.ttlive_group_photo_save_img_error, 0);
            Function0 r102 = this.f100341a.$onFailure;
            if (r102 == null) goto L15;
            Unit r103 = (Unit) r102.invoke();
        L15:
            Disposable r104 = this.f100341a.this$0.f100358c;
            if (r104 == null) goto L18;
            r104.dispose();
        L18:
            this.f100341a.this$0.f100357b = false;
            return;
        L5:
            if (r101.length() <= 0) goto L7;
            boolean r105 = true;
        L8:
            if (r105 != true) goto L12;
            Function1 r106 = this.f100341a.$onSuccess;
            if (r106 == null) goto L15;
            Unit r107 = (Unit) r106.invoke(r101);
            goto L15
        L7:
            r105 = false;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GroupPhotoShareLayoutViewHolder$trySaveImg$1 f100342a;

        public c(GroupPhotoShareLayoutViewHolder$trySaveImg$1 r100) {
            this.f100342a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            StringBuilder r102 = new StringBuilder("save bitmap error: ");
            if (r101 == null) goto L5;
            String r103 = r101.getMessage();
        L6:
            r102.append(r103);
            ALogger.e("GroupPhotoShareLayoutViewHolder", r102.toString());
            f2.b(R.string.ttlive_group_photo_save_img_error, 0);
            Function0 r104 = this.f100342a.$onFailure;
            if (r104 == null) goto L9;
            Unit r105 = (Unit) r104.invoke();
        L9:
            Disposable r106 = this.f100342a.this$0.f100358c;
            if (r106 == null) goto L12;
            r106.dispose();
        L12:
            this.f100342a.this$0.f100357b = false;
            return;
        L5:
            r103 = null;
            goto L6
        }
    }

    public GroupPhotoShareLayoutViewHolder$trySaveImg$1(l r100, Context r101, Function1 r102, Function0 r103) {
        this.this$0 = r100;
        this.$context = r101;
        this.$onSuccess = r102;
        this.$onFailure = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Bitmap r100 = com.bytedance.android.livesdk.share.g.a(this.this$0.f100359d.fD());
        l r101 = this.this$0;
        r101.f100358c = Single.fromCallable(new a(this, r100)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this), new c(this));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
