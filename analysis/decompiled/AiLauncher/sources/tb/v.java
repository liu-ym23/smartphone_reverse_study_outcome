package tb;

import La.H;
import La.K;
import Z8.C1173v;
import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonPointer;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;
import v9.C5678g;
import v9.C5685n;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\"\u0018\u0000  2\u00020\u0001:\u0002+.Bc\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u0002¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\u0007H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0002H\u0016¢\u0006\u0004\b*\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b.\u0010,\u001a\u0004\b\u0004\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b/\u0010,\u001a\u0004\b\u0005\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b0\u0010,\u001a\u0004\b1\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00078\u0007¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u0010)R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0007¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001e\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b9\u00106R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b\f\u0010\u001bR\u0014\u0010\r\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010,R\u0011\u0010<\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0011\u0010=\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b5\u0010\u001bR\u0011\u0010>\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b.\u0010\u001bR\u0011\u0010?\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b/\u0010\u001bR\u0017\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00020\t8G¢\u0006\u0006\u001a\u0004\b0\u00108R\u0013\u0010A\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b2\u0010\u001bR\u0013\u0010C\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\bB\u0010\u001bR\u0011\u0010E\u001a\u00020\u00078G¢\u0006\u0006\u001a\u0004\bD\u0010)R\u0013\u0010F\u001a\u0004\u0018\u00010\u00028G¢\u0006\u0006\u001a\u0004\b+\u0010\u001b¨\u0006G"}, d2 = {"Ltb/v;", "", "", "scheme", "username", "password", "host", "", "port", "", "pathSegments", "queryNamesAndValues", "fragment", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Ljava/net/URL;", "v", "()Ljava/net/URL;", "Ljava/net/URI;", "u", "()Ljava/net/URI;", "index", "o", "(I)Ljava/lang/String;", "p", "r", "()Ljava/lang/String;", "link", "s", "(Ljava/lang/String;)Ltb/v;", "Ltb/v$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Ltb/v$a;", "k", "(Ljava/lang/String;)Ltb/v$a;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "t", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_UMID, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "e", "I", "m", "f", "Ljava/util/List;", "l", "()Ljava/util/List;", Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Z", "isHttps", "encodedUsername", "encodedPassword", "encodedPath", "encodedPathSegments", "encodedQuery", "n", "query", "q", "querySize", "encodedFragment", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class v {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final String scheme;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String username;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String password;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String host;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int port;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final List<String> pathSegments;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final List<String> queryNamesAndValues;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final String fragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final String url;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010!\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b#\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\r\u001a\u00020\f*\b\u0012\u0004\u0012\u00020\b0\u00072\n\u0010\u000b\u001a\u00060\tj\u0002`\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u0003J\u0017\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\u001cJ\u001b\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u001e*\u00020\bH\u0002¢\u0006\u0004\b\u001f\u0010 J'\u0010!\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b!\u0010\"J#\u0010#\u001a\u00020\u0004*\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b#\u0010\"J'\u0010$\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b$\u0010\"J'\u0010%\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0002¢\u0006\u0004\b%\u0010\"J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\b¢\u0006\u0004\b*\u0010(J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\b¢\u0006\u0004\b,\u0010(J\u0015\u0010.\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\b¢\u0006\u0004\b.\u0010(J\u0015\u00100\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0004¢\u0006\u0004\b0\u00101J\u0017\u00103\u001a\u00020\u00002\b\u00102\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b3\u0010(J\u0017\u00105\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b5\u0010(J\u001f\u00108\u001a\u00020\u00002\u0006\u00106\u001a\u00020\b2\b\u00107\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b8\u00109J\u001f\u0010<\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\b2\b\u0010;\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b<\u00109J\u000f\u0010=\u001a\u00020\u0000H\u0000¢\u0006\u0004\b=\u0010>J\r\u0010@\u001a\u00020?¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\bH\u0016¢\u0006\u0004\bB\u0010CJ!\u0010E\u001a\u00020\u00002\b\u0010D\u001a\u0004\u0018\u00010?2\u0006\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0004\bE\u0010FR$\u0010&\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010G\u001a\u0004\bH\u0010C\"\u0004\bI\u0010JR\"\u0010M\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u0010G\u001a\u0004\bK\u0010C\"\u0004\bL\u0010JR\"\u0010P\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010G\u001a\u0004\bN\u0010C\"\u0004\bO\u0010JR$\u0010-\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010G\u001a\u0004\bQ\u0010C\"\u0004\bR\u0010JR\"\u0010/\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u0010S\u001a\u0004\bT\u0010\u0006\"\u0004\bU\u0010VR \u0010Z\u001a\b\u0012\u0004\u0012\u00020\b0\u001e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bW\u0010YR,\u0010^\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010X\u001a\u0004\b[\u0010Y\"\u0004\b\\\u0010]R$\u0010a\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010G\u001a\u0004\b_\u0010C\"\u0004\b`\u0010J¨\u0006b"}, d2 = {"Ltb/v$a;", "", "<init>", "()V", "", Const.INTENT_KEY_UMID, "()I", "", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "LY8/t;", "C", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "input", "startPos", "limit", "s", "(Ljava/lang/String;II)V", "pos", "", "addTrailingSlash", "alreadyEncoded", "p", "(Ljava/lang/String;IIZZ)V", "m", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "", "D", "(Ljava/lang/String;)Ljava/util/List;", "u", "(Ljava/lang/String;II)I", "B", "o", "k", "scheme", "t", "(Ljava/lang/String;)Ltb/v$a;", "username", ExifInterface.LONGITUDE_EAST, "password", "l", "host", Const.INTENT_KEY_BACKGROUND_COMMAND, "port", "n", "(I)Ltb/v$a;", "query", "q", "encodedQuery", "e", "name", UxipConstants.f30680s, Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Ljava/lang/String;)Ltb/v$a;", "encodedName", "encodedValue", Const.INTENT_KEY_APIKEY, "r", "()Ltb/v$a;", "Ltb/v;", "c", "()Ltb/v;", "toString", "()Ljava/lang/String;", "base", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ltb/v;Ljava/lang/String;)Ltb/v$a;", "Ljava/lang/String;", "getScheme$okhttp", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/lang/String;)V", "getEncodedUsername$okhttp", "x", "encodedUsername", "getEncodedPassword$okhttp", "w", "encodedPassword", "getHost$okhttp", "y", "I", "getPort$okhttp", "z", "(I)V", "f", "Ljava/util/List;", "()Ljava/util/List;", "encodedPathSegments", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedQueryNamesAndValues", "getEncodedFragment$okhttp", "v", "encodedFragment", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public String scheme;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        public String host;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        public List<String> encodedQueryNamesAndValues;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        public String encodedFragment;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public String encodedUsername = "";

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public String encodedPassword = "";

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        public int port = -1;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        public final List<String> encodedPathSegments = C1173v.s("");

        public final void A(String str) {
            this.scheme = str;
        }

        public final int B(String str, int i10, int i11) {
            int i12 = 0;
            while (i10 < i11) {
                char cCharAt = str.charAt(i10);
                if (cCharAt != '/' && cCharAt != '\\') {
                    break;
                }
                i12++;
                i10++;
            }
            return i12;
        }

        public final void C(List<String> list, StringBuilder sb2) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb2.append(JsonPointer.SEPARATOR);
                sb2.append(list.get(i10));
            }
        }

        public final List<String> D(String str) {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 <= str.length()) {
                String str2 = str;
                int iT0 = H.t0(str2, '&', i10, false, 4, null);
                if (iT0 == -1) {
                    iT0 = str2.length();
                }
                int iT02 = H.t0(str2, '=', i10, false, 4, null);
                if (iT02 == -1 || iT02 > iT0) {
                    String strSubstring = str2.substring(i10, iT0);
                    kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str2.substring(i10, iT02);
                    kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str2.substring(iT02 + 1, iT0);
                    kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
                    arrayList.add(strSubstring3);
                }
                i10 = iT0 + 1;
                str = str2;
            }
            return arrayList;
        }

        public final a E(String username) {
            kotlin.jvm.internal.p.i(username, "username");
            this.encodedUsername = Jb.a.b(username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        public final a a(String encodedName, String encodedValue) {
            kotlin.jvm.internal.p.i(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            kotlin.jvm.internal.p.f(list);
            list.add(Jb.a.b(encodedName, 0, 0, " \"'<>#&=", true, false, true, false, 83, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            kotlin.jvm.internal.p.f(list2);
            list2.add(encodedValue != null ? Jb.a.b(encodedValue, 0, 0, " \"'<>#&=", true, false, true, false, 83, null) : null);
            return this;
        }

        public final a b(String name, String value) {
            kotlin.jvm.internal.p.i(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            kotlin.jvm.internal.p.f(list);
            list.add(Jb.a.b(name, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 91, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            kotlin.jvm.internal.p.f(list2);
            list2.add(value != null ? Jb.a.b(value, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 91, null) : null);
            return this;
        }

        public final v c() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String strG = Jb.a.g(this.encodedUsername, 0, 0, false, 7, null);
            String strG2 = Jb.a.g(this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iD = d();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(C1174w.x(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Jb.a.g((String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                List<String> list3 = list2;
                arrayList = new ArrayList(C1174w.x(list3, 10));
                for (String str3 : list3) {
                    arrayList.add(str3 != null ? Jb.a.g(str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new v(str, strG, strG2, str2, iD, arrayList2, arrayList, str4 != null ? Jb.a.g(str4, 0, 0, false, 7, null) : null, toString(), null);
        }

        public final int d() {
            int i10 = this.port;
            if (i10 != -1) {
                return i10;
            }
            Companion companion = v.INSTANCE;
            String str = this.scheme;
            kotlin.jvm.internal.p.f(str);
            return companion.b(str);
        }

        public final a e(String encodedQuery) {
            String strB;
            this.encodedQueryNamesAndValues = (encodedQuery == null || (strB = Jb.a.b(encodedQuery, 0, 0, " \"'<>#", true, false, true, false, 83, null)) == null) ? null : D(strB);
            return this;
        }

        public final List<String> f() {
            return this.encodedPathSegments;
        }

        public final a g(String host) {
            kotlin.jvm.internal.p.i(host, "host");
            String strK = ub.l.k(Jb.a.g(host, 0, 0, false, 7, null));
            if (strK != null) {
                this.host = strK;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        public final boolean h(String input) {
            return kotlin.jvm.internal.p.d(input, ".") || La.D.L(input, "%2e", true);
        }

        public final boolean i(String input) {
            return kotlin.jvm.internal.p.d(input, "..") || La.D.L(input, "%2e.", true) || La.D.L(input, ".%2e", true) || La.D.L(input, "%2e%2e", true);
        }

        public final a j(v base, String input) throws NumberFormatException {
            String str;
            int i10;
            boolean z10;
            int i11;
            int i12;
            char c10;
            String input2 = input;
            kotlin.jvm.internal.p.i(input2, "input");
            int iP = ub.n.p(input2, 0, 0, 3, null);
            int iR = ub.n.r(input2, iP, 0, 2, null);
            int iU = u(input2, iP, iR);
            boolean z11 = true;
            if (iU != -1) {
                if (La.D.U(input2, Const.HTTPS_START, iP, true)) {
                    this.scheme = "https";
                    iP += 6;
                } else {
                    if (!La.D.U(input2, Const.HTTP_START, iP, true)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input2.substring(0, iU);
                        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
                        sb2.append(strSubstring);
                        sb2.append('\'');
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    this.scheme = "http";
                    iP += 5;
                }
            } else {
                if (base == null) {
                    if (input2.length() > 6) {
                        str = K.R1(input2, 6) + "...";
                    } else {
                        str = input2;
                    }
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + str);
                }
                this.scheme = base.getScheme();
            }
            int iB = B(input2, iP, iR);
            char c11 = '?';
            char c12 = '#';
            if (iB >= 2 || base == null || !kotlin.jvm.internal.p.d(base.getScheme(), this.scheme)) {
                boolean z12 = false;
                boolean z13 = false;
                int i13 = iP + iB;
                while (true) {
                    i10 = ub.n.i(input2, "@/\\?#", i13, iR);
                    char cCharAt = i10 != iR ? input2.charAt(i10) : (char) 65535;
                    if (cCharAt == 65535 || cCharAt == c12 || cCharAt == '/' || cCharAt == '\\' || cCharAt == c11) {
                        break;
                    }
                    if (cCharAt == '@') {
                        if (z12) {
                            z10 = z11;
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.encodedPassword);
                            sb3.append("%40");
                            input2 = input;
                            i11 = i10;
                            sb3.append(Jb.a.b(input2, i13, i10, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null));
                            this.encodedPassword = sb3.toString();
                        } else {
                            int iH = ub.n.h(input2, ':', i13, i10);
                            z10 = z11;
                            String strB = Jb.a.b(input2, i13, iH, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                            if (z13) {
                                strB = this.encodedUsername + "%40" + strB;
                            }
                            this.encodedUsername = strB;
                            if (iH != i10) {
                                i12 = i10;
                                this.encodedPassword = Jb.a.b(input, iH + 1, i12, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                                z12 = z10;
                            } else {
                                i12 = i10;
                            }
                            input2 = input;
                            i11 = i12;
                            z13 = z10;
                        }
                        i13 = i11 + 1;
                        z11 = z10;
                        c12 = '#';
                        c11 = '?';
                    }
                }
                int iO = o(input2, i13, i10);
                int i14 = iO + 1;
                if (i14 < i10) {
                    this.host = ub.l.k(Jb.a.g(input2, i13, iO, false, 4, null));
                    int iK = k(input2, i14, i10);
                    this.port = iK;
                    if (iK == -1) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid URL port: \"");
                        String strSubstring2 = input2.substring(i14, i10);
                        kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
                        sb4.append(strSubstring2);
                        sb4.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                } else {
                    this.host = ub.l.k(Jb.a.g(input2, i13, iO, false, 4, null));
                    Companion companion = v.INSTANCE;
                    String str2 = this.scheme;
                    kotlin.jvm.internal.p.f(str2);
                    this.port = companion.b(str2);
                }
                if (this.host == null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid URL host: \"");
                    String strSubstring3 = input2.substring(i13, iO);
                    kotlin.jvm.internal.p.h(strSubstring3, "substring(...)");
                    sb5.append(strSubstring3);
                    sb5.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
                iP = i10;
            } else {
                this.encodedUsername = base.f();
                this.encodedPassword = base.b();
                this.host = base.getHost();
                this.port = base.getPort();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.d());
                if (iP == iR || input2.charAt(iP) == '#') {
                    e(base.e());
                }
            }
            int i15 = ub.n.i(input2, "?#", iP, iR);
            s(input2, iP, i15);
            if (i15 >= iR || input2.charAt(i15) != '?') {
                c10 = '#';
            } else {
                c10 = '#';
                int iH2 = ub.n.h(input2, '#', i15, iR);
                this.encodedQueryNamesAndValues = D(Jb.a.b(input2, i15 + 1, iH2, " \"'<>#", true, false, true, false, 80, null));
                i15 = iH2;
            }
            if (i15 < iR && input2.charAt(i15) == c10) {
                this.encodedFragment = Jb.a.b(input2, i15 + 1, iR, "", true, false, false, true, 48, null);
            }
            return this;
        }

        public final int k(String input, int pos, int limit) throws NumberFormatException {
            int i10;
            try {
                i10 = Integer.parseInt(Jb.a.b(input, pos, limit, "", false, false, false, false, 120, null));
            } catch (NumberFormatException unused) {
            }
            if (1 > i10 || i10 >= 65536) {
                return -1;
            }
            return i10;
        }

        public final a l(String password) {
            kotlin.jvm.internal.p.i(password, "password");
            this.encodedPassword = Jb.a.b(password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        public final void m() {
            if (this.encodedPathSegments.remove(r0.size() - 1).length() != 0 || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                this.encodedPathSegments.set(r2.size() - 1, "");
            }
        }

        public final a n(int port) {
            if (1 <= port && port < 65536) {
                this.port = port;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + port).toString());
        }

        public final int o(String input, int pos, int limit) {
            while (pos < limit) {
                char cCharAt = input.charAt(pos);
                if (cCharAt == ':') {
                    return pos;
                }
                if (cCharAt == '[') {
                    do {
                        pos++;
                        if (pos < limit) {
                        }
                    } while (input.charAt(pos) != ']');
                }
                pos++;
            }
            return limit;
        }

        public final void p(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String strB = Jb.a.b(input, pos, limit, " \"<>^`{}|/\\?#", alreadyEncoded, false, false, false, 112, null);
            if (h(strB)) {
                return;
            }
            if (i(strB)) {
                m();
                return;
            }
            if (this.encodedPathSegments.get(r12.size() - 1).length() == 0) {
                this.encodedPathSegments.set(r12.size() - 1, strB);
            } else {
                this.encodedPathSegments.add(strB);
            }
            if (addTrailingSlash) {
                this.encodedPathSegments.add("");
            }
        }

        public final a q(String query) {
            String strB;
            this.encodedQueryNamesAndValues = (query == null || (strB = Jb.a.b(query, 0, 0, " \"'<>#", false, false, true, false, 91, null)) == null) ? null : D(strB);
            return this;
        }

        public final a r() {
            String str = this.host;
            this.host = str != null ? new Regex("[\"<>^`{|}]").l(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i10 = 0; i10 < size; i10++) {
                List<String> list = this.encodedPathSegments;
                list.set(i10, Jb.a.b(list.get(i10), 0, 0, "[]", true, true, false, false, 99, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    String str2 = list2.get(i11);
                    list2.set(i11, str2 != null ? Jb.a.b(str2, 0, 0, "\\^`{|}", true, true, true, false, 67, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Jb.a.b(str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 35, null) : null;
            return this;
        }

        public final void s(String input, int startPos, int limit) {
            if (startPos == limit) {
                return;
            }
            char cCharAt = input.charAt(startPos);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                startPos++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            int i10 = startPos;
            while (i10 < limit) {
                int i11 = ub.n.i(input, "/\\", i10, limit);
                boolean z10 = i11 < limit;
                a aVar = this;
                String str = input;
                aVar.p(str, i10, i11, z10, true);
                if (z10) {
                    i10 = i11 + 1;
                    this = aVar;
                    input = str;
                } else {
                    this = aVar;
                    input = str;
                    i10 = i11;
                }
            }
        }

        public final a t(String scheme) {
            kotlin.jvm.internal.p.i(scheme, "scheme");
            if (La.D.L(scheme, "http", true)) {
                this.scheme = "http";
                return this;
            }
            if (La.D.L(scheme, "https", true)) {
                this.scheme = "https";
                return this;
            }
            throw new IllegalArgumentException("unexpected scheme: " + scheme);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L12
                r0.append(r1)
                java.lang.String r1 = "://"
                r0.append(r1)
                goto L17
            L12:
                java.lang.String r1 = "//"
                r0.append(r1)
            L17:
                java.lang.String r1 = r6.encodedUsername
                int r1 = r1.length()
                r2 = 58
                if (r1 <= 0) goto L22
                goto L2a
            L22:
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L44
            L2a:
                java.lang.String r1 = r6.encodedUsername
                r0.append(r1)
                java.lang.String r1 = r6.encodedPassword
                int r1 = r1.length()
                if (r1 <= 0) goto L3f
                r0.append(r2)
                java.lang.String r1 = r6.encodedPassword
                r0.append(r1)
            L3f:
                r1 = 64
                r0.append(r1)
            L44:
                java.lang.String r1 = r6.host
                if (r1 == 0) goto L69
                kotlin.jvm.internal.p.f(r1)
                r3 = 2
                r4 = 0
                r5 = 0
                boolean r1 = La.H.f0(r1, r2, r5, r3, r4)
                if (r1 == 0) goto L64
                r1 = 91
                r0.append(r1)
                java.lang.String r1 = r6.host
                r0.append(r1)
                r1 = 93
                r0.append(r1)
                goto L69
            L64:
                java.lang.String r1 = r6.host
                r0.append(r1)
            L69:
                int r1 = r6.port
                r3 = -1
                if (r1 != r3) goto L72
                java.lang.String r1 = r6.scheme
                if (r1 == 0) goto L8b
            L72:
                int r1 = r6.d()
                java.lang.String r3 = r6.scheme
                if (r3 == 0) goto L85
                tb.v$b r4 = tb.v.INSTANCE
                kotlin.jvm.internal.p.f(r3)
                int r3 = r4.b(r3)
                if (r1 == r3) goto L8b
            L85:
                r0.append(r2)
                r0.append(r1)
            L8b:
                java.util.List<java.lang.String> r1 = r6.encodedPathSegments
                r6.C(r1, r0)
                java.util.List<java.lang.String> r1 = r6.encodedQueryNamesAndValues
                if (r1 == 0) goto La3
                r1 = 63
                r0.append(r1)
                tb.v$b r1 = tb.v.INSTANCE
                java.util.List<java.lang.String> r2 = r6.encodedQueryNamesAndValues
                kotlin.jvm.internal.p.f(r2)
                tb.v.Companion.a(r1, r2, r0)
            La3:
                java.lang.String r1 = r6.encodedFragment
                if (r1 == 0) goto Lb1
                r1 = 35
                r0.append(r1)
                java.lang.String r6 = r6.encodedFragment
                r0.append(r6)
            Lb1:
                java.lang.String r6 = r0.toString()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: tb.v.a.toString():java.lang.String");
        }

        public final int u(String input, int pos, int limit) {
            if (limit - pos < 2) {
                return -1;
            }
            char cCharAt = input.charAt(pos);
            if ((kotlin.jvm.internal.p.k(cCharAt, 97) >= 0 && kotlin.jvm.internal.p.k(cCharAt, 122) <= 0) || (kotlin.jvm.internal.p.k(cCharAt, 65) >= 0 && kotlin.jvm.internal.p.k(cCharAt, 90) <= 0)) {
                while (true) {
                    pos++;
                    if (pos >= limit) {
                        break;
                    }
                    char cCharAt2 = input.charAt(pos);
                    if ('a' > cCharAt2 || cCharAt2 >= '{') {
                        if ('A' > cCharAt2 || cCharAt2 >= '[') {
                            if ('0' > cCharAt2 || cCharAt2 >= ':') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return pos;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        public final void v(String str) {
            this.encodedFragment = str;
        }

        public final void w(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final void x(String str) {
            kotlin.jvm.internal.p.i(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void y(String str) {
            this.host = str;
        }

        public final void z(int i10) {
            this.port = i10;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\t*\u00020\u0004H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\u000bJ'\u0010\u0012\u001a\u00020\u0011*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\n\u0010\u0010\u001a\u00060\u000ej\u0002`\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Ltb/v$b;", "", "<init>", "()V", "", "scheme", "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;)I", "Ltb/v;", "c", "(Ljava/lang/String;)Ltb/v;", Const.INTENT_KEY_UMID, "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "LY8/t;", "e", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "okhttp"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: tb.v$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final int b(String scheme) {
            kotlin.jvm.internal.p.i(scheme, "scheme");
            if (kotlin.jvm.internal.p.d(scheme, "http")) {
                return 80;
            }
            return kotlin.jvm.internal.p.d(scheme, "https") ? 443 : -1;
        }

        public final v c(String str) {
            kotlin.jvm.internal.p.i(str, "<this>");
            return new a().j(null, str).c();
        }

        public final v d(String str) {
            kotlin.jvm.internal.p.i(str, "<this>");
            try {
                return c(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final void e(List<String> list, StringBuilder sb2) {
            C5678g c5678gR = C5685n.r(C5685n.s(0, list.size()), 2);
            int first = c5678gR.getFirst();
            int last = c5678gR.getLast();
            int step = c5678gR.getStep();
            if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
                return;
            }
            while (true) {
                String str = list.get(first);
                String str2 = list.get(first + 1);
                if (first > 0) {
                    sb2.append('&');
                }
                sb2.append(str);
                if (str2 != null) {
                    sb2.append('=');
                    sb2.append(str2);
                }
                if (first == last) {
                    return;
                } else {
                    first += step;
                }
            }
        }

        public Companion() {
        }
    }

    public /* synthetic */ v(String str, String str2, String str3, String str4, int i10, List list, List list2, String str5, String str6, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, str4, i10, list, list2, str5, str6);
    }

    public static final v g(String str) {
        return INSTANCE.c(str);
    }

    public final String a() {
        if (this.fragment == null) {
            return null;
        }
        String strSubstring = this.url.substring(H.t0(this.url, '#', 0, false, 6, null) + 1);
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String b() {
        if (this.password.length() == 0) {
            return "";
        }
        String strSubstring = this.url.substring(H.t0(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1, H.t0(this.url, '@', 0, false, 6, null));
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String c() {
        int iT0 = H.t0(this.url, JsonPointer.SEPARATOR, this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        String strSubstring = this.url.substring(iT0, ub.n.i(str, "?#", iT0, str.length()));
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final List<String> d() {
        int iT0 = H.t0(this.url, JsonPointer.SEPARATOR, this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int i10 = ub.n.i(str, "?#", iT0, str.length());
        ArrayList arrayList = new ArrayList();
        while (iT0 < i10) {
            int i11 = iT0 + 1;
            int iH = ub.n.h(this.url, JsonPointer.SEPARATOR, i11, i10);
            String strSubstring = this.url.substring(i11, iH);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            arrayList.add(strSubstring);
            iT0 = iH;
        }
        return arrayList;
    }

    public final String e() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iT0 = H.t0(this.url, '?', 0, false, 6, null) + 1;
        String str = this.url;
        String strSubstring = this.url.substring(iT0, ub.n.h(str, '#', iT0, str.length()));
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    public boolean equals(Object other) {
        return (other instanceof v) && kotlin.jvm.internal.p.d(((v) other).url, this.url);
    }

    public final String f() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        String strSubstring = this.url.substring(length, ub.n.i(str, ":@", length, str.length()));
        kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
        return strSubstring;
    }

    /* renamed from: h, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final boolean i() {
        return kotlin.jvm.internal.p.d(this.scheme, "https");
    }

    public final a j() {
        a aVar = new a();
        aVar.A(this.scheme);
        aVar.x(f());
        aVar.w(b());
        aVar.y(this.host);
        aVar.z(this.port != INSTANCE.b(this.scheme) ? this.port : -1);
        aVar.f().clear();
        aVar.f().addAll(d());
        aVar.e(e());
        aVar.v(a());
        return aVar;
    }

    public final a k(String link) {
        kotlin.jvm.internal.p.i(link, "link");
        try {
            return new a().j(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final List<String> l() {
        return this.pathSegments;
    }

    /* renamed from: m, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    public final String n() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        INSTANCE.e(this.queryNamesAndValues, sb2);
        return sb2.toString();
    }

    public final String o(int index) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(index * 2);
        kotlin.jvm.internal.p.f(str);
        return str;
    }

    public final String p(int index) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((index * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final int q() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String r() {
        a aVarK = k("/...");
        kotlin.jvm.internal.p.f(aVarK);
        return aVarK.E("").l("").c().getUrl();
    }

    public final v s(String link) {
        kotlin.jvm.internal.p.i(link, "link");
        a aVarK = k(link);
        if (aVarK != null) {
            return aVarK.c();
        }
        return null;
    }

    /* renamed from: t, reason: from getter */
    public final String getScheme() {
        return this.scheme;
    }

    /* renamed from: toString, reason: from getter */
    public String getUrl() {
        return this.url;
    }

    public final URI u() {
        String string = j().r().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e10) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").l(string, ""));
                kotlin.jvm.internal.p.f(uriCreate);
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e10);
            }
        }
    }

    public final URL v() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e10) {
            throw new RuntimeException(e10);
        }
    }

    public v(String str, String str2, String str3, String str4, int i10, List<String> list, List<String> list2, String str5, String str6) {
        this.scheme = str;
        this.username = str2;
        this.password = str3;
        this.host = str4;
        this.port = i10;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = str5;
        this.url = str6;
    }
}
