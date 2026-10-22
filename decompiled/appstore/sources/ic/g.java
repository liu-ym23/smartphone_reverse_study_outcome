package ic;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f20568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20569b = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final String a() {
            return b(g.a());
        }

        public final String b(String r10) {
            String r11 = null;
            Object r12 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke(null, new Object[]{r10, ""});     // Catch: Exception -> L10
            if ((r12 instanceof String) == false) goto L6;
            r11 = (String) r12;     // Catch: Exception -> L10
        L6:
            if (r11 != null) goto L9;
            return "";
        L9:
            return r11;
        L14:
            return "";
        }

        public a() {
        }
    }

    static {
        f20568a = new a(null);
        f20569b = "ro.system_ext.product.type";
    }

    public static final /* synthetic */ String a() {
        return f20569b;
    }
}
