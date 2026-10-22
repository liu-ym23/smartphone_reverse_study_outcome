package com.bytedanceos.common.ui.myapplist;

import android.text.TextUtils;
import com.bytedanceos.common.BaseApplication;
import com.bytedanceos.common.CommonCache;
import com.bytedanceos.common.data.AppFilter;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s8.b;
import s8.c;
import s8.d;

/* JADX INFO: loaded from: classes2.dex */
public class MyAppListData {
    public static final int WIFI_APPS = 50;
    private static AppFilter sActive;
    public final AppInfo HEADER_DOWNLOAD_QUEUE;
    public final AppInfo HEADER_LOCAL_APP;
    private final AppFilter mAppFilterOut;
    private final CommonCache mCache;
    public AppInfo mPendingDequeue;

    static {
        sActive = new AnonymousClass1();
    }

    public MyAppListData(AppInfo r10, AppInfo r11, boolean r12) {
        this.mCache = BaseApplication.c().b();
        this.HEADER_LOCAL_APP = r10;
        this.HEADER_DOWNLOAD_QUEUE = r11;
        ArrayList r13 = new ArrayList();
        r13.add(b.c());
        r13.add(b.a());
        if (r12 == false) goto L5;
        r13.add(new c(b.b()));
    L5:
        this.mAppFilterOut = new d(r13);
    }

    public static AppFilter activeFilter() {
        return sActive;
    }

    private List<AppInfo> queue(AppInfo r10) {
        ArrayList r11 = new ArrayList();
        List<AppInfo> r12 = this.mCache.v("DOWNLOAD");
        List r13 = this.mCache.v("WIFIAPPS");
        int r14 = 0;
        if (r13 == null) goto L15;
        Iterator r15 = r13.iterator();
    L6:
        if (r15.hasNext() == false) goto L14;
        AppInfo r16 = (AppInfo) r15.next();
        r16.default_check = 50;
        int r17 = 0;
    L9:
        if (r17 >= r12.size()) goto L6;
        if (TextUtils.equals(r16.getName(), r12.get(r17).getName()) == false) goto L13;
        r15.remove();
        j.a("remove:" + r16.getName());
    L13:
        r17 = r17 + 1;
        goto L9
    L14:
        r12.addAll(r13);
    L15:
        ArrayList r18 = new ArrayList();
        Iterator r19 = this.mCache.v("DOWNLOAD_FAILED").iterator();
    L17:
        if (r19.hasNext() == false) goto L19;
        AppInfo r20 = (AppInfo) r19.next();
        r20.mShowRetryBtn = true;
        r18.add(r20);
        goto L17
    L19:
        r12.addAll(r18);
        r12.removeAll(toFilterOut(r12));
        if (r12.contains(this.mPendingDequeue) == true) goto L22;
        this.mPendingDequeue = null;
    L22:
        r12.sort(AppInfo.getComparator());
        if (r10 == null) goto L25;
        r12.remove(r10);
    L25:
        ArrayList r110 = new ArrayList(this.mCache.v("LOCAL_APPS_ONLINE"));
        r110.sort(AppInfo.getComparator());
        r110.removeAll(r12);
        if (com.bytedanceos.common.toolbox.c.a(r110) == true) goto L29;
        Collections.reverse(r110);
        r110.add(0, this.HEADER_LOCAL_APP);
    L29:
        if (com.bytedanceos.common.toolbox.c.a(r12) == true) goto L32;
        r12.add(0, this.HEADER_DOWNLOAD_QUEUE);
    L32:
        if (r12.isEmpty() == true) goto L40;
        int r21 = r12.size();
        int r22 = 0;
    L34:
        if (r22 >= r21) goto L40;
        AppInfo r23 = r12.get(r22);
        if (r11.contains(r23) == true) goto L38;
        r11.add(r23);
    L38:
        r22 = r22 + 1;
    L40:
        if (r110.isEmpty() == true) goto L47;
        int r24 = r110.size();
    L42:
        if (r14 >= r24) goto L47;
        AppInfo r25 = (AppInfo) r110.get(r14);
        if (r11.contains(r25) == true) goto L46;
        r11.add(r25);
    L46:
        r14 = r14 + 1;
    L47:
        return r11;
    }

    private List<AppInfo> toFilterOut(List<AppInfo> r10) {
        ArrayList r11 = new ArrayList();
        Iterator<AppInfo> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        AppInfo r13 = r12.next();
        if (this.mAppFilterOut.filter(r13) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public List<AppInfo> buildMyAppList4Display() {
        return queue(this.mPendingDequeue);
    }

    public List<AppInfo> dequeue(AppInfo r10) {
        return queue(r10);
    }

    public boolean noDownloadAfterDequeue(List<AppInfo> r10) {
        int r11 = r10.indexOf(this.HEADER_DOWNLOAD_QUEUE);
        int r12 = r10.indexOf(this.HEADER_LOCAL_APP);
        if (r12 != (-1)) goto L6;
        r12 = r10.size();
    L6:
        if ((r12 - r11) > 2) goto L8;
        return true;
    L8:
        return false;
    }
}
