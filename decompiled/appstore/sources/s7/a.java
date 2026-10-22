package s7;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.j;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedanceos.appstore.buss.entity.bean.SearchHistoryEntityBean;
import com.bytedanceos.appstore.buss.room.search.SearchHistoryDao;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements SearchHistoryDao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f24522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f24523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedSQLiteStatement f24524c;

    /* JADX INFO: renamed from: s7.a$a, reason: collision with other inner class name */
    public class C0377a extends j {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f24525d;

        public C0377a(a r10, RoomDatabase r11) {
            this.f24525d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "INSERT OR REPLACE INTO `tv_search_history_table` (`id`,`createTime`) VALUES (?,?)";
        }

        @Override // androidx.room.j
        public /* bridge */ /* synthetic */ void i(SupportSQLiteStatement r10, Object r11) {
            l(r10, (SearchHistoryEntityBean) r11);
        }

        public void l(SupportSQLiteStatement r10, SearchHistoryEntityBean r11) {
            if (r11.getWord() != null) goto L5;
            r10.bindNull(1);
        L6:
            r10.bindLong(2, r11.getCreateTime());
            return;
        L5:
            r10.bindString(1, r11.getWord());
            goto L6
        }
    }

    public class b extends SharedSQLiteStatement {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ a f24526d;

        public b(a r10, RoomDatabase r11) {
            this.f24526d = r10;
            super(r11);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String e() {
            return "delete from tv_search_history_table";
        }
    }

    public class c implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SearchHistoryEntityBean f24527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f24528b;

        public c(a r10, SearchHistoryEntityBean r11) {
            this.f24528b = r10;
            this.f24527a = r11;
        }

        public Unit a() {
            a.a(this.f24528b).e();
            a.b(this.f24528b).j(this.f24527a);     // Catch: Throwable -> L6
            a.a(this.f24528b).D();     // Catch: Throwable -> L6
            Unit r10 = Unit.f21064a;     // Catch: Throwable -> L6
            a.a(this.f24528b).i();
            return r10;
        L6:
            th = move-exception;
            a.a(this.f24528b).i();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class d implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f24529a;

        public d(a r10) {
            this.f24529a = r10;
        }

        public Unit a() {
            SupportSQLiteStatement r10 = a.c(this.f24529a).b();
            a.a(this.f24529a).e();     // Catch: Throwable -> L8
            r10.executeUpdateDelete();     // Catch: Throwable -> L10
            a.a(this.f24529a).D();     // Catch: Throwable -> L10
            Unit r11 = Unit.f21064a;     // Catch: Throwable -> L10
            a.a(this.f24529a).i();     // Catch: Throwable -> L8
            a.c(this.f24529a).h(r10);
            return r11;
        L10:
            th = move-exception;
            a.a(this.f24529a).i();     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            a.c(this.f24529a).h(r10);
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }
    }

    public class e implements Callable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomSQLiteQuery f24530a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f24531b;

        public e(a r10, RoomSQLiteQuery r11) {
            this.f24531b = r10;
            this.f24530a = r11;
        }

        public List a() {
            Cursor r10 = b0.b.c(a.a(this.f24531b), this.f24530a, false, null);
            int r11 = b0.a.d(r10, "id");     // Catch: Throwable -> L12
            int r12 = b0.a.d(r10, "createTime");     // Catch: Throwable -> L12
            ArrayList r13 = new ArrayList(r10.getCount());     // Catch: Throwable -> L12
        L4:
            if (r10.moveToNext() == false) goto L14;
            if (r10.isNull(r11) == false) goto L9;
            String r14 = null;
        L10:
            r13.add(new SearchHistoryEntityBean(r14, r10.getLong(r12)));     // Catch: Throwable -> L12
            goto L4
        L9:
            r14 = r10.getString(r11);     // Catch: Throwable -> L12
            goto L10
        L14:
            r10.close();
            return r13;
        L12:
            th = move-exception;
            r10.close();
            throw th;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() {
            return a();
        }

        public void finalize() {
            this.f24530a.c();
        }
    }

    public a(RoomDatabase r10) {
        this.f24522a = r10;
        this.f24523b = new C0377a(this, r10);
        this.f24524c = new b(this, r10);
    }

    public static /* synthetic */ RoomDatabase a(a r10) {
        return r10.f24522a;
    }

    public static /* synthetic */ j b(a r10) {
        return r10.f24523b;
    }

    public static /* synthetic */ SharedSQLiteStatement c(a r10) {
        return r10.f24524c;
    }

    public static List d() {
        return Collections.emptyList();
    }

    @Override // com.bytedanceos.appstore.buss.room.search.SearchHistoryDao
    public Object deleteAll(Continuation r10) {
        return CoroutinesRoom.c(this.f24522a, true, new d(this), r10);
    }

    @Override // com.bytedanceos.appstore.buss.room.search.SearchHistoryDao
    public LiveData getSearchHistory() {
        RoomSQLiteQuery r10 = RoomSQLiteQuery.a("select * from tv_search_history_table order by createTime desc limit 0,20", 0);
        return this.f24522a.m().e(new String[]{"tv_search_history_table"}, false, new e(this, r10));
    }

    @Override // com.bytedanceos.appstore.buss.room.search.SearchHistoryDao
    public Object insert(SearchHistoryEntityBean r10, Continuation r11) {
        return CoroutinesRoom.c(this.f24522a, true, new c(this, r10), r11);
    }
}
