package a8;

import java.lang.invoke.VarHandle;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Stream;
import p5.i;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Function {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f235a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ i f236b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Locale f237c;

    public /* synthetic */ d(int i) {
        this.f235a = i;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        int i = 1;
        switch (this.f235a) {
            case 0:
                i iVar = this.f236b;
                Locale locale = this.f237c;
                Stream stream = ((List) iVar.f9733h).stream();
                d dVar = new d(i);
                dVar.f236b = iVar;
                dVar.f237c = locale;
                VarHandle.storeStoreFence();
                Stream streamFilter = stream.map(dVar).filter(new e(0));
                f fVar = new f(0);
                fVar.f240b = (String) obj;
                VarHandle.storeStoreFence();
                return (String) streamFilter.map(fVar).filter(new e(1)).findFirst().orElse("");
            default:
                i iVar2 = this.f236b;
                Locale locale2 = this.f237c;
                String str = (String) obj;
                Map map = (Map) ((ConcurrentHashMap) iVar2.f9730c).computeIfAbsent(str, new b(2));
                f fVar2 = new f(1);
                fVar2.f240b = str;
                VarHandle.storeStoreFence();
                return (ResourceBundle) map.computeIfAbsent(locale2, fVar2);
        }
    }
}
