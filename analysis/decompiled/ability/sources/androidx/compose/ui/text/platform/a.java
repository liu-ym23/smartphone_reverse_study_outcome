package androidx.compose.ui.text.platform;

import S7.k;
import S7.p;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import com.stepos.agentframework.adapter.ApiManager;

/* loaded from: classes2.dex */
public final /* synthetic */ class a implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1904a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(Object obj, int i) {
        this.f1904a = i;
        this.b = obj;
    }

    @Override // S7.p
    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        int i = this.f1904a;
        Object obj5 = this.b;
        switch (i) {
            case 0:
                return AndroidParagraphIntrinsics._init_$lambda$0((AndroidParagraphIntrinsics) obj5, (FontFamily) obj, (FontWeight) obj2, (FontStyle) obj3, (FontSynthesis) obj4);
            case 1:
                return FrameworkSQLiteDatabase.query$lambda$0((SupportSQLiteQuery) obj5, (SQLiteDatabase) obj, (SQLiteCursorDriver) obj2, (String) obj3, (SQLiteQuery) obj4);
            default:
                return ApiManager.uploadFile$lambda$0(null, (k) obj5, ((Integer) obj).intValue(), ((Boolean) obj2).booleanValue(), (String) obj3, (String) obj4);
        }
    }
}
