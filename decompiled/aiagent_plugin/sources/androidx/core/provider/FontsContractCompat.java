package androidx.core.provider;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.core.graphics.j;
import androidx.core.util.g;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class FontsContractCompat {

    public static final class Columns implements BaseColumns {
        public static final String FILE_ID = "file_id";
        public static final String ITALIC = "font_italic";
        public static final String RESULT_CODE = "result_code";
        public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
        public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
        public static final int RESULT_CODE_MALFORMED_QUERY = 3;
        public static final int RESULT_CODE_OK = 0;
        public static final String TTC_INDEX = "font_ttc_index";
        public static final String VARIATION_SETTINGS = "font_variation_settings";
        public static final String WEIGHT = "font_weight";

        public Columns() {
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f1284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b[] f1285b;

        @Deprecated
        public a(int r1, b[] r2) {
            this.f1284a = r1;
            this.f1285b = r2;
        }

        public int a() {
            return this.f1284a;
        }

        public b[] b() {
            return this.f1285b;
        }

        static a a(int r1, b[] r2) {
            return new a(r1, r2);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Uri f1286a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f1287b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f1288c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f1289d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f1290e;

        @Deprecated
        public b(Uri r3, int r4, int r5, boolean r6, int r7) {
            this.f1286a = (Uri) ZeusTransformUtils.preCheckCast(g.a(r3), Uri.class, "com.obric.aiagent.plugin");
            this.f1287b = r4;
            this.f1288c = r5;
            this.f1289d = r6;
            this.f1290e = r7;
        }

        static b a(Uri r7, int r8, int r9, boolean r10, int r11) {
            return new b(r7, r8, r9, r10, r11);
        }

        public Uri a() {
            return this.f1286a;
        }

        public int b() {
            return this.f1287b;
        }

        public int c() {
            return this.f1288c;
        }

        public boolean d() {
            return this.f1289d;
        }

        public int e() {
            return this.f1290e;
        }
    }

    public static class c {
        public void a(int r1) {
        }

        public void a(Typeface r1) {
        }

        public c() {
        }
    }

    public static Typeface a(Context r2, CancellationSignal r3, b[] r4) {
        return j.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, 0);
    }

    public static a a(Context r2, CancellationSignal r3, androidx.core.provider.c r4) {
        return FontProvider.a((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r4, r3);
    }

    public static Typeface a(Context r2, androidx.core.provider.c r3, int r4, boolean r5, int r6, Handler r7, c r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        androidx.core.provider.a r0 = new androidx.core.provider.a(r8, r7);
        if (r5 == false) goto L7;
        return d.a(r9, r3, r0, r4, r6);
    L7:
        return d.a(r9, r3, r4, null, r0);
    }
}
