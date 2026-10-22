package com.stepos.ailauncher.chat.fragment;

import Z8.C1174w;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ!\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/a;", "", "<init>", "()V", "", "installed", "", "serverVersion", "installedVersion", "c", "(ZLjava/lang/String;Ljava/lang/String;)Z", "server", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.fragment.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2579a {
    public static final C2579a INSTANCE = new C2579a();

    public static final List<BigInteger> b(String str) {
        String string;
        String strR0;
        String strR02;
        ArrayList arrayList = null;
        if (str != null && (string = La.H.D1(str).toString()) != null && (strR0 = La.H.R0(string, "v")) != null && (strR02 = La.H.R0(strR0, ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) != null) {
            if (!new Regex("[0-9]+(?:\\.[0-9]+)*").k(strR02)) {
                return null;
            }
            List listA1 = La.H.a1(strR02, new char[]{'.'}, false, 0, 6, null);
            arrayList = new ArrayList(C1174w.x(listA1, 10));
            Iterator it = listA1.iterator();
            while (it.hasNext()) {
                arrayList.add(new BigInteger((String) it.next()));
            }
        }
        return arrayList;
    }

    public final boolean a(String server, String installed) {
        List<BigInteger> listB;
        List<BigInteger> listB2 = b(server);
        if (listB2 == null || (listB = b(installed)) == null) {
            return false;
        }
        int iMax = Math.max(listB2.size(), listB.size());
        for (int i10 = 0; i10 < iMax; i10++) {
            BigInteger bigInteger = (BigInteger) Z8.F.t0(listB2, i10);
            if (bigInteger == null) {
                bigInteger = BigInteger.ZERO;
            }
            BigInteger bigInteger2 = (BigInteger) Z8.F.t0(listB, i10);
            if (bigInteger2 == null) {
                bigInteger2 = BigInteger.ZERO;
            }
            int iCompareTo = bigInteger.compareTo(bigInteger2);
            if (iCompareTo != 0) {
                return iCompareTo > 0;
            }
        }
        return false;
    }

    public final boolean c(boolean installed, String serverVersion, String installedVersion) {
        return installed && a(serverVersion, installedVersion);
    }
}
