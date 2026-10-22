package com.bytedance.android.shopping.anchorv3.auction.data.remote;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.PositionalDataSource;
import com.bytedance.android.ec.core.data.LoadingStatus;
import com.bytedance.android.ec.core.data.PagingLoadingStatus;
import com.bytedance.android.shopping.anchorv3.auction.AnchorV3AuctionOfferRecordsFragment;
import com.bytedance.android.shopping.anchorv3.auction.data.AuctionOfferRecordsRequest;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/auction/data/remote/AuctionOfferRecordsPagingDataSource;", "Landroidx/paging/PositionalDataSource;", "Lj53/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuctionOfferRecordsPagingDataSource extends PositionalDataSource<j53.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<PagingLoadingStatus> f164470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<LoadingStatus> f164471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AnchorV3AuctionOfferRecordsFragment.OfferRecordsParams f164472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i53.b f164473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.ec.core.async.b f164474e;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuctionOfferRecordsPagingDataSource f164475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PositionalDataSource.LoadInitialCallback f164476b;

        public a(AuctionOfferRecordsPagingDataSource r100, PositionalDataSource.LoadInitialCallback r101) {
            this.f164475a = r100;
            this.f164476b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v5, types: [androidx.paging.PositionalDataSource$LoadInitialCallback] */
        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v1, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r2v2, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AuctionOfferRecordsResponse r101 = (AuctionOfferRecordsResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "$this$isResponseSuccess");
            if (r101.getStatusCode() != 0) goto L5;
            boolean r102 = true;
        L6:
            if (r102 == false) goto L15;
            ?? r103 = this.f164476b;
            List<RecordList> r104 = r101.getRecords();
            if (r104 == null) goto L13;
            List<RecordList> r105 = r104;
            ?? r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator<T> r107 = r105.iterator();
        L11:
            if (r107.hasNext() == false) goto L14;
            r106.add(j53.b.b((RecordList) r107.next()));
        L14:
            r103.onResult(r106, 0);
            this.f164475a.f164471b.postValue(LoadingStatus.SUCCESS);
            return;
        L13:
            r106 = CollectionsKt.emptyList();
            goto L14
        L15:
            this.f164475a.f164471b.postValue(LoadingStatus.ERROR);
            return;
        L5:
            r102 = false;
            goto L6
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuctionOfferRecordsPagingDataSource f164477a;

        public b(AuctionOfferRecordsPagingDataSource r100) {
            this.f164477a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f164477a.f164471b.postValue(LoadingStatus.ERROR);
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuctionOfferRecordsPagingDataSource f164478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PositionalDataSource.LoadRangeCallback f164479b;

        public c(AuctionOfferRecordsPagingDataSource r100, PositionalDataSource.LoadRangeCallback r101) {
            this.f164478a = r100;
            this.f164479b = r101;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.util.List] */
        /* JADX WARN: Type inference failed for: r5v5, types: [androidx.paging.PositionalDataSource$LoadRangeCallback] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            AuctionOfferRecordsResponse r101 = (AuctionOfferRecordsResponse) r100;
            Intrinsics.checkNotNullParameter(r101, "$this$isResponseSuccess");
            boolean r102 = true;
            if (r101.getStatusCode() != 0) goto L5;
            boolean r103 = true;
        L6:
            if (r103 == false) goto L23;
            List<RecordList> r104 = r101.getRecords();
            if (r104 == null) goto L13;
            List<RecordList> r105 = r104;
            ?? r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
            Iterator<T> r107 = r105.iterator();
        L11:
            if (r107.hasNext() == false) goto L14;
            r106.add(j53.b.b((RecordList) r107.next()));
        L14:
            this.f164479b.onResult(r106);
            Collection r108 = (Collection) r106;
            if (r108 != null) goto L17;
        L20:
            if (r102 == false) goto L22;
            this.f164478a.f164470a.postValue(PagingLoadingStatus.END);
            return;
        L22:
            this.f164478a.f164470a.postValue(PagingLoadingStatus.SUCCESS);
            return;
        L17:
            if (r108.isEmpty() == true) goto L20;
            r102 = false;
            goto L20
        L13:
            r106 = CollectionsKt.emptyList();
            goto L14
        L23:
            this.f164478a.f164470a.postValue(PagingLoadingStatus.ERROR);
            return;
        L5:
            r103 = false;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AuctionOfferRecordsPagingDataSource f164480a;

        public d(AuctionOfferRecordsPagingDataSource r100) {
            this.f164480a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            this.f164480a.f164470a.postValue(PagingLoadingStatus.ERROR);
        }
    }

    @Override // androidx.paging.PositionalDataSource
    public final void loadInitial(PositionalDataSource.LoadInitialParams r100, PositionalDataSource.LoadInitialCallback<j53.a> r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f164471b.postValue(LoadingStatus.LOADING);
        i53.b r102 = this.f164473d;
        AnchorV3AuctionOfferRecordsFragment.OfferRecordsParams r103 = this.f164472c;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(r102.a(new AuctionOfferRecordsRequest(r103.f164435a, r103.f164436b, null, 4, null))).subscribe(new a(this, r101), new b(this)), this.f164474e);
    }

    @Override // androidx.paging.PositionalDataSource
    public final void loadRange(PositionalDataSource.LoadRangeParams r100, PositionalDataSource.LoadRangeCallback<j53.a> r110) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r110, "callback");
        this.f164470a.postValue(PagingLoadingStatus.LOADING);
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(this.f164473d.a(new AuctionOfferRecordsRequest(this.f164472c.f164435a, r100.startPosition, null, 4, null))).subscribe(new c(this, r110), new d(this)), this.f164474e);
    }

    public AuctionOfferRecordsPagingDataSource(AnchorV3AuctionOfferRecordsFragment.OfferRecordsParams r100, i53.b r101, com.bytedance.android.ec.core.async.b r102) {
        Intrinsics.checkNotNullParameter(r100, "offerRecordsParams");
        Intrinsics.checkNotNullParameter(r101, "remoteDataSource");
        Intrinsics.checkNotNullParameter(r102, "disposableScope");
        this.f164472c = r100;
        this.f164473d = r101;
        this.f164474e = r102;
        this.f164470a = new MutableLiveData();
        this.f164471b = new MutableLiveData();
    }
}
