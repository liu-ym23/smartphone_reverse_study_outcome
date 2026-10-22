package androidx.media;

import androidx.room.AbstractC0351g;
import java.util.Arrays;

/* loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f3994a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f3995b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f3996c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f3997d = -1;

    public final boolean equals(Object obj) {
        int i4;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f3995b != audioAttributesImplBase.f3995b) {
            return false;
        }
        int i5 = this.f3996c;
        int i6 = audioAttributesImplBase.f3996c;
        int i7 = audioAttributesImplBase.f3997d;
        if (i7 == -1) {
            int i8 = audioAttributesImplBase.f3994a;
            int i9 = AudioAttributesCompat.f3990b;
            if ((i6 & 1) != 1) {
                i4 = 4;
                if ((i6 & 4) != 4) {
                    switch (i8) {
                        case 2:
                            i4 = 0;
                            break;
                        case 3:
                            i4 = 8;
                            break;
                        case 4:
                            break;
                        case 5:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            i4 = 5;
                            break;
                        case 6:
                            i4 = 2;
                            break;
                        case 11:
                            i4 = 10;
                            break;
                        case 12:
                        default:
                            i4 = 3;
                            break;
                        case 13:
                            i4 = 1;
                            break;
                    }
                } else {
                    i4 = 6;
                }
            } else {
                i4 = 7;
            }
        } else {
            i4 = i7;
        }
        if (i4 == 6) {
            i6 |= 4;
        } else if (i4 == 7) {
            i6 |= 1;
        }
        return i5 == (i6 & 273) && this.f3994a == audioAttributesImplBase.f3994a && this.f3997d == i7;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3995b), Integer.valueOf(this.f3996c), Integer.valueOf(this.f3994a), Integer.valueOf(this.f3997d)});
    }

    public final String toString() {
        String strM;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3997d != -1) {
            sb.append(" stream=");
            sb.append(this.f3997d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i4 = this.f3994a;
        int i5 = AudioAttributesCompat.f3990b;
        switch (i4) {
            case 0:
                strM = "USAGE_UNKNOWN";
                break;
            case 1:
                strM = "USAGE_MEDIA";
                break;
            case 2:
                strM = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strM = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                strM = "USAGE_ALARM";
                break;
            case 5:
                strM = "USAGE_NOTIFICATION";
                break;
            case 6:
                strM = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                strM = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strM = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strM = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                strM = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strM = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case 12:
                strM = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case 13:
                strM = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case 14:
                strM = "USAGE_GAME";
                break;
            case 15:
            default:
                strM = AbstractC0351g.m("unknown usage ", i4);
                break;
            case 16:
                strM = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strM);
        sb.append(" content=");
        sb.append(this.f3995b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3996c).toUpperCase());
        return sb.toString();
    }
}
