package j1;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\u000fB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u0006\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0016¨\u0006\u0018"}, d2 = {"Lj1/a;", "Lj1/f;", "", "query", "", "", "bindArgs", "<init>", "(Ljava/lang/String;[Ljava/lang/Object;)V", "(Ljava/lang/String;)V", "Lj1/e;", "statement", "LY8/t;", "c", "(Lj1/e;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "[Ljava/lang/Object;", "()Ljava/lang/String;", "sql", "", "()I", "argCount", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: j1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4754a implements InterfaceC4759f {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String query;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object[] bindArgs;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0007\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\t\u0010\nJ)\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lj1/a$a;", "", "<init>", "()V", "Lj1/e;", "statement", "", "bindArgs", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lj1/e;[Ljava/lang/Object;)V", "", "index", "arg", Const.INTENT_KEY_APIKEY, "(Lj1/e;ILjava/lang/Object;)V", "sqlite"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: j1.a$a, reason: collision with other inner class name and from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final void a(InterfaceC4758e statement, int index, Object arg) {
            if (arg == null) {
                statement.bindNull(index);
                return;
            }
            if (arg instanceof byte[]) {
                statement.bindBlob(index, (byte[]) arg);
                return;
            }
            if (arg instanceof Float) {
                statement.bindDouble(index, ((Number) arg).floatValue());
                return;
            }
            if (arg instanceof Double) {
                statement.bindDouble(index, ((Number) arg).doubleValue());
                return;
            }
            if (arg instanceof Long) {
                statement.bindLong(index, ((Number) arg).longValue());
                return;
            }
            if (arg instanceof Integer) {
                statement.bindLong(index, ((Number) arg).intValue());
                return;
            }
            if (arg instanceof Short) {
                statement.bindLong(index, ((Number) arg).shortValue());
                return;
            }
            if (arg instanceof Byte) {
                statement.bindLong(index, ((Number) arg).byteValue());
                return;
            }
            if (arg instanceof String) {
                statement.bindString(index, (String) arg);
                return;
            }
            if (arg instanceof Boolean) {
                statement.bindLong(index, ((Boolean) arg).booleanValue() ? 1L : 0L);
                return;
            }
            throw new IllegalArgumentException("Cannot bind " + arg + " at index " + index + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
        }

        public final void b(InterfaceC4758e statement, Object[] bindArgs) {
            p.i(statement, "statement");
            if (bindArgs == null) {
                return;
            }
            int length = bindArgs.length;
            int i10 = 0;
            while (i10 < length) {
                Object obj = bindArgs[i10];
                i10++;
                a(statement, i10, obj);
            }
        }

        public Companion() {
        }
    }

    public C4754a(String query, Object[] objArr) {
        p.i(query, "query");
        this.query = query;
        this.bindArgs = objArr;
    }

    @Override // j1.InterfaceC4759f
    public int a() {
        Object[] objArr = this.bindArgs;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    @Override // j1.InterfaceC4759f
    /* renamed from: b, reason: from getter */
    public String getQuery() {
        return this.query;
    }

    @Override // j1.InterfaceC4759f
    public void c(InterfaceC4758e statement) {
        p.i(statement, "statement");
        INSTANCE.b(statement, this.bindArgs);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C4754a(String query) {
        this(query, null);
        p.i(query, "query");
    }
}
