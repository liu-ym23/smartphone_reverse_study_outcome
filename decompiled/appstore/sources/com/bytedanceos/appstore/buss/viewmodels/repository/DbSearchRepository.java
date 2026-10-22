package com.bytedanceos.appstore.buss.viewmodels.repository;

import androidx.lifecycle.LiveData;
import com.bytedanceos.appstore.buss.entity.bean.SearchHistoryEntityBean;
import com.bytedanceos.appstore.buss.room.search.SearchDatabase;
import com.bytedanceos.appstore.buss.room.search.SearchHistoryDao;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.b;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.o;

/* JADX INFO: loaded from: classes2.dex */
public final class DbSearchRepository {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f9020d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f9021e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f9022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f9023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LiveData f9024c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final DbSearchRepository a() {
            return (DbSearchRepository) DbSearchRepository.a().getValue();
        }

        public a() {
        }
    }

    static {
        f9020d = new a(null);
        f9021e = b.b(DbSearchRepository$Companion$instance$2.INSTANCE);
    }

    public DbSearchRepository() {
        this.f9022a = b.b(DbSearchRepository$searchHistoryDatabase$2.INSTANCE);
        this.f9023b = b.b(new DbSearchRepository$searchHistoryDao$2(this));
        this.f9024c = d().getSearchHistory();
    }

    public static final /* synthetic */ Lazy a() {
        return f9021e;
    }

    public static final /* synthetic */ SearchDatabase b(DbSearchRepository r10) {
        return r10.e();
    }

    public final Object c(Continuation r10) {
        Object r11 = d().deleteAll(r10);
        if (r11 != kotlin.coroutines.intrinsics.a.d()) goto L6;
        return r11;
    L6:
        return Unit.f21064a;
    }

    public final SearchHistoryDao d() {
        return (SearchHistoryDao) this.f9023b.getValue();
    }

    public final SearchDatabase e() {
        return (SearchDatabase) this.f9022a.getValue();
    }

    public final LiveData f() {
        return this.f9024c;
    }

    public final Object g(String r10, Continuation r11) {
        if (o.r(r10) == true) goto L5;
        Object r12 = d().insert(new SearchHistoryEntityBean(r10, System.currentTimeMillis()), r11);
        if (r12 != kotlin.coroutines.intrinsics.a.d()) goto L10;
        return r12;
    L10:
        return Unit.f21064a;
    L5:
        return Unit.f21064a;
    }
}
