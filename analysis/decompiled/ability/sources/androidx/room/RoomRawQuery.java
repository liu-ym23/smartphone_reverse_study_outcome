package androidx.room;

import C7.r;
import S7.k;
import androidx.compose.ui.text.d;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\n\u0010\u000bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/room/RoomRawQuery;", "", "", "sql", "Lkotlin/Function1;", "Landroidx/sqlite/SQLiteStatement;", "LC7/r;", "onBindStatement", AppAgent.CONSTRUCT, "(Ljava/lang/String;LS7/k;)V", "getBindingFunction", "()LS7/k;", "Ljava/lang/String;", "getSql", "()Ljava/lang/String;", "bindingFunction", "LS7/k;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RoomRawQuery {
    private final k bindingFunction;
    private final String sql;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RoomRawQuery(String sql) {
        this(sql, null, 2, 0 == true ? 1 : 0);
        kotlin.jvm.internal.k.f(sql, "sql");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r _init_$lambda$0(SQLiteStatement it) {
        kotlin.jvm.internal.k.f(it, "it");
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r bindingFunction$lambda$1(k kVar, SQLiteStatement it) {
        kotlin.jvm.internal.k.f(it, "it");
        kVar.invoke(new BindOnlySQLiteStatement(it));
        return r.f317a;
    }

    public final k getBindingFunction() {
        return this.bindingFunction;
    }

    public final String getSql() {
        return this.sql;
    }

    public RoomRawQuery(String sql, k onBindStatement) {
        kotlin.jvm.internal.k.f(sql, "sql");
        kotlin.jvm.internal.k.f(onBindStatement, "onBindStatement");
        this.sql = sql;
        this.bindingFunction = new androidx.compose.runtime.snapshots.c(onBindStatement, 1);
    }

    public /* synthetic */ RoomRawQuery(String str, k kVar, int i, e eVar) {
        this(str, (i & 2) != 0 ? new d(8) : kVar);
    }
}
