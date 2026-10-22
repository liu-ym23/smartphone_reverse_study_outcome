package j7;

import N9.j;
import android.content.pm.Signature;
import java.util.Comparator;

/* renamed from: j7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1600b implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return j.m(Integer.valueOf(((Signature) obj).hashCode()), Integer.valueOf(((Signature) obj2).hashCode()));
    }
}
