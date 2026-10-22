package d7;

import a.AbstractC0291a;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: d7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public abstract class AbstractC1377a {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f4302a = new ThreadPoolExecutor(1, 3, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public static String a(String str) {
        if (!AbstractC0291a.x(str) && str.endsWith("volces.com")) {
            String[] strArrSplit = str.split("\\.");
            if (strArrSplit.length == 4) {
                ArrayList arrayList = new ArrayList(strArrSplit.length - 1);
                for (int i = 1; i < strArrSplit.length; i++) {
                    arrayList.add(strArrSplit[i]);
                }
                return AbstractC0291a.z(".", arrayList);
            }
        }
        return str;
    }
}
