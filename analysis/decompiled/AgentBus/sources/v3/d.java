package v3;

import androidx.datastore.preferences.protobuf.j;

/* loaded from: classes.dex */
public final class d extends j1.c {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10389c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i2, byte[] bArr) {
        super(bArr);
        this.f10389c = i2;
    }

    @Override // j1.c
    public final j g(int i2, byte[] bArr) {
        switch (this.f10389c) {
            case 0:
                return new c(bArr, i2, 0);
            default:
                return new c(bArr, i2, 1);
        }
    }
}
