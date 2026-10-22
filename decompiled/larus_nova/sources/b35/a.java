package b35;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Pair;
import ay4.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.ss.android.lark.vfs.VFSFile;
import java.io.FileNotFoundException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f17185a = 0;

    static {
    }

    public static Pair a(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "path");
        InputStream r103 = null;
        if (TextUtils.isEmpty(r101) == true) goto L17;
        VFSFile r104 = d.a().i(r101);
    L14:
        e = move-exception;
        tt5.a.e("BaseResourceInterceptor", "readResponseStream... err happens", e, false);
    L27:
        return new Pair(r103, -1L);
    L6:
        if (r104.exists() == false) goto L8;
        r103 = r104.newInputStream();     // Catch: Exception -> L14
    L12:
        return new Pair(r103, Long.valueOf(r104.length()));
    L8:
        if (r100 == null) goto L12;
        AssetManager r105 = r100.getAssets();     // Catch: Exception -> L14
        if (r105 == null) goto L12;
        r103 = r105.open(r101);     // Catch: Exception -> L14
        goto L12
    L17:
        if (TextUtils.isEmpty(r102) == true) goto L25;
        if (r100 == null) goto L27;
        ContentResolver r106 = r100.getContentResolver();     // Catch: FileNotFoundException -> L23
        if (r106 == null) goto L27;
        r103 = ContentResolverWrapper.openInputStream(r106, UriProtector.parse(r102));     // Catch: FileNotFoundException -> L23
    L23:
        e = move-exception;
        tt5.a.e("BaseResourceInterceptor", "readResponseStream from uri... err", e, false);
        goto L27
    L25:
        tt5.a.d("BaseResourceInterceptor", "readResponseStream... empty file path and uri");
        goto L27
    }
}
