package androidx.room;

import android.content.Context;
import androidx.work.CoroutineWorker;
import com.stepos.agentsafetycenter.sync.PendingSyncWorker;
import g9.j1;
import g9.p0;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1517c;

    /* renamed from: f, reason: collision with root package name */
    public int f1518f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f1519g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, nb.c cVar, int i) {
        super(2, cVar);
        this.f1517c = i;
        this.f1519g = obj;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f1517c) {
            case 0:
                return new e((f) this.f1519g, cVar, 0);
            case 1:
                return new e((n0) this.f1519g, cVar, 1);
            case 2:
                return new e((CoroutineWorker) this.f1519g, cVar, 2);
            case 3:
                return new e((j1) this.f1519g, cVar, 3);
            case 4:
                return new e((Context) this.f1519g, cVar, 4);
            case 5:
                return new e((PendingSyncWorker) this.f1519g, cVar, 5);
            case 6:
                return new e((nc.n) this.f1519g, cVar, 6);
            case 7:
                return new e((o1.i0) this.f1519g, cVar, 7);
            case 8:
                return new e((kc.l) this.f1519g, cVar, 8);
            case 9:
                return new e((p0) this.f1519g, cVar, 9);
            case 10:
                return new e((c1) this.f1519g, cVar, 10);
            case 11:
                return new e((t.w) this.f1519g, cVar, 11);
            case 12:
                return new e((t.c0) this.f1519g, cVar, 12);
            default:
                return new e((u5.l) this.f1519g, cVar, 13);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        kc.t tVar = (kc.t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f1517c) {
            case 3:
                ((e) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
                break;
            case 10:
                ((e) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
                break;
        }
        return ((e) create(tVar, cVar)).invokeSuspend(jb.v.f6774a);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ff  */
    /* JADX WARN: Type inference failed for: r14v22, types: [pb.i, xb.p] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00fd -> B:48:0x0101). Please report as a decompilation issue!!! */
    @Override // pb.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
