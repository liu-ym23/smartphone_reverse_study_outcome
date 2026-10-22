package H0;

import H.h;
import android.text.TextUtils;
import android.util.Log;
import com.zyql.common.utils.upload.TOSUploader;
import g1.AbstractC1451a;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import u1.d;
import u1.e;

/* loaded from: classes2.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f726a = new ConcurrentHashMap();
    public static F0.c b;

    public static boolean a(String str, String str2) {
        b bVar;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && (bVar = (b) f726a.get(str)) != null && bVar.b != TOSUploader.EXPIRED_TIMES) {
            if (h.b) {
                Log.i("<monitor><report>", U7.a.e(new String[]{str2}));
            }
            a aVar = bVar.f725a;
            aVar.getClass();
            byte[] bArrM = AbstractC1451a.m(str2);
            d dVar = aVar.c;
            String str3 = aVar.f724a;
            if (!((AtomicBoolean) dVar.d).get() && bArrM != null && bArrM.length > 0 && ((a) ((ConcurrentHashMap) dVar.b).get(str3)) != null) {
                synchronized (((LinkedList) dVar.e)) {
                    try {
                        if (((AtomicBoolean) dVar.d).get()) {
                            return false;
                        }
                        if (((LinkedList) dVar.e).size() >= 2000) {
                            ((LinkedList) dVar.e).poll();
                        }
                        LinkedList linkedList = (LinkedList) dVar.e;
                        u1.b bVar2 = new u1.b();
                        bVar2.e = str3;
                        bVar2.b = bArrM;
                        boolean zAdd = linkedList.add(bVar2);
                        e eVar = (e) dVar.c;
                        synchronized (eVar.b) {
                            eVar.b.notify();
                        }
                        return zAdd;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        return false;
    }
}
