package android.net.ipmemorystore;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SameL3NetworkResponse {
    public static final int NETWORK_DIFFERENT = 2;
    public static final int NETWORK_NEVER_CONNECTED = 3;
    public static final int NETWORK_SAME = 1;
    public final float confidence;
    public final String l2Key1;
    public final String l2Key2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NetworkSameness {
    }

    public final int getNetworkSameness() {
        if (this.confidence <= 1.0d) goto L5;
        return 3;
    L5:
        if (this.confidence >= 0.0d) goto L8;
        return 3;
    L8:
        if (this.confidence <= 0.5d) goto L10;
        return 1;
    L10:
        return 2;
    }

    public SameL3NetworkResponse(String l2Key1, String l2Key2, float confidence) {
        this.l2Key1 = l2Key1;
        this.l2Key2 = l2Key2;
        this.confidence = confidence;
    }

    public SameL3NetworkResponse(SameL3NetworkResponseParcelable parceled) {
        this(parceled.l2Key1, parceled.l2Key2, parceled.confidence);
    }

    public SameL3NetworkResponseParcelable toParcelable() {
        SameL3NetworkResponseParcelable parcelable = new SameL3NetworkResponseParcelable();
        parcelable.l2Key1 = this.l2Key1;
        parcelable.l2Key2 = this.l2Key2;
        parcelable.confidence = this.confidence;
        return parcelable;
    }

    public boolean equals(Object o) {
        if ((o instanceof SameL3NetworkResponse) == true) goto L5;
        return false;
    L5:
        SameL3NetworkResponse other = (SameL3NetworkResponse) o;
        if (this.l2Key1.equals(other.l2Key1) == true) goto L8;
        return false;
    L8:
        if (this.l2Key2.equals(other.l2Key2) == true) goto L10;
        return false;
    L10:
        if (this.confidence != other.confidence) goto L15;
        return true;
    L15:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.l2Key1, this.l2Key2, Float.valueOf(this.confidence)});
    }

    public String toString() {
        switch(getNetworkSameness()) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return "Buggy sameness value ? \"" + this.l2Key1 + "\", \"" + this.l2Key2 + "\"";
    L7:
        return "\"" + this.l2Key1 + "\" can't be tested against \"" + this.l2Key2 + "\"";
    L9:
        return "\"" + this.l2Key1 + "\" different L3 network from \"" + this.l2Key2 + "\"";
    L11:
        return "\"" + this.l2Key1 + "\" same L3 network as \"" + this.l2Key2 + "\"";
    }
}
