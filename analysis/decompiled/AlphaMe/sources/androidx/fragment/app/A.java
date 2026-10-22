package androidx.fragment.app;

import android.os.Parcel;

/* loaded from: classes.dex */
public class A extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3568a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(int i4, Throwable th) {
        super(th);
        this.f3568a = i4;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        switch (this.f3568a) {
            case 11:
                return "Chain of Causes for CompositeException In Order Received =>";
            default:
                return super.getMessage();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(String str, int i4) {
        super(str);
        this.f3568a = i4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ A(String str, int i4, Throwable th) {
        super(str, th);
        this.f3568a = i4;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        this.f3568a = 2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A(String str, Throwable th) {
        super(str, th);
        this.f3568a = 12;
    }

    public A() {
        this.f3568a = 11;
    }
}
