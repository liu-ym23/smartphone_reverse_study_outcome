package com.bytedanceos.common.toolbox;

import android.text.format.DateUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.R$string;
import com.bytedanceos.common.model.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10068a = null;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public final long a() {
            return b0.n().p("last_notification_date_app_update_available", null, BaseApplication.c());
        }

        public final String b(List r10) {
            kotlin.jvm.internal.q.g(r10, "appInfos");
            BaseApplication r11 = BaseApplication.c();
            List r12 = kotlin.collections.b0.u0(r10, 2);
            ArrayList r13 = new ArrayList(kotlin.collections.u.r(r12, 10));
            Iterator r14 = r12.iterator();
        L4:
            if (r14.hasNext() == false) goto L6;
            r13.add(((AppInfo) r14.next()).appName);
            goto L4
        L6:
            int r15 = r10.size();
            if (r15 != 0) goto L9;
            return "";
        L9:
            if (r15 == 1) goto L13;
            if (r15 == 2) goto L12;
            String r16 = r11.getString(R$string.notification_content_app_updates_available_more, new Object[]{r13.get(0), r13.get(1)});
            kotlin.jvm.internal.q.f(r16, "getString(...)");
            return r16;
        L12:
            String r17 = r11.getString(R$string.notification_content_app_updates_available_two, new Object[]{r13.get(0), r13.get(1)});
            kotlin.jvm.internal.q.f(r17, "getString(...)");
            return r17;
        L13:
            String r18 = r11.getString(R$string.notification_content_app_updates_available_one, new Object[]{r13.get(0)});
            kotlin.jvm.internal.q.f(r18, "getString(...)");
            return r18;
        }

        public final boolean c() {
            return DateUtils.isToday(a());
        }

        public final void d() {
            long r10 = System.currentTimeMillis();
            b0.n().F("last_notification_date_app_update_available", r10, null, BaseApplication.c());
            j.n("NtfAppUpdate updateLastNotificationDate: " + r10);
        }

        public a() {
        }
    }

    static {
        f10068a = new a(null);
    }

    public static final String a(List r10) {
        return f10068a.b(r10);
    }

    public static final boolean b() {
        return f10068a.c();
    }

    public static final void c() {
        f10068a.d();
    }
}
