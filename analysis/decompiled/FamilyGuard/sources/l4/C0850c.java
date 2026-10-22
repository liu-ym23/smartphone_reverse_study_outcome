package l4;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: l4.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0850c extends C0849b {
    public static int a(float f5) {
        if (Float.isNaN(f5)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        }
        return Math.round(f5);
    }
}
