package com.bytedance.android.live.openplatform.api.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class SchemaInfo {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final JSONObject f83975p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Set<String> f83976q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final LruCache<String, SchemaInfo> f83977r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final b f83978s = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Host f83979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f83980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f83981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f83982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public JSONObject f83983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f83984f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f83985g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f83986h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f83987i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f83988j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f83989k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f83990l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f83991m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public JSONObject f83992n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Uri f83993o;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$Host;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "MICROAPP", "MICROGAME", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Host extends Enum<Host> {
        public static final a Companion = null;
        public static final Host MICROAPP = null;
        public static final Host MICROGAME = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Host[] f83994a = null;
        private final String value;

        public static final class a {
            public a() {
            }
        }

        static {
            Host r100 = new Host("MICROAPP", 0, AppbrandHostConstants.Micro_Host.HOST_APPBRAND);
            MICROAPP = r100;
            Host r101 = new Host("MICROGAME", 1, AppbrandHostConstants.Micro_Host.HOST_GAME);
            MICROGAME = r101;
            f83994a = new Host[]{r100, r101};
            Companion = new a();
        }

        public static Host valueOf(String r100) {
            return (Host) r27.a.a(Host.class, r100);
        }

        public static Host[] values() {
            return (Host[]) f83994a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public Host(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$LaunchMode;", "", "", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "HOST_STACK", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum LaunchMode extends Enum<LaunchMode> {
        public static final a Companion = null;
        public static final LaunchMode HOST_STACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LaunchMode[] f83995a = null;
        private final String mode;

        public static final class a {
            public a() {
            }
        }

        static {
            LaunchMode r100 = new LaunchMode();
            HOST_STACK = r100;
            f83995a = new LaunchMode[]{r100};
            Companion = new a();
        }

        public static LaunchMode valueOf(String r100) {
            return (LaunchMode) r27.a.a(LaunchMode.class, r100);
        }

        public static LaunchMode[] values() {
            return (LaunchMode[]) f83995a.clone();
        }

        public LaunchMode() {
            super("HOST_STACK", 0);
            this.mode = "hostStack";
        }

        public final String getMode() {
            return this.mode;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u0000 \u00022\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/utils/SchemaInfo$VersionType;", "", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "current", "latest", "audit", "preview", AppConstants.CHANNEL_LOCAL_DEV, "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum VersionType extends Enum<VersionType> {
        public static final a Companion = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ VersionType[] f83996a = null;
        public static final VersionType audit = null;
        public static final VersionType current = null;
        public static final VersionType latest = null;
        public static final VersionType local_dev = null;
        public static final VersionType preview = null;

        public static final class a {
            public a() {
            }
        }

        static {
            VersionType r100 = new VersionType("current", 0);
            current = r100;
            VersionType r101 = new VersionType("latest", 1);
            latest = r101;
            VersionType r102 = new VersionType("audit", 2);
            audit = r102;
            VersionType r103 = new VersionType("preview", 3);
            preview = r103;
            VersionType r104 = new VersionType(AppConstants.CHANNEL_LOCAL_DEV, 4);
            local_dev = r104;
            f83996a = new VersionType[]{r100, r101, r102, r103, r104};
            Companion = new a();
        }

        public static VersionType valueOf(String r100) {
            return (VersionType) r27.a.a(VersionType.class, r100);
        }

        public static VersionType[] values() {
            return (VersionType[]) f83996a.clone();
        }

        public VersionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<String, String> f83997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f83998b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Host f83999c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public JSONObject f84000d;

        public final SchemaInfo d() throws Exception {
            if (this.f83998b.length() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == false) goto L8;
            this.f83998b = AppConstants.SCHEME_SS_LOCAL;
        L8:
            String r101 = this.f83997a.get("app_id");
            if (TextUtils.isEmpty(r101) == true) goto L11;
            Intrinsics.checkNotNull(r101);
            StringsKt.startsWith$default(r101, "tt", false, 2, null);
        L11:
            String r102 = this.f83997a.get("start_page");
            if (this.f83999c != Host.MICROGAME) goto L14;
            r102 = null;
        L14:
            if (r102 == null) goto L16;
            StringsKt.startsWith$default(r102, HTTP.URL_DEFAULT, false, 2, null);
        L16:
            VersionType.a r103 = VersionType.Companion;
            String r110 = this.f83997a.get("version_type");
            r103.getClass();
            VersionType[] r104 = VersionType.values();
            int r111 = r104.length;
            int r112 = 0;
        L17:
            if (r112 >= r111) goto L22;
            VersionType r113 = r104[r112];
            if (StringsKt.equals(r113.name(), r110, true) == true) goto L23;
            r112 = r112 + 1;
        L23:
            if (r113 != null) goto L25;
            r113 = VersionType.current;
        L25:
            String r105 = this.f83997a.get("version");
            if (TextUtils.isEmpty(r105) == false) goto L28;
            r105 = "v2";
        L28:
            String r114 = this.f83997a.get("scene");
            if (TextUtils.isEmpty(r114) == false) goto L32;
            r114 = "0";
        L32:
            if (r113 != VersionType.preview) goto L34;
        L36:
            String r106 = this.f83997a.get("token");
            JSONObject r107 = this.f84000d;
            if (r107 == null) goto L39;
            Intrinsics.checkNotNull(r107);
            r107.optString("launch_from");
        L39:
            Uri.Builder r108 = new Uri.Builder().scheme(this.f83998b).authority(this.f83999c.getValue()).appendQueryParameter("app_id", r101);
            JSONObject r109 = this.f84000d;
            if (r109 == null) goto L42;
            SchemaInfo.f83978s.getClass();
            r108.appendQueryParameter("bdp_log", b.c(r109));
        L42:
            Set<String> r115 = SchemaInfo.f83976q;
            Iterator<Map.Entry<String, String>> r116 = this.f83997a.entrySet().iterator();
        L44:
            if (r116.hasNext() == false) goto L49;
            Map.Entry<String, String> r117 = r116.next();
            if (r115.contains(r117.getKey()) == true) goto L44;
            r108.appendQueryParameter(r117.getKey(), r117.getValue());
            goto L44
        L49:
            r108.appendQueryParameter("scene", r114);
            if (r106 != null) goto L52;
        L58:
            if (r102 == null) goto L60;
            r108.appendQueryParameter("start_page", r102);
        L60:
            r108.appendQueryParameter("version", r105);
            r108.appendQueryParameter("version_type", r113.name());
            String r118 = r108.toString();
            if (TextUtils.isEmpty(r118) == false) goto L64;
        L95:
            String r119 = "";
        L96:
            r108.appendQueryParameter(AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM, r119);
            return new SchemaInfo(r108.build());
        L64:
            if (StringsKt.contains$default(r118, "://", false, 2, null) == false) goto L73;
            Object[] r120 = StringsKt.split$default(r118, new String[]{"://"}, false, 0, 6, null).toArray(new String[0]);
            if (r120 == null) goto L72;
            String[] r121 = (String[]) r120;
            if (r121.length < 2) goto L95;
            r118 = r121[1];
            goto L73
        L72:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        L73:
            StringBuilder r122 = new StringBuilder();
            if (r118 == null) goto L99;
            int r123 = 0;
            r122.append(r118.substring(0, 10));
            r122.append(AppbrandHostConstants.Schema_BDP_SUM.MD5_SALT);
            r122.append(r118.substring(10));
            String r124 = r122.toString();
            if (r124 != null) goto L100;
        L90:
            String r125 = null;
        L91:
            if (r125 == null) goto L95;
            if (TextUtils.isEmpty(r125) == true) goto L95;
            r119 = r125.substring(2, 6) + r125.substring(20, 23);
            goto L96
        L100:
            if (r124.length() == 0) goto L90;
            MessageDigest r126 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L89
            r126.update(r124.getBytes("UTF-8"));     // Catch: Exception -> L89
            byte[] r127 = r126.digest();     // Catch: Exception -> L89
            char[] r128 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};     // Catch: Exception -> L89
            char[] r129 = new char[r127.length * 2];     // Catch: Exception -> L89
            int r130 = 0;
        L82:
            if (r123 >= r127.length) goto L87;
            int r131 = r127[r123];     // Catch: Exception -> L89
            if (r131 >= 0) goto L86;
            r131 = r131 + 256;     // Catch: Exception -> L89
        L86:
            int r132 = r130 + 1;     // Catch: Exception -> L89
            r129[r130] = r128[r131 >>> 4];     // Catch: Exception -> L89
            r130 = r132 + 1;     // Catch: Exception -> L89
            r129[r132] = r128[r131 & 15];     // Catch: Exception -> L89
            r123 = r123 + 1;     // Catch: Exception -> L89
            goto L82
        L87:
            r125 = new String(r129);     // Catch: Exception -> L89
            goto L91
        L99:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        L52:
            if (r106.length() <= 0) goto L54;
            boolean r133 = true;
        L56:
            if (r133 != true) goto L58;
            r108.appendQueryParameter("token", r106);
            goto L58
        L54:
            r133 = false;
            goto L56
        L34:
            if (r113 == VersionType.local_dev) goto L36;
            this.f83997a.remove(AppbrandHostConstants.Schema_RESERVED_FIELD.INSPECT);
            goto L36
        L22:
            r113 = null;
            goto L23
        L5:
            r100 = false;
            goto L6
        }

        public a() {
            this.f83997a = new LinkedHashMap();
            this.f83998b = AppConstants.SCHEME_SS_LOCAL;
            this.f83999c = Host.MICROAPP;
            this.f84000d = null;
        }

        public final SchemaInfo c() {
            return d();
        L4:
            return null;
        }

        public a(String r110) {
            if (r110 != null) goto L5;
            r110 = "";
        L5:
            Uri r111 = UriProtector.parse(r110);
            b r100 = SchemaInfo.f83978s;
            r100.getClass();
            JSONObject r101 = null;
            if (r111 == null) goto L11;
            String r102 = r111.getEncodedQuery();
            if (r102 == null) goto L11;
            LinkedHashMap<String, String> r103 = b.d(r102);
        L12:
            if (r103 != null) goto L14;
            r103 = new LinkedHashMap();
        L14:
            this.f83997a = r103;
            if (r111 == null) goto L18;
            String r104 = r111.getScheme();
            if (r104 == null) goto L18;
        L19:
            this.f83998b = r104;
            Host.a r105 = Host.Companion;
            if (r111 == null) goto L22;
            String r112 = r111.getAuthority();
        L23:
            r105.getClass();
            Host[] r106 = Host.values();
            int r107 = r106.length;
            int r108 = 0;
        L24:
            if (r108 >= r107) goto L29;
            Host r109 = r106[r108];
            if (StringsKt.equals(r109.getValue(), r112, true) == true) goto L30;
            r108 = r108 + 1;
        L30:
            if (r109 != null) goto L32;
            r109 = Host.MICROAPP;
        L32:
            this.f83999c = r109;
            String r113 = r103.get("bdp_log");
            if (r113 == null) goto L35;
            r101 = b.a(r100, r113);
        L35:
            this.f84000d = r101;
            return;
        L29:
            r109 = null;
            goto L30
        L22:
            r112 = null;
        L18:
            r104 = AppConstants.SCHEME_SS_LOCAL;
        L11:
            r103 = null;
            goto L12
        }

        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            this.f83997a.put("app_id", r100);
        }

        public final void f(LaunchMode r100) {
            Intrinsics.checkNotNullParameter(r100, "launchMode");
            this.f83997a.put(AppbrandHostConstants.Schema_RESERVED_FIELD.LAUNCH_MOD, r100.getMode());
        }

        @Deprecated(message = "startPageAndQuery代替，保证query的key/value都会encode")
        public final void g(String r100) {
            Intrinsics.checkNotNullParameter(r100, "startPage");
            this.f83997a.put("start_page", r100);
        }

        public final void b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            JSONObject r102 = this.f84000d;
            if (r102 != null) goto L5;
            r102 = new JSONObject();
        L5:
            r102.put(r100, r101);
            this.f84000d = r102;
        }

        public final void e(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "rawValue");
            this.f83997a.put(r100, r101);
        }

        public final void h(String r100, Map r101) {
            Intrinsics.checkNotNullParameter(r100, "startPagePath");
            Intrinsics.checkNotNullParameter(r101, "startPageQuery");
            StringBuilder r102 = new StringBuilder(r100);
            Iterator r103 = r101.entrySet().iterator();
            int r104 = 0;
        L4:
            if (r103.hasNext() == false) goto L15;
            Object r105 = r103.next();
            int r106 = r104 + 1;
            if (r104 >= 0) goto L8;
            CollectionsKt.throwIndexOverflow();
        L8:
            Map.Entry r107 = (Map.Entry) r105;
            if (r104 == 0) goto L11;
        L13:
            r102.append("&");
        L14:
            r102.append(Uri.encode((String) r107.getKey()));
            r102.append(ContainerUtils.KEY_VALUE_DELIMITER);
            r102.append(Uri.encode((String) r107.getValue()));
            r104 = r106;
            goto L4
        L11:
            if (StringsKt.contains$default(r102, "?", false, 2, null) == true) goto L13;
            r102.append("?");
            goto L14
        L15:
            this.f83997a.put("start_page", r102.toString());
        }
    }

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static SchemaInfo b(String r100) {
            if (r100 != null) goto L4;
            return null;
        L4:
            if (r100.length() != 0) goto L6;
            boolean r101 = true;
        L7:
            if (r101 == true) goto L28;
            LruCache<String, SchemaInfo> r102 = SchemaInfo.f83977r;
            SchemaInfo r103 = r102.get(r100);
            if (r103 != null) goto L23;
            monitor-enter(r102);
            r103 = r102.get(r100);     // Catch: Throwable -> L20
            if (r103 != null) goto L15;
            r103 = new a(r100).c();     // Catch: Throwable -> L20
        L15:
            if (r103 == null) goto L17;
            Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L20
            r102.put(r100, r103);     // Catch: Throwable -> L20
        L17:
            Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L20
            monitor-exit(r102);
        L20:
            th = move-exception;
            throw th;
        L23:
            return r103;
        L28:
            return null;
        L6:
            r101 = false;
            goto L7
        }

        public static String c(JSONObject r100) {
            if (r100 != null) goto L6;
            return "";
        L6:
            return StringsKt.replace$default(r100.toString(), "\\/", HTTP.URL_DEFAULT, false, 4, null);
        }

        public static LinkedHashMap d(String r110) {
            if (r110.length() != 0) goto L5;
            boolean r100 = true;
        L7:
            if (r100 == false) goto L23;
            return null;
        L23:
            LinkedHashMap r101 = new LinkedHashMap();     // Catch: Throwable -> L22
            Iterator<String> r111 = new Regex("&").split(r110, 0).iterator();     // Catch: Throwable -> L22
        L11:
            if (r111.hasNext() == false) goto L21;
            String r102 = r111.next();     // Catch: Throwable -> L22
            int r103 = StringsKt.indexOf$default(r102, ContainerUtils.KEY_VALUE_DELIMITER, 0, false, 6, null);     // Catch: Throwable -> L22
            if (r103 >= 0) goto L15;
            r101.put(URLDecoder.decode(r102, "UTF-8"), "");     // Catch: Throwable -> L22
            goto L11
        L15:
            if (r102 == null) goto L18;
            r101.put(URLDecoder.decode(r102.substring(0, r103), "UTF-8"), URLDecoder.decode(r102.substring(r103 + 1), "UTF-8"));     // Catch: Throwable -> L22
            goto L11
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");     // Catch: Throwable -> L22
        L21:
            return r101;
        L22:
            return null;
        L5:
            r100 = false;
            goto L7
        }

        public static final JSONObject a(b r100, String r101) {
            r100.getClass();
            if (TextUtils.isEmpty(r101) == false) goto L10;
        L7:
            return null;
        L10:
            Intrinsics.checkNotNull(r101);     // Catch: Exception -> L9
            return new JSONObject(r101);
        }
    }

    static {
        f83978s = new b();
        f83975p = new JSONObject();
        f83976q = SetsKt.setOf(new String[]{"start_page", "token", "version_type", "version", "scene", "app_id", "bdp_log", AppbrandHostConstants.Schema_RESERVED_FIELD.BDPSUM});
        f83977r = new LruCache(50);
        SetsKt.hashSetOf(new String[]{"ttc9b5bf08568f9ab2", "tt28f55e48b7ce0cb6"});
    }

    public final String a() {
        String r100 = this.f83980b;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L12;
        String r102 = String.valueOf(c("app_id"));
        this.f83980b = r102;
        return r102;
    L12:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final JSONObject b() {
        JSONObject r100 = this.f83983e;
        if (r100 == f83975p) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L12;
        JSONObject r102 = b.a(f83978s, c("bdp_log"));
        this.f83983e = r102;
        return r102;
    L12:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final String d() {
        String r100 = this.f83991m;
        boolean r101 = true;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r102 = true;
    L6:
        String r103 = null;
        if (r102 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L25;
        JSONObject r104 = b();
        if (r104 == null) goto L14;
        r103 = r104.optString("location");
    L14:
        if (r103 != null) goto L16;
    L19:
        if (r101 == true) goto L21;
        r100 = r103;
    L24:
        this.f83991m = r100;
        goto L25
    L21:
        r100 = c("location");
        if (r100 != null) goto L24;
        r100 = "";
        goto L24
    L16:
        if (r103.length() == 0) goto L19;
        r101 = false;
    L25:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    public final String e() {
        String r100 = this.f83986h;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        r100 = null;
    L9:
        if (r100 != null) goto L12;
        String r102 = c("start_page");
        this.f83986h = r102;
        return r102;
    L12:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final String f() {
        String r100 = this.f83987i;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r101 = true;
    L6:
        String r102 = null;
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L18;
        String r103 = e();
        if (r103 == null) goto L16;
        List<String> r104 = new Regex("\\?").split(r103, 0);
        if (r104 == null) goto L16;
        r102 = (String) CollectionsKt.getOrNull(r104, 0);
    L16:
        this.f83987i = r102;
        return r102;
    L18:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final String g() {
        String r100 = this.f83989k;
        if (r100 == "UNINITIALIZED_STRING") goto L5;
        boolean r101 = true;
    L6:
        String r102 = null;
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 != null) goto L18;
        String r103 = e();
        if (r103 == null) goto L16;
        List<String> r104 = new Regex("\\?").split(r103, 0);
        if (r104 == null) goto L16;
        r102 = (String) CollectionsKt.getOrNull(r104, 1);
    L16:
        this.f83989k = r102;
        return r102;
    L18:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public final String h() {
        return this.f83993o.toString();
    }

    public final int hashCode() {
        return this.f83993o.hashCode();
    }

    public final String toString() {
        return this.f83993o.toString();
    }

    public SchemaInfo(Uri r100) {
        this.f83993o = r100;
        if (TextUtils.isEmpty(r100.getScheme()) == true) goto L6;
        Intrinsics.checkNotNull(r100.getScheme());
    L6:
        Host.a r101 = Host.Companion;
        String r102 = r100.getHost();
        r101.getClass();
        Host[] r103 = Host.values();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L12;
        Host r106 = r103[r105];
        if (StringsKt.equals(r106.getValue(), r102, true) == true) goto L13;
        r105 = r105 + 1;
    L13:
        if (r106 != null) goto L15;
        r106 = Host.MICROAPP;
    L15:
        this.f83979a = r106;
        this.f83980b = "UNINITIALIZED_STRING";
        Function0<VersionType> r107 = new SchemaInfo$versionType$2(this);
        LazyThreadSafetyMode r108 = LazyThreadSafetyMode.PUBLICATION;
        this.f83981c = LazyKt.lazy(r108, r107);
        JSONObject r109 = f83975p;
        this.f83982d = "UNINITIALIZED_STRING";
        this.f83983e = r109;
        this.f83984f = LazyKt.lazy(r108, new SchemaInfo$techType$2(this));
        this.f83985g = LazyKt.lazy(r108, new SchemaInfo$mpType$2(this));
        this.f83986h = "UNINITIALIZED_STRING";
        this.f83987i = "UNINITIALIZED_STRING";
        this.f83988j = LazyKt.lazy(r108, new SchemaInfo$startPageQuery$2(this));
        this.f83989k = "UNINITIALIZED_STRING";
        this.f83990l = "UNINITIALIZED_STRING";
        this.f83991m = "UNINITIALIZED_STRING";
        this.f83992n = r109;
        return;
    L12:
        r106 = null;
        goto L13
    }

    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return UriProtector.getQueryParameter(this.f83993o, r100);
    L5:
        return null;
    }

    public final boolean equals(Object r100) {
        if (Intrinsics.areEqual(r100, this) == false) goto L7;
        return true;
    L7:
        if ((r100 instanceof SchemaInfo) == true) goto L9;
        return false;
    L9:
        return Intrinsics.areEqual(this.f83993o, ((SchemaInfo) r100).f83993o);
    }
}
