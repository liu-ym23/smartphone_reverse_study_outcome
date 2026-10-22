package androidx.work.impl.model;

import android.net.Uri;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.database.columns.DownloadInfoColumns;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f5743a = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5744a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f5745b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f5746c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f5747d = null;

        static {
            int[] r10 = new int[WorkInfo.State.values().length];
            r10[WorkInfo.State.ENQUEUED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L62:
            r10[WorkInfo.State.RUNNING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L70:
            r10[WorkInfo.State.SUCCEEDED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L46:
            r10[WorkInfo.State.FAILED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L48:
            r10[WorkInfo.State.BLOCKED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L56:
            r10[WorkInfo.State.CANCELLED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L13:
            f5744a = r10;
            int[] r11 = new int[BackoffPolicy.values().length];
            r11[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L33
        L50:
            r11[BackoffPolicy.LINEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L34
        L16:
            f5745b = r11;
            int[] r12 = new int[NetworkType.values().length];
            r12[NetworkType.NOT_REQUIRED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L44:
            r12[NetworkType.CONNECTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L52:
            r12[NetworkType.UNMETERED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L58:
            r12[NetworkType.NOT_ROAMING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L64:
            r12[NetworkType.METERED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L22:
            f5746c = r12;
            int[] r13 = new int[OutOfQuotaPolicy.values().length];
            r13[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L40
        L68:
            r13[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L41
        L25:
            f5747d = r13;
        }
    }

    static {
        f5743a = new t();
    }

    public t() {
    }

    public static final int a(BackoffPolicy r10) {
        kotlin.jvm.internal.q.g(r10, "backoffPolicy");
        int r11 = a.f5745b[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0;
    L5:
        if (r11 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final Set b(byte[] r10) {
        kotlin.jvm.internal.q.g(r10, DownloadInfoColumns.COLUMN_BYTES);
        LinkedHashSet r11 = new LinkedHashSet();
        if (r10.length != 0) goto L5;
        return r11;
    L5:
        ByteArrayInputStream r12 = new ByteArrayInputStream(r10);
        ObjectInputStream r13 = new ObjectInputStream(r12);     // Catch: Throwable -> L15 IOException -> L17
        int r14 = r13.readInt();     // Catch: Throwable -> L10
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L12;
        Uri r16 = Uri.parse(r13.readUTF());     // Catch: Throwable -> L10
        boolean r17 = r13.readBoolean();     // Catch: Throwable -> L10
        kotlin.jvm.internal.q.f(r16, "uri");     // Catch: Throwable -> L10
        r11.add(new androidx.work.a.b(r16, r17));     // Catch: Throwable -> L10
        r15 = r15 + 1;     // Catch: Throwable -> L10
        goto L8
    L12:
        Unit r18 = Unit.f21064a;     // Catch: Throwable -> L10
        kotlin.io.b.a(r13, null);     // Catch: Throwable -> L15 IOException -> L17
    L24:
        Unit r19 = Unit.f21064a;     // Catch: Throwable -> L15
        kotlin.io.b.a(r12, null);
        return r11;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        kotlin.io.b.a(r13, th);     // Catch: Throwable -> L15 IOException -> L17
        throw th;     // Catch: Throwable -> L15 IOException -> L17
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        kotlin.io.b.a(r12, th);
        throw th;
    L17:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L15
        goto L24
    }

    public static final BackoffPolicy c(int r10) {
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L7;
        return BackoffPolicy.LINEAR;
    L7:
        throw new IllegalArgumentException("Could not convert " + r10 + " to BackoffPolicy");
    L9:
        return BackoffPolicy.EXPONENTIAL;
    }

    public static final NetworkType d(int r10) {
        if (r10 == 0) goto L22;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L24;
        if (r10 == 4) goto L23;
        if (r10 != 5) goto L16;
        return NetworkType.TEMPORARILY_UNMETERED;
    L16:
        throw new IllegalArgumentException("Could not convert " + r10 + " to NetworkType");
    L23:
        return NetworkType.METERED;
    L24:
        return NetworkType.NOT_ROAMING;
    L25:
        return NetworkType.UNMETERED;
    L26:
        return NetworkType.CONNECTED;
    L22:
        return NetworkType.NOT_REQUIRED;
    }

    public static final OutOfQuotaPolicy e(int r10) {
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L7;
        return OutOfQuotaPolicy.DROP_WORK_REQUEST;
    L7:
        throw new IllegalArgumentException("Could not convert " + r10 + " to OutOfQuotaPolicy");
    L9:
        return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
    }

    public static final WorkInfo.State f(int r10) {
        if (r10 == 0) goto L21;
        if (r10 == 1) goto L26;
        if (r10 == 2) goto L25;
        if (r10 == 3) goto L24;
        if (r10 == 4) goto L23;
        if (r10 != 5) goto L15;
        return WorkInfo.State.CANCELLED;
    L15:
        throw new IllegalArgumentException("Could not convert " + r10 + " to State");
    L23:
        return WorkInfo.State.BLOCKED;
    L24:
        return WorkInfo.State.FAILED;
    L25:
        return WorkInfo.State.SUCCEEDED;
    L26:
        return WorkInfo.State.RUNNING;
    L21:
        return WorkInfo.State.ENQUEUED;
    }

    public static final int g(NetworkType r10) {
        kotlin.jvm.internal.q.g(r10, "networkType");
        int r11 = a.f5746c[r10.ordinal()];
        if (r11 == 1) goto L18;
        int r12 = 2;
        if (r11 != 2) goto L7;
        return 1;
    L7:
        if (r11 == 3) goto L22;
        r12 = 4;
        if (r11 != 4) goto L11;
        return 3;
    L11:
        if (r11 == 5) goto L22;
        if (r10 != NetworkType.TEMPORARILY_UNMETERED) goto L16;
        return 5;
    L16:
        throw new IllegalArgumentException("Could not convert " + r10 + " to int");
    L22:
        return r12;
    L18:
        return 0;
    }

    public static final int h(OutOfQuotaPolicy r10) {
        kotlin.jvm.internal.q.g(r10, "policy");
        int r11 = a.f5747d[r10.ordinal()];
        if (r11 != 1) goto L5;
        return 0;
    L5:
        if (r11 != 2) goto L8;
        return 1;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public static final byte[] i(Set r10) {
        kotlin.jvm.internal.q.g(r10, "triggers");
        if (r10.isEmpty() == true) goto L5;
        ByteArrayOutputStream r11 = new ByteArrayOutputStream();
        ObjectOutputStream r12 = new ObjectOutputStream(r11);     // Catch: Throwable -> L19
        r12.writeInt(r10.size());     // Catch: Throwable -> L12
        Iterator r13 = r10.iterator();     // Catch: Throwable -> L12
    L10:
        if (r13.hasNext() == false) goto L14;
        androidx.work.a.b r14 = (androidx.work.a.b) r13.next();     // Catch: Throwable -> L12
        r12.writeUTF(r14.a().toString());     // Catch: Throwable -> L12
        r12.writeBoolean(r14.b());     // Catch: Throwable -> L12
        goto L10
    L14:
        Unit r15 = Unit.f21064a;     // Catch: Throwable -> L12
    L16:
        kotlin.io.b.a(r12, null);     // Catch: Throwable -> L19
        kotlin.io.b.a(r11, null);
        byte[] r16 = r11.toByteArray();
        kotlin.jvm.internal.q.f(r16, "outputStream.toByteArray()");
        return r16;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        kotlin.io.b.a(r12, th);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        kotlin.io.b.a(r11, th);
        throw th;
    L5:
        return new byte[0];
    }

    public static final int j(WorkInfo.State r10) {
        kotlin.jvm.internal.q.g(r10, WsConstants.KEY_CONNECTION_STATE);
        switch(a.f5744a[r10.ordinal()]) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        return 5;
    L7:
        return 4;
    L8:
        return 3;
    L9:
        return 2;
    L10:
        return 1;
    L11:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }
}
