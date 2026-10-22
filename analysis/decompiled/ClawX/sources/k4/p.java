package k4;

import d8.x0;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class p extends f2.d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3634b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(int i8) {
        super(1);
        this.f3634b = i8;
    }

    @Override // f2.d
    public void l(String name) {
        switch (this.f3634b) {
            case 0:
                kotlin.jvm.internal.p.e(name, "name");
                List list = t.f3636a;
                int i8 = 0;
                int i9 = 0;
                while (i8 < name.length()) {
                    char cCharAt = name.charAt(i8);
                    int i10 = i9 + 1;
                    if (kotlin.jvm.internal.p.g(cCharAt, 32) <= 0 || x5.n.h1("\"(),/:;<=>?@[\\]{}", cCharAt)) {
                        throw new x0("Header name '" + name + "' contains illegal character '" + name.charAt(i9) + "' (code " + (name.charAt(i9) & 255) + ')');
                    }
                    i8++;
                    i9 = i10;
                }
                return;
            default:
                super.l(name);
                return;
        }
    }

    @Override // f2.d
    public void m(String value) {
        switch (this.f3634b) {
            case 0:
                kotlin.jvm.internal.p.e(value, "value");
                List list = t.f3636a;
                int i8 = 0;
                int i9 = 0;
                while (i8 < value.length()) {
                    char cCharAt = value.charAt(i8);
                    int i10 = i9 + 1;
                    if (kotlin.jvm.internal.p.g(cCharAt, 32) < 0 && cCharAt != '\t') {
                        throw new x0("Header value '" + value + "' contains illegal character '" + value.charAt(i9) + "' (code " + (value.charAt(i9) & 255) + ')');
                    }
                    i8++;
                    i9 = i10;
                }
                return;
            default:
                super.m(value);
                return;
        }
    }

    public q n() {
        Map values = (Map) this.f2554a;
        kotlin.jvm.internal.p.e(values, "values");
        return new q(values);
    }
}
