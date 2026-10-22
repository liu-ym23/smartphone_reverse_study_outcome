package com.bytedance.android.live.xplay.basic;

import com.bytedance.android.live.xplay.basic.log.XplayLog;
import io.reactivex.Completable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o> f102779a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<q, r, Unit> f102780b;

    public final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f102781a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r f102782b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Completable f102783c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Collection<q> f102784d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ d f102785e;

        /* JADX INFO: renamed from: com.bytedance.android.live.xplay.basic.d$a$a, reason: collision with other inner class name */
        public static final class C1556a<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f102786a;

            public C1556a(a r100) {
                this.f102786a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Disposable r101 = (Disposable) r100;
                this.f102786a.b(new r.e());
            }
        }

        public static final class b<T> implements Consumer {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f102787a;

            public b(a r100) {
                this.f102787a = r100;
            }

            @Override // io.reactivex.functions.Consumer
            public final void accept(Object r100) {
                Throwable r101 = (Throwable) r100;
                a r102 = this.f102787a;
                if (r101 != null) goto L9;
                r r103 = this.f102787a.f102782b;
                if (r103 == null) goto L8;
                r r104 = new r.b((r.e) r103);
            L12:
                r102.b(r104);
                return;
            L8:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.xplay.basic.XplayTaskState.Running");
            L9:
                r r105 = this.f102787a.f102782b;
                if (r105 == null) goto L15;
                r104 = new r.c((r.e) r105, r101);
                goto L12
            L15:
                throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.xplay.basic.XplayTaskState.Running");
            }
        }

        @Override // com.bytedance.android.live.xplay.basic.q
        public final Completable a() {
            return this.f102783c;
        }

        @Override // com.bytedance.android.live.xplay.basic.q
        public final o getTask() {
            return this.f102781a;
        }

        public a(d r100) {
            this.f102785e = r100;
            this.f102781a = r100;
            this.f102782b = r.d.f102866a;
            List<o> r101 = r100.f102779a;
            ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
            Iterator<T> r103 = r101.iterator();
        L4:
            if (r103.hasNext() == false) goto L6;
            r102.add(((o) r103.next()).a());
            goto L4
        L6:
            this.f102784d = r102;
            b(r.d.f102866a);
            Intrinsics.checkNotNullParameter(r102, "components");
            ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
            Iterator r105 = r102.iterator();
        L8:
            if (r105.hasNext() == false) goto L10;
            r104.add(((q) r105.next()).a());
            goto L8
        L10:
            this.f102783c = Completable.concat(r104).doOnSubscribe(new C1556a(this)).doOnEvent(new b(this));
        }

        public final void b(r r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            this.f102782b = r100;
            if ((r100 instanceof r.d) == false) goto L6;
        L17:
            Function2<q, r, Unit> r101 = this.f102785e.f102780b;
            if (r101 == null) goto L21;
            Unit r102 = r101.invoke(this, r100);
            return;
        L21:
            return;
        L6:
            if ((r100 instanceof r.f) == false) goto L9;
            int r103 = XplayLog.f102848a;
            XplayLog.a("XplayTask", "composite task '" + ((m) this.f102785e).f102851c + "' skipped");
            goto L17
        L9:
            if ((r100 instanceof r.e) == false) goto L12;
            int r104 = XplayLog.f102848a;
            XplayLog.a("XplayTask", "composite task '" + ((m) this.f102785e).f102851c + "' started");
            goto L17
        L12:
            if ((r100 instanceof r.b) == false) goto L15;
            int r105 = XplayLog.f102848a;
            XplayLog.c("XplayTask", "composite task '" + ((m) this.f102785e).f102851c + "' completed in " + ((r.b) r100).a().longValue() + "ms");
            goto L17
        L15:
            if ((r100 instanceof r.c) == false) goto L17;
            int r106 = XplayLog.f102848a;
            StringBuilder r107 = new StringBuilder("composite task '");
            r107.append(((m) this.f102785e).f102851c);
            r107.append("' failed in ");
            r.c r108 = (r.c) r100;
            r107.append(Long.valueOf(Long.valueOf(r108.f102864b).longValue() - Long.valueOf(r108.f102863a).longValue()).longValue());
            r107.append("ms: ");
            r107.append(r108.f102865c);
            XplayLog.b("XplayTask", r107.toString());
            goto L17
        }
    }

    @Override // com.bytedance.android.live.xplay.basic.o
    public final q a() {
        return new a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(List<? extends o> r100, Function2<? super q, ? super r, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "tasks");
        this.f102779a = r100;
        this.f102780b = r101;
    }
}
