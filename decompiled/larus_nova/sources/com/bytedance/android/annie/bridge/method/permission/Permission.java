package com.bytedance.android.annie.bridge.method.permission;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tR\u001f\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/annie/bridge/method/permission/Permission;", "", "", "", "permission", "Ljava/util/List;", "getPermission", "()Ljava/util/List;", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "CAMERA", "MICROPHONE", "PHOTOALBUM", "READ_PHOTOALBUM", "WRITE_PHOTOALBUM", "VIBRATE", "CALENDAR", "READ_CALENDAR", "WRITE_CALENDAR", BannerBizName.NOTIFICATION, HTTP.LOCATION, "UNKNOWN", "annie_release"}, k = 1, mv = {1, 4, 3})
public final enum Permission extends Enum<Permission> {
    public static final Permission CALENDAR = null;
    public static final Permission CAMERA = null;
    public static final a Companion = null;
    public static final Permission LOCATION = null;
    public static final Permission MICROPHONE = null;
    public static final Permission NOTIFICATION = null;
    public static final Permission PHOTOALBUM = null;
    public static final Permission READ_CALENDAR = null;
    public static final Permission READ_PHOTOALBUM = null;
    public static final Permission UNKNOWN = null;
    public static final Permission VIBRATE = null;
    public static final Permission WRITE_CALENDAR = null;
    public static final Permission WRITE_PHOTOALBUM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Permission[] f38754a = null;
    private final List<String> permission;

    public static final class a {
        public a() {
        }

        public static Permission a(String r100) {
            if (r100 == null) goto L8;
            return Permission.valueOf(r100.toUpperCase(Locale.ROOT));
        L6:
            return Permission.UNKNOWN;
        L8:
            return Permission.UNKNOWN;
        }
    }

    public static Permission valueOf(String r100) {
        return (Permission) r27.a.a(Permission.class, r100);
    }

    public static Permission[] values() {
        return (Permission[]) f38754a.clone();
    }

    static {
        Permission r100 = new Permission("CAMERA", 0, CollectionsKt.listOf("android.permission.CAMERA"));
        CAMERA = r100;
        Permission r101 = new Permission("MICROPHONE", 1, CollectionsKt.listOf("android.permission.RECORD_AUDIO"));
        MICROPHONE = r101;
        Permission r102 = new Permission("PHOTOALBUM", 2, CollectionsKt.emptyList());
        PHOTOALBUM = r102;
        Permission r103 = new Permission("READ_PHOTOALBUM", 3, CollectionsKt.emptyList());
        READ_PHOTOALBUM = r103;
        Permission r104 = new Permission("WRITE_PHOTOALBUM", 4, CollectionsKt.emptyList());
        WRITE_PHOTOALBUM = r104;
        Permission r105 = new Permission("VIBRATE", 5, CollectionsKt.listOf("android.permission.VIBRATE"));
        VIBRATE = r105;
        Permission r110 = new Permission("CALENDAR", 6, CollectionsKt.listOf(new String[]{"android.permission.READ_CALENDAR", "android.permission.WRITE_CALENDAR"}));
        CALENDAR = r110;
        Permission r111 = new Permission("READ_CALENDAR", 7, CollectionsKt.listOf("android.permission.READ_CALENDAR"));
        READ_CALENDAR = r111;
        Permission r112 = new Permission("WRITE_CALENDAR", 8, CollectionsKt.listOf("android.permission.WRITE_CALENDAR"));
        WRITE_CALENDAR = r112;
        Permission r113 = new Permission(BannerBizName.NOTIFICATION, 9, CollectionsKt.listOf(""));
        NOTIFICATION = r113;
        Permission r114 = new Permission(HTTP.LOCATION, 10, CollectionsKt.listOf(new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"}));
        LOCATION = r114;
        Permission r106 = new Permission("UNKNOWN", 11, CollectionsKt.listOf(null));
        UNKNOWN = r106;
        f38754a = new Permission[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106};
        Companion = new a();
    }

    public final List<String> getPermission() {
        return this.permission;
    }

    public Permission(String r100, int r101, List r102) {
        super(r100, r101);
        this.permission = r102;
    }
}
