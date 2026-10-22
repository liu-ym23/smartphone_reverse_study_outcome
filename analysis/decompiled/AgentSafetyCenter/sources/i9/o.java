package i9;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5887a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mc.i f5888b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(Handler handler, mc.r rVar) {
        super(handler);
        this.f5888b = rVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        switch (this.f5887a) {
            case 0:
                ((mc.r) this.f5888b).h(jb.v.f6774a);
                break;
            default:
                super.onChange(z10);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(mc.e eVar, Handler handler) {
        super(handler);
        this.f5888b = eVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10, Uri uri) {
        switch (this.f5887a) {
            case 1:
                ((mc.e) this.f5888b).h(jb.v.f6774a);
                break;
            default:
                super.onChange(z10, uri);
                break;
        }
    }
}
