package com.bytedance.ai.bridge.method.device.calendar;

import android.app.Activity;
import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import d3.a0;
import f2.k;
import f3.h;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes43.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f35452a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35453a = null;

        static {
            int[] r100 = new int[RepeatInterval.values().length];
            r100[RepeatInterval.DAY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[RepeatInterval.WEEK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[RepeatInterval.MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[RepeatInterval.YEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f35453a = r100;
        }
    }

    static {
        f35452a = new String[]{"android.permission.WRITE_CALENDAR"};
    }

    public static final RepeatInterval b(String r100) {
        String r101 = StringsKt.trim(r100).toString().toLowerCase(Locale.US);
        switch(r101.hashCode()) {
            case 99228: goto L18;
            case 3645428: goto L14;
            case 3704893: goto L10;
            case 104080000: goto L6;
            default: goto L20;
        };
    L20:
        return null;
    L6:
        if (r101.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH) == false) goto L20;
        return RepeatInterval.MONTH;
    L10:
        if (r101.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR) == false) goto L20;
        return RepeatInterval.YEAR;
    L14:
        if (r101.equals("week") == false) goto L20;
        return RepeatInterval.WEEK;
    L18:
        if (r101.equals(BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY) == false) goto L20;
        return RepeatInterval.DAY;
    }

    public static final long d(long r100, boolean r101) {
        if (r101 == true) goto L4;
        return r100;
    L4:
        Calendar r102 = Calendar.getInstance();
        r102.setTimeInMillis(r100);
        Calendar r103 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        r103.clear();
        r103.set(r102.get(1), r102.get(2), r102.get(5), 0, 0, 0);
        return r103.getTimeInMillis();
    }

    public static final long c(long r100, Long r101, Long r102) {
        if (r100 <= 0) goto L24;
        if (r101 == null) goto L6;
        long r103 = r101.longValue();
    L8:
        if (r103 < r100) goto L22;
        if (r102 == null) goto L11;
        long r104 = r102.longValue();
    L13:
        if (r104 < 0) goto L20;
        if ((r104 % 60) != 0) goto L18;
        return r103;
    L18:
        throw new IllegalArgumentException("The alarmOffset parameter should be a multiple of 60 seconds on Android.");
    L20:
        throw new IllegalArgumentException("The alarmOffset parameter should not be negative.");
    L11:
        r104 = 0;
        goto L13
    L22:
        throw new IllegalArgumentException("The endTime parameter should not be earlier than startTime.");
    L6:
        r103 = r100;
        goto L8
    L24:
        throw new IllegalArgumentException("The startTime parameter should be a valid Unix timestamp.");
    }

    public static final void a(e3.d r110, f r111, boolean r112, String r113, h r114, Function0 r115) {
        Activity r100 = r110.getOwnerActivity();
        if (r100 != null) goto L7;
        r100 = k.b();
        if (r100 != null) goto L7;
        h.a.a(r114, "context is null", null, null, 14);
        return;
    L7:
        Activity r101 = r100;
        a0 r102 = r110.getContainerContext();
        if (r102 == null) goto L24;
        String r103 = r102.getAppletId();
        if (r103 == null) goto L24;
        if (r103.length() <= 0) goto L14;
        boolean r104 = true;
    L15:
        if (r104 == false) goto L17;
        String r105 = r103;
    L18:
        if (r105 == null) goto L24;
        AppletAppManagerService.INSTANCE.getClass();
        AppletApplication r106 = AppletAppManagerService.a(r105);
        if (r106 != null) goto L23;
        h.a.a(r114, "applet is not running", null, null, 14);
        return;
    L23:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new AddPhoneCalendarMethodKt$handleCalendarEvent$1(r106, r114, r113, r101, r111, r105, r112, r115, null), 3, null);
        return;
    L17:
        r105 = null;
        goto L18
    L14:
        r104 = false;
    L24:
        h.a.a(r114, "appletId is empty", null, null, 14);
    }
}
