package androidx.camera.core.impl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class Identifier {
    public Identifier() {
    }

    public abstract Object getValue();

    public static Identifier create(Object r100) {
        return new AutoValue_Identifier(r100);
    }
}
