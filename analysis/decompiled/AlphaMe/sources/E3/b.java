package E3;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Path;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.r;
import com.stepos.alphame.R;
import d.C0527a;
import g0.InterfaceC0564d;
import j0.C0632g;
import java.io.IOException;
import java.util.ArrayList;
import k0.C0676d;
import k0.InterfaceC0674b;
import kotlin.jvm.internal.Intrinsics;
import l0.C0749c;

/* loaded from: classes2.dex */
public final class b implements x3.e, O0.k, r, InterfaceC0564d {

    /* renamed from: b, reason: collision with root package name */
    public static b f410b;

    /* renamed from: a, reason: collision with root package name */
    public int f411a;

    public /* synthetic */ b(int i4) {
        this.f411a = i4;
    }

    public static void c(k0.h statement, Object[] objArr) {
        Intrinsics.checkNotNullParameter(statement, "statement");
        if (objArr == null) {
            return;
        }
        int length = objArr.length;
        int i4 = 0;
        while (i4 < length) {
            Object obj = objArr[i4];
            i4++;
            if (obj == null) {
                statement.bindNull(i4);
            } else if (obj instanceof byte[]) {
                statement.bindBlob(i4, (byte[]) obj);
            } else if (obj instanceof Float) {
                statement.bindDouble(i4, ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                statement.bindDouble(i4, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                statement.bindLong(i4, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                statement.bindLong(i4, ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                statement.bindLong(i4, ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                statement.bindLong(i4, ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                statement.bindString(i4, (String) obj);
            } else {
                if (!(obj instanceof Boolean)) {
                    throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i4 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
                }
                statement.bindLong(i4, ((Boolean) obj).booleanValue() ? 1L : 0L);
            }
        }
    }

    public static C0676d d(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new C0676d(context);
    }

    public static C0632g e(j0.h owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        return new C0632g(owner);
    }

    public static Path f(float f4, float f5, float f6, float f7) {
        Path path = new Path();
        path.moveTo(f4, f5);
        path.lineTo(f6, f7);
        return path;
    }

    public static String h(String tableName, String triggerType) {
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        return "`room_table_modification_trigger_" + tableName + '_' + triggerType + '`';
    }

    public static C0749c i(C0527a refHolder, SQLiteDatabase sqLiteDatabase) {
        Intrinsics.checkNotNullParameter(refHolder, "refHolder");
        Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
        C0749c c0749c = (C0749c) refHolder.f12410b;
        if (c0749c != null) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            if (Intrinsics.areEqual(c0749c.f13426a, sqLiteDatabase)) {
                return c0749c;
            }
        }
        C0749c c0749c2 = new C0749c(sqLiteDatabase);
        refHolder.f12410b = c0749c2;
        return c0749c2;
    }

    @Override // O0.k
    public Object a(JsonReader jsonReader, float f4) throws IOException {
        int i4;
        double d4;
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        boolean z4 = jsonReader.peek() == JsonToken.BEGIN_ARRAY;
        if (z4) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z4) {
            jsonReader.endArray();
        }
        if (this.f411a == -1) {
            this.f411a = arrayList.size() / 4;
        }
        int i6 = this.f411a;
        float[] fArr = new float[i6];
        int[] iArr = new int[i6];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            i4 = this.f411a * 4;
            if (i7 >= i4) {
                break;
            }
            int i10 = i7 / 4;
            double dFloatValue = ((Float) arrayList.get(i7)).floatValue();
            int i11 = i7 % 4;
            if (i11 == 0) {
                fArr[i10] = (float) dFloatValue;
            } else if (i11 == 1) {
                i8 = (int) (dFloatValue * 255.0d);
            } else if (i11 == 2) {
                i9 = (int) (dFloatValue * 255.0d);
            } else if (i11 == 3) {
                iArr[i10] = Color.argb(255, i8, i9, (int) (dFloatValue * 255.0d));
            }
            i7++;
        }
        L0.c cVar = new L0.c(iArr, fArr);
        if (arrayList.size() > i4) {
            int size = (arrayList.size() - i4) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i12 = 0;
            while (i4 < arrayList.size()) {
                if (i4 % 2 == 0) {
                    dArr[i12] = ((Float) arrayList.get(i4)).floatValue();
                } else {
                    dArr2[i12] = ((Float) arrayList.get(i4)).floatValue();
                    i12++;
                }
                i4++;
            }
            while (true) {
                int[] iArr2 = cVar.f1152b;
                if (i5 >= iArr2.length) {
                    break;
                }
                int i13 = iArr2[i5];
                double d5 = cVar.f1151a[i5];
                int i14 = 1;
                while (true) {
                    if (i14 >= size) {
                        d4 = dArr2[size - 1] * 255.0d;
                        break;
                    }
                    int i15 = i14 - 1;
                    double d6 = dArr[i15];
                    double d7 = dArr[i14];
                    if (d7 >= d5) {
                        double d8 = dArr2[i15];
                        d4 = (((dArr2[i14] - d8) * ((d5 - d6) / (d7 - d6))) + d8) * 255.0d;
                        break;
                    }
                    i14++;
                }
                iArr2[i5] = Color.argb((int) d4, Color.red(i13), Color.green(i13), Color.blue(i13));
                i5++;
            }
        }
        return cVar;
    }

    @Override // androidx.preference.r
    public CharSequence b(Preference preference) {
        ListPreference listPreference = (ListPreference) preference;
        return TextUtils.isEmpty(listPreference.A()) ? listPreference.f4077a.getString(R.string.not_set) : listPreference.A();
    }

    @Override // x3.e
    public Object call(Object obj) {
        switch (this.f411a) {
            case 2:
                x3.a aVar = (x3.a) obj;
                h.f420f.e().getClass();
                return aVar;
            case 3:
                Throwable th = (Throwable) obj;
                h.f420f.c().getClass();
                return th;
            default:
                t3.b bVar = (t3.b) obj;
                h.f420f.c().getClass();
                return bVar;
        }
    }

    @Override // g0.InterfaceC0564d
    public void g() {
        switch (this.f411a) {
            case 1:
                break;
            default:
                Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
                break;
        }
    }

    @Override // g0.InterfaceC0564d
    public void j(int i4, Object obj) {
        String str;
        switch (this.f411a) {
            case 1:
                break;
            default:
                switch (i4) {
                    case 1:
                        str = "RESULT_INSTALL_SUCCESS";
                        break;
                    case 2:
                        str = "RESULT_ALREADY_INSTALLED";
                        break;
                    case 3:
                        str = "RESULT_UNSUPPORTED_ART_VERSION";
                        break;
                    case 4:
                        str = "RESULT_NOT_WRITABLE";
                        break;
                    case 5:
                        str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                        break;
                    case 6:
                        str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                        break;
                    case 7:
                        str = "RESULT_IO_EXCEPTION";
                        break;
                    case 8:
                        str = "RESULT_PARSE_EXCEPTION";
                        break;
                    case 9:
                    default:
                        str = "";
                        break;
                    case 10:
                        str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                        break;
                    case 11:
                        str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                        break;
                }
                if (i4 != 6 && i4 != 7 && i4 != 8) {
                    Log.d("ProfileInstaller", str);
                    break;
                } else {
                    Log.e("ProfileInstaller", str, (Throwable) obj);
                    break;
                }
                break;
        }
    }

    public void k(InterfaceC0674b db) {
        switch (this.f411a) {
            case 27:
                Intrinsics.checkNotNullParameter(db, "db");
                db.execSQL("UPDATE workspec SET period_count = 1 WHERE last_enqueue_time <> 0 AND interval_duration <> 0");
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("last_enqueue_time", Long.valueOf(System.currentTimeMillis()));
                db.update("WorkSpec", 3, contentValues, "last_enqueue_time = 0 AND interval_duration <> 0 ", new Object[0]);
                break;
            default:
                Intrinsics.checkNotNullParameter(db, "db");
                db.execSQL("UPDATE WorkSpec SET `last_enqueue_time` = -1 WHERE `last_enqueue_time` = 0");
                break;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(int i4, int i5) {
        this(0);
        this.f411a = i4;
        int i6 = 1;
        if (i4 != 1) {
        } else {
            this(i6);
        }
    }

    public b() {
        this.f411a = 21;
    }
}
