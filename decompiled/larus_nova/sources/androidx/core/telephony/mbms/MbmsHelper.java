package androidx.core.telephony.mbms;

import android.content.Context;
import android.os.Build;
import android.telephony.mbms.ServiceInfo;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes17.dex */
public final class MbmsHelper {

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static CharSequence getBestNameForService(Context r100, ServiceInfo r101) {
            Set<Locale> r102 = r101.getNamedContentLocales();
            if (r102.isEmpty() == false) goto L5;
            return null;
        L5:
            String[] r103 = new String[r102.size()];
            Iterator<Locale> r104 = r101.getNamedContentLocales().iterator();
            int r105 = 0;
        L7:
            if (r104.hasNext() == false) goto L9;
            r103[r105] = r104.next().toLanguageTag();
            r105 = r105 + 1;
            goto L7
        L9:
            Locale r106 = r100.getResources().getConfiguration().getLocales().getFirstMatch(r103);
            if (r106 != null) goto L13;
            return null;
        L13:
            return r101.getNameForLocale(r106);
        }
    }

    private MbmsHelper() {
    }

    public static CharSequence getBestNameForService(Context r100, ServiceInfo r101) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        return null;
    L5:
        return Api28Impl.getBestNameForService(r100, r101);
    }
}
