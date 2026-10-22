package r4;

import android.net.Uri;
import kotlin.jvm.internal.k;

/* renamed from: r4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1878a {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f5676a;
    public static final Uri b;
    public static final Uri c;

    static {
        Uri uri = Uri.parse("content://com.stepos.agentsafetycenter.ledger");
        k.e(uri, "parse(...)");
        f5676a = uri;
        Uri uri2 = Uri.parse("content://com.stepos.agentsafetycenter.permission");
        k.e(uri2, "parse(...)");
        b = uri2;
        Uri uri3 = Uri.parse("content://com.stepos.agentsafetycenter.permission/snapshot");
        k.e(uri3, "parse(...)");
        c = uri3;
    }

    public static String a(int i) {
        switch (i) {
            case 0:
                return "ok";
            case 1:
                return "noReadPermission";
            case 2:
                return "notWhitelisted";
            case 3:
                return "invalidArgs";
            case 4:
                return "noCacheAndFetchFailed";
            case 5:
                return "unknownGroupId";
            case 6:
                return "internalError";
            default:
                return androidx.appfunctions.metadata.a.i(i, "unknown(", ")");
        }
    }
}
