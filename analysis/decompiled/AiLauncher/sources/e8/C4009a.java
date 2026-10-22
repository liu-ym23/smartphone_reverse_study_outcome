package e8;

import La.H;
import Y8.t;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.sdk.SkillStoreKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a)\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroid/content/Context;", "context", "", "uriOrPath", "Lkotlin/Pair;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)Lkotlin/Pair;", "utils_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* renamed from: e8.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C4009a {
    public static final Pair<String, String> a(Context context, String uriOrPath) {
        p.i(context, "context");
        p.i(uriOrPath, "uriOrPath");
        String str = "file_" + System.currentTimeMillis();
        try {
            Uri uri = Uri.parse(uriOrPath);
            Log.i("FineNameUtil", "getFileNameAndSuffixFromUri. uriOrPath=" + uriOrPath);
            String scheme = uri.getScheme();
            if (scheme != null) {
                int iHashCode = scheme.hashCode();
                if (iHashCode != 3143036) {
                    if (iHashCode == 951530617 && scheme.equals(SkillStoreKt.SKILL_DOC_TYPE_CONTENT)) {
                        Log.i("FineNameUtil", "By content");
                        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                        if (cursorQuery != null) {
                            Cursor cursor = cursorQuery;
                            try {
                                Cursor cursor2 = cursor;
                                if (cursor2.moveToFirst()) {
                                    String string = cursor2.getString(cursor2.getColumnIndexOrThrow("_display_name"));
                                    if (string == null) {
                                        string = str;
                                    }
                                    Pair<String, String> pair = new Pair<>(string, H.g0(string, ".", false, 2, null) ? H.t1(string, ".", null, 2, null) : "dat");
                                    l9.b.a(cursor, null);
                                    return pair;
                                }
                                t tVar = t.f7040a;
                                l9.b.a(cursor, null);
                            } finally {
                            }
                        }
                    }
                } else if (scheme.equals(Const.STR_FILE)) {
                    Log.i("FineNameUtil", "By file");
                    String path = uri.getPath();
                    if (path != null) {
                        String name = new File(path).getName();
                        p.f(name);
                        return new Pair<>(name, H.g0(name, ".", false, 2, null) ? H.t1(name, ".", null, 2, null) : "dat");
                    }
                }
            } else {
                Log.i("FineNameUtil", "By File");
                File file = new File(uriOrPath);
                if (file.exists()) {
                    String name2 = file.getName();
                    p.f(name2);
                    return new Pair<>(name2, H.g0(name2, ".", false, 2, null) ? H.t1(name2, ".", null, 2, null) : "dat");
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return new Pair<>(str, "dat");
    }
}
