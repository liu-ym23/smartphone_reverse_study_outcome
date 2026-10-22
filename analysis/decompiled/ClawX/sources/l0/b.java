package l0;

import android.content.Context;
import java.io.File;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.q;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class b extends q implements p5.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f3727b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c f3728c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, c cVar) {
        super(0);
        this.f3727b = context;
        this.f3728c = cVar;
    }

    @Override // p5.a
    public final Object invoke() {
        this.f3728c.getClass();
        String fileName = "openclaw_config".concat(".preferences_pb");
        p.e(fileName, "fileName");
        return new File(this.f3727b.getApplicationContext().getFilesDir(), "datastore/".concat(fileName));
    }
}
