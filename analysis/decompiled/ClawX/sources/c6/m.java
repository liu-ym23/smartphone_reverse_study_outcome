package c6;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m extends IllegalStateException {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1143a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(String str, int i8) {
        super(str);
        this.f1143a = i8;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        switch (this.f1143a) {
            case 4:
                return null;
            default:
                return super.getCause();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(String str, boolean z) {
        super(str);
        this.f1143a = 3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String message) {
        super(message);
        this.f1143a = 3;
        kotlin.jvm.internal.p.e(message, "message");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(String taskName, int i8, Throwable th) {
        super("Concurrent " + taskName + " attempts", th);
        this.f1143a = i8;
        switch (i8) {
            case 2:
                super(taskName, th);
                break;
            default:
                kotlin.jvm.internal.p.e(taskName, "taskName");
                break;
        }
    }
}
