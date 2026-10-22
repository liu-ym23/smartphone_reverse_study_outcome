package t2;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* renamed from: t2.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2012a implements Application.ActivityLifecycleCallbacks {
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        byte[] bArrMarshall;
        LinkedHashMap linkedHashMap = AbstractC2013b.b;
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeBundle(bundle);
            bArrMarshall = parcelObtain.marshall();
            parcelObtain.recycle();
        } catch (Throwable unused) {
            parcelObtain.recycle();
            bArrMarshall = null;
        }
        if (bArrMarshall == null) {
            bundle.clear();
            return;
        }
        if (bArrMarshall.length > 1024) {
            String string = UUID.randomUUID().toString();
            try {
                linkedHashMap.put(string, bArrMarshall);
                if (linkedHashMap.size() > 64) {
                    Set setEntrySet = linkedHashMap.entrySet();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = setEntrySet.iterator();
                    while (it.hasNext()) {
                        arrayList.add(((Map.Entry) it.next()).getKey());
                        if (arrayList.size() >= 12) {
                            break;
                        }
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        linkedHashMap.remove((String) it2.next());
                    }
                }
                bundle.clear();
                bundle.putString("APMPLUS_TTL_ActivityRecordKey", string);
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPreCreated(Activity activity, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        Object obj = bundle.get("APMPLUS_TTL_ActivityRecordKey");
        if (obj instanceof String) {
            try {
                bundle.clear();
                byte[] bArr = (byte[]) AbstractC2013b.b.get(obj);
                if (bArr == null) {
                    return;
                }
                ClassLoader classLoader = activity.getClassLoader();
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.unmarshall(bArr, 0, bArr.length);
                    parcelObtain.setDataPosition(0);
                    Bundle bundle2 = parcelObtain.readBundle(classLoader);
                    if (bundle2 != null) {
                        bundle.putAll(bundle2);
                    }
                } finally {
                    parcelObtain.recycle();
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }
}
