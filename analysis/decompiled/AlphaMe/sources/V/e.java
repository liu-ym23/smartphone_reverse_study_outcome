package V;

import java.io.File;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
public final class e extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1921a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0 f1922b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Function0 function0, int i4) {
        super(0);
        this.f1921a = i4;
        this.f1922b = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i4 = this.f1921a;
        Function0 function0 = this.f1922b;
        switch (i4) {
            case 0:
                File file = (File) function0.invoke();
                if (Intrinsics.areEqual(FilesKt.getExtension(file), "preferences_pb")) {
                    return file;
                }
                throw new IllegalStateException(("File extension for file: " + file + " does not match required extension for Preferences file: preferences_pb").toString());
            default:
                try {
                    return (List) function0.invoke();
                } catch (SSLPeerUnverifiedException unused) {
                    return CollectionsKt.emptyList();
                }
        }
    }
}
