package androidx.room.support;

import Y8.t;
import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import androidx.room.InterfaceC1408d;
import androidx.room.support.AutoClosingRoomOpenHelper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import j1.InterfaceC4756c;
import j1.InterfaceC4757d;
import j1.InterfaceC4758e;
import j1.InterfaceC4759f;
import j1.h;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import x5.d;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0003$\u0013\u000fB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0001¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0003\u001a\u00020\u00018\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u0004\u0018\u00010 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006%"}, d2 = {"Landroidx/room/support/AutoClosingRoomOpenHelper;", "Lj1/d;", "Landroidx/room/d;", "delegate", "Landroidx/room/support/AutoCloser;", "autoCloser", "<init>", "(Lj1/d;Landroidx/room/support/AutoCloser;)V", "LY8/t;", "close", "()V", "", d.EXTRA_ENABLED, "setWriteAheadLoggingEnabled", "(Z)V", Const.INTENT_KEY_APIKEY, "Lj1/d;", "getDelegate", "()Lj1/d;", Const.INTENT_KEY_PKGNAME, "Landroidx/room/support/AutoCloser;", "()Landroidx/room/support/AutoCloser;", "Landroidx/room/support/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "c", "Landroidx/room/support/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "autoClosingDb", "Lj1/c;", "getWritableDatabase", "()Lj1/c;", "writableDatabase", "getReadableDatabase", "readableDatabase", "", "getDatabaseName", "()Ljava/lang/String;", "databaseName", "AutoClosingSupportSQLiteDatabase", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements InterfaceC4757d, InterfaceC1408d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4757d delegate;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final AutoCloser autoCloser;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AutoClosingSupportSQLiteDatabase autoClosingDb;

    @Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\u0013\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0002\u0018\u0000 ?2\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0017\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001c\u0010\nJ)\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001d2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00028\u00000\u001eH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010#\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b#\u0010$J\u0017\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%H\u0002¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u001e\u0010<\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u001e\u0010>\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0019098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010=¨\u0006@"}, d2 = {"Landroidx/room/support/AutoClosingRoomOpenHelper$a;", "Lj1/h;", "", "sql", "Landroidx/room/support/AutoCloser;", "autoCloser", "<init>", "(Ljava/lang/String;Landroidx/room/support/AutoCloser;)V", "LY8/t;", "close", "()V", "execute", "", "index", "bindNull", "(I)V", "", UxipConstants.f30680s, "bindLong", "(IJ)V", "", "bindDouble", "(ID)V", "bindString", "(ILjava/lang/String;)V", "", "bindBlob", "(I[B)V", "clearBindings", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "block", "m", "(Lp9/l;)Ljava/lang/Object;", "columnType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(II)V", "Lj1/e;", "query", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lj1/e;)V", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "Landroidx/room/support/AutoCloser;", "", "c", "[I", "bindingTypes", "", Const.INTENT_KEY_UMID, "[J", "longBindings", "", "e", "[D", "doubleBindings", "", "f", "[Ljava/lang/String;", "stringBindings", "[[B", "blobBindings", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a implements h {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final String sql;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final AutoCloser autoCloser;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int[] bindingTypes;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public long[] longBindings;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public double[] doubleBindings;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public String[] stringBindings;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public byte[][] blobBindings;

        public a(String sql, AutoCloser autoCloser) {
            p.i(sql, "sql");
            p.i(autoCloser, "autoCloser");
            this.sql = sql;
            this.autoCloser = autoCloser;
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        public static final t l(h statement) {
            p.i(statement, "statement");
            statement.execute();
            return t.f7040a;
        }

        public static final Object n(a aVar, InterfaceC5074l interfaceC5074l, InterfaceC4756c db2) {
            p.i(db2, "db");
            h hVarCompileStatement = db2.compileStatement(aVar.sql);
            aVar.g(hVarCompileStatement);
            return interfaceC5074l.invoke(hVarCompileStatement);
        }

        @Override // j1.InterfaceC4758e
        public void bindBlob(int index, byte[] value) {
            p.i(value, "value");
            i(4, index);
            this.bindingTypes[index] = 4;
            this.blobBindings[index] = value;
        }

        @Override // j1.InterfaceC4758e
        public void bindDouble(int index, double value) {
            i(2, index);
            this.bindingTypes[index] = 2;
            this.doubleBindings[index] = value;
        }

        @Override // j1.InterfaceC4758e
        public void bindLong(int index, long value) {
            i(1, index);
            this.bindingTypes[index] = 1;
            this.longBindings[index] = value;
        }

        @Override // j1.InterfaceC4758e
        public void bindNull(int index) {
            i(5, index);
            this.bindingTypes[index] = 5;
        }

        @Override // j1.InterfaceC4758e
        public void bindString(int index, String value) {
            p.i(value, "value");
            i(3, index);
            this.bindingTypes[index] = 3;
            this.stringBindings[index] = value;
        }

        @Override // j1.InterfaceC4758e
        public void clearBindings() {
            this.bindingTypes = new int[0];
            this.longBindings = new long[0];
            this.doubleBindings = new double[0];
            this.stringBindings = new String[0];
            this.blobBindings = new byte[0][];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            clearBindings();
        }

        @Override // j1.h
        public void execute() {
            m(new InterfaceC5074l() { // from class: e1.d
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.a.l((j1.h) obj);
                }
            });
        }

        public final void g(InterfaceC4758e query) {
            int length = this.bindingTypes.length;
            for (int i10 = 1; i10 < length; i10++) {
                int i11 = this.bindingTypes[i10];
                if (i11 == 1) {
                    query.bindLong(i10, this.longBindings[i10]);
                } else if (i11 == 2) {
                    query.bindDouble(i10, this.doubleBindings[i10]);
                } else if (i11 == 3) {
                    String str = this.stringBindings[i10];
                    p.f(str);
                    query.bindString(i10, str);
                } else if (i11 == 4) {
                    byte[] bArr = this.blobBindings[i10];
                    p.f(bArr);
                    query.bindBlob(i10, bArr);
                } else if (i11 == 5) {
                    query.bindNull(i10);
                }
            }
        }

        public final void i(int columnType, int index) {
            int i10 = index + 1;
            int[] iArr = this.bindingTypes;
            if (iArr.length < i10) {
                int[] iArrCopyOf = Arrays.copyOf(iArr, i10);
                p.h(iArrCopyOf, "copyOf(...)");
                this.bindingTypes = iArrCopyOf;
            }
            if (columnType == 1) {
                long[] jArr = this.longBindings;
                if (jArr.length < i10) {
                    long[] jArrCopyOf = Arrays.copyOf(jArr, i10);
                    p.h(jArrCopyOf, "copyOf(...)");
                    this.longBindings = jArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType == 2) {
                double[] dArr = this.doubleBindings;
                if (dArr.length < i10) {
                    double[] dArrCopyOf = Arrays.copyOf(dArr, i10);
                    p.h(dArrCopyOf, "copyOf(...)");
                    this.doubleBindings = dArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType == 3) {
                String[] strArr = this.stringBindings;
                if (strArr.length < i10) {
                    Object[] objArrCopyOf = Arrays.copyOf(strArr, i10);
                    p.h(objArrCopyOf, "copyOf(...)");
                    this.stringBindings = (String[]) objArrCopyOf;
                    return;
                }
                return;
            }
            if (columnType != 4) {
                return;
            }
            byte[][] bArr = this.blobBindings;
            if (bArr.length < i10) {
                Object[] objArrCopyOf2 = Arrays.copyOf(bArr, i10);
                p.h(objArrCopyOf2, "copyOf(...)");
                this.blobBindings = (byte[][]) objArrCopyOf2;
            }
        }

        public final <T> T m(final InterfaceC5074l<? super h, ? extends T> block) {
            return (T) this.autoCloser.h(new InterfaceC5074l() { // from class: e1.e
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.a.n(this.f32212a, block, (InterfaceC4756c) obj);
                }
            });
        }
    }

    @Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\r\u0010\fJ\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\u0014J\u0010\u0010\u0018\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0014J\u0010\u0010\u0019\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u0014J\u0010\u0010\u001a\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u0014J \u0010\u001e\u001a\u00020\n2\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ \u0010 \u001a\u00020\n2\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cH\u0096\u0001¢\u0006\u0004\b \u0010\u001fJ \u0010!\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b!\u0010\"J6\u0010$\u001a(\u0012\f\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c \u001d*\u0014\u0012\u000e\b\u0001\u0012\n \u001d*\u0004\u0018\u00010\u001c0\u001c\u0018\u00010#0#H\u0096\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b&\u0010\fJ \u0010(\u001a\n \u001d*\u0004\u0018\u00010'0'2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b(\u0010)J \u0010*\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001c2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b*\u0010\"J(\u0010-\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\n2\u000e\u0010,\u001a\n \u001d*\u0004\u0018\u00010+0+H\u0096\u0001¢\u0006\u0004\b-\u0010.J\u0018\u00100\u001a\u00020/2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b0\u00101J\u0018\u00102\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b2\u00103J\u0018\u00105\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b5\u00106J\u0018\u00108\u001a\u0002072\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b8\u00109J\u0018\u0010;\u001a\u00020:2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b;\u0010<J\u0018\u0010=\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b=\u00103J\u0018\u0010>\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\nH\u0096\u0001¢\u0006\u0004\b>\u0010\u0011J\u0010\u0010?\u001a\u00020\u0007H\u0097\u0001¢\u0006\u0004\b?\u0010\tJ\u0010\u0010@\u001a\u00020\u000fH\u0097\u0001¢\u0006\u0004\b@\u0010\u0014J\u0010\u0010A\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\bA\u0010\u0014J \u0010C\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010B0BH\u0096\u0001¢\u0006\u0004\bC\u0010DJ \u0010E\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010B0BH\u0096\u0001¢\u0006\u0004\bE\u0010DJ \u0010G\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010F0FH\u0096\u0001¢\u0006\u0004\bG\u0010HJ \u0010I\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010F0FH\u0096\u0001¢\u0006\u0004\bI\u0010HJ0\u0010L\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010J0J2\u000e\u0010,\u001a\n \u001d*\u0004\u0018\u00010K0KH\u0096\u0001¢\u0006\u0004\bL\u0010MJ\u0018\u0010N\u001a\n \u001d*\u0004\u0018\u00010K0KH\u0096\u0001¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\bP\u0010\u0014J \u0010R\u001a\u00020\u00072\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010Q0QH\u0096\u0001¢\u0006\u0004\bR\u0010SJ\u0018\u0010T\u001a\n \u001d*\u0004\u0018\u00010Q0QH\u0096\u0001¢\u0006\u0004\bT\u0010UJ(\u0010V\u001a\n \u001d*\u0004\u0018\u00010Q0Q2\u000e\u0010\u000e\u001a\n \u001d*\u0004\u0018\u00010Q0QH\u0096\u0001¢\u0006\u0004\bV\u0010WR\u0014\u0010\u0002\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bZ\u0010[¨\u0006\\"}, d2 = {"Landroidx/room/support/AutoClosingRoomOpenHelper$b;", "Landroid/database/Cursor;", "delegate", "Landroidx/room/support/AutoCloser;", "autoCloser", "<init>", "(Landroid/database/Cursor;Landroidx/room/support/AutoCloser;)V", "LY8/t;", "close", "()V", "", "getCount", "()I", "getPosition", "p0", "", com.stepos.ailauncher.container.wallpaper.a.PHASE_MOVE, "(I)Z", "moveToPosition", "moveToFirst", "()Z", "moveToLast", "moveToNext", "moveToPrevious", "isFirst", "isLast", "isBeforeFirst", "isAfterLast", "", "kotlin.jvm.PlatformType", "getColumnIndex", "(Ljava/lang/String;)I", "getColumnIndexOrThrow", "getColumnName", "(I)Ljava/lang/String;", "", "getColumnNames", "()[Ljava/lang/String;", "getColumnCount", "", "getBlob", "(I)[B", "getString", "Landroid/database/CharArrayBuffer;", "p1", "copyStringToBuffer", "(ILandroid/database/CharArrayBuffer;)V", "", "getShort", "(I)S", "getInt", "(I)I", "", "getLong", "(I)J", "", "getFloat", "(I)F", "", "getDouble", "(I)D", "getType", "isNull", "deactivate", "requery", "isClosed", "Landroid/database/ContentObserver;", "registerContentObserver", "(Landroid/database/ContentObserver;)V", "unregisterContentObserver", "Landroid/database/DataSetObserver;", "registerDataSetObserver", "(Landroid/database/DataSetObserver;)V", "unregisterDataSetObserver", "Landroid/content/ContentResolver;", "Landroid/net/Uri;", "setNotificationUri", "(Landroid/content/ContentResolver;Landroid/net/Uri;)V", "getNotificationUri", "()Landroid/net/Uri;", "getWantsAllOnMoveCalls", "Landroid/os/Bundle;", "setExtras", "(Landroid/os/Bundle;)V", "getExtras", "()Landroid/os/Bundle;", "respond", "(Landroid/os/Bundle;)Landroid/os/Bundle;", Const.INTENT_KEY_APIKEY, "Landroid/database/Cursor;", Const.INTENT_KEY_PKGNAME, "Landroidx/room/support/AutoCloser;", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b implements Cursor {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Cursor delegate;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final AutoCloser autoCloser;

        public b(Cursor delegate, AutoCloser autoCloser) {
            p.i(delegate, "delegate");
            p.i(autoCloser, "autoCloser");
            this.delegate = delegate;
            this.autoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
            this.autoCloser.g();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int p02, CharArrayBuffer p12) {
            this.delegate.copyStringToBuffer(p02, p12);
        }

        @Override // android.database.Cursor
        public void deactivate() {
            this.delegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int p02) {
            return this.delegate.getBlob(p02);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.delegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String p02) {
            return this.delegate.getColumnIndex(p02);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String p02) {
            return this.delegate.getColumnIndexOrThrow(p02);
        }

        @Override // android.database.Cursor
        public String getColumnName(int p02) {
            return this.delegate.getColumnName(p02);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.delegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.delegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int p02) {
            return this.delegate.getDouble(p02);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.delegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int p02) {
            return this.delegate.getFloat(p02);
        }

        @Override // android.database.Cursor
        public int getInt(int p02) {
            return this.delegate.getInt(p02);
        }

        @Override // android.database.Cursor
        public long getLong(int p02) {
            return this.delegate.getLong(p02);
        }

        @Override // android.database.Cursor
        public Uri getNotificationUri() {
            return this.delegate.getNotificationUri();
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.delegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int p02) {
            return this.delegate.getShort(p02);
        }

        @Override // android.database.Cursor
        public String getString(int p02) {
            return this.delegate.getString(p02);
        }

        @Override // android.database.Cursor
        public int getType(int p02) {
            return this.delegate.getType(p02);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.delegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.delegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.delegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.delegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.delegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int p02) {
            return this.delegate.isNull(p02);
        }

        @Override // android.database.Cursor
        public boolean move(int p02) {
            return this.delegate.move(p02);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.delegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.delegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.delegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int p02) {
            return this.delegate.moveToPosition(p02);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.delegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver p02) {
            this.delegate.registerContentObserver(p02);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver p02) {
            this.delegate.registerDataSetObserver(p02);
        }

        @Override // android.database.Cursor
        public boolean requery() {
            return this.delegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle p02) {
            return this.delegate.respond(p02);
        }

        @Override // android.database.Cursor
        public void setExtras(Bundle p02) {
            this.delegate.setExtras(p02);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver p02, Uri p12) {
            this.delegate.setNotificationUri(p02, p12);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver p02) {
            this.delegate.unregisterContentObserver(p02);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver p02) {
            this.delegate.unregisterDataSetObserver(p02);
        }
    }

    public AutoClosingRoomOpenHelper(InterfaceC4757d delegate, AutoCloser autoCloser) {
        p.i(delegate, "delegate");
        p.i(autoCloser, "autoCloser");
        this.delegate = delegate;
        this.autoCloser = autoCloser;
        this.autoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
        autoCloser.l(getDelegate());
    }

    /* renamed from: b, reason: from getter */
    public final AutoCloser getAutoCloser() {
        return this.autoCloser;
    }

    @Override // j1.InterfaceC4757d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.autoClosingDb.close();
    }

    @Override // j1.InterfaceC4757d
    /* renamed from: getDatabaseName */
    public String getName() {
        return this.delegate.getName();
    }

    @Override // androidx.room.InterfaceC1408d
    public InterfaceC4757d getDelegate() {
        return this.delegate;
    }

    @Override // j1.InterfaceC4757d
    public InterfaceC4756c getReadableDatabase() {
        this.autoClosingDb.i();
        return this.autoClosingDb;
    }

    @Override // j1.InterfaceC4757d
    public InterfaceC4756c getWritableDatabase() {
        this.autoClosingDb.i();
        return this.autoClosingDb;
    }

    @Override // j1.InterfaceC4757d
    public void setWriteAheadLoggingEnabled(boolean enabled) {
        this.delegate.setWriteAheadLoggingEnabled(enabled);
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0019\u0010\u001bJ)\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\t2\u0010\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001d0\u001cH\u0016¢\u0006\u0004\b\u0019\u0010\u001fJ\u0017\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020 H\u0016¢\u0006\u0004\b\u0019\u0010!J\u0017\u0010\"\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0016H\u0016¢\u0006\u0004\b$\u0010\u0018J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\bJ\u000f\u0010&\u001a\u00020\u0006H\u0016¢\u0006\u0004\b&\u0010\bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0018R\u0016\u0010,\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0018R(\u00102\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0/\u0018\u00010.8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Landroidx/room/support/AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase;", "Lj1/c;", "Landroidx/room/support/AutoCloser;", "autoCloser", "<init>", "(Landroidx/room/support/AutoCloser;)V", "LY8/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()V", "", "sql", "Lj1/h;", "compileStatement", "(Ljava/lang/String;)Lj1/h;", "beginTransaction", "beginTransactionNonExclusive", "Landroid/database/sqlite/SQLiteTransactionListener;", "transactionListener", "beginTransactionWithListener", "(Landroid/database/sqlite/SQLiteTransactionListener;)V", "endTransaction", "setTransactionSuccessful", "", "inTransaction", "()Z", "query", "Landroid/database/Cursor;", "(Ljava/lang/String;)Landroid/database/Cursor;", "", "", "bindArgs", "(Ljava/lang/String;[Ljava/lang/Object;)Landroid/database/Cursor;", "Lj1/f;", "(Lj1/f;)Landroid/database/Cursor;", "execSQL", "(Ljava/lang/String;)V", "enableWriteAheadLogging", "disableWriteAheadLogging", "close", Const.INTENT_KEY_APIKEY, "Landroidx/room/support/AutoCloser;", "isOpen", "getPath", "()Ljava/lang/String;", "path", "isWriteAheadLoggingEnabled", "", "Landroid/util/Pair;", "getAttachedDbs", "()Ljava/util/List;", "attachedDbs", "room-runtime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AutoClosingSupportSQLiteDatabase implements InterfaceC4756c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final AutoCloser autoCloser;

        public AutoClosingSupportSQLiteDatabase(AutoCloser autoCloser) {
            p.i(autoCloser, "autoCloser");
            this.autoCloser = autoCloser;
        }

        public static final t g(String str, InterfaceC4756c db2) throws SQLException {
            p.i(db2, "db");
            db2.execSQL(str);
            return t.f7040a;
        }

        public static final Object l(InterfaceC4756c it) {
            p.i(it, "it");
            return null;
        }

        @Override // j1.InterfaceC4756c
        public void beginTransaction() {
            try {
                this.autoCloser.j().beginTransaction();
            } catch (Throwable th) {
                this.autoCloser.g();
                throw th;
            }
        }

        @Override // j1.InterfaceC4756c
        public void beginTransactionNonExclusive() {
            try {
                this.autoCloser.j().beginTransactionNonExclusive();
            } catch (Throwable th) {
                this.autoCloser.g();
                throw th;
            }
        }

        @Override // j1.InterfaceC4756c
        public void beginTransactionWithListener(SQLiteTransactionListener transactionListener) {
            p.i(transactionListener, "transactionListener");
            try {
                this.autoCloser.j().beginTransactionWithListener(transactionListener);
            } catch (Throwable th) {
                this.autoCloser.g();
                throw th;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.autoCloser.f();
        }

        @Override // j1.InterfaceC4756c
        public h compileStatement(String sql) {
            p.i(sql, "sql");
            return new a(sql, this.autoCloser);
        }

        @Override // j1.InterfaceC4756c
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // j1.InterfaceC4756c
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // j1.InterfaceC4756c
        public void endTransaction() {
            try {
                InterfaceC4756c delegateDatabase = this.autoCloser.getDelegateDatabase();
                p.f(delegateDatabase);
                delegateDatabase.endTransaction();
            } finally {
                this.autoCloser.g();
            }
        }

        @Override // j1.InterfaceC4756c
        public void execSQL(final String sql) throws SQLException {
            p.i(sql, "sql");
            this.autoCloser.h(new InterfaceC5074l() { // from class: e1.b
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.g(sql, (InterfaceC4756c) obj);
                }
            });
        }

        @Override // j1.InterfaceC4756c
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.autoCloser.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$attachedDbs$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, w9.InterfaceC5754m
                public Object get(Object obj) {
                    return ((InterfaceC4756c) obj).getAttachedDbs();
                }
            });
        }

        @Override // j1.InterfaceC4756c
        public String getPath() {
            return (String) this.autoCloser.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$path$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, w9.InterfaceC5754m
                public Object get(Object obj) {
                    return ((InterfaceC4756c) obj).getPath();
                }
            });
        }

        public final void i() {
            this.autoCloser.h(new InterfaceC5074l() { // from class: e1.c
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.l((InterfaceC4756c) obj);
                }
            });
        }

        @Override // j1.InterfaceC4756c
        public boolean inTransaction() {
            if (this.autoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.autoCloser.h(AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$inTransaction$1.f14834a)).booleanValue();
        }

        @Override // j1.InterfaceC4756c
        public boolean isOpen() {
            return this.autoCloser.m();
        }

        @Override // j1.InterfaceC4756c
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.autoCloser.h(new PropertyReference1Impl() { // from class: androidx.room.support.AutoClosingRoomOpenHelper$AutoClosingSupportSQLiteDatabase$isWriteAheadLoggingEnabled$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, w9.InterfaceC5754m
                public Object get(Object obj) {
                    return Boolean.valueOf(((InterfaceC4756c) obj).isWriteAheadLoggingEnabled());
                }
            })).booleanValue();
        }

        @Override // j1.InterfaceC4756c
        public Cursor query(String query) {
            p.i(query, "query");
            try {
                return new b(this.autoCloser.j().query(query), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.g();
                throw th;
            }
        }

        @Override // j1.InterfaceC4756c
        public void setTransactionSuccessful() {
            InterfaceC4756c delegateDatabase = this.autoCloser.getDelegateDatabase();
            p.f(delegateDatabase);
            delegateDatabase.setTransactionSuccessful();
        }

        @Override // j1.InterfaceC4756c
        public Cursor query(String query, Object[] bindArgs) {
            p.i(query, "query");
            p.i(bindArgs, "bindArgs");
            try {
                return new b(this.autoCloser.j().query(query, bindArgs), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.g();
                throw th;
            }
        }

        @Override // j1.InterfaceC4756c
        public Cursor query(InterfaceC4759f query) {
            p.i(query, "query");
            try {
                return new b(this.autoCloser.j().query(query), this.autoCloser);
            } catch (Throwable th) {
                this.autoCloser.g();
                throw th;
            }
        }
    }
}
