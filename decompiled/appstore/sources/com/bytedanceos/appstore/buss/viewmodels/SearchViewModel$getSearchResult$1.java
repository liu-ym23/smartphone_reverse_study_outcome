package com.bytedanceos.appstore.buss.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedanceos.appstore.buss.entity.AppSubEntity;
import com.bytedanceos.appstore.buss.entity.CommonAppEntity;
import com.bytedanceos.appstore.buss.entity.SearchResultEntityWrap;
import com.bytedanceos.appstore.buss.entity.SearchResultPromoteEntity;
import com.bytedanceos.appstore.buss.entity.SearchResultRelatedEntityWrap;
import com.bytedanceos.appstore.buss.network.h;
import com.bytedanceos.appstore.buss.viewmodels.repository.SearchRepository;
import com.bytedanceos.common.BaseApplication;
import com.obric.appstore.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.t;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.SearchViewModel$getSearchResult$1", f = "SearchViewModel.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class SearchViewModel$getSearchResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $searchKey;
    Object L$0;
    int label;
    final /* synthetic */ SearchViewModel this$0;

    /* JADX INFO: renamed from: com.bytedanceos.appstore.buss.viewmodels.SearchViewModel$getSearchResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u001a\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/bytedanceos/appstore/buss/network/h;", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lcom/bytedanceos/appstore/buss/network/h;"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "com.bytedanceos.appstore.buss.viewmodels.SearchViewModel$getSearchResult$1$1", f = "SearchViewModel.kt", i = {0}, l = {130}, m = "invokeSuspend", n = {"dataList"}, s = {"L$0"})
    @SourceDebugExtension({"SMAP\nSearchViewModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/SearchViewModel$getSearchResult$1$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,217:1\n766#2:218\n857#2,2:219\n1855#2,2:221\n1864#2,3:223\n*S KotlinDebug\n*F\n+ 1 SearchViewModel.kt\ncom/bytedanceos/appstore/buss/viewmodels/SearchViewModel$getSearchResult$1$1\n*L\n135#1:218\n135#1:219,2\n156#1:221,2\n169#1:223,3\n*E\n"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
        final /* synthetic */ String $searchKey;
        Object L$0;
        int label;
        final /* synthetic */ SearchViewModel this$0;

        public AnonymousClass1(String r10, SearchViewModel r11, Continuation<? super AnonymousClass1> r12) {
            this.$searchKey = r10;
            this.this$0 = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
            return new AnonymousClass1(this.$searchKey, this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super h> r11) {
            return invoke2(r10, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object r23) {
            Object r10 = kotlin.coroutines.intrinsics.a.d();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ArrayList r12 = (ArrayList) this.L$0;
            kotlin.c.b(r23);
            ArrayList r13 = r12;
            Object r14 = r23;
        L11:
            h r15 = (h) r14;
            List<CommonAppEntity> r16 = null;
            if ((r15 instanceof h.c) == false) goto L107;
            if (this.this$0.g() != 1) goto L70;
            this.this$0.w(0);
            this.this$0.v(false);
            h.c r17 = (h.c) r15;
            SearchResultEntityWrap r18 = (SearchResultEntityWrap) r17.a();
            if (r18 == null) goto L31;
            SearchResultRelatedEntityWrap r19 = r18.getRelatedApps();
            if (r19 == null) goto L31;
            List<SearchResultPromoteEntity> r20 = r19.getPromoteApps();
            if (r20 == null) goto L31;
            ArrayList r21 = new ArrayList();
            Iterator<T> r22 = r20.iterator();
        L23:
            if (r22.hasNext() == false) goto L32;
            Object r110 = r22.next();
            String r111 = ((SearchResultPromoteEntity) r110).getName();
            if (r111 == null) goto L23;
            if (TextUtils.isEmpty(r111) == true) goto L23;
            if ((r111.length() * 2) >= 27) goto L23;
            r21.add(r110);
        L32:
            ArrayList r24 = new ArrayList();
            SearchResultEntityWrap r112 = (SearchResultEntityWrap) r17.a();
            if (r112 == null) goto L37;
            SearchResultRelatedEntityWrap r113 = r112.getRelatedApps();
            if (r113 == null) goto L37;
            List<SearchResultPromoteEntity> r114 = r113.getAdApps();
        L38:
            if (r114 == null) goto L46;
            SearchResultEntityWrap r115 = (SearchResultEntityWrap) r17.a();
            if (r115 == null) goto L44;
            SearchResultRelatedEntityWrap r116 = r115.getRelatedApps();
            if (r116 == null) goto L44;
            List<SearchResultPromoteEntity> r117 = r116.getAdApps();
        L45:
            q.e(r117, "null cannot be cast to non-null type kotlin.collections.Collection<com.bytedanceos.appstore.buss.entity.SearchResultPromoteEntity>");
            r24.addAll(r117);
        L44:
            r117 = null;
        L46:
            if (r21 == null) goto L48;
            r24.addAll(r21);
        L48:
            List r25 = c9.a.g(r24, 3);
            SearchResultEntityWrap r26 = (SearchResultEntityWrap) r17.a();
            if (r26 == null) goto L53;
            SearchResultRelatedEntityWrap r27 = r26.getRelatedApps();
            if (r27 == null) goto L53;
            String r28 = r27.getCategory();
        L55:
            if (TextUtils.isEmpty(r28) == true) goto L63;
            SearchResultPromoteEntity r29 = new SearchResultPromoteEntity(null, null, null, 0, null, null, 63, null);
            r29.setType(2);
            SearchResultEntityWrap r30 = (SearchResultEntityWrap) r17.a();
            if (r30 == null) goto L61;
            SearchResultRelatedEntityWrap r31 = r30.getRelatedApps();
            if (r31 == null) goto L61;
            String r32 = r31.getCategory();
        L62:
            r29.setName(r32);
            r25.add(r29);
        L61:
            r32 = null;
        L63:
            ArrayList r33 = new ArrayList();
            q.d(r25);
            Iterator r34 = r25.iterator();
        L65:
            if (r34.hasNext() == false) goto L68;
            r33.add((SearchResultPromoteEntity) r34.next());
            goto L65
        L68:
            if (r33.isEmpty() == true) goto L70;
            SearchViewModel r35 = this.this$0;
            r13.add(r33);
            r35.w(r35.q() + 1);
        L53:
            r28 = null;
        L37:
            r114 = null;
        L31:
            r21 = null;
        L70:
            h.c r36 = (h.c) r15;
            SearchResultEntityWrap r37 = (SearchResultEntityWrap) r36.a();
            if (r37 == null) goto L73;
            r16 = r37.getApps();
        L73:
            if (r16 == null) goto L131;
            if (r16.isEmpty() == true) goto L131;
            if (this.this$0.h() == true) goto L131;
            SearchViewModel r38 = this.this$0;
            Iterator<T> r39 = r16.iterator();
            int r40 = 0;
        L81:
            if (r39.hasNext() == false) goto L103;
            Object r41 = r39.next();
            int r118 = r40 + 1;
            if (r40 >= 0) goto L85;
            t.q();
        L85:
            CommonAppEntity r42 = (CommonAppEntity) r41;
            if (TextUtils.isEmpty(r42.getOnline_time()) == true) goto L88;
            String r119 = r42.getId();
            q.f(r119, "getId(...)");
            String r120 = r42.getName();
            q.f(r120, "getName(...)");
            String r121 = r42.getLogo();
            String r122 = r42.getOnline_time();
            q.f(r122, "getOnline_time(...)");
            String r123 = r42.getCategory();
            String r124 = r42.getStatus();
            q.f(r124, "getStatus(...)");
            r13.add(new AppSubEntity(r119, r120, "", r121, r122, r123, null, Integer.parseInt(r124), ""));
        L90:
            if (q.b("local", r42.getSource()) == true) goto L101;
            if (r38.h() == true) goto L101;
            if (r40 == 0) goto L101;
            r38.v(true);
            r38.w(r38.q() + r40);
            if (r40 >= r13.size()) goto L101;
            if (r38.g() != 1) goto L99;
            int r43 = 1;
        L100:
            r13.add(r40 + r43, BaseApplication.c().getString(R.string.split_item_desc));
            goto L101
        L99:
            r43 = 0;
        L101:
            r40 = r118;
            goto L81
        L88:
            r13.add(r42);
            goto L90
        L103:
            if (this.this$0.h() == true) goto L131;
            SearchViewModel r44 = this.this$0;
            r44.w(r44.q() + r16.size());
        L131:
            return new h.c(r36.b(), r13, r36.c());
        L107:
            if ((r15 instanceof h.a) == false) goto L110;
            return r15;
        L110:
            if (q.b(r15, h.b.f8818a) == false) goto L114;
            return null;
        L114:
            throw new NoWhenBranchMatchedException();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            kotlin.c.b(r23);
            r13 = new ArrayList();
            SearchRepository r45 = SearchRepository.f9037a;
            String r46 = this.$searchKey;
            int r47 = this.this$0.p();
            int r48 = this.this$0.g();
            int r49 = this.this$0.r();
            this.L$0 = r13;
            this.label = 1;
            r14 = r45.g(r46, r47, r48, r49, this);
            if (r14 != r10) goto L11;
            return r10;
        }

        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super h> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.f21064a);
        }
    }

    public SearchViewModel$getSearchResult$1(SearchViewModel r10, String r11, Continuation<? super SearchViewModel$getSearchResult$1> r12) {
        this.this$0 = r10;
        this.$searchKey = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object r10, @NotNull Continuation<?> r11) {
        return new SearchViewModel$getSearchResult$1(this.this$0, this.$searchKey, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo0invoke(CoroutineScope r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object r10) {
        Object r11 = kotlin.coroutines.intrinsics.a.d();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        MutableLiveData r13 = (MutableLiveData) this.L$0;
        kotlin.c.b(r10);
    L12:
        r13.p(r10);
        return Unit.f21064a;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        kotlin.c.b(r10);
        this.this$0.m().p(h.b.f8818a);
        MutableLiveData r14 = this.this$0.m();
        CoroutineDispatcher r15 = l0.b();
        AnonymousClass1 r16 = new AnonymousClass1(this.$searchKey, this.this$0, null);
        this.L$0 = r14;
        this.label = 1;
        Object r17 = kotlinx.coroutines.h.g(r15, r16, this);
        if (r17 != r11) goto L11;
        return r11;
    L11:
        r10 = r17;
        r13 = r14;
        goto L12
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(@NotNull CoroutineScope r10, @Nullable Continuation<? super Unit> r11) {
        return ((SearchViewModel$getSearchResult$1) create(r10, r11)).invokeSuspend(Unit.f21064a);
    }
}
