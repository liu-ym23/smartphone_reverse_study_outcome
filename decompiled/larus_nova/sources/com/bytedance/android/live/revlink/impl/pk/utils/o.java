package com.bytedance.android.live.revlink.impl.pk.utils;

import android.text.TextUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f97128a = 0;

    @JvmStatic
    public static final void b() {
        int r100 = l51.a.j();
        com.bytedance.tools.kcp.spongepreference.runtime.a r101 = l51.a.f507461m0;
        KProperty<?>[] r102 = l51.a.f507436a;
        r101.setValue(null, r102[74], Integer.valueOf(r100));
        int r103 = l51.a.k();
        l51.a.f507463n0.setValue(null, r102[75], Integer.valueOf(r103));
    }

    static {
    }

    @JvmStatic
    public static final boolean a(long r100) {
        c51.a r101 = c51.a.f22468h;
        r101.getClass();
        ReadOnlyProperty r102 = c51.a.f22462b;
        KProperty<?>[] r103 = c51.a.f22461a;
        String r104 = (String) r102.getValue(r101, r103[0]);
        r101.getClass();
        String r105 = (String) c51.a.f22463c.getValue(r101, r103[1]);
        SimpleDateFormat r106 = new SimpleDateFormat("HH:mm:ss");
        Date r107 = r106.parse(r104);     // Catch: ParseException -> L9
        Date r108 = r106.parse(r105);     // Catch: ParseException -> L9
        Date r109 = r106.parse(r106.format(new Date(r100)));     // Catch: ParseException -> L9
        Calendar r110 = Calendar.getInstance();     // Catch: ParseException -> L9
        r110.setTime(r107);     // Catch: ParseException -> L9
        Calendar r111 = Calendar.getInstance();     // Catch: ParseException -> L9
        r111.setTime(r108);     // Catch: ParseException -> L9
        Calendar r112 = Calendar.getInstance();     // Catch: ParseException -> L9
        r112.setTime(r109);     // Catch: ParseException -> L9
        if (r112.after(r110) == false) goto L12;
        if (r112.before(r111) == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final void c(int r100, int r101, boolean r102) {
        String r103 = String.valueOf(Calendar.getInstance().get(6));
        if (r102 == true) goto L5;
    L7:
        if (r102 == true) goto L9;
    L12:
        l51.a.I(r100);
        l51.a.J(r101);
        if (r102 == true) goto L16;
        b();
        return;
    L16:
        return;
    L9:
        if (l51.a.k() > 1) goto L11;
        b();
    L11:
        com.bytedance.tools.kcp.spongepreference.runtime.a r104 = l51.a.f507467p0;
        KProperty<?>[] r105 = l51.a.f507436a;
        r104.setValue(null, r105[77], Boolean.TRUE);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        l51.a.f507465o0.setValue(null, r105[76], r103);
        goto L12
    L5:
        if (TextUtils.equals((String) l51.a.f507465o0.getValue(null, l51.a.f507436a[76]), r103) == false) goto L7;
    }
}
