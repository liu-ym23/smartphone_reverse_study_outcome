package H0;

import A0.d;
import H0.n;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import z0.C1342h;
import z0.EnumC1335a;

/* loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {

    private static final class a implements A0.d<ByteBuffer> {

        /* renamed from: a, reason: collision with root package name */
        private final File f1963a;

        a(File file) {
            this.f1963a = file;
        }

        @Override // A0.d
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // A0.d
        public void b() {
        }

        @Override // A0.d
        public void cancel() {
        }

        @Override // A0.d
        public EnumC1335a d() {
            return EnumC1335a.LOCAL;
        }

        @Override // A0.d
        public void e(v0.g gVar, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.f(X0.a.a(this.f1963a));
            } catch (IOException e6) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e6);
                }
                aVar.c(e6);
            }
        }
    }

    public static class b implements o<File, ByteBuffer> {
        @Override // H0.o
        public n<File, ByteBuffer> a(r rVar) {
            return new d();
        }

        @Override // H0.o
        public void b() {
        }
    }

    @Override // H0.n
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<ByteBuffer> b(File file, int i5, int i6, C1342h c1342h) {
        return new n.a<>(new W0.b(file), new a(file));
    }

    @Override // H0.n
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }
}
