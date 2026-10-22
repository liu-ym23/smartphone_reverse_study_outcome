package com.blankj.utilcode.util;

import android.content.ClipData;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import androidx.appcompat.widget.p;
import androidx.collection.SimpleArrayMap;
import com.bytedance.librarian.LibrarianImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.capabilitykit.common.ErrorCode;
import com.ttnet.org.chromium.net.NetError;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.http.message.TokenParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class LogUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f6148a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f6149b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f6150c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f6151d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static SimpleDateFormat f6152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ExecutorService f6153f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SimpleArrayMap f6154g = null;

    public interface IFileWriter {
        void write(String r10, String r11);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
    }

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f6156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f6157c;

        public a(int r10, f r11, String r12) {
            this.f6155a = r10;
            this.f6156b = r11;
            this.f6157c = r12;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtils.e(this.f6155a, this.f6156b.f6179a, this.f6156b.f6181c + this.f6157c);
        }
    }

    public class b implements FilenameFilter {
        public b() {
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File r10, String r11) {
            return LogUtils.f(r11);
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ File f6158a;

        public c(File r10) {
            this.f6158a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6158a.delete() == true) goto L6;
            Log.e("LogUtils", "delete " + this.f6158a + " failed!");
            return;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f6160b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6161c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f6162d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f6163e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6164f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f6165g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f6166h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f6167i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f6168j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f6169k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f6170l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6171m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f6172n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f6173o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f6174p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6175q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f6176r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public IFileWriter f6177s;

        public /* synthetic */ d(a r10) {
            this();
        }

        public static /* synthetic */ int a(d r10) {
            return r10.f6171m;
        }

        public static /* synthetic */ int b(d r10) {
            return r10.f6172n;
        }

        public static /* synthetic */ boolean c(d r10) {
            return r10.f6166h;
        }

        public static /* synthetic */ IFileWriter d(d r10) {
            return r10.f6177s;
        }

        public final char e() {
            return LogUtils.b()[this.f6171m - 2];
        }

        public final String f() {
            String r10 = this.f6160b;
            if (r10 == null) goto L5;
            return r10;
        L5:
            return this.f6159a;
        }

        public final String g() {
            return this.f6162d;
        }

        public final char h() {
            return LogUtils.b()[this.f6172n - 2];
        }

        public final String i() {
            return this.f6161c;
        }

        public final String j() {
            if (LogUtils.h(this.f6165g) == false) goto L7;
            return "";
        L7:
            return this.f6165g;
        }

        public final String k() {
            String r10 = this.f6176r;
            if (r10 != null) goto L7;
            return "";
        L7:
            return r10.replace(":", "_");
        }

        public final int l() {
            return this.f6175q;
        }

        public final int m() {
            return this.f6173o;
        }

        public final int n() {
            return this.f6174p;
        }

        public final boolean o() {
            return this.f6164f;
        }

        public final boolean p() {
            return this.f6168j;
        }

        public final boolean q() {
            return this.f6169k;
        }

        public final boolean r() {
            return this.f6167i;
        }

        public final boolean s() {
            return this.f6163e;
        }

        public final boolean t() {
            return this.f6170l;
        }

        public String toString() {
            return "process: " + k() + LogUtils.c() + "switch: " + s() + LogUtils.c() + "console: " + o() + LogUtils.c() + "tag: " + j() + LogUtils.c() + "head: " + r() + LogUtils.c() + "file: " + p() + LogUtils.c() + "dir: " + f() + LogUtils.c() + "filePrefix: " + i() + LogUtils.c() + "border: " + q() + LogUtils.c() + "singleTag: " + t() + LogUtils.c() + "consoleFilter: " + e() + LogUtils.c() + "fileFilter: " + h() + LogUtils.c() + "stackDeep: " + m() + LogUtils.c() + "stackOffset: " + n() + LogUtils.c() + "saveDays: " + l() + LogUtils.c() + "formatter: " + LogUtils.a();
        }

        public d() {
            this.f6161c = "util";
            this.f6162d = ".txt";
            this.f6163e = true;
            this.f6164f = true;
            this.f6165g = "";
            this.f6166h = true;
            this.f6167i = true;
            this.f6168j = false;
            this.f6169k = true;
            this.f6170l = true;
            this.f6171m = 2;
            this.f6172n = 2;
            this.f6173o = 1;
            this.f6174p = 0;
            this.f6175q = -1;
            this.f6176r = Utils.e();
            if (this.f6159a == null) goto L6;
            return;
        L6:
            if ("mounted".equals(Environment.getExternalStorageState()) == true) goto L8;
        L10:
            this.f6159a = Utils.c().getCacheDir() + LogUtils.g() + "log" + LogUtils.g();
            return;
        L8:
            if (Utils.c().getExternalCacheDir() == null) goto L10;
            this.f6159a = Utils.c().getExternalCacheDir() + LogUtils.g() + "log" + LogUtils.g();
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Gson f6178a = null;

        static {
            f6178a = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
        }

        public static String a(Object r10) {
            if ((r10 instanceof Object[]) == false) goto L7;
            return Arrays.deepToString((Object[]) r10);
        L7:
            if ((r10 instanceof boolean[]) == false) goto L11;
            return Arrays.toString((boolean[]) r10);
        L11:
            if ((r10 instanceof byte[]) == false) goto L15;
            return Arrays.toString((byte[]) r10);
        L15:
            if ((r10 instanceof char[]) == false) goto L19;
            return Arrays.toString((char[]) r10);
        L19:
            if ((r10 instanceof double[]) == false) goto L23;
            return Arrays.toString((double[]) r10);
        L23:
            if ((r10 instanceof float[]) == false) goto L27;
            return Arrays.toString((float[]) r10);
        L27:
            if ((r10 instanceof int[]) == false) goto L31;
            return Arrays.toString((int[]) r10);
        L31:
            if ((r10 instanceof long[]) == false) goto L35;
            return Arrays.toString((long[]) r10);
        L35:
            if ((r10 instanceof short[]) == false) goto L39;
            return Arrays.toString((short[]) r10);
        L39:
            throw new IllegalArgumentException("Array has incompatible type: " + r10.getClass());
        }

        public static String b(Bundle r10) {
            Iterator<String> r11 = r10.keySet().iterator();
            if (r11.hasNext() == true) goto L6;
            return "Bundle {}";
        L6:
            StringBuilder r12 = new StringBuilder(128);
            r12.append("Bundle { ");
        L7:
            String r13 = r11.next();
            Object r14 = r10.get(r13);
            r12.append(r13);
            r12.append('=');
            if ((r14 instanceof Bundle) == false) goto L13;
            if (r14 != r10) goto L11;
            String r15 = "(this Bundle)";
        L12:
            r12.append(r15);
        L15:
            if (r11.hasNext() == false) goto L16;
            r12.append(',');
            r12.append(TokenParser.SP);
            goto L7
        L16:
            r12.append(" }");
            return r12.toString();
        L11:
            r15 = b((Bundle) r14);
            goto L12
        L13:
            r12.append(LogUtils.d(r14));
            goto L15
        }

        public static void c(ClipData r10, StringBuilder r11) {
            ClipData.Item r12 = r10.getItemAt(0);
            if (r12 != null) goto L6;
            r11.append("ClipData.Item {}");
            return;
        L6:
            r11.append("ClipData.Item { ");
            String r13 = r12.getHtmlText();
            if (r13 == null) goto L10;
            r11.append("H:");
            r11.append(r13);
            r11.append("}");
            return;
        L10:
            CharSequence r14 = r12.getText();
            if (r14 == null) goto L14;
            r11.append("T:");
            r11.append(r14);
            r11.append("}");
            return;
        L14:
            Uri r15 = r12.getUri();
            if (r15 == null) goto L18;
            r11.append("U:");
            r11.append(r15);
            r11.append("}");
            return;
        L18:
            Intent r16 = r12.getIntent();
            if (r16 == null) goto L22;
            r11.append("I:");
            r11.append(f(r16));
            r11.append("}");
            return;
        L22:
            r11.append("NULL");
            r11.append("}");
        }

        public static String d(String r10) {
            int r11 = r10.length();     // Catch: JSONException -> L8
            int r12 = 0;
        L3:
            if (r12 >= r11) goto L19;
            char r13 = r10.charAt(r12);     // Catch: JSONException -> L8
            if (r13 == '{') goto L7;
            if (r13 == '[') goto L13;
            if (Character.isWhitespace(r13) == false) goto L16;
            r12 = r12 + 1;
            goto L3
        L16:
            return r10;
        L13:
            return new JSONArray(r10).toString(2);
        L7:
            return new JSONObject(r10).toString(2);
        L19:
            return r10;
        L8:
            e = move-exception;
            e.printStackTrace();
            goto L19
        }

        public static String e(String r10) {
            StreamSource r11 = new StreamSource(new StringReader(r10));     // Catch: Exception -> L5
            StreamResult r12 = new StreamResult(new StringWriter());     // Catch: Exception -> L5
            Transformer r13 = TransformerFactory.newInstance().newTransformer();     // Catch: Exception -> L5
            r13.setOutputProperty("indent", "yes");     // Catch: Exception -> L5
            r13.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");     // Catch: Exception -> L5
            r13.transform(r11, r12);     // Catch: Exception -> L5
            return r12.getWriter().toString().replaceFirst(">", ">" + LogUtils.c());
        L5:
            e = move-exception;
            e.printStackTrace();
            return r10;
        }

        public static String f(Intent r10) {
            StringBuilder r11 = new StringBuilder(128);
            r11.append("Intent { ");
            String r12 = r10.getAction();
            boolean r13 = false;
            boolean r14 = true;
            if (r12 == null) goto L5;
            r11.append("act=");
            r11.append(r12);
            boolean r15 = false;
        L6:
            Set<String> r16 = r10.getCategories();
            if (r16 == null) goto L18;
            if (r15 == true) goto L10;
            r11.append(TokenParser.SP);
        L10:
            r11.append("cat=[");
            Iterator<String> r17 = r16.iterator();
        L12:
            if (r17.hasNext() == false) goto L17;
            String r18 = r17.next();
            if (r14 == true) goto L16;
            r11.append(',');
        L16:
            r11.append(r18);
            r14 = false;
            goto L12
        L17:
            r11.append("]");
            r15 = false;
        L18:
            Uri r19 = r10.getData();
            if (r19 == null) goto L23;
            if (r15 == true) goto L22;
            r11.append(TokenParser.SP);
        L22:
            r11.append("dat=");
            r11.append(r19);
            r15 = false;
        L23:
            String r20 = r10.getType();
            if (r20 == null) goto L28;
            if (r15 == true) goto L27;
            r11.append(TokenParser.SP);
        L27:
            r11.append("typ=");
            r11.append(r20);
            r15 = false;
        L28:
            int r21 = r10.getFlags();
            if (r21 == 0) goto L33;
            if (r15 == true) goto L32;
            r11.append(TokenParser.SP);
        L32:
            r11.append("flg=0x");
            r11.append(Integer.toHexString(r21));
            r15 = false;
        L33:
            String r22 = r10.getPackage();
            if (r22 == null) goto L38;
            if (r15 == true) goto L37;
            r11.append(TokenParser.SP);
        L37:
            r11.append("pkg=");
            r11.append(r22);
            r15 = false;
        L38:
            ComponentName r23 = r10.getComponent();
            if (r23 == null) goto L43;
            if (r15 == true) goto L42;
            r11.append(TokenParser.SP);
        L42:
            r11.append("cmp=");
            r11.append(r23.flattenToShortString());
            r15 = false;
        L43:
            Rect r24 = r10.getSourceBounds();
            if (r24 == null) goto L48;
            if (r15 == true) goto L47;
            r11.append(TokenParser.SP);
        L47:
            r11.append("bnds=");
            r11.append(r24.toShortString());
            r15 = false;
        L48:
            ClipData r25 = r10.getClipData();
            if (r25 == null) goto L53;
            if (r15 == true) goto L52;
            r11.append(TokenParser.SP);
        L52:
            c(r25, r11);
            r15 = false;
        L53:
            Bundle r26 = r10.getExtras();
            if (r26 == null) goto L58;
            if (r15 == true) goto L57;
            r11.append(TokenParser.SP);
        L57:
            r11.append("extras={");
            r11.append(b(r26));
            r11.append('}');
        L59:
            Intent r27 = r10.getSelector();
            if (r27 == null) goto L68;
            if (r13 == true) goto L63;
            r11.append(TokenParser.SP);
        L63:
            r11.append("sel={");
            if (r27 != r10) goto L66;
            String r28 = "(this Intent)";
        L67:
            r11.append(r28);
            r11.append("}");
            goto L68
        L66:
            r28 = f(r27);
        L68:
            r11.append(" }");
            return r11.toString();
        L58:
            r13 = r15;
            goto L59
        L5:
            r15 = true;
            goto L6
        }

        public static String g(Object r10) {
            if ((r10 instanceof CharSequence) == true) goto L5;
            return f6178a.toJson(r10);
        L9:
            return r10.toString();
        L5:
            return d(r10.toString());
        }

        public static String h(Object r10) {
            return i(r10, -1);
        }

        public static String i(Object r10, int r11) {
            if (r10.getClass().isArray() == false) goto L7;
            return a(r10);
        L7:
            if ((r10 instanceof Throwable) == false) goto L11;
            return j((Throwable) r10);
        L11:
            if ((r10 instanceof Bundle) == false) goto L15;
            return b((Bundle) r10);
        L15:
            if ((r10 instanceof Intent) == false) goto L19;
            return f((Intent) r10);
        L19:
            if (r11 != 32) goto L23;
            return g(r10);
        L23:
            if (r11 != 48) goto L27;
            return e(r10.toString());
        L27:
            return r10.toString();
        }

        public static String j(Throwable r10) {
            return g.a(r10);
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f6179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String[] f6180b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f6181c;

        public f(String r10, String[] r11, String r12) {
            this.f6179a = r10;
            this.f6180b = r11;
            this.f6181c = r12;
        }
    }

    static {
        f6148a = new char[]{'V', 'D', 'I', 'W', 'E', 'A'};
        f6149b = System.getProperty("file.separator");
        f6150c = System.getProperty("line.separator");
        f6151d = new d(null);
        f6153f = Executors.newSingleThreadExecutor();
        f6154g = new SimpleArrayMap();
    }

    public static void A(int r10, String r11, String[] r12) {
        if (r12 == null) goto L16;
        int r13 = r12.length;
        int r14 = 0;
    L4:
        if (r14 >= r13) goto L10;
        String r15 = r12[r14];
        if (f6151d.q() == false) goto L8;
        r15 = "│ " + r15;
    L8:
        Log.println(r10, r11, r15);
        r14 = r14 + 1;
        goto L4
    L10:
        if (f6151d.q() == false) goto L17;
        Log.println(r10, r11, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
        return;
    L17:
        return;
    }

    public static void B(int r10, String r11, String r12) {
        int r13 = r12.length();
        int r14 = r13 / ErrorCode.Contacts.PHONE_NO_PAGE_ERROR;
        if (r14 <= 0) goto L9;
        int r15 = 0;
        int r16 = 0;
    L5:
        if (r15 >= r14) goto L7;
        int r17 = r16 + ErrorCode.Contacts.PHONE_NO_PAGE_ERROR;
        D(r10, r11, r12.substring(r16, r17));
        r15 = r15 + 1;
        r16 = r17;
        goto L5
    L7:
        if (r16 == r13) goto L12;
        D(r10, r11, r12.substring(r16, r13));
        return;
    L12:
        return;
    L9:
        D(r10, r11, r12);
    }

    public static void C(int r10, String r11, String r12) {
        int r13 = r12.length();
        d r14 = f6151d;
        boolean r15 = r14.q();
        int r16 = ErrorCode.Contacts.PHONE_NO_PAGE_ERROR;
        if (r15 == false) goto L5;
        int r17 = (r13 + NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH) / ErrorCode.Contacts.PHONE_NO_PAGE_ERROR;
    L6:
        if (r17 <= 0) goto L21;
        int r18 = 1;
        if (r14.q() == false) goto L16;
        Log.println(r10, r11, r12.substring(0, ErrorCode.Contacts.PHONE_NO_PAGE_ERROR) + f6150c + "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    L11:
        if (r18 >= r17) goto L14;
        StringBuilder r19 = new StringBuilder();
        r19.append(" ");
        String r20 = f6150c;
        r19.append(r20);
        r19.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        r19.append(r20);
        r19.append("│ ");
        int r21 = r16 + ErrorCode.Contacts.PHONE_NO_PAGE_ERROR;
        r19.append(r12.substring(r16, r21));
        r19.append(r20);
        r19.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        Log.println(r10, r11, r19.toString());
        r18 = r18 + 1;
        r16 = r21;
        goto L11
    L14:
        if (r16 == (r13 + NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH)) goto L25;
        StringBuilder r22 = new StringBuilder();
        r22.append(" ");
        String r23 = f6150c;
        r22.append(r23);
        r22.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        r22.append(r23);
        r22.append("│ ");
        r22.append(r12.substring(r16, r13));
        Log.println(r10, r11, r22.toString());
        return;
    L25:
        return;
    L16:
        Log.println(r10, r11, r12.substring(0, ErrorCode.Contacts.PHONE_NO_PAGE_ERROR));
    L17:
        if (r18 >= r17) goto L19;
        StringBuilder r24 = new StringBuilder();
        r24.append(" ");
        r24.append(f6150c);
        int r25 = r16 + ErrorCode.Contacts.PHONE_NO_PAGE_ERROR;
        r24.append(r12.substring(r16, r25));
        Log.println(r10, r11, r24.toString());
        r18 = r18 + 1;
        r16 = r25;
        goto L17
    L19:
        if (r16 == r13) goto L27;
        Log.println(r10, r11, " " + f6150c + r12.substring(r16, r13));
        return;
    L27:
        return;
    L21:
        Log.println(r10, r11, r12);
        return;
    L5:
        r17 = r13 / ErrorCode.Contacts.PHONE_NO_PAGE_ERROR;
        goto L6
    }

    public static void D(int r10, String r11, String r12) {
        if (f6151d.q() == true) goto L6;
        Log.println(r10, r11, r12);
        return;
    L6:
        String[] r13 = r12.split(f6150c);
        int r14 = r13.length;
        int r15 = 0;
    L7:
        if (r15 >= r14) goto L9;
        Log.println(r10, r11, "│ " + r13[r15]);
        r15 = r15 + 1;
        goto L7
    }

    public static String E(int r10, Object... r11) {
        if (r11 == null) goto L10;
        int r12 = 0;
        if (r11.length != 1) goto L6;
        String r13 = n(r10, r11[0]);
    L12:
        if (r13.length() != 0) goto L16;
        return "log nothing";
    L16:
        return r13;
    L6:
        StringBuilder r14 = new StringBuilder();
        int r15 = r11.length;
    L7:
        if (r12 >= r15) goto L9;
        Object r16 = r11[r12];
        r14.append("args");
        r14.append("[");
        r14.append(r12);
        r14.append("]");
        r14.append(" = ");
        r14.append(o(r16));
        r14.append(f6150c);
        r12 = r12 + 1;
        goto L7
    L9:
        r13 = r14.toString();
        goto L12
    L10:
        r13 = "null";
        goto L12
    }

    public static String F(int r10, String r11, String[] r12, String r13) {
        StringBuilder r14 = new StringBuilder();
        int r15 = 0;
        if (f6151d.q() == false) goto L14;
        r14.append(" ");
        String r16 = f6150c;
        r14.append(r16);
        r14.append("┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
        r14.append(r16);
        if (r12 == null) goto L10;
        int r17 = r12.length;
        int r18 = 0;
    L7:
        if (r18 >= r17) goto L9;
        String r19 = r12[r18];
        r14.append("│ ");
        r14.append(r19);
        r14.append(f6150c);
        r18 = r18 + 1;
        goto L7
    L9:
        r14.append("├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
        r14.append(f6150c);
    L10:
        String[] r20 = r13.split(f6150c);
        int r21 = r20.length;
    L11:
        if (r15 >= r21) goto L13;
        String r22 = r20[r15];
        r14.append("│ ");
        r14.append(r22);
        r14.append(f6150c);
        r15 = r15 + 1;
        goto L11
    L13:
        r14.append("└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    L20:
        return r14.toString();
    L14:
        if (r12 == null) goto L18;
        r14.append(" ");
        r14.append(f6150c);
        int r23 = r12.length;
    L16:
        if (r15 >= r23) goto L18;
        r14.append(r12[r15]);
        r14.append(f6150c);
        r15 = r15 + 1;
    L18:
        r14.append(r13);
        goto L20
    }

    public static f G(String r12) {
        d r10 = f6151d;
        if (d.c(r10) == false) goto L5;
    L7:
        StackTraceElement[] r11 = new Throwable().getStackTrace();
        int r13 = r10.n() + 3;
        if (r13 < r11.length) goto L19;
        String r14 = q(r11[3]);
        if (d.c(r10) == false) goto L18;
        if (u(r12) == false) goto L18;
        int r15 = r14.indexOf(46);
        if (r15 != (-1)) goto L16;
        r12 = r14;
        goto L18
    L16:
        r12 = r14.substring(0, r15);
    L18:
        return new f(r12, null, ": ");
    L19:
        StackTraceElement r16 = r11[r13];
        String r17 = q(r16);
        if (d.c(r10) == false) goto L28;
        if (u(r12) == false) goto L28;
        int r18 = r17.indexOf(46);
        if (r18 != (-1)) goto L26;
        r12 = r17;
        goto L28
    L26:
        r12 = r17.substring(0, r18);
    L28:
        if (r10.r() == false) goto L39;
        String r19 = Thread.currentThread().getName();
        String r20 = new Formatter().format("%s, %s.%s(%s:%d)", new Object[]{r19, r16.getClassName(), r16.getMethodName(), r17, Integer.valueOf(r16.getLineNumber())}).toString();
        String r21 = " [" + r20 + "]: ";
        int r22 = 1;
        if (r10.m() <= 1) goto L32;
        int r23 = Math.min(r10.m(), r11.length - r13);
        String[] r24 = new String[r23];
        r24[0] = r20;
        int r25 = r19.length() + 2;
        String r26 = new Formatter().format("%" + r25 + "s", new Object[]{""}).toString();
    L34:
        if (r22 >= r23) goto L37;
        StackTraceElement r27 = r11[r22 + r13];
        r24[r22] = new Formatter().format("%s%s.%s(%s:%d)", new Object[]{r26, r27.getClassName(), r27.getMethodName(), q(r27), Integer.valueOf(r27.getLineNumber())}).toString();
        r22 = r22 + 1;
        goto L34
    L37:
        return new f(r12, r24, r21);
    L32:
        return new f(r12, new String[]{r20}, r21);
    L39:
        return new f(r12, null, ": ");
    L5:
        if (r10.r() == true) goto L7;
        r12 = r10.j();
        goto L39
    }

    public static void H(Object... r10) {
        v(5, f6151d.j(), r10);
    }

    public static /* synthetic */ SimpleArrayMap a() {
        return f6154g;
    }

    public static /* synthetic */ char[] b() {
        return f6148a;
    }

    public static /* synthetic */ String c() {
        return f6150c;
    }

    public static /* synthetic */ String d(Object r10) {
        return o(r10);
    }

    public static /* synthetic */ void e(int r10, String r11, String r12) {
        x(r10, r11, r12);
    }

    public static /* synthetic */ boolean f(String r10) {
        return t(r10);
    }

    public static /* synthetic */ String g() {
        return f6149b;
    }

    public static /* synthetic */ boolean h(String r10) {
        return u(r10);
    }

    public static boolean i(File r10) {
        if (r10 != null) goto L4;
    L11:
        return false;
    L4:
        if (r10.exists() == false) goto L9;
        if (r10.isDirectory() == false) goto L11;
    L10:
        return true;
    L9:
        if (r10.mkdirs() == false) goto L11;
        goto L10
    }

    public static boolean j(String r10, String r11) {
        File r12 = new File(r10);
        if (r12.exists() == false) goto L7;
        return r12.isFile();
    L7:
        if (i(r12.getParentFile()) == true) goto L18;
        return false;
    L18:
        k(r10, r11);     // Catch: IOException -> L13
        boolean r13 = r12.createNewFile();     // Catch: IOException -> L13
        if (r13 == false) goto L15;
        z(r10, r11);     // Catch: IOException -> L13
    L15:
        return r13;
    L13:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static void k(String r10, String r11) {
        d r12 = f6151d;
        if (r12.l() > 0) goto L5;
        return;
    L5:
        File[] r13 = new File(r10).getParentFile().listFiles(new b());
        if (r13 != null) goto L8;
        return;
    L8:
        if (r13.length <= 0) goto L28;
        SimpleDateFormat r14 = new SimpleDateFormat("yyyy_MM_dd", Locale.getDefault());
        long r15 = r14.parse(r11).getTime() - (((long) r12.l()) * 86400000);     // Catch: ParseException -> L17
        int r16 = r13.length;     // Catch: ParseException -> L17
        int r17 = 0;
    L12:
        if (r17 >= r16) goto L29;
        File r18 = r13[r17];     // Catch: ParseException -> L17
        String r19 = r18.getName();     // Catch: ParseException -> L17
        r19.length();     // Catch: ParseException -> L17
        if (r14.parse(m(r19)).getTime() > r15) goto L19;
        f6153f.execute(new c(r18));     // Catch: ParseException -> L17
    L19:
        r17 = r17 + 1;
        goto L12
    L29:
        return;
    L17:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public static void l(Object... r10) {
        v(6, f6151d.j(), r10);
    }

    public static String m(String r10) {
        Matcher r11 = Pattern.compile("[0-9]{4}_[0-9]{2}_[0-9]{2}").matcher(r10);
        if (r11.find() == true) goto L5;
        return "";
    L5:
        return r11.group();
    }

    public static String n(int r10, Object r11) {
        if (r11 != null) goto L6;
        return "null";
    L6:
        if (r10 != 32) goto L10;
        return e.i(r11, 32);
    L10:
        if (r10 != 48) goto L14;
        return e.i(r11, 48);
    L14:
        return o(r11);
    }

    public static String o(Object r10) {
        if (r10 != null) goto L5;
        return "null";
    L5:
        SimpleArrayMap r11 = f6154g;
        if (r11.isEmpty() == true) goto L9;
        p.a(r11.get(p(r10)));
    L9:
        return e.h(r10);
    }

    public static Class p(Object r10) {
        Class<?> r11 = r10.getClass();
        if (r11.isAnonymousClass() == false) goto L5;
    L6:
        Type[] r12 = r11.getGenericInterfaces();
        if (r12.length != 1) goto L13;
        Type r13 = r12[0];
    L10:
        if ((r13 instanceof ParameterizedType) == false) goto L12;
        r13 = ((ParameterizedType) r13).getRawType();
        goto L10
    L12:
        String r14 = r13.toString();
    L19:
        if (r14.startsWith("class ") == false) goto L22;
        r14 = r14.substring(6);
    L29:
        return Class.forName(r14);
    L26:
        e = move-exception;
        e.printStackTrace();
    L28:
        return r11;
    L22:
        if (r14.startsWith("interface ") == false) goto L29;
        r14 = r14.substring(10);
        goto L29
    L13:
        Type r15 = r11.getGenericSuperclass();
    L15:
        if ((r15 instanceof ParameterizedType) == false) goto L17;
        r15 = ((ParameterizedType) r15).getRawType();
        goto L15
    L17:
        r14 = r15.toString();
        goto L19
    L5:
        if (r11.isSynthetic() == false) goto L28;
        goto L6
    }

    public static String q(StackTraceElement r10) {
        String r11 = r10.getFileName();
        if (r11 == null) goto L5;
        return r11;
    L5:
        String r12 = r10.getClassName();
        String[] r13 = r12.split("\\.");
        if (r13.length <= 0) goto L8;
        r12 = r13[r13.length - 1];
    L8:
        int r14 = r12.indexOf(36);
        if (r14 == (-1)) goto L12;
        r12 = r12.substring(0, r14);
    L12:
        return r12 + ".java";
    }

    public static SimpleDateFormat r() {
        if (f6152e != null) goto L6;
        f6152e = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss.SSS ", Locale.getDefault());
    L6:
        return f6152e;
    }

    public static void s(String r10, String r11) {
        d r12 = f6151d;
        if (d.d(r12) != null) goto L28;
        BufferedWriter r13 = null;
        BufferedWriter r14 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(r11, true), "UTF-8"));     // Catch: Throwable -> L15 IOException -> L17
        r14.write(r10);     // Catch: Throwable -> L11 IOException -> L13
        r14.close();     // Catch: IOException -> L9
    L32:
        return;
    L13:
        e = e;
        r13 = r14;
    L18:
        e.printStackTrace();     // Catch: Throwable -> L15
        Log.e("LogUtils", "log to " + r11 + " failed!");     // Catch: Throwable -> L15
        if (r13 == null) goto L41;
        r13.close();     // Catch: IOException -> L9
        goto L32
    L41:
        return;
    L11:
        th = th;
        r13 = r14;
    L22:
        if (r13 != null) goto L30;
    L27:
        throw th;
    L30:
        r13.close();     // Catch: IOException -> L25
    L25:
        e = move-exception;
        e.printStackTrace();
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L17:
        e = e;
    L15:
        th = th;
        goto L22
    L28:
        d.d(r12).write(r11, r10);
    }

    public static boolean t(String r10) {
        return r10.matches("^" + f6151d.i() + "_[0-9]{4}_[0-9]{2}_[0-9]{2}_.*$");
    }

    public static boolean u(String r10) {
        if (r10 != null) goto L5;
        return true;
    L5:
        int r11 = r10.length();
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        if (Character.isWhitespace(r10.charAt(r12)) == false) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static void v(int r10, String r11, Object... r12) {
        d r13 = f6151d;
        if (r13.s() == true) goto L5;
        return;
    L5:
        int r14 = r10 & 15;
        int r15 = r10 & 240;
        if (r13.o() == true) goto L11;
        if (r13.p() == true) goto L11;
        if (r15 == 16) goto L11;
        return;
    L11:
        if (r14 < d.a(r13)) goto L13;
    L15:
        f r16 = G(r11);
        String r17 = E(r15, r12);
        if (r13.o() == false) goto L22;
        if (r15 == 16) goto L22;
        if (r14 < d.a(r13)) goto L22;
        w(r14, r16.f6179a, r16.f6180b, r17);
    L22:
        if (r13.p() == true) goto L25;
        if (r15 == 16) goto L25;
        return;
    L25:
        if (r14 < d.b(r13)) goto L30;
        f6153f.execute(new a(r14, r16, r17));
        return;
    L30:
        return;
    L13:
        if (r14 >= d.b(r13)) goto L15;
    }

    public static void w(int r10, String r11, String[] r12, String r13) {
        if (f6151d.t() == false) goto L5;
        C(r10, r11, F(r10, r11, r12, r13));
        return;
    L5:
        y(r10, r11, true);
        A(r10, r11, r12);
        B(r10, r11, r13);
        y(r10, r11, false);
    }

    public static void x(int r10, String r11, String r12) {
        String r13 = r().format(new Date());
        String r14 = r13.substring(0, 10);
        String r15 = r13.substring(11);
        StringBuilder r16 = new StringBuilder();
        d r17 = f6151d;
        r16.append(r17.f());
        r16.append(r17.i());
        r16.append("_");
        r16.append(r14);
        r16.append("_");
        r16.append(r17.k());
        r16.append(r17.g());
        String r18 = r16.toString();
        if (j(r18, r14) == true) goto L6;
        Log.e("LogUtils", "create " + r18 + " failed!");
        return;
    L6:
        s(r15 + f6148a[r10 - 2] + LibrarianImpl.Constants.SEPARATOR + r11 + r12 + f6150c, r18);
    }

    public static void y(int r10, String r11, boolean r12) {
        if (f6151d.q() == false) goto L9;
        if (r12 == false) goto L6;
        String r13 = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
    L7:
        Log.println(r10, r11, r13);
        return;
    L6:
        r13 = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";
        goto L7
    }

    public static void z(String r10, String r11) {
        String r12 = "";
        int r13 = 0;
        PackageInfo r14 = Utils.c().getPackageManager().getPackageInfo(Utils.c().getPackageName(), 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r14 == null) goto L9;
        r12 = r14.versionName;     // Catch: PackageManager.NameNotFoundException -> L7
        r13 = r14.versionCode;     // Catch: PackageManager.NameNotFoundException -> L7
    L9:
        s("************* Log Head ****************\nDate of Log        : " + r11 + "\nDevice Manufacturer: " + Build.MANUFACTURER + "\nDevice Model       : " + Build.MODEL + "\nAndroid Version    : " + Build.VERSION.RELEASE + "\nAndroid SDK        : " + Build.VERSION.SDK_INT + "\nApp VersionName    : " + r12 + "\nApp VersionCode    : " + r13 + "\n************* Log Head ****************\n\n", r10);
        return;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }
}
