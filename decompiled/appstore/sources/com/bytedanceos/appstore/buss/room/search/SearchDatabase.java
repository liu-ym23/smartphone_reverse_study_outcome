package com.bytedanceos.appstore.buss.room.search;

import android.content.Context;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.n0;
import com.bytedanceos.appstore.buss.entity.bean.SearchHistoryEntityBean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes2.dex */
@Database(entities = {SearchHistoryEntityBean.class}, exportSchema = false, version = 1)
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedanceos/appstore/buss/room/search/SearchDatabase;", "Landroidx/room/RoomDatabase;", "<init>", "()V", "Lcom/bytedanceos/appstore/buss/room/search/SearchHistoryDao;", "H", "()Lcom/bytedanceos/appstore/buss/room/search/SearchHistoryDao;", "p", "a", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SearchDatabase extends RoomDatabase {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f8822p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static volatile SearchDatabase f8823q;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final SearchDatabase a(Context r10) {
            Context r11 = r10.getApplicationContext();
            q.f(r11, "getApplicationContext(...)");
            return (SearchDatabase) n0.a(r11, SearchDatabase.class, "tv_search_database").d();
        }

        public final SearchDatabase b(Context r10) {
            q.g(r10, "context");
            SearchDatabase r11 = SearchDatabase.F();
            if (r11 != null) goto L15;
            monitor-enter(this);
            r11 = SearchDatabase.F();     // Catch: Throwable -> L9
            if (r11 != null) goto L11;
            SearchDatabase r12 = SearchDatabase.f8822p.a(r10);     // Catch: Throwable -> L9
            SearchDatabase.G(r12);     // Catch: Throwable -> L9
            r11 = r12;
        L11:
            monitor-exit(this);
        L9:
            th = move-exception;
            throw th;
        L15:
            return r11;
        }

        public a() {
        }
    }

    static {
        f8822p = new a(null);
    }

    public SearchDatabase() {
    }

    public static final /* synthetic */ SearchDatabase F() {
        return f8823q;
    }

    public static final /* synthetic */ void G(SearchDatabase r10) {
        f8823q = r10;
    }

    public abstract SearchHistoryDao H();
}
