package androidx.core.app;

import android.os.Bundle;
import androidx.core.app.j;
import androidx.core.graphics.drawable.IconCompat;
import com.stepos.minor.Minor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f9553a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f9554b = new Object();

    static Bundle a(j.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt(Minor.COLUMN_ICON, iconCompatD != null ? iconCompatD.h() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    private static Bundle b(r rVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", rVar.i());
        bundle.putCharSequence("label", rVar.h());
        bundle.putCharSequenceArray("choices", rVar.e());
        bundle.putBoolean("allowFreeFormInput", rVar.c());
        bundle.putBundle("extras", rVar.g());
        Set<String> setD = rVar.d();
        if (setD != null && !setD.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(setD.size());
            Iterator<String> it = setD.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] c(r[] rVarArr) {
        if (rVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[rVarArr.length];
        for (int i5 = 0; i5 < rVarArr.length; i5++) {
            bundleArr[i5] = b(rVarArr[i5]);
        }
        return bundleArr;
    }
}
