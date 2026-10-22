package q2;

import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo$State;
import h2.c;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class v {
    public static final LinkedHashSet a(byte[] bytes) throws IOException {
        ObjectInputStream objectInputStream;
        kotlin.jvm.internal.g.f(bytes, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bytes.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            try {
                int i10 = objectInputStream.readInt();
                for (int i11 = 0; i11 < i10; i11++) {
                    Uri uri = Uri.parse(objectInputStream.readUTF());
                    boolean z = objectInputStream.readBoolean();
                    kotlin.jvm.internal.g.e(uri, "uri");
                    linkedHashSet.add(new c.a(z, uri));
                }
                lb.n nVar = lb.n.f10413a;
                objectInputStream.close();
                lb.n nVar2 = lb.n.f10413a;
                byteArrayInputStream.close();
                return linkedHashSet;
            } finally {
            }
        } finally {
        }
    }

    public static final byte[] b(r2.g requestCompat) throws IOException {
        int[] iArrN0;
        int[] iArrN02;
        kotlin.jvm.internal.g.f(requestCompat, "requestCompat");
        int i10 = Build.VERSION.SDK_INT;
        NetworkRequest networkRequest = (NetworkRequest) requestCompat.f11693a;
        if (networkRequest == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                if (i10 >= 31) {
                    iArrN0 = networkRequest.getTransportTypes();
                    kotlin.jvm.internal.g.e(iArrN0, "request.transportTypes");
                } else {
                    int[] iArr = {2, 0, 3, 6, 9, 8, 4, 1, 5};
                    ArrayList arrayList = new ArrayList();
                    for (int i11 = 0; i11 < 9; i11++) {
                        int i12 = iArr[i11];
                        if (networkRequest.hasTransport(i12)) {
                            arrayList.add(Integer.valueOf(i12));
                        }
                    }
                    iArrN0 = kotlin.collections.a.N0(arrayList);
                }
                if (Build.VERSION.SDK_INT >= 31) {
                    iArrN02 = networkRequest.getCapabilities();
                    kotlin.jvm.internal.g.e(iArrN02, "request.capabilities");
                } else {
                    int[] iArr2 = {17, 5, 2, 10, 29, 19, 3, 32, 7, 4, 12, 23, 0, 33, 20, 11, 13, 18, 21, 15, 35, 34, 8, 1, 25, 14, 16, 6, 9};
                    ArrayList arrayList2 = new ArrayList();
                    for (int i13 = 0; i13 < 29; i13++) {
                        int i14 = iArr2[i13];
                        if (networkRequest.hasCapability(i14)) {
                            arrayList2.add(Integer.valueOf(i14));
                        }
                    }
                    iArrN02 = kotlin.collections.a.N0(arrayList2);
                }
                objectOutputStream.writeInt(iArrN0.length);
                for (int i15 : iArrN0) {
                    objectOutputStream.writeInt(i15);
                }
                objectOutputStream.writeInt(iArrN02.length);
                for (int i16 : iArrN02) {
                    objectOutputStream.writeInt(i16);
                }
                lb.n nVar = lb.n.f10413a;
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                kotlin.jvm.internal.g.e(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static final BackoffPolicy c(int i10) {
        if (i10 == 0) {
            return BackoffPolicy.f2759a;
        }
        if (i10 == 1) {
            return BackoffPolicy.f2760b;
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Could not convert ", " to BackoffPolicy"));
    }

    public static final NetworkType d(int i10) {
        if (i10 == 0) {
            return NetworkType.f2783a;
        }
        if (i10 == 1) {
            return NetworkType.f2784b;
        }
        if (i10 == 2) {
            return NetworkType.f2785c;
        }
        if (i10 == 3) {
            return NetworkType.f2786d;
        }
        if (i10 == 4) {
            return NetworkType.f2787e;
        }
        if (i10 == 5) {
            return NetworkType.h;
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Could not convert ", " to NetworkType"));
    }

    public static final OutOfQuotaPolicy e(int i10) {
        if (i10 == 0) {
            return OutOfQuotaPolicy.f2789a;
        }
        if (i10 == 1) {
            return OutOfQuotaPolicy.f2790b;
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Could not convert ", " to OutOfQuotaPolicy"));
    }

    public static final WorkInfo$State f(int i10) {
        if (i10 == 0) {
            return WorkInfo$State.f2792a;
        }
        if (i10 == 1) {
            return WorkInfo$State.f2793b;
        }
        if (i10 == 2) {
            return WorkInfo$State.f2794c;
        }
        if (i10 == 3) {
            return WorkInfo$State.f2795d;
        }
        if (i10 == 4) {
            return WorkInfo$State.f2796e;
        }
        if (i10 == 5) {
            return WorkInfo$State.h;
        }
        throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "Could not convert ", " to State"));
    }

    public static final int g(NetworkType networkType) {
        kotlin.jvm.internal.g.f(networkType, "networkType");
        int iOrdinal = networkType.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i10 = 1;
        if (iOrdinal != 1) {
            i10 = 2;
            if (iOrdinal != 2) {
                i10 = 3;
                if (iOrdinal != 3) {
                    i10 = 4;
                    if (iOrdinal != 4) {
                        if (networkType == NetworkType.h) {
                            return 5;
                        }
                        throw new IllegalArgumentException("Could not convert " + networkType + " to int");
                    }
                }
            }
        }
        return i10;
    }

    public static final byte[] h(Set<c.a> triggers) throws IOException {
        kotlin.jvm.internal.g.f(triggers, "triggers");
        if (triggers.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(triggers.size());
                for (c.a aVar : triggers) {
                    objectOutputStream.writeUTF(aVar.f9264a.toString());
                    objectOutputStream.writeBoolean(aVar.f9265b);
                }
                lb.n nVar = lb.n.f10413a;
                objectOutputStream.close();
                byteArrayOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                kotlin.jvm.internal.g.e(byteArray, "outputStream.toByteArray()");
                return byteArray;
            } finally {
            }
        } finally {
        }
    }

    public static final int i(WorkInfo$State state) {
        kotlin.jvm.internal.g.f(state, "state");
        int iOrdinal = state.ordinal();
        if (iOrdinal == 0) {
            return 0;
        }
        int i10 = 1;
        if (iOrdinal != 1) {
            i10 = 2;
            if (iOrdinal != 2) {
                i10 = 3;
                if (iOrdinal != 3) {
                    i10 = 4;
                    if (iOrdinal != 4) {
                        if (iOrdinal == 5) {
                            return 5;
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
        }
        return i10;
    }

    public static final r2.g j(byte[] bytes) throws IOException {
        kotlin.jvm.internal.g.f(bytes, "bytes");
        if (bytes.length == 0) {
            return new r2.g(null);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                int i10 = objectInputStream.readInt();
                int[] iArr = new int[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    iArr[i11] = objectInputStream.readInt();
                }
                int i12 = objectInputStream.readInt();
                int[] iArr2 = new int[i12];
                for (int i13 = 0; i13 < i12; i13++) {
                    iArr2[i13] = objectInputStream.readInt();
                }
                r2.g gVarA = r2.d.a(iArr2, iArr);
                objectInputStream.close();
                byteArrayInputStream.close();
                return gVarA;
            } finally {
            }
        } finally {
        }
    }
}
