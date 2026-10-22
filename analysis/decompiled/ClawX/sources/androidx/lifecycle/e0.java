package androidx.lifecycle;

import com.stepos.stepclaw.SecurePrefs;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e0 extends kotlin.jvm.internal.q implements p5.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f706b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f707c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e0(int i8, Object obj) {
        super(0);
        this.f706b = i8;
        this.f707c = obj;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f706b) {
            case 0:
                i0 i0Var = (i0) this.f707c;
                ArrayList arrayList = new ArrayList();
                Class clsA = kotlin.jvm.internal.z.a(g0.class).a();
                kotlin.jvm.internal.p.c(clsA, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
                arrayList.add(new s0.b(clsA));
                s0.b[] bVarArr = (s0.b[]) arrayList.toArray(new s0.b[0]);
                s0.b[] initializers = (s0.b[]) Arrays.copyOf(bVarArr, bVarArr.length);
                kotlin.jvm.internal.p.e(initializers, "initializers");
                d0 store = i0Var.c();
                if (i0Var instanceof h) {
                    ((h) i0Var).b();
                    throw null;
                }
                s0.a defaultCreationExtras = s0.a.f5230b;
                kotlin.jvm.internal.p.e(store, "store");
                store.getClass();
                kotlin.jvm.internal.p.e(defaultCreationExtras, "defaultCreationExtras");
                throw null;
            case 1:
                Object obj = j0.g0.d;
                File file = (File) this.f707c;
                synchronized (obj) {
                    j0.g0.f3346c.remove(file.getAbsolutePath());
                }
                return b5.a0.f883a;
            default:
                File file2 = (File) ((l0.b) this.f707c).invoke();
                String name = file2.getName();
                kotlin.jvm.internal.p.d(name, "getName(...)");
                if (x5.n.M1(name, '.', SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID).equals("preferences_pb")) {
                    File absoluteFile = file2.getAbsoluteFile();
                    kotlin.jvm.internal.p.d(absoluteFile, "file.absoluteFile");
                    return absoluteFile;
                }
                throw new IllegalStateException(("File extension for file: " + file2 + " does not match required extension for Preferences file: preferences_pb").toString());
        }
    }
}
