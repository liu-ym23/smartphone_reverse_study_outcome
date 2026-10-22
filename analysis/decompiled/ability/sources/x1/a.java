package x1;

import H.h;
import H.k;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import m0.C1669c;

/* loaded from: classes2.dex */
public abstract class a extends w1.b implements w1.a {
    public long f;
    public int g;

    public final synchronized int k(String str) {
        int iDelete = -1;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            iDelete = this.f6829a.getContentResolver().delete(j(), "_id in ( " + str + " )", null);
        } catch (Exception unused) {
        }
        return iDelete;
    }

    public final synchronized int l(LinkedList linkedList) {
        if (S0.b.a0(linkedList)) {
            return -1;
        }
        int iK = k(S0.b.o(",", linkedList));
        this.f -= iK;
        return iK;
    }

    public final synchronized void m(ArrayList arrayList) {
        int i;
        ArrayList arrayList2;
        ContentValues contentValuesD;
        try {
            if (S0.b.a0(arrayList)) {
                return;
            }
            int size = arrayList.size();
            int i6 = ((size - 1) / 50) + 1;
            i = 0;
            while (i < i6) {
                int i10 = i * 50;
                int iMin = Math.min(i10 + 50, size);
                arrayList2 = new ArrayList(iMin - i10);
                while (i10 < iMin) {
                    C1669c c1669c = (C1669c) arrayList.get(i10);
                    try {
                        contentValuesD = d(c1669c);
                    } catch (Throwable th) {
                        k.f723a.z("apm_AbsLogDao_" + c1669c.b + c1669c.c, th);
                        contentValuesD = null;
                    }
                    if (contentValuesD == null) {
                        arrayList.set(i10, null);
                    } else {
                        arrayList2.add(contentValuesD);
                        c1669c.getClass();
                        arrayList.set(i10, null);
                    }
                    i10++;
                }
                synchronized (this) {
                    if (!S0.b.a0(arrayList2)) {
                        int size2 = arrayList2.size();
                        int i11 = 0;
                        while (i11 < size2) {
                            ArrayList<ContentProviderOperation> arrayList3 = new ArrayList<>(8);
                            for (int i12 = 0; i12 < 50 && i11 < size2; i12++) {
                                ContentProviderOperation.Builder builderNewInsert = ContentProviderOperation.newInsert(j());
                                builderNewInsert.withValues((ContentValues) arrayList2.get(i11));
                                arrayList3.add(builderNewInsert.build());
                                i11++;
                            }
                            try {
                                ContentProviderResult[] contentProviderResultArrApplyBatch = h.f711a.getContentResolver().applyBatch(this.b, arrayList3);
                                if (h.b) {
                                    for (ContentProviderResult contentProviderResult : contentProviderResultArrApplyBatch) {
                                        Log.i("<monitor><store>", U7.a.e(new String[]{"insertBatch ret: ", contentProviderResult.uri.toString()}));
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                    }
                }
            }
            arrayList.clear();
            return;
        } catch (Throwable th2) {
            throw th2;
        }
        arrayList2.clear();
        i++;
    }
}
