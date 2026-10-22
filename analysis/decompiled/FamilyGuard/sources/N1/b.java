package N1;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.Time;
import java.util.Calendar;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static Time f4184a = null;

    /* renamed from: b, reason: collision with root package name */
    private static Time f4185b = null;

    /* renamed from: c, reason: collision with root package name */
    private static long f4186c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static int f4187d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static String f4188e;

    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r18, long r19, int r21) {
        /*
            Method dump skipped, instructions count: 1622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: N1.b.a(android.content.Context, long, int):java.lang.String");
    }

    public static String b(Context context, int i5, int i6, int i7) throws Resources.NotFoundException {
        if (context == null) {
            return BuildConfig.FLAVOR;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(i5, i6, i7);
        int i8 = calendar.get(7) - 1;
        String[] stringArray = context.getResources().getStringArray(H1.b.f2052c);
        return (i8 < 0 || i8 >= stringArray.length) ? BuildConfig.FLAVOR : stringArray[i8];
    }
}
