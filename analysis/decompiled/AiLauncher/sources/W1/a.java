package W1;

import android.annotation.SuppressLint;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;

@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f6591a = {"android.permission.READ_CALENDAR", PolicySdkPermissionManifestUtils.WRITE_CALENDAR};

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f6592b = {"android.permission.CAMERA"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f6593c = {"android.permission.READ_CONTACTS", PolicySdkPermissionManifestUtils.WRITE_CONTACTS, "android.permission.GET_ACCOUNTS"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f6594d = {PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION, PolicySdkPermissionManifestUtils.ACCESS_BACKGROUND_LOCATION};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f6595e = {PolicySdkPermissionManifestUtils.RECORD_AUDIO};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f6596f = {PolicySdkPermissionManifestUtils.READ_PHONE_STATE, "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", PolicySdkPermissionManifestUtils.WRITE_CALL_LOG, "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS", "android.permission.ANSWER_PHONE_CALLS"};

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f6597g = {PolicySdkPermissionManifestUtils.READ_PHONE_STATE, "android.permission.READ_PHONE_NUMBERS", "android.permission.CALL_PHONE", "android.permission.READ_CALL_LOG", PolicySdkPermissionManifestUtils.WRITE_CALL_LOG, "com.android.voicemail.permission.ADD_VOICEMAIL", "android.permission.USE_SIP", "android.permission.PROCESS_OUTGOING_CALLS"};

    /* renamed from: h, reason: collision with root package name */
    public static final String[] f6598h = {"android.permission.BODY_SENSORS"};

    /* renamed from: i, reason: collision with root package name */
    public static final String[] f6599i = {"android.permission.SEND_SMS", "android.permission.RECEIVE_SMS", "android.permission.READ_SMS", "android.permission.RECEIVE_WAP_PUSH", "android.permission.RECEIVE_MMS"};

    /* renamed from: j, reason: collision with root package name */
    public static final String[] f6600j = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};

    /* renamed from: k, reason: collision with root package name */
    public static final String[] f6601k = {PolicySdkPermissionManifestUtils.ACTIVITY_RECOGNITION};

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:8:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] a(java.lang.String r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L6
            java.lang.String[] r3 = new java.lang.String[r0]
            return r3
        L6:
            int r1 = r3.hashCode()
            r2 = -1
            switch(r1) {
                case -1611296843: goto L77;
                case -1596608551: goto L6c;
                case -1166291365: goto L61;
                case 82233: goto L56;
                case 76105038: goto L4b;
                case 140654183: goto L40;
                case 215175251: goto L35;
                case 604302142: goto L2a;
                case 1856013610: goto L1e;
                case 1980544805: goto L11;
                default: goto Le;
            }
        Le:
            r0 = r2
            goto L80
        L11:
            java.lang.String r0 = "CAMERA"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L1a
            goto Le
        L1a:
            r0 = 9
            goto L80
        L1e:
            java.lang.String r0 = "MICROPHONE"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L27
            goto Le
        L27:
            r0 = 8
            goto L80
        L2a:
            java.lang.String r0 = "CALENDAR"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L33
            goto Le
        L33:
            r0 = 7
            goto L80
        L35:
            java.lang.String r0 = "CONTACTS"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L3e
            goto Le
        L3e:
            r0 = 6
            goto L80
        L40:
            java.lang.String r0 = "ACTIVITY_RECOGNITION"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L49
            goto Le
        L49:
            r0 = 5
            goto L80
        L4b:
            java.lang.String r0 = "PHONE"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L54
            goto Le
        L54:
            r0 = 4
            goto L80
        L56:
            java.lang.String r0 = "SMS"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L5f
            goto Le
        L5f:
            r0 = 3
            goto L80
        L61:
            java.lang.String r0 = "STORAGE"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L6a
            goto Le
        L6a:
            r0 = 2
            goto L80
        L6c:
            java.lang.String r0 = "SENSORS"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L75
            goto Le
        L75:
            r0 = 1
            goto L80
        L77:
            java.lang.String r1 = "LOCATION"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L80
            goto Le
        L80:
            switch(r0) {
                case 0: goto La3;
                case 1: goto La0;
                case 2: goto L9d;
                case 3: goto L9a;
                case 4: goto L97;
                case 5: goto L94;
                case 6: goto L91;
                case 7: goto L8e;
                case 8: goto L8b;
                case 9: goto L88;
                default: goto L83;
            }
        L83:
            java.lang.String[] r3 = new java.lang.String[]{r3}
            return r3
        L88:
            java.lang.String[] r3 = W1.a.f6592b
            return r3
        L8b:
            java.lang.String[] r3 = W1.a.f6595e
            return r3
        L8e:
            java.lang.String[] r3 = W1.a.f6591a
            return r3
        L91:
            java.lang.String[] r3 = W1.a.f6593c
            return r3
        L94:
            java.lang.String[] r3 = W1.a.f6601k
            return r3
        L97:
            java.lang.String[] r3 = W1.a.f6596f
            return r3
        L9a:
            java.lang.String[] r3 = W1.a.f6599i
            return r3
        L9d:
            java.lang.String[] r3 = W1.a.f6600j
            return r3
        La0:
            java.lang.String[] r3 = W1.a.f6598h
            return r3
        La3:
            java.lang.String[] r3 = W1.a.f6594d
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: W1.a.a(java.lang.String):java.lang.String[]");
    }
}
