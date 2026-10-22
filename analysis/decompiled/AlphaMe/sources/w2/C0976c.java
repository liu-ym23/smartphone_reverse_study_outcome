package w2;

import android.opengl.GLES20;
import android.opengl.GLES30;
import f1.AbstractC0557a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import u2.AbstractC0940b;
import x2.e;

/* renamed from: w2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0976c implements InterfaceC0977d {

    /* renamed from: j, reason: collision with root package name */
    public static final IntBuffer f15851j = AbstractC0557a.N();

    /* renamed from: a, reason: collision with root package name */
    public final e f15852a;

    /* renamed from: b, reason: collision with root package name */
    public final FloatBuffer f15853b;

    /* renamed from: c, reason: collision with root package name */
    public final ByteBuffer f15854c;

    /* renamed from: d, reason: collision with root package name */
    public int f15855d;

    /* renamed from: e, reason: collision with root package name */
    public final int f15856e;

    /* renamed from: h, reason: collision with root package name */
    public int f15859h;

    /* renamed from: f, reason: collision with root package name */
    public boolean f15857f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f15858g = false;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f15860i = new ArrayList();

    public C0976c(e eVar) {
        this.f15859h = -1;
        this.f15852a = eVar;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(eVar.f15931b * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        this.f15854c = byteBufferAllocateDirect;
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        this.f15853b = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.flip();
        byteBufferAllocateDirect.flip();
        int i4 = AbstractC0940b.f15490a;
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        this.f15855d = iArr[0];
        this.f15856e = 35044;
        IntBuffer intBuffer = f15851j;
        intBuffer.clear();
        GLES30.glGenVertexArrays(1, intBuffer);
        this.f15859h = intBuffer.get(0);
    }

    @Override // z2.InterfaceC1006a
    public final void dispose() {
        GLES20.glBindBuffer(34962, 0);
        int i4 = this.f15855d;
        int i5 = AbstractC0940b.f15490a;
        GLES20.glDeleteBuffers(1, new int[]{i4}, 0);
        this.f15855d = 0;
        if (this.f15859h != -1) {
            IntBuffer intBuffer = f15851j;
            intBuffer.clear();
            intBuffer.put(this.f15859h);
            intBuffer.flip();
            GLES30.glDeleteVertexArrays(1, intBuffer);
            this.f15859h = -1;
        }
    }
}
