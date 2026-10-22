package androidx.work.impl.model;

import android.net.Uri;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.ContentUriTriggers;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes17.dex */
public class WorkTypeConverters {

    /* JADX INFO: renamed from: androidx.work.impl.model.WorkTypeConverters$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$work$BackoffPolicy = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$work$NetworkType = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$work$OutOfQuotaPolicy = null;
        static final /* synthetic */ int[] $SwitchMap$androidx$work$WorkInfo$State = null;

        static {
            int[] r100 = new int[OutOfQuotaPolicy.values().length];
            $SwitchMap$androidx$work$OutOfQuotaPolicy = r100;
            r100[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L26
        L55:
            $SwitchMap$androidx$work$OutOfQuotaPolicy[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L27
        L6:
            int[] r101 = new int[NetworkType.values().length];
            $SwitchMap$androidx$work$NetworkType = r101;
            r101[NetworkType.NOT_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L59:
            $SwitchMap$androidx$work$NetworkType[NetworkType.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L69:
            $SwitchMap$androidx$work$NetworkType[NetworkType.UNMETERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L43:
            $SwitchMap$androidx$work$NetworkType[NetworkType.NOT_ROAMING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L63:
            $SwitchMap$androidx$work$NetworkType[NetworkType.METERED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L15:
            int[] r102 = new int[BackoffPolicy.values().length];
            $SwitchMap$androidx$work$BackoffPolicy = r102;
            r102[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L51:
            $SwitchMap$androidx$work$BackoffPolicy[BackoffPolicy.LINEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L18:
            int[] r103 = new int[WorkInfo.State.values().length];
            $SwitchMap$androidx$work$WorkInfo$State = r103;
            r103[WorkInfo.State.ENQUEUED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L47:
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.RUNNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L61:
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.SUCCEEDED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L67:
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L41:
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.BLOCKED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L57:
            $SwitchMap$androidx$work$WorkInfo$State[WorkInfo.State.CANCELLED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
            return;
        }
    }

    public interface BackoffPolicyIds {
        public static final int EXPONENTIAL = 0;
        public static final int LINEAR = 1;
    }

    public interface NetworkTypeIds {
        public static final int CONNECTED = 1;
        public static final int METERED = 4;
        public static final int NOT_REQUIRED = 0;
        public static final int NOT_ROAMING = 3;
        public static final int TEMPORARILY_UNMETERED = 5;
        public static final int UNMETERED = 2;
    }

    public interface OutOfPolicyIds {
        public static final int DROP_WORK_REQUEST = 1;
        public static final int RUN_AS_NON_EXPEDITED_WORK_REQUEST = 0;
    }

    public interface StateIds {
        public static final int BLOCKED = 4;
        public static final int CANCELLED = 5;
        public static final String COMPLETED_STATES = "(2, 3, 5)";
        public static final int ENQUEUED = 0;
        public static final int FAILED = 3;
        public static final int RUNNING = 1;
        public static final int SUCCEEDED = 2;
    }

    private WorkTypeConverters() {
    }

    public static int backoffPolicyToInt(BackoffPolicy r100) {
        int r101 = AnonymousClass1.$SwitchMap$androidx$work$BackoffPolicy[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 2) goto L8;
        return 1;
    L8:
        throw new IllegalArgumentException("Could not convert " + r100 + " to int");
    }

    public static ContentUriTriggers byteArrayToContentUriTriggers(byte[] r100) {
        ContentUriTriggers r101 = new ContentUriTriggers();
        if (r100 != null) goto L5;
        return r101;
    L5:
        ByteArrayInputStream r102 = new ByteArrayInputStream(r100);
        ObjectInputStream r103 = new ObjectInputStream(r102);     // Catch: Throwable -> L19 IOException -> L21
        int r104 = r103.readInt();     // Catch: IOException -> L17 Throwable -> L34
    L8:
        if (r104 <= 0) goto L55;
        r101.add(Uri.parse(r103.readUTF()), r103.readBoolean());     // Catch: IOException -> L17 Throwable -> L34
        r104 = r104 - 1;
        goto L8
    L55:
        r103.close();     // Catch: IOException -> L13
    L15:
        r102.close();     // Catch: IOException -> L31
    L52:
    L33:
        return r101;
    L13:
        e = move-exception;
        e.printStackTrace();
    L17:
        IOException e100 = e;
    L23:
        e100.printStackTrace();     // Catch: Throwable -> L34
        if (r103 != null) goto L45;
    L29:
        r102.close();     // Catch: IOException -> L31
        goto L52
    L45:
        r103.close();     // Catch: IOException -> L27
    L27:
        e = move-exception;
        e.printStackTrace();
    L34:
        Throwable th10 = th;
    L35:
        if (r103 != null) goto L57;
    L49:
        r102.close();     // Catch: IOException -> L42
        throw th10;
    L42:
        e = move-exception;
        e.printStackTrace();
        throw th10;
    L57:
        r103.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        e.printStackTrace();
        goto L49
    L31:
        e = move-exception;
        e.printStackTrace();
    L21:
        e = move-exception;
        r103 = null;
        e100 = e;
    L19:
        th = move-exception;
        r103 = null;
        th10 = th;
        goto L35
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static byte[] contentUriTriggersToByteArray(ContentUriTriggers r100) {
        ?? r101 = 0;
        ObjectOutputStream r102 = null;
        r101 = 0;
        if (r100.size() != 0) goto L5;
        return null;
    L5:
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        ObjectOutputStream r104 = new ObjectOutputStream(r103);     // Catch: Throwable -> L22 IOException -> L24
        r104.writeInt(r100.size());     // Catch: Throwable -> L18 IOException -> L20
        Iterator<ContentUriTriggers.Trigger> r105 = r100.getTriggers().iterator();     // Catch: Throwable -> L18 IOException -> L20
    L8:
        boolean r106 = r105.hasNext();     // Catch: Throwable -> L18 IOException -> L20
        if (r106 == false) goto L54;
        ContentUriTriggers.Trigger r107 = r105.next();     // Catch: Throwable -> L18 IOException -> L20
        r104.writeUTF(r107.getUri().toString());     // Catch: Throwable -> L18 IOException -> L20
        r104.writeBoolean(r107.shouldTriggerForDescendants());     // Catch: Throwable -> L18 IOException -> L20
    L54:
        r104.close();     // Catch: IOException -> L14
    L16:
        r103.close();     // Catch: IOException -> L33
        r101 = r106;
    L51:
    L35:
        return r103.toByteArray();
    L14:
        e = move-exception;
        e.printStackTrace();
    L20:
        e = e;
        r102 = r104;
    L25:
        e.printStackTrace();     // Catch: Throwable -> L22
        if (r102 != null) goto L59;
    L31:
        r103.close();     // Catch: IOException -> L33
        r101 = r102;
        goto L51
    L59:
        r102.close();     // Catch: IOException -> L29
    L29:
        e = move-exception;
        e.printStackTrace();
    L18:
        th = th;
        r101 = r104;
    L37:
        if (r101 == 0) goto L57;
        r101.close();     // Catch: IOException -> L40
    L40:
        e = move-exception;
        e.printStackTrace();
    L57:
        r103.close();     // Catch: IOException -> L44
        throw th;
    L44:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L22:
        th = th;
    L24:
        e = e;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    }

    public static BackoffPolicy intToBackoffPolicy(int r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return BackoffPolicy.LINEAR;
    L8:
        throw new IllegalArgumentException("Could not convert " + r100 + " to BackoffPolicy");
    L10:
        return BackoffPolicy.EXPONENTIAL;
    }

    public static NetworkType intToNetworkType(int r100) {
        if (r100 == 0) goto L28;
        if (r100 == 1) goto L26;
        if (r100 == 2) goto L24;
        if (r100 == 3) goto L22;
        if (r100 == 4) goto L20;
        if (Build.VERSION.SDK_INT < 30) goto L18;
        if (r100 != 5) goto L18;
        return NetworkType.TEMPORARILY_UNMETERED;
    L18:
        throw new IllegalArgumentException("Could not convert " + r100 + " to NetworkType");
    L20:
        return NetworkType.METERED;
    L22:
        return NetworkType.NOT_ROAMING;
    L24:
        return NetworkType.UNMETERED;
    L26:
        return NetworkType.CONNECTED;
    L28:
        return NetworkType.NOT_REQUIRED;
    }

    public static OutOfQuotaPolicy intToOutOfQuotaPolicy(int r100) {
        if (r100 == 0) goto L10;
        if (r100 != 1) goto L8;
        return OutOfQuotaPolicy.DROP_WORK_REQUEST;
    L8:
        throw new IllegalArgumentException("Could not convert " + r100 + " to OutOfQuotaPolicy");
    L10:
        return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    }

    public static WorkInfo.State intToState(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 != 5) goto L16;
        return WorkInfo.State.CANCELLED;
    L16:
        throw new IllegalArgumentException("Could not convert " + r100 + " to State");
    L18:
        return WorkInfo.State.BLOCKED;
    L20:
        return WorkInfo.State.FAILED;
    L22:
        return WorkInfo.State.SUCCEEDED;
    L24:
        return WorkInfo.State.RUNNING;
    L26:
        return WorkInfo.State.ENQUEUED;
    }

    public static int networkTypeToInt(NetworkType r100) {
        int r101 = AnonymousClass1.$SwitchMap$androidx$work$NetworkType[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 2) goto L7;
        return 1;
    L7:
        if (r101 != 3) goto L9;
        return 2;
    L9:
        if (r101 != 4) goto L11;
        return 3;
    L11:
        if (r101 != 5) goto L13;
        return 4;
    L13:
        if (Build.VERSION.SDK_INT < 30) goto L18;
        if (r100 != NetworkType.TEMPORARILY_UNMETERED) goto L18;
        return 5;
    L18:
        throw new IllegalArgumentException("Could not convert " + r100 + " to int");
    }

    public static int outOfQuotaPolicyToInt(OutOfQuotaPolicy r100) {
        int r101 = AnonymousClass1.$SwitchMap$androidx$work$OutOfQuotaPolicy[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 0;
    L5:
        if (r101 != 2) goto L8;
        return 1;
    L8:
        throw new IllegalArgumentException("Could not convert " + r100 + " to int");
    }

    public static int stateToInt(WorkInfo.State r100) {
        switch(AnonymousClass1.$SwitchMap$androidx$work$WorkInfo$State[r100.ordinal()]) {
            case 1: goto L16;
            case 2: goto L14;
            case 3: goto L12;
            case 4: goto L10;
            case 5: goto L8;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return 5;
    L8:
        return 4;
    L10:
        return 3;
    L12:
        return 2;
    L14:
        return 1;
    L16:
        return 0;
    L5:
        throw new IllegalArgumentException("Could not convert " + r100 + " to int");
    }
}
