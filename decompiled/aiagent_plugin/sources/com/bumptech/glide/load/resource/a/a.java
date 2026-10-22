package com.bumptech.glide.load.resource.a;

import com.bumptech.glide.load.a.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f3774a;

    /* JADX INFO: renamed from: com.bumptech.glide.load.resource.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferRewinder.java */
    public static class C0096a implements e.a<ByteBuffer> {
        public C0096a() {
        }

        @Override // com.bumptech.glide.load.a.e.a
        public /* synthetic */ e<ByteBuffer> a(ByteBuffer r3) {
            return a2((ByteBuffer) ZeusTransformUtils.preCheckCast(r3, ByteBuffer.class, "com.obric.aiagent.plugin"));
        }

        /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
        public e<ByteBuffer> a2(ByteBuffer r1) {
            return new a(r1);
        }

        @Override // com.bumptech.glide.load.a.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    @Override // com.bumptech.glide.load.a.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.a.e
    public /* synthetic */ ByteBuffer a() {
        return c();
    }

    public a(ByteBuffer r1) {
        this.f3774a = r1;
    }

    public ByteBuffer c() {
        this.f3774a.position(0);
        return this.f3774a;
    }
}
