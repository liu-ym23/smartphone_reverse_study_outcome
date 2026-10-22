package com.bytedance.applet.jsb;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.Gson;
import com.ivy.ivykit.api.bridge.core.model.IvyReadableType;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes14.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<d1> f192048a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f192049b = null;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192050a = null;

        static {
            int[] r100 = new int[IvyReadableType.values().length];
            r100[IvyReadableType.Boolean.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r100[IvyReadableType.Int.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r100[IvyReadableType.Number.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r100[IvyReadableType.String.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[IvyReadableType.Array.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r100[IvyReadableType.Map.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            f192050a = r100;
        }
    }

    public d1() {
    }

    static {
        f192048a = LazyKt.lazy(new c1());
        f192049b = new Gson();
    }

    public static Keva a(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L10;
        return Keva.getRepo(r100.concat("-xbridge-storage"), 0);
    L10:
        return Keva.getRepo("xbridge-storage", 0);
    L5:
        r101 = false;
        goto L6
    }

    public static Object b(String r100) {
        Gson r101 = f192049b;
        f1 r102 = (f1) GsonProtectorUtils.fromJson(r101, r100, f1.class);
        String r103 = r102.getType();
        String r104 = "";
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        String r105 = r102.a();
        if (r105 == null) goto L9;
        r104 = r105;
    L9:
        IvyReadableType r106 = IvyReadableType.valueOf(r103);
        switch(b.f192050a[r106.ordinal()]) {
            case 1: goto L17;
            case 2: goto L23;
            case 3: goto L22;
            case 4: goto L18;
            case 5: goto L21;
            case 6: goto L20;
            default: goto L11;
        };
    L11:
        return null;
    L18:
        return r104;
    L20:
        return GsonProtectorUtils.fromJson(r101, r104, Map.class);
    L21:
        return GsonProtectorUtils.fromJson(r101, r104, List.class);
    L22:
        return Double.valueOf(CastDoubleProtector.parseDouble(r104));
    L23:
        return Integer.valueOf(CastIntegerProtector.parseInt(r104));
    L17:
        return Boolean.valueOf(Boolean.parseBoolean(r104));
    }
}
