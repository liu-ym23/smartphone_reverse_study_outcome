package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import K9.v;
import java.lang.reflect.Field;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

/* loaded from: classes5.dex */
public final /* synthetic */ class ReflectJavaClass$fields$2 extends FunctionReferenceImpl implements InterfaceC5074l<Field, v> {

    /* renamed from: a, reason: collision with root package name */
    public static final ReflectJavaClass$fields$2 f35015a = new ReflectJavaClass$fields$2();

    public ReflectJavaClass$fields$2() {
        super(1, v.class, "<init>", "<init>(Ljava/lang/reflect/Field;)V", 0);
    }

    @Override // p9.InterfaceC5074l
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final v invoke(Field p02) {
        p.i(p02, "p0");
        return new v(p02);
    }
}
