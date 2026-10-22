package androidx.media;

import android.util.SparseIntArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat implements androidx.versionedparcelable.c {
    private static final String TAG = "AudioAttributesCompat";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SparseIntArray f2116b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f2117c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AudioAttributesImpl f2118a;

    static {
        SparseIntArray r0 = new SparseIntArray();
        f2116b = r0;
        r0.put(5, 1);
        r0.put(6, 2);
        r0.put(7, 2);
        r0.put(8, 1);
        r0.put(9, 1);
        r0.put(10, 1);
        f2117c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    AudioAttributesCompat() {
    }

    public int hashCode() {
        return this.f2118a.hashCode();
    }

    public String toString() {
        return this.f2118a.toString();
    }

    static String a(int r2) {
        switch(r2) {
            case 0: goto L35;
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L29;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L23;
            case 7: goto L21;
            case 8: goto L19;
            case 9: goto L17;
            case 10: goto L15;
            case 11: goto L13;
            case 12: goto L11;
            case 13: goto L9;
            case 14: goto L7;
            case 15: goto L4;
            case 16: goto L5;
            default: goto L4;
        };
    L5:
        return "USAGE_ASSISTANT";
    L7:
        return "USAGE_GAME";
    L9:
        return "USAGE_ASSISTANCE_SONIFICATION";
    L11:
        return "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
    L13:
        return "USAGE_ASSISTANCE_ACCESSIBILITY";
    L15:
        return "USAGE_NOTIFICATION_EVENT";
    L17:
        return "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
    L19:
        return "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
    L21:
        return "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
    L23:
        return "USAGE_NOTIFICATION_RINGTONE";
    L25:
        return "USAGE_NOTIFICATION";
    L27:
        return "USAGE_ALARM";
    L29:
        return "USAGE_VOICE_COMMUNICATION_SIGNALLING";
    L31:
        return "USAGE_VOICE_COMMUNICATION";
    L33:
        return "USAGE_MEDIA";
    L35:
        return "USAGE_UNKNOWN";
    L4:
        return "unknown usage " + r2;
    }

    static int a(boolean r3, int r4, int r5) {
        if ((r4 & 1) != 1) goto L9;
        if (r3 == true) goto L36;
        return 7;
    L36:
        return 1;
    L9:
        if ((r4 & 4) != 4) goto L15;
        if (r3 == true) goto L37;
        return 6;
    L37:
        return 0;
    L15:
        switch(r5) {
            case 0: goto L31;
            case 1: goto L30;
            case 2: goto L38;
            case 3: goto L26;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L23;
            case 8: goto L23;
            case 9: goto L23;
            case 10: goto L23;
            case 11: goto L19;
            case 12: goto L30;
            case 13: goto L18;
            case 14: goto L30;
            case 15: goto L16;
            case 16: goto L30;
            default: goto L16;
        };
    L16:
        if (r3 == true) goto L35;
        return 3;
    L35:
        throw new IllegalArgumentException("Unknown usage value " + r5 + " in audio attributes");
    L18:
        return 1;
    L19:
        return 10;
    L21:
        return 2;
    L23:
        return 5;
    L25:
        return 4;
    L26:
        if (r3 == true) goto L39;
        return 8;
    L39:
        return 0;
    L30:
        return 3;
    L31:
        if (r3 == false) goto L40;
        return Integer.MIN_VALUE;
    L40:
        return 3;
    L38:
        return 0;
    }

    public boolean equals(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, AudioAttributesCompat.class) == true) goto L5;
        return false;
    L5:
        AudioAttributesCompat r5 = (AudioAttributesCompat) ZeusTransformUtils.preCheckCast(r4, AudioAttributesCompat.class, "com.obric.aiagent.plugin");
        AudioAttributesImpl r3 = this.f2118a;
        if (r3 != null) goto L12;
        if (r5.f2118a != null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return r3.equals(r5.f2118a);
    }
}
