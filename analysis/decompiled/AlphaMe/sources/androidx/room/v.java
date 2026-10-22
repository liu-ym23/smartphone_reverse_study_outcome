package androidx.room;

import android.database.sqlite.SQLiteProgram;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class v implements k0.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4245a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4246b;

    public v(SQLiteProgram delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f4246b = delegate;
    }

    public final void a(int i4, Object obj) {
        int size;
        int i5 = i4 - 1;
        Object obj2 = this.f4246b;
        if (i5 >= ((List) obj2).size() && (size = ((List) obj2).size()) <= i5) {
            while (true) {
                ((List) obj2).add(null);
                if (size == i5) {
                    break;
                } else {
                    size++;
                }
            }
        }
        ((List) obj2).set(i5, obj);
    }

    @Override // k0.h
    public final void bindBlob(int i4, byte[] value) {
        switch (this.f4245a) {
            case 0:
                Intrinsics.checkNotNullParameter(value, "value");
                a(i4, value);
                break;
            default:
                Intrinsics.checkNotNullParameter(value, "value");
                ((SQLiteProgram) this.f4246b).bindBlob(i4, value);
                break;
        }
    }

    @Override // k0.h
    public final void bindDouble(int i4, double d4) {
        switch (this.f4245a) {
            case 0:
                a(i4, Double.valueOf(d4));
                break;
            default:
                ((SQLiteProgram) this.f4246b).bindDouble(i4, d4);
                break;
        }
    }

    @Override // k0.h
    public final void bindLong(int i4, long j4) {
        switch (this.f4245a) {
            case 0:
                a(i4, Long.valueOf(j4));
                break;
            default:
                ((SQLiteProgram) this.f4246b).bindLong(i4, j4);
                break;
        }
    }

    @Override // k0.h
    public final void bindNull(int i4) {
        switch (this.f4245a) {
            case 0:
                a(i4, null);
                break;
            default:
                ((SQLiteProgram) this.f4246b).bindNull(i4);
                break;
        }
    }

    @Override // k0.h
    public final void bindString(int i4, String value) {
        switch (this.f4245a) {
            case 0:
                Intrinsics.checkNotNullParameter(value, "value");
                a(i4, value);
                break;
            default:
                Intrinsics.checkNotNullParameter(value, "value");
                ((SQLiteProgram) this.f4246b).bindString(i4, value);
                break;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        switch (this.f4245a) {
            case 0:
                break;
            default:
                ((SQLiteProgram) this.f4246b).close();
                break;
        }
    }
}
