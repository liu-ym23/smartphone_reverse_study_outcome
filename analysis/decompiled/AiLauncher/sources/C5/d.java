package C5;

import Z8.C1173v;
import Z8.Y;
import Z8.r;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Binder;
import android.os.Process;
import android.os.UserHandle;
import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import io.ktor.sse.ServerSentEventKt;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b,B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\u001aJ\u001f\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001c\u0010\fJ%\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\u001e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"LC5/d;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "k", "(Landroid/content/Context;)Z", "", "uid", "l", "(Landroid/content/Context;I)Z", "", "what", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Landroid/content/Context;Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/content/Context;ILjava/lang/String;)V", "LC5/d$a;", Const.INTENT_KEY_UMID, "(Landroid/content/Context;)LC5/d$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(I)Z", "c", "(Landroid/content/Context;)Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "pkg", "", "e", "(Landroid/content/Context;Ljava/lang/String;)Ljava/util/List;", "TAG", "Ljava/lang/String;", "LC5/d$b;", "POLICY", "LC5/d$b;", "", "TRUSTED_CERT_SHA256", "Ljava/util/Set;", "Ljava/util/concurrent/ConcurrentHashMap;", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", Const.INTENT_KEY_APIKEY, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    private static final String TAG = "CallerVerifier";
    public static final d INSTANCE = new d();
    private static final b POLICY = b.a.INSTANCE;
    private static final Set<String> TRUSTED_CERT_SHA256 = Y.e();
    private static final ConcurrentHashMap<Integer, Boolean> cache = new ConcurrentHashMap<>();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B+\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"LC5/d$a;", "", "", "uid", "Landroid/os/UserHandle;", "userHandle", "", "packageName", "key", "<init>", "(ILandroid/os/UserHandle;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/content/Context;", "context", "what", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/content/Context;Ljava/lang/String;)V", "I", "getUid", "()I", "Landroid/os/UserHandle;", "getUserHandle", "()Landroid/os/UserHandle;", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private final String key;
        private final String packageName;
        private final int uid;
        private final UserHandle userHandle;

        public a(int i10, UserHandle userHandle, String str, String key) {
            p.i(userHandle, "userHandle");
            p.i(key, "key");
            this.uid = i10;
            this.userHandle = userHandle;
            this.packageName = str;
            this.key = key;
        }

        public final void a(Context context, String what) {
            p.i(context, "context");
            p.i(what, "what");
            d.INSTANCE.h(context, this.uid, what);
        }

        /* renamed from: b, reason: from getter */
        public final String getKey() {
            return this.key;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"LC5/d$b;", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "LC5/d$b$a;", "LC5/d$b$b;", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LC5/d$b$a;", "LC5/d$b;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class a implements b {
            public static final a INSTANCE = new a();

            public boolean equals(Object other) {
                return this == other || (other instanceof a);
            }

            public int hashCode() {
                return -883139614;
            }

            public String toString() {
                return "PlatformSignatureOnly";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"LC5/d$b$b;", "LC5/d$b;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "utils_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: C5.d$b$b, reason: collision with other inner class name */
        public static final /* data */ class C0018b implements b {
            public static final C0018b INSTANCE = new C0018b();

            public boolean equals(Object other) {
                return this == other || (other instanceof C0018b);
            }

            public int hashCode() {
                return -1281760146;
            }

            public String toString() {
                return "PlatformSignatureOrKnownCert";
            }
        }
    }

    public static final CharSequence f(byte b10) {
        String str = String.format("%02X", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
        p.h(str, "format(...)");
        return str;
    }

    public final String b(Context context) {
        p.i(context, "context");
        int callingUid = Binder.getCallingUid();
        String strC = c(context);
        if (strC == null) {
            strC = "<unknown>";
        }
        return callingUid + ServerSentEventKt.COLON + strC;
    }

    public final String c(Context context) {
        Object objB;
        p.i(context, "context");
        int callingUid = Binder.getCallingUid();
        if (callingUid == Process.myUid()) {
            return context.getPackageName();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(callingUid);
            objB = Result.b(packagesForUid != null ? (String) r.Z(packagesForUid) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public final a d(Context context) {
        p.i(context, "context");
        int callingUid = Binder.getCallingUid();
        UserHandle userHandleForUid = UserHandle.getUserHandleForUid(callingUid);
        p.h(userHandleForUid, "getUserHandleForUid(...)");
        return new a(callingUid, userHandleForUid, c(context), b(context));
    }

    public final List<String> e(Context context, String pkg) {
        Object objB;
        SigningInfo signingInfo;
        Signature[] apkContentsSigners;
        try {
            Result.Companion companion = Result.INSTANCE;
            signingInfo = context.getPackageManager().getPackageInfo(pkg, 134217728).signingInfo;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (signingInfo != null && (apkContentsSigners = signingInfo.getApkContentsSigners()) != null) {
            ArrayList arrayList = new ArrayList(apkContentsSigners.length);
            for (Signature signature : apkContentsSigners) {
                byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(signature.toByteArray());
                p.h(bArrDigest, "digest(...)");
                arrayList.add(r.v0(bArrDigest, "", null, null, 0, null, new InterfaceC5074l() { // from class: C5.c
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return d.f(((Byte) obj).byteValue());
                    }
                }, 30, null));
            }
            objB = Result.b(arrayList);
            List listM = C1173v.m();
            if (Result.g(objB)) {
                objB = listM;
            }
            return (List) objB;
        }
        return C1173v.m();
    }

    public final void g(Context context, String what) {
        p.i(context, "context");
        p.i(what, "what");
        h(context, Binder.getCallingUid(), what);
    }

    public final void h(Context context, int uid, String what) {
        p.i(context, "context");
        p.i(what, "what");
        if (!j(uid)) {
            throw new SecurityException(what + " denied: cross-user uid=" + uid);
        }
        if (l(context, uid)) {
            return;
        }
        throw new SecurityException(what + " denied: untrusted caller uid=" + uid);
    }

    public final boolean i(Context context, int uid) {
        Object objB;
        Object objB2;
        PackageManager packageManager = context.getPackageManager();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(packageManager.getPackagesForUid(uid));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        String[] strArr = (String[]) objB;
        if (strArr == null || strArr.length == 0) {
            C4148a.u(TAG, "cannot resolve packages for uid=" + uid, false, 4, null);
            return false;
        }
        for (String str : strArr) {
            try {
                Result.Companion companion3 = Result.INSTANCE;
                objB2 = Result.b(Integer.valueOf(packageManager.checkSignatures(context.getPackageName(), str)));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.INSTANCE;
                objB2 = Result.b(C4849c.a(th2));
            }
            if (Result.g(objB2)) {
                objB2 = -4;
            }
            if (((Number) objB2).intValue() == 0) {
                return true;
            }
        }
        if ((POLICY instanceof b.C0018b) && !TRUSTED_CERT_SHA256.isEmpty()) {
            for (String str2 : strArr) {
                p.f(str2);
                List<String> listE = e(context, str2);
                if (!(listE instanceof Collection) || !listE.isEmpty()) {
                    Iterator<T> it = listE.iterator();
                    while (it.hasNext()) {
                        if (TRUSTED_CERT_SHA256.contains((String) it.next())) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean j(int uid) {
        if (uid == 0 || uid == 1000) {
            return true;
        }
        return p.d(UserHandle.getUserHandleForUid(uid), Process.myUserHandle());
    }

    public final boolean k(Context context) {
        p.i(context, "context");
        return l(context, Binder.getCallingUid());
    }

    public final boolean l(Context context, int uid) {
        p.i(context, "context");
        if (uid == Process.myUid() || uid == 1000 || uid == 0) {
            return true;
        }
        if (!j(uid)) {
            C4148a.u(TAG, "reject cross-user uid=" + uid, false, 4, null);
            return false;
        }
        ConcurrentHashMap<Integer, Boolean> concurrentHashMap = cache;
        Boolean bool = concurrentHashMap.get(Integer.valueOf(uid));
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zI = i(context, uid);
        concurrentHashMap.put(Integer.valueOf(uid), Boolean.valueOf(zI));
        if (!zI) {
            C4148a.u(TAG, "reject caller uid=" + uid, false, 4, null);
        }
        return zI;
    }
}
