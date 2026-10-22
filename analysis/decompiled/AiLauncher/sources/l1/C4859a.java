package l1;

import La.H;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import i1.InterfaceC4161c;
import j1.InterfaceC4757d;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0012\u001a\u00020\r8WX\u0096\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Ll1/a;", "Li1/c;", "Lj1/d;", "openHelper", "<init>", "(Lj1/d;)V", "", "fileName", "Landroidx/sqlite/driver/a;", "c", "(Ljava/lang/String;)Landroidx/sqlite/driver/a;", Const.INTENT_KEY_APIKEY, "Lj1/d;", "", Const.INTENT_KEY_PKGNAME, "()Z", "hasConnectionPool$annotations", "()V", "hasConnectionPool", "sqlite-framework"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: l1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4859a implements InterfaceC4161c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC4757d openHelper;

    public C4859a(InterfaceC4757d openHelper) {
        p.i(openHelper, "openHelper");
        this.openHelper = openHelper;
    }

    @Override // i1.InterfaceC4161c
    public boolean b() {
        return true;
    }

    @Override // i1.InterfaceC4161c
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public androidx.sqlite.driver.a a(String fileName) {
        p.i(fileName, "fileName");
        String name = this.openHelper.getName();
        if (name == null) {
            if (!p.d(fileName, ":memory:")) {
                throw new IllegalArgumentException(("This driver is configured to open an in-memory database but a file-based named '" + fileName + "' was requested.").toString());
            }
        } else if (!p.d(name, fileName) && !p.d(H.s1(name, JsonPointer.SEPARATOR, null, 2, null), H.s1(fileName, JsonPointer.SEPARATOR, null, 2, null))) {
            throw new IllegalArgumentException(("This driver is configured to open a database named '" + this.openHelper.getName() + "' but '" + fileName + "' was requested.").toString());
        }
        return new androidx.sqlite.driver.a(this.openHelper.getWritableDatabase());
    }
}
