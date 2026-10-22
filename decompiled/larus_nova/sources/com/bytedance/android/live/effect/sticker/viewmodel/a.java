package com.bytedance.android.live.effect.sticker.viewmodel;

import com.ss.android.ugc.effectmanager.effect.model.SearchEffectModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a<T, R> {

    /* JADX INFO: renamed from: com.bytedance.android.live.effect.sticker.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C1121a<R> extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f68816a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final R f68817b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C1121a) == false) goto L10;
            C1121a r101 = (C1121a) r100;
            if (Intrinsics.areEqual(this.f68816a, r101.f68816a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f68817b, r101.f68817b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Throwable r100 = this.f68816a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            R r104 = this.f68817b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Error(exception=" + this.f68816a + ", trace=" + this.f68817b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C1121a(Throwable r100, StickerSearchViewModel.b r101) {
            this.f68816a = r100;
            this.f68817b = r101;
        }
    }

    public static final class b<T, R> extends a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f68818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final R f68819b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f68818a, r101.f68818a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f68819b, r101.f68819b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            T r100 = this.f68818a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            R r104 = this.f68819b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Success(data=" + this.f68818a + ", trace=" + this.f68819b + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(SearchEffectModel r100, StickerSearchViewModel.b r101) {
            this.f68818a = r100;
            this.f68819b = r101;
        }
    }

    public a() {
    }
}
