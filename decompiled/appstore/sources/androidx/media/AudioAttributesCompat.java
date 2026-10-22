package androidx.media;

import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.versionedparcelable.VersionedParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class AudioAttributesCompat implements VersionedParcelable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseIntArray f3599b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f3600c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f3601a;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface AttributeUsage {
    }

    static {
        SparseIntArray r10 = new SparseIntArray();
        f3599b = r10;
        r10.put(5, 1);
        r10.put(6, 2);
        r10.put(7, 2);
        r10.put(8, 1);
        r10.put(9, 1);
        r10.put(10, 1);
        f3600c = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16};
    }

    public AudioAttributesCompat() {
    }

    public static int a(boolean r10, int r11, int r12) {
        if ((r11 & 1) != 1) goto L9;
        if (r10 == true) goto L36;
        return 7;
    L36:
        return 1;
    L9:
        if ((r11 & 4) != 4) goto L15;
        if (r10 == true) goto L37;
        return 6;
    L37:
        return 0;
    L15:
        switch(r12) {
            case 0: goto L33;
            case 1: goto L32;
            case 2: goto L38;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L25;
            case 6: goto L23;
            case 7: goto L25;
            case 8: goto L25;
            case 9: goto L25;
            case 10: goto L25;
            case 11: goto L21;
            case 12: goto L32;
            case 13: goto L20;
            case 14: goto L32;
            case 15: goto L16;
            case 16: goto L32;
            default: goto L16;
        };
    L16:
        if (r10 == true) goto L19;
        return 3;
    L19:
        throw new IllegalArgumentException("Unknown usage value " + r12 + " in audio attributes");
    L20:
        return 1;
    L21:
        return 10;
    L23:
        return 2;
    L25:
        return 5;
    L27:
        return 4;
    L28:
        if (r10 == true) goto L39;
        return 8;
    L39:
        return 0;
    L32:
        return 3;
    L33:
        if (r10 == false) goto L40;
        return Integer.MIN_VALUE;
    L40:
        return 3;
    L38:
        return 0;
    }

    public static String b(int r10) {
        switch(r10) {
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
        return "unknown usage " + r10;
    }

    public boolean equals(Object r10) {
        if ((r10 instanceof AudioAttributesCompat) == true) goto L5;
        return false;
    L5:
        AudioAttributesCompat r11 = (AudioAttributesCompat) r10;
        AudioAttributesImpl r12 = this.f3601a;
        if (r12 != null) goto L12;
        if (r11.f3601a != null) goto L13;
        return true;
    L13:
        return false;
    L12:
        return r12.equals(r11.f3601a);
    }

    public int hashCode() {
        return this.f3601a.hashCode();
    }

    public String toString() {
        return this.f3601a.toString();
    }
}
