package b76;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends com.bytedance.ies.xbridge.model.params.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f17957d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f17958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f17959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f17960c;

    /* JADX INFO: renamed from: b76.a$a, reason: collision with other inner class name */
    public static final class C0275a {
    }

    static {
    }

    public final String a() {
        String r100 = this.f17958a;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("message");
        return null;
    }

    public final String getType() {
        String r100 = this.f17959b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("type");
        return null;
    }

    @Override // com.bytedance.ies.xbridge.model.params.a
    public final List<String> provideParamList() {
        return CollectionsKt.listOf(new String[]{"message", "type", "duration"});
    }

    public a() {
    }
}
