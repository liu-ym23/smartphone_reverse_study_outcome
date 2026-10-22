package kotlin.reflect.jvm.internal.impl.descriptors;

/* JADX INFO: loaded from: classes4.dex */
public interface SourceElement {
    public static final SourceElement NO_SOURCE = null;

    SourceFile getContainingFile();

    static {
        NO_SOURCE = new AnonymousClass1();
    }
}
