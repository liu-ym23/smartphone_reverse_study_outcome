package com.bytedance.android.gamecp.business.comment.edit.upload;

import android.content.Context;
import com.bytedance.android.gamecp.base.network.response.i;
import com.bytedance.android.gamecp.business.api.GamePromoteApi;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import wu.l4;

/* JADX INFO: loaded from: classes44.dex */
public final class CommentImgUploadCenter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final long f52176e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f52177f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<String, b> f52178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashMap<String, b> f52179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f52180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<List<String>, Function1<LinkedHashMap<String, String>, Unit>> f52181d;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f52182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f52183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f52184c;

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "originPath");
            Intrinsics.checkNotNullParameter(r101, "compressPath");
            this.f52182a = r100;
            this.f52183b = r101;
            this.f52184c = null;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f52185a;

        public c(Context r100) {
            this.f52185a = r100;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L8;
            String r104 = (String) r103.next();
            int r105 = pt.a.f530616a;
            pt.a.C7243a r106 = pt.a.a(this.f52185a, r104, CommentImgUploadCenter.f52176e);
            if (r106.f530617a == false) goto L4;
            r102.add(new b(r104, r106.f530618b));
            goto L4
        L8:
            return r102;
        }
    }

    public static final class d<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CommentImgUploadCenter f52186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1 f52187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f52188c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f52189d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Context f52190e;

        public d(CommentImgUploadCenter r100, Function1 r101, boolean r102, Ref.BooleanRef r103, Context r104) {
            this.f52186a = r100;
            this.f52187b = r101;
            this.f52188c = r102;
            this.f52189d = r103;
            this.f52190e = r104;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            final ArrayList r101 = (ArrayList) r100;
            Intrinsics.checkNotNullParameter(r101, "uploadList");
            ArrayList r102 = new ArrayList();
            Iterator<T> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L9;
            T r104 = r103.next();
            if ((!this.f52186a.f52179b.containsKey(((b) r104).f52182a)) == false) goto L4;
            r102.add(r104);
            goto L4
        L9:
            if (r102.isEmpty() == false) goto L11;
            this.f52186a.c(r101, this.f52187b, this.f52188c);
        L27:
            return Unit.INSTANCE;
        L11:
            CommentImgUploadCenter r105 = this.f52186a;
            monitor-enter(r105);
            Iterator r106 = r102.iterator();     // Catch: Throwable -> L30
        L15:
            if (r106.hasNext() == false) goto L18;
            b r107 = (b) r106.next();     // Catch: Throwable -> L30
            r105.f52178a.put(r107.f52182a, r107);     // Catch: Throwable -> L30
            goto L15
        L18:
            monitor-exit(r105);
            int r108 = pt.a.f530616a;
            int r109 = r102.size();
            ArrayList r110 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator r111 = r102.iterator();
        L21:
            if (r111.hasNext() == false) goto L23;
            r110.add(((b) r111.next()).f52183b);
            goto L21
        L23:
            Object[] r112 = r110.toArray(new String[0]);
            if (r112 == null) goto L29;
            String[] r113 = (String[]) r112;
            CompositeDisposable r114 = this.f52186a.f52180c;
            com.bytedance.android.gamecp.business.comment.edit.upload.a r115 = new com.bytedance.android.gamecp.business.comment.edit.upload.a(this, r102, r101);
            Function0<Unit> r116 = new CommentImgUploadCenter$uploadImage$2$3(this, r101);
            Intrinsics.checkNotNullParameter(r113, "path");
            Intrinsics.checkNotNullParameter(r114, "compositeDisposable");
            Intrinsics.checkNotNullParameter(r115, "listener");
            Observable<i<qt.a>> r117 = ((GamePromoteApi) bs.e.a().b(GamePromoteApi.class)).getImageXToken();
            hv.b r118 = hv.d.f487273a;
            r114.add(r117.compose(new hv.a()).doFinally(pt.b.f530619a).subscribe(new pt.d(r109, r113, r115), new pt.e(r116)));
            goto L27
        L29:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L30:
            th = move-exception;
            throw th;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f52191a = null;

        static {
            f52191a = new e();
        }

        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        public final /* bridge */ /* synthetic */ void accept(Object r100) {
            Unit r101 = (Unit) r100;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f52192a = null;

        static {
            f52192a = new f();
        }

        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = x8.a.f562881a;
            String r102 = CommentImgUploadCenter.f52177f;
            x8.a.c(r102, (Throwable) r100, false);
        }
    }

    static {
        f52176e = l4.f561346a.getValue().b();
        f52177f = "CommentUpload";
    }

    public CommentImgUploadCenter() {
        this.f52178a = new LinkedHashMap();
        this.f52179b = new LinkedHashMap();
        this.f52180c = new CompositeDisposable();
        this.f52181d = new HashMap();
    }

    public static final void a(CommentImgUploadCenter r100, b r101) {
        monitor-enter(r100);
        if (r101 != null) goto L14;
        monitor-exit(r100);
        return;
    L14:
        b r102 = r100.f52178a.remove(r101.f52182a);     // Catch: Throwable -> L11
        if (r102 == null) goto L9;
        r100.f52179b.put(r102.f52182a, r102);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(List<b> r100, final Function1<? super LinkedHashMap<String, String>, Unit> r101, final boolean r102) {
        monitor-enter(this);
        yr.c.e(f52177f, "uploadImageComplete");     // Catch: Throwable -> L21
        final LinkedHashMap r103 = new LinkedHashMap();     // Catch: Throwable -> L21
        Iterator<T> r104 = r100.iterator();     // Catch: Throwable -> L21
    L5:
        if (r104.hasNext() == false) goto L18;
        b r105 = (b) r104.next();     // Catch: Throwable -> L21
        b r106 = this.f52179b.get(r105.f52182a);     // Catch: Throwable -> L21
        if (r106 == null) goto L9;
        String r107 = r106.f52184c;     // Catch: Throwable -> L21
    L10:
        if (r107 != null) goto L12;
    L15:
        boolean r108 = true;
    L16:
        if (r108 == true) goto L5;
        r103.put(r105.f52182a, r107);     // Catch: Throwable -> L21
        goto L5
    L12:
        if (StringsKt.isBlank(r107) == true) goto L15;
        r108 = false;
        goto L16
    L9:
        r107 = null;
        goto L10
    L18:
        UtilityKotlinExtentionsKt.g(0, false, false, new CommentImgUploadCenter$uploadImageComplete$2(this, r102, r101, r103), 7);     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final void b(List<String> r100, Context r101, boolean r110, Function1<? super LinkedHashMap<String, String>, Unit> r111) {
        Intrinsics.checkNotNullParameter(r100, "imgLocalPathLists");
        Intrinsics.checkNotNullParameter(r101, "ctx");
        Intrinsics.checkNotNullParameter(r111, "uploadSuc");
        if (((ArrayList) r100).isEmpty() == false) goto L6;
        c(CollectionsKt.emptyList(), r111, r110);
        return;
    L6:
        System.currentTimeMillis();
        Ref.BooleanRef r102 = new Ref.BooleanRef();
        r102.element = false;
        Disposable r103 = Observable.just(r100).map(new c(r101)).map(new d(this, r111, r110, r102, r101)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(e.f52191a, f.f52192a);
        this.f52180c.add(r103);
    }
}
