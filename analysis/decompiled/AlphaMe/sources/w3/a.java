package w3;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public final class a extends B0.f {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f15861b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f15862c;

    public /* synthetic */ a(int i4, Object obj) {
        this.f15861b = i4;
        this.f15862c = obj;
    }

    public final Object I0() {
        int i4 = this.f15861b;
        Object obj = this.f15862c;
        switch (i4) {
            case 0:
                return (PrintStream) obj;
            default:
                return (PrintWriter) obj;
        }
    }

    public final void J0(String str) {
        int i4 = this.f15861b;
        Object obj = this.f15862c;
        switch (i4) {
            case 0:
                ((PrintStream) obj).println((Object) str);
                break;
            default:
                ((PrintWriter) obj).println((Object) str);
                break;
        }
    }
}
