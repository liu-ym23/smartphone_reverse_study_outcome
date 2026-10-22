package com.zyql.common.utils.upload;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.compose.foundation.b;
import com.stepos.agentframework.adapter.bff.BffConstant;
import j9.m;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"getFileNameAndSuffixFromUri", "Lkotlin/Pair;", "", "context", "Landroid/content/Context;", "uriOrPath", "utils_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FileNameUtilKt {
    public static final Pair<String, String> getFileNameAndSuffixFromUri(Context context, String uriOrPath) {
        k.f(context, "context");
        k.f(uriOrPath, "uriOrPath");
        String strP = b.p(System.currentTimeMillis(), "file_");
        try {
            Uri uri = Uri.parse(uriOrPath);
            Log.i("FineNameUtil", "getFileNameAndSuffixFromUri. uriOrPath=".concat(uriOrPath));
            String scheme = uri.getScheme();
            if (scheme != null) {
                int iHashCode = scheme.hashCode();
                if (iHashCode != 3143036) {
                    if (iHashCode == 951530617 && scheme.equals("content")) {
                        Log.i("FineNameUtil", "By content");
                        Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_display_name"}, null, null, null);
                        if (cursorQuery != null) {
                            Cursor cursor = cursorQuery;
                            try {
                                Cursor cursor2 = cursor;
                                if (cursor2.moveToFirst()) {
                                    String string = cursor2.getString(cursor2.getColumnIndexOrThrow("_display_name"));
                                    if (string == null) {
                                        string = strP;
                                    }
                                    Pair<String, String> pair = new Pair<>(string, m.h0(string, ".", false) ? m.J0(string, ".", string) : "dat");
                                    cursor.close();
                                    return pair;
                                }
                                cursor.close();
                            } finally {
                            }
                        }
                    }
                } else if (scheme.equals(BffConstant.Type.File)) {
                    Log.i("FineNameUtil", "By file");
                    String path = uri.getPath();
                    if (path != null) {
                        String name = new File(path).getName();
                        k.c(name);
                        return new Pair<>(name, m.h0(name, ".", false) ? m.J0(name, ".", name) : "dat");
                    }
                }
            } else {
                Log.i("FineNameUtil", "By File");
                File file = new File(uriOrPath);
                if (file.exists()) {
                    String name2 = file.getName();
                    k.c(name2);
                    return new Pair<>(name2, m.h0(name2, ".", false) ? m.J0(name2, ".", name2) : "dat");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Pair<>(strP, "dat");
    }
}
