package m0;

import com.stepos.stepclaw.base.util.ALog;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Arrays;
import p7.m;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class f {
    public static String a(IOException iOException, StringBuilder sb) {
        sb.append(iOException.getMessage());
        return sb.toString();
    }

    public static String b(Object obj, String str) {
        return str.concat(obj.getClass().getName());
    }

    public static String c(String str, String str2) {
        return str + str2;
    }

    public static String d(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String e(StringBuilder sb, int i8, String str) {
        sb.append(i8);
        sb.append(str);
        return sb.toString();
    }

    public static String f(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String g(ASN1Sequence aSN1Sequence, StringBuilder sb) {
        sb.append(aSN1Sequence.size());
        return sb.toString();
    }

    public static String h(CipherParameters cipherParameters, String str) {
        return str.concat(cipherParameters.getClass().getName());
    }

    public static ASN1ObjectIdentifier i(String str) {
        return new ASN1ObjectIdentifier(str).intern();
    }

    public static m j(m mVar, m mVar2, m mVar3) {
        return mVar.o().a(mVar2).a(mVar3);
    }

    public static /* synthetic */ void k(AutoCloseable autoCloseable) throws Exception {
        boolean zIsTerminated;
        if (autoCloseable instanceof AutoCloseable) {
            autoCloseable.close();
            return;
        }
        if (!(autoCloseable instanceof ExecutorService)) {
            throw new IllegalArgumentException();
        }
        ExecutorService executorService = (ExecutorService) autoCloseable;
        if (executorService == ForkJoinPool.commonPool() || (zIsTerminated = executorService.isTerminated())) {
            return;
        }
        executorService.shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = executorService.awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    executorService.shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public static void l(String str, String str2, String str3, Exception exc) {
        ALog.w(str3, str + str2, exc);
    }

    public static byte[] m(ASN1Sequence aSN1Sequence, int i8) {
        return Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i8)).getOctets());
    }

    public static /* synthetic */ String n(int i8) {
        switch (i8) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }
}
