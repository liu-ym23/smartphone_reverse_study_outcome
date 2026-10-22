package rb;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import qb.AbstractC5171a;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0011¨\u0006\u0013"}, d2 = {"Lrb/m;", "Lrb/j;", "Lrb/q;", "writer", "Lqb/a;", "json", "<init>", "(Lrb/q;Lqb/a;)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "q", "c", Const.INTENT_KEY_UMID, "p", "Lqb/a;", "", "I", "level", "kotlinx-serialization-json"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: rb.m, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C5263m extends C5260j {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final AbstractC5171a json;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int level;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5263m(InterfaceC5267q writer, AbstractC5171a json) {
        super(writer);
        kotlin.jvm.internal.p.i(writer, "writer");
        kotlin.jvm.internal.p.i(json, "json");
        this.json = json;
    }

    @Override // rb.C5260j
    public void b() {
        o(true);
        this.level++;
    }

    @Override // rb.C5260j
    public void c() {
        o(false);
        k("\n");
        int i10 = this.level;
        for (int i11 = 0; i11 < i10; i11++) {
            k(this.json.getConfiguration().getPrettyPrintIndent());
        }
    }

    @Override // rb.C5260j
    public void d() {
        if (getWritingFirst()) {
            o(false);
        } else {
            c();
        }
    }

    @Override // rb.C5260j
    public void p() {
        f(' ');
    }

    @Override // rb.C5260j
    public void q() {
        this.level--;
    }
}
