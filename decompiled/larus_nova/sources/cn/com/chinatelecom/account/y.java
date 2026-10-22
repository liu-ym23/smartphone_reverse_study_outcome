package cn.com.chinatelecom.account;

import android.text.TextUtils;
import com.ss.ttvideoengine.DataLoaderHelper;
import kotlin.jvm.internal.ByteCompanionObject;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f24480a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f24481b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final byte[] f24482c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f24483d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final byte[] f24484e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f24485f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final byte[] f24486g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f24487h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f24488i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final byte[] f24489j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final byte[] f24490k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final byte[] f24491l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f24492m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f24493n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final byte[] f24494o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final byte[] f24495p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final byte[] f24496q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final byte[] f24497r = null;

    static {
        f24480a = new byte[]{-30, -91, -67, -20, -69, -120, -30, PSSSigner.TRAILER_IMPLICIT, -113, -20, -99, PSSSigner.TRAILER_IMPLICIT};
        f24481b = new byte[]{-30, -91, -67, -20, -69, -120, -19, -73, -101, -19, -79, -106, -17, -74, -120, -17, -78, -78};
        f24482c = new byte[]{-17, -103, -121, -17, -80, -98, -19, -86, -117, -29, -98, -109, -30, -91, -91};
        f24483d = new byte[]{-20, -99, -86, -19, -73, -101, -19, -79, -106, -30, -75, -108, -20, -124, -81};
        f24484e = new byte[]{-19, -83, -79, -17, ByteCompanionObject.MIN_VALUE, -94, -19, -73, -101, -19, -79, -106, -20, -106, -96, -17, -74, -118, -17, -102, -91};
        f24485f = new byte[]{89, 101, 105, 97, 111, 126, -30, PSSSigner.TRAILER_IMPLICIT, -113, -20, -99, PSSSigner.TRAILER_IMPLICIT, -17, -74, -120, -17, -78, -78};
        f24486g = new byte[]{-17, -107, -107, -17, -102, -121, -30, -83, -87, -20, -108, -102, -17, -74, -120, -17, -78, -78};
        f24487h = new byte[]{67, 69, -17, -74, -120, -17, -78, -78};
        f24488i = new byte[]{-19, -109, -79, -17, -73, -97, -19, -79, -103, -20, -108, -106, -18, -78, -80, -19, -93, -80};
        f24489j = new byte[]{-19, -109, -79, -17, -73, -97, -17, -74, -120, -17, -78, -78};
        f24490k = new byte[]{-29, -88, -114, -19, -109, -79, -17, -73, -97, -17, -74, -120, -17, -78, -78};
        f24491l = new byte[]{-30, -91, -67, -17, -113, -126, -17, -126, -105, -17, -83, -127, -17, -122, -100, 89, 78, 65};
        f24492m = new byte[]{-19, -98, -94, -20, -126, -67, -17, -113, -71, -29, -99, -89, -19, -97, -122, -29, -105, -88};
        f24493n = new byte[]{-17, -113, PSSSigner.TRAILER_IMPLICIT, -18, -79, -100, -19, -109, -79, -17, -73, -97, -20, -100, -77, -17, -74, -123};
        f24494o = new byte[]{93, 67, 76, 67, -17, -126, -115, -20, -121, -88, -30, PSSSigner.TRAILER_IMPLICIT, -113, -20, -99, PSSSigner.TRAILER_IMPLICIT};
        f24495p = new byte[]{93, 67, 76, 67, -17, -126, -115, -20, -121, -88, -17, -74, -120, -17, -78, -78};
        f24496q = new byte[]{-17, -125, -121, -19, -73, -92, -17, -107, -107, -17, -102, -121, -30, -83, -87, -20, -108, -102, -17, -82, -69, -30, -66, -81};
        f24497r = new byte[]{111, 100, 105, 120, 115, 122, 126, 42, 111, 114, 105, 111, 122, 126, 99, 101, 100};
    }

    public static JSONObject a() {
        return a(80103, h0.a(f24491l));
    }

    public static JSONObject a(int r100, String r101) {
        return a(r100, r101, null);
    }

    public static JSONObject a(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("result", r100);     // Catch: JSONException -> L7
        r103.put("msg", r101);     // Catch: JSONException -> L7
        if (TextUtils.isEmpty(r102) == true) goto L9;
        r103.put("reqId", r102);     // Catch: JSONException -> L7
    L9:
        return r103;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static String b(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        r103.put("result", r100);     // Catch: JSONException -> L7
        r103.put("msg", r101);     // Catch: JSONException -> L7
        if (TextUtils.isEmpty(r102) == true) goto L10;
        r103.put("reqId", r102);     // Catch: JSONException -> L7
    L10:
        return r103.toString();
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L10
    }

    public static JSONObject b() {
        return a(80004, h0.a(f24484e));
    }

    public static JSONObject c() {
        return a(DataLoaderHelper.DATALOADER_KEY_LONG_MAXCACHESIZE_FOR_DEFAULTDIR, h0.a(f24483d));
    }

    public static JSONObject d() {
        return a(80102, h0.a(f24490k));
    }

    public static JSONObject e() {
        return a(80001, h0.a(f24481b), null);
    }

    public static JSONObject f() {
        return a(DataLoaderHelper.DATALOADER_KEY_MDL_OPTION_START, h0.a(f24480a));
    }
}
