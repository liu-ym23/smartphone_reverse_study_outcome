package b4;

import com.bytedance.retrofit2.mime.TypedInput;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes43.dex */
public final class d extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map<String, String> f17435a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f17436b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<TypedInput> f17437c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<String> f17438d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Throwable> f17439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f17440f;

    @Override // b4.m
    public final int a() {
        return this.f17440f.element;
    }

    @Override // b4.m
    public final String b() {
        return this.f17438d.element;
    }

    @Override // b4.m
    public final Throwable c() {
        return this.f17439e.element;
    }

    @Override // b4.m
    public final TypedInput d() {
        return this.f17437c.element;
    }

    @Override // b4.m
    public final Integer e() {
        return Integer.valueOf(this.f17436b.element);
    }

    @Override // b4.m
    public final Map<String, String> f() {
        return this.f17435a;
    }

    public d(Map<String, String> r100, Ref.IntRef r101, Ref.ObjectRef<TypedInput> r102, Ref.ObjectRef<String> r103, Ref.ObjectRef<Throwable> r104, Ref.IntRef r105) {
        this.f17435a = r100;
        this.f17436b = r101;
        this.f17437c = r102;
        this.f17438d = r103;
        this.f17439e = r104;
        this.f17440f = r105;
    }
}
