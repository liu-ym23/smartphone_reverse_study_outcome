package com.stepos.ailauncher.chat.fragment;

import com.stepos.ailauncher.chat.view.PagedListController;
import com.stepos.ailauncher.contract.model.ListPage;
import com.stepos.ailauncher.foundation.appstore.AppVersionListRepository;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionItem;
import com.stepos.ailauncher.foundation.appstore.api.AppVersionSearchPage;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
@InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooAppSearchFragment$scheduleSearch$1", f = "AmooAppSearchFragment.kt", l = {143}, m = "invokeSuspend", v = 1)
/* loaded from: classes3.dex */
public final class AmooAppSearchFragment$scheduleSearch$1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
    final /* synthetic */ String $q;
    int label;
    final /* synthetic */ AmooAppSearchFragment this$0;

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/stepos/ailauncher/contract/model/ListPage;", "Lcom/stepos/ailauncher/foundation/appstore/api/AppVersionItem;", "key", ""}, k = 3, mv = {2, 2, 0}, xi = 48)
    @InterfaceC4112d(c = "com.stepos.ailauncher.chat.fragment.AmooAppSearchFragment$scheduleSearch$1$1", f = "AmooAppSearchFragment.kt", l = {146}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.ailauncher.chat.fragment.AmooAppSearchFragment$scheduleSearch$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Integer, InterfaceC4014c<? super ListPage<AppVersionItem>>, Object> {
        final /* synthetic */ String $q;
        /* synthetic */ int I$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$q = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$q, interfaceC4014c);
            anonymousClass1.I$0 = ((Number) obj).intValue();
            return anonymousClass1;
        }

        public final Object f(int i10, InterfaceC4014c<? super ListPage<AppVersionItem>> interfaceC4014c) {
            return ((AnonymousClass1) create(Integer.valueOf(i10), interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(Integer num, InterfaceC4014c<? super ListPage<AppVersionItem>> interfaceC4014c) {
            return f(num.intValue(), interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i10 = this.I$0;
            Object objG = C4063a.g();
            int i11 = this.label;
            if (i11 == 0) {
                C4849c.b(obj);
                if (i10 == 0) {
                    com.stepos.ailauncher.chat.trace.a.INSTANCE.i(this.$q);
                }
                AppVersionListRepository appVersionListRepository = AppVersionListRepository.INSTANCE;
                String str = this.$q;
                this.I$0 = i10;
                this.label = 1;
                obj = appVersionListRepository.i(str, i10, this);
                if (obj == objG) {
                    return objG;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
            }
            AppVersionSearchPage appVersionSearchPage = (AppVersionSearchPage) obj;
            if (appVersionSearchPage == null) {
                throw new IllegalStateException("App search failed");
            }
            if (!appVersionSearchPage.getMore() || appVersionSearchPage.getPageSize() > 0) {
                return new ListPage(appVersionSearchPage.getItems(), appVersionSearchPage.getMore() ? C4109a.f(i10 + appVersionSearchPage.getPageSize()) : null, null, 4, null);
            }
            throw new IllegalStateException("Search cursor did not advance");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmooAppSearchFragment$scheduleSearch$1(AmooAppSearchFragment amooAppSearchFragment, String str, InterfaceC4014c<? super AmooAppSearchFragment$scheduleSearch$1> interfaceC4014c) {
        super(2, interfaceC4014c);
        this.this$0 = amooAppSearchFragment;
        this.$q = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
        return new AmooAppSearchFragment$scheduleSearch$1(this.this$0, this.$q, interfaceC4014c);
    }

    @Override // p9.p
    public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
        return ((AmooAppSearchFragment$scheduleSearch$1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PagedListController pagedListController;
        Object objG = C4063a.g();
        int i10 = this.label;
        if (i10 == 0) {
            C4849c.b(obj);
            this.label = 1;
            if (Ua.U.a(300L, this) == objG) {
                return objG;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
        }
        PagedListController pagedListController2 = this.this$0.pages;
        if (pagedListController2 == null) {
            kotlin.jvm.internal.p.A("pages");
            pagedListController = null;
        } else {
            pagedListController = pagedListController2;
        }
        PagedListController.x(pagedListController, 0, null, new AnonymousClass1(this.$q, null), 2, null);
        return Y8.t.f7040a;
    }
}
