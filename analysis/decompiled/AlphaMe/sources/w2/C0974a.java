package w2;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import u2.AbstractC0940b;
import z2.InterfaceC1006a;

/* renamed from: w2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0974a implements InterfaceC1006a {

    /* renamed from: a, reason: collision with root package name */
    public final ShortBuffer f15829a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteBuffer f15830b;

    /* renamed from: c, reason: collision with root package name */
    public int f15831c;

    /* renamed from: f, reason: collision with root package name */
    public final int f15834f;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15832d = true;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15833e = false;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f15835g = false;

    public C0974a() {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(12);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        this.f15830b = byteBufferAllocateDirect;
        ShortBuffer shortBufferAsShortBuffer = byteBufferAllocateDirect.asShortBuffer();
        this.f15829a = shortBufferAsShortBuffer;
        shortBufferAsShortBuffer.flip();
        byteBufferAllocateDirect.flip();
        int i4 = AbstractC0940b.f15490a;
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        this.f15831c = iArr[0];
        this.f15834f = 35044;
    }

    public final int a() {
        if (this.f15835g) {
            return 0;
        }
        return this.f15829a.limit();
    }

    @Override // z2.InterfaceC1006a
    public final void dispose() {
        GLES20.glBindBuffer(34963, 0);
        int i4 = this.f15831c;
        int i5 = AbstractC0940b.f15490a;
        GLES20.glDeleteBuffers(1, new int[]{i4}, 0);
        this.f15831c = 0;
    }
}
