package androidx.media;

import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import q0.InterfaceC0824c;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements InterfaceC0824c {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3990b = 0;

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f3991a;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface AttributeContentType {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({EnumC0546d.f12493b})
    public @interface AttributeUsage {
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f3991a;
        return audioAttributesImpl == null ? audioAttributesCompat.f3991a == null : audioAttributesImpl.equals(audioAttributesCompat.f3991a);
    }

    public final int hashCode() {
        return this.f3991a.hashCode();
    }

    public final String toString() {
        return this.f3991a.toString();
    }
}
